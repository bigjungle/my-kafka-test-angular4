import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils } from 'ng-jhipster';

import { SysDirSdmSuffix } from './sys-dir-sdm-suffix.model';
import { ResponseWrapper, createRequestOption } from '../../shared';

@Injectable()
export class SysDirSdmSuffixService {

    private resourceUrl = 'api/sys-dirs';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(sysDir: SysDirSdmSuffix): Observable<SysDirSdmSuffix> {
        const copy = this.convert(sysDir);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(sysDir: SysDirSdmSuffix): Observable<SysDirSdmSuffix> {
        const copy = this.convert(sysDir);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<SysDirSdmSuffix> {
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
        entity.prodDate = this.dateUtils
            .convertDateTimeFromServer(entity.prodDate);
        entity.deployDate = this.dateUtils
            .convertDateTimeFromServer(entity.deployDate);
    }

    private convert(sysDir: SysDirSdmSuffix): SysDirSdmSuffix {
        const copy: SysDirSdmSuffix = Object.assign({}, sysDir);

        copy.prodDate = this.dateUtils.toDate(sysDir.prodDate);

        copy.deployDate = this.dateUtils.toDate(sysDir.deployDate);
        return copy;
    }
}
