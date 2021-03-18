package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.OrderItemAmtBreak;
import com.mps.think.util.PropertyUtilityClass;

public class OrderItemAmtBreakMapper implements RowMapper<OrderItemAmtBreak>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemAmtBreakMapper.class);

	@Override
	public OrderItemAmtBreak mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderItemAmtBreak orderItemAmtBreak=new OrderItemAmtBreak();
		try {
			orderItemAmtBreak.setOrderhdrId(rs.getInt("orderhdr_id"));
			orderItemAmtBreak.setOrderItemBreakType((new PropertyUtilityClass().getConstantValue("payment_break.order_item_break_type_"+rs.getString("order_item_break_type"))));
			orderItemAmtBreak.setOrderItemAmtBreakSeq(rs.getString("order_item_amt_break_seq"));
			orderItemAmtBreak.setOrderItemSeq(rs.getString("order_item_seq"));
			orderItemAmtBreak.setLocalAmount(rs.getString("local_amount"));
			orderItemAmtBreak.setBaseAmount(rs.getString("base_amount"));
			orderItemAmtBreak.setJurisdictionSeq(rs.getString("jurisdiction_seq"));
			orderItemAmtBreak.setState(rs.getString("state"));
			orderItemAmtBreak.setTaxType(rs.getString("tax_type"));
			orderItemAmtBreak.setTaxRateCategory(rs.getString("tax_rate_category"));
			orderItemAmtBreak.setRowVersion(rs.getString("row_version"));
			orderItemAmtBreak.setTaxDelivery(rs.getString("tax_delivery"));
			orderItemAmtBreak.setOrigBaseAmount(rs.getString("orig_base_amount"));
			orderItemAmtBreak.setTaxActive(rs.getString("tax_active"));
			orderItemAmtBreak.setTxIncl(rs.getString("tx_incl"));
			orderItemAmtBreak.setVrtxJurisdiction(rs.getString("vrtx_jurisdiction"));
			orderItemAmtBreak.setVrtxJurisdictionLevel(rs.getString("vrtx_jurisdiction_level"));
			orderItemAmtBreak.setVrtxTaxType(rs.getString("vrtx_tax_type"));
			orderItemAmtBreak.setNetBaseAmount(rs.getString("base_amount"));
			orderItemAmtBreak.setGrossBaseAmount(rs.getString("base_amount"));
			orderItemAmtBreak.setNetLocalAmount(rs.getString("local_amount"));
			orderItemAmtBreak.setGrossLocalAmount(rs.getString("local_amount"));
		}catch(Exception e) {
			LOGGER.info("PaymentReview: "+e);
		}
		return orderItemAmtBreak;
	}

		
}	