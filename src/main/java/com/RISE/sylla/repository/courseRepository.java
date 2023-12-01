package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.courseModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface courseRepository extends JpaRepository<courseModel, Long>{

    //function find a course by its ue
    Optional<courseModel> findByue(String ue);

    //function to find all courses linked to an ue
    List<courseModel> findAllByue(String ue);

    //function to find all the courses linked to a teacher
    List<courseModel> findAllByTeacher(long teacher);

    //function to find all courses by academic year
    List<courseModel> findAllByyear(int year);

}



