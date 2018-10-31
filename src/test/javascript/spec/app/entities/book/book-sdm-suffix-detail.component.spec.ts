/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject } from '@angular/core/testing';
import { OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Rx';
import { JhiDateUtils, JhiDataUtils, JhiEventManager } from 'ng-jhipster';
import { JhipsterTestModule } from '../../../test.module';
import { MockActivatedRoute } from '../../../helpers/mock-route.service';
import { BookSdmSuffixDetailComponent } from '../../../../../../main/webapp/app/entities/book/book-sdm-suffix-detail.component';
import { BookSdmSuffixService } from '../../../../../../main/webapp/app/entities/book/book-sdm-suffix.service';
import { BookSdmSuffix } from '../../../../../../main/webapp/app/entities/book/book-sdm-suffix.model';

describe('Component Tests', () => {

    describe('BookSdmSuffix Management Detail Component', () => {
        let comp: BookSdmSuffixDetailComponent;
        let fixture: ComponentFixture<BookSdmSuffixDetailComponent>;
        let service: BookSdmSuffixService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterTestModule],
                declarations: [BookSdmSuffixDetailComponent],
                providers: [
                    JhiDateUtils,
                    JhiDataUtils,
                    DatePipe,
                    {
                        provide: ActivatedRoute,
                        useValue: new MockActivatedRoute({id: 123})
                    },
                    BookSdmSuffixService,
                    JhiEventManager
                ]
            }).overrideTemplate(BookSdmSuffixDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(BookSdmSuffixDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BookSdmSuffixService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
            // GIVEN

            spyOn(service, 'find').and.returnValue(Observable.of(new BookSdmSuffix(10)));

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.find).toHaveBeenCalledWith(123);
            expect(comp.book).toEqual(jasmine.objectContaining({id: 10}));
            });
        });
    });

});
