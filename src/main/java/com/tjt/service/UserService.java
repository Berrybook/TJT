package com.tjt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;



import com.tjt.dto.UserDTO;

public interface UserService {

		
		public String userCreate(UserDTO dto)throws Exception;
		public List<UserDTO> listUser()throws Exception;	
		public UserDTO userById(HttpServletRequest request,String userid)throws Exception;
		public String UserUpdate(HttpServletRequest request,UserDTO dto)throws Exception;
		public void deleteUser(HttpServletRequest request,String userid)throws Exception;
}
