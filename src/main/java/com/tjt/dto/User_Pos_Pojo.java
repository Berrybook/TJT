package com.tjt.dto;

import java.io.Serializable;

public class User_Pos_Pojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userid;
	private String[] posid;
	private String city;
	private String role;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String[] getPosid() {
		return posid;
	}
	public void setPosid(String[] posid) {
		this.posid = posid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}