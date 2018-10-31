import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { SysDirSdmSuffix } from './sys-dir-sdm-suffix.model';
import { SysDirSdmSuffixPopupService } from './sys-dir-sdm-suffix-popup.service';
import { SysDirSdmSuffixService } from './sys-dir-sdm-suffix.service';
import { DepartmentSdmSuffix, DepartmentSdmSuffixService } from '../department';
import { PersonSdmSuffix, PersonSdmSuffixService } from '../person';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-sys-dir-sdm-suffix-dialog',
    templateUrl: './sys-dir-sdm-suffix-dialog.component.html'
})
export class SysDirSdmSuffixDialogComponent implements OnInit {

    sysDir: SysDirSdmSuffix;
    isSaving: boolean;

    sysdirs: SysDirSdmSuffix[];

    departments: DepartmentSdmSuffix[];

    people: PersonSdmSuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private sysDirService: SysDirSdmSuffixService,
        private departmentService: DepartmentSdmSuffixService,
        private personService: PersonSdmSuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.sysDirService.query()
            .subscribe((res: ResponseWrapper) => { this.sysdirs = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.departmentService.query()
            .subscribe((res: ResponseWrapper) => { this.departments = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
        this.personService.query()
            .subscribe((res: ResponseWrapper) => { this.people = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.sysDir.id !== undefined) {
            this.subscribeToSaveResponse(
                this.sysDirService.update(this.sysDir));
        } else {
            this.subscribeToSaveResponse(
                this.sysDirService.create(this.sysDir));
        }
    }

    private subscribeToSaveResponse(result: Observable<SysDirSdmSuffix>) {
        result.subscribe((res: SysDirSdmSuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: SysDirSdmSuffix) {
        this.eventManager.broadcast({ name: 'sysDirListModification', content: 'OK'});
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

    trackSysDirById(index: number, item: SysDirSdmSuffix) {
        return item.id;
    }

    trackDepartmentById(index: number, item: DepartmentSdmSuffix) {
        return item.id;
    }

    trackPersonById(index: number, item: PersonSdmSuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-sys-dir-sdm-suffix-popup',
    template: ''
})
export class SysDirSdmSuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sysDirPopupService: SysDirSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.sysDirPopupService
                    .open(SysDirSdmSuffixDialogComponent as Component, params['id']);
            } else {
                this.sysDirPopupService
                    .open(SysDirSdmSuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
