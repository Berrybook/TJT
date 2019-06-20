package com.tjt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tjt.dto.AdhocAssignmentDto;
import com.tjt.dto.City_DTO;
import com.tjt.dto.POSDTO;
import com.tjt.dto.UserDTO;
import com.tjt.entity.Adhoc_Assignment;
import com.tjt.entity.City_Table;
import com.tjt.service.AdhocAssignmentService;
import com.tjt.service.POSService;
import com.tjt.service.UserService;

@Controller
public class AdhocAssignmentController {

	@Autowired
	AdhocAssignmentService adhocService;
	@Autowired
	UserService usrService;

	@Autowired
	private POSService poser;

	@RequestMapping(value = "adhoccreate", method = RequestMethod.GET)
	public String adhocCreate(HttpServletRequest request, Map<String, Object> map) {

		List<City_DTO> listdto = null;
		// create Session object

		try {
			// test the session is equals to admin or null if admin null then it goes to
			// catch block

			request.setAttribute("POS_REG", "POS_REG");

			listdto = poser.listCity();
			map.put("listpos", listdto);
			return "adhocsaleman";

		} catch (Exception e) {
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
	}

	// All city in drop down

	@ModelAttribute("getAllCityindrop")
	public List<City_DTO> allCity() {
		List<City_DTO> listCity = null;
		ResponseEntity<List<City_DTO>> listhh = null;
		try {
			listCity = adhocService.allCity();

			listhh = new ResponseEntity<>(listCity, HttpStatus.MULTI_STATUS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCity;
	}

//@ResponseBody
//		@RequestMapping(value="salesmanByCity/{cityname}",method=RequestMethod.GET)	
//		public List<AdhocAssignmentDto> allSalesmanByCity(@PathVariable("cityname") String cityname) throws Exception{
//			System.out.println(cityname);
//			List<AdhocAssignmentDto> listadhoc = null;
//				listadhoc = adhocService.allSalesmanByCity(cityname);
//				System.out.println(listadhoc);
//			return 	listadhoc;
//			}

//@GetMapping("salesmanById/{uid}")
//public List<AdhocAssignmentDto> findbysalemanid(@PathVariable("uid") String uid)
//{
//	List<AdhocAssignmentDto> list=new ArrayList<AdhocAssignmentDto>();
//	
//	list=adhocService.findsalemanbyid(uid);
//
//	return list;
//}

	@RequestMapping(value = "adhocAllList", method = RequestMethod.GET)
	public String allAssignedAdhoc(HttpServletRequest req) {

		List<AdhocAssignmentDto> listdto = null;
		try {
			listdto = adhocService.allAssignedAdhoc();
			req.setAttribute("listdto", listdto);
			System.out.println(listdto);
		} catch (Exception e) {

		}
		return "alladhocassign";
	}

	@RequestMapping(value = "editadhoccontroller", method = RequestMethod.GET)
	public String editadhoc(HttpServletRequest req) {

		return "editadhoc";
	}

	@ResponseBody
	@RequestMapping(value = "salesmanByCity/{cityname}", method = RequestMethod.GET)
	public List<AdhocAssignmentDto> allSalesmanByCity(@RequestParam("cityname") String cityname) throws Exception {
		System.out.println(cityname);
		List<AdhocAssignmentDto> listadhoc = null;
		listadhoc = adhocService.allSalesmanByCity(cityname);
		System.out.println(listadhoc);
		return listadhoc;
	}

	@RequestMapping(value = "salesmanByCitydemo", method = RequestMethod.GET)
	public String allSalesmanByCitydemo(@RequestParam("cityname") String cityname, HttpServletRequest req)
			throws Exception {
		System.out.println(cityname);
		List<City_DTO> listCity = null;
		listCity = adhocService.allCity();
		req.setAttribute("listpos", listCity);
		List<AdhocAssignmentDto> listadhoc = null;
		listadhoc = adhocService.allSalesmanByCity(cityname);
		System.out.println(listadhoc);
		req.setAttribute("listadhoc", listadhoc);
		return "adhocdemo";
	}

	@ResponseBody
	@GetMapping("salesmanById")
	public UserDTO findbysalemanid(HttpServletRequest req, @RequestParam("id") String id) throws Exception {
		UserDTO list = null;

		list = usrService.userByIdhadhoc(id);
		System.out.println("user");
		req.setAttribute("val", list);
		list.getUserName();

		return list;
	}

	@GetMapping("/demoadhoc")
	public String demoadhoc(HttpServletRequest req) throws Exception {
		List<City_DTO> listCity = null;
		listCity = adhocService.allCity();
		req.setAttribute("listpos", listCity);
		return "adhocdemo";
	}

	@PostMapping("updateadhoc")
	public String updateadhoc(@ModelAttribute Adhoc_Assignment adhoc, HttpServletRequest req) throws Exception {
		adhocService.updateadhoc(adhoc);
		List<AdhocAssignmentDto> listdto = null;
		listdto = adhocService.allAssignedAdhoc();
		req.setAttribute("listdto", listdto);
		req.setAttribute("msg", "Successfully Assigned");
		return "editadhoc";
	}

	@ModelAttribute("allpos")
	/*
	 * @RequestMapping(value="/allpos",method=RequestMethod.GET)
	 * 
	 * @ResponseBody
	 */
	public List<POSDTO> findpos(HttpServletRequest request) {
		List<POSDTO> listos = null;
		List<String> list = null;
		list = new ArrayList<>();
		try {
			listos = poser.listPos();
			for (POSDTO posdto : listos) {
				String pos = posdto.getPos();
				list.add(pos);
			}
		} catch (Exception e) {
			return listos;
		}
		return listos;
	}

	@GetMapping("salesmanByIddemo")
	public String findbysalemaniddemo(HttpServletRequest req, @RequestParam("id") String id) throws Exception {
		AdhocAssignmentDto list = null;
		List<AdhocAssignmentDto> listdto = null;
		listdto = adhocService.allAssignedAdhoc();
		req.setAttribute("listdto", listdto);
		System.out.println("String:" + id);
		list = adhocService.allSalesmanByid(id);
		System.out.println("user");
		req.setAttribute("val", list);
		return "editadhoc";
	}

	
	@GetMapping("/posmanadhoc")
	public String posmanadhoc(HttpServletRequest req) throws Exception {
		List<City_DTO> listCity = null;
		System.out.println("conco");
		listCity = adhocService.allCity();
		req.setAttribute("listpos", listCity);
		return "posmanageradhoc";
	}
	
	
	
	@RequestMapping(value = "salesmanByCitypos", method = RequestMethod.GET)
	public String allSalesmanByCitypos(@RequestParam("cityname") String cityname, HttpServletRequest req)
			throws Exception {
		System.out.println(cityname);
		List<City_DTO> listCity = null;
		listCity = adhocService.allCity();
		req.setAttribute("listpos", listCity);
		List<AdhocAssignmentDto> listadhoc = null;
		listadhoc = adhocService.allSalesmanByCity(cityname);
		System.out.println(listadhoc);
		req.setAttribute("listadhoc", listadhoc);
		return "posmanageradhoc";
	}
	
	
	@GetMapping("salesmanByIdpos")
	public String findbysalemanidpos(HttpServletRequest req, @RequestParam("id") String id) throws Exception {
		AdhocAssignmentDto list = null;
		List<AdhocAssignmentDto> listdto = null;
		listdto = adhocService.allAssignedAdhoc();
		req.setAttribute("listdto", listdto);
		System.out.println("String:" + id);
		list = adhocService.allSalesmanByid(id);
		System.out.println("user");
		req.setAttribute("val", list);
		return "editadhocpos";
	}
	
	@PostMapping("updateadhocpos")
	public String updateadhocpos(@ModelAttribute Adhoc_Assignment adhoc, HttpServletRequest req) throws Exception {
		adhocService.updateadhoc(adhoc);
		List<AdhocAssignmentDto> listdto = null;
		listdto = adhocService.allAssignedAdhoc();
		req.setAttribute("listdto", listdto);
		req.setAttribute("msg", "Successfully Assigned");
		return "editadhocpos";
	}
}