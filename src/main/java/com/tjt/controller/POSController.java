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
import com.tjt.dto.POSDTO;
import com.tjt.service.POSService;

@Controller
public class POSController {
	@Autowired
	private POSService posService;
	
	@RequestMapping(value="Poscreate",method=RequestMethod.GET)
	public String createPOS(HttpServletRequest request){
		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
		request.setAttribute("POS_REG", "POS_REG");
		}
		 return "POS_REG";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
		
	}
	
	@RequestMapping(value="tjtyrePOS",method=RequestMethod.POST)
	public String processPOS(HttpServletRequest request,@ModelAttribute POSDTO dto,BindingResult result){
		try{
			posService.createPOS(dto);
		 }
		 catch(Exception e){
			 request.setAttribute("POS_UNsuccess", "POS Unsuccessfully Registered");
			 return "admin";
		 }
		
		request.setAttribute("POS_success", "POS Successfully Registered");
		 return "admin";
	}
	

	@RequestMapping(value="PosById",method=RequestMethod.GET)
	public String POSById(HttpServletRequest request){
		String pos=null;
		pos=request.getParameter("pos");
		try{
		posService.listById(pos);
		}
		catch(Exception e){
			request.setAttribute("POSById", "INTERNAL PROBLEM TRY AGAIN");
			 return "admin";
		}
		request.setAttribute("POSById", "POSById");
		
		 return "pos_update";
	}
	
	@RequestMapping(value="updatePos",method=RequestMethod.POST)
	public String updatePOS(HttpServletRequest request,@ModelAttribute POSDTO dto,BindingResult result){
		
		try{
			posService.updatePOS(dto);
		 }
		 catch(Exception e){
			 request.setAttribute("POS_UNsuccess_update", "POS Unsuccessfully updated");
			 return "admin";
		 }
		
		request.setAttribute("POS_success_Update", "POS Successfully Updated");
		 return "admin";
	}
	
	@RequestMapping(value="deletePosById",method=RequestMethod.POST)
	public String deletePOSById(HttpServletRequest request){
		String pos=null;
		pos=request.getParameter("pos");
		try{
		posService.deletePOS(pos);
		}
		catch(Exception e){
			request.setAttribute("DELETEBYID", "INTERNAL PROBLEM TRY AGAIN");
			 return "admin";
		}
		request.setAttribute("DELETEBYID", "POS Successfully  DELETED");
		
		 return "admin";
	}
	
	@RequestMapping(value="Posbyall",method=RequestMethod.GET)
	public String POSByAll(HttpServletRequest request,Map<String,Object>map){
		List<POSDTO> listdto=null;
		try{
			listdto=posService.listPos();
			map.put("listpos", listdto);
		}
		catch(Exception e){
			request.setAttribute("POSALL_FAIL", "POSALL_FAIL");
			 return "admin";
		}
		request.setAttribute("FIND_ALL", "FIND_ALL");
		
		 return "pos_ui";
	}
	
	
	@ModelAttribute("allCity")
	public List<City_DTO> listCity(HttpServletRequest request){
		List<City_DTO> listCity=null;
	
		try{
			
		listCity=posService.listCity();
	
		}
		catch(Exception e){
	
		return listCity;
		}
	
		return listCity;
	}
	
	@ResponseBody
	@RequestMapping(value="/findgstno/{city}",method=RequestMethod.GET)
	public String[] findGstNoAndGstAdd(@PathVariable("city")String city){
		String[] gst=null;
		try{
			gst=posService.findGstnoAndGsrAdd(city);
		
		}
		catch(Exception e){
		
			return gst;
		}
		
		
		return gst;
	}
	
}
