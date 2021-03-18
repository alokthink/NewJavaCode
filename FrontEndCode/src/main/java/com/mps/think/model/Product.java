package com.mps.think.model;

public class Product {
	private int productId;
	private String inventoryId;	
	/*private String grossBaseAmount;
	private String grossLocalAmount;
	private String netBaseAmount;
	private String netLocalAmount;*/
	private String description;
	private String orderCode;
	private String ocId;
	private String productSize;
	private String productStyle;
	private String productColor;
	private String price;
	private String rateClassId;
	private String product;
	private double localAmount;
	private double baseAmount;
	private String orderClass;	
	private int bundleQty;
	private int orderQty;
	private String shipQty;
	private String backordQty;	
	private String deliveryMethod;
	private String billingType;
	private String currency;
	private String exchangeRate;
	private String orderCodeId;
	
	public String getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(String orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
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
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductStyle() {
		return productStyle;
	}
	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(String rateClassId) {
		this.rateClassId = rateClassId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	/*public String getGrossBaseAmount() {
		return grossBaseAmount;
	}
	public void setGrossBaseAmount(String grossBaseAmount) {
		this.grossBaseAmount = grossBaseAmount;
	}
	public String getGrossLocalAmount() {
		return grossLocalAmount;
	}
	public void setGrossLocalAmount(String grossLocalAmount) {
		this.grossLocalAmount = grossLocalAmount;
	}
	public String getNetBaseAmount() {
		return netBaseAmount;
	}
	public void setNetBaseAmount(String netBaseAmount) {
		this.netBaseAmount = netBaseAmount;
	}
	public String getNetLocalAmount() {
		return netLocalAmount;
	}
	public void setNetLocalAmount(String netLocalAmount) {
		this.netLocalAmount = netLocalAmount;
	}*/
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", inventoryId=" + inventoryId + ", description=" + description
				+ ", orderCode=" + orderCode + ", ocId=" + ocId + ", productSize=" + productSize + ", productStyle="
				+ productStyle + ", productColor=" + productColor + ", price=" + price + ", rateClassId=" + rateClassId
				+ ", product=" + product + ", localAmount=" + localAmount + ", baseAmount=" + baseAmount
				+ ", orderClass=" + orderClass + ", bundleQty=" + bundleQty + ", orderQty=" + orderQty + ", shipQty="
				+ shipQty + ", backordQty=" + backordQty + ", deliveryMethod=" + deliveryMethod + ", billingType="
				+ billingType + "]";
	}

	
	
	
}
