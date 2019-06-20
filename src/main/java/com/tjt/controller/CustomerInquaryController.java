package com.tjt.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tjt.dto.UserDTO;
import com.tjt.entity.CustomerForm;
import com.tjt.entity.POS_Table;
import com.tjt.entity.User_Details_Table;
import com.tjt.service.CustomerInquaryService;
import com.tjt.service.InvoiceGenerationService;

@Controller

public class CustomerInquaryController {

	@Autowired
	private CustomerInquaryService customerInquaryService;
	
	@Autowired
	private InvoiceGenerationService service;

	@RequestMapping(value = "CustomerInquaryForm", method = RequestMethod.GET)

	public String customerForm(HttpServletRequest req) {

		HttpSession session = null;
		// create Session object
		session = req.getSession(false);
		try {
			String username = (String) session.getAttribute("pos");
			System.out.println(username);
//			req.setAttribute("val", customerInquaryService.findsalesman(username));
			req.setAttribute("val",service.allSalesManId(username));
			
			req.setAttribute("pos", username);
			return "CustomerInquary";
		} catch (Exception e) {
			System.out.println("catch");
			return "CustomerInquary";
		}
	}

//TO SAVE THE CUSTOMER DATA
	@RequestMapping(value = "savacustomerdata", method = RequestMethod.POST)
	public String customerInquaryForm(@ModelAttribute CustomerForm customerForm, HttpServletRequest req) {
		HttpSession session = null;

		// create Session object
		session = req.getSession(false);
		String username = (String) session.getAttribute("pos");
		System.out.println(username);

		customerInquaryService.customerData(customerForm);
		req.setAttribute("msg", "Successfully Placed");
		return "welcomeTjTyre";

	}

	@GetMapping("/allinquiry")
	public String allinquiry(HttpServletRequest req) throws ParseException

	{
		List<CustomerForm> ob = customerInquaryService.viewalldetails();
		req.setAttribute("val", ob);
		return "allinquiries";

	}

	@GetMapping("findbydate")
	public String findbydate(HttpServletRequest req) {

		req.setAttribute("val", customerInquaryService.finddate());

		return "inquirybydate";
	}

	@GetMapping("customerenquiry")
	public String customerenquiry(HttpServletRequest req) {
		List<CustomerForm> ob = customerInquaryService.viewalldetails();
		req.setAttribute("val", ob);
		return "customerenquiry";
	}

	@GetMapping("findbydatepos")
	public String findbydatepos(HttpServletRequest req) {

		req.setAttribute("val", customerInquaryService.finddate());

		return "cusinqinposbydate";
	}

	@GetMapping("customerenquirypos")
	public String customerenquirypos(HttpServletRequest req) {
		List<CustomerForm> ob = customerInquaryService.viewalldetails();
		req.setAttribute("val", ob);
		return "customerenquirypos";
	}
	
	//for pos manager find by date
	@GetMapping("findbydateposman")
	public String findinqdateposman(HttpServletRequest req) {

		req.setAttribute("val", customerInquaryService.finddate());

		return "cusinqposmanbydate";
	}
   //for pos manager all
	@GetMapping("custenqposman")
	public String customerinqposman(HttpServletRequest req) {
		List<CustomerForm> ob = customerInquaryService.viewalldetails();
		req.setAttribute("val", ob);
		return "custinqposmanager";
	}

}
