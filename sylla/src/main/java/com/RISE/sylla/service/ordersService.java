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
