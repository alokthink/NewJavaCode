package com.mps.think.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.impl.io.SocketOutputBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.tempuri.CryptoServiceLocator;
import org.tempuri.CryptoServiceSoap;

import com.mps.think.dao.PaymentInfoDao;
import com.mps.think.model.CustomerOrderModel;
import com.mps.think.model.CustomerOrderPayment;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.JournalDepositModel;
import com.mps.think.model.OrderDetailsModel;
import com.mps.think.model.OrderItem;
import com.mps.think.model.OrderItemAccountModel;
import com.mps.think.model.OrderItemAmtBreak;
import com.mps.think.model.PaybreakModel;
import com.mps.think.model.PaymentModel;
import com.mps.think.model.PaymentReview;
import com.mps.think.model.TotalDepositSummaryModel;
import com.mps.think.resultMapper.CustomerOrderFilterMapper;
import com.mps.think.resultMapper.CustomerPaymentMapper;
import com.mps.think.resultMapper.JournalDepositMapper;
import com.mps.think.resultMapper.OrderDetailsMapper;
import com.mps.think.resultMapper.OrderItemAccountMapper;
import com.mps.think.resultMapper.OrderLookupSearchMapper;
import com.mps.think.resultMapper.PaybreakMapper;
import com.mps.think.resultMapper.PaymentMapper;
import com.mps.think.resultMapper.ReviewAccontingMapper;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
import com.mps.think.wsdl.PaymentWsdl;

import Think.XmlWebServices.Order_payment_select_responsePayment_on_order;

@Repository
public class PaymentInfoDaoImpl implements PaymentInfoDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private CustomerUtility customerUtility;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<DropdownModel> getPaymentType() {
		List<Map<String, Object>> rows = new ArrayList<>();
		List<DropdownModel> paymentType = new ArrayList<>();
		try {
			rows = jdbcTemplate.queryForList("select payment_type,description,credit_card_type,payment_form from payment_type;");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_type").toString());
				model.setDescription(row.get("description") != null ? row.get("description").toString() : "");
				model.setExtraDataDef(row.get("credit_card_type") != null ? row.get("credit_card_type").toString() : "");
				model.setExtraDataDef2(row.get("payment_form") != null ? row.get("payment_form").toString() : "");
				paymentType.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return paymentType;

	}

