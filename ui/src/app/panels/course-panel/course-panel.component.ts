import {Component, EventEmitter, Input, Output} from '@angular/core';
import {DecimalPipe, NgForOf, NgIf} from "@angular/common";
import {CourseDTO} from "../../data/DTOs/course.dto";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
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
import {CourseService} from "../../services/course-service/course.service";
import {CalculateGradeService} from "../../services/calculate-grade-service/calculate-grade.service";
import {MatDialog} from "@angular/material/dialog";
import {CourseYearService} from "../../services/course-year-service/course-year.service";
import {ConfirmationPopupComponent} from "../../popups/confirmation-popup/confirmation-popup.component";
import {CourseYearPopupComponent} from "../../popups/course-year-popup/course-year-popup.component";

@Component({
  selector: 'app-course-panel',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    DecimalPipe,
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
  templateUrl: './course-panel.component.html',
  styleUrl: './course-panel.component.css'
})
export class CoursePanelComponent {

  @Input() course: CourseDTO | undefined;
  @Output() focusChange = new EventEmitter<any>();

  constructor(private courseService: CourseService,
              private calculateGradeService: CalculateGradeService,
              private courseYearService: CourseYearService,
              private dialog: MatDialog) {
  }

  triggerFocusChange(courseYear: CourseYearDTO) {
    this.focusChange.emit(courseYear)
  }

  openAddCourseYearDialog(): void {
    const dialogRef = this.dialog.open(CourseYearPopupComponent, {
      width: '60%',
      height: '60%',
      data: {
        course: this.course,
        type: "Add"
      }
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log(result)
    })
  }
  openEditCourseYearDialog(courseYear: CourseYearDTO): void {
    const dialogRef = this.dialog.open(CourseYearPopupComponent, {
      width: '60%',
      height: '60%',
      data: {
        course: this.course,
        courseYear: courseYear,
        type: "Edit"
      }
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log(result)
    })
  }

  deleteCourse(course: CourseDTO) {
    const dialogRef = this.dialog.open(ConfirmationPopupComponent)
    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.courseService.deleteCourse(course.courseId)
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


  getCourseGradeYearPercentString(courseYear: CourseYearDTO) : String {
    console.log("getCourseGrade ran")
    var grade: number | null =  this.calculateGradeService.calculateCurrentCourseYearGradePercent(courseYear);
    if (grade !== null) {
      return grade.toFixed(2) + "%";
    } else {
      return 0 + "%"
    }
  }
  getCourseYearGradeTotalString(courseYear: CourseYearDTO) : String {
    console.log("getCourseGrade ran")
    var grade: number | null =  this.calculateGradeService.calculateCurrentCourseYearGradeTotal(courseYear);
    var gradePercent: number | null =  this.calculateGradeService.calculateCurrentCourseYearGradePercent(courseYear);
    if (grade !== null && gradePercent !== null) {
      return grade.toFixed(2) + "% out of " + ((100/ gradePercent ) * grade).toFixed(2) + "%"
    } else {
      return 0 + "%"
    }
  }

}
