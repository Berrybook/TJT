package com.tjt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tjt.dao.User_Detalis_DAO;
import com.tjt.dto.UserDTO;
import com.tjt.entity.POS_Table;
import com.tjt.entity.Role_Table;
import com.tjt.entity.User_Details_Table;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private User_Detalis_DAO userDAO;
	
	@Override
	public String userCreate(UserDTO dto) throws Exception {
		
		//declare All Local variable 
		User_Details_Table usertable=null;
		Role_Table roleTable=null;
		POS_Table postable=null;
		MultipartFile file=null;
     	byte[] idprofe=null;
		
		//create roleTable class Object 
		roleTable=new Role_Table();
		
		//create PoS_Table Class Object 
		postable=new POS_Table();
		
		//create User_Details_Table object
		usertable=new User_Details_Table();
		
		
		//get Attachment in SalesTransactionDTO
     	file=dto.getIdprofe();
     	
     	//Convert the Attachment in byteCode 
     	idprofe=file.getBytes();
		
		//copy role
		roleTable.setRole(dto.getRole());
		postable.setPos(dto.getPos());
		BeanUtils.copyProperties(dto, usertable);
		usertable.setRole(roleTable);
		usertable.setPos_table(postable);
		usertable.setIdProfe(idprofe);
		
		usertable=userDAO.save(usertable);

		if(usertable ==null){
			return "User Registared unsuccessfully";
		}
		
			return "User Registared successfully ";
	}

	@Override
	public List<UserDTO> listUser() throws Exception {
				
				List<User_Details_Table> listUser=null;
				List<UserDTO> listdto=null;
				
				listdto=new ArrayList<UserDTO>();
				
				listUser=userDAO.findAll();
				
				for (User_Details_Table usertable : listUser) {
					POS_Table postable=new POS_Table();
					Role_Table roleTable=new Role_Table();
					UserDTO dto=new UserDTO();
					
					postable=usertable.getPos_table();
					roleTable=usertable.getRole();
					
					//set Value entity class to dto class 
					BeanUtils.copyProperties(usertable, dto);
					dto.setUserid(postable.getPos());
					dto.setRole(roleTable.getRole());
					
					listdto.add(dto);
				}
				
				return listdto;
				
		
	
	}

	@Override
	public UserDTO userById(String userid) throws Exception {
		
		Optional<User_Details_Table> usertable =null;
		
		User_Details_Table user=new User_Details_Table();
		UserDTO dto=new UserDTO();
		
		usertable=userDAO.findById(userid);
		user=usertable.get();
		BeanUtils.copyProperties(dto, user);
		
		return dto;
	}

	@Override
	public String UserUpdate(UserDTO dto) throws Exception {
		//declare All Local variable 
				User_Details_Table usertable=null;
				Role_Table roleTable=null;
				POS_Table postable=null;
				
				//create roleTable class Object 
				roleTable=new Role_Table();
				
				//create PoS_Table Class Object 
				postable=new POS_Table();
				
				//create User_Details_Table object
				usertable=new User_Details_Table();
				
				//copy role
				roleTable.setRole(dto.getRole());
				postable.setPos(dto.getPos());
				BeanUtils.copyProperties(dto, usertable);
				usertable.setRole(roleTable);
				usertable.setPos_table(postable);
				
				usertable=userDAO.save(usertable);
				
				if(usertable ==null){
					return "User  updated unsuccessfully";
				}
				
				return "User updated  successfully ";
	}

	@Override
	public void  deleteUser(String userid) throws Exception {
		
		userDAO.deleteById(userid);
		
		
			}

}
