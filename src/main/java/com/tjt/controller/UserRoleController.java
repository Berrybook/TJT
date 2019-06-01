package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.RoleDTO;
import com.tjt.dto.UserDTO;
import com.tjt.dto.User_Role_Mapping_DTO;
import com.tjt.service.UserRoleMappinService;

@Controller
public class UserRoleController {
	
	@Autowired UserRoleMappinService urService;
	
	
	@RequestMapping(value="createuserrolemappinglink",method=RequestMethod.GET)
	public String createroleaccess(HttpServletRequest request,Map<String,Object> map){
		HttpSession session=null;
		List<User_Role_Mapping_DTO> accessdto = null;
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
			accessdto = urService.listUserRoleMapping();
			map.put("allUserRole", accessdto);
		//test the session is equals to admin or null if admin null then it goes to catch block
		
		 return "userRoleMapping";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
} 
	
	//save all userRoleMapping Data

	@RequestMapping(value="createUserRoleMapping",method=RequestMethod.POST)
	public String createUserRoleMapping(@ModelAttribute User_Role_Mapping_DTO dto,HttpServletRequest request,Map<String,Object> map){
		List<User_Role_Mapping_DTO> accessdto = null;
		try {
			urService.createUserRoleMapping(dto); 
			accessdto = urService.listUserRoleMapping();
			map.put("allUserRole", accessdto);
		}
		catch(Exception e){
			request.setAttribute("MAPPING_FAILED","RoleUserMapping Failed ");
			return "userRoleMapping";
			
		}
		request.setAttribute("MAPPING_FAILED","RoleUserMapping  successfully Done ");
		return "userRoleMapping";
		
	}
	
	//shows all data in list
		/*@ModelAttribute("alluser")*/
		@RequestMapping(value="showlist",method=RequestMethod.GET)
		public List<User_Role_Mapping_DTO> listUserRoleMapping()
		{
			List<User_Role_Mapping_DTO> urDto = null;
		System.out.println("hhhhh");
			try{
				urDto = urService.listUserRoleMapping();
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return urDto;
		}
		
		

//role dropdown
		
		@ModelAttribute("getAllRole")
		public List<String> allRole(){
			List<String> listRole=null;
			
			System.out.println("fff");
			ResponseEntity<List<String>> listhh=null;
			try{
				listRole=urService.getAllRole();
				
				listhh=new ResponseEntity<>(listRole, HttpStatus.MULTI_STATUS);
			}
				catch(Exception e){
					e.printStackTrace();
				}

			return listRole;
		}

		
		//all User in dropdown
		
			
			@ModelAttribute("getallUser")
			public List<String> allUser(){
				List<String> listUser=null;
				

				ResponseEntity<List<String>> listUr=null;
				try{
					listUser=urService.getAllUserId();
					
					listUr=new ResponseEntity<>(listUser, HttpStatus.MULTI_STATUS);
				}
					catch(Exception e){
						e.printStackTrace();
					}

				return  listUser;
			}
		
}	

