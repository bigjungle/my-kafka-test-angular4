import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    DacolumnSdmSuffixService,
    DacolumnSdmSuffixPopupService,
    DacolumnSdmSuffixComponent,
    DacolumnSdmSuffixDetailComponent,
    DacolumnSdmSuffixDialogComponent,
    DacolumnSdmSuffixPopupComponent,
    DacolumnSdmSuffixDeletePopupComponent,
    DacolumnSdmSuffixDeleteDialogComponent,
    dacolumnRoute,
    dacolumnPopupRoute,
} from './';

const ENTITY_STATES = [
    ...dacolumnRoute,
    ...dacolumnPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        DacolumnSdmSuffixComponent,
        DacolumnSdmSuffixDetailComponent,
        DacolumnSdmSuffixDialogComponent,
        DacolumnSdmSuffixDeleteDialogComponent,
        DacolumnSdmSuffixPopupComponent,
        DacolumnSdmSuffixDeletePopupComponent,
    ],
    entryComponents: [
        DacolumnSdmSuffixComponent,
        DacolumnSdmSuffixDialogComponent,
        DacolumnSdmSuffixPopupComponent,
        DacolumnSdmSuffixDeleteDialogComponent,
        DacolumnSdmSuffixDeletePopupComponent,
    ],
    providers: [
        DacolumnSdmSuffixService,
        DacolumnSdmSuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterDacolumnSdmSuffixModule {}
