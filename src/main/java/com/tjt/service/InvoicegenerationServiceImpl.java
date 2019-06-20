package com.tjt.service;

import java.rmi.server.UID;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.AdhocAssignmentDao;
import com.tjt.dao.InvoiceDAO;
import com.tjt.dao.Invoice_Items_DAO;
import com.tjt.dao.Templet_DAO;
import com.tjt.dao.User_Detalis_DAO;
import com.tjt.dao.Vehicle_Invoice_DAO;
import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.Invoice_DTO;
import com.tjt.dto.Invoice_Items_Dto;
import com.tjt.dto.Invoice_Vehicle_DTO;
import com.tjt.dto.POSDTO;
import com.tjt.dto.Pos_Item_Price_Dto_Responce;
import com.tjt.dto.UserDTO;
import com.tjt.entity.City_Table;
import com.tjt.entity.Invoice;
import com.tjt.entity.Invoice_Items;
import com.tjt.entity.POS_Table;
import com.tjt.entity.Templet;
import com.tjt.entity.Tyre_Information;
import com.tjt.entity.User_Details_Table;
import com.tjt.entity.Vehicle_Invoice;
import com.tjt.util.NumberToWordConverter;

@Service
@Transactional
public class InvoicegenerationServiceImpl  implements InvoiceGenerationService {
		
		
		@Autowired
		private User_Detalis_DAO userDAO;
		
		@Autowired
		private Templet_DAO templet_DAO;
		
		@Autowired
		private InvoiceDAO invoiceDAO;
		
		@Autowired
		private Vehicle_Invoice_DAO invoice_vehicle_DAO;
		
		@Autowired
		private Invoice_Items_DAO invoice_Item_DAO;
		
		@Autowired
		private User_Detalis_DAO userdao;
		
