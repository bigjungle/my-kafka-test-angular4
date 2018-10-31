import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { DepSdmSuffixComponent } from './dep-sdm-suffix.component';
import { DepSdmSuffixDetailComponent } from './dep-sdm-suffix-detail.component';
import { DepSdmSuffixPopupComponent } from './dep-sdm-suffix-dialog.component';
import { DepSdmSuffixDeletePopupComponent } from './dep-sdm-suffix-delete-dialog.component';

export const depRoute: Routes = [
    {
        path: 'dep-sdm-suffix',
        component: DepSdmSuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Deps'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'dep-sdm-suffix/:id',
        component: DepSdmSuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Deps'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const depPopupRoute: Routes = [
    {
        path: 'dep-sdm-suffix-new',
        component: DepSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Deps'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'dep-sdm-suffix/:id/edit',
        component: DepSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Deps'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'dep-sdm-suffix/:id/delete',
        component: DepSdmSuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Deps'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
