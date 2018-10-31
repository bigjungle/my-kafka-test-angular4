import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SysDirSdmSuffix } from './sys-dir-sdm-suffix.model';
import { SysDirSdmSuffixPopupService } from './sys-dir-sdm-suffix-popup.service';
import { SysDirSdmSuffixService } from './sys-dir-sdm-suffix.service';

@Component({
    selector: 'jhi-sys-dir-sdm-suffix-delete-dialog',
    templateUrl: './sys-dir-sdm-suffix-delete-dialog.component.html'
})
export class SysDirSdmSuffixDeleteDialogComponent {

    sysDir: SysDirSdmSuffix;

    constructor(
        private sysDirService: SysDirSdmSuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sysDirService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'sysDirListModification',
                content: 'Deleted an sysDir'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sys-dir-sdm-suffix-delete-popup',
    template: ''
})
export class SysDirSdmSuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private sysDirPopupService: SysDirSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.sysDirPopupService
                .open(SysDirSdmSuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
