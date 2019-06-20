package com.tjt.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjt.dao.CustomerInquaryDAO;
import com.tjt.dto.CustomerInquaryDTO;
import com.tjt.dto.UserDTO;
import com.tjt.entity.CustomerForm;
import com.tjt.entity.POS_Table;
import com.tjt.entity.User_Details_Table;

import ch.qos.logback.classic.boolex.IEvaluator;

@Service

public class CustomerInquaryService implements CustimerDeclaration {
	@Autowired
	private CustomerInquaryDAO customerInquaryDAO;

	@Override
	public String customerData(CustomerForm customerForm) {
		customerInquaryDAO.save(customerForm);
		return "CustomerInquary";

	}

	public List<CustomerForm> viewalldetails() {
		Iterable<CustomerForm> ob = null;
		List<CustomerForm> list = new ArrayList<CustomerForm>();

		ob = customerInquaryDAO.findAll();

		for (CustomerForm customerForm : ob) {

			CustomerForm cus = new CustomerForm();
			cus.setCustomerName(customerForm.getCustomerName());
			cus.setComments(customerForm.getComments());
			cus.setMeterReading(customerForm.getMeterReading());
			cus.setPhoneNumber(customerForm.getPhoneNumber());
			cus.setTentadate(customerForm.getTentadate());
			cus.setTyreSize(customerForm.getTyreSize());
			cus.setVehicle(customerForm.getVehicle());
			cus.setVehicleModel(customerForm.getVehicleModel());
			cus.setDateofinqu(customerForm.getDateofinqu());
			cus.setTime(customerForm.getTime());
			cus.setPos(customerForm.getPos());
			cus.setSalesman(customerForm.getSalesman());
			list.add(cus);

		}

		return list;

	}

	public List<CustomerForm> finddate() {

		Date d = new Date();
		System.out.println("Date before Addition: " + d);
		List<CustomerForm> listcus = new ArrayList<CustomerForm>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String strDate = sdf.format(d);

		System.out.println("after string:" + strDate);

		try {
			c.setTime(sdf.parse(strDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Incrementing the date by 1 day
		c.add(Calendar.DAY_OF_MONTH, 7);
		String newDate = sdf.format(c.getTime());
		List<Object[]> list = null;
		list = customerInquaryDAO.finallbydate(strDate, newDate);
		for (Object[] obj : list) {
			CustomerForm cus = new CustomerForm();
			cus.setCustomerName((String) obj[0]);
			cus.setPhoneNumber((String) obj[1]);
			cus.setVehicle((String) obj[2]);
			cus.setVehicleModel((String) obj[3]);
			cus.setTyreSize((String) obj[4]);
			cus.setMeterReading((String) obj[5]);
			cus.setTentadate((String) obj[6]);
			cus.setComments((String) obj[7]);
			cus.setDateofinqu((String) obj[8]);
			cus.setTime((String) obj[9]);
			cus.setPos((String) obj[10]);
			cus.setSalesman((String) obj[11]);
			
			
			listcus.add(cus);
		}

		return listcus;

	}
	
	public List<UserDTO> findsalesman(String uname)
	{
		List<UserDTO> list=new ArrayList<UserDTO>();
		List<Object> obb=null;
		POS_Table pos=new POS_Table();
		System.out.println("obb1");
		pos.setPos(uname);
		obb = customerInquaryDAO.findsalesman(pos);
		System.out.println("obb2");
		for (Object obj : obb) {
			UserDTO userDto=null;
			 userDto=new UserDTO();
			 
			//cast salesmanId  in object 
			String salesmanid=(String)obj;
			userDto.setUserid(salesmanid);
			list.add(userDto);
			System.out.println("for loop");
		}
		System.out.println("list:"+obb);
		return list;
	}
	
	
	public List<String> findsalesmanbypos(String uname)
	{
		POS_Table pos=new POS_Table();
		pos.setPos(uname);
		List<String> list=customerInquaryDAO.findsalesmanbypos(pos);
//		for (Object ob : list) {
//			UserDTO udto=new UserDTO();
//			String salesman=(String) ob;
//			udto.setUserid(salesman);
//		}
		for(String s:list)
		System.out.println(s);
		return list;
	}
	
}