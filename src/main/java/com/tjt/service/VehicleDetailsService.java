package com.tjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tjt.dto.VehicleDetailsDto;


public interface VehicleDetailsService {

	public List<String> allVehicleBrand() throws Exception;
	public List<VehicleDetailsDto> allTyreDetailsByBrand(String vehicleBrand) throws Exception;
} 
