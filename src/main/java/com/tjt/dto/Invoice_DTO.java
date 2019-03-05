package com.tjt.dto;

import java.io.Serializable;
import java.sql.Date;


public class Invoice_DTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String customerName;
	
	private Long   contactNumber;
	
	private String email;
	
	private String address1;
	
	private String address2;
	
	private String city;
	
	private Long zipcode;
	
	private Double total_price;
	
	private Double total_cgst;
	
	private Double total_sgst;
	
	private Double total_gst;
	
	private Double taxble_amount;
	
	private Double discount=0.0;
	
	private long quantity;
	
	private String payment_mode;
	
	private Date saledate;

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

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public Double getTotal_gst() {
		return total_gst;
	}

	public void setTotal_gst(Double total_gst) {
		this.total_gst = total_gst;
	}

	public Date getSaledate() {
		return saledate;
	}

	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getTotal_cgst() {
		return total_cgst;
	}

	public void setTotal_cgst(Double total_cgst) {
		this.total_cgst = total_cgst;
	}

	public Double getTotal_sgst() {
		return total_sgst;
	}

	public void setTotal_sgst(Double total_sgst) {
		this.total_sgst = total_sgst;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public Double getTaxble_amount() {
		return taxble_amount;
	}

	public void setTaxble_amount(Double taxble_amount) {
		this.taxble_amount = taxble_amount;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

}
