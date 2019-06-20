package com.tjt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class CustomerForm {

@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String customerName;
private String pos;
private String dateofinqu;
private String time;
private String salesman;
private String phoneNumber;
private String vehicle;
private String vehicleModel;
private String tyreSize;
private String meterReading;
private String tentadate;
private String comments;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
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
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getVehicle() {
	return vehicle;
}
public void setVehicle(String vehicle) {
	this.vehicle = vehicle;
}
public String getMeterReading() {
	return meterReading;
}
public void setMeterReading(String meterReading) {
	this.meterReading = meterReading;
}
public String getTentadate() {
	return tentadate;
}
public void setTentadate(String tentadate) {
	this.tentadate = tentadate;
}
public String getPos() {
	return pos;
}
public void setPos(String pos) {
	this.pos = pos;
}
public String getDateofinqu() {
	return dateofinqu;
}
public void setDateofinqu(String dateofinqu) {
	this.dateofinqu = dateofinqu;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getSalesman() {
	return salesman;
}
public void setSalesman(String salesman) {
	this.salesman = salesman;
}





}
