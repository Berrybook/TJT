package com.tjt.service;

import java.util.List;

import com.tjt.dto.City_DTO;
import com.tjt.dto.WarehouseMasterDTO;

public interface WarehouseMasterService {
	public String CreateWarehouse(WarehouseMasterDTO dto) throws Exception;
	public List<WarehouseMasterDTO> listWarehouse() throws Exception;
	public List<City_DTO> listCity() throws Exception;

}
