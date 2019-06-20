package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.TrackingNewEntity;

public interface TrackSheetModiDao extends JpaRepository<TrackingNewEntity, Long>{
	
	@Query("select salesman,date,pos,sum(customerapp),sum(customerinq),sum(tyresale) from TrackingNewEntity where date=:date AND pos=:pos group by salesman,pos,date")
	List<Object[]> recordbydate(@Param("date") String date,@Param("pos") String pos);
	
	//all by pos
	@Query("select salesman,date,pos,sum(customerapp),sum(customerinq),sum(tyresale) from TrackingNewEntity where pos=:pos group by salesman,pos,date")
	List<Object[]> allrecordbypos(@Param("pos") String pos);
	
	//by date all pos
	@Query("select salesman,date,pos,sum(customerapp),sum(customerinq),sum(tyresale) from TrackingNewEntity where date=:date group by salesman,pos,date")
	List<Object[]> allrecordbydate(@Param("date") String date);

	//by all pos
	@Query("select salesman,date,pos,sum(customerapp),sum(customerinq),sum(tyresale) from TrackingNewEntity group by salesman,pos,date")
	List<Object[]> allrecordbydate();
	
	//find by all
		@Query("select salesman,date,pos,timeslot,customerapp,customerinq,tyresale,comment from TrackingNewEntity where date=:date AND salesman=:salesman AND pos=:pos ")
		List<Object[]> recordbydatesalesman(@Param("date") String date,@Param("pos") String pos,@Param("salesman") String salesman);
		
		//find by date pos
		@Query("select salesman,date,pos,timeslot,customerapp,customerinq,tyresale,comment from TrackingNewEntity where date=:date AND pos=:pos")
		List<Object[]> recordsalesmandate(@Param("date") String date,@Param("pos") String pos);

		//find by pos
		@Query("select salesman,date,pos,timeslot,customerapp,customerinq,tyresale,comment from TrackingNewEntity where pos=:pos ")
		List<Object[]> recordbypos(@Param("pos") String pos);
		
		//find by salesman
	      @Query("select salesman,date,pos,timeslot,customerapp,customerinq,tyresale,comment from TrackingNewEntity where pos=:pos and salesman=:salesman ")
		List<Object[]> recordbysalesman(@Param("pos") String pos,@Param("salesman") String salesman);
		
		
		@Query("select salesman,date,pos,timeslot,customerapp,customerinq,tyresale,comment from TrackingNewEntity")
		List<Object[]> allrecord();
}
