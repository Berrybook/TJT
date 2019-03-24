package com.tjt.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Transaction_Master")
public class SalesTransactionMaster {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@OnDelete(action = OnDeleteAction.CASCADE)
private long transactionid;	
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "userid")
@JsonIgnore
private User_Details_Table userid;
private double amount;
private Date date;
private String payment_mode;
private String receiver_name;
@Lob
private byte[] file_upload;

public byte[] getFile_upload() {
	return file_upload;
}
public void setFile_upload(byte[] file_upload) {
	this.file_upload = file_upload;
}


public long getTransactionid() {
	return transactionid;
}
public void setTransactionid(long transactionid) {
	this.transactionid = transactionid;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getPayment_mode() {
	return payment_mode;
}
public void setPayment_mode(String payment_mode) {
	this.payment_mode = payment_mode;
}
public User_Details_Table getUserid() {
	return userid;
}
public void setUserid(User_Details_Table userid) {
	this.userid = userid;
}
public String getReceiver_name() {
	return receiver_name;
}
public void setReceiver_name(String receiver_name) {
	this.receiver_name = receiver_name;
}

}

