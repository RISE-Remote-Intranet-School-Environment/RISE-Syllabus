package com.RISE.sylla.controller;

import com.RISE.sylla.model.DocumentModel;
import com.RISE.sylla.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.MapDocuOrderModel;
import com.RISE.sylla.service.MapDocuOrderService;

@RestController
@RequestMapping("/mapDocuOrders")
public class MapDocuOrderController {

    @Autowired
    OrderController ordercontroller;
    @Autowired
    MapDocuOrderService mapDocuOrderService;

    OrderModel order;
    /**
     * post NEW mapDocuOrder
     *
     * body needs to look like :    {
     *               "fkdocument":1,
     *               "fkorder":1
     *          }
     *
     * @param mapDocuOrder map to be posted
     * @return the posted map
     */
    @RequestMapping(value="", method= RequestMethod.POST)
    public MapDocuOrderModel createmapDocuOrder(@RequestBody MapDocuOrderModel mapDocuOrder) {
        mapDocuOrderService.createMap(mapDocuOrder);
        updatePricebyId(mapDocuOrder.getFkorder());
        return mapDocuOrderService.createMap(mapDocuOrder);
    }

    public void updatePricebyId(Long id){
        order = ordercontroller.readOrderById(id);
        order.setPrice(ordercontroller.getPrice(id));
    }
    /**
     * return a specific map by its id
     *
     * @param id id of the map to be returned
     * @return the map which as the provided id
     */
    @RequestMapping(value="/{mapId}", method=RequestMethod.GET)
    public Optional<MapDocuOrderModel> readMapById(@PathVariable(value = "mapId") Long id) {
        return mapDocuOrderService.getMapById(id);
    }

    /**
     * return all the maps stored in database
     *
     * @return all the map stored in database
     */
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<MapDocuOrderModel> readmapDocuOrders() {
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
    public MapDocuOrderModel updateDocuOrders(@PathVariable(value = "mapDocuOrderId") Long id, @RequestBody MapDocuOrderModel mapDocuOrderDetails) {
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
}
