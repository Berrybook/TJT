package com.tjt.dto;

import java.sql.Date;

public class AdhocAssignmentDto {
	
	private String userid;
	private String username;
	private String pos;
	private String adhocPos;
	private Date startDate;
	private Date endDate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getAdhocPos() {
		return adhocPos;
	}
	public void setAdhocPos(String adhocPos) {
		this.adhocPos = adhocPos;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
