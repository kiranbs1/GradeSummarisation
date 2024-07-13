package com.kiran.b.s.GradeSummarisation.database.entities;

import com.kiran.b.s.GradeSummarisation.data.enums.FileAttachmentExt;
import com.kiran.b.s.GradeSummarisation.data.enums.FileAttachmentType;
import jakarta.persistence.*;

@Entity
public class FileAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileAttachmentId;
    @Column(nullable = false)
    private int assessmentId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FileAttachmentType fileAttachmentType;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FileAttachmentExt fileAttachmentExt;
    @Column(nullable = false)
    private String name;
    private String Description;
    @Basic(fetch = FetchType.LAZY)
    private byte[] attachment;

    public int getFileAttachmentId() {
        return fileAttachmentId;
    }

    public void setFileAttachmentId(int fileAttachmentId) {
        this.fileAttachmentId = fileAttachmentId;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
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
