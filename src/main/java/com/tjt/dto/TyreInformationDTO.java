package com.tjt.dto;

public class TyreInformationDTO {

	private String tyrepattern;
	private String tyresize;
	private Double price;
	private String CGST;
	private String SGST;
	private String IGST;
	public String getTyrepattern() {
		return tyrepattern;
	}
	public void setTyrepattern(String tyrepattern) {
		this.tyrepattern = tyrepattern;
	}
	public String getTyresize() {
		return tyresize;
	}
	public void setTyresize(String tyresize) {
		this.tyresize = tyresize;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCGST() {
		return CGST;
	}
	public void setCGST(String cGST) {
		CGST = cGST;
	}
	public String getSGST() {
		return SGST;
	}
	public void setSGST(String sGST) {
		SGST = sGST;
	}
	public String getIGST() {
		return IGST;
	}
	public void setIGST(String iGST) {
		IGST = iGST;
	}
}
