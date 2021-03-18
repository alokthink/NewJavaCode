package com.mps.think.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.daoImpl.PaymentInfoDaoImpl;
import com.mps.think.model.CustomerOrderPayment;
import com.mps.think.util.PropertyUtilityClass;

public class CustomerPaymentMapper implements RowMapper<CustomerOrderPayment>{
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentInfoDaoImpl.class);
	private static final String ERROR = "Error"; 

	@Override
	public CustomerOrderPayment mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomerOrderPayment customerPaymentMapper = new CustomerOrderPayment();
		try{
			
			customerPaymentMapper.setRefund_status(rs.getString("refund_status"));
			customerPaymentMapper.setPayment_status(rs.getString("payment_status"));
			LOGGER.info("payment_status:{}",customerPaymentMapper.getPayment_status());
			customerPaymentMapper.setOrder_status(rs.getString("order_status"));
			customerPaymentMapper.setGross_base_amount(rs.getString("gross_base_amount"));
			customerPaymentMapper.setOrderhdr_id(rs.getInt("orderhdr_id"));
			customerPaymentMapper.setOrder_item_seq(rs.getInt("order_item_seq"));
	        customerPaymentMapper.setOrder_date(rs.getString("order_date"));
			customerPaymentMapper.setOrder_code_id(rs.getString("order_code"));
			customerPaymentMapper.setBill_to_customer_id(rs.getInt("bill_to_customer_id"));
			customerPaymentMapper.setCustomer_id(rs.getInt("customer_id"));
			customerPaymentMapper.setOrder_qty(rs.getInt("order_qty"));
			customerPaymentMapper.setCurrency(rs.getString("currency"));
			customerPaymentMapper.setOrder_code(rs.getString("order_code"));
		   customerPaymentMapper.setNet_base_amount(rs.getFloat("net_base_amount"));
			customerPaymentMapper.setGross_local_amount(rs.getFloat("gross_local_amount"));
			customerPaymentMapper.setNet_local_amount(rs.getFloat("net_local_amount"));
			
			//customerPaymentMapper.setOrderhdr_id(rs.getLong("orderhdr_id"));
			customerPaymentMapper.setRenewal_orderhdr_id(rs.getString("renewal_orderhdr_id"));
			customerPaymentMapper.setOc_id(rs.getString("oc_id"));
			customerPaymentMapper.setSubscrip_id(rs.getLong("subscrip_id"));
			// customerPaymentMapper.setOrder_item_seq(rs.getInt("order_item_seq"));
			// customerPaymentMapper.setOrder_date(new PropertyUtilityClass().getDateFormatter(rs.getString("order_date").toString()));
			customerPaymentMapper.setStart_date(rs.getString("start_date")!=null?(new PropertyUtilityClass().getDateFormatter(rs.getString("start_date").toString())):null);
			customerPaymentMapper.setExpire_date(rs.getString("expire_date")!=null?(new PropertyUtilityClass().getDateFormatter(rs.getString("expire_date").toString())):null);
			// customerPaymentMapper.setOc_id(rs.getString("order_class"));
			//customerOrderModel.setOrderCode(rs.getString("order_code"));
			//customerPaymentMapper.setOrder_code(rs.getString("order_code"));
		
			// customerPaymentMapper.setOrder_qty(rs.getLong("order_qty"));
			customerPaymentMapper.setN_issues_left(rs.getString("n_issues_left"));
			// customerPaymentMapper.setGross_local_amount(rs.getString("gross_local_amount"));
			//customerPaymentMapper.setOrder_status(new PropertyUtilityClass().getConstantValue("order_item.order_status_"+rs.getString("order_status")));
			customerPaymentMapper.setOrderStatusId(rs.getString("order_status"));
			//customerPaymentMapper.setPayment_status(new PropertyUtilityClass().getConstantValue("order_item.pay_status_"+rs.getString("payment_status")));
			customerPaymentMapper.setAgency_customer_id(rs.getString("agency_code"));
			customerPaymentMapper.setBundle_qty(rs.getLong("bundle_qty"));
			customerPaymentMapper.setOrder_code_type(rs.getInt("order_code_type"));
			customerPaymentMapper.setOrder_item_type(rs.getInt("order_item_type"));
			customerPaymentMapper.setStartIssueId(rs.getString("startIssueId"));
			customerPaymentMapper.setStopIssueId(rs.getString("stopIssueId"));
			// customerPaymentMapper.setCurrency(rs.getString("currency"));
			customerPaymentMapper.setBilling_type(rs.getInt("billing_type"));
			customerPaymentMapper.setIs_proforma(rs.getInt("is_proforma"));
			customerPaymentMapper.setNote_exist(rs.getInt("note_exist"));
			customerPaymentMapper.setService_exist(rs.getInt("service_exist"));
			customerPaymentMapper.setAttach_exist(rs.getString("attach_exist"));
			customerPaymentMapper.setGroup_order(rs.getInt("group_order"));
			customerPaymentMapper.setCancel_reason(rs.getString("cancel_reason")==null?"":rs.getString("cancel_reason"));
			customerPaymentMapper.setCustomer_address_seq(rs.getString("customer_address_seq"));
			customerPaymentMapper.setBackord_qty(rs.getString("backord_qty"));
			customerPaymentMapper.setShip_qty(rs.getString("ship_qty"));
			// customerPaymentMapper.setCustomer_id(rs.getString("customer_id"));
		
			//customerPaymentMapper.setNet_local_amount(rs.getString("net_local_amount"));
			//customerPaymentMapper.setNet_base_amount(rs.getString("net_base_amount"));
			customerPaymentMapper.setBill_to_customer_id(rs.getInt("bill_to_customer_id"));
			customerPaymentMapper.setAgency_customer_id(rs.getString("agency_customer_id"));
			
		}catch(Exception e){
			LOGGER.error(ERROR + e);
		}
		return customerPaymentMapper;
	
	}
	

}
