package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.CityDAO;
import com.tjt.dao.POS_DAO;
import com.tjt.dao.Role_DAO;
import com.tjt.dao.UserPOSMappingDAO;
import com.tjt.dao.User_Detalis_DAO;
import com.tjt.dto.User_Pos_Pojo;
import com.tjt.dto.User_Role_Mapping_DTO;
import com.tjt.entity.Role_Table;
import com.tjt.entity.User_POS_Mapping;
import com.tjt.entity.User_Role_Mapping;

@Service
public class UserPOSMappingServiceImpl implements UserPOSMappingService {
	
	@Autowired UserPOSMappingDAO mappingDao;
	@Autowired User_Detalis_DAO userDAO;
	@Autowired POS_DAO posDao;
	@Autowired Role_DAO roleDAo;
	@Autowired CityDAO cityDao;
	

	@Override
	public void createUserPOSMapping(User_Pos_Pojo dto) throws Exception {
		for(int i=0;i<dto.getRole().length();i++) {
			User_POS_Mapping userPOSEntity = new User_POS_Mapping();
			userPOSEntity.setUserid(dto.getUserid());
			userPOSEntity.setPosid(dto.getPosid()[i]);
			mappingDao.save(userPOSEntity);
		}
	
		
	}

	//View all user POS mapping in Grid
	@Override
	public List<User_Pos_Pojo> listUserPOSMapping() throws Exception {
		
		List<User_Pos_Pojo> listuserPOSPojo = null;
		List<User_POS_Mapping> listuserPOStable = null;
		listuserPOSPojo =new ArrayList<User_Pos_Pojo>();
		listuserPOStable = mappingDao.findAll();
		for(User_POS_Mapping userPOSTable : listuserPOStable)
		{
			User_Pos_Pojo UserposDto=new User_Pos_Pojo();
			BeanUtils.copyProperties(userPOSTable, UserposDto);
			
			listuserPOSPojo.add(UserposDto);
		}
		return listuserPOSPojo;
		
	}

	//get all roles in dropdown
	@Override
	public List<String> roleDropdown() throws Exception {
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

	//get all cities in dropdown
	@Override
	public List<String> cityDropdown() throws Exception {
		List<String> cityEntity=null;
		
		
		try {
			cityEntity=cityDao.allCitty();
			
			for(String roletable : cityEntity) {
				System.out.println("cityEntity "+cityEntity);
				
			}
		}
		catch (Exception e) {
			throw new Exception("database error");
		}
		return cityEntity;
	}

	
	//get all user based on role
	@Override
	public List<String> allUserByRole(Role_Table role) throws Exception {
		
		List<String> listuser = null;
		try {
			System.out.println("ASILA");
		listuser = userDAO.findUserByRole(role);
		
		/*for(String listalluser : listuser) {
			System.out.println("listuser "+listalluser);
			
		}*/
		}
		catch (Exception e) {
			throw new Exception("database error");
		}
		return listuser;
	}
	
	
	//get all POS citywise
	@Override
	public List<String> allPOSByCity(String cityname) throws Exception {
		
		List<String> listpos = null;
		try {
			listpos = posDao.findPOSByCity(cityname);
		}
		catch (Exception e) {
			throw new Exception("database error");
		}
		return listpos;
	}

}
