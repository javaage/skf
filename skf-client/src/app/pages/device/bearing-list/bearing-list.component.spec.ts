import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BearingListComponent } from './bearing-list.component';

describe('BearingListComponent', () => {
  let component: BearingListComponent;
  let fixture: ComponentFixture<BearingListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BearingListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BearingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
