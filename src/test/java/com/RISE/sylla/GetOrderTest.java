package com.RISE.sylla;

import com.RISE.sylla.controller.OrderController;
import com.RISE.sylla.model.orderModel;
import com.RISE.sylla.service.orderService;
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


public class GetOrderTest{

    @Mock
    private orderService orderService;

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }


    @Test
    public void testGetOrderById() throws Exception {
        // Mocking the service layer to return a specific order by ID
        orderModel order = new orderModel();
        order.setOrderID(1L);
        order.setStudent(19555L);
        order.setDate("2020");
        order.setPrice(20);
        order.setState("pending");
        when(orderService.getOrderById(1L)).thenReturn(Optional.of(order));

        // Perform the GET request and validate the response
        mockMvc.perform(get("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.orderID").value(1))
                .andExpect(jsonPath("$.student").value(19555));
    }

    @Test
    public void testGetAllOrders() throws Exception {
        //Create 2 new orders
        orderModel order1 = new orderModel();
        order1.setOrderID(1L);
        order1.setStudent(19555L);
        order1.setDate("2022");
        order1.setPrice(20);
        order1.setState("pending");

        orderModel order2 = new orderModel();
        order2.setOrderID(2L);
        order2.setStudent(19556L);
        order2.setDate("2022");
        order2.setPrice(26);
        order2.setState("pending");

        // Mocking the service layer to return a list of orders
        List<orderModel> orders = Arrays.asList(
                order1,
                order2
        );

        when(orderService.getOrders()).thenReturn(orders);

        // Perform the GET request and validate the response
        mockMvc.perform(get("/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].orderID").value(1))
                .andExpect(jsonPath("$[0].student").value(19555))
                .andExpect(jsonPath("$[1].orderID").value(2))
                .andExpect(jsonPath("$[1].student").value(19556));
    }
}
