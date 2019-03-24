package com.tjt.dto;

import java.io.Serializable;

public class Pos_Item_Price_Dto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String[] pos;
	private String[] pattern;
	private String[] size;
	private Double[] mrp;
	private Double[] salePrice;
	private Long[] qunatity;
	private String cityname;
	public String[] getPos() {
		return pos;
	}
	public void setPos(String[] pos) {
		this.pos = pos;
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

	public Double[] getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double[] salePrice) {
		this.salePrice = salePrice;
	}
	public Long[] getQunatity() {
		return qunatity;
	}
	public void setQunatity(Long[] qunatity) {
		this.qunatity = qunatity;
	}

	public Double[] getMrp() {
		return mrp;
	}
	public void setMrp(Double[] mrp) {
		this.mrp = mrp;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
}
