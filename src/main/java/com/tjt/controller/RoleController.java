package com.tjt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.tjt.dto.RoleDTO;
import com.tjt.service.RoleService;


@Controller
public class RoleController {

	
	@Autowired
	private RoleService roleservice;
	
	@RequestMapping(value="/role")
	public String role(HttpServletRequest request){
		
		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
		request.setAttribute("ROLE_HOME","ROLE_REG");
		}
		//RETURN TYREREG JSP PAGES 
		return "role";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			//RETURN LOGIN JSP PAGES 
			return "login";
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/addrole",method=RequestMethod.POST)
	public String tyreinfo(@RequestBody RoleDTO roledto,HttpServletRequest request){
		try{
			roleservice.addrole(roledto);
		}
		catch(Exception e){
			request.setAttribute("ROLE_FAIL","Role  Unsuccessfully Registered ");
			return "Role  Unsuccessfully Registered ";
		}
		request.setAttribute("ROLE_SUCCESS","Role  Successfully Registered ");
		return "Role  Successfully Registered ";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/listofrole",method=RequestMethod.GET)
	public List<RoleDTO> listtyreinfo(){
		List<RoleDTO> roledto = null;
		try{
			roledto = roleservice.listOfrole();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return roledto;
		
	}
	@RequestMapping(value="/updaterole",method=RequestMethod.PUT)
	@ResponseBody
	public String updatetyreinfo(@ModelAttribute RoleDTO roledto){
	
	roledto.setDescription("SALESMANdescription");
	
	
		try{
			roleservice.updaterole(roledto);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping(value="/deleterole",method=RequestMethod.DELETE)
	@ResponseBody
	public String deletetyreinfo(@RequestBody RoleDTO roledto){
	
		
		try{
			roleservice.deleterole(roledto);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}
