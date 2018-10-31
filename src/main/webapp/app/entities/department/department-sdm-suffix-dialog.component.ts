import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { DepartmentSdmSuffix } from './department-sdm-suffix.model';
import { DepartmentSdmSuffixPopupService } from './department-sdm-suffix-popup.service';
import { DepartmentSdmSuffixService } from './department-sdm-suffix.service';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-department-sdm-suffix-dialog',
    templateUrl: './department-sdm-suffix-dialog.component.html'
})
export class DepartmentSdmSuffixDialogComponent implements OnInit {

    department: DepartmentSdmSuffix;
    isSaving: boolean;

    departments: DepartmentSdmSuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private departmentService: DepartmentSdmSuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.departmentService.query()
            .subscribe((res: ResponseWrapper) => { this.departments = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.department.id !== undefined) {
            this.subscribeToSaveResponse(
                this.departmentService.update(this.department));
        } else {
            this.subscribeToSaveResponse(
                this.departmentService.create(this.department));
        }
    }

    private subscribeToSaveResponse(result: Observable<DepartmentSdmSuffix>) {
        result.subscribe((res: DepartmentSdmSuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: DepartmentSdmSuffix) {
        this.eventManager.broadcast({ name: 'departmentListModification', content: 'OK'});
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

    trackDepartmentById(index: number, item: DepartmentSdmSuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-department-sdm-suffix-popup',
    template: ''
})
export class DepartmentSdmSuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private departmentPopupService: DepartmentSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.departmentPopupService
                    .open(DepartmentSdmSuffixDialogComponent as Component, params['id']);
            } else {
                this.departmentPopupService
                    .open(DepartmentSdmSuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
