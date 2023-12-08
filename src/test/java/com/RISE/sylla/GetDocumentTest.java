package com.RISE.sylla;

import com.RISE.sylla.controller.DocumentController;
import com.RISE.sylla.model.DocumentModel;
import com.RISE.sylla.service.DocumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class GetDocumentTest{
    @Mock
    private DocumentService documentService;

    @InjectMocks
    private DocumentController documentController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(documentController).build();
    }


    @Test
    public void testGetDocumentById() throws Exception {
        // Mocking the service layer to return a specific document by ID
        DocumentModel document = new DocumentModel();
        document.setDocumentId(1L);
        document.setName("Document1");
        document.setAuthor("Teacher1");
        document.setPublishDate("2022");
        document.setPages(20);
        document.setVersion("2022");
        document.setPrice(22);
        when(documentService.getDocumentById(1L)).thenReturn(Optional.of(document));

        // Perform the GET request and validate the response
        mockMvc.perform(get("/documents/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.documentId").value(1))
                .andExpect(jsonPath("$.name").value("Document1"));
    }

    @Test
    public void testGetAllCourses() throws Exception {
        //Create 2 new courses
        DocumentModel document1 = new DocumentModel();
        document1.setDocumentId(1L);
        document1.setName("Document1");
        document1.setAuthor("Teacher1");
        document1.setPublishDate("2022");
        document1.setPages(20);
        document1.setVersion("2022");
        document1.setPrice(22);

        DocumentModel document2 = new DocumentModel();
        document2.setDocumentId(2L);
        document2.setName("Document2");
        document2.setAuthor("Teacher2");
        document2.setPublishDate("1990");
        document2.setPages(22);
        document2.setVersion("0.1");
        document2.setPrice(50);

        // Mocking the service layer to return a list of documents
        List<DocumentModel> documents = Arrays.asList(
                document1,
                document2
        );

        when(documentService.getDocuments()).thenReturn(documents);

        // Perform the GET request and validate the response
        mockMvc.perform(get("/documents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].documentId").value(1))
                .andExpect(jsonPath("$[0].name").value("Document1"))
                .andExpect(jsonPath("$[1].documentId").value(2))
                .andExpect(jsonPath("$[1].name").value("Document2"));
    }
}
