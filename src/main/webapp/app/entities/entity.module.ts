import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { JhipsterDatableSdmSuffixModule } from './datable/datable-sdm-suffix.module';
import { JhipsterDacolumnSdmSuffixModule } from './dacolumn/dacolumn-sdm-suffix.module';
import { JhipsterBookSdmSuffixModule } from './book/book-sdm-suffix.module';
import { JhipsterAuthorSdmSuffixModule } from './author/author-sdm-suffix.module';
import { JhipsterARightUserMySuffixModule } from './a-right-user/a-right-user-my-suffix.module';
import { JhipsterARightPersonMySuffixModule } from './a-right-person/a-right-person-my-suffix.module';
import { JhipsterPersonSdmSuffixModule } from './person/person-sdm-suffix.module';
import { JhipsterDepartmentSdmSuffixModule } from './department/department-sdm-suffix.module';
import { JhipsterDepSdmSuffixModule } from './dep/dep-sdm-suffix.module';
import { JhipsterSysDirSdmSuffixModule } from './sys-dir/sys-dir-sdm-suffix.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        JhipsterDatableSdmSuffixModule,
        JhipsterDacolumnSdmSuffixModule,
        JhipsterBookSdmSuffixModule,
        JhipsterAuthorSdmSuffixModule,
        JhipsterARightUserMySuffixModule,
        JhipsterARightPersonMySuffixModule,
        JhipsterPersonSdmSuffixModule,
        JhipsterDepartmentSdmSuffixModule,
        JhipsterDepSdmSuffixModule,
        JhipsterSysDirSdmSuffixModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterEntityModule {}
