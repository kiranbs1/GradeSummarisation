package com.kiran.b.s.GradeSummarisation.controller;

import com.kiran.b.s.GradeSummarisation.data.DTOs.CourseYearDTO;
import com.kiran.b.s.GradeSummarisation.data.mappers.DTOMapper;
import com.kiran.b.s.GradeSummarisation.data.mappers.EntityMapper;
import com.kiran.b.s.GradeSummarisation.database.entities.CourseYear;
import com.kiran.b.s.GradeSummarisation.database.service.CourseYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/v1/courseYear" )
public class CourseYearController {


    @Autowired
    private CourseYearService courseYearService;

    @PostMapping("/saveNewCourseYearData")
    private ResponseEntity<CourseYearDTO> saveNewCourseYearData(@RequestBody CourseYearDTO courseYearDTO) {
        CourseYear courseYear = EntityMapper.toCourseYear(courseYearDTO);
//        courseYear.setCourseYearId(null);
        courseYear = courseYearService.save(courseYear);
        courseYearDTO = DTOMapper.toCourseYearDTO(courseYear);
        return ResponseEntity.ok(courseYearDTO);
    }
    @PutMapping("/saveEditedShortCourseYearData")
    private ResponseEntity<CourseYearDTO> saveEditedShortCourseYearData(@RequestBody CourseYearDTO courseYearDTO) {
        System.out.println("saveEditedShortCourseYearData RANNNNNNNN");
        CourseYear courseYear = EntityMapper.toCourseYear(courseYearDTO);

        int courseYearId = courseYearService.updateCourseYear(courseYear);
        courseYear.setCourseYearId(courseYearId);

        courseYearDTO = DTOMapper.toCourseYearDTO(courseYear);
        return ResponseEntity.ok(courseYearDTO);
    }

    @DeleteMapping("/deleteCourseYear/{courseYearId}")
    public ResponseEntity<Void> deleteCourseYear(@PathVariable(value="courseYearId") int courseYearId) {
        if (courseYearId != 0) {
            courseYearService.delete(courseYearId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
