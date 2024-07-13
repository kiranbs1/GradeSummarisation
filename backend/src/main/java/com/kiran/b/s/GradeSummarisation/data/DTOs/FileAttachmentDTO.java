package com.kiran.b.s.GradeSummarisation.data.DTOs;

import com.kiran.b.s.GradeSummarisation.data.enums.FileAttachmentExt;
import com.kiran.b.s.GradeSummarisation.data.enums.FileAttachmentType;

import java.io.File;

public class FileAttachmentDTO {

    private Integer fileAttachmentId;
    private Integer AssessmentId;
    private FileAttachmentType fileAttachmentType;
    private FileAttachmentExt fileAttachmentExt;
    private String name;
    private String Description;
    private byte[] attachment;

    public Integer getFileAttachmentId() {
        return fileAttachmentId;
    }

    public void setFileAttachmentId(Integer fileAttachmentId) {
        this.fileAttachmentId = fileAttachmentId;
    }

    public Integer getAssessmentId() {
        return AssessmentId;
    }

    public void setAssessmentId(Integer assessmentId) {
        AssessmentId = assessmentId;
    }

    public FileAttachmentType getFileAttachmentType() {
        return fileAttachmentType;
    }

    public void setFileAttachmentType(FileAttachmentType fileAttachmentType) {
        this.fileAttachmentType = fileAttachmentType;
    }

    public FileAttachmentExt getFileAttachmentExt() {
        return fileAttachmentExt;
    }

    public void setFileAttachmentExt(FileAttachmentExt fileAttachmentExt) {
        this.fileAttachmentExt = fileAttachmentExt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }
}
