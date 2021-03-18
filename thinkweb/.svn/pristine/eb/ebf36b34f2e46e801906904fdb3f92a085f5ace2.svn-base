package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerHistoryModel;
import com.mps.think.util.PropertyUtilityClass;

public class CustomerHistoryMapper implements RowMapper<CustomerHistoryModel> {

	@Override
	public CustomerHistoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CustomerHistoryModel customerHistoryModel = new CustomerHistoryModel();
		customerHistoryModel.setColumn_name(rs.getString("column_name"));
		customerHistoryModel.setBatch_id(rs.getString("pending_xaction_header_id") != null ? rs.getString("pending_xaction_header_id"):"");
		customerHistoryModel.setCreation_date(rs.getString("creation_date"));
		customerHistoryModel.setCustomer_address_seq(rs.getString("customer_address_seq"));
		customerHistoryModel.setDescription(rs.getString("description"));
		customerHistoryModel.setDocument_reference_seq(rs.getString("document_reference_seq"));
		customerHistoryModel.setEdited(rs.getString("edited"));
		customerHistoryModel.setOrder_item_seq(rs.getString("order_item_seq"));
		customerHistoryModel.setPayment_account_seq(rs.getString("payment_account_seq"));
		customerHistoryModel.setOrderhdr_id(rs.getString("orderhdr_id"));
		customerHistoryModel.setPayment_seq(rs.getString("payment_seq"));
		customerHistoryModel.setService_seq(rs.getString("service_seq"));
		customerHistoryModel.setDocument_reference_id(rs.getString("document_reference_id"));
		customerHistoryModel.setTable_enum(new PropertyUtilityClass().getConstantValue("table_enum_"+rs.getString("table_enum")));
		customerHistoryModel.setUser_code(rs.getString("user_code"));
		customerHistoryModel.setVoucher_id(rs.getString("voucher_id"));
		customerHistoryModel.setVoucher_nbr(rs.getString("voucher_nbr"));
		customerHistoryModel.setXaction_name(rs.getString("xaction_name"));
		if(customerHistoryModel.getColumn_name() != null && customerHistoryModel.getColumn_name().equals("order_status")) {
			customerHistoryModel.setBefore_change_desc(new PropertyUtilityClass().getConstantValue("order_item.order_status_" +rs.getString("before_change")));
			customerHistoryModel.setAfter_change_desc(new PropertyUtilityClass().getConstantValue("order_item.order_status_" + rs.getString("after_change")));
		}
		else if(customerHistoryModel.getColumn_name() != null && customerHistoryModel.getColumn_name().equals("renewal_status")) {
			customerHistoryModel.setBefore_change_desc(new PropertyUtilityClass().getConstantValue("order_item.renewal_status_" +rs.getString("before_change")));
			customerHistoryModel.setAfter_change_desc(new PropertyUtilityClass().getConstantValue("order_item.renewal_status_" + rs.getString("after_change")));
		}
		else if(customerHistoryModel.getColumn_name() != null && customerHistoryModel.getColumn_name().equals("payment_status")) {
			customerHistoryModel.setBefore_change_desc(new PropertyUtilityClass().getConstantValue("order_item.pay_status_" +rs.getString("before_change")));
			customerHistoryModel.setAfter_change_desc(new PropertyUtilityClass().getConstantValue("order_item.pay_status_" + rs.getString("after_change")));
		}
		else if(customerHistoryModel.getColumn_name() != null && customerHistoryModel.getColumn_name().equals("order_date") ||
				customerHistoryModel.getColumn_name() != null && customerHistoryModel.getColumn_name().equals("cancel_date")) {
			customerHistoryModel.setBefore_change_desc(rs.getString("before_change")!=null
					? new PropertyUtilityClass().getDateFormatter(rs.getString("before_change")) : "");
			customerHistoryModel.setAfter_change_desc(rs.getString("after_change") !=null
					? new PropertyUtilityClass().getDateFormatter(rs.getString("after_change")) : "");
		}
		else {
			customerHistoryModel.setBefore_change_desc(rs.getString("before_change"));
			customerHistoryModel.setAfter_change_desc(rs.getString("after_change"));
		}
	
		return customerHistoryModel;
	}

}
