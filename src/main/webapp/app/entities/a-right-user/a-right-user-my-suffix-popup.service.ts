import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';
import { ARightUserMySuffix } from './a-right-user-my-suffix.model';
import { ARightUserMySuffixService } from './a-right-user-my-suffix.service';

@Injectable()
export class ARightUserMySuffixPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private aRightUserService: ARightUserMySuffixService

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
                this.aRightUserService.find(id).subscribe((aRightUser) => {
                    aRightUser.validBegin = this.datePipe
                        .transform(aRightUser.validBegin, 'yyyy-MM-ddTHH:mm:ss');
                    aRightUser.validEnd = this.datePipe
                        .transform(aRightUser.validEnd, 'yyyy-MM-ddTHH:mm:ss');
                    aRightUser.insertTime = this.datePipe
                        .transform(aRightUser.insertTime, 'yyyy-MM-ddTHH:mm:ss');
                    aRightUser.upinstantTime = this.datePipe
                        .transform(aRightUser.upinstantTime, 'yyyy-MM-ddTHH:mm:ss');
                    this.ngbModalRef = this.aRightUserModalRef(component, aRightUser);
                    resolve(this.ngbModalRef);
                });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.aRightUserModalRef(component, new ARightUserMySuffix());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    aRightUserModalRef(component: Component, aRightUser: ARightUserMySuffix): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.aRightUser = aRightUser;
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
