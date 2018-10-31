import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { DepSdmSuffix } from './dep-sdm-suffix.model';
import { DepSdmSuffixPopupService } from './dep-sdm-suffix-popup.service';
import { DepSdmSuffixService } from './dep-sdm-suffix.service';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-dep-sdm-suffix-dialog',
    templateUrl: './dep-sdm-suffix-dialog.component.html'
})
export class DepSdmSuffixDialogComponent implements OnInit {

    dep: DepSdmSuffix;
    isSaving: boolean;

    deps: DepSdmSuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private depService: DepSdmSuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.depService.query()
            .subscribe((res: ResponseWrapper) => { this.deps = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.dep.id !== undefined) {
            this.subscribeToSaveResponse(
                this.depService.update(this.dep));
        } else {
            this.subscribeToSaveResponse(
                this.depService.create(this.dep));
        }
    }

    private subscribeToSaveResponse(result: Observable<DepSdmSuffix>) {
        result.subscribe((res: DepSdmSuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: DepSdmSuffix) {
        this.eventManager.broadcast({ name: 'depListModification', content: 'OK'});
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

    trackDepById(index: number, item: DepSdmSuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-dep-sdm-suffix-popup',
    template: ''
})
export class DepSdmSuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private depPopupService: DepSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.depPopupService
                    .open(DepSdmSuffixDialogComponent as Component, params['id']);
            } else {
                this.depPopupService
                    .open(DepSdmSuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
