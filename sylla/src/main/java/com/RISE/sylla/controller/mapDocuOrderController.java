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
@RequestMapping("/mapDocuOrders")
public class mapDocuOrderController {

    @Autowired
    mapDocuOrderService mapDocuOrderService;

    /**
     * post NEW mapDocuOrder
     *
     * body needs to look like :    {
     *               "idmapdocuorder":1,
     *               "fkdocument":1,
     *               "fkcourse":1
     *          }
     *
     * @param mapDocuOrder map to be posted
     * @return the posted map
     */
    @RequestMapping(value="", method= RequestMethod.POST)
    public mapDocuOrderModel createmapDocuOrder(@RequestBody mapDocuOrderModel mapDocuOrder) {
        return mapDocuOrderService.createMap(mapDocuOrder);
    }

    /**
     * return a specific map by its id
     *
     * @param id id of the map to be returned
     * @return the map which as the provided id
     */
    @RequestMapping(value="/{mapId}", method=RequestMethod.GET)
    public Optional<mapDocuOrderModel> readMapById(@PathVariable(value = "mapId") Long id) {
        return mapDocuOrderService.getMapById(id);
    }

    /**
     * return all the maps stored in database
     *
     * @return all the map stored in database
     */
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<mapDocuOrderModel> readmapDocuOrders() {
        return mapDocuOrderService.getMaps();
    }

    /**
     * update a map which already exists
     *
     * body needs to look like :    {
     *               "idmapdocuorder":1,
     *               "fkdocument":1,
     *               "fkorder":1
     *           }
     * @param id id of the map to be updated
     * @param mapDocuOrderDetails new map data
     * @return the updated map
     */
    @RequestMapping(value="/{mapDocuOrderId}", method=RequestMethod.POST)
    public mapDocuOrderModel updateDocuOrders(@PathVariable(value = "mapDocuOrderId") Long id, @RequestBody mapDocuOrderModel mapDocuOrderDetails) {
        System.out.println(mapDocuOrderDetails);
        return mapDocuOrderService.updateMap(id, mapDocuOrderDetails);
    }


    /**
     * delete a map
     *
     * @param id id of the map to be deleted
     */
    @RequestMapping(value="/{mapDocuOrderId}", method=RequestMethod.DELETE)
    public void deleteMapDocuOrder(@PathVariable(value = "mapDocuOrderId") Long id) {
        mapDocuOrderService.deleteMap(id);
    }

    /**
     * return all the documents linked to an order
     *
     * @param id id of the order for which you wish to find the documents
     * @return list of document
     */
    @RequestMapping(value="/getDocsByOrderId/{orderId}", method=RequestMethod.GET)
    public List<Optional<documentModel>> readDocsByOrderId(@PathVariable(value = "orderId") Long id) {
        return mapDocuOrderService.getDocByOrderId(id);
    }

}