		@Autowired
		private AdhocAssignmentDao adhocdao;
		
	
	@Override
	public InvoiceDTO invoiceCreation(Invoice_DTO invoiceDto, Invoice_Items_Dto itemDto, Invoice_Vehicle_DTO vehicleDto,HttpServletRequest request) throws Exception {
		
		//open session 
		HttpSession session=request.getSession(false);
			
		//SalesMan_Table saletable=null;
		User_Details_Table userTable=null;
		List<String> sizeList=null,patternList=null;
		List<Double> basicPriceList=null;
		Invoice invoice=null;
		Vehicle_Invoice vehicleInvoice=null;
		Invoice_Items invoiceItem=null;
		long quantity=0l;
		InvoiceDTO invoiceDTO=null;
		String [] paterrns=null;
		String [] tyresizeresult=null;
		Double [] basicPrices=null;
		
		
		//create SalesMan_Table Object
		userTable=new User_Details_Table();
		
		//set UserId in SalesTable
		userTable.setUserid(invoiceDto.getUserId());
		//get the quantity 
		quantity=invoiceDto.getQuantity();
		Long quntity=0l;
		if(quantity==1){
			for(int i=0;i<itemDto.getBasicPrice().length;i++){
			if(itemDto.getBasicPrice()[i]!=null){
				quntity=quntity+1l;
			}
			}
		}
		else{
			quntity=invoiceDto.getQuantity();
		}
		//create Invoice class Object 
		invoice=new Invoice();
		//copy Invoice_DTO class object to invoice class Object 
		BeanUtils.copyProperties(invoiceDto, invoice);
		invoice.setQuantity(quntity);
		//create invoice 
		invoice=invoiceDAO.save(invoice);
		
		
		//add invoiceNumber in  session attribute 
		session.setAttribute("invoiceNumber", invoice.getInvoice_Number());
		session.setAttribute("userid", userTable.getUserid());
		
		vehicleInvoice=new Vehicle_Invoice();
		//copy Invoice_Vehicle_DTO class object to vehicleInvoice class Object 
		BeanUtils.copyProperties(vehicleDto, vehicleInvoice);
		vehicleInvoice.setInvoice_number(invoice);
		
		//create invoice 
		vehicleInvoice=invoice_vehicle_DAO.save(vehicleInvoice);
		//add invoiceNumber in  session attribute 
		session.setAttribute("vehicleInvoice", vehicleInvoice.getVehicle_Invoice());
		
		//invoiceItem=new Invoice_Items();
		int length=itemDto.getTyre_size().length;
		
		sizeList=new ArrayList<String>();
		patternList=new ArrayList<String>();
		basicPriceList=new ArrayList<Double>();
		
		Double tyrebasicPrice=0.0;
			if(quantity==1){
		for(int i=0;i<length;i++){
			
			if(itemDto.getBasicPrice()[i]!=null){
			Double basicPrice=itemDto.getBasicPrice()[i];
			invoiceItem=new Invoice_Items();
			
			//copy Invoice_Vehicle_DTO class object to vehicleInvoice class Object not required
			BeanUtils.copyProperties(itemDto, invoiceItem);
			
			invoiceItem.setBasicPrice(basicPrice);
			invoiceItem.setTyrepattern(itemDto.getTyrepattern()[i]);
			invoiceItem.setTyresize(itemDto.getTyre_size()[i]);
			invoiceItem.setSaledate(itemDto.getSaledate());
			invoiceItem.setInvoice_Number(invoice.getInvoice_Number());
			
			//create warranty card Id
			 UID warentyId = new UID();
			 String warrent=warentyId.toString();
			 invoiceItem.setWarrantyId(warrent);
			 
			//create invoice_Item
			invoiceItem=invoice_Item_DAO.save(invoiceItem);
			
			//set TyreSize in list
			sizeList.add(invoiceItem.getTyresize());
			patternList.add(invoiceItem.getTyrepattern());
			basicPriceList.add(invoiceItem.getBasicPrice());
			
			tyrebasicPrice=tyrebasicPrice+invoiceItem.getBasicPrice();
			
			//add invoiceNumber in  session attribute 
			session.setAttribute("invoiceItem", invoiceItem.getInvoice_Items());
			
			}		
		}//for loop end
			}
			
		else if(quantity==2){
			for(int i=0;i<length;i++){
				Double basicPrice=itemDto.getBasicPrice()[0];
				invoiceItem=new Invoice_Items();
				
				//copy Invoice_Vehicle_DTO class object to vehicleInvoice class Object 
				BeanUtils.copyProperties(itemDto, invoiceItem);
				invoiceItem.setBasicPrice(basicPrice);
				invoiceItem.setTyrepattern(itemDto.getTyrepattern()[0]);
				invoiceItem.setTyresize(itemDto.getTyre_size()[0]);
				invoiceItem.setSaledate(itemDto.getSaledate());
				invoiceItem.setInvoice_Number(invoice.getInvoice_Number());
				
				//create warranty card id
				UID warentyId = new UID();
				String warrent=warentyId.toString();
				invoiceItem.setWarrantyId(warrent);
				
				
				//create invoice_Item
				invoiceItem=invoice_Item_DAO.save(invoiceItem);
				
				//set tyreSize In List
				sizeList.add(invoiceItem.getTyresize());
				patternList.add(invoiceItem.getTyrepattern());
				basicPriceList.add(invoiceItem.getBasicPrice());
				
				//calculate basePrice 
				tyrebasicPrice=tyrebasicPrice+invoiceItem.getBasicPrice();
				
				//add invoiceNumber in  session attribute 
				session.setAttribute("invoiceItem", invoiceItem.getInvoice_Items());
						
			}//for loop end
		}
			
			//set tyreSize in  ArrayList to String Array
			tyresizeresult=new String[sizeList.size()];
			int i=0;
			for (String tyre : sizeList) {
				tyresizeresult[i]=tyre;
				i++;
			}
			int j=0;
			paterrns=new String[patternList.size()];
			for(String pattern:patternList){
				paterrns[j]=pattern;
				j++;
			}
			
			
			int k=0;
			basicPrices=new Double[basicPriceList.size()];
			for (Double double1 : basicPriceList) {
				basicPrices[k]=double1;
				k++;
			}
			String mail=userdao.userMailById(invoiceDto.getUserId());
			NumberToWordConverter numberWord=new NumberToWordConverter();
			
			String total_price=Double.toString(invoice.getTotal_price());
			
			total_price=numberWord.NumberToWord(total_price);
			
			invoiceDTO=new InvoiceDTO();
			BeanUtils.copyProperties(invoice, invoiceDTO);
			BeanUtils.copyProperties(vehicleInvoice, invoiceDTO);
			BeanUtils.copyProperties(invoiceItem, invoiceDTO);
			
			invoiceDTO.setBasicPrice(tyrebasicPrice);
			invoiceDTO.setDiscount(invoice.getDiscount());
			invoiceDTO.setTyresizes(tyresizeresult);
			invoiceDTO.setTyrepatterns(paterrns);
			invoiceDTO.setBasicPrices(basicPrices);
			invoiceDTO.setPrice_in_word(total_price);
			invoiceDTO.setUserMailId(mail);
			Templet templet=null;
			int pdfTempletId=0;
			
			Optional<Templet> pdftemplet=templet_DAO.findById(pdfTempletId+1);
			templet=pdftemplet.get();
			String pdfTemplet=templet.getTemplet();
			invoiceDTO.setTemplet(pdfTemplet);
			Optional<Templet> warrentyTemplet=templet_DAO.findById(pdfTempletId+2);
			Templet temp=warrentyTemplet.get();
			String warrentyTemp=temp.getTemplet();
			invoiceDTO.setWarrentyTemplet(warrentyTemp);
			
			
			return invoiceDTO;
			
			
	}
	
	
	@Override
	public List<Pos_Item_Price_Dto_Responce> getItemPatternByPos(String posId)throws Exception{
		List<Pos_Item_Price_Dto_Responce> itemPatternByPos=null;
		itemPatternByPos=new ArrayList<Pos_Item_Price_Dto_Responce>();

		POS_Table pos_table=new POS_Table();
		pos_table.setPos(posId);
		
		List<String> listPattern=invoiceDAO.allTyrePatternByPos(posId);
		
		Set<String > setpattern=new HashSet<String>();
		for (String pattern : listPattern) {
			
			setpattern.add(pattern);
		}
		
		for (String string : listPattern) {
			Pos_Item_Price_Dto_Responce itemPattern=new Pos_Item_Price_Dto_Responce();
			itemPattern.setPattern(string);
			itemPatternByPos.add(itemPattern);
		}
		
		return itemPatternByPos;
	}
	
