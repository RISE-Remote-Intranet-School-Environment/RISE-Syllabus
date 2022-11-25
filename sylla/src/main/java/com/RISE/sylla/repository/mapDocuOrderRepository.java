package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.mapDocuOrderModel;

@Repository
public interface mapDocuOrderRepository  extends JpaRepository<mapDocuOrderModel, Long>{
}
