package com.tjt.service;

import java.util.List;

import com.tjt.dto.RoleDTO;

public interface RoleService {

	public List<String> role()throws Exception;
	
	public List<String> roles() throws Exception;
	
	public void addrole(RoleDTO roledto);

	public List<RoleDTO> listOfrole();

	public void updaterole(RoleDTO roledto);

	public void deleterole(RoleDTO roledto);

	
}
