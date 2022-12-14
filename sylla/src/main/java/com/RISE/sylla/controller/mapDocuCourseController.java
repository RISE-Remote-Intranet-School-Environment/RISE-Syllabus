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


    /**
     * post NEW mapDocuCourse
     *
     * body needs to look like :    {
     *              "idmapdocuorder":1,
     *              "fkdocument":1,
     *              "fkorder":1
     *          }
     *
     * @param mapDocuCourse map to be posted
     * @return the posted map
     */
    @RequestMapping(value="/mapDocuCourses", method= RequestMethod.POST)
    public mapDocuCourseModel createMapDocuCourse(@RequestBody mapDocuCourseModel mapDocuCourse) {
        return mapDocuCourseService.createMapDocuCourse(mapDocuCourse);
    }

    /**
     * read all the maps stored in database
     *
     * @return all the map stored in database
     */
    @RequestMapping(value="/mapDocuCourses", method=RequestMethod.GET)
    public List<mapDocuCourseModel> readMapDocuCourses() {
        return mapDocuCourseService.getMapDocuCourses();
    }

    /**
     * read a specific map by its id
     *
     * @param id id of the map to be returned
     * @return the map which as the provided id
     */
    @RequestMapping(value="/{mapId}", method=RequestMethod.GET)
    public Optional<mapDocuCourseModel> readMapById(@PathVariable(value = "mapId") Long id) {
        return mapDocuCourseService.getMapById(id);
    }


    /**
     * update a map which already exists
     *
     * body needs to look like :    {
     *         "idmapdocuorder":1,
     *         "fkdocument":1,
     *         "fkorder":1
     *     }
     *
     * @param id id of the map to be updated
     * @param mapDocuCourseDetails new map data
     * @return the updated map
     */

    @RequestMapping(value="/mapDocuCourses/{mapDocuCourseId}", method=RequestMethod.PUT)
    public mapDocuCourseModel updateMapDocuCourses(@PathVariable(value = "mapDocuCourseId") Long id, @RequestBody mapDocuCourseModel mapDocuCourseDetails) {
        return mapDocuCourseService.updateMapDocuCourse(id, mapDocuCourseDetails);
    }

    /**
     * delete a map
     *
     * @param id id of the map to be deleted
     */
    @RequestMapping(value="/mapDocuCourses/{mapDocuCourseId}", method=RequestMethod.DELETE)
    public void deleteMapDocuCourse(@PathVariable(value = "mapDocuCourseId") Long id) {
        mapDocuCourseService.deleteMapDocuCourse(id);
    }

    /**
     * read all the documents linked to a course
     *
     * @param id id of the course for which you wish to find the documents
     * @return list of document
     */
    @RequestMapping(value="/getDocsByCourseId/{courseId}", method=RequestMethod.GET)
    public List<Optional<documentModel>> readDocsByCourseId(@PathVariable(value = "courseId") Long id) {
        return mapDocuCourseService.getDocByCourseId(id);
    }

}
