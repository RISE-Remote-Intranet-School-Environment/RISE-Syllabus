package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.ordersModel;

@Repository
public interface ordersRepository extends JpaRepository<ordersModel, Long>{
}