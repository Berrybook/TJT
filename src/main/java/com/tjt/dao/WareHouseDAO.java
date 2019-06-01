package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.dto.Warehouse_DTO;
import com.tjt.entity.Module_Master;
import com.tjt.entity.Warehouse_User_Mapping;


public interface WareHouseDAO extends JpaRepository<Warehouse_User_Mapping, String> {

	void save(Warehouse_DTO warehouse);
	
	@Query("select md.module_Id from Module_Master md")
	public List<Module_Master>showModule();
	@Query("select lb.level from Heirarchy_Module_Master lb where lb.module_Id=:module_Id ")
	public List<String[]>showLable(  @Param("module_Id")String module_Id);
}
