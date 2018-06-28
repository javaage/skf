import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserResetPSComponent } from './user-resetps.component';

describe('UserResetPSComponent', () => {
  let component: UserResetPSComponent;
  let fixture: ComponentFixture<UserResetPSComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserResetPSComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserResetPSComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
