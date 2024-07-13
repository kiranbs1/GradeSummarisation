package com.kiran.b.s.GradeSummarisation.database.repository;

import com.kiran.b.s.GradeSummarisation.database.entities.FileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileAttachmentRepo extends JpaRepository<FileAttachment, Integer> {
    // You can add custom query methods here if needed
}

