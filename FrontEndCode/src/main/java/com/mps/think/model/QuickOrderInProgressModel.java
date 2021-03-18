package com.mps.think.model;

public class QuickOrderInProgressModel 
{
	private int line;
	private String orderClass;
	private String orderCode;
	private int bundleQty;
	private int orderQty;
	private int shipQty;
	private int backordQty;
	private String ocId;
	private double localAmount;
	private double baseAmount;
	private String billingType;
	/*private double amount_charged;*/
	private String currency;
	private String delivery_method=null;
	private String billing_type="Balance Due";
	private String n_del_iss_left=null;
	private String n_inv_efforts=null;
	private String order_date;	
	private String n_ren_effort=null;
	private String agency_customer_id=null;
	private String renewal_orderhdr_id=null;
	//private String n_issues_left;
	private String change_qty_flag="False";
	private String is_complimentary="True";
	//private double net_base_amount;
	private String order_category=null;
	private String user_code;
	private int orderhdr_id=-1;
	private String refund_status="No Refund";
	private String bill_date;
	private String package_content_seq=null;
	private String percent_of_basic_price=null;
	//private double net_local_amount;
	private String payment_status="No Payment";
	//private String subscrip_id;
	private String has_premium="False";
	private String renew_to_customer_id;
	private String renewal_order_item_seq=null;
	//private String pkg_def;
	private String customer_group_id=null;
	//private String renewal_status;
	private String inventory_id;
	//private String stop_issue_id;
	private String customer_address_seq;
	private int prepayment_req=1;
	private String cancel_reason=null;
	private String pkg_item_seq=null;
	private String renewed_frm_subscrip=null;
	
	
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	
	public String getOrderClass() {
		return orderClass;
	}
	public void setOrderClass(String orderClass) {
		this.orderClass = orderClass;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getBundleQty() {
		return bundleQty;
	}
	public void setBundleQty(int bundleQty) {
		this.bundleQty = bundleQty;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public int getShipQty() {
		return shipQty;
	}
	public void setShipQty(int shipQty) {
		this.shipQty = shipQty;
	}
	public int getBackordQty() {
		return backordQty;
	}
	public void setBackordQty(int backordQty) {
		this.backordQty = backordQty;
	}
	public String getOcId() {
		return ocId;
	}
	public void setOcId(String ocId) {
		this.ocId = ocId;
	}
	public double getLocalAmount() {
		return localAmount;
	}
	public void setLocalAmount(double localAmount) {
		this.localAmount = localAmount;
	}
	public double getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDelivery_method() {
		return delivery_method;
	}
	public void setDelivery_method(String delivery_method) {
		this.delivery_method = delivery_method;
	}
	public String getBilling_type() {
		return billing_type;
	}
	public void setBilling_type(String billing_type) {
		this.billing_type = billing_type;
	}
	public String getN_del_iss_left() {
		return n_del_iss_left;
	}
	public void setN_del_iss_left(String n_del_iss_left) {
		this.n_del_iss_left = n_del_iss_left;
	}
	public String getN_inv_efforts() {
		return n_inv_efforts;
	}
	public void setN_inv_efforts(String n_inv_efforts) {
		this.n_inv_efforts = n_inv_efforts;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getN_ren_effort() {
		return n_ren_effort;
	}
	public void setN_ren_effort(String n_ren_effort) {
		this.n_ren_effort = n_ren_effort;
	}
	public String getAgency_customer_id() {
		return agency_customer_id;
	}
	public void setAgency_customer_id(String agency_customer_id) {
		this.agency_customer_id = agency_customer_id;
	}
	public String getRenewal_orderhdr_id() {
		return renewal_orderhdr_id;
	}
	public void setRenewal_orderhdr_id(String renewal_orderhdr_id) {
		this.renewal_orderhdr_id = renewal_orderhdr_id;
	}
	public String getChange_qty_flag() {
		return change_qty_flag;
	}
	public void setChange_qty_flag(String change_qty_flag) {
		this.change_qty_flag = change_qty_flag;
	}
	public String getIs_complimentary() {
		return is_complimentary;
	}
	public void setIs_complimentary(String is_complimentary) {
		this.is_complimentary = is_complimentary;
	}
	public String getOrder_category() {
		return order_category;
	}
	public void setOrder_category(String order_category) {
		this.order_category = order_category;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public int getOrderhdr_id() {
		return orderhdr_id;
	}
	public void setOrderhdr_id(int orderhdr_id) {
		this.orderhdr_id = orderhdr_id;
	}
	public String getRefund_status() {
		return refund_status;
	}
	public void setRefund_status(String refund_status) {
		this.refund_status = refund_status;
	}
	public String getBill_date() {
		return bill_date;
	}
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}
	public String getPackage_content_seq() {
		return package_content_seq;
	}
	public void setPackage_content_seq(String package_content_seq) {
		this.package_content_seq = package_content_seq;
	}
	public String getPercent_of_basic_price() {
		return percent_of_basic_price;
	}
	public void setPercent_of_basic_price(String percent_of_basic_price) {
		this.percent_of_basic_price = percent_of_basic_price;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public String getHas_premium() {
		return has_premium;
	}
	public void setHas_premium(String has_premium) {
		this.has_premium = has_premium;
	}
	public String getRenew_to_customer_id() {
		return renew_to_customer_id;
	}
	public void setRenew_to_customer_id(String renew_to_customer_id) {
		this.renew_to_customer_id = renew_to_customer_id;
	}
	public String getRenewal_order_item_seq() {
		return renewal_order_item_seq;
	}
	public void setRenewal_order_item_seq(String renewal_order_item_seq) {
		this.renewal_order_item_seq = renewal_order_item_seq;
	}
	public String getCustomer_group_id() {
		return customer_group_id;
	}
	public void setCustomer_group_id(String customer_group_id) {
		this.customer_group_id = customer_group_id;
	}
	public String getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(String inventory_id) {
		this.inventory_id = inventory_id;
	}
	public String getCustomer_address_seq() {
		return customer_address_seq;
	}
	public void setCustomer_address_seq(String customer_address_seq) {
		this.customer_address_seq = customer_address_seq;
	}
	public int getPrepayment_req() {
		return prepayment_req;
	}
	public void setPrepayment_req(int prepayment_req) {
		this.prepayment_req = prepayment_req;
	}
	public String getCancel_reason() {
		return cancel_reason;
	}
	public void setCancel_reason(String cancel_reason) {
		this.cancel_reason = cancel_reason;
	}
	public String getPkg_item_seq() {
		return pkg_item_seq;
	}
	public void setPkg_item_seq(String pkg_item_seq) {
		this.pkg_item_seq = pkg_item_seq;
	}
	public String getRenewed_frm_subscrip() {
		return renewed_frm_subscrip;
	}
	public void setRenewed_frm_subscrip(String renewed_frm_subscrip) {
		this.renewed_frm_subscrip = renewed_frm_subscrip;
	}
}
