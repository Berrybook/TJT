package com.tjt.service;

import java.util.List;

import com.tjt.dto.Pos_Item_Price_Dto;
import com.tjt.dto.Pos_Item_Price_Dto_Responce;

public interface Pos_Item_Price {

	public String  priceAssignmentInPos(Pos_Item_Price_Dto itemPrice);
	public List<String> allCity()throws Exception;
	public List<Pos_Item_Price_Dto_Responce> allPosItemByCity(String city)throws Exception;
}
