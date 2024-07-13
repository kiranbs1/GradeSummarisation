import {Component, EventEmitter, Input, Output} from '@angular/core';
import {NgForOf, NgIf} from "@angular/common";
import {CourseModuleDTO} from "../../data/DTOs/course-module.dto";
import {AssessmentDTO} from "../../data/DTOs/assessment.dto";
import {CourseService} from "../../services/course-service/course.service";
import {CalculateGradeService} from "../../services/calculate-grade-service/calculate-grade.service";
import {CourseYearService} from "../../services/course-year-service/course-year.service";
import {MatDialog} from "@angular/material/dialog";
import {CourseModuleService} from "../../services/course-module-service/course-module.service";
import {AssessmentService} from "../../services/assessment-service/assessment.service";
import {CourseYearPopupComponent} from "../../popups/course-year-popup/course-year-popup.component";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {CourseDTO} from "../../data/DTOs/course.dto";
import {ConfirmationPopupComponent} from "../../popups/confirmation-popup/confirmation-popup.component";
import {AssessmentPopupComponent} from "../../popups/assessment-popup/assessment-popup.component";
import {MatButton} from "@angular/material/button";
import {
  MatCard,
  MatCardActions,
  MatCardContent,
  MatCardFooter,
  MatCardHeader,
  MatCardSubtitle, MatCardTitle
} from "@angular/material/card";
import {MatIcon} from "@angular/material/icon";

@Component({
  selector: 'app-course-module-panel',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    MatButton,
    MatCard,
    MatCardActions,
    MatCardContent,
    MatCardFooter,
    MatCardHeader,
    MatCardSubtitle,
    MatCardTitle,
    MatIcon
  ],
  templateUrl: './course-module-panel.component.html',
  styleUrl: './course-module-panel.component.css'
})
export class CourseModulePanelComponent {

  @Input() courseModule: CourseModuleDTO | undefined;
  @Output() focusChange = new EventEmitter<any>();

  constructor(private courseModuleService: CourseModuleService,
              private assessmentService: AssessmentService,
              private dialog: MatDialog) {
  }

  triggerFocusChange(assessment: AssessmentDTO) {
    this.focusChange.emit(assessment)
  }

  openAddAssessmentDialog(): void {
    const dialogRef = this.dialog.open(AssessmentPopupComponent, {
      width: '60%',
      height: '60%',
      data: {
        courseModuleId: this.courseModule?.moduleId,
        type: "Add"
      }
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log(result)
    })
  }
  openEditAssessmentDialog(assessment: AssessmentDTO): void {
    const dialogRef = this.dialog.open(AssessmentPopupComponent, {
      width: '60%',
      height: '60%',
      data: {
        courseModuleId: this.courseModule?.moduleId,
        assessment: assessment,
        type: "Edit"
      }
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log(result)
    })
  }

  deleteAssessment(assessment: AssessmentDTO) {
    const dialogRef = this.dialog.open(ConfirmationPopupComponent)
    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.assessmentService.deleteAssessment(assessment.assessmentId)
      }
    })
  }

  deleteCourseModule(courseModule: CourseModuleDTO) {
    const dialogRef = this.dialog.open(ConfirmationPopupComponent)
    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        // this.courseModuleService.deleteCourseModule(courseModule.moduleId)
      }
    })
  }

}
