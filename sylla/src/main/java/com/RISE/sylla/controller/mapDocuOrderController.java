package com.RISE.sylla.controller;

import com.RISE.sylla.model.documentModel;
import com.RISE.sylla.model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.mapDocuOrderModel;
import com.RISE.sylla.service.mapDocuOrderService;

@RestController
@RequestMapping("/mapDocuOrder")
public class mapDocuOrderController {

    @Autowired
    mapDocuOrderService mapDocuOrderService;

    @RequestMapping(value="/mapDocuOrders", method= RequestMethod.POST)
    public mapDocuOrderModel createmapDocuOrder(@RequestBody mapDocuOrderModel mapDocuOrder) {
        return mapDocuOrderService.createMap(mapDocuOrder);
    }

    @RequestMapping(value="/{mapId}", method=RequestMethod.GET)
    public Optional<mapDocuOrderModel> readMapById(@PathVariable(value = "mapId") Long id) {
        return mapDocuOrderService.getMapById(id);
    }

    @RequestMapping(value="/mapDocuOrders", method=RequestMethod.GET)
    public List<mapDocuOrderModel> readmapDocuOrders() {
        return mapDocuOrderService.getMaps();
    }

    @RequestMapping(value="/mapDocuOrders/{mapDocuOrderId}", method=RequestMethod.PUT)
    public mapDocuOrderModel readmapDocuOrders(@PathVariable(value = "mapDocuOrderId") Long id, @RequestBody mapDocuOrderModel mapDocuOrderDetails) {
        return mapDocuOrderService.updateMap(id, mapDocuOrderDetails);
    }

    @RequestMapping(value="/mapDocuOrders/{mapDocuOrderId}", method=RequestMethod.DELETE)
    public void deletemapDocuOrder(@PathVariable(value = "mapDocuOrderId") Long id) {
        mapDocuOrderService.deleteMap(id);
    }


    //get doc by order id
    //@RequestMapping(value="/getDocsByOrderId/{orderId}", method=RequestMethod.GET)
    //public List<Optional<documentModel>> readDocsByOrderId( (@PathVariable(value = "oderId") Long id) {
    //    return mapDocuOrderService.getDocByOrderId(id);
    //}

    @RequestMapping(value="/getDocsByOrderId/{orderId}", method=RequestMethod.GET)
    public List<Optional<documentModel>> readDocsByOrderId(@PathVariable(value = "orderId") Long id) {
        return mapDocuOrderService.getDocByOrderId(id);
    }

}
