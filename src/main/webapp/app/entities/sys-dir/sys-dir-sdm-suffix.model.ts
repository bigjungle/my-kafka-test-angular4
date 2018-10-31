import { BaseEntity } from './../../shared';

export class SysDirSdmSuffix implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public type?: string,
        public code?: string,
        public assetNumber?: string,
        public ipv4?: string,
        public ipv6?: string,
        public model?: string,
        public config?: string,
        public uses?: string,
        public developer?: string,
        public version?: string,
        public prodDate?: any,
        public deployDate?: any,
        public serviceLife?: string,
        public status?: string,
        public confidentLevel?: string,
        public parentId?: number,
        public departmentId?: number,
        public personId?: number,
    ) {
    }
}
