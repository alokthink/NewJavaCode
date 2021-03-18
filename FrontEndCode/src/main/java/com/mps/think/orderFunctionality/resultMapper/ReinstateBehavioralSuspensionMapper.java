package com.mps.think.orderFunctionality.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.orderFunctionality.model.BehavioralSuspension;
import com.mps.think.util.PropertyUtilityClass;

public class ReinstateBehavioralSuspensionMapper implements RowMapper<BehavioralSuspension> {

	@Override
	public BehavioralSuspension mapRow(ResultSet rs, int rowNum) throws SQLException {
		BehavioralSuspension model = new BehavioralSuspension();
		try {
			model.setFname(rs.getString("fname")!=null?rs.getString("fname").toString():"");
			model.setDescription(rs.getString("description")!=null?rs.getString("description").toString():"");
			model.setOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_" + rs.getInt("order_status")));
			model.setSuspensionStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_" + rs.getInt("old_order_status")));
			model.setStartDate(rs.getString("start_date")!=null?rs.getString("start_date").toString():"");
			model.setCreationDate(rs.getString("creation_date")!=null?rs.getString("creation_date").toString():"");
			model.setActive(rs.getInt("active"));
		}catch(Exception e) {
			System.out.println("Exception:"+e);
		}
		return model;
	}
}
