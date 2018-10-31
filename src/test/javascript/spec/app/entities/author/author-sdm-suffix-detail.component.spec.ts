/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { AuthorSdmSuffixDetailComponent } from '../../../../../../main/webapp/app/entities/author/author-sdm-suffix-detail.component';
import { AuthorSdmSuffixService } from '../../../../../../main/webapp/app/entities/author/author-sdm-suffix.service';
import { AuthorSdmSuffix } from '../../../../../../main/webapp/app/entities/author/author-sdm-suffix.model';

describe('Component Tests', () => {

    describe('AuthorSdmSuffix Management Detail Component', () => {
        let comp: AuthorSdmSuffixDetailComponent;
        let fixture: ComponentFixture<AuthorSdmSuffixDetailComponent>;
        let service: AuthorSdmSuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [AuthorSdmSuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    AuthorSdmSuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(AuthorSdmSuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(AuthorSdmSuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AuthorSdmSuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new AuthorSdmSuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.author).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
