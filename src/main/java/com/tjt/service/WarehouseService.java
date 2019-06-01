package com.tjt.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.Heirarchy_Module_DAO;
import com.tjt.dao.Module_Master_DAO;
import com.tjt.dao.WareHouseDAO;
import com.tjt.dto.Warehouse_DTO;
import com.tjt.entity.Warehouse_User_Mapping;


@Service
public class WarehouseService {
	@Autowired
	private WareHouseDAO warehouseDAO;
	
	@Autowired
	private Module_Master_DAO module_MasterDAO;
	@Autowired
	private Heirarchy_Module_DAO  hierarchyModule;
	//add warehouse

	public String createWarehouse(Warehouse_DTO warehousedto) throws Exception {
		Warehouse_User_Mapping whentity=new Warehouse_User_Mapping();
		Warehouse_User_Mapping whentitys=null;
		 BeanUtils.copyProperties(warehousedto, whentity);
		 try{
		 whentitys= warehouseDAO.save(whentity);
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 System.out.println("llll"+whentitys.getModule_Id());
			return "hh";
		
		}
	// list warehouse
	public List<Warehouse_DTO> listwarehouse() throws Exception {
		List<Warehouse_User_Mapping> whentity = null;
		List<Warehouse_DTO> whdto = null;
	
		whentity = warehouseDAO.findAll();
		whdto = new ArrayList<Warehouse_DTO>();
		
		
		for(Warehouse_User_Mapping cityloop : whentity){
			Warehouse_DTO cityinfo  = new Warehouse_DTO();
		
			BeanUtils.copyProperties(cityloop, cityinfo);
			whdto.add(cityinfo);
		
	}
		return whdto;
	}
	//module in dropdown
	public List<String> showModule(){
		
		List<String> modulelist = null;
		
				modulelist = module_MasterDAO.findID();
				
				return modulelist;
	
		}
	public String updateWarehouse(Warehouse_User_Mapping warehouseRegistration, String id) {
		warehouseDAO.save(warehouseRegistration);
		return "warehouseRegister";
		
	}
	public String deleteWarehouse( String id) {
		warehouseDAO.deleteById(id);
		return "warehouseRegister";
	}
	// lable in dropdown according to moduleid
	//public List<String> showLable(String moduleID) {
	//	List<String> lablelist=null;
		//lablelist=hierarchyModule.showLable(moduleID);
		//return lablelist;
	//}

		public List<String> allHierarchyModuleId() throws Exception {
			List<String> allModule=null;
			allModule=hierarchyModule.allModuleId();
			return allModule;
		}
	
	
	
//level according to moduleid
		public List<String> allLevelByModuleId(String moduleId) throws Exception {
			List<String> allLevelByModuleId=null;
			allLevelByModuleId=hierarchyModule.allLevelBYModuleId(moduleId);
			return allLevelByModuleId;
		}
		
		
	
	//roll in dropdown according to level and hierarchy_Module
	
		public List<String> allRoleByModuleIdAndLevel(String hierarchy_Module_Id, String level) throws Exception {
			List<String> allRoleByModuleIdAndLevel=null;
			allRoleByModuleIdAndLevel=hierarchyModule.allRoleBYModuleIdAndLevel(hierarchy_Module_Id, level);
			return allRoleByModuleIdAndLevel;
		}
		
	
		public List<String> allLebelPathByLevel(String level) throws Exception {
			
			List<String> listLeble=null;
			Integer lebel=hierarchyModule.alllevel_depthBYLevel(level);
			listLeble=hierarchyModule.allLevelBYLevel(lebel);
			return listLeble;
		}
	

		public List<String> allUserIdByRole(String role) throws Exception {
			List<String> listLeble=null;
			listLeble=hierarchyModule.allUserIdByRole(role);
			return listLeble;
		}
		
	
		public List<String> allAccessByROle(String hierarchy_Module, String level, String role) throws Exception {
			List<String> listAccess=null;
			listAccess=hierarchyModule.allAccessByROle(hierarchy_Module, level, role);
			return listAccess;
		
	}
		public List<Warehouse_DTO> listcity() {
			List<Warehouse_User_Mapping> whentity = null;
			List<Warehouse_DTO> whdto = null;
		
			whentity = warehouseDAO.findAll();
			whdto = new ArrayList<Warehouse_DTO>();
			
			
			for(Warehouse_User_Mapping cityloop : whentity){
				Warehouse_DTO cityinfo  = new Warehouse_DTO();
			
				BeanUtils.copyProperties(cityloop, cityinfo);
				whdto.add(cityinfo);
			
		}
			return whdto;
		
	
		}
		
	}




		
	

