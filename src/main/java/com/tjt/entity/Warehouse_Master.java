package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Warehouse_Master")
public class Warehouse_Master {
	
	@Id
	@Column(name="Warehouse_Id")
	private String warehouse_Id;
	@Column(name="name")
	private String name;
	@Column(name="location")
	private String location;
	@Column(name="cityname")
	private String cityname;
	@Column(name="warehouse_type")
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	
}
