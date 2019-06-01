package com.tjt.dto;

import java.io.Serializable;
import java.sql.Date;


public class Shipment_Pojo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long shipment_Number;
	private Long orderNumber;
	private String shipment_By;
	private Date shipmentDate;
	private String[] pattern;
	private String [] size;
	private Long [] quantity;
	private String order_Raised_From;
	private String transportMode;
	
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
	public String[] getPattern() {
		return pattern;
	}
	public void setPattern(String[] pattern) {
		this.pattern = pattern;
	}
	public String[] getSize() {
		return size;
	}
	public void setSize(String[] size) {
		this.size = size;
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
	public Long getShipment_Number() {
		return shipment_Number;
	}
	public void setShipment_Number(Long shipment_Number) {
		this.shipment_Number = shipment_Number;
	}
	public Long[] getQuantity() {
		return quantity;
	}
	public void setQuantity(Long[] quantity) {
		this.quantity = quantity;
	}
	public void setOrder_Raised_From(String order_Raised_From) {
		this.order_Raised_From = order_Raised_From;
	}

}
