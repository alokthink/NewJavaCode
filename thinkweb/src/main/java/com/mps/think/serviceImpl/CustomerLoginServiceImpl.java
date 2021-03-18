package com.mps.think.serviceImpl;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.dao.CustomerLoginDao;
import com.mps.think.model.CustomerLoginModel;
import com.mps.think.model.DistributionAttributeModel;
import com.mps.think.model.DistributionMethodModel;
import com.mps.think.model.DistributionValueModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.service.CustomerLoginService;

@Service("CustomerLoginService")
public class CustomerLoginServiceImpl implements CustomerLoginService {
	
	@Autowired
	CustomerLoginDao customerLoginDao;

	@Override
	public List<Map<String, Object>> getCustomerLoginDetails(int customerId) {
		return customerLoginDao.getCustomerLoginDetails(customerId);
	}

	@Override
	public List<DropdownModel> getPassQuestionDetails() {
		return customerLoginDao.getPassQuestionDetails();
	}

	@Override
	public String addLogin(CustomerLoginModel customerLoginModel) {
		return customerLoginDao.addLogin(customerLoginModel);
	}

	@Override
	public String editLogin(CustomerLoginModel customerLoginModel) {
		return customerLoginDao.editLogin(customerLoginModel);
	}

	@Override
	public String deleteCustomerLogin(int customerId,int customerLoginId) {
		return customerLoginDao.deleteCustomerLogin(customerId,customerLoginId);
	}

	@Override
	public String transferCustomerLogin(int customerId, int customerLoginId) {
		return customerLoginDao.transferCustomerLogin(customerId,customerLoginId);
	}

	@Override
	public String checkLoginAvailable(String login) {
		return customerLoginDao.checkLoginAvailable(login);
	}

	@Override
	public List<Map<String, Object>> getIpAddressDetails(int customerId) {
		return customerLoginDao.getIpAddressDetails(customerId);
	}

	@Override
	public String addIpAddress(int customerId,String lowIpAddress, String highIpAddress) {
		
		if(Optional.ofNullable(lowIpAddress).isPresent() && lowIpAddress.contains(":") && lowIpAddress.contains(".") || Optional.ofNullable(highIpAddress).isPresent() && highIpAddress.contains(":") && highIpAddress.contains(".")) {
			throw new IllegalArgumentException("Invalid IP Address."
					+ " Please enter values between 0 and 255 for each segment for IPv4."
					+ " For IPv6, ensure proper format is used (8, colon separated, 16-bit hex values, leading zeros may be omitted)."
					+ " Double colon format is supported.  IPv4-mapped IPv6 format is not supported.");
		}
		if(Optional.ofNullable(lowIpAddress).isPresent() && lowIpAddress.contains(":")) {
			lowIpAddress = checkAndGetActualIPV6Value(lowIpAddress);
		}
		if(Optional.ofNullable(highIpAddress).isPresent() && highIpAddress.contains(":")) {
			highIpAddress = checkAndGetActualIPV6Value(highIpAddress);
		}


		return customerLoginDao.addIpAddress(customerId,lowIpAddress,highIpAddress);
	}

	@Override
	public List<Map<String, Object>> getCustLoginHistory(int customerLoginId) {
		return customerLoginDao.getCustLoginHistory(customerLoginId);
	}

	@Override
	public List<Map<String, Object>> customerEditData(int customerLoginId) {
		return customerLoginDao.customerEditData(customerLoginId);
	}

	@Override
	public List<DistributionMethodModel> retrieveDistributionMethods()
	{
		return customerLoginDao.retrieveDistributionMethodsFromDataSource();
	}
	
	@Override
	public List<DistributionAttributeModel> retrieveDistributionAttributes()
	{
		return customerLoginDao.retrieveDistributionAttributesFromDataSource();
	}
	
	@Override
	public List<DistributionValueModel> retrieveDistributionValues()
	{
		return customerLoginDao.retrieveDistributionValuesFromDataSource();
	}
	
	private String checkAndGetActualIPV6Value(String ipv6) {

		String ipV6[] = ipv6.split(":");
		
		if(ipV6.length == 8) {
			try {
				
				InetAddress lowIPV6Address = Inet6Address.getByName(ipv6);
				ipv6 = lowIPV6Address.getHostAddress();
				ipv6 = getActualIPV6Value(ipv6);
				
			}catch (Exception e) {
				throw new IllegalArgumentException("Invalid IP Address."
						+ " Please enter values between 0 and 255 for each segment for IPv4."
						+ " For IPv6, ensure proper format is used (8, colon separated, 16-bit hex values, leading zeros may be omitted)."
						+ " Double colon format is supported.  IPv4-mapped IPv6 format is not supported.");
			}
			
		}
		else {
			try {
				
				InetAddress lowIPV6Address = Inet6Address.getByName(ipv6);
				ipv6 = lowIPV6Address.getHostAddress();
				ipv6 = getActualIPV6Value(ipv6);
				
			}catch (Exception e) {
				throw new IllegalArgumentException("Invalid IP Address."
						+ " Please enter values between 0 and 255 for each segment for IPv4."
						+ " For IPv6, ensure proper format is used (8, colon separated, 16-bit hex values, leading zeros may be omitted)."
						+ " Double colon format is supported.  IPv4-mapped IPv6 format is not supported.");
			}
		}
	
		return ipv6;
	}
	
	
	private String getActualIPV6Value(String ipV6Data) {
		String value[] = ipV6Data.split(":");
		int count = 0;
		for(String valueIndex : value) {
			if( valueIndex.length() != 4 ) {
				String initial = "";
				for(int index = 1 ;index <= 4-valueIndex.length() ; index++) {
					initial = initial.concat("0");
				}

				value[count] = initial.concat(valueIndex);

			}
			count++;
		}
		
		String validData ="";
		for(String data : value) {
			validData =  validData.concat(data);
			validData =  validData.concat(":");
		}
		validData = validData.substring(0, validData.length()-1).toUpperCase();
		 
		return validData;
	}

}
