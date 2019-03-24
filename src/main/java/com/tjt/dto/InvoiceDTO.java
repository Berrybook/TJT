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
	private String userId;
	private Double discount=0.0;
	private String userMailId;

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
	
	private String[] tyresizes;
	
	private String[] tyrepatterns;
	private Double[] basicPrices;

	private Double total_price;

	private String payment_mode;
	
	private Date saledate;
	
	private String gstNo;
	
	private String gstAddress;
	
	private Double total_cgst;
	
	private Double total_sgst;
	
	private Double total_gst;
	
	private Double taxble_amount;
	
	private Double basicPrice;
	
	private Double[] totalbasicPrice;
	private long quantity;
	
	private String price_in_word;
	
	private String templet;
	
	private String warrentyTemplet;

	
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
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
	public Double[] getBasicPrices() {
		return basicPrices;
	}
	public void setBasicPrices(Double[] basicPrices) {
		this.basicPrices = basicPrices;
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
	public Double[] getTotalbasicPrice() {
		return totalbasicPrice;
	}
	public void setTotalbasicPrice(Double[] totalbasicPrice) {
		this.totalbasicPrice = totalbasicPrice;
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
	public Double getTotal_gst() {
		return total_gst;
	}
	public void setTotal_gst(Double total_gst) {
		this.total_gst = total_gst;
	}
	public Double getTaxble_amount() {
		return taxble_amount;
	}
	public void setTaxble_amount(Double taxble_amount) {
		this.taxble_amount = taxble_amount;
	}
	public Double getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(Double basicPrice) {
		this.basicPrice = basicPrice;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getPrice_in_word() {
		return price_in_word;
	}
	public void setPrice_in_word(String price_in_word) {
		this.price_in_word = price_in_word;
	}
	public String getTemplet() {
		return templet;
	}
	public void setTemplet(String templet) {
		this.templet = templet;
	}
	public String[] getTyrepatterns() {
		return tyrepatterns;
	}
	public void setTyrepatterns(String[] tyrepatterns) {
		this.tyrepatterns = tyrepatterns;
	}
	public String getWarrentyTemplet() {
		return warrentyTemplet;
	}
	public void setWarrentyTemplet(String warrentyTemplet) {
		this.warrentyTemplet = warrentyTemplet;
	}
	public String[] getTyresizes() {
		return tyresizes;
	}
	public void setTyresizes(String[] tyresizes) {
		this.tyresizes = tyresizes;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	
}
