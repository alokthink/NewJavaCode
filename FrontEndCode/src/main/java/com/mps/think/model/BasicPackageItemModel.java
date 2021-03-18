package com.mps.think.model;

public class BasicPackageItemModel {

	private int pkgDefId;
	private int orderCodeId;
	private String orderCode;
	private String orderClass;
	private int pkgContentSeq;
	private double revenuePercent;
	private int subscriptionDefId;
	private int itemOrderCodeId;
	private String pkgContentDescription;
	private int qty;
	private int required;
	private String pkgDef;
	private String pkgDefDescription;
	private int active;
	private int pkgPriceMethod;
	private int rateClassId;
	private int ocId;
	private int fromQty;
	private String regionList;
	private String region;
	private String currency;
	private int toQty;
	private String price;
	private String commodityCode; 
	private int orderCodeType;
	private int prepaymentReq;
	private int taxable;
	
	private String taxRate;
	private String state;
	private String totalPrice;
	
	private int bundleQty;
	private int orderQty;
	private int shipQty;
	private int backordQty;
	private double pkgPrice;	
	
	private double localAmount;
	private double baseAmount;
	private double totalTaxLocalAmount;
	private double totalTaxBaseAmount;
	private int issueId;
	private int productId;
	private int contentOcId;
	
	public int getContentOcId() {
		return contentOcId;
	}

	public void setContentOcId(int contentOcId) {
		this.contentOcId = contentOcId;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
	public double getTotalTaxLocalAmount() {
		return totalTaxLocalAmount;
	}
	public void setTotalTaxLocalAmount(double totalTaxLocalAmount) {
		this.totalTaxLocalAmount = totalTaxLocalAmount;
	}
	public double getTotalTaxBaseAmount() {
		return totalTaxBaseAmount;
	}
	public void setTotalTaxBaseAmount(double totalTaxBaseAmount) {
		this.totalTaxBaseAmount = totalTaxBaseAmount;
	}
	public double getPkgPrice() {
		return pkgPrice;
	}
	public void setPkgPrice(double pkgPrice) {
		this.pkgPrice = pkgPrice;
	}
	private String deliveryMethod;
	private String billingType;
	private double taxAmt;	


	public double getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(double taxAmt) {
		this.taxAmt = taxAmt;
	}
	private String  exchange_rate;
	

	public String getExchange_rate() {
		return exchange_rate;
	}
	public void setExchange_rate(String exchange_rate) {
		this.exchange_rate = exchange_rate;
	}
	public int getPkgDefId() {
		return pkgDefId;
	}
	public void setPkgDefId(int pkgDefId) {
		this.pkgDefId = pkgDefId;
	}
	public int getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(int orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
	public int getPkgContentSeq() {
		return pkgContentSeq;
	}
	public void setPkgContentSeq(int pkgContentSeq) {
		this.pkgContentSeq = pkgContentSeq;
	}
	public double getRevenuePercent() {
		return revenuePercent;
	}
	public void setRevenuePercent(double revenuePercent) {
		this.revenuePercent = revenuePercent;
	}
	public int getSubscriptionDefId() {
		return subscriptionDefId;
	}
	public void setSubscriptionDefId(int subscriptionDefId) {
		this.subscriptionDefId = subscriptionDefId;
	}
	public int getItemOrderCodeId() {
		return itemOrderCodeId;
	}
	public void setItemOrderCodeId(int itemOrderCodeId) {
		this.itemOrderCodeId = itemOrderCodeId;
	}
	public String getPkgContentDescription() {
		return pkgContentDescription;
	}
	public void setPkgContentDescription(String pkgContentDescription) {
		this.pkgContentDescription = pkgContentDescription;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getRequired() {
		return required;
	}
	public void setRequired(int required) {
		this.required = required;
	}
	public String getPkgDef() {
		return pkgDef;
	}
	public void setPkgDef(String pkgDef) {
		this.pkgDef = pkgDef;
	}
	public String getPkgDefDescription() {
		return pkgDefDescription;
	}
	public void setPkgDefDescription(String pkgDefDescription) {
		this.pkgDefDescription = pkgDefDescription;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getPkgPriceMethod() {
		return pkgPriceMethod;
	}
	public void setPkgPriceMethod(int pkgPriceMethod) {
		this.pkgPriceMethod = pkgPriceMethod;
	}
	public int getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(int rateClassId) {
		this.rateClassId = rateClassId;
	}
	public int getOcId() {
		return ocId;
	}
	public void setOcId(int ocId) {
		this.ocId = ocId;
	}
	public int getFromQty() {
		return fromQty;
	}
	public void setFromQty(int fromQty) {
		this.fromQty = fromQty;
	}
	public String getRegionList() {
		return regionList;
	}
	public void setRegionList(String regionList) {
		this.regionList = regionList;
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
	public int getToQty() {
		return toQty;
	}
	public void setToQty(int toQty) {
		this.toQty = toQty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCommodityCode() {
		return commodityCode;
	}
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}
	public int getOrderCodeType() {
		return orderCodeType;
	}
	public void setOrderCodeType(int orderCodeType) {
		this.orderCodeType = orderCodeType;
	}
	public int getPrepaymentReq() {
		return prepaymentReq;
	}
	public void setPrepaymentReq(int prepaymentReq) {
		this.prepaymentReq = prepaymentReq;
	}
	public int getTaxable() {
		return taxable;
	}
	public void setTaxable(int taxable) {
		this.taxable = taxable;
	}	
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderClass() {
		return orderClass;
	}
	public void setOrderClass(String orderClass) {
		this.orderClass = orderClass;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
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
	@Override
	public String toString() {
		return "BasicPackageItemModel [pkgDefId=" + pkgDefId + ", orderCodeId=" + orderCodeId + ", orderCode="
				+ orderCode + ", orderClass=" + orderClass + ", pkgContentSeq=" + pkgContentSeq + ", revenuePercent="
				+ revenuePercent + ", subscriptionDefId=" + subscriptionDefId + ", itemOrderCodeId=" + itemOrderCodeId
				+ ", pkgContentDescription=" + pkgContentDescription + ", qty=" + qty + ", required=" + required
				+ ", pkgDef=" + pkgDef + ", pkgDefDescription=" + pkgDefDescription + ", active=" + active
				+ ", pkgPriceMethod=" + pkgPriceMethod + ", rateClassId=" + rateClassId + ", ocId=" + ocId
				+ ", fromQty=" + fromQty + ", regionList=" + regionList + ", region=" + region + ", currency="
				+ currency + ", toQty=" + toQty + ", price=" + price + ", commodityCode=" + commodityCode
				+ ", orderCodeType=" + orderCodeType + ", prepaymentReq=" + prepaymentReq + ", taxable=" + taxable
				+ ", taxRate=" + taxRate + ", state=" + state + ", totalPrice=" + totalPrice + ", bundleQty="
				+ bundleQty + ", orderQty=" + orderQty + ", shipQty=" + shipQty + ", backordQty=" + backordQty
				+ ", pkgPrice=" + pkgPrice + ", taxAmt=" + taxAmt+", deliveryMethod=" + deliveryMethod + ", billingType="
				+ billingType +" ,exchange_rate=" + exchange_rate + ", localAmount=" + localAmount +",baseAmount="+ baseAmount + ",totalTaxLocalAmount=" + totalTaxLocalAmount  
				+ ", totalTaxBaseAmount=" + totalTaxBaseAmount + "]";
	}	
}
