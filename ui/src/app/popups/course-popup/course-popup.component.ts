import {Component, Inject, OnInit} from '@angular/core';
import {MatButton} from "@angular/material/button";
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatFormField} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {CourseDTO} from "../../data/DTOs/course.dto";
import {FormsModule} from "@angular/forms";
import {CourseService} from "../../services/course-service/course.service";

@Component({
  selector: 'app-course-popup',
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
  templateUrl: './course-popup.component.html',
  styleUrl: './course-popup.component.css'
})
export class CoursePopupComponent implements OnInit {

  type: string | undefined;
  title: string | undefined;
  loadedCourse: CourseDTO | null =null
  account: any | null =null;
  courseName: string | undefined;
  description: string | undefined;
  institution: string | undefined;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public dialogRef: MatDialogRef<CoursePopupComponent>,
              private courseService: CourseService) {
  }

  ngOnInit(): void {
    this.type = this.data.type;
    this.account = this.data.account;
    if (this.data.course !== undefined) {
      this.loadedCourse = this.data.course;
      this.courseName = this.data.course.name;
      this.description = this.data.course.description;
      this.institution = this.data.course.institution;
    }
    if (this.type === "Add") {
      this.title = "Add Course";
    } else if (this.type === "Edit") {
      this.title = "Edit Course";
    }
  }

  closePopup() {
    this.dialogRef.close("add/edit course Popup has been closed, no action taken")
  }

  saveCourse() {
    if (this.type === "Add") {
      if (this.account !== undefined) {
        if (this.courseName !== undefined && this.institution !== undefined) {
          const courseDTO: Partial<CourseDTO> = {
            userAccountId: this.account?.userAccountId,
            name: this.courseName,
            description: this.description,
            institution: this.institution
          };
          //save to courseService
          this.courseService.saveNewCourseData(courseDTO)
          this.dialogRef.close("successfully saved Course: " + courseDTO);
        } else {
          //ADD POPUP FOR ASKING FOR NEW FIELDS
        }
      } else {
        this.dialogRef.close("Something went wrong, please try refreshing the tab or logging out then back in ");
      }
    } else if (this.type === "Edit") {
      if (this.account !== undefined && this.loadedCourse !== undefined) {
        if (this.courseName !== undefined && this.institution !== undefined) {
          const courseDTO: Partial<CourseDTO> = {
            courseId: this.loadedCourse?.courseId,
            userAccountId: this.account?.userAccountId,
            name: this.courseName,
            description: this.description,
            institution: this.institution
          };
          this.courseService.saveEditedShortCourseData(courseDTO)
          this.dialogRef.close("Successfully edited Course: " + courseDTO);
        }
      } else {
        this.dialogRef.close("Something went wrong, please try refreshing the tab or logging out then back in ");
      }
    }
  }
}
