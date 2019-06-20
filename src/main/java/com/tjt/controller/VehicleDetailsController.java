package com.tjt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.VehicleDetailsDto;
import com.tjt.service.VehicleDetailsService;

@Controller
public class VehicleDetailsController {
	
	@Autowired VehicleDetailsService vehicleService;

	@ResponseBody
	@RequestMapping(value="/searchDetailsByBrand/{vehicleBrand}",method=RequestMethod.GET)
	public List<VehicleDetailsDto> allTyreDetailsByBrand(@PathVariable("vehicleBrand") String vehicleBrand) throws Exception{
		
		List<VehicleDetailsDto> listdetails = null;
		try {
		listdetails= vehicleService.allTyreDetailsByBrand(vehicleBrand);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listdetails;
	}
}
