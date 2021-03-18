package com.mps.think.setup.model;

public class ParentOrderClassModel {
	
	// Table : source_corde
	private Integer sourceCodeId; 
	private String agencyCustomerId;
	private String sourceFormat;
	private String sourceDesc;
	private String sourceCode;
	private String description;
	private String stateBreak;
	private String generated; 	
	private String breakeven;
	private String offer;
	private String list;
	private String fromDate;
	private String toDate;
	private String qty;
	private Float cost;
	private String auditQualCategory;
	private String genericAgency;
	private String qtyMailed;
	private String costMailing;
	private String state;
	private String sourceAttribute;
	private String sourceAttributeValue;
	private String agencyCode;
	private String agencyDesc;
	private String rateClass;
	private String rateDesc;
	private String renewalCard;
	private String renewalDesc;
	private String discountClass;
	private String discountDesc;
	
	//private Integer ocId;
	private String active;
	private String newsubRateClassId;
	private String newRenewalCardId;
	private String newsubDiscountClassId;
	private String auditSubscriptionTypeId;
	private String auditQualSourceId;
	private String auditNameTitleId;
	private String auditSalesChannelId;
	private String premiumOrderCodeId;
	private String sourceCodeType;
	private String mruCatalogContentSeq;
	private String currency;
	private String mruGenericPromotionCodeSeq;
	private String isDdp;
	private String shippingPriceList;
	private String renewalCardId;
	// Table : generic_promotion
	//private Integer sourceCodeId;  
	private String discountClassId;      
	private Long generatedPrice;       
	private Integer issueId;       
	private Long itemPrice;       
	//private Integer mruGenericPromoSeq;      
	private Integer ocId; 
	private Integer orderCodeId;
	private Integer pkgDefId; 
	private Integer productId;        
	private String rateClassId;      
	private Integer subscriptionDefId;
	
