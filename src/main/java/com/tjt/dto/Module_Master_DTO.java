package com.tjt.dto;

import java.io.Serializable;

public class Module_Master_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String module_Id;

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
