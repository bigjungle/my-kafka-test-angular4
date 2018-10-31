import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { DatableSdmSuffix } from './datable-sdm-suffix.model';
import { DatableSdmSuffixService } from './datable-sdm-suffix.service';

@Component({
    selector: 'jhi-datable-sdm-suffix-detail',
    templateUrl: './datable-sdm-suffix-detail.component.html'
})
export class DatableSdmSuffixDetailComponent implements OnInit, OnDestroy {

    datable: DatableSdmSuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private datableService: DatableSdmSuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDatables();
    }

    load(id) {
        this.datableService.find(id).subscribe((datable) => {
            this.datable = datable;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDatables() {
        this.eventSubscriber = this.eventManager.subscribe(
            'datableListModification',
            (response) => this.load(this.datable.id)
        );
    }
}
