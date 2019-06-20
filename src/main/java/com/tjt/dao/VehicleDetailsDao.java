package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.dto.VehicleDetailsDto;
import com.tjt.entity.Vehicle_Details;

public interface VehicleDetailsDao extends JpaRepository<Vehicle_Details, String>{

	@Query("select vehicleMake,rearSize,frontSize from Vehicle_Details where vehicleBrand=:vehicleBrand")
	public List<Object[]> allTyreDetailsByBrand(@Param("vehicleBrand") String vehicleBrand);
}
