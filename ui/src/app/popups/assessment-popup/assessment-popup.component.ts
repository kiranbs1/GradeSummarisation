import {Component, Inject, OnInit} from '@angular/core';
import {CourseDTO} from "../../data/DTOs/course.dto";
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
import {AssessmentService} from "../../services/assessment-service/assessment.service";
import {AssessmentDTO} from "../../data/DTOs/assessment.dto";
import {AssessmentType} from "../../data/enums/assessment-type.enum";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {MatCheckbox} from "@angular/material/checkbox";

@Component({
  selector: 'app-assessment-popup',
  standalone: true,
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButton,
    MatInput,
    MatFormField,
    FormsModule,
    MatRadioGroup,
    MatRadioButton,
    MatCheckbox
  ],  templateUrl: './assessment-popup.component.html',
  styleUrl: './assessment-popup.component.css'
})
export class AssessmentPopupComponent implements OnInit {

  type: string | undefined;
  title: string | undefined;
  loadedAssessment: AssessmentDTO | null =null;
  courseModuleId: number | undefined;
  assessmentName: string | undefined;
  description: string | undefined;
  assessmentType: AssessmentType = AssessmentType.COURSEWORK;
  mark: number | undefined;
  assessmentWeight: number | undefined;
  completed: boolean | undefined;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, public dialogRef: MatDialogRef<AssessmentPopupComponent>,
              private assessmentService: AssessmentService) {
  }

  ngOnInit(): void {
    this.type = this.data.type;
    this.courseModuleId = this.data.courseModuleId;
    if (this.data.assessment !== undefined) {
      this.loadedAssessment = this.data.assessment;
      this.assessmentName = this.data.assessment.name;
      this.description = this.data.assessment.description;
      this.assessmentType = this.data.assessment.assessmentType;
      this.mark = this.data.assessment.mark;
      this.assessmentWeight = this.data.assessment.assessmentWeight;
      this.completed = this.data.assessment.completed;
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
      if (this.courseModuleId !== undefined) {
        if (this.assessmentName !== undefined && this.assessmentType !== undefined
            && this.assessmentWeight !== undefined && this.mark !== undefined
            && this.completed !== undefined) {
          const assessmentDTO: Partial<AssessmentDTO> = {
            courseModuleId: this.courseModuleId,
            name: this.assessmentName,
            description: this.description,
            assessmentType: this.assessmentType,
            assessmentWeight: this.assessmentWeight,
            mark: this.mark,
            completed: this.completed
          };
          //save to courseService
          this.assessmentService.saveNewAssessmentData(assessmentDTO)
          this.dialogRef.close("successfully saved Assessment: " + assessmentDTO);
        } else {
          //ADD POPUP FOR ASKING FOR NEW FIELDS
        }
      } else {
        this.dialogRef.close("Something went wrong, please try refreshing the tab or logging out then back in ");
      }
    } else if (this.type === "Edit") {
      if (this.courseModuleId !== undefined && this.loadedAssessment !== undefined) {
        if (this.assessmentName !== undefined && this.assessmentType !== undefined
          && this.assessmentWeight !== undefined && this.mark !== undefined
          && this.completed !== undefined) {
          const assessmentDTO: Partial<AssessmentDTO> = {
            assessmentId: this.loadedAssessment?.assessmentId,
            courseModuleId: this.courseModuleId,
            name: this.assessmentName,
            description: this.description,
            assessmentType: this.assessmentType,
            assessmentWeight: this.assessmentWeight,
            mark: this.mark,
            completed: this.completed
          };
          this.assessmentService.saveEditedShortAssessmentData(assessmentDTO)
          this.dialogRef.close("Successfully edited Assessment: " + assessmentDTO);
        }
      } else {
        this.dialogRef.close("Something went wrong, please try refreshing the tab or logging out then back in ");
      }
    }
  }

  protected readonly AssessmentType = AssessmentType;
}
