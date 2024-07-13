import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursePopupComponent } from './course-popup.component';

describe('CoursePopupComponent', () => {
  let component: CoursePopupComponent;
  let fixture: ComponentFixture<CoursePopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoursePopupComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoursePopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
