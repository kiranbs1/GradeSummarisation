package com.kiran.b.s.GradeSummarisation.database.repository;

import com.kiran.b.s.GradeSummarisation.database.entities.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    // You can add custom query methods here if needed

    @Modifying
    @Transactional
    @Query("UPDATE Course c SET c.name = :name, c.institution = :institution, c.description = :description WHERE c.courseId = :courseId")
    int updateCourseDetails(@Param("courseId") Integer courseId,
                            @Param("name") String name,
                            @Param("institution") String institution,
                            @Param("description") String description);
}

