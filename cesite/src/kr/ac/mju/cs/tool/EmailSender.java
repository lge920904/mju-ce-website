package kr.ac.mju.cs.tool;


import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender {

	private final static String HOST = "smtp.gmail.com";
    private final static String PORT = "587";
    private final String adminEmail = "noreply-ceunix@administrator.com";
    private final String username = " ";
    private final String password = " ";
 
    public void sendMail (String recipietion, String authenticode) throws IOException {
       
    	System.out.println("mail : "+ recipietion+", "+authenticode);
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", PORT);
 
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(adminEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipietion));
			message.setSubject("메세지전송");
			message.setText(authenticode);
			Transport.send(message);
			System.out.println("sending email");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
}