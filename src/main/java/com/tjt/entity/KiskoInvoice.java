package com.tjt.entity;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="invoice_generation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class KiskoInvoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerid")
	private Long customerID;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
	private User_Details_Table user_Details_Table;
	
	@Column(name="customername" ,length=50)
	private String customerName;
	
	@Column(name="contactnumber" )
	private Long   contactNumber;
	
	@Column(name="email",length=50 )
	private String email;
	@Column(name="address1",length=50 )
	private String address1;
	@Column(name="address2",length=50 )
	private String address2;
	@Column(name="city",length=50 )
	private String city;
	@Column(name="zip_code",length=50 )
	private Long zipcode;
	@Column(name="vehiclemake",length=50 )
	private String vehiclemake;
	@Column(name="vehiclemodel",length=50 )
	private String vehiclemodel;
	@Column(name="vehiclenumber",length=50 )
	private String vehiclenumber;
	@Column(name="vehiclekm" )
	private Long   vehiclekm;
	@Column(name="vehicletype",length=50 )
	private String vehicletype;
	@Column(name="tyrepattern",length=50 )
	private String tyrepattern;
	@Column(name="tyresize",length=50 )
	private String tyresize;
	@Column(name="totalprice" )
	private Double totalprice;
	@Column(name="paymentmode",length=50 )
	private String paymentmode;
	@Column(name="saledate",length=50 )
	private Date saledate;
	public Long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	public User_Details_Table getUser_Details_Table() {
		return user_Details_Table;
	}
	public void setUser_Details_Table(User_Details_Table user_Details_Table) {
		this.user_Details_Table = user_Details_Table;
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
	
	
	
}
