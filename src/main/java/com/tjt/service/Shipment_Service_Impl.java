package com.tjt.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.History_Order_Details_DAO;
import com.tjt.dao.History_Shipment_Details_DAO;
import com.tjt.dao.Request_Order_DAO;
import com.tjt.dao.Shipment_DAO;
import com.tjt.dao.Shipment_Item_DAO;
import com.tjt.dto.Shipment_Pojo;
import com.tjt.entity.Historical_Order_Details;
import com.tjt.entity.Request_Order;
import com.tjt.entity.Shipment_Detailes;
import com.tjt.entity.Shipment_Item_Entity;

@Service
public class Shipment_Service_Impl implements Shipment_Service {
	
	@Autowired
	private Shipment_DAO shipment_DAO;
	
	@Autowired
	private Shipment_Item_DAO shipment_Item_DAO;
	
	@Autowired
	private History_Shipment_Details_DAO history_Shipment_Details_DAO;
	
	@Autowired
	private History_Order_Details_DAO history_Order_Details_DAO;
	
	@Autowired
	private Request_Order_DAO request_Order_DAO;
	
	@Override
	public Long generateShipmentOrder(Shipment_Pojo shipment_Pojo) {
		Long responce =0l;
		Shipment_Detailes shipment_Entity=new Shipment_Detailes();
		BeanUtils.copyProperties(shipment_Pojo, shipment_Entity);
		shipment_Entity= shipment_DAO.save(shipment_Entity);
		
		
		for(int i=0;i<shipment_Pojo.getPattern().length;i++){
			Shipment_Item_Entity shipment_Item_Entity =new Shipment_Item_Entity();
			shipment_Item_Entity.setPattern(shipment_Pojo.getPattern()[i]);
			shipment_Item_Entity.setSize(shipment_Pojo.getSize()[i]);
			shipment_Item_Entity.setQuantity(shipment_Pojo.getQuantity()[i]);
			shipment_Item_Entity.setShipment_Number(shipment_Entity.getShipment_Number());
			shipment_Item_DAO.save(shipment_Item_Entity);
			
		}
		
		if(shipment_Entity.equals(null)){
			responce=0l;
		}
		else{
			Request_Order request_Order =new Request_Order();
			//find current date 
			LocalDate currentdate=LocalDate.now();
			Date conformation_Date=Date.valueOf(currentdate);
			
			//Create Historical_Order_Details Object 
			Historical_Order_Details historical_Order_Details=new Historical_Order_Details();
			
			//get requestOrder By orderId 
			request_Order=request_Order_DAO.getOne(shipment_Entity.getOrderNumber());
			
			//set all request_order value in historical order Object
			historical_Order_Details.setOrder_id(request_Order.getOrder_id());
			historical_Order_Details.setRaised_By(request_Order.getRaised_By());
			historical_Order_Details.setPriority(request_Order.getPriority());
			historical_Order_Details.setUserId(request_Order.getDealer_id());
			historical_Order_Details.setRequisation_Date(request_Order.getRequisation_Date());
			historical_Order_Details.setConformation_Date(conformation_Date);
			
			//order transfer for order_table to historical table 
			historical_Order_Details=history_Order_Details_DAO.save(historical_Order_Details);
			
			//delete order_id by request_order 
			request_Order_DAO.deleteById(request_Order.getOrder_id());
			responce=shipment_Entity.getShipment_Number();
			
		}
		return responce;
	}
	@Override
	public List<Shipment_Pojo> getAllShipmentOrder(Shipment_Pojo shipment_Pojo) {
		
		return null;
	}
	
@Override
public List<Shipment_Pojo> getShipmentOrderByWareHouseId(String warehouseId) {

		
		List<Shipment_Pojo> shipments=null;
		
		List<Object[]> shipmentList=null; 
		shipments=new ArrayList<>();
		
		String[] pattern=null;
		String[] size=null;
		Long[] quantity=null;
		
		shipmentList=history_Shipment_Details_DAO.allShipmentByWareHouseId(warehouseId);
		for (Object[] shipment_list : shipmentList) {
			Shipment_Pojo shipment_pojo=new Shipment_Pojo();
			shipment_pojo.setShipment_Number( (Long) shipment_list[0]);
			shipment_pojo.setOrderNumber((Long) shipment_list[1]);
			shipment_pojo.setShipment_By((String) shipment_list[2]);
			shipment_pojo.setShipmentDate((Date) shipment_list[3]);
			shipment_pojo.setOrder_Raised_From((String) shipment_list[4]);
			shipment_pojo.setTransportMode((String) shipment_list[5]);
			shipmentList=history_Shipment_Details_DAO.allShipmentItemByshipmentId(shipment_pojo.getShipment_Number());
			pattern=new String[shipmentList.size()];
			size=new String[shipmentList.size()];
			quantity=new Long[shipmentList.size()];
			int i=0;
			for (Object[] items : shipmentList) {
				pattern[i]=(String) items[0];
				size[i]=(String) items[1];
				quantity[i]=(Long) items[2];
			}
			shipment_pojo.setQuantity(quantity);
			shipment_pojo.setPattern(pattern);
			shipment_pojo.setSize(size);
			shipments.add(shipment_pojo);
		}
		
		
		return shipments;
	}

}
