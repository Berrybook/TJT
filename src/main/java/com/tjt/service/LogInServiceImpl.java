package com.tjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.User_Detalis_DAO;
import com.tjt.entity.Role_Table;


@Service
public class LogInServiceImpl implements LogInService {
	@Autowired
  private User_Detalis_DAO userdao;
	
	

	@Override
	public String  LogIn(String userid, String password) throws Exception {
		List<Role_Table> listobj=null;
	
		
		String role=null;
		
		listobj=userdao.login(userid, password);
	
		for (Role_Table roletb : listobj) {
			
			 role=roletb.getRole();
			
		}
		
		return role;
	}

}
