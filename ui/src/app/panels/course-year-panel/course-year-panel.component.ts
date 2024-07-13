import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CourseDTO} from "../../data/DTOs/course.dto";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {CourseModuleDTO} from "../../data/DTOs/course-module.dto";
import {NgForOf, NgIf} from "@angular/common";
import {CourseYearPopupComponent} from "../../popups/course-year-popup/course-year-popup.component";
import {ConfirmationPopupComponent} from "../../popups/confirmation-popup/confirmation-popup.component";
import {CourseService} from "../../services/course-service/course.service";
import {CalculateGradeService} from "../../services/calculate-grade-service/calculate-grade.service";
import {CourseYearService} from "../../services/course-year-service/course-year.service";
import {MatDialog} from "@angular/material/dialog";
import {CourseModuleService} from "../../services/course-module-service/course-module.service";
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
import {CourseModulePopupComponent} from "../../popups/course-module-popup/course-module-popup.component";

@Component({
  selector: 'app-course-year-panel',
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
  templateUrl: './course-year-panel.component.html',
  styleUrl: './course-year-panel.component.css'
})
export class CourseYearPanelComponent {

  @Input() courseYear: CourseYearDTO | undefined;
  @Output() focusChange = new EventEmitter<any>();

  constructor(private courseYearService: CourseYearService,
              private calculateGradeService: CalculateGradeService,
              private courseModuleService: CourseModuleService,
              private dialog: MatDialog) {
  }

  openAddCourseModuleDialog(): void {
    const dialogRef = this.dialog.open(CourseModulePopupComponent, {
      width: '60%',
      height: '60%',
      data: {
        courseYear: this.courseYear,
        type: "Add"
      }
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log(result)
    })
  }
  openEditCourseModuleDialog(courseModule: CourseModuleDTO): void {
    const dialogRef = this.dialog.open(CourseModulePopupComponent, {
      width: '60%',
      height: '60%',
      data: {
        courseYear: this.courseYear,
        courseModule: courseModule,
        type: "Edit"
      }
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log(result)
    })
  }

  deleteCourseModule(courseModule: CourseModuleDTO) {
    const dialogRef = this.dialog.open(ConfirmationPopupComponent)
    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        // this.courseModuleService.deleteCourse(courseModule.courseId)
      }
    })
  }

  deleteCourseYear(courseYear: CourseYearDTO) {
    const dialogRef = this.dialog.open(ConfirmationPopupComponent)
    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.courseYearService.deleteCourseYear(courseYear.courseYearId)
      }
    })
  }


  getCourseModuleGradePercentString(courseModule: CourseModuleDTO) : String {
    var grade: number | null =  this.calculateGradeService.calculateCurrentCourseModuleGradePercent(courseModule);
    if (grade !== null) {
      return grade.toFixed(2) + "%";
    } else {
      return 0 + "%"
    }
  }
  getCourseModuleGradeTotalString(courseModule: CourseModuleDTO) : String {
    var grade: number | null =  this.calculateGradeService.calculateCurrentCourseModuleGradeTotal(courseModule);
    var gradePercent: number | null =  this.calculateGradeService.calculateCurrentCourseModuleGradePercent(courseModule);
    if (grade !== null && gradePercent !== null) {
      return grade.toFixed(2) + "% out of " + ((100/ gradePercent ) * grade).toFixed(2) + "%"
    } else {
      return 0 + "%"
    }
  }

  triggerFocusChange(courseModule: CourseModuleDTO) {
    this.focusChange.emit(courseModule)
  }

}
