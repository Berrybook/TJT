package com.tjt.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.tjt.dto.InvoiceDTO;


public class GeneratePdfReport {
	
	 public static ByteArrayInputStream invoicePdf(InvoiceDTO invoicedto) {
	 
		 
		 Document document=new Document(new Rectangle(700,700));
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
	
		 try{
			 PdfReposrtValueReplaceMent pdfTemplet=new PdfReposrtValueReplaceMent();
			 String templet=pdfTemplet.pdfTemplet(invoicedto);
				PdfWriter.getInstance(document,out);
			    document.open();
			    HTMLWorker htmlWorker = new HTMLWorker(document);
			    htmlWorker.parse(new StringReader(templet));
			    document.close();	  
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 return new ByteArrayInputStream(out.toByteArray());
	 }
}
