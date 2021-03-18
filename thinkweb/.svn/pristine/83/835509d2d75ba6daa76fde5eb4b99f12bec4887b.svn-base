package com.mps.think.util;

import static org.junit.Assert.assertFalse;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) 
public class GeneralUtilityTest {
	private static final Logger log=Logger.getLogger(GeneralUtility.class);  

	@Test
	public final void testSendMail() 
	{
	
		try
		{
			
			GeneralUtility.sendMail("Build Test Mail","Test mail for checking mail configuration working");
			assertFalse(false);
		} 
		catch (AddressException e) {
			assertFalse(true);
			log.error("AddressException while Sending mail", e);
		} catch (MessagingException e) {
			assertFalse(true);
			log.error("MessagingException while Sending mail", e);
		} catch (IOException e) {
			assertFalse(true);
			log.error("IOException while Sending mail", e);
		}
		
	}

}
