import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { AuthorSdmSuffixComponent } from './author-sdm-suffix.component';
import { AuthorSdmSuffixDetailComponent } from './author-sdm-suffix-detail.component';
import { AuthorSdmSuffixPopupComponent } from './author-sdm-suffix-dialog.component';
import { AuthorSdmSuffixDeletePopupComponent } from './author-sdm-suffix-delete-dialog.component';

@Injectable()
export class AuthorSdmSuffixResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const authorRoute: Routes = [
    {
        path: 'author-sdm-suffix',
        component: AuthorSdmSuffixComponent,
        resolve: {
            'pagingParams': AuthorSdmSuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Authors'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'author-sdm-suffix/:id',
        component: AuthorSdmSuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Authors'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const authorPopupRoute: Routes = [
    {
        path: 'author-sdm-suffix-new',
        component: AuthorSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Authors'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'author-sdm-suffix/:id/edit',
        component: AuthorSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Authors'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'author-sdm-suffix/:id/delete',
        component: AuthorSdmSuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Authors'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
