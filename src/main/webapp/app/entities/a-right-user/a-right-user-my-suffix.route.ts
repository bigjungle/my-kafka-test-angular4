import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { ARightUserMySuffixComponent } from './a-right-user-my-suffix.component';
import { ARightUserMySuffixDetailComponent } from './a-right-user-my-suffix-detail.component';
import { ARightUserMySuffixPopupComponent } from './a-right-user-my-suffix-dialog.component';
import { ARightUserMySuffixDeletePopupComponent } from './a-right-user-my-suffix-delete-dialog.component';

@Injectable()
export class ARightUserMySuffixResolvePagingParams implements Resolve<any> {

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

export const aRightUserRoute: Routes = [
    {
        path: 'a-right-user-my-suffix',
        component: ARightUserMySuffixComponent,
        resolve: {
            'pagingParams': ARightUserMySuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightUsers'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'a-right-user-my-suffix/:id',
        component: ARightUserMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightUsers'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const aRightUserPopupRoute: Routes = [
    {
        path: 'a-right-user-my-suffix-new',
        component: ARightUserMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightUsers'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'a-right-user-my-suffix/:id/edit',
        component: ARightUserMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightUsers'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'a-right-user-my-suffix/:id/delete',
        component: ARightUserMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightUsers'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
