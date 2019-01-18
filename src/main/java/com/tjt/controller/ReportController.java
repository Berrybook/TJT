package com.tjt.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tjt.dto.POSDTO;
import com.tjt.dto.POS_Item_DTO;
import com.tjt.dto.SaleReportDTO;
import com.tjt.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService reportservice;
	
	@RequestMapping(value="/Salereport",method=RequestMethod.GET)
	public String show(HttpServletRequest request){
		
		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
			request.setAttribute("REPORT", "REPORT_PAGE");
		}
		//RETURN report link JSP PAGES 
		return "reportmain";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			//RETURN LOGIN JSP PAGES 
			return "login";
		}
	}
	
	
	
	@RequestMapping(value="/Salereportbydate")
	public String salereport(HttpServletRequest request){


		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
			request.setAttribute("REPORT", "REPORT_PAGE");
		}
		//RETURN report link JSP PAGES 
		return "report";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			//RETURN LOGIN JSP PAGES 
			return "login";
		}
	}
	
	
	@RequestMapping(value="/listofsalebydate",method=RequestMethod.POST)
	public String listofaslebydate(Map<String,Object> list,HttpServletRequest request){
		
		
		List<SaleReportDTO> salelist = null;
		String pos = request.getParameter("posid");
		String saledate = request.getParameter("saledate");
		String sadledateto = request.getParameter("saledatesecond");
		
		Date date = Date.valueOf(saledate);
		Date dateto = Date.valueOf(sadledateto);
		
		try{
		salelist=reportservice.getSalesDetailsByDate(date,dateto,pos);
		}
		catch(Exception e){
			request.setAttribute("SALESPREPORT", "SOME iNTERNAL PROBLEM ");
			return "admin";
		}
		list.put("listreport", salelist);
		request.setAttribute("REPORT", "REPORT_LIST");
		request.setAttribute("POS", pos);
	
		return "report";		
	}
	
	
	@RequestMapping(value="/listofstock",method=RequestMethod.GET)
	public String  listofstock(Map<String,Object >map,HttpServletRequest request){
		
		HttpSession session=null;
		List<POS_Item_DTO> list=null;
		
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
		request.setAttribute("REPORT","STOCK REPORT");
		list= reportservice.getStockDetails();
		map.put("listreport", list);
		}
		//RETURN TYREREG JSP PAGES 
		return "stockreport";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			//RETURN LOGIN JSP PAGES 
			if(admin==null){
			return "login";
			}
			request.setAttribute("REPORT", "SOME iNTERNAL PROBLEM ");
			return "admin";
		}
		
		
	}

	
	@ModelAttribute(value="/listofpos")
	public List<POSDTO> listofpos(Map<String,Object> map){
		List<String> showpos = reportservice.getposlist();
		List<POSDTO> posdto = new ArrayList<>();
		for (String posdto2 : showpos) {
			POSDTO posdt = null;
			posdt = new POSDTO();
			posdt.setPos(posdto2);
			posdto.add(posdt);
			
		}
		map.put("poslist", posdto);
		return posdto;
	}

}
