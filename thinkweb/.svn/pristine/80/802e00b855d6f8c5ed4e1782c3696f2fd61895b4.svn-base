package com.mps.think.daoImpl;

import static com.mps.think.constants.SecurityConstants.ERROR;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mps.think.dao.CancelOrderDao;
import com.mps.think.model.CancelOrderAttributeModel;
import com.mps.think.model.CancelOrderDetailsModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.ExistingUnpaidOrdersModel;
import com.mps.think.model.RenewableItemsModel;
import com.mps.think.resultMapper.CancelOrderDetailsMapper;
import com.mps.think.resultMapper.ExistingUnpaidOrdersMapper;
import com.mps.think.resultMapper.RenewableItemsMapper;
import com.mps.think.util.PropertyUtilityClass;

import Think.XmlWebServices.Cancel_data;
import Think.XmlWebServices.Customer_identifier;
import Think.XmlWebServices.Order_cancel_request;
import Think.XmlWebServices.Payment_account_identifier;
import Think.XmlWebServices.Payment_refund_data;
import Think.XmlWebServices.Product_return_request;
import Think.XmlWebServices.Refund_calculate_request;
import Think.XmlWebServices.Refund_calculate_response;
import Think.XmlWebServices.Renewal_status_on_cancel;
import Think.XmlWebServices.Return_data;
import Think.XmlWebServices.ThinkSoap;
import Think.XmlWebServices.ThinkWSLocator;
import Think.XmlWebServices.User_login_data;
import Think.XmlWebServices.ZZBoolean;
import Think.XmlWebServices.ZZItemIdentifier;

@Repository
public class CancelOrderDaoImpl implements CancelOrderDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<DropdownModel> getcategory() {
		List<DropdownModel> category = new ArrayList<>();
		//Commented for resolving 610,611,615
		///.add(new DropdownModel("HAVEN","HAVEN - Haven Refund due to cancellation","Haven Refund due to cancellation",null,null,null));
		category.add(new DropdownModel("REFCANCEL","REFCANCEL - Refund due to cancellation","Refund due to cancellation",null,null,null));
		
