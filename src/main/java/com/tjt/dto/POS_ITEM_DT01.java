package com.tjt.dto;

public class POS_ITEM_DT01 {
	
	private Long tyre_id;
	private	String[] pos;
	private Long quantity;
	public Long getTyre_id() {
		return tyre_id;
	}
	public void setTyre_id(Long tyre_id) {
		this.tyre_id = tyre_id;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String[] getPos() {
		return pos;
	}
	public void setPos(String[] pos) {
		this.pos = pos;
	}
}
