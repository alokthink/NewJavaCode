package com.mps.think.wsdl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.mps.think.model.PaymentModel;
import com.mps.think.util.PropertyUtilityClass;
import Think.XmlWebServices.Customer_identifier;
import Think.XmlWebServices.Deposit_refund_request;
import Think.XmlWebServices.Deposit_use_request;
import Think.XmlWebServices.Deposit_use_response;
import Think.XmlWebServices.Item_payment;
import Think.XmlWebServices.Order_payment_select_request;
import Think.XmlWebServices.Order_payment_select_response;
import Think.XmlWebServices.Order_payment_select_responsePayment_on_order;
import Think.XmlWebServices.Payment_account_info_select_request;
import Think.XmlWebServices.Payment_account_info_select_response;
import Think.XmlWebServices.Payment_account_info_select_responsePayment_account;
import Think.XmlWebServices.Payment_add_data;
import Think.XmlWebServices.Payment_add_request;
import Think.XmlWebServices.Payment_add_response;
import Think.XmlWebServices.Payment_cancel_request;
import Think.XmlWebServices.Payment_cancel_response;
import Think.XmlWebServices.Payment_edit_data;
import Think.XmlWebServices.Payment_edit_request;
import Think.XmlWebServices.Payment_edit_response;
import Think.XmlWebServices.Payment_identifier;
import Think.XmlWebServices.Payment_list_select_request;
import Think.XmlWebServices.Payment_list_select_response;
import Think.XmlWebServices.Payment_list_select_responsePayment;
import Think.XmlWebServices.Payment_refund_data;
import Think.XmlWebServices.Payment_transfer_request;
import Think.XmlWebServices.Payment_transfer_response;
import Think.XmlWebServices.ThinkSoap;
import Think.XmlWebServices.ThinkWSLocator;
import Think.XmlWebServices.ThresholdOption;
import Think.XmlWebServices.Threshold_data;
import Think.XmlWebServices.Threshold_option_enum;
import Think.XmlWebServices.Threshold_option_list_request;
import Think.XmlWebServices.User_login_data;
import Think.XmlWebServices.ZZBoolean;
import Think.XmlWebServices.ZZCreditCard;
import Think.XmlWebServices.ZZItemIdentifier;
import Think.XmlWebServices.ZZPXIdentifier;



