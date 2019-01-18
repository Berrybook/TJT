package com.tjt.dto;

import java.sql.Date;


public class Invoice_Items_Dto {
	
	private String[] tyrepattern;
	private String[] tyre_size;
	private Double[] basicPrice;

	private Double SGST;

	private Double CGST;

	private Double IGST;

	private Date saledate;

	public String[] getTyrepattern() {
		return tyrepattern;
	}

	public void setTyrepattern(String[] tyrepattern) {
		this.tyrepattern = tyrepattern;
	}

	public String[] getTyre_size() {
		return tyre_size;
	}

	public void setTyre_size(String[] tyre_size) {
		this.tyre_size = tyre_size;
	}

	public Double[] getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(Double[] basicPrice) {
		this.basicPrice = basicPrice;
	}

	

	public Double getSGST() {
		return SGST;
	}

	public void setSGST(Double sGST) {
		SGST = sGST;
	}

	public Double getCGST() {
		return CGST;
	}

	public void setCGST(Double cGST) {
		CGST = cGST;
	}

	public Double getIGST() {
		return IGST;
	}

	public void setIGST(Double iGST) {
		IGST = iGST;
	}

	public Date getSaledate() {
		return saledate;
	}

	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}
	
}