git stapackage com.RISE.sylla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RISE.sylla.model.courseModel;
import com.RISE.sylla.service.courseService;

@RestController
@RequestMapping("/api")
public class courseController {
    @Autowired
    courseService courseService;

    @RequestMapping(value="/courses", method= RequestMethod.POST)
    public courseModel createCourse(@RequestBody courseModel course) {
        return courseService.createCourse(course);
    }

    @RequestMapping(value="/courses", method=RequestMethod.GET)
    public List<courseModel> readCourses() {
        return courseService.getCourse();
    }

    @RequestMapping(value="/courses/{courseId}", method=RequestMethod.PUT)
    public courseModel readCourses(@PathVariable(value = "courseId") Long id, @RequestBody courseModel courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    @RequestMapping(value="/courses/{courseId}", method=RequestMethod.DELETE)
    public void deleteCourse(@PathVariable(value = "courseId") Long id) {
        courseService.deleteCourse(id);
    }

}