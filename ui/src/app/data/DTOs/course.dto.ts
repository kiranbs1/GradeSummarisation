// course.dto.ts

import { CourseYearDTO } from './course-year.dto'; // Assuming CourseYearDTO is defined similarly

export interface CourseDTO {
  courseId: number;
  userAccountId: number;
  name: string;
  description: string;
  institution: string;
  courseYears: CourseYearDTO[];
}
