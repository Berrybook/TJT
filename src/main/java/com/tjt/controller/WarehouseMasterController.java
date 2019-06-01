package com.tjt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.City_DTO;
import com.tjt.dto.WarehouseMasterDTO;
import com.tjt.service.WarehouseMasterService;

@Controller
public class WarehouseMasterController {
	
	@Autowired WarehouseMasterService whservice;

	@GetMapping(value="warehouseMasterLink")
	public String CreateLinkWH(HttpServletRequest request) {
		 
		
		try{
		
			request.setAttribute("warehouseMaster", "warehouseMaster");
		
			return "warehouseMaster"; 
		}
		catch (Exception e) {
			request.setAttribute("session time out", "Should enter Username and Password");
		}
		
		return "login";
	}
	
	
	@RequestMapping(value="createwarehouses",method=RequestMethod.POST)
	public String CreateWarehouse(@ModelAttribute WarehouseMasterDTO dto,HttpServletRequest request) {
		
		try {
			whservice.CreateWarehouse(dto);
		}
		catch (Exception e) {
			request.setAttribute("warehouse_fail", "Warehouse registration failed");
			return  "warehouseMaster";
		}
		request.setAttribute("WH_SUCCESS","Warehouse Successfully Registered ");
		return  "warehouseMaster";
	}
	
	@ResponseBody
	@RequestMapping(value="showwarehouses",method=RequestMethod.GET)
	public List<WarehouseMasterDTO> listWarehouse(@RequestBody WarehouseMasterDTO dto){
		
		List<WarehouseMasterDTO> listwh=null;
		
		try {
			listwh=whservice.listWarehouse();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return listwh;
		
	}

	
	@ModelAttribute("citydropdown")
	public List<City_DTO> listCity(){
		List<City_DTO> citylist=null;
		
		try {
			citylist=whservice.listCity();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return citylist;
		
	} 
}
