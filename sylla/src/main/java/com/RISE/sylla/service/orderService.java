package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.RISE.sylla.model.orderModel;
import com.RISE.sylla.repository.orderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {
    @Autowired
    orderRepository orderRepository;

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

    public orderModel updateStatus(Long orderId, String status){
        orderModel order = orderRepository.findById(orderId).get();
        order.setState(status);
        return orderRepository.save(order);
    }
}
