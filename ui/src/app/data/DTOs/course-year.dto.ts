// course-year.dto.ts

import { CourseModuleDTO } from './course-module.dto'; // Assuming CourseModuleDTO is defined similarly

export interface CourseYearDTO {
  courseYearId: number;
  courseId: number;
  name: string;
  description: string;
  yearNumber: number;
  yearWeight: number;
  courseModules: CourseModuleDTO[];
}
