package com.tjt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.Invoice_DTO;
import com.tjt.dto.Invoice_Items_Dto;
import com.tjt.dto.Invoice_Vehicle_DTO;
import com.tjt.dto.KisokInvoiceDTO;
import com.tjt.dto.TyreInformationDTO;
import com.tjt.dto.UserDTO;


public interface InvoiceGenerationService {
	//invoice Creation
	public void InvoiceSave(KisokInvoiceDTO dto,HttpServletRequest request)throws Exception;
	//Get Invoice Of the current customer
	public InvoiceDTO InvoiceDetails(HttpServletRequest request)throws Exception;
	
	public InvoiceDTO InvoiceDetail(HttpServletRequest request)throws Exception;
	//get List of TyrePattern 
	public List<TyreInformationDTO> findTyrePattern()throws Exception;
	
	//Get All SalesManId 
	public List<UserDTO> allSalesManId(String pos)throws Exception;
	
	//List All TyreSize Of the Particular TyrePattern
	public List<TyreInformationDTO>  findTyreSize(String tyrePattern)throws Exception;
	
	//Get Tire Price Of the TyreSize And TyrePattern
	public Double getTyrePrice(String tyrePattern,String tyreSize)throws Exception;
	
	//Get Location Of The POS 
	public String  getLocation(String pos)throws Exception;
	
	//Get All Invoice Of the Particular KiOSk
	public List<InvoiceDTO> ListInvoicePos(String pos)throws Exception;
	
	//Get Invoice Of The Customer
	public InvoiceDTO FindInvoiceById(Long customerId)throws Exception;
	
	//Update Of the Invoice
	public String UpdateInvoiceById(InvoiceDTO dto)throws Exception;
	
	//invoice Creation
	public void invoiceCreation(Invoice_DTO invoiceDto,Invoice_Items_Dto itemDto,Invoice_Vehicle_DTO vehicleDto,HttpServletRequest request)throws Exception;
}
