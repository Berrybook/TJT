package com.tjt.dto;

public class Resource_Role_Access_DTO {
	
	
	private Long Id;

	private String level;

	private String module_Id;

	private String role;

	private String[] access;

	private String accesses;
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getModule_Id() {
		return module_Id;
	}

	public void setModule_Id(String module_Id) {
		this.module_Id = module_Id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String[] getAccess() {
		return access;
	}

	public void setAccess(String[] access) {
		this.access = access;
	}

	public String getAccesses() {
		return accesses;
	}

	public void setAccesses(String accesses) {
		this.accesses = accesses;
	}


}
