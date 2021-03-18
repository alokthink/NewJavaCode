package com.mps.think.orderFunctionality.daoImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.orderFunctionality.dao.PaymentFunctionalityDao;

@Repository
public class PaymentFunctionalityDaoImp  implements PaymentFunctionalityDao {
	
	private SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat formatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatYYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error"; 

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate; 
		
	@Override
	public List<Map<String, Object>> getGatewayLogCustomer(int customerId){
		List<Map<String, Object>> gatewayLogCustomerList = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(" select ics_ref_num,CONVERT(VARCHAR(10), trans_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), trans_date, 22), 11)) as trans_date,"
					+ " trans_name,trans_status,trans_message,return_codes,full_request,full_response,auth_code,auth_reconcilistionID,credit_reconcilistionID,payment_reconcilistionID,"
					+ " credit_card_address_seq,credit_card_customer_id,payment_seq,customer_id,ics_bank_def_id,amount,currency from ics_response "
					+ " where customer_id="+ customerId +" and payment_seq is null ");
			gatewayLogCustomerList = jdbcTemplate.queryForList(query.toString());
			for(Map<String, Object> gatewayLogCustomer : gatewayLogCustomerList){
				if(gatewayLogCustomer.get("trans_message") == null){
					gatewayLogCustomer.put("trans_message", "");
				}
				if(gatewayLogCustomer.get("return_codes") == null){
					gatewayLogCustomer.put("return_codes", "");
				}
				if(gatewayLogCustomer.get("full_response") == null){
					gatewayLogCustomer.put("full_response", "");
				}
				if(gatewayLogCustomer.get("auth_code") == null){
					gatewayLogCustomer.put("auth_code", "");
				}
				if(gatewayLogCustomer.get("auth_reconcilistionID") == null){
					gatewayLogCustomer.put("auth_reconcilistionID", "");
				}
				if(gatewayLogCustomer.get("credit_reconcilistionID") == null){
					gatewayLogCustomer.put("credit_reconcilistionID", "");
				}
				if(gatewayLogCustomer.get("payment_reconcilistionID") == null){
					gatewayLogCustomer.put("payment_reconcilistionID", "");
				}
				if(gatewayLogCustomer.get("credit_card_address_seq") == null){
					gatewayLogCustomer.put("credit_card_address_seq", "");
				}
				if(gatewayLogCustomer.get("credit_card_customer_id") == null){
					gatewayLogCustomer.put("credit_card_customer_id", "");
				}
				if(gatewayLogCustomer.get("payment_seq") == null){
					gatewayLogCustomer.put("payment_seq", "");
				}
				if(gatewayLogCustomer.get("amount") == null){
					gatewayLogCustomer.put("amount", "");
				}
				if(gatewayLogCustomer.get("currency") == null){
					gatewayLogCustomer.put("currency", "");
				}
			}
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return gatewayLogCustomerList;
	}
	
	@Override
	public List<Map<String, Object>> getGatewayLogSelectedPayment(int customerId, int paymentSeq){
		List<Map<String, Object>> gatewayLogCustomerList = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(" select ics_ref_num,CONVERT(varchar, trans_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(varchar, trans_date, 22), 11)) as trans_date,"
					+ " trans_name,trans_status,trans_message,return_codes,full_request,full_response,auth_code,auth_reconcilistionID,credit_reconcilistionID,payment_reconcilistionID,"
					+ " credit_card_address_seq,credit_card_customer_id,payment_seq,customer_id,ics_bank_def_id,amount,currency from ics_response "
					+ " where customer_id="+ customerId +" and payment_seq="+ paymentSeq);
			gatewayLogCustomerList = jdbcTemplate.queryForList(query.toString());
			for(Map<String, Object> gatewayLogCustomer : gatewayLogCustomerList){
				if(gatewayLogCustomer.get("trans_message") == null){
					gatewayLogCustomer.put("trans_message", "");
				}
				if(gatewayLogCustomer.get("return_codes") == null){
					gatewayLogCustomer.put("return_codes", "");
				}
				if(gatewayLogCustomer.get("full_response") == null){
					gatewayLogCustomer.put("full_response", "");
				}
				if(gatewayLogCustomer.get("auth_code") == null){
					gatewayLogCustomer.put("auth_code", "");
				}
				if(gatewayLogCustomer.get("auth_reconcilistionID") == null){
					gatewayLogCustomer.put("auth_reconcilistionID", "");
				}
				if(gatewayLogCustomer.get("credit_reconcilistionID") == null){
					gatewayLogCustomer.put("credit_reconcilistionID", "");
				}
				if(gatewayLogCustomer.get("payment_reconcilistionID") == null){
					gatewayLogCustomer.put("payment_reconcilistionID", "");
				}
				if(gatewayLogCustomer.get("credit_card_address_seq") == null){
					gatewayLogCustomer.put("credit_card_address_seq", "");
				}
				if(gatewayLogCustomer.get("credit_card_customer_id") == null){
					gatewayLogCustomer.put("credit_card_customer_id", "");
				}
				if(gatewayLogCustomer.get("payment_seq") == null){
					gatewayLogCustomer.put("payment_seq", "");
				}
				if(gatewayLogCustomer.get("amount") == null){
					gatewayLogCustomer.put("amount", "");
				}
				if(gatewayLogCustomer.get("currency") == null){
					gatewayLogCustomer.put("currency", "");
				}
			}
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
		}
		return gatewayLogCustomerList;
	}
	
	@Override
	  public int deleteGatewayLog(String icsRefNum) {
		int Status = 0;
		try{
			StringBuilder gatewayLog = new StringBuilder("delete from ics_response where ics_ref_num='"+icsRefNum+"'");
			Status = jdbcTemplate.update(gatewayLog.toString());
			
		} catch(Exception e){
			LOGGER.error(ERROR + e);
		}
		return Status;
	  }
}




