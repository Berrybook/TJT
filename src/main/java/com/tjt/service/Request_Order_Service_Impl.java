package com.tjt.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tjt.dao.Order_Item_DAO;
import com.tjt.dao.Request_Order_DAO;
import com.tjt.dao.Resource_Role_Access_DAO;
import com.tjt.dto.Order_Pojo;
import com.tjt.dto.Request_Order_View_Pojo;
import com.tjt.entity.Order_Item;
import com.tjt.entity.Request_Order;
import com.tjt.entity.Role_Table;

@Service
@Transactional
public class Request_Order_Service_Impl implements Request_Order_Service {
	@Autowired
	private Request_Order_DAO request_Order_DAO;
	@Autowired
	private Resource_Role_Access_DAO resource_Role_Access_DAO;
	
	@Autowired   
	private Order_Item_DAO itemDAO;
	
	
	@Override
	public String requestCreate(Order_Pojo order_Pojo) throws Exception {
		Request_Order requestorder = null;
		Order_Item orderItem = null;
		
		//get Admin userId for approver
		Role_Table role_Table =new Role_Table();
		role_Table.setRole("ADMIN");
		String approverName=request_Order_DAO.userByAdmin(role_Table);
		
		requestorder = new Request_Order();
		BeanUtils.copyProperties(order_Pojo, requestorder);
		requestorder.setApprover(approverName);
		requestorder=request_Order_DAO.save(requestorder);
		
		orderItem = new Order_Item();
			for (int i = 0; i <order_Pojo.getPattern().length; i++) {
			orderItem = new Order_Item();	
			orderItem.setOrder_Id(requestorder.getOrder_id());
			orderItem.setPattern(order_Pojo.getPattern()[i]);
			orderItem.setSize(order_Pojo.getSize()[i]);
			orderItem.setQuantity(order_Pojo.getQuantity()[i]);
			orderItem = itemDAO.save(orderItem);
			}

		return "";
	}
	
	@Override
	public List<Request_Order_View_Pojo> allOrderList(String module_Id, String role, String userId) {
		List<Request_Order_View_Pojo> listOrder=null;
		List<Object[]> allOrder=null;
		listOrder=new ArrayList<Request_Order_View_Pojo>();
		
		allOrder=request_Order_DAO.allRequestOrderByModule_IdAndRoleAndUserId(module_Id,role,userId);
		
		for (Object[] objects : allOrder) {
			Request_Order_View_Pojo Request_Order_View=new Request_Order_View_Pojo();
			Request_Order_View.setOrder_id((Long) objects[0]);
			Request_Order_View.setRaised_By((String) objects[1]);
			listOrder.add(Request_Order_View);
		}
		return listOrder;
	}
	
	
	@Override
	public Order_Pojo viewOrderBYOrderId(Long order_Id) {
		Request_Order request_Order=request_Order_DAO.getOne(order_Id);
		List<Object[]> order_item=request_Order_DAO.order_ItemByOrderId(order_Id);
		Order_Pojo order_pojo=new Order_Pojo();
		BeanUtils.copyProperties(request_Order, order_pojo);
		String[] pattern=null;
		String[] size=null;
		Long[] quantity=null;
		int i=0;
		quantity=new Long[order_item.size()];
		pattern=new String[order_item.size()];
		size=new String[order_item.size()];
		for (Object[] objects : order_item) {
			pattern[i]=(String) objects[0];
			size[i]=(String) objects[1];
			quantity[i]=(Long) objects[2];
			i++;
		}
		order_pojo.setPattern(pattern);
		order_pojo.setSize(size);
		order_pojo.setQuantity(quantity);
		return order_pojo;
	}
	
	@Override
	public String validationRequest(String moduleId,String UserId,String role,String access){
		String level="";
		if(role.equals("POS")){
			level=resource_Role_Access_DAO.levelByROleAndModuleAndModuleId(moduleId, UserId, role);
		}
		else{
			level=resource_Role_Access_DAO.levelByROleAndModuleAndUserId(moduleId, UserId, role);
		}
	
		Integer valiadte=resource_Role_Access_DAO.allAccessByROle(moduleId, level, role,access);
		
		if(valiadte==0){
			return "invalidate";
		}
		
		return "validate";
	}

