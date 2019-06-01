package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Invoice_Items;

public interface Invoice_Items_DAO extends JpaRepository<Invoice_Items, Long> {
	@Query("select i.tyrepattern,i.tyresize,i.basicPrice from Invoice_Items i where invoice_Number=:invoice_number ")
	public List<Invoice_Items> findAllByInvoice_Number(@Param("invoice_number")String invoice_number);
	
}
