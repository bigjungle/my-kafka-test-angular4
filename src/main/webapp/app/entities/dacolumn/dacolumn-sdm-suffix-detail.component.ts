import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { DacolumnSdmSuffix } from './dacolumn-sdm-suffix.model';
import { DacolumnSdmSuffixService } from './dacolumn-sdm-suffix.service';

@Component({
    selector: 'jhi-dacolumn-sdm-suffix-detail',
    templateUrl: './dacolumn-sdm-suffix-detail.component.html'
})
export class DacolumnSdmSuffixDetailComponent implements OnInit, OnDestroy {

    dacolumn: DacolumnSdmSuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private dacolumnService: DacolumnSdmSuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDacolumns();
    }

    load(id) {
        this.dacolumnService.find(id).subscribe((dacolumn) => {
            this.dacolumn = dacolumn;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDacolumns() {
        this.eventSubscriber = this.eventManager.subscribe(
            'dacolumnListModification',
            (response) => this.load(this.dacolumn.id)
        );
    }
}
