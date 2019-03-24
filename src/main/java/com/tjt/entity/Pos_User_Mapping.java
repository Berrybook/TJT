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
	private String userId;
	@Column(name="posId")
	private String posId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPosId() {
		return posId;
	}
	public void setPosId(String posId) {
		this.posId = posId;
	}
	public Long getPos_user_Id() {
		return pos_user_Id;
	}
	public void setPos_user_Id(Long pos_user_Id) {
		this.pos_user_Id = pos_user_Id;
	}

	
}
