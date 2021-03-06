package com.mps.think.orderFunctionality.resultMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.mps.think.orderFunctionality.model.OrderItemModel;
import com.mps.think.util.PropertyUtilityClass;

public class TransferOrderMapper implements RowMapper<OrderItemModel>  {
		@Override
	public OrderItemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderItemModel model = new OrderItemModel();
			try {
			model.setOrderhdrId(rs.getLong("orderhdr_id"));
			model.setOrderItemSeq(rs.getInt("order_item_seq"));
			model.setUserCode(rs.getString("user_code"));
			model.setDateStamp(rs.getString("date_stamp"));
			model.setOrderCode(rs.getString("order_code"));
			model.setOrderItemType(new PropertyUtilityClass().getConstantValue("order_code.order_code_type_" + rs.getString("order_item_type")));
			model.setOrderDate(rs.getString("order_date")!=null?rs.getString("order_date").toString():"");
			model.setGrossBaseAmount(rs.getString("gross_base_amount")!=null?rs.getString("gross_base_amount").toString():"");
			model.setGrossLocalAmount(rs.getString("gross_local_amount")!=null?rs.getString("gross_local_amount").toString():"");
			model.setNetBaseAmount(rs.getString("net_base_amount")!=null?rs.getString("net_base_amount").toString():"");
			model.setNetLocalAmount(rs.getString("net_local_amount")!=null?rs.getString("net_local_amount").toString():"");
			model.setHasTax(rs.getString("has_tax")!=null?rs.getString("has_tax").toString():"");
			model.setHasDeliveryCharge(new PropertyUtilityClass().getConstantValue("serve_backlabels_" + rs.getString("has_delivery_charge")));
			model.setBillDate(rs.getString("bill_date")!=null?rs.getString("bill_date").toString():"");
			model.setPaymentStatus(new PropertyUtilityClass().getConstantValue("order_item.pay_status_" + rs.getInt("payment_status")));
			model.setRefundStatus(new PropertyUtilityClass().getConstantValue("refund_status_" + rs.getString("refund_status")));
			model.setOrderType(new PropertyUtilityClass().getConstantValue("order_type_" + rs.getString("order_type")));
			model.setHasPremium(new PropertyUtilityClass().getConstantValue("serve_backlabels_" + rs.getString("has_premium")));
			model.setPrepaymentReq(rs.getInt("prepayment_req"));
			model.setProductId(rs.getString("product_id")!=null?rs.getString("product_id").toString():"");
			model.setIsComplimentary(new PropertyUtilityClass().getConstantValue("serve_backlabels_" + rs.getString("is_complimentary")));
			model.setSubscripStartType(new PropertyUtilityClass().getConstantValue("subscrip_start_type_" + rs.getString("subscrip_start_type")));
			model.setDuration(rs.getString("duration")!=null?rs.getString("duration").toString():"");
			model.setRenewalStatus(rs.getString("renewal_status")!=null?rs.getString("renewal_status").toString():"");
			model.setDeliveryMethodPerm(rs.getString("delivery_method_perm")!=null?rs.getString("delivery_method_perm").toString():"");
			model.setChangeQtyFlag(rs.getString("change_qty_flag")!=null?rs.getString("change_qty_flag").toString():"");
			model.setnRemainingPaidIssues(rs.getString("n_remaining_paid_issues")!=null?rs.getString("n_remaining_paid_issues").toString():"");
			model.setExtIssLeft(rs.getString("ext_iss_left")!=null?rs.getString("ext_iss_left").toString():"");
			model.setExtIssTot(rs.getString("ext_iss_tot")!=null?rs.getString("ext_iss_tot").toString():"");
			model.setOrderStatus(new PropertyUtilityClass().getConstantValue("suspended_order_status_" + rs.getInt("order_status")));
			model.setRenewalCategory(rs.getString("renewal_category")!=null?rs.getString("renewal_category").toString():"");
			model.setExchangeRate(rs.getString("exchange_rate")!=null?rs.getString("exchange_rate").toString():"");
			model.setRateClassId(rs.getString("rate_class_id")!=null?rs.getString("rate_class_id").toString():"");
			model.setRateClassEffectiveSeq(rs.getString("rate_class_effective_seq")!=null?rs.getString("rate_class_effective_seq").toString():"");
			model.setInventoryId(rs.getString("inventory_id")!=null?rs.getString("inventory_id").toString():"");
			model.setOcId(rs.getInt("oc_id"));
			model.setAutoPayment(rs.getString("auto_payment")!=null?rs.getString("auto_payment").toString():"");
			model.setPerpetualOrder(rs.getString("perpetual_order")!=null?rs.getString("perpetual_order").toString():"");
			model.setBillToCustomerId(rs.getString("bill_to_customer_id")!=null?rs.getString("bill_to_customer_id").toString():"");
			model.setBillToCustomerAddressSeq(rs.getString("bill_to_customer_address_seq")!=null?rs.getString("bill_to_customer_address_seq").toString():"");
			model.setRenewToCustomerId(rs.getString("renew_to_customer_id")!=null?rs.getString("renew_to_customer_id").toString():"");
			model.setRenewToCustomerAddressSeq(rs.getString("renew_to_customer_address_seq")!=null?rs.getString("renew_to_customer_address_seq").toString():"");
			model.setCustomerId(rs.getString("customer_id")!=null?rs.getString("customer_id").toString():"");
			model.setCustomerAddressSeq(rs.getString("customer_address_seq")!=null?rs.getString("customer_address_seq").toString():"");
			model.setAltShipCustomerId(rs.getString("alt_ship_customer_id")!=null?rs.getString("alt_ship_customer_id").toString():"");
			model.setAltShipCustomerAddressSeq(rs.getString("alt_ship_customer_address_seq")!=null?rs.getString("alt_ship_customer_address_seq").toString():"");
			model.setNoteExist(rs.getString("note_exist")!=null?rs.getString("note_exist").toString():"");
			model.setServiceExist(rs.getString("service_exist")!=null?rs.getString("service_exist").toString():"");
			model.setMruOrderItemAmtBreakSeq(rs.getString("mru_order_item_amt_break_seq")!=null?rs.getString("mru_order_item_amt_break_seq").toString():"");
			model.setHasBeenRenewed(rs.getString("has_been_renewed")!=null?rs.getString("has_been_renewed").toString():"");
			model.setRevenueMethod(rs.getInt("revenue_method"));
			model.setTrialType(rs.getString("trial_type")!=null?rs.getString("trial_type").toString():"");
			model.setOrigOrderQty(rs.getString("orig_order_qty")!=null?rs.getString("orig_order_qty").toString():"");
			model.setUnitExcess(rs.getString("unit_excess")!=null?rs.getString("unit_excess").toString():"");
			model.setIsProforma(rs.getString("is_proforma")!=null?rs.getString("is_proforma").toString():"");
			model.setnTaxUpdates(rs.getString("n_tax_updates")!=null?rs.getString("n_tax_updates").toString():"");
			model.setTotalTaxLocalAmount(rs.getString("total_tax_local_amount")!=null?rs.getString("total_tax_local_amount").toString():"");
			model.setTotalTaxBaseAmount(rs.getString("total_tax_base_amount")!=null?rs.getString("total_tax_base_amount").toString():"");
			model.setElectronicDelivery(rs.getInt("electronic_delivery"));
			model.setTimeUnitOptions(rs.getString("time_unit_options")!=null?rs.getString("time_unit_options").toString():"");
			model.setGroupOrder(rs.getString("group_order")!=null?rs.getString("group_order").toString():"");
			model.setInvoiceDate(rs.getString("invoice_date")!=null?rs.getString("invoice_date").toString():"");
			model.setAutoRenewNotifySent(rs.getString("auto_renew_notify_sent")!=null?rs.getString("auto_renew_notify_sent").toString():"");
			model.setExtendedDays(rs.getString("extended_days")!=null?rs.getString("extended_days").toString():"");
			model.setAsynchronousAutoRenew(rs.getString("asynchronous_auto_renew")!=null?rs.getString("asynchronous_auto_renew").toString():"");
			model.setnDaysGraced(rs.getString("n_days_graced")!=null?rs.getString("n_days_graced").toString():"");
			model.setIsBackOrdered(rs.getInt("is_back_ordered"));
			model.setMruGrpMbrItemDtlSeq(rs.getString("mru_grp_mbr_item_dtl_seq")!=null?rs.getString("mru_grp_mbr_item_dtl_seq").toString():"");
			model.setOrderCodeId(rs.getInt("order_code_id"));
			model.setSourceCodeId(rs.getInt("source_code_id"));
			model.setBundleQty(rs.getString("bundle_qty")!=null?rs.getString("bundle_qty").toString():"");
			model.setOrderQty(rs.getString("order_qty")!=null?rs.getString("order_qty").toString():"");
			model.setShipQty(rs.getString("ship_qty")!=null?rs.getString("ship_qty").toString():"");
			model.setBackordQty(rs.getString("backord_qty")!=null?rs.getString("backord_qty").toString():"");
			model.setCurrency(rs.getString("currency")!=null?rs.getString("currency").toString():"");
			model.setDeliveryMethod(rs.getString("delivery_method")!=null?rs.getString("delivery_method").toString():"");
			model.setBillingType(new PropertyUtilityClass().getConstantValue("billing_type_" + rs.getString("billing_type")));
			model.setFullName(rs.getString("fname")+" "+rs.getString("lname")+" "+rs.getString("address"));
			model.setBillingName(rs.getString("fname")+" "+rs.getString("lname")+" "+rs.getString("address"));
			model.setRenewalName(rs.getString("fname")+" "+rs.getString("lname")+" "+rs.getString("address"));
			model.setStartIssueId(rs.getString("start_issue_id")!=null?rs.getString("start_issue_id").toString():"");
			model.setStopIssueId(rs.getString("stop_issue_id")!=null?rs.getString("stop_issue_id").toString():"");
			model.setSubscriptionDefId(rs.getString("subscription_def_id")!=null?rs.getString("subscription_def_id").toString():"");
			model.setStartDate(rs.getString("start_date")!=null?rs.getString("start_date").toString():"");
			model.setExpireDate(rs.getString("expire_date")!=null?rs.getString("expire_date").toString():"");
			model.setnNonpaidIssues(rs.getString("n_nonpaid_issues")!=null?rs.getString("n_nonpaid_issues").toString():"");
			model.setnRemainingNonpaidIssues(rs.getString("n_remaining_nonpaid_issues")!=null?rs.getString("n_nonpaid_issues").toString():"");
			model.setAgencyCustomerId(rs.getString("agency_customer_id")!=null?rs.getString("agency_customer_id").toString():"");
			model.setOrderCategory(rs.getString("order_category")!=null?rs.getString("order_category").toString():"");
			model.setSubscripId(rs.getString("subscrip_id")!=null?rs.getString("subscrip_id").toString():"");
			model.setPackageContentSeq(rs.getString("package_content_seq")!=null?rs.getString("package_content_seq").toString():"");
			model.setLastInvDate(rs.getString("last_inv_date")!=null?rs.getString("last_inv_date").toString():"");
			model.setAuditQualCategory(rs.getString("audit_qual_category")!=null?rs.getString("audit_qual_category").toString():"");
			model.setCancelReason(rs.getString("cancel_reason")!=null?rs.getString("cancel_reason").toString():"");
			model.setCustomerGroupId(rs.getString("customer_group_id")!=null?rs.getString("customer_group_id").toString():"");
			model.setAuditQualSourceId(rs.getString("audit_qual_source_id")!=null?rs.getString("audit_qual_source_id").toString():"");
			model.setAuditSubscriptionTypeId(rs.getString("audit_subscription_type_id")!=null?rs.getString("audit_subscription_type_id").toString():"");
			model.setPercentOfBasicPrice(rs.getString("percent_of_basic_price")!=null?rs.getString("percent_of_basic_price").toString():"");
			model.setnRenEffort(rs.getString("n_ren_effort")!=null?rs.getString("n_ren_effort").toString():"");
			model.setLastRenDate(rs.getString("last_ren_date")!=null?rs.getString("last_ren_date").toString():"");
			model.setnDelIssLeft(rs.getString("n_del_iss_left")!=null?rs.getString("n_del_iss_left").toString():"");
			model.setAuditNameTitleId(rs.getString("audit_name_title_id")!=null?rs.getString("audit_name_title_id").toString():"");
			model.setAuditSalesChannelId(rs.getString("audit_sales_channel_id")!=null?rs.getString("audit_sales_channel_id").toString():"");
			model.setQualDate(rs.getString("qual_date")!=null?rs.getString("qual_date").toString():"");
			model.setSqualDate(rs.getString("squal_date")!=null?rs.getString("squal_date").toString():"");
			model.setPubRotationId(rs.getString("pub_rotation_id")!=null?rs.getString("pub_rotation_id").toString():"");
			model.setPremToOrderItemSeq(rs.getString("prem_to_order_item_seq")!=null?rs.getString("prem_to_order_item_seq").toString():"");
			model.setDiscountClassId(rs.getString("discount_class_id")!=null?rs.getString("discount_class_id").toString():"");
			model.setDiscClassEffectiveSeq(rs.getString("disc_class_effective_seq")!=null?rs.getString("disc_class_effective_seq").toString():"");
			model.setDiscountCardSeq(rs.getString("discount_card_seq")!=null?rs.getString("discount_card_seq").toString():"");
			model.setInstallmentPlanId(rs.getString("installment_plan_id")!=null?rs.getString("installment_plan_id").toString():"");
			model.setNumberVolumeSets(rs.getString("number_volume_sets")!=null?rs.getString("number_volume_sets").toString():"");					
			model.setAltShipDelCalc(rs.getString("alt_ship_del_calc")!=null?rs.getString("alt_ship_del_calc").toString():"");
			model.setDistributionMethod(rs.getString("distribution_method")!=null?rs.getString("distribution_method").toString():"");
			model.setBillingDef(rs.getString("billing_def")!=null?rs.getString("billing_def").toString():"");
			model.setBillingDefTestSeq(rs.getString("billing_def_test_seq")!=null?rs.getString("billing_def_test_seq").toString():"");
			model.setRenewalDef(rs.getString("renewal_def")!=null?rs.getString("renewal_def").toString():"");
			model.setRenewalDefTestSeq(rs.getString("renewal_def_test_seq")!=null?rs.getString("renewal_def_test_seq").toString():"");
			model.setAgentRefNbr(rs.getString("agent_ref_nbr")!=null?rs.getString("agent_ref_nbr").toString():"");
			model.setMruSuspensionSeq(rs.getString("mru_suspension_seq")==null?rs.getString("mru_suspension_seq").toString():"");
			model.setMruOrderItemShipSeq(rs.getString("mru_order_item_ship_seq")!=null?rs.getString("mru_order_item_ship_seq").toString():"");
			model.setMruBillingHistorySeq(rs.getString("mru_billing_history_seq")!=null?rs.getString("mru_billing_history_seq").toString():"");
			model.setMruOrderItemSglIssuesSeq(rs.getString("mru_order_item_sgl_issues_seq")!=null?rs.getString("mru_order_item_sgl_issues_seq").toString():"");
			model.setElectronicDocumentIdentifier(rs.getString("electronic_document_identifier")!=null?rs.getString("electronic_document_identifier").toString():"");
			model.setUnitTypeId(rs.getString("unit_type_id")!=null?rs.getString("unit_type_id").toString():"");
			model.setTrialPeriod(rs.getString("trial_period")!=null?rs.getString("trial_period").toString():"");
			model.setMruUnitHistorySeq(rs.getString("mru_unit_history_seq")!=null?rs.getString("mru_unit_history_seq").toString():"");
			model.setnNonpaidIssues(rs.getString("n_nonpaid_issues")!=null?rs.getString("n_nonpaid_issues").toString():"");
			model.setnRemainingNonpaidIssues(rs.getString("n_remaining_nonpaid_issues")!=null?rs.getString("n_remaining_nonpaid_issues").toString():"");
			model.setnCalUnitsPerSeg(rs.getString("n_cal_units_per_seg")!=null?rs.getString("n_cal_units_per_seg").toString():"");
			model.setSegmentExpireDate(rs.getString("segment_expire_date")!=null?rs.getString("segment_expire_date").toString():"");
			model.setCalendarUnit(rs.getString("calendar_unit")!=null?rs.getString("calendar_unit").toString():"");
			model.setnItemsPerSeg(rs.getString("n_items_per_seg")!=null?rs.getString("n_items_per_seg").toString():"");
			model.setnSegmentsLeft(rs.getString("n_segments_left")!=null?rs.getString("n_segments_left").toString():"");
			model.setMruOrderItemNoteSeq(rs.getString("mru_order_item_note_seq")!=null?rs.getString("mru_order_item_note_seq").toString():"");
			model.setRenewedFromSubscripId(rs.getString("renewed_from_subscrip_id")!=null?rs.getString("renewed_from_subscrip_id").toString():"");
			model.setPkgItemSeq(rs.getString("pkg_item_seq")!=null?rs.getString("pkg_item_seq").toString():"");
			model.setPkgDefId(rs.getString("pkg_def_id")!=null?rs.getString("pkg_def_id").toString():"");
			model.setItemUrl(rs.getString("item_url")!=null?rs.getString("item_url").toString():"");
			model.setPaymentAccountSeq(rs.getString("payment_account_seq")!=null?rs.getString("payment_account_seq").toString():"");
			model.setMaxCheckOutAmt(rs.getString("max_check_out_amt")!=null?rs.getString("max_check_out_amt").toString():"");
			model.setDealId(rs.getString("deal_id")!=null?rs.getString("deal_id").toString():"");
			model.setInvoiceId(rs.getString("invoice_id")!=null?rs.getString("invoice_id").toString():"");
			model.setFulfillmentDate(rs.getString("fulfillment_date")!=null?rs.getString("fulfillment_date").toString():"");
			model.setMultilineDiscountSchedule(rs.getString("multiline_discount_schedule")!=null?rs.getString("multiline_discount_schedule").toString():"");
			model.setMultilineDiscAmount(rs.getString("multiline_disc_amount")!=null?rs.getString("multiline_disc_amount").toString():"");
			model.setMultilineDiscEffSeq(rs.getString("multiline_disc_eff_seq")!=null?rs.getString("multiline_disc_eff_seq").toString():"");
			model.setShippingPriceList(rs.getString("shipping_price_list")!=null?rs.getString("shipping_price_list").toString():"");
			model.setExtendedRate(rs.getString("extended_rate")!=null?rs.getString("extended_rate").toString():"");		
			model.setAttachExist(rs.getString("attach_exist")!=null?rs.getString("attach_exist").toString():"");
			model.setAddonToOrderhdrId(rs.getString("addon_to_orderhdr_id")!=null?rs.getString("addon_to_orderhdr_id").toString():"");
			model.setAddonToOrderItemSeq(rs.getString("addon_to_order_item_seq")!=null?rs.getString("addon_to_order_item_seq").toString():"");
			model.setGenericPromotionCodeSeq(rs.getString("generic_promotion_code_seq")!=null?rs.getString("generic_promotion_code_seq").toString():"");
			model.setChargeOnCancellation(rs.getString("charge_on_cancellation")!=null?rs.getString("charge_on_cancellation").toString():"");
			model.setLastTaxInvoiceDate(rs.getString("last_tax_invoice_date")!=null?rs.getString("last_tax_invoice_date").toString():"");
			model.setCancelDate(rs.getString("cancel_date")!=null?rs.getString("cancel_date").toString():"");
			model.setManualDiscAmtBase(rs.getString("manual_disc_amt_base")!=null?rs.getString("manual_disc_amt_base").toString():"");
			model.setManualDiscAmtLocal(rs.getString("manual_disc_amt_local")!=null?rs.getString("manual_disc_amt_local").toString():"");
			model.setManualDiscPercentage(rs.getString("manual_disc_percentage")!=null?rs.getString("manual_disc_percentage").toString():"");
			model.setnInvEfforts(rs.getString("n_inv_efforts")!=null?rs.getString("n_inv_efforts").toString():"");
			model.setnIssuesLeft(rs.getString("n_issues_left")!=null?rs.getString("n_issues_left").toString():"");
			model.setPackageId(rs.getString("package_id")!=null?rs.getString("package_id").toString():"");
			model.setRatecardSeq(rs.getString("ratecard_seq")!=null?rs.getString("ratecard_seq").toString():"");
			}catch(Exception e) {
			System.out.println("Exception:"+e);
		}
		return model;
	}
}
