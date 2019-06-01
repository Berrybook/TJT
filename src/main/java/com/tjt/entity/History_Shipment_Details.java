package com.tjt.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class History_Shipment_Details {

	@Id
	private Long shipment_Number;
	private Long orderNumber;
	private String shipment_By;;
	private Date shipmentDate;
	private String order_Raised_From;
	private String transportMode;
	private Date shipment_Recived_Date;
	
	
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
	public Date getShipment_Recived_Date() {
		return shipment_Recived_Date;
	}
	public void setShipment_Recived_Date(Date shipment_Recived_Date) {
		this.shipment_Recived_Date = shipment_Recived_Date;
	}
}
