package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.VehicleDetailsDao;
import com.tjt.dto.VehicleDetailsDto;
import com.tjt.entity.Vehicle_Details;

@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService {

	@Autowired VehicleDetailsDao dao;
	
	@Override
	public List<String> allVehicleBrand() throws Exception {
		List<String> allbrand = null;
		List<Vehicle_Details> ventity =null;
		allbrand = new ArrayList<String>();
		ventity = dao.findAll();
		for(Vehicle_Details vehicle : ventity)
		{
			String all=vehicle.getVehicleBrand();
			
			allbrand.add(all);
		}
		return allbrand;
	}

	//search tyre using vehicle brand 
	@Override
	public List<VehicleDetailsDto> allTyreDetailsByBrand(String vehicleBrand) throws Exception {
		
		List<VehicleDetailsDto> listdto = new ArrayList<VehicleDetailsDto>();
		Vehicle_Details entity = new Vehicle_Details();
		entity.setVehicleBrand(vehicleBrand);
		List<Object[]> listallVehicle = null;
		
		listallVehicle = dao.allTyreDetailsByBrand(vehicleBrand);
		System.out.println("listallVehicle"+listallVehicle);
		for(Object[] obj: listallVehicle) {
			
			VehicleDetailsDto dto =new VehicleDetailsDto();
			dto.setVehicleMake((String) obj[0]);
			System.out.println((String) obj[0]);   
			
			dto.setFrontSize((String) obj[1]);
			dto.setRearSize((String) obj[2]);
			listdto.add(dto);
		}
		
		System.out.println("value"+listdto);
		return listdto;
	}

}
