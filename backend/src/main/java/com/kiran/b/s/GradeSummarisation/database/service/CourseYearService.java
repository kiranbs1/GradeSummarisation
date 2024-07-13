package com.kiran.b.s.GradeSummarisation.database.service;

import com.kiran.b.s.GradeSummarisation.database.entities.Course;
import com.kiran.b.s.GradeSummarisation.database.entities.CourseYear;
import com.kiran.b.s.GradeSummarisation.database.repository.CourseYearRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CourseYearService {

    @Autowired
    private CourseYearRepo courseYearRepository;

    public Optional<CourseYear> findById(int id) {
        return courseYearRepository.findById(id);
    }

    public CourseYear save(CourseYear courseYear) {
        return courseYearRepository.save(courseYear);
    }

    public int updateCourseYear(CourseYear courseYear) {
        return courseYearRepository.updateCourseYearDetails(courseYear.getCourseYearId(), courseYear.getName(),
                    courseYear.getDescription(), courseYear.getYearNumber(), courseYear.getYearWeight());
    }

        public void delete(int id) {
        courseYearRepository.deleteById(id);
    }
}
