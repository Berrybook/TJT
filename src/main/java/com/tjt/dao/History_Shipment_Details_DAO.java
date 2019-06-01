package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.History_Shipment_Details;


public interface History_Shipment_Details_DAO extends JpaRepository<History_Shipment_Details,Long> {
	
	
	@Query("select sp.shipment_Number,sp.orderNumber,sp.shipment_By,sp.shipmentDate,sp.order_Raised_From,sp.transportMode from Shipment_Detailes sp  where sp.order_Raised_From=:wareHouseId")
	public List<Object[]> allShipmentByWareHouseId(@Param("wareHouseId")String warehouseId);

	@Query("select sp.pattern,sp.size,sp.quantity from Shipment_Item_Entity sp  where sp.shipment_Number=:shipment_Number")
	public List<Object[]> allShipmentItemByshipmentId(@Param("shipment_Number")Long shipment_Number);

}
