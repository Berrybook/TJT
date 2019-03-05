package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.City_DTO;
import com.tjt.service.CityService;

@Controller
public class CityController {

		@Autowired
		private CityService cityservice;
		
		
		@RequestMapping(value="createcity",method=RequestMethod.GET)
		public String createCity(HttpServletRequest request,Map<String,Object> map){
			HttpSession session=null;
			List<City_DTO> citydto = null;
			//create Session object
			session=request.getSession(false);
			String admin=(String) session.getAttribute("admin");
			try{
				citydto = cityservice.listcity();
				
				map.put("allCity", citydto);
			//test the session is equals to admin or null if admin null then it goes to catch block
			if(admin.equals("admin")){
			request.setAttribute("cityReg", "cityReg");
			
			}
			 return "cityReg";
			}
			catch(Exception e){
				request.setAttribute("SessionTimeOut", "Should enter Username and Password");
				return "login";
			}
		}//end
		
		/*@ResponseBody*/
		@RequestMapping(value="addcity",method=RequestMethod.POST)
		public String addCity(HttpServletRequest request,@ModelAttribute City_DTO dto,BindingResult result,Map<String,Object> map) throws Exception {
			List<City_DTO> citydto = null;
			try {
			
			cityservice.createCity(dto);
			citydto = cityservice.listcity();
			map.put("allCity", citydto);
			}
			catch(Exception e)
			{
				request.setAttribute("city_registration", "City Unsuccessfully Registered");
				citydto = cityservice.listcity();
				map.put("allCity", citydto);
				return "cityReg";
			}
			request.setAttribute("city_registration", "City Successfully Registered");
			return "cityReg";
		}
		
		
	/*	@ResponseBody*/
		@ModelAttribute("listofcity")
		public List<City_DTO> listcityinfo(){
			List<City_DTO> citydto = null;
		
			try{
				citydto = cityservice.listcity();
				
			}
			catch(Exception e){
				
			}
			return citydto;
			
		}
		
		@ResponseBody
		@RequestMapping(value="/deletecity/{cityname}",method=RequestMethod.DELETE)
		public String deleteCity(@PathVariable("cityname") String cityname,HttpServletRequest request) {
			
			//String cityname = request.getParameter("cityname");
			try {
				cityservice.deleteCity(cityname);
				request.setAttribute("delete mode", "City Deleted Successfully");
				return "City Deleted Successfully";
			}
			catch(Exception e){
				
				request.setAttribute("delete mode", "City Deleted Successfully");
				return "City Deleted Successfully";
						
			}
		}
		
}
		
