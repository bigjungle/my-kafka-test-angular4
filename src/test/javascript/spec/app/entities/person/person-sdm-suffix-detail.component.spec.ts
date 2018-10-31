/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { PersonSdmSuffixDetailComponent } from '../../../../../../main/webapp/app/entities/person/person-sdm-suffix-detail.component';
import { PersonSdmSuffixService } from '../../../../../../main/webapp/app/entities/person/person-sdm-suffix.service';
import { PersonSdmSuffix } from '../../../../../../main/webapp/app/entities/person/person-sdm-suffix.model';

describe('Component Tests', () => {

    describe('PersonSdmSuffix Management Detail Component', () => {
        let comp: PersonSdmSuffixDetailComponent;
        let fixture: ComponentFixture<PersonSdmSuffixDetailComponent>;
        let service: PersonSdmSuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [PersonSdmSuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    PersonSdmSuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(PersonSdmSuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(PersonSdmSuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(PersonSdmSuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new PersonSdmSuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.person).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
