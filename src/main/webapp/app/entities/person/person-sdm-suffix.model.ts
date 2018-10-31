import { BaseEntity } from './../../shared';

export class PersonSdmSuffix implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public code?: string,
        public tel?: string,
        public fax?: string,
        public mail?: string,
        public sysDirs?: BaseEntity[],
        public departmentId?: number,
    ) {
    }
}
