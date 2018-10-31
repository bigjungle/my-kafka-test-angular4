import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { PersonSdmSuffix } from './person-sdm-suffix.model';
import { PersonSdmSuffixService } from './person-sdm-suffix.service';

@Component({
    selector: 'jhi-person-sdm-suffix-detail',
    templateUrl: './person-sdm-suffix-detail.component.html'
})
export class PersonSdmSuffixDetailComponent implements OnInit, OnDestroy {

    person: PersonSdmSuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private personService: PersonSdmSuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInPeople();
    }

    load(id) {
        this.personService.find(id).subscribe((person) => {
            this.person = person;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInPeople() {
        this.eventSubscriber = this.eventManager.subscribe(
            'personListModification',
            (response) => this.load(this.person.id)
        );
    }
}
