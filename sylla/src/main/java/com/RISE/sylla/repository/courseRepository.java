package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.courseModel;

@Repository
public interface courseRepository extends JpaRepository<courseModel, Long>{
}


