import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    AuthorSdmSuffixService,
    AuthorSdmSuffixPopupService,
    AuthorSdmSuffixComponent,
    AuthorSdmSuffixDetailComponent,
    AuthorSdmSuffixDialogComponent,
    AuthorSdmSuffixPopupComponent,
    AuthorSdmSuffixDeletePopupComponent,
    AuthorSdmSuffixDeleteDialogComponent,
    authorRoute,
    authorPopupRoute,
    AuthorSdmSuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...authorRoute,
    ...authorPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        AuthorSdmSuffixComponent,
        AuthorSdmSuffixDetailComponent,
        AuthorSdmSuffixDialogComponent,
        AuthorSdmSuffixDeleteDialogComponent,
        AuthorSdmSuffixPopupComponent,
        AuthorSdmSuffixDeletePopupComponent,
    ],
    entryComponents: [
        AuthorSdmSuffixComponent,
        AuthorSdmSuffixDialogComponent,
        AuthorSdmSuffixPopupComponent,
        AuthorSdmSuffixDeleteDialogComponent,
        AuthorSdmSuffixDeletePopupComponent,
    ],
    providers: [
        AuthorSdmSuffixService,
        AuthorSdmSuffixPopupService,
        AuthorSdmSuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterAuthorSdmSuffixModule {}
