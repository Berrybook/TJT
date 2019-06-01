package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Module_Master;

public interface Module_Master_DAO extends JpaRepository<Module_Master, String> {

	@Query("select m.module_Id  from Module_Master m")
	public List<String> findID();
	@Query("select m.role  from Role_Module_Mapping m where m.module=:module")
	public List<String> allRoleByModule(@Param("module") String module);
	
}
