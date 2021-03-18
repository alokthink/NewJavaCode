package com.mps.think.model;

public class ShippingModel {

	private String description;
	private String orderClass;	
	private String orderCode;
	private String ocId;
	private double localAmount;
	private double baseAmount;
	private int bundleQty;
	private int orderQty;
	private String shipQty;
	private String backordQty;	
	private String deliveryMethod;
	private String billingType;
	private String currency;
	private String exchangeRate;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
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
	public String getOrderClass() {
		return orderClass;
	}
	public void setOrderClass(String orderClass) {
		this.orderClass = orderClass;
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
	public String getShipQty() {
		return shipQty;
	}
	public void setShipQty(String shipQty) {
		this.shipQty = shipQty;
	}
	public String getBackordQty() {
		return backordQty;
	}
	public void setBackordQty(String backordQty) {
		this.backordQty = backordQty;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOcId() {
		return ocId;
	}
	public void setOcId(String ocId) {
		this.ocId = ocId;
	}
	
	 
}
