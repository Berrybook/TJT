package com.tjt.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.POSDTO;



public class GenerateInvoicePdfReport {
	
	 public void invoicePdfGeneration(InvoiceDTO invoicedto,POSDTO posdto,ByteArrayOutputStream out) {
	 
		 Document document=new Document(new Rectangle(700,700));
		 
try{
	PdfReposrtValueReplaceMent pdfTemplet=new PdfReposrtValueReplaceMent();
	 String templet=pdfTemplet.pdfTemplet(invoicedto,posdto);
			    PdfWriter.getInstance(document,out);
			    document.open();
			    HTMLWorker htmlWorker = new HTMLWorker(document);
			    htmlWorker.parse(new StringReader(templet));
			    document.close();
		 }

		 catch(Exception e){
			 
		 }
	 }
	 public  void invoicePdfGenerationWarrenty(InvoiceDTO invoicedto,POSDTO posdto,ByteArrayOutputStream out) throws DocumentException, IOException {
		 WarrentyClass warrenty=new WarrentyClass();
		 String warrentyPdf=warrenty.warrentyService(invoicedto,posdto);
		 Document document=new Document(new Rectangle(700,700));
		 PdfWriter.getInstance(document,out);
		    document.open();
		    HTMLWorker htmlWorker = new HTMLWorker(document);
		    htmlWorker.parse(new StringReader(warrentyPdf));
		    document.close();
	 }
	
}
