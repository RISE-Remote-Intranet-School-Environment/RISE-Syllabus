package com.RISE.sylla.repository;

import com.RISE.sylla.model.mapDocuOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.orderModel;

import java.util.List;

@Repository
public interface orderRepository extends JpaRepository<orderModel, Long>{

    List<orderModel> findAllBystudent(Long id);
}