package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjt.entity.User_POS_Mapping;

public interface UserPOSMappingDAO extends JpaRepository<User_POS_Mapping, String> {

/*	@Query("select userid,pos from User_POS_Mapping")
	public List<User_Pos_Pojo> findAllMappings();*/
}
