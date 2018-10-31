import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    DepSdmSuffixService,
    DepSdmSuffixPopupService,
    DepSdmSuffixComponent,
    DepSdmSuffixDetailComponent,
    DepSdmSuffixDialogComponent,
    DepSdmSuffixPopupComponent,
    DepSdmSuffixDeletePopupComponent,
    DepSdmSuffixDeleteDialogComponent,
    depRoute,
    depPopupRoute,
} from './';

const ENTITY_STATES = [
    ...depRoute,
    ...depPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        DepSdmSuffixComponent,
        DepSdmSuffixDetailComponent,
        DepSdmSuffixDialogComponent,
        DepSdmSuffixDeleteDialogComponent,
        DepSdmSuffixPopupComponent,
        DepSdmSuffixDeletePopupComponent,
    ],
    entryComponents: [
        DepSdmSuffixComponent,
        DepSdmSuffixDialogComponent,
        DepSdmSuffixPopupComponent,
        DepSdmSuffixDeleteDialogComponent,
        DepSdmSuffixDeletePopupComponent,
    ],
    providers: [
        DepSdmSuffixService,
        DepSdmSuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterDepSdmSuffixModule {}
