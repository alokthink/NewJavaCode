package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

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

import com.mps.think.model.CustomerLoginModel;
import com.mps.think.model.DistributionAttributeModel;
import com.mps.think.model.DistributionMethodModel;
import com.mps.think.model.DistributionValueModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.service.CustomerLoginService;
import com.mps.think.util.CustomerUtility;


@RestController
public class CustomerLoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerSearchController.class);
	
	@Autowired
	CustomerLoginService customerLoginService;
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
	
	@RequestMapping(path = "/customerLoginDetails", method = RequestMethod.POST)
	public Map<String, Object> customerLoginDetails(@RequestParam("customerId") int customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> custLoginDetails = customerLoginService.getCustomerLoginDetails(customerId);
 			List<DropdownModel> passQuestion = customerLoginService.getPassQuestionDetails();
 			
			responseObject.put("custDetails", custLoginDetails);
			responseObject.put("passQuestion", passQuestion);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/ipAddressDetails", method = RequestMethod.POST)
	public Map<String, Object> ipAddressDetails(@RequestParam("customerId") int customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> ipAddressDetails = customerLoginService.getIpAddressDetails(customerId);
 			
			responseObject.put("ipAddDetails", ipAddressDetails);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/addCustomerLogin", method = RequestMethod.POST)
	public Map<String, Object> addCustomerLogin(CustomerLoginModel customerLoginModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerLoginService.addLogin(customerLoginModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS,SUCCESS);
				responseObject.put("AddCustomer",status);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/editCustomerLogin", method = RequestMethod.POST)
	public Map<String, Object> editCustomerLogin(CustomerLoginModel customerLoginModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerLoginService.editLogin(customerLoginModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS,SUCCESS);
				responseObject.put("EditCustomer",status);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/deleteCustomerLogin", method = RequestMethod.POST)
	public Map<String, Object> deleteCustomerLogin(@RequestParam("customerId") int customerId,@RequestParam("customerLoginId") int customerLoginId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerLoginService.deleteCustomerLogin(customerId,customerLoginId);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS,SUCCESS);
				responseObject.put("DeleteCustomer",status);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/transferCustomerLogin", method = RequestMethod.POST)
	public Map<String, Object> transferCustomerLogin(@RequestParam("customerId") int customerId,
			@RequestParam("customerLoginId") int customerLoginId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerLoginService.transferCustomerLogin(customerId,customerLoginId);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS,SUCCESS);
				responseObject.put("TransferCustomer",status);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/checkLogin", method = RequestMethod.POST)
	public Map<String, Object> checkLoginAvailable(@RequestParam("login") String login) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String result = customerLoginService.checkLoginAvailable(login);
			if(ERROR.equals(result))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS,SUCCESS);
				responseObject.put("Availability",result);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/addIpAddress", method = RequestMethod.POST)
	public Map<String, Object> addIpAddress(@RequestParam("customerId") int customerId,
			@RequestParam("lowIpAddress") String lowIpAddress,@RequestParam("highIpAddress") String highIpAddress) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerLoginService.addIpAddress(customerId,lowIpAddress,highIpAddress);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS,SUCCESS);
				responseObject.put("AddIpAddress",status);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+":"+e.getMessage());
			return responseObject;
		}
	}
	
//	@RequestMapping(path = "/editIpAddress", method = RequestMethod.POST)
//	public Map<String, Object> editIpAddress(CustomerLoginModel customerLoginModel) {
//		Map<String, Object> responseObject = new LinkedHashMap<>();
//		try {
//			String status = customerLoginService.editIpAddress(customerLoginModel);
//			if(ERROR.equals(status))
//				responseObject.put(STATUS, ERROR);
//			else {
//				responseObject.put(STATUS,SUCCESS);
//				responseObject.put("EditCustomer",status);
//			}
//			return responseObject;
//		} catch (Exception e) {
//			LOGGER.error(ERROR + e);
//			responseObject.put(STATUS,ERROR+e);
//			return responseObject;
//		}
//	}
	
	
	@RequestMapping(path = "/customerLoginHistory", method = RequestMethod.POST)
	public Map<String, Object> viewCustLoginHistory(@RequestParam("customerLoginId") int customerLoginId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> details = customerLoginService.getCustLoginHistory(customerLoginId);
		
			    responseObject.put("CustLoginHist",details);
				responseObject.put(STATUS,SUCCESS);
				
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/customerEditData", method = RequestMethod.POST)
	public Map<String, Object> customerEditData(@RequestParam("customerLoginId") int customerLoginId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> editData = customerLoginService.customerEditData(customerLoginId);
		
			    responseObject.put("customerEditData",editData);
				responseObject.put(STATUS,SUCCESS);
				
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	

	/*Added for THINKDEV-1039*/
	@RequestMapping(path="/distributionMetadata")
	public Map<String, Object> provideDistributionMetadata()
	{
		Map<String, Object> distributionMetadata = new LinkedHashMap<String, Object>();
		try
		{
			List<DistributionMethodModel> distributionMethodsList=customerLoginService.retrieveDistributionMethods();
			distributionMetadata.put("distributionMethodsMetadataList", distributionMethodsList);
			List<DistributionAttributeModel> distributionAttributesList=customerLoginService.retrieveDistributionAttributes();
			distributionMetadata.put("distributionAttributesMetadataList", distributionAttributesList);
			List<DistributionValueModel> distributionValuesList=customerLoginService.retrieveDistributionValues();
			distributionMetadata.put("distributionValuesMetadataList", distributionValuesList);
			
			distributionMetadata.put(STATUS, SUCCESS);
		}catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			distributionMetadata.put(STATUS, ERROR + e);
			e.printStackTrace();
			return distributionMetadata;
		}
		return distributionMetadata;
	}
}