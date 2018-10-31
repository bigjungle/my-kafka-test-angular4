import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ARightPersonMySuffix } from './a-right-person-my-suffix.model';
import { ARightPersonMySuffixPopupService } from './a-right-person-my-suffix-popup.service';
import { ARightPersonMySuffixService } from './a-right-person-my-suffix.service';

@Component({
    selector: 'jhi-a-right-person-my-suffix-dialog',
    templateUrl: './a-right-person-my-suffix-dialog.component.html'
})
export class ARightPersonMySuffixDialogComponent implements OnInit {

    aRightPerson: ARightPersonMySuffix;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private aRightPersonService: ARightPersonMySuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.aRightPerson.id !== undefined) {
            this.subscribeToSaveResponse(
                this.aRightPersonService.update(this.aRightPerson));
        } else {
            this.subscribeToSaveResponse(
                this.aRightPersonService.create(this.aRightPerson));
        }
    }

    private subscribeToSaveResponse(result: Observable<ARightPersonMySuffix>) {
        result.subscribe((res: ARightPersonMySuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: ARightPersonMySuffix) {
        this.eventManager.broadcast({ name: 'aRightPersonListModification', content: 'OK'});
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
}

@Component({
    selector: 'jhi-a-right-person-my-suffix-popup',
    template: ''
})
export class ARightPersonMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private aRightPersonPopupService: ARightPersonMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.aRightPersonPopupService
                    .open(ARightPersonMySuffixDialogComponent as Component, params['id']);
            } else {
                this.aRightPersonPopupService
                    .open(ARightPersonMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
