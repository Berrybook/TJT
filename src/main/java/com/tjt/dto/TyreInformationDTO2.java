package com.tjt.dto;

import java.io.Serializable;

public class TyreInformationDTO2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tyrepattern;
	private String tyresize;


	public String getTyrepattern() {
		return tyrepattern;
	}
	public void setTyrepattern(String tyrepattern) {
		this.tyrepattern = tyrepattern;
	}
	public String getTyresize() {
		return tyresize;
	}
	public void setTyresize(String tyresize) {
		this.tyresize = tyresize;
	}
	
}