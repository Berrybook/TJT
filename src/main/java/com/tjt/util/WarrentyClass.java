package com.tjt.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.POSDTO;

public class WarrentyClass {
	
	public String warrentyService(InvoiceDTO invoiceDTO,POSDTO posdto){
		Date date=invoiceDTO.getSaledate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String salesdate=dateFormat.format(date);
		Long vehicleRunning=invoiceDTO.getVehiclekm();
		String running=Long.toString(vehicleRunning);
		
		String warrentyTemplet=	invoiceDTO.getWarrentyTemplet();
		String repalceName=warrentyTemplet.replaceAll("< NAME >", invoiceDTO.getCustomerName());
		String repalceInvoiceDate=repalceName.replaceAll("< invoice date >", salesdate);
		String replaceTyresize=repalceInvoiceDate.replaceAll("< Tyre size info >", invoiceDTO.getTyresize());
		String replaceVehicleNumber=replaceTyresize.replaceAll("< vehcile >", invoiceDTO.getVehiclenumber());
		String replaceVehicleRun=replaceVehicleNumber.replaceAll("< KM reading >", running);
		String posname=replaceVehicleRun.replaceAll("posName", posdto.getPosName());
		String address=posname.replaceAll("address1", posdto.getAddress1());
		String cityname=address.replaceAll("cityname", posdto.getCityname());
		String pincode=cityname.replaceAll("pincode", posdto.getPincode());
		return pincode;
	}

}
