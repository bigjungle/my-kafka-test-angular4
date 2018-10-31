import { BaseEntity } from './../../shared';

const enum Columntype {
    'SYS',
    'LOG',
    'AUDIT',
    'COMMON',
    'CUSTOM'
}

export class DacolumnSdmSuffix implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public title?: string,
        public description?: string,
        public columntype?: Columntype,
        public datables?: BaseEntity[],
    ) {
    }
}
