import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { ARightUserMySuffix } from './a-right-user-my-suffix.model';
import { ARightUserMySuffixService } from './a-right-user-my-suffix.service';

@Component({
    selector: 'jhi-a-right-user-my-suffix-detail',
    templateUrl: './a-right-user-my-suffix-detail.component.html'
})
export class ARightUserMySuffixDetailComponent implements OnInit, OnDestroy {

    aRightUser: ARightUserMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private aRightUserService: ARightUserMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInARightUsers();
    }

    load(id) {
        this.aRightUserService.find(id).subscribe((aRightUser) => {
            this.aRightUser = aRightUser;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInARightUsers() {
        this.eventSubscriber = this.eventManager.subscribe(
            'aRightUserListModification',
            (response) => this.load(this.aRightUser.id)
        );
    }
}
