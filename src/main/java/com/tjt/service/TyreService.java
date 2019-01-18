package com.tjt.service;

import java.util.List;

import com.tjt.dto.TyreInformationDTO;
import com.tjt.dto.TyreInformationDTO2;

public interface TyreService {
	public String  tyreSave(TyreInformationDTO dto)throws Exception;
	public List<TyreInformationDTO2> listTyre()throws Exception;
	public void tyreDelete(String tyrepattern,String tyreSize)throws Exception;
	public TyreInformationDTO2 tyrelistById(String tyrepattern,String tyreSize)throws Exception;
	public String tyreUpdate(TyreInformationDTO2 dto)throws Exception;

}
