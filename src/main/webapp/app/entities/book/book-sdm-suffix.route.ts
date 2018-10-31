import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { BookSdmSuffixComponent } from './book-sdm-suffix.component';
import { BookSdmSuffixDetailComponent } from './book-sdm-suffix-detail.component';
import { BookSdmSuffixPopupComponent } from './book-sdm-suffix-dialog.component';
import { BookSdmSuffixDeletePopupComponent } from './book-sdm-suffix-delete-dialog.component';

@Injectable()
export class BookSdmSuffixResolvePagingParams implements Resolve<any> {

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

export const bookRoute: Routes = [
    {
        path: 'book-sdm-suffix',
        component: BookSdmSuffixComponent,
        resolve: {
            'pagingParams': BookSdmSuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'book-sdm-suffix/:id',
        component: BookSdmSuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const bookPopupRoute: Routes = [
    {
        path: 'book-sdm-suffix-new',
        component: BookSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'book-sdm-suffix/:id/edit',
        component: BookSdmSuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'book-sdm-suffix/:id/delete',
        component: BookSdmSuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
