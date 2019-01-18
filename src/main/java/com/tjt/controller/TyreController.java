package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.tjt.dto.TyreInformationDTO;
import com.tjt.dto.TyreInformationDTO2;
import com.tjt.service.TyreService;

@Controller
public class TyreController {

	@Autowired
	private TyreService tyreService;
	
	//Show Tyre Form
	@RequestMapping(value="/tyrecreate",method=RequestMethod.GET)
	public String tyreCreate(HttpServletRequest request){
		
		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
		request.setAttribute("TYRE_HOME","TYRE_REG");
		}
		//RETURN TYREREG JSP PAGES 
		return "tyreReg";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			//RETURN LOGIN JSP PAGES 
			return "login";
		}	
	}//end
	
	//Process Tyre Information
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/tyrecreate",method=RequestMethod.POST)
	public String tyreProcess(HttpServletRequest request,@ModelAttribute TyreInformationDTO dto,Map<String,Object>map){
		List<TyreInformationDTO2> listDto=null;
		HttpSession session=null;
		String result=null;
		//create Session object
		session=request.getSession(false);
		listDto=(List<TyreInformationDTO2>) session.getAttribute("listtyre");
		try{
			//CREATE NEW TYRE 
			result=tyreService.tyreSave(dto);
			request.setAttribute("TYREREGISTRATION",result);
		}
		catch(Exception e){
			request.setAttribute("TYRE_NOT_SUCCESS"," REGISTARE FAILS,TRY AGAIN");
			map.put("listDto", listDto);
			return "listtyre";
		}
		map.put("listDto", listDto);
		return "listtyre";
	}
	
	
	//List Of Tyre Info
	@RequestMapping(value="listtyre",method=RequestMethod.GET)
	public String listTyre(HttpServletRequest request,Map<String,Object>map){
		
		
		HttpSession session=null;
		List<TyreInformationDTO2> listDto=null;
		
		//create Session object
		session=request.getSession(false);
		
		//GET VALUE FOR SESSION ATTRIBUTE 
		String admin=(String) session.getAttribute("admin");
		
		try{
			//test the session is equals to admin or null if admin null then it goes to catch block
			if(admin.equals("admin")){
				request.setAttribute("listtyre", "LISTTYRE");
				//get all Tyre list 
				listDto=tyreService.listTyre();				
				//put listTyre into the map collection 
				map.put("listDto", listDto);
				session.setAttribute("listtyre", listDto);
			}
			//return tyreReg JSP page 
			return "listtyre";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			if(admin==null){
				//RETURN LOGIN JSP PAGES 
				return "login";
			}
			request.setAttribute("listtyre", listDto);
			//RETURN TYREREG JSP PAGES 
			return "listtyre";
		}//END CATCH
	}//END TYRELIST SERVICE
	
	//UPDATE TYRE UPDATE FORM
	@RequestMapping(value="tyreupdate",method=RequestMethod.GET)
	public String invoiceUpdate(Map<String ,Object> map,HttpServletRequest request ) throws Exception{
		HttpSession session=null;
		TyreInformationDTO2 dto=null;
		String tyrepattern=null;
		String tyresize=null;

		//create Session object
		session=request.getSession(false);
		//GET VALUE FOR SESSION ATTRIBUTE 
		String admin=(String) session.getAttribute("admin");
		try{
			//test the session is equals to admin or null if admin null then it goes to catch block
			if(admin.equals("admin")){
				//SET JSP PAGE REQUESTED VALUE IN IN TYREPATTREN
				tyrepattern=request.getParameter("tyrepattern")	;
				
				//SET JSP PAGE REQUESTED VALUE IN IN TYREPATTREN
				tyresize=request.getParameter("tyresize");
				
				//SET VALUE IN  REQUEST ATTRIBUTE TO USE FOR JSP PAGE 
				request.setAttribute("updatemode", "UPDATE_MODE");
				
				//GET TYRE INFORMATION OF THE PARTICULAR TYREPATTREN AND TYRESIZE 
				 dto=tyreService.tyrelistById(tyrepattern,tyresize);
				 
				 //PUT VALUE  IN MAP COLLECTION TO USE JSP PAGE 
				 map.put("update",dto);
			}
			//RETURN TYREREG JSP PAGES 
			return "tyreReg";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			//CHECK ADMIN IS NULL OR NOT 
			if(admin==null){
				//RETURN LOGIN JSP PAGES 
				return "login";
			}
			request.setAttribute("updatemode", "INTERNAL PROBLEM");
			//RETURN ADMIN JSP PAGES 
			return "admin";
		}//END CATCH 
		
	}//END UPDATE TYRE 
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/updateprocess",method=RequestMethod.POST)
	public String InvoiceUpdateProcess(@ModelAttribute TyreInformationDTO2 dto,Map<String ,Object> map,HttpServletRequest request) {
		List<TyreInformationDTO2> listDto=null;
		HttpSession session=null;
		String res=null;
		//create Session object
		session=request.getSession(false);
		listDto=(List<TyreInformationDTO2>) session.getAttribute("listtyre");
		
		try{
		
		//UPDATED VALUE FOR SPECIFIC TYREPATTREN AND TYRESIZE 
		res=tyreService.tyreUpdate(dto);
		
		 //PUT VALUE  IN MAP COLLECTION TO USE JSP PAGE 
		 map.put("update", res);
		 map.put("listDto", listDto);
		 request.setAttribute("updatemode",res);
		//RETURN ADMIN JSP PAGES 
		 return "listtyre";
		}
		catch(Exception e){

			//SET VALUE IN  REQUEST ATTRIBUTE TO USE CONFORMATION MESSAGE TO USER 
			request.setAttribute("updatemodefail", "TYRE_UPDATE FAIL");
			map.put("listDto", listDto);
			//RETURN ADMIN JSP PAGES 
			 return "listtyre";
		}
		
	}//end update
	
	
		@RequestMapping(value="/tyredelete",method=RequestMethod.GET)
		public String  tyreDelete(HttpServletRequest request){
		 
		 String tyrepattern=request.getParameter("tyrepattern")	;
		 String tyresize=request.getParameter("tyresize")	;
		try{
			tyreService.tyreDelete(tyrepattern,tyresize);
			 request.setAttribute("deletemode", "TYRE_DELETE SUCCESS");
			return "admin";
		}
		catch(Exception e){
			 request.setAttribute("deletemode", "TYRE_DELETE FAILED");
			return "admin";
		}
		
	}
	
}
