package com.RISE.sylla.service;

import com.RISE.sylla.model.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.MapDocuCourseModel;
import com.RISE.sylla.repository.MapDocuCourseRepository;
import com.RISE.sylla.repository.DocumentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MapDocuCourseService {

    @Autowired
    MapDocuCourseRepository mapDocuCourseRepository;

    @Autowired
    DocumentRepository documentRepository;

    // CREATE
    public MapDocuCourseModel createMapDocuCourse(MapDocuCourseModel mapDocuCourse) {
        return mapDocuCourseRepository.save(mapDocuCourse);
    }

    // READ
    public List<MapDocuCourseModel> getMapDocuCourses() {
        return mapDocuCourseRepository.findAll();
    }

    //READ by id
    public Optional<MapDocuCourseModel> getMapById(Long mapId){return mapDocuCourseRepository.findById(mapId);}

    // DELETE
    public void deleteMapDocuCourse(Long mapDocuCourseId) {
        mapDocuCourseRepository.deleteById(mapDocuCourseId);
    }

    // UPDATE
    public MapDocuCourseModel updateMapDocuCourse(Long mapDocuCourseId, MapDocuCourseModel mapDocuCourseDetails) {
        MapDocuCourseModel mapDocuCourse = mapDocuCourseRepository.findById(mapDocuCourseId).get();
        mapDocuCourse.setIdMapDocuCourse(mapDocuCourseDetails.getIdMapDocuCourse());
        mapDocuCourse.setFkcourse(mapDocuCourseDetails.getFkcourse());
        mapDocuCourse.setFkdocument(mapDocuCourseDetails.getFkdocument());

        return mapDocuCourseRepository.save(mapDocuCourse);
    }

    //find documents by course id
    public List<Optional<DocumentModel>> getDocByCourseId(Long id){
        List<MapDocuCourseModel> list= mapDocuCourseRepository.findAllByfkcourse(id);
        List<Optional<DocumentModel>> docList = new ArrayList<Optional<DocumentModel>>();
        for (MapDocuCourseModel map:list) {
            docList.add(documentRepository.findById(map.getFkdocument()));
        }
        return docList;
    }
}
