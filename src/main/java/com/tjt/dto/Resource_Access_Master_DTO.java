package com.tjt.dto;

public class Resource_Access_Master_DTO {
	
	
	private Long Id;

	private String Module_Id;

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
