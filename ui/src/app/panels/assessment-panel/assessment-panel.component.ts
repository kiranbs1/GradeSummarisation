import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CourseDTO} from "../../data/DTOs/course.dto";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {AssessmentDTO} from "../../data/DTOs/assessment.dto";
import {FileAttachmentDTO} from "../../data/DTOs/file-attachment.dto";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-assessment-panel',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './assessment-panel.component.html',
  styleUrl: './assessment-panel.component.css'
})
export class AssessmentPanelComponent {

  @Input() assessment: AssessmentDTO | undefined;
  @Output() focusChange = new EventEmitter<any>();

  triggerFocusChange(fileAttachment: FileAttachmentDTO) {
    this.focusChange.emit(fileAttachment)
  }


}
