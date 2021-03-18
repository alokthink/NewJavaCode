package com.mps.think.controller;
import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.model.CustomerOrderModel;
import com.mps.think.model.CustomerOrderPayment;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.JournalDepositModel;
import com.mps.think.model.OrderDetailsModel;
import com.mps.think.model.OrderItem;
import com.mps.think.model.OrderItemAccountModel;
import com.mps.think.model.PaybreakModel;
import com.mps.think.model.PaymentModel;
import com.mps.think.model.PaymentReview;
import com.mps.think.model.TotalDepositSummaryModel;
import com.mps.think.service.CustomerOrderService;
import com.mps.think.service.PaymentService;
import com.mps.think.service.UtilityService;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
import com.mps.think.wsdl.PaymentWsdl;
import Think.XmlWebServices.Order_payment_select_responsePayment_on_order;
import Think.XmlWebServices.ThresholdOption;
import com.mps.think.service.PaymentAccountService;



@RestController
//@Scope("request")
public class PaymentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	CustomerOrderService customerOrderService;
	
//	@Autowired
//	PaymentWsdl paymentWsdl2;
	
	@Autowired
	PaymentAccountService paymentAccountService;
	
	@Autowired
	UtilityService utilityService;
	@Autowired
	JdbcTemplate jdbcTemplate;
	//*******************************************************
	@PostConstruct
	public void init() {
		 try {
			 CustomerUtility customerUtility = new CustomerUtility();
			 customerUtility.runTruncate(jdbcTemplate);
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}
   //*******************************************************
	
	@RequestMapping(path="/Payments", method = RequestMethod.POST)
	public Map<String, Object> allPayment(@RequestParam("customerId") String customerId,int filterDropdown,String orderhdrId){
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			
			//List<Payment_list_select_responsePayment> allPaymentList = new TestClass().fetchPaymentList(customerId);
		List<PaymentModel> allPaymentList = paymentService.getAllPayment(customerId,filterDropdown,orderhdrId);
		List<Map<String, Object>> customerDetails = customerOrderService.getCustomerDetails("All");	
				responseObject.put("paymentsTableHeaders",utilityService
				.getDispContextHeaders("view_payment_tab_list_all"));
			/*Iterator<Payment_list_select_responsePayment> it = allPaymentList.iterator();
			while(it.hasNext()){
				Calendar date = it.next().getCreation_date();
				String creationDate = date.DATE+"/"+date.MONTH+"/"+date.YEAR;
				System.out.println("creationDate = "+date.getTime());
			}*/
		/*model.addAttribute("allPayment", gson.toJson(allPaymentList));
		model.addAttribute("customerDetails", gson.toJson(customerDetails));
		model.addAttribute("customerId", customerId);*/
		   responseObject.put("allPayment",allPaymentList);
		   responseObject.put("customerDetailsList",customerDetails);
		   responseObject.put(STATUS,SUCCESS);
		   return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	

	@RequestMapping(path = "/MakePayment", method = RequestMethod.POST)	
	public Map<String,Object> makePayment(PaymentModel paymentModel,String currency){
		Map<String,Object> responseObject = new LinkedHashMap<String,Object>();
		Map<String,Object> tableHeaders = new LinkedHashMap<String,Object>();
		 double dueSum;
		 List<DropdownModel> defaultpaymentType=new ArrayList<>();
		 
		
		try {
			//PaymentType paymentType = new PaymentType();
			//paymentType.setPaymentType(paymentService.getPaymentType());
			//new TestClass().fetchAmount(customerId);
			//List<PaymentType> paymentList =	paymentService.getPaymentType();
			PaymentModel customerDetailsForPayment = paymentService.getCustomerDetailsForPayment(String.valueOf(paymentModel.getCustomer_id()));
			if(customerDetailsForPayment!=null) {
			double payAmount = 0.0d;			
			payAmount = paymentService.fetchPayAmount(paymentModel.getCustomer_id(), paymentModel.getOrderId(), paymentModel.getBill_to_customer_id());
			List<Order_payment_select_responsePayment_on_order> allPaymentList = new PaymentWsdl().fetchAmount(paymentModel.getCustomer_id());
			System.out.println(allPaymentList);
		
			 Iterator<Order_payment_select_responsePayment_on_order> itr=allPaymentList.iterator();  
			 
		    //  float totalAmount = 0.0f;
		      double paidAmonut= 0.00d;
		     // float netAmount = 0.0f;
		      while(itr.hasNext()) {
		    	  Order_payment_select_responsePayment_on_order orderPayment = itr.next();
		    	  
		    	  // totalAmount = totalAmount+Float.parseFloat(itr.next().getGross_base_amount().toString());
		    	  //paidAmonut = paidAmonut+Float.parseFloat(itr.next().getTotal_paid().toString());
		    	  paidAmonut = paidAmonut+Double.parseDouble(orderPayment.getTotal_paid()!=null?orderPayment.getTotal_paid().toString():"0.00");
		      }
		     
			List<Map<String, Object>> currencyList = paymentService.getCurrencyType();
			
		
			for(Map<String,Object> currencyMap:currencyList){
				paymentModel.setPay_exchange_rate(Double.parseDouble(currencyMap.get("exchange_rate").toString()));	
			}
			
			 responseObject.put("CustomerDetailsForPayment", customerDetailsForPayment);
			 responseObject.put("CurrencyTypeList", currencyList);
			
                 
				 List<CustomerOrderPayment> orderListForcustomer = paymentService.getCustomerOrder(String.valueOf(paymentModel.getCustomer_id()),paymentModel.getOrderId(),paymentModel.getOrderItemSeq(),paymentModel.getBill_to_customer_id(), paymentModel.getCurrency());
				 responseObject.put("OrderFilterDataList", orderListForcustomer);
				
					
			 double dueCurr = 0.00;
			 double payCurr = 0.00;
			 double netAmount = 0.00;
			 dueSum = 0;
			 DecimalFormat df = new DecimalFormat("#.##");
			String  paidAmt = df.format(paidAmonut);
			String PayAmt = df.format(payAmount);
			 List<Map<String, Object>> dafaultcurrency=	paymentService.getdefaultCurrency(paymentModel.getCustomer_id());
				
				if(currency == "") { 
					currency = (String) dafaultcurrency.get(0).get("currency");
				} else {
					currency = currency;
				}
			 if(orderListForcustomer.size() > 0){
				 				
				 for ( CustomerOrderPayment orderListForcustomers : orderListForcustomer) {
					 if(currency != "") {
						 for (Map<String,Object>  CurrencyList : currencyList) {
							 if(CurrencyList.get("currency").equals(currency)) {
								 BigDecimal bd = (BigDecimal) CurrencyList.get("exchange_rate");
								 double exchange_rate =  bd.doubleValue();
								 double due1 = orderListForcustomers.getDue() * (1/exchange_rate);
								 due1 = Math. round(due1 * 100.0) / 100.0;
								 orderListForcustomers.setDueCurr(due1);
								 dueSum+=  orderListForcustomers.getDueCurr();
								// orderListForcustomers.setPayCurr(orderListForcustomers.getDue() * (1/exchange_rate));
//								 tableHeaders.put("Due","due"); 
//								 tableHeaders.put("Due"+"("+currency+")", "dueCurr"); 
//								 tableHeaders.put("Pay"+"("+currency+")","payCurr");
								 
							 } 
						 } 
					 } else {
//						   tableHeaders.put("Due","due"); 
//				    	   tableHeaders.put("Pay", "pay");
						 for (Map<String,Object>  DefaultCurrency : dafaultcurrency) {
							 dueSum+=  orderListForcustomers.getDue();
						 }
						 dueSum = Math. round(dueSum * 100.0) / 100.0;
					 }
					 if (paymentModel.getOrderId() != 0 || paymentModel.getOrderItemSeq() != 0) {
						  netAmount+= orderListForcustomers.getDue();
						  
						  if (netAmount < 0) {
							   netAmount = 0.00;
						   }
					  }else {
						   netAmount = (double) (payAmount-paidAmonut);
						   if (netAmount < 0) {
							   netAmount = 0.00;
						   }
					  } 
				 }
				 
			 } else {
				 netAmount = 0.00;
			 }
			 responseObject.put("DefaultCurrency", dafaultcurrency);
			 responseObject.put("paymentAmount", netAmount);
		      responseObject.put("baseAmount", payAmount);
		      responseObject.put("dueSum", dueSum);
		      tableHeaders = utilityService.getDispContextHeaders("order_item_payments");
			 
			 if (currency != "") {
				 for (Map<String,Object>  defaultCurr : dafaultcurrency) {
		    		  if (defaultCurr.get("currency") == currency) {
		    			  tableHeaders.put("Due","due"); 
				    	  tableHeaders.put("Pay"+"("+currency+")", "pay");
		    		  } else {
		    			 tableHeaders.put("Due","due"); 
		 				 tableHeaders.put("Due"+"("+currency+")", "dueCurr"); 
		 				 tableHeaders.put("Pay"+"("+currency+")","payCurr"); 
		    		  }
		    	  }				 
		      } else {
		    	  tableHeaders.put("Due","due"); 
		    	  tableHeaders.put("Pay", "pay");
		    	  
		      }
			
			 
			List<DropdownModel> transactionStatusList = new ArrayList<>();
			for(int i=0;i<=12;i++){
				DropdownModel transactionStatus = new DropdownModel();
				transactionStatus.setKey(""+i);
				if(i==4 || i==5 || i==6 || i==7 || i==8 || i==9 ||i==10) {
					continue;
					}
				transactionStatus.setDisplay(new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_"+i));
				transactionStatusList.add(transactionStatus);
			}
			List<DropdownModel> orderFilterList = new ArrayList<>();
			for(int i=0;i<=1;i++){
				DropdownModel orderFilter = new DropdownModel();
				orderFilter.setKey(""+i);
				orderFilter.setDisplay(new PropertyUtilityClass().getConstantValue("order_filter_show_Paymet_"+i));
				orderFilterList.add(orderFilter);
			}
			
			List<DropdownModel> orderFilterPayer = new ArrayList<>();
			for(int i=0;i<=1;i++){
				DropdownModel orderFilterforPayer = new DropdownModel();
				orderFilterforPayer.setKey(""+i);
				orderFilterforPayer.setDisplay(new PropertyUtilityClass().getConstantValue("order_filter_where_payment_"+i));
				orderFilterPayer.add(orderFilterforPayer);
			}
			List<DropdownModel> orderFilterrecipient = new ArrayList<>();
			for(int i=0;i<=1;i++){
				DropdownModel orderFilterforrecipient = new DropdownModel();
				orderFilterforrecipient.setKey(""+i);
				orderFilterforrecipient.setDisplay(new PropertyUtilityClass().getConstantValue("order_filter_is_the_payment_"+i));
				orderFilterrecipient.add(orderFilterforrecipient);
			}
			
//			List<Map<String, Object>> paymentAccountList = paymentAccountService.getpaymentAccountList((long) paymentModel.getCustomer_id());
//			responseObject.put("paymentAccountList", paymentAccountList);
			
				Integer overPaymentHandling = paymentService.getOverPaymentHandling();
				responseObject.put("overPaymentHandling", overPaymentHandling);

				List<DropdownModel> payerCustomerList = paymentService.getPayerCustomer(paymentModel.getCustomer_id(),
						paymentModel.getOrderId());
				

				List<DropdownModel> paymentAccountList = paymentService
						.getpaymentAccountList(paymentModel.getCustomer_id());
				responseObject.put("paymentAccountList", paymentAccountList);
				if (paymentAccountList.isEmpty()) {
					defaultpaymentType=paymentService.getDefaultPaymentTypeInfo();
					responseObject.put("defualtPaymentType", defaultpaymentType);
					List<DropdownModel> paymentList = paymentService.getPaymentType();
					responseObject.put("PaymentTypeList", paymentList);
					

				} else {
					List<DropdownModel> defaultPaymentAccountSeq = paymentService
							.getdefaultPaymentAccountSeqInMake(paymentModel.getCustomer_id());
					responseObject.put("defaultPaymentAccountSeq", defaultPaymentAccountSeq);
					List<DropdownModel> paymentList1 = paymentService.getPaymentType();
					responseObject.put("PaymentTypeList", paymentList1);
					String seq=null;
					defaultpaymentType = paymentService.getPaymentType(paymentModel.getCustomer_id());
					responseObject.put("defualtPaymentType", defaultpaymentType);
				}
				/*if(defaultpaymentType.get(0).getKey()=="CA" ||  defaultpaymentType.get(0).getKey()=="CQ" || defaultpaymentType.get(0).getKey()=="BT") {
					String pmtClearStatus = new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_3");
					 responseObject.put("pmtClearStatus",pmtClearStatus);
				}
				else
				{
					String pmtClearStatus = new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_2");
					 responseObject.put("pmtClearStatus",pmtClearStatus);
			}*/
						
			responseObject.put("tableHeaders",tableHeaders);
			responseObject.put("payerCustomerList", payerCustomerList);
			responseObject.put("transactionStatus", transactionStatusList);
			responseObject.put("OrderFilterList", orderFilterList);
			// responseObject.put("currency", currencyData);
			responseObject.put("OrderFilterListForPayer", orderFilterPayer);
			responseObject.put("OrderFilterListRecipient", orderFilterrecipient);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			
		} 
		else {
			responseObject.put("Details for customerID:"+paymentModel.getCustomer_id()+"is not available", "false");
			return responseObject;
			
		}}
				catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
			}
	}

	
	@RequestMapping(path="/payAmountChng", method = RequestMethod.POST)	
	public Map<String,Object> payAmountChng(PaymentModel paymentModel,String currency){
		Map<String,Object> responseObject = new LinkedHashMap<String,Object>();
		Map<String,Object> tableHeaders = new LinkedHashMap<String,Object>();
		 double dueSum;
		try {
			double payAmount = 0.0d;
			 double netAmount = 0.00;
			 payAmount = paymentService.fetchPayAmount(paymentModel.getCustomer_id(), paymentModel.getOrderId(), paymentModel.getBill_to_customer_id());
				List<Order_payment_select_responsePayment_on_order> allPaymentList = new PaymentWsdl().fetchAmount(paymentModel.getCustomer_id());
				
		
				 Iterator<Order_payment_select_responsePayment_on_order> itr=allPaymentList.iterator(); 			 
			  
			      double paidAmonut= 0.00d;
			      while(itr.hasNext()) {
			    	  Order_payment_select_responsePayment_on_order orderPayment = itr.next();			    	  
			    	  paidAmonut = paidAmonut+Double.parseDouble(orderPayment.getTotal_paid()!=null?orderPayment.getTotal_paid().toString():"0.00");
			      }
			   dueSum= 0.00;
			List<Map<String, Object>> currencyList = paymentService.getCurrencyType();
			List<Map<String, Object>> dafaultcurrency=	paymentService.getdefaultCurrency(paymentModel.getCustomer_id());
			 List<CustomerOrderPayment> orderListForcustomer = paymentService.getCustomerOrder(String.valueOf(paymentModel.getCustomer_id()),paymentModel.getOrderId(),
					 paymentModel.getOrderItemSeq(),paymentModel.getBill_to_customer_id(), paymentModel.getCurrency());
          if(orderListForcustomer.size() > 0){
				 
				 
				 for ( CustomerOrderPayment orderListForcustomers : orderListForcustomer) {
					 if(currency != "") {
						 for (Map<String,Object>  CurrencyList : currencyList) {
							 if(CurrencyList.get("currency").equals(currency)) {
								 BigDecimal bd = (BigDecimal) CurrencyList.get("exchange_rate");
								 double exchange_rate =  bd.doubleValue();
								 double due1 = orderListForcustomers.getDue() * (1/exchange_rate);
								 due1 = Math. round(due1 * 100.0) / 100.0;
								 orderListForcustomers.setDueCurr(due1);
								 dueSum+=  orderListForcustomers.getDueCurr();
								 // orderListForcustomers.setPayCurr(orderListForcustomers.getDue() * (1/exchange_rate));
							 } 
						 } 
					 } else {
						 for (Map<String,Object>  DefaultCurrency : dafaultcurrency) {
							 dueSum+=  orderListForcustomers.getDue();	 
						 }
					 }
					 if (paymentModel.getOrderId() != 0 || paymentModel.getOrderItemSeq() != 0) {
						  netAmount+= orderListForcustomers.getDue();
						  
						  if (netAmount < 0) {
							   netAmount = 0.00;
						   }
					  }else {
						   netAmount = (double) (payAmount-paidAmonut);
						   if (netAmount < 0) {
							   netAmount = 0.00;
						   }
					  } 
				 }
				 
			 } else {
				 netAmount = 0.00;
			 }
          tableHeaders = utilityService.getDispContextHeaders("order_item_payments");
     	 if (currency != "") {
			 for (Map<String,Object>  defaultCurr : dafaultcurrency) {
	    		  if (defaultCurr.get("currency").equals(currency)) {
	    			  tableHeaders.put("Due","due"); 
			    	  tableHeaders.put("Pay"+"("+currency+")", "pay");
	    		  } else {
	    			 tableHeaders.put("Due","due"); 
	 				 tableHeaders.put("Due"+"("+currency+")", "dueCurr"); 
	 				 tableHeaders.put("Pay"+"("+currency+")","payCurr"); 
	    		  }
	    	  }				 
	      } else {
	    	  tableHeaders.put("Due","due"); 
	    	  tableHeaders.put("Pay", "pay");
	    	  
	      }
     
      responseObject.put("OrderFilterDataList", orderListForcustomer);
	  responseObject.put("tableHeaders",tableHeaders);
			 return responseObject;
		}
		catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
			}
		
		}
	
@RequestMapping(path = "/MakePaymentSave", method = RequestMethod.POST)
	public Map<String, Object> addPayment(PaymentModel paymentModel) {
		boolean status = false;
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Order_payment_select_responsePayment_on_order> fetchOrderDetails = new PaymentWsdl()
					.fetchAmount(paymentModel.getCustomer_id());

			System.out.println("fetchOrderDetaiks" + fetchOrderDetails);
			status = new PaymentWsdl().wsdlCall(paymentModel,fetchOrderDetails);
			responseObject.put(STATUS, status);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			e.printStackTrace();
			return responseObject;
		}
	}
	
	
	
	@RequestMapping(path="/PaymentAccount", method = RequestMethod.POST)
	public Map<String, Object> PaymentAccount( String customerId){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			
			List<Map<String, Object>> allPaymentAccoutList = paymentService.getPaymentAccount();
			/*model.addAttribute("allPaymentAccount", gson.toJson(allPaymentAccoutList));
			model.addAttribute("customerId", customerId);*/

			responseObject.put("allPaymentAccount",allPaymentAccoutList);
			   responseObject.put(STATUS,SUCCESS);
			   return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	@RequestMapping(path = "/getExchangeRate", method = RequestMethod.POST)
	public Map<String, Object> getExchangeRate(
			@RequestParam("currency") String currency) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();

		Double extRate= 0.0d;
		try {
			extRate = (Double) paymentService.getExchangeRate(currency);
			responseObject.put("exchangeRate", extRate);
			responseObject.put("Status","OK");
			
			return responseObject;
			} catch (Exception e) {
			LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path="/EditPayment",method = RequestMethod.POST)	
	public Map<String, Object> editPayment(PaymentModel paymentModel,String currency){
		  Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			double payAmount = 0.0d;			
			payAmount = paymentService.fetchPayAmount(paymentModel.getCustomer_id(), paymentModel.getOrderId(), paymentModel.getBill_to_customer_id());
			List<Order_payment_select_responsePayment_on_order> allPaymentList = new PaymentWsdl().fetchAmount(paymentModel.getCustomer_id());
			System.out.println(allPaymentList);
		
			 Iterator<Order_payment_select_responsePayment_on_order> itr=allPaymentList.iterator();  
			 
		    //  float totalAmount = 0.0f;
		      double paidAmonut= 0.00d;
		     // float netAmount = 0.0f;
		      while(itr.hasNext()) {
		    	  Order_payment_select_responsePayment_on_order orderPayment = itr.next();
		    	  
		    	  // totalAmount = totalAmount+Float.parseFloat(itr.next().getGross_base_amount().toString());
		    	  //paidAmonut = paidAmonut+Float.parseFloat(itr.next().getTotal_paid().toString());
		    	  paidAmonut = paidAmonut+Double.parseDouble(orderPayment.getTotal_paid()!=null?orderPayment.getTotal_paid().toString():"0.00");
		      }
			List<DropdownModel>paymentList=	paymentService.getPaymentType();
			List<DropdownModel>transactionReasonList=	paymentService.getTransactionReason();
			Map<String,Object> tableHeaders = new LinkedHashMap<String,Object>();
			//model.addAttribute("PaymentAdd", paymentList);
			PaymentModel fetchPaymentDetails = paymentService.selectPaymentDetails( paymentModel.getCustomer_id(), paymentModel.getPayment_seq());
			List<Map<String, Object>> currencyList = paymentService.getCurrencyType();
			PaymentModel customerDetailsForPayment = paymentService.getCustomerDetailsForPayment(String.valueOf(paymentModel.getCustomer_id()));
			//List<Map<String, Object>> orderListForcustomer = paymentService.getCurrentOrderforPayment(String.valueOf(paymentModel.getCustomerId()),paymentModel.getOrderId());
			List<Map<String, Object>> orderdetailsForEditPaymet = paymentService.getOrderItemsDetailsEditPage(paymentModel.getCustomer_id(),paymentModel.getPayment_seq());
			Double dafaultExchRate=	paymentService.getExchangeRate(paymentModel.getCurrency());
		    String defualtPaymentType=paymentService.getDefaultPaymentType();
		     List<DropdownModel> paymentList1=	paymentService.getPaymentType();
			responseObject.put("paymentList", paymentList1);
			Map<String, Object> defaultValue = new HashMap<>();
			for (DropdownModel i : paymentList1) {
				DropdownModel model=new DropdownModel();
				i.getKey().equals(defualtPaymentType);
				model.setKey(i.getKey());
				model.setDescription(i.getDescription());
				responseObject.put("defautPaymentType", model);
			}
				String paymentTypeForCustomer=paymentService.getPaymentTypeForCustomer( paymentModel.getCustomer_id());	  
				  	
			
			List<DropdownModel> transactionStatusList = new ArrayList<>();
			for(int i=0;i<=12;i++){
				DropdownModel transactionStatus = new DropdownModel();
				if(i==0 || i==1 || i==6 || i==7 || i==8 || i==9 || i==10 || i==11 || i==12) {
					continue;
					}
				transactionStatus.setKey(""+i);
				transactionStatus.setDisplay(new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_"+i));
				transactionStatusList.add(transactionStatus);
			}
			List<DropdownModel> orderFilterList = new ArrayList<>();
			for(int i=0;i<=1;i++){
				DropdownModel orderFilter = new DropdownModel();
				orderFilter.setKey(""+i);
				orderFilter.setDisplay(new PropertyUtilityClass().getConstantValue("order_filter_show_Paymet_"+i));
				orderFilterList.add(orderFilter);
			}
			List<DropdownModel> orderFilterPayer = new ArrayList<>();
			for(int i=0;i<=1;i++){
				DropdownModel orderFilterforPayer = new DropdownModel();
				orderFilterforPayer.setKey(""+i);
				orderFilterforPayer.setDisplay(new PropertyUtilityClass().getConstantValue("order_filter_where_payment_"+i));
				orderFilterPayer.add(orderFilterforPayer);
			}
			List<DropdownModel> orderFilterrecipient = new ArrayList<>();
			for(int i=0;i<=1;i++){
				DropdownModel orderFilterforrecipient = new DropdownModel();
				orderFilterforrecipient.setKey(""+i);
				orderFilterforrecipient.setDisplay(new PropertyUtilityClass().getConstantValue("order_filter_is_the_payment_"+i));
				orderFilterrecipient.add(orderFilterforrecipient);
			}
			//List<Map<String, Object>> dafaultcurrency=	paymentService.getdefaultCurrencyinEditPayment(paymentModel.getCustomer_id(),paymentModel.getPayment_seq());
			//CODE ADDED BY MALINI TO GET DEFAULT CURRENCY
			List<Map<String, Object>> dafaultcurrency=paymentService.getdefaultCurrencyFromConfig();
			responseObject.put("dafaultcurrency", dafaultcurrency);
			//to get customer order data in edit payment after cancelling order and  editing the inactive orders
			List<CustomerOrderPayment> orderListForcustomer = paymentService.getCustomerOrder(String.valueOf(paymentModel.getCustomer_id()),paymentModel.getOrderId(),paymentModel.getOrderItemSeq(),paymentModel.getBill_to_customer_id(), paymentModel.getCurrency());
			responseObject.put("orderListForcustomer", orderListForcustomer);
			    
			 if(currency == "") { 
				currency = (String) dafaultcurrency.get(0).get("currency");
			} else {
				currency = currency;
			}
			 
			 double dueCurr = 0.00;
			 double payCurr = 0.00;
			 double netAmount = 0.00;
			double dueSum = 0;
			
				tableHeaders = utilityService.getDispContextHeaders("order_item_payments");
			 
			 if (currency != "") {
				 for (Map<String,Object>  defaultCurr : dafaultcurrency) {
		    		  if (defaultCurr.get("currency") == currency) {
		    			  tableHeaders.put("Due","due"); 
				    	  tableHeaders.put("Pay"+"("+currency+")", "pay");
		    		  } else {
		    			 tableHeaders.put("Due","due"); 
		 				 tableHeaders.put("Due"+"("+currency+")", "dueCurr"); 
		 				 tableHeaders.put("Pay"+"("+currency+")","payCurr"); 
		    		  }
		    	  }				 
		      } else {
		    	  tableHeaders.put("Due","due"); 
		    	  tableHeaders.put("Pay", "pay");
		    	  
		      }
			   if(orderListForcustomer.size() > 0){
					 
					 
					 for ( CustomerOrderPayment orderListForcustomers : orderListForcustomer) {
						 if(currency != "") {
							 for (Map<String,Object>  CurrencyList : currencyList) {
								 if(CurrencyList.get("currency").equals(currency)) {
									 BigDecimal bd = (BigDecimal) CurrencyList.get("exchange_rate");
									 double exchange_rate =  bd.doubleValue();
									 double due1 = orderListForcustomers.getDue() * (1/exchange_rate);
									 due1 = Math. round(due1 * 100.0) / 100.0;
									 orderListForcustomers.setDueCurr(due1);
									 dueSum+=  orderListForcustomers.getDueCurr();
									 // orderListForcustomers.setPayCurr(orderListForcustomers.getDue() * (1/exchange_rate));
								 } 
							 } 
						 } else {
							 for (Map<String,Object>  DefaultCurrency : dafaultcurrency) {
								 dueSum+=  orderListForcustomers.getDue();	 
							 }
						 }
						 if (paymentModel.getOrderId() != 0 || paymentModel.getOrderItemSeq() != 0) {
							  netAmount+= orderListForcustomers.getDue();
							  
							  if (netAmount < 0) {
								   netAmount = 0.00;
							   }
						  }else {
							   netAmount = (double) (payAmount-paidAmonut);
							   if (netAmount < 0) {
								   netAmount = 0.00;
							   }
						  } 
					 }
					 
				 } else {
					 netAmount = 0.00;
				 }
			 responseObject.put("tableHeaders",tableHeaders);
			responseObject.put("dafaultcurrency", dafaultcurrency);
			List<Map<String, Object>> payerCustomerAddres =	paymentService.getPayerCustomerAddressForEdit(paymentModel.getCustomer_id(),paymentModel.getPayment_seq());
			List<Map<String, Object>> paymentSelectedProcessing=paymentService.getpaymentSelectedProcessing(paymentModel.getCustomer_id(),paymentModel.getPayment_seq());
			responseObject.put("paymentSelectedProcessing", paymentSelectedProcessing);
			List<DropdownModel> paymentAccountList = paymentService.getpaymentAccountList(paymentModel.getCustomer_id());
			responseObject.put("paymentAccountList", paymentAccountList);
			Map<String, Object> defaultType = new HashMap<>();
			for (DropdownModel i : paymentAccountList) {
				DropdownModel model=new DropdownModel();
				i.getKey().equals(paymentTypeForCustomer);
				model.setKey(i.getKey());
				model.setDescription(i.getDescription());
				responseObject.put("defaultPaymentAccount", model);
			}
			List<DropdownModel> defaultPaymentAccountSeq=paymentService.getdefaultPaymentAccountSeq(paymentModel.getPayerCustomer(),paymentModel.getPayment_seq());
			responseObject.put("defaultPaymentAccountSeq", defaultPaymentAccountSeq);
			 Integer overPaymentHandling=paymentService.getOverPaymentHandling();
			 responseObject.put("overPaymentHandling",overPaymentHandling);
				responseObject.put("payerCustomerAddressList", payerCustomerAddres);
	            responseObject.put("CustomerDetailsForPayment", customerDetailsForPayment);
				responseObject.put("currencyList", currencyList);
				responseObject.put("transactionStatusList", transactionStatusList);
				responseObject.put("transactionReasonList",transactionReasonList);
				responseObject.put("fetchPaymentDetails",fetchPaymentDetails);
				//responseObject.put("orderDeatailsForPayment", orderListForcustomer);
				responseObject.put("dafaultExchRate", dafaultExchRate);
				responseObject.put("orderItemDetailsList", orderdetailsForEditPaymet);
				responseObject.put("OrderFilterList", orderFilterList);
				// responseObject.put("currency", currencyData);
				responseObject.put("OrderFilterListForPayer", orderFilterPayer);
				responseObject.put("OrderFilterListRecipient", orderFilterrecipient);
				//added by malini
				String creditCardNumber=paymentService.getCreditCardNumber(paymentModel.getCustomer_id(), paymentModel.getPayment_seq());
				responseObject.put("creditCardNumber", creditCardNumber);
				// responseObject.put("tableHeaders",tableHeaders);
			//List<Map<String, Object>> orderListForcustomer = paymentService.getCustomerOrder(String.valueOf(paymentModel.getCustomerId()));
			//model.addAttribute("orderListForcustomer", gson.toJson(orderListForcustomer));
			//List<Map<String, Object>> paymentforEdit = paymentService.getPaymentForEdit(String.valueOf(paymentModel.getCustomerId(),paymentModel.getPaymentSeq()));
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR +e);
			 return responseObject;
		}
	}
	
	@RequestMapping(path="/cancelPayment",method = RequestMethod.POST)	
	public Map<String, Object> cancelPayment( PaymentModel paymentModel){
		boolean status = false;
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			status = new PaymentWsdl().cancelPayment(paymentModel.getCustomer_id(),paymentModel.getPayment_seq(),paymentModel);
			 responseObject.put(STATUS,status);
			 return responseObject;
		}
		catch (Exception e) {
			LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		}
	}
	
	@RequestMapping(path= "/UpdatePayment", method =RequestMethod.POST )
	public Map<String, Object> updatePayment (PaymentModel paymentModel){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			int status = paymentService.updatePayment(paymentModel);
			if(status == 0){
				responseObject.put(STATUS,false);
			}else {
				responseObject.put(STATUS,true);
			}
			 
			return responseObject;
		 }
	     catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR +e);
			 return responseObject;
		 }
		//return "redirect:/Payments?customerId="+paymentModel.getCustomerId();http://localhost:8080/reviewPaymentsOrderItemDetails?orderhdr_id=141
	}
	
	
	@RequestMapping(path = "/EditPaymentSave", method = RequestMethod.POST)
	public Map<String, Object> editPaymentSave(PaymentModel paymentModel) {
		boolean status = false;
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Order_payment_select_responsePayment_on_order> fetchOrderDetails = new PaymentWsdl()
					.fetchAmount(paymentModel.getCustomer_id());

			 System.out.println("fetchOrderDetails" + fetchOrderDetails);
			status = new PaymentWsdl().editWsdlCall(paymentModel, fetchOrderDetails);
			responseObject.put(STATUS, status);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			e.printStackTrace();
			return responseObject;
		}
	}
	@RequestMapping(path="/paymentBreakdown",method = RequestMethod.POST)
	public Map<String, Object> paymentBreakdown( int paymentSeq, int customerId){
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<PaybreakModel> viewPaymentBreakdownList=new ArrayList<>();
		List<Map<String, Object>> getpaymentAmount=new ArrayList<>();
		List<DropdownModel> orderList=new ArrayList<>();
		try{			
			viewPaymentBreakdownList= paymentService.paymentBreakdown(paymentSeq, customerId);
			getpaymentAmount= paymentService.getPaymentAmount(paymentSeq, customerId);
			/*model.addAttribute("paymentBreakdownList" , gson.toJson(viewPaymentBreakdownList));
			model.addAttribute("getpaymentAmount" ,(getpaymentAmount));*/
			orderList=paymentService.getOrderList(paymentSeq, customerId);
			responseObject.put("viewPaymentBreakdownList", viewPaymentBreakdownList);
			responseObject.put("getpaymentAmount", getpaymentAmount);
			responseObject.put("orderList", orderList);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e){
			LOGGER.info("Error in paymentBreakdown : "+e);
			 responseObject.put(STATUS,ERROR +e);
			 return responseObject;
		}
		
	}
	
	@RequestMapping(path="/paymentTransfer", method = RequestMethod.POST )	
	public Map<String, Object> transferPayment( int paymentSeq, int customerId, int recverCustomerId,PaymentModel paymentModel){
		boolean status =false;
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			status = new PaymentWsdl().transferPayment(paymentSeq,customerId,recverCustomerId,paymentModel);
			responseObject.put(STATUS,status);
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR +e);
			 return responseObject;
		}
		//redirectAttributes.addFlashAttribute(STATUS, TRANSFERSUCCESSFULLY);
		//return "redirect:/Payments?customerId="+customerId;
	}
	@RequestMapping(path="/depositeSummary",method = RequestMethod.POST)
	public Map<String, Object> getDepositSummary(int customerId,String currency){
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> depositSummaryList=new ArrayList<>();
		List<DropdownModel> paymentAccountList=new ArrayList<>();
		List<Map<String, Object>> depositDetailsList=new ArrayList<>();
		List<JournalDepositModel> depositAccountJournal=new ArrayList<>();
		List<Map<String, Object>> withdrawalDetailListData = new ArrayList<>();
		try{			
			depositSummaryList= paymentService.getDepositSummary(customerId);
			depositDetailsList= paymentService.getDepositDetails(customerId);
			depositAccountJournal= paymentService.getDepositDetailsfromJournal(customerId);
			paymentAccountList=paymentService.getpaymentAccountList(customerId);
			withdrawalDetailListData = paymentService.getWithdrawalDetails(customerId);
			responseObject.put("paymentAccountList", paymentAccountList);
			responseObject.put("depositDetailsList", depositDetailsList);
			responseObject.put("depositSummaryList", depositSummaryList);
			responseObject.put("depositAccountJournal", depositAccountJournal);
			responseObject.put("currencyList",paymentService.currencyList(customerId));
			responseObject.put("withdrawalDetails", withdrawalDetailListData);
			responseObject.put("tableHeaders",utilityService
					.getDispContextHeaders("view_order_item_payment_info"));
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e){
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR +e);
			return responseObject;
		}
		
	}
	
	@RequestMapping(path="/depositDetails",method = RequestMethod.POST)
	public Map<String, Object> getDepositDetails(int customerId)
    {
			 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			 List<Map<String, Object>> depositDetailsList=new ArrayList<>();
			 List<TotalDepositSummaryModel>  totalDepositDetails=new ArrayList<>();
			try{			
			    List<DropdownModel>  currencyList =paymentService.currencyList(customerId);
			    responseObject.put("currencyList",currencyList);
			    
			    depositDetailsList= paymentService.getDepositDetails(customerId);
				responseObject.put("OrderFilterDataList",depositDetailsList);
				
				totalDepositDetails= paymentService.getTotalDepositList(customerId);
				responseObject.put("totalDepositDetails",totalDepositDetails);
				
				responseObject.put(STATUS,SUCCESS);
				return responseObject;
			}catch(Exception e){
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR +e);
				return responseObject;
		}
}
	
	@RequestMapping(path="/orderItemDetails",method = RequestMethod.POST)
	public Map<String, Object> getOrderItemDetails(int customerId,int paymentSeq, int orderItemSeq){
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> orderItemDetailsList=new ArrayList<>();
		try{			
			orderItemDetailsList= paymentService.getOrderItemsDetails(customerId,paymentSeq,orderItemSeq);
			responseObject.put("orderItemDetailsList", orderItemDetailsList);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e){
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR +e);
			return responseObject;
		}
		
	}
		@RequestMapping(path="/fetchOrdersForEditpayment",method = RequestMethod.POST)
		public Map<String, Object> getOrdersForEditpayment(int customerId,int paymentSeq){
			 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			List<Map<String, Object>> orderdetailsForEditPaymet=new ArrayList<>();
			try{			
				orderdetailsForEditPaymet= paymentService.getOrderItemsDetailsEditPage(customerId,paymentSeq);
				responseObject.put("orderItemDetailsList", orderdetailsForEditPaymet);
				responseObject.put(STATUS,SUCCESS);
				return responseObject;
			}catch(Exception e){
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR +e);
				return responseObject;
			}
		}
			
			/*@RequestMapping(path="/fetchUnpaidAmount",method = RequestMethod.POST)
			public Map<String, Object> getUnpaidAmount(int customerId){
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				Double unpaidAmount = 0.0d;
				try{			
					unpaidAmount= paymentService.getUnpaidAmount(customerId);
					responseObject.put("FetchAmount", unpaidAmount);
					responseObject.put("Status","OK");
					return responseObject;
				}catch(Exception e){
					LOGGER.error(ERROR + e);
					responseObject.put("Status","error:"+e);
					return responseObject;
				}
	}*/
			
			@RequestMapping(path="/paymentFilterDropDown",method = RequestMethod.POST)
			public Map<String, Object> getPaymetFilter(){
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				try{	
					List<DropdownModel> paymentFilterList = new ArrayList<>();
					for(int i=0;i<=3;i++){
						DropdownModel paymentFilter = new DropdownModel();
						paymentFilter.setKey(""+i);
						paymentFilter.setDisplay(new PropertyUtilityClass().getConstantValue("payment_filter_dropdown_"+i));
						paymentFilterList.add(paymentFilter);
					}
					responseObject.put("PaymentFilterList", paymentFilterList);
					responseObject.put(STATUS,SUCCESS);
					return responseObject;
				  }
					catch(Exception e){
						LOGGER.error(ERROR + e);
						responseObject.put(STATUS,ERROR +e);
						return responseObject;
					}
				}
			
			@RequestMapping(path="/orderFIlterDropDownResult",method = RequestMethod.POST)
			public Map<String, Object> orderFilterData(int customer_id,String balancedue,String payer,String recipient,String currency){
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				 List<CustomerOrderPayment> orderFilterDataList=new ArrayList<>();
				try{			
					orderFilterDataList= paymentService.getOrdreFilterDropDownResult(customer_id,balancedue,payer,recipient);
					 Map<String, Object> tableHeaders = new LinkedHashMap<String,Object>();
					
					 	tableHeaders = utilityService.getDispContextHeaders("order_item_payments");
					 	tableHeaders.put("Due","due"); 
						tableHeaders.put("Pay","pay"); 
					    responseObject.put("tableHeaders", tableHeaders);
					
					

			 
		           	responseObject.put("OrderFilterDataList", orderFilterDataList);
					// responseObject.put("tableHeaders",tableHeaders);
					
					responseObject.put(STATUS,SUCCESS);
					return responseObject;
				}catch(Exception e){
					LOGGER.error(ERROR + e);
					responseObject.put(STATUS,ERROR +e);
					return responseObject;
				}
	      }
			
			@RequestMapping(path= "/DepositPaymentSave", method =RequestMethod.POST )
			public Map<String, Object> depositSave(PaymentModel paymentModel){
				boolean status = false;
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				try{
					status = paymentService.depositSave(paymentModel);
					
						 responseObject.put(STATUS,status);
						 return responseObject;
				}
				 catch(Exception e){
					 LOGGER.error(ERROR + e);
					 responseObject.put(STATUS,ERROR+e);
					 return responseObject;
				 }
			}	

			@RequestMapping(path="/depositRefundPayment",method = RequestMethod.POST)	
			public Map<String, Object> depositRefundPayment( PaymentModel paymentModel){
				boolean status = false;
				Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				try {
					status = new PaymentWsdl().depositRefundPayment(paymentModel);
					 responseObject.put(STATUS,status);
					 return responseObject;
				}
				catch (Exception e) {
					LOGGER.error(ERROR + e);
					 responseObject.put(STATUS,ERROR+e);
					 return responseObject;
				}
			}
			
			@RequestMapping(path="/orderlookup",method = RequestMethod.POST)	
			public Map<String, Object> searchlookup( OrderItem orderItem,String firstName,String lastName){
				List<Map<String, Object>> status ;
				Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				try {
					 status = paymentService.searchLookupOrder(orderItem, firstName,lastName);
					 responseObject.put(STATUS,status);
					 return responseObject;
				}
				catch (Exception e) {
					LOGGER.error(ERROR + e);
					 responseObject.put(STATUS,ERROR+e);
					 return responseObject;
				}
			}
			
			 @RequestMapping(path="/reviewPayments",method = RequestMethod.POST)	
				public  Map<String, Object> getReviewPayments(int orderId,int orderItemSeq){
					Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
					try {
						List<Map<String, Object>> paymentReviewList = paymentService.getReviewPayments(orderId,orderItemSeq);
						 responseObject.put("paymentReviewList",paymentReviewList);
						 responseObject.put(STATUS,SUCCESS);
						 }
					catch (Exception e) {
						LOGGER.error(ERROR + e);
						 responseObject.put(STATUS,ERROR+e);
						 return responseObject;
					}
					return responseObject;
				}
			 
			@RequestMapping(path="/getPayerCustomerAddress",method = RequestMethod.POST)	
			public  Map<String, Object> getPayerCustomerAddress(PaymentModel paymentModel){
				Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				try {
					 List<DropdownModel> payerCustomerAddressList =	paymentService.getPayerCustomerAddress(paymentModel.getCustomer_id());
					responseObject.put("payerCustomerAddressList", payerCustomerAddressList);
					 responseObject.put(STATUS,SUCCESS);
					 return responseObject;
				}
				catch (Exception e) {
					LOGGER.error(ERROR + e);
					 responseObject.put(STATUS,ERROR+e);
					 return responseObject;
				}
			}
			
			@RequestMapping(path="/getOrderItems",method = RequestMethod.POST)
			public Map<String, Object> getOrderItems( int orderhdr_id, int order_item_seq,int customer_id){
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				List<OrderDetailsModel> viewOrderItemsList=new ArrayList<>();
				//List<Map<String, Object>> getpaymentAmount=new ArrayList<>();
				try{			
					viewOrderItemsList= (List<OrderDetailsModel>) paymentService.viewOrderItemsList(orderhdr_id,order_item_seq,customer_id);
					/*model.addAttribute("paymentBreakdownList" , gson.toJson(viewPaymentBreakdownList));
					model.addAttribute("getpaymentAmount" ,(getpaymentAmount));*/
					responseObject.put("viewOrderItemsList", viewOrderItemsList);
					responseObject.put("tableHeaders",utilityService
							.getDispContextHeaders("view_oi_payable"));
					// responseObject.put("getpaymentAmount", getpaymentAmount);
					responseObject.put(STATUS,SUCCESS);
					return responseObject;
				}catch(Exception e){
					LOGGER.info("Error in paymentBreakdown : "+e);
					 responseObject.put(STATUS,ERROR +e);
					 return responseObject;
				}
				
			}
			
			
			@RequestMapping(path="/getOrderItemsFromDepositPay",method = RequestMethod.POST)
			public Map<String, Object> getOrderItemsFromDepositPay(PaymentModel paymentModel){
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				List<CustomerOrderPayment> viewOrderItemsListpay=new ArrayList<>();
				try{			
					viewOrderItemsListpay= (List<CustomerOrderPayment>) paymentService.viewOrderItemsListForDepPay(paymentModel.getCustomer_id(),paymentModel.getOrderId(),paymentModel.getOrderItemSeq());
	
					responseObject.put("orderListForcustomer", viewOrderItemsListpay);
					responseObject.put("customerOrderListHeader",utilityService
							.getDispContextHeaders("view_order_tab_list_all"));
					responseObject.put(STATUS,SUCCESS);
					return responseObject;
				}catch(Exception e){
					LOGGER.info("Error in paymentBreakdown : "+e);
					 responseObject.put(STATUS,ERROR +e);
					 return responseObject;
				}
				
			}
			
			
			@RequestMapping(path="/getDepositAmount",method = RequestMethod.POST)
			public Map<String, Object> getOrderItems( Integer customer_id, Integer orderId, Integer bill_to_customer_id,Integer orderItemSeq,String currency){
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				List<Map<String, Object>> DepositBalance=new ArrayList<>();
				List<Map<String, Object>> depositSummaryList=new ArrayList<>();
				try{			
					DepositBalance= ( List<Map<String,Object>>) paymentService.viewDepositBalance(bill_to_customer_id);
					depositSummaryList= paymentService.getDepositSummary(bill_to_customer_id);
					double payAmount = 0.0d;
					
					payAmount = paymentService.fetchPayAmount(customer_id, orderId, bill_to_customer_id);
					// paidAmt = jdbcTemplate.queryForList("select pay_currency_amount as paidAmt from paybreak where customer_id="+customerId +"and orderhdr_id="+ orderId + "and order_item_seq="+orderItemSeq+"" , Double.class );
					List<Order_payment_select_responsePayment_on_order> allPaymentList = new PaymentWsdl().fetchAmount(customer_id);
					Iterator<Order_payment_select_responsePayment_on_order> itr=allPaymentList.iterator(); 
					
					 double paidAmonut= 0.00d;
				     // float netAmount = 0.0f;
				      while(itr.hasNext()) {
				    	  Order_payment_select_responsePayment_on_order orderPayment = itr.next();
				    	  
				    	 // totalAmount = totalAmount+Float.parseFloat(itr.next().getGross_base_amount().toString());
				    	  //paidAmonut = paidAmonut+Float.parseFloat(itr.next().getTotal_paid().toString());
				    	  paidAmonut = paidAmonut+Double.parseDouble(orderPayment.getTotal_paid()!=null?orderPayment.getTotal_paid().toString():"0.00");
				      }
					 List<CustomerOrderPayment> orderListForcustomer = paymentService.getCustomerOrder(String.valueOf(customer_id),orderId,orderItemSeq,bill_to_customer_id,currency);
					 double netAmount = 0.00;
					 DecimalFormat df = new DecimalFormat(".##");
					String  paidAmt = df.format(paidAmonut);
					String PayAmt = df.format(payAmount);
//					   df.format(payAmount);
//					 df.format(paidAmonut);
					 if(orderListForcustomer.size() > 0){
						 
						 for ( CustomerOrderPayment orderListForcustomers : orderListForcustomer) {
							 
							 if ( orderId!= 0 || orderItemSeq != 0) {
								  netAmount+= orderListForcustomers.getDue();
								  if (netAmount < 0) {
									   netAmount = 0.00;
								   }
							  }else {
								   netAmount = (double) (payAmount-paidAmonut);
								   if (netAmount < 0) {
									   netAmount = 0.00;
								   }
							  }
							 
						 }
						 
					 } else {
						 netAmount = 0.00;
					 }
					
					responseObject.put("depositBalancet", DepositBalance);
					responseObject.put("depositSummaryList",depositSummaryList);
					responseObject.put("paymentAmount", netAmount);
					responseObject.put(STATUS,SUCCESS);
					return responseObject;
				}catch(Exception e){
					LOGGER.info("Error in getDeposit : "+e);
					 responseObject.put(STATUS,ERROR +e);
					 return responseObject;
				}
				
			}
			
			@RequestMapping(path= "/payFromDepositAccountSave", method =RequestMethod.POST )
			public Map<String, Object> UseDepositAccountPayment(PaymentModel paymentModel){
				boolean status = false;
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				try{
					// List<Order_payment_select_responsePayment_on_order> fetchOrderDetails = new PaymentWsdl().fetchAmount(paymentModel.getCustomer_id());
					status = new PaymentWsdl().UseDeposit(paymentModel);
						 responseObject.put(STATUS,status);
						 return responseObject;
				}
				 catch(Exception e){
					 LOGGER.error(ERROR + e);
					 responseObject.put(STATUS,ERROR+e);
					 return responseObject;
				 }
			}
			
			
			@RequestMapping(path= "/ThresholdData", method = RequestMethod.POST )
			public Map<String, Object> getPaymentThresholdData(int orderId, float PayAmount, int orderItemSeq) {
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
					List<Map<String, Object>> thresholdData= null;
					int proratedOrderQty = 0;
					float fractionValue =  0;

				
				try {
					double delivery=paymentService.getDeliveryAmount();
					thresholdData =  paymentService.getPaymentThresholdData(orderId,orderItemSeq);
					float localAmount = ((BigDecimal) thresholdData.get(0).get("net_base_amount")).floatValue();
					int issues = (int) thresholdData.get(0).get("order_qty");
					fractionValue = (localAmount / issues);
					 double PaidAmt =  (double) thresholdData.get(0).get("paidAmount");
					 DecimalFormat format=new DecimalFormat("#.00");
					 double totalPaid = PaidAmt+PayAmount;
					String value= format.format(totalPaid);
					 
					proratedOrderQty = (int) (totalPaid/fractionValue);
					responseObject.put("thresholdData",thresholdData );
					responseObject.put("delivery", delivery);
					responseObject.put("totalPaid", value);
					responseObject.put("thresholdData", thresholdData);
					//responseObject.put("proratedOrderQty", proratedOrderQty);
					
					return responseObject;
				}
				catch (Exception e) {
					 LOGGER.error(ERROR + e);
					 responseObject.put(STATUS,ERROR+e);
					 return responseObject;
				}
				
				
			}
			
			@RequestMapping(path= "/thresholdSettingOptions", method =RequestMethod.POST )
			public Map<String, Object> thresholdSettingOptions(float PayAmount) {
				boolean status = false;
				List<Map<String, Object>> thresholdSettingData = null;
				 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
				try{
					thresholdSettingData =  paymentService.getThresholdSettingOptions();
					float percentile = 100;
					
					float partialAmount = PayAmount*((Integer)thresholdSettingData.get(0).get("percent_partial")/percentile);
					float MinUnderFullPrcnt = PayAmount* ((Integer)thresholdSettingData.get(0).get("percent_under")/percentile);
					float MaxUnderFullPrcnt = PayAmount*((Integer)thresholdSettingData.get(0).get("percent_over")/percentile);
					float refundAmount = PayAmount*((Integer) thresholdSettingData.get(0).get("percent_refund")/percentile);
					float maxUnderFull =  ((BigDecimal)thresholdSettingData.get(0).get("max_under_full")).floatValue();
					float minUnderFull = ((BigDecimal) thresholdSettingData.get(0).get("max_over_full")).floatValue(); 
					
				    responseObject.put("thresholdSettingData", thresholdSettingData);
				    responseObject.put("partialAmount", partialAmount);
				    responseObject.put("MinUnderFullPrcnt", MinUnderFullPrcnt);
				    responseObject.put("MaxUnderFullPrcnt", MaxUnderFullPrcnt);
				    responseObject.put("refundAmount", refundAmount);
				    responseObject.put("maxUnderFull", maxUnderFull);
				    responseObject.put("minUnderFull", minUnderFull);
	
					return responseObject;
				}
				 catch(Exception e){
					 LOGGER.error(ERROR + e);
					 responseObject.put(STATUS,ERROR+e);
					 return responseObject;
				 }
			}
			
			@RequestMapping(value="/paymentHistory", method = RequestMethod.POST)
			public  Map<String, Object> paymentHistory(@RequestParam("customerId") Long customerId,@RequestParam("paymentSeq") int paymentSeq)
			{
				Map<String, Object> responseObject = new LinkedHashMap<>();
				try {
						List<Object> paymentHistoryList = paymentService.getPaymentHistory(customerId,paymentSeq);
						responseObject.put("paymentHistoryList",paymentHistoryList);
						responseObject.put(STATUS,SUCCESS);
						return responseObject;
					} catch (Exception e) {
						LOGGER.error(ERROR + e);
						responseObject.put(STATUS,ERROR);
						return responseObject;
				}
			}
			
			@RequestMapping(value="/checkNoteExist", method = RequestMethod.POST)
			public Map<String, Object> checkNoteExist(int customer_id, int payment_seq) {
				Map<String, Object> responseObject = new LinkedHashMap<>();
				
				try{
					Boolean checkStatus =  paymentService.checkNoteExist(customer_id,payment_seq);
					responseObject.put("checkStatus", checkStatus);
					return responseObject;
				} catch (Exception e) {
					LOGGER.error(ERROR + e);
					responseObject.put(STATUS,ERROR);
					return responseObject;
				}
			}
			
			@RequestMapping(value="/orderItemAccountInfo",method=RequestMethod.POST)
					public Map<String,Object> getOrderInformation(int orderhdr_id,int order_item_seq) {
				Map<String, Object> responseObject = new LinkedHashMap<String,Object>();
				try {
					List<Map<String,Object>> orderItemAccountInfo=paymentService.getOrderInformation(orderhdr_id,order_item_seq);
					List<OrderItemAccountModel> orderAccBreakType=paymentService.getorderAccBreakType(orderhdr_id,order_item_seq);
					responseObject.put("orderItemAccountInfo",orderItemAccountInfo);
					responseObject.put("orderAccBreakType",orderAccBreakType);
					return responseObject;
				}catch(Exception e) {
					LOGGER.error(ERROR + e);
					responseObject.put(STATUS,ERROR);
					return responseObject;
				}
			}
	@RequestMapping(value="/addCustomerDistAddress",method=RequestMethod.POST)
		public Map<String,Object> addCustomerDistAddress(int customer_id,int customer_address_seq) {
			Map<String, Object> responseObject = new LinkedHashMap<String,Object>();
			try {
				List<Map<String, Object>> distributionCustomerAddrs=paymentService.getDistributionCustomerAddrs(customer_id,customer_address_seq);
				List<Map<String, Object>>  addCustomerDist=paymentService.getAddCustomerDistAddress(customer_id);
				responseObject.put("distributionCustomerAddrs", distributionCustomerAddrs);
				responseObject.put("addCustomerDist", addCustomerDist);
				
				 return responseObject;
			}catch(Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
			}
		}
		@RequestMapping(path="/thresholdSettingOptionsWSDL",method = RequestMethod.POST)	
		public Map<String, Object> thresholdSettingOptionsWSDL( int oc_id,int order_code_id,int customer_id, String currency, 
				BigDecimal item_amount, BigDecimal total_amount_paid_on_item,BigDecimal total_amount_paid_this_payment,
				BigDecimal amount_to_apply){
			     Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			
			     try {
			    List<ThresholdOption[][]> Threshold_option = new PaymentWsdl().thresholdOptionsWsdl(oc_id,order_code_id, customer_id, currency, 
						item_amount, total_amount_paid_on_item, total_amount_paid_this_payment,amount_to_apply);
			   	responseObject.put("thresholdOption", Threshold_option);
			     }
			    catch (Exception e) {
				LOGGER.error(ERROR + e);
				 responseObject.put(STATUS,ERROR+e);
				 
			}
			return responseObject;
		} 

	// Threshold creation
	@RequestMapping(path = "/thresholdOptions", method = RequestMethod.POST)
	public Map<String, Object> thresholdOptions(float item_amount, float amount_to_apply) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		String status = null;
		boolean allButtonEnable = false;
		String message = null;
		try {

			// item_amount is total amount
			float dividedAmount = amount_to_apply / item_amount;
			float percentage = dividedAmount * 100;

			List<Map<String, Object>> paymentThresholdList = jdbcTemplate.queryForList("select * from payment_threshold");
					
			int percent_over = Integer.parseInt(paymentThresholdList.get(0).get("percent_over").toString());
			int percent_partial = Integer.parseInt(paymentThresholdList.get(0).get("percent_partial").toString());
			int percent_under = Integer.parseInt(paymentThresholdList.get(0).get("percent_under").toString());
			boolean underPaymentOverride = Boolean.parseBoolean(paymentThresholdList.get(0).get("under_payment_override").toString());//Malini 13/3/2020
			boolean overPaymentOverride = Boolean.parseBoolean(paymentThresholdList.get(0).get("over_payment_override").toString());
			int percent_refund = Integer.parseInt(paymentThresholdList.get(0).get("percent_refund").toString());
			
			int finalPercent = (int) percentage;
			// I have to check amount_to_apply fulfill which condition
			responseObject.put("underPaymentFieldActive", underPaymentOverride);
			responseObject.put("overPaymentFieldActive", overPaymentOverride);
			if (finalPercent == 100) {
				message = "Payment has been paid successfully";
				responseObject.put("message", message);
			}
			if (finalPercent < percent_over) {
				
				if (finalPercent < percent_partial) {
					status = "partial";
					responseObject.put("status", status);
					allButtonEnable = false;
					responseObject.put("allButtonEnable", allButtonEnable);
					
				}
				
				if (finalPercent >= percent_partial && finalPercent < percent_under) {
					status = "partial";
					responseObject.put("status", status);
					
					allButtonEnable = true;
					responseObject.put("allButtonEnable", allButtonEnable);
				}
				if (amount_to_apply < item_amount && status == null) {
					message = "The underpayment is within threshold values. It will be treated as full payment.";
					responseObject.put("message", message);
				} else if (amount_to_apply > item_amount && status == null) {
					message = "The overpayment is within threshold values. It will be treated as full payment.";
					responseObject.put("message", message);
				}
			} else {
				
				// if percentage is >= percent_refund
				if (finalPercent >= percent_refund) {
					status = "refund";
					responseObject.put("status", status);
					allButtonEnable = false;
					responseObject.put("allButtonEnable", allButtonEnable);
				}
				// if percentage is >= percent_over and < percent_refund
				if (finalPercent >= percent_over && finalPercent < percent_refund) {
					status = "refund";
					responseObject.put("status", status);
					allButtonEnable = true;
					responseObject.put("allButtonEnable", allButtonEnable);
				}
			}
			responseObject.put("item_amount", item_amount);
			responseObject.put("amount_to_apply", amount_to_apply);
			responseObject.put("percentage", finalPercent);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
		}
		return responseObject;
	}
		
		@RequestMapping(path="/paymentAccountChange",method = RequestMethod.POST)	
		public Map<String, Object> OnpaymentAccountChange(int payment_account_seq, int payerCustomer){
			     Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			     
			     List<Map<String, Object>> defaultvalues;
			     List<Map<String, Object>> PaymentAccountDetails;
			     try {
				defaultvalues = jdbcTemplate.queryForList("select is_active,credit_card_expire,credit_card_start_date,credit_card_info,credit_card_issue_id,"
						+ "card_verification_value," + 
						"  bill_to_customer_id,bill_to_customer_address_seq,bank_account_type,dd_sorting_code,payment_type,id_nbr_last_four, " + 
						"  branch_title,creation_date,expiry_notice_sent_date,secure_store_id_obtained_date, secure_bank_def_id from payment_account where payment_account_seq =" +payment_account_seq);
				 
				List<DropdownModel> paymentList=paymentService.getPaymentType();
				 
//			  PaymentAccountDetails = jdbcTemplate.queryForList("select credit_card_info,payment_type,payment_account_seq,description,id_nbr_last_four from payment_account where payment_account_seq = " +payment_account_seq);;
//					responseObject.put("PaymentAccountDetails", PaymentAccountDetails);
				
				List<DropdownModel> paymentAccountList = paymentService.getpaymentAccountList(payerCustomer);
				responseObject.put("paymentAccountList", paymentAccountList);
				 
				responseObject.put("PaymentTypeList", paymentList);
				responseObject.put("defaultvalues", defaultvalues);
			     }
			    catch (Exception e) {
				LOGGER.error(ERROR + e);
				 responseObject.put(STATUS,ERROR+e);
				 
			}
			return responseObject;
		} 
		
		@RequestMapping(path="/PayerCustomerChange",method = RequestMethod.POST)	
		public Map<String, Object> OnpaymentAccountChange( int payerCustomer){
			     Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			     try {
				
				List<DropdownModel> paymentAccountList = paymentService.getpaymentAccountList(payerCustomer);
				responseObject.put("paymentAccountList", paymentAccountList);
				 
			     }
			    catch (Exception e) {
				LOGGER.error(ERROR + e);
				 responseObject.put(STATUS,ERROR+e);
				 
			}
			return responseObject;
		}

		@RequestMapping(value="/reviewAccountingJournal",method=RequestMethod.POST)
		public Map<String,Object> getReviewAccountJournal(int order_item_seq,int orderhdr_id) {
		Map<String, Object> responseObject = new LinkedHashMap<String,Object>();
			try {
				List<PaymentReview> reviewDetails= paymentService.getReviewAccountJournal(order_item_seq,orderhdr_id);
				responseObject.put("reviewDetails",reviewDetails);
				return responseObject;
			} catch(Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
			}
		}
		
		
		@RequestMapping(value="/reviewPaymentsOrderItemDetails",method=RequestMethod.POST)
		public Map<String,Object> getReviewOrderItemDetails(int orderhdr_id,int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<String,Object>();
			try {
				 List<Map<String,Object>> reviewPaymentsOrderItemDetails= paymentService.getReviewOrderItemDetails(orderhdr_id,orderItemSeq);
				responseObject.put("reviewPaymentsOrderItemDetails",reviewPaymentsOrderItemDetails);
				return responseObject;
			} catch(Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
			}
		}

		@RequestMapping(path="/viewPaymentBreakdownBasedOnOrderCode",method = RequestMethod.POST)
		public Map<String, Object> paymentBreakdownBasedOnOrderCode(int orderhdr_id, int order_item_seq){
			 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			 try {
				 List<PaybreakModel> Details= paymentService.getpaymentBreakdownBasedOnOrderCode(orderhdr_id,order_item_seq);
					responseObject.put("PaymentBreakDownBasedOnOrderCode",Details); 
				 
					return responseObject;
				 
			 } catch(Exception e) {
					LOGGER.error(ERROR + e);
					responseObject.put(STATUS,ERROR);
					return responseObject;
				}
		

		}
		
		@RequestMapping(path="/OnPaymentTypeChanged",method = RequestMethod.POST)
		public Map<String, Object> OnPaymentTypeChanged(String payment_type,int payerCustomer){
			 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			 try {
				  List<DropdownModel> paymentList=	paymentService.getPaymentType();
					responseObject.put("PaymentTypeList", paymentList);
					
					List<DropdownModel> paymentAccountList = paymentService.getpaymentAccountList(payerCustomer);
					responseObject.put("paymentAccountList", paymentAccountList);
					
					 List<Map<String, Object>> defaultvalues = paymentService.getDefaultValuesOnPaymentTypeChange(payment_type,payerCustomer);
					 responseObject.put("defaultvalues", defaultvalues);
				 
					return responseObject;
				 
			 } catch(Exception e) {
					LOGGER.error(ERROR + e);
					responseObject.put(STATUS,ERROR);
					return responseObject;
				}
		

		}
		
		@RequestMapping(path="/onChangeOfPaymentType",method = RequestMethod.POST)
		public Map<String, Object> onChangePaymentType(int paymentForm){
			 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
			 String pmtClearStatus=null;
			 List<DropdownModel> transactionStatusList = new ArrayList<>();
			 try {
				 if (paymentForm ==1 || paymentForm== 4 || paymentForm==6 ||paymentForm==7||paymentForm==8||paymentForm==9)
						 {
						 pmtClearStatus = new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_2");
						 responseObject.put("pmtClearStatus",pmtClearStatus);
								DropdownModel transactionStatus = new DropdownModel();
								transactionStatus.setKey(""+2);
								transactionStatus.setDisplay(new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_"+2));
								transactionStatusList.add(transactionStatus);
								responseObject.put("transactionStatusList",transactionStatusList);
							}
						  else {
						 pmtClearStatus = new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_3");
						 responseObject.put("pmtClearStatus",pmtClearStatus);
						 DropdownModel transactionStatus = new DropdownModel();
								transactionStatus.setKey(""+3);
								transactionStatus.setDisplay(new PropertyUtilityClass().getConstantValue("payment_satus.payment_clear_status_"+3));
								transactionStatusList.add(transactionStatus);
								responseObject.put("transactionStatusList",transactionStatusList);
							}
						
				return responseObject;
							 
			 } catch(Exception e) {
					LOGGER.error(ERROR + e);
					responseObject.put(STATUS,ERROR);
					return responseObject;
				}
		

		}
		

}