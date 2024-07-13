import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssessmentPanelComponent } from './assessment-panel.component';

describe('AssessmentPanelComponent', () => {
  let component: AssessmentPanelComponent;
  let fixture: ComponentFixture<AssessmentPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssessmentPanelComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssessmentPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
