package com.tjt.util;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tjt.dto.InvoiceDTO;



public class GeneratePdfReport2 {
	
	 public static void citiesReport(InvoiceDTO invoicedto,ByteArrayOutputStream out) {
	 
		 
		 Document document=new Document();
		 
		 
		 try{
			 PdfPTable table2 = new PdfPTable(5);
			 table2.setWidthPercentage(100);
			 table2.setWidths(new int[]{5, 5, 5,5,5});
	            
	          //  Font f2= new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.BLACK);
	            PdfPCell cell11 = new PdfPCell(new Phrase("Date      :    "+invoicedto.getSaledate() + "     Invoice Number  :   " + invoicedto.getInvoice_Number()));
	            cell11.setColspan(10);
	            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell11.setPadding(5.0f);
	            cell11.setBackgroundColor(new BaseColor(200,200,200));
	            table2.addCell(cell11);
			 
			 PdfPTable table1 = new PdfPTable(5);
	            table1.setWidthPercentage(100);
	            table1.setWidths(new int[]{5, 5, 5,5,5});
	            
	           // Font f1= new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.BLACK);
	            PdfPCell cell10 = new PdfPCell(new Phrase("GST NUMBER     : "+invoicedto.getGstNo()+ "              GST ADDRESS    :  "+invoicedto.getGstAddress()));
	            cell10.setColspan(10);
	            cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell10.setPadding(5.0f);
	            cell10.setBackgroundColor(new BaseColor(200,200,200));
	            table1.addCell(cell10);
	            
	           
	            
	            
			 PdfPTable table = new PdfPTable(5);
	            table.setWidthPercentage(100);
	            table.setWidths(new int[]{5, 5, 5,5,5});
	            
	            Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.BLACK);
	            PdfPCell cell1 = new PdfPCell(new Phrase("TJTYRE INVOICE", f));
	            cell1.setColspan(10);
	            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	            cell1.setPadding(5.0f);
	            cell1.setBackgroundColor(new BaseColor(200,200,200));
	            table.addCell(cell1);
	            
	            
	            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	            PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("SalesPersion", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            hcell = new PdfPCell(new Phrase("CustomerName", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("ContactNumber", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("EmailId", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("TotalPrice", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            
	            
	           

	                PdfPCell cell;
	                cell = new PdfPCell(new Phrase(invoicedto.getUserid()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);
	                

	                cell = new PdfPCell(new Phrase(invoicedto.getCustomerName()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	               

	                cell = new PdfPCell(new Phrase(String.valueOf(invoicedto.getContactNumber())));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                cell.setPaddingRight(5);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(invoicedto.getEmail()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                
	                cell = new PdfPCell(new Phrase(String.valueOf(invoicedto.getTotal_price())));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                cell.setPaddingRight(5);
	                table.addCell(cell);
	           

	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(table1);
	            document.add( table2);
	            document.add(table);
	          
	           
	            document.close();
			 
		 }
		 catch(Exception e){
			 
		 }
		// return new ByteArrayOutputStream(out.toByteArray());
	 }
}
