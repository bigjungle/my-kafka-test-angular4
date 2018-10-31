import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { DatableSdmSuffix } from './datable-sdm-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class DatableSdmSuffixService {

    private resourceUrl = 'api/datables';

    constructor(private http: Http) { }

    create(datable: DatableSdmSuffix): Observable<DatableSdmSuffix> {
        const copy = this.convert(datable);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    update(datable: DatableSdmSuffix): Observable<DatableSdmSuffix> {
        const copy = this.convert(datable);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            return res.json();
        });
    }

    find(id: number): Observable<DatableSdmSuffix> {
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

    private convert(datable: DatableSdmSuffix): DatableSdmSuffix {
        const copy: DatableSdmSuffix = Object.assign({}, datable);
        return copy;
    }
}
