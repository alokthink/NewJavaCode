package com.mps.think.process.util;

import java.io.IOException;
import java.util.Properties;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtility {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtility.class);
	
	public String getConstantValue(String constantValue)
	{			
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/constantProcess.properties"));
		} 
		catch (IOException e) {
		
		}
							
		return properties.getProperty(constantValue);
	}
	
	public String getQuery(String query)
	{			
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
		} 
		catch (IOException e) {
		
		}
							
		return properties.getProperty(query);
	}


	public static Boolean validateCreditCardNumber(String str) {

		int[] ints = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			ints[i] = Integer.parseInt(str.substring(i, i + 1));
		}
		for (int i = ints.length - 2; i >= 0; i = i - 2) {
			int j = ints[i];
			j = j * 2;
			if (j > 9) {
				j = j % 10 + 1;
			}
			ints[i] = j;
		}
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		if (sum % 10 == 0) {
		return true;
		} else {
			return false;
		}
	}
	
	public static enum PAY_CCTYPE{
		// payment_type.credit_card_type
		PAY_CCTYPE_NA,
		PAY_CCTYPE_VISA,
		PAY_CCTYPE_MASTERCARD,
		PAY_CCTYPE_AMEX,
		PAY_CCTYPE_DISCOVER,
		PAY_CCTYPE_OTHER,
		PAY_CCTYPE_SOLO,
		PAY_CCTYPE_SWITCH,
		PAY_CCTYPE_VALUE_LINK,
	} 
	
}
