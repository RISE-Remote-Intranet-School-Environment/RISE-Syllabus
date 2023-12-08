package com.RISE.sylla;

import com.RISE.sylla.controller.OrderController;
import com.RISE.sylla.model.OrderModel;
import com.RISE.sylla.service.OrderService;
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

public class DeleteOrderTest {
    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void deleteOrderTest() throws Exception {
        // Mocking the service layer to return a specific order by ID
        OrderModel order = new OrderModel();
        order.setOrderID(1L);
        order.setStudent(19555L);
        order.setDate("2020");
        order.setPrice(20);
        order.setState("pending");
        when(orderService.getOrderById(1L)).thenReturn(Optional.of(order));

        OrderModel newOrder = new OrderModel();
        newOrder.setOrderID(10L);
        newOrder.setStudent(777L);
        newOrder.setDate("2222");
        newOrder.setPrice(999);
        newOrder.setState("pending");

        mockMvc.perform(post("/orders")
                        .content(objectMapper.writeValueAsString(newOrder))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        // Perform delete request to delete the newly added course
        mockMvc.perform(delete("/orders/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
