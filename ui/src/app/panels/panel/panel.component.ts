import { Component, Input, OnInit } from '@angular/core';
import { AccountPanelComponent } from "../account-panel/account-panel.component";
import { AccountDTO } from "../../data/DTOs/account.dto";
import { CommonModule } from "@angular/common";
import {CoursePanelComponent} from "../course-panel/course-panel.component";
import {CourseDTO} from "../../data/DTOs/course.dto";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {CourseModuleDTO} from "../../data/DTOs/course-module.dto";
import {AssessmentDTO} from "../../data/DTOs/assessment.dto";
import {FileAttachmentDTO} from "../../data/DTOs/file-attachment.dto";
import {CourseYearPanelComponent} from "../course-year-panel/course-year-panel.component";
import {CourseModulePanelComponent} from "../course-module-panel/course-module-panel.component";
import {AssessmentPanelComponent} from "../assessment-panel/assessment-panel.component";
import {FileAttachmentPanelComponent} from "../file-attachment-panel/file-attachment-panel.component";
import {AccountService} from "../../services/account-service/account.service";

@Component({
  selector: 'app-panel',
  standalone: true,
  imports: [
    AccountPanelComponent,
    CommonModule,
    CoursePanelComponent,
    CourseYearPanelComponent,
    CourseModulePanelComponent,
    AssessmentPanelComponent,
    FileAttachmentPanelComponent
  ],
  templateUrl: './panel.component.html',
  styleUrls: ['./panel.component.css']
})
export class PanelComponent implements OnInit {

  selectedItem: any | undefined;

  constructor(private accountService: AccountService) {
  }

  ngOnInit(): void {
    this.accountService.getAccountData().subscribe(account => {
      this.selectedItem = account;
    });
  }

  onFocusChange(item: any) {
    console.log('Focus changed to:', item);

    // Fetch the latest version of the account data
    this.accountService.getAccountData().subscribe(accountdto => {
      const account = accountdto;

      if (this.isAccountDTO(item)) {
        this.selectedItem = account;
        return;
      } else if (this.isCourseDTO(item)) {
        const selectedCourse = account?.courses.find(course => course.courseId === item.courseId);
        if (selectedCourse) {
          this.selectedItem = selectedCourse;
        }
        return;
      } else if (this.isCourseYearDTO(item)) {
        account?.courses.forEach(course => {
          const selectedCourseYear = course.courseYears.find(year => year.courseYearId === item.courseYearId);
          if (selectedCourseYear) {
            this.selectedItem = selectedCourseYear;
          }
        });
        return;
      } else if (this.isCourseModuleDTO(item)) {
        account?.courses.forEach(course => {
          course.courseYears.forEach(year => {
            const selectedModule = year.courseModules.find(module => module.moduleId === item.moduleId);
            if (selectedModule) {
              this.selectedItem = selectedModule;
            }
          });
        });
        return;
      } else if (this.isAssessmentDTO(item)) {
        account?.courses.forEach(course => {
          course.courseYears.forEach(year => {
            year.courseModules.forEach(module => {
              const selectedAssessment = module.assessments.find(assessment => assessment.assessmentId === item.assessmentId);
              if (selectedAssessment) {
                this.selectedItem = selectedAssessment;
              }
            });
          });
        });
        return;
      } else if (this.isFileAttachmentDTO(item)) {
        account?.courses.forEach(course => {
          course.courseYears.forEach(year => {
            year.courseModules.forEach(module => {
              module.assessments.forEach(assessment => {
                const selectedFileAttachment = assessment.fileAttachments.find(file => file.fileAttachmentId === item.fileAttachmentId);
                if (selectedFileAttachment) {
                  this.selectedItem = selectedFileAttachment;
                }
              });
            });
          });
        });
        return;
      }
    });
  }


  isAccountDTO(item: any): item is AccountDTO {
    return item && item.userAccountId !== undefined && item.clientReg !== undefined;
  }
  isCourseDTO(item: any): item is CourseDTO {
    return item && item.courseId !== undefined && item.userAccountId !== undefined;
  }
  isCourseYearDTO(item: any): item is CourseYearDTO {
    return item && item.courseYearId !== undefined && item.courseId !== undefined;
  }
  isCourseModuleDTO(item: any): item is CourseModuleDTO {
    return item && item.moduleId !== undefined && item.courseYearId !== undefined;
  }
  isAssessmentDTO(item: any): item is AssessmentDTO {
    return item && item.assessmentId !== undefined && item.courseModuleId !== undefined;
  }
  isFileAttachmentDTO(item: any): item is FileAttachmentDTO {
    return item && item.fileAttachmentId !== undefined && item.assessmentId !== undefined;
  }
}
