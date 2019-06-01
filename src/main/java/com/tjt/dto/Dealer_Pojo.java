package com.tjt.dto;

import java.io.Serializable;

public class Dealer_Pojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dealer_Mail_Id;
	private String dealer_Name;
	private String password;
	private String address;
	private String city;
	private String state;
	private long pincode;
	private long phone_number;
	private String channelExecutive;
	
	
	public String getDealer_Mail_Id() {
		return dealer_Mail_Id;
	}
	public void setDealer_Mail_Id(String dealer_Mail_Id) {
		this.dealer_Mail_Id = dealer_Mail_Id;
	}
	public String getDealer_Name() {
		return dealer_Name;
	}
	public void setDealer_Name(String dealer_Name) {
		this.dealer_Name = dealer_Name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getChannelExecutive() {
		return channelExecutive;
	}
	public void setChannelExecutive(String channelExecutive) {
		this.channelExecutive = channelExecutive;
	}
}
