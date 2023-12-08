package com.RISE.sylla;

import com.RISE.sylla.controller.UserController;
import com.RISE.sylla.model.UserModel;
import com.RISE.sylla.service.userService;
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


public class GetUserTest{
    @Mock
    private userService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void testGetUserById() throws Exception {
        // Mocking the service layer to return a specific user by ID
        UserModel user = new UserModel();
        user.setUserId(1L);
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setEmailId("19555@ecam.be");
        user.setRole("Role1");
        user.setMatricule(19555);
        user.setTrigram("TRI");
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        // Perform the GET request and validate the response
        mockMvc.perform(get("/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.firstName").value("FirstName"))
                .andExpect(jsonPath("$.lastName").value("LastName"));
    }

    @Test
    public void testGetAllCourses() throws Exception {
        //Create 2 new courses
        UserModel user1 = new UserModel();
        user1.setUserId(1L);
        user1.setFirstName("FirstName1");
        user1.setLastName("LastName1");
        user1.setEmailId("19555@ecam.be");
        user1.setRole("Role1");
        user1.setMatricule(19555);
        user1.setTrigram("TRI");

        UserModel user2 = new UserModel();
        user2.setUserId(2L);
        user2.setFirstName("FirstName2");
        user2.setLastName("LastName2");
        user2.setEmailId("19556@ecam.be");
        user2.setRole("Role2");
        user2.setMatricule(19556);
        user2.setTrigram("TRJ");

        // Mocking the service layer to return a list of users
        List<UserModel> users = Arrays.asList(
                user1,
                user2
        );

        when(userService.getUsers()).thenReturn(users);

        // Perform the GET request and validate the response
        mockMvc.perform(get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].userId").value(1))
                .andExpect(jsonPath("$[0].firstName").value("FirstName1"))
                .andExpect(jsonPath("$[0].lastName").value("LastName1"))
                .andExpect(jsonPath("$[1].userId").value(2))
                .andExpect(jsonPath("$[1].firstName").value("FirstName2"))
                .andExpect(jsonPath("$[1].lastName").value("LastName2"));
    }
}
