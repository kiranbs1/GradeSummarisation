import { Injectable } from '@angular/core';
import {CourseService} from "../course-service/course.service";
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, of, tap} from "rxjs";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {environment} from "../../../environments/environment";
import {AccountService} from "../account-service/account.service";
import {CourseDTO} from "../../data/DTOs/course.dto";

@Injectable({
  providedIn: 'root'
})
export class CourseYearService {

  public readonly courseYearEndpoint: string = "/v1/courseYear";

  constructor(private courseService: CourseService, private accountService: AccountService, private http: HttpClient) { }

  deleteCourseYear(courseYearId: number): void {
    this.http.delete<void>(`${environment.baseUrl}${this.courseYearEndpoint}/deleteCourseYear/${courseYearId}`)
      .pipe(
        tap(response => {
          console.log('deleted Course Year: ', courseYearId);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course:', error);
          return of(undefined);
        })
      )
      .subscribe()
  }

  saveNewCourseYearData(courseYearDTO: Partial<CourseYearDTO>) {
    this.http.post<CourseYearDTO>(`${environment.baseUrl}${this.courseYearEndpoint}/saveNewCourseYearData`, courseYearDTO)
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

  saveEditedShortCourseYearData(courseYearDTO: Partial<CourseYearDTO>) {
    this.http.put<(CourseYearDTO)>(`${environment.baseUrl}${this.courseYearEndpoint}/saveEditedShortCourseYearData`,courseYearDTO)
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
