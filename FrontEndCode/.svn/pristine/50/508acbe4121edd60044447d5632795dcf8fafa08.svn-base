package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerHistoryModel;

public class SingleIssueHistoryMapper implements RowMapper<CustomerHistoryModel>{
	
	@Override
	public CustomerHistoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerHistoryModel customerHistoryModel = new CustomerHistoryModel();
		customerHistoryModel.setOrderhdr_id(rs.getString("orderhdr_id"));
		customerHistoryModel.setShipperRefNbr(rs.getInt("shipper_ref_nbr"));
		customerHistoryModel.setOrder_item_seq(rs.getString("order_item_seq"));
		customerHistoryModel.setIssueDate(rs.getString("issue_date"));
		customerHistoryModel.setBundleQty(rs.getString("qty_shipped"));
		customerHistoryModel.setDropDate(rs.getString("drop_date"));
		customerHistoryModel.setCustId(rs.getInt("customer_id"));
		
		return customerHistoryModel;
	}
}
