package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.OrderDetailsModel;
import com.mps.think.model.PaybreakModel;
import com.mps.think.util.PropertyUtilityClass;

public class OrderDetailsMapper implements RowMapper<OrderDetailsModel> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error"; 
	@Override
	public OrderDetailsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderDetailsModel orderDetailsModel = new OrderDetailsModel();
		try{
			orderDetailsModel.setCustomer_id(rs.getInt("customer_id"));
			orderDetailsModel.setOrderhdr_id(rs.getInt("orderhdr_id"));
			orderDetailsModel.setOrder_item_seq(rs.getInt("order_item_seq"));
			orderDetailsModel.setNote_exist(rs.getInt("note_exist"));
			orderDetailsModel.setService_exist(rs.getString("service_exist"));
			orderDetailsModel.setOc_id(rs.getInt("oc_id"));
			orderDetailsModel.setOrder_date(rs.getString("order_date"));
			orderDetailsModel.setBackord_qty(rs.getInt ("backord_qty"));;
			orderDetailsModel.setAgency_customer_id(rs.getInt("agency_customer_id"));
			orderDetailsModel.setBundle_qty(rs.getInt("bundle_qty"));
			orderDetailsModel.setCustomer_address_seq(rs.getString("customer_address_seq"));
			orderDetailsModel.setGross_base_amount(rs.getInt("gross_base_amount"));
			orderDetailsModel.setGross_local_amount(rs.getInt("gross_local_amount"));
			orderDetailsModel.setN_issues_left(rs.getInt("n_issues_left"));
			orderDetailsModel.setNet_base_amount(rs.getInt("net_base_amount"));
			orderDetailsModel.setNet_local_amount(rs.getInt("net_local_amount"));
			orderDetailsModel.setOrder_code_id(rs.getInt("order_code_id"));
			
			orderDetailsModel.setOrder_item_seq(rs.getInt("order_item_seq"));
			orderDetailsModel.setOrder_qty(rs.getInt("order_qty"));
			orderDetailsModel.setOrder_status(rs.getString("order_status"));
			orderDetailsModel.setOrderhdr_id(rs.getInt("orderhdr_id"));
			orderDetailsModel.setPackage_instance(rs.getInt("package_instance"));
			orderDetailsModel.setPayment_status(rs.getString("payment_status"));
			orderDetailsModel.setRenewal_orderhdr_id(rs.getInt("renewal_orderhdr_id"));
			orderDetailsModel.setShip_qty(rs.getInt("ship_qty"));
			orderDetailsModel.setSubscrip_id(rs.getInt("subscrip_id"));
			
			
			
		}catch(Exception e){
			LOGGER.error(ERROR + e);
		}
		return orderDetailsModel;
	}

}
