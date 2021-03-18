/**
 * 
 */
package com.mps.think.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * @author Harmohan
 * General Utility Class
 */
@Repository
public class GeneralUtility 
{	
	private static final Logger log = Logger.getLogger(GeneralUtility.class);
	/**
	 * This Method is used to send mail. Reads the mail.properties file to get sender, recipient and host details
	 * @param subject --> Hold the subject of the mail
	 * @param msg --> Message body
	 * @author Harmohan
	 * @return Null
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws IOException 
	 * @
	 */
	public static boolean sendMail(String subject,String msg) throws AddressException, MessagingException, IOException 
	{
		
				Properties properties = new Properties();
				properties.load(GeneralUtility.class.getResourceAsStream("/mail.properties"));
			    String recipient = properties.getProperty("recipient");
			    String sender = properties.getProperty("sender");
			    String host = properties.getProperty("host");
			    Properties mailproperties = System.getProperties();
			    mailproperties.setProperty("mail.smtp.hostaa", host);
			    Session session = Session.getDefaultInstance(mailproperties);
			    MimeMessage message = new MimeMessage(session);
			    message.setFrom(new InternetAddress(sender));
			    message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			    message.setSubject(subject);
			    message.setContent("<h3>Oops, Think application encountered an error, The details are as below:</h3> <br>"+msg,"text/html");
			    Transport.send(message);
			    log.info("Mail successfully sent");
			    return true;
			    
		
		    
		      
		    
	}

}
