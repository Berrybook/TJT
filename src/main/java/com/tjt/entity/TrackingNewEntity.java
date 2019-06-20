package com.tjt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class TrackingNewEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String salesman;
	private String pos;
	private String date;
	private String curtime;
	private Long customerapp;
	private Long customerinq;
	private Long tyresale;
	private String timeslot;
	private String comment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCurtime() {
		return curtime;
	}
	public void setCurtime(String curtime) {
		this.curtime = curtime;
	}
	public Long getCustomerapp() {
		return customerapp;
	}
	public void setCustomerapp(Long customerapp) {
		this.customerapp = customerapp;
	}
	public Long getCustomerinq() {
		return customerinq;
	}
	public void setCustomerinq(Long customerinq) {
		this.customerinq = customerinq;
	}
	public Long getTyresale() {
		return tyresale;
	}
	public void setTyresale(Long tyresale) {
		this.tyresale = tyresale;
	}
	public String getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
