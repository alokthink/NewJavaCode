package com.mps.think.orderFunctionality.model;

public class OrderItemModel {
	 
	 private int orderItemSeq;
	 private long orderhdrId;  
	 private String addonToOrderItemSeq;     
	 private String addonToOrderhdrId;      
	 private String agencyCustomerId;    
	 private String agentRefNbr;
	 private String altShipCustomerAddressSeq;    
	 private String altShipCustomerId;      
	 private String altShipDelCalc;
	 private String asynchronousAutoRenew;
	 private String attachExist;
	 private String auditNameTitleId;   
	 private String auditQualCategory;
	 private String auditQualSourceId; 
	 private String auditSalesChannelId; 
	 private String auditSubscriptionTypeId;   
	 private String autoPayment; 
	 private String autoRenewNotifySent;
	 private String backordQty;
	 private String billDate;
	 private String billToCustomerAddressSeq;     
	 private String billToCustomerId;
	 private String billingDef;       
	 private String billingDefTestSeq;  
	 private String billingType;
	 private String bundleQty;
	 private String calendarUnit; 
	 private String cancelDate;
	 private String cancelReason;
	 private String changeQtyFlag; 
	 private String chargeOnCancellation;
	 private String currency;
	 private String customerAddressSeq;     
	 private String customerGroupId;       
	 private String customerId;   
	 private String dateStamp;
	 private String dealId;    
	 private String deliveryMethod;    
	 private String deliveryMethodPerm;
	 private String discClassEffectiveSeq;   
	 private String discountCardSeq;  
	 private String discountClassId;   
	 private String distributionMethod;      
	 private String duration;
	 private int electronicDelivery;
	 private String electronicDocumentIdentifier;      
	 private String exchangeRate;
	 private String expireDate; 
	 private String extIssLeft;
	 private String extIssTot;
	 private String extendedDays;   
	 private String extendedRate;       
	 private String fulfillmentDate;  
	 private String genericPromotionCodeSeq;       
	 private String grossBaseAmount;
	 private String grossLocalAmount;
	 private String groupOrder;
	 private String hasBeenRenewed;
	 private String hasDeliveryCharge;
	 private String hasPremium;
	 private String hasTax;
	 private String installmentPlanId;
	 private String inventoryId;
	 private String invoiceDate;      
	 private String invoiceId;  
	 private int isBackOrdered; 
	 private String isComplimentary; 
	 private String isProforma;
	 private String itemUrl;        
	 private String lastInvDate;
	 private String lastRenDate;
	 private String lastTaxInvoiceDate;     
	 private String manualDiscAmtBase;   
	 private String manualDiscAmtLocal;      
	 private String manualDiscPercentage;     
	 private String maxCheckOutAmt;  
	 private String mruBillingHistorySeq;      
	 private String mruGrpMbrItemDtlSeq;    
	 private String mruOrderItemAmtBreakSeq;      
	 private String mruOrderItemNoteSeq;     
	 private String mruOrderItemSglIssuesSeq;   
	 private String mruOrderItemShipSeq;      
	 private String mruSuspensionSeq;   
	 private String mruUnitHistorySeq;  
	 private String multilineDiscAmount;       
	 private String multilineDiscEffSeq;   
	 private String multilineDiscountSchedule;  
	 private String nCalUnitsPerSeg;  
	 private String nDaysGraced;  
	 private String nDelIssLeft;
	 private String nInvEfforts;
	 private String nIssuesLeft;
	 private String nItemsPerSeg;   
	 private String nNonpaidIssues;
	 private String nRemainingNonpaidIssues;
	 private String nRemainingPaidIssues;
	 private String nRenEffort;
	 private String nSegmentsLeft;  
	 private String nTaxUpdates;  
	 private String netBaseAmount;
	 private String netLocalAmount;
	 private String noteExist; 
	 private String numberVolumeSets;
	 private int ocId;
	 private String orderCategory;       
	 private int orderCodeId;
	 private String orderDate; 
	 private String orderItemType;
	 private String orderQty;
	 private String orderCode;
	 private String orderStatus;
	 private String orderType; 
	 private String origOrderQty;
	 private String packageContentSeq;
	 private String packageId;
	 private String paymentAccountSeq;    
	 private String paymentStatus;  
	 private String percentOfBasicPrice; 
	 private String perpetualOrder; 
	 private String pkgDefId;
	 private String pkgItemSeq; 
	 private String premToOrderItemSeq;  
	 private int prepaymentReq;
	 private String productId; 
	 private String pubRotationId; 
	 private String qualDate;   
	 private String rateClassEffectiveSeq;
	 private String rateClassId;   
	 private String ratecardSeq;  
	 private String refundStatus;
	 private String renewToCustomerAddressSeq;  
	 private String renewToCustomerId;   
	 private String renewalCategory;
	 private String renewalDef;       
	 private String renewalDefTestSeq;     
	 private String renewalStatus;
	 private String renewedFromSubscripId;
	 private int revenueMethod;
	 private String segmentExpireDate;  
	 private String serviceExist;
	 private String shipQty;
	 private String shippingPriceList;       
	 private int sourceCodeId;
	 private String squalDate;       
	 private String startDate; 
	 private String startIssueId;  
	 private String stopIssueId; 
	 private String subscripId;
	 private String subscripStartType;
	 private String subscriptionDefId;
	 private String timeUnitOptions;
	 private String totalTaxBaseAmount;     
	 private String totalTaxLocalAmount;   
	 private String trialPeriod;     
	 private String trialType;
	 private String unitExcess;
	 private String unitTypeId;     
	 private String userCode;
	 private String fullName;
	 private String billingName;
	 private String renewalName;
	
