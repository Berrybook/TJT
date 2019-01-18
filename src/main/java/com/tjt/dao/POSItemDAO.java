package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.POS_Item;
import com.tjt.entity.POS_Table;
import com.tjt.entity.PosItemCompositeKey;
import com.tjt.entity.Tyre_Information;


public interface POSItemDAO extends JpaRepository< POS_Item, PosItemCompositeKey> {
	
	
@Query("select p.pos from POS_Table p")
public List<String> listpos();

@Query("select ti.tyrepattern,tyresize from Tyre_Information ti")
public List<Object[]> listtyreid();

/*@Query("select p.pos_table from POS_Item p where p.tyre_id=:tyreinfo")
public List<POS_Table> listposname(@Param("tyreinfo")Tyre_Information tyreinfo);


@Query("select pi.tyre_id,pi.tyrepattern,pi.tyresize from POS_Item pi")
public List<Object[]>  listpositem();*/


@Query("select p.quantity from POS_Item p where p.tyre=:tyreinfo and p.pos_table=:pos")
public Long featchQuantity(@Param("tyreinfo")Tyre_Information tyre,@Param("pos")POS_Table pos);

@Query("select count(*) from POS_Item p where p.tyre=:tyreinfo and p.pos_table=:pos")
public Integer checkTyre(@Param("tyreinfo")Tyre_Information tyre,@Param("pos")POS_Table pos);




}
