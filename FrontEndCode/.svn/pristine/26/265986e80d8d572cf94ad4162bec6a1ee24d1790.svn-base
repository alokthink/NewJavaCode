package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerHistoryModel;

public class PromotionEffortsMapper implements RowMapper<CustomerHistoryModel>{
	
	@Override
	public CustomerHistoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerHistoryModel customerHistoryModel = new CustomerHistoryModel();
		customerHistoryModel.setOrderClass(rs.getString("oc"));
		customerHistoryModel.setEffortNo(rs.getInt("effort_number"));
		customerHistoryModel.setIssueDate(rs.getString("promotion_date"));
		customerHistoryModel.setSourceCode(rs.getString("source_code"));
		customerHistoryModel.setCustId(rs.getInt("customer_id"));
		
		return customerHistoryModel;
	}

}
