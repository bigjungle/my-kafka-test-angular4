import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ARightUserMySuffix } from './a-right-user-my-suffix.model';
import { ARightUserMySuffixPopupService } from './a-right-user-my-suffix-popup.service';
import { ARightUserMySuffixService } from './a-right-user-my-suffix.service';

@Component({
    selector: 'jhi-a-right-user-my-suffix-dialog',
    templateUrl: './a-right-user-my-suffix-dialog.component.html'
})
export class ARightUserMySuffixDialogComponent implements OnInit {

    aRightUser: ARightUserMySuffix;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private aRightUserService: ARightUserMySuffixService,
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
        if (this.aRightUser.id !== undefined) {
            this.subscribeToSaveResponse(
                this.aRightUserService.update(this.aRightUser));
        } else {
            this.subscribeToSaveResponse(
                this.aRightUserService.create(this.aRightUser));
        }
    }

    private subscribeToSaveResponse(result: Observable<ARightUserMySuffix>) {
        result.subscribe((res: ARightUserMySuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: ARightUserMySuffix) {
        this.eventManager.broadcast({ name: 'aRightUserListModification', content: 'OK'});
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
    selector: 'jhi-a-right-user-my-suffix-popup',
    template: ''
})
export class ARightUserMySuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private aRightUserPopupService: ARightUserMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.aRightUserPopupService
                    .open(ARightUserMySuffixDialogComponent as Component, params['id']);
            } else {
                this.aRightUserPopupService
                    .open(ARightUserMySuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
