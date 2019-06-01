package com.tjt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tjt.entity.Dealer_Master;

public interface Dealer_DAO extends JpaRepository<Dealer_Master, String> {

	@Query("select count(*) from Dealer_Master d where d.dealer_Mail_Id=:dealer_Mail_Id and d.password=:password")
	public int login(@Param("dealer_Mail_Id") String dealer_Mail_Id, @Param("password") String password);
	
	@Query("select d.userid,d.userName from User_Details_Table d where d.role='CHANNELEXECUTIVE'")
	public List<Object[]> allChannelExecutive();
	
	@Query("select d.dealer_Mail_Id,d.dealer_Name from Dealer_Master d where d.channelExecutive=:channelExecutive")
	public List<Object[]> allDealerByChannelExecutive(@Param("channelExecutive") String channelExecutive);

}
