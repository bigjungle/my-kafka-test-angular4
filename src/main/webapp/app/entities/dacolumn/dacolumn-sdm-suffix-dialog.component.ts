import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { DacolumnSdmSuffix } from './dacolumn-sdm-suffix.model';
import { DacolumnSdmSuffixPopupService } from './dacolumn-sdm-suffix-popup.service';
import { DacolumnSdmSuffixService } from './dacolumn-sdm-suffix.service';
import { DatableSdmSuffix, DatableSdmSuffixService } from '../datable';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-dacolumn-sdm-suffix-dialog',
    templateUrl: './dacolumn-sdm-suffix-dialog.component.html'
})
export class DacolumnSdmSuffixDialogComponent implements OnInit {

    dacolumn: DacolumnSdmSuffix;
    isSaving: boolean;

    datables: DatableSdmSuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private dacolumnService: DacolumnSdmSuffixService,
        private datableService: DatableSdmSuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.datableService.query()
            .subscribe((res: ResponseWrapper) => { this.datables = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.dacolumn.id !== undefined) {
            this.subscribeToSaveResponse(
                this.dacolumnService.update(this.dacolumn));
        } else {
            this.subscribeToSaveResponse(
                this.dacolumnService.create(this.dacolumn));
        }
    }

    private subscribeToSaveResponse(result: Observable<DacolumnSdmSuffix>) {
        result.subscribe((res: DacolumnSdmSuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: DacolumnSdmSuffix) {
        this.eventManager.broadcast({ name: 'dacolumnListModification', content: 'OK'});
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

    trackDatableById(index: number, item: DatableSdmSuffix) {
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
    selector: 'jhi-dacolumn-sdm-suffix-popup',
    template: ''
})
export class DacolumnSdmSuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private dacolumnPopupService: DacolumnSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.dacolumnPopupService
                    .open(DacolumnSdmSuffixDialogComponent as Component, params['id']);
            } else {
                this.dacolumnPopupService
                    .open(DacolumnSdmSuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
