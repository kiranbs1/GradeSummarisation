package com.kiran.b.s.GradeSummarisation.data.mappers;

import com.kiran.b.s.GradeSummarisation.data.DTOs.*;
import com.kiran.b.s.GradeSummarisation.data.enums.AssessmentType;
import com.kiran.b.s.GradeSummarisation.data.enums.FileAttachmentExt;
import com.kiran.b.s.GradeSummarisation.data.enums.FileAttachmentType;
import com.kiran.b.s.GradeSummarisation.database.entities.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EntityMapperTest {

    @Test
    void testToAccount() {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(1);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail("test@example.com");
        accountDTO.setClientReg("clientReg");
        accountDTO.setOauthId(1);
        accountDTO.setCourses(Collections.singletonList(courseDTO));

        Account account = EntityMapper.toAccount(accountDTO);

        assertNotNull(account);
        assertEquals(accountDTO.getEmail(), account.getEmail());
        assertEquals(accountDTO.getClientReg(), account.getClientReg());
        assertEquals(accountDTO.getOauthId(), account.getOauthId());
        assertNotNull(account.getCourses());
        assertEquals(1, account.getCourses().size());
    }

    @Test
    void testToCourse() {
        CourseYearDTO courseYearDTO = new CourseYearDTO();
        courseYearDTO.setYearNumber(1);

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(1);
        courseDTO.setUserAccountId(1);
        courseDTO.setName("Course Name");
        courseDTO.setDescription("Description");
        courseDTO.setInstitution("Institution");
        courseDTO.setCourseYears(Collections.singletonList(courseYearDTO));

        Course course = EntityMapper.toCourse(courseDTO);

        assertNotNull(course);
        assertEquals(courseDTO.getCourseId(), course.getCourseId());
        assertEquals(courseDTO.getUserAccountId(), course.getUserAccountId());
        assertEquals(courseDTO.getName(), course.getName());
        assertEquals(courseDTO.getDescription(), course.getDescription());
        assertEquals(courseDTO.getInstitution(), course.getInstitution());
        assertNotNull(course.getCourseYears());
        assertEquals(1, course.getCourseYears().size());
    }

    @Test
    void testToCourseYear() {
        CourseModuleDTO courseModuleDTO = new CourseModuleDTO();
        courseModuleDTO.setModuleId(1);

        CourseYearDTO courseYearDTO = new CourseYearDTO();
        courseYearDTO.setCourseYearId(1);
        courseYearDTO.setCourseId(1);
        courseYearDTO.setName("Year 1");
        courseYearDTO.setDescription("Description");
        courseYearDTO.setYearWeight(0.5f);
        courseYearDTO.setYearNumber(1);
        courseYearDTO.setCourseModules(Collections.singletonList(courseModuleDTO));

        CourseYear courseYear = EntityMapper.toCourseYear(courseYearDTO);

        assertNotNull(courseYear);
        assertEquals(courseYearDTO.getCourseYearId(), courseYear.getCourseYearId());
        assertEquals(courseYearDTO.getCourseId(), courseYear.getCourseId());
        assertEquals(courseYearDTO.getName(), courseYear.getName());
        assertEquals(courseYearDTO.getDescription(), courseYear.getDescription());
        assertEquals(courseYearDTO.getYearWeight(), courseYear.getYearWeight());
        assertEquals(courseYearDTO.getYearNumber(), courseYear.getYearNumber());
        assertNotNull(courseYear.getCourseModules());
        assertEquals(1, courseYear.getCourseModules().size());
    }

    @Test
    void testToCourseModule() {
        AssessmentDTO assessmentDTO = new AssessmentDTO();
        assessmentDTO.setAssessmentId(1);

        CourseModuleDTO courseModuleDTO = new CourseModuleDTO();
        courseModuleDTO.setModuleId(1);
        courseModuleDTO.setCourseYearId(1);
        courseModuleDTO.setName("Module 1");
        courseModuleDTO.setDescription("Description");
        courseModuleDTO.setModuleWeight(0.3f);
        courseModuleDTO.setAssessments(Collections.singletonList(assessmentDTO));

        CourseModule courseModule = EntityMapper.toCourseModule(courseModuleDTO);

        assertNotNull(courseModule);
        assertEquals(courseModuleDTO.getModuleId(), courseModule.getCourseModuleId());
        assertEquals(courseModuleDTO.getCourseYearId(), courseModule.getCourseYearId());
        assertEquals(courseModuleDTO.getName(), courseModule.getName());
        assertEquals(courseModuleDTO.getDescription(), courseModule.getDescription());
        assertEquals(courseModuleDTO.getModuleWeight(), courseModule.getModuleWeight());
        assertNotNull(courseModule.getAssessments());
        assertEquals(1, courseModule.getAssessments().size());
    }

    @Test
    void testToAssessment() {
        FileAttachmentDTO fileAttachmentDTO = new FileAttachmentDTO();
        fileAttachmentDTO.setFileAttachmentId(1);

        AssessmentDTO assessmentDTO = new AssessmentDTO();
        assessmentDTO.setAssessmentId(1);
        assessmentDTO.setCourseModuleId(1);
        assessmentDTO.setName("Assessment 1");
        assessmentDTO.setDescription("Description");
        assessmentDTO.setAssessmentType(AssessmentType.EXAM);
        assessmentDTO.setMark(95.5f);
        assessmentDTO.setCompleted(true);
        assessmentDTO.setAssessmentWeight(0.2f);
        assessmentDTO.setFileAttachments(Collections.singletonList(fileAttachmentDTO));

        Assessment assessment = EntityMapper.toAssessment(assessmentDTO);

        assertNotNull(assessment);
        assertEquals(assessmentDTO.getAssessmentId(), assessment.getAssessmentId());
        assertEquals(assessmentDTO.getCourseModuleId(), assessment.getCourseModuleId());
        assertEquals(assessmentDTO.getName(), assessment.getName());
        assertEquals(assessmentDTO.getDescription(), assessment.getDescription());
        assertEquals(assessmentDTO.getAssessmentType(), assessment.getAssessmentType());
        assertEquals(assessmentDTO.getMark(), assessment.getMark());
        assertTrue(assessment.isCompleted());
        assertEquals(assessmentDTO.getAssessmentWeight(), assessment.getAssessmentWeight());
        assertNotNull(assessment.getFileAttachments());
        assertEquals(1, assessment.getFileAttachments().size());
    }

    @Test
    void testToFileAttachment() {
        FileAttachmentDTO fileAttachmentDTO = new FileAttachmentDTO();
        fileAttachmentDTO.setFileAttachmentId(1);
        fileAttachmentDTO.setAssessmentId(1);
        fileAttachmentDTO.setFileAttachmentExt(FileAttachmentExt.pdf);
        fileAttachmentDTO.setFileAttachmentType(FileAttachmentType.BRIEF);
        fileAttachmentDTO.setName("Attachment");
        fileAttachmentDTO.setDescription("Description");
        fileAttachmentDTO.setAttachment(new byte[]{1, 2, 3});

        FileAttachment fileAttachment = EntityMapper.toFileAttachment(fileAttachmentDTO);

        assertNotNull(fileAttachment);
        assertEquals(fileAttachmentDTO.getFileAttachmentId(), fileAttachment.getFileAttachmentId());
        assertEquals(fileAttachmentDTO.getAssessmentId(), fileAttachment.getAssessmentId());
        assertEquals(fileAttachmentDTO.getFileAttachmentExt(), fileAttachment.getFileAttachmentExt());
        assertEquals(fileAttachmentDTO.getFileAttachmentType(), fileAttachment.getFileAttachmentType());
        assertEquals(fileAttachmentDTO.getName(), fileAttachment.getName());
        assertEquals(fileAttachmentDTO.getDescription(), fileAttachment.getDescription());
        assertArrayEquals(fileAttachmentDTO.getAttachment(), fileAttachment.getAttachment());
    }

}