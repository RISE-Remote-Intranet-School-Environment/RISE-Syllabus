package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.OrderModel;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>{

    List<OrderModel> findAllBystudent(Long id);
}