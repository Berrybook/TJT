package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjt.dto.Dealer_Pojo;
import com.tjt.dto.Order_Pojo;
import com.tjt.dto.TyreInformationDTO;
import com.tjt.service.Dealer_Service;
import com.tjt.service.Request_Order_Service;
import com.tjt.service.TyreService;

@Controller
public class Request_Controller {
	
	@Autowired
	private Request_Order_Service request_Order_Service;
	
	@Autowired
	private TyreService tyreService;
	
	@Autowired
	private Dealer_Service dealer_Service;
	
	
	
	@PostMapping("createOrder")
	public String orderCreate(@ModelAttribute Order_Pojo order_Pojo,HttpServletRequest request) throws Exception{
		order_Pojo.setStatus("pending");
		request_Order_Service.requestCreate(order_Pojo);
		HttpSession session=null;
		session=request.getSession(false);
		String userIds=(String) session.getAttribute("pos");
		request.setAttribute("msg", "Successfully Placed");
		request.setAttribute("posname", userIds);
		return "order_create";
	}
	
	
	
	@PostMapping("createOrderByPOS")
	public String orderCreateByPOS(@ModelAttribute Order_Pojo order_Pojo,HttpServletRequest request,Map<String,Object>map) throws Exception{
		order_Pojo.setStatus("pending");
		HttpSession session=null;
		session=request.getSession(false);
		String userIds=(String) session.getAttribute("pos");
		request_Order_Service.requestCreate(order_Pojo);
		List<Order_Pojo> listro = null;
		listro=request_Order_Service.allOrderList(userIds);
		map.put("orderdetails",listro);
		request.setAttribute("msg", "Successfully Placed");
		request.setAttribute("posname", userIds);
		return "order_create_by_pos";
	}
	
	
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
	
	
	//get All OrderList 
	@GetMapping("allOrderList")
	public String allOrderList(Map<String,Object>map) throws Exception{
		List<Order_Pojo> allorderlist=request_Order_Service.allOrderList();
		map.put("orderList", allorderlist);
		return "order_list";
		
	}
	
	@GetMapping("updateStatus")
	public String UpdateRequestOrderStatus(Map<String,Object>map,@RequestParam String order_id,@RequestParam String status) throws Exception{
		try{
			Long order_ids=Long.valueOf(order_id);
		request_Order_Service.UpdateRequest_Order_Status(order_ids, status);
		List<Order_Pojo> allorderlist=request_Order_Service.allOrderList();
		map.put("orderList", allorderlist);
		}
		catch(Exception e){
			List<Order_Pojo> allorderlist=request_Order_Service.allOrderList();
			map.put("orderList", allorderlist);
			return "order_list";
		}
		return "order_list";
	}
	
	@GetMapping("dealerupdateStatus")
	public String DealeUpdateStatus(HttpServletRequest request,Map<String,Object>map,@RequestParam String order_id,@RequestParam String status) throws Exception{
		HttpSession session =null;
		
		session=request.getSession(false);
		
		String delaerId=(String) session.getAttribute("delaer_id");
		try{
			Long order_ids=Long.valueOf(order_id);
		request_Order_Service.UpdateRequest_Order_Status(order_ids, status);
		List<Order_Pojo> listOrderView=request_Order_Service.viewOrderByDealer(delaerId);
		map.put("viewOrderByDealer", listOrderView);
		
		}
		catch(Exception e){
			List<Order_Pojo> listOrderView=request_Order_Service.viewOrderByDealer(delaerId);
			map.put("viewOrderByDealer", listOrderView);
			return "view_order_delaer";
		}
		return "view_order_delaer";
	}
	

}
