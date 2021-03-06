import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';
import { SysDirSdmSuffix } from './sys-dir-sdm-suffix.model';
import { SysDirSdmSuffixService } from './sys-dir-sdm-suffix.service';

@Injectable()
export class SysDirSdmSuffixPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private datePipe: DatePipe,
        private modalService: NgbModal,
        private router: Router,
        private sysDirService: SysDirSdmSuffixService

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
                this.sysDirService.find(id).subscribe((sysDir) => {
                    sysDir.prodDate = this.datePipe
                        .transform(sysDir.prodDate, 'yyyy-MM-ddTHH:mm:ss');
                    sysDir.deployDate = this.datePipe
                        .transform(sysDir.deployDate, 'yyyy-MM-ddTHH:mm:ss');
                    this.ngbModalRef = this.sysDirModalRef(component, sysDir);
                    resolve(this.ngbModalRef);
                });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.sysDirModalRef(component, new SysDirSdmSuffix());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    sysDirModalRef(component: Component, sysDir: SysDirSdmSuffix): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.sysDir = sysDir;
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
