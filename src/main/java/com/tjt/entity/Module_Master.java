package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Module_Master")
public class Module_Master {
	
	@Id
	@Column(name="Module_Id")
	private String module_Id;
	@Column(name="Description")
	private String Description;
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getModule_Id() {
		return module_Id;
	}
	public void setModule_Id(String module_Id) {
		this.module_Id = module_Id;
	}
	

}
