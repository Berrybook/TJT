package com.tjt.dto;

import java.io.Serializable;

public class CustomerInquaryDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;


	private String customerName;
	private String phoneNumber;
	private String Vehicle;
	private String vehicleModel;
	private String tyreSize;
	private String MeterReading;
	private String tentativeTyreSize;
	private String comments;
	public String getCustomerName() {
	return customerName;
	}
	public void setCustomerName(String customerName) {
	this.customerName = customerName;
	}
	public String getPhoneNumber() {
	return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
	}
	public String getVehicle() {
	return Vehicle;
	}
	public void setVehicle(String vehicle) {
	Vehicle = vehicle;
	}
	public String getVehicleModel() {
	return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
	this.vehicleModel = vehicleModel;
	}
	public String getTyreSize() {
	return tyreSize;
	}
	public void setTyreSize(String tyreSize) {
	this.tyreSize = tyreSize;
	}
	public String getMeterReading() {
	return MeterReading;
	}
	public void setMeterReading(String meterReading) {
	MeterReading = meterReading;
	}
	public String getTentativeTyreSize() {
	return tentativeTyreSize;
	}
	public void setTentativeTyreSize(String tentativeTyreSize) {
	this.tentativeTyreSize = tentativeTyreSize;
	}
	public String getComments() {
	return comments;
	}
	public void setComments(String comments) {
	this.comments = comments;
	}


}
