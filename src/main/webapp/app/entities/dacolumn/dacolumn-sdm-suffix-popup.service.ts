import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DacolumnSdmSuffix } from './dacolumn-sdm-suffix.model';
import { DacolumnSdmSuffixService } from './dacolumn-sdm-suffix.service';

@Injectable()
export class DacolumnSdmSuffixPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private dacolumnService: DacolumnSdmSuffixService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.dacolumnService.find(id).subscribe((dacolumn) => {
                    this.ngbModalRef = this.dacolumnModalRef(component, dacolumn);
                    resolve(this.ngbModalRef);
                });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.dacolumnModalRef(component, new DacolumnSdmSuffix());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    dacolumnModalRef(component: Component, dacolumn: DacolumnSdmSuffix): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.dacolumn = dacolumn;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
