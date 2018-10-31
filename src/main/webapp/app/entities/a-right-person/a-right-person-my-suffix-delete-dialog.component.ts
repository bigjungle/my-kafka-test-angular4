import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ARightPersonMySuffix } from './a-right-person-my-suffix.model';
import { ARightPersonMySuffixPopupService } from './a-right-person-my-suffix-popup.service';
import { ARightPersonMySuffixService } from './a-right-person-my-suffix.service';

@Component({
    selector: 'jhi-a-right-person-my-suffix-delete-dialog',
    templateUrl: './a-right-person-my-suffix-delete-dialog.component.html'
})
export class ARightPersonMySuffixDeleteDialogComponent {

    aRightPerson: ARightPersonMySuffix;

    constructor(
        private aRightPersonService: ARightPersonMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.aRightPersonService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'aRightPersonListModification',
                content: 'Deleted an aRightPerson'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-a-right-person-my-suffix-delete-popup',
    template: ''
})
export class ARightPersonMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private aRightPersonPopupService: ARightPersonMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.aRightPersonPopupService
                .open(ARightPersonMySuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
