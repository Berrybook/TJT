
package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.tjt.dao.SalesTransactionDAO;
import com.tjt.dao.User_Detalis_DAO;
import com.tjt.dto.SalesTransactionDTO;
import com.tjt.dto.UserDTO;
import com.tjt.entity.POS_Table;
import com.tjt.entity.SalesTransactionMaster;
import com.tjt.entity.User_Details_Table;


@Service
public class SalesTransactionImpl implements SalesTransactionService {
		@Autowired
     	private  SalesTransactionDAO salestransactiondao;
		
		@Autowired
		private User_Detalis_DAO userDAO;
     
     	@Override
		public String  Salestransaction(SalesTransactionDTO sales) throws Exception  {
    	
     	MultipartFile file=null;
     	byte[] byteupload=null;
     	SalesTransactionMaster trasactionentity =null;
     	User_Details_Table saletable=null;
		
		//create User_Details_Table Object
		saletable=new User_Details_Table();
		
		//set salesManId in SalesTable
		saletable.setUserid(sales.getUserid());
     	
     	//get Attachment in SalesTransactionDTO
     	file=sales.getFile_upload();
     	
     	//Convert the Attachment in byteCode 
     	byteupload=file.getBytes();
     	
		//create tarsactionEnity class object  
     	trasactionentity = new SalesTransactionMaster();
     	
     	//copy TrasactionDTO class Object data into trasactionEntity class Object 
		BeanUtils.copyProperties(sales,trasactionentity);
		
		//Set Attachment in TrasactionEnity class
		trasactionentity.setFile_upload(byteupload);
		trasactionentity.setUserid(saletable);

		//insert all transaction Information In Transaction masterTable 
		trasactionentity=salestransactiondao.save(trasactionentity);
	
		
		//check the transaction is successfully inserted or not 
		if(trasactionentity == null){
			
			return "transaction failed";
		}//if
		
		else{
			return "transaction successfully";
		}//else
		
	}//end SalesTransaction 
     	
     	
	@Override
	public List<SalesTransactionDTO> getallSales()throws Exception{
		
		List<SalesTransactionMaster> salestransactionmaster =null;
		List<SalesTransactionDTO> salestransactiondto = null;
		
		
		//get  details of sales transaction
		salestransactionmaster = salestransactiondao.findAll();
		
		//create list of SalesTransactionDTO generic type
		salestransactiondto =new ArrayList<SalesTransactionDTO>();
		
		//Iterative the list and to the list 
		 for(SalesTransactionMaster master: salestransactionmaster){
			 
			 SalesTransactionDTO saledto =null;
			 User_Details_Table saletable=null;
				
			//create SalesMan_Table Object
			saletable=new User_Details_Table();
			 //create local TransactionDTO class Object 
			 saledto = new SalesTransactionDTO();
			 String salesmanid=saletable.getUserid();
			 
			 //copy salesTransactionEnity class Object  SalesTransactionDTO
			 BeanUtils.copyProperties(master, saledto);
			 saledto.setUserid(salesmanid);
			 //Add All SalesTransactionDTO into the list
			 salestransactiondto.add(saledto);
		 }
		 return salestransactiondto;
	}//getallSales
	
	
	@Override
	public List<UserDTO> allSalesManId(String pos)throws Exception {
		List<Object[]> listObject=null;
		List<UserDTO> listdto=null;
		
		
		//create ArrayList Object in  SalesManDTO generic type
		listdto=new ArrayList<UserDTO>();
		POS_Table pos_table=new POS_Table();
		pos_table.setPos(pos);
		String admin="ADMIN";
		
		//to Get  allsalesmanId method 
		listObject =userDAO.allSalesmanid(pos_table,admin);
		
		//Iterative  the list 
		for(Object[] obj: listObject){
			
			UserDTO salesmanDTO=null;
			//create local object  salesManDTo class 
			 salesmanDTO=new UserDTO();
			 
			 //cast object to salesmanId 
			String salesmanid=(String)obj[0];
			String salesmanname=(String)obj[1];
			
			
			//set salesManId in SalesManDTo class 
			salesmanDTO.setUserid(salesmanid);
			salesmanDTO.setUserName(salesmanname);
			
			//Add SalesmanId in List 
			listdto.add(salesmanDTO);
		}
		return listdto;
	}
	

}
