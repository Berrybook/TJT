package com.tjt.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.POS_DAO;
import com.tjt.dao.ReportDAO;
import com.tjt.dto.POS_Item_DTO;
import com.tjt.dto.SaleReportDTO;
import com.tjt.entity.POS_Table;
import com.tjt.entity.User_Details_Table;



@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDAO reportdao;
	
	@Autowired
	private POS_DAO posdao;
	
	public List<SaleReportDTO> getSalesDetailsByDate(Date saledate,Date saledateto,String pos)throws Exception  {
		List<SaleReportDTO> listdto=null;
		List<Object[]> listInvoice=null;
		//KiskoInvoice postable=new KiskoInvoice();
		//postable.setSaledate(saledate);
		listdto=new ArrayList<SaleReportDTO>();
		
		POS_Table postable = new POS_Table();
		postable.setPos(pos);
		
		User_Details_Table user =new User_Details_Table();
		user.setPos_table(postable);
		
		
		listInvoice=reportdao.getSalesDetailsByDate(saledate,saledateto,postable);
		//System.out.println(listInvoice);
		for(Object[] invoice:listInvoice){
			//KisokInvoiceDTO dto=new KisokInvoiceDTO();
			SaleReportDTO saleReport = new SaleReportDTO();
			Date date = (Date) invoice[0];
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			 String strDate= formatter.format(date);  
			    
			saleReport.setSaledate(strDate);
			
			
			//set saleReport value in saleReposrt DTO class 
			saleReport.setTyrepattern((String) invoice[1]);
			saleReport.setTyresize((String) invoice[2]);
			saleReport.setPaymentmode((String) invoice[3]);
			saleReport.setTotprice((Double) invoice[4]);
			saleReport.setQuantity((Long) invoice[5]);
			
			//add DTO  value in list 
			listdto.add(saleReport);
		}
		
		return listdto;
		
	}

	@Override
	public List<POS_Item_DTO> getStockDetails() throws Exception  {
		List<POS_Item_DTO> listdto=null;
		List<Object[]> liststock=null;
		
		//KiskoInvoice postable=new KiskoInvoice();
		//postable.setSaledate(saledate);
		listdto=new ArrayList<POS_Item_DTO>();

		liststock=reportdao.getStockdetails();
	
		for(Object[] invoice:liststock){
			//KisokInvoiceDTO dto=new KisokInvoiceDTO();
			POS_Item_DTO saleReport = new POS_Item_DTO();
			
			
	
			saleReport.setPos((String) invoice[0]);
			saleReport.setTyrepattern((String) invoice[1]);
			saleReport.setTyresize((String) invoice[2]);
			saleReport.setQuantity((Long) invoice[3]);
			
			
	
			
			listdto.add(saleReport);
		}
		return listdto;

	}
	@Override
	public List<String> getposlist() {
		List<String> listpos = null;
		
		listpos = new ArrayList<>();
		List<POS_Table>  postable = null;
		
		
		postable= posdao.findAll(); 
		for (POS_Table pos_Table : postable) {
			String pos = null;
			pos = pos_Table.getPos();
			listpos.add(pos);
		}
		
		
		return listpos;
	}


}
