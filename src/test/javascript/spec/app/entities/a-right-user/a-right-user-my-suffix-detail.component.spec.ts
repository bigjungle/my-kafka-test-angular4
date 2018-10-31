/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { ARightUserMySuffixDetailComponent } from '../../../../../../main/webapp/app/entities/a-right-user/a-right-user-my-suffix-detail.component';
import { ARightUserMySuffixService } from '../../../../../../main/webapp/app/entities/a-right-user/a-right-user-my-suffix.service';
import { ARightUserMySuffix } from '../../../../../../main/webapp/app/entities/a-right-user/a-right-user-my-suffix.model';

describe('Component Tests', () => {

    describe('ARightUserMySuffix Management Detail Component', () => {
        let comp: ARightUserMySuffixDetailComponent;
        let fixture: ComponentFixture<ARightUserMySuffixDetailComponent>;
        let service: ARightUserMySuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [ARightUserMySuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    ARightUserMySuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(ARightUserMySuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ARightUserMySuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ARightUserMySuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new ARightUserMySuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.aRightUser).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
