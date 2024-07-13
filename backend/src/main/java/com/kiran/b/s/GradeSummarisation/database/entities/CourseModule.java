package com.kiran.b.s.GradeSummarisation.database.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CourseModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseModuleId;
    @Column(nullable = false)
    private Integer courseYearId;
    @Column(nullable = false)
    private String name;
    private String description;
    private float moduleWeight;
    @OneToMany(mappedBy = "courseModuleId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Assessment> assessments;

    public Integer getCourseModuleId() {
        return courseModuleId;
    }

    public void setCourseModuleId(Integer courseModuleId) {
        this.courseModuleId = courseModuleId;
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

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }
}
