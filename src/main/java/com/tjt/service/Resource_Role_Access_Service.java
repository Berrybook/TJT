package com.tjt.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tjt.dto.Module_Master_DTO;
import com.tjt.dto.Resource_Role_Access_DTO;



public interface Resource_Role_Access_Service {

	public String createRoleAccess(HttpServletRequest request, @ModelAttribute Resource_Role_Access_DTO roledto, BindingResult result,Map<String,Object> map) throws Exception;
	 
	
	public String createResourceRoleAccess(Resource_Role_Access_DTO dto) throws Exception;
	
	public List<Resource_Role_Access_DTO> listResourceRoleAccess() throws Exception;
	
	
	public List<Module_Master_DTO> AllModule()throws Exception;
	
	public List<String> allHierarchyModuleId()throws Exception;
	
	public List<String> allLevelByModuleId(String moduleId)throws Exception;
	
	public List<String> allRoleByModuleIdAndLevel(String hierarchy_Module_Id,String level)throws Exception;
	
	public List<String> allLebelPathByLevel(String level)throws Exception;
	
	public List<String> allUserIdByRole(String role)throws Exception;
	
	public List<String> allAccessByROle( String hierarchy_Module , String level,String role)throws Exception;
	
	public List<String> AllRoleByModule(String module) throws Exception;
}
