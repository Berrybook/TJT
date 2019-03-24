package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity @IdClass(PosItemCompositeKey.class)
@Table(name="pos_item")
public class POS_Item {
	@Id
	@Column(name="tyrepattern",nullable=true)
	private String tyrepattern;
	@Id
	@Column(name="tyresize",nullable=true)
	private String tyresize;
	@Id
	@Column(name="pos",nullable=true)
	private String pos;

	@ColumnDefault("0")
	private Long quantity=0l;
	
	@ColumnDefault("0.0")
	private Double MRP=0.0;
	
	@ColumnDefault("0.0")
	private Double salePrice=0.0;
	
	

	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getMRP() {
		return MRP;
	}

	public void setMRP(Double mRP) {
		MRP = mRP;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
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
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}

	
}
