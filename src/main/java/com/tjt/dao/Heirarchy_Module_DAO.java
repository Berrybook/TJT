package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Heirarchy_Module_Master;

public interface Heirarchy_Module_DAO extends JpaRepository<Heirarchy_Module_Master, Long> {

	@Query("select hm.module_Id from Heirarchy_Module_Master hm group by hm.module_Id")
	public List<String> allModuleId();
	
	@Query("select hm.level from Heirarchy_Module_Master hm where hm.module_Id=:Module_Id")
	public List<String> allLevelBYModuleId(@Param("Module_Id") String Module_Id );
	
	@Query("select rrc.role from Resource_Role_Access rrc   where rrc.module_Id=:hierarchy_Module  and rrc.level=:level GROUP BY rrc.role")
	public List<String> allRoleBYModuleIdAndLevel(@Param("hierarchy_Module") String hierarchy_Module ,@Param("level") String level );
	
	@Query("select hm.level_depth from Heirarchy_Module_Master hm where hm.level=:level")
	public Integer alllevel_depthBYLevel(@Param("level") String level );
	
	@Query("select hm.level from Heirarchy_Module_Master hm where hm.level_depth >:level_depth")
	public List<String> allLevelBYLevel(@Param("level_depth") Integer level_depth );
	
	@Query("select urm.userid from User_Role_Mapping urm where urm.role=:role")
	public List<String> allUserIdByRole(@Param("role") String role  );
	
	@Query("select hm.access from Resource_Role_Access hm where hm.module_Id =:hierarchy_Module and hm.level=:level and hm.role=:role ")
	public List<String> allAccessByROle(@Param("hierarchy_Module") String hierarchy_Module ,@Param("level") String level,@Param("role") String role );
	
	
}
