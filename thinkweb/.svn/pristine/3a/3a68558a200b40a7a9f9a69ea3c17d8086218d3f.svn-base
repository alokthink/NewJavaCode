package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.OrderItem;

public class OrderItemMapper implements RowMapper<OrderItem> {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemMapper.class);
	@Override
	public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderItem orderItem = new OrderItem();
		try {			
			orderItem.setOrderCodeID(rs.getString("order_code_id"));
			orderItem.setOrderCodeType(rs.getString("order_code_type"));
			orderItem.setOrderCode(rs.getString("order_code"));
			orderItem.setOcId(rs.getInt("oc_id"));
			orderItem.setOrderClass(rs.getString("oc"));
			orderItem.setBundleQty(rs.getInt("qty"));
			if(rs.getInt("order_code_type")==2){
				orderItem.setOrderQty(rs.getInt("qty"));
				/*if(rs.getDouble("price")==0){
					orderItem.setAmountCharged(rs.getDouble("default_price_per_issue"));
				}else{*/
					orderItem.setAmountCharged(rs.getDouble("price"));
				//}
			} else if(rs.getInt("order_code_type")==0){
				orderItem.setOrderQty(rs.getInt("n_issues"));
				orderItem.setAmountCharged(rs.getInt("n_issues")*rs.getDouble("default_price_per_issue"));
			}
			
			
			orderItem.setCurrency("USD");
			orderItem.setBillingType("payment pending");
						
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return orderItem;
	}

}
