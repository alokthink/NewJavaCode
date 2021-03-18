package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.PaybreakModel;
import com.mps.think.util.PropertyUtilityClass;

public class PaybreakMapper implements RowMapper<PaybreakModel> {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error"; 
	@Override
	public PaybreakModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		PaybreakModel paybreakModel = new PaybreakModel();
		try{
			int paySeq = rs.getInt("payment_seq");
			paybreakModel.setCustomerId(rs.getInt("customer_id"));
	
				paybreakModel.setPaymentSeq(rs.getInt("payment_seq"));
			
			paybreakModel.setPaybreakSeq(rs.getInt("paybreak_seq"));
			paybreakModel.setOrderhdrId(rs.getInt("orderhdr_id"));
			paybreakModel.setOrderItemSeq(rs.getInt("order_item_seq"));
			paybreakModel.setOrderItemBreakType((new PropertyUtilityClass().getConstantValue("payment_break.order_item_break_type_"+rs.getString("order_item_break_type"))));
			paybreakModel.setOrderItemAmtBreakSeq(rs.getInt("order_item_amt_break_seq"));
			paybreakModel.setOrderItemAmtBreakSeqDesc(new PropertyUtilityClass().getConstantValue("payment_break.order_item_break_type_"+rs.getString("order_item_amt_break_seq")));
			paybreakModel.setLocalAmount(rs.getFloat("local_amount"));
			paybreakModel.setBaseAmount(rs.getFloat("base_amount"));
			paybreakModel.setPayCurrencyAmount(rs.getFloat("pay_currency_amount"));
			paybreakModel.setPaybreakType(rs.getInt("paybreak_type"));
			paybreakModel.setPaybreakTypeDesc(new PropertyUtilityClass().getConstantValue("payment.paybreak_type_"+rs.getString("paybreak_type")));
			paybreakModel.setPcurrency(rs.getString("pcurrency"));
            paybreakModel.setOcurrency(rs.getString("ocurrency"));
			// paybreakModel.setOcId(rs.getInt("oc_id"));
			// paybreakModel.setDateStamp(rs.getInt("date_stamp"));
			paybreakModel.setBogusCommission(rs.getBoolean("bogus_commission"));
			//paybreakModel.setLocalExchangeRate(rs.getFloat("local_exchange_rate"));
			// paybreakModel.setRowVersion(rs.getString("row_version"));
			// paybreakModel.setEditTrailId(rs.getInt("edit_trail_id"));
			// paybreakModel.setJrnFlag(rs.getInt("jrn_flag"));
			paybreakModel.setBcurrency(rs.getString("bcurrency"));
		}catch(Exception e){
			LOGGER.error(ERROR + e);
		}
		return paybreakModel;
	}

}
