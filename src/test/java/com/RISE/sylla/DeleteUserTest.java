package com.RISE.sylla;

import com.RISE.sylla.controller.UserController;
import com.RISE.sylla.model.UserModel;
import com.RISE.sylla.service.userService;
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

public class DeleteUserTest {
    @Mock
    private userService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void deleteUserTest() throws Exception {
        // Mocking the service layer to return a specific order by ID
        UserModel user = new UserModel();
        user.setUserId(1L);
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setEmailId("19555@ecam.be");
        user.setRole("Role1");
        user.setMatricule(19555);
        user.setTrigram("TRI");
        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        UserModel newUser = new UserModel();
        newUser.setUserId(10L);
        newUser.setFirstName("NEWFirstName");
        newUser.setLastName("NEWLastName");
        newUser.setEmailId("NEW19555@ecam.be");
        newUser.setRole("NEWRole1");
        newUser.setMatricule(19555);
        newUser.setTrigram("NEW");

        mockMvc.perform(post("/users")
                        .content(objectMapper.writeValueAsString(newUser))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        // Perform delete request to delete the newly added course
        mockMvc.perform(delete("/users/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
