package com.bschool.chats.bschoolAndroid.resources;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
	
	public static void sendEmail1(String message, String subject, String to, String from, String password) {
		
		//Variable for gmail host
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		
		//Host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//Get the session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		
			
		
	});
		
		//Compose message
		MimeMessage msg = new MimeMessage(session);
		
		try {
			msg.setFrom(from);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			
			//Send the message using transport
			Transport.send(msg);
			System.out.println("Email sent");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	// adding recipients
	
	
	
}
