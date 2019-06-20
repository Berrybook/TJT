package com.tjt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.POSDTO;
import com.tjt.entity.TrackingNewEntity;
import com.tjt.service.CustomerInquaryService;
import com.tjt.service.InvoiceGenerationService;
import com.tjt.service.POSService;
import com.tjt.service.TrackSheetModService;

@Controller
public class TrackSheetModeController {

	
	@Autowired
	private TrackSheetModService trackmodecon;
	
	@Autowired
	private InvoiceGenerationService service;
	
	@Autowired
	private CustomerInquaryService customerInquaryService;
	
	@Autowired
	private POSService posService;
	
	
	@GetMapping("trackingsheet")
	public String  trackingsheet(HttpServletRequest req) throws Exception
	{
		HttpSession session = null;
		// create Session object
		session = req.getSession(false);
			String username = (String) session.getAttribute("pos");
			System.out.println("sheet"+username);
//			req.setAttribute("val", customerInquaryService.findsalesman(username));
			req.setAttribute("val",service.allSalesManId(username));
			req.setAttribute("pos", username);
		return "sheetmod";
	}
	
	
	
	@PostMapping("submitsheet")
	public String submitsheet(HttpServletRequest req,@ModelAttribute TrackingNewEntity track) throws Exception
	{
		HttpSession session = null;
		// create Session object
		String msg=trackmodecon.addnewsheet(track);
		session = req.getSession(false);
			String username = (String) session.getAttribute("pos");
			System.out.println("sheet"+username);
//			req.setAttribute("val", customerInquaryService.findsalesman(username));
			req.setAttribute("val",service.allSalesManId(username));
			req.setAttribute("pos", username);
			req.setAttribute("msg", msg);
			System.out.println("Message"+msg);
			return "sheetmod";
	}
	
	//search report 
	@GetMapping("datewisereport")
	public String recordbydate(HttpServletRequest req) throws Exception
	{
		List<POSDTO> listdto=null;
		listdto=posService.listPos();
//		req.setAttribute("val", trackmodecon.recordbydate());
		req.setAttribute("listpos", listdto);
		return "trackgrid";
	}
	
	
	//sum of report grid
	@GetMapping("viewreport")
	public String viewreport(HttpServletRequest req,@RequestParam String date,@RequestParam String pos) throws Exception
	{
		List<POSDTO> listdto=null;
		listdto=posService.listPos();
		req.setAttribute("val", trackmodecon.recordbydate(date,pos));
		req.setAttribute("listpos", listdto);
		return "trackgrid";
	}
	
	//search salesman report day time-slot wise
	@GetMapping("viewreportsalesman")
	public String viewreportsalesman(HttpServletRequest req,@RequestParam String date,@RequestParam String pos,@RequestParam String salesman) throws Exception
	{
		List<POSDTO> listdto=null;
		listdto=posService.listPos();
		req.setAttribute("val", trackmodecon.recordbydatesalesman(date,pos,salesman));
		req.setAttribute("listpos", listdto);
		return "trackgridsalesman";
	}
	
	//grid salesman report day time-slot wise
	@GetMapping("salesmanwisereport")
	public String recordbysalesman(HttpServletRequest req) throws Exception
	{
		List<POSDTO> listdto=null;
		listdto=posService.listPos();
//		req.setAttribute("val", trackmodecon.recordbydate());
		req.setAttribute("listpos", listdto);
		return "trackgridsalesman";
	}
	
	
	//find all salesman by pos
	@ResponseBody
	@GetMapping("/salesmanbypos/{pos}")
	public List<String>  VehicleByArea(@PathVariable("pos")String pos,HttpServletRequest request){
		
		List<String> listsalesman=new ArrayList<>();
		try {
			listsalesman =customerInquaryService.findsalesmanbypos(pos);
		
		}
		 catch(Exception e){
				request.setAttribute("salesman","INTERNAL SOME PROBLEM");
				return listsalesman;	
				
		 }
	
		return listsalesman;
		}
	
	
	
	
	
	
	//pos manager reports
	
		//search salesman report day time-slot wise
			@GetMapping("viewreportPosmanager")
			public String viewreportPosmanager(HttpServletRequest req,@RequestParam String date,@RequestParam String pos,@RequestParam String salesman) throws Exception
			{
				List<POSDTO> listdto=null;
				listdto=posService.listPos();
				req.setAttribute("val", trackmodecon.recordbydatesalesman(date,pos,salesman));
				req.setAttribute("listpos", listdto);
				return "trackgridsalesman_posmanger";
			}
			
			//grid salesman report day time-slot wise
			@GetMapping("salesmanwisereportPosmgr")
			public String salesmanwisereportPosmgr(HttpServletRequest req) throws Exception
			{
				List<POSDTO> listdto=null;
				listdto=posService.listPos();
//				req.setAttribute("val", trackmodecon.recordbydate());
				req.setAttribute("listpos", listdto);
				return "trackgridsalesman_posmanger";
			}
			
			
			//search report 
			@GetMapping("datewisereportPosmgr")
			public String recordbydatePosmgr(HttpServletRequest req) throws Exception
			{
				List<POSDTO> listdto=null;
				listdto=posService.listPos();
//				req.setAttribute("val", trackmodecon.recordbydate());
				req.setAttribute("listpos", listdto);
				return "trackgrid_posmanager";
			}
			
			
			//sum of report grid
			@GetMapping("viewreportPosmgr")
			public String viewreportPosmgr(HttpServletRequest req,@RequestParam String date,@RequestParam String pos) throws Exception
			{
				List<POSDTO> listdto=null;
				listdto=posService.listPos();
				req.setAttribute("val", trackmodecon.recordbydate(date,pos));
				req.setAttribute("listpos", listdto);
				return "trackgrid_posmanager";
			}
			
}
