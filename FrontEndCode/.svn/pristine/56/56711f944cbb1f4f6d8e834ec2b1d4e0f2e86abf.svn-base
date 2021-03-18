package com.mps.think.util;

import java.rmi.RemoteException;
import java.security.spec.KeySpec;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.tempuri.CryptoServiceLocator;
import org.tempuri.CryptoServiceSoap;

import com.mps.think.model.CustomerAddAttributeModel;

@Repository
public class CustomerUtility {
	
	private static String secretKey = "thkCustService";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public long getmaxDateStamp() throws SQLException {
		Long dateStamp = jdbcTemplate.queryForObject("select max(date_stamp) from date_stamp", Long.class);
		if(dateStamp==null)
			dateStamp=(long) 0;
		return dateStamp;
	}
	
	public int getcurrentDateStampCount() throws SQLException {
		int count = jdbcTemplate.queryForObject("select count(*) from date_stamp where  Month(creation_date) = Month('"+new SimpleDateFormat("yyyy/MM/dd").format(new Date())+"') " + 
				"AND Year(creation_date) = Year('"+new SimpleDateFormat("yyyy/MM/dd").format(new Date())+"') " + 
				"AND DAY(creation_date)=DAY('"+new SimpleDateFormat("yyyy/MM/dd").format(new Date())+"')", Integer.class);
		return count;
    }
	
	public void insertDateStamp(Long dateStampId) throws SQLException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String dateStampQuery= "Insert INTO date_stamp " +
				"(date_stamp,creation_date) VALUES " +
				"(:date_stamp,:creation_date)";
		parameters.put("date_stamp", dateStampId+1);
		parameters.put("creation_date", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		namedParameterJdbcTemplate.update(dateStampQuery, parameters);
		
   }
	
	public Long getDocumentReferenceId() throws SQLException {
		Long documentReferenceId = jdbcTemplate.queryForObject("select bypass_doc_ref_id from config;", Long.class);
		return documentReferenceId;
   }
	
	public long getMaxEventQueueId() throws SQLException {
		//Long eventQueueId = jdbcTemplate.queryForObject("select max(event_queue_id) from event_queue", Long.class);
		Long eventQueueId = jdbcTemplate.queryForObject("select id from mru_event_queue_id", Long.class);
		if(eventQueueId==null)
			eventQueueId=(long) 0;
		return eventQueueId;
	}
	
