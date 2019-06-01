package com.tjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.Role_DAO;
import com.tjt.dao.User_Detalis_DAO;
import com.tjt.entity.Role_Table;



@Service
public class LogInServiceImpl implements LogInService {
	@Autowired
  private User_Detalis_DAO userdao;
	
	@Autowired
	private Role_DAO role_DAO; 

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
	
	@Override
	public List<String> getAllROleByLogin()throws Exception{
		
		String admin="ADMIN";
		String pos="POS";
		String cityManager="CityManager";
		List<String> listRole=null;
		listRole=role_DAO.GetRoleByLogIn(admin,pos,cityManager);
		return listRole;
	}
	
	@Override
	public int  UserAuthentication(String userid, String password,String role) throws Exception{
		int count =0;
		int responseBody=0;
		count=userdao.userLoginAuthentication(userid, password);
		if(count==0){
			responseBody=count;
		}
		else{

			count=userdao.userRoleauthentication(userid, role);
			if(count==0){
		
				responseBody=count;
			}
			else{
			
				responseBody=count;
			
			}
		}
		return responseBody;
	}

}
