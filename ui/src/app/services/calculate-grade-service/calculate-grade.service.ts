import { Injectable } from '@angular/core';
import {CourseDTO} from "../../data/DTOs/course.dto";
import {CourseModuleDTO} from "../../data/DTOs/course-module.dto";
import {CourseYearDTO} from "../../data/DTOs/course-year.dto";
import {AssessmentDTO} from "../../data/DTOs/assessment.dto";

@Injectable({
  providedIn: 'root'
})
export class CalculateGradeService {

  constructor() { }

  calculateCurrentCourseGradeTotal(course : CourseDTO): number | null {
    console.log("calculateCurrentCourseGradePercent ran")
    var grade: number = 0;
    var noOfYears = 0;
    course.courseYears.forEach(courseYear => {
      var courseModuleGrade: number | null = this.calculateCurrentCourseYearGradeTotal(courseYear)
      if (courseModuleGrade !== null) {
        grade += courseModuleGrade * courseYear.yearWeight;
        noOfYears += 1
      }
    })
    if (noOfYears == 0) {
      return null;
    }
    console.log("course module grade for :" + course.courseId + " : " + grade);
    return grade;
  }

  calculateCurrentCourseYearGradeTotal(courseYear : CourseYearDTO): number | null {
    console.log("calculateCurrentCourseYearGradePercent ran")

    var grade: number = 0;
    var noOfModules = 0;
    courseYear.courseModules.forEach(courseModule => {
      var courseModuleGrade: number | null = this.calculateCurrentCourseModuleGradeTotal(courseModule)
      if (courseModuleGrade !== null) {
        grade += courseModuleGrade * courseModule.moduleWeight;
        noOfModules += 1
      }
    })
    if (noOfModules == 0) {
      return null;
    }
    console.log("course module grade for :" + courseYear.courseYearId + " : " + grade);

    return grade;
  }
  calculateCurrentCourseModuleGradeTotal(courseModule : CourseModuleDTO): number | null {
    var grade: number = 0;
    var noOfAssessments = 0;
    courseModule.assessments.forEach(assessment => {
      if (assessment.completed) {
        grade += assessment.mark * assessment.assessmentWeight
        noOfAssessments +=1
      }
    })
    if (noOfAssessments == 0) {
      return null;
    }
    console.log("course module grade for :" + courseModule.moduleId + " : " + grade);
    return grade;
  }


  calculateCurrentCourseGradePercent(course : CourseDTO): number | null {
    console.log("calculateCurrentCourseGradePercent ran")
    var grade: number = 0;
    var usedCourseWeight = 0;
    course.courseYears.forEach(courseYear => {
      var courseModuleGrade: number | null = this.calculateCurrentCourseYearGradePercent(courseYear)
      if (courseModuleGrade !== null) {
        grade += courseModuleGrade * courseYear.yearWeight;
        usedCourseWeight += courseYear.yearWeight
      }
    })
    if (usedCourseWeight == 0) {
      return null;
    }
    console.log("course module grade for :" + course.courseId + " : " + grade);
    return grade * (1 / usedCourseWeight);
  }

  calculateCurrentCourseYearGradePercent(courseYear : CourseYearDTO): number | null {
    console.log("calculateCurrentCourseYearGradePercent ran")

    var grade: number = 0;
    var usedYearWeight = 0;
    courseYear.courseModules.forEach(courseModule => {
      var courseModuleGrade: number | null = this.calculateCurrentCourseModuleGradePercent(courseModule)
      if (courseModuleGrade !== null) {
        grade += courseModuleGrade * courseModule.moduleWeight;
        usedYearWeight += courseModule.moduleWeight;
      }
    })
    if (usedYearWeight == 0) {
      return null;
    }
    console.log("course module grade for :" + courseYear.courseYearId + " : " + grade);

    return grade * (1 / usedYearWeight);
  }
  calculateCurrentCourseModuleGradePercent(courseModule : CourseModuleDTO): number | null {
    var grade: number = 0;
    var usedModuleWeight = 0;
    courseModule.assessments.forEach(assessment => {
      if (assessment.completed) {
        grade += assessment.mark * assessment.assessmentWeight;
        usedModuleWeight += assessment.assessmentWeight;
      }
    })
    if (usedModuleWeight == 0) {
      return null;
    }
    console.log("course module grade for :" + courseModule.moduleId + " : " + grade);
    return grade * (1 / usedModuleWeight);
  }
}
