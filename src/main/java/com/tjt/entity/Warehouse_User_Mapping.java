package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warehouse_User_Mapping {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

	@Column(name="warehouse_Id",unique = true)
	private String warehouse_Id;
	
	@Column(name="userid")
	private String userid;

	@Column(name="lable")
	private String lable;
	
	@Column(name="module_Id")
	private String module_Id;
	
	@Column(name="parent_Id")
	private String parent_Id;
	
	@Column(name="Role")
	private String role;
	
	@Column(name="level")
	private String level;
	
	
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

	public String getLable() {
		return lable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public String getParent_Id() {
		return parent_Id;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setParent_Id(String parent_Id) {
		this.parent_Id = parent_Id;
	}
	
		
}
