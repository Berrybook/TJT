package com.tjt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.POSItemDAO;
import com.tjt.dao.POS_DAO;
import com.tjt.dao.Tyre_DAO;
import com.tjt.dto.TyreInformationDTO;

import com.tjt.entity.POS_Item;
import com.tjt.entity.POS_Table;
import com.tjt.entity.TyreCompositeKey;
import com.tjt.entity.Tyre_Information;

@Service
public class TyreServiceImpl implements TyreService {
	
	@Autowired
	private Tyre_DAO tyreDao;
	@Autowired
	private POSItemDAO pOSItemDAO;
	@Autowired
	private POS_DAO pOS_DAO;

	@Override
	public String tyreSave(TyreInformationDTO tyreInformationDTO) throws Exception {
		Tyre_Information tyreEntity=null;
		String tyrepattren=null,tyresize=null;
		Integer count=0;
		String responseResult="";
		POS_Item pOS_Item=null;
		//create tyreEntity Object 
		tyreEntity=new Tyre_Information();
		
		
		//set TyrePattern and TyreSize 
		tyrepattren=tyreInformationDTO.getTyrepattern().toUpperCase();
		tyresize=tyreInformationDTO.getTyresize().toUpperCase();
		
		//test this value is available or not 
		count=tyreDao.checkTyre(tyrepattren, tyresize);

		if(count==0){
			tyreEntity.setTyrepattern(tyrepattren);
			tyreEntity.setTyresize(tyresize);
			tyreEntity=tyreDao.save(tyreEntity);
			
			//get all POS 
			List<POS_Table> lsitPos=pOS_DAO.findAll();
			
			for (POS_Table pos : lsitPos) {
				pOS_Item=new POS_Item();
				pOS_Item.setTyrepattern(tyreEntity.getTyrepattern());
				pOS_Item.setTyresize(tyreEntity.getTyresize());
				pOS_Item.setPos(pos.getPos());
				//assign Item in  all POS 
				pOSItemDAO.save(pOS_Item);
			}
			responseResult= "Tyre  Sucessfully Registered";
		}
		
		else{
		responseResult= "Tyre  already exist";
		}
		
		return responseResult;
	}

	//List of tyre details
	@Override
	public List<TyreInformationDTO> listTyre() throws Exception {
		
		List<Tyre_Information> listEntity=null;
		List<TyreInformationDTO> listDto=null;
		listDto=new ArrayList<TyreInformationDTO>();
		listEntity=tyreDao.findAll();
		
		for (Tyre_Information entity : listEntity) {
			TyreInformationDTO dto=new TyreInformationDTO();
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
	public TyreInformationDTO tyrelistById(String tyrepattern,String tyreSize) throws Exception {
		//DEclare All LocalVariable 
		Optional<Tyre_Information> opt=null;
		Tyre_Information listentity=null;
		TyreInformationDTO listDto=null;
		
		//Create Object of TyreEntity class 
		listentity=new Tyre_Information();
		listDto=new TyreInformationDTO();
		
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
	public String tyreUpdate(TyreInformationDTO dto) throws Exception {
		Tyre_Information tyreEntity=null;
		tyreEntity=new Tyre_Information();
		
		//copy all value from tyreDto class Object to tyreEntity class Object
		BeanUtils.copyProperties(dto, tyreEntity);
		
		tyreEntity=tyreDao.save(tyreEntity);
		//System.out.println(tyreEntity.getTyreid());
		
		if(tyreEntity==null){
			return "Tyre not Sucessfully Updated";
		}
			return "Tyre  Sucessfully Updated";
	}
}
