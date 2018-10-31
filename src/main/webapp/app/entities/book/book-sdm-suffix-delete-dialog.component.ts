import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { BookSdmSuffix } from './book-sdm-suffix.model';
import { BookSdmSuffixPopupService } from './book-sdm-suffix-popup.service';
import { BookSdmSuffixService } from './book-sdm-suffix.service';

@Component({
    selector: 'jhi-book-sdm-suffix-delete-dialog',
    templateUrl: './book-sdm-suffix-delete-dialog.component.html'
})
export class BookSdmSuffixDeleteDialogComponent {

    book: BookSdmSuffix;

    constructor(
        private bookService: BookSdmSuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.bookService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'bookListModification',
                content: 'Deleted an book'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-book-sdm-suffix-delete-popup',
    template: ''
})
export class BookSdmSuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private bookPopupService: BookSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.bookPopupService
                .open(BookSdmSuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
