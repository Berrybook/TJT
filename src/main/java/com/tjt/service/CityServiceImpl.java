package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.CityDAO;
import com.tjt.dto.City_DTO;

import com.tjt.entity.City_Table;


@Service
public class CityServiceImpl implements CityService {
	
	@Autowired CityDAO citydao;
//Add city
	@Override
	public String createCity(City_DTO dto) throws Exception {
	 City_Table cityentity=new City_Table();
	 String cityname=dto.getCityname().toUpperCase();
	 BeanUtils.copyProperties(dto, cityentity);
	 cityentity.setCityname(cityname);
	 citydao.save(cityentity);
		return null;
	}
	//list city
	@Override
	public List<City_DTO> listcity() throws Exception {
		List<City_Table> cityentity = null;
		List<City_DTO> citydto = null;
	
		cityentity = citydao.findAll();
		citydto = new ArrayList<City_DTO>();
		
		
		for(City_Table cityloop : cityentity){
			City_DTO cityinfo  = new City_DTO();
		
			BeanUtils.copyProperties(cityloop, cityinfo);
			citydto.add(cityinfo);
		
	}
		return citydto;
	}
	
	//Delete the city
	@Override
	public void deleteCity(String cityname) throws Exception {
		
		
		citydao.deleteById(cityname);
		
	}
	
}
