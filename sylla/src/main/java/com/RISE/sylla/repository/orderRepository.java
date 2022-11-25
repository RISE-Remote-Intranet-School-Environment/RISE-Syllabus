package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.orderModel;

@Repository
public interface orderRepository extends JpaRepository<orderModel, Long>{
}