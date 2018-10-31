import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { ARightPersonMySuffixComponent } from './a-right-person-my-suffix.component';
import { ARightPersonMySuffixDetailComponent } from './a-right-person-my-suffix-detail.component';
import { ARightPersonMySuffixPopupComponent } from './a-right-person-my-suffix-dialog.component';
import { ARightPersonMySuffixDeletePopupComponent } from './a-right-person-my-suffix-delete-dialog.component';

@Injectable()
export class ARightPersonMySuffixResolvePagingParams implements Resolve<any> {

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

export const aRightPersonRoute: Routes = [
    {
        path: 'a-right-person-my-suffix',
        component: ARightPersonMySuffixComponent,
        resolve: {
            'pagingParams': ARightPersonMySuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightPeople'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'a-right-person-my-suffix/:id',
        component: ARightPersonMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightPeople'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const aRightPersonPopupRoute: Routes = [
    {
        path: 'a-right-person-my-suffix-new',
        component: ARightPersonMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightPeople'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'a-right-person-my-suffix/:id/edit',
        component: ARightPersonMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightPeople'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'a-right-person-my-suffix/:id/delete',
        component: ARightPersonMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ARightPeople'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
