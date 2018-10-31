import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    ARightUserMySuffixService,
    ARightUserMySuffixPopupService,
    ARightUserMySuffixComponent,
    ARightUserMySuffixDetailComponent,
    ARightUserMySuffixDialogComponent,
    ARightUserMySuffixPopupComponent,
    ARightUserMySuffixDeletePopupComponent,
    ARightUserMySuffixDeleteDialogComponent,
    aRightUserRoute,
    aRightUserPopupRoute,
    ARightUserMySuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...aRightUserRoute,
    ...aRightUserPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ARightUserMySuffixComponent,
        ARightUserMySuffixDetailComponent,
        ARightUserMySuffixDialogComponent,
        ARightUserMySuffixDeleteDialogComponent,
        ARightUserMySuffixPopupComponent,
        ARightUserMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        ARightUserMySuffixComponent,
        ARightUserMySuffixDialogComponent,
        ARightUserMySuffixPopupComponent,
        ARightUserMySuffixDeleteDialogComponent,
        ARightUserMySuffixDeletePopupComponent,
    ],
    providers: [
        ARightUserMySuffixService,
        ARightUserMySuffixPopupService,
        ARightUserMySuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterARightUserMySuffixModule {}
