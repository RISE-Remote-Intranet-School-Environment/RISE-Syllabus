package com.RISE.sylla;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DeleteCourseTest extends SyllaApplicationTests {
    @Value("${server.port}")
    private int port;
    @Autowired
    private MockMvc mvc;

    DeleteCourseTest() {
    }

    @Test
    public void deleteCourseTest() throws Exception {
        String json = "{\"courseId\":10},{\"name\":\"nameTest\"},{\"teacher\":\"teacherTest\",{\"ue\":\"ueTest\",{\"year\":707}";

        mvc.perform(post("http://localhost:" + port + "/courses/")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
/*
        mvc.perform(delete("http://localhost:" + port + "/courses/10")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

 */
    }
}
