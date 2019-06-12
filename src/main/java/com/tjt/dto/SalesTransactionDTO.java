package com.tjt.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class SalesTransactionDTO {

	
	private String userid;
	private double amount;
	private Date date;
	private String payment_mode;
	private String receiver_name;
	private MultipartFile file_upload;

	public MultipartFile getFile_upload() {
		return file_upload;
	}
	public void setFile_upload(MultipartFile file_upload) {
		this.file_upload = file_upload;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

}

