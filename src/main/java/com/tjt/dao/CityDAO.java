package com.tjt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjt.entity.City_Table;

public interface CityDAO extends JpaRepository<City_Table,String> {

	
}