	@Override
	public List<Order_Pojo> allOrderList(String userId) {
		List<Object[]> listOrder=null;
		
		List<Order_Pojo> listorders=null;
		
		listorders=new ArrayList<Order_Pojo>();
		listOrder=request_Order_DAO.orderByReasedBy(userId);
		
		for (Object[] orders : listOrder) {
			Order_Pojo order_Pojo=new Order_Pojo();
			Long order_id=(Long) orders[0];
			order_Pojo.setOrder_id(order_id);
			order_Pojo.setRaised_By((String) orders[1]);
			order_Pojo.setRequisation_Date( (Date) orders[2]);
			order_Pojo.setPriority((String) orders[3]);
			order_Pojo.setDealer_id((String) orders[4]);
			order_Pojo.setStatus((String) orders[5]);
			order_Pojo.setApprover((String) orders[6]);
			String[] pattern=null;
			String[] size=null;
			Long[] quantity=null;
			int i=0;
			List<Object[]> order_item=request_Order_DAO.order_ItemByOrderId(order_id);
			quantity=new Long[order_item.size()];
			pattern=new String[order_item.size()];
			size=new String[order_item.size()];
			for (Object[] objects : order_item) {
				pattern[i]=(String) objects[0];
				size[i]=(String) objects[1];
				quantity[i]=(Long) objects[2];
				i++;
			}
			order_Pojo.setPattern(pattern);
			order_Pojo.setSize(size);
			order_Pojo.setQuantity(quantity);
			
			listorders.add(order_Pojo);
			
		}
		return listorders;
	}
	@Override
	public List<Order_Pojo> viewOrderByDealer(String dealer_id) throws Exception {
List<Object[]> listOrder=null;
		
		List<Order_Pojo> listorders=null;
		String approved="approved";
		String reject="rejected";
		String accept="accepted";
		listorders=new ArrayList<Order_Pojo>();
		listOrder=request_Order_DAO.orderViewByDealer(dealer_id,approved, accept, reject);
		
		for (Object[] orders : listOrder) {
			Order_Pojo order_Pojo=new Order_Pojo();
			Long order_id=(Long) orders[0];
			order_Pojo.setOrder_id(order_id);
			order_Pojo.setRaised_By((String) orders[1]);
			order_Pojo.setRequisation_Date( (Date) orders[2]);
			order_Pojo.setPriority((String) orders[3]);
			order_Pojo.setDealer_id((String) orders[4]);
			order_Pojo.setStatus((String) orders[5]);
			order_Pojo.setApprover((String) orders[6]);
			String[] pattern=null;
			String[] size=null;
			Long[] quantity=null;
			int i=0;
			
			List<Object[]> order_item=request_Order_DAO.order_ItemByOrderId(order_id);
			
			quantity=new Long[order_item.size()];
			pattern=new String[order_item.size()];
			size=new String[order_item.size()];
			for (Object[] objects : order_item) {
				pattern[i]=(String) objects[0];
				size[i]=(String) objects[1];
				quantity[i]=(Long) objects[2];
				i++;
			}
			order_Pojo.setPattern(pattern);
			order_Pojo.setSize(size);
			order_Pojo.setQuantity(quantity);
			
			listorders.add(order_Pojo);
			
		}
		return listorders;
	}
	
	
	//get all order Details 
	@Override
	public List<Order_Pojo> allOrderList() throws Exception{
		List<Request_Order> listOrder=null;
		
		List<Order_Pojo> listorders=null;
		
		listorders=new ArrayList<Order_Pojo>();
		listOrder=request_Order_DAO.findAll();
		
		for (Request_Order orders : listOrder) {
			Order_Pojo order_Pojo=new Order_Pojo();
			BeanUtils.copyProperties(orders, order_Pojo);
			String[] pattern=null;
			String[] size=null;
			Long[] quantity=null;
			int i=0;
			List<Object[]> order_item=request_Order_DAO.order_ItemByOrderId(orders.getOrder_id());
			quantity=new Long[order_item.size()];
			pattern=new String[order_item.size()];
			size=new String[order_item.size()];
			for (Object[] objects : order_item) {
				pattern[i]=(String) objects[0];
				size[i]=(String) objects[1];
				quantity[i]=(Long) objects[2];
				i++;
			}
			order_Pojo.setPattern(pattern);
			order_Pojo.setSize(size);
			order_Pojo.setQuantity(quantity);
			
			listorders.add(order_Pojo);
			
		}
		return listorders;
	}

	@Override
	public String UpdateRequest_Order_Status(Long order_id, String status) throws Exception {
		int result=0;
		String responcebody=null;
		try{
		request_Order_DAO.updateRequest_OrderStatus(order_id, status);
		}
		catch(Exception e){
			e.printStackTrace();
			responcebody="not done";
		}
		if(result==0){
			responcebody="not done";
		}
		responcebody="done";
		return responcebody;
	}
}
