package com.tjt.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.InvoiceDAO;
import com.tjt.dao.Invoice_Items_DAO;
import com.tjt.dao.KisokInvoiceDAO;
import com.tjt.dao.User_Detalis_DAO;
import com.tjt.dao.Vehicle_Invoice_DAO;
import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.Invoice_DTO;
import com.tjt.dto.Invoice_Items_Dto;
import com.tjt.dto.Invoice_Vehicle_DTO;
import com.tjt.dto.KisokInvoiceDTO;
import com.tjt.dto.TyreInformationDTO;
import com.tjt.dto.UserDTO;
import com.tjt.entity.Invoice;
import com.tjt.entity.Invoice_Items;
import com.tjt.entity.KiskoInvoice;
import com.tjt.entity.POS_Table;
import com.tjt.entity.User_Details_Table;
import com.tjt.entity.Vehicle_Invoice;

@Service
@Transactional
public class InvoicegenerationServiceImpl  implements InvoiceGenerationService {
		
		@Autowired
		private KisokInvoiceDAO kisoinvoice;
		
		@Autowired
		private User_Detalis_DAO userDAO;
		
		@Autowired
		private InvoiceDAO invoiceDAO;
		
		@Autowired
		private Vehicle_Invoice_DAO invoice_vehicle_DAO;
		
		@Autowired
		private Invoice_Items_DAO invoice_Item_DAO;
		
		
		
	@Override
	public void InvoiceSave(KisokInvoiceDTO dto, HttpServletRequest request)throws Exception {
		KiskoInvoice invoice=null;
		//SalesMan_Table saletable=null;
		User_Details_Table userTable=null;
		
	
		//create SalesMan_Table Object
		userTable=new User_Details_Table();
		userTable.setUserid(dto.getUserid());
		//set salesManId in SalesTable
		//create invoiceEntity  class Object 
		invoice=new KiskoInvoice();
	
		//copy invoiceDTO class Object to InvoiceEntity class Object 
		BeanUtils.copyProperties(dto, invoice);
		invoice.setUser_Details_Table(userTable);
		//call DAO class save Method to store the data 
		invoice=kisoinvoice.save(invoice);
		//open session 
		HttpSession session=request.getSession(false);
		
		//add customerId id session attribute 
		session.setAttribute("customerId", invoice.getCustomerID());
	}
	
	@Override
	public void invoiceCreation(Invoice_DTO invoiceDto, Invoice_Items_Dto itemDto, Invoice_Vehicle_DTO vehicleDto,HttpServletRequest request) throws Exception {
		
		//open session 
		HttpSession session=request.getSession(false);
				
		//SalesMan_Table saletable=null;
		User_Details_Table userTable=null;
		
		Invoice invoice=null;
		Vehicle_Invoice vehicleInvoice=null;
		Invoice_Items invoiceItem=null;
		
		//create SalesMan_Table Object
		userTable=new User_Details_Table();
		//set UserId in SalesTable
		userTable.setUserid(invoiceDto.getUserId());
		//create Invoice class Object 
		invoice=new Invoice();
		//copy Invoice_DTO class object to invoice class Object 
		BeanUtils.copyProperties(invoiceDto, invoice);
		invoice.setUser_Details_Table(userTable);
		
		
		//create invoice 
		invoice=invoiceDAO.save(invoice);
		//add invoiceNumber in  session attribute 
		session.setAttribute("invoiceNumber", invoice.getInvoice_Number());
		
		vehicleInvoice=new Vehicle_Invoice();
		
		//copy Invoice_Vehicle_DTO class object to vehicleInvoice class Object 
		BeanUtils.copyProperties(vehicleDto, vehicleInvoice);
		vehicleInvoice.setInvoice_number(invoice);
		//create invoice 
		vehicleInvoice=invoice_vehicle_DAO.save(vehicleInvoice);
		//add invoiceNumber in  session attribute 
		session.setAttribute("vehicleInvoice", vehicleInvoice.getVehicle_Invoice());
		
		invoiceItem=new Invoice_Items();
		
		/*Double basicPrice=itemDto.getBasicPrice();
		Double SGST=0.14*basicPrice;
		Double CGST=0.14*basicPrice;
		Double IGST=0.28*basicPrice;
		//copy Invoice_Vehicle_DTO class object to vehicleInvoice class Object 
		BeanUtils.copyProperties(itemDto, invoiceItem);
		invoiceItem.setSGST(SGST);
		invoiceItem.setCGST(CGST);
		invoiceItem.setIGST(IGST);*/
		
		int length=itemDto.getTyrepattern().length;
		for(int i=0;i<length;i++){
			Double basicPrice=itemDto.getBasicPrice()[i];
			Double SGST=0.14*basicPrice;
			Double CGST=0.14*basicPrice;
			Double IGST=0.28*basicPrice;
			//copy Invoice_Vehicle_DTO class object to vehicleInvoice class Object 
			BeanUtils.copyProperties(itemDto, invoiceItem);
			invoiceItem.setBasicPrice(basicPrice);
			invoiceItem.setTyrepattern(itemDto.getTyrepattern()[i]);
			invoiceItem.setTyresize(itemDto.getTyre_size()[i]);
			invoiceItem.setSGST(SGST);
			invoiceItem.setCGST(CGST);
			invoiceItem.setIGST(IGST);
			invoiceItem.setSaledate(itemDto.getSaledate());
			invoiceItem.setInvoice_Number(invoice);
			//create invoice_Item
			invoiceItem=invoice_Item_DAO.save(invoiceItem);
			//add invoiceNumber in  session attribute 
			session.setAttribute("invoiceItem", invoiceItem.getInvoice_Items());
		}//for loop end 
	}
	
	

