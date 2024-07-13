package com.kiran.b.s.GradeSummarisation.database.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CourseYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseYearId;
    @Column(nullable = false)
    private Integer courseId;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private int yearNumber;
    private float yearWeight;
    @OneToMany(mappedBy = "courseYearId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<CourseModule> courseModules;

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

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public float getYearWeight() {
        return yearWeight;
    }

    public void setYearWeight(float yearWeight) {
        this.yearWeight = yearWeight;
    }

    public List<CourseModule> getCourseModules() {
        return courseModules;
    }

    public void setCourseModules(List<CourseModule> courseModules) {
        this.courseModules = courseModules;
    }
}
