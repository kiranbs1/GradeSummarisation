import {Component, Inject, OnInit} from '@angular/core';
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {CoursePopupComponent} from "../course-popup/course-popup.component";
import {CourseYearService} from "../../services/course-year-service/course-year.service";
import {MatButton} from "@angular/material/button";
import {MatFormField} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-course-year-popup',
  standalone: true,
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButton,
    MatInput,
    MatFormField,
    FormsModule
  ],
  templateUrl: './course-year-popup.component.html',
  styleUrl: './course-year-popup.component.css'
})
export class CourseYearPopupComponent implements OnInit{

  type: string | undefined;
  title: string | undefined;
  loadedCourseYear: CourseYearDTO | null = null
  course: any | null = null;
  courseYearName: string | undefined;
  description: string | undefined;
  yearWeight: number | undefined;
  yearNumber: number | undefined;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public dialogRef: MatDialogRef<CoursePopupComponent>,
              private courseYearService: CourseYearService) {
  }

  ngOnInit(): void {
    this.type = this.data.type;
    this.course = this.data.course;
    if (this.data.courseYear !== undefined) {
      this.loadedCourseYear = this.data.courseYear;
      this.courseYearName = this.data.courseYear.name;
      this.description = this.data.courseYear.description;
      this.yearNumber = this.data.courseYear.yearNumber;
      this.yearWeight = this.data.courseYear.yearWeight;
    }
    if (this.type === "Add") {
      this.title = "Add Course Year";
    } else if (this.type === "Edit") {
      this.title = "Edit Course Year";
    }
  }

  closePopup() {
    this.dialogRef.close("add/edit course year Popup has been closed, no action taken")
  }

  saveCourseYear() {
    if (this.type === "Add") {
      if (this.course !== undefined) {
        if (this.courseYearName !== undefined && this.yearNumber !== undefined && this.yearWeight !== undefined) {
          const courseYearDTO: Partial<CourseYearDTO> = {
            courseId: this.course?.courseId,
            name: this.courseYearName,
            description: this.description,
            yearNumber: this.yearNumber,
            yearWeight: this.yearWeight
          };
          this.courseYearService.saveNewCourseYearData(courseYearDTO)
          this.dialogRef.close("successfully saved Course Year: " + courseYearDTO);
        } else {
        }
      } else {
        this.dialogRef.close("Something went wrong, please try refreshing the tab or logging out then back in ");
      }
    } else if (this.type === "Edit") {
      if (this.course !== undefined && this.loadedCourseYear !== undefined) {
        if (this.courseYearName !== undefined && this.yearNumber !== undefined && this.yearWeight !== undefined) {
          const courseYearDTO: Partial<CourseYearDTO> = {
            courseYearId: this.loadedCourseYear?.courseYearId,
            courseId: this.course?.courseId,
            name: this.courseYearName,
            description: this.description,
            yearNumber: this.yearNumber,
            yearWeight: this.yearWeight
          };
          this.courseYearService.saveEditedShortCourseYearData(courseYearDTO)
          this.dialogRef.close("Successfully edited Course Year: " + courseYearDTO);
        }
      } else {
        this.dialogRef.close("Something went wrong, please try refreshing the tab or logging out then back in ");
      }
    }
  }
}
