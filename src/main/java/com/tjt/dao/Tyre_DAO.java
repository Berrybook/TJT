package com.tjt.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.TyreCompositeKey;
import com.tjt.entity.Tyre_Information;

public interface Tyre_DAO extends JpaRepository<Tyre_Information,TyreCompositeKey> {
	@Query("select count(*) from Tyre_Information it where it.tyrepattern=:tyrepattren and it.tyresize=:tyresize")
	public Integer checkTyre(@Param("tyrepattren")String tyrepattren,@Param("tyresize")String tyresize);
	
}
