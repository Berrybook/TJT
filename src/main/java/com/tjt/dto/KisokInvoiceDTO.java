package com.tjt.dto;

import java.sql.Date;

public class KisokInvoiceDTO {
	//transfer data from one layer to another layer
	
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
	private Double totalprice;
	private String paymentmode;
	private Date saledate;
	private String gstNo;
	private String gstAddress;
	public KisokInvoiceDTO(){
		
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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
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
	
	
	

	
	}
