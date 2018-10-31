import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';
import { ARightPersonMySuffix } from './a-right-person-my-suffix.model';
import { ARightPersonMySuffixService } from './a-right-person-my-suffix.service';

@Injectable()
export class ARightPersonMySuffixPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private aRightPersonService: ARightPersonMySuffixService

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
                this.aRightPersonService.find(id).subscribe((aRightPerson) => {
                    aRightPerson.birthday = this.datePipe
                        .transform(aRightPerson.birthday, 'yyyy-MM-ddTHH:mm:ss');
                    aRightPerson.validBegin = this.datePipe
                        .transform(aRightPerson.validBegin, 'yyyy-MM-ddTHH:mm:ss');
                    aRightPerson.validEnd = this.datePipe
                        .transform(aRightPerson.validEnd, 'yyyy-MM-ddTHH:mm:ss');
                    aRightPerson.insertTime = this.datePipe
                        .transform(aRightPerson.insertTime, 'yyyy-MM-ddTHH:mm:ss');
                    aRightPerson.upinstantTime = this.datePipe
                        .transform(aRightPerson.upinstantTime, 'yyyy-MM-ddTHH:mm:ss');
                    this.ngbModalRef = this.aRightPersonModalRef(component, aRightPerson);
                    resolve(this.ngbModalRef);
                });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.aRightPersonModalRef(component, new ARightPersonMySuffix());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    aRightPersonModalRef(component: Component, aRightPerson: ARightPersonMySuffix): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.aRightPerson = aRightPerson;
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
