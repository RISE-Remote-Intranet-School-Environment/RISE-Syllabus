package com.RISE.sylla.controller;

import com.RISE.sylla.model.documentModel;
import com.RISE.sylla.model.mapDocuCourseModel;
import com.RISE.sylla.model.userModel;
import com.RISE.sylla.service.mapDocuCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.mapDocuCourseModel;
import com.RISE.sylla.service.mapDocuOrderService;


@RestController
@RequestMapping("mapDocuCourse")
public class mapDocuCourseController {

    @Autowired
    mapDocuCourseService mapDocuCourseService;

    @RequestMapping(value="/mapDocuCourses", method= RequestMethod.POST)
    public mapDocuCourseModel createMapDocuCourse(@RequestBody mapDocuCourseModel mapDocuCourse) {
        return mapDocuCourseService.createMapDocuCourse(mapDocuCourse);
    }

    @RequestMapping(value="/mapDocuCourses", method=RequestMethod.GET)
    public List<mapDocuCourseModel> readMapDocuCourses() {
        return mapDocuCourseService.getMapDocuCourses();
    }

    @RequestMapping(value="/{mapId}", method=RequestMethod.GET)
    public Optional<mapDocuCourseModel> readMapById(@PathVariable(value = "mapId") Long id) {
        return mapDocuCourseService.getMapById(id);
    }

    @RequestMapping(value="/mapDocuCourses/{mapDocuCourseId}", method=RequestMethod.PUT)
    public mapDocuCourseModel readMapDocuCourses(@PathVariable(value = "mapDocuCourseId") Long id, @RequestBody mapDocuCourseModel mapDocuCourseDetails) {
        return mapDocuCourseService.updateMapDocuCourse(id, mapDocuCourseDetails);
    }

    @RequestMapping(value="/mapDocuCourses/{mapDocuCourseId}", method=RequestMethod.DELETE)
    public void deleteMapDocuCourse(@PathVariable(value = "mapDocuCourseId") Long id) {
        mapDocuCourseService.deleteMapDocuCourse(id);
    }

    @RequestMapping(value="/getDocsByCourseId/{courseId}", method=RequestMethod.GET)
    public List<Optional<documentModel>> readDocsByCourseId(@PathVariable(value = "courseId") Long id) {
        return mapDocuCourseService.getDocByCourseId(id);
    }

}
