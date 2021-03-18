package com.mps.think.daoImpl;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.dao.OrderPaymentDao;
import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.option.model.EditTrail;
import com.mps.think.option.model.Journal;
import com.mps.think.option.model.Paybreak;
import com.mps.think.option.model.Payment;
import com.mps.think.option.model.PaymentReversedPayment;
import com.mps.think.option.model.SupplementalRefund;
import com.mps.think.resultMapper.CustomerAuxiliaryMapper;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
@Repository
public class OrderPaymentDaoImpl implements OrderPaymentDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderPaymentDaoImpl.class);
	private static final String ERROR = "Error"; 
	private SimpleDateFormat formatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat formatDDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat formatYYYYMMDDHHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private CustomerUtility customerUtility;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Override
	public List<Map<String, Object>> getSupplementalRefundDetails(Integer orderHdrId, Integer orderItemSeq) {
		List<Map<String, Object>> supplementalRefundDetails = null;//new ArrayList<>();
		String localAmount = null;
		String payCurrencyAmout = null;
		try {
				boolean localAmountFlage = false;
				String cardNumber = null;
				supplementalRefundDetails = jdbcTemplate.queryForList(fetchQuery(orderHdrId, orderItemSeq, localAmountFlage));
				if(supplementalRefundDetails.size() != 0) {
				String currency = supplementalRefundDetails.get(0).get("currency")!=null?supplementalRefundDetails.get(0).get("currency").toString():null;
				Integer customerId = supplementalRefundDetails.get(0).get("customer_id")!=null?(Integer) supplementalRefundDetails.get(0).get("customer_id"):null;
				String customerName = supplementalRefundDetails.get(0).get("customer_name")!=null?supplementalRefundDetails.get(0).get("customer_name").toString():null;
				//String id_nbr = supplementalRefundDetails.get(0).get("id_nbr")!=null?supplementalRefundDetails.get(0).get("id_nbr").toString():null;
				String payment_type = supplementalRefundDetails.get(0).get("payment_type")!=null?supplementalRefundDetails.get(0).get("payment_type").toString():null;
				Integer payment_account_seq = supplementalRefundDetails.get(0).get("payment_account_seq")!=null?(Integer) supplementalRefundDetails.get(0).get("payment_account_seq"):null;
				String ex_date = supplementalRefundDetails.get(0).get("exp_date")!=null?supplementalRefundDetails.get(0).get("exp_date").toString():null;
				String transaction_reason = supplementalRefundDetails.get(0).get("transaction_reason")!=null?supplementalRefundDetails.get(0).get("transaction_reason").toString():null;
				String nameOnCard = supplementalRefundDetails.get(0).get("name_on_card")!=null?supplementalRefundDetails.get(0).get("name_on_card").toString():null;
				String paymentForm = supplementalRefundDetails.get(0).get("payment_form").toString();
				if(supplementalRefundDetails.get(0).get("credit_card")!=null) {
					 cardNumber = new CustomerUtility().decryptedCardNumber(supplementalRefundDetails.get(0).get("credit_card").toString());
				 }
				supplementalRefundDetails.clear();
				localAmountFlage = true;//fetch only local and pay currency amount
				supplementalRefundDetails = jdbcTemplate.queryForList(fetchQuery(orderHdrId, orderItemSeq, localAmountFlage));
				localAmount = supplementalRefundDetails.get(0).get("local_amount")!=null?supplementalRefundDetails.get(0).get("local_amount").toString():null;
				payCurrencyAmout = supplementalRefundDetails.get(0).get("pay_currency_amount")!=null?supplementalRefundDetails.get(0).get("pay_currency_amount").toString():null;
				float localAmount3 = round(Float.valueOf(localAmount),2);
				float payCurrency3 = round(Float.valueOf(payCurrencyAmout),2);
				
					float currentLocalPrice =  round(Math.abs(localAmount3),2);
					float currentCurrencyPrice =  round(Math.abs(payCurrency3),2);
					Map<String,Object> m = new HashMap<String,Object>();
					//m.put("use_payment_acount", true);
					//m.put("refund_deposit_account", false);
					m.put("local_amount", currentLocalPrice);
					m.put("pay_currency_amount", currentCurrencyPrice);
					m.put("currency", currency);
					m.put("customer_id", customerId);
					m.put("customer_name", customerName);
					//m.put("id_nbr", id_nbr);
					m.put("payment_type", payment_type);
					m.put("payment_account_seq", payment_account_seq);
					m.put("exp_date", ex_date);
					m.put("transaction_reason", transaction_reason);
					m.put("name_on_card", nameOnCard);
					m.put("payment_form", paymentForm);
					m.put("credit_card", cardNumber);
					supplementalRefundDetails.clear();
					supplementalRefundDetails.add(m);
				}
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return supplementalRefundDetails;
	}
	public String fetchQuery(Integer orderHdrId, Integer orderItemSeq, boolean localAmount) {
		StringBuilder query2 = null;
		if(localAmount == false) {
			//fetch all except local and pay currency amount
			query2 = new StringBuilder("SELECT payment.currency as currency,payment.customer_id as customer_id,");
			query2.append("CONCAT(customer.fname,' ',customer.lname) as customer_name,");
			query2.append("(case when (payment.payment_type in('CA','DD','CK')) then null else pc.id_nbr end ) as credit_card,");
			query2.append("(case when (payment.payment_type in ('CA','DD')) then 'CK' else payment.payment_type end) as payment_type");
			query2.append(",pc.payment_account_seq,RIGHT(CONVERT(VARCHAR(10), payment.exp_date, 103), 7) AS exp_date,payment.transaction_reason,pc.credit_card_info as name_on_card,payment_type.payment_form");
		}else {
			//fetch only local and pay currency amount
			query2 = new StringBuilder("SELECT sum(pb.local_amount) AS local_amount,sum(pb.pay_currency_amount) as pay_currency_amount");
		}
			query2.append(" FROM order_item oi, paybreak pb");
			query2.append(" left join customer on pb.customer_id = customer.customer_id");
			query2.append(" left join payment on payment.customer_id=customer.customer_id");
			query2.append(" left join payment_account pc on pc.customer_id=pb.customer_id  and pc.payment_account_seq=payment.payment_account_seq ");
			query2.append("left join payment_type on payment_type.payment_type = payment.payment_type WHERE oi.orderhdr_id = ");
			query2.append(orderHdrId);
			query2.append(" and oi.order_item_seq = ");
			query2.append(orderItemSeq);
			query2.append(" and pb.orderhdr_id = oi.orderhdr_id and pb.order_item_seq = oi.order_item_seq");
			query2.append(" and payment.customer_id = pb.customer_id and payment.payment_seq = pb.payment_seq ");
		return query2.toString();
	}
	//This method for rounding off decimal value like 4.978 will be 4.98
	public static float round(float value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.floatValue();
	}
	@Override
	public List<DropdownModel> getTransactionReasonByReasonType(String action) {
			List<Map<String, Object>> rows=new ArrayList<>();
			List<DropdownModel> transactionReasonsList = new ArrayList<>();
				try {
					Integer reasonType = null;
							if(action.equalsIgnoreCase("refund")) {
								reasonType = 9;
							}
						rows = jdbcTemplate.queryForList("select transaction_reason,description,reason_type from transaction_reason where reason_type = "+reasonType);
					for (Map<String, Object> row : rows) {
		                   DropdownModel model = new DropdownModel();
			               model.setKey(row.get("transaction_reason").toString());
			               model.setDisplay(row.get("reason_type").toString());
			               model.setDescription(row.get("description")!=null?row.get("description").toString():"");
			               transactionReasonsList.add(model);
	                   }
					}
				catch(Exception e){
					LOGGER.error(ERROR + e);
					
				}
				return transactionReasonsList;
	}
	@Override
	public int savePayment(SupplementalRefund payment) {
		Map<String, Object>addSourceParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder baseAmount = null;
		StringBuilder payCurrencyAmount = null;
		String paymentSaveQuery = "insert into payment (customer_id,payment_seq,user_code,currency,date_stamp,creation_date,payment_clear_status,commission,payment_type,base_amount,pay_currency_amount,transaction_reason,transaction_type,payment_clear_method,realize_cash_when,pay_exchange_rate,is_reversed,status_noedit,processing,mru_paybreak_seq,customer_deposit_pay_amt,refund_deposit_pay_amt,cash_realized,deposit_transaction,is_ecommerce,is_recurring,needs_memo_post,cc_cleaned,hosted_secure_token_pmt) values (:customer_id,:payment_seq,:user_code,:currency,:date_stamp,:creation_date,:payment_clear_status,:commission,:payment_type,:base_amount,:pay_currency_amount,:transaction_reason,:transaction_type,:payment_clear_method,:realize_cash_when,:pay_exchange_rate,:is_reversed,:status_noedit,:processing,:mru_paybreak_seq,:customer_deposit_pay_amt,:refund_deposit_pay_amt,:cash_realized,:deposit_transaction,:is_ecommerce,:is_recurring,:needs_memo_post,:cc_cleaned,:hosted_secure_token_pmt)";
		try  {
			addSourceParams.put("customer_id", payment.getCustomerId());
			 int paymentSeq = getPaymentSeq(payment.getCustomerId());
			 if(paymentSeq !=0){
				 addSourceParams.put("payment_seq", ++paymentSeq);	
				}else{
					addSourceParams.put("payment_seq", 1);
				}
			 addSourceParams.put("user_code", payment.getUserCode());
			 addSourceParams.put("currency", payment.getCurrency());
			 long dateStamp = customerUtility.getmaxDateStamp();
			 addSourceParams.put("date_stamp", dateStamp);
			 addSourceParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			 if(("null".equals(payment.getIdNbr())) | ("".equals(payment.getIdNbr() ))) {
				 addSourceParams.put("id_nbr",null);			
				}else {
				 addSourceParams.put("id_nbr",payment.getIdNbr());
				}
			 if(("null".equals(payment.getExpDate())) | ("".equals(payment.getExpDate() ))) {
				 addSourceParams.put("exp_date",null);			
				}else {
				 addSourceParams.put("exp_date",payment.getExpDate());
				}
			 if(("null".equals(payment.getRefNbr())) | ("".equals(payment.getRefNbr() ))) {
				 addSourceParams.put("ref_nbr",null);			
				}else {
				 addSourceParams.put("ref_nbr",payment.getRefNbr());
				}
			 
			 if(("null".equals(payment.getAuthCode())) | ("".equals(payment.getAuthCode() ))) {
				 addSourceParams.put("auth_code",null);			
				}else {
				 addSourceParams.put("auth_code",payment.getAuthCode());
				}
			 if(("null".equals(payment.getAuthDate())) | ("".equals(payment.getAuthDate() ))) {
				 addSourceParams.put("auth_date",null);			
				}else {
				 addSourceParams.put("auth_date",payment.getAuthDate());
				}
			 if(("null".equals(payment.getClearDate())) | ("".equals(payment.getClearDate() ))) {
				 addSourceParams.put("clear_date",null);			
				}else {
				 addSourceParams.put("clear_date",payment.getClearDate());
				}
			 addSourceParams.put("payment_clear_status", payment.getPaymentClearStatus()!=null?payment.getPaymentClearStatus():5);//when user click put refund into deposit account
			 addSourceParams.put("effort_nbr", payment.getEffortNbr()!=null?payment.getEffortNbr():null);
			 addSourceParams.put("commission", payment.getCommission()!=null?payment.getCommission():0);
			 addSourceParams.put("payment_type", payment.getPaymentType());
			
			 if(("null".equals(payment.getCreditCardInfo())) | ("".equals(payment.getCreditCardInfo() ))) {
				 addSourceParams.put("credit_card_info",null);			
				}else {
				 addSourceParams.put("credit_card_info",payment.getCreditCardInfo());
				}
			 if(payment.getBaseAmount() !=null) {
				 baseAmount = new StringBuilder("-").append(payment.getBaseAmount());
				 addSourceParams.put("base_amount",baseAmount);	
				}else {
				 addSourceParams.put("base_amount",0.0);
				}
			 if(payment.getPayCurrencyAmount() !=null) {
				// payCurrencyAmount = new StringBuilder("-").append(payment.getPayCurrencyAmount());
				 payCurrencyAmount = new StringBuilder("-").append(payment.getBaseAmount());//baseAmount is a refund amount
				 addSourceParams.put("pay_currency_amount",payCurrencyAmount);	
				}else {
				 payCurrencyAmount = new StringBuilder("-").append(payment.getBaseAmount());//baseAmount is a refund amount
				 addSourceParams.put("pay_currency_amount",payCurrencyAmount);
				}
			 if(("null".equals(payment.getTransactionReason())) | ("".equals(payment.getTransactionReason() ))) {
				 addSourceParams.put("transaction_reason",null);			
				}else {
				 addSourceParams.put("transaction_reason",payment.getTransactionReason());
				}
			 addSourceParams.put("transaction_type", payment.getTransactionType()!=null?payment.getTransactionType():2);//2 means refund
			 addSourceParams.put("payment_clear_method", payment.getPayClearMethod()!=null?payment.getPayClearMethod():0);
			 addSourceParams.put("realize_cash_when", payment.getRealizeCashWhen()!=null?payment.getRealizeCashWhen():1);//Credit card indicator of when to realize cash 0 N/A 1 Entered 2 Authorized 3 Cleared 
			 addSourceParams.put("pay_exchange_rate", payment.getPayExchangeRate()!=null?payment.getPayExchangeRate():1.0);
			 if(("null".equals(payment.getIsReversed())) | ("".equals(payment.getIsReversed() ))) {
				 addSourceParams.put("is_reversed",0);			
				}else { 
				 addSourceParams.put("is_reversed",payment.getIsReversed());
				}
			 addSourceParams.put("status_noedit", payment.getStatusNoedit()!=null?payment.getStatusNoedit():0);
			 addSourceParams.put("processing", payment.getProcessing()!=null?payment.getProcessing():0);
			 addSourceParams.put("mru_paybreak_seq", payment.getMruPaybreakSeq()!=null?payment.getMruPaybreakSeq():1);
			 addSourceParams.put("customer_deposit_pay_amt", payment.getCustomerDepositPayAmount()!=null?payment.getCustomerDepositPayAmount():0.0);
			 addSourceParams.put("nbr_times_issued", payment.getNbrTimesIssued()!=null?payment.getNbrTimesIssued():null);
			 addSourceParams.put("pending_xaction_header_id", payment.getPendingXactionHeaderId()!=null?payment.getPendingXactionHeaderId():null);
			 if(("null".equals(payment.getCreditCardStartDate())) | ("".equals(payment.getCreditCardStartDate() ))) {
				 addSourceParams.put("credit_card_start_date",null);			
				}else {
				 addSourceParams.put("credit_card_start_date",payment.getCreditCardStartDate());
				}
			 if(("null".equals(payment.getCardVerificationValue())) | ("".equals(payment.getCardVerificationValue() ))) {
				 addSourceParams.put("card_verification_value",null);			
				}else {
				 addSourceParams.put("card_verification_value",payment.getCardVerificationValue());
				}
			 if(("null".equals(payment.getCreditCardIssueId())) | ("".equals(payment.getCreditCardIssueId() ))) {
				 addSourceParams.put("credit_card_issue_id",null);			
				}else {
				 addSourceParams.put("credit_card_issue_id",payment.getCreditCardIssueId());
				}
			 addSourceParams.put("credit_card_bill_customer_id", payment.getCreditCardBillCustomerId()!=null?payment.getCreditCardBillCustomerId():null);
			 if(("null".equals(payment.getCreditCardBillAddressSeq())) | ("".equals(payment.getCreditCardBillAddressSeq() ))) {
				 addSourceParams.put("credit_card_bill_address_seq",null);			
				}else {
				 addSourceParams.put("credit_card_bill_address_seq",payment.getCreditCardBillAddressSeq());
				}
			 addSourceParams.put("refund_deposit_pay_amt", payment.getRefundDepositPayAmount()!=null?payment.getRefundDepositPayAmount():0.0);
			 if(("null".equals(payment.getCheckNumber())) | ("".equals(payment.getCheckNumber() ))) {
				 addSourceParams.put("check_number",null);			
				}else {
				 addSourceParams.put("check_number",payment.getCheckNumber());
				}
			 addSourceParams.put("refund_deposit_pay_amt", payment.getIcsBankDefId()!=null?payment.getIcsBankDefId():null);
			 addSourceParams.put("cash_realized", payment.getCashRealized()!=null|payment.getCashRealized()!=""?payment.getCashRealized():1);
			 addSourceParams.put("mru_payment_note_seq", payment.getMruPaymentNoteSeq()!=null?payment.getMruPaymentNoteSeq():null);
			 addSourceParams.put("deposit_transaction", payment.getDepositTransaction()!=null?payment.getDepositTransaction():0);
			 addSourceParams.put("is_ecommerce", payment.getIsEcommerce()!=null?payment.getIsEcommerce():0);
			 addSourceParams.put("is_recurring", payment.getIsRecurring()!=null?payment.getIsRecurring():0);
			 addSourceParams.put("max_settle_retries", payment.getMaxSettleRetries()!=null?payment.getMaxSettleRetries():null);
			 addSourceParams.put("n_days_between_settle_retries", payment.getnDaysBetweenSettleRetries()!=null?payment.getnDaysBetweenSettleRetries():null);
			 if(("null".equals(payment.getNextSettleRetryDate())) | ("".equals(payment.getNextSettleRetryDate() ))) {
				 addSourceParams.put("next_settle_retry_date",null);			
				}else {
				 addSourceParams.put("next_settle_retry_date",payment.getNextSettleRetryDate());
				}
			 addSourceParams.put("n_settle_retries_left", payment.getnSettleRetriesLeft()!=null?payment.getnSettleRetriesLeft():null);
			 if(("null".equals(payment.getCancelItmAfterSettleRetry())) | ("".equals(payment.getCancelItmAfterSettleRetry() ))) {
				 addSourceParams.put("cancel_itm_after_settle_retry",null);			
				}else {
				 addSourceParams.put("cancel_itm_after_settle_retry",payment.getCancelItmAfterSettleRetry());
				}
			 addSourceParams.put("payment_account_seq", payment.getPaymentAccountSeq()!=null?payment.getPaymentAccountSeq():null);
			 addSourceParams.put("needs_memo_post", payment.getNeedsMemoPost()!=null?payment.getNeedsMemoPost():0);
			 if(("null".equals(payment.getIdNbrLastFour())) | ("".equals(payment.getIdNbrLastFour() ))) {
				 addSourceParams.put("id_nbr_last_four",null);			
				}else {
				 addSourceParams.put("id_nbr_last_four",payment.getIdNbrLastFour());
				}
			 addSourceParams.put("bacs_id", payment.getBacsId()!=null?payment.getBacsId():null);
			 addSourceParams.put("ics_bank_def_id", payment.getIcsBankDefId()!=null?payment.getIcsBankDefId():null);
			 addSourceParams.put("cc_cleaned", payment.getCcCleaned()!=null?payment.getCcCleaned():0);
			 addSourceParams.put("hosted_secure_token_pmt", payment.getHostedSecureTokenPmt()!=null?payment.getHostedSecureTokenPmt():0);
			 if(("null".equals(payment.getBaNbr())) | ("".equals(payment.getBaNbr() ))) {
				 addSourceParams.put("ba_nbr",null);			
				}else {
				 addSourceParams.put("ba_nbr",payment.getBaNbr());
				}
			 addSourceParams.put("suspend_after_n_settle_retries", payment.getSuspendAfterNSettleRetries()!=null?payment.getSuspendAfterNSettleRetries():null);
			 status = namedParameterJdbcTemplate.update(paymentSaveQuery, addSourceParams);
		
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	 int insertIntoPaymentReversedPaymentTable(Map<String, Object>addSourceParams,Payment payment) {
		 int status = 0;
		 try {
			 String paymentReversedPaymentSaveQuery = "insert into payment_reversed_payment(original_customer_id,original_payment_seq,reversed_customer_id,reversed_payment_seq) values(:original_customer_id,:original_payment_seq,:reversed_customer_id,:reversed_payment_seq)";
			 addSourceParams.put("original_customer_id", payment.getCustomerId());
			 addSourceParams.put("original_payment_seq", payment.getPaymentSeq());
			 addSourceParams.put("reversed_customer_id", payment.getCustomerId());
			 String reversedPaymentSeqResult = jdbcTemplate.queryForObject("select MAX(reversed_payment_seq) from payment_reversed_payment where original_customer_id = "+payment.getCustomerId()+" and original_payment_seq = "+payment.getPaymentSeq(),String.class);
			 if(reversedPaymentSeqResult != null) {
				 addSourceParams.put("reversed_payment_seq", Integer.valueOf(reversedPaymentSeqResult)+1); 
			 }else {
				 addSourceParams.put("reversed_payment_seq", 1);  
			 }
			 status = namedParameterJdbcTemplate.update(paymentReversedPaymentSaveQuery, addSourceParams);
			 
		 }catch (Exception e) {
			 LOGGER.error(ERROR + e);
		}
		 return status;
	 }
	
	@Override
	public int savePaymentReversedPayment(PaymentReversedPayment paymentReversedPayment) {
		Map<String, Object>addSourceParams = new HashMap<>();
		int status = 0; 
		 String editTrailSaveQuery = "insert into payment_reversed_payment(original_customer_id,original_payment_seq,reversed_customer_id,reversed_payment_seq) values(:original_customer_id,:original_payment_seq,:reversed_customer_id,:reversed_payment_seq)";
		try {
			addSourceParams.put("original_customer_id", paymentReversedPayment.getOriginal_customer_id());
			 addSourceParams.put("original_payment_seq", paymentReversedPayment.getOriginal_payment_seq());
			 addSourceParams.put("reversed_customer_id", paymentReversedPayment.getReversed_customer_id());
			 String reversedPaymentSeqResult = jdbcTemplate.queryForObject("select MAX(reversed_payment_seq) from payment_reversed_payment where original_customer_id = "+paymentReversedPayment.getOriginal_customer_id()+" and original_payment_seq = "+paymentReversedPayment.getOriginal_payment_seq(),String.class);
			 if(reversedPaymentSeqResult != null) {
				 addSourceParams.put("reversed_payment_seq", Integer.valueOf(reversedPaymentSeqResult)+1); 
			 }else {
				 addSourceParams.put("reversed_payment_seq", 1);  
			 }
			 status = namedParameterJdbcTemplate.update(editTrailSaveQuery, addSourceParams);
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	@Override
	public int saveEditTrail(EditTrail editTrail) {
		Map<String, Object>addSourceParams = new HashMap<>();
		int status = 0; 
		 String editTrailSaveQuery = "insert into edit_trail(edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,order_item_amt_break_seq,edited,currency,table_enum,document_reference_id,document_reference_seq,local_amount,base_amount,date_stamp,creation_date,xaction_name,payment_seq,demographic_seq,job_id,service_seq) values(:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:order_item_amt_break_seq,:edited,:currency,:table_enum,:document_reference_id,:document_reference_seq,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name,:payment_seq,:demographic_seq,:job_id,:service_seq)";
		 
		try {
			 Long maxEditTrailId = customerUtility.getmaxeditTrailId() + 1;
			 addSourceParams.put("edit_trail_id", maxEditTrailId);  
			 addSourceParams.put("customer_id", editTrail.getCustomerId()!=null?editTrail.getCustomerId():null); 
			 addSourceParams.put("customer_address_seq", editTrail.getCustomerAddressSeq()!=null?editTrail.getCustomerAddressSeq():null); 
			 addSourceParams.put("user_code", editTrail.getUserCode()); 
			 
			 addSourceParams.put("subscrip_id", editTrail.getOrderhdrId()!=null?editTrail.getOrderhdrId():null); 
			 addSourceParams.put("orderhdr_id", editTrail.getOrderhdrId()!=null?editTrail.getOrderhdrId():null); 
			 addSourceParams.put("order_item_seq", editTrail.getOrderItemSeq()!=null?editTrail.getOrderItemSeq():null); 
			 addSourceParams.put("order_item_amt_break_seq", editTrail.getOrderItemAmtBreakSeq()!=null?editTrail.getOrderItemAmtBreakSeq():null); 
			 addSourceParams.put("edited", editTrail.getEdited()); 
			 addSourceParams.put("currency", editTrail.getCurrency()!=null?editTrail.getCurrency():null); 
			 addSourceParams.put("table_enum", editTrail.getTableEnum()!=null?editTrail.getTableEnum():null); 
			 addSourceParams.put("document_reference_id", editTrail.getDocumentReferenceId()); 
			 addSourceParams.put("document_reference_seq", editTrail.getDocumentReferenceSeq()!=null?editTrail.getDocumentReferenceSeq():null); 
			 addSourceParams.put("local_amount", editTrail.getLocalAmount()!=null?editTrail.getLocalAmount():0.0); 
			 addSourceParams.put("base_amount", editTrail.getBaseAmount()!=null?editTrail.getBaseAmount():0.0); 
			 addSourceParams.put("date_stamp", editTrail.getDateStamp()); 
			 addSourceParams.put("creation_date", editTrail.getCreationDate()!=null?editTrail.getCreationDate():null); 
			 addSourceParams.put("xaction_name", editTrail.getXactionName()!=null?editTrail.getXactionName():null); 
			 addSourceParams.put("payment_seq", editTrail.getPaymentSeq()!=null?editTrail.getPaymentSeq():null); 
			 addSourceParams.put("demographic_seq", editTrail.getDemographicSeq()!=null?editTrail.getDemographicSeq():null); 
			 addSourceParams.put("job_id", editTrail.getJobId()!=null?editTrail.getJobId():null); 
			 addSourceParams.put("payment_account_seq", editTrail.getPaymentAccountSeq()!=null?editTrail.getPaymentAccountSeq():null); 
			 addSourceParams.put("service_seq", editTrail.getServiceSeq()!=null?editTrail.getServiceSeq():null); 
			 status = namedParameterJdbcTemplate.update(editTrailSaveQuery, addSourceParams);
			 customerUtility.updateMruEditTrailId(maxEditTrailId);
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	@Override
	public int saveJournal(Journal journal) {
		Map<String, Object>addSourceParams = new HashMap<>();
		
		int status = 0; 
		try {
//			String maxIdResult = jdbcTemplate.queryForObject("select MAX(journal_id) from journal",String.class);
//			 if(maxIdResult != null) {
//				 addSourceParams.put("journal_id", Integer.valueOf(maxIdResult)+1); 
//			 }else {
//				 addSourceParams.put("journal_id", 1);  
//			 }
			String journalSaveQuery = "insert into journal(journal_id,date_stamp,orderhdr_id,order_item_seq,posting_reference,tax_amount,net_amount,del_amount,com_amount,debit_account,qty_debit_account,credit_account,qty_credit_account,qty,customer_id,payment_seq,bndl_qty,job_id) values(:journal_id,:date_stamp,:orderhdr_id,:order_item_seq,:posting_reference,:tax_amount,:net_amount,:del_amount,:com_amount,:debit_account,:qty_debit_account,:credit_account,:qty_credit_account,:qty,:customer_id,:payment_seq,:bndl_qty,:job_id)";
			long journalId = customerUtility.getMaxJournalId() + 1;
			jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_journal_id') begin create"
							+ "  table mru_journal_id (id int) insert mru_journal_id (id) values (1) end else update mru_journal_id with (TABLOCKX)"
							+ "  set id =" + journalId);
		     //long journalId = customerUtility.getMaxJournalId() + 1;
			 addSourceParams.put("journal_id", journalId);
			 addSourceParams.put("date_stamp", journal.getDateStamp()); 
			 addSourceParams.put("orderhdr_id", journal.getOrderhdrId()); 
			 addSourceParams.put("order_item_seq", journal.getOrderItemSeq()); 
			 addSourceParams.put("posting_reference", journal.getPostingReference()); 
			 addSourceParams.put("tax_amount", journal.getTaxAmount()!=null?journal.getTaxAmount():0.0); 
			 addSourceParams.put("net_amount", journal.getNetAmount()!=null?journal.getNetAmount():0.0); 
			 addSourceParams.put("del_amount", journal.getDelAmount()!=null?journal.getDelAmount():0.0); 
			 addSourceParams.put("com_amount", journal.getCom_amount()!=null?journal.getCom_amount():0.0); 
			 addSourceParams.put("debit_account", journal.getDebitAccount()!=null?journal.getDebitAccount():null); 
			 addSourceParams.put("qty_debit_account", journal.getQtyDebitAccount()!=null?journal.getQtyDebitAccount():null); 
			 addSourceParams.put("credit_account", journal.getCreditAccount()!=null?journal.getCreditAccount():null); 
			 addSourceParams.put("qty_credit_account", journal.getQtyCreditAccount()!=null?journal.getQtyCreditAccount():null); 
			 addSourceParams.put("qty", journal.getQty()!=null?journal.getQty():null); 
			 addSourceParams.put("customer_id", journal.getCustomerId()!=null?journal.getCustomerId():null); 
			 addSourceParams.put("payment_seq", journal.getPaymentSeq()!=null?journal.getPaymentSeq():null); 
			 addSourceParams.put("bndl_qty", journal.getBndlQty()!=null?journal.getBndlQty():null); 
			 addSourceParams.put("job_id", journal.getJobId()!=null?journal.getJobId():null); 
			 status = namedParameterJdbcTemplate.update(journalSaveQuery, addSourceParams);
			 customerUtility.updateJournalId(journalId);
			 
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	@Override
	public int savePaybreak(Paybreak paybreak) {
		Map<String, Object>addSourceParams = new HashMap<>();
		int status = 0; 
		String savePaybreakQuery = "insert into paybreak(customer_id,payment_seq,paybreak_seq,orderhdr_id,order_item_seq,order_item_amt_break_seq,local_amount,base_amount,pay_currency_amount,paybreak_type,oc_id,date_stamp,bogus_commission,local_exchange_rate,edit_trail_id,jrn_flag) values(:customer_id,:payment_seq,:paybreak_seq,:orderhdr_id,:order_item_seq,:order_item_amt_break_seq,:local_amount,:base_amount,:pay_currency_amount,:paybreak_type,:oc_id,:date_stamp,:bogus_commission,:local_exchange_rate,:edit_trail_id,:jrn_flag)";
		addSourceParams.put("customer_id", paybreak.getCustomerId());  
		addSourceParams.put("payment_seq", paybreak.getPaymentSeq());
		String maxIdResult = jdbcTemplate.queryForObject("SELECT max(paybreak_seq) FROM paybreak WHERE customer_id="+paybreak.getCustomerId()+" and payment_seq="+paybreak.getPaymentSeq(),String.class);
		if(maxIdResult != null) {
			 addSourceParams.put("paybreak_seq", Integer.valueOf(maxIdResult)+1); 
		 }else {
			 addSourceParams.put("paybreak_seq", 1);  
		 }
		 addSourceParams.put("orderhdr_id", paybreak.getOrderhdrId()); 
		 addSourceParams.put("order_item_seq", paybreak.getOrderItemSeq()); 
		 addSourceParams.put("order_item_amt_break_seq", paybreak.getOrderItemAmtBreakSeq()!=null?paybreak.getOrderItemAmtBreakSeq():0.0); 
		 addSourceParams.put("local_amount", paybreak.getLocalAmount()!=null?paybreak.getLocalAmount():0.0); 
		 addSourceParams.put("base_amount", paybreak.getBaseAmount()!=null?paybreak.getBaseAmount():0.0); 
		 addSourceParams.put("pay_currency_amount", paybreak.getPayCurrencyAmount()!=null?paybreak.getPayCurrencyAmount():0.0); 
		 addSourceParams.put("paybreak_type", paybreak.getPaybreakType()!=null?paybreak.getPaybreakType():null); 
		 addSourceParams.put("oc_id", paybreak.getOcId()); 
		 addSourceParams.put("date_stamp", paybreak.getDateStamp()); 
		 addSourceParams.put("bogus_commission", paybreak.getBogusCommission()); 
		 addSourceParams.put("local_exchange_rate", paybreak.getLocalExchangeRate()!=null?paybreak.getLocalExchangeRate():null); 
		 addSourceParams.put("edit_trail_id", paybreak.getEditTrailId()!=null?paybreak.getEditTrailId():null); 
		 addSourceParams.put("jrn_flag", paybreak.getJrnFlag()!=null?paybreak.getJrnFlag():null); 
		 status = namedParameterJdbcTemplate.update(savePaybreakQuery, addSourceParams);
		 return status;
	}

	@Override
	public List<DropdownModel> getCurrencyType() {
		List<Map<String, Object>> rows=new ArrayList<>();
		List<DropdownModel> currencyList = new ArrayList<>();
		try {
			 rows = jdbcTemplate.queryForList("select currency,description,currency_symbol from currency");
			 for (Map<String, Object> row : rows) {
                 DropdownModel model = new DropdownModel();
	               model.setKey(row.get("currency").toString());
	               model.setDisplay(row.get("currency_symbol")!=null?row.get("currency_symbol").toString():"");
	               model.setDescription(row.get("description")!=null?row.get("description").toString():"");
	               currencyList.add(model);
             }
		}
		catch(Exception e){
			LOGGER.error(ERROR + e);
			
		}
		return currencyList;
		
	}	
	
	@Override
	public int getPaymentSeq(Integer customerId) {
		int paymentSeq = 0;
		try {
			String max = jdbcTemplate.queryForObject("select max(payment_seq) from payment where  customer_id="+customerId, String.class);
		if(max == null){
			paymentSeq = 0;
		}else {
			paymentSeq =Integer.valueOf(max);
		}
		}catch(Exception e) {
		}
		return paymentSeq;
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int saveSupplementalRefund(SupplementalRefund payment) {
		Map<String, Object>addSourceParams = new LinkedHashMap<>();
		int status = 0;
		StringBuilder baseAmount = null;
		StringBuilder payCurrencyAmount = null;
		String customerDepositQuery = "insert into customer_deposit (customer_id,liab_amt,no_more_liability,recon_upd) values (:customer_id,:liab_amt,:no_more_liability,:recon_upd)";
		String paymentSaveQuery = "insert into payment (customer_id,payment_seq,user_code,currency,date_stamp,creation_date,payment_clear_status,commission,payment_type,base_amount,pay_currency_amount,transaction_reason,transaction_type,payment_clear_method,realize_cash_when,pay_exchange_rate,is_reversed,status_noedit,processing,mru_paybreak_seq,customer_deposit_pay_amt,refund_deposit_pay_amt,cash_realized,deposit_transaction,is_ecommerce,is_recurring,needs_memo_post,cc_cleaned,hosted_secure_token_pmt) values (:customer_id,:payment_seq,:user_code,:currency,:date_stamp,:creation_date,:payment_clear_status,:commission,:payment_type,:base_amount,:pay_currency_amount,:transaction_reason,:transaction_type,:payment_clear_method,:realize_cash_when,:pay_exchange_rate,:is_reversed,:status_noedit,:processing,:mru_paybreak_seq,:customer_deposit_pay_amt,:refund_deposit_pay_amt,:cash_realized,:deposit_transaction,:is_ecommerce,:is_recurring,:needs_memo_post,:cc_cleaned,:hosted_secure_token_pmt)";
		try {
			 //If user clicks "put refund into deposit account" button then some entries will be inserted into customer_deposit table.
			 if(payment.getIsDepositAccount()) {
				 addSourceParams.put("customer_id", payment.getCustomerId());
				 addSourceParams.put("liab_amt", 0.0);
				 addSourceParams.put("no_more_liability", 0);
				 addSourceParams.put("recon_upd", 0);
				 //status = namedParameterJdbcTemplate.update(customerDepositQuery, addSourceParams);
				 status = 0;
				 status = savePayment(payment);
			 }
			 status = 0;
			 addSourceParams.put("customer_id", payment.getCustomerId());
			 int paymentSeq = getPaymentSeq(payment.getCustomerId());
			 if(paymentSeq !=0){
				 addSourceParams.put("payment_seq", ++paymentSeq);	
				}else{
					addSourceParams.put("payment_seq", 1);
				}
			 addSourceParams.put("user_code", payment.getUserCode());
			 addSourceParams.put("currency", payment.getCurrency());
			 long dateStamp = customerUtility.getmaxDateStamp();
			 addSourceParams.put("date_stamp", dateStamp);
			 addSourceParams.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			 if(("null".equals(payment.getIdNbr())) | ("".equals(payment.getIdNbr() ))) {
				 addSourceParams.put("id_nbr",null);			
				}else {
				 addSourceParams.put("id_nbr",payment.getIdNbr());
				}
			 if(("null".equals(payment.getExpDate())) | ("".equals(payment.getExpDate() ))) {
				 addSourceParams.put("exp_date",null);			
				}else {
				 addSourceParams.put("exp_date",payment.getExpDate());
				}
			 if(("null".equals(payment.getRefNbr())) | ("".equals(payment.getRefNbr() ))) {
				 addSourceParams.put("ref_nbr",null);			
				}else {
				 addSourceParams.put("ref_nbr",payment.getRefNbr());
				}
			 
			 if(("null".equals(payment.getAuthCode())) | ("".equals(payment.getAuthCode() ))) {
				 addSourceParams.put("auth_code",null);			
				}else {
				 addSourceParams.put("auth_code",payment.getAuthCode());
				}
			 if(("null".equals(payment.getAuthDate())) | ("".equals(payment.getAuthDate() ))) {
				 addSourceParams.put("auth_date",null);			
				}else {
				 addSourceParams.put("auth_date",payment.getAuthDate());
				}
			 if(("null".equals(payment.getClearDate())) | ("".equals(payment.getClearDate() ))) {
				 addSourceParams.put("clear_date",null);			
				}else {
				 addSourceParams.put("clear_date",payment.getClearDate());
				}
			 if(payment.getIsDepositAccount()) {
				 addSourceParams.put("payment_clear_status", payment.getPaymentClearStatus()!=null?payment.getPaymentClearStatus():3);//because 3 means cleared
			 }else {
				 addSourceParams.put("payment_clear_status", payment.getPaymentClearStatus()!=null?payment.getPaymentClearStatus():6);//because 6 means Ready to Process Refund 
			 }
			 addSourceParams.put("effort_nbr", payment.getEffortNbr()!=null?payment.getEffortNbr():null);
			 addSourceParams.put("commission", payment.getCommission()!=null?payment.getCommission():0);
			 addSourceParams.put("payment_type", payment.getPaymentType());
			
			 if(("null".equals(payment.getCreditCardInfo())) | ("".equals(payment.getCreditCardInfo() ))) {
				 addSourceParams.put("credit_card_info",null);			
				}else {
				 addSourceParams.put("credit_card_info",payment.getCreditCardInfo());
				}
				 baseAmount = new StringBuilder("-").append(payment.getBaseAmount());
				 addSourceParams.put("base_amount",baseAmount);	
				 addSourceParams.put("pay_currency_amount",baseAmount);	
			 if( "null".equals(payment.getTransactionReason()) | payment.getIsDepositAccount() ) {
				 addSourceParams.put("transaction_reason",null);			
				}else {
				 addSourceParams.put("transaction_reason",payment.getTransactionReason());
				}
			 if(payment.getIsDepositAccount()) {
				  addSourceParams.put("transaction_type", payment.getTransactionType()!=null?payment.getTransactionType():0);//0 means payment 
			 }else {
			  addSourceParams.put("transaction_type", payment.getTransactionType()!=null?payment.getTransactionType():2);//2 means refund
			 }
			 addSourceParams.put("payment_clear_method", payment.getPayClearMethod()!=null?payment.getPayClearMethod():0);
			 addSourceParams.put("realize_cash_when", payment.getRealizeCashWhen()!=null?payment.getRealizeCashWhen():1);//Credit card indicator of when to realize cash 0 N/A 1 Entered 2 Authorized 3 Cleared 
			 addSourceParams.put("pay_exchange_rate", payment.getPayExchangeRate()!=null?payment.getPayExchangeRate():1.0);
			 if(("null".equals(payment.getIsReversed())) | ("".equals(payment.getIsReversed() ))) {
				 addSourceParams.put("is_reversed",0);			
				}else { 
				 addSourceParams.put("is_reversed",payment.getIsReversed());
				}
			 addSourceParams.put("status_noedit", payment.getStatusNoedit()!=null?payment.getStatusNoedit():0);
			 addSourceParams.put("processing", payment.getProcessing()!=null?payment.getProcessing():0);
			 addSourceParams.put("mru_paybreak_seq", payment.getMruPaybreakSeq()!=null?payment.getMruPaybreakSeq():null);
			 if(payment.getIsDepositAccount()) {
				 addSourceParams.put("customer_deposit_pay_amt", payment.getBaseAmount());
			 }else {
				 addSourceParams.put("customer_deposit_pay_amt", payment.getCustomerDepositPayAmount()!=null?payment.getCustomerDepositPayAmount():0.0);
			 }
			 addSourceParams.put("nbr_times_issued", payment.getNbrTimesIssued()!=null?payment.getNbrTimesIssued():null);
			 addSourceParams.put("pending_xaction_header_id", payment.getPendingXactionHeaderId()!=null?payment.getPendingXactionHeaderId():null);
			 if(("null".equals(payment.getCreditCardStartDate())) | ("".equals(payment.getCreditCardStartDate() ))) {
				 addSourceParams.put("credit_card_start_date",null);			
				}else {
				 addSourceParams.put("credit_card_start_date",payment.getCreditCardStartDate());
				}
			 if(("null".equals(payment.getCardVerificationValue())) | ("".equals(payment.getCardVerificationValue() ))) {
				 addSourceParams.put("card_verification_value",null);			
				}else {
				 addSourceParams.put("card_verification_value",payment.getCardVerificationValue());
				}
			 if(("null".equals(payment.getCreditCardIssueId())) | ("".equals(payment.getCreditCardIssueId() ))) {
				 addSourceParams.put("credit_card_issue_id",null);			
				}else {
				 addSourceParams.put("credit_card_issue_id",payment.getCreditCardIssueId());
				}
			 addSourceParams.put("credit_card_bill_customer_id", payment.getCreditCardBillCustomerId()!=null?payment.getCreditCardBillCustomerId():null);
			 if(("null".equals(payment.getCreditCardBillAddressSeq())) | ("".equals(payment.getCreditCardBillAddressSeq() ))) {
				 addSourceParams.put("credit_card_bill_address_seq",null);			
				}else {
				 addSourceParams.put("credit_card_bill_address_seq",payment.getCreditCardBillAddressSeq());
				}
			 addSourceParams.put("refund_deposit_pay_amt", payment.getRefundDepositPayAmount()!=null?payment.getRefundDepositPayAmount():0.0);
			 if(("null".equals(payment.getCheckNumber())) | ("".equals(payment.getCheckNumber() ))) {
				 addSourceParams.put("check_number",null);			
				}else {
				 addSourceParams.put("check_number",payment.getCheckNumber());
				}
			 addSourceParams.put("refund_deposit_pay_amt", payment.getIcsBankDefId()!=null?payment.getIcsBankDefId():null);
			 addSourceParams.put("cash_realized", payment.getCashRealized()!=null|payment.getCashRealized()!=""?payment.getCashRealized():1);
			 addSourceParams.put("mru_payment_note_seq", payment.getMruPaymentNoteSeq()!=null?payment.getMruPaymentNoteSeq():null);
			 if(payment.getIsDepositAccount()) {
				 addSourceParams.put("deposit_transaction", payment.getDepositTransaction()!=null?payment.getDepositTransaction():2);//2 means refund to deposit
			 }else {
				 addSourceParams.put("deposit_transaction", payment.getDepositTransaction()!=null?payment.getDepositTransaction():0);
			 }
			 addSourceParams.put("is_ecommerce", payment.getIsEcommerce()!=null?payment.getIsEcommerce():0);
			 addSourceParams.put("is_recurring", payment.getIsRecurring()!=null?payment.getIsRecurring():0);
			 addSourceParams.put("max_settle_retries", payment.getMaxSettleRetries()!=null?payment.getMaxSettleRetries():null);
			 addSourceParams.put("n_days_between_settle_retries", payment.getnDaysBetweenSettleRetries()!=null?payment.getnDaysBetweenSettleRetries():null);
			 if(("null".equals(payment.getNextSettleRetryDate())) | ("".equals(payment.getNextSettleRetryDate() ))) {
				 addSourceParams.put("next_settle_retry_date",null);			
				}else {
				 addSourceParams.put("next_settle_retry_date",payment.getNextSettleRetryDate());
				}
			 addSourceParams.put("n_settle_retries_left", payment.getnSettleRetriesLeft()!=null?payment.getnSettleRetriesLeft():null);
			 if(("null".equals(payment.getCancelItmAfterSettleRetry())) | ("".equals(payment.getCancelItmAfterSettleRetry() ))) {
				 addSourceParams.put("cancel_itm_after_settle_retry",null);			
				}else {
				 addSourceParams.put("cancel_itm_after_settle_retry",payment.getCancelItmAfterSettleRetry());
				}
			 addSourceParams.put("payment_account_seq", payment.getPaymentAccountSeq()!=null?payment.getPaymentAccountSeq():null);
			 addSourceParams.put("needs_memo_post", payment.getNeedsMemoPost()!=null?payment.getNeedsMemoPost():0);
			 if(("null".equals(payment.getIdNbrLastFour())) | ("".equals(payment.getIdNbrLastFour() ))) {
				 addSourceParams.put("id_nbr_last_four",null);			
				}else {
				 addSourceParams.put("id_nbr_last_four",payment.getIdNbrLastFour());
				}
			 addSourceParams.put("bacs_id", payment.getBacsId()!=null?payment.getBacsId():null);
			 addSourceParams.put("ics_bank_def_id", payment.getIcsBankDefId()!=null?payment.getIcsBankDefId():null);
			 addSourceParams.put("cc_cleaned", payment.getCcCleaned()!=null?payment.getCcCleaned():0);
			 addSourceParams.put("hosted_secure_token_pmt", payment.getHostedSecureTokenPmt()!=null?payment.getHostedSecureTokenPmt():0);
			 if(("null".equals(payment.getBaNbr())) | ("".equals(payment.getBaNbr() ))) {
				 addSourceParams.put("ba_nbr",null);			
				}else {
				 addSourceParams.put("ba_nbr",payment.getBaNbr());
				}
			 addSourceParams.put("suspend_after_n_settle_retries", payment.getSuspendAfterNSettleRetries()!=null?payment.getSuspendAfterNSettleRetries():null);
			 status = namedParameterJdbcTemplate.update(paymentSaveQuery, addSourceParams);
			
			 if(status != 0) {
				 addSourceParams.clear();
				 status = 0;
				 //insertIntoPaymentReversedPaymentTable(addSourceParams,payment);
				 String paymentReversedPaymentSaveQuery = "insert into payment_reversed_payment(original_customer_id,original_payment_seq,reversed_customer_id,reversed_payment_seq) values(:original_customer_id,:original_payment_seq,:reversed_customer_id,:reversed_payment_seq)";
				 addSourceParams.put("original_customer_id", payment.getCustomerId());
				 List<Map<String, Object>> original_payment_seqList = jdbcTemplate.queryForList("SELECT DISTINCT payment.* FROM payment, order_item oi, paybreak pb WHERE oi.orderhdr_id = "+payment.getOrderhdrId()+" and oi.order_item_seq = "+payment.getOrderItemSeq()+" and pb.orderhdr_id = oi.orderhdr_id and pb.order_item_seq = oi.order_item_seq and payment.customer_id = pb.customer_id and payment.payment_seq = pb.payment_seq");
				 Integer original_payment_seq = null;
				 if(original_payment_seqList.size()!=0) {
					 original_payment_seq =(Integer) original_payment_seqList.get(0).get("payment_seq");  
				 }
				 addSourceParams.put("original_payment_seq", original_payment_seq);	
				 addSourceParams.put("reversed_customer_id", payment.getCustomerId());
				 addSourceParams.put("reversed_payment_seq", paymentSeq);//incremented payment seq
				 status = namedParameterJdbcTemplate.update(paymentReversedPaymentSaveQuery, addSourceParams);
			 } 
			  //journal_deposit table
			  //if user clicks put refund into deposit account
			  if(payment.getIsDepositAccount()) {
				 addSourceParams.clear(); 
				 status = 0;
				
				 String journalDepositQuery = "insert into journal_deposit (journal_deposit_id,customer_id,payment_seq,date_stamp,posting_reference,amount,debit_account,credit_account) values (:journal_deposit_id,:customer_id,:payment_seq,:date_stamp,:posting_reference,:amount,:debit_account,:credit_account)";
				// String maxIdResult = jdbcTemplate.queryForObject("select MAX(journal_deposit_id) from journal_deposit",String.class);
				 long maxJournalDepositId = customerUtility.getMaxJournalDepositId() + 1;
				 
				 long journalId = customerUtility.getMaxJournalId() + 1;
				 jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_journal_id') begin create"
				 								+ "  table mru_journal_id (id int) insert mru_journal_id (id) values (1) end else update mru_journal_id with (TABLOCKX)"
				 								+ "  set id =" + journalId);
				 
				
				 addSourceParams.put("journal_deposit_id", maxJournalDepositId); 
				 addSourceParams.put("journal_id", journalId); 
				 addSourceParams.put("customer_id", payment.getCustomerId()); 
				 addSourceParams.put("payment_seq", paymentSeq); 
				 addSourceParams.put("date_stamp", dateStamp); 
				 //53 mean Refund Transfer to Customer Deposit
				 addSourceParams.put("posting_reference", payment.getPostingReference()!=null?payment.getPostingReference():53); 
				 addSourceParams.put("amount", payment.getBaseAmount()); 
				 addSourceParams.put("debit_account", payment.getDebitAccount()!=null?payment.getDebitAccount():2); //2 means cash
				 addSourceParams.put("credit_account", payment.getCreditAccount()!=null?payment.getCreditAccount():3); //3 means Liability
				 status = namedParameterJdbcTemplate.update(journalDepositQuery, addSourceParams);
				 customerUtility.updateJournalDepositId(maxJournalDepositId);
				 customerUtility.updateJournalId(journalId);
				 
				 
			 }
			 //journal table
			 if(status != 0) {
				 addSourceParams.clear(); 
				 status = 0;
				 
				 String journalSaveQuery = "insert into journal(journal_id,date_stamp,orderhdr_id,order_item_seq,posting_reference,tax_amount,net_amount,del_amount,com_amount,debit_account,qty_debit_account,credit_account,qty_credit_account,qty,customer_id,payment_seq,bndl_qty,job_id) values(:journal_id,:date_stamp,:orderhdr_id,:order_item_seq,:posting_reference,:tax_amount,:net_amount,:del_amount,:com_amount,:debit_account,:qty_debit_account,:credit_account,:qty_credit_account,:qty,:customer_id,:payment_seq,:bndl_qty,:job_id)";
				// long journalId = customerUtility.getMaxJournalId() + 1;
				 
				 long journalId = customerUtility.getMaxJournalId() + 1;
				 jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_journal_id') begin create"
				 								+ "  table mru_journal_id (id int) insert mru_journal_id (id) values (1) end else update mru_journal_id with (TABLOCKX)"
				 								+ "  set id =" + journalId);
				 
				 addSourceParams.put("journal_id", journalId); 
				 addSourceParams.put("date_stamp", dateStamp); 
				 addSourceParams.put("orderhdr_id", payment.getOrderhdrId()); 
				 addSourceParams.put("order_item_seq", payment.getOrderItemSeq()); 
				 addSourceParams.put("posting_reference", payment.getPostingReference()!=null?payment.getPostingReference():75); 
				 addSourceParams.put("tax_amount", payment.getTaxAmount()!=null?payment.getTaxAmount():0.0); 
				 addSourceParams.put("net_amount", payment.getBaseAmount()!=null?payment.getBaseAmount():0.0); 
				 addSourceParams.put("del_amount", payment.getDelAmount()!=null?payment.getDelAmount():0.0); 
				 addSourceParams.put("com_amount", payment.getComAmount()!=null?payment.getComAmount():0.0); 
				 addSourceParams.put("debit_account", payment.getDebitAccount()!=null?payment.getDebitAccount():3); 
				 addSourceParams.put("qty_debit_account", payment.getQtyDebitAccount()!=null?payment.getQtyDebitAccount():0); 
				 addSourceParams.put("credit_account", payment.getCreditAccount()!=null?payment.getCreditAccount():2); 
				 addSourceParams.put("qty_credit_account", payment.getQtyCreditAccount()!=null?payment.getQtyCreditAccount():0); 
				 addSourceParams.put("qty", payment.getQty()!=null?payment.getQty():0); 
				 addSourceParams.put("customer_id", payment.getCustomerId()!=null?payment.getCustomerId():null); 
				 addSourceParams.put("payment_seq", paymentSeq); 
				 addSourceParams.put("bndl_qty", payment.getBndlQty()!=null?payment.getBndlQty():0); 
				 addSourceParams.put("job_id", payment.getJobId()!=null?payment.getJobId():null); 
				 status = namedParameterJdbcTemplate.update(journalSaveQuery, addSourceParams);
				 customerUtility.updateJournalId(journalId);
			 }
			 
			 Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			 if(status != 0) {
				 addSourceParams.clear();
				 status = 0;
				 String editTrailSaveQuery = "insert into edit_trail(edit_trail_id,customer_id,customer_address_seq,user_code,subscrip_id,orderhdr_id,order_item_seq,order_item_amt_break_seq,edited,currency,table_enum,document_reference_id,document_reference_seq,local_amount,base_amount,date_stamp,creation_date,xaction_name,payment_seq,demographic_seq,job_id,service_seq) values(:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:subscrip_id,:orderhdr_id,:order_item_seq,:order_item_amt_break_seq,:edited,:currency,:table_enum,:document_reference_id,:document_reference_seq,:local_amount,:base_amount,:date_stamp,:creation_date,:xaction_name,:payment_seq,:demographic_seq,:job_id,:service_seq)";
				 addSourceParams.put("edit_trail_id", editTrailId);
				 addSourceParams.put("customer_id", payment.getCustomerId()!=null?payment.getCustomerId():null); 
				 addSourceParams.put("customer_address_seq", payment.getCustomerAddressSeq()!=null?payment.getCustomerAddressSeq():null); 
				 addSourceParams.put("user_code", customerUtility.getStringValue(payment.getUserCode())); 
				 addSourceParams.put("subscrip_id", payment.getSubscripId()!=null?payment.getSubscripId():null); 
				 addSourceParams.put("orderhdr_id", payment.getOrderhdrId()!=null?payment.getOrderhdrId():null); 
				 addSourceParams.put("order_item_seq", payment.getOrderItemSeq()!=null?payment.getOrderItemSeq():null); 
				 addSourceParams.put("order_item_amt_break_seq", payment.getOrderItemAmtBreakSeq()!=null?payment.getOrderItemAmtBreakSeq():null); 
				 addSourceParams.put("edited", payment.getEdited()==null?0:payment.getEdited()); 
				 addSourceParams.put("currency", payment.getCurrency()!=null?payment.getCurrency():null); 
				 addSourceParams.put("table_enum", payment.getTableEnum()!=null?payment.getTableEnum():4); 
				 addSourceParams.put("document_reference_id", payment.getDocumentReferenceId()); 
				 addSourceParams.put("document_reference_seq", payment.getDocumentReferenceSeq()!=null?payment.getDocumentReferenceSeq():null); 
				 addSourceParams.put("local_amount", payment.getLocalAmount()!=null?payment.getLocalAmount():0.0); 
				 addSourceParams.put("base_amount", payment.getBaseAmount()); 
				 addSourceParams.put("date_stamp",dateStamp); 
				 addSourceParams.put("creation_date", LocalDateTime.now()); 
				 addSourceParams.put("xaction_name", "supplemental_refund_add_request");
				 addSourceParams.put("payment_seq", paymentSeq!=0?paymentSeq:null); 
				 addSourceParams.put("demographic_seq", payment.getDemographicSeq()!=null?payment.getDemographicSeq():null); 
				 addSourceParams.put("job_id", payment.getJobId()!=null?payment.getJobId():null); 
				 addSourceParams.put("payment_account_seq", payment.getPaymentAccountSeq()!=null?payment.getPaymentAccountSeq():null); 
				 addSourceParams.put("service_seq", payment.getServiceSeq()!=null?payment.getServiceSeq():null); 
				 status = namedParameterJdbcTemplate.update(editTrailSaveQuery, addSourceParams);
				 customerUtility.updateMruEditTrailId(editTrailId);
			 }
			 
			 if(status != 0) {
				 addSourceParams.clear(); 
				 status = 0;
				 String savePaybreakQuery = "insert into paybreak(customer_id,payment_seq,paybreak_seq,orderhdr_id,order_item_seq,order_item_amt_break_seq,local_amount,base_amount,pay_currency_amount,paybreak_type,oc_id,date_stamp,bogus_commission,local_exchange_rate,edit_trail_id,jrn_flag) values(:customer_id,:payment_seq,:paybreak_seq,:orderhdr_id,:order_item_seq,:order_item_amt_break_seq,:local_amount,:base_amount,:pay_currency_amount,:paybreak_type,:oc_id,:date_stamp,:bogus_commission,:local_exchange_rate,:edit_trail_id,:jrn_flag)";
				 addSourceParams.put("customer_id", payment.getCustomerId());  
				 addSourceParams.put("payment_seq", paymentSeq);
				 String maxIdResult = jdbcTemplate.queryForObject("SELECT max(paybreak_seq) FROM paybreak WHERE customer_id="+payment.getCustomerId()+" and payment_seq="+payment.getPaymentSeq(),String.class);
				if(maxIdResult != null) {
					 addSourceParams.put("paybreak_seq", Integer.valueOf(maxIdResult)+1); 
				 }else {
					 addSourceParams.put("paybreak_seq", 1);  
				 }
				 addSourceParams.put("orderhdr_id", payment.getOrderhdrId()); 
				 addSourceParams.put("order_item_seq", payment.getOrderItemSeq()); 
				 Integer order_item_amt_break_seq = jdbcTemplate.queryForObject("select max(order_item_amt_break_seq) from order_item_amt_break where orderhdr_id="+payment.getOrderhdrId()+" and order_item_seq="+payment.getOrderItemSeq(), Integer.class);
				 if(order_item_amt_break_seq!=null)
					 addSourceParams.put("order_item_amt_break_seq",order_item_amt_break_seq); 
				 baseAmount = new StringBuilder("-").append(payment.getBaseAmount());//baseAmount is a refund amount
				 addSourceParams.put("local_amount", baseAmount); 
				 addSourceParams.put("base_amount", baseAmount); 
				 addSourceParams.put("pay_currency_amount", baseAmount); 
				 addSourceParams.put("paybreak_type", payment.getPaybreakType()!=null?payment.getPaybreakType():0); 
				 addSourceParams.put("oc_id", payment.getOcId()); 
				 addSourceParams.put("date_stamp", dateStamp); 
				 addSourceParams.put("bogus_commission", payment.getBogusCommission()!=null?payment.getBogusCommission():0); 
				 addSourceParams.put("local_exchange_rate", payment.getLocalExchangeRate()!=null?payment.getLocalExchangeRate():1.0); 
				 addSourceParams.put("edit_trail_id",editTrailId); 
				 addSourceParams.put("jrn_flag", payment.getJrnFlag()!=null?payment.getJrnFlag():null); 
				 status = namedParameterJdbcTemplate.update(savePaybreakQuery, addSourceParams);
			 }
			 if(status!=0) {
				 status = 0;
				 status = jdbcTemplate.update("update customer set mru_payment_seq="+paymentSeq+" where customer_id="+payment.getCustomerId());
			  }
			 }catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}

	@Override
	public List<Map<String, Object>> getAuxiliaryFieldsDetails(int customerId, int serviceSeq) {
		List<Map<String,Object>> auxiliaryFieldsDetails =new ArrayList<>();
		try {
			 StringBuilder query = new StringBuilder("SELECT * FROM service_ext ").append("WHERE customer_id=").append(customerId).append(" and service_seq=").append(serviceSeq).append(" ORDER BY customer_id,service_seq");
			 auxiliaryFieldsDetails = jdbcTemplate.queryForList(query.toString());
			}
		catch(Exception e){
			LOGGER.error(ERROR + e);			
		}
		return auxiliaryFieldsDetails;
	}

	@Override
	public int saveAuxiliaryFieldsDetails(HttpServletRequest request) {
		int status = 0;
		LOGGER.info("Inside saveAuxiliaryFieldsDetails");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", "service");
			//parameters.put("custsvc_edit_disposition",0);
			List<String> columnName = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name ORDER BY table_name,column_name", parameters, String.class);
			
			parameters.clear();
			parameters.put("customer_id", request.getParameter("customer_id"));
			parameters.put("service_seq",request.getParameter("service_seq"));
			int auxiliaryCount = namedParameterJdbcTemplate.queryForObject("select count(*) from service_ext where customer_id= :customer_id and service_seq= :service_seq ",parameters,Integer.class);
			Map<String, Object> customerAuxiliaryPreviousData=null;
			if(auxiliaryCount>0)
				customerAuxiliaryPreviousData = namedParameterJdbcTemplate.queryForMap("select * from service_ext where customer_id= :customer_id and service_seq= :service_seq",parameters);
			
			parameters.clear();
			StringBuilder query = new StringBuilder("");
			
			if(!"true".equals(request.getParameter("updateFlag"))) {
				query.append("Insert into service_ext (customer_id,service_seq,");
				
				for(String column: columnName) 
					query.append(column+",");
				query.setLength(query.length() - 1);
				
				query.append(") VALUES(:customer_id,:service_seq,");
				
				for(String column: columnName) {
					query.append(":"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(")");
			}
			else {
				query.append("UPDATE service_ext set ");
				
				for(String column: columnName) {
					query.append(column+"=:"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(" where customer_id=:customer_id and service_seq= :service_seq");
				
			}	
			
			parameters.put("customer_id", request.getParameter("customerId"));
			parameters.put("service_seq", request.getParameter("serviceSeq"));
			
			namedParameterJdbcTemplate.update(query.toString(), parameters);
			
			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}
			
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			
			parameters.clear();
			String editTrailCodeQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,orderhdr_id,service_seq,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
					+ "values (:edit_trail_id,:customer_id,:user_code,:orderhdr_id,:service_seq,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", request.getParameter("customerId"));			
			parameters.put("user_code", request.getParameter("userCode"));
			parameters.put("orderhdr_id", request.getParameter("orderhdrId"));
			parameters.put("service_seq", request.getParameter("serviceSeq"));
			parameters.put("edited", 1);
			parameters.put("table_enum", 11);
			parameters.put("document_reference_id", request.getParameter("documentReferenceId"));
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			//parameters.put("creation_date", new Date());
			parameters.put("xaction_name", "service_edit_request");
			namedParameterJdbcTemplate.update(editTrailCodeQuery, parameters);
			
			customerUtility.updateMruEditTrailId(editTrailId);
			
			for(String column: columnName) {
				if(auxiliaryCount>0) {
					if(!(customerAuxiliaryPreviousData.get(column)==null?"":customerAuxiliaryPreviousData.get(column).toString()).equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, customerAuxiliaryPreviousData.get(column), "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				else {
					if(!"".equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, null, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
			}
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;
	}
	@Override
	public List<CustomerAuxiliaryModel> getServiceAuxiliaryFormField() throws SQLException {
		LOGGER.info("Inside getCustomerAuxiliaryFormField");
		List<CustomerAuxiliaryModel> result = null;
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", "service");
			parameters.put("custsvc_edit_disposition",0);
			result = namedParameterJdbcTemplate.query("SELECT * FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name", parameters, new CustomerAuxiliaryMapper());
			for (CustomerAuxiliaryModel customerAuxiliaryModel : result) {
				customerAuxiliaryModel.setColumnDatatype(new PropertyUtilityClass().getConstantValue("column_datatype_"+customerAuxiliaryModel.getColumnDatatype()));
				if(customerAuxiliaryModel.getLookupTableName()!=null) {
							LinkedHashMap<String, String> values =new LinkedHashMap<String, String>();							
							List<Map<String, Object>> rows = jdbcTemplate.queryForList("select "+customerAuxiliaryModel.getLookupDisplayColumnName()+","+customerAuxiliaryModel.getLookupValueColumnName()
																									+" from "+customerAuxiliaryModel.getLookupTableName());
							for (Map<String, Object> row : rows) {
									values.put(row.get(customerAuxiliaryModel.getLookupDisplayColumnName()).toString(),row.get(customerAuxiliaryModel.getLookupValueColumnName()).toString());
							}
							customerAuxiliaryModel.setValues(values);
					
				}
				}
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return result;
	}
	@Override
	public List<CustomerAuxiliaryModel> getAuxiliaryFields(String action) throws SQLException {
		LOGGER.info("Inside getCustomerAuxiliaryFormField");
		List<CustomerAuxiliaryModel> result = null;
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", action);
			parameters.put("custsvc_edit_disposition",0);
			result = namedParameterJdbcTemplate.query("SELECT * FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name", parameters, new CustomerAuxiliaryMapper());
			for (CustomerAuxiliaryModel customerAuxiliaryModel : result) {
				customerAuxiliaryModel.setColumnDatatype(new PropertyUtilityClass().getConstantValue("column_datatype_"+customerAuxiliaryModel.getColumnDatatype()));
				if(customerAuxiliaryModel.getLookupTableName()!=null) {
							LinkedHashMap<String, String> values =new LinkedHashMap<String, String>();							
							List<Map<String, Object>> rows = jdbcTemplate.queryForList("select "+customerAuxiliaryModel.getLookupDisplayColumnName()+","+customerAuxiliaryModel.getLookupValueColumnName()
																									+" from "+customerAuxiliaryModel.getLookupTableName());
							for (Map<String, Object> row : rows) {
									values.put(row.get(customerAuxiliaryModel.getLookupDisplayColumnName()).toString(),row.get(customerAuxiliaryModel.getLookupValueColumnName()).toString());
							}
							customerAuxiliaryModel.setValues(values);
					
				}
				}
		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return result;
	}
	@Override
	public LinkedHashMap<String, String> setServiceAuxiliaryDetailByID(long customerId, int serviceSeq)
			throws SQLException {
		LOGGER.info("Inside setOrderAuxiliaryDetailByID");
		LinkedHashMap<String, String> customerDetail = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> customerDetail2 = new LinkedHashMap<String, String>();
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> parameters2 = new HashMap<String, Object>();
				parameters.put("customer_id", customerId);
				parameters.put("service_seq", serviceSeq);
				parameters2.put("table_name", "service");
				parameters2.put("custsvc_edit_disposition",0);
				//int count = namedParameterJdbcTemplate.queryForObject("select count(*) from service_ext where customer_id= :customer_id and service_seq= :service_seq",parameters, Integer.class);
				int count = jdbcTemplate.queryForObject("select count(*) from service_ext where customer_id= "+customerId+" and service_seq= "+serviceSeq,Integer.class);
				if(count>0) {
				List<String> fields = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE table_name = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition", parameters2,String.class);
				Map<String, Object> rows = namedParameterJdbcTemplate.queryForMap("select * from service_ext where customer_id= :customer_id and service_seq= :service_seq",parameters);
				for (Map.Entry<String,Object> entry : rows.entrySet()) {
						for(int i=0;i<fields.size();i++) {
							if(fields.contains(entry.getKey())) {
								customerDetail.put(fields.get(i), rows.get(fields.get(i))==null?null:rows.get(fields.get(i)).toString());
						  }
						}
					}
				//trimming only date from date related column
				Set<Entry<String, String>> entries=customerDetail.entrySet();
				for (Entry<String, String> entry : entries) {
					if(entry.getKey().contains("date") && entry.getValue() != null) { 
						String value = entry.getValue();
						String date = value.substring(0, value.indexOf(' '));
						customerDetail2.put(entry.getKey(), date);
					}else {
						customerDetail2.put(entry.getKey(), entry.getValue());
					}
				  }
				}
				
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return customerDetail2;
	}
	@Override
	@Transactional
	public String saveServiceAuxiliary(HttpServletRequest request) throws SQLException {
		LOGGER.info("Inside saveServiceAuxiliary");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", "service");
			parameters.put("custsvc_edit_disposition",0);
			List<String> columnName = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name", parameters, String.class);
			
			parameters.clear();
			parameters.put("customer_id", request.getParameter("customerId"));
			parameters.put("service_seq",request.getParameter("serviceSeq"));
			int auxiliaryCount = namedParameterJdbcTemplate.queryForObject("select count(*) from service_ext where customer_id= :customer_id and service_seq= :service_seq ",parameters,Integer.class);
			Map<String, Object> customerAuxiliaryPreviousData=null;
			if(auxiliaryCount>0)
				customerAuxiliaryPreviousData = namedParameterJdbcTemplate.queryForMap("select * from service_ext where customer_id= :customer_id and service_seq= :service_seq",parameters);
			
			parameters.clear();
			StringBuilder query = new StringBuilder("");
			
			if(!"true".equals(request.getParameter("updateFlag"))) {
				query.append("Insert into service_ext (customer_id,service_seq,");
				
				for(String column: columnName) 
					query.append(column+",");
				query.setLength(query.length() - 1);
				
				query.append(") VALUES(:customer_id,:service_seq,");
				
				for(String column: columnName) {
					query.append(":"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(")");
			}
			else {
				query.append("UPDATE service_ext set ");
				
				for(String column: columnName) {
					query.append(column+"=:"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(" where customer_id=:customer_id and service_seq= :service_seq");
				
			}	
			
			parameters.put("customer_id", request.getParameter("customerId"));
			parameters.put("service_seq", request.getParameter("serviceSeq"));
			
			namedParameterJdbcTemplate.update(query.toString(), parameters);
			
			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}
			
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			
			parameters.clear();
			String editTrailCodeQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,service_seq,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
					+ "values (:edit_trail_id,:customer_id,:user_code,:service_seq,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", request.getParameter("customerId"));			
			parameters.put("user_code", request.getParameter("userCode"));
			//parameters.put("orderhdr_id", request.getParameter("orderhdrId"));
			parameters.put("service_seq", request.getParameter("serviceSeq"));
			parameters.put("edited", 1);
			parameters.put("table_enum", 11);
			parameters.put("document_reference_id", request.getParameter("documentReferenceId"));
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			//parameters.put("creation_date", new Date());
			if(!"true".equals(request.getParameter("updateFlag"))) {
				parameters.put("xaction_name", "service_add_request");
			}else {
				parameters.put("xaction_name", "service_edit_request");
			}
			
			namedParameterJdbcTemplate.update(editTrailCodeQuery, parameters);
			
			customerUtility.updateMruEditTrailId(editTrailId);
			
			for(String column: columnName) {
				if(auxiliaryCount>0) {
					if(!(customerAuxiliaryPreviousData.get(column)==null?"":customerAuxiliaryPreviousData.get(column).toString()).equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, customerAuxiliaryPreviousData.get(column), "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				else {
					if(!"".equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, null, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
			}
			
			
			return "Added";
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}
	@Override
	public Map<String,Object> showReviewJobHistoryButton(long jobId) {
		LOGGER.info("Inside showReviewJobHistoryButton");
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String,Object> result = new LinkedHashMap<>();
			try {
					parameters.put("job_id", jobId);
					StringBuilder query = new StringBuilder("select process_type from process where process_id = (select process_id from job where job_id = ").append(jobId).append(")");
					String processType = jdbcTemplate.queryForObject(query.toString(),String.class);
					result.put("processType",processType);
					// for Rollback & Restart Update button
					String queryForMaxJobId = "select max(job_id) from job where step_name='no step' and process_id = (select process_id from job where job_id = "+jobId+")";
					Long maxJobId = jdbcTemplate.queryForObject(queryForMaxJobId,Long.class);
					long MaxJob = maxJobId!=null?maxJobId:0;
					if(jobId == MaxJob) {
						result.put("Rollback",true);
						result.put("RestartUpdate",true);
					}else {
						result.put("RestartUpdate",false);
					}
					result.put("Reprint",true);
					int countJobRenewalEffort = namedParameterJdbcTemplate.queryForObject("select count(*) from job_renewal_effort where job_id= :job_id ",parameters, Integer.class);
					int countJobBillingEffort = namedParameterJdbcTemplate.queryForObject("select count(*) from job_billing_effort where job_id= :job_id ",parameters, Integer.class);
					if(countJobRenewalEffort > 0 | countJobBillingEffort > 0) {
						result.put("ViewEffort",true);
					}else {
						result.put("ViewEffort",false);
					}
					//for view label details button
					StringBuilder queryForViewLabelDetails = new StringBuilder("select count(*) from view_label_hist_dtl where job_id = ").append(jobId);
					
					Integer viewLabel = jdbcTemplate.queryForObject(queryForViewLabelDetails.toString(),Integer.class);
					
					if(viewLabel!= 0) {
						result.put("viewLabel",true);
					}else {
						result.put("viewLabel",false);
					}
					result.put("viewJobLog",true);
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
			}
		return result;
	}
	@Override
	public LinkedHashMap<String, String> setPaymentAuxiliaryDetailByID(long customerId, int paymentSeq) throws SQLException {
		LOGGER.info("Inside setOrderAuxiliaryDetailByID");
		LinkedHashMap<String, String> paymentDetail = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> paymentDetail2 = new LinkedHashMap<String, String>();
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> parameters2 = new HashMap<String, Object>();
				parameters.put("customer_id", customerId);
				parameters.put("payment_seq", paymentSeq);
				parameters2.put("table_name", "payment");
				parameters2.put("custsvc_edit_disposition",0);
				int count = namedParameterJdbcTemplate.queryForObject("select count(*) from payment_ext where customer_id= :customer_id and payment_seq= :payment_seq",parameters, Integer.class);
				if(count>0) {
				List<String> fields = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE table_name = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition", parameters2,String.class);
				Map<String, Object> rows = namedParameterJdbcTemplate.queryForMap("select * from payment_ext where customer_id= :customer_id and payment_seq= :payment_seq",parameters);
				for (Map.Entry<String,Object> entry : rows.entrySet()) {
						for(int i=0;i<fields.size();i++) {
							if(fields.contains(entry.getKey())) {
								paymentDetail.put(fields.get(i), rows.get(fields.get(i))==null?null:rows.get(fields.get(i)).toString());
							}
						}
					}
				Set<Entry<String, String>> entries=paymentDetail.entrySet();
				for (Entry<String, String> entry : entries) {
					if(entry.getKey().contains("date") && entry.getValue() != null) { 
						String value = entry.getValue();
						String date = value.substring(0, value.indexOf(' '));
						paymentDetail2.put(entry.getKey(), date);
					}else {
						paymentDetail2.put(entry.getKey(), entry.getValue());
					}
				  }
				}
				
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return paymentDetail2;
	}
	@Override
	public int savePaymentAuxiliaryFieldsDetails(HttpServletRequest request) {
			int status = 0;
			LOGGER.info("Inside savePaymentAuxiliaryFieldsDetails");
			try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("table_name", "payment");
				parameters.put("custsvc_edit_disposition",0);
				List<String> columnName = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name", parameters, String.class);
				
				parameters.clear();
				parameters.put("customer_id", request.getParameter("customerId"));
				parameters.put("payment_seq",request.getParameter("paymentSeq"));
				int auxiliaryCount = namedParameterJdbcTemplate.queryForObject("select count(*) from payment_ext where customer_id= :customer_id and payment_seq= :payment_seq",parameters,Integer.class);
				Map<String, Object> customerAuxiliaryPreviousData=null;
				if(auxiliaryCount>0)
					customerAuxiliaryPreviousData = namedParameterJdbcTemplate.queryForMap("select * from payment_ext where customer_id= :customer_id and payment_seq= :payment_seq",parameters);
				
				parameters.clear();
				StringBuilder query = new StringBuilder("");
				
				if(!"true".equals(request.getParameter("updateFlag"))) {
					query.append("Insert into payment_ext (customer_id,payment_seq,");
					
					for(String column: columnName) 
						query.append(column+",");
					query.setLength(query.length() - 1);
					
					query.append(") VALUES(:customer_id,:payment_seq,");
					
					for(String column: columnName) {
						query.append(":"+column+",");
						parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
					}
					query.setLength(query.length() - 1);
					
					query.append(")");
				}
				else {
					query.append("UPDATE payment_ext set ");
					
					for(String column: columnName) {
						query.append(column+"=:"+column+",");
						parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
					}
					query.setLength(query.length() - 1);
					
					query.append(" where customer_id=:customer_id and payment_seq= :payment_seq");
					
				}	
				
				parameters.put("customer_id", request.getParameter("customerId"));
				parameters.put("payment_seq", request.getParameter("paymentSeq"));
				
				status = namedParameterJdbcTemplate.update(query.toString(), parameters);
				
				int count = customerUtility.getcurrentDateStampCount();

				if (count == 0) {
					Long dateStampId = customerUtility.getmaxDateStamp();
					customerUtility.insertDateStamp(dateStampId);
				}
				
				Long dateStamp = customerUtility.getmaxDateStamp();
				Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
				
				parameters.clear();
				String editTrailCodeQuery = "insert into edit_trail "
						+ "(edit_trail_id,customer_id,user_code,payment_seq,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
						+ "values (:edit_trail_id,:customer_id,:user_code,:payment_seq,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name)";

				parameters.put("edit_trail_id", editTrailId);
				parameters.put("customer_id", request.getParameter("customerId"));			
				parameters.put("user_code", request.getParameter("userCode"));
				parameters.put("payment_seq", request.getParameter("paymentSeq"));
				parameters.put("edited", 1);
				parameters.put("table_enum", 4);
				parameters.put("document_reference_id", request.getParameter("documentReferenceId"));
				parameters.put("date_stamp", dateStamp);
				parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
				//parameters.put("creation_date", new Date());
				if(!"true".equals(request.getParameter("updateFlag"))) {
					parameters.put("xaction_name", "payment_add_request");
				}else {
					parameters.put("xaction_name", "payment_edit_request");
				}
				status = 0;
				status = namedParameterJdbcTemplate.update(editTrailCodeQuery, parameters);
				
				customerUtility.updateMruEditTrailId(editTrailId);
				
				for(String column: columnName) {
					if(auxiliaryCount>0) {
						if(!(customerAuxiliaryPreviousData.get(column)==null?"":customerAuxiliaryPreviousData.get(column).toString()).equals(request.getParameter(column)))
							customerUtility.insertEditTrailDelta(editTrailId, column, customerAuxiliaryPreviousData.get(column), "".equals(request.getParameter(column))?null:request.getParameter(column));
					}
					else {
						if(!"".equals(request.getParameter(column)))
							customerUtility.insertEditTrailDelta(editTrailId, column, null, "".equals(request.getParameter(column))?null:request.getParameter(column));
					}
				}
				
				
				return status;
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
				return status;
			}
	}
	@Override
	public LinkedHashMap<String, String> setCustomerLoginAuxiliaryDetailByID(long customerLoginId) throws SQLException {
		LOGGER.info("Inside setCustomerLoginAuxiliaryDetailByID");
		LinkedHashMap<String, String> customerLoginDetail = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> customerLoginDetail2 = new LinkedHashMap<String, String>();
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> parameters2 = new HashMap<String, Object>();
				parameters.put("customer_login_id", customerLoginId);
				parameters2.put("table_name", "customer_login");
				parameters2.put("custsvc_edit_disposition",0);
				int count = namedParameterJdbcTemplate.queryForObject("select count(*) from customer_login_ext where customer_login_id= :customer_login_id",parameters, Integer.class);
				if(count>0) {
				List<String> fields = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE table_name = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition", parameters2,String.class);
				Map<String, Object> rows = namedParameterJdbcTemplate.queryForMap("select * from customer_login_ext where customer_login_id= :customer_login_id",parameters);
				for (Map.Entry<String,Object> entry : rows.entrySet()) {
						for(int i=0;i<fields.size();i++) {
							if(fields.contains(entry.getKey())) {
								customerLoginDetail.put(fields.get(i), rows.get(fields.get(i))==null?null:rows.get(fields.get(i)).toString());
							}
						}
					}
				Set<Entry<String, String>> entries=customerLoginDetail.entrySet();
				for (Entry<String, String> entry : entries) {
					if(entry.getKey().contains("date") && entry.getValue() != null) { 
						String value = entry.getValue();
						String date = value.substring(0, value.indexOf(' '));
						customerLoginDetail2.put(entry.getKey(), date);
					}else {
						customerLoginDetail2.put(entry.getKey(), entry.getValue());
					}
				  }
				}
				
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return customerLoginDetail2;
	}
	@Override
	public int saveCustomerLoginAuxiliaryFieldsDetails(HttpServletRequest request) {
		int status = 0;
		LOGGER.info("Inside saveCustomerLoginAuxiliaryFieldsDetails");
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("table_name", "customer_login");
			parameters.put("custsvc_edit_disposition",0);
			List<String> columnName = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name", parameters, String.class);
			
			parameters.clear();
			parameters.put("customer_login_id", request.getParameter("customerLoginId"));
			int auxiliaryCount = namedParameterJdbcTemplate.queryForObject("select count(*) from customer_login_ext where customer_login_id= :customer_login_id",parameters,Integer.class);
			Map<String, Object> customerAuxiliaryPreviousData=null;
			if(auxiliaryCount>0)
				customerAuxiliaryPreviousData = namedParameterJdbcTemplate.queryForMap("select * from customer_login_ext where customer_login_id= :customer_login_id",parameters);
			
			parameters.clear();
			StringBuilder query = new StringBuilder("");
			
			if(!"true".equals(request.getParameter("updateFlag"))) {
				query.append("Insert into customer_login_ext (customer_login_id,");
				
				for(String column: columnName) 
					query.append(column+",");
				query.setLength(query.length() - 1);
				
				query.append(") VALUES(:customer_login_id,");
				
				for(String column: columnName) {
					query.append(":"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(")");
			}
			else {
				query.append("UPDATE customer_login_ext set ");
				
				for(String column: columnName) {
					query.append(column+"=:"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(" where customer_login_id=:customer_login_id");
				
			}	
			
			parameters.put("customer_login_id", request.getParameter("customerLoginId"));
			
			status = namedParameterJdbcTemplate.update(query.toString(), parameters);
			
			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}
			
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			
			parameters.clear();
			String editTrailCodeQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
					+ "values (:edit_trail_id,:customer_id,:user_code,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", request.getParameter("customerId"));			
			parameters.put("user_code", request.getParameter("userCode"));
			parameters.put("edited", 1);
			parameters.put("table_enum", 0);
			parameters.put("document_reference_id", request.getParameter("documentReferenceId"));
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			//parameters.put("creation_date", new Date());
			if(!"true".equals(request.getParameter("updateFlag"))) {
				parameters.put("xaction_name", "customer_login_add_request");
			}else {
				parameters.put("xaction_name", "customer_login_edit_request");
			}
			status = 0;
			status = namedParameterJdbcTemplate.update(editTrailCodeQuery, parameters);
			
			customerUtility.updateMruEditTrailId(editTrailId);
			
			for(String column: columnName) {
				if(auxiliaryCount>0) {
					if(!(customerAuxiliaryPreviousData.get(column)==null?"":customerAuxiliaryPreviousData.get(column).toString()).equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, customerAuxiliaryPreviousData.get(column), "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				else {
					if(!"".equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, null, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
			}
			
			
			return status;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return status;
		}
	}
	@Override
	public LinkedHashMap<String, String> setCustomerAddressAuxiliaryDetailByID(long customerId, int customerAddressSeq) throws SQLException {
		LOGGER.info("Inside setCustomerAddressAuxiliaryDetailByID");
		LinkedHashMap<String, String> customerAddressDetail = new LinkedHashMap<String, String>();
		LinkedHashMap<String, String> customerAddressDetail2 = new LinkedHashMap<String, String>();
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> parameters2 = new HashMap<String, Object>();
				parameters.put("customer_id", customerId);
				parameters.put("customer_address_seq", customerAddressSeq);
				parameters2.put("table_name", "customer_address");
				parameters2.put("custsvc_edit_disposition",0);
				int count = namedParameterJdbcTemplate.queryForObject("select count(*) from customer_address_ext where customer_id= :customer_id and customer_address_seq= :customer_address_seq",parameters, Integer.class);
				if(count>0) {
				List<String> fields = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE table_name = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition", parameters2,String.class);
				Map<String, Object> rows = namedParameterJdbcTemplate.queryForMap("select * from customer_address_ext where customer_id= :customer_id and customer_address_seq= :customer_address_seq",parameters);
				for (Map.Entry<String,Object> entry : rows.entrySet()) {
						for(int i=0;i<fields.size();i++) {
							if(fields.contains(entry.getKey())) {
								customerAddressDetail.put(fields.get(i), rows.get(fields.get(i))==null?null:rows.get(fields.get(i)).toString());
							}
						}
					}
				Set<Entry<String, String>> entries=customerAddressDetail.entrySet();
				for (Entry<String, String> entry : entries) {
					if(entry.getKey().contains("date") && entry.getValue() != null) { 
						String value = entry.getValue();
						String date = value.substring(0, value.indexOf(' '));
						customerAddressDetail2.put(entry.getKey(), date);
					}else {
						customerAddressDetail2.put(entry.getKey(), entry.getValue());
					}
				  }
				}
				
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		
		return customerAddressDetail2;
	}
	@Override
	public int saveCustomerAddressFieldsDetails(HttpServletRequest request) {
		int status = 0;
		LOGGER.info("Inside saveCustomerLoginAuxiliaryFieldsDetails");
		try {
			Map<String, Object> parameters = new LinkedHashMap<String, Object>();
			parameters.put("table_name", "customer_address");
			parameters.put("custsvc_edit_disposition",0);
			List<String> columnName = namedParameterJdbcTemplate.queryForList("SELECT column_name FROM aux_field WHERE LOWER(table_name) = :table_name and custsvc_edit_disposition != :custsvc_edit_disposition ORDER BY table_name,column_name", parameters, String.class);
			
			parameters.clear();
			parameters.put("customer_id", request.getParameter("customerId"));
			parameters.put("customer_address_seq", request.getParameter("customerAddressSeq"));
			int auxiliaryCount = namedParameterJdbcTemplate.queryForObject("select count(*) from customer_address_ext where customer_id= :customer_id and customer_address_seq= :customer_address_seq",parameters,Integer.class);
			Map<String, Object> customerAuxiliaryPreviousData=null;
			if(auxiliaryCount>0)
				customerAuxiliaryPreviousData = namedParameterJdbcTemplate.queryForMap("select * from customer_address_ext where customer_id= :customer_id and customer_address_seq= :customer_address_seq",parameters);
			
			parameters.clear();
			StringBuilder query = new StringBuilder("");
			
			if(!"true".equals(request.getParameter("updateFlag"))) {
				query.append("Insert into customer_address_ext (customer_id,customer_address_seq,");
				
				for(String column: columnName) 
					query.append(column+",");
				query.setLength(query.length() - 1);
				
				query.append(") VALUES(:customer_id,:customer_address_seq,");
				
				for(String column: columnName) {
					query.append(":"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(")");
			}
			else {
				query.append("UPDATE customer_address_ext set ");
				
				for(String column: columnName) {
					query.append(column+"=:"+column+",");
					parameters.put(column, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				query.setLength(query.length() - 1);
				
				query.append(" where customer_id=:customer_id and customer_address_seq=:customer_address_seq");
				
			}	
			
			parameters.put("customer_id", request.getParameter("customerId"));
			parameters.put("customer_address_seq", request.getParameter("customerAddressSeq"));
			
			status = namedParameterJdbcTemplate.update(query.toString(), parameters);
			
			int count = customerUtility.getcurrentDateStampCount();

			if (count == 0) {
				Long dateStampId = customerUtility.getmaxDateStamp();
				customerUtility.insertDateStamp(dateStampId);
			}
			
			Long dateStamp = customerUtility.getmaxDateStamp();
			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			
			parameters.clear();
			String editTrailCodeQuery = "insert into edit_trail "
					+ "(edit_trail_id,customer_id,customer_address_seq,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name) "
					+ "values (:edit_trail_id,:customer_id,:customer_address_seq,:user_code,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name)";

			parameters.put("edit_trail_id", editTrailId);
			parameters.put("customer_id", request.getParameter("customerId"));	
			parameters.put("customer_address_seq", request.getParameter("customerAddressSeq"));
			parameters.put("user_code", request.getParameter("userCode"));
			parameters.put("edited", 1);
			parameters.put("table_enum", 1);
			parameters.put("document_reference_id", request.getParameter("documentReferenceId"));
			parameters.put("date_stamp", dateStamp);
			parameters.put("creation_date", formatYYYYMMDDHHMMSS.format(new Date()));
			//parameters.put("creation_date", new Date());
			if(!"true".equals(request.getParameter("updateFlag"))) {
				parameters.put("xaction_name", "customer_address_add_request");
			}else {
				parameters.put("xaction_name", "customer_address_edit_request");
			}
			status = 0;
			status = namedParameterJdbcTemplate.update(editTrailCodeQuery, parameters);
			
			customerUtility.updateMruEditTrailId(editTrailId);
			
			for(String column: columnName) {
				if(auxiliaryCount>0) {
					if(!(customerAuxiliaryPreviousData.get(column)==null?"":customerAuxiliaryPreviousData.get(column).toString()).equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, customerAuxiliaryPreviousData.get(column), "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
				else {
					if(!"".equals(request.getParameter(column)))
						customerUtility.insertEditTrailDelta(editTrailId, column, null, "".equals(request.getParameter(column))?null:request.getParameter(column));
				}
			}
			
			
			return status;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return status;
		}
	}
	@Override
	public List<DropdownModel> getPaymentAccountList(int customerId, int active) {
		List<Map<String,Object>> paymentAccountData = new ArrayList<>();
		List<DropdownModel> paymentAccountList = new ArrayList<>();
		try {
			//paymentAccountData = jdbcTemplate.queryForList("SELECT payment_account_seq,description,id_nbr_last_four FROM payment_account WHERE customer_id = "+customerId+" and is_active = "+active+" and payment_type in (select payment_type from payment_type where payment_form in (1, 7)) ORDER BY customer_id,payment_account_seq");
			paymentAccountData = jdbcTemplate.queryForList("SELECT payment_account_seq,description,id_nbr_last_four,id_nbr,credit_card_expire,payment_type,credit_card_info as name_on_card FROM payment_account WHERE customer_id = "+customerId+" and is_active = "+active+" and payment_type in (select payment_type from payment_type where payment_form in (1, 7)) ORDER BY customer_id,payment_account_seq");
			for (Map<String, Object> action : paymentAccountData) {
				   DropdownModel model = new DropdownModel();
	               model.setKey(action.get("payment_account_seq")!=null?action.get("payment_account_seq").toString():"");
	               model.setDescription(action.get("description")!=null?action.get("description").toString():"");
	               model.setDisplay(action.get("id_nbr_last_four")!=null?action.get("id_nbr_last_four").toString():"");
	               model.setExtra(action.get("id_nbr")!=null?customerUtility.decryptedCardNumber(action.get("id_nbr").toString()):"");
	               model.setExtraData(action.get("credit_card_expire")!=null?action.get("credit_card_expire").toString():"");
	               model.setExtraDataDef(action.get("payment_type")!=null?action.get("payment_type").toString():"");
	               model.setExtraDataDef2(action.get("name_on_card")!=null?action.get("name_on_card").toString():"");
	               paymentAccountList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return paymentAccountList;
	}
	@Override
	public List<DropdownModel> getRefundCardDetails(int paymentAccountSeq, int idNbrLastFour) {
		List<Map<String,Object>> refundCardDetailsData = new ArrayList<>();
		List<DropdownModel> refundCardDetails = new ArrayList<>();
		try {
			refundCardDetailsData = jdbcTemplate.queryForList("select payment_account_seq,id_nbr,payment_type,credit_card_expire,credit_card_info as name_on_card from payment_account where payment_account_seq="+paymentAccountSeq+" and id_nbr_last_four="+idNbrLastFour);
			refundCardDetailsData.forEach(action->{
				  DropdownModel model = new DropdownModel();
	               model.setKey(action.get("payment_account_seq")!=null?action.get("payment_account_seq").toString():"");
	               model.setDisplay(action.get("id_nbr")!=null?action.get("id_nbr").toString():"");
	               model.setExtra(action.get("payment_type")!=null?action.get("payment_type").toString():"");
	               model.setExtraData(action.get("credit_card_expire")!=null?action.get("credit_card_expire").toString():"");
	               model.setDescription(action.get("name_on_card")!=null?action.get("name_on_card").toString():"");
	               refundCardDetails.add(model);
			});
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return refundCardDetails;
	}
	@Override
	public List<Map<String,Object>> getAmountToCurrencyConversion(long orderhdrId, int orderItemSeq) {
		List<Map<String,Object>> amountList= null;
		StringBuilder query = new StringBuilder("SELECT cast(isnull(sum(pb.local_amount),0 ) as decimal(10,2)) as amount,oi.currency FROM order_item oi, paybreak pb ")
							  .append("left join customer on pb.customer_id = customer.customer_id ")
							  .append("left join payment on payment.customer_id=customer.customer_id ")
							  .append("WHERE oi.orderhdr_id = ").append(orderhdrId)
							  .append("and oi.order_item_seq = ").append(orderItemSeq)
							  .append("and pb.orderhdr_id = oi.orderhdr_id and pb.order_item_seq = oi.order_item_seq ")
							  .append("and payment.customer_id = pb.customer_id and payment.payment_seq = pb.payment_seq ")
							  .append("GROUP BY oi.currency");
		try {
				amountList = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return amountList;
	}
	@Override
	public List<Map<String, Object>> getCurrencyDetails(String currency) {
		List<Map<String,Object>> currencyList= null;
		String query = "select currency,user_code,description,exchange_rate,n_decimal_places,change_date,currency_symbol,html_symbol,iso4217_num_code,date_stamp from currency where currency='"+currency+"'";
		try {
			currencyList = jdbcTemplate.queryForList(query.toString());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return currencyList;
	}
	
	@Override
	public float covertedAmountByCurrency(float amount, String currency) {
		float finalConvertdAmount = 0;
		int count = 0;
		List<Map<String,Object>> currencyList = null;
		if(count == 0) {
			count++;
			currencyList = getCurrencyDetails(currency);
		}
		if (currencyList != null){
			BigDecimal exchangeRate = (BigDecimal)currencyList.get(0).get("exchange_rate");
			short n_decimal_places = (short) currencyList.get(0).get("n_decimal_places");
			//currency conversion logic
			float exchangedAmount = 1/exchangeRate.floatValue();
			float convertedAmount = Float.valueOf(amount) * exchangedAmount;
			int n_decimal_places1 = (int)n_decimal_places;
			finalConvertdAmount = round(convertedAmount, n_decimal_places1);
	}
	return finalConvertdAmount;
  }
}