		return category;
	}

	@Override
	public List<DropdownModel> getReasonList() throws SQLException {
		LOGGER.info("Inside getReasonList");
		List<DropdownModel>  reasonList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select cancel_reason,description from cancel_reason where active = 1");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("cancel_reason").toString());
				model.setDisplay(row.get("cancel_reason") + "-" + row.get("description"));
				//Added below by Sohrab for THINKDEV-597
				if(null!=row.get("description"))
				{
					model.setDescription(row.get("description").toString());
				}else
				{
					model.setDescription(null);
				}
				reasonList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return reasonList;
	}

	@Override
	public List<DropdownModel> getCurrencyTypeList() throws SQLException {
		LOGGER.info("Inside getCurrencyTypeList");
		List<DropdownModel>  reasonList = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select currency,description from currency");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("currency").toString());
				model.setDisplay(row.get("currency") + "-" + row.get("description"));
				//Added below by Sohrab for THINKDEV-596
				if(null!=row.get("description"))
				{
					model.setDescription(row.get("description").toString());
				}else
				{
					model.setDescription(null);
				}
				reasonList.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return reasonList;
	}

	@Override
	public List<DropdownModel> getPaymentTypeList() throws SQLException {
		LOGGER.info("Inside getPaymentTypeList");
		List<DropdownModel>  PaymentType = new ArrayList<>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(
					"select payment_type,description from payment_type");
			for (Map<String, Object> row : rows) {
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_type").toString());
				model.setDisplay(row.get("payment_type") + "-" + row.get("description"));
				//Added below by Sohrab for THINKDEV-596
				if(null!=row.get("description"))
				{
					model.setDescription(row.get("description").toString());
				}else
				{
					model.setDescription(null);
				}
				PaymentType.add(model);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return PaymentType;
	}

	@Override
	public List<DropdownModel> getCancellationRenewalStatusList(){
		LOGGER.info("Inside getCancellationRenewalStatusList");
		List<DropdownModel> CancellationRenewalStatus = new ArrayList<>();
		CancellationRenewalStatus.add(new DropdownModel("try","Try to Renew","Try to Renew",null,null,null));
		CancellationRenewalStatus.add(new DropdownModel("notry","Don't try to Renew","Don't try to Renew",null,null,null));
		return CancellationRenewalStatus;
	}

	
	
	@Override
	public List<CancelOrderDetailsModel> getOrderDetail(Long orderHdrId, int orderItemSeq) throws SQLException 
	{
		LOGGER.info("Inside getOrderDetail");
		//Sohrab edited for 1129,610,611,615,1119
		List<CancelOrderDetailsModel> finalOrderDetailsList = new ArrayList<>();
		try 
		{
				String order_item_query = "SELECT oc.order_code,oi.* FROM order_item oi INNER JOIN order_code oc ON oi.order_code_id=oc.order_code_id WHERE orderhdr_id=? AND order_item_seq=?;";
				CancelOrderDetailsModel cancelOrderDetailsModelObject = jdbcTemplate.queryForObject(order_item_query,new CancelOrderDetailsMapper(),orderHdrId,orderItemSeq);
				List<String>agency_data_list=null;
				String payment_status=null;
				Refund_calculate_response refundCalculateResponse = null;
				if(null!=cancelOrderDetailsModelObject)
				{
					if(null!=cancelOrderDetailsModelObject.getPayment_status())
					{
						payment_status=cancelOrderDetailsModelObject.getPayment_status();
					}
					if(null!=cancelOrderDetailsModelObject.getAgency_customer_id() && null!=cancelOrderDetailsModelObject.getCustomer_address_seq())
					{
							agency_data_list=new ArrayList<String>();
							String agencyDetailsCountQuery="SELECT COUNT(*) FROM agency a"+ 
									" INNER JOIN customer_address cadd ON cadd.customer_id=a.customer_id"+
									" WHERE cadd.customer_id="+cancelOrderDetailsModelObject.getAgency_customer_id()+
									" AND cadd.customer_address_seq="+cancelOrderDetailsModelObject.getCustomer_address_seq()+";";
							int agencyDetailsCount=jdbcTemplate.queryForObject(agencyDetailsCountQuery, Integer.class);
							if(agencyDetailsCount>0)
							{
								String agencyDetailsQuery="SELECT a.customer_id,a.agency_code,cadd.company FROM agency a"+ 
										" INNER JOIN customer_address cadd ON cadd.customer_id=a.customer_id"+
										" WHERE cadd.customer_id=? AND cadd.customer_address_seq=?;";
								Map<String,Object> agencyDetailsMap = jdbcTemplate.queryForMap(agencyDetailsQuery,cancelOrderDetailsModelObject.getAgency_customer_id(),cancelOrderDetailsModelObject.getCustomer_address_seq());
								agency_data_list.add(agencyDetailsMap.get("customer_id").toString());
								agency_data_list.add(agencyDetailsMap.get("agency_code").toString());
								agency_data_list.add(agencyDetailsMap.get("company").toString());
							}
					}
					cancelOrderDetailsModelObject.setAgency_data_list(agency_data_list);
					String order_code_type_query = "SELECT oc.order_code_type FROM order_item oi INNER JOIN order_code oc ON oi.order_code_id=oc.order_code_id WHERE orderhdr_id="+orderHdrId+" AND order_item_seq=1;";
					int order_code_type=jdbcTemplate.queryForObject(order_code_type_query, Integer.class);
					if(order_code_type!=4 && order_code_type!=6)
					{
						refundCalculateResponse = getRefundAmount(orderHdrId,orderItemSeq);
					}else
					{
						String currency=jdbcTemplate.queryForObject("SELECT currency FROM config;", String.class);
						cancelOrderDetailsModelObject.setRefAmt(BigDecimal.valueOf(0));
						cancelOrderDetailsModelObject.setRefCurr(currency);
					}
				}
				if(null!=refundCalculateResponse)
				{
					/** Here, cc_pmt_refund_amount is the refund amount in the payment currency*/
					BigDecimal cc_pmt_refund_amount=refundCalculateResponse.getCancel_item_info()[0].getCc_pmt_refund_amount();
					if(null!=cc_pmt_refund_amount)
					{
						if(cc_pmt_refund_amount.equals(BigDecimal.valueOf(0)) && null!=payment_status)
						{
							if(payment_status.equals("1"))
							{
								if(cancelOrderDetailsModelObject.getNetLocalAmount()!=0)
								{	
									BigDecimal netLocalAmt = new BigDecimal(cancelOrderDetailsModelObject.getNetLocalAmount()+"");
									netLocalAmt = netLocalAmt.setScale(2, BigDecimal.ROUND_HALF_EVEN);
									cc_pmt_refund_amount=netLocalAmt;
								}
								else if(cancelOrderDetailsModelObject.getGrossLocalAmount()!=0)
								{	
									BigDecimal grossLocalAmt = new BigDecimal(cancelOrderDetailsModelObject.getGrossLocalAmount()+"");
									grossLocalAmt = grossLocalAmt.setScale(2, BigDecimal.ROUND_HALF_EVEN);
									cc_pmt_refund_amount=grossLocalAmt;
								}
							}
						}
					}
					/** Here, cc_pmt_refund_currency is the refund currency. Must be a valid currency in the database.*/
					String cc_pmt_refund_currency=refundCalculateResponse.getCancel_item_info()[0].getCc_pmt_refund_currency();
					BigDecimal cc_paid_amount=refundCalculateResponse.getCancel_item_info()[0].getCc_paid_amount();
					cc_paid_amount = cc_paid_amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
					double paid_amount=cc_paid_amount.doubleValue();
					if(null!=cancelOrderDetailsModelObject)
					{
						cancelOrderDetailsModelObject.setRefAmt(cc_pmt_refund_amount);
						cancelOrderDetailsModelObject.setRefCurr(cc_pmt_refund_currency);
						cancelOrderDetailsModelObject.setPaidAmt(paid_amount);
						if(null!=refundCalculateResponse.getPayment())
						{
							cancelOrderDetailsModelObject.setPaymentStatus(true);
						}
					}
				}
				finalOrderDetailsList.add(cancelOrderDetailsModelObject);
		}catch(Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return finalOrderDetailsList;
	}
	
	

	@Override
	public Refund_calculate_response getRefundAmount(Long orderHdrId, int orderItemSeq) 
	{
		LOGGER.info("Inside getRefundAmount");
		Refund_calculate_response refundCalculateResponse = null;
		try 
		{
			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			soap = locator.getThinkSoap();

			Refund_calculate_request refundCalculateRequest = new Refund_calculate_request();
			refundCalculateRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
				User_login_data login=new User_login_data();
				login.setLogin(new PropertyUtilityClass().getQuery("login"));	
				login.setPassword( new PropertyUtilityClass().getQuery("password"));
			refundCalculateRequest.setUser_login_data(login);
				Cancel_data cancelData = new Cancel_data();
					ZZItemIdentifier ZZItemIdentifier = new ZZItemIdentifier();
					ZZItemIdentifier.setOrderhdr_id(orderHdrId.intValue());
					ZZItemIdentifier.setOrder_item_seq(orderItemSeq);
				cancelData.setItem_identifier(ZZItemIdentifier);
				cancelData.setCancel_reason("CNCNET");
			refundCalculateRequest.setCancel_data(cancelData);
			
			refundCalculateResponse = soap.refundCalculate(refundCalculateRequest);
		}catch(Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return refundCalculateResponse;
	}
	
	

	@Override
	public String cancelOrder(CancelOrderAttributeModel cancelOrderAttributeModel) 
	{
		LOGGER.info("Inside cancelOrder");
		try 
		{
			String refAmt[] = null;
			String odrHdrId[] = cancelOrderAttributeModel.getOrderHdrId().split(",");
			if(null!=cancelOrderAttributeModel.getRefundAmount())
			{
				if(!"".equals(cancelOrderAttributeModel.getRefundAmount())) 
				{
					refAmt = cancelOrderAttributeModel.getRefundAmount().split(",");
				}
			}
            //Modified for THINKDEV-1129 Resolution.
			for(int i=0;i<odrHdrId.length;i++) 
			{
				ThinkSoap soap = null;
				ThinkWSLocator locator = new ThinkWSLocator();
				soap = locator.getThinkSoap();
				Order_cancel_request orderCancelRequest = new Order_cancel_request();
				orderCancelRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
				orderCancelRequest.setSubmit(ZZBoolean.yes);
				orderCancelRequest.setDoc_ref_id(cancelOrderAttributeModel.getDocumentReferenceId());
				orderCancelRequest.setCheck_missing_fields(ZZBoolean.no);

				User_login_data login=new User_login_data();
				login.setLogin(new PropertyUtilityClass().getQuery("login"));	
				login.setPassword( new PropertyUtilityClass().getQuery("password"));
				orderCancelRequest.setUser_login_data(login);

				Customer_identifier customerIdentity=new Customer_identifier();
				customerIdentity.setCustomer_id(Integer.parseInt(cancelOrderAttributeModel.getCustomerId()));
				orderCancelRequest.setCustomer_identifier(customerIdentity);
				
				Cancel_data cancelData = new Cancel_data();
				if(cancelOrderAttributeModel.isPaymentStatus()==false)
				{
					cancelData.setNo_refund(ZZBoolean.yes);// 17-03-2020  charitha
				}	
				if("notry".equals(cancelOrderAttributeModel.getCancellationRenewalStatus())) 
				{
					cancelData.setRenewal_status_on_cancel(Renewal_status_on_cancel.value2);
				}else 
				{
					cancelData.setRenewal_status_on_cancel(Renewal_status_on_cancel.value1);
				}
				if("1".equals(cancelOrderAttributeModel.getApplySubscriptionChain())) 
				{
				  cancelData.setApply_renewal_status_on_cancel_to_ren_chain(ZZBoolean.yes);
				}
				ZZItemIdentifier ZZItemIdentifier = new ZZItemIdentifier();
				ZZItemIdentifier.setOrderhdr_id(Integer.parseInt(odrHdrId[i]));
				ZZItemIdentifier.setOrder_item_seq(cancelOrderAttributeModel.getOrderItemSeq());
				cancelData.setItem_identifier(ZZItemIdentifier);
				
				cancelData.setCancel_reason(cancelOrderAttributeModel.getReason());
				
				if(cancelOrderAttributeModel.isPaymentStatus())	
				{
					if(null!=refAmt[i] && !refAmt[i].isEmpty())
					{
						if(refAmt[i].trim().equals("0"))
						{
							cancelData.setNo_refund(ZZBoolean.yes);
						}else
						{
							if(!"".equals(cancelOrderAttributeModel.getRefundAmount())) 
							{
								cancelData.setAmount(new BigDecimal(refAmt[i]));
								if(null!=cancelOrderAttributeModel.getCurrency()&& !"".equals(cancelOrderAttributeModel.getCurrency()))
								{
									cancelData.setCurrency(cancelOrderAttributeModel.getCurrency());
								}
								Payment_refund_data paymentRefundData = new Payment_refund_data();
								if("1".equals(cancelOrderAttributeModel.getRefundDepositeAccount())) 
								{
									paymentRefundData.setRefund_to_deposit(ZZBoolean.yes);
								}
								else 
								{
									paymentRefundData.setRefund_to_deposit(ZZBoolean.no);
									if(!"".equals(cancelOrderAttributeModel.getPaymentType())) 
									{
										paymentRefundData.setPayment_type(cancelOrderAttributeModel.getPaymentType());
									}
								}
								paymentRefundData.setAmount(new BigDecimal(refAmt[i]));
								paymentRefundData.setCurrency(cancelOrderAttributeModel.getCurrency());
								if("1".equals(cancelOrderAttributeModel.getUsePaymentAccount())) 
								{
									Payment_account_identifier payment_account_identifier = new Payment_account_identifier();
									payment_account_identifier.setPayment_account_seq(cancelOrderAttributeModel.getPayAccount());
									paymentRefundData.setPayment_account_identifier(payment_account_identifier);
								}
								if(!"".equals(cancelOrderAttributeModel.getCreditCard())) 
								{
									paymentRefundData.setCard_number(cancelOrderAttributeModel.getCreditCard());
								}
								if(!"".equals(cancelOrderAttributeModel.getNameOnCard())) 
								{
									paymentRefundData.setCredit_card_info(cancelOrderAttributeModel.getNameOnCard());
								}
								//paymentRefundData.setTransaction_reason(cancelOrderAttributeModel.getTransaction_reason());// 17-03-2020 charitha
								orderCancelRequest.setPayment_refund_data(paymentRefundData);
							}
						}
					}
				}
				orderCancelRequest.setCancel_data(cancelData);
				soap.orderCancel(orderCancelRequest);			
			}
			return "cancelled";
		}catch (Exception e) 
		{
			LOGGER.error(ERROR);
			e.printStackTrace();
			return ERROR;
		}
	}
	

	@Override
	public boolean getPaymentAccountFlag(Long customerId) {
		
		LOGGER.info("Inside getPaymentAccountFlag");
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("customer_id", customerId);
				int count = namedParameterJdbcTemplate.queryForObject("select count(*) from payment_account where customer_id=:customer_id",parameters,Integer.class);
				
				if(count>0)
					return true;
				else
					return false;
				
			}catch (Exception e) {
				LOGGER.error(ERROR + e);
				return false;
			}	
	}

	
	
	@Override
	public List<DropdownModel> getPaymentAccountList(Long customerId) {
		LOGGER.info("Inside getPaymentAccountList");
		List<DropdownModel>  paymentAccountList = new ArrayList<>();
		try 
		{
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("customer_id", customerId);
			List<Map<String, Object>> rows =  namedParameterJdbcTemplate.queryForList(
					"select payment_account_seq,description,id_nbr_last_four from payment_account where customer_id=:customer_id",parameters);
			for (Map<String, Object> row : rows) 
			{
				DropdownModel model = new DropdownModel();
				model.setKey(row.get("payment_account_seq").toString());
				//Edited by Sohrab to handle NullPointerException
				String description="",id_nbr_last_four="";
				if(null!=row.get("description"))
				{
					description=row.get("description").toString();
				}else
				{
					description="null";
				}
				if(null!=row.get("id_nbr_last_four"))
				{
					id_nbr_last_four=row.get("id_nbr_last_four").toString();
				}else
				{
					id_nbr_last_four="null";
				}
				model.setDisplay(description+"-"+id_nbr_last_four);
				model.setDescription(description);
				paymentAccountList.add(model);
			}
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
		}
		return paymentAccountList;
	}
	
	

	@Override
	public String getCustomerName(Long customerId) {
		LOGGER.info("Inside getCustomerName");	
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("customer_id", customerId);
				String fullName = namedParameterJdbcTemplate
						.queryForObject("SELECT CONCAT(fname,' ' collate Latin1_General_CI_AS,lname) as fullName from customer where customer_id=:customer_id",parameters,String.class);
				return fullName;
				
			}catch (Exception e) {
				LOGGER.error(ERROR + e);
				return ERROR;
			}
		
	}

	@Override
	public String getSelectedOrder(Long orderHdrId, int orderItemSeq) {

		LOGGER.info("Inside getSelectedOrder");	
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("orderhdr_id", orderHdrId);
				parameters.put("order_item_seq", orderItemSeq);
				String orderCode = namedParameterJdbcTemplate
						.queryForObject("select description from order_code where order_code_id= (select order_code_id from order_item where orderhdr_id =:orderhdr_id  and order_item_seq=:order_item_seq)",parameters,String.class);
				return orderHdrId+": "+orderItemSeq+" "+orderCode;
				
			}catch (Exception e) {
				LOGGER.error(ERROR + e);
				return ERROR;
			}
	}

	@Override
	public String getPaymentType(Long orderHdrId, int orderItemSeq) {

		LOGGER.info("Inside getPaymentType");	
		try {
			String pType = null;
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("orderhdr_id", orderHdrId);
				parameters.put("order_item_seq", orderItemSeq);
//				List<String> paymentType = namedParameterJdbcTemplate
//						.queryForList("select DISTINCT p.payment_type from payment p inner join paybreak pb on p.customer_id=pb.customer_id and p.payment_seq=pb.payment_seq " + 
//								"where  orderhdr_id = "+orderHdrId+" and order_item_seq="+orderItemSeq+"",parameters,String.class);
				String dsn=new PropertyUtilityClass().getQuery("dsn");
				if( dsn.equals("web_countryside_test")) {
					pType = "_DA";
				}else if( dsn.equals("php_cs_web")) {
					pType = "CQ";
				}else if( dsn.equals("ucp_cs_web1")) {
					pType = "CK";
				}
				else if(dsn.equals("Noida-Live74")) {
					pType = "CA";
				}
				else if(dsn.equals("QADB-QA")) {
					pType = "CK";
				}
				else if(dsn.equals("QADB_74_TEST")) {
					pType = "CA";
				}
				
				
//				else {
//					for(String co: paymentType) {
//						pType = co;
//					}
//				}
				
				return pType;	
			}catch (Exception e) {
				LOGGER.error(ERROR + e);
				return ERROR;
			}
	}

	
	
	@Override
	public String retrievePaymentTypeToCancelOrderFromDataSource() 
	{
		LOGGER.info("Inside retrievePaymentTypeToCancelOrderFromDataSource");
		String paymentTypeToCancelOrder = null;
		try 
		{
			String payment_type_compound_xactionQuery = "SELECT payment_type_compound_xaction FROM config;";	
			paymentTypeToCancelOrder=jdbcTemplate.queryForObject(payment_type_compound_xactionQuery,String.class);
			if(paymentTypeToCancelOrder==null || "".equals(paymentTypeToCancelOrder))
			{
				paymentTypeToCancelOrder="CQ";
			}
		}catch (Exception e) 
		{
				LOGGER.error(ERROR + e);
				e.printStackTrace();
				paymentTypeToCancelOrder=ERROR;
		}
		return paymentTypeToCancelOrder;
	}
	
	
	
	@Override
	public int getNoOfSubscripIdInOrder(int subscripId) {

		LOGGER.info("Inside getNoOfSubscripIdInOrder");	
		try {
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("subscrip_id", subscripId);
				int query = namedParameterJdbcTemplate
						.queryForObject("SELECT DISTINCT COUNT(*) FROM order_item oi INNER JOIN order_code oc ON oi.order_code_id=oc.order_code_id WHERE subscrip_id is not null and subscrip_id ="+subscripId+ "",parameters, Integer.class);

				return query;	
			}catch (Exception e) {
				LOGGER.error(ERROR + e);
				return 0;
			}
	}

	@Override
	public List<CancelOrderDetailsModel> getEntireSubOrderDetail(int subscripId) {
		LOGGER.info("Inside getEntireSubOrderDetail");	
		
		List<CancelOrderDetailsModel> rows = new ArrayList<>();
		List<CancelOrderDetailsModel> rowsList = new ArrayList<>();
		try {
			
			StringBuilder query = new StringBuilder("SELECT DISTINCT oc.order_code,oi.*  FROM order_item oi INNER JOIN order_code oc ON oi.order_code_id=oc.order_code_id WHERE subscrip_id is not null and subscrip_id ="+subscripId+ "");
			  
			rows = jdbcTemplate.query(query.toString(),new CancelOrderDetailsMapper());

			 double payAmt=0.00;
			for(CancelOrderDetailsModel co : rows) {
				
			Long ordHdrId = (long) co.getOrderHdrId();
			int ordSeq = co.getOrderItemSeq();
			
			Refund_calculate_response refundCalculateResponse = getRefundAmount(ordHdrId,ordSeq);
			List<Map<String, Object>> queryData = jdbcTemplate.queryForList("select DISTINCT p.payment_type,p.pay_currency_amount from payment p inner join paybreak pb on p.customer_id=pb.customer_id and p.payment_seq=pb.payment_seq " + 
				    		"where  orderhdr_id = "+ordHdrId+" and order_item_seq="+ordSeq+"");
				
				  
				for(int j=0;j<queryData.size();j++) {
					payAmt = payAmt + Double.valueOf(queryData.get(j).get("pay_currency_amount").toString()) ;
				}
										
				co.setRefAmt(refundCalculateResponse.getCancel_item_info()[0].getCc_pmt_refund_amount());
				co.setRefCurr(refundCalculateResponse.getCancel_item_info()[0].getCc_pmt_refund_currency());
				
				 if(queryData.size() != 0) {
					co.setPaidAmt(payAmt);
				}else {
					co.setPaidAmt(0.00);
				   }
				 
					rowsList.add(co);	 
				}				
			
			}catch (Exception e) {
				LOGGER.error(ERROR + e);
			}
		return rowsList;
		
	}
	
	
	@Override
	 public String getBalanceDueFromDataSource(int customer_id)
	 {
		 	LOGGER.info("inside getBalanceDueFromDataSource");
		 	String balanceDue=null;
			try 
			{
				String balanceDueQuery = "select sum(gross_local_amount) FROM order_item WHERE customer_id=? and payment_status IN (0,5) AND order_status IN (0,5,6,7,8,9,10,11,12,13,15,16);";	
				balanceDue=jdbcTemplate.queryForObject(balanceDueQuery,new Object[]{customer_id}, String.class);
			} catch (Exception e) 
			{
				LOGGER.info("balanceDue" + e);
				e.printStackTrace();
			}
			return balanceDue;
	 }
	 
	 
	 @Override
	 public String getDepositAmountFromDataSource(int cancelled_order_id)
	 {
		 	LOGGER.info("inside getDepositAmountFromDataSource");
		 	String deposit_amount=null;
			try 
			{
				String deposit_amount_query = "select orig_base_amount from order_item_amt_break WHERE orderhdr_id=?";	
				deposit_amount=jdbcTemplate.queryForObject(deposit_amount_query, new Object[]{cancelled_order_id},String.class);
			} catch (Exception e) 
			{
				LOGGER.info("deposit_amount" + e);
				e.printStackTrace();
			}
			return deposit_amount;
	 }
	 
	 
	 @Override
	 public List<ExistingUnpaidOrdersModel> getListOfExistingUnpaidOrdersFromDataSource(int customer_id,CancelOrderAttributeModel cancelOrderAttributeModel)
	 {
		 LOGGER.info("inside getListOfExistingUnpaidOrdersFromDataSource");
		 List<ExistingUnpaidOrdersModel> existingUnpaidOrdersModelList=null;
			try 
			{
				String existingUnpaidOrdersQuery = "SELECT "+cancelOrderAttributeModel.getDocumentReferenceId()+","+cancelOrderAttributeModel.getRefundAmount()+",oit.note_exist,oit.service_exist,oit.orderhdr_id,"
						+ "oit.order_item_seq,oit.order_date,o.oc,oder.order_code,"+
				"oit.order_qty,oit.n_issues_left,oit.gross_local_amount,oit.order_status,"+
				"oit.payment_status,oit.agency_customer_id,oit.bundle_qty,oit.customer_address_seq,"+
				"oit.customer_id,oit.subscrip_id,oit.gross_base_amount,oit.net_base_amount,oit.net_local_amount,"+
				"oit.renewal_orderhdr_id,oit.package_instance,oit.ship_qty,oit.backord_qty,oit.currency"+ 
				" FROM order_item oit INNER JOIN oc o ON o.oc_id=oit.oc_id"+ 
				" INNER JOIN order_code oder ON oder.order_code_id=oit.order_code_id"+ 
				" WHERE oit.customer_id="+customer_id+" and oit.payment_status IN (0,5) AND oit.order_status IN (0,5,6,7,8,9,10,11,12,13,15,16) AND oit.gross_base_amount<>0 AND oit.pkg_item_seq is null;";	
				
				existingUnpaidOrdersModelList=jdbcTemplate.query(existingUnpaidOrdersQuery, new ExistingUnpaidOrdersMapper());
			} catch (Exception e) 
			{
				LOGGER.info("existingUnpaidOrdersModelList" + e);
				e.printStackTrace();
				existingUnpaidOrdersModelList=null;
			}
			return existingUnpaidOrdersModelList;
	 }
	 
	 
	 @Override
		public String returnProductDAO(CancelOrderAttributeModel cancelOrderAttributeModel) 
		{
			LOGGER.info("Inside returnProductDAO");
			try
			{
				ThinkSoap soap = null;
				ThinkWSLocator locator = new ThinkWSLocator();
				soap = locator.getThinkSoap();
				
				Product_return_request product_return_request_obj = new Product_return_request();
				product_return_request_obj.setDsn(new PropertyUtilityClass().getQuery("dsn"));
				product_return_request_obj.setDoc_ref_id(cancelOrderAttributeModel.getDocumentReferenceId());
				
				User_login_data login=new User_login_data();
				login.setLogin(new PropertyUtilityClass().getQuery("login"));	
				login.setPassword( new PropertyUtilityClass().getQuery("password"));
				product_return_request_obj.setUser_login_data(login);
				
				ZZItemIdentifier zzItemIdentifierObj = new ZZItemIdentifier();
				zzItemIdentifierObj.setOrderhdr_id(Integer.parseInt(cancelOrderAttributeModel.getOrderHdrId()));
				zzItemIdentifierObj.setOrder_item_seq(cancelOrderAttributeModel.getOrderItemSeq());
				product_return_request_obj.setItem_identifier(zzItemIdentifierObj);
				
				Return_data return_data_obj = new Return_data();
				if(cancelOrderAttributeModel.getType_of_return()==0)
				{
					return_data_obj.setReturn_inventory(ZZBoolean.no);
				}else if(cancelOrderAttributeModel.getType_of_return()==2 || cancelOrderAttributeModel.getType_of_return()==3)
				{
					return_data_obj.setReturn_inventory(ZZBoolean.yes);
				}
				return_data_obj.setReturn_qty(cancelOrderAttributeModel.getReturnQty());
				product_return_request_obj.setReturn_data(return_data_obj);
				
				soap.productReturn(product_return_request_obj);

				return "success";	
			}catch (Exception e) 
			{
				LOGGER.error(ERROR);
				e.printStackTrace();
				return ERROR;
			}
		}

	
	@Override
	public List<RenewableItemsModel> getListOfRenewableItemsFromDataSource(CancelOrderAttributeModel cancelOrderAttributeModel) 
	{
		 LOGGER.info("inside getListOfRenewableItemsFromDataSource");
		 List<RenewableItemsModel> renewableItemsModelList=null;
			try 
			{
				int customer_Id=0;
				if(cancelOrderAttributeModel.getCustomerId()!=null && cancelOrderAttributeModel.getCustomerId()!="")
				{
					customer_Id=Integer.parseInt(cancelOrderAttributeModel.getCustomerId());
				}
				String renewableItemsQuery = "SELECT oit.note_exist,oit.service_exist,oit.orderhdr_id,oit.order_item_seq,"+
				"oit.order_date,o.oc,oder.order_code,oit.order_qty,oit.n_issues_left,oit.gross_local_amount,oit.order_status,"+
				"oit.payment_status,oit.agency_customer_id,oit.bundle_qty,oit.customer_address_seq,oit.customer_id,"+
				"oit.subscrip_id,oit.gross_base_amount,oit.net_base_amount,oit.net_local_amount,oit.renewal_orderhdr_id,"+
				"oit.package_instance,oit.ship_qty,oit.backord_qty,oit.order_code_id,oit.order_item_type"+
				" FROM order_item oit INNER JOIN oc o ON o.oc_id=oit.oc_id"+ 
				" INNER JOIN order_code oder ON oder.order_code_id=oit.order_code_id"+ 
				" WHERE oit.customer_id="+customer_Id+" AND oit.order_status IN (0,5,6,7,8,9,10,11,12,13,15,16)"+
				" AND oder.order_code_type IN (0,4,5,6,7) AND oit.subscrip_start_type<>2 and oit.pkg_item_seq is null order by oit.orderhdr_id,oit.order_item_seq;";	
				
				renewableItemsModelList=jdbcTemplate.query(renewableItemsQuery, new RenewableItemsMapper());
			} catch (Exception e) 
			{
				LOGGER.info("renewableItemsModelList" + e);
				e.printStackTrace();
				renewableItemsModelList=null;
			}
			return renewableItemsModelList;
	}
}