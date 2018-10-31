import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { SysDirSdmSuffix } from './sys-dir-sdm-suffix.model';
import { SysDirSdmSuffixService } from './sys-dir-sdm-suffix.service';

@Component({
    selector: 'jhi-sys-dir-sdm-suffix-detail',
    templateUrl: './sys-dir-sdm-suffix-detail.component.html'
})
export class SysDirSdmSuffixDetailComponent implements OnInit, OnDestroy {

    sysDir: SysDirSdmSuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private sysDirService: SysDirSdmSuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSysDirs();
    }

    load(id) {
        this.sysDirService.find(id).subscribe((sysDir) => {
            this.sysDir = sysDir;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSysDirs() {
        this.eventSubscriber = this.eventManager.subscribe(
            'sysDirListModification',
            (response) => this.load(this.sysDir.id)
        );
    }
}
