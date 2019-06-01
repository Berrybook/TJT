package com.tjt.service;

import java.util.List;

import com.tjt.dto.Shipment_Pojo;

public interface Shipment_Service {
	public Long generateShipmentOrder(Shipment_Pojo shipment_Pojo);
	
	public List<Shipment_Pojo> getAllShipmentOrder(Shipment_Pojo shipment_Pojo);
	
	public List<Shipment_Pojo> getShipmentOrderByWareHouseId(String warehouseId);
}
