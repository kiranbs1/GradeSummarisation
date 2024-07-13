package com.kiran.b.s.GradeSummarisation.data.DTOs;

import com.kiran.b.s.GradeSummarisation.data.enums.AssessmentType;

import java.util.List;

public class AssessmentDTO {

    private Integer assessmentId;
    private Integer courseModuleId;
    private String name;
    private String description;
    private float mark;
    private AssessmentType assessmentType;
    private float assessmentWeight;
    private boolean completed;
    private List<FileAttachmentDTO> fileAttachments;

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

    public List<FileAttachmentDTO> getFileAttachments() {
        return fileAttachments;
    }

    public void setFileAttachments(List<FileAttachmentDTO> fileAttachments) {
        this.fileAttachments = fileAttachments;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