	// Table : generic_promotion_code
	private Integer genericPromoCodeSeq;
	private String promoCode;
	private Integer qtyLimit;
	private Integer qtyUsed;
	public Integer getSourceCodeId() {
		return sourceCodeId;
	}
	public void setSourceCodeId(Integer sourceCodeId) {
		this.sourceCodeId = sourceCodeId;
	}
	public String getDiscountClassId() {
		return discountClassId;
	}
	public void setDiscountClassId(String discountClassId) {
		this.discountClassId = discountClassId;
	}
	public Long getGeneratedPrice() {
		return generatedPrice;
	}
	public void setGeneratedPrice(Long generatedPrice) {
		this.generatedPrice = generatedPrice;
	}
	public Integer getIssueId() {
		return issueId;
	}
	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}
	public Long getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Long itemPrice) {
		this.itemPrice = itemPrice;
	}
	/*public Integer getMruGenericPromoSeq() {
		return mruGenericPromoSeq;
	}
	public void setMruGenericPromoSeq(Integer mruGenericPromoSeq) {
		this.mruGenericPromoSeq = mruGenericPromoSeq;
	}*/
	public Integer getOcId() {
		return ocId;
	}
	public void setOcId(Integer ocId) {
		this.ocId = ocId;
	}
	public Integer getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(Integer orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
	public Integer getPkgDefId() {
		return pkgDefId;
	}
	public void setPkgDefId(Integer pkgDefId) {
		this.pkgDefId = pkgDefId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(String rateClassId) {
		this.rateClassId = rateClassId;
	}
	public Integer getSubscriptionDefId() {
		return subscriptionDefId;
	}
	public void setSubscriptionDefId(Integer subscriptionDefId) {
		this.subscriptionDefId = subscriptionDefId;
	}
	public String getAgencyCustomerId() {
		return agencyCustomerId;
	}
	public void setAgencyCustomerId(String agencyCustomerId) {
		this.agencyCustomerId = agencyCustomerId;
	}
	public String getSourceFormat() {
		return sourceFormat;
	}
	public void setSourceFormat(String sourceFormat) {
		this.sourceFormat = sourceFormat;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStateBreak() {
		return stateBreak;
	}
	public void setStateBreak(String string) {
		this.stateBreak = string;
	}
	public String getGenerated() {
		return generated;
	}
	public void setGenerated(String string) {
		this.generated = string;
	}
	public String getBreakeven() {
		return breakeven;
	}
	public void setBreakeven(String breakeven) {
		this.breakeven = breakeven;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public String getAuditQualCategory() {
		return auditQualCategory;
	}
	public void setAuditQualCategory(String auditQualCategory) {
		this.auditQualCategory = auditQualCategory;
	}
	public String getGenericAgency() {
		return genericAgency;
	}
	public void setGenericAgency(String genericAgency) {
		this.genericAgency = genericAgency;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getNewsubRateClassId() {
		return newsubRateClassId;
	}
	public void setNewsubRateClassId(String newsubRateClassId) {
		this.newsubRateClassId = newsubRateClassId;
	}
	public String getNewRenewalCardId() {
		return newRenewalCardId;
	}
	public void setNewRenewalCardId(String newRenewalCardId) {
		this.newRenewalCardId = newRenewalCardId;
	}
	public String getNewsubDiscountClassId() {
		return newsubDiscountClassId;
	}
	public void setNewsubDiscountClassId(String newsubDiscountClassId) {
		this.newsubDiscountClassId = newsubDiscountClassId;
	}
	public String getAuditSubscriptionTypeId() {
		return auditSubscriptionTypeId;
	}
	public void setAuditSubscriptionTypeId(String auditSubscriptionTypeId) {
		this.auditSubscriptionTypeId = auditSubscriptionTypeId;
	}
	public String getAuditQualSourceId() {
		return auditQualSourceId;
	}
	public void setAuditQualSourceId(String auditQualSourceId) {
		this.auditQualSourceId = auditQualSourceId;
	}
	public String getAuditNameTitleId() {
		return auditNameTitleId;
	}
	public void setAuditNameTitleId(String auditNameTitleId) {
		this.auditNameTitleId = auditNameTitleId;
	}
	public String getAuditSalesChannelId() {
		return auditSalesChannelId;
	}
	public void setAuditSalesChannelId(String auditSalesChannelId) {
		this.auditSalesChannelId = auditSalesChannelId;
	}
	public String getPremiumOrderCodeId() {
		return premiumOrderCodeId;
	}
	public void setPremiumOrderCodeId(String premiumOrderCodeId) {
		this.premiumOrderCodeId = premiumOrderCodeId;
	}
	public String getSourceCodeType() {
		return sourceCodeType;
	}
	public void setSourceCodeType(String string) {
		this.sourceCodeType = string;
	}
	public String getMruCatalogContentSeq() {
		return mruCatalogContentSeq;
	}
	public void setMruCatalogContentSeq(String mruCatalogContentSeq) {
		this.mruCatalogContentSeq = mruCatalogContentSeq;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getMruGenericPromotionCodeSeq() {
		return mruGenericPromotionCodeSeq;
	}
	public void setMruGenericPromotionCodeSeq(String mruGenericPromotionCodeSeq) {
		this.mruGenericPromotionCodeSeq = mruGenericPromotionCodeSeq;
	}
	public String getIsDdp() {
		return isDdp;
	}
	public void setIsDdp(String isDdp) {
		this.isDdp = isDdp;
	}
	public String getShippingPriceList() {
		return shippingPriceList;
	}
	public void setShippingPriceList(String shippingPriceList) {
		this.shippingPriceList = shippingPriceList;
	}
	public Integer getGenericPromoCodeSeq() {
		return genericPromoCodeSeq;
	}
	public void setGenericPromoCodeSeq(Integer genericPromoCodeSeq) {
		this.genericPromoCodeSeq = genericPromoCodeSeq;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public Integer getQtyLimit() {
		return qtyLimit;
	}
	public void setQtyLimit(Integer qtyLimit) {
		this.qtyLimit = qtyLimit;
	}
	public Integer getQtyUsed() {
		return qtyUsed;
	}
	public void setQtyUsed(Integer qtyUsed) {
		this.qtyUsed = qtyUsed;
	}
	public String getRenewalCardId() {
		return renewalCardId;
	}
	public void setRenewalCardId(String renewalCardId) {
		this.renewalCardId = renewalCardId;
	}
	public String getQtyMailed() {
		return qtyMailed;
	}
	public void setQtyMailed(String qtyMailed) {
		this.qtyMailed = qtyMailed;
	}
	public String getCostMailing() {
		return costMailing;
	}
	public void setCostMailing(String costMailing) {
		this.costMailing = costMailing;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSourceAttribute() {
		return sourceAttribute;
	}
	public void setSourceAttribute(String sourceAttribute) {
		this.sourceAttribute = sourceAttribute;
	}
	public String getSourceAttributeValue() {
		return sourceAttributeValue;
	}
	public void setSourceAttributeValue(String sourceAttributeValue) {
		this.sourceAttributeValue = sourceAttributeValue;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public String getAgencyDesc() {
		return agencyDesc;
	}
	public void setAgencyDesc(String agencyDesc) {
		this.agencyDesc = agencyDesc;
	}
	public String getRateClass() {
		return rateClass;
	}
	public void setRateClass(String rateClass) {
		this.rateClass = rateClass;
	}
	public String getRateDesc() {
		return rateDesc;
	}
	public void setRateDesc(String rateDesc) {
		this.rateDesc = rateDesc;
	}
	public String getRenewalCard() {
		return renewalCard;
	}
	public void setRenewalCard(String renewalCard) {
		this.renewalCard = renewalCard;
	}
	public String getDiscountClass() {
		return discountClass;
	}
	public void setDiscountClass(String discountClass) {
		this.discountClass = discountClass;
	}
	public String getDiscountDesc() {
		return discountDesc;
	}
	public void setDiscountDesc(String discountDesc) {
		this.discountDesc = discountDesc;
	}
	public String getRenewalDesc() {
		return renewalDesc;
	}
	public void setRenewalDesc(String renewalDesc) {
		this.renewalDesc = renewalDesc;
	}
	public String getSourceDesc() {
		return sourceDesc;
	}
	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}

}
