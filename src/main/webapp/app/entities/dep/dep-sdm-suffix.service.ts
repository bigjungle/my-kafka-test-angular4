import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { DepSdmSuffix } from './dep-sdm-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class DepSdmSuffixService {

    private resourceUrl = 'api/deps';

    constructor(private http: Http) { }

    create(dep: DepSdmSuffix): Observable<DepSdmSuffix> {
        const copy = this.convert(dep);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    update(dep: DepSdmSuffix): Observable<DepSdmSuffix> {
        const copy = this.convert(dep);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    find(id: number): Observable<DepSdmSuffix> {
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

    private convert(dep: DepSdmSuffix): DepSdmSuffix {
        const copy: DepSdmSuffix = Object.assign({}, dep);
        return copy;
    }
}
