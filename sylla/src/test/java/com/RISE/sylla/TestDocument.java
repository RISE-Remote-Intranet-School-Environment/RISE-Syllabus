package com.RISE.sylla;

import com.RISE.sylla.model.documentModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDocument {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testDocumentGet() throws Exception {
        mockMvc.perform(get("/document/documents")).andExpect(status().isOk());
    }

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Test
    public void testDocumentPost() throws Exception {
        String url = "/document/documents";
        documentModel document = new documentModel() ;
        document.setDocumentId(33l);
        document.setName("4268321");
        document.setAuthor("4268321");
        document.setPublishDate("4268321");
        document.setPages(33);
        document.setVersion("4268321");
        document.setPrice(33);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(document );

        mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDocumentIdGet() throws Exception {
        mockMvc.perform(get("/document/{documentId}", "1")).andExpect(status().isOk());
    }

    @Test
    public void testDocumentIdPut() throws Exception {
        String url = "/document/documents/{documentId}";
        String var = "2";
        documentModel document = new documentModel() ;
        document.setDocumentId(2l);
        document.setName("4268321");
        document.setAuthor("4268321");
        document.setPublishDate("4268321");
        document.setPages(33);
        document.setVersion("4268321");
        document.setPrice(33);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(document );

        mockMvc.perform(put(url, var).contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.documentId").value("2"))
                .andExpect(jsonPath("$.name").value("4268321"))
                .andExpect(jsonPath("$.author").value("4268321"))
                .andExpect(jsonPath("$.publishDate").value("4268321"))
                .andExpect(jsonPath("$.pages").value(33))
                .andExpect(jsonPath("$.version").value("4268321"))
                .andExpect(jsonPath("$.price").value(33));


        //mockMvc.perform(put("/document/documents/{documentId}","1")).andExpect(status().isOk());
    }

    @Test
    public void testDocumentDelete() throws Exception {
        mockMvc.perform(delete("/document/documents/{documentId}","1")).andExpect(status().isOk());
    }
}