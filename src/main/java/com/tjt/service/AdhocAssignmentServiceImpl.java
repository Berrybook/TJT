package com.tjt.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.AdhocAssignmentDao;
import com.tjt.dao.CityDAO;
import com.tjt.dao.Role_DAO;
import com.tjt.dao.User_Detalis_DAO;
import com.tjt.dto.AdhocAssignmentDto;
import com.tjt.dto.City_DTO;
import com.tjt.entity.Adhoc_Assignment;
import com.tjt.entity.City_Table;
import com.tjt.entity.POS_Table;
import com.tjt.entity.Role_Table;
import com.tjt.entity.User_Details_Table;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class AdhocAssignmentServiceImpl implements AdhocAssignmentService {

        @Autowired
        private CityDAO cityDao;
        @Autowired 
        private User_Detalis_DAO userDAO;
        @Autowired 
        private AdhocAssignmentDao adhocDAO;  
        @Autowired 
        private Role_DAO roledao;
        @Autowired
        private CityDAO cityDAO;
        
        @Autowired
        private POSService poser; 
        
        //adhoc salesman assign to pos
        @Override
        public String createAdhocAssignment(HttpServletRequest request,AdhocAssignmentDto dto) throws Exception {
                Adhoc_Assignment adhocentity = null;
                POS_Table posentity = null;
                adhocentity = new Adhoc_Assignment();
                posentity = new POS_Table();
                
                posentity.setPos(dto.getAdhocPos());
                BeanUtils.copyProperties(dto, adhocentity);
                adhocentity.setAdhocPos(dto.getAdhocPos());
                adhocentity.setStartDate(dto.getStartDate());
                adhocentity.setEndDate(dto.getEndDate());
                adhocentity=adhocDAO.save(adhocentity);
                if(adhocentity ==null){
                        return "salesman assign failed";
                }
                
                return "salesman assigned  successfully ";
        }

        //get all cities in dropdown
        @Override
        public List<City_DTO> allCity() throws Exception {
                
        	List<City_DTO> cityEntity=null;
                try {
                        cityEntity=poser.listCity();
                        
                        
                }
                catch (Exception e) {
                        throw new Exception("database error allcity");
                }
                return cityEntity;
        }

      //get salsman citywise 
      		@Override
      		public List<AdhocAssignmentDto> allSalesmanByCity(String cityname) throws Exception {
      		List<AdhocAssignmentDto> listuser = null;
      		listuser = new ArrayList<AdhocAssignmentDto>();
      		List<Object[]> adhocsalesman = null;
      	
      	
      		
      		City_Table city_table=new City_Table();
      		city_table.setCityname(cityname);
      		try {
      			adhocsalesman = userDAO.allSalesmanByCity(city_table);
      			
      				for(Object[] adhoc : adhocsalesman) {
      				AdhocAssignmentDto adhocdto = new AdhocAssignmentDto();
      				
      			
      				
      				adhocdto.setUserid((String) adhoc[0]);
      				adhocdto.setUsername((String) adhoc[1]);
      				POS_Table postable = null;
      				postable = (POS_Table) adhoc[2];
      				adhocdto.setPos(postable.getPos());
      				listuser.add(adhocdto);
      				}	
      		}
      		
      			catch (Exception e) {
      				throw new Exception("database error allsalesmanByCity");
      		}
      			System.out.println(listuser);
      			return listuser;
      		}

        @Override
        public AdhocAssignmentDto salesmanById(HttpServletRequest request,String userid) throws Exception {
                
                HttpSession session=null;
                AdhocAssignmentDto adhocdto = new AdhocAssignmentDto();
                Adhoc_Assignment adhoctable = new Adhoc_Assignment();
                session=request.getSession(false);
                adhoctable = adhocDAO.getOne(userid);
                BeanUtils.copyProperties(adhoctable, adhocdto);
                
                return adhocdto;
        }

		@Override
		public List<AdhocAssignmentDto> findsalemanbyid(String uid) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<AdhocAssignmentDto> allAssignedAdhoc() throws Exception {
			 
			List<AdhocAssignmentDto> listDto = null;
			List<Adhoc_Assignment>	listTable = null;
			listTable = adhocDAO.findAll();
			listDto = new ArrayList<AdhocAssignmentDto>();
			for(Adhoc_Assignment adhocloop : listTable){
				AdhocAssignmentDto adhocdto = new AdhocAssignmentDto();
				
				BeanUtils.copyProperties(adhocloop, adhocdto);
				listDto.add(adhocdto);
				
			}
			
			return listDto;
		}
        
		
		public void updateadhoc(Adhoc_Assignment adhoc)
		{
			adhocDAO.save(adhoc);
		}
		
		
		
		
		//demo id
		@Override
  		public AdhocAssignmentDto allSalesmanByid(String id) throws Exception {
  		List<AdhocAssignmentDto> listuser = null;
  		listuser = new ArrayList<AdhocAssignmentDto>();
  		List<Object[]> adhocsalesman = null;
  		AdhocAssignmentDto adhocdto = new AdhocAssignmentDto();
  
  		try {
  			System.out.println(id);
  			adhocsalesman = userDAO.allSalesmanById(id);
  			System.out.println("val"+adhocsalesman);
  			
  				for(Object[] adhoc : adhocsalesman) {
  			
  				adhocdto.setUserid((String) adhoc[0]);
  				adhocdto.setUsername((String) adhoc[1]);
  				POS_Table postable = null;
  				postable = (POS_Table) adhoc[2];
  				adhocdto.setPos(postable.getPos());
  				listuser.add(adhocdto);
  				}	
  		}
  		
  			catch (Exception e) {
  				throw new Exception("database error allsalesmanByCity");
  		}
  			System.out.println(listuser);
  			return adhocdto;
  		}
		
		
}