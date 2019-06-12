package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.Role_DAO;
import com.tjt.dto.RoleDTO;
import com.tjt.entity.Role_Table;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private Role_DAO roledao;
	
	@Override
	public List<String> roles() throws Exception {
		List<Role_Table> listrole=null;
		List<String> listroledto=null;
		listroledto=new ArrayList<String>();
		listrole=roledao.findAll();
		for (Role_Table role : listrole) {
			String role1=null;
			role1=role.getRole();
			
			if(role1=="ADMIN"){
			
			}
			else{
				listroledto.add(role1);
			}
			
		}
		
		return listroledto;
	}
	@Override
	public List<String> role()throws Exception{
		List<String> listrole=null;
		String admin="ADMIN";
		listrole=roledao.getRoles(admin);
	
		return listrole;
	}
	
	@Override
	public void addrole(RoleDTO roledto) {
		Role_Table roleentity = new Role_Table();
		BeanUtils.copyProperties(roledto, roleentity);
		roleentity.setRole(roleentity.getRole().toUpperCase());
		roledao.save(roleentity);
	}
	
	@Override
	public List<RoleDTO> listOfrole() {
		List<Role_Table> roleentity = null;
		List<RoleDTO> roledto = null;
		
		roleentity = roledao.findAll();
		roledto = new ArrayList<RoleDTO>();
		
		for(Role_Table roleetempntity : roleentity){
			RoleDTO tyreInfodto  = new RoleDTO();
			BeanUtils.copyProperties(roleetempntity, tyreInfodto);
			roledto.add(tyreInfodto);
			
			
		}
		// TODO Auto-generated method stub
		return roledto;
	}

	@Override
	public void updaterole(RoleDTO roledto) {
		Role_Table roleentity = new Role_Table();
		BeanUtils.copyProperties(roledto, roleentity);
		roledao.save(roleentity);
	}
	
	@Override
	public void deleterole(RoleDTO roledto) {
		Role_Table roleentity = new Role_Table();
		BeanUtils.copyProperties(roledto, roleentity);
		roledao.delete(roleentity);
	}


}
