package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.documentModel;
@Repository
public interface documentRepository extends JpaRepository<documentModel, Long>{
}
