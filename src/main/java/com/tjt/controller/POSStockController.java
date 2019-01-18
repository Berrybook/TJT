package com.tjt.controller;


import java.util.ArrayList;
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

import com.tjt.dto.POSDTO;
import com.tjt.dto.POSItemDTO;
import com.tjt.dto.TyreInformationDTO2;
import com.tjt.service.POSStockService;

@Controller
public class POSStockController {

	@Autowired
	private POSStockService stockservice; 
	
	
	@RequestMapping(value="stocklink",method=RequestMethod.GET)
	public String stockLink(HttpServletRequest request) {
		
		HttpSession session=null;
		String responsePage="";
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
			request.setAttribute("positemstock","positemstock");
		}
		//RETURN TYREREG JSP PAGES 
		responsePage= "stockLink";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			//RETURN LOGIN JSP PAGES 
			responsePage= "login";
		}
		
		return responsePage;
	}
	//create the pos stock 
	@RequestMapping(value="posstockquantity",method=RequestMethod.GET)
	public String posItemCreate(HttpServletRequest request){
		String responsePage="";
		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
			request.setAttribute("positemstock","positemstock");
		}
		//RETURN TYREREG JSP PAGES 
		responsePage = "posstock";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			//RETURN LOGIN JSP PAGES 
			responsePage= "login";
		}
		return responsePage;
	}
	@RequestMapping(value="posstockquantity",method=RequestMethod.POST)
	public String posItemProcess(Map<String,Object> map,HttpServletRequest request, @ModelAttribute POSItemDTO positemdto,BindingResult result ){
		//check the model class field is valid or not 
		String responsePage="";
			if(result.hasErrors()){
				request.setAttribute("validationFailed", "validation Failed");
				responsePage= "posstock";
			}
			else{
				
				
				try{
					//Quantity add In all Tyre  from  POS-ITEM 
					stockservice.posItemQuantityAssign(positemdto);
				}
				catch(Exception e){
					request.setAttribute("posstock","POS STOCK PROBLEM");
					responsePage= "admin";
				}
				//set value for request attribute in global visible 
				request.setAttribute("posstock","QUANTITY ADDING SUCESSFULLY");
				
				//send redirect to invoice Details pages
				responsePage= "admin";
		}
			return responsePage;
	}
			
	
	//create the POS and Item Assignment  form page 
		@RequestMapping(value="positemassign",method=RequestMethod.GET)
		public String posItemAssign(HttpServletRequest request){
			
			HttpSession session=null;
			String responsePage="";
			
			//create Session object
			session=request.getSession(false);
			String admin=(String) session.getAttribute("admin");
			try{
			//test the session is equals to admin or null if admin null then it goes to catch block
			if(admin.equals("admin")){
				request.setAttribute("positemstock","positemstock");
			}
			//RETURN TYREREG JSP PAGES 
			responsePage= "positemassign";
			}
			catch(Exception e){
				request.setAttribute("SessionTimeOut", "Should enter Username and Password");
				//RETURN LOGIN JSP PAGES 
				responsePage= "login";
			}
			return responsePage;
		}
		
		//create the POS and Item Assignment  Processing  
		@RequestMapping(value="positemassign",method=RequestMethod.POST)
		public String posItemAssignmentProcess(Map<String,Object> map,HttpServletRequest request, @ModelAttribute POSItemDTO positemdto,BindingResult result ){
			String responsePage="";
			//check the model class field is valid or not 
				if(result.hasErrors()){
				
					responsePage= "admin";
				}
				else{
					//get AllTyre Value in Value Param 
					String allTyre=request.getParameter("alltyre");
						try{
							
							//Assign Tyre In Each POS 
							stockservice.posItemAssignment(positemdto, allTyre);
						}
						catch(Exception e){
							request.setAttribute("posstock","POS STOCK PROBLEM");
							responsePage= "admin";
						}
						//set value for request attribute in global visible 
						request.setAttribute("posstock","POS TYRE ASSIGNMENT SUCESSFULLY");
					
						//send redirect to invoice Details pages
						responsePage= "admin";
						}
				return responsePage;
		}

	@ModelAttribute("tyreid")
	public List<TyreInformationDTO2> findTyreid(){
		
		
		
		List<TyreInformationDTO2> list=null;
		
		try{
		//get All TyrePattern 
		list=stockservice.listtyreid();
		}
		catch(Exception e){
			return list;
		}
		
		return list;
	}
	@ModelAttribute("posid")
	public List<POSDTO> findposid(){
		
		List<String> listpos=null;
		
		List<POSDTO> list=new ArrayList<POSDTO>();
		
		try{
		//get All TyrePattern 
		listpos=stockservice.listpos();
		for (String pos : listpos) {
			POSDTO dto=new POSDTO();
			dto.setPos(pos);
			list.add(dto);
		}
		}
		catch(Exception e){
			return list;
		}
		
		return list;
	}
	
	
	

	@ModelAttribute("positemid")
	public List<TyreInformationDTO2> findPosItemid(){
		
		List<TyreInformationDTO2> listtyre=null;
		
		try{
		//get All TyrePattern 
		listtyre=stockservice.listpostyreid();
		}
		catch(Exception e){
			
			return listtyre;
		}
		return listtyre;
		
	}
	
	
	@RequestMapping(value="posname/{tyreid}",method=RequestMethod.GET)
	@ResponseBody
	public List<String> findposname(@PathVariable("tyreid")Long tyre){
		
		List<String> listpos=null;
		
		
		try{
		//get All TyrePattern 
		listpos=stockservice.listposname(tyre);
		}
		catch(Exception e){
			return listpos;
		}
		
		return listpos;
	}
	
	@RequestMapping(value="quantityadd",method=RequestMethod.GET)
	public String quantityadd(HttpServletRequest request){
		
		request.setAttribute("positemstock","positemstock");
		
		return "posstockquantityentry";
	}
	
	
	@RequestMapping(value="quantityadd",method=RequestMethod.POST)
	public String quantityaddprocess(Map<String,Object> map,HttpServletRequest request, @ModelAttribute POSItemDTO positemdto,BindingResult result){
		String responsePage="";
		//check the model class field is valid or not 
		if(result.hasErrors()){
		
			responsePage= "admin";
		}
		else{
			
			//call service layer to  save  Method 
			try {
			stockservice.posUpdate(positemdto);
			}
			catch(Exception e){
				//set value for request attribute in global visible 
				request.setAttribute("TYREQUANTITY","SOME INTERNAL PROBLEM TRY AGIN");
				//send redirect to invoice Details pages
				responsePage= "admin";
			}
			
			//set value for request attribute in global visible 
			request.setAttribute("TYREQUANTITY","TYRE QUANTITY SUCCESSFULLY ADDING");
			
			//send redirect to invoice Details pages
			responsePage= "admin";
	}
		return responsePage;
	}
	
	
}
