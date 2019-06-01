package com.tjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pos_user_mapping")
public class Pos_User_Mapping {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pos_user_Id")
	private Long pos_user_Id;
	@Column(name="userId")
	private String userid;
	@Column(name="pos")
	private String pos;
	
	public Long getPos_user_Id() {
		return pos_user_Id;
	}
	public void setPos_user_Id(Long pos_user_Id) {
		this.pos_user_Id = pos_user_Id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	
	

	
}
