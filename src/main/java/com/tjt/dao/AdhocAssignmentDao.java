package com.tjt.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Adhoc_Assignment;

public interface AdhocAssignmentDao extends JpaRepository<Adhoc_Assignment, String> {
	@Query("select a.userid,a.username,a.startDate,a.endDate from Adhoc_Assignment a where a.adhocPos=:pos AND a.startDate<=:currentdate AND a.endDate>=:currentdate")
	public List<Object[]> allAssignedSalesman(@Param("pos") String pos,@Param("currentdate") Date currentdate); 

}
