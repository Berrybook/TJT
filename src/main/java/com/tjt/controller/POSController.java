package com.tjt.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.City_DTO;
import com.tjt.dto.POSDTO;
import com.tjt.dto.Pos_Item_Price_Dto;
import com.tjt.dto.Pos_Item_Price_Dto_Responce;
import com.tjt.service.POSService;
import com.tjt.service.Pos_Item_Price;

@Controller
public class POSController {
	@Autowired
	private POSService posService;
	
	@Autowired
	private Pos_Item_Price pos_Item_Price;
	
	@RequestMapping(value="Poscreate",method=RequestMethod.GET)
	public String createPOS(HttpServletRequest request,Map<String,Object> map){
		
		List<POSDTO> listdto=null;
		//create Session object
		
		
		try{
		//test the session is equals to admin or null if admin null then it goes to catch block
		
		request.setAttribute("POS_REG", "POS_REG");
		
		listdto=posService.listPos();
		map.put("listpos", listdto);
		 return "POS_REG";
		
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
	}

	@RequestMapping(value="tjtyrePOS",method=RequestMethod.POST)
	public String processPOS(Map<String,Object> map,HttpServletRequest request,@ModelAttribute POSDTO dto,BindingResult result) throws Exception{
		List<POSDTO> listdto=null;
		String results="";
		try{
		 results=posService.createPOS(dto);
			listdto=posService.listPos();
			map.put("listpos", listdto);
			request.setAttribute("POS_success", results);
			request.setAttribute("POS_REG", "POS_REG");
		 }
		 catch(Exception e){
			 listdto=posService.listPos();
				map.put("listpos", listdto);
			request.setAttribute("POS_REG", "POS_REG");
			 request.setAttribute("POS_success", "POS Unsuccessfully Registered ");
			 return "POS_REG";
		 }
		 return "POS_REG";
	}
	
	@RequestMapping(value="PosById",method=RequestMethod.GET)
	public String POSById(HttpServletRequest request,Map<String,Object> map){
		String pos=null;
		POSDTO posDto=null;
		List<POSDTO> listdto=null;
		pos=request.getParameter("posId");
		try{
			posDto=posService.listById(pos);
			map.put("pos_update", posDto);
			listdto=posService.listPos();
			map.put("listpos", listdto);
		}
		catch(Exception e){
			request.setAttribute("posUpdate", "posUpdate");
			map.put("pos_update", posDto);
			 return "POS_REG";
		}
		request.setAttribute("posUpdate", "posUpdate");
		
		 return "POS_REG";
	}
	
	@RequestMapping(value="updatePos",method=RequestMethod.POST)
	public String updatePOS(Map<String,Object> map,HttpServletRequest request,@ModelAttribute POSDTO dto,BindingResult result) throws Exception{
		List<POSDTO> listdto=null;
		try{
			posService.updatePOS(dto);
			listdto=posService.listPos();
			map.put("listpos", listdto);
			request.setAttribute("POS_update", "POS Successfully Updated");
			request.setAttribute("POS_REG", "POS_REG");
		 }
		 catch(Exception e){
			 request.setAttribute("POS_update", "POS Unsuccessfully updated");
			 request.setAttribute("POS_REG", "POS_REG");
			 listdto=posService.listPos();
			 map.put("listpos", listdto);
			 return "POS_REG";
		 }
		 return "POS_REG";
	}
	@RequestMapping(value="deletePosById",method=RequestMethod.POST)
	public String deletePOSById(HttpServletRequest request){
		String pos=null;
		pos=request.getParameter("pos");
		try{
		posService.deletePOS(pos);
		}
		catch(Exception e){
			request.setAttribute("DELETEBYID", "Internal Issue Try Again");
			 return "admin";
		}
		request.setAttribute("DELETEBYID", "POS Successfully  Deleted");
		
		 return "admin";
	}
	
	@RequestMapping(value="Posbyall",method=RequestMethod.GET)
	public String POSByAll(HttpServletRequest request,Map<String,Object> map){
		List<POSDTO> listdto=null;
		try{
			listdto=posService.listPos();
			map.put("listpos", listdto);
		}
		catch(Exception e){
			request.setAttribute("POSALL_FAIL", "POSALL_FAIL");
			map.put("listpos", listdto);
			 return "PosList";
		}
		request.setAttribute("FIND_ALL", "FIND_ALL");
		
		 return "PosList";
	}
	/*@ResponseBody
	@RequestMapping(value="allCity",method=RequestMethod.GET)*/
	@ModelAttribute("allCity")
	public List<City_DTO> listCity(HttpServletRequest request){
		List<City_DTO> listCity=null;
		
		try{
		listCity=posService.listCity();
		}
		catch(Exception e){
		return listCity;
		}
	
		return listCity;
	}
	
	@ResponseBody
	@RequestMapping(value="/findgstno/{city}",method=RequestMethod.GET)
	public String[] findGstNoAndGstAdd(@PathVariable("city")String city){
		String[] gst=null;
		try{
			gst=posService.findGstnoAndGsrAdd(city);
		
		}
		catch(Exception e){
		
			return gst;
		}
		return gst;
	}
	
	@RequestMapping(value="/priceListByPos",method=RequestMethod.GET)
	public String priceListByPos(HttpServletRequest request,Map<String,Object> map) throws Exception{
		List<Pos_Item_Price_Dto_Responce> listPrice=null;
		 HttpSession session=null;
		session=request.getSession(true);
		String pos=(String) session.getAttribute("pos");
		listPrice=posService.PriceList(pos);
		map.put("itemPrice", listPrice);
		return "item_price_list";
	}
	
	//get Item_Price_Assign Pages
	@RequestMapping(value="item_price_assign",method=RequestMethod.GET)
	public String item_Price_assign(){
		 return "item_price_assign";
	}
	
	//Assignment all price in each item for each pos 
		@RequestMapping(value="/priceAssignment",method=RequestMethod.POST)
		
		public String POS_Item_Price(HttpServletRequest request,@ModelAttribute Pos_Item_Price_Dto pos_Item_price_Dto ){
			try{
			pos_Item_Price.priceAssignmentInPos(pos_Item_price_Dto);
			request.setAttribute("price_assignment", "Price Assignment Successfully ");
			}
			catch(Exception e){
			request.setAttribute("price_assignment", "Price Assignment Unsuccessfully ");
			}
			return "item_price_assign";
		}
		
		
		//get ALl POSItem By CityName
		@RequestMapping(value="/getAllPosItem/{cityname}",method=RequestMethod.GET)
		@ResponseBody
		public List<Pos_Item_Price_Dto_Responce> allPosaAndItemByCity(@PathVariable("cityname")String cityName) throws Exception{
			List<Pos_Item_Price_Dto_Responce> listPosItem=null;
			listPosItem=pos_Item_Price.allPosItemByCity(cityName);
			return listPosItem;
		}
	
}
