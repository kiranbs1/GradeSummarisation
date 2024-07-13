package com.kiran.b.s.GradeSummarisation.database.repository;

import com.kiran.b.s.GradeSummarisation.database.entities.CourseYear;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseYearRepo extends JpaRepository<CourseYear, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE CourseYear cy SET cy.name = :name, cy.description = :description, cy.yearNumber = :yearNumber, cy.yearWeight = :yearWeight WHERE cy.courseYearId = :courseYearId")
    int updateCourseYearDetails(@Param("courseYearId") Integer courseYearId,
                                @Param("name") String name,
                                @Param("description") String description,
                                @Param("yearNumber") int yearNumber,
                                @Param("yearWeight") float yearWeight);

}