	@Override
	public InvoiceDTO InvoiceDetails(HttpServletRequest request)throws Exception  {
		HttpSession session=null;
		InvoiceDTO DTO=null;
		KiskoInvoice invoice=null;
		User_Details_Table table=null;
		List<Object[]> listgstno=null;
		
		//open HttpSession 
		 session=request.getSession(false);
		 
		//find HttpSession Value and store in customerId
		Long customerId=(Long)session.getAttribute("customerId");
		String pos=(String) session.getAttribute("pos");
		String gstNo=null;
		String gstAddress=null;
		
		try{
		
		listgstno=kisoinvoice.getGstNoAndGstAddress(pos);
		for (Object[] objects : listgstno) {
			
			gstNo=(String) objects[0];
			gstAddress=(String) objects[1];
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//Create Sales Man Table Object 
		table=new User_Details_Table();
		
		//call findAll method  and store invoice details in listInvoice
		invoice=kisoinvoice.getOne(customerId);
		//table=invoice.getSalesman();
		table=invoice.getUser_Details_Table();
		//create InvoiceDTO class Object 
		DTO=new InvoiceDTO();
		
		//copy InvoiceEntity class object data to invoiceDTO class Object 
		BeanUtils.copyProperties(invoice, DTO);
		//DTO.setSalesmanid(table.getSalesmanid());
		DTO.setUserid(table.getUserid());
		DTO.setGstNo(gstNo);
		DTO.setGstAddress(gstAddress);
		
		return DTO;
	}

	
	
	@Override
	public List<TyreInformationDTO> findTyrePattern()throws Exception {
		List<Object[]> listObject=null;
		List<TyreInformationDTO> listtyre=null;
		
		//create ArrayList Object 
		listtyre=new ArrayList<TyreInformationDTO>();
		
		//get all tyrePattern in Tire Information table 
		listObject =invoiceDAO.allTyrePattern();
		
		//Iterative the listObject 
		for(Object obj: listObject){
			
			//create  local TyreInforamtionDto class Object  
			TyreInformationDTO tyreDTO=new TyreInformationDTO();
			
			//find tirePattern in object 
			String tyrePattern=(String)obj;
			
			//set TyrePattern in TyrePatternDto class  
			tyreDTO.setTyrepattern(tyrePattern);
			
			// add Tire Pattern in list 
			listtyre.add(tyreDTO);
		}
		return listtyre;
	}

	@Override
	public List<UserDTO> allSalesManId(String pos) throws Exception {
		//all local variable initialize 
		List<Object[]> listObject=null;
		List<UserDTO> listdto=null;
		
		//create ArrayList Object of  SalesManDTO Generic type 
		listdto=new ArrayList<UserDTO>();
		POS_Table pos_table=new POS_Table();
		pos_table.setPos(pos);
		String admin="ADMIN";
		//To get All salesmanId under the particular POS 
		listObject =userDAO.allSalesmanid(pos_table,admin);
		
		//Iterative the ListObejct 
		for(Object[] obj: listObject){
			
			UserDTO userDto=null;
			//create local Object salesManDTO class Object 
			 userDto=new UserDTO();
			 
			//cast salesmanId  in object 
			String salesmanid=(String)obj[0];
			String salesmanname=(String)obj[1];
			//set salesManDto class In salesmanId and salesmanName
			userDto.setUserid(salesmanid);
			userDto.setUserName(salesmanname);
			
			//Add all SalesManId In list 
			listdto.add(userDto);
		}
		return listdto;
	}
	
	

	@Override
	public List<TyreInformationDTO> findTyreSize(String tyrePattern)throws Exception  {
		List<Object[]> listObject=null;
		List<TyreInformationDTO> listtyresize=null;
		
		//create ArrayList Object 
		listtyresize=new ArrayList<TyreInformationDTO>();
		
		//get all tyreSize in Tire Information table 
		listObject =invoiceDAO.allTyreSize(tyrePattern);
		
		//Iterative the listObject 
		for(Object obj: listObject){
			
			//create  local TyreInforamtionDto class Object  
			TyreInformationDTO tyreDTO=new TyreInformationDTO();
			
			//cast tireSize in object 
			String tyresize=(String)obj;
			
			
			//set TyreSize in TyrePatternDto class  
			tyreDTO.setTyresize(tyresize);
			
			// add AllTireSize in list 
			listtyresize.add(tyreDTO);
		}
		return listtyresize;
	}

	//Get tyrePrice in the specific tyrePattern and tyresize
	@Override
	public Double getTyrePrice(String tyrePattern, String tyreSize) throws Exception {
		Double price=0.0;
		
		//get Price 
		price=invoiceDAO.getTyrePrice(tyrePattern, tyreSize);
		
		return price;
	}


	@Override
	public List<InvoiceDTO> ListInvoicePos(String pos) throws Exception {
		List<InvoiceDTO> listdto=null;
		List<Object[]> listInvoice=null;
		
		POS_Table postable=new POS_Table();
		postable.setPos(pos);
		listdto=new ArrayList<InvoiceDTO>();
		
		listInvoice=invoiceDAO.getInvoice(postable);
		
		for(Object[] invoice:listInvoice){
			InvoiceDTO dto=new InvoiceDTO();
			//KiskoInvoice invoice1=new KiskoInvoice();
			Invoice invoice1=new Invoice();
			invoice1.setInvoice_Number((Long) invoice[0]);
			invoice1.setUser_Details_Table((User_Details_Table) invoice[1]);
			invoice1.setSaledate((Date) invoice[2]);
			invoice1.setTotal_price((Double) invoice[3]);
			
			User_Details_Table sale=new User_Details_Table();
			sale=invoice1.getUser_Details_Table();
			dto.setInvoice_Number(invoice1.getInvoice_Number());
			dto.setUserid(sale.getUserid());
			dto.setSaledate(invoice1.getSaledate());
			dto.setTotal_price(invoice1.getTotal_price());
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public InvoiceDTO FindInvoiceById(Long customerId) throws Exception {
		InvoiceDTO dto=null;
		KiskoInvoice invoice=null;
		invoice=kisoinvoice.getOne(customerId);
		dto=new InvoiceDTO();
		BeanUtils.copyProperties(invoice, dto);
		return dto;
	}

	@Override
	public String UpdateInvoiceById(InvoiceDTO dto) throws Exception {
		
		KiskoInvoice invoice=null;
		User_Details_Table saletable=null;
		
		//create SalesMan_Table Object
		saletable=new User_Details_Table();
		
		//set salesManId in SalesTable
		saletable.setUserid(dto.getUserid());
	
		invoice=new KiskoInvoice();
		BeanUtils.copyProperties(dto, invoice);
		invoice.setUser_Details_Table(saletable);
		
		try{
		invoice=kisoinvoice.save(invoice);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(invoice==null){
			return "Invoice not update";
		}
		
		
		return "Invoice Update Sucessfully";
	}//UpdateInvoiceById end 



	@Override
	public String getLocation(String pos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvoiceDTO InvoiceDetail(HttpServletRequest request) throws Exception {
		HttpSession session=null;
		InvoiceDTO DTO=null;
		Invoice invoice=null;
		Vehicle_Invoice vehicleInvoice=null;
		Invoice_Items invoiceItem=null;
		User_Details_Table table=null;
		List<Object[]> listgstno=null;
		
		//open HttpSession 
		 session=request.getSession(false);
		 
		//find HttpSession Value and store in customerId
		Long invoiceNumber=(Long)session.getAttribute("invoiceNumber");
		Long vehicle_Invoice=(Long)session.getAttribute("vehicleInvoice");
		Long invoice_Item=(Long)session.getAttribute("invoiceItem");
		String pos=(String) session.getAttribute("pos");
		String gstNo=null;
		String gstAddress=null;

		
		listgstno=invoiceDAO.getGstNoAndGstAddress(pos);
		for (Object[] objects : listgstno) {
			
			gstNo=(String) objects[0];
			gstAddress=(String) objects[1];
		}
		
		//Create Sales Man Table Object 
		table=new User_Details_Table();
		
		//getOne  method  and store invoice details in listInvoice
		invoice=invoiceDAO.getOne(invoiceNumber);
		
		//call find vehicleInvoice list
		vehicleInvoice=invoice_vehicle_DAO.getOne(vehicle_Invoice);
		
		//getOne  itemInvoice 
		invoiceItem=invoice_Item_DAO.getOne(invoice_Item);
		
		//table=invoice.getSalesman();
		table=invoice.getUser_Details_Table();
		
		//create InvoiceDTO class Object 
		DTO=new InvoiceDTO();
		
		//copy InvoiceEntity class object data to invoiceDTO class Object 
		BeanUtils.copyProperties(invoice, DTO);
		//DTO.setSalesmanid(table.getSalesmanid());
		DTO.setUserid(table.getUserid());
		DTO.setGstNo(gstNo);
		DTO.setGstAddress(gstAddress);
		DTO.setTyrepattern(invoiceItem.getTyrepattern());
		DTO.setTyresize(invoiceItem.getTyresize());
		DTO.setSGST(invoiceItem.getSGST());
		DTO.setCGST(invoiceItem.getCGST());
		DTO.setIGST(invoiceItem.getIGST());
		
		//return DTO Object 
		return DTO;
	}



	
	
}//class End 


