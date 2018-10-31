import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    BookSdmSuffixService,
    BookSdmSuffixPopupService,
    BookSdmSuffixComponent,
    BookSdmSuffixDetailComponent,
    BookSdmSuffixDialogComponent,
    BookSdmSuffixPopupComponent,
    BookSdmSuffixDeletePopupComponent,
    BookSdmSuffixDeleteDialogComponent,
    bookRoute,
    bookPopupRoute,
    BookSdmSuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...bookRoute,
    ...bookPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        BookSdmSuffixComponent,
        BookSdmSuffixDetailComponent,
        BookSdmSuffixDialogComponent,
        BookSdmSuffixDeleteDialogComponent,
        BookSdmSuffixPopupComponent,
        BookSdmSuffixDeletePopupComponent,
    ],
    entryComponents: [
        BookSdmSuffixComponent,
        BookSdmSuffixDialogComponent,
        BookSdmSuffixPopupComponent,
        BookSdmSuffixDeleteDialogComponent,
        BookSdmSuffixDeletePopupComponent,
    ],
    providers: [
        BookSdmSuffixService,
        BookSdmSuffixPopupService,
        BookSdmSuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterBookSdmSuffixModule {}
