import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { PersonSdmSuffixComponent } from './person-sdm-suffix.component';
import { PersonSdmSuffixDetailComponent } from './person-sdm-suffix-detail.component';
import { PersonSdmSuffixPopupComponent } from './person-sdm-suffix-dialog.component';
import { PersonSdmSuffixDeletePopupComponent } from './person-sdm-suffix-delete-dialog.component';

export const personRoute: Routes = [
    {
        path: 'person-sdm-suffix',
        component: PersonSdmSuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'People'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'person-sdm-suffix/:id',
        component: PersonSdmSuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'People'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const personPopupRoute: Routes = [
    {
        path: 'person-sdm-suffix-new',
        component: PersonSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'People'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'person-sdm-suffix/:id/edit',
        component: PersonSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'People'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'person-sdm-suffix/:id/delete',
        component: PersonSdmSuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'People'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
