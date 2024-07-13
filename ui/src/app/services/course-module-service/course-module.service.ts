import { Injectable } from '@angular/core';
import {CourseYearService} from "../course-year-service/course-year.service";
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, of, tap} from "rxjs";
import {CourseModuleDTO} from "../../data/DTOs/course-module.dto";
import {environment} from "../../../environments/environment";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {AccountService} from "../account-service/account.service";

@Injectable({
  providedIn: 'root'
})
export class CourseModuleService {

  public readonly courseModuleEndpoint: string = "/v1/courseModule";

  constructor(private courseYearService: CourseYearService,
              private accountService: AccountService,
              private http: HttpClient) { }

  deleteModuleYear(courseModuleId: number): void {
    this.http.delete<void>(`${environment.baseUrl}${this.courseModuleEndpoint}/deleteCourseModule/${courseModuleId}`)
      .pipe(
        tap(response => {
          console.log('deleted Course Year: ', courseModuleId);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course:', error);
          return of(undefined);
        })
      )
      .subscribe()
  }

  saveNewCourseModuleData(courseModuleDTO: Partial<CourseModuleDTO>) {
    this.http.post<CourseYearDTO>(`${environment.baseUrl}${this.courseModuleEndpoint}/saveNewCourseModuleData`, courseModuleDTO)
      .pipe(
        tap(course => {
          console.log('new Course Module saved: ', course);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving course Module: ', error);
          return of(undefined);
        })
      )
      .subscribe()
  }

  saveEditedShortCourseModuleData(courseModuleDTO: Partial<CourseModuleDTO>) {
    this.http.put<(CourseYearDTO)>(`${environment.baseUrl}${this.courseModuleEndpoint}/saveEditedShortCourseModuleData`,courseModuleDTO)
      .pipe(
        tap(course => {
          console.log('Edited Course Module saved:', course);
          this.accountService.loadAccountData().subscribe();
        }),
        catchError(error => {
          console.error('Error saving Module year:', error);
          return of(undefined);
        })
      )
      .subscribe()
  }

}
