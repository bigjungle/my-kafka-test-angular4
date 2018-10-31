/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { DepSdmSuffixDetailComponent } from '../../../../../../main/webapp/app/entities/dep/dep-sdm-suffix-detail.component';
import { DepSdmSuffixService } from '../../../../../../main/webapp/app/entities/dep/dep-sdm-suffix.service';
import { DepSdmSuffix } from '../../../../../../main/webapp/app/entities/dep/dep-sdm-suffix.model';

describe('Component Tests', () => {

    describe('DepSdmSuffix Management Detail Component', () => {
        let comp: DepSdmSuffixDetailComponent;
        let fixture: ComponentFixture<DepSdmSuffixDetailComponent>;
        let service: DepSdmSuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [DepSdmSuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    DepSdmSuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(DepSdmSuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DepSdmSuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DepSdmSuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new DepSdmSuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.dep).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
