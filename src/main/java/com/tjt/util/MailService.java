package com.tjt.util;

import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tjt.dto.InvoiceDTO;
import com.tjt.dto.MailConnectionproperties;

public class MailService {
	
	
	
	 //attachment send in mail 
		public  void sendmail(HttpServletRequest request ,List<byte[]> listbytes,MailConnectionproperties propertie) throws Exception{
			HttpSession session=null;
			InvoiceDTO invoiceDTO=null;
			mailConnection mailconnection=null;
			Multipart multipart=null;
			session=request.getSession(false);
			 invoiceDTO=(InvoiceDTO) session.getAttribute("invoiceDetails");
				String [] mailid=new String[2];
				mailid[0]=invoiceDTO.getEmail();
				mailid[1]=invoiceDTO.getUserMailId();
			//connect mail 
			mailconnection=new mailConnection(); 
			Session mailSession=mailconnection.mailConnect( propertie);
			Message msg=new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("invoice@tjtyres.com",false));
			msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(mailid[0]));
			msg.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(mailid[1]));
			msg.setSubject("TJTyre Invoice and Warrenty ");
			msg.setSentDate(new Date());
			multipart=new MimeMultipart();
			String [] fileName= {"tjtyreinvoice","tjtyrewarrenty","tjtyrewarrenty"};
			int i=0;
			
			//construct the pdf body part
			for (byte[] bytes : listbytes) {
				DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
		        MimeBodyPart pdfBodyPart = new MimeBodyPart();
		        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
		        pdfBodyPart.setFileName(fileName[i]+".pdf");
		        multipart.addBodyPart(pdfBodyPart);
		        i++;
			}
			msg.setContent(multipart);
			msg.setDescription("invoice message ");
			//send the mail

			Transport.send(msg);
		}
}
