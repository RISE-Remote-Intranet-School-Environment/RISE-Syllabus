package com.RISE.sylla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RISE.sylla.model.UserModel;

@Repository
public interface userRepository extends JpaRepository<UserModel, Long> {

}