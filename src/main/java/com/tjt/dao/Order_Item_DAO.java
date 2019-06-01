package com.tjt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjt.entity.Order_Item;

public interface Order_Item_DAO extends JpaRepository<Order_Item, Long> {
	
	

}
