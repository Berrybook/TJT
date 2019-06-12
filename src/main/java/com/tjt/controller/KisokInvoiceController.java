package com.tjt.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.Invoice_DTO;
import com.tjt.dto.Invoice_Items_Dto;
import com.tjt.dto.Invoice_Vehicle_DTO;
import com.tjt.dto.MailConnectionproperties;
import com.tjt.dto.POSDTO;
import com.tjt.dto.Pos_Item_Price_Dto_Responce;
import com.tjt.dto.UserDTO;
import com.tjt.service.InvoiceGenerationService;
import com.tjt.util.GenerateInvoicePdfReport;
import com.tjt.util.GeneratePdfReport;
import com.tjt.util.MailService;


@Controller

public class KisokInvoiceController {
	
	@Autowired
	private InvoiceGenerationService service;
	
	@Value("${mail.username}")
	private String usernames;
	
	@Value("${mail.password}")
	private String mailpassword;
	
	@Value("${mail.host}")
	private String host;
	
	@Value("${mail.port}")
	private String port;
	
	@Value("${mail.starttls}")
	private String starttls;
	
	@Value("${mail.auth}")
	private String auth;
	
	
	//landing page form 
	@RequestMapping(value="welcome")
	public String welCome(HttpServletRequest request){
	
		String responsePage="";
	
		
		try{
		
		
		request.setAttribute("mode","MODE_INVOICE");
	
		responsePage= "welcomeTjTyre";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			responsePage= "login";
		}
		return responsePage;
	}

