/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { PlantMallTestModule } from '../../../test.module';
import { SysAdminDeleteDialogComponent } from 'app/entities/sys-admin/sys-admin-delete-dialog.component';
import { SysAdminService } from 'app/entities/sys-admin/sys-admin.service';

describe('Component Tests', () => {
    describe('SysAdmin Management Delete Component', () => {
        let comp: SysAdminDeleteDialogComponent;
        let fixture: ComponentFixture<SysAdminDeleteDialogComponent>;
        let service: SysAdminService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [PlantMallTestModule],
                declarations: [SysAdminDeleteDialogComponent]
            })
                .overrideTemplate(SysAdminDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SysAdminDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SysAdminService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
