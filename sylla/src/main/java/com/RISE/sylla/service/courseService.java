package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.courseModel;
import com.RISE.sylla.repository.courseRepository;
import java.util.List;
import java.util.Optional;

@Service
public class courseService {
    @Autowired
    courseRepository courseRepository;

    // CREATE
    public courseModel createCourse(courseModel course) {
        return courseRepository.save(course);
    }

    // READ
    public List<courseModel> getCourses() {
        return courseRepository.findAll();
    }

    //READ by id
    public Optional<courseModel> getCourseById(Long courseId){return courseRepository.findById(courseId);}

    // READ by teacher
    public List<courseModel> getCourseByTeacherId(Long teacherId){return courseRepository.findAllByTeacher(teacherId);}
    // DELETE
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    // UPDATE
    public courseModel updateCourse(Long courseId, courseModel courseDetails) {
        courseModel course = courseRepository.findById(courseId).get();
        course.setName(courseDetails.getName());
        course.setTeacher(courseDetails.getTeacher());
        course.setUE(courseDetails.getUE());
        course.setYear(courseDetails.getYear());

        return courseRepository.save(course);
    }
}
