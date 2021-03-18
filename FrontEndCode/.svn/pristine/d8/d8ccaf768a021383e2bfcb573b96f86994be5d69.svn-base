package com.mps.think.service;

import java.util.List;
import java.util.Map;

import com.mps.think.model.CustomerLoginModel;
import com.mps.think.model.DistributionAttributeModel;
import com.mps.think.model.DistributionMethodModel;
import com.mps.think.model.DistributionValueModel;
import com.mps.think.model.DropdownModel;


public interface CustomerLoginService {

	List<Map<String, Object>> getCustomerLoginDetails(int customerId);

	List<DropdownModel> getPassQuestionDetails();

	String addLogin(CustomerLoginModel customerLoginModel);

	String editLogin(CustomerLoginModel customerLoginModel);

	String deleteCustomerLogin(int customerId,int customerLoginId);

	String transferCustomerLogin(int customerId, int customerLoginId);

	String checkLoginAvailable(String login);

	List<Map<String, Object>> getIpAddressDetails(int customerId);

	String addIpAddress(int customerId,String lowIpAddress, String highIpAddress);

	List<Map<String, Object>> getCustLoginHistory(int customerLoginId);

	List<Map<String, Object>> customerEditData(int customerLoginId);
	
	List<DistributionMethodModel> retrieveDistributionMethods();
	List<DistributionAttributeModel> retrieveDistributionAttributes();
	List<DistributionValueModel> retrieveDistributionValues();

}
