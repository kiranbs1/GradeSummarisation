package com.kiran.b.s.GradeSummarisation.database.repository;

import com.kiran.b.s.GradeSummarisation.database.entities.CourseModule;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseModuleRepo extends JpaRepository<CourseModule, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE CourseModule cm SET cm.name = :name, cm.description = :description, cm.moduleWeight = :moduleWeight WHERE cm.courseModuleId = :courseModuleId")
    int updateCourseModuleDetails(@Param("courseModuleId") Integer courseModuleId,
                                  @Param("name") String name,
                                  @Param("description") String description,
                                  @Param("moduleWeight") float moduleWeight);

}

