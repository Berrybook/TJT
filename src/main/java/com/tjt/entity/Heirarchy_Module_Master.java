package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Heirarchy_Module_Master {
	
	@Id
	@Column(name="id")
	private String id;
	@Column(name="Module_Id")
	private String module_Id;
	@Column(name="level")
	private String level;
	

	@Column(name="level_depth")
	private int level_depth;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}




	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}



	public int getLevel_depth() {
		return level_depth;
	}


	public void setLevel_depth(int level_depth) {
		this.level_depth = level_depth;
	}


	public String getModule_Id() {
		return module_Id;
	}


	public void setModule_Id(String module_Id) {
		this.module_Id = module_Id;
	}


	
	

}
