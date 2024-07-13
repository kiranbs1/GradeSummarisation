import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseModulePanelComponent } from './course-module-panel.component';

describe('CourseModulePanelComponent', () => {
  let component: CourseModulePanelComponent;
  let fixture: ComponentFixture<CourseModulePanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseModulePanelComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourseModulePanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
