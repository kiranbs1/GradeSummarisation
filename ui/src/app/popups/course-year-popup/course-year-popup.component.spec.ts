import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseYearPopupComponent } from './course-year-popup.component';

describe('CourseYearPopupComponent', () => {
  let component: CourseYearPopupComponent;
  let fixture: ComponentFixture<CourseYearPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseYearPopupComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourseYearPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