	public List<Map<String, Object>> getCurrencyType() {
		List<Map<String, Object>> rows = new ArrayList<>();
		try {
			rows = jdbcTemplate
					.queryForList("select currency,description,currency_symbol,exchange_rate from currency;");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return rows;

	}

	/*
	 * public List<Map<String, Object>> getAllPayment(String customerId){
	 * List<Map<String, Object>> rows=new ArrayList<>(); try { rows = jdbcTemplate
	 * .queryForList("select customer_id,payment_seq,user_code,is_reversed,creation_date,user_code,transaction_type,payment_type,currency,payment_clear_status,pay_currency_amount,transaction_reason,check_number from payment where customer_id = "
	 * +customerId); } catch(Exception e){ LOGGER.error(ERROR + e);
	 * 
	 * } return rows;
	 * 
	 * }
	 */
	public List<PaymentModel> getAllPayment(String customerId, int filterDropdown, String orderhdrId) {
		List<PaymentModel> allPaymentDetails = new ArrayList<>();
		/*
		 * try { String paymentQueryforView =
		 * "select * from payment where customer_id =?"; allPaymentDetails =
		 * jdbcTemplate.query(paymentQueryforView,new Object[]{customerId}, new
		 * PaymentMapper()); }
		 */
		try {
			StringBuilder queryForPaymentSearch = new StringBuilder();
//			 queryForPaymentSearch.append("select * from payment where customer_id ="+customerId);
			if (filterDropdown == 0) {
				queryForPaymentSearch.append("SELECT distinct customer_id,payment_seq,customer_deposit_pay_amt,"
						+ "user_code,currency,date_stamp,CONVERT(VARCHAR(10), creation_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), creation_date, 22), 11)) as creation_date,id_nbr,exp_date,ref_nbr,auth_code,auth_date,clear_date,payment_clear_status,effort_nbr,commission,"
						+ "payment_type,credit_card_info,base_amount,pay_currency_amount,transaction_reason,transaction_type,payment_clear_method,realize_cash_when,"
						+ "pay_exchange_rate,is_reversed,status_noedit,processing,nbr_times_issued,pending_xaction_header_id,credit_card_start_date,"
						+ "card_verification_value,credit_card_issue_id,credit_card_bill_customer_id,credit_card_bill_address_seq,refund_deposit_pay_amt,check_number,"
						+ "ics_bank_def_id,cash_realized,deposit_transaction,is_ecommerce,is_recurring,max_settle_retries,n_days_between_settle_retries,"
						+ "next_settle_retry_date,n_settle_retries_left,cancel_itm_after_settle_retry,payment_account_seq,bacs_id,needs_memo_post,id_nbr_last_four,"
						+ "suspend_after_n_settle_retries FROM view_payment_tab_list_all WHERE customer_id ="
						+ customerId);
			}
			if (filterDropdown == 1) {
				queryForPaymentSearch.append("SELECT distinct customer_id,payment_seq,customer_deposit_pay_amt,"
						+ "user_code,currency,date_stamp,CONVERT(VARCHAR(10), creation_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), creation_date, 22), 11)) as creation_date,id_nbr,exp_date,ref_nbr,auth_code,auth_date,clear_date,payment_clear_status,effort_nbr,commission,"
						+ "payment_type,credit_card_info,base_amount,pay_currency_amount,transaction_reason,transaction_type,payment_clear_method,realize_cash_when,"
						+ "pay_exchange_rate,is_reversed,status_noedit,processing,nbr_times_issued,pending_xaction_header_id,credit_card_start_date,"
						+ "card_verification_value,credit_card_issue_id,credit_card_bill_customer_id,credit_card_bill_address_seq,refund_deposit_pay_amt,check_number,"
						+ "ics_bank_def_id,cash_realized,deposit_transaction,is_ecommerce,is_recurring,max_settle_retries,n_days_between_settle_retries,"
						+ "next_settle_retry_date,n_settle_retries_left,cancel_itm_after_settle_retry,payment_account_seq,bacs_id,needs_memo_post,id_nbr_last_four,"
						+ "suspend_after_n_settle_retries FROM view_payment_tab_list_all WHERE o_customer_id ="
						+ customerId + "ORDER BY payment_seq");
			}
			if (filterDropdown == 2) {
				queryForPaymentSearch.append(
						"select distinct customer_id,payment_seq,user_code,currency,date_stamp,CONVERT(VARCHAR(10), creation_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), creation_date, 22), 11)) as creation_date,id_nbr,exp_date,ref_nbr,"
								+ "auth_code,auth_date,clear_date,payment_clear_status,effort_nbr,commission,payment_type,credit_card_info,base_amount,pay_currency_amount,"
								+ "transaction_reason,transaction_type,payment_clear_method,realize_cash_when,pay_exchange_rate,is_reversed,status_noedit,processing,"
								+ "customer_deposit_pay_amt,nbr_times_issued,pending_xaction_header_id,credit_card_start_date,card_verification_value,credit_card_issue_id,"
								+ "credit_card_bill_customer_id,credit_card_bill_address_seq,refund_deposit_pay_amt,check_number,ics_bank_def_id,"
								+ "cash_realized,deposit_transaction,is_ecommerce,is_recurring,max_settle_retries,n_days_between_settle_retries,next_settle_retry_date,"
								+ "n_settle_retries_left,cancel_itm_after_settle_retry,payment_account_seq,bacs_id,needs_memo_post,id_nbr_last_four,"
								+ "suspend_after_n_settle_retries FROM view_payment_tab_list_all WHERE o_orderhdr_id ="
								+ orderhdrId + "ORDER BY payment_seq");
			}
			if (filterDropdown == 3) {
				queryForPaymentSearch.append(
						"select CONVERT(VARCHAR(10), creation_date, 101) + ' ' + LTRIM(RIGHT(CONVERT(CHAR(20), creation_date, 22), 11)) as creation_date,* from view_payment_tab_list_all where customer_id ="
								+ customerId + "ORDER BY payment_seq desc");
			}
			allPaymentDetails = jdbcTemplate.query(queryForPaymentSearch.toString(), new PaymentMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return allPaymentDetails;
	}

	public List<Map<String, Object>> getPaymentAccount() {
		List<Map<String, Object>> rows = new ArrayList<>();
		try {
			rows = jdbcTemplate.queryForList(
					"select payment_account_seq,is_active,description,creation_date from payment_account;");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return rows;

	}

	public PaymentModel getCustomerDetailsForPayment(String customerId) {
		List<Map<String, Object>> customerDetailsList = new ArrayList<>();
		PaymentModel customerDetails = new PaymentModel();
		try {
			customerDetailsList = jdbcTemplate.queryForList(
					"select CONCAT(c.fname,' ',c.lname)as nameOnCard,CONCAT(c.fname,' ',c.lname)as fullname,c.customer_id,c.creation_date,ca.address1,ca.city from customer c inner join customer_address ca on c.customer_id =ca.customer_id where  c.customer_id="
							+ customerId);
			// System.out.println("Cust"+customerDetailsList );
			for (Map<String, Object> custometDetailsMap : customerDetailsList) {
				// orderItem.setOrderhdrId(Long.parseLong(orderItemMap.get("orderhdr_id").toString()));
				customerDetails.setCustomer_id(Integer.parseInt(custometDetailsMap.get("customer_id").toString()));
				// customerDetails.setfName(custometDetailsMap.get("fname").toString());
				// customerDetails.setlName(custometDetailsMap.get("lname").toString());
				customerDetails.setNameOnCard(custometDetailsMap.get("nameOnCard").toString());
				customerDetails.setFullName(custometDetailsMap.get("fullname").toString());
				customerDetails.setCreation_date(custometDetailsMap.get("creation_date").toString());
				// customerDetails.setState(custometDetailsMap.get("state").toString());
				customerDetails.setAddress1(custometDetailsMap.get("address1").toString());
				customerDetails.setCity(custometDetailsMap.get("city").toString());

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return customerDetails;

	}

	public List<DropdownModel> getPayerCustomer(int customerId, int orderId) {
		List<Map<String, Object>> rows = new ArrayList<>();
		List<DropdownModel> payerList = new ArrayList<>();
		try {
			String serviceSeqresult = jdbcTemplate.queryForObject(
					"select max (order_item_seq)  from order_item where customer_id =" + customerId, String.class);
			if (serviceSeqresult != null) {
				if (orderId != 0) {
					rows = jdbcTemplate.queryForList(
							"select c.customer_id,CONCAT(c.fname,' ',c.lname)as fullname,c.company from customer c "
									+ " where  c.customer_id in (select distinct bill_to_customer_id  from order_item where customer_id = "
									+ customerId + "and orderhdr_id = " + orderId + ")" + "or  customer_id ="
									+ customerId);
				} else {
					rows = jdbcTemplate.queryForList(
							"select c.customer_id,CONCAT(c.fname,' ',c.lname)as fullname,c.company from customer c "
									+ " where  c.customer_id in (select distinct bill_to_customer_id  from order_item where customer_id = "
									+ customerId
									+ "and payment_status in (0,5) AND cancel_date is null and gross_local_amount <>0"
									+ ")" + "or  customer_id =" + customerId);
				}

			} else {
				rows = jdbcTemplate
						.queryForList("select c.customer_id,CONCAT(c.fname,' ',c.lname)as fullname from customer c "
								+ " where c.customer_id = " + customerId);
			}
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("customer_id").toString());
				if (!" ".equals(row.get("fullname").toString())) {
					model.setDisplay(row.get("fullname").toString());
				} else if (row.get("company") != null || !" ".equals((String) row.get("company"))) {
					model.setDisplay((String) row.get("company"));
				} else {
					model.setDisplay(row.get("customer_id").toString());
				}

				payerList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return payerList;

	}

	public List<DropdownModel> getPayerCustomerAddress(int customer_id) {
		List<Map<String, Object>> rows = new ArrayList<>();
		List<DropdownModel> payerAddressList = new ArrayList<>();

		try {

			String serviceSeqresult = jdbcTemplate.queryForObject(
					"select max (order_item_seq)  from order_item where customer_id =" + customer_id, String.class);
			if (serviceSeqresult != null) {
				rows = jdbcTemplate.queryForList(
						"select ca.customer_id,ca.address1,ca.address2,ca.address3,ca.city from customer_address ca "
								+ " where  ca.customer_id = " + customer_id);
			} else {
				rows = jdbcTemplate.queryForList(
						"select ca.customer_id,ca.address1,ca.address2,ca.address3,ca.city from customer_address ca "
								+ " where  ca.customer_id  = " + customer_id);

			}
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("customer_id").toString());
				if (row.get("address1") != null || row.get("address2") != null || row.get("address3") != null) {
					model.setDisplay(row.get("customer_id").toString() + ":" + row.get("address1") != null
							? row.get("address1").toString()
							: "" + "," + row.get("address2") != null ? row.get("address2").toString()
									: "" + "," + row.get("address3") != null ? row.get("address3").toString() : "");
				} else {
					model.setDisplay(row.get("customer_id").toString() + ":" + row.get("city").toString());
				}

				payerAddressList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return payerAddressList;

	}

	public List<Map<String, Object>> getOrderDetaiils(String customerId) {
		List<Map<String, Object>> orderDetails = new ArrayList<>();
		try {
			orderDetails = jdbcTemplate.queryForList(
					"select oi.order_item_type,oi.order_date,oi.order_code_id,oi.billing_type,oi.bill_to_customer_id,oi.order_qty,oi.currency,oi.has_delivery_charge,oc.order_code_type,oc.order_code,oc.price"
							+ " from order_item oi inner join order_code oc on oi.order_code_id = oc.order_code_id where oi.customer_id="
							+ customerId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderDetails;
	}

	public void addPayment(PaymentModel paymentModel) {

		String addpaymentquery = "insert into payment (customer_id,payment_seq,user_code,currency,date_stamp,creation_date,id_nbr,exp_date,ref_nbr,auth_code,auth_date,"
				+ " clear_date,payment_clear_status,effort_nbr,commission,payment_type,credit_card_info,base_amount,pay_currency_amount,transaction_reason,"
				+ " transaction_type,payment_clear_method,realize_cash_when,pay_exchange_rate,is_reversed,status_noedit,processing,mru_paybreak_seq,"
				+ " customer_deposit_pay_amt,nbr_times_issued,pending_xaction_header_id,credit_card_start_date,card_verification_value,credit_card_issue_id,"
				+ " credit_card_bill_customer_id,credit_card_bill_address_seq,refund_deposit_pay_amt,check_number,ics_bank_def_id,"
				+ " cash_realized,mru_payment_note_seq,deposit_transaction,is_ecommerce,is_recurring,max_settle_retries,n_days_between_settle_retries,"
				+ " next_settle_retry_date,n_settle_retries_left,cancel_itm_after_settle_retry,payment_account_seq,needs_memo_post,id_nbr_last_four,"
				+ " bacs_id,cc_cleaned,hosted_secure_token_pmt,ba_nbr) values "
				+ " (:customer_id,:payment_seq,:user_code,:currency,:date_stamp,:creation_date,:id_nbr,GETDATE(),:ref_nbr,:auth_code,:auth_date,"
				+ " :clear_date,:payment_clear_status,:effort_nbr,:commission,:payment_type,:credit_card_info,:base_amount,:pay_currency_amount,:transaction_reason,"
				+ " :transaction_type,:payment_clear_method,:realize_cash_when,:pay_exchange_rate,:is_reversed,:status_noedit,:processing,:mru_paybreak_seq,"
				+ " :customer_deposit_pay_amt,:nbr_times_issued,:pending_xaction_header_id,GETDATE(),:card_verification_value,:credit_card_issue_id,"
				+ " :credit_card_bill_customer_id,:credit_card_bill_address_seq,:refund_deposit_pay_amt,:check_number,:ics_bank_def_id,"
				+ " :cash_realized,:mru_payment_note_seq,:deposit_transaction,:is_ecommerce,:is_recurring,:max_settle_retries,:n_days_between_settle_retries,"
				+ " GETDATE(),:n_settle_retries_left,:cancel_itm_after_settle_retry,:payment_account_seq,:needs_memo_post,:id_nbr_last_four,"
				+ ":bacs_id,:cc_cleaned,:hosted_secure_token_pmt,:ba_nbr)";

		Map<String, Object> paymentParameters = new HashMap<String, Object>();

		paymentParameters.put("customer_id", paymentModel.getCustomer_id());
		try {
			
		String PaymentSeqresult = jdbcTemplate.queryForObject(
				"select max(payment_seq) from payment where customer_id =" + paymentModel.getCustomer_id(),
				String.class);
		int dateStamp = jdbcTemplate.queryForObject("select max(date_stamp) from date_stamp", int.class);
		if (PaymentSeqresult != null) {
			paymentParameters.put("payment_seq", Integer.parseInt(PaymentSeqresult) + 1);
		} else {
			paymentParameters.put("payment_seq", 1);
		}

		paymentParameters.put("user_code", "THK");
		paymentParameters.put("currency", paymentModel.getCurrencyType());
		paymentParameters.put("date_stamp", dateStamp);
		paymentParameters.put("creation_date", paymentModel.getCreation_date());
		paymentParameters.put("id_nbr", "a");
		// paymentParameters.put("exp_date", "date");
		paymentParameters.put("ref_nbr", "0");
		paymentParameters.put("auth_code", paymentModel.getAuth_code());
		paymentParameters.put("auth_date", paymentModel.getAuth_date());

		paymentParameters.put("clear_date", paymentModel.getClear_date());
		paymentParameters.put("payment_clear_status", 0);
		paymentParameters.put("effort_nbr", 0);
		paymentParameters.put("commission", 0);
		paymentParameters.put("payment_type", "CA");
		paymentParameters.put("credit_card_info", "NULL");
		paymentParameters.put("base_amount", 0);//
		paymentParameters.put("pay_currency_amount", 0);//
		paymentParameters.put("transaction_reason", "REFCANCEL");

		paymentParameters.put("transaction_type", 0);
		paymentParameters.put("payment_clear_method", 0);
		paymentParameters.put("realize_cash_when", 1);
		paymentParameters.put("pay_exchange_rate", 0.001);//
		paymentParameters.put("is_reversed", 0);
		paymentParameters.put("status_noedit", 0);
		paymentParameters.put("processing", 0);
		paymentParameters.put("mru_paybreak_seq", 1);
		paymentParameters.put("customer_deposit_pay_amt", 0);//
		paymentParameters.put("nbr_times_issued", 0);
		paymentParameters.put("pending_xaction_header_id", 1);
		// paymentParameters.put("credit_card_start_date",paymentModel.getCreditCardStartDate());
		paymentParameters.put("card_verification_value", paymentModel.getCard_verification_value());
		paymentParameters.put("credit_card_issue_id", paymentModel.getCredit_card_issue_id());
		paymentParameters.put("credit_card_bill_customer_id", null);
		paymentParameters.put("credit_card_bill_address_seq", null);
		paymentParameters.put("refund_deposit_pay_amt", 1);
		paymentParameters.put("check_number", "1");
		paymentParameters.put("ics_bank_def_id", null);
		// paymentParameters.put("row_version", null);
		paymentParameters.put("cash_realized", 1);
		paymentParameters.put("mru_payment_note_seq", null);
		paymentParameters.put("deposit_transaction", 0);
		paymentParameters.put("is_ecommerce", 0);
		paymentParameters.put("is_recurring", 0);
		paymentParameters.put("max_settle_retries", null);
		paymentParameters.put("n_days_between_settle_retries", null);
		// paymentParameters.put("next_settle_retry_date", null);
		paymentParameters.put("n_settle_retries_left", null);
		paymentParameters.put("cancel_itm_after_settle_retry", 0);
		paymentParameters.put("payment_account_seq", null);
		paymentParameters.put("needs_memo_post", 0);
		paymentParameters.put("id_nbr_last_four", "Null");
		paymentParameters.put("bacs_id", null);
		paymentParameters.put("cc_cleaned", 0);
		paymentParameters.put("hosted_secure_token_pmt", 0);
		paymentParameters.put("ba_nbr", "1");
		// System.out.println(paymentParameters);
		// System.out.println(addpaymentquery);

		namedParameterJdbcTemplate.update(addpaymentquery, paymentParameters);

		paymentParameters.clear();
//		String editTrailId = jdbcTemplate.queryForObject(
//				"select max(edit_trail_id) from edit_trail where customer_id =" + paymentModel.getCustomer_id(),
//				String.class);
		long editTrailId = new CustomerUtility().getmaxeditTrailId() + 1;
		int documentReferenceId = jdbcTemplate.queryForObject("select bypass_doc_ref_id from config;", int.class);

		int paymentSeq = jdbcTemplate.queryForObject("select max(payment_seq) from payment", int.class);
		String editTrailAddressQuery = "insert into edit_trail "
				+ "(edit_trail_id,customer_id,user_code,edited,table_enum,document_reference_id,date_stamp,creation_date,xaction_name,payment_seq) "
				+ "values (:edit_trail_id,:customer_id,:user_code,:edited,:table_enum,:document_reference_id,:date_stamp,:creation_date,:xaction_name,:payment_seq)";

		paymentParameters.put("edit_trail_id", editTrailId);
		paymentParameters.put("customer_id", paymentModel.getCustomer_id());
		paymentParameters.put("user_code", "THK");
		paymentParameters.put("edited", 0);
		paymentParameters.put("table_enum", 1);
		paymentParameters.put("document_reference_id", documentReferenceId);
		paymentParameters.put("date_stamp", dateStamp);

		paymentParameters.put("creation_date", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		paymentParameters.put("xaction_name", "customer_address_add_request");
		paymentParameters.put("payment_seq", paymentSeq);
		//paymentParameters.put("customer_address_seq", maxAddressSeqId + 1);
		namedParameterJdbcTemplate.update(editTrailAddressQuery, paymentParameters);
		new CustomerUtility().updateMruEditTrailId(editTrailId);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
	}

	/*
	 * public void addPaymentJournal (PaymentModel paymentModel){ String
	 * addPaymentJournalQuery =
	 * "insert into journal (journal_id,orderhdr_id,order_item_seq,posting_reference,tax_amount,net_amount,del_amount,"
	 * +
	 * "com_amount,debit_account,qty_debit_account,credit_account,qty_credit_account,qty,customer_id,payment_seq,row_version,bndl_qty,job_id) values"
	 * +" (:journal_id,:journal_id,:orderhdr_id,:order_item_seq,:posting_reference,:tax_amount,:net_amount,:del_amount,"
	 * +
	 * ":com_amount,:debit_account,:qty_debit_account,:credit_account,:qty_credit_account,:qty,:customer_id,:payment_seq,:row_version,:bndl_qty,:job_id)";
	 * 
	 * 
	 * Map<String, Object> journalParameter = new HashMap<String,Object>(); String
	 * journal_id =
	 * jdbcTemplate.queryForObject("select id from mru_journal_id;"
	 * ,String.class); journalParameter.put("journal_id", journal_id +1); l }
	 */
	public List<CustomerOrderPayment> getCustomerOrder(String customerId, int orderId, int orderItemSeq,
			int bill_to_customer_id, String currency) {
		List<CustomerOrderPayment> rows = new ArrayList<>();
		StringBuilder fetchOrderDetails = new StringBuilder();
		List<Double> paidAmt = new ArrayList<>();
		try {
			DecimalFormat df2 = new DecimalFormat("#.##");
			double newpAmt;
			if (orderId == 0 && orderItemSeq == 0) {
				fetchOrderDetails.append(
						"select oi.refund_status,oi.payment_status,oi.order_status,oi.gross_base_amount,oi.orderhdr_id,oi.order_item_seq,oi.order_date,oi.order_code_id,oi.bill_to_customer_id,oi.customer_id,oi.order_qty,oi.currency,"
								+ " oc.order_code,oi.net_base_amount,oi.gross_local_amount,oi.net_local_amount "
								+ " from order_item as oi"
								+ " inner join order_code as oc on oi.order_code_id = oc.order_code_id"
								+ " where customer_id =" + customerId + " and oi.pkg_item_seq is null and "
								+ " (oi.order_status in (0,5,6,7,8,9,10,11,12,13,15,16) or( oi.order_status in (6) and oi.payment_status  in (1,2,3,4) and oi.gross_base_amount > 0.0 )) and payment_status in (0,5) and oi.gross_base_amount > 0.0");
				rows = jdbcTemplate.query(fetchOrderDetails.toString(), new CustomerPaymentMapper());
				for (CustomerOrderPayment row : rows) {
					newpAmt = 0;
					orderId = row.getOrderhdr_id();
					orderItemSeq = row.getOrder_item_seq();
					paidAmt = jdbcTemplate.queryForList(
							"select pay_currency_amount as paidAmt from paybreak where customer_id=" + customerId
									+ "and orderhdr_id=" + orderId + "and order_item_seq=" + orderItemSeq + "",
							Double.class);

					for (int i = 0; i < paidAmt.size(); i++) {
						newpAmt += paidAmt.get(i);
					}
					df2.format(row.setDue((double) (row.getGross_local_amount() - newpAmt)));
					if (row.getDue() == 0) {
						row.setDue(0.00);
					}
					// row.setPay((row.getDue()));
					if (row.getPay() == 0) {
						// row.setPay(0.00);
					}
//							 if(currency != "") {
//								 row.setDueCurr((double) (row.getDue() * 1/paymentModel.get );
//								 payCurr = netAmount * (1/paymentModel.getPay_exchange_rate());
//							 }	 
				}
			} else {
				fetchOrderDetails.append(
						"select oi.refund_status,oi.payment_status,oi.order_status,oi.gross_base_amount,oi.orderhdr_id,oi.order_item_seq,oi.order_date,oi.order_code_id,oi.bill_to_customer_id,oi.customer_id,oi.order_qty,oi.currency,"
								+ " oc.order_code,oi.net_base_amount,oi.gross_local_amount,oi.net_local_amount "
								+ " from order_item as oi"
								+ " inner join order_code as oc on oi.order_code_id = oc.order_code_id"
								+ " where customer_id =" + customerId);
				if (customerId != String.valueOf(bill_to_customer_id)) {
					fetchOrderDetails.append(
							"  and orderhdr_id =" + orderId + " or bill_to_customer_id = " + bill_to_customer_id);
				}
				fetchOrderDetails.append(
						"  and oi.pkg_item_seq is null and (oi.order_status in (0,5,7,8,9,10,11,12,13,15,16) or( oi.order_status in (6) and "
								+ " oi.payment_status  in (1,2,3,4) and oi.gross_base_amount > 0.0 )) and payment_status in(0,5) and oi.gross_base_amount > 0.0 and "
								+ " orderhdr_id =" + orderId);
				rows = jdbcTemplate.query(fetchOrderDetails.toString(), new CustomerPaymentMapper());
				if (rows.size() > 0) {
					float ChargeAmt = rows.get(0).getGross_local_amount();
					// float paidAmt1 = j
					for (CustomerOrderPayment row : rows) {
						paidAmt = jdbcTemplate
								.queryForList("select pay_currency_amount as paidAmt from paybreak where customer_id="
										+ bill_to_customer_id + "and orderhdr_id=" + orderId + "and order_item_seq="
										+ row.getOrder_item_seq() + "", Double.class);
						newpAmt = 0;
						for (int i = 0; i < paidAmt.size(); i++) {
							newpAmt += paidAmt.get(i);
						}
						row.setDue((double) (row.getGross_local_amount() - newpAmt));
						if (row.getDue() == 0) {
							row.setDue(0.00);
						}
						// row.setPay((row.getDue()));
						if (row.getPay() == 0) {
							// row.setPay(0.00);
						}
					}
				}
			}
			for (CustomerOrderPayment row : rows) {
				if (row.getGross_local_amount() == 0) {
					rows.remove(row);
				}
			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rows;

	}

	public Double getExchangeRate(String currency) {
		LOGGER.info("Inside Exchange Rate Method");
		Double rows = 0.0d;
		try {
			rows = jdbcTemplate.queryForObject(
					"select exchange_rate from currency where currency = " + "'" + currency + "'", Double.class);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rows;
	}

	public PaymentModel selectPaymentDetails(int customerId, int paymentSeq) {
		LOGGER.info("Inside Payment Details Method");
		PaymentModel paymentdetails = new PaymentModel();
		try {

			paymentdetails = jdbcTemplate.queryForObject(
					"select * from payment where customer_id=" + customerId + " and payment_seq =" + paymentSeq,
					new PaymentMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return paymentdetails;
	}

	public int updatePayment(PaymentModel paymentModel) {
		int status = 0;
		try {
			LOGGER.info("Inside Payment update Method");
			Map<String, Object> parameters = new HashMap<String, Object>();
			String updatePaymentQuery = "update payment set base_amount=:base_amount, transaction_reason=:transaction_reason, payment_clear_status=:payment_clear_status,"
					+ "pay_currency_amount= :pay_currency_amount,auth_code=:auth_code,ref_nbr=:ref_nbr,creation_date=:creation_date,"
					+ "exp_date=:exp_date, credit_card_start_date=:credit_card_start_date,auth_date=:auth_date,clear_date=:clear_date,cancel_itm_after_settle_retry=:cancel_itm_after_settle_retry  where customer_id ="
					+ paymentModel.getCustomer_id() + " and payment_seq =" + paymentModel.getPayment_seq();

			parameters.put("customer_id", paymentModel.getCustomer_id());
			parameters.put("payment_seq", paymentModel.getPayment_seq());
			parameters.put("payment_clear_status", paymentModel.getPayment_clear_status());
			parameters.put("auth_code", paymentModel.getAuth_code() != null ? paymentModel.getAuth_code() : "");
			parameters.put("auth_date", paymentModel.getAuth_date() != null ? paymentModel.getAuth_date() : "");
			parameters.put("transaction_reason",
					paymentModel.getTransaction_reason() != "" ? paymentModel.getTransaction_reason() : null);
			parameters.put("ref_nbr", paymentModel.getRef_nbr() != null ? paymentModel.getRef_nbr() : "");
			parameters.put("clear_date", paymentModel.getClear_date() != null ? paymentModel.getClear_date():"");
			parameters.put("credit_card_start_date", paymentModel.getCreditCardStartDate());
			parameters.put("pay_currency_amount", paymentModel.getPayAmount());
			parameters.put("creation_date", paymentModel.getCreation_date());
			parameters.put("base_amount", paymentModel.getBase_amount());
			parameters.put("exp_date", paymentModel.getExp_date());
//		/*parameters.put("user_code",paymentModel.getUser_code());
			parameters.put("currency", paymentModel.getCurrency());
			// parameters.put("date_stamp",paymentModel.getDate_stamp());

			// parameters.put("id_nbr", paymentModel.getId_nbr());
			parameters.put("effort_nbr", paymentModel.getEffort_nbr());
			// parameters.put("commission", paymentModel.getCommission());
			parameters.put("payment_type", paymentModel.getPayment_type());
			parameters.put("credit_card_info", paymentModel.getCredit_card_info());
			// parameters.put("pay_currency_amount", paymentModel.getPay_currency_amount());

			parameters.put("transaction_type", paymentModel.getTransaction_type());
			parameters.put("payment_clear_method", paymentModel.getPayment_clear_method());
			// parameters.put("realize_cash_when", paymentModel.getRealizCcashWhen());
			parameters.put("pay_exchange_rate", paymentModel.getPay_exchange_rate());
			parameters.put("is_reversed", paymentModel.getIs_reversed());
			// parameters.put("status_noedit", paymentModel.isStatusNoedit());
			// parameters.put("processing", paymentModel.getProcessing());
			// parameters.put("mru_paybreak_seq", paymentModel.getStatus_noedit());
			parameters.put("customer_deposit_pay_amt", paymentModel.getCustomer_deposit_pay_amt());
			// parameters.put("nbr_times_issued", paymentModel.getNbr_times_issued());
			// parameters.put("pending_xaction_header_id",
			// paymentModel.getPending_xaction_header_id());

			parameters.put("card_verification_value", paymentModel.getCard_verification_value());
			parameters.put("credit_card_issue_id", paymentModel.getCredit_card_issue_id());
			parameters.put("credit_card_bill_customer_id", paymentModel.getCredit_card_bill_customer_id());
			parameters.put("credit_card_bill_address_seq", paymentModel.getCredit_card_bill_address_seq());
			parameters.put("cancel_itm_after_settle_retry", paymentModel.isCancelItmAfterSettleRetry());
			// parameters.put("refund_deposit_pay_amt",
			// paymentModel.getRefund_deposit_pay_amt());
			parameters.put("check_number", paymentModel.getCheck_number());
			// parameters.put("ics_bank_def_id", paymentModel.getIcs_bank_def_id());
			// parameters.put("cash_realized", paymentModel.isCash_realized());
			// parameters.put("mru_payment_note_seq",
			// paymentModel.isMru_payment_note_seq());
			// parameters.put("deposit_transaction", paymentModel.getDeposit_transaction());
			// parameters.put("is_ecommerce", paymentModel.getIs_ecommerce());
//        parameters.put("is_recurring", paymentModel.getIs_recurring());
//        parameters.put("max_settle_retries", paymentModel.getMax_settle_retries());
//        parameters.put("n_days_between_settle_retries", paymentModel.getN_days_between_settle_retries());
//        parameters.put("next_settle_retry_date", paymentModel.getNextSettleRetryDate());
//        parameters.put("n_settle_retries_left", paymentModel.getN_settle_retries_left());
//        parameters.put("cancel_itm_after_settle_retry", paymentModel.isCancelItmAfterSettleRetry());
//        parameters.put("payment_account_seq", paymentModel.getPayment_account_seq());
//        parameters.put("needs_memo_post", paymentModel.getNeeds_memo_post());
//        parameters.put("id_nbr_last_four", paymentModel.getId_nbr_last_four());
//        parameters.put("bacs_id", paymentModel.getBacs_id());
//        parameters.put("cc_cleaned", paymentModel.getCc_cleaned());
//        parameters.put("hosted_secure_token_pmt", paymentModel.getHosted_secure_token_pmt());
//        parameters.put("ba_nbr", paymentModel.getBa_nbr());
//        parameters.put("suspend_after_n_settle_retries", paymentModel.getSuspendAfterNSettleRetries());

			status = namedParameterJdbcTemplate.update(updatePaymentQuery, parameters);
		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return status;

	}

	public List<PaybreakModel> paymentBreakdown(int paymentSeq, int customerId) {
		LOGGER.info("Inside Payment Breakdown Method");
		List<PaybreakModel> paymentBreakdetails = new ArrayList<PaybreakModel>();
		try {
			paymentBreakdetails = jdbcTemplate.query("select * from view_paybreak_oibreak where customer_id="
					+ customerId + " and payment_seq =" + paymentSeq, new PaybreakMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return paymentBreakdetails;
	}

	public List<Map<String, Object>> getPaymentAmount(int paymentSeq, int customerId) {
		LOGGER.info("Inside get amount for paymnet from order table ");
		List<Map<String, Object>> aamountListPaymentBreakdown = new ArrayList<>();
		try {
			aamountListPaymentBreakdown = jdbcTemplate.queryForList(
					"select customer_id,payment_seq,currency, base_amount,pay_currency_amount,refund_deposit_pay_amt, customer_deposit_pay_amt from payment where customer_id="
							+ customerId + "and payment_seq=" + paymentSeq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return aamountListPaymentBreakdown;

	}

	public List<Map<String, Object>> getDepositSummary(int customerId) {
		List<Map<String, Object>> depositSummary = new ArrayList<>();
		try {
			depositSummary = jdbcTemplate.queryForList("select currency,pay_exchange_rate, sum(customer_deposit_pay_amt) as customer_deposit_pay_amt,sum((pay_exchange_rate*customer_deposit_pay_amt)) as "
					+ "customer_deposit_base_amt from payment  where customer_id="
					+ customerId + "and customer_deposit_pay_amt !=0 group by currency,pay_exchange_rate");
	}catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return depositSummary;

	}

	public List<Map<String, Object>> getOrderItemsDetails(int customerId, int paymentSeq, int orderItemSeq) {
		List<Map<String, Object>> orderItemDetails = new ArrayList<>();
		try {
			orderItemDetails = jdbcTemplate.queryForList("select * from  paybreak where customer_id = " + customerId
					+ " and payment_seq =" + paymentSeq + "and order_item_seq=" + orderItemSeq);
		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return orderItemDetails;

	}

	// Transaction Reason drop down values

	public List<DropdownModel> getTransactionReason() {
		List<Map<String, Object>> rows = new ArrayList<>();
		List<DropdownModel> transactionReasonsList = new ArrayList<>();

		try {
			// String transResn = "CREDIT";
			rows = jdbcTemplate
					.queryForList("select transaction_reason,description,reason_type from transaction_reason");
			// where transaction_reason='"+ transResn +"'"

			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("transaction_reason").toString());
				model.setDisplay(row.get("description").toString());
				model.setDescription(row.get("reason_type").toString());
				transactionReasonsList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return transactionReasonsList;
	}

	public List<Map<String, Object>> getOrderItemsDetailsEditPage(int customerId, int paymentSeq) {
		List<Map<String, Object>> orderItemDetailsforEditPayment = new ArrayList<>();
		Map<String, Object> dueAndPayDetails=new HashMap<>();
		List<Map<String, Object>> dueAndPay = new ArrayList<>();
		
		try {
			 double paidAmount=0.0;
			 double baseAmount=0.0;
			 double dueAmt=0.0;
			 paidAmount=jdbcTemplate.queryForObject("  select customer_deposit_pay_amt from view_payment_deposit where customer_id="+customerId+" and payment_seq="+paymentSeq,double.class);
			 baseAmount=jdbcTemplate.queryForObject("select base_amount from payment where customer_id="+customerId+" and payment_seq="+paymentSeq,double.class);
			 dueAmt=baseAmount-paidAmount;
			
			orderItemDetailsforEditPayment = jdbcTemplate.queryForList(
					"select oc.order_code as order_code_id,oi.order_date,oi.refund_status,oi.payment_status,oi.order_status,oi.net_local_amount ,oi.order_code_id as order_code,oi.bill_to_customer_id,oi.customer_id,oi.currency,oi.order_qty ,oi.orderhdr_id,oi.gross_base_amount ,oi.net_base_amount,oi.order_item_seq,"+dueAmt + " as due,"+dueAmt + " as dueCurr,"+dueAmt+"as payCurr  from order_item as oi inner join order_code as oc on  oi.order_code_id = oc.order_code_id "
							+ " where orderhdr_id in (select DISTINCT orderhdr_id from  order_item where orderhdr_id in (select DISTINCT  orderhdr_id from paybreak where customer_id = "
							+ customerId + "and payment_seq =" + paymentSeq + "))");
			 
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return orderItemDetailsforEditPayment;

	}

	public Double getUnpaidAmount(int customerId) {
		LOGGER.info("Inside unpaid amonut for payment method");
		Double rows = 0.0d;
		try {
			rows = jdbcTemplate.queryForObject("select sum(gross_base_amount)  from order_item where customer_id =  "
					+ customerId + " and pkg_item_seq is null and "
					+ "(order_status in (0,5,7,8,9,10,11,12,13,15,16) or( order_status in (6) and payment_status not in (1,2,3,4) and "
					+ "gross_base_amount > 0.0 ));", Double.class);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rows;
	}

	public List<Map<String, Object>> getdefaultCurrency(int customerId) {
		LOGGER.info("Inside default currency");
		List<Map<String, Object>> defaultcurrency = new ArrayList<>();
		try {
			defaultcurrency = jdbcTemplate.queryForList(
					"select currency,description,exchange_rate from currency where currency = (select currency from state"
							+ " where state=(select top 1 state from customer_address where customer_id=" + customerId
							+ "))");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultcurrency;
	}

	public List<Map<String, Object>> partialPaymentDetails(int customerId, int orderId) {
		LOGGER.info("Inside partial payment fetch details popup");
		List<Map<String, Object>> partialpaymetDetails = new ArrayList<>();

		try {
			partialpaymetDetails = jdbcTemplate.queryForList(
					"  select oi.orderhdr_id,oi.customer_id,oi.gross_base_amount, oi.expire_date,oi.total_tax_base_amount,oi.order_date,oi.start_date,oi.currency,o.oc,sc.source_code,t.term from order_item as oi inner join  oc as o on oi.oc_id = o.oc_id "
							+ " inner join order_code as c  on  oi.order_code_id = c.order_code_id"
							+ " inner join source_code as sc  on  oi.source_code_id = sc.source_code_id"
							+ " inner join term as t  on  t.term_id = c.term_id" + "	where customer_id = "
							+ customerId + " and orderhdr_id =" + orderId);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return partialpaymetDetails;
	}

	public List<CustomerOrderPayment> getOrdreFilterDropDownResult(int customerId, String balancedue, String payer,
			String recipient) {
		LOGGER.info("Inside order filter dropdown result list method");

		List<CustomerOrderPayment> rows = new ArrayList<>();
		StringBuilder fetchOrderDetails = new StringBuilder();
		StringBuilder OrderQueryforPayment = new StringBuilder();
		List<Double> paidAmt = new ArrayList<>();
		try {

			DecimalFormat df2 = new DecimalFormat("#.##");
			double newpAmt;
			OrderQueryforPayment.append(
					"select oi.refund_status,oi.payment_status,oi.order_status,oi.gross_base_amount,oi.orderhdr_id,oi.order_item_seq,oi.order_date,oi.order_code_id,oi.bill_to_customer_id,oi.customer_id,"
							+ "oi.order_qty,oi.currency,	oc.order_code,oi.net_base_amount,oi.gross_local_amount,oi.net_local_amount  from order_item as oi  inner join order_code as oc on oi.order_code_id = oc.order_code_id  where"
							+ " customer_id = " + customerId
							+ "and oi.pkg_item_seq is null and (oi.order_status in (0,5,6,7,8,9,10,11,12,13,15,16)  and oi.gross_base_amount > 0.0 )");

			if (balancedue.equals("0") && payer.equals("0") && recipient.equals("0")) {
				OrderQueryforPayment.append(" and payment_status in (0,5)");
			}
			if (balancedue.equals("0") && payer.equals("1") && recipient.equals("1")) {
				OrderQueryforPayment.append("and payment_status = 0 and oi.bill_to_customer_id !=" + customerId + " ");
			}
			if (balancedue.equals("0") && payer.equals("0") && recipient.equals("1")) {
				OrderQueryforPayment.append("and payment_status = 0 and oi.bill_to_customer_id =" + customerId + " ");
			}
			if (balancedue.equals("1") && payer.equals("0") && recipient.equals("1")) {
				OrderQueryforPayment.append("");
			}
			if (balancedue.equals("1") && payer.equals("1") && recipient.equals("0")) {
				OrderQueryforPayment.append(" and payment_status = 0 ");
			}
			if (balancedue.equals("1") && payer.equals("1") && recipient.equals("1")) {
				OrderQueryforPayment.append(" and payment_status = 0 ");
			}

			rows = jdbcTemplate.query(OrderQueryforPayment.toString(), new CustomerPaymentMapper());
			List<Order_payment_select_responsePayment_on_order> allPaymentList = new PaymentWsdl()
					.fetchAmount(customerId);

			for (CustomerOrderPayment row : rows) {

				Iterator<Order_payment_select_responsePayment_on_order> itr = allPaymentList.iterator();
				while (itr.hasNext()) {

					Order_payment_select_responsePayment_on_order orderPayment = itr.next();

					newpAmt = 0;
					int orderId = row.getOrderhdr_id();
					System.out.println("orderID" + orderId);
					int orderItemSeq = row.getOrder_item_seq();
					// newpAmt =fetchPayAmount(customerId, orderId, customerId);
					newpAmt = newpAmt + Double.parseDouble(
							orderPayment.getTotal_paid() != null ? orderPayment.getTotal_paid().toString() : "0.00");
					System.out.println("new" + newpAmt);
					df2.format(row.setDue((double) (row.getGross_local_amount() - newpAmt)));
					System.out.println(row.getDue());
					if (row.getDue() == 0) {
						row.setDue(0.00);

					}
					if (row.getPay() == 0) {
					}

				}

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rows;
	}

	public List<Map<String, Object>> getDepositDetails(int customerId) {
		LOGGER.info("Inside deposit details");
		List<Map<String, Object>> depositDetails = new ArrayList<>();
		try {
			 
		 depositDetails = jdbcTemplate.queryForList("select creation_date,payment_clear_status,payment_seq,payment_type,currency,pay_currency_amount,customer_deposit_pay_amt,"
		 		+ "customer_deposit_pay_amt as deposit_balance,base_amount ,(pay_exchange_rate*customer_deposit_pay_amt)as initial_base_amount,"
		 + "(pay_exchange_rate*customer_deposit_pay_amt)as deposit_balance_base  from payment  where customer_id ="+ customerId + " and customer_deposit_pay_amt !=0 ");
			 
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return depositDetails;
	}
	
	@Override
	public List<TotalDepositSummaryModel> getTotalDepositList(int customerId) {
		List<TotalDepositSummaryModel>  totalDepositDetails=new ArrayList<>();
		try {
			 
			 Map<String,Object> allCurrencyMap=jdbcTemplate.queryForMap("select  SUM(base_amount) as initialAmount, SUM(pay_currency_amount) as balanceAvailable"
			 		+ "  from  payment where customer_id="+customerId);
			TotalDepositSummaryModel allModel=new TotalDepositSummaryModel();
			 allModel.setCurrency("Base");
			 allModel.setInitialDeposit(allCurrencyMap.get("initialAmount").toString());
			 allModel.setBalanceAvailable(allCurrencyMap.get("balanceAvailable").toString());
			 totalDepositDetails.add(allModel);
			
		  List<Map<String, Object>>  rows = jdbcTemplate.queryForList("select currency,SUM(base_amount) as initialAmount, "
				+ "SUM(pay_currency_amount) as balanceAvailable  from  payment where customer_id= "+customerId+" group by currency");
			
			for(Map<String, Object> row : rows) {
				 TotalDepositSummaryModel  model=new TotalDepositSummaryModel();
				 model.setCurrency(row.get("currency").toString());
				 model.setInitialDeposit(row.get("initialAmount").toString());
				 model.setBalanceAvailable(row.get("balanceAvailable").toString());
				 totalDepositDetails.add(model);
		 }
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return  totalDepositDetails;
	}
	


	public double fetchPayAmount(int customerId, int orderId, int bill_to_customer_id) {
		LOGGER.info("Inside fetch amount for payment");
		Double rows = 0.0d;
		try {
				List<Map<String,Object>> orderItemtype=jdbcTemplate.queryForList("select distinct order_item_type from order_item where customer_id="+customerId+" and orderhdr_id="+orderId);
				for(Map<String,Object> result:orderItemtype) {
				if(Integer.parseInt( result.get("order_item_type").toString())==7) {
					rows=jdbcTemplate.queryForObject("select sum(gross_local_amount) as gross_base_amount from order_item where customer_id="+customerId+" and "
							+ "pkg_item_seq is null and (order_item_type in (7) or payment_status not in (1,2,3,4) and gross_local_amount > 0.0 and payment_status in (0,5) and order_status in (0,5,7,8,9,10,11,12,13,15,16) and orderhdr_id="+orderId+")",Double.class);
					System.out.println(rows);
				}
				}
				if(rows==0.0) {
			if (orderId == 0) {
				rows = jdbcTemplate
						.queryForObject("select sum(gross_local_amount)  from order_item where customer_id =  "
								+ customerId + " and pkg_item_seq is null and "
								+ "(order_status in (0,5,7,8,9,10,11,12,13,15,16) or( order_status in (6) and payment_status not in (1,2,3,4) and "
								+ "gross_local_amount > 0.0 ))and payment_status in (0,5);", Double.class);
			} else {
				rows = jdbcTemplate.queryForObject(
						"select sum(gross_local_amount) as gross_base_amount  from order_item where bill_to_customer_id = "
								+ bill_to_customer_id + "and orderhdr_id =" + orderId + "and  payment_status in (0,5)",
						Double.class);
			}
				}
				} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		if (rows == null) {
			return 0.0d;
		} else {
			return rows;
		}

	}

	public List<JournalDepositModel> getDepositDetailsfromJournal(int customerId) {
		List<JournalDepositModel> journalDeposit = new ArrayList<>();
		try {
			String journalDepositDetails = "SELECT customer_id,payment_seq,credit_account,debit_account,amount,posting_reference  FROM journal_deposit WHERE customer_id ="
					+ customerId + " ORDER BY journal_deposit_id;";
			
			journalDeposit = jdbcTemplate.query(journalDepositDetails, new JournalDepositMapper());
			}

		catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return journalDeposit;

	}

	public List<Map<String, Object>> getWithdrawalDetails(int customerId) {

		List<Map<String, Object>> withdrawlDetailsDetails = new ArrayList<>();
		try {

			withdrawlDetailsDetails = jdbcTemplate.queryForList(
					"SELECT p.customer_id, o.orderhdr_id, o.order_item_seq, oc.oc_id, d.creation_date as payment_date, p.currency as pay_currency,"
							+ " o.currency as order_currency,o.net_local_amount, o.net_base_amount, o.order_date, o.order_item_type, o.product_id,"
							+ "o.subscription_def_id, o.start_issue_id, oc.description as oc_description, p.payment_type,o.pkg_def_id, o.pkg_item_seq,"
							+ " sum(b.pay_currency_amount) as pay_currency_amount,sum(b.base_amount) as pay_base_amount FROM order_item o, payment p,"
							+ " paybreak b,oc, date_stamp d WHERE o.orderhdr_id = b.orderhdr_id and o.order_item_seq = b.order_item_seq and "
							+ "b.customer_id = p.customer_id and b.payment_seq = p.payment_seq and oc.oc_id = o.oc_id and d.date_stamp = b.date_stamp"
							+ " and p.customer_id = " + customerId
							+ " and b.paybreak_type in (0) and pkg_item_seq is null "
							+ "group by p.customer_id, o.orderhdr_id, o.order_item_seq, oc.oc_id, d.creation_date, p.currency,o.currency, o.net_local_amount,"
							+ " o.net_base_amount, o.order_date, o.order_item_type, o.product_id, o.subscription_def_id,o.start_issue_id, oc.description, "
							+ "p.payment_type, o.pkg_def_id,o.pkg_item_seq ORDER BY payment_date desc, o.orderhdr_id, o.order_item_seq");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return withdrawlDetailsDetails;
	}

	/*
	 * public List<Map<String, Object>> getCurrentOrderforPayment(String
	 * customerId,int orderId){ List<Map<String, Object>> rows=new ArrayList<>();
	 * try {
	 * 
	 * rows = jdbcTemplate
	 * .queryForList("select oi.orderhdr_id,oi.order_item_seq,oi.order_date,oi.order_code_id,oi.bill_to_customer_id,oi.order_qty,oi.currency,"
	 * +" oc.order_code,oi.net_base_amount,oi.gross_local_amount,oi.net_local_amount "
	 * + " from order_item as oi" +
	 * " inner join order_code as oc on oi.order_code_id = oc.order_code_id" +
	 * " where customer_id ="+ customerId +" and oi.pkg_item_seq is null and " +
	 * " (oi.order_status in (0,5,7,8,9,10,11,12,13,15,16) or( oi.order_status in (6) and oi.payment_status  in (1,2,3,4) and oi.gross_base_amount > 0.0 )) and orderhdr_id="
	 * +orderId); } catch(Exception e){ LOGGER.error(ERROR + e);
	 * 
	 * } return rows;
	 * 
	 * }
	 */
	public boolean depositSave(PaymentModel paymentModel) {
		try {
			Map<String, Object> paymentParameters = new HashMap<String, Object>();
			String addpaymentquery = "insert into payment (customer_id,payment_seq,user_code,currency,date_stamp,creation_date,payment_clear_status,commission,payment_type,base_amount,"
					+ " pay_currency_amount,transaction_type,payment_clear_method,realize_cash_when,pay_exchange_rate,is_reversed,status_noedit,processing,"
					+ " customer_deposit_pay_amt,refund_deposit_pay_amt,cash_realized,deposit_transaction,is_ecommerce,is_recurring,needs_memo_post,cc_cleaned,hosted_secure_token_pmt) values"
					+ " (:customer_id,:payment_seq,:user_code,:currency,:date_stamp,GETDATE(),:payment_clear_status,:commission,:payment_type,:base_amount,"
					+ " :pay_currency_amount,:transaction_type,:payment_clear_method,:realize_cash_when,:pay_exchange_rate,:is_reversed,:status_noedit,:processing,"
					+ " :customer_deposit_pay_amt,:refund_deposit_pay_amt,:cash_realized,:deposit_transaction,:is_ecommerce,:is_recurring,:needs_memo_post,:cc_cleaned,:hosted_secure_token_pmt)";

			paymentParameters.put("customer_id", paymentModel.getCustomer_id());
			String PaymentSeqresult = jdbcTemplate.queryForObject(
					"select max(payment_seq) from payment where customer_id =" + paymentModel.getCustomer_id(),
					String.class);
			if (PaymentSeqresult != null) {
				paymentParameters.put("payment_seq", Integer.parseInt(PaymentSeqresult) + 1);
			} else {
				paymentParameters.put("payment_seq", 1);
			}

			// paymentModel.getAuth_code()!=null?paymentModel.getAuth_code():""
			paymentParameters.put("user_code", "THK");
			paymentParameters.put("currency", paymentModel.getCurrency() != null ? paymentModel.getCurrency() : "");
			int dateStamp = jdbcTemplate.queryForObject("select max(date_stamp) from date_stamp", int.class);
			paymentParameters.put("date_stamp", dateStamp);
			paymentParameters.put("creation_date",
					paymentModel.getCreation_date() != null ? paymentModel.getCreation_date() : "");
			paymentParameters.put("id_nbr", paymentModel.getId_nbr() != null ? paymentModel.getId_nbr_last_four() : "");
			// paymentParameters.put("exp_date", "date");
			paymentParameters.put("ref_nbr", paymentModel.getRef_nbr() != null ? paymentModel.getRef_nbr() : "");
			paymentParameters.put("auth_code", paymentModel.getAuth_code() != null ? paymentModel.getAuth_code() : "");
			paymentParameters.put("auth_date", paymentModel.getAuth_date() != null ? paymentModel.getAuth_date() : "");

			paymentParameters.put("clear_date",
					paymentModel.getClear_date() != null ? paymentModel.getClear_date() : "");
			paymentParameters.put("payment_clear_status",
					String.valueOf(paymentModel.getPayment_clear_status()) != null
							? paymentModel.getPayment_clear_status()
							: 0);
			paymentParameters.put("effort_nbr",
					paymentModel.getEffort_nbr() != null ? paymentModel.getEffort_nbr() : "");
			paymentParameters.put("commission",
					String.valueOf(paymentModel.getCommission()) != null ? paymentModel.getCommission() : 0);
			paymentParameters.put("payment_type",
					paymentModel.getPayment_type() != null ? paymentModel.getPayment_type() : "");
			paymentParameters.put("credit_card_info",
					paymentModel.getCredit_card_info() != null ? paymentModel.getCredit_card_info() : "");
			paymentParameters.put("base_amount",
					paymentModel.getBase_amount() != null ? paymentModel.getBase_amount() : 0.0d);
			paymentParameters.put("pay_currency_amount", paymentModel.getPayAmount());
			paymentParameters.put("transaction_reason",
					paymentModel.getTransaction_reason() != null ? paymentModel.getTransaction_reason() : "");

			paymentParameters.put("transaction_type",
					paymentModel.getTransaction_type() != null ? paymentModel.getTransaction_type() : 0);
			paymentParameters.put("payment_clear_method",
					paymentModel.getPayment_clear_method() != null ? paymentModel.getPayment_clear_method() : 0);
			paymentParameters.put("realize_cash_when",
					String.valueOf(paymentModel.getRealizCcashWhen()) != null ? paymentModel.getRealizCcashWhen() : 1);
			paymentParameters.put("pay_exchange_rate", paymentModel.getPay_exchange_rate());//
			paymentParameters.put("is_reversed",
					String.valueOf(paymentModel.getIs_reversed()) != null ? paymentModel.getIs_reversed() : 0);
			paymentParameters.put("status_noedit",
					String.valueOf(paymentModel.getStatus_noedit()) != null ? paymentModel.getStatus_noedit() : 0);
			paymentParameters.put("processing",
					String.valueOf(paymentModel.getProcessing()) != null ? paymentModel.getProcessing() : 0);
			paymentParameters.put("mru_paybreak_seq",
					String.valueOf(paymentModel.getStatus_noedit()) != null ? paymentModel.getStatus_noedit() : "");
			paymentParameters.put("customer_deposit_pay_amt",
					paymentModel.getPayAmount() != null ? paymentModel.getPayAmount() : 0.0000);//
			paymentParameters.put("nbr_times_issued",
					String.valueOf(paymentModel.getNbr_times_issued()) != null ? paymentModel.getNbr_times_issued()
							: "");
			paymentParameters.put("pending_xaction_header_id",
					String.valueOf(paymentModel.getPending_xaction_header_id()) != null
							? paymentModel.getPending_xaction_header_id()
							: "");
			// paymentParameters.put("credit_card_start_date",paymentModel.getCreditCardStartDate());
			paymentParameters.put("card_verification_value",
					paymentModel.getCard_verification_value() != null ? paymentModel.getCard_verification_value() : "");
			paymentParameters.put("credit_card_issue_id",
					paymentModel.getCredit_card_issue_id() != null ? paymentModel.getCredit_card_issue_id() : "");
			paymentParameters.put("credit_card_bill_customer_id",
					String.valueOf(paymentModel.getCredit_card_bill_customer_id()) != null
							? paymentModel.getCredit_card_bill_customer_id()
							: "");
			paymentParameters.put("credit_card_bill_address_seq",
					String.valueOf(paymentModel.getCredit_card_bill_address_seq()) != null
							? paymentModel.getCredit_card_bill_address_seq()
							: "");
			paymentParameters.put("refund_deposit_pay_amt",
					paymentModel.getRefund_deposit_pay_amt() != null ? paymentModel.getRefund_deposit_pay_amt()
							: 0.0000);
			paymentParameters.put("check_number",
					paymentModel.getCheck_number() != null ? paymentModel.getCheck_number() : "");
			paymentParameters.put("ics_bank_def_id",
					String.valueOf(paymentModel.getIcs_bank_def_id()) != null ? paymentModel.getIcs_bank_def_id() : "");
			// paymentParameters.put("row_version", null);
			paymentParameters.put("cash_realized",
					String.valueOf(paymentModel.getRealizCcashWhen()) != null ? paymentModel.getRealizCcashWhen() : 1);
			paymentParameters.put("mru_payment_note_seq",
					String.valueOf(paymentModel.getStatus_noedit()) != null ? paymentModel.getStatus_noedit() : "");
			paymentParameters.put("deposit_transaction",
					paymentModel.getDeposit_transaction() != null ? paymentModel.getDeposit_transaction() : 0);
			paymentParameters.put("is_ecommerce",
					String.valueOf(paymentModel.getIs_ecommerce()) != null ? paymentModel.getIs_ecommerce() : 0);
			paymentParameters.put("is_recurring",
					String.valueOf(paymentModel.getIs_recurring()) != null ? paymentModel.getIs_recurring() : 0);
			paymentParameters.put("max_settle_retries",
					String.valueOf(paymentModel.getMax_settle_retries()) != null ? paymentModel.getMax_settle_retries()
							: "");
			paymentParameters.put("n_days_between_settle_retries",
					String.valueOf(paymentModel.getN_days_between_settle_retries()) != null
							? paymentModel.getN_days_between_settle_retries()
							: "");
			// paymentParameters.put("next_settle_retry_date", null);
			paymentParameters.put("n_settle_retries_left",
					paymentModel.getN_settle_retries_left() != null ? paymentModel.getN_settle_retries_left() : "");
			// paymentParameters.put("cancel_itm_after_settle_retry", paymentModel.getcan);
			paymentParameters.put("payment_account_seq",String.valueOf(paymentModel.getPayment_account_seq()) != ""? paymentModel.getPayment_account_seq(): 0);
			paymentParameters.put("needs_memo_post",
					String.valueOf(paymentModel.getNeeds_memo_post()) != null ? paymentModel.getNeeds_memo_post() : 0);
			paymentParameters.put("cc_cleaned",
					String.valueOf(paymentModel.getCc_cleaned()) != null ? paymentModel.getCc_cleaned() : 0);
			paymentParameters.put("id_nbr_last_four",
					paymentModel.getId_nbr_last_four() != null ? paymentModel.getId_nbr_last_four() : "");
			paymentParameters.put("bacs_id",
					String.valueOf(paymentModel.getBacs_id()) != null ? paymentModel.getBacs_id() : "");
			paymentParameters.put("hosted_secure_token_pmt",
					String.valueOf(paymentModel.getHosted_secure_token_pmt()) != null
							? paymentModel.getHosted_secure_token_pmt()
							: 0);
			paymentParameters.put("ba_nbr", paymentModel.getBa_nbr() != null ? paymentModel.getBa_nbr() : "");

			namedParameterJdbcTemplate.update(addpaymentquery, paymentParameters);
			
			paymentParameters.clear();
			
			String queryForJournalDeposit = "insert into journal_deposit (journal_deposit_id,customer_id,payment_seq,date_stamp,posting_reference,amount,debit_account,credit_account) values"
					+ "(:journal_deposit_id,:customer_id,:payment_seq,:date_stamp,:posting_reference,:amount,:debit_account,:credit_account)";

			
			Integer journalDepositId = jdbcTemplate.queryForObject("select max(journal_deposit_id) from journal_deposit", Integer.class);
			
			long journalId = customerUtility.getMaxJournalId() + 1;
			
			jdbcTemplate.update("set nocount on if not exists (select 1 from information_schema.tables where table_name = 'mru_journal_id') begin create"
			+ " table mru_journal_id (id int) insert mru_journal_id (id) values (1) end else update mru_journal_id with (TABLOCKX)"
			+ " set id =" + journalId);
			
			if(journalId==0) {
				journalId=(int) 0;
			}
			else
			paymentParameters.put("journal_deposit_id", journalId);	
							
			paymentParameters.put("customer_id", paymentModel.getCustomer_id());
			System.out.println(paymentModel.getCustomer_id());
			String PaymentSeq = jdbcTemplate.queryForObject(
					"select max(payment_seq) from payment where customer_id =" + paymentModel.getCustomer_id(),
					String.class);
			
			paymentParameters.put("payment_seq", PaymentSeq);
			System.out.println(PaymentSeq);

			paymentParameters.put("date_stamp", dateStamp);
			System.out.println(dateStamp);
			paymentParameters.put("posting_reference", 8);
			paymentParameters.put("amount", paymentModel.getPay_currency_amount());
			System.out.println(paymentModel.getPay_currency_amount());
			paymentParameters.put("debit_account", 2);
			paymentParameters.put("credit_account", 3);

			namedParameterJdbcTemplate.update(queryForJournalDeposit, paymentParameters);
			Map<String, Object> parameters = new HashMap<String, Object>();
			String  mruJournalDepositQuery="update mru_journal_deposit_id set id = :id";
			parameters.put("id", journalDepositId);
			namedParameterJdbcTemplate.update(mruJournalDepositQuery, parameters);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return false;

		}
		return true;

	}

	public List<Map<String,Object>> searchLookupOrder(OrderItem orderItem, String firstName, String lastName) {
		LOGGER.info("Inside search look up order method");
		
		List<Map<String,Object>> lookUpDetails = new ArrayList<>();
		Map<String, Object> dueAndPayDetails=new HashMap<>();
		List<Map<String, Object>> dueAndPay = new ArrayList<>();
		try {
			StringBuilder querySearchLookupOrder = new StringBuilder();

			querySearchLookupOrder.append(
					"select oi.orderhdr_id,oi.bill_to_customer_id as customer_id,oi.order_qty,oi.order_date,oi.refund_status,oi.currency, oc.order_code,oc.order_code_id,"
					+ "oi.order_item_seq,oi.payment_status,oi.customer_id,CONCAT(c.fname,' ',c.lname)as fullname,oi.order_date,oi.order_status,oi.subscrip_id,"
					+ " oi.gross_base_amount,oi.net_local_amount,oi.net_base_amount,oi.gross_local_amount,oi.gross_base_amount as due,oi.net_local_amount as pay, oc.oc_id,oc.description from order_item as oi "
					+ "inner join order_code as oc on oi.order_code_id = oc.order_code_id  inner join customer as c on c.customer_id = oi.customer_id	where ");

			if (orderItem.getSubscripId() != null) {
				querySearchLookupOrder
						.append(" subscrip_id =" + orderItem.getSubscripId().toString() + " order by subscrip_id asc");
			}
			if (orderItem.getCustomerId() != 0) {
				querySearchLookupOrder
						.append(" oi.customer_id =" + orderItem.getCustomerId() + " order by subscrip_id asc");
			}
			if (orderItem.getOrderhdrId() != 0) {
				querySearchLookupOrder
						.append(" orderhdr_id =" + orderItem.getOrderhdrId() + " order by subscrip_id asc");
			}

			if (firstName != null && lastName == null) {
				querySearchLookupOrder.append(" fname like '%" + firstName + "%' order by subscrip_id asc");
			}
			if (lastName != null && firstName == null) {
				querySearchLookupOrder.append(" lname like '%" + lastName + "%' order by subscrip_id asc");
			}
			if (firstName != null && lastName != null) {
				querySearchLookupOrder.append(
						" lname like '%" + lastName + "%' and fname like'%" + firstName + "%'order by subscrip_id asc");
			}
			lookUpDetails = jdbcTemplate.queryForList(querySearchLookupOrder.toString());

			
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return lookUpDetails;
	}

	// code modified by Malini to get review Payments when payment of order is
	// cancelled
	public List<Map<String, Object>> getReviewPayments(int orderId, int orderItemSeq) {
		List<Map<String, Object>> rows = new ArrayList<>();
		Map<String, Object> status = null;
		try {
			rows = jdbcTemplate.queryForList(
					"select distinct creation_date,customer_id,payment_seq,base_amount,exp_date,pay_currency_amount,currency,"
							+ "payment_type,payment_clear_status,check_number,ref_nbr,user_code,status_noedit,auth_date,transaction_type,pay_exchange_rate,"
							+ "payment_clear_method,processing,realize_cash_when,credit_card_info,commission,effort_nbr,is_reversed,transaction_reason,auth_code,"
							+ "clear_date,date_stamp FROM view_payment_review WHERE orderhdr_id =" + orderId);
			for (Map<String, Object> value : rows) {
				int tarnsactionType = value.get("transaction_type") != null
						? Integer.parseInt(value.get("transaction_type").toString())
						: 0;
				if (tarnsactionType == 1) {
					String updatequery = "update view_order_tab_list_all set pay_status=0 where orderhdr_id=" + orderId
							+ "and order_item_seq=" + orderItemSeq;
					int result = jdbcTemplate.update(updatequery);
					if (result != 0) {
						status.put("updatedPayStatus", result);
					}
					rows.add(status);
				}
			}

		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return rows;
	}

	public List<Map<String, Object>> getPayerCustomerAddressForEdit(int customerId, int paymentSeq) {
		List<Map<String, Object>> rows = new ArrayList<>();
		try {
			rows = jdbcTemplate.queryForList(
					"select address1 from customer_address  where  customer_id in (select distinct customer_id from order_item where orderhdr_id in"
							+ "(select  distinct orderhdr_id from paybreak where customer_id =" + customerId
							+ "and payment_seq=" + paymentSeq + ")) and customer_address_seq in"
							+ "(select distinct bill_to_customer_address_seq from order_item where orderhdr_id in"
							+ "(select  distinct orderhdr_id from paybreak where customer_id = " + customerId
							+ "and payment_seq=" + paymentSeq + "))");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);

		}
		return rows;

	}

	public List<OrderDetailsModel> viewOrderItemsList(int orderhdr_id, int order_item_seq, int customer_id) {
		LOGGER.info("Inside Payment deposit pay Method");
		List<OrderDetailsModel> viewOrderItemsList = new ArrayList<OrderDetailsModel>();
		try {
			// viewOrderItemsList = jdbcTemplate.query("select * from order_item where
			// orderhdr_id=" + orderhdrId +" and order_item_seq =" + orderItemSeq, new
			// OrderDetailsMapper());
			viewOrderItemsList = jdbcTemplate.query(
					"SELECT *,oc.oc as order_class,order_code.order_code,order_code.order_code_type,agency_code  from order_item"
							+ " left join order_code order_code on order_item.order_code_id=order_code.order_code_id"
							+ " left join oc oc on order_item.oc_id=oc.oc_id left join agency on order_item.agency_customer_id=agency.customer_id",
					new OrderDetailsMapper());
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return viewOrderItemsList;
	}

	public List<Map<String, Object>> viewDepositBalance(int customer_id) {
		LOGGER.info("Inside Payment from deposit Method");
		List<Map<String, Object>> viewDepositBalance = new ArrayList<>();
		try {
			// viewOrderItemsList = jdbcTemplate.query("select * from order_item where
			// orderhdr_id=" + orderhdrId +" and order_item_seq =" + orderItemSeq, new
			// OrderDetailsMapper());
			viewDepositBalance = jdbcTemplate.queryForList(
					"SELECT sum(customer_deposit_pay_amt) as customer_deposit_pay_amt from payment where customer_id = "
							+ customer_id);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return viewDepositBalance;

	}

	@Override
	public List<CustomerOrderPayment> viewOrderItemsListForDepPay(int customer_id, int orderId, int orderItemSeq) {
		List<CustomerOrderPayment> orderItemDataList = new ArrayList<>();

		orderItemDataList = jdbcTemplate.query(
				"Select agency.agency_code, oi.*,orderCode.order_code_type,orderCode.order_code,oc.oc as order_class, (select enumeration from issue where issue.issue_id=oi.start_issue_id)as startIssueId,"
						+ "(select enumeration from issue where issue.issue_id=oi.stop_issue_id)as stopIssueId FROM order_item oi"
						+ " inner join order_code as orderCode on oi.order_code_id = orderCode.order_code_id"
						+ " left join agency on oi.agency_customer_id=agency.customer_id"
						+ " left join oc oc on oi.oc_id=oc.oc_id" + " where oi.customer_id =" + customer_id
						+ " and orderhdr_id =" + orderId + " and oi.pkg_item_seq is null and "
						+ " (oi.order_status in (0,5,7,8,9,10,11,12,13,15,16) or( oi.order_status in (6) and oi.gross_base_amount > 0.0 )) and oi.gross_base_amount > 0.0",
				new CustomerPaymentMapper());
		try {

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderItemDataList;
	}

	public List<Map<String, Object>> getPaymentThresholdData(int orderId, int orderItemSeq) {
		List<Map<String, Object>> thresholdData = new ArrayList<>();
		List<Double> paidAmounts = new ArrayList<>();
		List<Map<String, Object>> term = new ArrayList<Map<String, Object>>();
		Map<String, Object> termData = new HashMap<>();

		Double paidAmount = 0.00;

		paidAmounts = jdbcTemplate.queryForList("select pay_currency_amount from paybreak where orderhdr_id = "
				+ orderId + " and order_item_seq =" + orderItemSeq + " and bogus_commission=0 ", Double.class);
			if(paidAmounts.size()!=0) {
		
			for (int i = 0; i < paidAmounts.size(); i++) {
				paidAmount += paidAmounts.get(i);
				System.out.println(paidAmount);
				
			}}
			else {
				 paidAmount = 0.00;
				 System.out.println(paidAmount);
			}
			term = jdbcTemplate.queryForList(
					"select term from term where term_id=(select term_id from order_code where order_code_id="
							+ "(select order_code_id from order_item where orderhdr_id=" + orderId
							+ "and order_item_seq=" + orderItemSeq + "))");

			thresholdData = jdbcTemplate.queryForList(
					"select oi.oc_id,oi.order_code_id,oi.orderhdr_id,oi.customer_id,oi.net_base_amount,oi.subscription_def_id,oi.order_qty,oi.n_remaining_paid_issues,oi.order_item_seq,\r\n"
							+ "					 		 oi.total_tax_base_amount as tax,convert(varchar,oi.order_date,101) as order_date,convert(varchar,oi.start_date,101) as start_date, convert (varchar,oi.expire_date,101) as expire_date, oi.currency, o.oc,sc.source_code from order_item as oi \r\n"
							+ "					 		 inner join  oc as o on oi.oc_id = o.oc_id  inner join order_code as c  on  oi.order_code_id = c.order_code_id				 		\r\n"
							+ "					 	 inner join source_code as sc  on  oi.source_code_id = sc.source_code_id \r\n"
							+ "					 	                     where oi.orderhdr_id =" + orderId
							+ " and oi.order_item_seq=" + orderItemSeq);
			if(thresholdData.size()!=0)
			{
			for (Map<String, Object> data : thresholdData) {
				data.put("paidAmount", paidAmount);
				data.put("term", term);

			}}
			else {
				throw new RuntimeException("No data for this orderhdr_id " + orderId);
			}

		

		return thresholdData;

	}

	public List<Map<String, Object>> getThresholdSettingOptions() {
		List<Map<String, Object>> thresholdSettingData = new ArrayList<>();

		try {
			thresholdSettingData = jdbcTemplate.queryForList(
					"select pt.percent_partial,pt.percent_under,pt.percent_over,pt.percent_refund,pt.max_under_under,"
							+ " pt.max_under_full,pt.max_over_full,pt.max_over_over,pt.payment_threshold from payment_threshold as pt inner join config as c  "
							+ " on pt.payment_threshold = c.payment_threshold");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return thresholdSettingData;
	}

	@Override
	public List<Object> getPaymentHistory(Long customerId, int paymentSeq) throws SQLException {
		LOGGER.info("Inside getPaymentHistory");
		List<Object> paymentHistory = new ArrayList<Object>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("SELECT * FROM view_edit_hist WHERE customer_id = " + customerId
							+ " and payment_seq = " + paymentSeq + " and" + " table_enum = 4 order by creation_date");
			for (Map<String, Object> row : rows) {
				if (row.get("column_name") != null && row.get("column_name").equals("order_status")) {
					row.put("before_change", new PropertyUtilityClass()
							.getConstantValue("order_item.order_status_" + row.get("before_change")));
					row.put("after_change", new PropertyUtilityClass()
							.getConstantValue("order_item.order_status_" + row.get("after_change")));
				} else if (row.get("column_name") != null && row.get("column_name").equals("renewal_status")) {
					row.put("before_change", new PropertyUtilityClass()
							.getConstantValue("order_item.renewal_status_" + row.get("before_change")));
					row.put("after_change", new PropertyUtilityClass()
							.getConstantValue("order_item.renewal_status_" + row.get("after_change")));
				} else if (row.get("column_name") != null && row.get("column_name").equals("payment_status")) {
					row.put("before_change", new PropertyUtilityClass()
							.getConstantValue("order_item.pay_status_" + row.get("before_change")));
					row.put("after_change", new PropertyUtilityClass()
							.getConstantValue("order_item.pay_status_" + row.get("after_change")));
				} else if (row.get("column_name") != null && row.get("column_name").equals("order_date")) {
					row.put("before_change",
							row.get("before_change") != null
									? new PropertyUtilityClass().getDateFormatter((String) row.get("before_change"))
									: "");
					row.put("after_change",
							row.get("after_change") != null
									? new PropertyUtilityClass().getDateFormatter((String) row.get("after_change"))
									: "");
				} else {
					row.put("before_change", row.get("before_change"));
					row.put("after_change", row.get("after_change"));
				}
				paymentHistory.add(row);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return paymentHistory;

	}

	@Override
	public Boolean checkNoteExistOnPayment(int customer_id, int payment_seq) {
		LOGGER.info("Inside clearAddInfo");
		boolean noteAvailable = false;
		try {
			Integer noteExist;
			noteExist = jdbcTemplate
					.queryForObject("select count(customer_id) as note_exist from payment_note where customer_id ="
							+ customer_id + "and payment_seq = " + payment_seq, Integer.class);
			if (noteExist > 0) {
				noteAvailable = true;
			} else {
				noteAvailable = false;
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return noteAvailable;
	}

	@Override
	public List<Map<String, Object>> getOrderInformation(int orderhdr_id, int order_item_seq) {
		List<Map<String, Object>> orderInfo = new ArrayList<>();
		try {
			orderInfo = jdbcTemplate.queryForList(
					"select deferred_qty,earned_qty,no_more_ar,no_more_liability,orderhdr_id,order_item_seq,recon_upd from order_item_account where orderhdr_id="
							+ orderhdr_id + " and order_item_seq=" + order_item_seq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return orderInfo;
	}

	@Override
	public List<OrderItemAccountModel> getorderAccBreakType(int orderhdr_id, int order_item_seq) {
		List<OrderItemAccountModel> orderAccBreakinfo = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"select acc_break_type,ar,cash,liability,revenue,order_item_seq,orderhdr_id from order_item_acc_break where orderhdr_id="
							+ orderhdr_id + " and order_item_seq=" + order_item_seq);
			orderAccBreakinfo = jdbcTemplate.query(query.toString(), new OrderItemAccountMapper());
		}

		catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderAccBreakinfo;
	}

	@Override
	public List<Map<String, Object>> getAddCustomerDistAddress(int customer_id) {
		List<Map<String, Object>> addCustomerDistAddrs = new ArrayList<>();
		try {
			addCustomerDistAddrs = jdbcTemplate.queryForList(
					"select distribution_method,distribution_attribute,dist_attribute_value from customer_address_dist where customer_id="
							+ customer_id);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return addCustomerDistAddrs;
	}

	@Override
	public List<Map<String, Object>> getDistributionCustomerAddrs(int customer_id, int customer_address_seq) {
		List<Map<String, Object>> distributionCustomerAddrs = new ArrayList<>();
		try {
			distributionCustomerAddrs = jdbcTemplate.queryForList(
					"select customer_address_seq,address1,address2,city,county,state,zip from customer_address where customer_id="
							+ customer_id + " and customer_address_seq=" + customer_address_seq);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return distributionCustomerAddrs;
	}

//		@Override
//		public List<Map<String, Object>> getpaymentAccountList(int customer_id) {
//			List<Map<String, Object>> accountList=new ArrayList<>();
//			try {
//				accountList=jdbcTemplate.queryForList("select ");
//			}catch(Exception e) {
//				LOGGER.error(ERROR + e);
//			}
//			
//			return accountList;
//		}

	@Override
	public List<DropdownModel> getpaymentAccountList(int payerCustomer) {
		LOGGER.info("Inside getAttachmentCategoryList");
		List<DropdownModel> accountList = new ArrayList<>();
		try {

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select payment_account_seq,description,id_nbr_last_four from payment_account where customer_id ="
							+ payerCustomer);

			for (Map<String, Object> row : rows) {

				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_account_seq").toString());
				model.setDisplay( row.get("description").toString());
				model.setDescription(row.get("id_nbr_last_four") != null ? row.get("id_nbr_last_four").toString() : "");
				accountList.add(model);

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return accountList;

	}

	@Override
	public List<PaymentReview> getReviewAccountJournal(int order_item_seq, int orderhdr_id) {
		List<PaymentReview> reviewData = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"select payment_seq,posting_reference,net_amount,tax_amount,del_amount,com_amount,debit_account,credit_account,orderhdr_id,order_item_seq,customer_id,qty,qty_credit_account,qty_debit_account,date_stamp,journal_id,row_version,bndl_qty,job_id from journal ");
			query.append(" where order_item_seq=" + order_item_seq + " and orderhdr_id=" + orderhdr_id
					+ " ORDER BY payment_seq");
			reviewData = jdbcTemplate.query(query.toString(), new ReviewAccontingMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return reviewData;
	}

	@Override
	public List<Map<String, Object>> getReviewOrderItemDetails(int orderhdr_id, int orderItemseq) {
		List<Map<String, Object>> reviewData = new ArrayList<>();
		try {
			StringBuilder query = new StringBuilder(
					"select order_item.alt_ship_customer_id,order_item_amt_break.order_item_seq,order_item_amt_break.order_item_amt_break_seq,order_item_amt_break.orderhdr_id,order_item_amt_break.local_amount,order_item_amt_break.base_amount,"
							+ "order_item_amt_break.base_amount as netBaseAmount,order_item_amt_break.base_amount as grossBaseAmount,order_item_amt_break.local_amount as netLocalAmount,order_item_amt_break.local_amount "
							+ "as grossLocalAmount,order_item_amt_break.jurisdiction_seq,order_item_amt_break.state,order_item_amt_break.tax_type,order_item_amt_break.tax_rate_category,order_item_amt_break.row_version,order_item_amt_break.effective_date,"
							+ "order_item_amt_break.orig_base_amount,order_item_amt_break.tax_rate,order_item_amt_break.tax_delivery,order_item_amt_break.tax_active,order_item_amt_break.vrtx_jurisdiction,order_item_amt_break.vrtx_jurisdiction_level,"
							+ "order_item_amt_break.vrtx_tax_type,order_item_amt_break.tx_incl,(CASE when order_item_break_type=0 then 'Order item'"
							+ " when order_item_break_type=1 then 'tax' when order_item_break_type=2 then 'delivery' when order_item_break_type=3 then 'commission' END )as order_item_break_type,0 as blpc_current_applied_amt,0 as blpc_current_ratio,0 as blpc_earned_ratio,0 as blpc_earned_amt,0 as blpc_original_ratio,0 as blpc_proposed_applied_amt from order_item_amt_break left outer  join order_item"
							+ " on order_item.orderhdr_id=order_item_amt_break.orderhdr_id and order_item_amt_break.order_item_seq=order_item.orderhdr_id where order_item_amt_break.orderhdr_id="
							+ orderhdr_id + "and order_item_amt_break.order_item_seq=" + orderItemseq);
			reviewData = jdbcTemplate.queryForList(query.toString());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return reviewData;
	}

	@Override
	public List<DropdownModel> getOrderList(int paymentSeq, int customerId) {

		List<DropdownModel> orderDataList = new ArrayList<>();

		try {
			List<Map<String, Object>> orderDetails = jdbcTemplate
					.queryForList("select orderhdr_id,order_item_seq from view_paybreak_oibreak  where customer_id ="
							+ customerId + " and payment_seq =" + paymentSeq);

			for (Map<String, Object> row : orderDetails) {
				DropdownModel model = new DropdownModel();
				List<Map<String, Object>> ordercodeidDetails = jdbcTemplate
						.queryForList("select order_code_id from order_item where orderhdr_id ="
								+ row.get("orderhdr_id") + "and order_item_seq =" + row.get("order_item_seq"));
				for (Map<String, Object> OrdercodeidDetails : ordercodeidDetails) {

					model.setKey(row.get("orderhdr_id").toString() + "-" + row.get("order_item_seq").toString());
					List<Map<String, Object>> ordercode = jdbcTemplate
							.queryForList("select order_code from order_code where order_code_id ="
									+ OrdercodeidDetails.get("order_code_id"));
					model.setDisplay(ordercode.get(0).get("order_code").toString().concat("(")
							.concat(row.get("orderhdr_id").toString()).concat(")"));
					orderDataList.add(model);
				}

			}

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return orderDataList;

	}

	@Override
	public List<PaybreakModel> getPaymentBreakDownBasedOnOrderCode(int orderhdr_id, int order_item_seq) {
		List<PaybreakModel> data = new ArrayList<>();
		try {
			// List<Map<String,Object>> =
			StringBuilder query = new StringBuilder(
					"select order_item_break_type ,order_item_amt_break_seq,order_item_seq, paybreak_type,local_amount,base_amount,pcurrency,bogus_commission,ocurrency,bcurrency,payment_seq,paybreak_seq,orderhdr_id,customer_id,pay_currency_amount from view_paybreak_oibreak where orderhdr_id="
							+ orderhdr_id + " and order_item_seq =" + order_item_seq);

			data = jdbcTemplate.query(query.toString(), new PaybreakMapper());

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return data;
	}

	@Override
	public List<Map<String, Object>> getDefaultValuesOnPaymentTypeChange(String payment_type, int payerCustomer) {

		List<Map<String, Object>> defaultValues = new ArrayList();
		try {

			defaultValues = jdbcTemplate.queryForList(
					"select top 1 payment_account_seq,credit_card_info,credit_card_start_date,credit_card_expire,card_verification_value,id_nbr_last_four from payment_account where customer_id ="
							+ payerCustomer + "and is_active =" + 1 + "and payment_type =" + "'" + payment_type + "'");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultValues;

	}

	@Override
	public List<DropdownModel> getCurrency() {
		LOGGER.info("Inside getCurrency");
		List<DropdownModel> getCurrency = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate
					.queryForList("  select currency,description,currency_symbol from currency");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("currency").toString());
				model.setDisplay((String) row.get("description"));
				model.setDescription(row.get("currency_symbol") != null ? row.get("currency_symbol").toString() : "");
				getCurrency.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return getCurrency;
	}

	@Override
	public List<DropdownModel> getdefaultPaymentAccountSeq(int payerCustomer, int payment_seq) {
		List<Map<String, Object>> defaultValues = new ArrayList();
		List<DropdownModel> defaultPaymentAccountSeq = new ArrayList<>();
		try {
			defaultValues = jdbcTemplate.queryForList("  select payment_account_seq from payment where customer_id="
					+ payerCustomer + "and payment_seq=" + payment_seq);
			for (Map<String, Object> row : defaultValues) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_account_seq").toString());
				defaultPaymentAccountSeq.add(model);

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultPaymentAccountSeq;

	}

	@Override
	public List<Map<String, Object>> getpaymentSelectedProcessing(int customerId, int payment_seq) {
		List<Map<String, Object>> value = new ArrayList();
		try {

			value = jdbcTemplate.queryForList(
					" select (CASE when processing=0 then 'false' when processing=1 then 'true' END)as processing from payment where customer_id="
							+ customerId + "and payment_seq=" + payment_seq);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return value;

	}

	@Override
	public String getDefaultPaymentType() {
		System.out.println("inside getDefaultPaymentType method.....");
		String value = null;

		try {

			value = jdbcTemplate.queryForObject("select default_payment_type_pay_add from config", String.class);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return value;

	}

	@Override
	public Integer getOverPaymentHandling() {
		System.out.println("inside getOverPaymentHandling");

		Integer value = null;
		try {

			value = jdbcTemplate.queryForObject("select default_refund from config", Integer.class);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return value;

	}

	@Override
	public List<Map<String, Object>> getdefaultCurrencyinEditPayment(int customer_id, int payment_seq) {
		LOGGER.info("Inside default currency");
		List<Map<String, Object>> defaultcurrency = new ArrayList<>();
		try {
			defaultcurrency = jdbcTemplate.queryForList(
					"(select currency,description,exchange_rate from currency where currency=  (select currency from payment where customer_id="
							+ customer_id + " and payment_seq=" + payment_seq + "))");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultcurrency;
	}

	// underpayment option is added by Malini
	@Override
	public String getUnderPaymentOption() {
		LOGGER.info("Inside default currency");

		String value = null;
		try {
			value = jdbcTemplate.queryForObject(
					"  select (CASE when  on_under_payment=0 then 'prorate issue' when on_under_payment=1 then 'Partial Payment' when on_under_payment=2 then 'Reject Payment' END) as on_under_payment from payment_threshold",
					String.class);
			/*value = jdbcTemplate.queryForObject("select under_payment_notify from payment_threshold",String.class); */ 
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return value;
	}

	@Override
	public double getDeliveryAmount() {
		LOGGER.info("Inside default currency");
		double amount = 0.0;

		try {
			amount = jdbcTemplate.queryForObject("select distinct amount from delivery_method", Double.class);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return amount;
	}

	@Override
	public String getPaymentTypeForCustomer(int customer_id) {
		LOGGER.info("Inside getPaymentTypeForCustomer ");
		String value = null;

		try {
			value = jdbcTemplate.queryForObject(
					"select payment_type from payment_Account where customer_id=" + customer_id, String.class);

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return value;
	}

	@Override
	public List<DropdownModel> currencyList(int customerId) {

		List<DropdownModel> currencyList = new ArrayList<>();
		
		DropdownModel dropdownmodel=new DropdownModel();
		dropdownmodel.setKey("[all]");
		dropdownmodel.setDisplay("[all]");
		 currencyList.add(dropdownmodel);
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("select currency from  payment  where  "
					+ "customer_id="+customerId+"  group by currency");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("currency").toString());
				model.setDisplay(row.get("currency").toString());

				currencyList.add(model);
				
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return currencyList;
	}
	@Override
	public List<DropdownModel> getDefaultPaymentTypeInfo() {
		List<Map<String, Object>> defaultValues = new ArrayList();
		List<DropdownModel> defaultPaymentAccountSeq = new ArrayList<>();
		try {
			defaultValues = jdbcTemplate.queryForList("  select config.default_payment_type_pay_add,payment_type.description from config inner join payment_type on payment_type.payment_type=config.default_payment_type_pay_add ");
			for (Map<String, Object> row : defaultValues) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("default_payment_type_pay_add").toString()!=null?row.get("default_payment_type_pay_add").toString():"");
				model.setDisplay(row.get("description").toString()!=null?row.get("description").toString():"");
				defaultPaymentAccountSeq.add(model);

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultPaymentAccountSeq;
	}

	@Override
	public List<DropdownModel> getPaymentType(int customer_id) {
		List<Map<String, Object>> defaultValues = new ArrayList();
		List<DropdownModel> defaultPaymenrtType = new ArrayList<>();
		try {
			defaultValues = jdbcTemplate.queryForList(" select payment_account.payment_type,payment_type.description,payment_type.payment_form,payment_type.credit_card_type from payment_account inner join payment_type on payment_account.payment_type=payment_type.payment_type where customer_id="+customer_id);
			//defaultValues = jdbcTemplate.queryForList(" select top 1 payment_account.payment_type,payment_type.description,payment_type.payment_form,payment_type.credit_card_type from payment_account inner join payment_type on payment_account.payment_type=payment_type.payment_type where customer_id="+customer_id);
			for (Map<String, Object> row : defaultValues) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_type")!=null?row.get("payment_type").toString():"");
				model.setDescription(row.get("description")!=null?row.get("description").toString():"");
				model.setExtraDataDef(row.get("credit_card_type")!=null?row.get("credit_card_type").toString():"");
				model.setExtraDataDef2(row.get("payment_form")!=null?row.get("payment_form").toString():"");
				defaultPaymenrtType.add(model);

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultPaymenrtType;
	}

	@Override
	public List<DropdownModel> getdefaultPaymentAccountSeqInMake(int payerCustomer) {
		List<Map<String, Object>> defaultValues = new ArrayList();
		List<DropdownModel> defaultPaymenrtAccountType = new ArrayList<>();
		try {
			defaultValues = jdbcTemplate.queryForList(" select top 1 payment_account_seq,description,id_nbr_last_four from payment_account where customer_id ="+payerCustomer);
			for (Map<String, Object> row : defaultValues) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_account_seq")!=null?row.get("payment_account_seq").toString():"");
				System.out.println("rows:"+row);
				model.setDisplay(row.get("description")!=null?row.get("description").toString():"");
				model.setDescription(row.get("id_nbr_last_four") != null?row.get("id_nbr_last_four").toString() :"");
				defaultPaymenrtAccountType.add(model);

			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return defaultPaymenrtAccountType;
	}

	@Override
	public List<Map<String, Object>> getdefaultCurrencyFromConfig() {
		List<Map<String, Object>> defaultValues = new ArrayList();
		try {
			defaultValues = jdbcTemplate.queryForList(" select currency from config ");

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		return defaultValues;
	}

	@Override
	public String getCreditCardNumber(int customer_id, int payment_seq) {
		List<Map<String, Object>> cardNumber = new ArrayList();
		String cNumber=null;
		try {
			CryptoServiceSoap soap = null;
			CryptoServiceLocator locator = new CryptoServiceLocator();
			soap = locator.getCryptoServiceSoap();
			cardNumber = jdbcTemplate.queryForList("select id_nbr from payment where customer_id="+customer_id+" and payment_seq="+payment_seq);
			String number=cardNumber.get(0).get("id_nbr").toString();
			System.out.println("------------");
			if(number!=null) {
				System.out.println("<------->");
			cNumber=soap.decryption(number);
			System.out.println(cNumber);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}

		
		return cNumber;
	}


	}
