import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DacolumnSdmSuffix } from './dacolumn-sdm-suffix.model';
import { DacolumnSdmSuffixPopupService } from './dacolumn-sdm-suffix-popup.service';
import { DacolumnSdmSuffixService } from './dacolumn-sdm-suffix.service';

@Component({
    selector: 'jhi-dacolumn-sdm-suffix-delete-dialog',
    templateUrl: './dacolumn-sdm-suffix-delete-dialog.component.html'
})
export class DacolumnSdmSuffixDeleteDialogComponent {

    dacolumn: DacolumnSdmSuffix;

    constructor(
        private dacolumnService: DacolumnSdmSuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.dacolumnService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'dacolumnListModification',
                content: 'Deleted an dacolumn'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-dacolumn-sdm-suffix-delete-popup',
    template: ''
})
export class DacolumnSdmSuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private dacolumnPopupService: DacolumnSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.dacolumnPopupService
                .open(DacolumnSdmSuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