@Repository
public class PaymentWsdl
{
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentWsdl.class);
	private static final String ERROR = "Error"; 
	
	 /**Method Updated By Sohrab For null & empty check for dates. Used e.printStackTrace();*/
	public boolean wsdlCall(PaymentModel paymentModel,
			List<Order_payment_select_responsePayment_on_order> fetchOrderDetails) throws ServiceException {
		try {
			System.out.println("Inside Payment Add Method");
			int arraySize = fetchOrderDetails.size();
			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			Payment_add_request paymentAddRequest = new Payment_add_request();
			Payment_add_response paymentAddResponse;
			soap = locator.getThinkSoap();

			User_login_data login = new User_login_data();
			login.setLogin(new PropertyUtilityClass().getQuery("login"));
			login.setPassword(new PropertyUtilityClass().getQuery("password"));

			Customer_identifier customerIdentity = new Customer_identifier();
			customerIdentity.setCustomer_id(paymentModel.getPayerCustomer());
			
		

			Payment_add_data paymentAddData = new Payment_add_data();
			paymentAddData.setAmount(new BigDecimal(String.valueOf(paymentModel.getPayAmount())));
		

			paymentAddData.setAuth_code(paymentModel.getAuth_code() != null ? paymentModel.getAuth_code() : "");
			if (null != paymentModel.getAuth_date()) {
				if (!"".equals(paymentModel.getAuth_date().trim())) {
					paymentAddData.setAuth_date(
							new PropertyUtilityClass().dateFormatter(paymentModel.getAuth_date().trim()) != null
									? (new PropertyUtilityClass().dateFormatter(paymentModel.getAuth_date().trim()))
									: null);
				}
			}
		//	paymentAddData.setCard_number(paymentModel.getCardNumber() != null ? paymentModel.getCardNumber() : "");
			if(paymentModel.getCardNumber()!="" && paymentModel.getCardNumber() !=null )//Suresh 7March2020
			{
			paymentAddData.setCard_number(paymentModel.getCardNumber() != null ? paymentModel.getCardNumber() : null);
			}
			if(paymentModel.getCardNumber()!=null && paymentModel.getCardNumber()!="")
			{
				paymentAddData.setCard_verification_value(String.valueOf(paymentModel.getCard_verification_value()));
				paymentAddData.setCredit_card_issue_id(String.valueOf(paymentModel.getCredit_card_issue_id()) != null
						? paymentModel.getCredit_card_issue_id()
						: "");
				
			}
			if ((paymentModel.getCreditCardAuthorization() != null)
					&& (paymentModel.getCreditCardAuthorization() == 1)) {
				paymentAddData.setCredit_card_authorization(ZZBoolean.yes);
				
			} else {
				paymentAddData.setCredit_card_authorization(ZZBoolean.no);
			}
			paymentAddData.setBase_amount(new BigDecimal(String.valueOf(paymentModel.getBase_amount())));
			if(paymentModel.getCheck_number()!=null && paymentModel.getCheck_number()!="")
			{
			paymentAddData
					.setCheck_number(paymentModel.getCheck_number() != null ? paymentModel.getCheck_number() : null);
			}
			if (null != paymentModel.getClear_date()) {
				if (!"".equals(paymentModel.getClear_date().trim())) {
					paymentAddData.setClear_date(
							new PropertyUtilityClass().dateFormatter(paymentModel.getClear_date().trim()) != null
									? (new PropertyUtilityClass().dateFormatter(paymentModel.getClear_date().trim()))
									: null);
				}
			}
		
			paymentAddData.setCurrency(paymentModel.getCurrency() != null ? paymentModel.getCurrency() : "");
			paymentAddData.setEffort_nbr(paymentModel.getEffort_nbr() != null ? (paymentModel.getEffort_nbr()) : 0);
			//paymentAddData.setRef_nbr(paymentModel.getRef_nbr() != null ? paymentModel.getRef_nbr() : "");//suresh 04March2020
			paymentAddData.setRef_nbr(paymentModel.getRef_nbr() != null ? paymentModel.getRef_nbr() : null);
			//paymentAddData.setId_nbr(paymentModel.getId_nbr() != null ? paymentModel.getRef_nbr() : "");
			paymentAddData.setId_nbr(paymentModel.getId_nbr() != null ? paymentModel.getRef_nbr() : null);//suresh 04March2020
			if (Integer.valueOf(paymentModel.getRefund_deposit_pay_amt()) == 1) {
				paymentAddData.setRefund_to_deposit(ZZBoolean.yes);
			} else {
				paymentAddData.setRefund_to_deposit(ZZBoolean.no);
			}
			ZZPXIdentifier zZPXIdentifier = new ZZPXIdentifier();
			zZPXIdentifier.setPending_xaction_header_id(2);
			
						
			if(paymentModel.getOrderIdOrderseq() !=null) {
         
			 String  orderPairID[] = paymentModel.getOrderIdOrderseq().toString().split(",");
			 
			 if (arraySize == 0 || paymentModel.getOrderId() != 0) {
				arraySize = orderPairID.length;
			}
			 
			Item_payment itemPayment[] = new Item_payment[arraySize];
			paymentAddRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
			int i = 0;
			if (arraySize >= 1) {
				for (int j = 0; j < orderPairID.length; j++) {
					String OrderIdOrderseq[] = orderPairID[j].split("-");
					String orderId = OrderIdOrderseq[0];
					String orderItemSeq = OrderIdOrderseq[1];
					ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
					Item_payment itemPayments = new Item_payment();
					itemIdentifier.setOrderhdr_id(Integer.parseInt(orderId));
					System.out.println("orderhdr_id is"+orderId);
					itemIdentifier.setOrder_item_seq(Integer.parseInt(orderItemSeq));
					System.out.println("orderItemSeq is"+orderItemSeq);
				    // itemPayments.setThreshold_option(Threshold_option_enum.fromString("partial"));
					
					if(paymentModel.getThreshold_option()!=null && paymentModel.getThreshold_option() !="")
					{
				    itemPayments.setThreshold_option(Threshold_option_enum.fromString(paymentModel.getThreshold_option()));
					}
					
					
					itemPayments.setItem_identifier(itemIdentifier);
					itemPayment[i] = itemPayments;
					i++;
				}
			} else {
				for (Order_payment_select_responsePayment_on_order item : fetchOrderDetails) {
					ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
					Item_payment itemPayments = new Item_payment();
					itemIdentifier.setOrderhdr_id(item.getOrderhdr_id());
					itemIdentifier.setOrder_item_seq(item.getOrder_item_seq());
					itemPayments.setItem_identifier(itemIdentifier);
					itemPayment[i] = itemPayments;
					i++;
				}
			}
			

			if (itemPayment[0] != null) {
				paymentAddRequest.setItem_payment(itemPayment);
			}
			
			//if payment_account_seq !=0  then card_number=null, ref_nbr=null,id_nbr=null,credit_card_info=null, credit_card_bill_address_seq=null,
			if (paymentModel.getPayment_account_seq() != 0) {
				paymentAddData.setPayment_account_seq(paymentModel.getPayment_account_seq());
			} else {
				paymentAddData.setPayment_type(paymentModel.getPayment_type());
				if (null != paymentModel.getCreditCardStartDate()) {
					if (!"".equals(paymentModel.getCreditCardStartDate().trim())) {
						paymentAddData.setCredit_card_start_date(new PropertyUtilityClass()
								.dateFormatter(paymentModel.getCreditCardStartDate().trim()) != null
										? (new PropertyUtilityClass()
												.dateFormatter(paymentModel.getCreditCardStartDate().trim()))
										: null);
					}
				}
				
				if (null != paymentModel.getExp_date()) {
					if (!"".equals(paymentModel.getExp_date().trim())) {
						paymentAddData.setExp_date(
								new PropertyUtilityClass().dateFormatter(paymentModel.getExp_date().trim()));
					}
				}
				if(paymentModel.getCredit_card_info()!="" && paymentModel.getCredit_card_info()!=null)
				{
					
				paymentAddData.setCard_number(paymentModel.getCredit_card_info());
				paymentAddData.setCredit_card_info(paymentModel.getFullName());
				}
				
			 }
				Integer Pay_clear_status = Integer.parseInt(paymentModel.getPayment_clear_status());
				paymentAddData.setPayment_clear_status(Pay_clear_status);
				//paymentAddData.setCredit_card_info(
					//	paymentModel.getCredit_card_info() != null ? (paymentModel.getCredit_card_info()) : "");
				
				
				/*paymentAddData.setCredit_card_info(
						paymentModel.getCredit_card_info() != null ? (paymentModel.getCredit_card_info()) :null);*/
				
				
				//paymentAddData.setCredit_card_bill_address_seq(
				//		String.valueOf(paymentModel.getCredit_card_bill_address_seq()) != null? paymentModel.getCredit_card_bill_address_seq()
				//		: 0);
				
				paymentAddData.setCredit_card_bill_address_seq(
								String.valueOf(paymentModel.getCredit_card_bill_address_seq()) != null? paymentModel.getCredit_card_bill_address_seq()
								: null);
				
				//suresh-4March2020
				if(paymentModel.getCredit_card_bill_address_seq()==0)
				{
					paymentAddData.setCredit_card_bill_address_seq(null);
				}
				
				paymentAddRequest.setUser_login_data(login);
				paymentAddRequest.setCustomer_identifier(customerIdentity);
				paymentAddRequest.setPayment_add_data(paymentAddData);
				paymentAddRequest.setDoc_ref_id(paymentModel.getDoc_ref_id());
				paymentAddRequest.setCheck_missing_fields(ZZBoolean.no);
				
				paymentAddResponse = soap.paymentAdd(paymentAddRequest);
				paymentAddResponse.getPayment();
			}
			
		} catch (AxisFault e) {
			String fault = e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
			LOGGER.info("PaymentAddWsdl = " + fault);
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			return false;
		}
		return true;
	}
	 
	
	public boolean editWsdlCall(PaymentModel paymentModel,List<Order_payment_select_responsePayment_on_order> 
	fetchOrderDetails) throws ServiceException {
		try {
			
			System.out.println("Inside Edit Payment Update Method");
			int arraySize = fetchOrderDetails.size();
			ThinkSoap soap = null;
			ThinkWSLocator locator = new ThinkWSLocator();
			Payment_edit_request paymentEditRequest = new Payment_edit_request();
			Payment_edit_response paymentEditResponse;
			soap = locator.getThinkSoap();

			User_login_data login = new User_login_data();
			login.setLogin(new PropertyUtilityClass().getQuery("login"));
			login.setPassword(new PropertyUtilityClass().getQuery("password"));
		

			Payment_edit_data paymentEditData = new Payment_edit_data();
			paymentEditData.setAmount(new BigDecimal(String.valueOf(paymentModel.getPayAmount())));
			paymentEditData.setBase_amount(new BigDecimal(String.valueOf(paymentModel.getBase_amount())));
			paymentEditData.setAuth_code(paymentModel.getAuth_code() != null ? paymentModel.getAuth_code() : "");
			Integer Pay_clear_status = Integer.parseInt(paymentModel.getPayment_clear_status());
			paymentEditData.setPayment_clear_status(Pay_clear_status);
			if (null != paymentModel.getAuth_date()) {
				if (!"".equals(paymentModel.getAuth_date().trim())) {
					paymentEditData.setAuth_date(new PropertyUtilityClass().dateFormatter(paymentModel.getAuth_date().trim()) != null
							? (new PropertyUtilityClass().dateFormatter(paymentModel.getAuth_date().trim()))
							: null);
				}
			}
			
			if (paymentModel.getCardNumber() != "" && paymentModel.getCardNumber() != null	&& paymentModel.getPayment_account_seq() == 0)// Malini 13/3/2020
			{
				if (paymentModel.getCardNumber() != null && paymentModel.getCardNumber() != "") {
					paymentEditData
							.setCard_verification_value(String.valueOf(paymentModel.getCard_verification_value()));
					paymentEditData
							.setCredit_card_issue_id(String.valueOf(paymentModel.getCredit_card_issue_id()) != null
									? paymentModel.getCredit_card_issue_id()
									: "");

				}
				if (paymentModel.getCredit_card_info() != "" && paymentModel.getCredit_card_info() != null) {

					paymentEditData.setCard_number(paymentModel.getCredit_card_info());
					paymentEditData.setCredit_card_info(paymentModel.getFullName());
				}
				if ((paymentModel.getCreditCardAuthorization() != null)
						&& (paymentModel.getCreditCardAuthorization() == 1)) {
					paymentEditData.setCredit_card_authorization(ZZBoolean.yes);

				} else {
					paymentEditData.setCredit_card_authorization(ZZBoolean.no);
				}
			}
		
			/*if(paymentModel.getCardNumber()!=null && paymentModel.getPayment_account_seq()==0)
			{
				paymentEditData.setCard_verification_value(String.valueOf(paymentModel.getCard_verification_value()));
				paymentEditData.setCredit_card_issue_id(String.valueOf(paymentModel.getCredit_card_issue_id()) != null
						? paymentModel.getCredit_card_issue_id()
						: "");
				paymentEditData.setCard_number(paymentModel.getCredit_card_info());
				paymentEditData.setCredit_card_info(paymentModel.getFullName());
				
				if ((paymentModel.getCreditCardAuthorization() != null)
						&& (paymentModel.getCreditCardAuthorization() == 1)) {
					paymentEditData.setCredit_card_authorization(ZZBoolean.yes);
				} else {
					paymentEditData.setCredit_card_authorization(ZZBoolean.no);
				}
			}*/
			
			if(paymentModel.getCheck_number()!=null && paymentModel.getCheck_number()!="")
			{
				paymentEditData
					.setCheck_number(paymentModel.getCheck_number() != null ? paymentModel.getCheck_number() : null);
			}
			paymentEditData.setBase_amount(new BigDecimal(String.valueOf(paymentModel.getBase_amount())));
			paymentEditData.setCheck_number(paymentModel.getCheck_number() != null ? paymentModel.getCheck_number() : "");
			if (null != paymentModel.getClear_date()) {
				if (!"".equals(paymentModel.getClear_date().trim())) {
					paymentEditData.setClear_date(
							new PropertyUtilityClass().dateFormatter(paymentModel.getClear_date().trim()) != null
									? (new PropertyUtilityClass().dateFormatter(paymentModel.getClear_date().trim()))
									: null);
				}
			}
		
			paymentEditData.setCurrency(paymentModel.getCurrency() != null ? paymentModel.getCurrency() : "");
			paymentEditData.setEffort_nbr(paymentModel.getEffort_nbr() != null ? (paymentModel.getEffort_nbr()) : 0);
			paymentEditData.setRef_nbr(paymentModel.getRef_nbr() != null ? paymentModel.getRef_nbr() : null);
			paymentEditData.setId_nbr(paymentModel.getId_nbr() != null ? paymentModel.getRef_nbr() : null);//added by malini
			if (Integer.valueOf(paymentModel.getRefund_deposit_pay_amt()) == 1) {
				paymentEditData.setRefund_to_deposit(ZZBoolean.yes);
			} else {
				paymentEditData.setRefund_to_deposit(ZZBoolean.no);
			}
			ZZPXIdentifier zZPXIdentifier = new ZZPXIdentifier();
			zZPXIdentifier.setPending_xaction_header_id(2);
			
						
			if(paymentModel.getOrderIdOrderseq() !=null) {
		         
				 String  orderPairID[] = paymentModel.getOrderIdOrderseq().toString().split(",");
				 
				 if (arraySize == 0 || paymentModel.getOrderId() != 0) {
					arraySize = orderPairID.length;
				}
				 
				Item_payment itemPayment[] = new Item_payment[arraySize];
				paymentEditRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
				int i = 0;
				if (arraySize >= 1) {
					for (int j = 0; j < orderPairID.length; j++) {
						String OrderIdOrderseq[] = orderPairID[j].split("-");
						String orderId = OrderIdOrderseq[0];
						String orderItemSeq = OrderIdOrderseq[1];
						ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
						Item_payment itemPayments = new Item_payment();
						itemIdentifier.setOrderhdr_id(Integer.parseInt(orderId));
						itemIdentifier.setOrder_item_seq(Integer.parseInt(orderItemSeq));
						if(paymentModel.getThreshold_option()!=null && paymentModel.getThreshold_option() !="")//Malini 13/3/2020
						{
					    itemPayments.setThreshold_option(Threshold_option_enum.fromString(paymentModel.getThreshold_option()));
						}
						//itemPayments.setThreshold_option(Threshold_option_enum.refund);
						
						itemPayments.setItem_identifier(itemIdentifier);
						itemPayment[i] = itemPayments;
						i++;
					}
				} else {
					for (Order_payment_select_responsePayment_on_order item : fetchOrderDetails) {
						ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
						Item_payment itemPayments = new Item_payment();
						itemIdentifier.setOrderhdr_id(item.getOrderhdr_id());
						itemIdentifier.setOrder_item_seq(item.getOrder_item_seq());
						itemPayments.setItem_identifier(itemIdentifier);
						itemPayment[i] = itemPayments;
						i++;
					}
				}
				

				if (itemPayment[0] != null) {
					paymentEditRequest.setItem_payment(itemPayment);
				}
		}	
			
			paymentEditData.setCredit_card_bill_address_seq(
							String.valueOf(paymentModel.getCredit_card_bill_address_seq()) != null? paymentModel.getCredit_card_bill_address_seq()
							: null);
			
			if(paymentModel.getCredit_card_bill_address_seq()==0)
			{
				paymentEditData.setCredit_card_bill_address_seq(null);
			}
			
			if (paymentModel.getPayment_account_seq() != 0) {
				paymentEditData.setPayment_account_seq(paymentModel.getPayment_account_seq());
			} else {
				paymentEditData.setPayment_type(paymentModel.getPayment_type());
				if (null != paymentModel.getCreditCardStartDate()) {
					if (!"".equals(paymentModel.getCreditCardStartDate().trim())) {
						paymentEditData.setCredit_card_start_date(new PropertyUtilityClass()
								.dateFormatter(paymentModel.getCreditCardStartDate().trim()) != null
										? (new PropertyUtilityClass()
												.dateFormatter(paymentModel.getCreditCardStartDate().trim()))
										: null);
					}
				}
				if (null != paymentModel.getExp_date()) {
					if (!"".equals(paymentModel.getExp_date().trim())) {
						paymentEditData.setExp_date(
								new PropertyUtilityClass().dateFormatter(paymentModel.getExp_date().trim()));
					}
				}
				
				Payment_identifier PaymentIdentity = new Payment_identifier();
				
				Customer_identifier CustomerIdentity = new Customer_identifier();
				CustomerIdentity.setCustomer_id(paymentModel.getCustomer_id());
				
				PaymentIdentity.setCustomer_identifier(CustomerIdentity);
				PaymentIdentity.setPayment_seq(paymentModel.getPayment_seq());
				
				paymentEditData.setPayment_identifier(PaymentIdentity);
				
				paymentEditRequest.setUser_login_data(login);
				paymentEditRequest.setPayment_edit_data(paymentEditData);
				paymentEditRequest.setDoc_ref_id(paymentModel.getDoc_ref_id());
				paymentEditRequest.setCheck_missing_fields(ZZBoolean.no);
				paymentEditRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
				paymentEditResponse = soap.paymentEdit(paymentEditRequest);
				paymentEditResponse.getPayment();
				
			 }
		}catch (AxisFault e) {
			String fault = e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
			LOGGER.info("PaymentEditWsdl = " + fault);
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			return false;
		}
		return true;
		}
	
	
	
	 
	public List<Order_payment_select_responsePayment_on_order> fetchAmount(int customerId) throws ServiceException {

		ThinkSoap soap = null;
		ThinkWSLocator locator = new ThinkWSLocator();
		Order_payment_select_responsePayment_on_order[] fetchPayAmount = null;
		Order_payment_select_request orderPaymentSelectRequset = new Order_payment_select_request();
		Order_payment_select_response orderPaymentSelectResponse = new Order_payment_select_response();
		List<Order_payment_select_responsePayment_on_order> list = new ArrayList<>();
		soap = locator.getThinkSoap();
		User_login_data login = new User_login_data();
		Customer_identifier customerIdentity = new Customer_identifier();
		login.setLogin(new PropertyUtilityClass().getQuery("login"));
		login.setPassword(new PropertyUtilityClass().getQuery("password"));
		customerIdentity.setCustomer_id(customerId);
		orderPaymentSelectRequset.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		orderPaymentSelectRequset.setUser_login_data(login);
		orderPaymentSelectRequset.setCustomer_identifier(customerIdentity);
		try {
			orderPaymentSelectResponse = soap.orderPaymentSelect(orderPaymentSelectRequset);
			fetchPayAmount = (orderPaymentSelectResponse.getPayment_on_order());
			if (fetchPayAmount != null) {
				list = Arrays.asList(fetchPayAmount);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
		return list;

	}
	public List<Payment_list_select_responsePayment> fetchPaymentList(String customerId) throws ServiceException{
		LOGGER.info("Inside  payment list method");
		  ThinkSoap soap = null;
		  int customerID = Integer.parseInt(customerId);
		  ThinkWSLocator locator = new ThinkWSLocator();
		  Payment_list_select_responsePayment[] search = null;
		  List<Payment_list_select_responsePayment> list = new ArrayList<>();
		  Payment_list_select_request  paymentListSelectRequset = new Payment_list_select_request();
		  Payment_list_select_response paymentListSelectResponse = new Payment_list_select_response();
		  soap = locator.getThinkSoap();
		  User_login_data login=new User_login_data();
		  Customer_identifier customerIdentity = new Customer_identifier();
		  login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		  login.setPassword( new PropertyUtilityClass().getQuery("password"));
		  customerIdentity.setCustomer_id(customerID);
		  paymentListSelectRequset.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		  paymentListSelectRequset.setUser_login_data(login);
		  paymentListSelectRequset.setCustomer_identifier(customerIdentity);
		  try {
			  paymentListSelectResponse = soap.paymentListSelect(paymentListSelectRequset);
		      search=(paymentListSelectResponse.getPayment());
		      if(search != null)
		      {
			      list = Arrays.asList(search);
		        }      
		  } catch (Exception e) {
		  
			  LOGGER.error(ERROR + e);
		  }
		 return list;
		
	}
	/*public void orderAddPaymentAdd(int customerId,float payCurrencyAmount,String paymentType) throws ServiceException{
		try{
			LOGGER.info("Inside order add payment add method");
          ThinkSoap soap = null;
		  ThinkWSLocator locator = new ThinkWSLocator();
		  Orderhdr orderHeaderID = null;
		  Payment paymentAmount = null;
		  Order_add_payment_add_request  orderAddPaymentAddRequest = new Order_add_payment_add_request();
		  Order_add_payment_add_response orderAddPaymentAddResponse = new Order_add_payment_add_response();
		  soap = locator.getThinkSoap();
		  User_login_data login=new User_login_data();
		  Customer_identifier customerIdentity = new Customer_identifier();
		  Customer_address_identifier customerAddressIdentifier = new  Customer_address_identifier();
		  Order_data orderData = new Order_data();
		  Item_data itemData[] = new Item_data[1];
		  Item_data itemData1= new Item_data();
		  Payment_add_data paymentAddData = new Payment_add_data();
		  itemData[0]=itemData1;
		  itemData1.setOrder_code_id(117);
		  itemData1.setSource_code_id(573);
		  itemData1.setSubscription_def_id(358);
		  login.setLogin("pradaxinas");
		  login.setPassword("qwer1234$");
		  customerIdentity.setCustomer_id(customerId);
		  customerAddressIdentifier.setCustomer_address_seq(1);
		  customerAddressIdentifier.setCustomer_identifier(customerIdentity);
		  orderData.setItem_data(itemData);
		  paymentAddData.setAmount(new BigDecimal(String.valueOf(payCurrencyAmount)));
		  paymentAddData.setPayment_type(paymentType);
		  paymentAddData.setPayment_clear_status(3);
		  orderAddPaymentAddRequest.setDsn("ucp_cs_web");
		  orderAddPaymentAddRequest.setDoc_ref_id(2);
		  orderAddPaymentAddRequest.setUser_login_data(login);
		  orderAddPaymentAddRequest.setCustomer_address_identifier(customerAddressIdentifier);
		  orderAddPaymentAddRequest.setOrder_data(orderData);
		  orderAddPaymentAddRequest.setPayment_add_data(paymentAddData);
		  orderAddPaymentAddResponse = soap.orderAddPaymentAdd(orderAddPaymentAddRequest);
		  orderHeaderID =(orderAddPaymentAddResponse.getOrderhdr());
		  paymentAmount = (orderAddPaymentAddResponse.getPayment());
		  } catch (Exception e) {
			  LOGGER.error(ERROR + e);
		  }
		
	}*/
     public boolean cancelPayment(int customerId,int paymentSeq,PaymentModel paymentModel) throws ServiceException{
    	 try {
    	  LOGGER.info("Inside cancel payment method");
 		  ThinkSoap soap = null;
 		  ThinkWSLocator locator = new ThinkWSLocator();
 		 
 		  Payment_cancel_request paymentCancelRequest = new Payment_cancel_request();
 		  Payment_cancel_response paymentCancelResponse;
 		  soap = locator.getThinkSoap();
 		  User_login_data login=new User_login_data();
 		  Customer_identifier customerIdentity = new Customer_identifier();
 		  Payment_identifier paymentIdentifier = new Payment_identifier();
 		  login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		  login.setPassword( new PropertyUtilityClass().getQuery("password"));
 		  customerIdentity.setCustomer_id(customerId);
 		  paymentIdentifier.setPayment_seq(paymentSeq);
 		  paymentIdentifier.setCustomer_identifier(customerIdentity);
 		  paymentCancelRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
		  paymentCancelRequest.setDoc_ref_id(paymentModel.getDoc_ref_id());
		  paymentCancelRequest.setUser_login_data(login);
 		  paymentCancelRequest.setPayment_identifier(paymentIdentifier);
 		  paymentCancelResponse = soap.paymentCancel(paymentCancelRequest);
 		  paymentCancelResponse.getPayment();
 		  }
    	 catch(AxisFault e){			
				// SOAPFault sf=new org.apache.axis.message.SOAPFault(e);
				String fault=e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
				LOGGER.info("PaymentCancelWsdl = "+fault);		
				return false;
    	 } catch (Exception e) {
 			 LOGGER.error(ERROR + e);
 			 
 			 return false;
 		  }
    	 return true;
    	  
	  }
     public boolean transferPayment(int paymentSeq,int customerId,int recverCustomerId,PaymentModel paymentModel) throws ServiceException{
    	 try {
         LOGGER.info("Inside transfer payment method");
    	 ThinkSoap soap = null;
    	 ThinkWSLocator locator = new ThinkWSLocator();
     	 Payment_transfer_request paymentTransferRequest = new Payment_transfer_request();
    	 Payment_transfer_response paymentTransferResponse;
    	 soap = locator.getThinkSoap();
    	 User_login_data login=new User_login_data();
    	 Customer_identifier customerIdentity = new Customer_identifier();
    	 Customer_identifier customerIdentity1 = new Customer_identifier();
    	 Payment_identifier paymentIdentifier = new Payment_identifier();

    	 Payment_identifier paymentForGetPayment = new Payment_identifier();
    	 login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		 login.setPassword( new PropertyUtilityClass().getQuery("password"));
    	 customerIdentity.setCustomer_id(customerId);
    	 paymentIdentifier.setPayment_seq(paymentSeq);
    	 paymentIdentifier.setCustomer_identifier(customerIdentity);
    	 customerIdentity1.setCustomer_id(recverCustomerId);
    	 paymentForGetPayment.setCustomer_identifier(customerIdentity1);
    	 paymentTransferRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
    	 paymentTransferRequest.setDoc_ref_id(paymentModel.getDoc_ref_id());
    	 paymentTransferRequest.setUser_login_data(login);
    	 paymentTransferRequest.setCustomer_identifier(customerIdentity1);
    	 paymentTransferRequest.setPayment_identifier(paymentIdentifier);
    	 paymentTransferResponse = soap.paymentTransfer(paymentTransferRequest);
    	 paymentTransferResponse.getPayment();
    	 }catch(AxisFault e){			
				// SOAPFault sf=new org.apache.axis.message.SOAPFault(e);
				String fault=e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
				LOGGER.info("PaymentTransferWsdl = "+fault);		
				return false;
		  }catch (Exception e) {
			  LOGGER.error(ERROR + e);
			  return false;
		  }
    	 return true;
      }
     public boolean depositRefundPayment(PaymentModel paymentModel) throws ServiceException{
    	 try {
    	  LOGGER.info("Inside deposit refund  payment method");
 		  ThinkSoap soap = null;
 		  ThinkWSLocator locator = new ThinkWSLocator();
 		  Deposit_refund_request depositRefundPaymentRequest = new Deposit_refund_request();
 		  //Deposit_refund_response depositRefundPaymentResponse;
 		  soap = locator.getThinkSoap();
 		  User_login_data login=new User_login_data();
 		  Customer_identifier customerIdentity = new Customer_identifier();
 		  Payment_refund_data paymentRefundData = new Payment_refund_data();
 		  ZZCreditCard creditCardInfo = new ZZCreditCard();
 		 // Payment_identifier paymentIdentifier = new Payment_identifier();
 		  login.setLogin(new PropertyUtilityClass().getQuery("login"));	
		  login.setPassword( new PropertyUtilityClass().getQuery("password"));
 		  customerIdentity.setCustomer_id(paymentModel.getCustomer_id());
 		  creditCardInfo.setCredit_card_info("no");
 		  paymentRefundData.setSkip_bank_def_ref_num_check(ZZBoolean.yes);
 		  paymentRefundData.setRefund_to_deposit(ZZBoolean.no);
 		  paymentRefundData.setCustomer_identifier(customerIdentity);
 		  paymentRefundData.setAmount(new BigDecimal(String.valueOf(paymentModel.getPayAmount())));
 	      paymentRefundData.setCurrency(paymentModel.getCurrency());
 		  paymentRefundData.setTransaction_reason("REFDEPOSIT");
// 		  paymentRefundData.setPayment_type("_DA");
 		 String dsn=new PropertyUtilityClass().getQuery("dsn");
			if( dsn.equals("web_countryside_test")) {
				paymentRefundData.setPayment_type("_DA");
			}else if( dsn.equals("php_cs_web")) {
				paymentRefundData.setPayment_type("CQ");
			}else if( dsn.equals("ucp_cs_web1")) {
				paymentRefundData.setPayment_type("CK");
			}
			else if(dsn.equals("Noida-Live74")) {
				paymentRefundData.setPayment_type("CK");
			}
			else if(dsn.equals("QADB_74_TEST")) {
				paymentRefundData.setPayment_type("CK");
			}
 		  paymentRefundData.setCredit_card_info(String.valueOf(creditCardInfo));
 		  //paymentIdentifier.setPayment_seq(paymentSeq);
 		 // paymentIdentifier.setCustomer_identifier(customerIdentity);
 		 //depositRefundPaymentRequest.setDsn("ucp_cs_web");
 		   depositRefundPaymentRequest.setDsn(dsn);
 		   depositRefundPaymentRequest.setDoc_ref_id(paymentModel.getDoc_ref_id());
 		   depositRefundPaymentRequest.setSubmit(ZZBoolean.yes);
 		   depositRefundPaymentRequest.setUser_login_data(login);
 		   depositRefundPaymentRequest.setPayment_refund_data(paymentRefundData);
 		  //depositRefundPaymentRequest.setPayment_identifier(paymentIdentifier);
 		  soap.depositRefund(depositRefundPaymentRequest);
 		  } catch (Exception e) {
 			 LOGGER.error(ERROR + e);
 			 return false;
 		  }
    	 return true;
    	  
	  } 

     public boolean UseDeposit(PaymentModel paymentModel) throws ServiceException{
    	 try {
    	 LOGGER.info("Inside Use Deposit method");

    	 ThinkSoap soap = null;


    	 ThinkWSLocator locator = new ThinkWSLocator();
    	 Deposit_use_request depositUseRequest = new Deposit_use_request();
    	 Deposit_use_response depositUseResponse;
    	 soap = locator.getThinkSoap();


    	 User_login_data login=new User_login_data();
    	 login.setLogin(new PropertyUtilityClass().getQuery("login"));
    	 login.setPassword( new PropertyUtilityClass().getQuery("password"));

    	 Customer_identifier customerIdentity = new Customer_identifier();
    	 customerIdentity.setCustomer_id(paymentModel.getPayerCustomer());


    	 int arraySize = 0;
    	 String orderPairID[] = paymentModel.getOrderIdOrderseq().toString().split(",");
    	 System.out.println("Lenght of array"+orderPairID.length);
    	 if (paymentModel.getOrderId()!=0){
    	 arraySize=orderPairID.length;
    	 }
    	 Item_payment itemPayment[] = new Item_payment[arraySize];

    	 int i=0;
    	 if (paymentModel.getOrderId() != 0 && paymentModel.getOrderItemSeq() != 0) {

    	 for (int j = 0; j < orderPairID.length; j++) {
    	 String OrderIdOrderseq[] = orderPairID[j].split("-");
    	 String orderId = OrderIdOrderseq[0];
    	 String orderItemSeq = OrderIdOrderseq[1];
    	 ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
    	 Item_payment itemPayments = new Item_payment();
    	 for (int k = 0; k < orderPairID.length; k++) {
    	 itemIdentifier.setOrderhdr_id(Integer.parseInt(orderId));
    	 itemIdentifier.setOrder_item_seq(Integer.parseInt(orderItemSeq));
    	 if(paymentModel.getThreshold_option()!=null && paymentModel.getThreshold_option() !="")
    	 {
    	 itemPayments.setThreshold_option(Threshold_option_enum.fromString(paymentModel.getThreshold_option()));
    	 }
    	 
    	 itemPayments.setAmount(new BigDecimal(String.valueOf(paymentModel.getPay_currency_amount())));
    	 itemPayments.setItem_identifier(itemIdentifier);
    	 itemPayment[i] = itemPayments;
    	 i++;
    	 }
    	 }
    	 }
    	 depositUseRequest.setCurrency(paymentModel.getCurrency());
    	 depositUseRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
    	 depositUseRequest.setDoc_ref_id(paymentModel.getDoc_ref_id());
    	 depositUseRequest.setUser_login_data(login);
    	 depositUseRequest.setItem_payment(itemPayment);
    	 depositUseRequest.setCustomer_identifier(customerIdentity);
    	 depositUseResponse= soap.depositUse(depositUseRequest);
    	 System.out.println(depositUseResponse.getOrderhdr(0));
    	 }catch (Exception e) {
    	 LOGGER.error(ERROR + e);
    	 return false;
    	 }
    	 return true;
    	 }
    /* public boolean UseDeposit(PaymentModel paymentModel) throws ServiceException{
    	 try {
         LOGGER.info("Inside Use Deposit method");
         
    	 ThinkSoap soap = null;
    	 
    	 
    	 ThinkWSLocator locator = new ThinkWSLocator();
    	 Deposit_use_request depositUseRequest = new Deposit_use_request();
    	 Deposit_use_response depositUseResponse;
    	 soap = locator.getThinkSoap();
    	 
    	 
    	 User_login_data login=new User_login_data();
    	 login.setLogin(new PropertyUtilityClass().getQuery("login"));	
    	 login.setPassword( new PropertyUtilityClass().getQuery("password"));
    	
    	 Customer_identifier customerIdentity = new Customer_identifier();
    	 customerIdentity.setCustomer_id(paymentModel.getPayerCustomer());
    	  	
    	  Item_payment itemPayment[] = new Item_payment[1];

    	 				ZZItemIdentifier itemIdentifier = new ZZItemIdentifier();
    					Item_payment itemPayments = new Item_payment();
    					
    						itemIdentifier.setOrderhdr_id(paymentModel.getOrderId());
    						itemIdentifier.setOrder_item_seq(paymentModel.getOrderItemSeq());
    						itemPayments.setItem_identifier(itemIdentifier);
    						
    						itemPayments.setAmount(new BigDecimal(String.valueOf(paymentModel.getAmount())));
    						itemPayments.setPay_currency_amount(new BigDecimal(String.valueOf(paymentModel.getPay_currency_amount())));
    						//itemPayments.setThreshold_option(Threshold_option_enum.partial);
    						itemPayments.setThreshold_option(Threshold_option_enum.fromString(paymentModel.getThresholdOption()));
    						itemPayment[0] = itemPayments;
    				
    	 depositUseRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));	
    	 depositUseRequest.setUser_login_data(login); 
    	 depositUseRequest.setCustomer_identifier(customerIdentity);
    	 depositUseRequest.setItem_payment(itemPayment);
    	 depositUseRequest.setCurrency(paymentModel.getCurrency());
    	 depositUseRequest.setDoc_ref_id(paymentModel.getDoc_ref_id());
    	 depositUseRequest.setSubmit(ZZBoolean.yes);
    	
    	
    	 soap.depositUse(depositUseRequest);
    	  	  
    	 }
    	 catch (Exception e) {
    		  LOGGER.error(ERROR + e);
    		  return false;
    	  }
    	 return true;
    	
     }*/

    public List<ThresholdOption[][]> thresholdOptionsWsdl(int oc_id,int order_code_id,int customer_id, String currency, 
		BigDecimal item_amount, BigDecimal total_amount_paid_on_item,BigDecimal total_amount_paid_this_payment,
		BigDecimal amount_to_apply) throws ServiceException {
	 	
	  LOGGER.info("Inside threshold options method");
	  ThinkSoap soap = null;
	  ThinkWSLocator locator = new ThinkWSLocator();	 
	  soap = locator.getThinkSoap();
		
	  Threshold_option_list_request thresholdOptionListRequest = new Threshold_option_list_request();
	  
      ThresholdOption[][] thresholdDataResponse = null;
	  List<ThresholdOption[][]> responseList = new ArrayList<>();
	  
	  User_login_data login=new User_login_data();
	  login.setLogin(new PropertyUtilityClass().getQuery("login"));	
	  login.setPassword( new PropertyUtilityClass().getQuery("password"));
	  
//	  Customer_identifier customerIdentity = new Customer_identifier();
//	  Payment_identifier paymentIdentifier = new Payment_identifier();
//	  customerIdentity.setCustomer_id(customer_id);
	 
	  thresholdOptionListRequest.setDsn(new PropertyUtilityClass().getQuery("dsn"));
	  thresholdOptionListRequest.setUser_login_data(login);
	  try {
	  Threshold_data[] threshold_data= new Threshold_data[1];  
	  Threshold_data list = new Threshold_data();
	  list.setOc_id(oc_id);
	  list.setOrder_code_id(order_code_id);
	  list.setCustomer_id(customer_id);
	  list.setCurrency(currency);
	  list.setItem_amount(item_amount);
	  list.setTotal_amount_paid_on_item(total_amount_paid_on_item);
	  list.setTotal_amount_paid_this_payment(total_amount_paid_this_payment);
	  list.setAmount_to_apply(amount_to_apply);	  
	  list.setOrder_item_type(0);
	  list.setBilling_type(0);
	  list.setSubscrip_start_type(0);
	  threshold_data[0]=list;
	  thresholdOptionListRequest.setThreshold_data(threshold_data);
	 
	 //ObjectMapper.convertValue(thresholdOptionListRequest,new ThresholdOption[][]<List<ThresholdOption>>() { });
	 // ObjectMapper.convertValue(thresholdOptionListRequest, null);
//	   ObjectMapper mapper = new ObjectMapper();
//	  Threshold_option_list_request threshold_option_list_request = mapper.convertValue(thresholdOptionListRequest, Threshold_option_list_request.class);
//	  Threshold_option_list_request request =(Threshold_option_list_request) org.apache.axis.utils.JavaUtils.convert(thresholdOptionListRequest,ThresholdOption[][].class);
     
	 thresholdDataResponse=soap.thresholdOptionList(thresholdOptionListRequest);
	 
	 if(thresholdDataResponse != null)
		{
			responseList.add(thresholdDataResponse);
		}
		
	  }	 catch(AxisFault e){			
			//SOAPFault sf=new org.apache.axis.message.SOAPFault(e);
			String fault=e.getFaultDetails()[0].getAttributes().getNamedItem("error_description").getNodeValue().toString();
			LOGGER.info("paymentWsdl = "+fault);		
			
		}
	 catch (Exception e) {
		 LOGGER.error(ERROR + e);
	  }
	  
	 return responseList;
	  
 }



public List<Payment_account_info_select_response> bankDetailsList(Long customerId) throws ServiceException{
	LOGGER.info("Inside bankDetailsList method");

	  ThinkWSLocator locator = new ThinkWSLocator();
	  ThinkSoap soap = null;
	  soap = locator.getThinkSoap();
	  
	  int customerID = Integer.parseInt(customerId.toString());	  
	  
	  Payment_account_info_select_responsePayment_account bankDetails = null;
	  
	  List<Payment_account_info_select_response> list = new ArrayList<>();
	  
	  Payment_account_info_select_request  paymentListInfoSelectRequset = new Payment_account_info_select_request();
	  Payment_account_info_select_response paymentListInfoSelectResponse = new Payment_account_info_select_response();
	 
	  User_login_data login=new User_login_data();
	  login.setLogin(new PropertyUtilityClass().getQuery("login"));	
	  login.setPassword( new PropertyUtilityClass().getQuery("password"));

	  Customer_identifier customerIdentity = new Customer_identifier();
	  customerIdentity.setCustomer_id(customerID);
	  
	  paymentListInfoSelectRequset.setDsn(new PropertyUtilityClass().getQuery("dsn"));
	  paymentListInfoSelectRequset.setUser_login_data(login);
	  paymentListInfoSelectRequset.setCustomer_identifier(customerIdentity);
	  try {		  
		  paymentListInfoSelectResponse = soap.paymentAccountInfoSelect(paymentListInfoSelectRequset);
		  
		  list.add(paymentListInfoSelectResponse);
	  } catch (Exception e) {
	  
		  LOGGER.error(ERROR + e);
	  }
	 return list;
	
}
}
