package com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.CourseModel;
import com.RISE.sylla.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    /**
     * add a new course to the database
     *
     * body needs to look like :    {
     *         "courseId":1,
     *         "name":"fluid dynamics and microbiology applied to ethics",
     *         "teacher":"Dr fun",
     *         "ue":"ethics101",
     *         "year:1
     *     }
     *
     * @param course new course
     * @return the new course
     */
    @RequestMapping(value="", method= RequestMethod.POST)
    public CourseModel createCourse(@RequestBody CourseModel course) {
        return courseService.createCourse(course);
    }


    /**
     * Read all the courses in the database
     *
     *
     * @return all the courses
     */
    @RequestMapping(value="", method=RequestMethod.GET)
    public List<CourseModel> readCourses() {
        return courseService.getCourses();
    }


    /**
     * read a course by its id
     *
     * @param id id of the course to be read
     * @return the course linked to the provided id
     */
    @RequestMapping(value="/{courseId}", method=RequestMethod.GET)
    public Optional<CourseModel> readCourseById(@PathVariable(value = "courseId") Long id) {
        return courseService.getCourseById(id);
    }

    /**
     * update a course which already exists
     *
     * body needs to look like :    {
     *         "courseId":1,
     *         "name":"fluid dynamics and microbiology applied to ethics",
     *         "teacher":"Dr fun",
     *         "ue":"ethics101",
     *         "year:1
     *     }
     *
     * @param id id of the course to be updated
     * @param courseDetails new course data
     * @return the updated course
     */
    @RequestMapping(value="/{courseId}", method=RequestMethod.PUT)
    public CourseModel updateCourses(@PathVariable(value = "courseId") Long id, @RequestBody CourseModel courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    /**
     * delete a course
     *
     * @param id id of the course to be deleted
     */
    @RequestMapping(value="/{courseId}", method=RequestMethod.DELETE)
    public void deleteCourse(@PathVariable(value = "courseId") Long id) {
        courseService.deleteCourse(id);
    }

    /**
     * read all the course in an ue
     *
     * @param ue ue for which you wish to find the courses
     * @return list of courses linked to the provided ue
     */
    @RequestMapping(value="/UE/{ue}", method=RequestMethod.GET)
    public List<CourseModel> getCoursesByUE(@PathVariable(value = "ue") String ue) {
        return courseService.getCoursesByUE(ue);
    }

    /**
     * read all the course in an academic year
     *
     * @param year academic year for which you wish to find the courses
     * @return list of courses linked to the provided year
     */
    @RequestMapping(value="/Year/{year}", method=RequestMethod.GET)
    public List<CourseModel> getCoursesByAcademicYear(@PathVariable(value = "year") int year) {
        return courseService.getCoursesByAcademicYear(year);
    }

}