package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.SubscriptModel;

public class SubscripMapper implements RowMapper<SubscriptModel>{

	@Override
	public SubscriptModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SubscriptModel subscriptModel = new SubscriptModel();
		
		subscriptModel.setOrderCodeId(rs.getInt("item_order_code_id"));
		subscriptModel.setOcId(rs.getInt("oc_id"));
		subscriptModel.setIssueId(rs.getInt("issue_id"));
		
		return subscriptModel;
	}

}
