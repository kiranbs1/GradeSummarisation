package com.kiran.b.s.GradeSummarisation.data.mappers;

import com.kiran.b.s.GradeSummarisation.data.DTOs.*;
import com.kiran.b.s.GradeSummarisation.data.enums.AssessmentType;
import com.kiran.b.s.GradeSummarisation.data.enums.FileAttachmentExt;
import com.kiran.b.s.GradeSummarisation.data.enums.FileAttachmentType;
import com.kiran.b.s.GradeSummarisation.database.entities.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DTOMapperTest {

    @Test
    void testToAccountDTO() {
        Course course = new Course();
        course.setCourseId(1);

        Account account = new Account();
        account.setUserAccountId(1);
        account.setEmail("test@example.com");
        account.setClientReg("clientReg");
        account.setOauthId(2);
        account.setCourses(Collections.singletonList(course));

        AccountDTO accountDTO = DTOMapper.toAccountDTO(account);

        assertNotNull(accountDTO);
        assertEquals(account.getUserAccountId(), accountDTO.getUserAccountId());
        assertEquals(account.getEmail(), accountDTO.getEmail());
        assertEquals(account.getClientReg(), accountDTO.getClientReg());
        assertEquals(account.getOauthId(), accountDTO.getOauthId());
        assertNotNull(accountDTO.getCourses());
        assertEquals(1, accountDTO.getCourses().size());
    }

    @Test
    void testToCourseDTO() {
        CourseYear courseYear = new CourseYear();
        courseYear.setYearNumber(1);

        Course course = new Course();
        course.setCourseId(1);
        course.setUserAccountId(1);
        course.setName("Course Name");
        course.setDescription("Description");
        course.setInstitution("Institution");
        course.setCourseYears(Collections.singletonList(courseYear));

        CourseDTO courseDTO = DTOMapper.toCourseDTO(course);

        assertNotNull(courseDTO);
        assertEquals(course.getCourseId(), courseDTO.getCourseId());
        assertEquals(course.getUserAccountId(), courseDTO.getUserAccountId());
        assertEquals(course.getName(), courseDTO.getName());
        assertEquals(course.getDescription(), courseDTO.getDescription());
        assertEquals(course.getInstitution(), courseDTO.getInstitution());
        assertNotNull(courseDTO.getCourseYears());
        assertEquals(1, courseDTO.getCourseYears().size());
    }

    @Test
    void testToCourseYearDTO() {
        CourseModule courseModule = new CourseModule();
        courseModule.setCourseModuleId(1);

        CourseYear courseYear = new CourseYear();
        courseYear.setCourseYearId(1);
        courseYear.setCourseId(1);
        courseYear.setName("Year 1");
        courseYear.setDescription("Description");
        courseYear.setYearWeight(0.5f);
        courseYear.setYearNumber(1);
        courseYear.setCourseModules(Collections.singletonList(courseModule));

        CourseYearDTO courseYearDTO = DTOMapper.toCourseYearDTO(courseYear);

        assertNotNull(courseYearDTO);
        assertEquals(courseYear.getCourseYearId(), courseYearDTO.getCourseYearId());
        assertEquals(courseYear.getCourseId(), courseYearDTO.getCourseId());
        assertEquals(courseYear.getName(), courseYearDTO.getName());
        assertEquals(courseYear.getDescription(), courseYearDTO.getDescription());
        assertEquals(courseYear.getYearWeight(), courseYearDTO.getYearWeight());
        assertEquals(courseYear.getYearNumber(), courseYearDTO.getYearNumber());
        assertNotNull(courseYearDTO.getCourseModules());
        assertEquals(1, courseYearDTO.getCourseModules().size());
    }

    @Test
    void testToCourseModuleDTO() {
        Assessment assessment = new Assessment();
        assessment.setAssessmentId(1);

        CourseModule courseModule = new CourseModule();
        courseModule.setCourseModuleId(1);
        courseModule.setCourseYearId(1);
        courseModule.setName("Module 1");
        courseModule.setDescription("Description");
        courseModule.setModuleWeight(0.3f);
        courseModule.setAssessments(Collections.singletonList(assessment));

        CourseModuleDTO courseModuleDTO = DTOMapper.toCourseModuleDTO(courseModule);

        assertNotNull(courseModuleDTO);
        assertEquals(courseModule.getCourseModuleId(), courseModuleDTO.getModuleId());
        assertEquals(courseModule.getCourseYearId(), courseModuleDTO.getCourseYearId());
        assertEquals(courseModule.getName(), courseModuleDTO.getName());
        assertEquals(courseModule.getDescription(), courseModuleDTO.getDescription());
        assertEquals(courseModule.getModuleWeight(), courseModuleDTO.getModuleWeight());
        assertNotNull(courseModuleDTO.getAssessments());
        assertEquals(1, courseModuleDTO.getAssessments().size());
    }

    @Test
    void testToAssessmentDTO() {
        FileAttachment fileAttachment = new FileAttachment();
        fileAttachment.setFileAttachmentId(1);

        Assessment assessment = new Assessment();
        assessment.setAssessmentId(1);
        assessment.setCourseModuleId(1);
        assessment.setName("Assessment 1");
        assessment.setDescription("Description");
        assessment.setAssessmentType(AssessmentType.EXAM);
        assessment.setMark(95.5f);
        assessment.setCompleted(true);
        assessment.setAssessmentWeight(0.2f);
        assessment.setFileAttachments(Collections.singletonList(fileAttachment));

        AssessmentDTO assessmentDTO = DTOMapper.toAssessmentDTO(assessment);

        assertNotNull(assessmentDTO);
        assertEquals(assessment.getAssessmentId(), assessmentDTO.getAssessmentId());
        assertEquals(assessment.getCourseModuleId(), assessmentDTO.getCourseModuleId());
        assertEquals(assessment.getName(), assessmentDTO.getName());
        assertEquals(assessment.getDescription(), assessmentDTO.getDescription());
        assertEquals(assessment.getAssessmentType(), assessmentDTO.getAssessmentType());
        assertEquals(assessment.getMark(), assessmentDTO.getMark());
        assertTrue(assessmentDTO.isCompleted());
        assertEquals(assessment.getAssessmentWeight(), assessmentDTO.getAssessmentWeight());
        assertNotNull(assessmentDTO.getFileAttachments());
        assertEquals(1, assessmentDTO.getFileAttachments().size());
    }

    @Test
    void testToFileAttachmentDTO() {
        FileAttachment fileAttachment = new FileAttachment();
        fileAttachment.setFileAttachmentId(1);
        fileAttachment.setAssessmentId(1);
        fileAttachment.setFileAttachmentExt(FileAttachmentExt.pdf);
        fileAttachment.setFileAttachmentType(FileAttachmentType.BRIEF);
        fileAttachment.setName("Attachment");
        fileAttachment.setDescription("Description");
        fileAttachment.setAttachment(new byte[]{1, 2, 3});

        FileAttachmentDTO fileAttachmentDTO = DTOMapper.toFileAttachmentDTO(fileAttachment);

        assertNotNull(fileAttachmentDTO);
        assertEquals(fileAttachment.getFileAttachmentId(), fileAttachmentDTO.getFileAttachmentId());
        assertEquals(fileAttachment.getAssessmentId(), fileAttachmentDTO.getAssessmentId());
        assertEquals(fileAttachment.getFileAttachmentExt(), fileAttachmentDTO.getFileAttachmentExt());
        assertEquals(fileAttachment.getFileAttachmentType(), fileAttachmentDTO.getFileAttachmentType());
        assertEquals(fileAttachment.getName(), fileAttachmentDTO.getName());
        assertEquals(fileAttachment.getDescription(), fileAttachmentDTO.getDescription());
        assertArrayEquals(fileAttachment.getAttachment(), fileAttachmentDTO.getAttachment());
    }
}