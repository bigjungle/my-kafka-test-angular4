import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    ARightPersonMySuffixService,
    ARightPersonMySuffixPopupService,
    ARightPersonMySuffixComponent,
    ARightPersonMySuffixDetailComponent,
    ARightPersonMySuffixDialogComponent,
    ARightPersonMySuffixPopupComponent,
    ARightPersonMySuffixDeletePopupComponent,
    ARightPersonMySuffixDeleteDialogComponent,
    aRightPersonRoute,
    aRightPersonPopupRoute,
    ARightPersonMySuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...aRightPersonRoute,
    ...aRightPersonPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ARightPersonMySuffixComponent,
        ARightPersonMySuffixDetailComponent,
        ARightPersonMySuffixDialogComponent,
        ARightPersonMySuffixDeleteDialogComponent,
        ARightPersonMySuffixPopupComponent,
        ARightPersonMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        ARightPersonMySuffixComponent,
        ARightPersonMySuffixDialogComponent,
        ARightPersonMySuffixPopupComponent,
        ARightPersonMySuffixDeleteDialogComponent,
        ARightPersonMySuffixDeletePopupComponent,
    ],
    providers: [
        ARightPersonMySuffixService,
        ARightPersonMySuffixPopupService,
        ARightPersonMySuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterARightPersonMySuffixModule {}
