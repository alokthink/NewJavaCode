package com.mps.think.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mps.think.model.CustomerAuxiliaryModel;

public class PropertyUtilityClass 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtilityClass.class);
	
	public String getConstantValue(String constantValue)
	{			
		Properties properties=new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/constant.properties"));
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
	
	/*
	 * This method is used for date formatting.
	 * Date formate (MM/dd/yyyy) 
	 * 
	 * */
	public String getDateFormatter(String date){
		String finalDate = "";
		try{
			Date parseDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			DateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
			finalDate = formater.format(parseDate);			
		}
		catch(Exception e)
		{
			LOGGER.info("getDateFormatter : "+e.getMessage());
			try {
				GeneralUtility.sendMail("issue in date format", e.getMessage());
			}
			catch (AddressException ae) {
			
				LOGGER.error("AddressException while Sending mail", ae);
			} catch (MessagingException me) {
				
				LOGGER.error("MessagingException while Sending mail", me);
			} catch (IOException ie) {
				
				LOGGER.error("IOException while Sending mail", ie);
			}
		}
		
		return finalDate;
	}
	
	public Date dateFormatter(String date){
		Date finalDate = null ;
		try{
			if(date!=null){
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			finalDate = formatter.parse(date);
			}
		}catch(Exception e){
			LOGGER.info("dateFormatter : "+e);
		}
		
		return finalDate;
	}
	
	/* Itee Gupta
	 * Use this method to save date in (yyyy-MM-dd) this format which return date in String
	 */
	public String saveDateFormatter(String date){
		String finalDate = null ;
		 
		try{
			if(date!=null){
//			SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
//			SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			SimpleDateFormat inSDF = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd");
			Date invDate = inSDF.parse(date);
			finalDate = outSDF.format(invDate);
			}
		}catch(Exception e){
			LOGGER.info("dateFormatter : "+e);
		}
		
		return finalDate;
	}
	public String getAmount(String amount) {
		String numberAsString=null;
		try {
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
        numberAsString = decimalFormat.format(amount);
        System.out.println(numberAsString);
		}catch(Exception e){
			LOGGER.info("AmountFormatter : "+e);
		}
		return numberAsString;
		
	}
	
	public Map<String,String> dynamicHeader(String currency){
		 Map<String,String> tableHeaders = new LinkedHashMap<String,String>();
		 	tableHeaders.put("Order","orderCode"); 
         tableHeaders.put("Order Date","orderDate"); 
         tableHeaders.put("Order Code","orderCodeId"); 
         tableHeaders.put("Bill to","billToCustomerId"); 
         tableHeaders.put("Recipient","customerId"); 
         tableHeaders.put("Qty","orderQty"); 
         tableHeaders.put("Currency","currency"); 
         tableHeaders.put("Charged","grossLocalAmount"); 
         tableHeaders.put("Due","netBaseAmount");
         
         switch (currency) 
	        {
	        case "GBP": 
			            tableHeaders.put("Pay","netLocalAmount"); 
	                    break;
			case "EUR": 
				        tableHeaders.put("Due"+ "("+currency+")","netLocalAmount"); 
				        tableHeaders.put("Pay"+ "("+currency+")","netLocalAmount"); 
			           
	                    break;
			case "USD": 
				        tableHeaders.put("Due"+ "("+currency+")","netLocalAmount"); 
			            tableHeaders.put("Pay"+ "("+currency+")","netLocalAmount"); 
	                    break;
	        }
         return tableHeaders;
	}
	
	
		//Added by Sohrab for fixing THINKDEV-561,565,610,611,615
		public static String getDateInDesiredFormat(String dateInput,DateFormat inputFormat,DateFormat outputFormat)
		{
			String resultDate=null;
			try
			{
				Date date = inputFormat.parse(dateInput);
				resultDate= outputFormat.format(date);  
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return resultDate;
		}
		
		
		//Added by Sohrab for fixing THINKDEV-610,611,615
		public static String getDateAfterAddingDays(String oldDate,DateFormat sdf,int numberOfDays)
		{
			Calendar c = Calendar.getInstance();
			String newDate ="";
			try 
			{
				c.setTime(sdf.parse(oldDate));
				c.add(Calendar.DAY_OF_MONTH, numberOfDays);  
				newDate = sdf.format(c.getTime());
			} catch(Exception e) 
			{
				e.printStackTrace();
			}
			return newDate;
		}
		
		
		//Added by Sohrab for fixing THINKDEV-610,611,615
		public static int getActualMaximumDays(int input,Calendar cal)
		{
		    int maxDays = cal.getActualMaximum(input);
			return maxDays;
		}
		
		
		//Added by Sohrab for fixing THINKDEV-610,611,615
		public static int addNumberOfYearsInCurrentYearAndProvideTotalNumberOfDays(String start_date,int num_of_years_to_add)
		{
			String start_date_array[]=start_date.split("/");
			int current_year=Integer.parseInt(start_date_array[2]);
			int next_year=current_year+1;
			int totalNumberOfDays=0;
			for(int i=1;i<=num_of_years_to_add;i++)
			{
				totalNumberOfDays=totalNumberOfDays+Year.of(next_year).length();
				next_year++;
			}
			return totalNumberOfDays;
		}
		
		
		//Added by Sohrab for fixing THINKDEV-610,611,615
		public static int addNumberOfMonthsInCurrentMonthAndProvideTotalNumberOfDays(String start_date,int num_of_months_to_add)
		{
			String start_date_array[]=start_date.split("/");
			int current_year=Integer.parseInt(start_date_array[2]);
			int current_month=Integer.parseInt(start_date_array[0]);
			int totalNumberOfDays=0;
			for(int i=1;i<=num_of_months_to_add;i++)
			{
				totalNumberOfDays=totalNumberOfDays+Month.of(current_month).length(Year.isLeap(current_year));
				current_month++;
				if(current_month>12)
				{
					current_month=1;
					current_year++;
				}
			}
			return totalNumberOfDays;
		}


				
		public String getCurrentDateDDMMYY() {
			 String strDate = null;
			 Date date = new Date();  
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			 strDate= formatter.format(date); 
			 
			 return strDate;
		 }
		/* This is for auxiliary fields to set default date for date picker
		 * If data type is date then it appends current date if and only if default value is null
		 */
		public void appendDefaultDateInAuxiliaryFields(List<CustomerAuxiliaryModel> auxiliaryFormField) {
			for(int i=0;i<auxiliaryFormField.size();i++) {
				if(auxiliaryFormField.get(i).getColumnDatatype().equalsIgnoreCase("Date") ) {
					if(auxiliaryFormField.get(i).getDefaultValue() == null) {
						auxiliaryFormField.get(i).setDefaultValue(new CustomerUtility().getCurrentDateYYMMDD());
					}
				}
			}
			
		}
		public String removeZeroFromAuxiliary(String value) {
			String finalValue = null;
			double number = Double.parseDouble(value);
			int integer = (int)number;
			double decimal = (10 * number - 10 * integer)/10;
			//double temp =  Math.round(decimal*100.0)/100.0;
			double temp =  (decimal*100.0)/100.0;
			if(temp != 0) {//if temp is not equal to 0.0...
				Double actualValue = new Double(integer);
				actualValue = actualValue + temp;
				finalValue = String.valueOf(actualValue);
			}else {
				finalValue = String.valueOf(integer);
			}
			return finalValue;
		}
	public String getCurrentDateTime() {
		LocalDate date = LocalDate.now();
		String time = LocalTime.now().toString();
		String trimedTime = time.substring(0, time.indexOf("."));
		String finalDate = date+" "+trimedTime; 
		System.out.println("creation_date: "+finalDate);
		return finalDate;
	}
}
