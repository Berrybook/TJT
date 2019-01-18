package com.tjt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tjt.dto.POSDTO;
import com.tjt.dto.RoleDTO;
import com.tjt.dto.UserDTO;
import com.tjt.service.POSService;
import com.tjt.service.RoleService;
import com.tjt.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private POSService pOsservice;
	
	@RequestMapping(value="/userregistration",method=RequestMethod.GET)
	public String UserRegistration(HttpServletRequest request ){
		
		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
		request.setAttribute("user_form", "user_form");
		}
		 return "user_form";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
		
	}//end 
	
	@RequestMapping(value="/userregistration",method=RequestMethod.POST)
	public String UserProcessing(@ModelAttribute UserDTO dto,HttpServletRequest request ){
		String result=null;
		 try{
			
			 result=userService.userCreate(dto);
		 }
		 catch(Exception e){
			 request.setAttribute("UserRegister", result);
			 return "admin";
		 }
		 request.setAttribute("UserRegister", result);
		return "admin";
	}
	
	@RequestMapping(value="userAll",method=RequestMethod.GET)
	public List<UserDTO> allUser(HttpServletRequest request,Map<String,Object> map){
		List<UserDTO> listdto=null;
		try{
			listdto=userService.listUser();
			map.put("list", listdto);
		}
		catch(Exception e){
			map.put("list", listdto);
			return listdto;
		}
		return listdto;
	}
	
	@RequestMapping(value="userid/{userid}",method=RequestMethod.GET)
	public UserDTO UserById(@PathVariable String userid){
		UserDTO dto=null;
		try{
			 dto=userService.userById(userid);
		}
		catch(Exception e){
			return null;
		}
		return dto;
	}
	
	@RequestMapping(value="/userupdate",method=RequestMethod.POST)
	public String UserUpdate(@ModelAttribute UserDTO dto,HttpServletRequest request ){
		String result=null;
		 try{
			 result=userService.UserUpdate(dto);
		 }
		 catch(Exception e){
			 request.setAttribute("UserUpdate", result);
			 return "admin";
		 }
		 request.setAttribute("UserUpdate", result);
		return "admin";
	}
	
	@RequestMapping(value="userdelete/{userid}",method=RequestMethod.GET)
	public String UserDeleteById(@PathVariable String userid){
		try{
			 userService.userById(userid);
		}
		catch(Exception e){
			return "unsuccessfully";
		}
		return "successfully";
	}
	

	@ModelAttribute("role")
	public List<RoleDTO> findRole(HttpServletRequest request){
		List<RoleDTO> listrole=null;
		List<String> list=null;
		listrole=new ArrayList<RoleDTO>();
		try{
			list=roleService.role();
		
		for (String string : list) {
			RoleDTO dto=new RoleDTO();
			dto.setRole(string);
			listrole.add(dto);
			System.out.println(string);
		}
		}
		catch(Exception e){
			e.printStackTrace();
			return listrole;
		}
		return listrole;
	}
	
	@ModelAttribute("allpos")
	public List<POSDTO> findpos(HttpServletRequest request){
		List<POSDTO> listdto=null;
		
		try{
			listdto=pOsservice.listPos();
		
		}
		catch(Exception e){
			return listdto;
		}
		return listdto;
	}
	
	

}
