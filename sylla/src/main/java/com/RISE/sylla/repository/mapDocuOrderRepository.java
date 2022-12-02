package com.RISE.sylla.repository;

import com.RISE.sylla.model.documentModel;
import com.RISE.sylla.service.mapDocuOrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.mapDocuOrderModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface mapDocuOrderRepository  extends JpaRepository<mapDocuOrderModel, Long>{
    List<mapDocuOrderModel> findAllByfkorder(Long id);

}
