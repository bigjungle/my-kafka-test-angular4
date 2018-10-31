import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { ARightPersonMySuffix } from './a-right-person-my-suffix.model';
import { ARightPersonMySuffixService } from './a-right-person-my-suffix.service';

@Component({
    selector: 'jhi-a-right-person-my-suffix-detail',
    templateUrl: './a-right-person-my-suffix-detail.component.html'
})
export class ARightPersonMySuffixDetailComponent implements OnInit, OnDestroy {

    aRightPerson: ARightPersonMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private aRightPersonService: ARightPersonMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInARightPeople();
    }

    load(id) {
        this.aRightPersonService.find(id).subscribe((aRightPerson) => {
            this.aRightPerson = aRightPerson;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInARightPeople() {
        this.eventSubscriber = this.eventManager.subscribe(
            'aRightPersonListModification',
            (response) => this.load(this.aRightPerson.id)
        );
    }
}
