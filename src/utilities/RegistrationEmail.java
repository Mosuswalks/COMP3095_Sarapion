package utilities;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class RegistrationEmail {
	
	private String emailTemplate = "This is a confirmation of your registration with Sarapion";
	
	private static Properties mailServerProperties;
	private static Session getEmailSession;
	private static MimeMessage generateEmailMessage;
	
	
	public static void sendEmail(String targetEmail, String firstName) throws AddressException, MessagingException{
		
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable","true");
		
		
		getEmailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateEmailMessage = new MimeMessage(getEmailSession);
		generateEmailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail));
		generateEmailMessage.setSubject("Registration Confirmation");
		String emailBody = "<br><br>Hi " + firstName + ",<br><br>" +
						"Thank you for signing up to Sarapion! " + 
						"<br><br> Regards, <br>Admin";
		
		
		generateEmailMessage.setContent(emailBody,"text/html");
		
		Transport transport = getEmailSession.getTransport("smtp");
		
		transport.connect("smtp.gmail.com", "sarapion.bc@gmail.com", "assignment13095");
		transport.sendMessage(generateEmailMessage, generateEmailMessage.getAllRecipients());
		System.out.println("Email Sent");
		transport.close();
		
	}

}
