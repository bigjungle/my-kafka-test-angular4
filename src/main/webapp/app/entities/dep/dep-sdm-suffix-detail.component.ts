import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { DepSdmSuffix } from './dep-sdm-suffix.model';
import { DepSdmSuffixService } from './dep-sdm-suffix.service';

@Component({
    selector: 'jhi-dep-sdm-suffix-detail',
    templateUrl: './dep-sdm-suffix-detail.component.html'
})
export class DepSdmSuffixDetailComponent implements OnInit, OnDestroy {

    dep: DepSdmSuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private depService: DepSdmSuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDeps();
    }

    load(id) {
        this.depService.find(id).subscribe((dep) => {
            this.dep = dep;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDeps() {
        this.eventSubscriber = this.eventManager.subscribe(
            'depListModification',
            (response) => this.load(this.dep.id)
        );
    }
}
