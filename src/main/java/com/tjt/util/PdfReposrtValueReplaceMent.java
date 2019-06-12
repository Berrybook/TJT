package com.tjt.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.POSDTO;

public class PdfReposrtValueReplaceMent {
	
	public String pdfTemplet(InvoiceDTO invoicedto,POSDTO posdto ){
		
	String replaceQuantity=null,replacetyresize=null,replacebasicPrice=null,rateReplace=null;
	String templet=invoicedto.getTemplet();
	
	String rowAdd="<td style='border: 1px solid black;height: 60px;vertical-align: bottom;font-size: 15px'><p>2</td>"
	+"<td style='border: 1px solid black;height: 60px;vertical-align: bottom;font-size: 15px'>tyresize1</td>"
    +"<td style='border: 1px solid black;height: 60px;vertical-align: bottom;font-size: 15px'>40114010</td>"
    +"<td style='border: 1px solid black;height: 60px;vertical-align: bottom;font-size: 15px'>quntity1</td>"
    +"<td style='border: 1px solid black;height: 60px;vertical-align: bottom;font-size: 15px'>rate1</td>"
    +"<td style='border: 1px solid black;height: 60px;vertical-align: bottom;font-size: 15px'><center>rate1</td>";
	long quantityTest=invoicedto.getQuantity();

	Date date=invoicedto.getSaledate();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	String salesdate=dateFormat.format(date);
	
	//convert invoiceNumber to StringFormart
	Long number=invoicedto.getInvoice_Number();
	String invoiceNumber=Long.toString(number);
	
	
	//convert contactNumber to StringFormart
	Long contactnumber=invoicedto.getContactNumber();
	String invoiceContact=Long.toString(contactnumber);
	
	
	//convert CGST to StringFormart
	Double cgst=invoicedto.getTotal_cgst();
	cgst=(double) Math.round(cgst*100.0)/100.0;
	String invoicecgst=Double.toString(cgst);
	
	
	//convert SGST to StringFormart
	Double sgst=invoicedto.getTotal_sgst();
	sgst=(double) Math.round(sgst*100.0)/100.0;
	String invoicesgst=Double.toString(sgst);
	
	
	
	//convert totalPrice to StringFormart
	Double totalprice=invoicedto.getTotal_price();
	String total_price=Double.toString(totalprice);
	Double textble_amount=invoicedto.getTaxble_amount();
	String taxbleamount=Double.toString(textble_amount);
	//convert quantity to StringFormart
	Long quantity=invoicedto.getQuantity();
	String invoiceQuantity=Long.toString(quantity);
	
	//convert BasicPrice to StringFormart
	Double basicPrice=invoicedto.getBasicPrice();
	String basicPrice1=Double.toString(basicPrice);
	
	Double discount=invoicedto.getDiscount();
	
	String discounts=Double.toString(discount);
	String posname=templet.replaceAll("posName", posdto.getPosName());
	String address=posname.replaceAll("address1", posdto.getAddress1());
	String cityName=address.replaceAll("cityname", posdto.getCityname());
	String pincode=cityName.replaceAll("pincode", posdto.getPincode());
	String replacename=pincode.replaceAll("customername",invoicedto.getCustomerName());
	String replacedate=replacename.replaceAll("salesdate", salesdate);
	String replaceInvoicenumber=replacedate.replaceAll("invoicenumber", invoiceNumber);
	String replaceAddress=replaceInvoicenumber.replaceAll("address1", invoicedto.getAddress1());
	String replaceAddress1=replaceAddress.replaceAll("address2", invoicedto.getAddress2());
	String replacecity=	replaceAddress1.replaceAll("city", invoicedto.getCity());
	String repalceEmail=replacecity.replaceAll("email",invoicedto.getEmail());
	String replacecgst=repalceEmail.replaceAll("cgstprice", invoicecgst);
	String replacesgst=replacecgst.replaceAll("sgstprice", invoicesgst);
	String replacetotalprice=replacesgst.replaceAll("totalprice", total_price);
	String replaceContactNumber=replacetotalprice.replaceAll("contactnumber", invoiceContact);
	String replaceQuantityInWord=replaceContactNumber.replaceAll("####", invoicedto.getPrice_in_word());
	String replacetaxbleamount=replaceQuantityInWord.replaceAll("taxbleamount", taxbleamount);
	String replaceDiscount=replacetaxbleamount.replaceAll("discount", discounts);
	try{
	if(quantityTest==1){
		replacetyresize=replaceDiscount.replaceAll("tyresize", invoicedto.getTyresize()+" "+invoicedto.getTyrepattern());
		replacebasicPrice=replacetyresize.replaceAll("basicprice", basicPrice1);
		replaceQuantity=replacebasicPrice.replaceAll("quntity", invoiceQuantity);
		Double rate=invoicedto.getBasicPrices()[0];
		String rates=Double.toString(rate);
		rateReplace=replaceQuantity.replaceAll("rates",rates);
		return rateReplace;
	}
	
	else{
			int i=0;
			if((invoicedto.getTyrepatterns()[i]==invoicedto.getTyrepatterns()[i+1]) && (invoicedto.getTyresizes()[i]==invoicedto.getTyresizes()[i])){
				replacetyresize=replaceDiscount.replaceAll("tyresize", invoicedto.getTyresizes()[i]+" "+invoicedto.getTyrepatterns()[i]);
				replacebasicPrice=replacetyresize.replaceAll("basicprice", basicPrice1);
				replaceQuantity=replacebasicPrice.replaceAll("quntity", invoiceQuantity);
				Double rate=invoicedto.getBasicPrices()[0];
				String rates=Double.toString(rate);
				rateReplace=replaceQuantity.replaceAll("rates",rates);
				return rateReplace;
			}
			else{
				String newbPdfTemplet=null;
				replacetyresize=replaceDiscount.replaceAll("tyresize", invoicedto.getTyresizes()[i]+" "+invoicedto.getTyrepatterns()[i]);
				Double basicPr=invoicedto.getBasicPrices()[i];
				String rate=Double.toString(basicPr);
				replacebasicPrice=replacetyresize.replaceAll("basicprice", rate);
				String rateReplace1=replacebasicPrice.replaceAll("rates", rate);
				replaceQuantity=rateReplace1.replaceAll("quntity", "1");
				for(int j=0;j<quantityTest;j++){}
					 String replacetyresize1=rowAdd.replaceAll("tyresize1", invoicedto.getTyresizes()[i+1]+" "+invoicedto.getTyrepatterns()[i+1]);
					 Double basicPric=invoicedto.getBasicPrices()[i+1];
					 String rate1=Double.toString(basicPric);
					 String replacerate=replacetyresize1.replaceAll("rate1", rate1);
					 String Quantity=replacerate.replaceAll("quntity1","1");
					 newbPdfTemplet=replaceQuantity.replaceAll("<>",Quantity );
				return newbPdfTemplet;
			}
	}
	}catch(Exception e){
		
	}
	return replacetaxbleamount;
	
	
	}
	
	
}
