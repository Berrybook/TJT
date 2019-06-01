
package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjt.dto.Module_Master_DTO;
import com.tjt.dto.Resource_Role_Access_DTO;
import com.tjt.service.Request_Order_Service_Impl;
import com.tjt.service.Resource_Role_Access_Service;

@Controller
public class Resource_Role_Access_Controller {
	
	@Autowired
	private Resource_Role_Access_Service resource_Role_Access_Service;
	
	@Autowired
	private Request_Order_Service_Impl request_Order_Service_Impl;
	
	@GetMapping("/resourceAccess")
	public String resourceAccess(){
		
		return "Resource_Access";
	}
	
	@RequestMapping(value="createroleaccess",method=RequestMethod.GET)
	public String createroleaccess(HttpServletRequest request,Map<String,Object> map){
		
		List<Resource_Role_Access_DTO> accessdto = null;
		
		try{
			accessdto = resource_Role_Access_Service.listResourceRoleAccess();
			map.put("allroleAcces", accessdto);
		//test the session is equals to admin or null if admin null then it goes to catch block
	
		 return "resourceRoleAccess";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
	}//end
	
	
	//to save Resource Role Access details
	
		@RequestMapping(value="createroleaccess",method=RequestMethod.POST)
		public String createRoleAccess(HttpServletRequest request, @ModelAttribute Resource_Role_Access_DTO roledto, BindingResult result,Map<String,Object> map) throws Exception{
			List<Resource_Role_Access_DTO> radto= null;
			try{
				
				resource_Role_Access_Service.createResourceRoleAccess(roledto);
				radto=resource_Role_Access_Service.listResourceRoleAccess();
			map.put("allroleAcces", radto);
			}
			catch(Exception e){
				
				request.setAttribute("resourceRoleAccess"," rolerEsource Registration successfull" );	
				radto=resource_Role_Access_Service.listResourceRoleAccess();
				map.put("allroleAcces", radto);
				return "resourceRoleAccess";
			}
			request.setAttribute("resourceRoleAccess", " rolerEsource Registration unsuccessfull");
			return "resourceRoleAccess";
		}
	
	@GetMapping("/allModule")
	public ResponseEntity<List<Module_Master_DTO>> allModule(){
		List<Module_Master_DTO> listModule=null;
		
		ResponseEntity<List<Module_Master_DTO>> listhh=null;
		try{
			listModule=resource_Role_Access_Service.AllModule();
			listhh=new ResponseEntity<>(listModule, HttpStatus.MULTI_STATUS);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	
	
	@ModelAttribute("allHierarchyModules")
	public List<String> allHierarchyModule(){
		List<String> listModule=null;
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=resource_Role_Access_Service.allHierarchyModuleId();
		
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listModule;
	}
	
	
	@GetMapping("/allLevelByModuleId/{moduleId}")
	@ResponseBody
	public ResponseEntity<List<String>> allLevelByModuleId(@PathVariable("moduleId") String moduleId){
		List<String> listModule=null;
		
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=resource_Role_Access_Service.allLevelByModuleId(moduleId);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	
	
	@GetMapping("/allRoleByModuleIdAndLevel/{moduleId},{level}")
	@ResponseBody
	public ResponseEntity<List<String>> allRoleByModuleIdAndLevel(@PathVariable("moduleId") String hierarchy_Module_Id,@PathVariable("level") String level){
		List<String> listModule=null;
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=resource_Role_Access_Service.allRoleByModuleIdAndLevel(hierarchy_Module_Id, level);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	
	@GetMapping("/allLevelByLevelPath/{level}")
	@ResponseBody
	public ResponseEntity<List<String>> allLevelByLevel_Path(@PathVariable("level") String level){
		List<String> listModule=null;
		
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=resource_Role_Access_Service.allLebelPathByLevel(level);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	
	@GetMapping("/allUserIdByRole/{role}")
	@ResponseBody
	public ResponseEntity<List<String>> allUserIdByRole(@PathVariable("role") String role){
		List<String> listModule=null;
		
		ResponseEntity<List<String>> listhh=null;
		try{
			
			listModule=resource_Role_Access_Service.allUserIdByRole(role);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	@GetMapping("/allAccessBy/{hierarchy_Module},{level},{role}")
	@ResponseBody
	public ResponseEntity<List<String>> allUserIdByRole(@PathVariable("hierarchy_Module") String hierarchy_Module,@PathVariable("level") String level,@PathVariable("role") String role){
		List<String> listModule=null;
		
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=resource_Role_Access_Service.allAccessByROle(hierarchy_Module, level, role);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	
	
	@GetMapping("/allRoleByModule/{module}")
	@ResponseBody
	public ResponseEntity<List<String>> allRoleByModule(@PathVariable("module") String module){
		List<String> listModule=null;
		
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=resource_Role_Access_Service.AllRoleByModule(module);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	
	
	/*@GetMapping("requestOrder")
	public String validateRequest(HttpServletRequest request,@RequestParam String access){
		String moduleId="WareHouse",userId="hyd001",role="POS";
		String validate=request_Order_Service_Impl.validationRequest(moduleId, userId, role, access);
		System.out.println(validate);
		if(validate=="validate"){
			return "order_create";
		}
		request.setAttribute("invalide", "Create not access");
		return "invoicegeneration2";
	}
	
	@GetMapping("viewOrder")
	public String validateViewOrder(HttpServletRequest request,@RequestParam String access){
		String moduleId="WareHouse";
		HttpSession session=null;
		session=request.getSession(false);
		String roles=(String) session.getAttribute("role");
	
		String userId=(String) session.getAttribute("pos");
		String validate=request_Order_Service_Impl.validationRequest(moduleId, userId, roles, access);
		
		if(validate=="validate"){
			return "view_order";
		}
		
		if(roles.equals("CityManager")){
		request.setAttribute("invalide", "Create not access");
		return "city_manager";
		}
		if(roles.equals("POS")){
			
			request.setAttribute("invalide", "Create not access");
			return "welcomeTjTyre";
		}
		if(roles.equals("POSManager")){
			request.setAttribute("invalide", "Create not access");
			return "pos_manager";
		}
		else{
			request.setAttribute("invalide", "Create not access");
			return "factory_manager";
		}
		
	}*/
}
