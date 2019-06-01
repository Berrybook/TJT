package com.tjt.dto;

public class User_Role_Mapping_DTO {
	
	private Long Id;
	private String[] role;
	private String userid;
	private String roles;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String[] getRole() {
		return role;
	}
	public void setRole(String[] role) {
		this.role = role;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	

}
