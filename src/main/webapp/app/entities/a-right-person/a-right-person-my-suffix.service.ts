import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { ARightPersonMySuffix } from './a-right-person-my-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class ARightPersonMySuffixService {

    private resourceUrl = 'api/a-right-people';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(aRightPerson: ARightPersonMySuffix): Observable<ARightPersonMySuffix> {
        const copy = this.convert(aRightPerson);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(aRightPerson: ARightPersonMySuffix): Observable<ARightPersonMySuffix> {
        const copy = this.convert(aRightPerson);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<ARightPersonMySuffix> {
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
        entity.birthday = this.dateUtils
            .convertDateTimeFromServer(entity.birthday);
        entity.validBegin = this.dateUtils
            .convertDateTimeFromServer(entity.validBegin);
        entity.validEnd = this.dateUtils
            .convertDateTimeFromServer(entity.validEnd);
        entity.insertTime = this.dateUtils
            .convertDateTimeFromServer(entity.insertTime);
        entity.upinstantTime = this.dateUtils
            .convertDateTimeFromServer(entity.upinstantTime);
    }

    private convert(aRightPerson: ARightPersonMySuffix): ARightPersonMySuffix {
        const copy: ARightPersonMySuffix = Object.assign({}, aRightPerson);

        copy.birthday = this.dateUtils.toDate(aRightPerson.birthday);

        copy.validBegin = this.dateUtils.toDate(aRightPerson.validBegin);

        copy.validEnd = this.dateUtils.toDate(aRightPerson.validEnd);

        copy.insertTime = this.dateUtils.toDate(aRightPerson.insertTime);

        copy.upinstantTime = this.dateUtils.toDate(aRightPerson.upinstantTime);
        return copy;
    }
}
