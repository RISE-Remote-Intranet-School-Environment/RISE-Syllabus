package com.RISE.sylla.service;


import com.RISE.sylla.model.documentModel;
import com.RISE.sylla.repository.documentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.mapDocuOrderModel;
import com.RISE.sylla.repository.mapDocuOrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MapDocuOrderService {

    @Autowired
    mapDocuOrderRepository mapDocuOrderRepository;

    @Autowired
    documentRepository documentRepository;

    //create
    public mapDocuOrderModel createMap(mapDocuOrderModel map){return mapDocuOrderRepository.save(map);}

    //read all
    public List<mapDocuOrderModel> getMaps() {
        return mapDocuOrderRepository.findAll();
    }

    //READ by id
    public Optional<mapDocuOrderModel> getMapById(Long mapId){return mapDocuOrderRepository.findById(mapId);}

    // DELETE
    public void deleteMap(Long mapId) {
        mapDocuOrderRepository.deleteById(mapId);
    }

    // UPDATE
    public mapDocuOrderModel updateMap(Long mapId, mapDocuOrderModel mapDetails) {
        System.out.println(mapDetails.getFkdocument());
        mapDocuOrderModel map = mapDocuOrderRepository.findById(mapId).get();
        map.setFkorder(mapDetails.getFkorder());
        map.setFkdocument(mapDetails.getFkdocument());

        return mapDocuOrderRepository.save(map);
    }

    //find documents by order id
    public List<Optional<documentModel>> getDocByOrderId(Long id){
        List<mapDocuOrderModel> list= mapDocuOrderRepository.findAllByfkorder(id);
        List<Optional<documentModel>> docList = new ArrayList<Optional<documentModel>>();
        for (mapDocuOrderModel map:list) {
            docList.add(documentRepository.findById(map.getFkdocument()));
        }
        return docList;
    }

}
