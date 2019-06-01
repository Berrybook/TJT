package com.tjt.service;

import java.util.List;

public interface LogInService {
		
		public String LogIn(String userid,String password)throws Exception;
		public List<String> getAllROleByLogin()throws Exception;
		public int  UserAuthentication(String userid, String password,String role) throws Exception;
		
}
