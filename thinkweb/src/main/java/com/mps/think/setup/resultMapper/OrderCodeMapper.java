package com.mps.think.setup.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.setup.model.OrderCodeModel;
import com.mps.think.setup.util.PropertyUtils;

public class OrderCodeMapper implements RowMapper<OrderCodeModel>{

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderCodeModel.class);
	
	@Override
	public OrderCodeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderCodeModel orderCode = new OrderCodeModel();
		try{
			orderCode.setOrderCodeId(rs.getInt("order_code_id"));
			orderCode.setOcId(rs.getInt("oc_id"));
			orderCode.setUserCode(rs.getString("user_code"));
			orderCode.setCommodityCode(rs.getString("commodity_code")!=null?rs.getString("commodity_code"):"");
			orderCode.setActive(new PropertyUtils().getConstantValue("active_"+rs.getInt("active")));
			orderCode.setOrderCodeType(new PropertyUtils().getConstantValue("order_code_type_"+rs.getInt("order_code_type")));
			orderCode.setDescription(rs.getString("description"));
			orderCode.setItemType(new PropertyUtils().getConstantValue("item_type_"+rs.getInt("item_type")));
			orderCode.setPrepaymentReq(rs.getString("prepayment_req"));
			orderCode.setTaxable(new PropertyUtils().getConstantValue("taxable_"+rs.getInt("taxable")));
			orderCode.setShipWeight(rs.getLong("ship_weight"));
			orderCode.setIssueId(rs.getInt("issue_id"));
			orderCode.setPubRotationId(rs.getInt("pub_rotation_id"));
			orderCode.setStandord(new PropertyUtils().getConstantValue("standord_"+rs.getInt("standord")));
			orderCode.setGraceQty(rs.getInt("grace_qty"));
			orderCode.setAuditQualCategory(new PropertyUtils().getConstantValue("audit_qual_category_"+rs.getInt("audit_qual_category")));
			orderCode.setPerpetualOrder(new PropertyUtils().getConstantValue("perpetual_order_"+rs.getInt("perpetual_order")));
			orderCode.setOrderCode(rs.getString("order_code"));
			orderCode.setPrice(rs.getLong("price"));
			orderCode.setNewsubRateClassId(rs.getInt("newsub_rate_class_id"));
			orderCode.setDiscountClassId(rs.getInt("discount_class_id"));
			orderCode.setNewRenewalCardId(rs.getInt("new_renewal_card_id"));
			orderCode.setTermId(rs.getInt("term_id"));
			orderCode.setAuditQualSourceId(rs.getInt("audit_qual_source_id"));
			orderCode.setAuditSubscriptionTypeId(rs.getInt("audit_subscription_type_id"));
			orderCode.setAuditSalesChannelId(rs.getInt("audit_sales_channel_id"));
			orderCode.setAuditNameTitleId(rs.getInt("audit_name_title_id"));
			orderCode.setMedia(rs.getString("media"));
			orderCode.setEdition(rs.getString("edition"));
			orderCode.setQty(rs.getInt("qty"));
			orderCode.setProductSize(rs.getString("product_size"));
			orderCode.setProductStyle(rs.getString("product_style"));
			orderCode.setProductColor(rs.getString("product_color"));
			orderCode.setDisallowInstallBilling(new PropertyUtils().getConstantValue("disallow_install_billing_"+rs.getInt("disallow_install_billing")));
			orderCode.setAutoRenewal(new PropertyUtils().getConstantValue("auto_renewal_"+rs.getInt("auto_renewal")));
			orderCode.setSampleCopyOrder(rs.getString("sample_copy_order"));
			orderCode.setSubscriptionCategoryId(rs.getInt("subscription_category_id"));
			orderCode.setRevenueMethod(new PropertyUtils().getConstantValue("revenue_method_"+rs.getInt("revenue_method")));
			orderCode.setStartType(new PropertyUtils().getConstantValue("start_type_"+rs.getInt("start_type")));
			orderCode.setAutoReplace(rs.getString("auto_replace"));
			orderCode.setUnitTypeId(rs.getInt("unit_type_id"));
			orderCode.setExcessRateClassId(rs.getInt("excess_rate_class_id"));
			orderCode.setCreditCardProcess(new PropertyUtils().getConstantValue("credit_card_process_"+rs.getInt("credit_card_process")));
			orderCode.setAllowOnInternet(rs.getString("allow_on_internet"));
			orderCode.setTrialType(new PropertyUtils().getConstantValue("trial_type_"+rs.getInt("trial_type")));
			orderCode.setTrialPeriod(rs.getInt("trial_period"));
			orderCode.setAutoPayment(rs.getString("auto_payment"));
			orderCode.setIsProforma(rs.getString("is_proforma"));
			orderCode.setUnitExcess(new PropertyUtils().getConstantValue("unit_excess_"+rs.getInt("unit_excess")));
			orderCode.setSegmentedOrder(rs.getString("segmented_order"));
			orderCode.setBackstartTbRenewals(rs.getString("backstart_tb_renewals"));
			orderCode.setRenewAsProforma(rs.getString("renew_as_proforma"));
			orderCode.setPremium(rs.getString("premium"));
			orderCode.setPremium(new PropertyUtils().getConstantValue("premium_"+rs.getInt("premium")));
			orderCode.setPkgOnlyItem(rs.getString("pkg_only_item"));
			orderCode.setShipPremiumPercentage(rs.getInt("ship_premium_percentage"));
			orderCode.setMinNitems(rs.getInt("min_n_items"));
			orderCode.setMaxNitems(rs.getInt("max_n_items"));
			orderCode.setInstallmentBillingOnly(new PropertyUtils().getConstantValue("installment_billing_only_"+rs.getString("installment_billing_only")));
		}catch(Exception e){
			LOGGER.info("OrderCodeMapper:"+e);
		}
		return orderCode;
	}

}
