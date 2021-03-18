package com.mps.think.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.tempuri.CryptoServiceLocator;
import org.tempuri.CryptoServiceSoap;

import com.mps.think.dao.PaymentAccountDao;
import com.mps.think.model.CustomerAddressModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.PaymentAccountModel;
import com.mps.think.resultMapper.CustomerAddressMapper;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
import com.mps.think.wsdl.PaymentWsdl;

import Think.XmlWebServices.Customer_identifier;
import Think.XmlWebServices.Payment_account_add_request;
import Think.XmlWebServices.Payment_account_data;
import Think.XmlWebServices.Payment_account_info_select_response;
import Think.XmlWebServices.ThinkSoap;
import Think.XmlWebServices.ThinkWSLocator;
import Think.XmlWebServices.User_login_data;

@Repository
public class PaymentAccountDaoImpl implements PaymentAccountDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentAccountDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	CustomerUtility customerUtility;

	@Override
	public List<DropdownModel> getpaymentTypeList() throws SQLException {

		LOGGER.info("Inside getpaymentTypeList");
		List<DropdownModel> paymentTypeList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate
				.queryForList("select payment_type,description from payment_type where credit_card_type !=0");
		for (Map<String, Object> row : rows) {
			DropdownModel model = new DropdownModel();
			model.setKey(row.get("payment_type").toString());
			model.setDisplay(row.get("payment_type") + "-" + row.get("description"));
			paymentTypeList.add(model);
		}
		return paymentTypeList;

	}

	@Override
	public void getCardAddress(Long customerId, PaymentAccountModel paymentAccountModel) throws SQLException {
		LOGGER.info("Inside getCardAddress");
		int count = jdbcTemplate.queryForObject(
				"select count(*) from customer_address, customer where customer.customer_id = customer_address.customer_id "
						+ "and customer.default_cust_addr_seq = customer_address.customer_address_seq and customer.customer_id = "
						+ customerId,
				Integer.class);
		if (count > 0) {
			CustomerAddressModel customerAddressModel = (CustomerAddressModel) jdbcTemplate
					.queryForObject("select customer_address.* "
							+ "from customer_address, customer where customer.customer_id = customer_address.customer_id "
							+ "and customer.default_cust_addr_seq = customer_address.customer_address_seq and customer.customer_id = "
							+ customerId, new CustomerAddressMapper());
			paymentAccountModel.setDefaultAddressSeq(customerAddressModel.getCustomerAddressSeq());
//paymentAccountModel.setCardAddress(customerUtility.getString(customerAddressModel.getAddress1()) + " " + customerUtility.getString(customerAddressModel.getAddress2()));
		} else {
			CustomerAddressModel customerAddressModel = (CustomerAddressModel) jdbcTemplate.queryForObject(
					"select customer_address.* "
							+ "from customer_address, customer where customer.customer_id = customer_address.customer_id "
							+ "and customer_address.customer_address_seq = 1 and customer.customer_id = " + customerId,
					new CustomerAddressMapper());
			paymentAccountModel.setDefaultAddressSeq(customerAddressModel.getCustomerAddressSeq());
//	paymentAccountModel.setCardAddress(customerUtility.getString(customerAddressModel.getAddress1()) + " " + customerUtility.getString(customerAddressModel.getAddress2()));
		}
	}

	@Override
	public String addPaymentAccount(PaymentAccountModel paymentAccountModel) {
		LOGGER.info("Inside addPaymentAccount");
		SimpleDateFormat inSDF = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd");
		try {

			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			soap = locator.getThinkSoap();

			User_login_data login = new User_login_data();
			login.setLogin(new PropertyUtilityClass().getQuery("login"));
			login.setPassword(new PropertyUtilityClass().getQuery("password"));

			Payment_account_add_request payment_account_add_request = new Payment_account_add_request();

			payment_account_add_request.setDsn(new PropertyUtilityClass().getQuery("dsn"));
			payment_account_add_request.setDoc_ref_id(paymentAccountModel.getDocumentReferenceId());
			payment_account_add_request.setUser_login_data(login);

			Customer_identifier customer_identifier = new Customer_identifier();
			customer_identifier.setCustomer_id(Integer.parseInt(paymentAccountModel.getCustomerId().toString()));

			payment_account_add_request.setCustomer_identifier(customer_identifier);

			Payment_account_data payment_account_data = new Payment_account_data();

			if (null != paymentAccountModel.getDescription() && !"".equals(paymentAccountModel.getDescription()))
				payment_account_data.setDescription(paymentAccountModel.getDescription());

			if ("true".equals(paymentAccountModel.getActive()))
				payment_account_data.setIs_active(true);
			else
				payment_account_data.setIs_active(false);

			if (null != paymentAccountModel.getCreditCard() && !"".equals(paymentAccountModel.getCreditCard()))
				payment_account_data.setId_nbr(paymentAccountModel.getCreditCard());

			if (null != paymentAccountModel.getCustomerId() && !"".equals(paymentAccountModel.getCustomerId()))
				payment_account_data
						.setBill_to_customer_id(Integer.parseInt(paymentAccountModel.getCustomerId().toString()));

			if (null != paymentAccountModel.getPaymentType() && !"".equals(paymentAccountModel.getPaymentType()))
				payment_account_data.setPayment_type(paymentAccountModel.getPaymentType());

			if (null != paymentAccountModel.getCardAddress() && !"".equals(paymentAccountModel.getCardAddress()))
				payment_account_data
						.setBill_to_customer_address_seq(Integer.parseInt(paymentAccountModel.getCardAddress()));

			if (null != paymentAccountModel.getExpireDate() && !"".equals(paymentAccountModel.getExpireDate())) {
				String date = "30/" + paymentAccountModel.getExpireDate();
//Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date); 
				Date invDate = inSDF.parse(date);
				String invFinalDate = outSDF.format(invDate);
				payment_account_data.setCredit_card_expire(new PropertyUtilityClass().dateFormatter(invFinalDate));
			}

			if (null != paymentAccountModel.getStartDate() && !"".equals(paymentAccountModel.getStartDate())) {
				String date = "01/" + paymentAccountModel.getStartDate();
//Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date); 
				Date invDate = inSDF.parse(date);
				String invFinalDate = outSDF.format(invDate);
				payment_account_data.setCredit_card_start_date(new PropertyUtilityClass().dateFormatter(invFinalDate));

			}

			if (null != paymentAccountModel.getIssueNumber() && !"".equals(paymentAccountModel.getIssueNumber()))
				payment_account_data.setCredit_card_issue_id(paymentAccountModel.getIssueNumber());

			if (null != paymentAccountModel.getNameOnCard() && !"".equals(paymentAccountModel.getNameOnCard()))
				payment_account_data.setCredit_card_info(paymentAccountModel.getNameOnCard());

			if (null != paymentAccountModel.getExpirationNotice()
					&& !"".equals(paymentAccountModel.getExpirationNotice())) {
//	payment_account_data.setExpiry_notice_sent_date(paymentAccountModel.getExpirationNotice());
			}

			if (null != paymentAccountModel.getBankName() && !"".equals(paymentAccountModel.getBankName()))
				payment_account_data.setDd_bank_name(paymentAccountModel.getBankName());

			if (null != paymentAccountModel.getBranchTitle() && !"".equals(paymentAccountModel.getBranchTitle()))
				payment_account_data.setBranch_title(paymentAccountModel.getBranchTitle());

			if (null != paymentAccountModel.getSortCode() && !"".equals(paymentAccountModel.getSortCode()))
				payment_account_data.setDd_sorting_code(paymentAccountModel.getSortCode());

			if (null != paymentAccountModel.getTransposedSortCode()
					&& !"".equals(paymentAccountModel.getTransposedSortCode()))
				payment_account_data.setDd_sorting_code_transposed(paymentAccountModel.getTransposedSortCode());

			if (null != paymentAccountModel.getAccountNumber() && !"".equals(paymentAccountModel.getAccountNumber()))
				payment_account_data.setBa_nbr(paymentAccountModel.getAccountNumber());

			if (null != paymentAccountModel.getTransposedAccountNumber()
					&& !"".equals(paymentAccountModel.getTransposedAccountNumber()))
				payment_account_data.setDd_id_nbr_transposed(paymentAccountModel.getTransposedAccountNumber());

			if (null != paymentAccountModel.getAccountName() && !"".equals(paymentAccountModel.getAccountName()))
				payment_account_data.setDd_bank_description(paymentAccountModel.getAccountName());

			if (null != paymentAccountModel.getBankState() && !"".equals(paymentAccountModel.getBankState()))
				payment_account_data.setDd_state(paymentAccountModel.getBankState());

//			if (null != paymentAccountModel.getSecureStoreId() && !"".equals(paymentAccountModel.getSecureStoreId()))
//				payment_account_data.setSecure_store_id(paymentAccountModel.getSecureStoreId());

			if (null != paymentAccountModel.getCreditCardLastFourDigit()
					&& !"".equals(paymentAccountModel.getCreditCardLastFourDigit()))
				payment_account_data.setId_nbr_last_four(paymentAccountModel.getCreditCardLastFourDigit());
							
			/*
			 * Passing parameter secure_store_id_obtained_date in case of SECURE TOKEN Add
			 */
			if (null != paymentAccountModel.getSecureStore() && !"".equals(paymentAccountModel.getSecureStore())) {
				payment_account_data.setSecure_store_id_obtained_date(java.sql.Date.valueOf(java.time.LocalDate.now()));
				payment_account_data.setSecure_store_id(paymentAccountModel.getSecureStore());
			}
				
			payment_account_add_request.setPayment_account_data(payment_account_data);
			soap.paymentAccountAdd(payment_account_add_request);

			return "added";
		}catch(AxisFault e){			
			//Soap Exception
			String fault=e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
			LOGGER.info("Payment Account = "+fault);		
			 return fault;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			return ERROR;
		}
	}

	@Override
	public List<Map<String, Object>> getpaymentAccountList(Long customerId) {
		LOGGER.info("Inside addPaymentAccount");
		List<Map<String, Object>> rows = new ArrayList<>(); 
		try {
			 PaymentWsdl obj = new PaymentWsdl();
			 List<Payment_account_info_select_response> bankDetailsList = obj.bankDetailsList(customerId);
			 Map<String, Object> map = null;
			 List<Map<String, Object>> date = new ArrayList<>(); 
			 if(bankDetailsList.get(0).getPayment_account()[0].getPayment_account_seq()!=0) {
			 for(Payment_account_info_select_response row:bankDetailsList) {
				 date= jdbcTemplate.queryForList("select format(creation_date,'yyyy-MM-dd HH:mm:s tt')as creation_date from payment_account where customer_id="+customerId+"");
				 		for(int i=0;i<row.getPayment_account().length;i++) {
						map = new LinkedHashMap<String, Object>();
						map.put("payment_account_seq", row.getPayment_account(i).getPayment_account_seq());
						map.put("is_active", row.getPayment_account(i).getIs_active());
						map.put("description", row.getPayment_account(i).getDescription()!=null?row.getPayment_account(i).getDescription():null);
						if(row.getPayment_account(i).getCreation_date()!=null) {
							String creation_date = date.get(i).get("creation_date").toString();
							map.put("creation_date",creation_date);
						}else {
							map.put("creation_date",null);
						}
						
						SimpleDateFormat sdfTime1 = new SimpleDateFormat("yyy-MM-dd");	
						
						if(row.getPayment_account(i).getCredit_card_expire()!=null) {
							Date credit_card_expire = row.getPayment_account(i).getCredit_card_expire();
							map.put("credit_card_expire", sdfTime1.format(credit_card_expire));
						}else {
							map.put("credit_card_expire",null);
						}
						map.put("payment_form",row.getPayment_account(i).getPayment_form()!=0?row.getPayment_account(i).getPayment_form():null);
						map.put("credit_card_issue_id",row.getPayment_account(i).getCredit_card_issue_id()!=null?row.getPayment_account(i).getCredit_card_issue_id():null);
						map.put("payment_type",row.getPayment_account(i).getPayment_type()!=null?row.getPayment_account(i).getPayment_type():null);
						map.put("dd_bank_description",row.getPayment_account(i).getDd_bank_description()!=null?row.getPayment_account(i).getDd_bank_description():null);
						map.put("bill_to_customer_address_seq",row.getPayment_account(i).getBill_to_customer_address_seq()!=0?row.getPayment_account(i).getBill_to_customer_address_seq():null);
						map.put("bill_to_customer_id",row.getPayment_account(i).getBill_to_customer_id()!=0?row.getPayment_account(i).getBill_to_customer_id():null);
						map.put("bank_account_type",row.getPayment_account(i).getBank_account_type()!=null?row.getPayment_account(i).getBank_account_type():null);
						map.put("credit_card_info",row.getPayment_account(i).getCredit_card_info()!=null?row.getPayment_account(i).getCredit_card_info():null);
						
						if(row.getPayment_account(i).getCredit_card_start_date()!=null) {
							Date credit_card_start_date = row.getPayment_account(i).getCredit_card_start_date();
							map.put("credit_card_start_date",sdfTime1.format(credit_card_start_date));
						}else {
							map.put("credit_card_start_date",null);
						}
						map.put("customer_id",row.getPayment_account(i).getCustomer_id());
						map.put("dd_sorting_code",row.getPayment_account(i).getDd_sorting_code()!=null?row.getPayment_account(i).getDd_sorting_code():null);
						map.put("card_verification_value",row.getPayment_account(i).getCard_verification_value()!=null?row.getPayment_account(i).getCard_verification_value():null);
						map.put("dd_state",row.getPayment_account(i).getDd_state()!=null?row.getPayment_account(i).getDd_state():null);
						map.put("dd_bank_name",row.getPayment_account(i).getDd_bank_name()!=null?row.getPayment_account(i).getDd_bank_name():null);
						map.put("row_version", null);
						map.put("id_nbr_last_four",row.getPayment_account(i).getId_nbr_last_four()!=null?row.getPayment_account(i).getId_nbr_last_four():null);
						map.put("dd_id_nbr_transposed",row.getPayment_account(i).getDd_id_nbr_transposed()!=null?row.getPayment_account(i).getDd_id_nbr_transposed():null);
						map.put("dd_sorting_code_transposed",row.getPayment_account(i).getDd_sorting_code_transposed()!=null?row.getPayment_account(i).getDd_sorting_code_transposed():null);
						map.put("branch_title",row.getPayment_account(i).getBranch_title()!=null?row.getPayment_account(i).getBranch_title():null);
						map.put("expiry_notice_sent_days_left",row.getPayment_account(i).getExpiry_notice_sent_days_left()!=0?row.getPayment_account(i).getExpiry_notice_sent_days_left():null);
						
						if(row.getPayment_account(i).getExpiry_notice_sent_date()!=null) {
							Date expiry_notice_sent_date = row.getPayment_account(i).getExpiry_notice_sent_date();
							map.put("expiry_notice_sent_date",sdfTime1.format(expiry_notice_sent_date));
						}else {
							map.put("expiry_notice_sent_date",null);
						}
						
						map.put("secure_store_id_obtained_date",row.getPayment_account(i).getSecure_store_id_obtained_date()!=null?sdfTime1.format(row.getPayment_account(i).getSecure_store_id_obtained_date()):null);
						map.put("secure_bank_def_id",row.getPayment_account(i).getSecure_bank_def_id()!=0?row.getPayment_account(i).getSecure_bank_def_id():null);
						if(row.getPayment_account(i).getId_nbr()!=null && !row.getPayment_account(i).getId_nbr().equals("")) {
							String creditCard = "XXXXXXXXXXXX";
							map.put("id_nbr",creditCard+row.getPayment_account(i).getId_nbr());
						}else {
							map.put("id_nbr",null);
						}
						if(row.getPayment_account(i).getBa_nbr()!=null && !row.getPayment_account(i).getBa_nbr().equals("")) {
							String debitCard = "XXXXXXXXXXXX";
							map.put("ba_nbr",debitCard+row.getPayment_account(i).getBa_nbr());
						}else {
							map.put("ba_nbr",null);
						}
						rows.add(map);
						 System.out.println(map);
					}
				}
			 }
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return rows;
	}

	@Override
	public List<DropdownModel> getaddressList(Long customerId) throws SQLException {
		LOGGER.info("Inside getaddressList");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("customer_id", customerId);

		List<DropdownModel> addressList = new ArrayList<>();

		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList("SELECT * FROM customer_address "
				+ "WHERE customer_id= :customer_id and replace_customer_address_seq is NULL ORDER BY customer_address_seq asc",
				parameters);
		for (Map<String, Object> row : rows) {
			DropdownModel model = new DropdownModel();
			model.setKey(row.get("customer_address_seq") + "");
			model.setDisplay(
					row.get("address1") + "," + row.get("address2") + "," + row.get("city") + "," + row.get("state"));
			addressList.add(model);
		}

		return addressList;
	}

	@Override
	// public List<Map<String, Object>> getPaymentAccountDetails(Long customerId,
	// int payment_account_seq) {
	public PaymentAccountModel getPaymentAccountDetails(Long customerId, int payment_account_seq) throws ServiceException {
		LOGGER.info("Inside getPaymentAccountDetails");
		PaymentAccountModel paymentAccountModel = new PaymentAccountModel();
		try {
		CryptoServiceSoap soap = null;
		CryptoServiceLocator locator = new CryptoServiceLocator();
		soap = locator.getCryptoServiceSoap();
		

		String query = ("select customer.fname,customer.lname,payment_account.is_active,payment_account.description,payment_account.creation_date,payment_account.credit_card_expire,payment_account.payment_form,payment_account.credit_card_issue_id,payment_account.payment_type,payment_account.dd_bank_description,payment_account.bill_to_customer_address_seq,payment_account.bill_to_customer_id, "
				+ "payment_account.bank_account_type,payment_account.credit_card_info,payment_account.credit_card_start_date,payment_account.customer_id,payment_account.dd_sorting_code,payment_account.card_verification_value,payment_account.dd_state,payment_account.dd_bank_name,payment_account.row_version,payment_account.id_nbr_last_four,payment_account.dd_id_nbr_transposed,payment_account.dd_sorting_code_transposed,payment_account.id_nbr,"
				+ "payment_account.branch_title,payment_account.expiry_notice_sent_days_left,payment_account.expiry_notice_sent_date,payment_account.secure_store_id_obtained_date,payment_account.secure_bank_def_id,payment_account.ba_nbr "
				+ "from payment_account inner join customer on customer.customer_id=payment_account.customer_id where payment_account.customer_id= "
				+ customerId + "and payment_account_seq=" + payment_account_seq);


		SqlRowSet rs = jdbcTemplate.queryForRowSet(query);

		if (rs.next()) {
			LOGGER.info("rs.getString(\"fname\")" + rs.getString("fname"));
			paymentAccountModel.setActive(rs.getString("is_active"));
			paymentAccountModel.setDescription(rs.getString("description"));

			paymentAccountModel.setStartDate(rs.getString("credit_card_start_date"));
			paymentAccountModel.setExpireDate(rs.getString("credit_card_expire"));
			paymentAccountModel.setBankName(rs.getString("dd_bank_name"));
			paymentAccountModel.setAccountName(rs.getString("dd_bank_description"));
			//paymentAccountModel.setAccountNumber(rs.getString("ba_nbr"));
			String accountNo = "XXXXXXX";		
			if(rs.getString("ba_nbr")!=null) {
			String accountNumber= soap.decryption(rs.getString("ba_nbr").toString());
			paymentAccountModel.setAccountNumber(accountNumber);}
			if(rs.getString("id_nbr")!=null) {
				String accountNumber= soap.decryption(rs.getString("id_nbr").toString());
				paymentAccountModel.setAccountNumber(accountNumber);}
			paymentAccountModel.setBankState(rs.getString("dd_state"));
			paymentAccountModel.setCreditCard(rs.getString("id_nbr"));
			paymentAccountModel.setBranchTitle(rs.getString("branch_title"));
			paymentAccountModel.setCardAddress(rs.getString("bill_to_customer_address_seq"));
			paymentAccountModel.setCardHolder(rs.getString("bill_to_customer_id"));
			paymentAccountModel.setNameOnCard(rs.getString("credit_card_info"));
			paymentAccountModel.setIssueNumber(rs.getString("credit_card_issue_id"));
			paymentAccountModel.setCustomerId(rs.getLong("customer_id"));
			paymentAccountModel.setPaymentType(rs.getString("payment_type"));
			LOGGER.info("payment_type:{}", paymentAccountModel.getPaymentType());

			paymentAccountModel.setSortCode(rs.getString("dd_sorting_code"));
			paymentAccountModel.setTransposedSortCode(rs.getString("dd_sorting_code_transposed"));
			paymentAccountModel.setTransposedAccountNumber(rs.getString("dd_id_nbr_transposed"));
			paymentAccountModel.setCreditCardLastFourDigit(rs.getString("id_nbr_last_four"));
			paymentAccountModel.setExpirationNotice(rs.getString("expiry_notice_sent_date"));
			paymentAccountModel.setSecureStoreId(rs.getString("id_nbr"));
			paymentAccountModel.setCardHolder(rs.getString("fname") + rs.getString("lname"));

			paymentAccountModel.setSecureStoreDate(rs.getString("secure_store_id_obtained_date"));
			LOGGER.info("securestoreid:{}", paymentAccountModel.getSecureStoreDate());

		}
		} catch (InvalidResultSetAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paymentAccountModel;

	}

	@Override
	public int updatePaymentAccountDetails(PaymentAccountModel paymentAccountModel, int paymentAccountSeq) {

		int status = 0;

		try {
			LOGGER.info("Inside Payment update Method");
			CryptoServiceSoap soap = null;
			CryptoServiceLocator locator = new CryptoServiceLocator();
			soap = locator.getCryptoServiceSoap();
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("customer_id", paymentAccountModel.getCustomerId());
			//parameters.put("is_active", paymentAccountModel.getActive());
			parameters.put("is_active",("true".equals(paymentAccountModel.getActive())?1:0));
			
			parameters.put("description", paymentAccountModel.getDescription());
			parameters.put("payment_type", paymentAccountModel.getPaymentType());

			/*
			 * if (paymentAccountModel.getPaymentType().equals("DirectDebit")||
			 * paymentAccountModel.getPaymentType().equals("DD")) {
			 * LOGGER.info("update for DD:{}", paymentAccountModel.getPaymentTypeList());
			 * query =
			 * "update payment_account set is_active=:is_active,description=:description,payment_type=:payment_type,dd_bank_name=:dd_bank_name,dd_sorting_code=:dd_sorting_code,ba_nbr=:ba_nbr,dd_id_nbr_transposed=:dd_id_nbr_transposed,dd_bank_description=:dd_bank_description,dd_state=:dd_state,branch_title=:branch_title where customer_id ="
			 * + paymentAccountModel.getCustomerId() + " and payment_account_seq =" +
			 * paymentAccountSeq;
			 * 
			 * parameters.put("dd_bank_name", paymentAccountModel.getBankName());
			 * parameters.put("dd_sorting_code", paymentAccountModel.getSortCode());
			 * parameters.put("dd_sorting_code_transposed",
			 * paymentAccountModel.getTransposedSortCode()); parameters.put("ba_nbr",
			 * paymentAccountModel.getAccountNumber());
			 * parameters.put("dd_id_nbr_transposed",
			 * paymentAccountModel.getTransposedAccountNumber());
			 * parameters.put("dd_bank_description", paymentAccountModel.getAccountName());
			 * parameters.put("dd_state", paymentAccountModel.getBankState());
			 * parameters.put("branch_title", paymentAccountModel.getBranchTitle()); //
			 * status = namedParameterJdbcTemplate.update(updatePaymentQuery1, parameters);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * } else if
			 * (paymentAccountModel.getPaymentType().equals("CC")||paymentAccountModel.
			 * getPaymentType().equals("VS")) { LOGGER.info("update for CC:{}",
			 * paymentAccountModel.getPaymentTypeList().toString()); query =
			 * "update payment_account set  is_active=:is_active,description=:description,payment_type=:payment_type,credit_card_info=:credit_card_info,credit_card_start_date=:credit_card_start_date,credit_card_expire=:credit_card_expire,id_nbr=:id_nbr,bill_to_customer_id=:bill_to_customer_id,bill_to_customer_address_seq=:bill_to_customer_address_seq,"
			 * +
			 * "expiry_notice_sent_date=:expiry_notice_sent_date,credit_card_issue_id=:credit_card_issue_id where customer_id="
			 * + paymentAccountModel.getCustomerId() + " and payment_account_seq =" +
			 * paymentAccountSeq;
			 * 
			 * parameters.put("credit_card_info", paymentAccountModel.getNameOnCard());
			 * LOGGER.info("update for credit info CC:{}",
			 * paymentAccountModel.getNameOnCard()); parameters.put("credit_card_issue_id",
			 * paymentAccountModel.getIssueNumber());
			 * 
			 * String startdate = "02/" + paymentAccountModel.getStartDate();
			 * LOGGER.info("paymentAccountModel.getStartDate()----->" +
			 * paymentAccountModel.getStartDate()); Date date1 = new
			 * SimpleDateFormat("dd/mm/yyyy").parse(startdate);
			 * parameters.put("credit_card_start_date", date1);
			 * LOGGER.info("start Date if---->" + date1);
			 * 
			 * String expdate = "30/" + paymentAccountModel.getExpireDate();
			 * 
			 * Date date2 = new SimpleDateFormat("dd/mm/yyyy").parse(expdate);
			 * parameters.put("credit_card_expire", date2); LOGGER.info("exp Date if---->" +
			 * date2);
			 * 
			 * parameters.put("bill_to_customer_id", paymentAccountModel.getCardHolder());
			 * 
			 * LOGGER.info("card holder:{}", paymentAccountModel.getCardHolder());
			 * 
			 * parameters.put("bill_to_customer_address_seq",
			 * paymentAccountModel.getCardAddress());
			 * LOGGER.info("update for customer address seq CC:{}",
			 * paymentAccountModel.getCardAddress());
			 * parameters.put("expiry_notice_sent_date",
			 * paymentAccountModel.getExpirationNotice()); parameters.put("id_nbr",
			 * paymentAccountModel.getCreditCard());
			 * 
			 * }
			 * 
			 * else {
			 * 
			 * LOGGER.info("update for secure token");
			 * 
			 * query =
			 * "update payment_account set  is_active=:is_active,description=:description,payment_type=:payment_type,secure_store_id_obtained_date=:secure_store_id_obtained_date,credit_card_info=:credit_card_info,credit_card_start_date=:credit_card_start_date,credit_card_expire=:credit_card_expire,id_nbr=:id_nbr,bill_to_customer_id=:bill_to_customer_id,bill_to_customer_address_seq=:bill_to_customer_address_seq,"
			 * +
			 * "expiry_notice_sent_date=:expiry_notice_sent_date,credit_card_issue_id=:credit_card_issue_id,id_nbr_last_four=:id_nbr_last_four where customer_id="
			 * + paymentAccountModel.getCustomerId() + " and payment_account_seq =" +
			 * paymentAccountSeq;
			 * 
			 * parameters.put("credit_card_info", paymentAccountModel.getNameOnCard());
			 * 
			 * parameters.put("credit_card_issue_id", paymentAccountModel.getIssueNumber());
			 * 
			 * String startdate = "02/" + paymentAccountModel.getStartDate();
			 * LOGGER.info("paymentAccountModel.getStartDate()----->" +
			 * paymentAccountModel.getStartDate());
			 * 
			 * Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(startdate);
			 * parameters.put("credit_card_start_date", date1);
			 * 
			 * String expdate = "30/" + paymentAccountModel.getExpireDate(); Date date2 =
			 * new SimpleDateFormat("dd/MM/yyyy").parse(expdate);
			 * parameters.put("credit_card_expire", date2);
			 * 
			 * parameters.put("bill_to_customer_id", paymentAccountModel.getCardHolder());
			 * 
			 * LOGGER.info("card holder:{}", paymentAccountModel.getCardHolder());
			 * 
			 * parameters.put("bill_to_customer_address_seq",
			 * paymentAccountModel.getCardAddress()); LOGGER.info("card holder",
			 * paymentAccountModel.getCardAddress());
			 * parameters.put("expiry_notice_sent_date",
			 * paymentAccountModel.getExpirationNotice()); parameters.put("id_nbr",
			 * paymentAccountModel.getCreditCard()); parameters.put("id_nbr",
			 * paymentAccountModel.getSecureStoreId()); parameters.put("id_nbr_last_four",
			 * paymentAccountModel.getCreditCardLastFourDigit());
			 * 
			 * String secDate = "30/" + paymentAccountModel.getSecureStoreDate(); Date date3
			 * = new SimpleDateFormat("dd/MM/yyyy").parse(secDate);
			 * LOGGER.info("secDate{}:"+secDate);
			 * parameters.put("secure_store_id_obtained_date", date3);
			 * 
			 * //parameters.put("secure_store_id_obtained_date",paymentAccountModel.
			 * getSecureStoreDate()); LOGGER.info("securedate{}:",
			 * paymentAccountModel.getSecureStoreDate());
			 */
			String accountNumber= soap.encryption(paymentAccountModel.getAccountNumber());
			System.out.println(accountNumber);
			StringBuilder paymentAccountUpdate = new StringBuilder();
			if (paymentAccountModel.getPaymentType().equals("DirectDebit")
					|| paymentAccountModel.getPaymentType().equals("DD")) {
				LOGGER.info("update for DD:{}", paymentAccountModel.getPaymentTypeList());
				paymentAccountUpdate.append("update payment_account set is_active=:is_active,description=:description,payment_type=:payment_type,dd_bank_name=:dd_bank_name,dd_sorting_code=:dd_sorting_code,ba_nbr=:ba_nbr,dd_id_nbr_transposed=:dd_id_nbr_transposed,dd_bank_description=:dd_bank_description,dd_state=:dd_state,branch_title=:branch_title where customer_id = ")
				 .append(paymentAccountModel.getCustomerId()).append(" and payment_account_seq = ").append(paymentAccountSeq );

				parameters.put("dd_bank_name", paymentAccountModel.getBankName());
				parameters.put("dd_sorting_code", paymentAccountModel.getSortCode());
				parameters.put("dd_sorting_code_transposed", paymentAccountModel.getTransposedSortCode());
				parameters.put("ba_nbr", accountNumber);
				parameters.put("dd_id_nbr_transposed", paymentAccountModel.getTransposedAccountNumber());
				parameters.put("dd_bank_description", paymentAccountModel.getAccountName());
				parameters.put("dd_state", paymentAccountModel.getBankState());
				parameters.put("branch_title", paymentAccountModel.getBranchTitle());
				// status = namedParameterJdbcTemplate.update(updatePaymentQuery1, parameters);

			} else if (paymentAccountModel.getSecureStoreId()!="") {
				LOGGER.info("update for secure token");
				paymentAccountUpdate.append("update payment_account set  is_active=:is_active,description=:description,payment_type=:payment_type,credit_card_expire=:credit_card_expire,bill_to_customer_id=:bill_to_customer_id,bill_to_customer_address_seq=:bill_to_customer_address_seq,")
						.append( "credit_card_issue_id=:credit_card_issue_id");
						
				if(paymentAccountModel.getStartDate()!="") {
							paymentAccountUpdate.append(" ,credit_card_start_date=:credit_card_start_date ");
							String startdate = "02/" + paymentAccountModel.getStartDate();
							Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(startdate);
							parameters.put("credit_card_start_date", date1);}
				paymentAccountUpdate.append( " where customer_id= ").append(paymentAccountModel.getCustomerId()).append( " and payment_account_seq = ").append( paymentAccountSeq );

			//	parameters.put("credit_card_info", paymentAccountModel.getNameOnCard());
				parameters.put("credit_card_issue_id", paymentAccountModel.getIssueNumber());
                String expdate = "30/" + paymentAccountModel.getExpireDate();
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(expdate);
				parameters.put("credit_card_expire", date2);
				parameters.put("bill_to_customer_id", paymentAccountModel.getCardHolder());
				parameters.put("bill_to_customer_address_seq", paymentAccountModel.getCardAddress());
			//	parameters.put("expiry_notice_sent_date", paymentAccountModel.getExpirationNotice());
			//	parameters.put("id_nbr", paymentAccountModel.getCreditCard());
			//	parameters.put("id_nbr", paymentAccountModel.getSecureStoreId());
			//	parameters.put("id_nbr_last_four", paymentAccountModel.getCreditCardLastFourDigit());
			
			} else {
				LOGGER.info("update for CC:{}", paymentAccountModel.getPaymentTypeList().toString());
				paymentAccountUpdate.append( "update payment_account set  is_active=:is_active,description=:description,payment_type=:payment_type,credit_card_info=:credit_card_info,credit_card_issue_id=:credit_card_issue_id,credit_card_expire=:credit_card_expire,bill_to_customer_id=:bill_to_customer_id,bill_to_customer_address_seq=:bill_to_customer_address_seq ");
				//	.append( "expiry_notice_sent_date=:expiry_notice_sent_date ");
				if(paymentAccountModel.getStartDate()!="") {
					paymentAccountUpdate.append(" ,credit_card_start_date=:credit_card_start_date ");
					String startdate = "02/" + paymentAccountModel.getStartDate();				
					Date date1 = new SimpleDateFormat("dd/mm/yyyy").parse(startdate);
					parameters.put("credit_card_start_date", date1);}
					parameters.put("credit_card_issue_id", paymentAccountModel.getIssueNumber());
				
				paymentAccountUpdate.append(" where customer_id= ").append(paymentAccountModel.getCustomerId()).append(" and payment_account_seq =").append( paymentAccountSeq );
				parameters.put("credit_card_info", paymentAccountModel.getNameOnCard());
				String expdate = "30/" + paymentAccountModel.getExpireDate();
				Date date2 = new SimpleDateFormat("dd/mm/yyyy").parse(expdate);
				parameters.put("credit_card_expire", date2);
				parameters.put("bill_to_customer_id", paymentAccountModel.getCardHolder());
				parameters.put("bill_to_customer_address_seq", paymentAccountModel.getCardAddress());
			//	parameters.put("expiry_notice_sent_date", paymentAccountModel.getExpirationNotice());
			//	parameters.put("id_nbr", paymentAccountModel.getCreditCard());
			}
			status = namedParameterJdbcTemplate.update(paymentAccountUpdate.toString(), parameters);

			Map<String, Object> parameters1 = new HashMap<String, Object>();
			LOGGER.info("update for edit trail");
			String query1 = null;
			query1 = "insert into edit_trail(edit_trail_id,customer_id,user_code,document_reference_id,date_stamp,creation_date,xaction_name,payment_account_seq)"
					+ "values(:edit_trail_id,:customer_id,:user_code,:document_reference_id,:date_stamp,:creation_date,:xaction_name,:payment_account_seq)";

			//int editTrailId = jdbcTemplate.queryForObject("select max(edit_trail_id) from edit_trail", Integer.class);

			Long editTrailId = customerUtility.getmaxeditTrailId() + 1;
			parameters1.put("edit_trail_id", editTrailId);
			// parameters1.put("customer_address_seq", "");
			parameters1.put("user_code", "THK");
			// parameters1.put("subscrip_id", "");
			// parameters1.put("orderhdr_id", "");
			// parameters1.put("order_item_seq", "");
			// parameters1.put("order_item_amt_break_seq", "");
			// parameters1.put("edited", "");
			// parameters1.put("table_enum", "");
			parameters1.put("document_reference_id",paymentAccountModel.getDocumentReferenceId());
			// parameters1.put("document_reference_seq", "");
			// parameters1.put("local_amount", "");
			// parameters1.put("base_amount", "");
			parameters1.put("date_stamp", 1);
			parameters1.put("creation_date", new Date());
			parameters1.put("xaction_name", "payment_account_edit_request");
			// parameters1.put("payment_seq","");
			// parameters1.put("demographic_seq", "");
			// parameters1.put("job_id", "");
			parameters1.put("customer_id", paymentAccountModel.getCustomerId());
			parameters1.put("payment_account_seq", paymentAccountSeq);

			namedParameterJdbcTemplate.update(query1, parameters1);
			customerUtility.updateMruEditTrailId(editTrailId);
		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);
		}
		return status;

	}

	@Override
	public String clearPaymentAccount(Long customerId, int paymentAccountSeq) {
		int status = 0;
        int paymentClearStatus;
		boolean active = false;

		try {
			LOGGER.info("Inside clearPaymentAccount");
			String query = null;
			SqlRowSet row = jdbcTemplate.queryForRowSet("select is_active from payment_account where customer_id="
					+ customerId + " and payment_account_seq =" + paymentAccountSeq);

			if (row.next()) {
				active = row.getBoolean("is_active");
			}

			if (active) {
				LOGGER.info("paymentaccount is active");

				return "account in active status not possibe to clear";

			} else {
				LOGGER.info("paymentaccount is inActive");
				paymentClearStatus=jdbcTemplate.queryForObject("select count(payment_account_seq) as payment_account_seq  from payment where payment_account_seq="+paymentAccountSeq+" and customer_id=" + customerId + "", Integer.class);
				if(paymentClearStatus>0)	{
					return "Can not remove credit/debit card information from this payment account because there is at least one pending payment from this account.";
				}else {
				query = "delete from payment_account where  customer_id=" + customerId + " and payment_account_seq="
						+ paymentAccountSeq;
				jdbcTemplate.execute(query);

				return "accountcleared";
			}
			}
		} catch (Exception e) {
			e.printStackTrace();

			LOGGER.error(ERROR + e);

			return "error";
		}

	}
	@Override
	public Integer getCreditCardToggleValue() {
		//Map<String,Object> value=new HashMap<>();
		LOGGER.info("Inside getCredeitCardtoggleValue()....");
		Integer value = jdbcTemplate.queryForObject("select credit_card_authorization from config ", Integer.class);
			
		return value;
		
		
	}

	@Override
	public Integer getBankWizardToggleValue() {
		LOGGER.info("Inside getBankWizardtoggleValue()....");
		Integer value = jdbcTemplate.queryForObject("select bank_wizard_installed from config ", Integer.class);
			
		return value;
	}

	@Override
	public List<Map<String, Object>> getCreditAccountList(Long customerId, Integer active) {
		LOGGER.info("Inside getCreditAccountList(Long customerId, Integer active)....");
		List<Map<String, Object>> creditAccountList = new ArrayList<>();
		try {
			 creditAccountList = jdbcTemplate.queryForList(" SELECT * FROM payment_account WHERE customer_id = "+customerId+" and is_active = "+active+" and payment_type in (select payment_type from payment_type where payment_form in (1, 6, 7)) ORDER BY customer_id,payment_account_seq");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return creditAccountList;
	}

	@Override
	public List<Map<String, Object>> getDebitAccountList(Long customerId, Integer active) {
		LOGGER.info("Inside getDebitAccountList(Long customerId, Integer active)....");
		List<Map<String, Object>> debitAccountList = new ArrayList<>();
		try {
			debitAccountList = jdbcTemplate.queryForList(" SELECT * FROM payment_account WHERE customer_id = "+customerId+" and is_active = "+active+" and payment_type in (select payment_type from payment_type where payment_form = 4) ORDER BY customer_id,payment_account_seq");
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return debitAccountList;
	}

	

}
