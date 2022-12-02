package com.RISE.sylla.service;

import com.RISE.sylla.model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.documentModel;
import com.RISE.sylla.repository.documentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class documentService {
    @Autowired
    documentRepository documentRepository;

    // CREATE
    public documentModel createDocument(documentModel document) {
        return documentRepository.save(document);
    }

    // READ
    public List<documentModel> getDocuments() {
        return documentRepository.findAll();
    }

    //READ by id
    public Optional<documentModel> getDocumentById(Long userId){return documentRepository.findById(userId);}

    // DELETE
    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }

    // UPDATE
    public documentModel updateDocument(Long documentId, documentModel documentDetails) {
        documentModel document = documentRepository.findById(documentId).get();
        document.setName(documentDetails.getName());
        document.setAuthor(documentDetails.getAuthor());
        document.setPublishDate(documentDetails.getPublishDate());
        document.setPages(documentDetails.getPages());
        document.setVersion(documentDetails.getVersion());
        document.setPrice(documentDetails.getPrice());

        return documentRepository.save(document);
    }
}
