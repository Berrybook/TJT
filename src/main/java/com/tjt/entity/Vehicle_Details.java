package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle_Details")
public class Vehicle_Details {
	
	@Id
	private Long id;
	
	@Column(name="vehicle_brand")
	private String vehicleBrand;
	
	@Column(name="vehicle_make")
	private String vehicleMake;
	
	@Column(name="vehicle_make_subcategory")
	private String vehicleMakeSubcategory;
	
	@Column(name="rear_size")
	private String rearSize;
	
	@Column(name="front_size")
	private String frontSize;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
