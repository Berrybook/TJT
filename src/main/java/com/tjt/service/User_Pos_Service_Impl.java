package com.tjt.service;

import com.tjt.dao.Pos_User_Mapping_DAO;
import com.tjt.dto.User_Pos_Pojo;
import com.tjt.entity.Pos_User_Mapping;

public class User_Pos_Service_Impl implements User_Pos_Service {

	private Pos_User_Mapping_DAO pos_User_Mapping_DAO;
	@Override	
	public String user_Pos_assign(User_Pos_Pojo user_Pos_Pojo) throws Exception {
		
		
		for(int i=0;i<user_Pos_Pojo.getPosid().length;i++){
			Pos_User_Mapping pos_User_Mapping =new Pos_User_Mapping();
			pos_User_Mapping.setUserid(user_Pos_Pojo.getUserid());
			pos_User_Mapping.setPos(user_Pos_Pojo.getPosid()[i]);
			pos_User_Mapping_DAO.save(pos_User_Mapping);
		}
		return null;
	}

}
