package com.mps.think.model;

public class CustomerOrderModel {

	private long orderhdr_id;
	private long subscrip_id;
	private String ocId;
	private int order_item_seq;
	private String date;
	private String oc_id;
	private String orderCode;
	private String order_code_id;
	private String orderCodeId;
	private long order_qty;
	private String n_issues_left;
	private double charged;
	private String order_status;
	private String orderStatusId;
	private String payment_status;
	private String agency;
	private long bundle_qty;
	private int orderItemType;
	private int noCharge;
	private int orderCodeType;
	private String start_date;
	private String expire_date;
	private String order_date;
    private String billToCustomerId;
    private int orderQty;
    private String currency;
    private String customer_id;
    private String renewal_orderhdr_id;
    private String start_issue_id;
    private String stop_issue_id;
    public String getStart_issue_id() {
		return start_issue_id;
	}
	public void setStart_issue_id(String start_issue_id) {
		this.start_issue_id = start_issue_id;
	}
	public String getStop_issue_id() {
		return stop_issue_id;
	}
	public void setStop_issue_id(String stop_issue_id) {
		this.stop_issue_id = stop_issue_id;
	}
	private int billing_type;
    private int is_proforma;
    private int note_exist; 
    private int service_exist;
    private int attach_exist;
    private String customer_address_seq;
    private String agency_customer_id;
    private String backord_qty;
    private String ship_qty;
	private int group_order;
    private String cancel_reason;
    private String gross_local_amount;
    private String gross_base_amount;
    private String net_base_amount;
    private String net_local_amount;
    private String subscrip_start_type;
    private String localAmount;
    private String baseAmount;
    private String renew_start_date;
    private String renew_expire_date;
    private String pageName;
    private String unitExcess;
    private String unitTypeId;
    private String mruUnitHistorySeq;
    private int dateStamp;
    private int installAutoPayment;
    private int cancelDD;
    private int subscriptionDefId;
    private int upsellOn;
    private int audited;  
    private int QP; 
    private int QF; 
    private int NQP; 
    private int NQF; 
    private String inventory_id;
    private double due;
    private double pay;
    
    
	public double getDue() {
		return due;
	}
	public void setDue(double due) {
		this.due = due;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public int getInstallAutoPayment() {
		return installAutoPayment;
	}
	public void setInstallAutoPayment(int installAutoPayment) {
		this.installAutoPayment = installAutoPayment;
	}
	public int getCancelDD() {
		return cancelDD;
	}
	public void setCancelDD(int cancelDD) {
		this.cancelDD = cancelDD;
	}
	public String getUnitExcess() {
		return unitExcess;
	}
	public void setUnitExcess(String unitExcess) {
		this.unitExcess = unitExcess;
	}
	public String getUnitTypeId() {
		return unitTypeId;
	}
	public void setUnitTypeId(String unitTypeId) {
		this.unitTypeId = unitTypeId;
	}
	public String getMruUnitHistorySeq() {
		return mruUnitHistorySeq;
	}
	public void setMruUnitHistorySeq(String mruUnitHistorySeq) {
		this.mruUnitHistorySeq = mruUnitHistorySeq;
	}
	public int getDateStamp() {
		return dateStamp;
	}
	public void setDateStamp(int dateStamp) {
		this.dateStamp = dateStamp;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getRenew_start_date() {
		return renew_start_date;
	}
	public void setRenew_start_date(String renew_start_date) {
		this.renew_start_date = renew_start_date;
	}
	public String getRenew_expire_date() {
		return renew_expire_date;
	}
	public void setRenew_expire_date(String renew_expire_date) {
		this.renew_expire_date = renew_expire_date;
	}
	public String getSubscrip_start_type() {
		return subscrip_start_type;
	}
	public void setSubscrip_start_type(String subscrip_start_type) {
		this.subscrip_start_type = subscrip_start_type;
	}
	public String getLocalAmount() {
		return localAmount;
	}
	public void setLocalAmount(String localAmount) {
		this.localAmount = localAmount;
	}
	public String getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(String baseAmount) {
		this.baseAmount = baseAmount;
	}
	public int getNoCharge() {
		return noCharge;
	}
	public void setNoCharge(int noCharge) {
		this.noCharge = noCharge;
	}
	public String getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(String orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
   
	public String getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public int getOrderCodeType() {
		return orderCodeType;
	}
	public void setOrderCodeType(int orderCodeType) {
		this.orderCodeType = orderCodeType;
	}
	public String getOcId() {
		return ocId;
	}
	public void setOcId(String ocId) {
		this.ocId = ocId;
	}
	
	
	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	
	public double getCharged() {
		return charged;
	}
	public void setCharged(double charged) {
		this.charged = charged;
	}
	
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	public int getOrderItemType() {
		return orderItemType;
	}
	public void setOrderItemType(int orderItemType) {
		this.orderItemType = orderItemType;
	}
	
	public String getBillToCustomerId() {
		return billToCustomerId;
	}
	public void setBillToCustomerId(String billToCustomerId) {
		this.billToCustomerId = billToCustomerId;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
		
	public long getOrderhdr_id() {
		return orderhdr_id;
	}
	public void setOrderhdr_id(long orderhdr_id) {
		this.orderhdr_id = orderhdr_id;
	}
	public long getSubscrip_id() {
		return subscrip_id;
	}
	public void setSubscrip_id(long subscrip_id) {
		this.subscrip_id = subscrip_id;
	}
	public int getOrder_item_seq() {
		return order_item_seq;
	}
	public void setOrder_item_seq(int order_item_seq) {
		this.order_item_seq = order_item_seq;
	}
	public String getOc_id() {
		return oc_id;
	}
	public void setOc_id(String oc_id) {
		this.oc_id = oc_id;
	}
	public String getOrder_code_id() {
		return order_code_id;
	}
	public void setOrder_code_id(String order_code_id) {
		this.order_code_id = order_code_id;
	}
	public long getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(long order_qty) {
		this.order_qty = order_qty;
	}
	public String getN_issues_left() {
		return n_issues_left;
	}
	public void setN_issues_left(String n_issues_left) {
		this.n_issues_left = n_issues_left;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public long getBundle_qty() {
		return bundle_qty;
	}
	public void setBundle_qty(long bundle_qty) {
		this.bundle_qty = bundle_qty;
	}
	public String getExpire_date() {
		return expire_date;
	}
	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getRenewal_orderhdr_id() {
		return renewal_orderhdr_id;
	}
	public void setRenewal_orderhdr_id(String renewal_orderhdr_id) {
		this.renewal_orderhdr_id = renewal_orderhdr_id;
	}
	public int getBilling_type() {
		return billing_type;
	}
	public void setBilling_type(int billing_type) {
		this.billing_type = billing_type;
	}
	public int getIs_proforma() {
		return is_proforma;
	}
	public void setIs_proforma(int is_proforma) {
		this.is_proforma = is_proforma;
	}
	public int getNote_exist() {
		return note_exist;
	}
	public void setNote_exist(int note_exist) {
		this.note_exist = note_exist;
	}
	public int getService_exist() {
		return service_exist;
	}
	public void setService_exist(int service_exist) {
		this.service_exist = service_exist;
	}
	public int getAttach_exist() {
		return attach_exist;
	}
	public void setAttach_exist(int attach_exist) {
		this.attach_exist = attach_exist;
	}
	public String getCustomer_address_seq() {
		return customer_address_seq;
	}
	public void setCustomer_address_seq(String customer_address_seq) {
		this.customer_address_seq = customer_address_seq;
	}
	public String getAgency_customer_id() {
		return agency_customer_id;
	}
	public void setAgency_customer_id(String agency_customer_id) {
		this.agency_customer_id = agency_customer_id;
	}
	public String getBackord_qty() {
		return backord_qty;
	}
	public void setBackord_qty(String backord_qty) {
		this.backord_qty = backord_qty;
	}
	public String getShip_qty() {
		return ship_qty;
	}
	public void setShip_qty(String ship_qty) {
		this.ship_qty = ship_qty;
	}
	public int getGroup_order() {
		return group_order;
	}
	public void setGroup_order(int group_order) {
		this.group_order = group_order;
	}
	public String getCancel_reason() {
		return cancel_reason;
	}
	public void setCancel_reason(String cancel_reason) {
		this.cancel_reason = cancel_reason;
	}
	public String getGross_local_amount() {
		return gross_local_amount;
	}
	public void setGross_local_amount(String gross_local_amount) {
		this.gross_local_amount = gross_local_amount;
	}
	public String getGross_base_amount() {
		return gross_base_amount;
	}
	public void setGross_base_amount(String gross_base_amount) {
		this.gross_base_amount = gross_base_amount;
	}
	public String getNet_base_amount() {
		return net_base_amount;
	}
	public void setNet_base_amount(String net_base_amount) {
		this.net_base_amount = net_base_amount;
	}
	public String getNet_local_amount() {
		return net_local_amount;
	}
	public void setNet_local_amount(String net_local_amount) {
		this.net_local_amount = net_local_amount;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public int getSubscriptionDefId() {
		return subscriptionDefId;
	}
	public void setSubscriptionDefId(int subscriptionDefId) {
		this.subscriptionDefId = subscriptionDefId;
	}
	public int getUpsellOn() {
		return upsellOn;
	}
	public void setUpsellOn(int upsellOn) {
		this.upsellOn = upsellOn;
	}
	public int getAudited() {
		return audited;
	}
	public void setAudited(int audited) {
		this.audited = audited;
	}
	public String getInventory_id() {
		return inventory_id;
	}
	public void setInventory_id(String inventory_id) {
		this.inventory_id = inventory_id;
	}
	
	public int getQP() {
		return QP;
	}
	public void setQP(int qP) {
		QP = qP;
	}
	public int getQF() {
		return QF;
	}
	public void setQF(int qF) {
		QF = qF;
	}
	public int getNQP() {
		return NQP;
	}
	public void setNQP(int nQP) {
		NQP = nQP;
	}
	public int getNQF() {
		return NQF;
	}
	public void setNQF(int nQF) {
		NQF = nQF;
	}
	@Override
	public String toString() {
		return "CustomerOrderModel [orderhdr_id=" + orderhdr_id + ", subscrip_id=" + subscrip_id + ", ocId=" + ocId
				+ ", order_item_seq=" + order_item_seq + ", date=" + date + ", oc_id=" + oc_id + ", orderCode="
				+ orderCode + ", order_code_id=" + order_code_id + ", orderCodeId=" + orderCodeId + ", order_qty="
				+ order_qty + ", n_issues_left=" + n_issues_left + ", charged=" + charged + ", order_status="
				+ order_status + ", orderStatusId=" + orderStatusId + ", payment_status=" + payment_status + ", agency="
				+ agency + ", bundle_qty=" + bundle_qty + ", orderItemType=" + orderItemType + ", noCharge=" + noCharge
				+ ", orderCodeType=" + orderCodeType + ", start_date=" + start_date + ", expire_date=" + expire_date
				+ ", order_date=" + order_date + ", billToCustomerId=" + billToCustomerId + ", orderQty=" + orderQty
				+ ", currency=" + currency + ", customer_id=" + customer_id + ", renewal_orderhdr_id="
				+ renewal_orderhdr_id + ", startIssue=" + start_issue_id + ", stopIssue=" + stop_issue_id + ", billing_type="
				+ billing_type + ", is_proforma=" + is_proforma + ", note_exist=" + note_exist + ", service_exist="
				+ service_exist + ", attach_exist=" + attach_exist + ", customer_address_seq=" + customer_address_seq
				+ ", agency_customer_id=" + agency_customer_id + ", backord_qty=" + backord_qty + ", ship_qty="
				+ ship_qty + ", group_order=" + group_order + ", cancel_reason=" + cancel_reason
				+ ", gross_local_amount=" + gross_local_amount + ", gross_base_amount=" + gross_base_amount
				+ ", net_base_amount=" + net_base_amount + ", net_local_amount=" + net_local_amount
				+ ", subscrip_start_type=" + subscrip_start_type + ", localAmount=" + localAmount + ", baseAmount="
				+ baseAmount + ", renew_start_date=" + renew_start_date + ", renew_expire_date=" + renew_expire_date
				+ ", pageName=" + pageName + ", unitExcess=" + unitExcess + ", unitTypeId=" + unitTypeId
				+ ", mruUnitHistorySeq=" + mruUnitHistorySeq + ", dateStamp=" + dateStamp + ", installAutoPayment="
				+ installAutoPayment + ", cancelDD=" + cancelDD + ", subscriptionDefId=" + subscriptionDefId
				+ ", upsellOn=" + upsellOn + ", audited=" + audited + ", QP=" + QP + ", QF=" + QF + ", NQP=" + NQP
				+ ", NQF=" + NQF + ", inventory_id=" + inventory_id + "]";
	}
	
}