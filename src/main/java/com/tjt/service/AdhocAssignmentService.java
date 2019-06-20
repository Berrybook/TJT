package com.tjt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tjt.dto.AdhocAssignmentDto;
import com.tjt.dto.City_DTO;
import com.tjt.entity.Adhoc_Assignment;
import com.tjt.entity.City_Table;

public interface AdhocAssignmentService {
	
	public String createAdhocAssignment(HttpServletRequest request,AdhocAssignmentDto dto) throws Exception;
	public List<City_DTO> allCity()throws Exception;
	public List<AdhocAssignmentDto> allSalesmanByCity(String cityname) throws Exception;
	public AdhocAssignmentDto salesmanById(HttpServletRequest request,String userid) throws Exception;
	public List<AdhocAssignmentDto> findsalemanbyid(String uid);
	public List<AdhocAssignmentDto> allAssignedAdhoc() throws Exception;
	public void updateadhoc(Adhoc_Assignment adhoc);
	public AdhocAssignmentDto allSalesmanByid(String id) throws Exception;
	

}
