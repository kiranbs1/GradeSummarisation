// assessment.dto.ts

import { FileAttachmentDTO } from './file-attachment.dto'; // Assuming FileAttachmentDTO is defined similarly
import { AssessmentType } from '../enums/assessment-type.enum'; // Assuming AssessmentType is an enum defined similarly

export interface AssessmentDTO {
  assessmentId: number;
  courseModuleId: number;
  name: string;
  description: string;
  assessmentType: AssessmentType;
  mark: number;
  assessmentWeight: number;
  completed: boolean;
  fileAttachments: FileAttachmentDTO[];
}
