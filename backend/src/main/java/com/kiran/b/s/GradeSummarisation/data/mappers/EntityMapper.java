package com.kiran.b.s.GradeSummarisation.data.mappers;

import com.kiran.b.s.GradeSummarisation.data.DTOs.*;
import com.kiran.b.s.GradeSummarisation.database.entities.*;

import java.util.stream.Collectors;

public class EntityMapper {
    public static Account toAccount(AccountDTO accountDTO) {
        if (accountDTO == null) return null;

        Account account = new Account();
        account.setEmail(accountDTO.getEmail());
        account.setClientReg(accountDTO.getClientReg());
        account.setOauthId(accountDTO.getOauthId());
        if (accountDTO.getCourses() != null) {
            account.setCourses(accountDTO.getCourses().stream()
                    .map(EntityMapper::toCourse)
                    .collect(Collectors.toList()));
        }
        return account;
    }

    public static Course toCourse(CourseDTO courseDTO) {
        if (courseDTO == null) return null;

        Course course = new Course();
        course.setCourseId(courseDTO.getCourseId());
        course.setUserAccountId(courseDTO.getUserAccountId());
        // Need to set the parent account reference in the parent entity, usually handled by persistence context
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setInstitution(courseDTO.getInstitution());
        if (courseDTO.getCourseYears() != null) {
            course.setCourseYears(courseDTO.getCourseYears().stream()
                    .map(EntityMapper::toCourseYear)
                    .collect(Collectors.toList()));
        }
        return course;
    }

    public static CourseYear toCourseYear(CourseYearDTO courseYearDTO) {
        if (courseYearDTO == null) return null;

        CourseYear courseYear = new CourseYear();
        courseYear.setCourseYearId(courseYearDTO.getCourseYearId());
        courseYear.setCourseId(courseYearDTO.getCourseId());
        // Need to set the parent course reference in the parent entity, usually handled by persistence context
        courseYear.setName(courseYearDTO.getName());
        courseYear.setDescription(courseYearDTO.getDescription());
        courseYear.setYearWeight(courseYearDTO.getYearWeight());
        courseYear.setYearNumber(courseYearDTO.getYearNumber());
        if (courseYearDTO.getCourseModules() != null) {
            courseYear.setCourseModules(courseYearDTO.getCourseModules().stream()
                    .map(EntityMapper::toCourseModule)
                    .collect(Collectors.toList()));
        }
        return courseYear;
    }

    public static CourseModule toCourseModule(CourseModuleDTO courseModuleDTO) {
        if (courseModuleDTO == null) return null;

        CourseModule courseModule = new CourseModule();
        courseModule.setCourseModuleId(courseModuleDTO.getModuleId());
        courseModule.setCourseYearId(courseModuleDTO.getCourseYearId());
        // Need to set the parent course year reference in the parent entity, usually handled by persistence context
        courseModule.setName(courseModuleDTO.getName());
        courseModule.setDescription(courseModuleDTO.getDescription());
        courseModule.setModuleWeight(courseModuleDTO.getModuleWeight());
        if (courseModuleDTO.getAssessments() != null) {
            courseModule.setAssessments(courseModuleDTO.getAssessments().stream()
                    .map(EntityMapper::toAssessment)
                    .collect(Collectors.toList()));
        }
        return courseModule;
    }

    public static Assessment toAssessment(AssessmentDTO assessmentDTO) {
        if (assessmentDTO == null) return null;

        Assessment assessment = new Assessment();
        assessment.setAssessmentId(assessmentDTO.getAssessmentId());
        assessment.setCourseModuleId(assessmentDTO.getCourseModuleId());
        // Need to set the parent course module reference in the parent entity, usually handled by persistence context
        assessment.setName(assessmentDTO.getName());
        assessment.setDescription(assessmentDTO.getDescription());
        assessment.setAssessmentType(assessmentDTO.getAssessmentType());
        assessment.setMark(assessmentDTO.getMark());
        assessment.setCompleted(assessmentDTO.isCompleted());
        assessment.setAssessmentWeight(assessmentDTO.getAssessmentWeight());
        if (assessmentDTO.getFileAttachments() != null) {
            assessment.setFileAttachments(assessmentDTO.getFileAttachments().stream()
                    .map(EntityMapper::toFileAttachment)
                    .collect(Collectors.toList()));
        }
        return assessment;
    }

    public static FileAttachment toFileAttachment(FileAttachmentDTO fileAttachmentDTO) {
        if (fileAttachmentDTO == null) return null;

        FileAttachment fileAttachment = new FileAttachment();
        fileAttachment.setFileAttachmentId(fileAttachmentDTO.getFileAttachmentId());
        fileAttachment.setAssessmentId(fileAttachmentDTO.getAssessmentId());
        fileAttachment.setFileAttachmentExt(fileAttachmentDTO.getFileAttachmentExt());
        fileAttachment.setFileAttachmentType(fileAttachmentDTO.getFileAttachmentType());
        fileAttachment.setName(fileAttachmentDTO.getName());
        fileAttachment.setDescription(fileAttachmentDTO.getDescription());
        fileAttachment.setAttachment(fileAttachmentDTO.getAttachment());

        return fileAttachment;
    }
}
