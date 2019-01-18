package com.tjt.dto;

import java.sql.Date;

public class InvoiceDTO {
	
private Long invoice_Number;
	
	public Long getInvoice_Number() {
		return invoice_Number;
	}
	public void setInvoice_Number(Long invoice_Number) {
		this.invoice_Number = invoice_Number;
	}
	private String userid;

	private String customerName;

	private Long   contactNumber;

	private String email;

	private String address1;
	
	private String address2;
	
	private String city;

	private Long zipcode;
	
	private String vehiclemake;
	private String vehiclemodel;

	private String vehiclenumber;
	
	private Long   vehiclekm;
	
	private String vehicletype;
	
	private String tyrepattern;

	private String tyresize;

	private Double total_price;

	private String payment_mode;
	
	private Date saledate;
	
	private String gstNo;
	
	private String gstAddress;
	
	private Double SGST;
	
	private Double CGST;
	
	private Double IGST;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getZipcode() {
		return zipcode;
	}
	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}
	public String getVehiclemake() {
		return vehiclemake;
	}
	public void setVehiclemake(String vehiclemake) {
		this.vehiclemake = vehiclemake;
	}
	public String getVehiclemodel() {
		return vehiclemodel;
	}
	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}
	public String getVehiclenumber() {
		return vehiclenumber;
	}
	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}
	public Long getVehiclekm() {
		return vehiclekm;
	}
	public void setVehiclekm(Long vehiclekm) {
		this.vehiclekm = vehiclekm;
	}
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
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
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public Date getSaledate() {
		return saledate;
	}
	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getGstAddress() {
		return gstAddress;
	}
	public void setGstAddress(String gstAddress) {
		this.gstAddress = gstAddress;
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
}
