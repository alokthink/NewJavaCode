package com.mps.think.model;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class OrderItem 
{
	private long orderhdrId;
	private int orderItemSeq;
	private String deliveryMethod;
	private String deliverydisc;
	private String distributionMethod;
	private String attribute;
	private String value;
	private String userCode;	
	private int dateStamp;
	private int orderItemType;
	private Calendar orderDate1;
	private String orderDate;
	private String grossBaseAmount;
	private String grossLocalAmount;
	private String netBaseAmount;
	private String netLocalAmount;
	private String baseAmount;
	private String localAmount;
	private String localCommission;
	private String baseCommission;
	private int hasTax;
	private int hasDeliveryCharge;
	private String billDate;
	private int paymentStatus;
	private int refundStatus;
	private int orderType;	
	private int hasPremium;
	private int prepaymentReq;
	private String productId;
	private int isComplimentary;
	private int subscripStartType;
	private int duration;
	private int renewalStatus;
	private int deliveryMethodPerm;
	private int changeQtyFlag;
	private int nRemainingPaidIssue;
	private int extIssleft;
	private int extIssTot;
	private int orderStatus;
	private int renewalCategory;
	private String exchangeRate;
	private int rateClassId;
	private int rateClassEffectiveSeq;
	private String inventoryId;
	private int ocId;
	private int autoPayment;
	private int perpetualOrder;
	private int billToCustomerId;
	private int billToCustomerAddressSeq;
	private int renewToCustomerId;
	private int renewToCustomerAddressSeq;
	private int customerId;
	private int customerAddressSeq;
	private int altShipCustomerId;
	private int altShipCustomerAddressSeq;
	private int noteExist;
	private int serviceExist;
	private int mruOrderItemAmtBreakSeq;
	private int hasBeenRenewed;
	private int revenueMethod;
	private int trialType;
	private int origOrderQty;
	private String unitExcess;
	private int isProforma;
	private int nTaxUpdates;
	private String totalTaxLocalAmount;
	private String totalTaxBaseAmount;
	private int electronicDelivery;
	private int timeUnitOptions;
	private int groupOrder;
	private String invoiceDate;
	private int autoRenewNotifySent;
	private int extendedDays;
	private int asynchronousAutoRenew;
	private int nDaysGraced;
	private int isBackOrdered;
	private int mruGrpMbrItemDtlSeq;	
	private String orderCodeID;
	private String sourceCodeID;
	private String orderCodeType;
	private String orderClass;
	private String orderCode;
	private String sourceCode;
	private String orderCodeDescription;
	private String sourceCodeDescription;
	private int bundleQty;
	private int orderQty;
	private String shipQty;
	private String backordQty;
	private double amountCharged;
	private String currency;
	private String billingType;
	private String fullName;
	private String address1;
	private String altFullNameTo;
	private String billToFullName;
	private String altCustomerAddress;
	private String billToCustomerAddress;
	private String renewToCustomerAddress;
	private String renewFullNameTo;
	private List<Map<String, Object>> altCustomerAddressList;
	private List<Map<String, Object>> billToCustomerAddressList;
	private String product;
	private String productSize;
	private String productStyle;
	private String productColor;
	private String productTaxonomy;
	private String startIssueId;
	private int stopIssueId;
	private String currIssueId;
	private String subscriptionDefId;	
	private String startDate;
	private String expireDate;
	private int nNonPaidIssues;
	private int nRemainingNonPaidIssues;
	private String subscriptionDef;
	private String subscriptionDefDescription;
	private String termDescription;
	private String subscriptionCategoryId;
	private String subscriptionCategoryDescription;
	private String poNumber;
	private String rateClassDescription;
	private String rateClassEffectiveDate;
	private String order_status;
	private String payment_status;
	private String media;
	private String edition;
	private int rotation;
	private String packageID;
	private String agencyCode;
	private String agencyName;
	private String agencyCustomerId;
	private String agencyRefNbr;
	private String invoiceNo;
	private String orderCategory;
	private double taxRateAmount;
	private double manualDiscAmtLocal;
	private double manualDiscAmtBase;
	private double manualDiscPercentage;
	private int docRefId;	
	private String nIssueLeft;
	private String subscripId;
	private String packageContentSeq;
	private String nInvEffort;
	private String lastInvDate;
	private String auditQualCategory;
	private String cancelReason;
	private String customerGroupId;
	private String auditSourceId;
	private String auditSubscriptionTypeId;
	private String percentOfBasicPrice;
	private String nRenEffort;
	private String lastRenDate;
	private String nDelIssLeft;
	private String auditNameTitleId;	
	private String auditSalesChannelId;	
	private String qualDate;	
	private String squalDate;
	private String pubRotationId;
	private String premToOrderItemSeq;
	private String renewalOrderhdrId;
	private String renewalOrderItemSeq;
	private String discountClassId;
	private String discClassEffectiveSeq;
	private String discountCardSeq;
	private String installmentPlanId;
	private String numberVolumeSets;
	private String altShipDelCalc;	
	private String billingDef;
	private String billingDefTestSeq;	
	private String renewalDef;	
	private String renewalDefTestSeq;	
	private String agentRefNbr;
	private String mruSuspensionSeq;	
	private String mruOrderItemShipSeq;	
	private String mruBillingHistorySeq;	
	private String mruOrderItemSglIssuesSeq;
	private String electronicDocumentIdentifier;
	private String packageInstance;	
	private String unitTypeId;	
	private String exRateClassId;	
	private String exRateClassEffectiveSeq;	
	private String exRatecardSeq;	
	private String trialPeriod;	
	private String mruUnitHistorySeq;	
	private String nNonpaidIssues;	
	private String nRemainingNonpaidIssues;	
	private String nCalUnitsPerSeg;	
	private String segmentExpireDate;	
	private String calendarUnit;	
	private String nItemsPerSeg;	
	private String nSegmentsLeft;	
	private String rowVersion;	
	private String mruOrderItemNoteSeq;	
	private String nTax_updates;	
	private String renewedFromSubscripId;	
	private String pkgItemSeq;	
	private String pkgDefId;	
	private String pkgContentSeq;	
	private String itemUrl;	
	private String paymentAccountSeq;	
	private String maxCheckOutAmt;	
	private String nCheckedOut;	
	private String dealId;	
	private String invoiceId;	
	private String fulfillmentDate;	
	private String multilineDiscountSchedule;	
	private String multilineDiscAmount;	
	private String multilineDiscEffSeq;	
	private String shippingPriceList;	
	private String extendedRate;	
	private String attachExist;	
	private String addonToOrderhdrId;	
	private String addonToOrderItemSeq;	
	private String genericPromotionCodeSeq;	
	private String chargeOnCancellation;	
	private String lastTaxInvoiceDate;	
	private String documentReferenceId;
	private int expireYear;
	private String pageName;
	private int startType;
	private String enumeration;
	private double revenue_percent;
	private int liability;
	private String productPrice; 
	// table:order_item_install
	private Integer nbrInstallments;
	private String installAutoPayment;
	private String mandateDate;
	private String debitAccountRef;
	private String noticeDate;
	private String sendNotice;
	private String currentYearSent;
	private String yearEndSent;
	private Integer installPaymentAccountSeq;
	private String paymentStartDate;
	private String paymentEndDate;
	private Integer pullDay;
	private String ddiAccepted;
	private String ddiLogged;
	private String mostRecentPaymentDate;
	private String auddisTransactionCode;
	private String bacsTransactionCode;
	private String cancelDD;
	private String nextPaymentDate;
	private String unitDescription;
	private int unitUse;
	private int installmentIdNew;
	private String chargeNew;
	private String remitNew;
	private String percentNew;
	private String chargeRen;
	private String remitRen;
	private String percentRen;
	private String genericPromotionCode;
	private String unitType;
	private String unitTypeDescription;
	private String new_commission;
	private String ren_commission;
	private int audited;
	private int QP;
	private int QF;
	private int NQP;
	private int NQF;
	private String customerDistributionValues;
	private int minItem;
	private int maxItem;
	private String pkgType;
	private Integer intallmentId;
	private Integer subscriptionId; 
	private String state;
	private int quickOrderCodeId;
	private String rateClass;
	private double due;
	private double pay;
	private double charged;
	public double getCharged() {
		return charged;
	}

	public void setCharged(double charged) {
		this.charged = charged;
	}

	public double getDue() {
		return due;
	}

	public void setDue(double due) {
		this.due = due;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	//Added for 610,611
	private double cancelledOrderAmount;
	private String payment_type;
	
	
	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public double getCancelledOrderAmount() {
		return cancelledOrderAmount;
	}

	public void setCancelledOrderAmount(double cancelledOrderAmount) {
		this.cancelledOrderAmount = cancelledOrderAmount;
	}

	public Integer getIntallmentId() {
		return intallmentId;
	}

	public void setIntallmentId(Integer intallmentId) {
		this.intallmentId = intallmentId;
	}

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getQuickOrderCodeId() {
		return quickOrderCodeId;
	}

	public void setQuickOrderCodeId(int quickOrderCodeId) {
		this.quickOrderCodeId = quickOrderCodeId;
	}

	public long getOrderhdrId() {
		return orderhdrId;
	}

	public void setOrderhdrId(long orderhdrId) {
		this.orderhdrId = orderhdrId;
	}

	public int getOrderItemSeq() {
		return orderItemSeq;
	}

	public void setOrderItemSeq(int orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getDeliverydisc() {
		return deliverydisc;
	}

	public void setDeliverydisc(String deliverydisc) {
		this.deliverydisc = deliverydisc;
	}

	public String getDistributionMethod() {
		return distributionMethod;
	}

	public void setDistributionMethod(String distributionMethod) {
		this.distributionMethod = distributionMethod;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(int dateStamp) {
		this.dateStamp = dateStamp;
	}

	public int getOrderItemType() {
		return orderItemType;
	}

	public void setOrderItemType(int orderItemType) {
		this.orderItemType = orderItemType;
	}

	public Calendar getOrderDate1() {
		return orderDate1;
	}

	public Calendar setOrderDate1(Calendar orderDate1) {
		return this.orderDate1 = orderDate1;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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

	public String getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(String baseAmount) {
		this.baseAmount = baseAmount;
	}

	public String getLocalAmount() {
		return localAmount;
	}

	public void setLocalAmount(String localAmount) {
		this.localAmount = localAmount;
	}

	public String getLocalCommission() {
		return localCommission;
	}

	public void setLocalCommission(String localCommission) {
		this.localCommission = localCommission;
	}

	public String getBaseCommission() {
		return baseCommission;
	}

	public void setBaseCommission(String baseCommission) {
		this.baseCommission = baseCommission;
	}

	public int getHasTax() {
		return hasTax;
	}

	public void setHasTax(int hasTax) {
		this.hasTax = hasTax;
	}

	public int getHasDeliveryCharge() {
		return hasDeliveryCharge;
	}

	public void setHasDeliveryCharge(int hasDeliveryCharge) {
		this.hasDeliveryCharge = hasDeliveryCharge;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(int refundStatus) {
		this.refundStatus = refundStatus;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getHasPremium() {
		return hasPremium;
	}

	public void setHasPremium(int hasPremium) {
		this.hasPremium = hasPremium;
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

	public int getIsComplimentary() {
		return isComplimentary;
	}

	public void setIsComplimentary(int isComplimentary) {
		this.isComplimentary = isComplimentary;
	}

	public int getSubscripStartType() {
		return subscripStartType;
	}

	public void setSubscripStartType(int subscripStartType) {
		this.subscripStartType = subscripStartType;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRenewalStatus() {
		return renewalStatus;
	}

	public void setRenewalStatus(int renewalStatus) {
		this.renewalStatus = renewalStatus;
	}

	public int getDeliveryMethodPerm() {
		return deliveryMethodPerm;
	}

	public void setDeliveryMethodPerm(int deliveryMethodPerm) {
		this.deliveryMethodPerm = deliveryMethodPerm;
	}

	public int getChangeQtyFlag() {
		return changeQtyFlag;
	}

	public void setChangeQtyFlag(int changeQtyFlag) {
		this.changeQtyFlag = changeQtyFlag;
	}

	public int getnRemainingPaidIssue() {
		return nRemainingPaidIssue;
	}

	public void setnRemainingPaidIssue(int nRemainingPaidIssue) {
		this.nRemainingPaidIssue = nRemainingPaidIssue;
	}

	public int getExtIssleft() {
		return extIssleft;
	}

	public void setExtIssleft(int extIssleft) {
		this.extIssleft = extIssleft;
	}

	public int getExtIssTot() {
		return extIssTot;
	}

	public void setExtIssTot(int extIssTot) {
		this.extIssTot = extIssTot;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getRenewalCategory() {
		return renewalCategory;
	}

	public void setRenewalCategory(int renewalCategory) {
		this.renewalCategory = renewalCategory;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public int getRateClassId() {
		return rateClassId;
	}

	public void setRateClassId(int rateClassId) {
		this.rateClassId = rateClassId;
	}

	public int getRateClassEffectiveSeq() {
		return rateClassEffectiveSeq;
	}

	public void setRateClassEffectiveSeq(int rateClassEffectiveSeq) {
		this.rateClassEffectiveSeq = rateClassEffectiveSeq;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getOcId() {
		return ocId;
	}

	public void setOcId(int ocId) {
		this.ocId = ocId;
	}

	public int getAutoPayment() {
		return autoPayment;
	}

	public void setAutoPayment(int autoPayment) {
		this.autoPayment = autoPayment;
	}

	public int getPerpetualOrder() {
		return perpetualOrder;
	}

	public void setPerpetualOrder(int perpetualOrder) {
		this.perpetualOrder = perpetualOrder;
	}

	public int getBillToCustomerId() {
		return billToCustomerId;
	}

	public void setBillToCustomerId(int billToCustomerId) {
		this.billToCustomerId = billToCustomerId;
	}

	public int getBillToCustomerAddressSeq() {
		return billToCustomerAddressSeq;
	}

	public void setBillToCustomerAddressSeq(int billToCustomerAddressSeq) {
		this.billToCustomerAddressSeq = billToCustomerAddressSeq;
	}

	public int getRenewToCustomerId() {
		return renewToCustomerId;
	}

	public void setRenewToCustomerId(int renewToCustomerId) {
		this.renewToCustomerId = renewToCustomerId;
	}

	public int getRenewToCustomerAddressSeq() {
		return renewToCustomerAddressSeq;
	}

	public void setRenewToCustomerAddressSeq(int renewToCustomerAddressSeq) {
		this.renewToCustomerAddressSeq = renewToCustomerAddressSeq;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerAddressSeq() {
		return customerAddressSeq;
	}

	public void setCustomerAddressSeq(int customerAddressSeq) {
		this.customerAddressSeq = customerAddressSeq;
	}

	public int getAltShipCustomerId() {
		return altShipCustomerId;
	}

	public void setAltShipCustomerId(int altShipCustomerId) {
		this.altShipCustomerId = altShipCustomerId;
	}

	public int getAltShipCustomerAddressSeq() {
		return altShipCustomerAddressSeq;
	}

	public void setAltShipCustomerAddressSeq(int altShipCustomerAddressSeq) {
		this.altShipCustomerAddressSeq = altShipCustomerAddressSeq;
	}

	public int getNoteExist() {
		return noteExist;
	}

	public void setNoteExist(int noteExist) {
		this.noteExist = noteExist;
	}

	public int getServiceExist() {
		return serviceExist;
	}

	public void setServiceExist(int serviceExist) {
		this.serviceExist = serviceExist;
	}

	public int getMruOrderItemAmtBreakSeq() {
		return mruOrderItemAmtBreakSeq;
	}

	public void setMruOrderItemAmtBreakSeq(int mruOrderItemAmtBreakSeq) {
		this.mruOrderItemAmtBreakSeq = mruOrderItemAmtBreakSeq;
	}

	public int getHasBeenRenewed() {
		return hasBeenRenewed;
	}

	public void setHasBeenRenewed(int hasBeenRenewed) {
		this.hasBeenRenewed = hasBeenRenewed;
	}

	public int getRevenueMethod() {
		return revenueMethod;
	}

	public void setRevenueMethod(int revenueMethod) {
		this.revenueMethod = revenueMethod;
	}

	public int getTrialType() {
		return trialType;
	}

	public void setTrialType(int trialType) {
		this.trialType = trialType;
	}

	public int getOrigOrderQty() {
		return origOrderQty;
	}

	public void setOrigOrderQty(int origOrderQty) {
		this.origOrderQty = origOrderQty;
	}

	public String getUnitExcess() {
		return unitExcess;
	}

	public void setUnitExcess(String unitExcess) {
		this.unitExcess = unitExcess;
	}

	public int getIsProforma() {
		return isProforma;
	}

	public void setIsProforma(int isProforma) {
		this.isProforma = isProforma;
	}

	public int getnTaxUpdates() {
		return nTaxUpdates;
	}

	public void setnTaxUpdates(int nTaxUpdates) {
		this.nTaxUpdates = nTaxUpdates;
	}

	public String getTotalTaxLocalAmount() {
		return totalTaxLocalAmount;
	}

	public void setTotalTaxLocalAmount(String totalTaxLocalAmount) {
		this.totalTaxLocalAmount = totalTaxLocalAmount;
	}

	public String getTotalTaxBaseAmount() {
		return totalTaxBaseAmount;
	}

	public void setTotalTaxBaseAmount(String totalTaxBaseAmount) {
		this.totalTaxBaseAmount = totalTaxBaseAmount;
	}

	public int getElectronicDelivery() {
		return electronicDelivery;
	}

	public void setElectronicDelivery(int electronicDelivery) {
		this.electronicDelivery = electronicDelivery;
	}

	public int getTimeUnitOptions() {
		return timeUnitOptions;
	}

	public void setTimeUnitOptions(int timeUnitOptions) {
		this.timeUnitOptions = timeUnitOptions;
	}

	public int getGroupOrder() {
		return groupOrder;
	}

	public void setGroupOrder(int groupOrder) {
		this.groupOrder = groupOrder;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getAutoRenewNotifySent() {
		return autoRenewNotifySent;
	}

	public void setAutoRenewNotifySent(int autoRenewNotifySent) {
		this.autoRenewNotifySent = autoRenewNotifySent;
	}

	public int getExtendedDays() {
		return extendedDays;
	}

	public void setExtendedDays(int extendedDays) {
		this.extendedDays = extendedDays;
	}

	public int getAsynchronousAutoRenew() {
		return asynchronousAutoRenew;
	}

	public void setAsynchronousAutoRenew(int asynchronousAutoRenew) {
		this.asynchronousAutoRenew = asynchronousAutoRenew;
	}

	public int getnDaysGraced() {
		return nDaysGraced;
	}

	public void setnDaysGraced(int nDaysGraced) {
		this.nDaysGraced = nDaysGraced;
	}

	public int getIsBackOrdered() {
		return isBackOrdered;
	}

	public void setIsBackOrdered(int isBackOrdered) {
		this.isBackOrdered = isBackOrdered;
	}

	public int getMruGrpMbrItemDtlSeq() {
		return mruGrpMbrItemDtlSeq;
	}

	public void setMruGrpMbrItemDtlSeq(int mruGrpMbrItemDtlSeq) {
		this.mruGrpMbrItemDtlSeq = mruGrpMbrItemDtlSeq;
	}

	public String getOrderCodeID() {
		return orderCodeID;
	}

	public void setOrderCodeID(String orderCodeID) {
		this.orderCodeID = orderCodeID;
	}

	public String getSourceCodeID() {
		return sourceCodeID;
	}

	public void setSourceCodeID(String sourceCodeID) {
		this.sourceCodeID = sourceCodeID;
	}

	public String getOrderCodeType() {
		return orderCodeType;
	}

	public void setOrderCodeType(String orderCodeType) {
		this.orderCodeType = orderCodeType;
	}

	public String getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(String orderClass) {
		this.orderClass = orderClass;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getOrderCodeDescription() {
		return orderCodeDescription;
	}

	public void setOrderCodeDescription(String orderCodeDescription) {
		this.orderCodeDescription = orderCodeDescription;
	}

	public String getSourceCodeDescription() {
		return sourceCodeDescription;
	}

	public void setSourceCodeDescription(String sourceCodeDescription) {
		this.sourceCodeDescription = sourceCodeDescription;
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

	public double getAmountCharged() {
		return amountCharged;
	}

	public void setAmountCharged(double amountCharged) {
		this.amountCharged = amountCharged;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAltFullNameTo() {
		return altFullNameTo;
	}

	public void setAltFullNameTo(String altFullNameTo) {
		this.altFullNameTo = altFullNameTo;
	}

	public String getBillToFullName() {
		return billToFullName;
	}

	public void setBillToFullName(String billToFullName) {
		this.billToFullName = billToFullName;
	}

	public String getAltCustomerAddress() {
		return altCustomerAddress;
	}

	public void setAltCustomerAddress(String altCustomerAddress) {
		this.altCustomerAddress = altCustomerAddress;
	}

	public String getBillToCustomerAddress() {
		return billToCustomerAddress;
	}

	public void setBillToCustomerAddress(String billToCustomerAddress) {
		this.billToCustomerAddress = billToCustomerAddress;
	}

	public String getRenewToCustomerAddress() {
		return renewToCustomerAddress;
	}

	public void setRenewToCustomerAddress(String renewToCustomerAddress) {
		this.renewToCustomerAddress = renewToCustomerAddress;
	}

	public String getRenewFullNameTo() {
		return renewFullNameTo;
	}

	public void setRenewFullNameTo(String renewFullNameTo) {
		this.renewFullNameTo = renewFullNameTo;
	}

	public List<Map<String, Object>> getAltCustomerAddressList() {
		return altCustomerAddressList;
	}

	public void setAltCustomerAddressList(List<Map<String, Object>> altCustomerAddressList) {
		this.altCustomerAddressList = altCustomerAddressList;
	}

	public List<Map<String, Object>> getBillToCustomerAddressList() {
		return billToCustomerAddressList;
	}

	public void setBillToCustomerAddressList(List<Map<String, Object>> billToCustomerAddressList) {
		this.billToCustomerAddressList = billToCustomerAddressList;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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

	public String getProductTaxonomy() {
		return productTaxonomy;
	}

	public void setProductTaxonomy(String productTaxonomy) {
		this.productTaxonomy = productTaxonomy;
	}

	public String getStartIssueId() {
		return startIssueId;
	}

	public void setStartIssueId(String startIssueId) {
		this.startIssueId = startIssueId;
	}

	public int getStopIssueId() {
		return stopIssueId;
	}

	public void setStopIssueId(int stopIssueId) {
		this.stopIssueId = stopIssueId;
	}

	public String getCurrIssueId() {
		return currIssueId;
	}

	public void setCurrIssueId(String currIssueId) {
		this.currIssueId = currIssueId;
	}

	public String getSubscriptionDefId() {
		return subscriptionDefId;
	}

	public void setSubscriptionDefId(String subscriptionDefId) {
		this.subscriptionDefId = subscriptionDefId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public int getnNonPaidIssues() {
		return nNonPaidIssues;
	}

	public void setnNonPaidIssues(int nNonPaidIssues) {
		this.nNonPaidIssues = nNonPaidIssues;
	}

	public int getnRemainingNonPaidIssues() {
		return nRemainingNonPaidIssues;
	}

	public void setnRemainingNonPaidIssues(int nRemainingNonPaidIssues) {
		this.nRemainingNonPaidIssues = nRemainingNonPaidIssues;
	}

	public String getSubscriptionDef() {
		return subscriptionDef;
	}

	public void setSubscriptionDef(String subscriptionDef) {
		this.subscriptionDef = subscriptionDef;
	}

	public String getSubscriptionDefDescription() {
		return subscriptionDefDescription;
	}

	public void setSubscriptionDefDescription(String subscriptionDefDescription) {
		this.subscriptionDefDescription = subscriptionDefDescription;
	}

	public String getTermDescription() {
		return termDescription;
	}

	public void setTermDescription(String termDescription) {
		this.termDescription = termDescription;
	}

	public String getSubscriptionCategoryId() {
		return subscriptionCategoryId;
	}

	public void setSubscriptionCategoryId(String subscriptionCategoryId) {
		this.subscriptionCategoryId = subscriptionCategoryId;
	}

	public String getSubscriptionCategoryDescription() {
		return subscriptionCategoryDescription;
	}

	public void setSubscriptionCategoryDescription(String subscriptionCategoryDescription) {
		this.subscriptionCategoryDescription = subscriptionCategoryDescription;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public String getRateClassDescription() {
		return rateClassDescription;
	}

	public void setRateClassDescription(String rateClassDescription) {
		this.rateClassDescription = rateClassDescription;
	}

	public String getRateClassEffectiveDate() {
		return rateClassEffectiveDate;
	}

	public void setRateClassEffectiveDate(String rateClassEffectiveDate) {
		this.rateClassEffectiveDate = rateClassEffectiveDate;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public String getPackageID() {
		return packageID;
	}

	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyCustomerId() {
		return agencyCustomerId;
	}

	public void setAgencyCustomerId(String agencyCustomerId) {
		this.agencyCustomerId = agencyCustomerId;
	}

	public String getAgencyRefNbr() {
		return agencyRefNbr;
	}

	public void setAgencyRefNbr(String agencyRefNbr) {
		this.agencyRefNbr = agencyRefNbr;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getOrderCategory() {
		return orderCategory;
	}

	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}

	public double getTaxRateAmount() {
		return taxRateAmount;
	}

	public void setTaxRateAmount(double taxRateAmount) {
		this.taxRateAmount = taxRateAmount;
	}

	public double getManualDiscAmtLocal() {
		return manualDiscAmtLocal;
	}

	public void setManualDiscAmtLocal(double manualDiscAmtLocal) {
		this.manualDiscAmtLocal = manualDiscAmtLocal;
	}

	public double getManualDiscAmtBase() {
		return manualDiscAmtBase;
	}

	public void setManualDiscAmtBase(double manualDiscAmtBase) {
		this.manualDiscAmtBase = manualDiscAmtBase;
	}

	public double getManualDiscPercentage() {
		return manualDiscPercentage;
	}

	public void setManualDiscPercentage(double manualDiscPercentage) {
		this.manualDiscPercentage = manualDiscPercentage;
	}

	public int getDocRefId() {
		return docRefId;
	}

	public void setDocRefId(int docRefId) {
		this.docRefId = docRefId;
	}

	public String getnIssueLeft() {
		return nIssueLeft;
	}

	public void setnIssueLeft(String nIssueLeft) {
		this.nIssueLeft = nIssueLeft;
	}

	public String getSubscripId() {
		return subscripId;
	}

	public void setSubscripId(String subscripId) {
		this.subscripId = subscripId;
	}

	public String getPackageContentSeq() {
		return packageContentSeq;
	}

	public void setPackageContentSeq(String packageContentSeq) {
		this.packageContentSeq = packageContentSeq;
	}

	public String getnInvEffort() {
		return nInvEffort;
	}

	public void setnInvEffort(String nInvEffort) {
		this.nInvEffort = nInvEffort;
	}

	public String getLastInvDate() {
		return lastInvDate;
	}

	public void setLastInvDate(String lastInvDate) {
		this.lastInvDate = lastInvDate;
	}

	public String getAuditQualCategory() {
		return auditQualCategory;
	}

	public void setAuditQualCategory(String auditQualCategory) {
		this.auditQualCategory = auditQualCategory;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCustomerGroupId() {
		return customerGroupId;
	}

	public void setCustomerGroupId(String customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public String getAuditSourceId() {
		return auditSourceId;
	}

	public void setAuditSourceId(String auditSourceId) {
		this.auditSourceId = auditSourceId;
	}


	public String getAuditSubscriptionTypeId() {
		return auditSubscriptionTypeId;
	}

	public void setAuditSubscriptionTypeId(String auditSubscriptionTypeId) {
		this.auditSubscriptionTypeId = auditSubscriptionTypeId;
	}

	public String getPercentOfBasicPrice() {
		return percentOfBasicPrice;
	}

	public void setPercentOfBasicPrice(String percentOfBasicPrice) {
		this.percentOfBasicPrice = percentOfBasicPrice;
	}

	public String getnRenEffort() {
		return nRenEffort;
	}

	public void setnRenEffort(String nRenEffort) {
		this.nRenEffort = nRenEffort;
	}

	public String getLastRenDate() {
		return lastRenDate;
	}

	public void setLastRenDate(String lastRenDate) {
		this.lastRenDate = lastRenDate;
	}

	public String getnDelIssLeft() {
		return nDelIssLeft;
	}

	public void setnDelIssLeft(String nDelIssLeft) {
		this.nDelIssLeft = nDelIssLeft;
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

	public String getQualDate() {
		return qualDate;
	}

	public void setQualDate(String qualDate) {
		this.qualDate = qualDate;
	}

	public String getSqualDate() {
		return squalDate;
	}

	public void setSqualDate(String squalDate) {
		this.squalDate = squalDate;
	}

	public String getPubRotationId() {
		return pubRotationId;
	}

	public void setPubRotationId(String pubRotationId) {
		this.pubRotationId = pubRotationId;
	}

	public String getPremToOrderItemSeq() {
		return premToOrderItemSeq;
	}

	public void setPremToOrderItemSeq(String premToOrderItemSeq) {
		this.premToOrderItemSeq = premToOrderItemSeq;
	}

	public String getRenewalOrderhdrId() {
		return renewalOrderhdrId;
	}

	public void setRenewalOrderhdrId(String renewalOrderhdrId) {
		this.renewalOrderhdrId = renewalOrderhdrId;
	}

	public String getRenewalOrderItemSeq() {
		return renewalOrderItemSeq;
	}

	public void setRenewalOrderItemSeq(String renewalOrderItemSeq) {
		this.renewalOrderItemSeq = renewalOrderItemSeq;
	}

	public String getDiscountClassId() {
		return discountClassId;
	}

	public void setDiscountClassId(String discountClassId) {
		this.discountClassId = discountClassId;
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

	public String getInstallmentPlanId() {
		return installmentPlanId;
	}

	public void setInstallmentPlanId(String installmentPlanId) {
		this.installmentPlanId = installmentPlanId;
	}

	public String getNumberVolumeSets() {
		return numberVolumeSets;
	}

	public void setNumberVolumeSets(String numberVolumeSets) {
		this.numberVolumeSets = numberVolumeSets;
	}

	public String getAltShipDelCalc() {
		return altShipDelCalc;
	}

	public void setAltShipDelCalc(String altShipDelCalc) {
		this.altShipDelCalc = altShipDelCalc;
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

	public String getAgentRefNbr() {
		return agentRefNbr;
	}

	public void setAgentRefNbr(String agentRefNbr) {
		this.agentRefNbr = agentRefNbr;
	}

	public String getMruSuspensionSeq() {
		return mruSuspensionSeq;
	}

	public void setMruSuspensionSeq(String mruSuspensionSeq) {
		this.mruSuspensionSeq = mruSuspensionSeq;
	}

	public String getMruOrderItemShipSeq() {
		return mruOrderItemShipSeq;
	}

	public void setMruOrderItemShipSeq(String mruOrderItemShipSeq) {
		this.mruOrderItemShipSeq = mruOrderItemShipSeq;
	}

	public String getMruBillingHistorySeq() {
		return mruBillingHistorySeq;
	}

	public void setMruBillingHistorySeq(String mruBillingHistorySeq) {
		this.mruBillingHistorySeq = mruBillingHistorySeq;
	}

	public String getMruOrderItemSglIssuesSeq() {
		return mruOrderItemSglIssuesSeq;
	}

	public void setMruOrderItemSglIssuesSeq(String mruOrderItemSglIssuesSeq) {
		this.mruOrderItemSglIssuesSeq = mruOrderItemSglIssuesSeq;
	}

	public String getElectronicDocumentIdentifier() {
		return electronicDocumentIdentifier;
	}

	public void setElectronicDocumentIdentifier(String electronicDocumentIdentifier) {
		this.electronicDocumentIdentifier = electronicDocumentIdentifier;
	}

	public String getPackageInstance() {
		return packageInstance;
	}

	public void setPackageInstance(String packageInstance) {
		this.packageInstance = packageInstance;
	}

	public String getUnitTypeId() {
		return unitTypeId;
	}

	public void setUnitTypeId(String unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	public String getExRateClassId() {
		return exRateClassId;
	}

	public void setExRateClassId(String exRateClassId) {
		this.exRateClassId = exRateClassId;
	}

	public String getExRateClassEffectiveSeq() {
		return exRateClassEffectiveSeq;
	}

	public void setExRateClassEffectiveSeq(String exRateClassEffectiveSeq) {
		this.exRateClassEffectiveSeq = exRateClassEffectiveSeq;
	}

	public String getExRatecardSeq() {
		return exRatecardSeq;
	}

	public void setExRatecardSeq(String exRatecardSeq) {
		this.exRatecardSeq = exRatecardSeq;
	}

	public String getTrialPeriod() {
		return trialPeriod;
	}

	public void setTrialPeriod(String trialPeriod) {
		this.trialPeriod = trialPeriod;
	}

	public String getMruUnitHistorySeq() {
		return mruUnitHistorySeq;
	}

	public void setMruUnitHistorySeq(String mruUnitHistorySeq) {
		this.mruUnitHistorySeq = mruUnitHistorySeq;
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

	public String getnCalUnitsPerSeg() {
		return nCalUnitsPerSeg;
	}

	public void setnCalUnitsPerSeg(String nCalUnitsPerSeg) {
		this.nCalUnitsPerSeg = nCalUnitsPerSeg;
	}

	public String getSegmentExpireDate() {
		return segmentExpireDate;
	}

	public void setSegmentExpireDate(String segmentExpireDate) {
		this.segmentExpireDate = segmentExpireDate;
	}

	public String getCalendarUnit() {
		return calendarUnit;
	}

	public void setCalendarUnit(String calendarUnit) {
		this.calendarUnit = calendarUnit;
	}

	public String getnItemsPerSeg() {
		return nItemsPerSeg;
	}

	public void setnItemsPerSeg(String nItemsPerSeg) {
		this.nItemsPerSeg = nItemsPerSeg;
	}

	public String getnSegmentsLeft() {
		return nSegmentsLeft;
	}

	public void setnSegmentsLeft(String nSegmentsLeft) {
		this.nSegmentsLeft = nSegmentsLeft;
	}

	public String getRowVersion() {
		return rowVersion;
	}

	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
	}

	public String getMruOrderItemNoteSeq() {
		return mruOrderItemNoteSeq;
	}

	public void setMruOrderItemNoteSeq(String mruOrderItemNoteSeq) {
		this.mruOrderItemNoteSeq = mruOrderItemNoteSeq;
	}

	public String getnTax_updates() {
		return nTax_updates;
	}

	public void setnTax_updates(String nTax_updates) {
		this.nTax_updates = nTax_updates;
	}

	public String getRenewedFromSubscripId() {
		return renewedFromSubscripId;
	}

	public void setRenewedFromSubscripId(String renewedFromSubscripId) {
		this.renewedFromSubscripId = renewedFromSubscripId;
	}

	public String getPkgItemSeq() {
		return pkgItemSeq;
	}

	public void setPkgItemSeq(String pkgItemSeq) {
		this.pkgItemSeq = pkgItemSeq;
	}

	public String getPkgDefId() {
		return pkgDefId;
	}

	public void setPkgDefId(String pkgDefId) {
		this.pkgDefId = pkgDefId;
	}

	public String getPkgContentSeq() {
		return pkgContentSeq;
	}

	public void setPkgContentSeq(String pkgContentSeq) {
		this.pkgContentSeq = pkgContentSeq;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public String getPaymentAccountSeq() {
		return paymentAccountSeq;
	}

	public void setPaymentAccountSeq(String paymentAccountSeq) {
		this.paymentAccountSeq = paymentAccountSeq;
	}

	public String getMaxCheckOutAmt() {
		return maxCheckOutAmt;
	}

	public void setMaxCheckOutAmt(String maxCheckOutAmt) {
		this.maxCheckOutAmt = maxCheckOutAmt;
	}

	public String getnCheckedOut() {
		return nCheckedOut;
	}

	public void setnCheckedOut(String nCheckedOut) {
		this.nCheckedOut = nCheckedOut;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getFulfillmentDate() {
		return fulfillmentDate;
	}

	public void setFulfillmentDate(String fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}

	public String getMultilineDiscountSchedule() {
		return multilineDiscountSchedule;
	}

	public void setMultilineDiscountSchedule(String multilineDiscountSchedule) {
		this.multilineDiscountSchedule = multilineDiscountSchedule;
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

	public String getShippingPriceList() {
		return shippingPriceList;
	}

	public void setShippingPriceList(String shippingPriceList) {
		this.shippingPriceList = shippingPriceList;
	}

	public String getExtendedRate() {
		return extendedRate;
	}

	public void setExtendedRate(String extendedRate) {
		this.extendedRate = extendedRate;
	}

	public String getAttachExist() {
		return attachExist;
	}

	public void setAttachExist(String attachExist) {
		this.attachExist = attachExist;
	}

	public String getAddonToOrderhdrId() {
		return addonToOrderhdrId;
	}

	public void setAddonToOrderhdrId(String addonToOrderhdrId) {
		this.addonToOrderhdrId = addonToOrderhdrId;
	}

	public String getAddonToOrderItemSeq() {
		return addonToOrderItemSeq;
	}

	public void setAddonToOrderItemSeq(String addonToOrderItemSeq) {
		this.addonToOrderItemSeq = addonToOrderItemSeq;
	}

	public String getGenericPromotionCodeSeq() {
		return genericPromotionCodeSeq;
	}

	public void setGenericPromotionCodeSeq(String genericPromotionCodeSeq) {
		this.genericPromotionCodeSeq = genericPromotionCodeSeq;
	}

	public String getChargeOnCancellation() {
		return chargeOnCancellation;
	}

	public void setChargeOnCancellation(String chargeOnCancellation) {
		this.chargeOnCancellation = chargeOnCancellation;
	}

	public String getLastTaxInvoiceDate() {
		return lastTaxInvoiceDate;
	}

	public void setLastTaxInvoiceDate(String lastTaxInvoiceDate) {
		this.lastTaxInvoiceDate = lastTaxInvoiceDate;
	}

	public String getDocumentReferenceId() {
		return documentReferenceId;
	}

	public void setDocumentReferenceId(String documentReferenceId) {
		this.documentReferenceId = documentReferenceId;
	}

	public int getExpireYear() {
		return expireYear;
	}

	public void setExpireYear(int expireYear) {
		this.expireYear = expireYear;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public int getStartType() {
		return startType;
	}

	public void setStartType(int startType) {
		this.startType = startType;
	}

	public String getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}

	public double getRevenue_percent() {
		return revenue_percent;
	}

	public void setRevenue_percent(double revenue_percent) {
		this.revenue_percent = revenue_percent;
	}

	public int getLiability() {
		return liability;
	}

	public void setLiability(int liability) {
		this.liability = liability;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getNbrInstallments() {
		return nbrInstallments;
	}

	public void setNbrInstallments(Integer nbrInstallments) {
		this.nbrInstallments = nbrInstallments;
	}

	public String getInstallAutoPayment() {
		return installAutoPayment;
	}

	public void setInstallAutoPayment(String installAutoPayment) {
		this.installAutoPayment = installAutoPayment;
	}

	public String getMandateDate() {
		return mandateDate;
	}

	public void setMandateDate(String mandateDate) {
		this.mandateDate = mandateDate;
	}

	public String getDebitAccountRef() {
		return debitAccountRef;
	}

	public void setDebitAccountRef(String debitAccountRef) {
		this.debitAccountRef = debitAccountRef;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getSendNotice() {
		return sendNotice;
	}

	public void setSendNotice(String sendNotice) {
		this.sendNotice = sendNotice;
	}

	public String getCurrentYearSent() {
		return currentYearSent;
	}

	public void setCurrentYearSent(String currentYearSent) {
		this.currentYearSent = currentYearSent;
	}

	public String getYearEndSent() {
		return yearEndSent;
	}

	public void setYearEndSent(String yearEndSent) {
		this.yearEndSent = yearEndSent;
	}

	public Integer getInstallPaymentAccountSeq() {
		return installPaymentAccountSeq;
	}

	public void setInstallPaymentAccountSeq(Integer installPaymentAccountSeq) {
		this.installPaymentAccountSeq = installPaymentAccountSeq;
	}

	public String getPaymentStartDate() {
		return paymentStartDate;
	}

	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}

	public String getPaymentEndDate() {
		return paymentEndDate;
	}

	public void setPaymentEndDate(String paymentEndDate) {
		this.paymentEndDate = paymentEndDate;
	}

	public Integer getPullDay() {
		return pullDay;
	}

	public void setPullDay(Integer pullDay) {
		this.pullDay = pullDay;
	}

	public String getDdiAccepted() {
		return ddiAccepted;
	}

	public void setDdiAccepted(String ddiAccepted) {
		this.ddiAccepted = ddiAccepted;
	}

	public String getDdiLogged() {
		return ddiLogged;
	}

	public void setDdiLogged(String ddiLogged) {
		this.ddiLogged = ddiLogged;
	}

	public String getMostRecentPaymentDate() {
		return mostRecentPaymentDate;
	}

	public void setMostRecentPaymentDate(String mostRecentPaymentDate) {
		this.mostRecentPaymentDate = mostRecentPaymentDate;
	}

	public String getAuddisTransactionCode() {
		return auddisTransactionCode;
	}

	public void setAuddisTransactionCode(String auddisTransactionCode) {
		this.auddisTransactionCode = auddisTransactionCode;
	}

	public String getBacsTransactionCode() {
		return bacsTransactionCode;
	}

	public void setBacsTransactionCode(String bacsTransactionCode) {
		this.bacsTransactionCode = bacsTransactionCode;
	}

	public String getCancelDD() {
		return cancelDD;
	}

	public void setCancelDD(String cancelDD) {
		this.cancelDD = cancelDD;
	}

	public String getNextPaymentDate() {
		return nextPaymentDate;
	}

	public void setNextPaymentDate(String nextPaymentDate) {
		this.nextPaymentDate = nextPaymentDate;
	}

	public String getUnitDescription() {
		return unitDescription;
	}

	public void setUnitDescription(String unitDescription) {
		this.unitDescription = unitDescription;
	}

	public int getUnitUse() {
		return unitUse;
	}

	public void setUnitUse(int unitUse) {
		this.unitUse = unitUse;
	}

	public int getInstallmentIdNew() {
		return installmentIdNew;
	}

	public void setInstallmentIdNew(int installmentIdNew) {
		this.installmentIdNew = installmentIdNew;
	}

	public String getChargeNew() {
		return chargeNew;
	}

	public void setChargeNew(String chargeNew) {
		this.chargeNew = chargeNew;
	}

	public String getRemitNew() {
		return remitNew;
	}

	public void setRemitNew(String remitNew) {
		this.remitNew = remitNew;
	}

	public String getPercentNew() {
		return percentNew;
	}

	public void setPercentNew(String percentNew) {
		this.percentNew = percentNew;
	}

	public String getChargeRen() {
		return chargeRen;
	}

	public void setChargeRen(String chargeRen) {
		this.chargeRen = chargeRen;
	}

	public String getRemitRen() {
		return remitRen;
	}

	public void setRemitRen(String remitRen) {
		this.remitRen = remitRen;
	}

	public String getPercentRen() {
		return percentRen;
	}

	public void setPercentRen(String percentRen) {
		this.percentRen = percentRen;
	}

	public String getGenericPromotionCode() {
		return genericPromotionCode;
	}

	public void setGenericPromotionCode(String genericPromotionCode) {
		this.genericPromotionCode = genericPromotionCode;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnitTypeDescription() {
		return unitTypeDescription;
	}

	public void setUnitTypeDescription(String unitTypeDescription) {
		this.unitTypeDescription = unitTypeDescription;
	}

	public String getNew_commission() {
		return new_commission;
	}

	public void setNew_commission(String new_commission) {
		this.new_commission = new_commission;
	}

	public String getRen_commission() {
		return ren_commission;
	}

	public void setRen_commission(String ren_commission) {
		this.ren_commission = ren_commission;
	}

	public int getAudited() {
		return audited;
	}

	public void setAudited(int audited) {
		this.audited = audited;
	}

	public int getQP() {
		return QP;
	}

	public void setQP(int qP) {
		QP = qP;
	}

	public int getQF() {
		return QF;
	}

	public void setQF(int qF) {
		QF = qF;
	}

	public int getNQP() {
		return NQP;
	}

	public void setNQP(int nQP) {
		NQP = nQP;
	}

	public int getNQF() {
		return NQF;
	}

	public void setNQF(int nQF) {
		NQF = nQF;
	}

	public String getCustomerDistributionValues() {
		return customerDistributionValues;
	}

	public void setCustomerDistributionValues(String customerDistributionValues) {
		this.customerDistributionValues = customerDistributionValues;
	}

	
	public int getMinItem() {
		return minItem;
	}

	public void setMinItem(int minItem) {
		this.minItem = minItem;
	}

	public int getMaxItem() {
		return maxItem;
	}

	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}
	
	public String getPkgType() {
		return pkgType;
	}

	public void setPkgType(String pkgType) {
		this.pkgType = pkgType;
	}

	public String getRateClass() {
		return rateClass;
	}

	public void setRateClass(String rateClass) {
		this.rateClass = rateClass;
	}

	@Override
	public String toString() {
		return "OrderItem [orderhdrId=" + orderhdrId + ", orderItemSeq=" + orderItemSeq + ", deliveryMethod="
				+ deliveryMethod + ", deliverydisc=" + deliverydisc + ", distributionMethod=" + distributionMethod
				+ ", attribute=" + attribute + ", value=" + value + ", userCode=" + userCode + ", dateStamp="
				+ dateStamp + ", orderItemType=" + orderItemType + ", orderDate=" + orderDate + ", grossBaseAmount="
				+ grossBaseAmount + ", grossLocalAmount=" + grossLocalAmount + ", netBaseAmount=" + netBaseAmount
				+ ", netLocalAmount=" + netLocalAmount + ", baseAmount=" + baseAmount + ", localAmount=" + localAmount
				+ ", localCommission=" + localCommission + ", baseCommission=" + baseCommission + ", hasTax=" + hasTax
				+ ", hasDeliveryCharge=" + hasDeliveryCharge + ", billDate=" + billDate + ", paymentStatus="
				+ paymentStatus + ", refundStatus=" + refundStatus + ", orderType=" + orderType + ", hasPremium="
				+ hasPremium + ", prepaymentReq=" + prepaymentReq + ", productId=" + productId + ", isComplimentary="
				+ isComplimentary + ", subscripStartType=" + subscripStartType + ", duration=" + duration
				+ ", renewalStatus=" + renewalStatus + ", deliveryMethodPerm=" + deliveryMethodPerm + ", changeQtyFlag="
				+ changeQtyFlag + ", nRemainingPaidIssue=" + nRemainingPaidIssue + ", extIssleft=" + extIssleft
				+ ", extIssTot=" + extIssTot + ", orderStatus=" + orderStatus + ", renewalCategory=" + renewalCategory
				+ ", exchangeRate=" + exchangeRate + ", rateClassId=" + rateClassId + ", rateClassEffectiveSeq="
				+ rateClassEffectiveSeq + ", inventoryId=" + inventoryId + ", ocId=" + ocId + ", autoPayment="
				+ autoPayment + ", perpetualOrder=" + perpetualOrder + ", billToCustomerId=" + billToCustomerId
				+ ", billToCustomerAddressSeq=" + billToCustomerAddressSeq + ", renewToCustomerId=" + renewToCustomerId
				+ ", renewToCustomerAddressSeq=" + renewToCustomerAddressSeq + ", customerId=" + customerId
				+ ", customerAddressSeq=" + customerAddressSeq + ", altShipCustomerId=" + altShipCustomerId
				+ ", altShipCustomerAddressSeq=" + altShipCustomerAddressSeq + ", noteExist=" + noteExist
				+ ", serviceExist=" + serviceExist + ", mruOrderItemAmtBreakSeq=" + mruOrderItemAmtBreakSeq
				+ ", hasBeenRenewed=" + hasBeenRenewed + ", revenueMethod=" + revenueMethod + ", trialType=" + trialType
				+ ", origOrderQty=" + origOrderQty + ", unitExcess=" + unitExcess + ", isProforma=" + isProforma
				+ ", nTaxUpdates=" + nTaxUpdates + ", totalTaxLocalAmount=" + totalTaxLocalAmount
				+ ", totalTaxBaseAmount=" + totalTaxBaseAmount + ", electronicDelivery=" + electronicDelivery
				+ ", timeUnitOptions=" + timeUnitOptions + ", groupOrder=" + groupOrder + ", invoiceDate=" + invoiceDate
				+ ", autoRenewNotifySent=" + autoRenewNotifySent + ", extendedDays=" + extendedDays
				+ ", asynchronousAutoRenew=" + asynchronousAutoRenew + ", nDaysGraced=" + nDaysGraced
				+ ", isBackOrdered=" + isBackOrdered + ", mruGrpMbrItemDtlSeq=" + mruGrpMbrItemDtlSeq + ", orderCodeID="
				+ orderCodeID + ", sourceCodeID=" + sourceCodeID + ", orderCodeType=" + orderCodeType + ", orderClass="
				+ orderClass + ", orderCode=" + orderCode + ", sourceCode=" + sourceCode + ", orderCodeDescription="
				+ orderCodeDescription + ", sourceCodeDescription=" + sourceCodeDescription + ", bundleQty=" + bundleQty
				+ ", orderQty=" + orderQty + ", shipQty=" + shipQty + ", backordQty=" + backordQty + ", amountCharged="
				+ amountCharged + ", currency=" + currency + ", billingType=" + billingType + ", fullName=" + fullName
				+ ", address1=" + address1 + ", altFullNameTo=" + altFullNameTo + ", billToFullName=" + billToFullName
				+ ", altCustomerAddress=" + altCustomerAddress + ", billToCustomerAddress=" + billToCustomerAddress
				+ ", renewToCustomerAddress=" + renewToCustomerAddress + ", renewFullNameTo=" + renewFullNameTo
				+ ", altCustomerAddressList=" + altCustomerAddressList + ", billToCustomerAddressList="
				+ billToCustomerAddressList + ", product=" + product + ", productSize=" + productSize
				+ ", productStyle=" + productStyle + ", productColor=" + productColor + ", productTaxonomy="
				+ productTaxonomy + ", startIssueId=" + startIssueId + ", stopIssueId=" + stopIssueId + ", currIssueId="
				+ currIssueId + ", subscriptionDefId=" + subscriptionDefId + ", startDate=" + startDate
				+ ", expireDate=" + expireDate + ", nNonPaidIssues=" + nNonPaidIssues + ", nRemainingNonPaidIssues="
				+ nRemainingNonPaidIssues + ", subscriptionDef=" + subscriptionDef + ", subscriptionDefDescription="
				+ subscriptionDefDescription + ", termDescription=" + termDescription + ", subscriptionCategoryId="
				+ subscriptionCategoryId + ", subscriptionCategoryDescription=" + subscriptionCategoryDescription
				+ ", poNumber=" + poNumber + ", rateClassDescription=" + rateClassDescription
				+ ", rateClassEffectiveDate=" + rateClassEffectiveDate + ", order_status=" + order_status
				+ ", payment_status=" + payment_status + ", media=" + media + ", edition=" + edition + ", rotation="
				+ rotation + ", packageID=" + packageID + ", agencyCode=" + agencyCode + ", agencyName=" + agencyName
				+ ", agencyCustomerId=" + agencyCustomerId + ", agencyRefNbr=" + agencyRefNbr + ", invoiceNo="
				+ invoiceNo + ", orderCategory=" + orderCategory + ", taxRateAmount=" + taxRateAmount
				+ ", manualDiscAmtLocal=" + manualDiscAmtLocal + ", manualDiscAmtBase=" + manualDiscAmtBase
				+ ", manualDiscPercentage=" + manualDiscPercentage + ", docRefId=" + docRefId + ", nIssueLeft="
				+ nIssueLeft + ", subscripId=" + subscripId + ", packageContentSeq=" + packageContentSeq
				+ ", nInvEffort=" + nInvEffort + ", lastInvDate=" + lastInvDate + ", auditQualCategory="
				+ auditQualCategory + ", cancelReason=" + cancelReason + ", customerGroupId=" + customerGroupId
				+ ",auditSourceId=" +auditSourceId + ", auditSubscriptionTypeId=" + auditSubscriptionTypeId
				+ ", percentOfBasicPrice=" + percentOfBasicPrice + ", nRenEffort=" + nRenEffort + ", lastRenDate="
				+ lastRenDate + ", nDelIssLeft=" + nDelIssLeft + ", auditNameTitleId=" + auditNameTitleId
				+ ", auditSalesChannelId=" + auditSalesChannelId + ", qualDate=" + qualDate + ", squalDate=" + squalDate
				+ ", pubRotationId=" + pubRotationId + ", premToOrderItemSeq=" + premToOrderItemSeq
				+ ", renewalOrderhdrId=" + renewalOrderhdrId + ", renewalOrderItemSeq=" + renewalOrderItemSeq
				+ ", discountClassId=" + discountClassId + ", discClassEffectiveSeq=" + discClassEffectiveSeq
				+ ", discountCardSeq=" + discountCardSeq + ", installmentPlanId=" + installmentPlanId
				+ ", numberVolumeSets=" + numberVolumeSets + ", altShipDelCalc=" + altShipDelCalc + ", billingDef="
				+ billingDef + ", billingDefTestSeq=" + billingDefTestSeq + ", renewalDef=" + renewalDef
				+ ", renewalDefTestSeq=" + renewalDefTestSeq + ", agentRefNbr=" + agentRefNbr + ", mruSuspensionSeq="
				+ mruSuspensionSeq + ", mruOrderItemShipSeq=" + mruOrderItemShipSeq + ", mruBillingHistorySeq="
				+ mruBillingHistorySeq + ", mruOrderItemSglIssuesSeq=" + mruOrderItemSglIssuesSeq
				+ ", electronicDocumentIdentifier=" + electronicDocumentIdentifier + ", packageInstance="
				+ packageInstance + ", unitTypeId=" + unitTypeId + ", exRateClassId=" + exRateClassId
				+ ", exRateClassEffectiveSeq=" + exRateClassEffectiveSeq + ", exRatecardSeq=" + exRatecardSeq
				+ ", trialPeriod=" + trialPeriod + ", mruUnitHistorySeq=" + mruUnitHistorySeq + ", nNonpaidIssues="
				+ nNonpaidIssues + ", nRemainingNonpaidIssues=" + nRemainingNonpaidIssues + ", nCalUnitsPerSeg="
				+ nCalUnitsPerSeg + ", segmentExpireDate=" + segmentExpireDate + ", calendarUnit=" + calendarUnit
				+ ", nItemsPerSeg=" + nItemsPerSeg + ", nSegmentsLeft=" + nSegmentsLeft + ", rowVersion=" + rowVersion
				+ ", mruOrderItemNoteSeq=" + mruOrderItemNoteSeq + ", nTax_updates=" + nTax_updates
				+ ", renewedFromSubscripId=" + renewedFromSubscripId + ", pkgItemSeq=" + pkgItemSeq + ", pkgDefId="
				+ pkgDefId + ", pkgContentSeq=" + pkgContentSeq + ", itemUrl=" + itemUrl + ", paymentAccountSeq="
				+ paymentAccountSeq + ", maxCheckOutAmt=" + maxCheckOutAmt + ", nCheckedOut=" + nCheckedOut
				+ ", dealId=" + dealId + ", invoiceId=" + invoiceId + ", fulfillmentDate=" + fulfillmentDate
				+ ", multilineDiscountSchedule=" + multilineDiscountSchedule + ", multilineDiscAmount="
				+ multilineDiscAmount + ", multilineDiscEffSeq=" + multilineDiscEffSeq + ", shippingPriceList="
				+ shippingPriceList + ", extendedRate=" + extendedRate + ", attachExist=" + attachExist
				+ ", addonToOrderhdrId=" + addonToOrderhdrId + ", addonToOrderItemSeq=" + addonToOrderItemSeq
				+ ", genericPromotionCodeSeq=" + genericPromotionCodeSeq + ", chargeOnCancellation="
				+ chargeOnCancellation + ", lastTaxInvoiceDate=" + lastTaxInvoiceDate + ", documentReferenceId="
				+ documentReferenceId + ", expireYear=" + expireYear + ", pageName=" + pageName + ", startType="
				+ startType + ", enumeration=" + enumeration + ", revenue_percent=" + revenue_percent + ", liability="
				+ liability + ", productPrice=" + productPrice + ", nbrInstallments=" + nbrInstallments
				+ ", installAutoPayment=" + installAutoPayment + ", mandateDate=" + mandateDate + ", debitAccountRef="
				+ debitAccountRef + ", noticeDate=" + noticeDate + ", sendNotice=" + sendNotice + ", currentYearSent="
				+ currentYearSent + ", yearEndSent=" + yearEndSent + ", installPaymentAccountSeq="
				+ installPaymentAccountSeq + ", paymentStartDate=" + paymentStartDate + ", paymentEndDate="
				+ paymentEndDate + ", pullDay=" + pullDay + ", ddiAccepted=" + ddiAccepted + ", ddiLogged=" + ddiLogged
				+ ", mostRecentPaymentDate=" + mostRecentPaymentDate + ", auddisTransactionCode="
				+ auddisTransactionCode + ", bacsTransactionCode=" + bacsTransactionCode + ", cancelDD=" + cancelDD
				+ ", nextPaymentDate=" + nextPaymentDate + ", unitDescription=" + unitDescription + ", unitUse="
				+ unitUse + ", installmentIdNew=" + installmentIdNew + ", chargeNew=" + chargeNew + ", remitNew="
				+ remitNew + ", percentNew=" + percentNew + ", chargeRen=" + chargeRen + ", remitRen=" + remitRen
				+ ", percentRen=" + percentRen + ", genericPromotionCode=" + genericPromotionCode + ", unitType="
				+ unitType + ", unitTypeDescription=" + unitTypeDescription + ", new_commission=" + new_commission
				+ ", ren_commission=" + ren_commission + ", audited=" + audited + ", QP=" + QP + ", QF=" + QF + ", NQP="
				+ NQP + ", NQF=" + NQF + ", customerDistributionValues=" + customerDistributionValues+ ",cancelledOrderAmount=" + cancelledOrderAmount+ ",payment_type=" + payment_type+"]";
	}
}