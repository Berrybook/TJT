package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.CityDAO;
import com.tjt.dao.POSItemDAO;
import com.tjt.dto.Pos_Item_Price_Dto;
import com.tjt.dto.Pos_Item_Price_Dto_Responce;
import com.tjt.entity.City_Table;
import com.tjt.entity.POS_Item;


@Service
@Transactional
public class Pos_Item_Price_Impl implements Pos_Item_Price {

	@Autowired
    private POSItemDAO positemdao;
	
	@Autowired
	private CityDAO cityDAO;
	
	@Override
	public String priceAssignmentInPos(Pos_Item_Price_Dto itemPrice) {
		POS_Item pOS_Item=null;
		List<String > allPosByCity=null;
		allPosByCity=positemdao.findAllByPOS(itemPrice.getCityname());
		try{
		for (String pos : allPosByCity) {
			for(int i=0;i<itemPrice.getPattern().length;i++){
				
				pOS_Item=new POS_Item();
				pOS_Item.setPos(pos);
				pOS_Item.setTyrepattern(itemPrice.getPattern()[i]);
				pOS_Item.setTyresize(itemPrice.getSize()[i]);
				pOS_Item.setMRP(itemPrice.getMrp()[i]);
				pOS_Item.setSalePrice(itemPrice.getSalePrice()[i]);
				pOS_Item.setQuantity(0l);
				
				positemdao.save(pOS_Item);
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "original ";
	}

	//all city
	@Override
	public List<String> allCity() throws Exception {
		List<City_Table> listCity=null;
		List<String> allCity=null;
		allCity=new ArrayList<String>();
		listCity=cityDAO.findAll();
		for (City_Table city_Table : listCity) {
			String city=city_Table.getCityname();
			allCity.add(city);
		}
		return allCity;
	}

	@Override
	public List<Pos_Item_Price_Dto_Responce> allPosItemByCity(String city) throws Exception {
		
		City_Table cityTable=new City_Table();
		cityTable.setCityname(city);
		List<Object[]> listItemPrice=null;
		List<Pos_Item_Price_Dto_Responce> listPosItem=new ArrayList<Pos_Item_Price_Dto_Responce>();
		listItemPrice=positemdao.allPosItemByCity(city);
			for (Object[] pOS_Item : listItemPrice) {
				//
				Pos_Item_Price_Dto_Responce pos_Item_Price_Dto=new Pos_Item_Price_Dto_Responce();
				
		
				pos_Item_Price_Dto.setQunatity((Long) pOS_Item[2]);
				pos_Item_Price_Dto.setMrp((Double) pOS_Item[3]);
				pos_Item_Price_Dto.setSalePrice((Double) pOS_Item[4]);
				pos_Item_Price_Dto.setPattern((String) pOS_Item[0]);
				pos_Item_Price_Dto.setSize((String) pOS_Item[1]);
				listPosItem.add(pos_Item_Price_Dto);
			}
		return listPosItem;
	}

}
