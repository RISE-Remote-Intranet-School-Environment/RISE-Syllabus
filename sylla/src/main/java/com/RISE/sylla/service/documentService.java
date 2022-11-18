package com.RISE.sylla.service;

import com.RISE.sylla.model.userModel;
import com.RISE.sylla.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class documentService {
    @Autowired
    com.RISE.sylla.repository.documentRepository documentRepository;

    // CREATE
    public documentModel createDocument(documentModel document) {
        return decomentRepository.save(document);
    }

    // READ
    public List<documentModel> getDocument() {
        return documentRepository.findAll();
    }

    // DELETE
    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }

    // UPDATE
    public documentModel updateDocument(Long documentId, documentModel documentDetails) {
        documentModel document = documentRepository.findById(documentId).get();
        document.setFirstName(documentDetails.getFirstName());
        document.setLastName(documentDetails.getLastName());
        document.setEmailId(documentDetails.getEmailId());

        return documentRepository.save(document);
    }
}
