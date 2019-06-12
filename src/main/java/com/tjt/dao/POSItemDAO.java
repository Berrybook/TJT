package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tjt.entity.POS_Item;
import com.tjt.entity.PosItemCompositeKey;



@Repository
public interface POSItemDAO extends JpaRepository< POS_Item, PosItemCompositeKey> {

@Query("select p.pos from POS_Table p")
public List<String> listpos();

@Query("select ti.tyrepattern,tyresize from Tyre_Information ti")
public List<Object[]> listtyreid();

@Query("select p.quantity from POS_Item p where p.tyrepattern=:tyrepattern AND p.tyresize=:tyresize  and p.pos=:pos")
public Long featchQuantity(@Param("tyrepattern")String tyrepattern,@Param("tyresize")String tyresize,@Param("pos")String pos);

@Query("select count(*) from POS_Item p where p.tyrepattern=:tyrepattern AND p.tyresize=:tyresize  and p.pos=:pos")
public Integer checkTyre(@Param("tyrepattern")String tyrepattern,@Param("tyresize")String tyresize,@Param("pos")String pos);

@Query("select pi.tyrepattern,pi.tyresize,pi.quantity,pi.MRP,pi.salePrice from POS_Item pi where pi.pos in (select pt.pos from POS_Table pt where pt.city_table=(select ct.cityname from City_Table ct where ct.cityname=:cityname)) group by pi.tyrepattern,pi.tyresize,pi.quantity,pi.MRP,pi.salePrice")
public List<Object[]> allPosItemByCity(@Param("cityname")String cityname);

@Query("select pi.tyrepattern,pi.tyresize,pi.quantity,pi.MRP,pi.salePrice from POS_Item pi where pi.pos=:pos")
public List<Object[]> findAllByPos_table(@Param("pos")String pos);

@Query("select pi.pos from POS_Item pi where pi.pos in (select pt.pos from POS_Table pt where pt.city_table=(select ct.cityname from City_Table ct where ct.cityname=:cityname))")
public List<String> findAllByPOS(@Param("cityname")String cityname);

}
