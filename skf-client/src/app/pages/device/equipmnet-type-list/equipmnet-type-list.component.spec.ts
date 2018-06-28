import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmnetTypeListComponent } from './equipmnet-type-list.component';

describe('EquipmnetTypeListComponent', () => {
  let component: EquipmnetTypeListComponent;
  let fixture: ComponentFixture<EquipmnetTypeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipmnetTypeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipmnetTypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
