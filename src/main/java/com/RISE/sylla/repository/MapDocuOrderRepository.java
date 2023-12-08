package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.MapDocuOrderModel;

import java.util.List;

@Repository
public interface MapDocuOrderRepository extends JpaRepository<MapDocuOrderModel, Long>{

    //function to find map by order id
    List<MapDocuOrderModel> findAllByfkorder(Long id);

}

