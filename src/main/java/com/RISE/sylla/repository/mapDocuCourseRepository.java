package com.RISE.sylla.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.MapDocuCourseModel;

import java.util.List;

@Repository
public interface mapDocuCourseRepository extends JpaRepository<MapDocuCourseModel, Long>{

    //function to find map by course id
    List<MapDocuCourseModel> findAllByfkcourse(Long id);
}
