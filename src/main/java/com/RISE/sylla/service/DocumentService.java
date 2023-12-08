package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.DocumentModel;
import com.RISE.sylla.repository.DocumentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    // CREATE
    public DocumentModel createDocument(DocumentModel document) {
        return documentRepository.save(document);
    }

    // READ
    public List<DocumentModel> getDocuments() {
        return documentRepository.findAll();
    }

    //READ by id
    public Optional<DocumentModel> getDocumentById(Long Id){return documentRepository.findById(Id);}

    // DELETE
    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }

    // UPDATE
    public DocumentModel updateDocument(Long documentId, DocumentModel documentDetails) {
        DocumentModel document = documentRepository.findById(documentId).get();
        document.setName(documentDetails.getName());
        document.setAuthor(documentDetails.getAuthor());
        document.setPublishDate(documentDetails.getPublishDate());
        document.setPages(documentDetails.getPages());
        document.setVersion(documentDetails.getVersion());
        document.setPrice(documentDetails.getPrice());

        return documentRepository.save(document);
    }
}
