package com.tjt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.tjt.dto.SalesTransactionDTO;
import com.tjt.dto.UserDTO;
import com.tjt.service.SalesTransactionService;

@Controller
public class SalesTransactionController {
	
	@Autowired
	private SalesTransactionService salestransactionimpl;
		//TjTyre invoiceGenerate form 
		@RequestMapping(value="/saletransaction",method=RequestMethod.GET)
		public String SalesTransactionForm(HttpServletRequest request){
			HttpSession session=null;
			
			//create Session object
			session=request.getSession(false);
			String possession=(String) session.getAttribute("possession");
			try{
			//test the session is equals to admin or null if admin null then it goes to catch block
			if(possession.equals("possession")){
				request.setAttribute("mode","MODE_INVOICE");
			}
			 return "SalesTransaction";
			}
			catch(Exception e){
				request.setAttribute("SessionTimeOut", "Should enter Username and Password");
				return "login";
			}
		}
	
	
@RequestMapping(value="/saletransaction",method=RequestMethod.POST)
	public String transaction(HttpServletRequest request,@ModelAttribute SalesTransactionDTO dto,BindingResult result) {
	
	if(result.hasErrors()){
		request.setAttribute("transaction","Transaction_faild");
		return "SalesTransaction";
	}
	
	try{
		
		//call service method to execute transaction 
		salestransactionimpl.Salestransaction(dto);
	}
	catch(Exception e){
		request.setAttribute("transaction","Transaction faild");
		return "welcomeTjTyre";
	}
	
		request.setAttribute("transaction","Trasaction Successfully");
		return "welcomeTjTyre";

}

//get all transaction 
@RequestMapping(value="/listtransaction",method=RequestMethod.GET)
public List<SalesTransactionDTO> showtransaction(){
	List<SalesTransactionDTO> salestransaction = null;
	try{
		salestransaction = salestransactionimpl.getallSales();
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}
	return salestransaction;
	
}


//get all userid 
@ModelAttribute("salesidlist")
public List<UserDTO> findSalesmanid(HttpServletRequest request){
	//call the session 
	HttpSession session=request.getSession(false);
	//get session value 
	String pos=(String)session.getAttribute("pos");
	
	List<UserDTO> listdto=null;
	try{
	listdto=salestransactionimpl.allSalesManId(pos);
	}
	catch(Exception e){
		return listdto;
	}
	
	return listdto;
}

}
