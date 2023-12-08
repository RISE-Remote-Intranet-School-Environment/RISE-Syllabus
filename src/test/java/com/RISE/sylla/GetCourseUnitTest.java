import com.RISE.sylla.model.CourseModel;
import com.RISE.sylla.service.CourseService;
import com.RISE.sylla.controller.CourseController;
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

public class GetCourseUnitTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @Test
    public void testGetCourseById() throws Exception {
        // Mocking the service layer to return a specific course by ID
        CourseModel course = new CourseModel();
        course.setCourseId(1L);
        course.setName("Course1");
        course.setTeacher("Teacher1");
        course.setUE("UE1");
        course.setYear(2022);
        when(courseService.getCourseById(1L)).thenReturn(Optional.of(course));

        // Perform the GET request and validate the response
        mockMvc.perform(get("/courses/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.courseId").value(1))
                .andExpect(jsonPath("$.name").value("Course1"));
    }

    @Test
    public void testGetAllCourses() throws Exception {
        //Create 2 new courses
        CourseModel course1 = new CourseModel();
        course1.setCourseId(1L);
        course1.setName("Course1");
        course1.setTeacher("Teacher1");
        course1.setUE("UE1");
        course1.setYear(2022);

        CourseModel course2 = new CourseModel();
        course2.setCourseId(2L);
        course2.setName("Course2");
        course2.setTeacher("Teacher2");
        course2.setUE("UE2");
        course2.setYear(2022);

        // Mocking the service layer to return a list of courses
        List<CourseModel> courses = Arrays.asList(
                course1,
                course2
        );

        when(courseService.getCourses()).thenReturn(courses);

        // Perform the GET request and validate the response
        mockMvc.perform(get("/courses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].courseId").value(1))
                .andExpect(jsonPath("$[0].name").value("Course1"))
                .andExpect(jsonPath("$[1].courseId").value(2))
                .andExpect(jsonPath("$[1].name").value("Course2"));
    }
}