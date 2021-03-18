package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CancelOrderDetailsModel;
import com.mps.think.util.PropertyUtilityClass;

public class CancelOrderDetailsMapper implements  RowMapper<CancelOrderDetailsModel>{
	
	@Override
	public CancelOrderDetailsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		CancelOrderDetailsModel cancelOrderDetailsModel = new CancelOrderDetailsModel();
		cancelOrderDetailsModel.setCurrency(rs.getString("currency"));
		cancelOrderDetailsModel.setGrossBaseAmount(rs.getDouble("gross_base_amount"));
		cancelOrderDetailsModel.setGrossLocalAmount(rs.getDouble("gross_local_amount"));
		cancelOrderDetailsModel.setNetBaseAmount(rs.getDouble("net_base_amount"));
		cancelOrderDetailsModel.setNetLocalAmount(rs.getFloat("net_local_amount"));
		cancelOrderDetailsModel.setOrderCategory(rs.getString("order_category"));
		cancelOrderDetailsModel.setOrderCode(rs.getString("order_code"));
		cancelOrderDetailsModel.setOrderCodeId(rs.getInt("order_code_id"));
		cancelOrderDetailsModel.setOrderDate(rs.getString("order_date"));
		cancelOrderDetailsModel.setOrderHdrId(rs.getInt("orderhdr_id"));
		cancelOrderDetailsModel.setOrderItemSeq(rs.getInt("order_item_seq"));
		cancelOrderDetailsModel.setOrderItemType(rs.getInt("order_item_type"));
		cancelOrderDetailsModel.setOrderQty(rs.getInt("order_qty"));
		cancelOrderDetailsModel.setSourceCodeId(rs.getInt("source_code_id"));
		cancelOrderDetailsModel.setSubscripId(rs.getInt("subscrip_id"));
		cancelOrderDetailsModel.setUserCode(rs.getString("user_code"));
		cancelOrderDetailsModel.setOrderStatus(new PropertyUtilityClass().getConstantValue("order_item.order_status_"+rs.getInt("order_status")));
		
		return cancelOrderDetailsModel;
	}

}
