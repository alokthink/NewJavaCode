package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerHistoryModel;

public class BillingEffortHistoryMapper implements RowMapper<CustomerHistoryModel>{
	
	@Override
	public CustomerHistoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerHistoryModel customerHistoryModel = new CustomerHistoryModel();
		customerHistoryModel.setOrderhdr_id(rs.getString("orderhdr_id"));
		customerHistoryModel.setEffortNo(rs.getInt("effort_number"));
		customerHistoryModel.setInstallNbr(rs.getInt("installment_number"));
		customerHistoryModel.setProcessId(rs.getString("process_id"));
		customerHistoryModel.setDropDate(rs.getString("drop_date"));
		customerHistoryModel.setDescription(rs.getString("description"));
		customerHistoryModel.setCustId(rs.getInt("customer_id"));
		
		return customerHistoryModel;
	}

}
