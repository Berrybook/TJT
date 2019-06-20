package com.tjt.dto;

import javax.persistence.Column;

public class VehicleDetailsDto {
	
	private String vehicleBrand;
	private String vehicleMake;
	private String vehicleMakeSubcategory;
	private String rearSize;
	private String frontSize;
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public String getVehicleMake() {
		return vehicleMake;
	}
	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}
	public String getVehicleMakeSubcategory() {
		return vehicleMakeSubcategory;
	}
	public void setVehicleMakeSubcategory(String vehicleMakeSubcategory) {
		this.vehicleMakeSubcategory = vehicleMakeSubcategory;
	}
	public String getRearSize() {
		return rearSize;
	}
	public void setRearSize(String rearSize) {
		this.rearSize = rearSize;
	}
	public String getFrontSize() {
		return frontSize;
	}
	public void setFrontSize(String frontSize) {
		this.frontSize = frontSize;
	}


}
