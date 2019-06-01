package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Resource_Master")
public class Resource_Access_Master {
	
	@javax.persistence.Id
	@Column(name="Id" )
	private Long Id;
	@Column(name="Module_Id" )
	private String Module_Id;
	@Column(name="Description" )
	private String Description;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getModule_Id() {
		return Module_Id;
	}
	public void setModule_Id(String module_Id) {
		Module_Id = module_Id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

}
