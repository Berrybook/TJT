package com.tjt.service;

import java.util.List;

import com.tjt.dto.UserDTO;

public interface UserService {

		
		public String userCreate(UserDTO dto)throws Exception;
		public List<UserDTO> listUser()throws Exception;	
		public UserDTO userById(String userid)throws Exception;
		public String UserUpdate(UserDTO dto)throws Exception;
		public void deleteUser(String userid)throws Exception;
}
