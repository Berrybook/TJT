package com.tjt.service;

import java.util.List;

import com.tjt.dto.City_DTO;

public interface CityService {
	
 public String createCity(City_DTO dto) throws Exception;
 public List<City_DTO>  listcity() throws Exception;
 public void deleteCity(String cityname) throws Exception;

}
