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

@Entity
@Table(name="Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="invoice_Number")
	Long invoice_Number;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
	
	private User_Details_Table user_Details_Table;
	
	@Column(name="customer_name" ,length=100)
	private String customerName;
	
	@Column(name="contact_number" )
	private Long   contactNumber;
	
	@Column(name="email",length=50 )
	private String email;
	
	@Column(name="address1",length=400 )
	private String address1;
	
	@Column(name="address2",length=400 )
	private String address2;
	
	@Column(name="city",length=200 )
	private String city;
	
	@Column(name="zip_code" )
	private Long zipcode;
	
	@Column(name="total_price" )
	private Double total_price;
	
	@Column(name="total_gst" )
	private Double total_gst;
	
	@Column(name="total_sgst" )
	private Double total_sgst;
	
	@Column(name="total_cgst" )
	private Double total_cgst;
	
	@Column(name="taxble_amount" )
	private Double taxble_amount;
	
	@Column(name="quantity" )
	private long quantity;
	
	@Column(name="discount" )
	private Double discount=0.0;
	
	@Column(name="payment_mode" )
	private String payment_mode;
	
	@Column(name="saledate" )
	private Date saledate;
	
	public Double getTotal_gst() {
		return total_gst;
	}

	public void setTotal_gst(Double total_gst) {
		this.total_gst = total_gst;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	
	
	public Long getInvoice_Number() {
		return invoice_Number;
	}

	public void setInvoice_Number(Long invoice_Number) {
		this.invoice_Number = invoice_Number;
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

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public Date getSaledate() {
		return saledate;
	}

	public Double getTaxble_amount() {
		return taxble_amount;
	}

	public void setTaxble_amount(Double taxble_amount) {
		this.taxble_amount = taxble_amount;
	}

	public Double getTotal_sgst() {
		return total_sgst;
	}

	public void setTotal_sgst(Double total_sgst) {
		this.total_sgst = total_sgst;
	}

	public Double getTotal_cgst() {
		return total_cgst;
	}

	public void setTotal_cgst(Double total_cgst) {
		this.total_cgst = total_cgst;
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

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	
	
}
