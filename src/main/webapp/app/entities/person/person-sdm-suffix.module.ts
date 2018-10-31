import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    PersonSdmSuffixService,
    PersonSdmSuffixPopupService,
    PersonSdmSuffixComponent,
    PersonSdmSuffixDetailComponent,
    PersonSdmSuffixDialogComponent,
    PersonSdmSuffixPopupComponent,
    PersonSdmSuffixDeletePopupComponent,
    PersonSdmSuffixDeleteDialogComponent,
    personRoute,
    personPopupRoute,
} from './';

const ENTITY_STATES = [
    ...personRoute,
    ...personPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        PersonSdmSuffixComponent,
        PersonSdmSuffixDetailComponent,
        PersonSdmSuffixDialogComponent,
        PersonSdmSuffixDeleteDialogComponent,
        PersonSdmSuffixPopupComponent,
        PersonSdmSuffixDeletePopupComponent,
    ],
    entryComponents: [
        PersonSdmSuffixComponent,
        PersonSdmSuffixDialogComponent,
        PersonSdmSuffixPopupComponent,
        PersonSdmSuffixDeleteDialogComponent,
        PersonSdmSuffixDeletePopupComponent,
    ],
    providers: [
        PersonSdmSuffixService,
        PersonSdmSuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterPersonSdmSuffixModule {}
