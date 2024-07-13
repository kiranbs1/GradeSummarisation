package com.kiran.b.s.GradeSummarisation.database.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    @Column(nullable = false)
    private Integer userAccountId;
    @Column(nullable = false)
    private String name;
    private String description;
    private String institution;
    @OneToMany(mappedBy = "courseId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<CourseYear> courseYears;

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

    public List<CourseYear> getCourseYears() {
        return courseYears;
    }

    public void setCourseYears(List<CourseYear> courseYears) {
        this.courseYears = courseYears;
    }
}
