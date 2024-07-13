package com.kiran.b.s.GradeSummarisation.database.service;

import com.kiran.b.s.GradeSummarisation.database.entities.CourseModule;
import com.kiran.b.s.GradeSummarisation.database.entities.CourseYear;
import com.kiran.b.s.GradeSummarisation.database.repository.CourseModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CourseModuleService {

    @Autowired
    private CourseModuleRepo courseModuleRepository;

    public Optional<CourseModule> findById(int id) {
        return courseModuleRepository.findById(id);
    }

    public CourseModule save(CourseModule courseModule) {
        return courseModuleRepository.save(courseModule);
    }

    public int updateCourseModule(CourseModule courseModule) {
        return courseModuleRepository.updateCourseModuleDetails(courseModule.getCourseModuleId(), courseModule.getName(),
                    courseModule.getDescription(), courseModule.getModuleWeight());
    }

    public void delete(int id) {
        courseModuleRepository.deleteById(id);
    }
}
