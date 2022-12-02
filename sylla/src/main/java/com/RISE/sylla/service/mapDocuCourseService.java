package com.RISE.sylla.service;

import com.RISE.sylla.model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.mapDocuCourseModel;
import com.RISE.sylla.repository.mapDocuCourseRepository;
import java.util.List;
import java.util.Optional;

@Service
public class mapDocuCourseService {

    @Autowired
    mapDocuCourseRepository mapDocuCourseRepository;

    // CREATE
    public mapDocuCourseModel createMapDocuCourse(mapDocuCourseModel mapDocuCourse) {
        return mapDocuCourseRepository.save(mapDocuCourse);
    }

    // READ
    public List<mapDocuCourseModel> getMapDocuCourses() {
        return mapDocuCourseRepository.findAll();
    }

    //READ by id
    public Optional<mapDocuCourseModel> getMapById(Long mapId){return mapDocuCourseRepository.findById(mapId);}

    // DELETE
    public void deleteMapDocuCourse(Long mapDocuCourseId) {
        mapDocuCourseRepository.deleteById(mapDocuCourseId);
    }

    // UPDATE
    public mapDocuCourseModel updateMapDocuCourse(Long mapDocuCourseId, mapDocuCourseModel mapDocuCourseDetails) {
        mapDocuCourseModel mapDocuCourse = mapDocuCourseRepository.findById(mapDocuCourseId).get();
        mapDocuCourse.setIdMapDocuCourse(mapDocuCourseDetails.getIdMapDocuCourse());
        mapDocuCourse.setFkCourse_DocCourse(mapDocuCourseDetails.getFkCourse_DocCourse());
        mapDocuCourse.setFkDocument_DocCourse(mapDocuCourseDetails.getFkDocument_DocCourse());

        return mapDocuCourseRepository.save(mapDocuCourse);
    }
}
