package com.tjt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shipment_Item_Entity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Shipment_Item_Entity_Id;
	private Long shipment_Number;
	private String pattern;
	private String  size;
	private Long  quantity;
	
	public Long getShipment_Item_Entity_Id() {
		return Shipment_Item_Entity_Id;
	}
	public void setShipment_Item_Entity_Id(Long shipment_Item_Entity_Id) {
		Shipment_Item_Entity_Id = shipment_Item_Entity_Id;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public Long getShipment_Number() {
		return shipment_Number;
	}
	public void setShipment_Number(Long shipment_Number) {
		this.shipment_Number = shipment_Number;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
