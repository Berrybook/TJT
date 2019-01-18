package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tjt.dao.POS_DAO;
import com.tjt.dto.City_DTO;
import com.tjt.dto.POSDTO;
import com.tjt.entity.City_Table;
import com.tjt.entity.POS_Table;

@Service
public class POSServiceImpl implements POSService{
	
	@Autowired
	private POS_DAO posDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,transactionManager="transactionManager")
	public int autheticate(String pos, String password) {
		int count=0;
		 count=posDao.login(pos, password);
		 return count;
		
	}

	@Override
	public String createPOS(POSDTO dto) throws Exception {
		
		POS_Table postable=null;
		City_Table citytable=null;
		String gst_number=null;
		String gst_address=null;
		
		//create POS_table Object 
		postable=new POS_Table();
		
		//create POS_table Object 
		citytable=new City_Table();
		
		String cityname=dto.getCityname();
			List<Object[]> listGSt=null;
			listGSt=posDao.featchGstNoAndGstAddress(cityname);
			
			for (Object[] objects : listGSt) {
				
				gst_number= (String) objects[0];
				gst_address=(String) objects[1];
			}
	
		
		
		citytable.setCityname(dto.getCityname());
		
		
		
		//copy POSDTO class to entity class 
		BeanUtils.copyProperties(dto, postable);
		postable.setCity_table(citytable);
		postable.setGstNo(gst_number);
		postable.setGstAddress(gst_address);
		
		//saving POS data from database
		postable=posDao.save(postable);
		if(postable==null){
			return "pos alr";
		}
		return "";
	}

	@Override
	public POSDTO listById(String pos) throws Exception {
		
		POSDTO dto=null;
		POS_Table postable=null;
		City_Table citytable=null;
		
		//create POSDTO Object 
		dto=new POSDTO();
		
		//create City_Table Object 
		citytable=new City_Table();
		
		postable=posDao.getOne( pos);
		citytable=postable.getCity_table();
		//copy POS_Table class object to POSDTO
		BeanUtils.copyProperties(postable, dto);
		dto.setCityname(citytable.getCityname());
		
		return dto;
	}

	@Override
	public void updatePOS(POSDTO dto) throws Exception {
		POS_Table postable=null;
		City_Table citytable=null;
		
		//create POS_table Object 
		postable=new POS_Table();
		
		//create POS_table Object 
		citytable=new City_Table();
		
		
		citytable.setCityname(dto.getCityname());
		
		
		
		//copy POSDTO class to entity class 
		BeanUtils.copyProperties(dto, postable);
		postable.setCity_table(citytable);
		
		
		//update POS data from database
		posDao.save(postable);
		
	}

	@Override
	public void deletePOS(String pos) throws Exception {
		
		//delete POS data from database
		posDao.deleteById(pos);
	}

	@Override
	public List<POSDTO> listPos() throws Exception {

		List<POSDTO> listDto=null;
		List<POS_Table> listpostable=null;
		City_Table citytable=null;
		
		//create POSDTO Object 
		listDto=new ArrayList<POSDTO>();
		
		//create City_Table Object 
		citytable=new City_Table();
		
		listpostable=posDao.findAll();
		for (POS_Table pos_Table : listpostable) {
			POSDTO dto=new POSDTO();
			citytable=pos_Table.getCity_table();
			BeanUtils.copyProperties(pos_Table, dto);
			dto.setCityname(citytable.getCityname());
			listDto.add(dto);
		}
		
		
		return listDto;
	}

	@Override
	public List<City_DTO> listCity() throws Exception {
		List<City_DTO>  listCitydto=null;
		List<Object[]>  listcityenity=null;
		
		listCitydto=new ArrayList<City_DTO>();
		listcityenity=posDao.listCity();
		for (Object city_Table : listcityenity) {
			
			City_DTO dto=new City_DTO();
			dto.setCityname((String) city_Table);
			listCitydto.add(dto);
		}
		
		
		return listCitydto;
	}

	@Override
	public String[] findGstnoAndGsrAdd(String city) throws Exception {
		
		List<Object[]> listGSt=null;
		String[] gst=null;
		
			listGSt=posDao.featchGstNoAndGstAddress(city);
			
			for (Object[] objects : listGSt) {
				gst=new String[objects.length];
				gst[0]= (String) objects[0];
				gst[1]=(String) objects[1];
			}
	
		
		return gst;
	}
	
	
	

}
