package com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.orderModel;
import com.RISE.sylla.service.orderService;

@RestController
@RequestMapping("/order")
public class orderController {
    @Autowired
    orderService orderService;

    @RequestMapping(value="/orders", method= RequestMethod.POST)
    public orderModel createOrder(@RequestBody orderModel order) {
        return orderService.createOrder(order);
    }

    @RequestMapping(value="/orders", method=RequestMethod.GET)
    public List<orderModel> readOrders() {
        return orderService.getOrder();
    }

    @RequestMapping(value="/orders/{orderId}", method=RequestMethod.PUT)
    public orderModel readOrders(@PathVariable(value = "orderId") Long id, @RequestBody orderModel orderDetails) {
        return orderService.updateOrder(id, orderDetails);
    }

    @RequestMapping(value="/orders/{orderId}", method=RequestMethod.DELETE)
    public void deleteOrder(@PathVariable(value = "orderId") Long id) {
        orderService.deleteOrder(id);
    }

}