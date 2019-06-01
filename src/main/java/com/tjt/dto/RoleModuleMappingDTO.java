package com.tjt.dto;

public class RoleModuleMappingDTO {
	
	

	private Long Id;
	
	private String[] Role;
	
	private String Description;

	private String module;
	
	private String roles;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String[] getRole() {
		return Role;
	}

	public void setRole(String[] role) {
		Role = role;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	



}
