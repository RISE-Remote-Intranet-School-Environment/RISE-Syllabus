package com.RISE.sylla.controller;

import com.RISE.sylla.model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("/document")
public class documentController {
    @Autowired
    documentService documentService;

    @RequestMapping(value="/documents", method= RequestMethod.POST)
    public documentModel createDocument(@RequestBody documentModel document) {
        return documentService.createDocument(document);
    }

    @RequestMapping(value="/documents", method=RequestMethod.GET)
    public List<documentModel> readDocuments() {
        return documentService.getDocuments();
    }

    @RequestMapping(value="/{documentId}", method=RequestMethod.GET)
    public Optional<documentModel> readDocumentById(@PathVariable(value = "documentId") Long id) {
        return documentService.getDocumentById(id);
    }

    @RequestMapping(value="/documents/{documentId}", method=RequestMethod.PUT)
    public documentModel readDocuments(@PathVariable(value = "documentId") Long id, @RequestBody documentModel documentDetails) {
        return documentService.updateDocument(id, documentDetails);
    }

    @RequestMapping(value="/documents/{documentId}", method=RequestMethod.DELETE)
    public void deleteDocument(@PathVariable(value = "documentId") Long id) {
        documentService.deleteDocument(id);
    }

}