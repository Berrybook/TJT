package com.tjt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.tjt.dao.Heirarchy_Module_DAO;
import com.tjt.dao.Module_Master_DAO;
import com.tjt.dao.Resource_Role_Access_DAO;
import com.tjt.dto.Module_Master_DTO;
import com.tjt.dto.Resource_Role_Access_DTO;
import com.tjt.entity.Module_Master;
import com.tjt.entity.Resource_Role_Access;

@Service
@Transactional
public class Resource_Role_Access_Service_Impl implements Resource_Role_Access_Service {

	@Autowired
	private Module_Master_DAO module_Master_DAO;
	
	@Autowired
	private Heirarchy_Module_DAO heirarchy_Module_DAO;
	
	@Autowired
	private Resource_Role_Access_DAO resource_Role_Access_DAO;
	
	
	@Override
	public List<Module_Master_DTO> AllModule() throws Exception {
		List<Module_Master> listModule=null;
		List<Module_Master_DTO> listModuleDto=null;
		listModuleDto =new ArrayList<Module_Master_DTO>();
		try{
		listModule=module_Master_DAO.findAll();
		
		for (Module_Master module_Master: listModule) {
			Module_Master_DTO module_Master_DTO=new Module_Master_DTO();
			BeanUtils.copyProperties(module_Master, module_Master_DTO);
			listModuleDto.add(module_Master_DTO);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listModuleDto;
	}

	@Override
	public List<String> allHierarchyModuleId() throws Exception {
		List<String> allModule=null;
		allModule=heirarchy_Module_DAO.allModuleId();
		return allModule;
	}

	@Override
	public List<String> allLevelByModuleId(String moduleId) throws Exception {
		List<String> allLevelByModuleId=null;
		allLevelByModuleId=heirarchy_Module_DAO.allLevelBYModuleId(moduleId);
		return allLevelByModuleId;
	}

	@Override
	public List<String> allRoleByModuleIdAndLevel(String hierarchy_Module_Id, String level) throws Exception {
		List<String> allRoleByModuleIdAndLevel=null;
		allRoleByModuleIdAndLevel=heirarchy_Module_DAO.allRoleBYModuleIdAndLevel(hierarchy_Module_Id, level);
		return allRoleByModuleIdAndLevel;
	}

	@Override
	public List<String> allLebelPathByLevel(String level) throws Exception {
		
		List<String> listLeble=null;
		Integer lebel=heirarchy_Module_DAO.alllevel_depthBYLevel(level);
		listLeble=heirarchy_Module_DAO.allLevelBYLevel(lebel);
		return listLeble;
	}

	@Override
	public List<String> allUserIdByRole(String role) throws Exception {
		List<String> listLeble=null;
		listLeble=heirarchy_Module_DAO.allUserIdByRole(role);
		return listLeble;
	}

	@Override
	public List<String> allAccessByROle(String hierarchy_Module, String level, String role) throws Exception {
		List<String> listAccess=null;
		listAccess=heirarchy_Module_DAO.allAccessByROle(hierarchy_Module, level, role);
		return listAccess;
	}

	@Override
	public String createRoleAccess(HttpServletRequest request, Resource_Role_Access_DTO roledto, BindingResult result,
			Map<String, Object> map) throws Exception {
		Resource_Role_Access rrcentity = new Resource_Role_Access();
		BeanUtils.copyProperties(roledto, rrcentity);
		resource_Role_Access_DAO.save(rrcentity);
		return null;
	}

	@Override
	public String createResourceRoleAccess(Resource_Role_Access_DTO dto) throws Exception {
		
		
		try{
		for(int i=0;i<dto.getAccess().length;i++){	
			Resource_Role_Access rrcentity = new Resource_Role_Access();
			BeanUtils.copyProperties(dto, rrcentity);
			rrcentity.setAccess(dto.getAccess()[i]);
		rrcentity=resource_Role_Access_DAO.save(rrcentity);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Resource_Role_Access_DTO> listResourceRoleAccess() throws Exception {
		List<Resource_Role_Access_DTO> listRoleAccess=null;
		listRoleAccess=new ArrayList<Resource_Role_Access_DTO>();
		List<Resource_Role_Access> listRoleAccessEntity=null;
		listRoleAccessEntity=resource_Role_Access_DAO.findAll();
		for (Resource_Role_Access resource_Role_Access : listRoleAccessEntity) {
			Resource_Role_Access_DTO Resource_Role_Access_DTO =new  Resource_Role_Access_DTO();
			BeanUtils.copyProperties(resource_Role_Access, Resource_Role_Access_DTO);
			Resource_Role_Access_DTO.setAccesses(resource_Role_Access.getAccess());
			listRoleAccess.add(Resource_Role_Access_DTO);
		}
		
		return listRoleAccess;
	}
	
	@Override
	public List<String> AllRoleByModule(String module)throws Exception{
		
		List<String> listRole=null;
		listRole=	module_Master_DAO.allRoleByModule(module);
		return listRole;
	}
	

}
