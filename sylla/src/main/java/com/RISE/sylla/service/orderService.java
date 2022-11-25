package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.RISE.sylla.model.orderModel;
import com.RISE.sylla.repository.orderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {
    @Autowired
    orderRepository ordersRepository;

    // CREATE
    public orderModel createOrder(orderModel order) {
        return ordersRepository.save(order);
    }

    // READ
    public List<orderModel> getOrder() {
        return ordersRepository.findAll();
    }

    // DELETE
    public void deleteOrder(Long orderId) {
        ordersRepository.deleteById(orderId);
    }

    // UPDATE
    public orderModel updateOrder(Long orderId, orderModel orderDetails) {
        orderModel order = ordersRepository.findById(orderId).get();
        order.setStudent(orderDetails.getStudent());
        order.setDate(orderDetails.getDate());
        order.setPrice(orderDetails.getPrice());
        order.setState(orderDetails.getState());
        return ordersRepository.save(order);
    }
}
