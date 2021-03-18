package com.mps.think.resultMapper;

import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.model.CustomerOrderModel;
import com.mps.think.util.PropertyUtilityClass;

public class CustomerOrderMapper implements RowMapper<CustomerOrderModel>{

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerOrderMapper.class);
	@Override
	public CustomerOrderModel mapRow(ResultSet rs, int arg1) {
		CustomerOrderModel customerOrderModel=new CustomerOrderModel();
		try{
		customerOrderModel.setOrderhdr_id(rs.getLong("orderhdr_id"));
		customerOrderModel.setRenewal_orderhdr_id(rs.getString("renewal_orderhdr_id"));
		customerOrderModel.setOcId(rs.getString("oc_id"));
		customerOrderModel.setNoCharge(rs.getInt("no_charge"));
		customerOrderModel.setSubscrip_id(rs.getLong("subscrip_id"));
		customerOrderModel.setOrder_item_seq(rs.getInt("order_item_seq"));
		customerOrderModel.setOrder_date(new PropertyUtilityClass().getDateFormatter(rs.getString("order_date").toString()));
		customerOrderModel.setStart_date(rs.getString("start_date")!=null?(new PropertyUtilityClass().getDateFormatter(rs.getString("start_date").toString())):null);
		customerOrderModel.setExpire_date(rs.getString("expire_date")!=null?(new PropertyUtilityClass().getDateFormatter(rs.getString("expire_date").toString())):null);
		customerOrderModel.setOc_id(rs.getString("order_class"));
		customerOrderModel.setInventory_id(rs.getString("inventory_id"));
		customerOrderModel.setOrder_code_id(rs.getString("order_code"));
		customerOrderModel.setOrderCodeId(rs.getString("order_code_id"));
		customerOrderModel.setOrder_qty(rs.getLong("order_qty"));
		customerOrderModel.setN_issues_left(rs.getString("n_issues_left"));
		customerOrderModel.setGross_local_amount(rs.getString("gross_local_amount"));
		customerOrderModel.setOrder_status(new PropertyUtilityClass().getConstantValue("order_item.order_status_"+rs.getString("order_status")));
		customerOrderModel.setOrderStatusId(rs.getString("order_status"));
		customerOrderModel.setPayment_status(new PropertyUtilityClass().getConstantValue("order_item.pay_status_"+rs.getString("payment_status")));
		customerOrderModel.setAgency_customer_id(rs.getString("agency_code"));
		customerOrderModel.setBundle_qty(rs.getLong("bundle_qty"));
		customerOrderModel.setOrderCodeType(rs.getInt("order_code_type"));
		customerOrderModel.setOrderItemType(rs.getInt("order_item_type"));
		customerOrderModel.setStart_issue_id(rs.getString("startIssueId"));
		customerOrderModel.setStop_issue_id(rs.getString("stopIssueId"));
		customerOrderModel.setCurrency(rs.getString("currency"));
		customerOrderModel.setBilling_type(rs.getInt("billing_type"));
		customerOrderModel.setIs_proforma(rs.getInt("is_proforma"));
		customerOrderModel.setNote_exist(rs.getInt("note_exist"));
		customerOrderModel.setService_exist(rs.getInt("service_exist"));
		customerOrderModel.setAttach_exist(rs.getInt("attach_exist"));
		customerOrderModel.setGroup_order(rs.getInt("group_order"));
		customerOrderModel.setCancel_reason(rs.getString("cancel_reason")==null?"":rs.getString("cancel_reason"));
		customerOrderModel.setCustomer_address_seq(rs.getString("customer_address_seq"));
		customerOrderModel.setBackord_qty(rs.getString("backord_qty"));
		customerOrderModel.setShip_qty(rs.getString("ship_qty"));
		customerOrderModel.setCustomer_id(rs.getString("customer_id"));
		customerOrderModel.setGross_base_amount(rs.getString("gross_base_amount"));
		customerOrderModel.setNet_local_amount(rs.getString("net_local_amount"));
		customerOrderModel.setNet_base_amount(rs.getString("net_base_amount"));
		customerOrderModel.setBillToCustomerId(rs.getString("bill_to_customer_id"));
		customerOrderModel.setAgency(rs.getString("agency_customer_id"));
		customerOrderModel.setSubscrip_start_type(rs.getString("subscrip_start_type"));
		customerOrderModel.setLocalAmount(rs.getString("localAmount"));
		customerOrderModel.setBaseAmount(rs.getString("baseAmount"));
		customerOrderModel.setRenew_start_date(rs.getString("renew_start_date")==null?"":rs.getString("renew_start_date"));
		customerOrderModel.setRenew_expire_date(rs.getString("renew_expire_date")==null?"":rs.getString("renew_expire_date"));
		customerOrderModel.setPageName(rs.getString("pageName"));
		customerOrderModel.setDateStamp(rs.getInt("date_stamp"));
		customerOrderModel.setUnitExcess(new PropertyUtilityClass().getConstantValue("unit_excess_"+rs.getString("unit_excess")));
		customerOrderModel.setUnitTypeId(rs.getString("unit_type_id"));
		customerOrderModel.setMruUnitHistorySeq(rs.getString("mru_unit_history_seq"));
		customerOrderModel.setInstallAutoPayment(rs.getInt("install_auto_payment"));
		customerOrderModel.setCancelDD(rs.getInt("cancel_dd"));
		customerOrderModel.setSubscriptionDefId(rs.getInt("subscription_def_id"));
		customerOrderModel.setUpsellOn(rs.getInt("upsell_on"));
		customerOrderModel.setAudited(rs.getInt("audited"));
		customerOrderModel.setQP(rs.getInt("qp"));
		customerOrderModel.setQF(rs.getInt("qf"));
		customerOrderModel.setNQP(rs.getInt("nqp"));
		customerOrderModel.setNQF(rs.getInt("nqf"));
		customerOrderModel.setSourceCodeID(rs.getInt("source_code_id"));
		customerOrderModel.setPkgDefID(rs.getInt("pkg_def_id"));
		customerOrderModel.setRequired(rs.getInt("required"));
		}
		catch(Exception e){
			LOGGER.info("customerOrderModel : "+e);
		}
		return customerOrderModel;
	}

}
