// file-attachment.dto.ts

import { FileAttachmentExt } from '../enums/file-attachment-ext.enum'; // Assuming FileAttachmentExt is an enum defined similarly
import { FileAttachmentType } from '../enums/file-attachment-type.enum'; // Assuming FileAttachmentType is an enum defined similarly

export interface FileAttachmentDTO {
  fileAttachmentId: number;
  assessmentId: number;
  fileAttachmentType: FileAttachmentType;
  fileAttachmentExt: FileAttachmentExt;
  name: string;
  description: string;
  attachment: Blob; // Assuming attachment is of type Blob or ArrayBuffer
}
