// account.dto.ts

import { CourseDTO } from './course.dto'; // Assuming CourseDTO is defined similarly

export interface AccountDTO {
  userAccountId: number;
  oauthId: number;
  email: string;
  clientReg: string;
  courses: CourseDTO[];
}
