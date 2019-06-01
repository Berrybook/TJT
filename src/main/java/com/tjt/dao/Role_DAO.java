package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Role_Table;

public interface Role_DAO extends JpaRepository<Role_Table,String> {
	
	@Query("select t.role from Role_Table t where t.role!=:admin")
	public List<String> getRoles(@Param("admin")String admin);
	
	@Query("select t.role from Role_Table t where t.role in(:admin,:pos,:cityManager)")
	public List<String> GetRoleByLogIn(@Param("admin")String admin,@Param("pos")String pos,@Param("cityManager")String cityManager);

}
