import { BaseEntity } from './../../shared';

export class DepSdmSuffix implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public code?: string,
        public tel?: string,
        public fax?: string,
        public mail?: string,
        public upperId?: number,
        public deps?: BaseEntity[],
    ) {
    }
}
