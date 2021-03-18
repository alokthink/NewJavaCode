package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.daoImpl.CustomerOrderDaoImpl;
import com.mps.think.model.Customer;
import com.mps.think.model.CustomerAddressModel;

public class CustomerInformationMapper implements RowMapper<CustomerAddressModel>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerOrderDaoImpl.class);
	
	@Override
	public CustomerAddressModel mapRow(ResultSet rs, int rowNum){
		CustomerAddressModel customerAddressModel = new CustomerAddressModel();
		try{
			customerAddressModel.setCustomerId(rs.getLong("customer_id"));
			customerAddressModel.setState(rs.getString("state"));
			customerAddressModel.setCurrency(rs.getString("currency"));
			customerAddressModel.setStateCodeForTaxes(rs.getString("state_code_for_taxes"));
			
		}catch(Exception e){
			LOGGER.error("CustomerInformation : "+e);
		}
		return customerAddressModel;
	}

}
