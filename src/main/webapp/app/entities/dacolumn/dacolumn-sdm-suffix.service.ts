import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { DacolumnSdmSuffix } from './dacolumn-sdm-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class DacolumnSdmSuffixService {

    private resourceUrl = 'api/dacolumns';

    constructor(private http: Http) { }

    create(dacolumn: DacolumnSdmSuffix): Observable<DacolumnSdmSuffix> {
        const copy = this.convert(dacolumn);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    update(dacolumn: DacolumnSdmSuffix): Observable<DacolumnSdmSuffix> {
        const copy = this.convert(dacolumn);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    find(id: number): Observable<DacolumnSdmSuffix> {
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

    private convert(dacolumn: DacolumnSdmSuffix): DacolumnSdmSuffix {
        const copy: DacolumnSdmSuffix = Object.assign({}, dacolumn);
        return copy;
    }
}
