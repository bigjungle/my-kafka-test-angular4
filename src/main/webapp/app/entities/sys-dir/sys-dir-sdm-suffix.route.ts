import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { SysDirSdmSuffixComponent } from './sys-dir-sdm-suffix.component';
import { SysDirSdmSuffixDetailComponent } from './sys-dir-sdm-suffix-detail.component';
import { SysDirSdmSuffixPopupComponent } from './sys-dir-sdm-suffix-dialog.component';
import { SysDirSdmSuffixDeletePopupComponent } from './sys-dir-sdm-suffix-delete-dialog.component';

export const sysDirRoute: Routes = [
    {
        path: 'sys-dir-sdm-suffix',
        component: SysDirSdmSuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SysDirs'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'sys-dir-sdm-suffix/:id',
        component: SysDirSdmSuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SysDirs'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sysDirPopupRoute: Routes = [
    {
        path: 'sys-dir-sdm-suffix-new',
        component: SysDirSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SysDirs'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sys-dir-sdm-suffix/:id/edit',
        component: SysDirSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SysDirs'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'sys-dir-sdm-suffix/:id/delete',
        component: SysDirSdmSuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SysDirs'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
