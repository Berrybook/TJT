package com.tjt.dto;

import java.sql.Date;


public class Request_Order_DTO {

	
	private Long order_id;
	private String posid,pattern,size;
	private Integer quantity;
	private Date requisation_Date;
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public String getPosid() {
		return posid;
	}
	public void setPosid(String posid) {
		this.posid = posid;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getRequisation_Date() {
		return requisation_Date;
	}
	public void setRequisation_Date(Date requisation_Date) {
		this.requisation_Date = requisation_Date;
	}
	
}
