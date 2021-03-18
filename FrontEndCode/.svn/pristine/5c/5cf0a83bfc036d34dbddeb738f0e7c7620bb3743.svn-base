package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.OrderClass;
import com.mps.think.util.PropertyUtilityClass;;

public class OrderClassMapper  implements RowMapper<OrderClass> {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderClassMapper.class);
	@Override
	public OrderClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrderClass orderClass = new OrderClass();
		try {			
			orderClass.setOcID(rs.getInt("oc_id"));
			orderClass.setOrderCode(rs.getString("oc"));
			orderClass.setDescription(rs.getString("description"));
			orderClass.setProfitCenter(rs.getString("profit_center"));
			orderClass.setParentOc(rs.getString("parent_oc_id"));
			orderClass.setOcType(new PropertyUtilityClass().getConstantValue("oc_type_" +rs.getString("oc_type")));
			
		} catch (Exception e) {
			LOGGER.info("" + e);
		}
		return orderClass;
	}

}