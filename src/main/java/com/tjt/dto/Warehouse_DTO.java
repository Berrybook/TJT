package com.tjt.dto;

import java.io.Serializable;

public class Warehouse_DTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String warehouse_Id;
	private String module_Id;
	private String label;
	private String role;
	private String userid;
	private String level;
	public String getWarehouse_Id() {
		return warehouse_Id;
	}
	public void setWarehouse_Id(String warehouse_Id) {
		this.warehouse_Id = warehouse_Id;
	}
	public String getModule_Id() {
		return module_Id;
	}
	public void setModule_Id(String module_Id) {
		this.module_Id = module_Id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
}
