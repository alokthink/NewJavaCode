package com.mps.think.orderFunctionality.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.orderFunctionality.model.BehavioralSuspension;
import com.mps.think.util.PropertyUtilityClass;

public class BehavioralSuspensionMapper implements RowMapper<BehavioralSuspension> {

	@Override
	public BehavioralSuspension mapRow(ResultSet rs, int rowNum) throws SQLException{
		BehavioralSuspension model = new BehavioralSuspension();
		try {
			//model.setCustomerId(rs.getLong("customer_id"));
			model.setFname(rs.getString("fname")!=null?rs.getString("fname").toString():"");
			model.setDescription(rs.getString("description")!=null?rs.getString("description").toString():"");
			model.setSuspendedOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_" + rs.getInt("suspended_order_status")));
			model.setOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_" + rs.getInt("order_status")));
			model.setSuspensionStatus(new PropertyUtilityClass().getConstantValue("suspension_status_" + rs.getInt("suspension_status")));
			model.setUserCode(rs.getString("user_code"));
			model.setStartDate(rs.getString("start_date")!=null?rs.getString("start_date").toString():"");
			model.setExpireDate(rs.getString("expire_date")!=null?rs.getString("expire_date").toString():"");
		}catch(Exception e) {
			System.out.println("Exception:"+e);
		}
		return model;
	}
}
