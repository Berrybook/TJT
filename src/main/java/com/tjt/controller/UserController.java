package com.tjt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String UserRegistration(HttpServletRequest request ,Map<String,Object> map){
		
		
		List<UserDTO> listdto=null;
		
		
		
		try{
		
		request.setAttribute("userreg", "userreg");
	
		listdto=userService.listUser();
		
		map.put("listUser", listdto);
		 return "user_form";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
		
	}//end 
	
	
	@RequestMapping(value="/userregistration",method=RequestMethod.POST)
	public String UserProcessing(Map<String,Object> map,@ModelAttribute UserDTO dto,HttpServletRequest request ,BindingResult  validate) throws Exception{
		String result=null;
		List<UserDTO> listdto=null;
		 try{
			 result=userService.userCreate(dto);
			 listdto=userService.listUser();
			 map.put("listUser", listdto);
			 request.setAttribute("UserRegister", result);
			 request.setAttribute("userreg", "userreg");
			
		 }
		 catch(Exception e){
			 request.setAttribute("UserRegister", result);
			 request.setAttribute("userreg", "userreg");
			 return "user_form";
		 }
		
		return "user_form";
	}
	@RequestMapping(value="userAll",method=RequestMethod.GET)
	public String allUser(HttpServletRequest request,Map<String,Object> map){
		List<UserDTO> listdto=null;
		
		try{
			listdto=userService.listUser();
			
			map.put("listUser", listdto);
		}
		catch(Exception e){
			map.put("list", listdto);
			return "user_list";
		}
		return "user_list";
	}
	
	@RequestMapping(value="userupdate",method=RequestMethod.GET)
	public String  UserById(HttpServletRequest request,Map<String,Object> map){
		UserDTO userDto=null;
		String userid=null;
		List<UserDTO> listdto=null;
		userid=request.getParameter("userId");
	
		try{
			userDto=userService.userById(request,userid);
			
			 request.setAttribute("userUpdate","userUpdate");
			 map.put("user_update", userDto);
			 
			 listdto=userService.listUser();
			map.put("listUser", listdto);
			
		}
		catch(Exception e){
			map.put("user_update", userDto);
			 request.setAttribute("userUpdate","userUpdate");
			return "user_form";
		}
		return "user_form";
	}
	
	@RequestMapping(value="userupdate",method=RequestMethod.POST)
	public String UserUpdate(@ModelAttribute UserDTO userDto,HttpServletRequest request,Map<String,Object>map ){
		String result=null;
		List<UserDTO> listdto=null;
		String responseBody="";
		 try{
			 
			
			 result=userService.UserUpdate(request,userDto);
			 request.setAttribute("user_update_result", result);
			 listdto=userService.listUser();
			 map.put("listUser", listdto);
			 responseBody= "user_form";
			 request.setAttribute("userreg", "userreg");
		 }
		 catch(Exception e){
			 /*request.setAttribute("UserUpdate", result);*/
			 request.setAttribute("user_update_result", result);
			 request.setAttribute("userreg", "userreg");
			 responseBody= "user_form";
		 }
		
		 
		 return responseBody;
	}
	
	@RequestMapping(value="userdelete/{userid}",method=RequestMethod.GET)
	public String UserDeleteById(@PathVariable String userid,HttpServletRequest request){
		try{
			 userService.userById(request,userid);
		}
		catch(Exception e){
			return "User Unsuccessfully Registered";
		}
		return "User Successfully Registered";
	}
	
	
	@ModelAttribute("role")
	/*@RequestMapping(value="/roles",method=RequestMethod.GET)
	@ResponseBody*/
	public List<RoleDTO>   findRole(HttpServletRequest request){
		List<RoleDTO> listrole=null;
		List<String> list=null;
		listrole=new ArrayList<RoleDTO>();
		try{
			list=roleService.role();
			for (String string : list) {
				RoleDTO role=new RoleDTO();
				role.setRole(string);
				listrole.add(role)
;			}
		}
		catch(Exception e){
			e.printStackTrace();
			return listrole;
		}
		return listrole;
	}
	
	@ModelAttribute("allpos")
	/*@RequestMapping(value="/allpos",method=RequestMethod.GET)
	@ResponseBody*/
	public List<POSDTO> findpos(HttpServletRequest request){
		List<POSDTO> listos=null;
		List<String> list=null;
		list=new ArrayList<>();
		try{
			listos=pOsservice.listPos();
			for (POSDTO posdto : listos) {
				String pos=posdto.getPos();
				list.add(pos);
			}
		}
		catch(Exception e){
			return listos;
		}
		return listos;
	}
}
