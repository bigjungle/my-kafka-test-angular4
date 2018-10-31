import { BaseEntity } from './../../shared';

export class DepartmentSdmSuffix implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public code?: string,
        public tel?: string,
        public fax?: string,
        public mail?: string,
        public people?: BaseEntity[],
        public sysDirs?: BaseEntity[],
        public parentId?: number,
    ) {
    }
}
