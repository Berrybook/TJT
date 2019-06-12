package com.tjt.dto;

import java.sql.Date;

public class Invoice_Vehicle_DTO {


	private String vehiclemake;

	private String vehiclemodel;

	private String vehiclenumber;

	private Long   vehiclekm;

	private String vehicletype;

	private Date saledate;

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
