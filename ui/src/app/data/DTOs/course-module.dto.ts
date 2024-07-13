// course-module.dto.ts

import { AssessmentDTO } from './assessment.dto'; // Assuming AssessmentDTO is defined similarly

export interface CourseModuleDTO {
  moduleId: number;
  courseYearId: number;
  name: string;
  description: string;
  moduleWeight: number;
  assessments: AssessmentDTO[];
}
