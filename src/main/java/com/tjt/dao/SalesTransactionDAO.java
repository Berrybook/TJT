package com.tjt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjt.entity.SalesTransactionMaster;

public interface SalesTransactionDAO extends JpaRepository<SalesTransactionMaster, Long>{

	
}