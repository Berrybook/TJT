package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tjt.dao.POSItemDAO;
import com.tjt.dao.POS_DAO;
import com.tjt.dao.Tyre_DAO;
import com.tjt.dto.City_DTO;
import com.tjt.dto.POSDTO;
import com.tjt.dto.Pos_Item_Price_Dto_Responce;
import com.tjt.entity.City_Table;
import com.tjt.entity.POS_Item;
import com.tjt.entity.POS_Table;
import com.tjt.entity.Tyre_Information;

@Service
public class POSServiceImpl implements POSService{
	
	@Autowired
	private POS_DAO posDao;
	
	@Autowired
	private POSItemDAO pOSItemDAO;
	
	@Autowired
	private Tyre_DAO tyreDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,transactionManager="transactionManager")
	public int autheticate(String pos, String password) {
		int count=0;
		 count=posDao.login(pos, password);
		 return count;
		
	}

	@Override
	public String createPOS(POSDTO dto) throws Exception {
		
		POS_Table postable=null;
		City_Table citytable=null;
		String gst_number=null;
		String gst_address=null;
		POS_Item pOS_Item=null;
		
		//create POS_table Object 
		postable=new POS_Table();
		
		//create POS_table Object 
		citytable=new City_Table();
		
		String cityname=dto.getCityname();
			List<Object[]> listGSt=null;
			listGSt=posDao.featchGstNoAndGstAddress(cityname);
			
			for (Object[] objects : listGSt) {
				
				gst_number= (String) objects[0];
				gst_address=(String) objects[1];
			}
	
		
		
		citytable.setCityname(dto.getCityname());
		
		
		
		//copy POSDTO class to entity class 
		BeanUtils.copyProperties(dto, postable);
		postable.setPos(dto.getPos().toLowerCase());
		postable.setCity_table(citytable);
		postable.setGstNo(gst_number);
		postable.setGstAddress(gst_address);
		int count=posDao.checkPOS(postable.getPos());
		if(count==0){	
			
			postable=posDao.save(postable);
			List<Tyre_Information> listitem=tyreDao.findAll();
			for (Tyre_Information tyre_Information : listitem) {
				pOS_Item=new POS_Item();
				pOS_Item.setTyrepattern(tyre_Information.getTyrepattern());
				pOS_Item.setTyresize(tyre_Information.getTyresize());
				pOS_Item.setPos(postable.getPos());
				
				//assign Item in  all POS 
				pOSItemDAO.save(pOS_Item);
			}
			
			return "POS Registered Sucessfully";
		}
		else{
			return "POS Already Exists";
		}
	}

	@Override
	public POSDTO listById(String pos) throws Exception {
		
		POSDTO dto=null;
		POS_Table postable=null;
		City_Table citytable=null;
		
		//create POSDTO Object 
		dto=new POSDTO();
		
		//create City_Table Object 
		citytable=new City_Table();
		
		postable=posDao.getOne( pos);
		citytable=postable.getCity_table();
		//copy POS_Table class object to POSDTO
		BeanUtils.copyProperties(postable, dto);
		dto.setCityname(citytable.getCityname());
		
		return dto;
	}

	@Override
	public void updatePOS(POSDTO dto) throws Exception {
		POS_Table postable=null;
		City_Table citytable=null;
		String gst_number=null;
		String gst_address=null;
		
		//create POS_table Object 
		postable=new POS_Table();
		
		//create POS_table Object 
		citytable=new City_Table();
		
		
		citytable.setCityname(dto.getCityname());
		String cityname=dto.getCityname();
		List<Object[]> listGSt=null;
		listGSt=posDao.featchGstNoAndGstAddress(cityname);
		
		for (Object[] objects : listGSt) {
			
			gst_number= (String) objects[0];
			gst_address=(String) objects[1];
		}
		
		
		
		//copy POSDTO class to entity class 
		BeanUtils.copyProperties(dto, postable);
		postable.setCity_table(citytable);
		postable.setGstNo(gst_number);
		postable.setGstAddress(gst_address);
		
		
		//update POS data from database
		posDao.save(postable);
		
	}

	@Override
	public void deletePOS(String pos) throws Exception {
		
		//delete POS data from database
		posDao.deleteById(pos);
	}

	@Override
	public List<POSDTO> listPos() throws Exception {

		List<POSDTO> listDto=null;
		List<POS_Table> listpostable=null;
		City_Table citytable=null;
		
		//create POSDTO Object 
		listDto=new ArrayList<POSDTO>();
		
		//create City_Table Object 
		citytable=new City_Table();
		
		listpostable=posDao.findAll();
		for (POS_Table pos_Table : listpostable) {
			POSDTO dto=new POSDTO();
			citytable=pos_Table.getCity_table();
			BeanUtils.copyProperties(pos_Table, dto);
			dto.setCityname(citytable.getCityname());
			listDto.add(dto);
		}
		
		
		return listDto;
	}

	@Override
	public List<City_DTO> listCity() throws Exception {
		List<City_DTO>  listCitydto=null;
		List<Object[]>  listcityenity=null;
		
		listCitydto=new ArrayList<City_DTO>();
		listcityenity=posDao.listCity();
		for (Object city_Table : listcityenity) {
			
			City_DTO dto=new City_DTO();
			dto.setCityname((String) city_Table);
			listCitydto.add(dto);
		}
		
		
		return listCitydto;
	}

	@Override
	public String[] findGstnoAndGsrAdd(String city) throws Exception {
		
		List<Object[]> listGSt=null;
		String[] gst=null;
		
			listGSt=posDao.featchGstNoAndGstAddress(city);
			
			for (Object[] objects : listGSt) {
				gst=new String[objects.length];
				gst[0]= (String) objects[0];
				gst[1]=(String) objects[1];
			}
	
		
		return gst;
	}
	
	@Override
	public List<Pos_Item_Price_Dto_Responce> PriceList(String pos) throws Exception {
		List<Pos_Item_Price_Dto_Responce> listItemPrice=null;
		List<Object[]> listItemByPos=null;
		
		
		//create ArrayList in PosItemPrice
		listItemPrice=new ArrayList<Pos_Item_Price_Dto_Responce>();
		
		//get allItemPrice in Each POS
		listItemByPos=pOSItemDAO.findAllByPos_table(pos);
		
		//Iterative ListItemPrice By Each POS
		for (Object[] pos_Item : listItemByPos) {
			Double mrp=0.0,mrpgst=0.0,withgstmrp=0.0,salePrice=0.0;
			Double withgstSalePrice=0.0,salepriceGst=0.0;
			Pos_Item_Price_Dto_Responce pos_Item_Price=new Pos_Item_Price_Dto_Responce();
			
			
			//calculate GST of SalesPrice 
			salePrice=(Double) pos_Item[4];
			salepriceGst=salePrice*0.28;
			withgstSalePrice=salePrice+salepriceGst;
			withgstSalePrice=(double) Math.round(withgstSalePrice*100.0)/100.0;
			
			//calculate GST of MRP  
			 mrp=(Double) pos_Item[3];
			 mrpgst=mrp*0.28;
			 withgstmrp=mrp+mrpgst;
			 withgstmrp=(double) Math.round(withgstmrp*100.0)/100.0;
			 
			 
			//set value in Pos_Item_Price_Dto_Responce
			pos_Item_Price.setPattern((String) pos_Item[0]);
			
			pos_Item_Price.setSize((String) pos_Item[1]);
			pos_Item_Price.setQunatity((Long) pos_Item[2]);
			pos_Item_Price.setMrp(withgstmrp);
			pos_Item_Price.setSalePrice(withgstSalePrice);
			listItemPrice.add(pos_Item_Price);
		}
		return listItemPrice;
	}
	
	
	

}
