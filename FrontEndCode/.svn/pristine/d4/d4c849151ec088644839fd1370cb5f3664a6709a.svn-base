package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.ShippingModel;

public class ShippingMapper implements RowMapper<ShippingModel> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShippingMapper.class);
	@Override
	public ShippingModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShippingModel ShippingData = new ShippingModel();
		try {
			ShippingData.setOrderClass(rs.getString("oc"));
			ShippingData.setOrderCode(rs.getString("order_code"));
			ShippingData.setDescription(rs.getString("description"));
			ShippingData.setOcId(rs.getString("oc_id"));
			ShippingData.setBundleQty(1);
			ShippingData.setOrderQty(1);
			ShippingData.setBillingType(rs.getString("billingType"));
			
		}catch(Exception e){
			LOGGER.info("Shipping Data : "+e);
		}
		return ShippingData;
	
	}

}

