package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.Dealer_Pojo;
import com.tjt.dto.Order_Pojo;
import com.tjt.entity.User_Details_Table;
import com.tjt.service.Dealer_Service;
import com.tjt.service.Request_Order_Service;

@Controller
public class Dealer_Controller {

	@Autowired
	private Dealer_Service dealer_Service;
	
	@Autowired
	private Request_Order_Service request_Order_Service;
	
	@GetMapping("/create_Dealer")
	public String create_Dealer_form(Map<String,Object> map,HttpServletRequest req) throws Exception{
		List<Dealer_Pojo> alldealer=dealer_Service.allDealer();
	
		map.put("alldealer", alldealer);
		return "dealer_reg";
	}
	
	@ModelAttribute("chhanelExecutive")
	public List<User_Details_Table> allChanneExecutive(){
		List<User_Details_Table> allChhanelExecutive=null;
		try{
			allChhanelExecutive=dealer_Service.allChannelExecutive();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return allChhanelExecutive;
	}
	
	@PostMapping("/create_Dealer")
	public String create_Dealer(@ModelAttribute Dealer_Pojo dealer_Pojo,Map<String,Object>map,HttpServletRequest req){
		try{
		String result=dealer_Service.create_Dealer(dealer_Pojo);
		List<Dealer_Pojo> alldealer=dealer_Service.allDealer();
		req.setAttribute("msg", "Successfully Placed");
		map.put("alldealer", alldealer);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "dealer_reg";
	}
	
	@GetMapping("viewDealer")
	public String viewOrderByDealer(HttpServletRequest request,Map<String,Object> map) throws Exception{
		HttpSession session =null;
		
		session=request.getSession(false);
		
		String delaerId=(String) session.getAttribute("delaer_id");
		
		List<Order_Pojo> listOrderView=request_Order_Service.viewOrderByDealer(delaerId);
		map.put("viewOrderByDealer", listOrderView);
		return "view_order_delaer";
	}
	
	
}
