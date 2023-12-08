package com.RISE.sylla;

import com.RISE.sylla.controller.documentController;
import com.RISE.sylla.model.documentModel;
import com.RISE.sylla.service.documentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DeleteDocumentTest {
    @Mock
    private documentService documentService;

    @InjectMocks
    private documentController documentController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(documentController).build();
        this.objectMapper = new ObjectMapper();
    }


    @Test
    public void deleteDocumentTest() throws Exception {
        // Mocking the service layer to return a specific document by ID
        documentModel document1 = new documentModel();
        document1.setDocumentId(1L);
        document1.setName("Document1");
        document1.setAuthor("Teacher1");
        document1.setPublishDate("2022");
        document1.setPages(20);
        document1.setVersion("2022");
        document1.setPrice(22);
        when(documentService.getDocumentById(1L)).thenReturn(Optional.of(document1));

        documentModel newDocument = new documentModel();
        newDocument.setDocumentId(10L);
        newDocument.setName("Document2");
        newDocument.setAuthor("Teacher2");
        newDocument.setPublishDate("1990");
        newDocument.setPages(22);
        newDocument.setVersion("0.1");
        newDocument.setPrice(50);

        mockMvc.perform(post("/documents")
                        .content(objectMapper.writeValueAsString(newDocument))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        // Perform delete request to delete the newly added course
        mockMvc.perform(delete("/documents/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
