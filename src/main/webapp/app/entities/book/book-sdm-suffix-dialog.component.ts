import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { BookSdmSuffix } from './book-sdm-suffix.model';
import { BookSdmSuffixPopupService } from './book-sdm-suffix-popup.service';
import { BookSdmSuffixService } from './book-sdm-suffix.service';
import { AuthorSdmSuffix, AuthorSdmSuffixService } from '../author';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-book-sdm-suffix-dialog',
    templateUrl: './book-sdm-suffix-dialog.component.html'
})
export class BookSdmSuffixDialogComponent implements OnInit {

    book: BookSdmSuffix;
    isSaving: boolean;

    authors: AuthorSdmSuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: JhiAlertService,
        private bookService: BookSdmSuffixService,
        private authorService: AuthorSdmSuffixService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorService.query()
            .subscribe((res: ResponseWrapper) => { this.authors = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.book.id !== undefined) {
            this.subscribeToSaveResponse(
                this.bookService.update(this.book));
        } else {
            this.subscribeToSaveResponse(
                this.bookService.create(this.book));
        }
    }

    private subscribeToSaveResponse(result: Observable<BookSdmSuffix>) {
        result.subscribe((res: BookSdmSuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: BookSdmSuffix) {
        this.eventManager.broadcast({ name: 'bookListModification', content: 'OK'});
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

    trackAuthorById(index: number, item: AuthorSdmSuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-book-sdm-suffix-popup',
    template: ''
})
export class BookSdmSuffixPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private bookPopupService: BookSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.bookPopupService
                    .open(BookSdmSuffixDialogComponent as Component, params['id']);
            } else {
                this.bookPopupService
                    .open(BookSdmSuffixDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
