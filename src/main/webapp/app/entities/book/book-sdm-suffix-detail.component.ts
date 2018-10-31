import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { BookSdmSuffix } from './book-sdm-suffix.model';
import { BookSdmSuffixService } from './book-sdm-suffix.service';

@Component({
    selector: 'jhi-book-sdm-suffix-detail',
    templateUrl: './book-sdm-suffix-detail.component.html'
})
export class BookSdmSuffixDetailComponent implements OnInit, OnDestroy {

    book: BookSdmSuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private bookService: BookSdmSuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInBooks();
    }

    load(id) {
        this.bookService.find(id).subscribe((book) => {
            this.book = book;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInBooks() {
        this.eventSubscriber = this.eventManager.subscribe(
            'bookListModification',
            (response) => this.load(this.book.id)
        );
    }
}
