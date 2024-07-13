package com.kiran.b.s.GradeSummarisation.data.DTOs;

import java.util.List;

public class CourseDTO {

    private Integer courseId;
    private Integer userAccountId;
    private String name;
    private String description;
    private String institution;
    private List<CourseYearDTO> courseYears;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public List<CourseYearDTO> getCourseYears() {
        return courseYears;
    }

    public void setCourseYears(List<CourseYearDTO> courseYears) {
        this.courseYears = courseYears;
    }
}
