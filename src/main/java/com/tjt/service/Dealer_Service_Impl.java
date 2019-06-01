package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tjt.dao.Dealer_DAO;
import com.tjt.dto.Dealer_Pojo;
import com.tjt.entity.Dealer_Master;
import com.tjt.entity.User_Details_Table;

@Service
@Transactional
public class Dealer_Service_Impl implements Dealer_Service {

	@Autowired
	private Dealer_DAO dealer_DAO;
	@Override
	public String create_Dealer(Dealer_Pojo dealer_Pojo) throws Exception {
		Dealer_Master dealer_Master=new Dealer_Master();
		BeanUtils.copyProperties(dealer_Pojo, dealer_Master);
		dealer_Master=dealer_DAO.save(dealer_Master);
		return null;
	}
	@Override
	public List<Dealer_Pojo> allDealer() throws Exception {
		List<Dealer_Pojo> allDealer=null;
		allDealer=new ArrayList<Dealer_Pojo>();
		List<Dealer_Master> listDealer=dealer_DAO.findAll();
		for (Dealer_Master dealer_Master : listDealer) {
			Dealer_Pojo dealer_Pojo=new Dealer_Pojo();
			BeanUtils.copyProperties(dealer_Master, dealer_Pojo);
			allDealer.add(dealer_Pojo);
		}
		
		return allDealer;
	}
	
	@Override
	public List<Dealer_Pojo> allDealerByChannelExecutive(String channelExecutive) throws Exception {
		List<Dealer_Pojo> allDealer=null;
		allDealer=new ArrayList<Dealer_Pojo>();
		List<Object[]> listDealer=dealer_DAO.allDealerByChannelExecutive(channelExecutive);
		for (Object[] dealer_Master : listDealer) {
			Dealer_Pojo dealer_Pojo=new Dealer_Pojo();
			dealer_Pojo.setDealer_Mail_Id((String) dealer_Master[0]);
			dealer_Pojo.setDealer_Name((String) dealer_Master[1]);
			allDealer.add(dealer_Pojo);
		}
		
		return allDealer;
	}
	@Override
	public int authenticate(String dealer_Mail_Id, String password) throws Exception {
		int count=0;
		count=dealer_DAO.login(dealer_Mail_Id, password);
		return count;
	}
	@Override
	public List<User_Details_Table> allChannelExecutive() throws Exception {
		List<Object[]> allChannelExecutive=null;
		List<User_Details_Table> allChannel=null;
		allChannel=new ArrayList<>();
		allChannelExecutive=dealer_DAO.allChannelExecutive();
		for (Object[] strings : allChannelExecutive) {
			User_Details_Table user_Details_Table=new User_Details_Table();
			user_Details_Table.setUserid((String) strings[0]);
			user_Details_Table.setUserName((String) strings[1]);
			allChannel.add(user_Details_Table);
		}
		return allChannel;
	}
	
	

}
