package com.tjt.util;

import java.util.Properties;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Value;




public class mailConnection {
	
	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String mailpassword;
	
	@Value("${host}")
	private String host;
	
	@Value("${port}")
	private String port;
	
	@Value("${starttls}")
	private String starttls;
	
	@Value("${auth}")
	private String auth;
	
	

	public Session mailConnect(String userName,String password){
		
		System.out.println(" stsyemmmmm  "+host );
		
		System.out.println(" stsyemmmmm  "+starttls +" "+ port+" "+username);
		Properties pos=new Properties();
		pos.put("mail.smtp.auth", auth);
		pos.put("mail.smtp.starttls.enable", starttls);
		pos.put("mail.smtp.host",host);
		pos.put("mail.smtp.port",port);
		System.out.println(port +" "+host+" "+username);
		Session session=Session.getInstance(pos, new javax.mail.Authenticator(){
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(username, mailpassword);
			}
		});
		return session;
	}
}
