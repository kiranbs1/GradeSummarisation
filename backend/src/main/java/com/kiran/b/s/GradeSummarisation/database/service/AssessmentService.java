package com.kiran.b.s.GradeSummarisation.database.service;

import com.kiran.b.s.GradeSummarisation.database.entities.Assessment;
import com.kiran.b.s.GradeSummarisation.database.entities.CourseYear;
import com.kiran.b.s.GradeSummarisation.database.repository.AssessmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AssessmentService {

    @Autowired
    private AssessmentRepo assessmentRepository;

    public Optional<Assessment> findById(int id) {
        return assessmentRepository.findById(id);
    }

    public Assessment save(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    public int updateAssessment(Assessment assessment) {
        return assessmentRepository.updateAssessmentDetails(assessment.getAssessmentId(), assessment.getName(),
                    assessment.getDescription(), assessment.getMark(), assessment.getAssessmentType(), assessment.getAssessmentWeight(),
                    assessment.isCompleted());
    }
    public void delete(int id) {
        assessmentRepository.deleteById(id);
    }
}
