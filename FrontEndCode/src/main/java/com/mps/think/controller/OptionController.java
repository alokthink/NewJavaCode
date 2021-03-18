package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.option.model.SupplementalRefund;
import com.mps.think.service.CustomerSearchService;
import com.mps.think.service.OrderPaymentService;
import com.mps.think.service.PaymentService;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
@RestController
public class OptionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OptionController.class);
	private static final String ERROR = "Error"; 
	
	@Autowired
	OrderPaymentService service;
	
	@Autowired 
	PaymentService paymentService;
	 
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	CustomerSearchService customerSearchService;
	@PostMapping(path= "/supplementalRefund")
	public Map<String, Object> getSupplementalRefund(Integer orderHdrId, Integer orderItemSeq, String action, Integer customerId, Integer active){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> supplementalRefundDetails = new ArrayList<>();
		List<DropdownModel> currencyList = new ArrayList<>();
		List<DropdownModel> paymentTypeList = new ArrayList<>();
		List<DropdownModel> transactionReasonList =	new ArrayList<>();
		List<DropdownModel> paymentAccountList =	new ArrayList<>();
		try {
			 supplementalRefundDetails = service.getSupplementalRefundDetails(orderHdrId,orderItemSeq);
			 if(customerId != null && (active != null | active != 0)) {
				 paymentAccountList = service.getPaymentAccountList(customerId, active);
			 }
			 if(supplementalRefundDetails.size() != 0) {
				 String paymentForm = supplementalRefundDetails.get(0).get("payment_form").toString();
				 Integer payment_form[] = {1,7};
				 List<Integer> listOfPaymentForm = Arrays.asList(payment_form);
				 //because user has no credit and debit card, then use_payment_account will be disabled.
				 if(paymentAccountList.size() == 0) {
					 supplementalRefundDetails.get(0).putIfAbsent("use_payment_acount_checked",false);//it will enabled only in credit case
					 supplementalRefundDetails.get(0).putIfAbsent("use_payment_acount_enable",false);
					 supplementalRefundDetails.get(0).putIfAbsent("refund_deposit_account_enable", true); 
				 } else if(listOfPaymentForm.contains(Integer.valueOf(paymentForm))) {//when user has paid through credit card
					 supplementalRefundDetails.get(0).putIfAbsent("use_payment_acount_checked",true);
					 supplementalRefundDetails.get(0).putIfAbsent("use_payment_acount_enable",false);
					 supplementalRefundDetails.get(0).putIfAbsent("refund_deposit_account_enable", false);
				 }else{
					 //when user has paid through cash and debit card
					 supplementalRefundDetails.get(0).putIfAbsent("use_payment_acount_checked",false);
					 supplementalRefundDetails.get(0).putIfAbsent("use_payment_acount_enable",true);
					 supplementalRefundDetails.get(0).putIfAbsent("refund_deposit_account_enable", true);
				 }
				
				 responseObject.put("supplementalRefundDetails", supplementalRefundDetails) ;
				 currencyList = service.getCurrencyType();
				 responseObject.put("currencyList", currencyList); 
				 paymentTypeList = paymentService.getPaymentType();
				 
				 String defualtPaymentType=paymentService.getDefaultPaymentType();
				  	   
					for (DropdownModel i : paymentTypeList) {
						DropdownModel model=new DropdownModel();
						i.getKey().equals(defualtPaymentType);
						model.setKey(i.getKey());
						model.setDescription(i.getDescription());
						responseObject.put("defautPaymentType", model);
					}
				 
				 responseObject.put("paymentAccountList", paymentAccountList);
				 responseObject.put("paymentTypeList", paymentTypeList);
				 transactionReasonList = service.getTransactionReasonByReasonType(action);
				 responseObject.put("transactionReasonList", transactionReasonList) ;
				 responseObject.put(STATUS, SUCCESS);
			 }else {
				 //String message = "There are no non-reversed payments for this order item. Cannot create a refund for this order.";
				 String message = "Business logic exception detected: CFFF01E3: Cannot give a supplemental refund on an order that currently has no money applied to it.";
				 responseObject.put("ApplicationErrorDetected", message);
				 responseObject.put(STATUS, SUCCESS);
			 }
			 
			 return responseObject;
		}catch (Exception e) {
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		}
	}
	@PostMapping("/refundCardDetail")
	public Map<String, Object> getRefundCardDetail(int paymentAccountSeq, int idNbrLastFour) {
		Map<String, Object> responseObject = new HashMap<>();
		List<DropdownModel> refundCardDetail = new ArrayList<>();
		try {

			refundCardDetail = service.getRefundCardDetails(paymentAccountSeq, idNbrLastFour);
			if (refundCardDetail.size() != 0) {
				responseObject.put("refundCardDetail", refundCardDetail);
				responseObject.put(STATUS, true);
			} else {
				responseObject.put("refundCardDetail", refundCardDetail);
				responseObject.put(STATUS, false);
			}
		
		}catch (Exception e) {
			LOGGER.info("Error in getRefundCardDetail() : " + e);
			responseObject.put(STATUS, ERROR + e);
		}
		return responseObject;

	}
	@PostMapping("/saveSupplementalRefund")
	public Map<String, Object> saveSupplementalRefund(SupplementalRefund payment) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {

			status = service.saveSupplementalRefund(payment);
			if (status != 0) {
				responseObject.put(STATUS, SUCCESS);
			} else {
				responseObject.put(STATUS, ERROR);
			}
		return responseObject;
		}catch (Exception e) {
			LOGGER.info("Error in saveSupplementalRefund() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}


@RequestMapping(value="/serviceAuxiliary", method = RequestMethod.POST)
public Map<String, Object> ServiceAuxiliaryAdd(@RequestParam("customerId") Long customerId,@RequestParam("serviceSeq")int serviceSeq)

{
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	LinkedHashMap<String, String> map = null;
	List<Map<String, String>> finalMap = new ArrayList<Map<String,String>>(); 
	try {
		List<CustomerAuxiliaryModel> auxiliaryFormField = service.getServiceAuxiliaryFormField();
		new PropertyUtilityClass().appendDefaultDateInAuxiliaryFields(auxiliaryFormField);
		responseObject.put("auxiliaryformfeild", auxiliaryFormField);
		LinkedHashMap<String, String> serviceAuxiliaryDetail = service.setServiceAuxiliaryDetailByID(customerId, serviceSeq);
		//Getting the Set of entries 
        Set<Entry<String, String>> entrySet = serviceAuxiliaryDetail.entrySet(); 
        //Creating an ArrayList Of Entry objects 
        List<Entry<String, String>> auxiliaryFieldDetails = new ArrayList<Entry<String,String>>(entrySet); 
        int length = auxiliaryFieldDetails.size();
        for(int i=0;i<length;i++) {
        	map = new LinkedHashMap<String, String>();
        		if(auxiliaryFormField.get(i).getColumnName().equals(auxiliaryFieldDetails.get(i).getKey())) {
        			if(auxiliaryFieldDetails.get(i).getValue() == null) {// to set default value for date column
        				map.put(auxiliaryFieldDetails.get(i).getKey(), auxiliaryFormField.get(i).getDefaultValue());
        		   }else {
        			map.put(auxiliaryFieldDetails.get(i).getKey(), auxiliaryFieldDetails.get(i).getValue());
        		   }
        			if(auxiliaryFormField.get(i).getColumnDatatype().equalsIgnoreCase("Numeric") ) {
        				if(auxiliaryFieldDetails.get(i).getValue()!=null) {
        					String value = auxiliaryFieldDetails.get(i).getValue();
        					String finalValue = new PropertyUtilityClass().removeZeroFromAuxiliary(value);
            				map.put(auxiliaryFieldDetails.get(i).getKey(), finalValue);
        				}
        			}
        			map.put("columnDatatype", auxiliaryFormField.get(i).getColumnDatatype());
        			map.put("columnLength", auxiliaryFormField.get(i).getColumnLength());
        			map.put("columnPrecision", auxiliaryFormField.get(i).getColumnPrecision());
        			finalMap.add(map);
        		}
        }
        responseObject.put("serviceAuxiliaryDetail", finalMap);
		responseObject.put("customerId", customerId);
		responseObject.put("serviceSeq", serviceSeq);
		responseObject.put(STATUS,SUCCESS);
		return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
	}
}
@RequestMapping(value="/serviceAuxiliarySubmit", method = RequestMethod.POST)
public Map<String, Object> ServiceAuxiliaryAddSubmit(HttpServletRequest request)

{
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	try {
		String status = service.saveServiceAuxiliary(request);
		if(ERROR.equals(status))
			responseObject.put(STATUS, ERROR);
		else {
			responseObject.put(STATUS, SUCCESS);
		}
		return responseObject;
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		responseObject.put(STATUS,ERROR);
		return responseObject;
	}

}	
@RequestMapping(path="/showReviewJobHistoryButton", method = RequestMethod.POST )
public Map<String,Object> showReviewJobHistory(long jobId){
	Map<String,Object> responseObject = new LinkedHashMap<>();
	try {
		Map<String,Object>  results = service.showReviewJobHistoryButton(jobId);
		if(results.isEmpty()) {
			responseObject.put("results", results);
			responseObject.put(STATUS, SUCCESS);
		}else {
			responseObject.put("results", results);
			responseObject.put(STATUS, SUCCESS);
		}
		return responseObject;
	}catch(Exception e) {
		LOGGER.info(ERROR + e);
		responseObject.put(STATUS, ERROR);
		return responseObject;
	}
	    	
}


@RequestMapping(value="/paymentAuxiliary", method = RequestMethod.POST)
public Map<String, Object>  paymentAuxiliaryAdd(Long customerId,Integer paymentSeq)

{
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	LinkedHashMap<String, String> map = null;
	List<Map<String, String>> finalMap = new ArrayList<Map<String,String>>(); 
	try {
		String action = "payment";
		List<CustomerAuxiliaryModel> auxiliaryFormField = service.getAuxiliaryFields(action);
		new PropertyUtilityClass().appendDefaultDateInAuxiliaryFields(auxiliaryFormField);
		responseObject.put("auxiliaryformfeild", auxiliaryFormField);
		if(paymentSeq==null) {
			Integer seq = jdbcTemplate.queryForObject("select max(payment_seq) from payment where customer_id="+customerId, Integer.class);
			paymentSeq = seq;
		}
		LinkedHashMap<String, String> auxiliaryDetail = service.setPaymentAuxiliaryDetailByID(customerId, paymentSeq);
		//Getting the Set of entries 
        Set<Entry<String, String>> entrySet = auxiliaryDetail.entrySet(); 
        //Creating an ArrayList Of Entry objects 
        List<Entry<String, String>> paymentAuxiliaryDetail = new ArrayList<Entry<String,String>>(entrySet); 
        int length = paymentAuxiliaryDetail.size();
        for(int i=0;i<length;i++) {
        	map = new LinkedHashMap<String, String>();
        		if(auxiliaryFormField.get(i).getColumnName().equals(paymentAuxiliaryDetail.get(i).getKey())) {
        			if(paymentAuxiliaryDetail.get(i).getValue() == null) {// to set default value for date column
        				map.put(paymentAuxiliaryDetail.get(i).getKey(), auxiliaryFormField.get(i).getDefaultValue());
        		   }else {
        			map.put(paymentAuxiliaryDetail.get(i).getKey(), paymentAuxiliaryDetail.get(i).getValue());
        		   }
        			if(auxiliaryFormField.get(i).getColumnDatatype().equalsIgnoreCase("Numeric") ) {
        				if(paymentAuxiliaryDetail.get(i).getValue()!=null) {
        					String value = paymentAuxiliaryDetail.get(i).getValue();
        					String finalValue = new PropertyUtilityClass().removeZeroFromAuxiliary(value);
            				map.put(paymentAuxiliaryDetail.get(i).getKey(), finalValue);
        				}
        			}
        			map.put("columnDatatype", auxiliaryFormField.get(i).getColumnDatatype());
        			map.put("columnLength", auxiliaryFormField.get(i).getColumnLength());
        			map.put("columnPrecision", auxiliaryFormField.get(i).getColumnPrecision());
        			finalMap.add(map);
        		}
        }
        responseObject.put("paymentAuxiliaryDetail", finalMap);
		responseObject.put("customerId", customerId);
		responseObject.put("paymentSeq", paymentSeq);	
		responseObject.put(STATUS,SUCCESS);
		return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
	}
}
@RequestMapping(value="/paymentAuxiliarySubmit", method = RequestMethod.POST)
public Map<String, Object> paymentAuxiliaryAddSubmit(HttpServletRequest request)

{
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	try {
		int status = service.savePaymentAuxiliaryFieldsDetails(request);
		if(status ==0)
			responseObject.put(STATUS, ERROR);
		else {
			responseObject.put(STATUS, SUCCESS);
		}
		return responseObject;
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		responseObject.put(STATUS,ERROR);
		return responseObject;
	}

}	

@RequestMapping(value="/customerLoginAuxiliary", method = RequestMethod.POST)
public Map<String, Object>  customerLoginAuxiliaryAdd(@RequestParam("customerId") Long customerId, Integer customerLoginId){
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	LinkedHashMap<String, String> map = null;
	List<Map<String, String>> finalMap = new ArrayList<Map<String,String>>(); 
	try {
		String action = "customer_login";
		List<CustomerAuxiliaryModel> auxiliaryFormField = service.getAuxiliaryFields(action);
		new PropertyUtilityClass().appendDefaultDateInAuxiliaryFields(auxiliaryFormField);
		responseObject.put("auxiliaryformfeild", auxiliaryFormField);
		/*
		 if user wants to create new record for auxiliary then user will send "" or 0 
		 customerLoginId will get max customer login id from table based on customer id
		 */
		if(customerLoginId==null) {
			Integer customerLogin_Id = jdbcTemplate.queryForObject("select max(customer_login_id) from customer_login where customer_id="+customerId, Integer.class);
			customerLoginId = customerLogin_Id;
		}
		LinkedHashMap<String, String> serviceAuxiliaryDetail = service.setCustomerLoginAuxiliaryDetailByID(customerLoginId);
		//Getting the Set of entries 
        Set<Entry<String, String>> entrySet = serviceAuxiliaryDetail.entrySet(); 
        //Creating an ArrayList Of Entry objects 
        List<Entry<String, String>> auxiliaryFieldDetails = new ArrayList<Entry<String,String>>(entrySet); 
        int length = auxiliaryFieldDetails.size();
        for(int i=0;i<length;i++) {
        		map = new LinkedHashMap<String, String>();
        		if(auxiliaryFormField.get(i).getColumnName().equals(auxiliaryFieldDetails.get(i).getKey())) {
        			if(auxiliaryFieldDetails.get(i).getValue() == null) {// to set default value for date column
        				map.put(auxiliaryFieldDetails.get(i).getKey(), auxiliaryFormField.get(i).getDefaultValue());
        		   }else {
        			map.put(auxiliaryFieldDetails.get(i).getKey(), auxiliaryFieldDetails.get(i).getValue());
        		   }
        			if(auxiliaryFormField.get(i).getColumnDatatype().equalsIgnoreCase("Numeric") ) {
        				if(auxiliaryFieldDetails.get(i).getValue()!=null) {
        					String value = auxiliaryFieldDetails.get(i).getValue();
        					String finalValue = new PropertyUtilityClass().removeZeroFromAuxiliary(value);
            				map.put(auxiliaryFieldDetails.get(i).getKey(), finalValue);
        				}
        			}
        			map.put("columnDatatype", auxiliaryFormField.get(i).getColumnDatatype());
        			map.put("columnLength", auxiliaryFormField.get(i).getColumnLength());
        			map.put("columnPrecision", auxiliaryFormField.get(i).getColumnPrecision());
        			finalMap.add(map);
        		}
        }
        responseObject.put("customerLoginDetail", finalMap);
		responseObject.put("customerId", customerId);
		responseObject.put("customerLoginId", customerLoginId);
		responseObject.put(STATUS,SUCCESS);
		return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
	}
}
@RequestMapping(value="/customerLoginAuxiliarySubmit", method = RequestMethod.POST)
public Map<String, Object> customerLoginAuxiliaryAddSubmit(HttpServletRequest request){
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	try {
		int status = service.saveCustomerLoginAuxiliaryFieldsDetails(request);
		if(status == 0)
			responseObject.put(STATUS, ERROR);
		else {
			responseObject.put(STATUS, SUCCESS);
		}
		return responseObject;
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		responseObject.put(STATUS,ERROR);
		return responseObject;
	}

}
@RequestMapping(value="/customerAddressAuxiliary", method = RequestMethod.POST)
public Map<String, Object>  customerAddressAuxiliaryAdd(@RequestParam("customerId") Long customerId,@RequestParam("customerAddressSeq")Integer customerAddressSeq){
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	LinkedHashMap<String, String> map = null;
	List<Map<String, String>> finalMap = new ArrayList<Map<String,String>>(); 
	try {
		String action = "customer_address";
		List<CustomerAuxiliaryModel> auxiliaryFormField = service.getAuxiliaryFields(action);
		new PropertyUtilityClass().appendDefaultDateInAuxiliaryFields(auxiliaryFormField);
		responseObject.put("auxiliaryformfeild", auxiliaryFormField);
		if(customerAddressSeq==null) {
			Integer seq = jdbcTemplate.queryForObject("select max(customer_address_seq) from customer_address where customer_id="+customerId, Integer.class);
			customerAddressSeq = seq;
		}
		LinkedHashMap<String, String> serviceAuxiliaryDetail = service.setCustomerAddressAuxiliaryDetailByID(customerId, customerAddressSeq);
		//Getting the Set of entries 
        Set<Entry<String, String>> entrySet = serviceAuxiliaryDetail.entrySet(); 
        //Creating an ArrayList Of Entry objects 
        List<Entry<String, String>> auxiliaryFieldDetails = new ArrayList<Entry<String,String>>(entrySet); 
        int length = auxiliaryFieldDetails.size();
        for(int i=0;i<length;i++) {
        		map = new LinkedHashMap<String, String>();
        		if(auxiliaryFormField.get(i).getColumnName().equals(auxiliaryFieldDetails.get(i).getKey())) {
        			if(auxiliaryFieldDetails.get(i).getValue() == null) {// to set default value for date column
        				map.put(auxiliaryFieldDetails.get(i).getKey(), auxiliaryFormField.get(i).getDefaultValue());
        		   }else {
        			map.put(auxiliaryFieldDetails.get(i).getKey(), auxiliaryFieldDetails.get(i).getValue());
        		   }
        			if(auxiliaryFormField.get(i).getColumnDatatype().equalsIgnoreCase("Numeric") ) {
        				if(auxiliaryFieldDetails.get(i).getValue()!=null) {
        					String value = auxiliaryFieldDetails.get(i).getValue();
        					String finalValue = new PropertyUtilityClass().removeZeroFromAuxiliary(value);
            				map.put(auxiliaryFieldDetails.get(i).getKey(), finalValue);
        				}
        			}
        			map.put("columnDatatype", auxiliaryFormField.get(i).getColumnDatatype());
        			map.put("columnLength", auxiliaryFormField.get(i).getColumnLength());
        			map.put("columnPrecision", auxiliaryFormField.get(i).getColumnPrecision());
        			finalMap.add(map);
        		}
        }
        responseObject.put("customerAddressDetail", finalMap);
		responseObject.put("customerId", customerId);
		responseObject.put("customerAddressSeq", customerAddressSeq);
		responseObject.put(STATUS,SUCCESS);
		return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR); 
			return responseObject;
	}
}
@RequestMapping(value="/customerAddressAuxiliarySubmit", method = RequestMethod.POST)
public Map<String, Object> customerAddressAuxiliaryAddSubmit(HttpServletRequest request){
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	try {
		int status = service.saveCustomerAddressFieldsDetails(request);
		if(status == 0)
			responseObject.put(STATUS, ERROR);
		else {
			responseObject.put(STATUS, SUCCESS);
		}
		return responseObject;
	} catch (Exception e) {
		LOGGER.error(ERROR + e);
		responseObject.put(STATUS,ERROR);
		return responseObject;
	}

}

	@PostMapping(value = "/currencyConversion")
	public Map<String, Object> currencyConvertedAmount(long orderhdrId, int orderItemSeq, String currency) {
		Map<String, Object> responseObject = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> amountList = service.getAmountToCurrencyConversion(orderhdrId, orderItemSeq);
			if (amountList == null) {
				responseObject.put(STATUS, ERROR);
			}else {
					String amount = amountList.get(0).get("amount").toString();
					if(currency != null && !currency.isEmpty()) {
						float convertedAmount = service.covertedAmountByCurrency(Float.valueOf(amount), currency);
						responseObject.put("convertedAmount", convertedAmount);
						responseObject.put("currency", currency);
						responseObject.put(STATUS, SUCCESS);
				}else {
					String msg = "currency can not be null or blank";
					responseObject.put("currency", msg);
					throw new Exception("currency:"+msg);
					
				}
				
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

}

