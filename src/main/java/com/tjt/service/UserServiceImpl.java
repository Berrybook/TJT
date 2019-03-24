package com.tjt.service;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tjt.dao.User_Detalis_DAO;
import com.tjt.dto.UserDTO;
import com.tjt.entity.POS_Table;
import com.tjt.entity.Role_Table;
import com.tjt.entity.User_Details_Table;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private User_Detalis_DAO userDAO;
	
	@Override
	public String userCreate(UserDTO dto) throws Exception {
		
		//declare All Local variable 
		User_Details_Table usertable=null;
		Role_Table roleTable=null;
		POS_Table postable=null;
		byte[] file=null;
		String filename=null;
     
		try {
		//create roleTable class Object 
		roleTable=new Role_Table();
		
		//create PoS_Table Class Object 
		postable=new POS_Table();
		
		//create User_Details_Table object
		usertable=new User_Details_Table();
		long size=dto.getIdprofe().getSize();
		ByteBuffer buffer=ByteBuffer.allocate(Long.BYTES);
		buffer.putLong(size);
		file=buffer.array();
		filename=dto.getIdprofe().getOriginalFilename();
		/*//retrive image 
		 ByteBuffer buffer1 = ByteBuffer.allocate(Long.BYTES); 
		 buffer1.put(file, 0, file.length);
	        buffer1.flip();//need flip 
	      //long sizze= buffer.getLong();
	        long sizze= ByteBuffer.wrap(file).getLong();
	        System.out.println("image size "+sizze);
            String base64Image = Base64.getEncoder().encodeToString(file);
            System.out.println("image name "+base64Image);
            */
		//copy role
		roleTable.setRole(dto.getRole());
		postable.setPos(dto.getPos());
		BeanUtils.copyProperties(dto, usertable);
		usertable.setUserid(dto.getUserid().toLowerCase());
		usertable.setRole(roleTable);
		usertable.setPos_table(postable);
		usertable.setIdProfe(file);
		usertable.setIdprofeFilename(filename);
		int count=userDAO.checkUser(usertable.getUserid());
		if(count==0){
		usertable=userDAO.save(usertable);
		return "User Registered Successfully ";
		}
		else{
		return "User Already Exists";
		}
		}
		catch(Exception e) {
			return "User Registered unsuccessfully ";
			
		}
	}

	@Override
	public List<UserDTO> listUser() throws Exception {
				List<UserDTO> listdto=null;
				List<Object[]> listUser=null;
				listdto=new ArrayList<UserDTO>();
				Role_Table role=new Role_Table();
				role.setRole("ADMIN");
					listUser=userDAO.allUserList(role);
					int i=0;
					for (Object[] object: listUser) {
						POS_Table postable=new POS_Table();
						Role_Table roleTable=new Role_Table();
						UserDTO userDTO=new UserDTO();
						postable=(POS_Table) object[i+7];
						roleTable=(Role_Table) object[i+5];
						userDTO.setPos(postable.getPos());
						userDTO.setRole(roleTable.getRole());
						userDTO.setUserid((String) object[i]);
						userDTO.setPassword((String) object[i+1]);
						userDTO.setMobilenumber((Long) object[i+2]);
						userDTO.setAddress((String) object[i+3]);
						userDTO.setMailid((String) object[i+4]);
						userDTO.setRole(roleTable.getRole());
						userDTO.setUserName((String) object[i+6]);
						userDTO.setPos(postable.getPos());
						listdto.add(userDTO);
						}
				
				return listdto;
	
	}

	@Override
	public UserDTO userById(HttpServletRequest request,String userid) throws Exception {
		HttpSession session=null;
		
		User_Details_Table user=new User_Details_Table();
		UserDTO dto=new UserDTO();
		user=userDAO.getOne(userid);
		session=request.getSession(false);
		session.setAttribute("filename", user.getIdprofeFilename());
		session.setAttribute("multipartfile", user.getIdProfe());
		BeanUtils.copyProperties(user, dto);

		/*ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES); 
		 buffer.put(user.getIdProfe(), 0, user.getIdProfe().length);
	        buffer.flip();//need flip 
	      //long sizze= buffer.getLong();
	        long sizze= ByteBuffer.wrap(user.getIdProfe()).getLong();
           String base64Image = Base64.getEncoder().encodeToString(user.getIdProfe());
           dto.setImage(base64Image);*/
		
		return dto;
	}
	@Override
	public String UserUpdate(HttpServletRequest request,UserDTO dto) throws Exception {
		//declare All Local variable 
				User_Details_Table usertable=null;
				Role_Table roleTable=null;
				POS_Table postable=null;
				byte[] file=null;
				String fileName=null;
				long size=0l;
				HttpSession session=null;
				
				//get Session 
				session=request.getSession(false);
				//create roleTable class Object 
				roleTable=new Role_Table();
				
				//create PoS_Table Class Object 
				postable=new POS_Table();
				
				//create User_Details_Table object
				usertable=new User_Details_Table();
				
				size=dto.getIdprofe().getSize();
				if(size==0){
					fileName=(String) session.getAttribute("filename");
					file=(byte[]) session.getAttribute("multipartfile");
				}
				else{
				ByteBuffer buffer=ByteBuffer.allocate(Long.BYTES);
				buffer.putLong(size);
				file=buffer.array();
				fileName=dto.getIdprofe().getOriginalFilename();
				}
				
				//copy role
				roleTable.setRole(dto.getRole());
				postable.setPos(dto.getPos());
				BeanUtils.copyProperties(dto, usertable);
				usertable.setRole(roleTable);
				usertable.setPos_table(postable);
				usertable.setIdProfe(file);
				usertable.setIdprofeFilename(fileName);
				usertable=userDAO.save(usertable);
				
				if(usertable ==null){
					return "User  updated unsuccessfully";
				}
				
				return "User updated  successfully ";
	}

	@Override
	public void  deleteUser(HttpServletRequest request,String userid) throws Exception {
		
		userDAO.deleteById(userid);
		
		
			}

}
