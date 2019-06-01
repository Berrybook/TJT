package com.tjt.service;

import java.util.List;

import com.tjt.dto.Dealer_Pojo;
import com.tjt.entity.User_Details_Table;

public interface Dealer_Service {
	public String create_Dealer(Dealer_Pojo dealer_Pojo)throws Exception;
	
	public List<Dealer_Pojo> allDealer()throws Exception;
	public int authenticate(String dealer_Mail_Id,String password)throws Exception;

	public List<User_Details_Table> allChannelExecutive()throws Exception;

	List<Dealer_Pojo> allDealerByChannelExecutive(String channelExecutive) throws Exception;

	
}
