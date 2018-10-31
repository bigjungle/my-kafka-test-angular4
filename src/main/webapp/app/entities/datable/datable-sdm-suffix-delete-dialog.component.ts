import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DatableSdmSuffix } from './datable-sdm-suffix.model';
import { DatableSdmSuffixPopupService } from './datable-sdm-suffix-popup.service';
import { DatableSdmSuffixService } from './datable-sdm-suffix.service';

@Component({
    selector: 'jhi-datable-sdm-suffix-delete-dialog',
    templateUrl: './datable-sdm-suffix-delete-dialog.component.html'
})
export class DatableSdmSuffixDeleteDialogComponent {

    datable: DatableSdmSuffix;

    constructor(
        private datableService: DatableSdmSuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.datableService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'datableListModification',
                content: 'Deleted an datable'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-datable-sdm-suffix-delete-popup',
    template: ''
})
export class DatableSdmSuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private datablePopupService: DatableSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.datablePopupService
                .open(DatableSdmSuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
