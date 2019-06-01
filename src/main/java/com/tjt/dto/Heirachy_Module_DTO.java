package com.tjt.dto;

import java.io.Serializable;

public class Heirachy_Module_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Module_Id;
	

	private String level;

	private String level_depth;

	public String getModule_Id() {
		return Module_Id;
	}

	public void setModule_Id(String module_Id) {
		Module_Id = module_Id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel_depth() {
		return level_depth;
	}

	public void setLevel_depth(String level_depth) {
		this.level_depth = level_depth;
	}

}
