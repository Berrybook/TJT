package com.tjt.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.Invoice_DTO;
import com.tjt.dto.Invoice_Items_Dto;
import com.tjt.dto.Invoice_Vehicle_DTO;
import com.tjt.dto.KisokInvoiceDTO;
import com.tjt.dto.TyreInformationDTO;
import com.tjt.dto.UserDTO;
import com.tjt.service.InvoiceGenerationService;
import com.tjt.util.GeneratePdfReport;
import com.tjt.util.GeneratePdfReport2;

@Controller

public class KisokInvoiceController {
	
	@Autowired
	private InvoiceGenerationService service;
	
	@Value("${tjtyres.username}")
	private String username;
	@Value("${tjtyres.password}")
	private String password;
	
	
	//landing page form 
	@RequestMapping(value="welcome")
	public String welCome(HttpServletRequest request){
		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String possession=(String) session.getAttribute("possession");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(possession.equals("possession")){
		request.setAttribute("mode","MODE_INVOICE");
		}
		 return "welcomeTjTyre";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
	}

	//logout 
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session=null;
		session=request.getSession(false);
		if(session !=null){
		session.invalidate();
		request.setAttribute("logout"," Log Out Successfully ");
		}
		return "login";
		
	}
	
	//TjTyre invoiceGenerate form page
	@RequestMapping(value="/createinvoice",method=RequestMethod.GET)
	public String kisokInvoiceGenerateForm(HttpServletRequest request){
		
		HttpSession session=null;
		
		//create Session object
		session=request.getSession(false);
		String possession=(String) session.getAttribute("possession");
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(possession.equals("possession")){
		request.setAttribute("mode","MODE_INVOICE");
		}
		 return "invoicegeneration2";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
	}
	
	//create invoice generation 
	@RequestMapping(value="/invoicegeneration",method=RequestMethod.POST)
	public String invoiceConformation(Map<String,Object> map,HttpServletRequest request,@Valid @ModelAttribute KisokInvoiceDTO dto,BindingResult result ){
			HttpSession session=null;
			//check the model class field is valid or not 
			if(result.hasErrors()){
				request.setAttribute("invoicegeneration","Invoice_Generation");
				return "welcomeTjTyre";
			}
			else{
				try{
					System.out.println("invoice From ");
					session=request.getSession(false);
					String tyresize=(String) session.getAttribute("tyresize");
					dto.setTyresize(tyresize);
					session.setAttribute("invoice", dto);
				}
				catch(Exception e){
					request.setAttribute("INVOICE_MODE","INVOICE_NOT_GENERATE");
					return "welcomeTjTyre";
				}
				//set value for request attribute in global visible 
				request.setAttribute("mode","MODE_HOME");
				map.put("invoice",dto);
				//send redirect to invoice Details pages
				return "invoicedetails";
		}
	}
	//create invoice generation 
		@RequestMapping(value="/invoicegeneration1",method=RequestMethod.POST)
		public String invoice(Map<String,Object> map,HttpServletRequest request,@Valid @ModelAttribute Invoice_DTO dto,@Valid @ModelAttribute Invoice_Items_Dto itemdto,@ModelAttribute Invoice_Vehicle_DTO vehicledto,BindingResult result ){
				HttpSession session=null;
				//check the model class field is valid or not 
				if(result.hasErrors()){
					System.out.println("invoice From ERROR ");
					request.setAttribute("invoicegeneration","Invoice_Generation");
					return "welcomeTjTyre";
				}
				else{
					try{
						
						//get session 
						session=request.getSession(false);
						@SuppressWarnings("unchecked")
						ArrayList<String> tyresizes=(ArrayList<String>) session.getAttribute("tyresize");
						String[] tyresize=new String[tyresizes.size()];
						int i=0;
						for (String string : tyresizes) {
							
							tyresize[i]=string;
							i++;
						}
						itemdto.setTyre_size(tyresize);
						session.setAttribute("invoice", dto);
						session.setAttribute("invoiceItem",itemdto);
						session.setAttribute("invoiceVehicle",vehicledto);
						
					}
					catch(Exception e){
						request.setAttribute("INVOICE_MODE","INVOICE_NOT_GENERATE");
						return "welcomeTjTyre";
					}
					//set value for request attribute in global visible 
					request.setAttribute("mode","MODE_HOME");
					map.put("invoice",dto);
					map.put("invoiceItem",itemdto);
					map.put("invoiceVehicle",vehicledto);
					//send redirect to invoice Details pages
					return "invoicedetails";
			}
		}
	@RequestMapping(value="/invoiceedit",method=RequestMethod.GET)
	public String invoiceEdit(Map<String,Object> map,HttpServletRequest request ){
		HttpSession session=null;
		//KisokInvoiceDTO dto=null;
		Invoice_DTO invoiceDto=null;
		Invoice_Items_Dto itemDto=null;
		Invoice_Vehicle_DTO vehicleDto=null;
		
		session=request.getSession(false);
		String possession=(String) session.getAttribute("possession");
				try{
					if(possession.equals("possession")){
						// dto=(KisokInvoiceDTO) session.getAttribute("invoice");
						invoiceDto=(Invoice_DTO) session.getAttribute("invoice");
						itemDto=(Invoice_Items_Dto) session.getAttribute("invoiceItem");
						vehicleDto=(Invoice_Vehicle_DTO) session.getAttribute("invoiceVehicle");
					 
						//set value for request attribute in global visible 
						request.setAttribute("INVOICEEDIT","INVOICE_EDIT");
						//map.put("update", dto);
						map.put("update",invoiceDto);
						map.put("updateitem",itemDto);
						map.put("updateVehicle",vehicleDto);
					}
						//send redirect to invoice Details pages
						return "editinvoice";
				}
				catch(Exception e){
					request.setAttribute("SessionTimeOut", "Should enter Username and Password");
					if(possession==null){
					return "login";
				    }
					request.setAttribute("INVOICE_MODE","INVOICE_NOT_GENERATE");
					return "welcomeTjTyre";
				}
		}
	
		//final invoiceGenerate create service 
		@RequestMapping(value="/createinvoiceconform",method=RequestMethod.GET)
		public String kisokInvoicegenerateProcess(Map<String,Object> map,HttpServletRequest request ){
				HttpSession session=null;
				//KisokInvoiceDTO dto=null;
				Invoice_DTO invoiceDto=null;
				Invoice_Items_Dto itemDto=null;
				Invoice_Vehicle_DTO vehicleDto=null;
				
				session=request.getSession(false);
				String possession=(String) session.getAttribute("possession");
				try{
					if(possession.equals(possession)){
					//	dto=(KisokInvoiceDTO) session.getAttribute("invoice");
					 	invoiceDto=(Invoice_DTO) session.getAttribute("invoice");
						itemDto=(Invoice_Items_Dto) session.getAttribute("invoiceItem");
						vehicleDto=(Invoice_Vehicle_DTO) session.getAttribute("invoiceVehicle");
					// service.InvoiceSave(dto,request);
						try{
							
						service.invoiceCreation(invoiceDto, itemDto, vehicleDto, request);
						}
						catch(Exception e){
							System.out.println("Exception from sumbit final ");
							e.printStackTrace();
						}
					//set value for request attribute in global visible 
						request.setAttribute("mode","MODE_HOME");
					}
					
					//send redirect to invoice Details pages
					return "redirect:/showData";
				}
				catch(Exception e){
					request.setAttribute("SessionTimeOut", "Should enter Username and Password");
					if(possession==null){
					return "login";
				    }
					request.setAttribute("INVOICE_MODE","INVOICE_NOT_GENERATE");
					return "welcomeTjTyre";
				}
		}
	
		
		//invoice report generated in JSP file 
		@RequestMapping(value="/showData" ,method=RequestMethod.GET)
		public String invoiceDetails(Map<String,Object> map ,HttpServletRequest request) {
			HttpSession session=null;
			InvoiceDTO dto=null;
			
			session=request.getSession(false);
			String possession=(String) session.getAttribute("possession");	
			try{
				if(possession.equals(possession)){
				//call service class method
				dto=service.InvoiceDetail(request);
				//set value for map object for global visible 
				map.put("result", dto);
				}
				return "details";
			}
			catch(Exception e){
				request.setAttribute("SessionTimeOut", "Should enter Username and Password");
				if(possession==null){
				return "login";
			    }
				request.setAttribute("INVOICE_DETAILS","INVOICE_NOT_GENERATE");
				return "welcomeTjTyre";
			}
			
		}
		
		//DOWNLOAD invoice report generated in PDF file  
		@ResponseBody
	    @RequestMapping(value = "/pdfgeneration", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> showDetails(Map<String,Object> map ,HttpServletRequest request) throws Exception {
			
			HttpSession session=null;
			InvoiceDTO dto=null;
			HttpHeaders headers =null;
			 ByteArrayInputStream bis =null;
			session=request.getSession(false);
			String possession=(String) session.getAttribute("possession");
			try{
			if(possession.equals(possession)){
				
			}
			dto=service.InvoiceDetail(request);
	        bis = GeneratePdfReport.citiesReport(dto);

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
		public List<TyreInformationDTO> findTyrePattern(HttpServletRequest request){
			List<TyreInformationDTO> listdto=null;
			
			try{
			//get All TyrePattern 
			listdto=service.findTyrePattern();
			}
			catch(Exception e){
				request.setAttribute("tyrepattern","INTERNAL SOME PROBLEM");
				return listdto;
			}
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
		
		//fetch list of tyreSize under the particular tyrePttern 
		@ResponseBody
		@RequestMapping(value="tyresize/{tyrepattern}",method=RequestMethod.GET)
		public List<String>  findTyresize(HttpServletRequest request,@PathVariable("tyrepattern")String tyrepttern ){
			
			List<String> listtyresize=null;
			List<TyreInformationDTO> listdto=null;
			String tyresize=null;
			HttpSession session=null;
			//get session 
			session=request.getSession(false);
			//add value from session 
			session.setAttribute("tyrepattern",tyrepttern);
			//create list Of String type Generic 
			listtyresize=new ArrayList<String>();
			try{
			//Find All TyreSize Under the particular TyrePattern 
			listdto=service.findTyreSize(tyrepttern);
			}
			catch(Exception e){
				request.setAttribute("tyresize","INTERNAL SOME PROBLEM");
				return listtyresize;
			}
			//iterative list 
			for(TyreInformationDTO dto:listdto){
				for(int i=0;i<1;i++){
					//set tyreSize into String 
					tyresize =dto.getTyresize();
					//add tyreSize into list
					listtyresize.add( tyresize);
				}//end internal for loop
			}//end ForLoop 
			request.setAttribute("tyresizelist", listtyresize);
			return listtyresize;
			
		}// End findTyresize
		
	@ResponseBody
	@RequestMapping(value="tyreprice/{tyrepattern},{tyresize}",method=RequestMethod.GET)
	public Double getTyrePrice(HttpServletRequest request,@PathVariable("tyrepattern") String tyrepattern,@PathVariable("tyresize") String tyresize){
		Double price=0.0;
		HttpSession session=null;
		session=request.getSession(false);
		session.setAttribute("size", tyresize);
		
		ArrayList<String> tyresizes = new ArrayList<String>();
		tyresizes.add((String) session.getAttribute("size"));

		//get session 
		
		session.setAttribute("tyresize", tyresizes);
			try{
		//get price 
		price=service.getTyrePrice(tyrepattern, tyresize);
			}
		catch(Exception e){
			request.setAttribute("tyreprice","INTERNAL SOME PROBLEM");
			return price;
		}

		return  price;
	}
	//ListInvoice in the particular location
	@RequestMapping(value="/listinvocepos" ,method=RequestMethod.GET)
	public String listInvoiceInPos(Map<String,Object>map,HttpServletRequest request) {
		List<InvoiceDTO> listInvoice=null;
		HttpSession session=null;
		//get session 
		session=request.getSession(false);
		//get session attribute 
		String pos=(String) session.getAttribute("pos");
		try{
		listInvoice=service.ListInvoicePos(pos);
		}
		catch(Exception e){
			e.printStackTrace();
			return "welcomeTjTyre";
		}
		map.put("listinvoice",listInvoice);
		request.setAttribute("invoice","LIST_INVOICE");
		request.setAttribute("poslist",pos);
		
		return "welcomeTjTyre";
	}
	
	//editing the invoice 
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String invoiceUpdate(Map<String ,Object> map,HttpServletRequest request ) throws Exception{
		InvoiceDTO dto=null;
		HttpSession session =null;
		 session=request.getSession(false);
		 
		 Long customerId=Long.parseLong(request.getParameter("customerId"));
		
		 dto=service.FindInvoiceById(customerId);
		 session.setAttribute("customerID", dto.getInvoice_Number());
		 
		 request.setAttribute("updatemode", "UPDATE_MODE");
		 map.put("update",dto);
		return "welcomeTjTyre";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String InvoiceUpdateProcess(Map<String ,Object> map,@ModelAttribute InvoiceDTO dto,BindingResult result,HttpServletRequest request){
		String res=null;
		HttpSession session =null;
		 session=request.getSession(false);
		 Long customerID=(Long) session.getAttribute("customerID");
		dto.setInvoice_Number(customerID);
		try{
		res=service.UpdateInvoiceById(dto);
		}
		catch(Exception e){
			request.setAttribute("UPDATE","SOME INTERNAL ISSU");
			return "welcomeTjTyre";
		}
			map.put("result", res);
		return "welcomeTjTyre";
	}
	
	//mailing service 
	 @RequestMapping(value="/send",method=RequestMethod.GET)
	 public String sendma(HttpServletRequest request) {
		 	HttpSession session=null;
			
			//create Session object
			session=request.getSession(false);
			String possession=(String) session.getAttribute("possession");
			try{
			//test the session is equals to admin or null if admin null then it goes to catch block
			if(possession.equals("possession")){
				sendemaeil(request);
				 request.setAttribute("mail","Send mail sucessfully");
			}
			 	return "welcomeTjTyre";
			}
			catch(Exception e){
				request.setAttribute("SessionTimeOut", "Should enter Username and Password");
				if(possession==null){
					return "login";
				}
				 request.setAttribute("mail","maile not send sucessfully");
				 return "welcomeTjTyre";
			}
	 }
	private void sendemaeil(HttpServletRequest request ) throws Exception{
		
		InvoiceDTO dto=null;
			//get invoice details 
			dto=service.InvoiceDetail(request);

	      //now write the PDF content to the output stream
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        GeneratePdfReport2.citiesReport(dto,outputStream);
	        byte[] bytes = outputStream.toByteArray();
	        
	       
		 //Email configuration
	    Properties pos=new Properties();
		pos.put("mail.smtp.auth", "true");
		pos.put("mail.smtp.starttls.enable", "true");
		pos.put("mail.smtp.host", "tjtyres.com");
		pos.put("mail.smtp.port", "587");
		
		
		Session session=Session.getInstance(pos, new javax.mail.Authenticator(){
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress(username,false));
		msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(dto.getEmail()));
		msg.setSubject("TjTyre Invoice ");
		
		msg.setSentDate(new Date());
		
		 //construct the pdf body part
        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
     //  pdfBodyPart.setDataHandler(new DataHandler("Object", mimeType));
        pdfBodyPart.setFileName("tjtyreinvoice.pdf");
		
		
		
		Multipart multipart=new MimeMultipart();
		multipart.addBodyPart(pdfBodyPart);
		
	
		msg.setContent(multipart);
		//send the mail
		try{
		Transport.send(msg);
		}
		catch(Exception e){
			System.out.println(" hhhh");
			e.printStackTrace();
		}
		
	}
	
		
		
}//end Class 
		

