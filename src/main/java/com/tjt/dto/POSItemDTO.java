package com.tjt.dto;

public class POSItemDTO {
	
	private String pos;
	private String[] tyresize;
	private String[] tyrepattern;	
	private Long[] quantity;
	
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	public Long[] getQuantity() {
		return quantity;
	}
	public void setQuantity(Long[] quantity) {
		this.quantity = quantity;
	}
	public String[] getTyresize() {
		return tyresize;
	}
	public void setTyresize(String[] tyresize) {
		this.tyresize = tyresize;
	}
	public String[] getTyrepattern() {
		return tyrepattern;
	}
	public void setTyrepattern(String[] tyrepattern) {
		this.tyrepattern = tyrepattern;
	}
	
	
	

}
 