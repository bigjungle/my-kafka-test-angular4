import { BaseEntity } from './../../shared';

const enum Tabletype {
    'PARAMETER',
    'DATA',
    'TEMPLATE',
    'TEMPLATEDATA'
}

export class DatableSdmSuffix implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public title?: string,
        public description?: string,
        public tabletype?: Tabletype,
        public columns?: BaseEntity[],
    ) {
    }
}
