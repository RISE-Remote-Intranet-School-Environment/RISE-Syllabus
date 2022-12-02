package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.courseModel;

import java.util.List;

@Repository
public interface courseRepository extends JpaRepository<courseModel, Long>{
    List<courseModel> findAllByTeacher(long teacher);
}


