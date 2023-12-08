package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.DocumentModel;
@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel, Long>{
}
