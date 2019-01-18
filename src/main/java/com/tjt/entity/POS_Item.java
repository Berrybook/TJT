package com.tjt.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity @IdClass(PosItemCompositeKey.class)
@Table
public class POS_Item {

	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tyrepattern", referencedColumnName="tyrepattern"),
	    @JoinColumn(name="tyresize", referencedColumnName="tyresize")
	    
	})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Tyre_Information tyre;
	

	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pos", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private POS_Table pos_table;

	private Long quantity;
	
	
	public POS_Table getPos_table() {
		return pos_table;
	}

	public void setPos_table(POS_Table pos_table) {
		this.pos_table = pos_table;
	}

	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public Tyre_Information getTyre() {
		return tyre;
	}

	public void setTyre(Tyre_Information tyre) {
		this.tyre = tyre;
	}

	
}
