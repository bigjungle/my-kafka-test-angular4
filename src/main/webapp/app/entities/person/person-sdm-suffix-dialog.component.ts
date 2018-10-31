import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { PersonSdmSuffix } from './person-sdm-suffix.model';
import { PersonSdmSuffixPopupService } from './person-sdm-suffix-popup.service';
import { PersonSdmSuffixService } from './person-sdm-suffix.service';
import { DepartmentSdmSuffix, DepartmentSdmSuffixService } from '../department';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-person-sdm-suffix-dialog',
    templateUrl: './person-sdm-suffix-dialog.component.html'
})
export class PersonSdmSuffixDialogComponent implements OnInit {

    person: PersonSdmSuffix;
    isSaving: boolean;

    departments: DepartmentSdmSuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private personService: PersonSdmSuffixService,
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
        if (this.person.id !== undefined) {
            this.subscribeToSaveResponse(
                this.personService.update(this.person));
        } else {
            this.subscribeToSaveResponse(
                this.personService.create(this.person));
        }
    }

    private subscribeToSaveResponse(result: Observable<PersonSdmSuffix>) {
        result.subscribe((res: PersonSdmSuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: PersonSdmSuffix) {
        this.eventManager.broadcast({ name: 'personListModification', content: 'OK'});
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
    selector: 'jhi-person-sdm-suffix-popup',
    template: ''
})
export class PersonSdmSuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private personPopupService: PersonSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.personPopupService
                    .open(PersonSdmSuffixDialogComponent as Component, params['id']);
            } else {
                this.personPopupService
                    .open(PersonSdmSuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
