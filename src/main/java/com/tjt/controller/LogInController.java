package com.tjt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjt.service.LogInService;
import com.tjt.service.POSService;

@Controller
public class LogInController {
	
	@Autowired
	private POSService service;
	
	@Autowired
	private LogInService userservice;
	
	
	
	//LogPage Form  
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm(HttpServletRequest request){
		String responsePage="";
		responsePage="login";
		return responsePage;
	}
	
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String LoginProcess(@RequestParam("pos") String pos,@RequestParam("password")String password,HttpServletRequest request) throws Exception {
		
		String responsePage="";
		HttpSession session=null;
		
		//create Session object
		session=request.getSession();
		String role=null;
		try{
		 role=userservice.LogIn(pos, password);
		 if(role.equalsIgnoreCase("ADMIN")){
				session.setAttribute("admin","admin");
				request.setAttribute("welcome", "WELCOME TO TJTYRE");
				responsePage= "admin";
			}
		 else{
			 request.setAttribute("login","Invalid credential");
			 responsePage= "login";
		 }
		}
		catch(Exception e){
			int count=0;
			//call authentication  service class Object
			count=service.autheticate(pos, password);
			
			if(count==0){
				
				//set requestAttribute value for global 
				request.setAttribute("login","Invalid credential");
				responsePage= "login";
			}
			else{
				session.setAttribute("pos",pos);
				session.setAttribute("possession","possession");
				request.setAttribute("welcome", "WELCOME TO TJTYRE");
				responsePage= "welcomeTjTyre";
			}
		}
		return responsePage;
		
		
	}
}
