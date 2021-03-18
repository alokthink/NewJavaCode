package com.mps.think.model;
import org.codehaus.jackson.annotate.JsonPropertyOrder;


@JsonPropertyOrder({"n","s","order","line","date","order_class","order_code","qty","liability","charged","order_status","pay_status","agency","bundle_qty","address_seq","subscrip_id","gross_base_amount","net_base_amount","net_local_amount","renewal","package_instance","ship_qty","backOrd_qty","customer_id","payerCustomer","orderId","orderItemSeq","currency","payAmount","doc_ref_id","refund_deposit_pay_amt","payment_clear_status"})
public class ExistingUnpaidOrdersModel 
{
	private int n;
	private int s;
	private int order;
	private int line;
	private String date;
	private String order_class;
	private String order_code;
	private int qty;
	private String liability; 
	private double charged;
	private String order_status;
	private String pay_status;
	private String agency;
	private int bundle_qty;
	private int address_seq;
	private String subscrip_id;
	private double gross_base_amount;
	private double net_base_amount;
	private double net_local_amount;
	private String renewal;
	private String package_instance;
	private String ship_qty;
	private String backOrd_qty;
	private int customer_id;
	private int payerCustomer;
	private int orderId;
	private int orderItemSeq;
	private String orderIdOrderseq;
	private String currency;
	private double payAmount;
	private double base_amount;
	private int doc_ref_id;
	private double refund_deposit_pay_amt;
	private int payment_clear_status;
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrder_class() {
		return order_class;
	}
	public void setOrder_class(String order_class) {
		this.order_class = order_class;
	}
	public String getOrder_code() {
		return order_code;
	}
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getLiability() {
		return liability;
	}
	public void setLiability(String liability) {
		this.liability = liability;
	}
	public double getCharged() {
		return charged;
	}
	public void setCharged(double charged) {
		this.charged = charged;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getPay_status() {
		return pay_status;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public int getBundle_qty() {
		return bundle_qty;
	}
	public void setBundle_qty(int bundle_qty) {
		this.bundle_qty = bundle_qty;
	}
	public int getAddress_seq() {
		return address_seq;
	}
	public void setAddress_seq(int address_seq) {
		this.address_seq = address_seq;
	}
	public String getSubscrip_id() {
		return subscrip_id;
	}
	public void setSubscrip_id(String subscrip_id) {
		this.subscrip_id = subscrip_id;
	}
	public double getGross_base_amount() {
		return gross_base_amount;
	}
	public void setGross_base_amount(double gross_base_amount) {
		this.gross_base_amount = gross_base_amount;
	}
	public double getNet_base_amount() {
		return net_base_amount;
	}
	public void setNet_base_amount(double net_base_amount) {
		this.net_base_amount = net_base_amount;
	}
	public double getNet_local_amount() {
		return net_local_amount;
	}
	public void setNet_local_amount(double net_local_amount) {
		this.net_local_amount = net_local_amount;
	}
	public String getRenewal() {
		return renewal;
	}
	public void setRenewal(String renewal) {
		this.renewal = renewal;
	}
	public String getPackage_instance() {
		return package_instance;
	}
	public void setPackage_instance(String package_instance) {
		this.package_instance = package_instance;
	}
	public String getShip_qty() {
		return ship_qty;
	}
	public void setShip_qty(String ship_qty) {
		this.ship_qty = ship_qty;
	}
	public String getBackOrd_qty() {
		return backOrd_qty;
	}
	public void setBackOrd_qty(String backOrd_qty) {
		this.backOrd_qty = backOrd_qty;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getPayerCustomer() {
		return payerCustomer;
	}
	public void setPayerCustomer(int payerCustomer) {
		this.payerCustomer = payerCustomer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(int orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	public String getOrderIdOrderseq() {
		return orderIdOrderseq;
	}
	public void setOrderIdOrderseq(String orderIdOrderseq) {
		this.orderIdOrderseq = orderIdOrderseq;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public double getBase_amount() {
		return base_amount;
	}
	public void setBase_amount(double base_amount) {
		this.base_amount = base_amount;
	}
	public int getDoc_ref_id() {
		return doc_ref_id;
	}
	public void setDoc_ref_id(int doc_ref_id) {
		this.doc_ref_id = doc_ref_id;
	}
	public double getRefund_deposit_pay_amt() {
		return refund_deposit_pay_amt;
	}
	public void setRefund_deposit_pay_amt(double refund_deposit_pay_amt) {
		this.refund_deposit_pay_amt = refund_deposit_pay_amt;
	}
	public int getPayment_clear_status() {
		return payment_clear_status;
	}
	public void setPayment_clear_status(int payment_clear_status) {
		this.payment_clear_status = payment_clear_status;
	}
}