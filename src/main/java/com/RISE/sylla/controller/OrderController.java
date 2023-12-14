package com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.OrderModel;
import com.RISE.sylla.service.OrderService;

import com.RISE.sylla.service.MapDocuOrderService;
import com.RISE.sylla.model.MapDocuOrderModel;
import com.RISE.sylla.model.DocumentModel;
import com.RISE.sylla.service.DocumentService;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    OrderModel order;
    @Autowired
    DocumentService documentService;
    @Autowired
    MapDocuOrderService mapDocuOrderService;

    /**
     * POST method '/orders' creating order with params
     * body needs to look like :    {
     *               "student": "21012",
     *               "date": "01012023",
     *               "price": 10,
     *               "state": 1
     *          }
     *
     * @param order order to be posted
     * @return the posted order
     */
    @RequestMapping(value="", method=RequestMethod.POST)
    public OrderModel createOrder(@RequestBody OrderModel order) {
        return orderService.createOrder(order);
    }

    /**
     * update the status of an order
     * body needs to look like :    {
     *               "state": 1
     *           }
     * @param status new status of the order you want to update
     * @return the updated order
     */
    @RequestMapping(value="/status", method=RequestMethod.POST)
    public OrderModel updateStatus(@RequestBody String status) {
        String[] data = status.split(",");
        return orderService.updateStatus(Long.parseLong(data[0]), data[1]);
    }

    /**
     * return all the orders
     *
     * @return all the orders
     */
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<OrderModel> readOrders() {
        return orderService.getOrders();
    }

    /**
     * return a specific order by its id
     *
     * @param id id of the order to be returned
     * @return the order which has the provided id
     */
    @RequestMapping(value="/{orderId}", method=RequestMethod.GET)
    public OrderModel readOrderById(@PathVariable(value = "orderId") Long id) {

        if (orderService.getOrderById(id).isPresent()) {
            // Utilisez la méthode get() pour obtenir la valeur
            order = orderService.getOrderById(id).get();
        }
        return order;
    }
    /**
     * return all the documents linked to the specified order
     *
     * @param id of the order for which you wish to find the documents
     * @return list of document
     */
    @RequestMapping(value="/{orderId}/content", method=RequestMethod.GET)
    public List<Optional<DocumentModel>> readContentInOrder(@PathVariable(value = "orderId") Long id) {

        return orderService.getdocumentsByOrder(id);
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
    @RequestMapping(value="/{orderId}", method=RequestMethod.PUT)
    public OrderModel updateOrders(@PathVariable(value = "orderId") Long id, @RequestBody OrderModel orderDetails) {
        return orderService.updateOrder(id, orderDetails);
    }

    /**
     * delete an order
     *
     * @param id id of the order to be deleted
     */
    @RequestMapping(value="/{orderId}", method=RequestMethod.DELETE)
    public void deleteOrder(@PathVariable(value = "orderId") Long id) {
        orderService.deleteOrder(id);
    }

    /**
     * calculate the total price of a given order
     *
     * @param orderId id of the order
     * @return the price of the order
     */
    @RequestMapping(value="/{orderId}/price", method=RequestMethod.GET)
    public long getPrice(@PathVariable(value = "orderId") Long orderId) {
    long totalPrice = 0;
    List<MapDocuOrderModel> mapDocuOrderArray = mapDocuOrderService.getMaps();
    List<DocumentModel> documentArray = documentService.getDocuments();
    for (MapDocuOrderModel element : mapDocuOrderArray) {
        if (Objects.equals(element.getFkorder(), orderId)) {
            Long fkDoc = element.getFkdocument();
            for (DocumentModel element2 : documentArray) {
                if (Objects.equals(element2.getDocumentId(), fkDoc)) {
                    totalPrice += (long) element2.getPrice();
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
    public List<OrderModel> readOrderByUserId(@PathVariable(value = "userId") Long id) {
        return orderService.getOrderByUserId(id);
    }

}