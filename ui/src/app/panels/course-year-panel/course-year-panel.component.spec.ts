import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseYearPanelComponent } from './course-year-panel.component';

describe('CourseYearPanelComponent', () => {
  let component: CourseYearPanelComponent;
  let fixture: ComponentFixture<CourseYearPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseYearPanelComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourseYearPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
