import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { DepartmentSdmSuffixComponent } from './department-sdm-suffix.component';
import { DepartmentSdmSuffixDetailComponent } from './department-sdm-suffix-detail.component';
import { DepartmentSdmSuffixPopupComponent } from './department-sdm-suffix-dialog.component';
import { DepartmentSdmSuffixDeletePopupComponent } from './department-sdm-suffix-delete-dialog.component';

export const departmentRoute: Routes = [
    {
        path: 'department-sdm-suffix',
        component: DepartmentSdmSuffixComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Departments'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'department-sdm-suffix/:id',
        component: DepartmentSdmSuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Departments'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const departmentPopupRoute: Routes = [
    {
        path: 'department-sdm-suffix-new',
        component: DepartmentSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Departments'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'department-sdm-suffix/:id/edit',
        component: DepartmentSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Departments'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'department-sdm-suffix/:id/delete',
        component: DepartmentSdmSuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Departments'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
