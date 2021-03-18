package com.mps.think.model;

public class PackageMemberModel {

	private int orderCodeId;
	private int orderCodeType;
	private int ocId;
	private String issueId;
	private String StartDate;
	private String orderCode;
	private String description;
	private String address;
	private String currency;
	private float itemAmount;
	private float taxAmount;
	private int customerId;
	private double localAmount;
	private String state;
    private double baseAmount;
    private RatecardModel ratecardModel;
    private String orderStatus;
    private double itemAmt;
    private int  subscriptionDefId;
    private int pkgDefId;
    private int productId;
    private int orderItemId;

	public RatecardModel getRatecardModel() {
		return ratecardModel;
	}
	public void setRatecardModel(RatecardModel ratecardModel) {
		this.ratecardModel = ratecardModel;
	}
	public int getOrderCodeId() {
		return orderCodeId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setOrderCodeId(int orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
	public int getOrderCodeType() {
		return orderCodeType;
	}
	public void setOrderCodeType(int orderCodeType) {
		this.orderCodeType = orderCodeType;
	}
	public int getOcId() {
		return ocId;
	}
	public void setOcId(int ocId) {
		this.ocId = ocId;
	}
	public String getIssueId() {
		return issueId;
	}
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(float itemAmount) {
		this.itemAmount = itemAmount;
	}
	public float getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getItemAmt() {
		return itemAmt;
	}
	public void setItemAmt(double itemAmt) {
		this.itemAmt = itemAmt;
	}
	public int getSubscriptionDefId() {
		return subscriptionDefId;
	}
	public void setSubscriptionDefId(int subscriptionDefId) {
		this.subscriptionDefId = subscriptionDefId;
	}
	public int getPkgDefId() {
		return pkgDefId;
	}
	public void setPkgDefId(int pkgDefId) {
		this.pkgDefId = pkgDefId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	
	
	
}
