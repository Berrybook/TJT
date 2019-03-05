package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tjt.entity.City_Table;

public interface CityDAO extends JpaRepository<City_Table,String> {

	@Query("Select ct.cityname from City_Table ct")
	public List<String> allCity();
	
}
