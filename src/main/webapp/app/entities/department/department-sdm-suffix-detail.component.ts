import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { JhiEventManager } from 'ng-jhipster';

import { DepartmentSdmSuffix } from './department-sdm-suffix.model';
import { DepartmentSdmSuffixService } from './department-sdm-suffix.service';

@Component({
    selector: 'jhi-department-sdm-suffix-detail',
    templateUrl: './department-sdm-suffix-detail.component.html'
})
export class DepartmentSdmSuffixDetailComponent implements OnInit, OnDestroy {

    department: DepartmentSdmSuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private departmentService: DepartmentSdmSuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDepartments();
    }

    load(id) {
        this.departmentService.find(id).subscribe((department) => {
            this.department = department;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDepartments() {
        this.eventSubscriber = this.eventManager.subscribe(
            'departmentListModification',
            (response) => this.load(this.department.id)
        );
    }
}
