package com.kiran.b.s.GradeSummarisation.controller;

import com.kiran.b.s.GradeSummarisation.data.DTOs.CourseModuleDTO;
import com.kiran.b.s.GradeSummarisation.data.mappers.DTOMapper;
import com.kiran.b.s.GradeSummarisation.data.mappers.EntityMapper;
import com.kiran.b.s.GradeSummarisation.database.entities.CourseModule;
import com.kiran.b.s.GradeSummarisation.database.service.CourseModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/v1/courseModule" )
public class CourseModuleController {


    @Autowired
    private CourseModuleService courseModuleService;

    @PostMapping("/saveNewCourseModuleData")
    private ResponseEntity<CourseModuleDTO> saveNewCourseModuleData(@RequestBody CourseModuleDTO courseModuleDTO) {
        CourseModule courseModule = EntityMapper.toCourseModule(courseModuleDTO);
        courseModule.setCourseModuleId(null);
        courseModule = courseModuleService.save(courseModule);
        courseModuleDTO = DTOMapper.toCourseModuleDTO(courseModule);
        return ResponseEntity.ok(courseModuleDTO);
    }

    @PutMapping("/saveEditedShortCourseModuleData")
    private ResponseEntity<CourseModuleDTO> saveEditedShortCourseModuleData(@RequestBody CourseModuleDTO courseModuleDTO) {
        System.out.println("saveEditedShortCourseModuleData RANNNNNNNN");
        CourseModule courseModule = EntityMapper.toCourseModule(courseModuleDTO);

        int courseModuleId = courseModuleService.updateCourseModule(courseModule);
        courseModule.setCourseModuleId(courseModuleId);

        courseModuleDTO = DTOMapper.toCourseModuleDTO(courseModule);
        return ResponseEntity.ok(courseModuleDTO);
    }

    @DeleteMapping("/deleteCourseModule/{courseModuleId}")
    public ResponseEntity<Void> deleteCourseModule(@PathVariable(value = "courseModuleId") int courseModuleId) {
        if (courseModuleId != 0) {
            courseModuleService.delete(courseModuleId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }
}