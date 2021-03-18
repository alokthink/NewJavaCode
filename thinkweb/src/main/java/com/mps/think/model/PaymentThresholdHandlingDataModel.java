package com.mps.think.model;

import java.util.Map;

public class PaymentThresholdHandlingDataModel 
{
	private String order_class;
	private String term;
	private String start_date;
	private String source_code;
	private double order_amount;
	//private double order_amount_bymycalc;
	private String currency;
	private int customer_nbr;
	private int order_nbr=-1;
	private int line_item=-2;
	private String order_date;
	private double totalPaid;
	private Map<String, Object> underOverPaymentOptions;
	private String expiration_date;
	private int order_quantity;
	private int remaining_issues;
	private int number_of_days;
	private double subscription;
	//private double subscription_bymycalc;
	private double delivery=0.00;
	private double tax=0.00;
	private Map<Integer, String>start_dates_map;
	
	
	
	
	public Map<Integer, String> getStart_dates_map() {
		return start_dates_map;
	}
	public void setStart_dates_map(Map<Integer, String> start_dates_map) {
		this.start_dates_map = start_dates_map;
	}
	/*Used for testing 
	 public double getOrder_amount_bymycalc() {
		return order_amount_bymycalc;
	}
	public void setOrder_amount_bymycalc(double order_amount_bymycalc) {
		this.order_amount_bymycalc = order_amount_bymycalc;
	}
	public double getSubscription_bymycalc() {
		return subscription_bymycalc;
	}
	public void setSubscription_bymycalc(double subscription_bymycalc) {
		this.subscription_bymycalc = subscription_bymycalc;
	}*/
	public Map<String, Object> getUnderOverPaymentOptions() {
		return underOverPaymentOptions;
	}
	public void setUnderOverPaymentOptions(Map<String, Object> underOverPaymentOptions) {
		this.underOverPaymentOptions = underOverPaymentOptions;
	}
	public String getOrder_class() {
		return order_class;
	}
	public void setOrder_class(String order_class) {
		this.order_class = order_class;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getSource_code() {
		return source_code;
	}
	public void setSource_code(String source_code) {
		this.source_code = source_code;
	}
	public double getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getCustomer_nbr() {
		return customer_nbr;
	}
	public void setCustomer_nbr(int customer_nbr) {
		this.customer_nbr = customer_nbr;
	}
	public int getOrder_nbr() {
		return order_nbr;
	}
	public void setOrder_nbr(int order_nbr) {
		this.order_nbr = order_nbr;
	}
	public int getLine_item() {
		return line_item;
	}
	public void setLine_item(int line_item) {
		this.line_item = line_item;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public double getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public int getRemaining_issues() {
		return remaining_issues;
	}
	public void setRemaining_issues(int remaining_issues) {
		this.remaining_issues = remaining_issues;
	}
	public double getSubscription() {
		return subscription;
	}
	public void setSubscription(double subscription) {
		this.subscription = subscription;
	}
	public double getDelivery() {
		return delivery;
	}
	public void setDelivery(double delivery) {
		this.delivery = delivery;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public int getNumber_of_days() {
		return number_of_days;
	}
	public void setNumber_of_days(int number_of_days) {
		this.number_of_days = number_of_days;
	}
}