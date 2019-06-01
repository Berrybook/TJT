package com.tjt.dto;

public class Pos_User_Mapping_DTO {
	
	private Long pos_user_Id;

	private String[] userid;

	private String[] pos;
	
	
	public Long getPos_user_Id() {
		return pos_user_Id;
	}
	public void setPos_user_Id(Long pos_user_Id) {
		this.pos_user_Id = pos_user_Id;
	}
	public String[] getUserid() {
		return userid;
	}
	public void setUserid(String[] userid) {
		this.userid = userid;
	}
	public String[] getPos() {
		return pos;
	}
	public void setPos(String[] pos) {
		this.pos = pos;
	}
	

}
