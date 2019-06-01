package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.CityDAO;
import com.tjt.dao.WarehouseMasterDAO;
import com.tjt.dto.City_DTO;
import com.tjt.dto.WarehouseMasterDTO;
import com.tjt.entity.City_Table;
import com.tjt.entity.Warehouse_Master;

@Service
public class WarehouseMasterServiceImpl implements WarehouseMasterService {
	
	@Autowired WarehouseMasterDAO whDAO;
	@Autowired CityDAO cityDAO;

	@Override
	public String CreateWarehouse(WarehouseMasterDTO dto) throws Exception {
		Warehouse_Master whtable=null;
		City_Table citytable=null;
		
		whtable = new Warehouse_Master();
		citytable = new City_Table();
		
		citytable.setCityname(dto.getCityname());
		BeanUtils.copyProperties(dto, whtable);
	
		whtable= whDAO.save(whtable);
		
		return null;
	}

	@Override
	public List<WarehouseMasterDTO> listWarehouse() throws Exception {
		
		List<Warehouse_Master> whtablelist=null;
		List<WarehouseMasterDTO> whdtolist=null;
		
		whdtolist = new ArrayList<WarehouseMasterDTO>();
		whtablelist = whDAO.findAll();
		
		for(Warehouse_Master whEntity : whtablelist) {
			WarehouseMasterDTO whdto = new WarehouseMasterDTO();
			BeanUtils.copyProperties(whEntity, whdto);
			whdtolist.add(whdto);
		}
		return whdtolist;
		
	}

	@Override
	public List<City_DTO> listCity() throws Exception {
		
		List<City_Table> citytbl=null;
		List<City_DTO> citydto=null;
		citydto = new ArrayList<City_DTO>();
		citytbl = cityDAO.findAll();
		
		for(City_Table cityentity : citytbl) {
			City_DTO cdto = new City_DTO();
			BeanUtils.copyProperties(cityentity, cdto);
			citydto.add(cdto);
		}
			
		return citydto;
	
	}

}
