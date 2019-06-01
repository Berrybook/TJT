package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjt.dto.Order_Pojo;
import com.tjt.service.Request_Order_Service;


@Controller
public class ViewOrderController {

	@Autowired Request_Order_Service roService;
	
	
@RequestMapping(value="viewOrderLink")
	public String CreateLinkWH(HttpServletRequest request,Map<String,Object >map) {
		HttpSession session=null;
		//create session object
		session = request.getSession(false);
		String channelexecutive=(String) session.getAttribute("channelexecutive"); 
		
		List<Order_Pojo> listro = null;
		
		try{
			
			
			listro=roService.allOrderList(channelexecutive);
			map.put("orderdetails",listro);
			
			return "viewOrderChannelExecutive"; 
			//return listro; 
		}
		catch (Exception e) {
			request.setAttribute("session time out", "Should enter Username and Password");
			e.printStackTrace();
		}
		
		return "viewOrderChannelExecutive";
	}
	

	
	
}
