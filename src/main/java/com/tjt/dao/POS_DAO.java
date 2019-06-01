package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.POS_Table;


public interface POS_DAO extends JpaRepository<POS_Table ,String> {
		@Query("select count(*) from POS_Table p where p.pos=:pos and p.password=:password")
		public int login(@Param("pos") String pos, @Param("password") String password);
		
		@Query("select t.gstno,t.gstaddres from City_Table t where t.cityname=:city")
		public List<Object[]> featchGstNoAndGstAddress(@Param("city")String city);
		
		@Query("select ct.cityname from City_Table ct")
		public List<Object[]> listCity();
		
		@Query("select count(*) from POS_Table udt where udt.pos=:pos")
		public Integer checkPOS(@Param("pos")String pos);
		
		@Query("select pos from POS_Table where cityname=:cityname")
		public List<String> findPOSByCity(@Param("cityname") String cityname);
		
		
}
