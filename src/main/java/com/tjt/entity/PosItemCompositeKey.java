package com.tjt.entity;

import java.io.Serializable;

import javax.persistence.IdClass;


@IdClass(TyreCompositeKey.class)
public class PosItemCompositeKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String pos;
	
	private String  tyrepattern;
	
	private String  tyresize;

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

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
