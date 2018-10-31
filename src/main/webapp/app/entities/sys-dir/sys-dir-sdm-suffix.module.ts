import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    SysDirSdmSuffixService,
    SysDirSdmSuffixPopupService,
    SysDirSdmSuffixComponent,
    SysDirSdmSuffixDetailComponent,
    SysDirSdmSuffixDialogComponent,
    SysDirSdmSuffixPopupComponent,
    SysDirSdmSuffixDeletePopupComponent,
    SysDirSdmSuffixDeleteDialogComponent,
    sysDirRoute,
    sysDirPopupRoute,
} from './';

const ENTITY_STATES = [
    ...sysDirRoute,
    ...sysDirPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        SysDirSdmSuffixComponent,
        SysDirSdmSuffixDetailComponent,
        SysDirSdmSuffixDialogComponent,
        SysDirSdmSuffixDeleteDialogComponent,
        SysDirSdmSuffixPopupComponent,
        SysDirSdmSuffixDeletePopupComponent,
    ],
    entryComponents: [
        SysDirSdmSuffixComponent,
        SysDirSdmSuffixDialogComponent,
        SysDirSdmSuffixPopupComponent,
        SysDirSdmSuffixDeleteDialogComponent,
        SysDirSdmSuffixDeletePopupComponent,
    ],
    providers: [
        SysDirSdmSuffixService,
        SysDirSdmSuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterSysDirSdmSuffixModule {}
