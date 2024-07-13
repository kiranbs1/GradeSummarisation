package com.kiran.b.s.GradeSummarisation.database.repository;

import com.kiran.b.s.GradeSummarisation.data.enums.AssessmentType;
import com.kiran.b.s.GradeSummarisation.database.entities.Assessment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepo extends JpaRepository<Assessment, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Assessment a SET a.name = :name, a.description = :description, a.mark = :mark, a.assessmentType = :assessmentType, a.assessmentWeight = :assessmentWeight, a.completed = :completed WHERE a.assessmentId = :assessmentId")
    int updateAssessmentDetails(@Param("assessmentId") Integer assessmentId,
                                @Param("name") String name,
                                @Param("description") String description,
                                @Param("mark") float mark,
                                @Param("assessmentType") AssessmentType assessmentType,
                                @Param("assessmentWeight") float assessmentWeight,
                                @Param("completed") boolean completed);

}

