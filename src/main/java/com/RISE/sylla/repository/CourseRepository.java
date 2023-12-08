package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.CourseModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long>{

    //function find a course by its ue
    Optional<CourseModel> findByue(String ue);

    //function to find all courses linked to an ue
    List<CourseModel> findAllByue(String ue);

    //function to find all the courses linked to a teacher
    List<CourseModel> findAllByTeacher(long teacher);

    //function to find all courses by academic year
    List<CourseModel> findAllByyear(int year);

}



