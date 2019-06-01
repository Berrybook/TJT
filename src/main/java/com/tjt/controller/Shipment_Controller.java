package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.Dealer_Pojo;
import com.tjt.dto.Order_Pojo;
import com.tjt.dto.Request_Order_View_Pojo;
import com.tjt.dto.Shipment_Pojo;
import com.tjt.dto.TyreInformationDTO;
import com.tjt.service.Dealer_Service;
import com.tjt.service.Request_Order_Service;
import com.tjt.service.Shipment_Service;
import com.tjt.service.TyreService;

@Controller
public class Shipment_Controller {

	@Autowired
	private Shipment_Service shipment_Service;
	@Autowired
	private Request_Order_Service request_Order_Service;
	@Autowired
	private TyreService tyreService;
	@Autowired
	private Dealer_Service dealer_Service;
	
	
	
	
	@PostMapping("/shipment")
	@ResponseBody
	public Long shipmentController(@RequestBody Shipment_Pojo shipment_Pojo){
		Long result=shipment_Service.generateShipmentOrder(shipment_Pojo);
		return result;
		
	}
	
	
	/*@GetMapping("/vieworder")
	public String viewOrder(HttpServletRequest request){
		String module_Id="WareHouse";
		String role="CityManager";
		String userId="pravat1996";
		List<Request_Order_View_Pojo> allOrder=null;
		allOrder=request_Order_Service.allOrderList(module_Id, role, userId);
		request.setAttribute("view_order",allOrder);
		return "view_order_all";
	}*/
	
	
	@ModelAttribute("tyres")
	public List<TyreInformationDTO> allTyre(){
		List<TyreInformationDTO> listtyre=null;
		try{
		 listtyre=tyreService.listTyre();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listtyre;
	}
	
	@ModelAttribute("allDealer")
	public List<Dealer_Pojo> allDealer(HttpServletRequest request){
		List<Dealer_Pojo> listtyre=null;
		HttpSession session=null;
		session=request.getSession();
		String userId=(String) session.getAttribute("pos");
		try{
		 listtyre=dealer_Service.allDealerByChannelExecutive(userId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return listtyre;
	}
	
	
	@GetMapping("/vieworderByorderId")
	public String  viewOrderByorderId(ModelMap map,@RequestParam long order_id,HttpServletRequest request){
		Order_Pojo order=request_Order_Service.viewOrderBYOrderId(order_id);
		request.setAttribute("view",order);
		map.put("view_orders", order);
		return "view_order";
	}
	
	@GetMapping("/shimentConformByWareHouse")
	@ResponseBody
	public List<Shipment_Pojo> shipmentConform(){
		String wareHouse_Id="hyd001";
		List<Shipment_Pojo> allShipment=null;
		allShipment=shipment_Service.getShipmentOrderByWareHouseId(wareHouse_Id);
		return allShipment;
	}
	@GetMapping("requestOrder")
	public String validateRequest(HttpServletRequest request,@RequestParam String access){
		String moduleId="WareHouse",userId="hyd001",role="POS";
		HttpSession session=null;
		session=request.getSession(false);
		String roles=(String) session.getAttribute("role");
		
		String userIds=(String) session.getAttribute("pos");
		
	//	String validate=request_Order_Service.validationRequest(moduleId, userId, role, access);
	/*
		if(validate=="validate"){
			request.setAttribute("posname", userIds);
			return "order_create";
		}
		request.setAttribute("invalide", "Create not access");
		return "invoicegeneration2";*/
		
		request.setAttribute("posname", userIds);
		return "order_create";
	}
	
	@GetMapping("requestOrderbypos")
	public String requestorderBypos(HttpServletRequest request,@RequestParam String access,Map<String,Object> map){
		
		HttpSession session=null;
		session=request.getSession(false);
		String roles=(String) session.getAttribute("role");
		
		String userIds=(String) session.getAttribute("pos");
		    
			List<Order_Pojo> listro = null;
			listro=request_Order_Service.allOrderList(userIds);
			map.put("orderdetails",listro);
		
	
		
		request.setAttribute("posname", userIds);
		return "order_create_by_pos";
	}
	
	@GetMapping("viewOrder")
	public String validateViewOrder(HttpServletRequest request,@RequestParam String access){
		String moduleId="WareHouse";
		HttpSession session=null;
		session=request.getSession(false);
		String roles=(String) session.getAttribute("role");
	
		String userId=(String) session.getAttribute("pos");
	
		String validate=request_Order_Service.validationRequest(moduleId, userId, roles, access);
	
		if(validate.equals("validate")){
			
			if(roles.equals("POS")){
				List<Order_Pojo> allOrder=null;	
				allOrder=request_Order_Service.allOrderList(userId);
				request.setAttribute("view_order",allOrder);
				return "view_order_by_pos";
			}
			
			else{
			List<Request_Order_View_Pojo> allOrder=null;
			allOrder=request_Order_Service.allOrderList(moduleId, roles, userId);
			request.setAttribute("view_order",allOrder);
			return "view_order_all";
			}
		}
		
		if(roles.equals("CityManager")){
		request.setAttribute("invalide", "Create not access");
		return "city_manager";
		}
		if(roles.equals("POS")){
			
			request.setAttribute("invalide", "Create not access");
			return "welcomeTjTyre";
		}
		if(roles.equals("POSManager")){
			request.setAttribute("invalide", "Create not access");
			return "pos_manager";
		}
		else{
			request.setAttribute("invalide", "Create not access");
			return "factory_manager";
		}
	}
}
