package com.tjt.service;

import java.sql.Date;
import java.util.List;

import com.tjt.dto.POS_Item_DTO;
import com.tjt.dto.SaleReportDTO;


public interface ReportService {
	public List<SaleReportDTO> getSalesDetailsByDate(Date saledate,Date saledateto,String pos)throws Exception;

	public List<POS_Item_DTO> getStockDetails()throws Exception ;

	public List<String> getposlist();
	
	public List<SaleReportDTO> getSalesDetailsByMonth(String pos)throws Exception;

}
