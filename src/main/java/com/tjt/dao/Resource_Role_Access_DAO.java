package com.tjt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Resource_Role_Access;

public interface Resource_Role_Access_DAO extends JpaRepository<Resource_Role_Access, Long> {

	
	@Query("select count(*) from Resource_Role_Access hm where hm.module_Id =:hierarchy_Module and hm.level=:level and hm.role=:role and hm.access=:access")
	public Integer allAccessByROle(@Param("hierarchy_Module") String hierarchy_Module ,@Param("level") String level,@Param("role") String role ,@Param("access")String access);
	
	@Query("select hm.level from Warehouse_User_Mapping hm where hm.module_Id =:hierarchy_Module and hm.warehouse_Id=:warehouse_Id and hm.role=:role ")
	public String levelByROleAndModuleAndModuleId(@Param("hierarchy_Module") String hierarchy_Module ,@Param("warehouse_Id") String userId,@Param("role") String role );
	
	
	@Query("select hm.level from Warehouse_User_Mapping hm where hm.module_Id =:hierarchy_Module and hm.userid=:userid and hm.role=:role ")
	public String levelByROleAndModuleAndUserId(@Param("hierarchy_Module") String hierarchy_Module ,@Param("userid") String userId,@Param("role") String role );
}
