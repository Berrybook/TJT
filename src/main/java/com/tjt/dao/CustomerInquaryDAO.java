package com.tjt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.tjt.entity.CustomerForm;
import com.tjt.entity.POS_Table;

public interface CustomerInquaryDAO extends JpaRepository<CustomerForm, String>{

	
	
	@Query("select bf.customerName,bf.phoneNumber,bf.vehicle,bf.vehicleModel,bf.tyreSize,bf.meterReading,bf.tentadate,bf.comments,bf.dateofinqu,bf.time,bf.pos,bf.salesman from CustomerForm bf where bf.tentadate between :datea and :dateb")
	public List<Object[]> finallbydate(@Param("datea") String datea,@Param("dateb") String dateb);

	@Query("select ut.userid from User_Details_Table ut where ut.pos_table=:pos AND ut.role='SALESMAN'")
	public List<Object> findsalesman(@Param("pos") POS_Table pos);

}
