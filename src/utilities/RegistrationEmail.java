/******************************************************************************************************
 * Project: Sarapion
 * Assignment: 1
 * Author: Mohamed Abdi, Carol Hung, Kevin Ly, ZhiRun Yulu
 * Student Numbers: 100-649-804, 101-019-479, 101-082-639, 101-065-994
 * Date: October 28 2018
 * Description: This file contains the Email Class responsible for sending out registration confirmation emails.

********************************************************************************************************/

package utilities;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class RegistrationEmail {
	
	
	private static Properties mailServerProperties;
	private static Session getEmailSession;
	private static MimeMessage generateEmailMessage;
	
	
	public static void sendEmail(String targetEmail, String firstName, String lastName) throws AddressException, MessagingException{
		
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable","true");
		
		
		getEmailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateEmailMessage = new MimeMessage(getEmailSession);
		generateEmailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail));
		generateEmailMessage.setSubject("Registration Confirmation");
		String emailBody = "<br><br>Hi " + firstName + " " + lastName + ",<br><br>" +
						"Thank you for signing up to Sarapion! " + 
						"<br><br> "
						+ "You are recieving this email because the email " + targetEmail + ", was provided for verification."
						+ "<br><br>"
						+ "Regards, <br>Admin";
		
		
		generateEmailMessage.setContent(emailBody,"text/html");
		
		Transport transport = getEmailSession.getTransport("smtp");
		
		transport.connect("smtp.gmail.com", "sarapion.bc@gmail.com", "assignment13095");
		transport.sendMessage(generateEmailMessage, generateEmailMessage.getAllRecipients());
		transport.close();
		
	}

}
