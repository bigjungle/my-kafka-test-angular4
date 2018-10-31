import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { AuthorSdmSuffix } from './author-sdm-suffix.model';
import { AuthorSdmSuffixPopupService } from './author-sdm-suffix-popup.service';
import { AuthorSdmSuffixService } from './author-sdm-suffix.service';

@Component({
    selector: 'jhi-author-sdm-suffix-delete-dialog',
    templateUrl: './author-sdm-suffix-delete-dialog.component.html'
})
export class AuthorSdmSuffixDeleteDialogComponent {

    author: AuthorSdmSuffix;

    constructor(
        private authorService: AuthorSdmSuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.authorService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'authorListModification',
                content: 'Deleted an author'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-author-sdm-suffix-delete-popup',
    template: ''
})
export class AuthorSdmSuffixDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private authorPopupService: AuthorSdmSuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.authorPopupService
                .open(AuthorSdmSuffixDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
