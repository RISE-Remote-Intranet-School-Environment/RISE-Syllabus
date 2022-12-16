package com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.orderModel;
import com.RISE.sylla.service.orderService;

import com.RISE.sylla.service.mapDocuOrderService;
import com.RISE.sylla.model.mapDocuOrderModel;
import com.RISE.sylla.model.documentModel;
import com.RISE.sylla.service.documentService;


@RestController
@RequestMapping("/order")
public class orderController {
    @Autowired
    orderService orderService;
    @Autowired
    documentService documentService;
    @Autowired
    mapDocuOrderService mapDocuOrderService;

    /**
     * post NEW order
     *
     * body needs to look like :    {
     *               "orderId":1,
     *               "student":"1999",
     *               "date":"220307",
     *               "price":10,
     *               "state":1
     *          }
     *
     * @param order order to be posted
     * @return the posted order
     */
    @RequestMapping(value="/orders", method= RequestMethod.POST)
    public orderModel createOrder(@RequestBody orderModel order) {
        return orderService.createOrder(order);
    }

    /**
     * update the status of an order
     *
     * body needs to look like :    {
     *               "state":1
     *           }
     * @param status new status of the order you want to update
     * @return the updated order
     */
    @RequestMapping(value="/status", method= RequestMethod.POST)
    public orderModel updateStatus(@RequestBody String status) {
        String[] data = status.split(",");
        return orderService.updateStatus(Long.parseLong(data[0]), data[1]);
    }

    /**
     * read all the orders
     *
     * @return all the orders
     */
    @RequestMapping(value="/orders", method=RequestMethod.GET)
    public List<orderModel> readOrders() {
        return orderService.getOrders();
    }

    /**
     * read a specific order by its id
     *
     * @param id id of the order to be returned
     * @return the order which has the provided id
     */
    @RequestMapping(value="/{orderId}", method=RequestMethod.GET)
    public Optional<orderModel> readOrderById(@PathVariable(value = "orderId") Long id) {
        return orderService.getOrderById(id);
    }

    /**
     * update an order which already exists
     *
     * body needs to look like :    {
     *               "orderId":1,
     *               "student":"1999",
     *               "date":"220307",
     *               "price":10,
     *               "state":1
     *           }
     * @param id id of the order to be updated
     * @param orderDetails new order data
     * @return the updated order
     */
    @RequestMapping(value="/orders/{orderId}", method=RequestMethod.PUT)
    public orderModel readOrders(@PathVariable(value = "orderId") Long id, @RequestBody orderModel orderDetails) {
        return orderService.updateOrder(id, orderDetails);
    }

    /**
     * delete an order
     *
     * @param id id of the order to be deleted
     */
    @RequestMapping(value="/orders/{orderId}", method=RequestMethod.DELETE)
    public void deleteOrder(@PathVariable(value = "orderId") Long id) {
        orderService.deleteOrder(id);
    }

    /**
     * calculate the total price of a given order
     *
     * @param orderId id of the order
     * @return the price of the order
     */
    @RequestMapping(value="/price/{orderId}", method=RequestMethod.GET)
    public long getPrice(@PathVariable(value = "orderId") Long orderId) {
    int totalPrice = 0;
    //List<orderModel> order = orderService.getOrder();
    List<mapDocuOrderModel> mapDocuOrderArray = mapDocuOrderService.getMaps();
    List<documentModel> documentArray = documentService.getDocuments();
    for (mapDocuOrderModel element : mapDocuOrderArray) {
        if (element.getFkorder() == orderId) {
            Long fkDoc = element.getFkdocument();
            for (documentModel element2 : documentArray) {
                if (element2.getDocumentId() == fkDoc) {
                    totalPrice += element2.getPrice();
                }
            }
            
        }
    }
    return totalPrice;
    }

    /**
     * read a specific order by its user id
     *
     * @param id id of the user corresponding to the order to be returned
     * @return the order which has the provided user id
     */
    @RequestMapping(value="/getOrderByUserId/{userId}", method=RequestMethod.GET)
    public List<orderModel> readOrderByUserId(@PathVariable(value = "userId") Long id) {
        return orderService.getOrderByUserId(id);
    }

}