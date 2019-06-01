package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.User_Pos_Pojo;
import com.tjt.dto.User_Role_Mapping_DTO;
import com.tjt.entity.Role_Table;
import com.tjt.service.UserPOSMappingService;

@Controller 
public class UserPosMappingController {
 
	@Autowired UserPOSMappingService upmappingService;
	
	
	@RequestMapping(value="createUserPOS",method=RequestMethod.GET)
	public String createUserPOS(HttpServletRequest request,Map<String,Object> map){
		HttpSession session=null;
		List<User_Pos_Pojo> accessdto = null;
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
			accessdto = upmappingService.listUserPOSMapping();
			map.put("allUserPOS", accessdto);
		//test the session is equals to admin or null if admin null then it goes to catch block
		
		 return "";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
}
	
	//save all userPOSMapping Data

		@RequestMapping(value="createUserPOSMapping",method=RequestMethod.POST)
		public String createUserPOSMapping(@ModelAttribute User_Pos_Pojo dto,HttpServletRequest request,Map<String,Object> map){
			List<User_Pos_Pojo> accessdto = null;
			try {
				upmappingService.createUserPOSMapping(dto); 
				accessdto = upmappingService.listUserPOSMapping();
				map.put("allUserPOS", accessdto);
			}
			catch(Exception e){
				request.setAttribute("MAPPING_FAILED","UserPOSMapping Failed ");
				return "UserPOSMapping";
				
			}
			request.setAttribute("MAPPING_FAILED","UserPOSMapping  successfully Done ");
			return "UserPOSMapping";
			
		}
	
		
		//shows all data in Grid
		@ResponseBody
		@RequestMapping(value="showUsrMappinList",method=RequestMethod.GET)
		public List<User_Pos_Pojo> listUserPOSMapping()
		{
			List<User_Pos_Pojo> upDto = null;
		System.out.println("yahoooooo");
			try{
				upDto = upmappingService.listUserPOSMapping();
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return upDto;
		}
		

		//All role in drop down
		@ResponseBody		
		@GetMapping("getAllRole")
		public List<String> allRole(){
			List<String> listRole=null;
					
			System.out.println("fff");
			ResponseEntity<List<String>> listhh=null;
			try{
				listRole=upmappingService.roleDropdown();
						
				listhh=new ResponseEntity<>(listRole, HttpStatus.MULTI_STATUS);
			   }
				catch(Exception e){
					e.printStackTrace();
				}

					return listRole;
			}
		
		
		//All city in drop down
		@ResponseBody		
		@GetMapping("getAllCity")
		public List<String> allCity(){
			List<String> listCity = null;
			ResponseEntity<List<String>> listhh=null;
			try{
				listCity=upmappingService.cityDropdown();
						
				listhh=new ResponseEntity<>(listCity, HttpStatus.MULTI_STATUS);
			   }
				catch(Exception e){
					e.printStackTrace();
				}

					return listCity;
			}
		
		//get all userid rolewise 
		@ResponseBody		
		@GetMapping("allUseridByRole/{role}")
		public List<String> allUseridByRole(@PathVariable("role") Role_Table role){
			List<String> listUser = null;
			ResponseEntity<List<String>> listhh=null;
			try{
				
				listUser=upmappingService.allUserByRole(role);
						
				listhh=new ResponseEntity<>(listUser, HttpStatus.MULTI_STATUS);
			   }
				catch(Exception e){
					
					e.printStackTrace();
				}

					return listUser;
			}
		
		
}
