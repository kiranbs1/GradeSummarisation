package com.kiran.b.s.GradeSummarisation.controller;

import com.kiran.b.s.GradeSummarisation.data.DTOs.AssessmentDTO;
import com.kiran.b.s.GradeSummarisation.data.mappers.DTOMapper;
import com.kiran.b.s.GradeSummarisation.data.mappers.EntityMapper;
import com.kiran.b.s.GradeSummarisation.database.entities.Assessment;
import com.kiran.b.s.GradeSummarisation.database.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/v1/assessment" )
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/saveNewAssessmentData")
    private ResponseEntity<AssessmentDTO> saveNewAssessmentData(@RequestBody AssessmentDTO assessmentDTO) {
        Assessment assessment = EntityMapper.toAssessment(assessmentDTO);
        assessment.setAssessmentId(null);
        assessment = assessmentService.save(assessment);
        assessmentDTO = DTOMapper.toAssessmentDTO(assessment);
        return ResponseEntity.ok(assessmentDTO);
    }
    @PutMapping("/saveEditedShortAssessmentData")
    private ResponseEntity<AssessmentDTO> saveEditedShortAssessmentData(@RequestBody AssessmentDTO assessmentDTO) {
        System.out.println("saveEditedShortAssessmentData RANNNNNNNN");
        Assessment assessment = EntityMapper.toAssessment(assessmentDTO);

        int assessmentId = assessmentService.updateAssessment(assessment);
        assessment.setAssessmentId(assessmentId);

        assessmentDTO = DTOMapper.toAssessmentDTO(assessment);
        return ResponseEntity.ok(assessmentDTO);
    }

    @DeleteMapping("/deleteAssessment/{assessmentId}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable(value="assessmentId") int assessmentId) {
        if (assessmentId != 0) {
            assessmentService.delete(assessmentId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
