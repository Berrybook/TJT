package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.Module_Master_DTO;
import com.tjt.dto.RoleModuleMappingDTO;
import com.tjt.service.RoleModuleMappingService;

@Controller
public class RoleModuleMappingController {

	
	@Autowired RoleModuleMappingService mappingService;
	
	@RequestMapping(value="createrolmodulemappinglink",method=RequestMethod.GET)
	public String createroleaccess(HttpServletRequest request,Map<String,Object> map){

		List<RoleModuleMappingDTO> accessdto = null;
		
		try{
			accessdto = mappingService.listRoleModuleMapping();
			map.put("rolemodulemapping", accessdto);
		
		 return "roleModuleMapping";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
	}//end
	
	

	@RequestMapping(value="/createRoleModuleMapping",method=RequestMethod.POST)
	public String createRoleModuleMapping(@ModelAttribute RoleModuleMappingDTO dto,HttpServletRequest request,Map<String,Object> map) throws Exception{
		List<RoleModuleMappingDTO> accessdto = null;
		try {
			mappingService.createRoleModuleMapping(dto);
		
				accessdto = mappingService.listRoleModuleMapping();
				map.put("rolemodulemapping", accessdto);
		}
		catch(Exception e){
			
				request.setAttribute("MAPPING_FAILED","RoleModuleMapping Failed ");
				
				accessdto = mappingService.listRoleModuleMapping();
				map.put("rolemodulemapping", accessdto);
				return "roleModuleMapping";
		}
		request.setAttribute("MAPPING_FAILED","RoleModuleMapping  successfully Done ");
		return "roleModuleMapping";
		
		
	}
	
	@ModelAttribute("allModuleDropdown")
	public List<Module_Master_DTO> allModule(){
		List<Module_Master_DTO> listModule=null;
		
		System.out.println("fff");
		ResponseEntity<List<Module_Master_DTO>> listhh=null;
		try{
			listModule=mappingService.allModule();
			for (Module_Master_DTO module_Master_DTO : listModule) {
				System.out.println(module_Master_DTO.getModule_Id()+" HHH");
			}
			listhh=new ResponseEntity<>(listModule, HttpStatus.MULTI_STATUS);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listModule;
	}
	//all Role in dropdown
	
	
	@ModelAttribute("allRoleDropdown")
	public List<String> allRole(){
		List<String> listRole=null;
		
		System.out.println("fff");
		ResponseEntity<List<String>> listhh=null;
		try{
			listRole=mappingService.allRole();
			
			listhh=new ResponseEntity<>(listRole, HttpStatus.MULTI_STATUS);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listRole;
	}
	
	//shows all data in list
	@ResponseBody
	@RequestMapping(value="getList",method=RequestMethod.GET)
	public List<RoleModuleMappingDTO> showRoleModuleMapping()
	{
		List<RoleModuleMappingDTO> rmmDto = null;
		System.out.println("List RolemoduleMapping ");
		try{
			rmmDto = mappingService.listRoleModuleMapping();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rmmDto;
	}
}