	@Override
	public List<String> getItemSizeByPos(String posId,String pattern) throws Exception{
	//	List<Pos_Item_Price_Dto_Responce> itemSizeByPosandPattern=null;
		List<String> listSize=null;
		//itemSizeByPosandPattern=pos_Item_DAO.listSize(posId, pattern);
		listSize=invoiceDAO.allTyreSizeByPos(posId, pattern);
		
		return listSize;
	}
	
	
	@Override
	public List<UserDTO> allSalesManId(String pos) throws Exception {
		//all local variable initialize 
		List<Object[]> listObject=null;
		List<Object[]> listObject2=null;
		List<UserDTO> listdto=null;
		
		//create ArrayList Object of  SalesManDTO Generic type 
		listdto=new ArrayList<UserDTO>();
		
		LocalDate today=LocalDate.now();
		Date currentDate=Date.valueOf(today);
		System.out.println("currentDate"+currentDate);
		POS_Table pos_table=new POS_Table();
		pos_table.setPos(pos);
		String admin="ADMIN";
		System.out.println("list1");
		//To get All salesmanId under the particular POS 
		listObject =userDAO.allSalesmanid(pos_table,admin);
		listObject2 = adhocdao.allAssignedSalesman(pos,currentDate);
		System.out.println("list");
		//Iterative  ListObejct 
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
		for(Object[] obj2 : listObject2)
		{
			
				UserDTO userDto1=null;
			//create local Object salesManDTO class Object 
				userDto1=new UserDTO();
				System.out.println((String) obj2[0]);
				userDto1.setUserid((String) obj2[0]);
				userDto1.setUserName((String) obj2[1]);
				listdto.add(userDto1);
			
		}
		return listdto;
	}
	
	@Override
	public Double getPriceByPatternAndSize(String pos,String tyrePattern, String tyreSize) throws Exception {
		Double price=0.0;
		Tyre_Information tyre=new Tyre_Information();
		POS_Table pos_table=new POS_Table();
		tyre.setTyrepattern(tyrePattern);
		tyre.setTyresize(tyreSize);
		pos_table.setPos(pos);
		
		//get Price 
		price=invoiceDAO.getPriceByPatternAndSize(tyrePattern,tyreSize, pos);

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
			invoice1.setUserId((String) invoice[1]);
			invoice1.setSaledate((Date) invoice[2]);
			invoice1.setTotal_price((Double) invoice[3]);
			
			dto.setInvoice_Number(invoice1.getInvoice_Number());
			dto.setUserId(invoice1.getUserId());
			dto.setSaledate(invoice1.getSaledate());
			dto.setTotal_price(invoice1.getTotal_price());
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public InvoiceDTO InvoiceDetails(Long invoiceId) throws Exception {
		Invoice invoice=null;
		InvoiceDTO invoiceDTO=null;
		invoice=invoiceDAO.getOne(invoiceId);
		invoiceDTO=new InvoiceDTO();
		BeanUtils.copyProperties(invoice, invoiceDTO);
		return invoiceDTO;
	}


	@Override
	public POSDTO getAddressofPOS(String posId) throws Exception {
		List<Object[]> posAddress=null;
		POSDTO postdo=new POSDTO();
		City_Table citytable=new City_Table();
		try{
		posAddress=invoiceDAO.getAddressOfPOS(posId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		for (Object[] objects : posAddress) {
			postdo.setAddress1((String) objects[0]);
			postdo.setPincode((String) objects[1]);
			citytable=(City_Table) objects[2];
			postdo.setCityname(citytable.getCityname());
			postdo.setPosName((String) objects[3]);
			
		}
		
		return postdo;
	}

	



}//class End 


