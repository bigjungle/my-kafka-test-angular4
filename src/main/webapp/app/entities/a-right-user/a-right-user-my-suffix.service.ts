import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { ARightUserMySuffix } from './a-right-user-my-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class ARightUserMySuffixService {

    private resourceUrl = 'api/a-right-users';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(aRightUser: ARightUserMySuffix): Observable<ARightUserMySuffix> {
        const copy = this.convert(aRightUser);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(aRightUser: ARightUserMySuffix): Observable<ARightUserMySuffix> {
        const copy = this.convert(aRightUser);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<ARightUserMySuffix> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
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
        for (let i = 0; i < jsonResponse.length; i++) {
            this.convertItemFromServer(jsonResponse[i]);
        }
        return new ResponseWrapper(res.headers, jsonResponse, res.status);
    }

    private convertItemFromServer(entity: any) {
        entity.validBegin = this.dateUtils
            .convertDateTimeFromServer(entity.validBegin);
        entity.validEnd = this.dateUtils
            .convertDateTimeFromServer(entity.validEnd);
        entity.insertTime = this.dateUtils
            .convertDateTimeFromServer(entity.insertTime);
        entity.upinstantTime = this.dateUtils
            .convertDateTimeFromServer(entity.upinstantTime);
    }

    private convert(aRightUser: ARightUserMySuffix): ARightUserMySuffix {
        const copy: ARightUserMySuffix = Object.assign({}, aRightUser);

        copy.validBegin = this.dateUtils.toDate(aRightUser.validBegin);

        copy.validEnd = this.dateUtils.toDate(aRightUser.validEnd);

        copy.insertTime = this.dateUtils.toDate(aRightUser.insertTime);

        copy.upinstantTime = this.dateUtils.toDate(aRightUser.upinstantTime);
        return copy;
    }
}
