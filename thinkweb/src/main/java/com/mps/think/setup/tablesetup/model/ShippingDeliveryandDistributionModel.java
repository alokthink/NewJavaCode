package com.mps.think.setup.tablesetup.model;

public class ShippingDeliveryandDistributionModel {
	
	private String deliveryMethod;
	private String regionList;
	private String description;
	private Double amount;
	private String distributionMethod;
	private String modeTransport;
	private int mruDelMethodDefaultSeq;
	private int mruDistMethodDefaultSeq;
	private int mruDistMethodOverrideSeq;
	private int mruDelMethodOverrideSeq;
	private int active;
	private String segmentDelimiter;
	private String distributionAttribute;
	private int segmentOrder;
	private int requiredForDelivery;
	private int suppressPrinting;
	private String shippingMethod;
	private String shippingPriceList;
	private int taxOnShipping;
	private int inclOrderItemTax;
	private int chargeSubscriptions;
	private int chargeIssues;
	private int chargeProducts;
	private int chargePackages;
	private int shippingPriceLstDtlSeq;
	private String region;
	private String currency;
	private int fromQty;
	private int toQty;
	private double fromAmount;
	private double toAmount;
	private double shippingCharge;
	private double shippingPercent;
	private String mailingEntryPoint;
	private int entryPointType;
	private String fromPrefix;
	private String toPrefix;
	private int zone;
	private String transportMode;
	private int disMethodDefaultSeq;
	private String city;
	private String beginPostalRange;
	private String endPostalRange;
	private String state;
	private String distAttributeValue;
	private int validateValues;
	private int notDelivarable;
	private int allowedDelMethod;
	
