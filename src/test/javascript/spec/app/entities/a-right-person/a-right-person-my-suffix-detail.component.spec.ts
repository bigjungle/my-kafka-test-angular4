/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { ARightPersonMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/a-right-person/a-right-person-my-suffix-detail.component';
import { ARightPersonMySuffixService } from '../../../../../../main/webapp/app/entities/a-right-person/a-right-person-my-suffix.service';
import { ARightPersonMySuffix } from '../../../../../../main/webapp/app/entities/a-right-person/a-right-person-my-suffix.model';

describe('Component Tests', () => {

    describe('ARightPersonMySuffix Management Detail Component', () => {
        let comp: ARightPersonMySuffixDetailComponent;
        let fixture: ComponentFixture<ARightPersonMySuffixDetailComponent>;
        let service: ARightPersonMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [ARightPersonMySuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    ARightPersonMySuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(ARightPersonMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ARightPersonMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ARightPersonMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new ARightPersonMySuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.aRightPerson).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