	public void updateEventQueueId(long eventQueueId) throws SQLException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String  mruEventQueueQuery="update mru_event_queue_id set id = :id";
		parameters.put("id", eventQueueId);
		namedParameterJdbcTemplate.update(mruEventQueueQuery, parameters);
	}
	public long getmaxeditTrailId() throws SQLException {
		//Long editTrailId = jdbcTemplate.queryForObject("select max(edit_trail_id) from mru_edit_trail_id", Long.class);
		Long editTrailId = jdbcTemplate.queryForObject("select id from mru_edit_trail_id", Long.class);
		if(editTrailId==null)
			editTrailId=(long) 0;
		return editTrailId;
	}
	
	public void updateMruEditTrailId(long editTrailId) throws SQLException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String  mruEditTrialQuery="update mru_edit_trail_id set id = :id";
		parameters.put("id", editTrailId);
		namedParameterJdbcTemplate.update(mruEditTrialQuery, parameters);
	}
	
	public void insertEditTrailDelta(long editTrailId, String columnName,Object before, Object after) throws SQLException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String  editTrialDeltaQuery="INSERT INTO edit_trail_delta " +
						"(edit_trail_id,column_name,before_change,after_change) VALUES " +
						"(:edit_trail_id,:column_name,:before_change,:after_change)";
		parameters.put("edit_trail_id", editTrailId);
		parameters.put("column_name", columnName);
		parameters.put("before_change", "".equals(before)?null:before);
		parameters.put("after_change", "".equals(after)?null:after);
		namedParameterJdbcTemplate.update(editTrialDeltaQuery, parameters);
	}
	
	public StringBuilder getmatchCode(CustomerAddAttributeModel customerAddAttributeModel) throws RuntimeException {
		
		StringBuilder matchcode = new StringBuilder();
		if(getStringValue(customerAddAttributeModel.getlName())!=null)
			matchcode.append(customerAddAttributeModel.getlName().length()>=2?customerAddAttributeModel.getlName().substring(0, 2):customerAddAttributeModel.getlName().substring(0, 1));
		
		if(getStringValue(customerAddAttributeModel.getfName())!=null)
			matchcode.append(customerAddAttributeModel.getfName().length()>=4?customerAddAttributeModel.getfName().substring(3, 4):"");
		
		if(getStringValue(customerAddAttributeModel.getfName())!=null)
			matchcode.append(customerAddAttributeModel.getfName().substring(0, 1));
		
		if(getStringValue(customerAddAttributeModel.getAddress1())!=null) {
			String[] address1 = customerAddAttributeModel.getAddress1().split(" ");
			for(int i = 0; i < address1.length; i++) {
	            if(i==0 && !"".equals(address1[i].trim()))
	            	matchcode.append(address1[i].length()>=2?address1[i].substring(0,2):address1[i].substring(0,1)); 
	            if(i==1 && !"".equals(address1[i].trim()))
	            	matchcode.append(address1[i].substring(0,1)); 
	            if(i==2 && !"".equals(address1[i].trim()))
	            	matchcode.append(address1[i].length()>=2?address1[i].substring(0,2):address1[i].substring(0,1)); 
	            if(i==3 && !"".equals(address1[i].trim()))
	            	matchcode.append(address1[i].substring(0,1));
	        }   	
		}		
		return matchcode;
	}
	
	public String getdocumentReferenceDialogue() throws SQLException {
			String documentReferenceId = jdbcTemplate.queryForObject("select bypass_doc_ref_dlg from config",String.class);
			return documentReferenceId;
	}
	
	public String getStringValue(String string) throws RuntimeException {
		if(string == null || "".equals(string)) {
			return null;
		}else {
			return string;
		}	
	}
	
	public String getString(String string) throws RuntimeException {
		if(string == null || "".equals(string)) {
			return "";
		}else {
			return string;
		}	
	}
	
	 
	public String encrypt(String strToEncrypt, int salt)
	{
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	        String b1 = String.valueOf(salt);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), b1.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}
	
	public String decrypt(String strToDecrypt, int salt) {
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	        
	        String b1 = String.valueOf(salt);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), b1.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    }
	    catch (Exception e) {
	        System.out.println("Error while decrypting: " + e.toString());
	    }
	    return null;
	}
	
	 public int toLongIpNumber(String ipAddress) {
		 
	        if (ipAddress == null || ipAddress.isEmpty()) {
	            throw new IllegalArgumentException("IPV4 address cannot be null or empty");
	        }
	        String[] octets = ipAddress.split(java.util.regex.Pattern.quote("."));
	        if (octets.length != 4) {
	            throw new IllegalArgumentException("invalid IPV4 address");
	        }
	        int ip = 0;
	        for (int i = 3; i >= 0; i--) {
	            long octet = Long.parseLong(octets[3 - i]);
	            if (octet > 255 || octet < 0) {
	                throw new IllegalArgumentException("invalid ip address");
	            }
	            ip |= octet << (i * 8);
	        }
	        return ip;
	    }
	 
	 public  long toLongIPV6Number(String addr) {
		    String[] addrArray = addr.split(":");
		    long[] num = new long[addrArray.length];

		    for (int i=0; i<addrArray.length; i++) {
		        num[i] = Long.parseLong(addrArray[i], 16);
		    }
		    long long1 = num[0];
		    for (int i=1;i<4;i++) {
		        long1 = (long1<<16) + num[i];
		    }
		    long long2 = num[4];
		    for (int i=5;i<8;i++) {
		        long2 = (long2<<16) + num[i];
		    }

		    long[] longs = {long2, long1};
			long actualLongs = 0L;
			for(long value : longs) {
				actualLongs= actualLongs + value;
			}
			return actualLongs;
		}
	 
	 
	 public String getCurrentFormattedDate() {
		 String strDate = null;
		 Date date = new Date();  
		 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		 strDate= formatter.format(date); 
		 
		 return strDate;
	 }
	 public String getCurrentDateDDMMYY() {
		 String strDate = null;
		 Date date = new Date();  
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		 strDate= formatter.format(date); 
		 
		 return strDate;
	 }
	 public String getCurrentDateYYMMDD() {
		 String strDate = null;
		 Date date = new Date();  
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		 strDate= formatter.format(date); 
		 
		 return strDate;
	 }
	 
	 public void runTruncate(JdbcTemplate jdbcTemplate) {
		 try {
			   //jdbcTemplate.update("truncate table edit_trail_delta;truncate table edit_trail;truncate table event_queue;");
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 public long getMaxJournalId() throws SQLException {
			Long journalId = jdbcTemplate.queryForObject("select id from mru_journal_id", Long.class);
			if(journalId==null)
				journalId=(long) 0;
			return journalId;
		}
		
		public void updateJournalId(long journalId) throws SQLException {
			Map<String, Object> parameters = new HashMap<String, Object>();
			String  mruJournalQuery="update mru_journal_id set id = :id";
			parameters.put("id", journalId);
			namedParameterJdbcTemplate.update(mruJournalQuery, parameters);
		}
		 public long getMaxJournalDepositId() throws SQLException {
				Long journalDepositId = jdbcTemplate.queryForObject("select id from mru_journal_deposit_id", Long.class);
				if(journalDepositId==null)
					journalDepositId=(long) 0;
				return journalDepositId;
			}
			
			public void updateJournalDepositId(long journalDepositId) throws SQLException {
				Map<String, Object> parameters = new HashMap<String, Object>();
				String  mruJournalDepositQuery="update mru_journal_deposit_id set id = :id";
				parameters.put("id", journalDepositId);
				namedParameterJdbcTemplate.update(mruJournalDepositQuery, parameters);
			}
		 public String decryptedCardNumber(String cardNumber) {
			 CryptoServiceSoap soap = null;
			 CryptoServiceLocator locator = new CryptoServiceLocator();
			 String accountNumber = null;
				try {
					soap = locator.getCryptoServiceSoap();
					Predicate<String> isNotNull = str -> !(str.equals("") || str.equalsIgnoreCase("null"));
					if(isNotNull.test(cardNumber)) {
						accountNumber = soap.decryption(cardNumber);
					}else {                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
						accountNumber= "InvalidCardNumber";
					}
					
				}catch (ServiceException | RemoteException e) {
					e.printStackTrace();
				}
				
			 return accountNumber;
		 }
		 

}
