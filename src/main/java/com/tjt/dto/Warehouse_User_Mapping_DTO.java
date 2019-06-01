package com.tjt.dto;

public class Warehouse_User_Mapping_DTO {
	
	private String warehouse_Id;

	private String userid;

	private String level;

	private String module_Id;
	

	private String parent_Id;
	

	private String role;

	public String getWarehouse_Id() {
		return warehouse_Id;
	}

	public void setWarehouse_Id(String warehouse_Id) {
		this.warehouse_Id = warehouse_Id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


	public String getParent_Id() {
		return parent_Id;
	}

	public void setParent_Id(String parent_Id) {
		this.parent_Id = parent_Id;
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

	public String getModule_Id() {
		return module_Id;
	}

	public void setModule_Id(String module_Id) {
		this.module_Id = module_Id;
	}
	
		
}
