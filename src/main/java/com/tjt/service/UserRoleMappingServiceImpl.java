package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.Role_DAO;
import com.tjt.dao.User_Detalis_DAO;
import com.tjt.dao.User_Role_Mapping_DAO;
import com.tjt.dto.User_Role_Mapping_DTO;
import com.tjt.entity.Role_Table;
import com.tjt.entity.User_Details_Table;
import com.tjt.entity.User_Role_Mapping;

@Service
public class UserRoleMappingServiceImpl implements UserRoleMappinService {
	
	@Autowired User_Role_Mapping_DAO userroleDAO;
	
	@Autowired User_Detalis_DAO userDAO;
	
	@Autowired Role_DAO roleDAo;

	
	//save the userRoleMapping
	@Override
	public void createUserRoleMapping(User_Role_Mapping_DTO dto) throws Exception {
	
		for(int i=0;i<dto.getRole().length;i++) {
			User_Role_Mapping userRoleEntity = new User_Role_Mapping();
			userRoleEntity.setUserid(dto.getUserid());
			userRoleEntity.setRole(dto.getRole()[i]);
			userroleDAO.save(userRoleEntity);
		}
	
		
	}

	//show userid in dropdown
	@Override
	public List<String> getAllUserId() throws Exception {
		List<String> userentity=null;
		String admin = "ADMIN";
		Role_Table role_table=new Role_Table();
		role_table.setRole(admin);
		try {
			userentity=userDAO.userIdExceptAdmin(role_table);		
		}
		catch (Exception e) {
			throw new Exception("database error");
		}
		return userentity;
		
	}

	
	//allrole in dropdown
		@Override
		public List<String> getAllRole() throws Exception {
			List<String> roleentity=null;
			String admn = "ADMIN";
			
			try {
				roleentity=roleDAo.getRoles(admn);
				
				for(String roletable : roleentity) {
					System.out.println("roletable "+roletable);
					
				}
			}
			catch (Exception e) {
				throw new Exception("database error");
			}
			return roleentity;
		}
		
	@Override
	public List<User_Role_Mapping_DTO> listUserRoleMapping() throws Exception {
		
		List<User_Role_Mapping_DTO> mapingDto = null;
		List<User_Role_Mapping> mapingEntity = null;
		mapingDto = new ArrayList<User_Role_Mapping_DTO>();
		mapingEntity = userroleDAO.findAll();
		
		for(User_Role_Mapping userRoleTable : mapingEntity)
		{
			User_Role_Mapping_DTO user_Role_Mapping_DTO=new User_Role_Mapping_DTO();
			BeanUtils.copyProperties(userRoleTable, user_Role_Mapping_DTO);
			user_Role_Mapping_DTO.setRoles(userRoleTable.getRole());
			mapingDto.add(user_Role_Mapping_DTO);
		}
		return mapingDto;
	}

}
