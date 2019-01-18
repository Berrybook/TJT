package com.tjt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.Tyre_DAO;
import com.tjt.dto.TyreInformationDTO;
import com.tjt.dto.TyreInformationDTO2;
import com.tjt.entity.TyreCompositeKey;
import com.tjt.entity.Tyre_Information;

@Service
public class TyreServiceImpl implements TyreService {
	
	@Autowired
	private Tyre_DAO tyreDao;

	@Override
	public String tyreSave(TyreInformationDTO dto) throws Exception {
		Tyre_Information tyreEntity=null;
		String tyrepattren=null,tyresize=null;
		Integer count=0;
		
		tyreEntity=new Tyre_Information();
		BeanUtils.copyProperties(dto, tyreEntity);
		tyreEntity.setCGST("14");
		tyreEntity.setIGST("28");
		tyreEntity.setSGST("14");
		tyrepattren=tyreEntity.getTyrepattern();
		tyresize=tyreEntity.getTyresize();
		count=tyreDao.checkTyre(tyrepattren, tyresize);
		if(count==0){
			tyreEntity=tyreDao.save(tyreEntity);
			return "Tyre  Sucessfully Registred";
		}
			return "Tyre  alredy exist";
	}

	//List of tyre details
	@Override
	public List<TyreInformationDTO2> listTyre() throws Exception {
		
		List<Tyre_Information> listEntity=null;
		List<TyreInformationDTO2> listDto=null;
		listDto=new ArrayList<TyreInformationDTO2>();
		listEntity=tyreDao.findAll();
		for (Tyre_Information entity : listEntity) {
			TyreInformationDTO2 dto=new TyreInformationDTO2();
			BeanUtils.copyProperties(entity, dto);
			listDto.add(dto);
		}
		
		
		return listDto;
	}

	@Override
	public void tyreDelete(String tyrepattern,String tyreSize) throws Exception {
		Tyre_Information listentity=null;
		
		listentity=new Tyre_Information();
		
		listentity.setTyrepattern(tyrepattern);
		listentity.setTyresize(tyreSize);
		
		tyreDao.delete(listentity);
		
	}

	@Override
	public TyreInformationDTO2 tyrelistById(String tyrepattern,String tyreSize) throws Exception {
		//DEclare All LocalVariable 
		Optional<Tyre_Information> opt=null;
		Tyre_Information listentity=null;
		TyreInformationDTO2 listDto=null;
		
		//Create Object of TyreEntity class 
		listentity=new Tyre_Information();
		listDto=new TyreInformationDTO2();
		
		TyreCompositeKey key=new TyreCompositeKey();
		key.setTyrepattern(tyrepattern);
		key.setTyresize(tyreSize);
		
			//get tyre details of 
			opt=tyreDao.findById(key);
			//copy all otp value to entity class 
			listentity=opt.get();
			
			//copy all enity class  value to dto class 
			BeanUtils.copyProperties(listentity, listDto);
			return listDto;
	}

	@Override
	public String tyreUpdate(TyreInformationDTO2 dto) throws Exception {
		Tyre_Information tyreEntity=null;
		tyreEntity=new Tyre_Information();
		
		//copy all value from tyreDto class Object to tyreEntity class Object
		BeanUtils.copyProperties(dto, tyreEntity);
		tyreEntity.setCGST("14");
		tyreEntity.setIGST("28");
		tyreEntity.setSGST("14");
		tyreEntity=tyreDao.save(tyreEntity);
		//System.out.println(tyreEntity.getTyreid());
		
		if(tyreEntity==null){
			return "Tyre not Sucessfully Updated";
		}
			return "Tyre  Sucessfully Updated";
	}
}
