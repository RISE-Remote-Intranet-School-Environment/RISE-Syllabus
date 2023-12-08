package com.RISE.sylla;

import com.RISE.sylla.model.CourseModel;
import com.RISE.sylla.service.CourseService;
import com.RISE.sylla.controller.CourseController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class DeleteCourseTest{
    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
        this.objectMapper = new ObjectMapper();
    }


    @Test
    public void deleteCourseTest() throws Exception {
        CourseModel course1 = new CourseModel();
        course1.setCourseId(1L);
        course1.setName("Course1");
        course1.setTeacher("Teacher1");
        course1.setUE("UE1");
        course1.setYear(2022);
        when(courseService.getCourseById(1L)).thenReturn(Optional.of(course1));

        CourseModel newCourse = new CourseModel();
        newCourse.setCourseId(10L);
        newCourse.setName("nameTest");
        newCourse.setTeacher("teacherTest");
        newCourse.setUE("ueTest");
        newCourse.setYear(707);

        mockMvc.perform(post("/courses")
                        .content(objectMapper.writeValueAsString(newCourse))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        // Perform delete request to delete the newly added course
        mockMvc.perform(delete("/courses/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
