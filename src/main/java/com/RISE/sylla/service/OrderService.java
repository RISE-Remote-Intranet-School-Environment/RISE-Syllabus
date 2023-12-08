package com.RISE.sylla.service;

import com.RISE.sylla.model.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;

import com.RISE.sylla.model.OrderModel;
import com.RISE.sylla.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MapDocuOrderService mapDocuOrderService;

    // CREATE
    public OrderModel createOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    // READ
    public List<OrderModel> getOrders() {
        return orderRepository.findAll();
    }

    //READ by id
    public Optional<OrderModel> getOrderById(Long orderId){return orderRepository.findById(orderId);}

    //READ content
    public List<Optional<DocumentModel>> getdocumentsByOrder(Long orderId) {
        return mapDocuOrderService.getDocByOrderId(orderId);
    }

    // DELETE
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    // UPDATE
    public OrderModel updateOrder(Long orderId, OrderModel orderDetails) {
        OrderModel order = orderRepository.findById(orderId).get();
        order.setStudent(orderDetails.getStudent());
        order.setDate(orderDetails.getDate());
        order.setPrice(orderDetails.getPrice());
        order.setState(orderDetails.getState());
        return orderRepository.save(order);
    }

    public OrderModel updateStatus(Long orderId, String status){
        OrderModel order = orderRepository.findById(orderId).get();
        order.setState(status);
        return orderRepository.save(order);
    }


    //find order by user id
    public List<OrderModel> getOrderByUserId(Long id){
        return orderRepository.findAllBystudent(id);

    }

}
