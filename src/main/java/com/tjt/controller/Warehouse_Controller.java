package com.tjt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tjt.dto.WarehouseMasterDTO;
import com.tjt.dto.Warehouse_DTO;
import com.tjt.entity.Warehouse_User_Mapping;
import com.tjt.service.Resource_Role_Access_Service;
import com.tjt.service.WarehouseMasterService;
import com.tjt.service.WarehouseService;


@Controller
public class Warehouse_Controller {
	@Autowired
	private WarehouseService warehouseService;
	
	@Autowired
	private WarehouseMasterService warehouseMasterService;
	
	
	@Autowired
	private Resource_Role_Access_Service resource_Role_Access_Service;


	@RequestMapping(value="warehouseRegistration",method=RequestMethod.GET)
	public String getWarehouse(Map<String,Object> map) throws Exception {
		List<Warehouse_DTO> whdto = null;
		whdto=warehouseService.listwarehouse();
		map.put("allWarehouse", whdto);
		return "warehouse_registration";
	}
	
	@RequestMapping(value="createwarehouse",method=RequestMethod.GET)
	public String createWarehouse(HttpServletRequest request,Map<String,Object> map){
		HttpSession session=null;
		List<Warehouse_DTO> whdto = null;
		//create Session object
		session=request.getSession(false);
		String admin=(String) session.getAttribute("admin");
		try{
			whdto = warehouseService.listwarehouse();
			
			
			map.put("allwarehose", whdto);
		//test the session is equals to admin or null if admin null then it goes to catch block
		if(admin.equals("admin")){
}
		 return "warehouse_registration";
		}
		catch(Exception e){
			request.setAttribute("SessionTimeOut", "Should enter Username and Password");
			return "login";
		}
	}//end

	
	// warehouse registration
	@RequestMapping(value="createwarehouse",method=RequestMethod.POST)
	public String createWarehouse(HttpServletRequest request, @ModelAttribute Warehouse_DTO warehousedto, BindingResult result,Map<String,Object> map) throws Exception{
		List<Warehouse_DTO> whdto= null;
		try{
			
		warehouseService.createWarehouse(warehousedto);
		whdto=warehouseService.listwarehouse();
		map.put("allWarehouse", whdto);
		}
		catch(Exception e){
			
			request.setAttribute("warehouse_registration"," Warehouse Registration successfull" );	
			whdto=warehouseService.listwarehouse();
			map.put("allWarehouse", whdto);
			return "warehouse_registration";
		}
		request.setAttribute("warehouse_registration", " Warehouse Registration unsuccessfull");
		return "warehouse_registration";
				}
	@ModelAttribute("list of warehouse")
	public List<Warehouse_DTO> listcityinfo(){
		List<Warehouse_DTO> whdto = null;
	
		try{
			whdto = warehouseService.listcity();
			
		}
		catch(Exception e){
			
		}
		return whdto;
		
	}
	
	@ModelAttribute("allHierarchyModule")
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
	
	//for warehouse update
	@RequestMapping(value="warehouseUpdate/{id}",method=RequestMethod.PUT)
	public String updatrWarehouse(@RequestBody Warehouse_User_Mapping warehouseRegistration,@PathVariable String id){
		warehouseService.updateWarehouse(warehouseRegistration,id);
		return id;
		
	}
	//for deleting
	@RequestMapping(value="deleteWarehouse/{id}",method=RequestMethod.DELETE)
	public String deleteWarehouse(@PathVariable String id){
		warehouseService.deleteWarehouse(id);
		return id;
		
	}
		//for lable in dropdown
	//@GetMapping("lableByModuleID/{module_Id}")
	//@ResponseBody
			
	//public List<Integer>showLable( HttpServletRequest request, @PathVariable("module_Id") String module_Id){
		//List<Integer>listdto=null;
		//List<Hierarchy_Module> lablelist=new ArrayList<>();
		//try{
			
		//listdto=warehouseService.showLable( module_Id);
		//for (Integer  lable : listdto) {
			//Hierarchy_Module hierarchy=new Hierarchy_Module();
			//hierarchy.setLable(lable);
			//lablelist.add(hierarchy);
		//}
		//}
		//catch(Exception e){
			//e.printStackTrace();
		//}
		//request.setAttribute("lable", "lable according to moduleId");
		
	//	return listdto;
		
	//
	//for allHierarchyModule in dropdown



	/*@GetMapping("/allLevelByModuleId/{module_Id}")
	@ResponseBody
	public List<String> allLevelByModuleId(@PathVariable("module_Id") String module_Id){
		List<String> listModule=null;
		
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=warehouseService.allLevelByModuleId(module_Id);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listModule;
	}
	//all role by moduleid and level
	@GetMapping("/allRoleByModuleIdAndLevelInWh/{module_Id},{level}")
	@ResponseBody
	public ResponseEntity<List<String>> allRoleByModuleIdAndLevel(@PathVariable("module_Id") String hierarchy_Module_Id,@PathVariable("level") String level){
		List<String> listModule=null;
		ResponseEntity<List<String>> listhh=null;
		try{
			System.out.println("dddd");
			listModule=warehouseService.allRoleByModuleIdAndLevel(hierarchy_Module_Id, level);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
			System.out.println("dddd");
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	

	
	@GetMapping("/allLevelByLeve/{level}")
	public ResponseEntity<List<String>> allLevelByLevel_Path(@PathVariable("level") String level){
		List<String> listModule=null;
		
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=warehouseService.allLebelPathByLevel(level);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}
	
	@GetMapping("/allAccessByy/{hierarchy_Module},{level},{role}")
	public ResponseEntity<List<String>> allUserIdByRole(@PathVariable("hierarchy_Module") String hierarchy_Module,@PathVariable("level") String level,@PathVariable("role") String role){
		List<String> listModule=null;
		
		ResponseEntity<List<String>> listhh=null;
		try{
			listModule=warehouseService.allAccessByROle(hierarchy_Module, level, role);
			listhh=new ResponseEntity<>(listModule, HttpStatus.OK);
		}
			catch(Exception e){
				e.printStackTrace();
			}

		return listhh;
	}*/
	
	@ModelAttribute("allWareHouseId")
	public List<WarehouseMasterDTO> allWareHouseId(){
		List<WarehouseMasterDTO> allwareHouse=null;
		try{
		 allwareHouse=warehouseMasterService.listWarehouse();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return allwareHouse;
	}
}

	
	


