package com.tjt.service;

import java.util.List;

import com.tjt.dto.POSItemDTO;
import com.tjt.dto.TyreInformationDTO2;

public interface POSStockService {
	public void posItemQuantityAssign(POSItemDTO dto)throws Exception ;
 
	public List <TyreInformationDTO2> listtyreid()throws Exception ;
	public List <String> listpos()throws Exception ;

	public List <TyreInformationDTO2> listpostyreid()throws Exception ;
	public List <String> listposname( Long tyreid)throws Exception ;
	
	public void posUpdate(POSItemDTO dto)throws Exception;

	void posItemAssignment(POSItemDTO dto,String allTyre) throws Exception;

	
}
