import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseModulePopupComponent } from './course-module-popup.component';

describe('CourseModulePopupComponent', () => {
  let component: CourseModulePopupComponent;
  let fixture: ComponentFixture<CourseModulePopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseModulePopupComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourseModulePopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
