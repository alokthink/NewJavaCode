package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerHistoryModel;

public class UnitsHistoryMapper implements RowMapper<CustomerHistoryModel>{

	@Override
	public CustomerHistoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerHistoryModel customerHistoryModel = new CustomerHistoryModel();
		customerHistoryModel.setOrderhdr_id(rs.getString("orderhdr_id"));
		customerHistoryModel.setOrder_item_seq(rs.getString("order_item_seq"));
		customerHistoryModel.setUnitHistSeq(rs.getInt("unit_history_seq"));
		customerHistoryModel.setBundleQty(rs.getString("quantity"));
		customerHistoryModel.setUnitUsage(rs.getInt("unit_usage"));
		customerHistoryModel.setDescription(rs.getString("unit_description"));
		customerHistoryModel.setSubscripId(rs.getString("subscrip_id"));
		customerHistoryModel.setPcCalendarSeq(rs.getInt("profit_center_calendar_seq"));
		customerHistoryModel.setDateStamp(rs.getInt("date_stamp"));
		customerHistoryModel.setUser_code(rs.getString("user_code"));
		customerHistoryModel.setUnitTypeId(rs.getInt("unit_type_id"));
		customerHistoryModel.setRevStatus(rs.getString("revenue_status"));
		customerHistoryModel.setProfitCenter(rs.getString("profit_center"));
		
		return customerHistoryModel;
	}
	
	

}
