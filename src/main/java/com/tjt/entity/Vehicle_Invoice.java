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
@Table(name="Vehicle_Invoice")
public class Vehicle_Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long vehicle_Invoice;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoice_Number", nullable = false)
	private Invoice invoice_number;
	
	@Column(name="vehicle_make",length=50 )
	private String vehiclemake;
	@Column(name="vehicle_model",length=50 )
	private String vehiclemodel;
	@Column(name="vehicle_number",length=50 )
	private String vehiclenumber;
	@Column(name="vehicle_Run" )
	private Long   vehiclekm;
	@Column(name="vehicle_type",length=50 )
	private String vehicletype;
	@Column(name="saledate" )
	private Date saledate;
	
	
	public Long getVehicle_Invoice() {
		return vehicle_Invoice;
	}
	public void setVehicle_Invoice(Long vehicle_Invoice) {
		this.vehicle_Invoice = vehicle_Invoice;
	}
	public Invoice getInvoice_number() {
		return invoice_number;
	}
	public void setInvoice_number(Invoice invoice_number) {
		this.invoice_number = invoice_number;
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
	public Date getSaledate() {
		return saledate;
	}
	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}

}
