package com.kiran.b.s.GradeSummarisation.controller;

import com.kiran.b.s.GradeSummarisation.data.DTOs.AccountDTO;
import com.kiran.b.s.GradeSummarisation.data.DTOs.CourseDTO;
import com.kiran.b.s.GradeSummarisation.data.mappers.DTOMapper;
import com.kiran.b.s.GradeSummarisation.data.mappers.EntityMapper;
import com.kiran.b.s.GradeSummarisation.database.entities.Course;
import com.kiran.b.s.GradeSummarisation.database.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping( "/v1/course" )
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/saveNewCourseData")
    private ResponseEntity<CourseDTO> saveNewCourseData(@RequestBody CourseDTO courseDTO) {
        Course course = EntityMapper.toCourse(courseDTO);
        course.setCourseId(null);
        course = courseService.save(course);
        courseDTO = DTOMapper.toCourseDTO(course);
        return ResponseEntity.ok(courseDTO);
    }
    @PutMapping("/saveEditedShortCourseData")
    private ResponseEntity<CourseDTO> saveEditedShortCourseData(@RequestBody CourseDTO courseDTO) {
        System.out.println("saveEditedShortCourseData RANNNNNNNN");
        Course course = EntityMapper.toCourse(courseDTO);

        int courseId = courseService.updateCourse(course);
        course.setCourseId(courseId);

        courseDTO = DTOMapper.toCourseDTO(course);
        return ResponseEntity.ok(courseDTO);
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(value="courseId") int courseId) {
        if (courseId != 0) {
            courseService.delete(courseId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
