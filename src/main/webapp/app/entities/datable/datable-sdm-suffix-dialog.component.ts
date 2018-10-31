import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { DatableSdmSuffix } from './datable-sdm-suffix.model';
import { DatableSdmSuffixPopupService } from './datable-sdm-suffix-popup.service';
import { DatableSdmSuffixService } from './datable-sdm-suffix.service';
import { DacolumnSdmSuffix, DacolumnSdmSuffixService } from '../dacolumn';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-datable-sdm-suffix-dialog',
    templateUrl: './datable-sdm-suffix-dialog.component.html'
})
export class DatableSdmSuffixDialogComponent implements OnInit {

    datable: DatableSdmSuffix;
    isSaving: boolean;

    dacolumns: DacolumnSdmSuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private datableService: DatableSdmSuffixService,
        private dacolumnService: DacolumnSdmSuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.dacolumnService.query()
            .subscribe((res: ResponseWrapper) => { this.dacolumns = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.datable.id !== undefined) {
            this.subscribeToSaveResponse(
                this.datableService.update(this.datable));
        } else {
            this.subscribeToSaveResponse(
                this.datableService.create(this.datable));
        }
    }

    private subscribeToSaveResponse(result: Observable<DatableSdmSuffix>) {
        result.subscribe((res: DatableSdmSuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: DatableSdmSuffix) {
        this.eventManager.broadcast({ name: 'datableListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError(error) {
        try {
            error.json();
        } catch (exception) {
            error.message = error.text();
        }
        this.isSaving = false;
        this.onError(error);
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }

    trackDacolumnById(index: number, item: DacolumnSdmSuffix) {
        return item.id;
    }

    getSelected(selectedVals: Array<any>, option: any) {
        if (selectedVals) {
            for (let i = 0; i < selectedVals.length; i++) {
                if (option.id === selectedVals[i].id) {
                    return selectedVals[i];
                }
            }
        }
        return option;
    }
}

@Component({
    selector: 'jhi-datable-sdm-suffix-popup',
    template: ''
})
export class DatableSdmSuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private datablePopupService: DatableSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.datablePopupService
                    .open(DatableSdmSuffixDialogComponent as Component, params['id']);
            } else {
                this.datablePopupService
                    .open(DatableSdmSuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
