package com.tjt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tjt.entity.Shipment_Detailes;

@Repository
public interface Shipment_DAO extends JpaRepository<Shipment_Detailes,Long> {

	
//	public Shipment_DAO findShipment_Entity();
}
