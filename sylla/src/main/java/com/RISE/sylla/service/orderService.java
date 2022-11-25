package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class orderService {
    @Autowired
    com.RISE.sylla.repository.orderRepository orderRepository;

    // CREATE
    public orderModel createOrder(orderModel order) {
        return orderRepository.save(order);
    }

    // READ
    public List<orderModel> getOrder() {
        return orderRepository.findAll();
    }

    // DELETE
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    // UPDATE
    public orderModel updateOrder(Long orderId, orderModel orderDetails) {
        orderModel order = orderRepository.findById(orderId).get();
        order.setStudent(orderDetails.getStudent());
        order.setDate(orderDetails.getDate());
        order.setPrice(orderDetails.getPrice());
        order.setState(orderDetails.getState());
        return orderRepository.save(order);
    }
}
