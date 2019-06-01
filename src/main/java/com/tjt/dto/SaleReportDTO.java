package com.tjt.dto;


public class SaleReportDTO {
	
	private String userId;
	private String saledate;
	private String tyrepattern;
	private String tyresize;
	private Long quantity;
	private Double totprice;
	private String paymentmode;
	
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
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getTotprice() {
		return totprice;
	}
	public String getSaledate() {
		return saledate;
	}
	public void setTotprice(Double totprice) {
		this.totprice = totprice;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
