package com.RISE.sylla.service;


import com.RISE.sylla.model.DocumentModel;
import com.RISE.sylla.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.MapDocuOrderModel;
import com.RISE.sylla.repository.MapDocuOrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MapDocuOrderService {

    @Autowired
    MapDocuOrderRepository mapDocuOrderRepository;

    @Autowired
    DocumentRepository documentRepository;

    //create
    public MapDocuOrderModel createMap(MapDocuOrderModel map){return mapDocuOrderRepository.save(map);}

    //read all
    public List<MapDocuOrderModel> getMaps() {
        return mapDocuOrderRepository.findAll();
    }

    //READ by id
    public Optional<MapDocuOrderModel> getMapById(Long mapId){return mapDocuOrderRepository.findById(mapId);}

    // DELETE
    public void deleteMap(Long mapId) {
        mapDocuOrderRepository.deleteById(mapId);
    }

    // UPDATE
    public MapDocuOrderModel updateMap(Long mapId, MapDocuOrderModel mapDetails) {
        System.out.println(mapDetails.getFkdocument());
        MapDocuOrderModel map = mapDocuOrderRepository.findById(mapId).get();
        map.setFkorder(mapDetails.getFkorder());
        map.setFkdocument(mapDetails.getFkdocument());

        return mapDocuOrderRepository.save(map);
    }

    //find documents by order id
    public List<Optional<DocumentModel>> getDocByOrderId(Long id){
        List<MapDocuOrderModel> list= mapDocuOrderRepository.findAllByfkorder(id);
        List<Optional<DocumentModel>> docList = new ArrayList<Optional<DocumentModel>>();
        for (MapDocuOrderModel map:list) {
            docList.add(documentRepository.findById(map.getFkdocument()));
        }
        return docList;
    }

}
