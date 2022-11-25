package com.RISE.sylla.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.mapDocuCourseModel;

@Repository
public interface mapDocuCourseRepository extends JpaRepository<mapDocuCourseModel, Long>{
}
