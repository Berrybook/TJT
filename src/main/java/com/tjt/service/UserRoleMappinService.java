package com.tjt.service;

import java.util.List;

import com.tjt.dto.RoleDTO;
import com.tjt.dto.UserDTO;
import com.tjt.dto.User_Role_Mapping_DTO;

import com.tjt.entity.User_Details_Table;

public interface UserRoleMappinService {

	public void createUserRoleMapping(User_Role_Mapping_DTO dto) throws Exception;
	public List<String>  getAllUserId() throws Exception;

	public List<User_Role_Mapping_DTO> listUserRoleMapping() throws Exception;
	public List<String> getAllRole() throws Exception;
	
}
 