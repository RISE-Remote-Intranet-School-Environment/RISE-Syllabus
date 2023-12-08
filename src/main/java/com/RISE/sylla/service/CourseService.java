package com.RISE.sylla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RISE.sylla.model.CourseModel;
import com.RISE.sylla.repository.CourseRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    // CREATE
    public CourseModel createCourse(CourseModel course) {
        return courseRepository.save(course);
    }

    // READ
    public List<CourseModel> getCourses() {
        return courseRepository.findAll();
    }

    //READ by id
    public Optional<CourseModel> getCourseById(Long courseId){return courseRepository.findById(courseId);}

    // READ by teacher
    public List<CourseModel> getCourseByTeacherId(Long teacherId){return courseRepository.findAllByTeacher(teacherId);}
    // DELETE
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    // UPDATE
    public CourseModel updateCourse(Long courseId, CourseModel courseDetails) {
        CourseModel course = courseRepository.findById(courseId).get();
        course.setName(courseDetails.getName());
        course.setTeacher(courseDetails.getTeacher());
        course.setUE(courseDetails.getUE());
        course.setYear(courseDetails.getYear());

        return courseRepository.save(course);
    }

    // read all courses linked to an ue
    public List<CourseModel> getCoursesByUE(String ue) {
        return courseRepository.findAllByue(ue);
    }

    //read all courses linked to an academic year
    public List<CourseModel> getCoursesByAcademicYear(int year) {
        return courseRepository.findAllByyear(year);
    }
}
