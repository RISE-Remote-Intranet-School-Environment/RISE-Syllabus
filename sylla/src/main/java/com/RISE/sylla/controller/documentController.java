package com.RISE.sylla.controller;

import com.RISE.sylla.model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.documentModel;
import com.RISE.sylla.service.documentService;

@RestController
@RequestMapping("/documents")
public class documentController {
    @Autowired
    public List<documentModel> order;
    public float Totalprice;
    documentService documentService;


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
    public documentModel createDocument(@RequestBody documentModel document) {
        return documentService.createDocument(document);
    }

    /**
     * @return all the documents
     */
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<documentModel> readDocuments() {
        return documentService.getDocuments();
    }



    /**
     * return a specific document by its id
     *
     * @param id id of the document to be returned
     * @return the document which has the provided id
     */
    @RequestMapping(value="/{documentId}", method=RequestMethod.GET)
    public Optional<documentModel> readDocumentById(@PathVariable(value = "documentId") Long id) {
        return documentService.getDocumentById(id);
    }

    @RequestMapping(value="/catalogue/{documentId}", method=RequestMethod.GET)
    public void addDocumenttoorder(@PathVariable(value = "documentId") Long id) {
        documentModel document = readDocumentById(id).get();
         order.add(document);
         addtototalprice(document.getPrice());
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
    public documentModel updateDocuments(@PathVariable(value = "documentId") Long id, @RequestBody documentModel documentDetails) {
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