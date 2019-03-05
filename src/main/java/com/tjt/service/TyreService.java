package com.tjt.service;

import java.util.List;

import com.tjt.dto.TyreInformationDTO;


public interface TyreService {
	public String  tyreSave(TyreInformationDTO dto)throws Exception;
	public List<TyreInformationDTO> listTyre()throws Exception;
	public void tyreDelete(String tyrepattern,String tyreSize)throws Exception;
	public TyreInformationDTO tyrelistById(String tyrepattern,String tyreSize)throws Exception;
	public String tyreUpdate(TyreInformationDTO dto)throws Exception;

}
