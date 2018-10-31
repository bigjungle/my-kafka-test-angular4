import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { DatableSdmSuffixComponent } from './datable-sdm-suffix.component';
import { DatableSdmSuffixDetailComponent } from './datable-sdm-suffix-detail.component';
import { DatableSdmSuffixPopupComponent } from './datable-sdm-suffix-dialog.component';
import { DatableSdmSuffixDeletePopupComponent } from './datable-sdm-suffix-delete-dialog.component';

export const datableRoute: Routes = [
    {
        path: 'datable-sdm-suffix',
        component: DatableSdmSuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Datables'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'datable-sdm-suffix/:id',
        component: DatableSdmSuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Datables'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const datablePopupRoute: Routes = [
    {
        path: 'datable-sdm-suffix-new',
        component: DatableSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Datables'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'datable-sdm-suffix/:id/edit',
        component: DatableSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Datables'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'datable-sdm-suffix/:id/delete',
        component: DatableSdmSuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Datables'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
