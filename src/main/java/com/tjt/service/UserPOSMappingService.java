package com.tjt.service;

import java.util.List;

import com.tjt.dto.User_Pos_Pojo;
import com.tjt.entity.Role_Table;

public interface UserPOSMappingService {

	public void createUserPOSMapping(User_Pos_Pojo dto) throws Exception;
	public List<User_Pos_Pojo> listUserPOSMapping() throws Exception;
	public List<String> roleDropdown() throws Exception;
	public List<String> cityDropdown() throws Exception;
	public List<String> allUserByRole(Role_Table role) throws Exception;
	public List<String> allPOSByCity(String cityname) throws Exception;
}
