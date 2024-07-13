package com.kiran.b.s.GradeSummarisation.database.service;

import com.kiran.b.s.GradeSummarisation.database.entities.Course;
import com.kiran.b.s.GradeSummarisation.database.repository.CourseRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepo courseRepository;

    public Optional<Course> findById(int id) {
        return courseRepository.findById(id);
    }

    public int updateCourse(Course course){
        return courseRepository.updateCourseDetails(course.getCourseId(),
                course.getName(), course.getInstitution(), course.getDescription());
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(int id) {
        courseRepository.deleteById(id);
    }
}