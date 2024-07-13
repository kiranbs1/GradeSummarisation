import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CourseDTO} from "../../data/DTOs/course.dto";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {NgForOf, NgIf} from "@angular/common";
import {FileAttachmentDTO} from "../../data/DTOs/file-attachment.dto";

@Component({
  selector: 'app-file-attachment-panel',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './file-attachment-panel.component.html',
  styleUrl: './file-attachment-panel.component.css'
})
export class FileAttachmentPanelComponent {

  @Input() fileAttachment: FileAttachmentDTO | undefined;
  @Output() focusChange = new EventEmitter<any>();

  triggerFocusChange(courseYear: CourseYearDTO) {
    this.focusChange.emit(courseYear)
  }


}
