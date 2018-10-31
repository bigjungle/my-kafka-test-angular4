/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { SysDirSdmSuffixDetailComponent } from '../../../../../../main/webapp/app/entities/sys-dir/sys-dir-sdm-suffix-detail.component';
import { SysDirSdmSuffixService } from '../../../../../../main/webapp/app/entities/sys-dir/sys-dir-sdm-suffix.service';
import { SysDirSdmSuffix } from '../../../../../../main/webapp/app/entities/sys-dir/sys-dir-sdm-suffix.model';

describe('Component Tests', () => {

    describe('SysDirSdmSuffix Management Detail Component', () => {
        let comp: SysDirSdmSuffixDetailComponent;
        let fixture: ComponentFixture<SysDirSdmSuffixDetailComponent>;
        let service: SysDirSdmSuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [SysDirSdmSuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    SysDirSdmSuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(SysDirSdmSuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SysDirSdmSuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SysDirSdmSuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new SysDirSdmSuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.sysDir).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
