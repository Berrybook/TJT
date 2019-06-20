package com.tjt.service;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tjt.dao.TrackSheetModiDao;
import com.tjt.entity.TrackingNewEntity;

@Service
public class TrackSheetModService {
	

	@Autowired
	private TrackSheetModiDao trackSheetModiDao;
	
	
	
	public String addnewsheet(TrackingNewEntity track) {

		String st = track.getTimeslot();
		
		LocalTime ct = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		String msg = "val";
	


		
		
		if (st.equalsIgnoreCase("8am-10am")) {
			LocalTime start = LocalTime.parse("08:00:00");
			LocalTime end = LocalTime.parse("10:30:00");
			
//		Date start=sdf.parse("08:00");
//		Date end=sdf.parse("10:00");
			if (ct.isAfter(start) && ct.isBefore(end))

			{
				msg = "Record Successfully Submitted";
				trackSheetModiDao.save(track);
				return msg;

			}

			else

			{
				msg = "This Time-Slot is not available Please select the current Time-Slot";

				return msg;
			}

		}

		else if (st.equalsIgnoreCase("10am-12pm"))

		{

			LocalTime start = LocalTime.parse("10:00:00");
			LocalTime end = LocalTime.parse("12:30:00");
			if (ct.isAfter(start) && ct.isBefore(end))

			{
				msg = "Record Successfully Submitted";
				trackSheetModiDao.save(track);
				return msg;

			}

			else

			{
				msg = "This Time-Slot is not available Please select the current Time-Slot";

				return msg;
			}

		}

		else if (st.equalsIgnoreCase("12pm-2pm"))

		{
			LocalTime start = LocalTime.parse("12:00:00");
			LocalTime end = LocalTime.parse("14:30:00");
			if (ct.isAfter(start) && ct.isBefore(end))

			{
				msg = "Record Successfully Submitted";
				trackSheetModiDao.save(track);
				return msg;

			}

			else

			{
				msg = "This Time-Slot is not available Please select the current Time-Slot";

				return msg;
			}

		}

		else if (st.equalsIgnoreCase("2pm-4pm"))

		{
			LocalTime start = LocalTime.parse("14:00:00");
			LocalTime end = LocalTime.parse("16:30:00");
			if (ct.isAfter(start) && ct.isBefore(end))

			{
				msg = "Record Successfully Submitted";
				trackSheetModiDao.save(track);
				return msg;

			}

			else

			{
				msg = "This Time-Slot is not available Please select the current Time-Slot";

				return msg;
			}

		}

		else if (st.equalsIgnoreCase("4pm-6pm"))

		{
			LocalTime start = LocalTime.parse("16:00:00");
			LocalTime end = LocalTime.parse("18:30:00");
			if (ct.isAfter(start) && ct.isBefore(end))

			{
				msg = "Record Successfully Submitted";
				trackSheetModiDao.save(track);
				return msg;

			}

			else

			{
				msg = "This Time-Slot is not available Please select the current Time-Slot";

				return msg;
			}

		}

		else if (st.equalsIgnoreCase("6pm-8pm"))

		{
			LocalTime start = LocalTime.parse("18:00:00");
			LocalTime end = LocalTime.parse("20:30:00");
			if (ct.isAfter(start) && ct.isBefore(end))

			{
				msg = "Record Successfully Submitted";
				trackSheetModiDao.save(track);
				return msg;

			}

			else

			{
				msg = "This Time-Slot is not available Please select the current Time-Slot";

				return msg;
			}

		}
		
		else if (st.equalsIgnoreCase("8pm-10pm"))

		{
			LocalTime start = LocalTime.parse("20:00:00");
			LocalTime end = LocalTime.parse("22:30:00");
			if (ct.isAfter(start) && ct.isBefore(end))

			{
				msg = "Record Successfully Submitted";
				trackSheetModiDao.save(track);
				return msg;

			}

			else

			{
				msg = "This Time-Slot is not available Please select the current Time-Slot";	

				return msg;
			}

		}

		return msg;

	}
	
	public List<TrackingNewEntity> recordbydate(String date,String pos) {
		
		List<Object[]> listob=null;
		List<TrackingNewEntity> track=new ArrayList<TrackingNewEntity>();		
		
		if(pos.equalsIgnoreCase("allpos") && date.equalsIgnoreCase(""))
		{  System.out.println("allpos");
			listob=trackSheetModiDao.allrecordbydate();}
		
		else if(pos.equalsIgnoreCase("allpos") && date.equalsIgnoreCase(date))
		{listob=trackSheetModiDao.allrecordbydate(date);}
		
		else if(pos.equalsIgnoreCase(pos) && date!="")
		{
			{listob=trackSheetModiDao.recordbydate(date,pos);}
		}
		
		else if(pos.equalsIgnoreCase(pos) && date.equalsIgnoreCase(""))
		{
			{listob=trackSheetModiDao.allrecordbypos(pos);}
		}
		
	
		for (Object[] objects : listob) {
			TrackingNewEntity traob=new TrackingNewEntity();
			traob.setSalesman((String) objects[0]);
			traob.setDate((String) objects[1]);
			traob.setPos((String) objects[2]);
			traob.setCustomerapp((Long) objects[3]);
			traob.setCustomerinq((Long) objects[4]);
			traob.setTyresale((Long) objects[5]);
			track.add(traob);
			
		}
	
		return track;
	}
	
public List<TrackingNewEntity> recordbydatesalesman(String date,String pos,String salesman) {
		
		
		List<TrackingNewEntity> track=new ArrayList<TrackingNewEntity>();
		List<Object[]> listob=null;
		

		if(date.equalsIgnoreCase("")&&salesman.equalsIgnoreCase("undefined"))
		{
			System.out.println("2");
			listob=trackSheetModiDao.recordbypos(pos);
			 
		}
		else if(salesman.equalsIgnoreCase(salesman)&&date.equalsIgnoreCase("")&&pos!="")
			
		{
			System.out.println("3");
			listob=trackSheetModiDao.recordbysalesman(pos,salesman);
			
			
		}
		else if(salesman.equalsIgnoreCase("undefined")&&date.equalsIgnoreCase(date))
		{
			System.out.println("4");
			 listob=trackSheetModiDao.recordsalesmandate(date,pos);
		}
		else if(salesman.equalsIgnoreCase(salesman)&&date.equalsIgnoreCase(date)&&pos!="")
		{
			System.out.println("5");
			listob=trackSheetModiDao.recordbydatesalesman(date,pos,salesman);
			
		}
		else if(pos.equalsIgnoreCase("")&&date.equalsIgnoreCase(""))
		{
			System.out.println("6");
			listob=trackSheetModiDao.allrecord();
			
		}
		
		
		for (Object[] objects : listob) {
			TrackingNewEntity traob=new TrackingNewEntity();
			traob.setSalesman((String) objects[0]);
			traob.setDate((String) objects[1]);
			traob.setPos((String) objects[2]);
			traob.setTimeslot((String) objects[3]);
			traob.setCustomerapp((Long) objects[4]);
			traob.setCustomerinq((Long) objects[5]);
			traob.setTyresale((Long) objects[6]);
			traob.setComment((String) objects[7]);
			track.add(traob);
			
		}

	
		return track;
	}



}
