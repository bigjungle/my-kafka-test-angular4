import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { AuthorSdmSuffix } from './author-sdm-suffix.model';
import { AuthorSdmSuffixPopupService } from './author-sdm-suffix-popup.service';
import { AuthorSdmSuffixService } from './author-sdm-suffix.service';

@Component({
    selector: 'jhi-author-sdm-suffix-dialog',
    templateUrl: './author-sdm-suffix-dialog.component.html'
})
export class AuthorSdmSuffixDialogComponent implements OnInit {

    author: AuthorSdmSuffix;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private authorService: AuthorSdmSuffixService,
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
        if (this.author.id !== undefined) {
            this.subscribeToSaveResponse(
                this.authorService.update(this.author));
        } else {
            this.subscribeToSaveResponse(
                this.authorService.create(this.author));
        }
    }

    private subscribeToSaveResponse(result: Observable<AuthorSdmSuffix>) {
        result.subscribe((res: AuthorSdmSuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: AuthorSdmSuffix) {
        this.eventManager.broadcast({ name: 'authorListModification', content: 'OK'});
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
    selector: 'jhi-author-sdm-suffix-popup',
    template: ''
})
export class AuthorSdmSuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private authorPopupService: AuthorSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.authorPopupService
                    .open(AuthorSdmSuffixDialogComponent as Component, params['id']);
            } else {
                this.authorPopupService
                    .open(AuthorSdmSuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
