package com.kiran.b.s.GradeSummarisation.data.mappers;

import com.kiran.b.s.GradeSummarisation.data.DTOs.*;
import com.kiran.b.s.GradeSummarisation.database.entities.*;

import java.util.Comparator;
import java.util.stream.Collectors;

public class DTOMapper {

    public static AccountDTO toAccountDTO(Account account) {
        if (account == null)
            return null;

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserAccountId(account.getUserAccountId());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setClientReg(account.getClientReg());
        accountDTO.setOauthId(account.getOauthId());
        if (account.getCourses() != null) {
            accountDTO.setCourses(account.getCourses().stream()
                    .sorted(Comparator.comparing(Course::getCourseId))
                    .map(DTOMapper::toCourseDTO)
                    .collect(Collectors.toList()));
        }
        return accountDTO;
    }



    public static CourseDTO toCourseDTO(Course course) {
        if (course == null) return null;

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setUserAccountId(course.getUserAccountId()); // Reference to parent Account ID
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setInstitution(course.getInstitution());
        if (course.getCourseYears() != null) {
            courseDTO.setCourseYears(course.getCourseYears().stream()
                    .sorted(Comparator.comparing(CourseYear::getYearNumber))
                    .map(DTOMapper::toCourseYearDTO)
                    .collect(Collectors.toList()));
        }
        return courseDTO;
    }


    public static CourseYearDTO toCourseYearDTO(CourseYear courseYear) {
        if (courseYear == null) return null;

        CourseYearDTO courseYearDTO = new CourseYearDTO();
        courseYearDTO.setCourseYearId(courseYear.getCourseYearId());
        courseYearDTO.setCourseId(courseYear.getCourseId()); // Reference to parent Course ID
        courseYearDTO.setName(courseYear.getName());
        courseYearDTO.setDescription(courseYear.getDescription());
        courseYearDTO.setYearWeight(courseYear.getYearWeight());
        courseYearDTO.setYearNumber(courseYear.getYearNumber());
        if (courseYear.getCourseModules() != null) {
            courseYearDTO.setCourseModules(courseYear.getCourseModules().stream()
                    .sorted(Comparator.comparing(CourseModule::getCourseModuleId))
                    .map(DTOMapper::toCourseModuleDTO)
                    .collect(Collectors.toList()));
        }
        return courseYearDTO;
    }

    public static CourseModuleDTO toCourseModuleDTO(CourseModule courseModule) {
        if (courseModule == null) return null;

        CourseModuleDTO courseModuleDTO = new CourseModuleDTO();
        courseModuleDTO.setModuleId(courseModule.getCourseModuleId());
        courseModuleDTO.setCourseYearId(courseModule.getCourseYearId()); // Reference to parent CourseYear ID
        courseModuleDTO.setName(courseModule.getName());
        courseModuleDTO.setDescription(courseModule.getDescription());
        courseModuleDTO.setModuleWeight(courseModule.getModuleWeight());
        if (courseModule.getAssessments() != null) {
            courseModuleDTO.setAssessments(courseModule.getAssessments().stream()
                    .sorted(Comparator.comparing(Assessment::getAssessmentId))
                    .map(DTOMapper::toAssessmentDTO)
                    .collect(Collectors.toList()));
        }
        return courseModuleDTO;
    }

    public static AssessmentDTO toAssessmentDTO(Assessment assessment) {
        if (assessment == null) return null;

        AssessmentDTO assessmentDTO = new AssessmentDTO();
        assessmentDTO.setAssessmentId(assessment.getAssessmentId());
        assessmentDTO.setCourseModuleId(assessment.getCourseModuleId()); // Reference to parent Module ID
        assessmentDTO.setName(assessment.getName());
        assessmentDTO.setDescription(assessment.getDescription());
        assessmentDTO.setAssessmentType(assessment.getAssessmentType());
        assessmentDTO.setMark(assessment.getMark());
        assessmentDTO.setCompleted(assessment.isCompleted());
        assessmentDTO.setAssessmentWeight(assessment.getAssessmentWeight());
        if (assessment.getFileAttachments() != null) {
            assessmentDTO.setFileAttachments(assessment.getFileAttachments().stream()
                    .sorted(Comparator.comparing(FileAttachment::getFileAttachmentId))
                    .map(DTOMapper::toFileAttachmentDTO)
                    .collect(Collectors.toList()));
        }
        return assessmentDTO;
    }

    public static FileAttachmentDTO toFileAttachmentDTO(FileAttachment fileAttachment) {
        if (fileAttachment == null) return null;

        FileAttachmentDTO fileAttachmentDTO = new FileAttachmentDTO();
        fileAttachmentDTO.setFileAttachmentId(fileAttachmentDTO.getFileAttachmentId());
        fileAttachmentDTO.setAssessmentId(fileAttachmentDTO.getAssessmentId());
        fileAttachmentDTO.setFileAttachmentExt(fileAttachmentDTO.getFileAttachmentExt());
        fileAttachmentDTO.setFileAttachmentType(fileAttachmentDTO.getFileAttachmentType());
        fileAttachmentDTO.setName(fileAttachmentDTO.getName());
        fileAttachmentDTO.setDescription(fileAttachmentDTO.getDescription());
        fileAttachmentDTO.setAttachment(fileAttachmentDTO.getAttachment());

        return fileAttachmentDTO;
    }
}
