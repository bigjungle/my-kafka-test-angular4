import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSharedModule } from '../../shared';
import {
    DepartmentSdmSuffixService,
    DepartmentSdmSuffixPopupService,
    DepartmentSdmSuffixComponent,
    DepartmentSdmSuffixDetailComponent,
    DepartmentSdmSuffixDialogComponent,
    DepartmentSdmSuffixPopupComponent,
    DepartmentSdmSuffixDeletePopupComponent,
    DepartmentSdmSuffixDeleteDialogComponent,
    departmentRoute,
    departmentPopupRoute,
} from './';

const ENTITY_STATES = [
    ...departmentRoute,
    ...departmentPopupRoute,
];

@NgModule({
    imports: [
        JhipsterSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        DepartmentSdmSuffixComponent,
        DepartmentSdmSuffixDetailComponent,
        DepartmentSdmSuffixDialogComponent,
        DepartmentSdmSuffixDeleteDialogComponent,
        DepartmentSdmSuffixPopupComponent,
        DepartmentSdmSuffixDeletePopupComponent,
    ],
    entryComponents: [
        DepartmentSdmSuffixComponent,
        DepartmentSdmSuffixDialogComponent,
        DepartmentSdmSuffixPopupComponent,
        DepartmentSdmSuffixDeleteDialogComponent,
        DepartmentSdmSuffixDeletePopupComponent,
    ],
    providers: [
        DepartmentSdmSuffixService,
        DepartmentSdmSuffixPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterDepartmentSdmSuffixModule {}
