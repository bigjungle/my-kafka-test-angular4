import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DepartmentSdmSuffix } from './department-sdm-suffix.model';
import { DepartmentSdmSuffixPopupService } from './department-sdm-suffix-popup.service';
import { DepartmentSdmSuffixService } from './department-sdm-suffix.service';

@Component({
    selector: 'jhi-department-sdm-suffix-delete-dialog',
    templateUrl: './department-sdm-suffix-delete-dialog.component.html'
})
export class DepartmentSdmSuffixDeleteDialogComponent {

    department: DepartmentSdmSuffix;

    constructor(
        private departmentService: DepartmentSdmSuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.departmentService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'departmentListModification',
                content: 'Deleted an department'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-department-sdm-suffix-delete-popup',
    template: ''
})
export class DepartmentSdmSuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private departmentPopupService: DepartmentSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.departmentPopupService
                .open(DepartmentSdmSuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
