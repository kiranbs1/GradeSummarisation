package com.kiran.b.s.GradeSummarisation.database.entities;

import com.kiran.b.s.GradeSummarisation.data.enums.AssessmentType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assessmentId;
    @Column(nullable = false)
    private Integer courseModuleId;
    @Column(nullable = false)
    private String name;
    private String description;
    private float mark;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssessmentType assessmentType;
    private float assessmentWeight;
    @Column(nullable = false)
    private boolean completed;
    @OneToMany(mappedBy = "assessmentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<FileAttachment> fileAttachments;

    public Integer getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Integer getCourseModuleId() {
        return courseModuleId;
    }

    public void setCourseModuleId(Integer courseModuleId) {
        this.courseModuleId = courseModuleId;
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

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(AssessmentType assessmentType) {
        this.assessmentType = assessmentType;
    }

    public float getAssessmentWeight() {
        return assessmentWeight;
    }

    public void setAssessmentWeight(float assessmentWeight) {
        this.assessmentWeight = assessmentWeight;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<FileAttachment> getFileAttachments() {
        return fileAttachments;
    }

    public void setFileAttachments(List<FileAttachment> fileAttachments) {
        this.fileAttachments = fileAttachments;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
