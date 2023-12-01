package com.RISE.sylla;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeleteCourseTest extends SyllaApplicationTests {
    @Value("${server.port}")
    private int port;
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;


    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void deleteCourseTest() throws Exception {
        String json = "{\"courseId\":10,\"name\":\"nameTest\",\"teacher\":\"teacherTest\",\"ue\":\"ueTest\",\"year\":707}";

        mvc.perform(post("http://localhost:" + port + "/courses")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.courseId").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("nameTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.teacher").value("teacherTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ue").value("ueTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.year").value(707));

        mvc.perform(delete("http://localhost:" + port + "/courses/10")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