	//logout 
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session=null;
		String responsePage="";
		session=request.getSession(false);
		if(session !=null){
		session.invalidate();
		request.setAttribute("logout"," Log Out Successfully ");
		}
		responsePage="login";
		return responsePage;
		
	}
	
	//TjTyre invoiceGenerate form page
	@RequestMapping(value="/createinvoice",method=RequestMethod.GET)
	public String kisokInvoiceGenerateForm(HttpServletRequest request){
		String responsePage="";
		
		try{
		
		request.setAttribute("mode","MODE_INVOICE");
	
		responsePage= "invoicegeneration2";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			responsePage= "login";
		}
		return responsePage;
	}
	
	//create invoice generation 
		@RequestMapping(value="/invoicegeneration1",method=RequestMethod.POST)
		public String invoice(Map<String,Object> map,HttpServletRequest request,@Valid @ModelAttribute Invoice_DTO dto, @ModelAttribute Invoice_Items_Dto itemdto,@ModelAttribute Invoice_Vehicle_DTO vehicledto ){
				HttpSession session=null;
				String responsePage="";
				//get session 
				session=request.getSession(false);
				
				String posid=(String)session.getAttribute("pos");
				
					try{
						
						session.setAttribute("invoice", dto);
						session.setAttribute("invoiceItem",itemdto);
						session.setAttribute("invoiceVehicle",vehicledto);
						
						//set value for request attribute in global visible 
						request.setAttribute("mode","MODE_HOME");
						map.put("invoice",dto);
						map.put("invoiceItem",itemdto);
						map.put("invoiceVehicle",vehicledto);
						//send redirect to invoice Details pages
						responsePage= "invoicedetails";
					}
					catch(Exception e){
						request.setAttribute("INVOICE_MODE","INVOICE_NOT_GENERATE");
						responsePage= "welcomeTjTyre";
					}	
			//}
				return responsePage;
		}
		
	@RequestMapping(value="/invoiceedit",method=RequestMethod.GET)
	public String invoiceEdit(Map<String,Object> map,HttpServletRequest request ){
		HttpSession session=null;
		String responsePage="";
	
		Invoice_DTO invoiceDto=null;
		Invoice_Items_Dto itemDto=null;
		Invoice_Vehicle_DTO vehicleDto=null;
		
		session=request.getSession(false);
		
				try{
				
					
						invoiceDto=(Invoice_DTO) session.getAttribute("invoice");
						itemDto=(Invoice_Items_Dto) session.getAttribute("invoiceItem");
						vehicleDto=(Invoice_Vehicle_DTO) session.getAttribute("invoiceVehicle");
					 
						//set value for request attribute in global visible 
						request.setAttribute("INVOICEEDIT","INVOICE_EDIT");
					
						map.put("update",invoiceDto);
						map.put("updateitem",itemDto);
						map.put("updateVehicle",vehicleDto);
			
						//send redirect to invoice Details pages
					responsePage= "invoicegeneration2";
				}
				catch(Exception e){
					
					request.setAttribute("INVOICE_MODE","INVOICE_NOT_GENERATE");
					responsePage= "welcomeTjTyre";
				}
				return responsePage;
		}
	
		//final invoiceGenerate create service 
		@RequestMapping(value="/createinvoiceconform",method=RequestMethod.GET)
		public String kisokInvoicegenerateProcess(Map<String,Object> map,HttpServletRequest request){
				HttpSession session=null;
				String responsePage="";
				InvoiceDTO dto=null;
				
				Invoice_DTO invoiceDto=null;
				Invoice_Items_Dto itemDto=null;
				Invoice_Vehicle_DTO vehicleDto=null;
		
				session=request.getSession(false);
				String posId=(String) session.getAttribute("pos");
				
				try{
					
					
					 	invoiceDto=(Invoice_DTO) session.getAttribute("invoice");
						itemDto=(Invoice_Items_Dto) session.getAttribute("invoiceItem");
						vehicleDto=(Invoice_Vehicle_DTO) session.getAttribute("invoiceVehicle");
				
						try{
							
						dto=service.invoiceCreation(invoiceDto, itemDto, vehicleDto, request);
						POSDTO posdto=service.getAddressofPOS(posId);
						map.put("result", dto);
						map.put("pos_addresses", posdto);
						session.setAttribute("invoiceDetails", dto);
						session.setAttribute("pos_address", posdto);
						}
						catch(Exception e){
						
							e.printStackTrace();
						}
					//set value for request attribute in global visible 
						request.setAttribute("mode","MODE_HOME");
				
					
					//send redirect to invoice Details pages
					responsePage= "details";
				}
				catch(Exception e){
					
					request.setAttribute("INVOICE_MODE","INVOICE_NOT_GENERATE");
					responsePage= "welcomeTjTyre";
				}
				return responsePage;
		}
		//DOWNLOAD invoice report generated in PDF file  
		@ResponseBody
	    @RequestMapping(value = "/pdfgeneration", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> showDetails(Map<String,Object> map ,HttpServletRequest request) throws Exception {
			
			HttpSession session=null;
			InvoiceDTO invoiceDTO=null;
			HttpHeaders headers =null;
			 ByteArrayInputStream bis =null;
			session=request.getSession(false);
			POSDTO posdto=null;
			
			try{
			
			//invoiceDTO=service.InvoiceDetail(request);
			invoiceDTO=(InvoiceDTO) session.getAttribute("invoiceDetails");
			posdto=(POSDTO) session.getAttribute("pos_address");
			bis = GeneratePdfReport.invoicePdf(invoiceDTO,posdto);

	         headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=invoice.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
			}
			catch(Exception e){
							return ResponseEntity
			                .ok()
			                .headers(headers)
			                .contentType(MediaType.APPLICATION_PDF)
			                .body(new InputStreamResource(bis));
			}
		}
	
		//fetch list of tyrePattern in data base and show in drop-downlist
				@ModelAttribute("tyrepattern")
				/*@ResponseBody
				@RequestMapping(value="patternByPos/{pos}",method=RequestMethod.GET)*/
				public List<Pos_Item_Price_Dto_Responce> getTyrePatternByPos(HttpServletRequest request){
					List<Pos_Item_Price_Dto_Responce> listdto=null;
					
					
					HttpSession session=null;
					session=request.getSession(false);
					String posid=(String) session.getAttribute("pos");
					
					try{
					//get All TyrePattern 
					
					listdto=service.getItemPatternByPos(posid);
					
					}
					catch(Exception e){}
					return listdto;
				}
		//fetch list of salesmanId  under a particular POS 
		@ModelAttribute("posid")
		public List<UserDTO> findSalesmanid(HttpServletRequest request){
			HttpSession session=null;
			List<UserDTO> listdto=null;
			
			//call the session 
			 session=request.getSession(false);
			
			//cast POS in  session value 
			String pos=(String)session.getAttribute("pos");
			
			try{
			//get all salesManId under the particular POS 
			listdto=service.allSalesManId(pos);
			}
			catch(Exception e){
				request.setAttribute("POS_DETAILS","INTERNAL SOME PROBLEM");
				return listdto;
			}
			return listdto;
		}//end findSalesmanid()
		
		@ResponseBody
		@RequestMapping(value="tyresizes/{pattern}",method=RequestMethod.GET)
		public List<String>  findTyresizeByPosAndPattern(HttpServletRequest request,@PathVariable("pattern")String pattern ){
			
			List<String> listtyresize=null;
			
			HttpSession session=null;
			session=request.getSession(false);
			String posid=(String) session.getAttribute("pos");
			try{
			//Find All TyreSize Under the particular TyrePattern 
				listtyresize=service.getItemSizeByPos(posid, pattern);
			}
			catch(Exception e){
				e.printStackTrace();
				
				return listtyresize;
			}
		
			return listtyresize;
		}// End findTyresize
		
		
		
		@ResponseBody
		@RequestMapping(value="tyreprice/{tyrepattern},{tyresize}",method=RequestMethod.GET)
		public Double getPriceByPatternAndSize(HttpServletRequest request,@PathVariable("tyrepattern") String tyrepattern,@PathVariable("tyresize") String tyresize){
			Double price=0.0;
			
			HttpSession session=null;
			session=request.getSession(false);
			String posid=(String) session.getAttribute("pos");
			
			Double response=0.0;
			
			
				try{
			//get price 
			price=service.getPriceByPatternAndSize(posid, tyrepattern, tyresize);
			
			response= price;
				}
			catch(Exception e){
				
				response= price;
			}

			return  response;
		}
		
	//ListInvoice in the particular location
	@RequestMapping(value="/listinvocepos" ,method=RequestMethod.GET)
	public String listInvoiceInPos(Map<String,Object>map,HttpServletRequest request) {
		List<InvoiceDTO> listInvoice=null;
		HttpSession session=null;
		String responsePage="";
		//get session 
		session=request.getSession(false);
		//get session attribute 
		String pos=(String) session.getAttribute("pos");
		try{
		listInvoice=service.ListInvoicePos(pos);
		map.put("listinvoice",listInvoice);
		request.setAttribute("invoice","LIST_INVOICE");
		request.setAttribute("poslist",pos);
		
		responsePage= "welcomeTjTyre";
		}
		catch(Exception e){
			e.printStackTrace();
			responsePage= "welcomeTjTyre";
		}
		return responsePage;
	}
	
	
	
	
	
	//mailing service 
	 @RequestMapping(value="/send",method=RequestMethod.GET)
	 public String sendma(HttpServletRequest request) throws Exception {
		 	HttpSession session=null;
		 	String responsePage="";
		 	InvoiceDTO invoiceDTO=null;
		 	//get Session attribute
		 	session=request.getSession(false);
		 	String posId=(String) session.getAttribute("pos");
		 	
		 	//get the POS Address 
		 	POSDTO posdto=service.getAddressofPOS(posId);
		 	
		 	MailConnectionproperties properties=null;
		 	GenerateInvoicePdfReport invoicePdfReport=null;
		 	ByteArrayOutputStream outputStream = null;
		 	byte[] bytes=null,warentybytes=null;
		 	properties=new MailConnectionproperties();
		 	properties.setAuth(auth);
		 	properties.setHost(host);
		 	properties.setMailpassword(mailpassword);
		 	properties.setPort(port);
		 	properties.setStarttls(starttls);
		 	properties.setUsername(usernames);
		 	
		 	MailService mailService=new MailService();
		 	
		 	//create Session object
			session=request.getSession(false);
			 invoiceDTO=(InvoiceDTO) session.getAttribute("invoiceDetails");
			
			 //now write the PDF content to the output stream			
		 	outputStream = new ByteArrayOutputStream();
		 	List<byte[]> listtattachment=new ArrayList<byte[]>();
		 	//invoice PDF generation service 
	        invoicePdfReport=new GenerateInvoicePdfReport(); 
	        invoicePdfReport.invoicePdfGeneration(invoiceDTO,posdto,outputStream);
	        bytes = outputStream.toByteArray();
	        listtattachment.add(bytes);
	 
	        //Warranty invoice  PDF generation service
	        String [] tyresize=invoiceDTO.getTyresizes();
	        for(int i=0;i<tyresize.length;i++){
	        invoiceDTO.setTyresize(tyresize[i]);
	        invoicePdfReport.invoicePdfGenerationWarrenty(invoiceDTO,posdto, outputStream);
			warentybytes=outputStream.toByteArray();
			listtattachment.add(warentybytes);
	        }
	        
			try{
			//test the session is equals to admin or null if admin null then it goes to catch block
		
				mailService.sendmail(request,listtattachment, properties);
	
				 request.setAttribute("mail","Sent mail Sucessfully");
			responsePage= "welcomeTjTyre";
			}
			catch(Exception e){
				 request.setAttribute("mail","sent mail Unsucessfully ");
				 e.printStackTrace();
				 responsePage= "welcomeTjTyre";
			}
			return responsePage;
	 }
	 
	 @GetMapping("posaddress/{posid}")
	 @ResponseBody
	 public POSDTO address(@PathVariable("posid") String posId) throws Exception{
		 POSDTO posdto=service.getAddressofPOS(posId);
		 return posdto;
	 }
	 
}//end Class 
		

