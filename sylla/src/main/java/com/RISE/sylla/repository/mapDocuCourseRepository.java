package com.RISE.sylla.repository;


import com.RISE.sylla.model.mapDocuOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.mapDocuCourseModel;

import java.util.List;

@Repository
public interface mapDocuCourseRepository extends JpaRepository<mapDocuCourseModel, Long>{

    //function to find map by course id
    List<mapDocuCourseModel> findAllByfkcourse(Long id);
}
