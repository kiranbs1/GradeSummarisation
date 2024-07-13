import {Component, Inject} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {CourseService} from "../../services/course-service/course.service";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-confirmation-popup',
  standalone: true,
  imports: [
    MatDialogContent,
    MatDialogTitle,
    MatButton,
    MatDialogActions
  ],
  templateUrl: './confirmation-popup.component.html',
  styleUrl: './confirmation-popup.component.css'
})
export class ConfirmationPopupComponent {

  constructor(public dialogRef: MatDialogRef<ConfirmationPopupComponent>) {
  }


  confirmPopup() {
    this.dialogRef.close(true)
  }

  cancelPopup() {
    this.dialogRef.close(false)
  }


}
