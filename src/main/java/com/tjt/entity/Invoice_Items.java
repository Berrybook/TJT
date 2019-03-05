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
@Table(name="Invoice_Items")
public class Invoice_Items {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long invoice_Items;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice_Number", nullable = false)
	private Invoice invoice_Number;
	
	@Column(name="tyrepattern",length=100 )
	private String tyrepattern;
	@Column(name="tyresize",length=100 )
	private String tyresize;
	@Column(name="basic_Price")
	private Double basicPrice;
	@Column(name="warrantyId")
	private String  warrantyId;
	@Column(name="sale_date")
	private Date saledate;
	public Long getInvoice_Items() {
		return invoice_Items;
	}
	public void setInvoice_Items(Long invoice_Items) {
		this.invoice_Items = invoice_Items;
	}
	
	
	public Invoice getInvoice_Number() {
		return invoice_Number;
	}
	public void setInvoice_Number(Invoice invoice_Number) {
		this.invoice_Number = invoice_Number;
	}
	public Double getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(Double basicPrice) {
		this.basicPrice = basicPrice;
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
	public String getWarrantyId() {
		return warrantyId;
	}
	public void setWarrantyId(String warrantyId) {
		this.warrantyId = warrantyId;
	}
	public Date getSaledate() {
		return saledate;
	}
	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}
}
