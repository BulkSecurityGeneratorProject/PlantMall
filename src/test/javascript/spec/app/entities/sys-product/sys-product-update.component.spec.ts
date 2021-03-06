/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { PlantMallTestModule } from '../../../test.module';
import { SysProductUpdateComponent } from 'app/entities/sys-product/sys-product-update.component';
import { SysProductService } from 'app/entities/sys-product/sys-product.service';
import { SysProduct } from 'app/shared/model/sys-product.model';

describe('Component Tests', () => {
    describe('SysProduct Management Update Component', () => {
        let comp: SysProductUpdateComponent;
        let fixture: ComponentFixture<SysProductUpdateComponent>;
        let service: SysProductService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [PlantMallTestModule],
                declarations: [SysProductUpdateComponent]
            })
                .overrideTemplate(SysProductUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(SysProductUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SysProductService);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity', fakeAsync(() => {
                // GIVEN
                const entity = new SysProduct(123);
                spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.sysProduct = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.update).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));

            it('Should call create service on save for new entity', fakeAsync(() => {
                // GIVEN
                const entity = new SysProduct();
                spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.sysProduct = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.create).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));
        });
    });
});
