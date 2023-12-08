package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.mapDocuOrderModel;

import java.util.List;

@Repository
public interface mapDocuOrderRepository  extends JpaRepository<mapDocuOrderModel, Long>{

    //function to find map by order id
    List<mapDocuOrderModel> findAllByfkorder(Long id);

}

