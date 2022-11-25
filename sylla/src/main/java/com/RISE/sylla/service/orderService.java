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

    public long getPrice(Long orderId) {
        int totalPrice = 0;
        ordersModel order = ordersRepository.findById(orderId).get();
        List<mapDocuOrderModel> mapDocuOrderArray = mapDocuOrderRepository.findAll();
        List<documentModel> documentArray = documentRepository.findAll();
        for (mapDocuOrderModel element : mapDocuOrderArray) {
            if (element.getFkOrder_DocOrder() == orderId) {
                int fkDoc = element.getFkDocument_DocOrder();
                for (documentModel element2 : documentArray) {
                    if (element2.getDocumentId() == fkDoc) {
                        totalPrice += element2.getPrice();
                    }
                }

            }
        }
        return totalPrice;
    }
}
