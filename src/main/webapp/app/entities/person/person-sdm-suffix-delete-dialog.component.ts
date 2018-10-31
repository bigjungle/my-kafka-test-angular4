import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { PersonSdmSuffix } from './person-sdm-suffix.model';
import { PersonSdmSuffixPopupService } from './person-sdm-suffix-popup.service';
import { PersonSdmSuffixService } from './person-sdm-suffix.service';

@Component({
    selector: 'jhi-person-sdm-suffix-delete-dialog',
    templateUrl: './person-sdm-suffix-delete-dialog.component.html'
})
export class PersonSdmSuffixDeleteDialogComponent {

    person: PersonSdmSuffix;

    constructor(
        private personService: PersonSdmSuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.personService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'personListModification',
                content: 'Deleted an person'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-person-sdm-suffix-delete-popup',
    template: ''
})
export class PersonSdmSuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private personPopupService: PersonSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.personPopupService
                .open(PersonSdmSuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
