/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { DatableSdmSuffixDetailComponent } from '../../../../../../main/webapp/app/entities/datable/datable-sdm-suffix-detail.component';
import { DatableSdmSuffixService } from '../../../../../../main/webapp/app/entities/datable/datable-sdm-suffix.service';
import { DatableSdmSuffix } from '../../../../../../main/webapp/app/entities/datable/datable-sdm-suffix.model';

describe('Component Tests', () => {

    describe('DatableSdmSuffix Management Detail Component', () => {
        let comp: DatableSdmSuffixDetailComponent;
        let fixture: ComponentFixture<DatableSdmSuffixDetailComponent>;
        let service: DatableSdmSuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [DatableSdmSuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    DatableSdmSuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(DatableSdmSuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DatableSdmSuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DatableSdmSuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new DatableSdmSuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.datable).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
