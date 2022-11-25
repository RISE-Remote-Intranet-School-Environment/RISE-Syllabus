package com.RISE.sylla.service;


import com.RISE.sylla.model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.mapDocuOrderModel;
import com.RISE.sylla.repository.mapDocuOrderRepository;
import java.util.List;

@Service
public class mapDocuOrderService {

    @Autowired
    mapDocuOrderRepository mapDocuOrderRepository;

    //create
    public mapDocuOrderModel createMap(mapDocuOrderModel map){return mapDocuOrderRepository.save(map);}

    public List<mapDocuOrderModel> getMap() {
        return mapDocuOrderRepository.findAll();
    }

    // DELETE
    public void deleteMap(Long mapId) {
        mapDocuOrderRepository.deleteById(mapId);
    }

    // UPDATE
    public mapDocuOrderModel updateMap(Long mapId, mapDocuOrderModel mapDetails) {
        mapDocuOrderModel map = mapDocuOrderRepository.findById(mapId).get();
        map.setFkOrder_DocOrder(mapDetails.getFkOrder_DocOrder());
        map.setFkDocument_DocOrder(mapDetails.getFkDocument_DocOrder());

        return mapDocuOrderRepository.save(map);
    }

}
