import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssessmentPopupComponent } from './assessment-popup.component';

describe('AssessmentPopupComponent', () => {
  let component: AssessmentPopupComponent;
  let fixture: ComponentFixture<AssessmentPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssessmentPopupComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssessmentPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
