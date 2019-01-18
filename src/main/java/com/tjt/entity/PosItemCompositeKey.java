package com.tjt.entity;

import java.io.Serializable;

import javax.persistence.IdClass;


@IdClass(TyreCompositeKey.class)
public class PosItemCompositeKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String pos_table;
	
	private TyreCompositeKey tyre;



	public String getPos_table() {
		return pos_table;
	}

	public TyreCompositeKey getTyre() {
		return tyre;
	}

	public void setTyre(TyreCompositeKey tyre) {
		this.tyre = tyre;
	}

	public void setPos_table(String pos_table) {
		this.pos_table = pos_table;
	}


}
