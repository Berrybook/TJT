package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="user_details_master_table")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class User_Details_Table {
	@Id
	@Column(name="userid" )
	private String userid;
	@Column(name="password" ,nullable=false)
	private String password;
	@Column(name="mobilenumber" )
	private Long mobilenumber;
	@Column(name="address" )
	private String address;
	@Column(name="mailid" )
	private String mailid;
	@Lob
	@Column(name="idprofe" )
	private byte[] idProfe;
	
	@Column(name="idprofeFilename" )
	private String idprofeFilename;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role", nullable = false)
	@JsonIgnore
	private Role_Table role;
	
	@Column(name="username" )
	private String userName;
	
	@Column(name="mgr" )
	private String mgr; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pos")
	@JsonIgnore
	private POS_Table pos_table;

	public POS_Table getPos_table() {
		return pos_table;
	}

	public void setPos_table(POS_Table pos_table) {
		this.pos_table = pos_table;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public byte[] getIdProfe() {
		return idProfe;
	}

	public void setIdProfe(byte[] idProfe) {
		this.idProfe = idProfe;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Role_Table getRole() {
		return role;
	}

	public void setRole(Role_Table role) {
		this.role = role;
	}

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getIdprofeFilename() {
		return idprofeFilename;
	}

	public void setIdprofeFilename(String idprofeFilename) {
		this.idprofeFilename = idprofeFilename;
	}
	
	
}
