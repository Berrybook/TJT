package com.tjt.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="shipment_entity")
public class Shipment_Detailes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long shipment_Number;
	private Long orderNumber;
	private String shipment_By;
	private Date shipmentDate;
	private String order_Raised_From;
	private String transportMode;
	
	
	public Long getShipment_Number() {
		return shipment_Number;
	}
	public void setShipment_Number(Long shipment_Number) {
		this.shipment_Number = shipment_Number;
	}
	public Long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public Date getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String getShipment_By() {
		return shipment_By;
	}
	public void setShipment_By(String shipment_By) {
		this.shipment_By = shipment_By;
	}
	public String getOrder_Raised_From() {
		return order_Raised_From;
	}
	public void setOrder_Raised_From(String order_Raised_From) {
		this.order_Raised_From = order_Raised_From;
	}

}
