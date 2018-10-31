import { BaseEntity } from './../../shared';

const enum Language {
    'FRENCH',
    'ENGLISH',
    'SPANISH',
    'CHINESE'
}

export class BookSdmSuffix implements BaseEntity {
    constructor(
        public id?: number,
        public title?: string,
        public description?: string,
        public language?: Language,
        public writerId?: number,
    ) {
    }
}
