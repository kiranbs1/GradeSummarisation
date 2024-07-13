import { Injectable } from '@angular/core';
import {AccountService} from "../account-service/account.service";
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, of, tap} from "rxjs";
import {CourseDTO} from "../../data/DTOs/course.dto";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  public readonly courseEndpoint: string = "/v1/course";

  constructor(private accountService: AccountService, private http: HttpClient) {
  }

  saveNewCourseData(courseDTO: Partial<CourseDTO>): void {
    this.http.post<CourseDTO>(`${environment.baseUrl}${this.courseEndpoint}/saveNewCourseData`, courseDTO)
      .pipe(
        tap(course => {
          console.log('new Course saved:', course);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course:', error);
          return of(undefined);
        })
      )
      .subscribe()
  }
  saveEditedShortCourseData(courseDTO: Partial<CourseDTO>) {
    this.http.put<(CourseDTO)>(`${environment.baseUrl}${this.courseEndpoint}/saveEditedShortCourseData`,courseDTO)
      .pipe(
        tap(course => {
          console.log('Edited Course saved:', course);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course:', error);
          return of(undefined);
        })
      )
      .subscribe()
  }
  deleteCourse(courseId: number): void {
    this.http.delete<void>(`${environment.baseUrl}${this.courseEndpoint}/deleteCourse/${courseId}`)
      .pipe(
        tap(response => {
          console.log('deleted Course: ', courseId);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course:', error);
          return of(undefined);
        })
      )
      .subscribe()
  }
}
