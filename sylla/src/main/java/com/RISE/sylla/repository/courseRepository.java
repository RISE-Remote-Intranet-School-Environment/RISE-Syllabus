package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.courseModel;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

@Repository
public interface courseRepository extends JpaRepository<courseModel, Long>{
    Optional<courseModel> findByue(String ue);

    List<courseModel> findAllByue(String ue);
=======

@Repository
public interface courseRepository extends JpaRepository<courseModel, Long>{
    List<courseModel> findAllByTeacher(long teacher);
>>>>>>> 18-add-get-course-by-teacher
}



