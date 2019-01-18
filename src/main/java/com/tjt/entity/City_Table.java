package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="City_Table")
public class City_Table {
	@Id
	@Column(name="cityname")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private String cityname;
	@Column(name="gstno" ,length=200)
	private String gstno;
	@Column(name="gstaddres",length=400)
	private String gstaddres;
	@Column(name="descrption")
	private String descrption;
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getGstno() {
		return gstno;
	}
	public void setGstno(String gstno) {
		this.gstno = gstno;
	}
	public String getGstaddres() {
		return gstaddres;
	}
	public void setGstaddres(String gstaddres) {
		this.gstaddres = gstaddres;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
}
