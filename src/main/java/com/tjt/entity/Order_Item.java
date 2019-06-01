package com.tjt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class Order_Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long order_Item_Id;
	private Long order_Id;
	private String pattern;
	private String size;
	private Long quantity;
	public Long getOrder_Item_Id() {
		return order_Item_Id;
	}
	public void setOrder_Item_Id(Long order_Item_Id) {
		this.order_Item_Id = order_Item_Id;
	}
	public Long getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(Long order_Id) {
		this.order_Id = order_Id;
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
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	

}
