/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { DepartmentSdmSuffixDetailComponent } from '../../../../../../main/webapp/app/entities/department/department-sdm-suffix-detail.component';
import { DepartmentSdmSuffixService } from '../../../../../../main/webapp/app/entities/department/department-sdm-suffix.service';
import { DepartmentSdmSuffix } from '../../../../../../main/webapp/app/entities/department/department-sdm-suffix.model';

describe('Component Tests', () => {

    describe('DepartmentSdmSuffix Management Detail Component', () => {
        let comp: DepartmentSdmSuffixDetailComponent;
        let fixture: ComponentFixture<DepartmentSdmSuffixDetailComponent>;
        let service: DepartmentSdmSuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [DepartmentSdmSuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    DepartmentSdmSuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(DepartmentSdmSuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DepartmentSdmSuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DepartmentSdmSuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new DepartmentSdmSuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.department).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
