import { BaseEntity } from './../../shared';

export class ARightUserMySuffix implements BaseEntity {
    constructor(
        public id?: number,
        public userPassword?: string,
        public processPassword?: string,
        public userSort?: string,
        public userPasswordValiinstantTimes?: number,
        public userPasswordLockFlag?: string,
        public procPasswordValiinstantTimes?: number,
        public procPasswordLockFlag?: string,
        public userProp?: string,
        public by01?: string,
        public by02?: string,
        public by03?: string,
        public by04?: string,
        public by05?: string,
        public validType?: string,
        public validBegin?: any,
        public validEnd?: any,
        public insertUserId?: string,
        public insertPersonId?: string,
        public insertTime?: any,
        public upinstantUserId?: string,
        public upinstantPersonId?: string,
        public upinstantTime?: any,
    ) {
    }
}
