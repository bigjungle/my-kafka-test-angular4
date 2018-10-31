import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ARightUserMySuffix } from './a-right-user-my-suffix.model';
import { ARightUserMySuffixPopupService } from './a-right-user-my-suffix-popup.service';
import { ARightUserMySuffixService } from './a-right-user-my-suffix.service';

@Component({
    selector: 'jhi-a-right-user-my-suffix-delete-dialog',
    templateUrl: './a-right-user-my-suffix-delete-dialog.component.html'
})
export class ARightUserMySuffixDeleteDialogComponent {

    aRightUser: ARightUserMySuffix;

    constructor(
        private aRightUserService: ARightUserMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.aRightUserService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'aRightUserListModification',
                content: 'Deleted an aRightUser'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-a-right-user-my-suffix-delete-popup',
    template: ''
})
export class ARightUserMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private aRightUserPopupService: ARightUserMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.aRightUserPopupService
                .open(ARightUserMySuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
