import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { DacolumnSdmSuffixComponent } from './dacolumn-sdm-suffix.component';
import { DacolumnSdmSuffixDetailComponent } from './dacolumn-sdm-suffix-detail.component';
import { DacolumnSdmSuffixPopupComponent } from './dacolumn-sdm-suffix-dialog.component';
import { DacolumnSdmSuffixDeletePopupComponent } from './dacolumn-sdm-suffix-delete-dialog.component';

export const dacolumnRoute: Routes = [
    {
        path: 'dacolumn-sdm-suffix',
        component: DacolumnSdmSuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Dacolumns'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'dacolumn-sdm-suffix/:id',
        component: DacolumnSdmSuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Dacolumns'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const dacolumnPopupRoute: Routes = [
    {
        path: 'dacolumn-sdm-suffix-new',
        component: DacolumnSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Dacolumns'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'dacolumn-sdm-suffix/:id/edit',
        component: DacolumnSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Dacolumns'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'dacolumn-sdm-suffix/:id/delete',
        component: DacolumnSdmSuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Dacolumns'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
