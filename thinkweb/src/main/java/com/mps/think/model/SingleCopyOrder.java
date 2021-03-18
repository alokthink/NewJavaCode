package com.mps.think.model;

public class SingleCopyOrder {
	
	private int issueID;
	private int rateClassId;
	private String description;
	private String renewalCardId;
	private String orderCodeId;
	private String allowOnInternet;
	private String tagLine;
	private String issn;
	private String rowVersion;
	private String expireGap;
	private String logicalStart;
	private String auditNGraceIssuesAllowed;
	private String auxiliary1;
	private String auxiliary2;
	private String forcedExpireMonth;
	private String extfreeQty;
	private String upgradeDowngradeValue;
	private String cancelPolicyId;
	private String inactive;
	private String premiumOrderCodeId;
	private String orderCode;
	private String commodityCode;
	private String subscriptionCategoryDescription;
	private String orderClass;	
	private int bundleQty;
	private int orderQty;
	private int shipQty;
	private int backordQty;	
	private String deliveryMethod;
	private String billingType;
	private String rateClassEffectiveSeq;
	private String rateClassEffectiveDate;
	private String orderCodeType;
	private double localAmount;
	private double baseAmount;
	private String state;
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
	
	
	public String getOrderCodeType() {
		return orderCodeType;
	}

	public void setOrderCodeType(String orderCodeType) {
		this.orderCodeType = orderCodeType;
	}

	public String getRateClassEffectiveSeq() {
		return rateClassEffectiveSeq;
	}

	public void setRateClassEffectiveSeq(String rateClassEffectiveSeq) {
		this.rateClassEffectiveSeq = rateClassEffectiveSeq;
	}

	public String getRateClassEffectiveDate() {
		return rateClassEffectiveDate;
	}

	public void setRateClassEffectiveDate(String rateClassEffectiveDate) {
		this.rateClassEffectiveDate = rateClassEffectiveDate;
	}

	private RatecardModel ratecardModel;
	private RateClassEffectiveModel rateClassEffectiveModel;

	public int getIssueID() {
		return issueID;
	}

	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}

	public int getRateClassId() {
		return rateClassId;
	}

	public void setRateClassId(int rateClassId) {
		this.rateClassId = rateClassId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRenewalCardId() {
		return renewalCardId;
	}

	public void setRenewalCardId(String renewalCardId) {
		this.renewalCardId = renewalCardId;
	}

	public String getOrderCodeId() {
		return orderCodeId;
	}

	public void setOrderCodeId(String orderCodeId) {
		this.orderCodeId = orderCodeId;
	}

	public String getAllowOnInternet() {
		return allowOnInternet;
	}

	public void setAllowOnInternet(String allowOnInternet) {
		this.allowOnInternet = allowOnInternet;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getRowVersion() {
		return rowVersion;
	}

	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
	}

	public String getExpireGap() {
		return expireGap;
	}

	public void setExpireGap(String expireGap) {
		this.expireGap = expireGap;
	}

	public String getLogicalStart() {
		return logicalStart;
	}

	public void setLogicalStart(String logicalStart) {
		this.logicalStart = logicalStart;
	}

	public String getAuditNGraceIssuesAllowed() {
		return auditNGraceIssuesAllowed;
	}

	public void setAuditNGraceIssuesAllowed(String auditNGraceIssuesAllowed) {
		this.auditNGraceIssuesAllowed = auditNGraceIssuesAllowed;
	}

	public String getAuxiliary1() {
		return auxiliary1;
	}

	public void setAuxiliary1(String auxiliary1) {
		this.auxiliary1 = auxiliary1;
	}

	public String getAuxiliary2() {
		return auxiliary2;
	}

	public void setAuxiliary2(String auxiliary2) {
		this.auxiliary2 = auxiliary2;
	}

	public String getForcedExpireMonth() {
		return forcedExpireMonth;
	}

	public void setForcedExpireMonth(String forcedExpireMonth) {
		this.forcedExpireMonth = forcedExpireMonth;
	}

	public String getExtfreeQty() {
		return extfreeQty;
	}

	public void setExtfreeQty(String extfreeQty) {
		this.extfreeQty = extfreeQty;
	}

	public String getUpgradeDowngradeValue() {
		return upgradeDowngradeValue;
	}

	public void setUpgradeDowngradeValue(String upgradeDowngradeValue) {
		this.upgradeDowngradeValue = upgradeDowngradeValue;
	}

	public String getCancelPolicyId() {
		return cancelPolicyId;
	}

	public void setCancelPolicyId(String cancelPolicyId) {
		this.cancelPolicyId = cancelPolicyId;
	}

	public String getInactive() {
		return inactive;
	}

	public void setInactive(String inactive) {
		this.inactive = inactive;
	}

	public String getPremiumOrderCodeId() {
		return premiumOrderCodeId;
	}

	public void setPremiumOrderCodeId(String premiumOrderCodeId) {
		this.premiumOrderCodeId = premiumOrderCodeId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getSubscriptionCategoryDescription() {
		return subscriptionCategoryDescription;
	}

	public void setSubscriptionCategoryDescription(String subscriptionCategoryDescription) {
		this.subscriptionCategoryDescription = subscriptionCategoryDescription;
	}

	public RatecardModel getRatecardModel() {
		return ratecardModel;
	}

	public void setRatecardModel(RatecardModel ratecardModel) {
		this.ratecardModel = ratecardModel;
	}

	public RateClassEffectiveModel getRateClassEffectiveModel() {
		return rateClassEffectiveModel;
	}

	public void setRateClassEffectiveModel(RateClassEffectiveModel rateClassEffectiveModel) {
		this.rateClassEffectiveModel = rateClassEffectiveModel;
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

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	@Override
	public String toString() {
		return "SingleCopyOrder [issueID=" + issueID + ", rateClassId="
				+ rateClassId + ", description=" + description + ", renewalCardId=" + renewalCardId + ", orderCodeId=" + orderCodeId
				+ ", allowOnInternet=" + allowOnInternet + ", tagLine=" + tagLine + ", issn="
				+ issn + ", rowVersion=" + rowVersion + ", expireGap=" + expireGap + ", logicalStart=" + logicalStart
				+ ", auditNGraceIssuesAllowed=" + auditNGraceIssuesAllowed + ", auxiliary1=" + auxiliary1
				+ ", auxiliary2=" + auxiliary2 + ", forcedExpireMonth=" + forcedExpireMonth + ", extfreeQty="
				+ extfreeQty + ", upgradeDowngradeValue=" + upgradeDowngradeValue + ", cancelPolicyId=" + cancelPolicyId
				+ ", inactive=" + inactive + ", premiumOrderCodeId=" + premiumOrderCodeId + ", orderCode=" + orderCode
				+ ", commodityCode=" + commodityCode + ", subscriptionCategoryDescription="
				+ subscriptionCategoryDescription + ", orderClass=" + orderClass + ", bundleQty=" + bundleQty
				+ ", orderQty=" + orderQty + ", shipQty=" + shipQty + ", backordQty=" + backordQty + ", deliveryMethod="
				+ deliveryMethod + ", billingType=" + billingType + ", rateClassEffectiveSeq ="
				+ rateClassEffectiveSeq+" , rateClassEffectiveDate ="+rateClassEffectiveDate+",ratecardModel=" + ratecardModel
				+ ", rateClassEffectiveModel=" + rateClassEffectiveModel + ",orderCodeType="+orderCodeType+", localAmount=" + localAmount +",baseAmount="+ baseAmount + " ]";
	}

}
