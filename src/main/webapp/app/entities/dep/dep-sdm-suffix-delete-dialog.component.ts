import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DepSdmSuffix } from './dep-sdm-suffix.model';
import { DepSdmSuffixPopupService } from './dep-sdm-suffix-popup.service';
import { DepSdmSuffixService } from './dep-sdm-suffix.service';

@Component({
    selector: 'jhi-dep-sdm-suffix-delete-dialog',
    templateUrl: './dep-sdm-suffix-delete-dialog.component.html'
})
export class DepSdmSuffixDeleteDialogComponent {

    dep: DepSdmSuffix;

    constructor(
        private depService: DepSdmSuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.depService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'depListModification',
                content: 'Deleted an dep'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-dep-sdm-suffix-delete-popup',
    template: ''
})
export class DepSdmSuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private depPopupService: DepSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.depPopupService
                .open(DepSdmSuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
