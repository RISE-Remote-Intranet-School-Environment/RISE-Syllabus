package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.RISE.sylla.model.ordersModel;
import com.RISE.sylla.repository.ordersRepository;
import java.util.List;

public class ordersService {
    @Autowired
    com.RISE.sylla.repository.ordersRepository ordersRepository;

    // CREATE
    public ordersModel createOrder(ordersModel order) {
        return ordersRepository.save(order);
    }

    // READ
    public List<ordersModel> getOrder() {
        return ordersRepository.findAll();
    }

    // DELETE
    public void deleteOrder(Long orderId) {
        ordersRepository.deleteById(orderId);
    }

    // UPDATE
    public ordersModel updateOrder(Long orderId, ordersModel orderDetails) {
        ordersModel order = ordersRepository.findById(orderId).get();
        order.setStudent(orderDetails.getStudent());
        order.setDate(orderDetails.getDate());
        order.setPrice(orderDetails.getPrice());
        order.setState(orderDetails.getState());
        return ordersRepository.save(order);
    }
}
