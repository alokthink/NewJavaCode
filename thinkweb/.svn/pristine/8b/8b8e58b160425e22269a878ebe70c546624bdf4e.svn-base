package com.mps.think.util;

import java.rmi.RemoteException;
import java.security.spec.KeySpec;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;
import org.tempuri.CryptoServiceLocator;
import org.tempuri.CryptoServiceSoap;

import com.mps.think.model.CustomerAddAttributeModel;
import com.mps.think.option.model.EditTrail;

@Repository
public class CustomerUtility {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerUtility.class);
	private static String secretKey = "thkCustService";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public long getmaxDateStamp() throws SQLException {
		Long dateStamp = jdbcTemplate.queryForObject("select max(date_stamp) as date_stamp from date_stamp", Long.class);
		if(dateStamp==null)
			dateStamp=(long) 1;
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
	
	public String getName() throws SQLException {
		String name = jdbcTemplate.queryForObject("select concat(user_code.user_code,' - ',name) as name from document_reference left join user_code on user_code.user_code = document_reference.user_code where document_reference_id=(select bypass_doc_ref_id from config)", String.class);
		return name;
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
		if(getStringValue(customerAddAttributeModel.getCompany())!=null) {
			String[] company = customerAddAttributeModel.getCompany().split(" ");
			for(int i = 0; i < company.length; i++) {
	            if(i==0 && !"".equals(company[i].trim()))
	            	matchcode.append(company[i].length()>=2?company[i].substring(0,2):company[i].substring(0,1)); 
	            if(i==1 && !"".equals(company[i].trim()))
	            	matchcode.append(company[i].length()>=2?company[i].substring(0,2):company[i].substring(0,1));  
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
		 public String getCurrentDateYYMMDDWithTime(String date) {
			 
			 String finalDate = "";
				try{
					Date parseDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
					DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
					finalDate = formater.format(parseDate);	
					LocalTime time = LocalTime.now();
					finalDate = finalDate+" "+time;
				}catch (Exception e) {
					e.printStackTrace();
				}
				return finalDate;
		 } 
		 /**
		  * To formate table's date into MM/dd/yyyy
		  * @author Chaman.Bharti
		  */
		 Predicate<String> isNullOrEmpty = s-> s != null && !s.trim().isEmpty();
		 public String getFormattedDate(String date) {
			 String formattedDate = null;
			 try {
				  if(isNullOrEmpty.test(date)) {
					Date parseDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
					DateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
					formattedDate = formater.format(parseDate);	
				  }
			} catch (Exception e) {
				e.printStackTrace();
			}
			 return formattedDate;
		 }
		 /**
		  * To insert into edit trail table
		  * @author Chaman.Bharti
		  */
		 //To find out 'public int saveEditTrail(EditTrail editTrail' inside OrderPaymentDaoImpl for edit trail table
		 public long saveEditTrail(EditTrail editTrail) {
				Map<String, Object>addSourceParams = new HashMap<>();
				long maxEditTrailId = 0; 
				int status = 0;
				StringBuilder query = new StringBuilder("insert into edit_trail(edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,");
				query.append("order_item_seq,order_item_amt_break_seq,edited,currency,table_enum,document_reference_id,document_reference_seq,local_amount,");
				query.append("base_amount,date_stamp,creation_date,xaction_name,payment_seq,demographic_seq,job_id,service_seq) ");
				query.append("values(:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,");
				query.append(":order_item_seq,:order_item_amt_break_seq,:edited,:currency,:table_enum,:document_reference_id,:document_reference_seq,");
				query.append(":local_amount,:base_amount,:date_stamp,GETDATE(),:xaction_name,:payment_seq,:demographic_seq,:job_id,:service_seq)");
				 
				try {
					 maxEditTrailId = getmaxeditTrailId() + 1;
					 addSourceParams.put("edit_trail_id", maxEditTrailId);  
					 addSourceParams.put("customer_id", editTrail.getCustomerId()!=null?editTrail.getCustomerId():null); 
					 addSourceParams.put("customer_address_seq", editTrail.getCustomerAddressSeq()!=null?editTrail.getCustomerAddressSeq():null); 
					 addSourceParams.put("user_code", editTrail.getUserCode()); 
					 addSourceParams.put("subscrip_id", editTrail.getSubscripId()!=null?editTrail.getSubscripId():null); 
					 addSourceParams.put("orderhdr_id", editTrail.getOrderhdrId()!=null?editTrail.getOrderhdrId():null); 
					 addSourceParams.put("order_item_seq", editTrail.getOrderItemSeq()!=null?editTrail.getOrderItemSeq():null); 
					 addSourceParams.put("order_item_amt_break_seq", editTrail.getOrderItemAmtBreakSeq()!=null?editTrail.getOrderItemAmtBreakSeq():null); 
					 addSourceParams.put("edited", editTrail.getEdited()!=null?editTrail.getEdited():0); 
					 addSourceParams.put("currency", editTrail.getCurrency()!=null?editTrail.getCurrency():null); 
					 addSourceParams.put("table_enum", editTrail.getTableEnum()!=null?editTrail.getTableEnum():null); 
					 addSourceParams.put("document_reference_id", editTrail.getDocumentReferenceId()); 
					 addSourceParams.put("document_reference_seq", editTrail.getDocumentReferenceSeq()!=null?editTrail.getDocumentReferenceSeq():null); 
					 addSourceParams.put("local_amount", editTrail.getLocalAmount()!=null?editTrail.getLocalAmount():0.0); 
					 addSourceParams.put("base_amount", editTrail.getBaseAmount()!=null?editTrail.getBaseAmount():0.0); 
					 addSourceParams.put("date_stamp", getmaxDateStamp()); 
					// addSourceParams.put("creation_date", editTrail.getCreationDate()!=null?editTrail.getCreationDate():null); 
					 addSourceParams.put("xaction_name",editTrail.getXactionName()); 
					 addSourceParams.put("payment_seq", editTrail.getPaymentSeq()!=null?editTrail.getPaymentSeq():null); 
					 addSourceParams.put("demographic_seq", editTrail.getDemographicSeq()!=null?editTrail.getDemographicSeq():null); 
					 addSourceParams.put("job_id", editTrail.getJobId()!=null?editTrail.getJobId():null); 
					 addSourceParams.put("payment_account_seq", editTrail.getPaymentAccountSeq()!=null?editTrail.getPaymentAccountSeq():null); 
					 addSourceParams.put("service_seq", editTrail.getServiceSeq()!=null?editTrail.getServiceSeq():null); 
					 status = namedParameterJdbcTemplate.update(query.toString(), addSourceParams);
					 if(status>0) {
						 updateMruEditTrailId(maxEditTrailId);
						}
				}catch (Exception e) {
					LOGGER.error("ERROR" + e);
					e.printStackTrace();
				}
				return maxEditTrailId;
			}
		 /**
		  * To insert into edit trail delta table using batch if you have to insert record more than one
		  * @author Chaman.Bharti
		  */
		 public void insertEditTrailDeltaByBatch(List<EditTrail> list, long edit_trail_id) throws SQLException{
			 List<EditTrail> listToInsert = new ArrayList<>(list.size());
			 long editTrailId = edit_trail_id;
			 try {
					for(EditTrail m:list) {
						EditTrail model = new EditTrail();
						model.setEditTrailId(editTrailId);
						model.setColumnName(m.getColumnName());
						model.setBeforeChange(m.getBeforeChange());
						model.setAfterChange(m.getAfterChange());
						listToInsert.add(model);
					}
					StringBuilder query = new StringBuilder("INSERT INTO edit_trail_delta (");
					query.append("edit_trail_id,column_name,before_change,after_change) ");
					query.append("VALUES (:editTrailId,:columnName,:beforeChange,:afterChange)");
					SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(listToInsert.toArray());
					//int[] updateCounts = namedParameterJdbcTemplate.batchUpdate(query.toString(), batch);
					namedParameterJdbcTemplate.batchUpdate(query.toString(), batch);
			} catch (Exception e) {
				LOGGER.error("ERROR" + e);
				e.printStackTrace();
			}
			}
		 
		 public void updateMruPromotionCardId(long id) throws SQLException {
				Map<String, Object> parameters = new HashMap<String, Object>();
				String  mruPromotionCardQuery="update mru_promotion_card_id set id = :id";
				parameters.put("id", id);
				namedParameterJdbcTemplate.update(mruPromotionCardQuery, parameters);
			}

}
