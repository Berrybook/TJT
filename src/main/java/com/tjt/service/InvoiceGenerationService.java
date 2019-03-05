package com.tjt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.Invoice_DTO;
import com.tjt.dto.Invoice_Items_Dto;
import com.tjt.dto.Invoice_Vehicle_DTO;
import com.tjt.dto.Pos_Item_Price_Dto_Responce;
import com.tjt.dto.UserDTO;


public interface InvoiceGenerationService {
	
	//get Pattern  By POS 
	public List<String> getItemSizeByPos(String posId,String pattern)throws Exception;
	
	//get size By POS and Pattern 
	public List<Pos_Item_Price_Dto_Responce> getItemPatternByPos(String posId)throws Exception;
	
	//get price By POS and Pattern and Size
	public Double getPriceByPatternAndSize(String pos,String tyrePattern, String tyreSize) throws Exception;
	
	
	//Get All SalesManId 
	public List<UserDTO> allSalesManId(String pos)throws Exception;
	
	
	//Get All Invoice Of the Particular KiOSk
	public List<InvoiceDTO> ListInvoicePos(String pos)throws Exception;
	
	
	//invoice Creation
	public InvoiceDTO invoiceCreation(Invoice_DTO invoiceDto,Invoice_Items_Dto itemDto,Invoice_Vehicle_DTO vehicleDto,HttpServletRequest request)throws Exception;
}
