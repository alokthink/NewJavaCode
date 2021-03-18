package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.model.AgencyAttributeModel;
import com.mps.think.model.CustomerAddAttributeModel;
import com.mps.think.service.AgencyService;
import com.mps.think.service.CustomerSearchService;

@RestController
public class AgencyController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AgencyController.class);
		
	@Autowired
	AgencyService agencyService;
	
	@Autowired
	CustomerSearchService customerSearchService;

	@RequestMapping(path="/agencies", method = RequestMethod.POST)
	public Map<String, Object> agencies(){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			responseObject.put("agencyList", agencyService.getAgencyList());
			AgencyAttributeModel agencyAttributeModel = new AgencyAttributeModel();
			responseObject.put("AgencySearch", agencyAttributeModel);
			responseObject.put("PaymentThresholdList", customerSearchService.getpaymentThresholdList());
			responseObject.put(STATUS,SUCCESS);
			return responseObject;	
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR+e);
				return responseObject;
		}	
	}
	
	@RequestMapping(path = "/agenciesSearch", method = RequestMethod.POST)
	public Map<String, Object> agencySearch(AgencyAttributeModel agencyAttributeModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			responseObject.put("agencyList",agencyService.getAgencySearch(agencyAttributeModel));
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/editAgency", method = RequestMethod.POST)
	public Map<String, Object> editAgency(AgencyAttributeModel agencyAttributeModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = agencyService.editAgency(agencyAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS,SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/addAgency", method = RequestMethod.POST)
	public  Map<String, Object> addagency(){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			CustomerAddAttributeModel customerAddAttributeModel = new CustomerAddAttributeModel();
			customerAddAttributeModel.setStateList(customerSearchService.getStateList());
			customerAddAttributeModel.setAddressTypeList(customerSearchService.getaddressType());
			customerAddAttributeModel.setListRentalList(customerSearchService.getlistRental());
			customerAddAttributeModel.setCustomerCategoryList(customerSearchService.getcustomerCategory());
			customerAddAttributeModel.setSalesRepresentativeList(customerSearchService.getsalesRepresentative());
			customerAddAttributeModel.setAddressStatusList(customerSearchService.getaddressStatus());
			customerAddAttributeModel.setCreditStatusList(customerSearchService.getcreditStatus());
			customerAddAttributeModel.setTaxFilterList(customerSearchService.gettaxFilter());
			customerAddAttributeModel.setPaymentThersholdList(customerSearchService.getpaymentThresholdList());
			customerAddAttributeModel.setAddressType(customerSearchService.getdefaultAddressType());
			customerAddAttributeModel.setListRental(customerSearchService.getdefaultListRental());
			customerAddAttributeModel.setAddressStatus(customerSearchService.getdefaultAddressStatus());
			customerAddAttributeModel.setCreditStatus(customerSearchService.getdefaultCreditStatus());
			responseObject.put("AgencyAdd", customerAddAttributeModel);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR+e);
				return responseObject;
		}
	}
	
	@RequestMapping(path="/addAgencySubmit", method = RequestMethod.POST)
	public Map<String, Object> addagencySubmit(CustomerAddAttributeModel customerAddAttributeModel){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerSearchService.addCustomer(customerAddAttributeModel);	
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else
				responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}	
	}
}
