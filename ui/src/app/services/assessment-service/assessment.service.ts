import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, of, tap} from "rxjs";
import {AssessmentDTO} from "../../data/DTOs/assessment.dto";
import {CourseService} from "../course-service/course.service";
import {AccountService} from "../account-service/account.service";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AssessmentService {

  public readonly assessmentEndpoint: string = "/v1/assessment";

  constructor(private courseService: CourseService, private accountService: AccountService, private http: HttpClient) { }

  deleteAssessment(assessmentId: number): void {
    this.http.delete<void>(`${environment.baseUrl}${this.assessmentEndpoint}/deleteAssessment/${assessmentId}`)
      .pipe(
        tap(response => {
          console.log('deleted Course Year: ', assessmentId);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course:', error);
          return of(undefined);
        })
      )
      .subscribe()
  }

  saveNewAssessmentData(assessmentDTO: Partial<AssessmentDTO>) {
    this.http.post<AssessmentDTO>(`${environment.baseUrl}${this.assessmentEndpoint}/saveNewAssessmentData`, assessmentDTO)
      .pipe(
        tap(course => {
          console.log('new Course Year saved: ', course);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course year: ', error);
          return of(undefined);
        })
      )
      .subscribe()
  }

  saveEditedShortAssessmentData(assessmentDTO: Partial<AssessmentDTO>) {
    this.http.put<(AssessmentDTO)>(`${environment.baseUrl}${this.assessmentEndpoint}/saveEditedShortAssessmentData`,assessmentDTO)
      .pipe(
        tap(course => {
          console.log('Edited Course Year saved:', course);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course year:', error);
          return of(undefined);
        })
      )
      .subscribe()
  }
}
