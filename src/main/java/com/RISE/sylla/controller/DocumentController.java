package com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.DocumentModel;
import com.RISE.sylla.service.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    DocumentService documentService;
    public List<DocumentModel> order;
    public float Totalprice;

    public DocumentController(DocumentService documentService, List<DocumentModel> order) {
        this.documentService = documentService;
        this.order = order != null ? order : new ArrayList<>(); // Initialisation sécurisée
    }

    /**
     * POST method '/documents' creating document with params

     * body needs to look like :    {
     *               "name": "mathematics",
     *               "author": "arthur",
     *               "publishDate": 110923,
     *               "pages": 50,
     *               "version": 1.0,
     *               "price": 10
     *          }
     *
     * @param document document to be posted
     * @return the posted document
     */
    @RequestMapping(value="", method= RequestMethod.POST)
    public DocumentModel createDocument(@RequestBody DocumentModel document) {
        return documentService.createDocument(document);
    }

    /**
     * @return all the documents
     */
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<DocumentModel> readDocuments() {
        return documentService.getDocuments();
    }



    /**
     * return a specific document by its id
     *
     * @param id id of the document to be returned
     * @return the document which has the provided id
     */
    @RequestMapping(value="/{documentId}", method=RequestMethod.GET)
    public Optional<DocumentModel> readDocumentById(@PathVariable(value = "documentId") Long id) {
        return documentService.getDocumentById(id);
    }


    public void addtototalprice(float price){
        Totalprice+= price;
    }

    /**
     * update a document which already exists
     *
     * body needs to look like :    {
     *               "documentId":1,
     *               "name":1,
     *               "author":1,
     *               "publishDate":1,
     *               "pages":1,
     *               "version":1,
     *               "price":1
     *           }
     * @param id id of the document to be updated
     * @param documentDetails new document data
     * @return the updated document
     */
    @RequestMapping(value="/{documentId}", method=RequestMethod.PUT)
    public DocumentModel updateDocuments(@PathVariable(value = "documentId") Long id, @RequestBody DocumentModel documentDetails) {
        return documentService.updateDocument(id, documentDetails);
    }

    /**
     * delete a document
     *
     * @param id id of the document to be deleted
     */
    @RequestMapping(value="/{documentId}", method=RequestMethod.DELETE)
    public void deleteDocument(@PathVariable(value = "documentId") Long id) {
        documentService.deleteDocument(id);
    }

}