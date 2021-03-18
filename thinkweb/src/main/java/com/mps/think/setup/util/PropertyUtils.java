package com.mps.think.setup.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mps.think.process.util.PropertyUtility;

public class PropertyUtils {
	
private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtility.class);
	
	public String getConstantValue(String constantValue)
	{			
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/constantSetup.properties"));
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



}
