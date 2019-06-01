package com.tjt.service;

import java.util.List;

import com.tjt.dto.Module_Master_DTO;
import com.tjt.dto.RoleModuleMappingDTO;
import com.tjt.entity.Module_Master;


public interface RoleModuleMappingService {
	
public	String createRoleModuleMapping(RoleModuleMappingDTO dto) throws Exception;
public List<String> allRole()throws Exception;
public List<Module_Master_DTO> allModule() throws Exception;
public List<RoleModuleMappingDTO> listRoleModuleMapping()throws Exception;
}
