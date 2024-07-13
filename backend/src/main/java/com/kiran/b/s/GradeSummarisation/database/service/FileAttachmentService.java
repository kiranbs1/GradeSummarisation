package com.kiran.b.s.GradeSummarisation.database.service;

import com.kiran.b.s.GradeSummarisation.database.entities.FileAttachment;
import com.kiran.b.s.GradeSummarisation.database.repository.FileAttachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class FileAttachmentService {

    @Autowired
    private FileAttachmentRepo fileAttachmentRepository;

    public Optional<FileAttachment> findById(int id) {
        return fileAttachmentRepository.findById(id);
    }

    public FileAttachment save(FileAttachment fileAttachment) {
        return fileAttachmentRepository.save(fileAttachment);
    }

    public void delete(int id) {
        fileAttachmentRepository.deleteById(id);
    }
}
