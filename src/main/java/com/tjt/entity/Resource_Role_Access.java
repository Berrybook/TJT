package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Resource_Role_Access")
public class Resource_Role_Access {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;
	@Column(name="level")
	private String level;
	@Column(name="module_Id")
	private String module_Id;
	@Column(name="role")
	private String role;
	@Column(name="access")
	private String access;
	
	public String getRole() {
		return role;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModule_Id() {
		return module_Id;
	}
	public void setModule_Id(String module_Id) {
		this.module_Id = module_Id;
	}
	

}
