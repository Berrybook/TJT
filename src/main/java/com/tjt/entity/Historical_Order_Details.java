package com.tjt.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Historical_Order_Details {
	@Id
	private Long order_id;
	private String raised_By;
	private Date requisation_Date;
	private String priority;
	private String userId;
	private Date conformation_Date;
	
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public String getRaised_By() {
		return raised_By;
	}
	public void setRaised_By(String raised_By) {
		this.raised_By = raised_By;
	}
	public Date getRequisation_Date() {
		return requisation_Date;
	}
	public void setRequisation_Date(Date requisation_Date) {
		this.requisation_Date = requisation_Date;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getConformation_Date() {
		return conformation_Date;
	}
	public void setConformation_Date(Date conformation_Date) {
		this.conformation_Date = conformation_Date;
	}
}
