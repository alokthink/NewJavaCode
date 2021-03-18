package com.mps.think.orderFunctionality.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mps.think.orderFunctionality.service.PaymentFunctionalityService;
	
	@RestController
	public class PaymentFunctionalityController {
		
		private static Gson gson = new GsonBuilder().serializeNulls().create();
		private static final Logger LOGGER = LoggerFactory.getLogger(OrderFunctionalityController.class);

		@Autowired
		PaymentFunctionalityService paymentFunctionalityService;
		
		@RequestMapping(path = "/gatewayLogCustomer", method = RequestMethod.POST)
		public Map<String, Object> getGatewayLogCustomer(int customerId){
			Map<String, Object> responseObject = new LinkedHashMap<>();
			List<Map<String, Object>> gatewayLogCustomer = new ArrayList<>();
			try {
				gatewayLogCustomer = paymentFunctionalityService.getGatewayLogCustomer(customerId);
			    responseObject.put("gatewayLogCustomer", gatewayLogCustomer);
			    responseObject.put(STATUS, SUCCESS);
			    return responseObject;
			}catch(Exception e) {
				LOGGER.info("Error in getGatewayLogCustomer :" + e );
				responseObject.put(STATUS, ERROR + e);
				return responseObject;
			}
		}
		@RequestMapping(path = "/gatewayLogSelectedPayment", method = RequestMethod.POST)
		public Map<String, Object> getGatewayLogSelectedPayment(int customerId, int paymentSeq){
			Map<String, Object> responseObject = new LinkedHashMap<>();
			List<Map<String, Object>> gatewayLogSelectedPayment = new ArrayList<>();
			try {
				gatewayLogSelectedPayment = paymentFunctionalityService.getGatewayLogSelectedPayment(customerId, paymentSeq);
			    responseObject.put("gatewayLogSelectedPayment", gatewayLogSelectedPayment);
			    responseObject.put(STATUS, SUCCESS);
			    return responseObject;
			}catch(Exception e) {
				LOGGER.info("Error in getGatewayLogSelectedPayment :" + e );
				responseObject.put(STATUS, ERROR + e);
				return responseObject;
			}
		}
		
		@RequestMapping(path = "/deleteGatewayLog", method = RequestMethod.POST)
		public Map<String, Object> deleteGatewayLog(String icsRefNum) {
			Map<String, Object> responseObject = new HashMap<>();
			int status = 0;
			try {
				status = paymentFunctionalityService.deleteGatewayLog(icsRefNum);
				if (status == 0) {
					responseObject.put(STATUS, false);
				} else {
					responseObject.put(STATUS, true);
				}
				return responseObject;

			} catch (Exception e) {
				LOGGER.info("Error in deleteGatewayLog : " + e);
				responseObject.put(STATUS, ERROR + e);
				return responseObject;
			}
		}
	}	
	  