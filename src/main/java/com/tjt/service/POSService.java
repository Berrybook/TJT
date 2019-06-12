package com.tjt.service;

import java.util.List;

import com.tjt.dto.City_DTO;
import com.tjt.dto.POSDTO;
import com.tjt.dto.Pos_Item_Price_Dto_Responce;

public interface POSService {
	public int autheticate(String pos,String password); 
	public String createPOS(POSDTO dto) throws Exception;
	public POSDTO listById(String pos)throws Exception;
	public void updatePOS(POSDTO dto)throws Exception;
	public void deletePOS(String pos)throws Exception;
	public List<POSDTO> listPos()throws Exception;
	public List<City_DTO> listCity()throws Exception ;
	public String[] findGstnoAndGsrAdd(String city)throws Exception;
	public List<Pos_Item_Price_Dto_Responce> PriceList(String pos)throws Exception;
	
	
}
