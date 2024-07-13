package com.kiran.b.s.GradeSummarisation.data.DTOs;

import java.util.List;

public class CourseYearDTO {

    private Integer courseYearId;
    private Integer courseId;
    private String name;
    private String description;
    private int yearNumber;
    private float yearWeight;
    private List<CourseModuleDTO> courseModules;

    public Integer getCourseYearId() {
        return courseYearId;
    }

    public void setCourseYearId(Integer courseYearId) {
        this.courseYearId = courseYearId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getYearWeight() {
        return yearWeight;
    }

    public void setYearWeight(float yearWeight) {
        this.yearWeight = yearWeight;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public List<CourseModuleDTO> getCourseModules() {
        return courseModules;
    }

    public void setCourseModules(List<CourseModuleDTO> courseModules) {
        this.courseModules = courseModules;
    }
}
