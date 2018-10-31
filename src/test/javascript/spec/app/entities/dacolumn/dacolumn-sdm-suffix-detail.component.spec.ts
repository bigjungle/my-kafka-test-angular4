/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { DacolumnSdmSuffixDetailComponent } from '../../../../../../main/webapp/app/entities/dacolumn/dacolumn-sdm-suffix-detail.component';
import { DacolumnSdmSuffixService } from '../../../../../../main/webapp/app/entities/dacolumn/dacolumn-sdm-suffix.service';
import { DacolumnSdmSuffix } from '../../../../../../main/webapp/app/entities/dacolumn/dacolumn-sdm-suffix.model';

describe('Component Tests', () => {

    describe('DacolumnSdmSuffix Management Detail Component', () => {
        let comp: DacolumnSdmSuffixDetailComponent;
        let fixture: ComponentFixture<DacolumnSdmSuffixDetailComponent>;
        let service: DacolumnSdmSuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [DacolumnSdmSuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    DacolumnSdmSuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(DacolumnSdmSuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DacolumnSdmSuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DacolumnSdmSuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new DacolumnSdmSuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.dacolumn).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