	public int getValidateValues() {
		return validateValues;
	}
	public void setValidateValues(int validateValues) {
		this.validateValues = validateValues;
	}
	public int getNotDelivarable() {
		return notDelivarable;
	}
	public void setNotDelivarable(int notDelivarable) {
		this.notDelivarable = notDelivarable;
	}
	public int getAllowedDelMethod() {
		return allowedDelMethod;
	}
	public void setAllowedDelMethod(int allowedDelMethod) {
		this.allowedDelMethod = allowedDelMethod;
	}
	public String getDistAttributeValue() {
		return distAttributeValue;
	}
	public void setDistAttributeValue(String distAttributeValue) {
		this.distAttributeValue = distAttributeValue;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getDisMethodDefaultSeq() {
		return disMethodDefaultSeq;
	}
	public void setDisMethodDefaultSeq(int disMethodDefaultSeq) {
		this.disMethodDefaultSeq = disMethodDefaultSeq;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBeginPostalRange() {
		return beginPostalRange;
	}
	public void setBeginPostalRange(String beginPostalRange) {
		this.beginPostalRange = beginPostalRange;
	}
	public String getEndPostalRange() {
		return endPostalRange;
	}
	public void setEndPostalRange(String endPostalRange) {
		this.endPostalRange = endPostalRange;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String getMailingEntryPoint() {
		return mailingEntryPoint;
	}
	public void setMailingEntryPoint(String mailingEntryPoint) {
		this.mailingEntryPoint = mailingEntryPoint;
	}
	public int getEntryPointType() {
		return entryPointType;
	}
	public void setEntryPointType(int entryPointType) {
		this.entryPointType = entryPointType;
	}
	public String getFromPrefix() {
		return fromPrefix;
	}
	public void setFromPrefix(String fromPrefix) {
		this.fromPrefix = fromPrefix;
	}
	public String getToPrefix() {
		return toPrefix;
	}
	public void setToPrefix(String toPrefix) {
		this.toPrefix = toPrefix;
	}
	public int getZone() {
		return zone;
	}
	public void setZone(int zone) {
		this.zone = zone;
	}
	public int getShippingPriceLstDtlSeq() {
		return shippingPriceLstDtlSeq;
	}
	public void setShippingPriceLstDtlSeq(int shippingPriceLstDtlSeq) {
		this.shippingPriceLstDtlSeq = shippingPriceLstDtlSeq;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getFromQty() {
		return fromQty;
	}
	public void setFromQty(int fromQty) {
		this.fromQty = fromQty;
	}
	public int getToQty() {
		return toQty;
	}
	public void setToQty(int toQty) {
		this.toQty = toQty;
	}
	public double getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(double fromAmount) {
		this.fromAmount = fromAmount;
	}
	public double getToAmount() {
		return toAmount;
	}
	public void setToAmount(double toAmount) {
		this.toAmount = toAmount;
	}
	public double getShippingCharge() {
		return shippingCharge;
	}
	public void setShippingCharge(double shippingCharge) {
		this.shippingCharge = shippingCharge;
	}
	public double getShippingPercent() {
		return shippingPercent;
	}
	public void setShippingPercent(double shippingPercent) {
		this.shippingPercent = shippingPercent;
	}
	public String getShippingPriceList() {
		return shippingPriceList;
	}
	public void setShippingPriceList(String shippingPriceList) {
		this.shippingPriceList = shippingPriceList;
	}
	public int getTaxOnShipping() {
		return taxOnShipping;
	}
	public void setTaxOnShipping(int taxOnShipping) {
		this.taxOnShipping = taxOnShipping;
	}
	public int getInclOrderItemTax() {
		return inclOrderItemTax;
	}
	public void setInclOrderItemTax(int inclOrderItemTax) {
		this.inclOrderItemTax = inclOrderItemTax;
	}
	public int getChargeSubscriptions() {
		return chargeSubscriptions;
	}
	public void setChargeSubscriptions(int chargeSubscriptions) {
		this.chargeSubscriptions = chargeSubscriptions;
	}
	public int getChargeIssues() {
		return chargeIssues;
	}
	public void setChargeIssues(int chargeIssues) {
		this.chargeIssues = chargeIssues;
	}
	public int getChargeProducts() {
		return chargeProducts;
	}
	public void setChargeProducts(int chargeProducts) {
		this.chargeProducts = chargeProducts;
	}
	public int getChargePackages() {
		return chargePackages;
	}
	public void setChargePackages(int chargePackages) {
		this.chargePackages = chargePackages;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getDistributionAttribute() {
		return distributionAttribute;
	}
	public void setDistributionAttribute(String distributionAttribute) {
		this.distributionAttribute = distributionAttribute;
	}
	public int getSegmentOrder() {
		return segmentOrder;
	}
	public void setSegmentOrder(int segmentOrder) {
		this.segmentOrder = segmentOrder;
	}
	public int getRequiredForDelivery() {
		return requiredForDelivery;
	}
	public void setRequiredForDelivery(int requiredForDelivery) {
		this.requiredForDelivery = requiredForDelivery;
	}
	public int getSuppressPrinting() {
		return suppressPrinting;
	}
	public void setSuppressPrinting(int suppressPrinting) {
		this.suppressPrinting = suppressPrinting;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getModeTransport() {
		return modeTransport;
	}
	public void setModeTransport(String modeTransport) {
		this.modeTransport = modeTransport;
	}
	public int getMruDelMethodDefaultSeq() {
		return mruDelMethodDefaultSeq;
	}
	public void setMruDelMethodDefaultSeq(int mruDelMethodDefaultSeq) {
		this.mruDelMethodDefaultSeq = mruDelMethodDefaultSeq;
	}
	public int getMruDistMethodOverrideSeq() {
		return mruDistMethodOverrideSeq;
	}
	public void setMruDistMethodOverrideSeq(int mruDistMethodOverrideSeq) {
		this.mruDistMethodOverrideSeq = mruDistMethodOverrideSeq;
	}
	public int getMruDelMethodOverrideSeq() {
		return mruDelMethodOverrideSeq;
	}
	public void setMruDelMethodOverrideSeq(int mruDelMethodOverrideSeq) {
		this.mruDelMethodOverrideSeq = mruDelMethodOverrideSeq;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	public String getDistributionMethod() {
		return distributionMethod;
	}
	public void setDistributionMethod(String distributionMethod) {
		this.distributionMethod = distributionMethod;
	}
	
	public String getRegionList() {
		return regionList;
	}
	public void setRegionList(String regionList) {
		this.regionList = regionList;
	}
	public String getSegmentDelimiter() {
		return segmentDelimiter;
	}
	public void setSegmentDelimiter(String segmentDelimiter) {
		this.segmentDelimiter = segmentDelimiter;
	}
	public int getMruDistMethodDefaultSeq() {
		return mruDistMethodDefaultSeq;
	}
	public void setMruDistMethodDefaultSeq(int mruDistMethodDefaultSeq) {
		this.mruDistMethodDefaultSeq = mruDistMethodDefaultSeq;
	}
	

}
