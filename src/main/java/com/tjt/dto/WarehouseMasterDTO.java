package com.tjt.dto;

public class WarehouseMasterDTO {
	
	private String warehouse_Id;
	private String name;
	private String location;
	private String cityname;
	private String warehouse_type;
	public String getWarehouse_Id() {
		return warehouse_Id;
	}
	public void setWarehouse_Id(String warehouse_Id) {
		this.warehouse_Id = warehouse_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getWarehouse_type() {
		return warehouse_type;
	}
	public void setWarehouse_type(String warehouse_type) {
		this.warehouse_type = warehouse_type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
