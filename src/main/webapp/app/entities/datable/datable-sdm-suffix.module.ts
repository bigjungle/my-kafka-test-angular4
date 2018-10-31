import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    DatableSdmSuffixService,
    DatableSdmSuffixPopupService,
    DatableSdmSuffixComponent,
    DatableSdmSuffixDetailComponent,
    DatableSdmSuffixDialogComponent,
    DatableSdmSuffixPopupComponent,
    DatableSdmSuffixDeletePopupComponent,
    DatableSdmSuffixDeleteDialogComponent,
    datableRoute,
    datablePopupRoute,
} from './';

const ENTITY_STATES = [
    ...datableRoute,
    ...datablePopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        DatableSdmSuffixComponent,
        DatableSdmSuffixDetailComponent,
        DatableSdmSuffixDialogComponent,
        DatableSdmSuffixDeleteDialogComponent,
        DatableSdmSuffixPopupComponent,
        DatableSdmSuffixDeletePopupComponent,
    ],
    entryComponents: [
        DatableSdmSuffixComponent,
        DatableSdmSuffixDialogComponent,
        DatableSdmSuffixPopupComponent,
        DatableSdmSuffixDeleteDialogComponent,
        DatableSdmSuffixDeletePopupComponent,
    ],
    providers: [
        DatableSdmSuffixService,
        DatableSdmSuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterDatableSdmSuffixModule {}
