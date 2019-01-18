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
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	@Column(name="SGST")
	private Double SGST;
	@Column(name="CGST")
	private Double CGST;
	@Column(name="IGST")
	private Double IGST;
	
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
