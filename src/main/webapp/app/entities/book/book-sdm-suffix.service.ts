import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { BookSdmSuffix } from './book-sdm-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class BookSdmSuffixService {

    private resourceUrl = 'api/books';

    constructor(private http: Http) { }

    create(book: BookSdmSuffix): Observable<BookSdmSuffix> {
        const copy = this.convert(book);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    update(book: BookSdmSuffix): Observable<BookSdmSuffix> {
        const copy = this.convert(book);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    find(id: number): Observable<BookSdmSuffix> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            return res.json();
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        return new ResponseWrapper(res.headers, jsonResponse, res.status);
    }

    private convert(book: BookSdmSuffix): BookSdmSuffix {
        const copy: BookSdmSuffix = Object.assign({}, book);
        return copy;
    }
}