	@Override
	public String toString() {
		return "OrderItemModel [orderItemSeq=" + orderItemSeq + ", orderhdrId=" + orderhdrId + ", addonToOrderItemSeq="
				+ addonToOrderItemSeq + ", addonToOrderhdrId=" + addonToOrderhdrId + ", agencyCustomerId="
				+ agencyCustomerId + ", agentRefNbr=" + agentRefNbr + ", altShipCustomerAddressSeq="
				+ altShipCustomerAddressSeq + ", altShipCustomerId=" + altShipCustomerId + ", altShipDelCalc="
				+ altShipDelCalc + ", asynchronousAutoRenew=" + asynchronousAutoRenew + ", attachExist=" + attachExist
				+ ", auditNameTitleId=" + auditNameTitleId + ", auditQualCategory=" + auditQualCategory
				+ ", auditQualSourceId=" + auditQualSourceId + ", auditSalesChannelId=" + auditSalesChannelId
				+ ", auditSubscriptionTypeId=" + auditSubscriptionTypeId + ", autoPayment=" + autoPayment
				+ ", autoRenewNotifySent=" + autoRenewNotifySent + ", backordQty=" + backordQty + ", billDate="
				+ billDate + ", billToCustomerAddressSeq=" + billToCustomerAddressSeq + ", billToCustomerId="
				+ billToCustomerId + ", billingDef=" + billingDef + ", billingDefTestSeq=" + billingDefTestSeq
				+ ", billingType=" + billingType + ", bundleQty=" + bundleQty + ", calendarUnit=" + calendarUnit
				+ ", cancelDate=" + cancelDate + ", cancelReason=" + cancelReason + ", changeQtyFlag=" + changeQtyFlag
				+ ", chargeOnCancellation=" + chargeOnCancellation + ", currency=" + currency + ", customerAddressSeq="
				+ customerAddressSeq + ", customerGroupId=" + customerGroupId + ", customerId=" + customerId
				+ ", dateStamp=" + dateStamp + ", dealId=" + dealId + ", deliveryMethod=" + deliveryMethod
				+ ", deliveryMethodPerm=" + deliveryMethodPerm + ", discClassEffectiveSeq=" + discClassEffectiveSeq
				+ ", discountCardSeq=" + discountCardSeq + ", discountClassId=" + discountClassId
				+ ", distributionMethod=" + distributionMethod + ", duration=" + duration + ", electronicDelivery="
				+ electronicDelivery + ", electronicDocumentIdentifier=" + electronicDocumentIdentifier
				+ ", exchangeRate=" + exchangeRate + ", expireDate=" + expireDate + ", extIssLeft=" + extIssLeft
				+ ", extIssTot=" + extIssTot + ", extendedDays=" + extendedDays + ", extendedRate=" + extendedRate
				+ ", fulfillmentDate=" + fulfillmentDate + ", genericPromotionCodeSeq=" + genericPromotionCodeSeq
				+ ", grossBaseAmount=" + grossBaseAmount + ", grossLocalAmount=" + grossLocalAmount + ", groupOrder="
				+ groupOrder + ", hasBeenRenewed=" + hasBeenRenewed + ", hasDeliveryCharge=" + hasDeliveryCharge
				+ ", hasPremium=" + hasPremium + ", hasTax=" + hasTax + ", installmentPlanId=" + installmentPlanId
				+ ", inventoryId=" + inventoryId + ", invoiceDate=" + invoiceDate + ", invoiceId=" + invoiceId
				+ ", isBackOrdered=" + isBackOrdered + ", isComplimentary=" + isComplimentary + ", isProforma="
				+ isProforma + ", itemUrl=" + itemUrl + ", lastInvDate=" + lastInvDate + ", lastRenDate=" + lastRenDate
				+ ", lastTaxInvoiceDate=" + lastTaxInvoiceDate + ", manualDiscAmtBase=" + manualDiscAmtBase
				+ ", manualDiscAmtLocal=" + manualDiscAmtLocal + ", manualDiscPercentage=" + manualDiscPercentage
				+ ", maxCheckOutAmt=" + maxCheckOutAmt + ", mruBillingHistorySeq=" + mruBillingHistorySeq
				+ ", mruGrpMbrItemDtlSeq=" + mruGrpMbrItemDtlSeq + ", mruOrderItemAmtBreakSeq="
				+ mruOrderItemAmtBreakSeq + ", mruOrderItemNoteSeq=" + mruOrderItemNoteSeq
				+ ", mruOrderItemSglIssuesSeq=" + mruOrderItemSglIssuesSeq + ", mruOrderItemShipSeq="
				+ mruOrderItemShipSeq + ", mruSuspensionSeq=" + mruSuspensionSeq + ", mruUnitHistorySeq="
				+ mruUnitHistorySeq + ", multilineDiscAmount=" + multilineDiscAmount + ", multilineDiscEffSeq="
				+ multilineDiscEffSeq + ", multilineDiscountSchedule=" + multilineDiscountSchedule
				+ ", nCalUnitsPerSeg=" + nCalUnitsPerSeg + ", nDaysGraced=" + nDaysGraced + ", nDelIssLeft="
				+ nDelIssLeft + ", nInvEfforts=" + nInvEfforts + ", nIssuesLeft=" + nIssuesLeft + ", nItemsPerSeg="
				+ nItemsPerSeg + ", nNonpaidIssues=" + nNonpaidIssues + ", nRemainingNonpaidIssues="
				+ nRemainingNonpaidIssues + ", nRemainingPaidIssues=" + nRemainingPaidIssues + ", nRenEffort="
				+ nRenEffort + ", nSegmentsLeft=" + nSegmentsLeft + ", nTaxUpdates=" + nTaxUpdates + ", netBaseAmount="
				+ netBaseAmount + ", netLocalAmount=" + netLocalAmount + ", noteExist=" + noteExist
				+ ", numberVolumeSets=" + numberVolumeSets + ", ocId=" + ocId + ", orderCategory=" + orderCategory
				+ ", orderCodeId=" + orderCodeId + ", orderDate=" + orderDate + ", orderItemType=" + orderItemType
				+ ", orderQty=" + orderQty + ", orderCode=" + orderCode + ", orderStatus=" + orderStatus
				+ ", orderType=" + orderType + ", origOrderQty=" + origOrderQty + ", packageContentSeq="
				+ packageContentSeq + ", packageId=" + packageId + ", paymentAccountSeq=" + paymentAccountSeq
				+ ", paymentStatus=" + paymentStatus + ", percentOfBasicPrice=" + percentOfBasicPrice
				+ ", perpetualOrder=" + perpetualOrder + ", pkgDefId=" + pkgDefId + ", pkgItemSeq=" + pkgItemSeq
				+ ", premToOrderItemSeq=" + premToOrderItemSeq + ", prepaymentReq=" + prepaymentReq + ", productId="
				+ productId + ", pubRotationId=" + pubRotationId + ", qualDate=" + qualDate + ", rateClassEffectiveSeq="
				+ rateClassEffectiveSeq + ", rateClassId=" + rateClassId + ", ratecardSeq=" + ratecardSeq
				+ ", refundStatus=" + refundStatus + ", renewToCustomerAddressSeq=" + renewToCustomerAddressSeq
				+ ", renewToCustomerId=" + renewToCustomerId + ", renewalCategory=" + renewalCategory + ", renewalDef="
				+ renewalDef + ", renewalDefTestSeq=" + renewalDefTestSeq + ", renewalStatus=" + renewalStatus
				+ ", renewedFromSubscripId=" + renewedFromSubscripId + ", revenueMethod=" + revenueMethod
				+ ", segmentExpireDate=" + segmentExpireDate + ", serviceExist=" + serviceExist + ", shipQty=" + shipQty
				+ ", shippingPriceList=" + shippingPriceList + ", sourceCodeId=" + sourceCodeId + ", squalDate="
				+ squalDate + ", startDate=" + startDate + ", startIssueId=" + startIssueId + ", stopIssueId="
				+ stopIssueId + ", subscripId=" + subscripId + ", subscripStartType=" + subscripStartType
				+ ", subscriptionDefId=" + subscriptionDefId + ", timeUnitOptions=" + timeUnitOptions
				+ ", totalTaxBaseAmount=" + totalTaxBaseAmount + ", totalTaxLocalAmount=" + totalTaxLocalAmount
				+ ", trialPeriod=" + trialPeriod + ", trialType=" + trialType + ", unitExcess=" + unitExcess
				+ ", unitTypeId=" + unitTypeId + ", userCode=" + userCode + ", fullName=" + fullName + ", billingName="
				+ billingName + ", renewalName=" + renewalName + ",]";
	}
	public int getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(int orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	public long getOrderhdrId() {
		return orderhdrId;
	}
	public void setOrderhdrId(long orderhdrId) {
		this.orderhdrId = orderhdrId;
	}
	public String getAddonToOrderItemSeq() {
		return addonToOrderItemSeq;
	}
	public void setAddonToOrderItemSeq(String addonToOrderItemSeq) {
		this.addonToOrderItemSeq = addonToOrderItemSeq;
	}
	public String getAddonToOrderhdrId() {
		return addonToOrderhdrId;
	}
	public void setAddonToOrderhdrId(String addonToOrderhdrId) {
		this.addonToOrderhdrId = addonToOrderhdrId;
	}
	public String getAgencyCustomerId() {
		return agencyCustomerId;
	}
	public void setAgencyCustomerId(String agencyCustomerId) {
		this.agencyCustomerId = agencyCustomerId;
	}
	public String getAgentRefNbr() {
		return agentRefNbr;
	}
	public void setAgentRefNbr(String agentRefNbr) {
		this.agentRefNbr = agentRefNbr;
	}
	public String getAltShipCustomerAddressSeq() {
		return altShipCustomerAddressSeq;
	}
	public void setAltShipCustomerAddressSeq(String altShipCustomerAddressSeq) {
		this.altShipCustomerAddressSeq = altShipCustomerAddressSeq;
	}
	public String getAltShipCustomerId() {
		return altShipCustomerId;
	}
	public void setAltShipCustomerId(String altShipCustomerId) {
		this.altShipCustomerId = altShipCustomerId;
	}
	public String getAltShipDelCalc() {
		return altShipDelCalc;
	}
	public void setAltShipDelCalc(String altShipDelCalc) {
		this.altShipDelCalc = altShipDelCalc;
	}
	public String getAsynchronousAutoRenew() {
		return asynchronousAutoRenew;
	}
	public void setAsynchronousAutoRenew(String asynchronousAutoRenew) {
		this.asynchronousAutoRenew = asynchronousAutoRenew;
	}
	public String getAttachExist() {
		return attachExist;
	}
	public void setAttachExist(String attachExist) {
		this.attachExist = attachExist;
	}
	public String getAuditNameTitleId() {
		return auditNameTitleId;
	}
	public void setAuditNameTitleId(String auditNameTitleId) {
		this.auditNameTitleId = auditNameTitleId;
	}
	public String getAuditQualCategory() {
		return auditQualCategory;
	}
	public void setAuditQualCategory(String auditQualCategory) {
		this.auditQualCategory = auditQualCategory;
	}
	public String getAuditQualSourceId() {
		return auditQualSourceId;
	}
	public void setAuditQualSourceId(String auditQualSourceId) {
		this.auditQualSourceId = auditQualSourceId;
	}
	public String getAuditSalesChannelId() {
		return auditSalesChannelId;
	}
	public void setAuditSalesChannelId(String auditSalesChannelId) {
		this.auditSalesChannelId = auditSalesChannelId;
	}
	public String getAuditSubscriptionTypeId() {
		return auditSubscriptionTypeId;
	}
	public void setAuditSubscriptionTypeId(String auditSubscriptionTypeId) {
		this.auditSubscriptionTypeId = auditSubscriptionTypeId;
	}
	public String getAutoPayment() {
		return autoPayment;
	}
	public void setAutoPayment(String autoPayment) {
		this.autoPayment = autoPayment;
	}
	public String getAutoRenewNotifySent() {
		return autoRenewNotifySent;
	}
	public void setAutoRenewNotifySent(String autoRenewNotifySent) {
		this.autoRenewNotifySent = autoRenewNotifySent;
	}
	public String getBackordQty() {
		return backordQty;
	}
	public void setBackordQty(String backordQty) {
		this.backordQty = backordQty;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillToCustomerAddressSeq() {
		return billToCustomerAddressSeq;
	}
	public void setBillToCustomerAddressSeq(String billToCustomerAddressSeq) {
		this.billToCustomerAddressSeq = billToCustomerAddressSeq;
	}
	public String getBillToCustomerId() {
		return billToCustomerId;
	}
	public void setBillToCustomerId(String billToCustomerId) {
		this.billToCustomerId = billToCustomerId;
	}
	public String getBillingDef() {
		return billingDef;
	}
	public void setBillingDef(String billingDef) {
		this.billingDef = billingDef;
	}
	public String getBillingDefTestSeq() {
		return billingDefTestSeq;
	}
	public void setBillingDefTestSeq(String billingDefTestSeq) {
		this.billingDefTestSeq = billingDefTestSeq;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getBundleQty() {
		return bundleQty;
	}
	public void setBundleQty(String bundleQty) {
		this.bundleQty = bundleQty;
	}
	public String getCalendarUnit() {
		return calendarUnit;
	}
	public void setCalendarUnit(String calendarUnit) {
		this.calendarUnit = calendarUnit;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getChangeQtyFlag() {
		return changeQtyFlag;
	}
	public void setChangeQtyFlag(String changeQtyFlag) {
		this.changeQtyFlag = changeQtyFlag;
	}
	public String getChargeOnCancellation() {
		return chargeOnCancellation;
	}
	public void setChargeOnCancellation(String chargeOnCancellation) {
		this.chargeOnCancellation = chargeOnCancellation;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCustomerAddressSeq() {
		return customerAddressSeq;
	}
	public void setCustomerAddressSeq(String customerAddressSeq) {
		this.customerAddressSeq = customerAddressSeq;
	}
	public String getCustomerGroupId() {
		return customerGroupId;
	}
	public void setCustomerGroupId(String customerGroupId) {
		this.customerGroupId = customerGroupId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getDateStamp() {
		return dateStamp;
	}
	public void setDateStamp(String dateStamp) {
		this.dateStamp = dateStamp;
	}
	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public String getDeliveryMethodPerm() {
		return deliveryMethodPerm;
	}
	public void setDeliveryMethodPerm(String deliveryMethodPerm) {
		this.deliveryMethodPerm = deliveryMethodPerm;
	}
	public String getDiscClassEffectiveSeq() {
		return discClassEffectiveSeq;
	}
	public void setDiscClassEffectiveSeq(String discClassEffectiveSeq) {
		this.discClassEffectiveSeq = discClassEffectiveSeq;
	}
	public String getDiscountCardSeq() {
		return discountCardSeq;
	}
	public void setDiscountCardSeq(String discountCardSeq) {
		this.discountCardSeq = discountCardSeq;
	}
	public String getDiscountClassId() {
		return discountClassId;
	}
	public void setDiscountClassId(String discountClassId) {
		this.discountClassId = discountClassId;
	}
	public String getDistributionMethod() {
		return distributionMethod;
	}
	public void setDistributionMethod(String distributionMethod) {
		this.distributionMethod = distributionMethod;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getElectronicDelivery() {
		return electronicDelivery;
	}
	public void setElectronicDelivery(int electronicDelivery) {
		this.electronicDelivery = electronicDelivery;
	}
	public String getElectronicDocumentIdentifier() {
		return electronicDocumentIdentifier;
	}
	public void setElectronicDocumentIdentifier(String electronicDocumentIdentifier) {
		this.electronicDocumentIdentifier = electronicDocumentIdentifier;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getExtIssLeft() {
		return extIssLeft;
	}
	public void setExtIssLeft(String extIssLeft) {
		this.extIssLeft = extIssLeft;
	}
	public String getExtIssTot() {
		return extIssTot;
	}
	public void setExtIssTot(String extIssTot) {
		this.extIssTot = extIssTot;
	}
	public String getExtendedDays() {
		return extendedDays;
	}
	public void setExtendedDays(String extendedDays) {
		this.extendedDays = extendedDays;
	}
	public String getExtendedRate() {
		return extendedRate;
	}
	public void setExtendedRate(String extendedRate) {
		this.extendedRate = extendedRate;
	}
	public String getFulfillmentDate() {
		return fulfillmentDate;
	}
	public void setFulfillmentDate(String fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}
	public String getGenericPromotionCodeSeq() {
		return genericPromotionCodeSeq;
	}
	public void setGenericPromotionCodeSeq(String genericPromotionCodeSeq) {
		this.genericPromotionCodeSeq = genericPromotionCodeSeq;
	}
	public String getGrossBaseAmount() {
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
	public String getGroupOrder() {
		return groupOrder;
	}
	public void setGroupOrder(String groupOrder) {
		this.groupOrder = groupOrder;
	}
	public String getHasBeenRenewed() {
		return hasBeenRenewed;
	}
	public void setHasBeenRenewed(String hasBeenRenewed) {
		this.hasBeenRenewed = hasBeenRenewed;
	}
	public String getHasDeliveryCharge() {
		return hasDeliveryCharge;
	}
	public void setHasDeliveryCharge(String hasDeliveryCharge) {
		this.hasDeliveryCharge = hasDeliveryCharge;
	}
	public String getHasPremium() {
		return hasPremium;
	}
	public void setHasPremium(String hasPremium) {
		this.hasPremium = hasPremium;
	}
	public String getHasTax() {
		return hasTax;
	}
	public void setHasTax(String hasTax) {
		this.hasTax = hasTax;
	}
	public String getInstallmentPlanId() {
		return installmentPlanId;
	}
	public void setInstallmentPlanId(String installmentPlanId) {
		this.installmentPlanId = installmentPlanId;
	}
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getIsBackOrdered() {
		return isBackOrdered;
	}
	public void setIsBackOrdered(int isBackOrdered) {
		this.isBackOrdered = isBackOrdered;
	}
	public String getIsComplimentary() {
		return isComplimentary;
	}
	public void setIsComplimentary(String isComplimentary) {
		this.isComplimentary = isComplimentary;
	}
	public String getIsProforma() {
		return isProforma;
	}
	public void setIsProforma(String isProforma) {
		this.isProforma = isProforma;
	}
	public String getItemUrl() {
		return itemUrl;
	}
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	public String getLastInvDate() {
		return lastInvDate;
	}
	public void setLastInvDate(String lastInvDate) {
		this.lastInvDate = lastInvDate;
	}
	public String getLastRenDate() {
		return lastRenDate;
	}
	public void setLastRenDate(String lastRenDate) {
		this.lastRenDate = lastRenDate;
	}
	public String getLastTaxInvoiceDate() {
		return lastTaxInvoiceDate;
	}
	public void setLastTaxInvoiceDate(String lastTaxInvoiceDate) {
		this.lastTaxInvoiceDate = lastTaxInvoiceDate;
	}
	public String getManualDiscAmtBase() {
		return manualDiscAmtBase;
	}
	public void setManualDiscAmtBase(String manualDiscAmtBase) {
		this.manualDiscAmtBase = manualDiscAmtBase;
	}
	public String getManualDiscAmtLocal() {
		return manualDiscAmtLocal;
	}
	public void setManualDiscAmtLocal(String manualDiscAmtLocal) {
		this.manualDiscAmtLocal = manualDiscAmtLocal;
	}
	public String getManualDiscPercentage() {
		return manualDiscPercentage;
	}
	public void setManualDiscPercentage(String manualDiscPercentage) {
		this.manualDiscPercentage = manualDiscPercentage;
	}
	public String getMaxCheckOutAmt() {
		return maxCheckOutAmt;
	}
	public void setMaxCheckOutAmt(String maxCheckOutAmt) {
		this.maxCheckOutAmt = maxCheckOutAmt;
	}
	public String getMruBillingHistorySeq() {
		return mruBillingHistorySeq;
	}
	public void setMruBillingHistorySeq(String mruBillingHistorySeq) {
		this.mruBillingHistorySeq = mruBillingHistorySeq;
	}
	public String getMruGrpMbrItemDtlSeq() {
		return mruGrpMbrItemDtlSeq;
	}
	public void setMruGrpMbrItemDtlSeq(String mruGrpMbrItemDtlSeq) {
		this.mruGrpMbrItemDtlSeq = mruGrpMbrItemDtlSeq;
	}
	public String getMruOrderItemAmtBreakSeq() {
		return mruOrderItemAmtBreakSeq;
	}
	public void setMruOrderItemAmtBreakSeq(String mruOrderItemAmtBreakSeq) {
		this.mruOrderItemAmtBreakSeq = mruOrderItemAmtBreakSeq;
	}
	public String getMruOrderItemNoteSeq() {
		return mruOrderItemNoteSeq;
	}
	public void setMruOrderItemNoteSeq(String mruOrderItemNoteSeq) {
		this.mruOrderItemNoteSeq = mruOrderItemNoteSeq;
	}
	public String getMruOrderItemSglIssuesSeq() {
		return mruOrderItemSglIssuesSeq;
	}
	public void setMruOrderItemSglIssuesSeq(String mruOrderItemSglIssuesSeq) {
		this.mruOrderItemSglIssuesSeq = mruOrderItemSglIssuesSeq;
	}
	public String getMruOrderItemShipSeq() {
		return mruOrderItemShipSeq;
	}
	public void setMruOrderItemShipSeq(String mruOrderItemShipSeq) {
		this.mruOrderItemShipSeq = mruOrderItemShipSeq;
	}
	public String getMruSuspensionSeq() {
		return mruSuspensionSeq;
	}
	public void setMruSuspensionSeq(String mruSuspensionSeq) {
		this.mruSuspensionSeq = mruSuspensionSeq;
	}
	public String getMruUnitHistorySeq() {
		return mruUnitHistorySeq;
	}
	public void setMruUnitHistorySeq(String mruUnitHistorySeq) {
		this.mruUnitHistorySeq = mruUnitHistorySeq;
	}
	public String getMultilineDiscAmount() {
		return multilineDiscAmount;
	}
	public void setMultilineDiscAmount(String multilineDiscAmount) {
		this.multilineDiscAmount = multilineDiscAmount;
	}
	public String getMultilineDiscEffSeq() {
		return multilineDiscEffSeq;
	}
	public void setMultilineDiscEffSeq(String multilineDiscEffSeq) {
		this.multilineDiscEffSeq = multilineDiscEffSeq;
	}
	public String getMultilineDiscountSchedule() {
		return multilineDiscountSchedule;
	}
	public void setMultilineDiscountSchedule(String multilineDiscountSchedule) {
		this.multilineDiscountSchedule = multilineDiscountSchedule;
	}
	public String getnCalUnitsPerSeg() {
		return nCalUnitsPerSeg;
	}
	public void setnCalUnitsPerSeg(String nCalUnitsPerSeg) {
		this.nCalUnitsPerSeg = nCalUnitsPerSeg;
	}
	public String getnDaysGraced() {
		return nDaysGraced;
	}
	public void setnDaysGraced(String nDaysGraced) {
		this.nDaysGraced = nDaysGraced;
	}
	public String getnDelIssLeft() {
		return nDelIssLeft;
	}
	public void setnDelIssLeft(String nDelIssLeft) {
		this.nDelIssLeft = nDelIssLeft;
	}
	public String getnInvEfforts() {
		return nInvEfforts;
	}
	public void setnInvEfforts(String nInvEfforts) {
		this.nInvEfforts = nInvEfforts;
	}
	public String getnIssuesLeft() {
		return nIssuesLeft;
	}
	public void setnIssuesLeft(String nIssuesLeft) {
		this.nIssuesLeft = nIssuesLeft;
	}
	public String getnItemsPerSeg() {
		return nItemsPerSeg;
	}
	public void setnItemsPerSeg(String nItemsPerSeg) {
		this.nItemsPerSeg = nItemsPerSeg;
	}
	public String getnNonpaidIssues() {
		return nNonpaidIssues;
	}
	public void setnNonpaidIssues(String nNonpaidIssues) {
		this.nNonpaidIssues = nNonpaidIssues;
	}
	public String getnRemainingNonpaidIssues() {
		return nRemainingNonpaidIssues;
	}
	public void setnRemainingNonpaidIssues(String nRemainingNonpaidIssues) {
		this.nRemainingNonpaidIssues = nRemainingNonpaidIssues;
	}
	public String getnRemainingPaidIssues() {
		return nRemainingPaidIssues;
	}
	public void setnRemainingPaidIssues(String nRemainingPaidIssues) {
		this.nRemainingPaidIssues = nRemainingPaidIssues;
	}
	public String getnRenEffort() {
		return nRenEffort;
	}
	public void setnRenEffort(String nRenEffort) {
		this.nRenEffort = nRenEffort;
	}
	public String getnSegmentsLeft() {
		return nSegmentsLeft;
	}
	public void setnSegmentsLeft(String nSegmentsLeft) {
		this.nSegmentsLeft = nSegmentsLeft;
	}
	public String getnTaxUpdates() {
		return nTaxUpdates;
	}
	public void setnTaxUpdates(String nTaxUpdates) {
		this.nTaxUpdates = nTaxUpdates;
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
	}
	public String getNoteExist() {
		return noteExist;
	}
	public void setNoteExist(String noteExist) {
		this.noteExist = noteExist;
	}
	public String getNumberVolumeSets() {
		return numberVolumeSets;
	}
	public void setNumberVolumeSets(String numberVolumeSets) {
		this.numberVolumeSets = numberVolumeSets;
	}
	public int getOcId() {
		return ocId;
	}
	public void setOcId(int ocId) {
		this.ocId = ocId;
	}
	public String getOrderCategory() {
		return orderCategory;
	}
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	public int getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(int orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderItemType() {
		return orderItemType;
	}
	public void setOrderItemType(String orderItemType) {
		this.orderItemType = orderItemType;
	}
	public String getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrigOrderQty() {
		return origOrderQty;
	}
	public void setOrigOrderQty(String origOrderQty) {
		this.origOrderQty = origOrderQty;
	}
	public String getPackageContentSeq() {
		return packageContentSeq;
	}
	public void setPackageContentSeq(String packageContentSeq) {
		this.packageContentSeq = packageContentSeq;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getPaymentAccountSeq() {
		return paymentAccountSeq;
	}
	public void setPaymentAccountSeq(String paymentAccountSeq) {
		this.paymentAccountSeq = paymentAccountSeq;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPercentOfBasicPrice() {
		return percentOfBasicPrice;
	}
	public void setPercentOfBasicPrice(String percentOfBasicPrice) {
		this.percentOfBasicPrice = percentOfBasicPrice;
	}
	public String getPerpetualOrder() {
		return perpetualOrder;
	}
	public void setPerpetualOrder(String perpetualOrder) {
		this.perpetualOrder = perpetualOrder;
	}
	public String getPkgDefId() {
		return pkgDefId;
	}
	public void setPkgDefId(String pkgDefId) {
		this.pkgDefId = pkgDefId;
	}
	public String getPkgItemSeq() {
		return pkgItemSeq;
	}
	public void setPkgItemSeq(String pkgItemSeq) {
		this.pkgItemSeq = pkgItemSeq;
	}
	public String getPremToOrderItemSeq() {
		return premToOrderItemSeq;
	}
	public void setPremToOrderItemSeq(String premToOrderItemSeq) {
		this.premToOrderItemSeq = premToOrderItemSeq;
	}
	public int getPrepaymentReq() {
		return prepaymentReq;
	}
	public void setPrepaymentReq(int prepaymentReq) {
		this.prepaymentReq = prepaymentReq;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getPubRotationId() {
		return pubRotationId;
	}
	public void setPubRotationId(String pubRotationId) {
		this.pubRotationId = pubRotationId;
	}
	public String getQualDate() {
		return qualDate;
	}
	public void setQualDate(String qualDate) {
		this.qualDate = qualDate;
	}
	public String getRateClassEffectiveSeq() {
		return rateClassEffectiveSeq;
	}
	public void setRateClassEffectiveSeq(String rateClassEffectiveSeq) {
		this.rateClassEffectiveSeq = rateClassEffectiveSeq;
	}
	public String getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(String rateClassId) {
		this.rateClassId = rateClassId;
	}
	public String getRatecardSeq() {
		return ratecardSeq;
	}
	public void setRatecardSeq(String ratecardSeq) {
		this.ratecardSeq = ratecardSeq;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	public String getRenewToCustomerAddressSeq() {
		return renewToCustomerAddressSeq;
	}
	public void setRenewToCustomerAddressSeq(String renewToCustomerAddressSeq) {
		this.renewToCustomerAddressSeq = renewToCustomerAddressSeq;
	}
	public String getRenewToCustomerId() {
		return renewToCustomerId;
	}
	public void setRenewToCustomerId(String renewToCustomerId) {
		this.renewToCustomerId = renewToCustomerId;
	}
	public String getRenewalCategory() {
		return renewalCategory;
	}
	public void setRenewalCategory(String renewalCategory) {
		this.renewalCategory = renewalCategory;
	}
	public String getRenewalDef() {
		return renewalDef;
	}
	public void setRenewalDef(String renewalDef) {
		this.renewalDef = renewalDef;
	}
	public String getRenewalDefTestSeq() {
		return renewalDefTestSeq;
	}
	public void setRenewalDefTestSeq(String renewalDefTestSeq) {
		this.renewalDefTestSeq = renewalDefTestSeq;
	}
	public String getRenewalStatus() {
		return renewalStatus;
	}
	public void setRenewalStatus(String renewalStatus) {
		this.renewalStatus = renewalStatus;
	}
	public String getRenewedFromSubscripId() {
		return renewedFromSubscripId;
	}
	public void setRenewedFromSubscripId(String renewedFromSubscripId) {
		this.renewedFromSubscripId = renewedFromSubscripId;
	}
	public int getRevenueMethod() {
		return revenueMethod;
	}
	public void setRevenueMethod(int revenueMethod) {
		this.revenueMethod = revenueMethod;
	}
	public String getSegmentExpireDate() {
		return segmentExpireDate;
	}
	public void setSegmentExpireDate(String segmentExpireDate) {
		this.segmentExpireDate = segmentExpireDate;
	}
	public String getServiceExist() {
		return serviceExist;
	}
	public void setServiceExist(String serviceExist) {
		this.serviceExist = serviceExist;
	}
	public String getShipQty() {
		return shipQty;
	}
	public void setShipQty(String shipQty) {
		this.shipQty = shipQty;
	}
	public String getShippingPriceList() {
		return shippingPriceList;
	}
	public void setShippingPriceList(String shippingPriceList) {
		this.shippingPriceList = shippingPriceList;
	}
	public int getSourceCodeId() {
		return sourceCodeId;
	}
	public void setSourceCodeId(int sourceCodeId) {
		this.sourceCodeId = sourceCodeId;
	}
	public String getSqualDate() {
		return squalDate;
	}
	public void setSqualDate(String squalDate) {
		this.squalDate = squalDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartIssueId() {
		return startIssueId;
	}
	public void setStartIssueId(String startIssueId) {
		this.startIssueId = startIssueId;
	}
	public String getStopIssueId() {
		return stopIssueId;
	}
	public void setStopIssueId(String stopIssueId) {
		this.stopIssueId = stopIssueId;
	}
	public String getSubscripId() {
		return subscripId;
	}
	public void setSubscripId(String subscripId) {
		this.subscripId = subscripId;
	}
	public String getSubscripStartType() {
		return subscripStartType;
	}
	public void setSubscripStartType(String subscripStartType) {
		this.subscripStartType = subscripStartType;
	}
	public String getSubscriptionDefId() {
		return subscriptionDefId;
	}
	public void setSubscriptionDefId(String subscriptionDefId) {
		this.subscriptionDefId = subscriptionDefId;
	}
	public String getTimeUnitOptions() {
		return timeUnitOptions;
	}
	public void setTimeUnitOptions(String timeUnitOptions) {
		this.timeUnitOptions = timeUnitOptions;
	}
	public String getTotalTaxBaseAmount() {
		return totalTaxBaseAmount;
	}
	public void setTotalTaxBaseAmount(String totalTaxBaseAmount) {
		this.totalTaxBaseAmount = totalTaxBaseAmount;
	}
	public String getTotalTaxLocalAmount() {
		return totalTaxLocalAmount;
	}
	public void setTotalTaxLocalAmount(String totalTaxLocalAmount) {
		this.totalTaxLocalAmount = totalTaxLocalAmount;
	}
	public String getTrialPeriod() {
		return trialPeriod;
	}
	public void setTrialPeriod(String trialPeriod) {
		this.trialPeriod = trialPeriod;
	}
	public String getTrialType() {
		return trialType;
	}
	public void setTrialType(String trialType) {
		this.trialType = trialType;
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBillingName() {
		return billingName;
	}
	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}
	public String getRenewalName() {
		return renewalName;
	}
	public void setRenewalName(String renewalName) {
		this.renewalName = renewalName;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	
}
