package com.tjt.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="request_order")
public class Request_Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long order_id;
	private String raised_By;
	private Date requisation_Date;
	private Date expected_Date;
	private String priority;
	private String dealer_id;	
	private String status;
	private String approver;
	
	
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
	public String getDealer_id() {
		return dealer_id;
	}
	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public Date getExpected_Date() {
		return expected_Date;
	}
	public void setExpected_Date(Date expected_Date) {
		this.expected_Date = expected_Date;
	}
	
}
