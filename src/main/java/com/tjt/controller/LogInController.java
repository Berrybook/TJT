package com.tjt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjt.service.Dealer_Service;
import com.tjt.service.LogInService;
import com.tjt.service.POSService;

@Controller
public class LogInController {
	
	@Autowired
	private POSService service;
	
	@Autowired
	private LogInService userservice;
	
	@Autowired
	private Dealer_Service dealerservice;
	//LogPage Form  
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm(HttpServletRequest request){
		String responsePage="";
		responsePage="login";
		return responsePage;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=null;
		String responsePage="";
		session=request.getSession(false);
		if(session !=null){
			response.setHeader("pragma", "no-cache");  
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Expires", "-1");
		session.invalidate();
		request.setAttribute("logout"," Log Out Successfully ");
		}
		responsePage="login";
		return responsePage;
		
	}
	
	@ModelAttribute("loginByRole")
	public List<String> loginByRole(){
		List<String> rolelogin=null;
		try{
		rolelogin=userservice.getAllROleByLogin();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return rolelogin;
	}
	
	/*@RequestMapping(value="login",method=RequestMethod.POST)
	public String LoginProcess(@RequestParam("role") String role,@RequestParam("pos") String userId,@RequestParam("password")String password,HttpServletRequest request){
		
		String responsePage="";
		HttpSession session=null;
		int count=0;
		String userid=userId.toLowerCase();
	
		//create Session object
		session=request.getSession();
		
		if(role.equalsIgnoreCase("POS")){
			
			count=service.autheticate(userid, password);
			if(count==0){
				request.setAttribute("login","Invalid credential");
				responsePage= "login";
				
			}
			else{
				session.setAttribute("pos",userId);
				session.setAttribute("role",role);
				session.setAttribute("possession","possession");
				request.setAttribute("welcome", "WELCOME TO TJTYRE");
				responsePage= "welcomeTjTyre";
			}
		}
		else{
			
			try{
			if(role.equalsIgnoreCase("ADMIN")){
				
				role=userservice.LogIn(userid, password);
				if(role==null){
					request.setAttribute("login","Invalid credential");
					responsePage= "login";
				}
			else{
				session.setAttribute("admin","admin");
				request.setAttribute("welcome", "WELCOME TO TJTYRE");
				String sessions=(String) session.getAttribute("admin");
			
				request.setAttribute("sessions",sessions);
				responsePage= "admin";
				}
			}
			if(role.equalsIgnoreCase("CityManager")){
				
				count=userservice.UserAuthentication(userid, password, role);
				if(count==0){
					request.setAttribute("login","Invalid credential");
					responsePage= "login";
				}
				
				else{
					session.setAttribute("pos",userid);
					session.setAttribute("role",role);
					session.setAttribute("possession","possession");
					request.setAttribute("welcome", "WELCOME TO TJTYRE");
					responsePage= "city_manager";
				}
			}
		}
		catch(Exception e ){
			request.setAttribute("login","Invalid credential");
			responsePage= "login";
		}
			}
		return responsePage;
	}*/
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String LoginProcess(@RequestParam("pos") String pos,@RequestParam("password")String password,HttpServletRequest request) throws Exception {
		
		String responsePage="";
		HttpSession session=null;
		String userid=pos.toLowerCase();
	
		//create Session object
		session=request.getSession();
		String role=null;
		try{
		 role=userservice.LogIn(userid, password);
		 if(role.equalsIgnoreCase("ADMIN")){
				session.setAttribute("admin","admin");
				request.setAttribute("welcome", "WELCOME TO TJTYRE");
				responsePage= "admin";
			}
			/*else if(role.equalsIgnoreCase("SALESMAN")){
				session.setAttribute("pos",pos);
				responsePage= "login";
			}
			else if(role.equalsIgnoreCase("OPERATIONALMANAGER")){
				session.setAttribute("pos",pos);
				responsePage= "omanager";
			}
			else if(role.equalsIgnoreCase("SALESMANAGER")){
				session.setAttribute("pos",pos);
				responsePage= "salesmanager";
			}*/
		 else if(role.equalsIgnoreCase("POSMANAGER")){
			 session.setAttribute("pos", userid);
				 session.setAttribute("POSMANAGER", userid);
			
				responsePage= "posmanagerlogin";
		 }
		 else if(role.equalsIgnoreCase("CHANNELEXECUTIVE")) {
			 session.setAttribute("pos", userid);
			 session.setAttribute("channelexecutive", userid);
			 responsePage= "channelexecutive";
		 }
		 else if(role.equalsIgnoreCase("CityManager")){
			 
			 session.setAttribute("pos",userid);
			session.setAttribute("role",role);
			 responsePage= "city_manager";
		 }
		}
		catch(Exception e){
			int count=0;
			//call authentication  service class Object
			count=service.autheticate(userid, password);
			
		
		
			if(count==0){
				
				//set requestAttribute value for global 
				request.setAttribute("login","Invalid credential");
				responsePage= "login";
				 
				count=dealerservice.authenticate(userid, password);
				 if(count==0)
				 {
					//set requestAttribute value for global 
						request.setAttribute("login","Invalid credential");
						responsePage= "login"; 
				 }
				 else {
					 session.setAttribute("pos",userid);
					 session.setAttribute("delaer_id",userid);
						session.setAttribute("possession","possession");
						request.setAttribute("welcome", "WELCOME TO TJTYRE");
						responsePage= "dealerlogin";
				 }
			}
			else{
				session.setAttribute("pos",userid);
				session.setAttribute("possession","possession");
			System.out.println(userid);
				request.setAttribute("welcome", "WELCOME TO TJTYRE");
				responsePage= "welcomeTjTyre";
			}
		}
		return responsePage;
		
		
	}
	
	
}
