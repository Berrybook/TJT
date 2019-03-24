package com.tjt.util;

import java.util.Properties;

import javax.mail.Session;

import com.tjt.dto.MailConnectionproperties;


public class mailConnection {
	
	
	
	

	public Session mailConnect(MailConnectionproperties properties){
		Properties pos=new Properties();
		pos.put("mail.smtp.auth", properties.getAuth());
		pos.put("mail.smtp.starttls.enable", properties.getStarttls());
		pos.put("mail.smtp.host",properties.getHost());
		pos.put("mail.smtp.port",properties.getPort());
		
		Session session=Session.getInstance(pos, new javax.mail.Authenticator(){
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(properties.getUsername(), properties.getMailpassword());
			}
		});
		return session;
	}
}
