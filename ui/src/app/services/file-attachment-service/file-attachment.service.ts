import { Injectable } from '@angular/core';
import {AssessmentService} from "../assessment-service/assessment.service";
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {FileAttachmentDTO} from "../../data/DTOs/file-attachment.dto";

@Injectable({
  providedIn: 'root'
})
export class FileAttachmentService {

  constructor(private assessmentService: AssessmentService, private http: HttpClient) { }

}
