package com.kiran.b.s.GradeSummarisation.data.DTOs;

import java.util.List;

public class CourseModuleDTO {

    private Integer moduleId;
    private Integer courseYearId;
    private String name;
    private String description;
    private float moduleWeight;
    private List<AssessmentDTO> assessments;

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getCourseYearId() {
        return courseYearId;
    }

    public void setCourseYearId(Integer courseYearId) {
        this.courseYearId = courseYearId;
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

    public float getModuleWeight() {
        return moduleWeight;
    }

    public void setModuleWeight(float moduleWeight) {
        this.moduleWeight = moduleWeight;
    }

    public List<AssessmentDTO> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<AssessmentDTO> assessments) {
        this.assessments = assessments;
    }
}
