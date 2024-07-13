import {Component, Inject, OnInit} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";
import {MatFormField} from "@angular/material/form-field";
import {FormsModule} from "@angular/forms";
import {CourseModuleService} from "../../services/course-module-service/course-module.service";
import {CourseModuleDTO} from "../../data/DTOs/course-module.dto";

@Component({
  selector: 'app-course-module-popup',
  standalone: true,
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButton,
    MatInput,
    MatFormField,
    FormsModule],
  templateUrl: './course-module-popup.component.html',
  styleUrl: './course-module-popup.component.css'
})
export class CourseModulePopupComponent implements OnInit {
  type: string | undefined;
  title: string | undefined;
  loadedCourseModule: CourseModuleDTO | null =null
  courseYearId: number | undefined;
  courseModuleName: string | undefined;
  description: string | undefined;
  moduleWeight: number | undefined;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public dialogRef: MatDialogRef<CourseModulePopupComponent>,
              private courseModuleService: CourseModuleService) {

  }

  ngOnInit(): void {
    this.type = this.data.type;
    this.courseYearId = this.data.courseYearId;
    if (this.data.courseModule !== undefined) {
      this.loadedCourseModule = this.data.courseModule;
      this.courseModuleName = this.data.courseModule.name;
      this.description = this.data.courseModule.description;
      this.moduleWeight = this.data.courseModule.moduleWeight;
    }
    if (this.type === "Add") {
      this.title = "Add Module";
    } else if (this.type === "Edit") {
      this.title = "Edit Module";
    }
  }

  closePopup() {
    this.dialogRef.close("add/edit Module Popup has been closed, no action taken")
  }

  saveCourse() {
    if (this.type === "Add") {
      if (this.courseYearId !== undefined) {
        if (this.courseModuleName !== undefined && this.moduleWeight !== undefined) {
          const courseModuleDTO: Partial<CourseModuleDTO> = {
            courseYearId: this.courseYearId,
            name: this.courseModuleName,
            description: this.description,
            moduleWeight: this.moduleWeight
          };
          this.courseModuleService.saveNewCourseModuleData(courseModuleDTO)
          this.dialogRef.close("successfully saved Course: " + courseModuleDTO);
        } else {
          //ADD POPUP FOR ASKING FOR NEW FIELDS
        }
      } else {
        this.dialogRef.close("Something went wrong, please try refreshing the tab or logging out then back in ");
      }
    } else if (this.type === "Edit") {
      if (this.loadedCourseModule !== undefined) {
        if (this.courseModuleName !== undefined && this.moduleWeight !== undefined) {
          const courseModule: Partial<CourseModuleDTO> = {
            moduleId: this.loadedCourseModule?.moduleId,
            courseYearId: this.loadedCourseModule?.courseYearId,
            name: this.courseModuleName,
            description: this.description,
            moduleWeight: this.moduleWeight
          };
          this.courseModuleService.saveEditedShortCourseModuleData(courseModule)
          this.dialogRef.close("Successfully edited Course Module: " + courseModule.moduleId);
        }
      } else {
        this.dialogRef.close("Something went wrong, please try refreshing the tab or logging out then back in ");
      }
    }
  }
}
