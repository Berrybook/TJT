package com.tjt.service;

import java.util.List;

import com.tjt.dto.Order_Pojo;
import com.tjt.dto.Request_Order_View_Pojo;

public interface Request_Order_Service {

	
	public List<Request_Order_View_Pojo> allOrderList(String module_Id,String role,String userId);
	public Order_Pojo viewOrderBYOrderId(Long order_Id) ;
	public String validationRequest(String moduleId, String UserId, String role, String access);
	public String requestCreate(Order_Pojo order_Pojo) throws Exception;
	public List<Order_Pojo> allOrderList(String userId);
	public  List<Order_Pojo> viewOrderByDealer(String dealer_id)throws Exception ;
	List<Order_Pojo> allOrderList() throws Exception;
	public String UpdateRequest_Order_Status(Long order_id,String status)throws Exception;
	

}
