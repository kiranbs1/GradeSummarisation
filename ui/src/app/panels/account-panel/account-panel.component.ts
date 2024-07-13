import {Component, EventEmitter, Input, Output} from '@angular/core';
import {AccountDTO} from "../../data/DTOs/account.dto";
import {CommonModule} from "@angular/common";
import {CourseDTO} from "../../data/DTOs/course.dto";
import {
  MatCard, MatCardActions,
  MatCardContent,
  MatCardFooter,
  MatCardHeader,
  MatCardSubtitle,
  MatCardTitle
} from "@angular/material/card";
import {MatIcon} from "@angular/material/icon";
import {MatButton} from "@angular/material/button";
import {MatDialog} from "@angular/material/dialog";
import {CoursePopupComponent} from "../../popups/course-popup/course-popup.component";
import {AccountService} from "../../services/account-service/account.service";
import {CourseService} from "../../services/course-service/course.service";
import {ConfirmationPopupComponent} from "../../popups/confirmation-popup/confirmation-popup.component";
import {CalculateGradeService} from "../../services/calculate-grade-service/calculate-grade.service";

@Component({
  selector: 'app-account-panel',
  standalone: true,
  imports: [CommonModule, MatCard, MatCardHeader, MatCardContent, MatCardFooter, MatCardTitle, MatCardSubtitle, MatCardActions, MatIcon, MatButton],
  templateUrl: './account-panel.component.html',
  styleUrl: './account-panel.component.css'
})
export class AccountPanelComponent {
  @Input() account: AccountDTO | undefined;

  @Output() focusChange = new EventEmitter<any>();

  constructor(private dialog: MatDialog, private accountService: AccountService, private courseService: CourseService,
              private calculateGradeService: CalculateGradeService) {
  }

  openAddCourseDialog(): void {
    const dialogRef = this.dialog.open(CoursePopupComponent, {
      width: '60%',
      height: '60%',
      data: {
        account: this.account,
        type: "Add"
      }
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log(result)
    })
  }

  openEditCourseDialog(courseDTO: CourseDTO): void {
    const dialogRef = this.dialog.open(CoursePopupComponent, {
      width: '60%',
      height: '60%',
      data: {
        account: this.account,
        course: courseDTO,
        type: "Edit"
      }
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log(result)
    })
  }

  // Method to trigger focus change
  triggerFocusChange(course: CourseDTO) {
    this.focusChange.emit(course)
  }

  deleteCourse(course: CourseDTO) {
    const dialogRef = this.dialog.open(ConfirmationPopupComponent)
    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.courseService.deleteCourse(course.courseId)
      }
    })
  }

  getCourseGradePercentString(course: CourseDTO) : String {
    console.log("getCourseGrade ran")
    var grade: number | null =  this.calculateGradeService.calculateCurrentCourseGradePercent(course);
    if (grade !== null) {
      return grade.toFixed(2) + "%";
    } else {
      return 0 + "%"
    }
  }
  getCourseGradeTotalString(course: CourseDTO) : String {
    console.log("getCourseGrade ran")
    var grade: number | null =  this.calculateGradeService.calculateCurrentCourseGradeTotal(course);
    var gradePercent: number | null =  this.calculateGradeService.calculateCurrentCourseGradePercent(course);
    if (grade !== null && gradePercent !== null) {
      return grade.toFixed(2) + "% out of " + ((100/ gradePercent ) * grade).toFixed(2) + "%"
    } else {
      return 0 + "%"
    }
  }
}
