package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.Module_Master_DAO;
import com.tjt.dao.Role_DAO;
import com.tjt.dao.Role_Module_Mapping_DAO;
import com.tjt.dto.Module_Master_DTO;
import com.tjt.dto.RoleModuleMappingDTO;
import com.tjt.entity.Module_Master;
import com.tjt.entity.Role_Module_Mapping;

@Service
public class RoleModuleMappingImpl implements RoleModuleMappingService {
	
	@Autowired Role_Module_Mapping_DAO rmmDAO;
	
	@Autowired Role_DAO roleDAO;
	
	@Autowired Module_Master_DAO moduleDAO;

	
//service for save role_module_mapping 
	@Override
	public String createRoleModuleMapping(RoleModuleMappingDTO dto) throws Exception {
		
		
		
		
		Role_Module_Mapping  role_module_entity =null;
		try {
	
		for(int i=0;i<dto.getRole().length;i++){
			
			role_module_entity = new Role_Module_Mapping();
			role_module_entity.setModule(dto.getModule());
			role_module_entity.setRole(dto.getRole()[i]);
			role_module_entity=rmmDAO.save(role_module_entity);
		}
	
		
		return "Mapping successfully Done";
		
	}
	catch (Exception e) {
		
		return "mapping failed";
	}	
	
	}
	
	
	//allrole in dropdown
	@Override
	public List<String> allRole() throws Exception {
		List<String> roleentity=null;
		String admn = "ADMIN";	
		
		try {
			roleentity=roleDAO.getRoles(admn);
			
			
		}
		catch (Exception e) {
			throw new Exception("database error");
		}
		return roleentity;
	}
	
	
//all module shown in dropdown
	@Override
	public List<Module_Master_DTO> allModule() throws Exception {
		List<Module_Master> module=null;
		List<Module_Master_DTO> moduleDto=null;
		moduleDto=new ArrayList<Module_Master_DTO>();
		 
		try {
			
			module=moduleDAO.findAll();
			
			for(Module_Master moduleMaster : module) {
				Module_Master_DTO moduleMasterDto= new Module_Master_DTO();
				BeanUtils.copyProperties(moduleMaster, moduleMasterDto);
			
				moduleDto.add(moduleMasterDto);
				
			}
		}
		catch (Exception e) {
			throw new Exception("database error");
		}
			
		return moduleDto;
	}

	
	//list  for role_module_mapping
	@Override
	public List<RoleModuleMappingDTO> listRoleModuleMapping() throws Exception {
		List<RoleModuleMappingDTO> listDto=null;
		List<Role_Module_Mapping> listEntity=null;
		listDto = new ArrayList<RoleModuleMappingDTO>();
		
		listEntity = rmmDAO.findAll();
		
		for(Role_Module_Mapping mapping_entity : listEntity) {
			
			RoleModuleMappingDTO rmmdto = new RoleModuleMappingDTO();
			BeanUtils.copyProperties(mapping_entity, rmmdto);
			rmmdto.setRoles(mapping_entity.getRole());
			listDto.add(rmmdto);
		}
		
		return listDto;   
	}

}
