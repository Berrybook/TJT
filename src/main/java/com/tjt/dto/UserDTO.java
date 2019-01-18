package com.tjt.dto;



import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
	private String userid;
	private String password;
	private Long mobilenumber;
	private String address;
	private String mailid;
	private MultipartFile idprofe;
	private String userName;
	private String role;
	private String pos;
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
	public Long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public MultipartFile getIdprofe() {
		return idprofe;
	}
	public void setIdprofe(MultipartFile idprofe) {
		this.idprofe = idprofe;
	}
	
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	
	public String getRole() {
		return role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
}
