package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RISE.sylla.model.mapDocuCourseModel;
import com.RISE.sylla.repository.mapDocuCourseRepository;

import java.util.List;

@Service
public class mapDocuCourseService {
    @Autowired
    mapDocuCourseRepository mapDocuCourseRepository;

    // CREATE
    public mapDocuCourseModel createMapDocuCourse(mapDocuCourseModel document) {
        return mapDocuCourseRepository.save(document);
    }

    // READ
    public List<mapDocuCourseModel> getMapDocuCourse() {
        return mapDocuCourseRepository.findAll();
    }

    // DELETE
    public void deleteMapDocuCourse(Long mapDocuCourseId) {
        mapDocuCourseRepository.deleteById(mapDocuCourseId);
    }

    // UPDATE
    public mapDocuCourseModel updateMapDocuCourse(Long mapDocuCourseId, mapDocuCourseModel mapDocuCourseDetails) {
        mapDocuCourseModel mapDocuCourse = mapDocuCourseRepository.findById(mapDocuCourseId).get();
        mapDocuCourse.setFkCourse_DocCourse(mapDocuCourseDetails.getFkCourse_DocCourse());
        mapDocuCourse.setFkDocument_DocCourse(mapDocuCourseDetails.getFkDocument_DocCourse());

        return mapDocuCourseRepository.save(mapDocuCourse);
    }
}
