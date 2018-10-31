import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { AuthorSdmSuffix } from './author-sdm-suffix.model';
import { AuthorSdmSuffixService } from './author-sdm-suffix.service';

@Component({
    selector: 'jhi-author-sdm-suffix-detail',
    templateUrl: './author-sdm-suffix-detail.component.html'
})
export class AuthorSdmSuffixDetailComponent implements OnInit, OnDestroy {

    author: AuthorSdmSuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private authorService: AuthorSdmSuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInAuthors();
    }

    load(id) {
        this.authorService.find(id).subscribe((author) => {
            this.author = author;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInAuthors() {
        this.eventSubscriber = this.eventManager.subscribe(
            'authorListModification',
            (response) => this.load(this.author.id)
        );
    }
}
