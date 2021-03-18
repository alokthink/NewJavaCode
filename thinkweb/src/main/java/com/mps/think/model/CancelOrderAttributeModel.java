package com.mps.think.model;

import java.util.ArrayList;
import java.util.List;

public class CancelOrderAttributeModel 
{
	private String orderHdrId;
	private int orderItemSeq;
	private List<Object> cancelOrderList = new ArrayList<>();
	private List<DropdownModel> CategoryList = new ArrayList<>();
	private List<DropdownModel> ReasonList = new ArrayList<>();
	private List<DropdownModel> PaymentTypeList = new ArrayList<>();
	private List<DropdownModel> CurrencyTypeList = new ArrayList<>();
	private List<DropdownModel> CancellationRenewalStatusList = new ArrayList<>();
	private String cancelType;
	private String reason;
	private String refundAmount;
	private String currency;
	private String customerId;
	private String customerName;
	private int payAccount;
	private String creditCard;
	private String expireDate;
	private String nameOnCard;
	private String usePaymentAccount;
	private String paymentType;
	//For THINKDEV-611
	private String paymentTypeToCancelOrder;
	private String category;
	private String refundDepositeAccount;
	private String cancellationRenewalStatus;
	private String applySubscriptionChain;
	private List<CancelOrderDetailsModel> orderDetail;
	private List<DropdownModel> PaymentAccountList;
	private boolean paymentStatus;
	private String userCode;
	private int documentReferenceId;
	private boolean paymentAccountFlag;
	private String selectedOrder;
	private int noOfSubscripId;
	//Added by Sohrab for Return APIs
	private int shipQty;
	private int returnQty;
	private int type_of_return;
	private String cancel_orders_in_entire_sub;
	private String payment_done_flags;
	private String renew_anyway;
	private String transaction_reason;
	
	
	
	public String getPaymentTypeToCancelOrder() {
		return paymentTypeToCancelOrder;
	}
	public void setPaymentTypeToCancelOrder(String paymentTypeToCancelOrder) {
		this.paymentTypeToCancelOrder = paymentTypeToCancelOrder;
	}
	public String getTransaction_reason() {
		return transaction_reason;
	}
	public void setTransaction_reason(String transaction_reason) {
		this.transaction_reason = transaction_reason;
	}
	public String getOrderHdrId() {
		return orderHdrId;
	}
	public void setOrderHdrId(String orderHdrId) {
		this.orderHdrId = orderHdrId;
	}
	public int getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(int orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	public List<Object> getCancelOrderList() {
		return cancelOrderList;
	}
	public void setCancelOrderList(List<Object> cancelOrderList) {
		this.cancelOrderList = cancelOrderList;
	}
	public List<DropdownModel> getCategoryList() {
		return CategoryList;
	}
	public void setCategoryList(List<DropdownModel> categoryList) {
		CategoryList = categoryList;
	}
	public List<DropdownModel> getReasonList() {
		return ReasonList;
	}
	public void setReasonList(List<DropdownModel> reasonList) {
		ReasonList = reasonList;
	}
	public List<DropdownModel> getPaymentTypeList() {
		return PaymentTypeList;
	}
	public void setPaymentTypeList(List<DropdownModel> paymentTypeList) {
		PaymentTypeList = paymentTypeList;
	}
	public List<DropdownModel> getCurrencyTypeList() {
		return CurrencyTypeList;
	}
	public void setCurrencyTypeList(List<DropdownModel> currencyTypeList) {
		CurrencyTypeList = currencyTypeList;
	}
	public List<DropdownModel> getCancellationRenewalStatusList() {
		return CancellationRenewalStatusList;
	}
	public void setCancellationRenewalStatusList(List<DropdownModel> cancellationRenewalStatusList) {
		CancellationRenewalStatusList = cancellationRenewalStatusList;
	}
	public String getCancelType() {
		return cancelType;
	}
	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getPayAccount() {
		return payAccount;
	}
	public void setPayAccount(int payAccount) {
		this.payAccount = payAccount;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getUsePaymentAccount() {
		return usePaymentAccount;
	}
	public void setUsePaymentAccount(String usePaymentAccount) {
		this.usePaymentAccount = usePaymentAccount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRefundDepositeAccount() {
		return refundDepositeAccount;
	}
	public void setRefundDepositeAccount(String refundDepositeAccount) {
		this.refundDepositeAccount = refundDepositeAccount;
	}
	public String getCancellationRenewalStatus() {
		return cancellationRenewalStatus;
	}
	public void setCancellationRenewalStatus(String cancellationRenewalStatus) {
		this.cancellationRenewalStatus = cancellationRenewalStatus;
	}
	public String getApplySubscriptionChain() {
		return applySubscriptionChain;
	}
	public void setApplySubscriptionChain(String applySubscriptionChain) {
		this.applySubscriptionChain = applySubscriptionChain;
	}
	public List<CancelOrderDetailsModel> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<CancelOrderDetailsModel> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public List<DropdownModel> getPaymentAccountList() {
		return PaymentAccountList;
	}
	public void setPaymentAccountList(List<DropdownModel> paymentAccountList) {
		PaymentAccountList = paymentAccountList;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public int getDocumentReferenceId() {
		return documentReferenceId;
	}
	public void setDocumentReferenceId(int documentReferenceId) {
		this.documentReferenceId = documentReferenceId;
	}
	public boolean isPaymentAccountFlag() {
		return paymentAccountFlag;
	}
	public void setPaymentAccountFlag(boolean paymentAccountFlag) {
		this.paymentAccountFlag = paymentAccountFlag;
	}
	public String getSelectedOrder() {
		return selectedOrder;
	}
	public void setSelectedOrder(String selectedOrder) {
		this.selectedOrder = selectedOrder;
	}
	public int getNoOfSubscripId() {
		return noOfSubscripId;
	}
	public void setNoOfSubscripId(int noOfSubscripId) {
		this.noOfSubscripId = noOfSubscripId;
	}
	public int getShipQty() {
		return shipQty;
	}
	public void setShipQty(int shipQty) {
		this.shipQty = shipQty;
	}
	public int getReturnQty() {
		return returnQty;
	}
	public void setReturnQty(int returnQty) {
		this.returnQty = returnQty;
	}
	public int getType_of_return() {
		return type_of_return;
	}
	public void setType_of_return(int type_of_return) {
		this.type_of_return = type_of_return;
	}
	public String getCancel_orders_in_entire_sub() {
		return cancel_orders_in_entire_sub;
	}
	public void setCancel_orders_in_entire_sub(String cancel_orders_in_entire_sub) {
		this.cancel_orders_in_entire_sub = cancel_orders_in_entire_sub;
	}
	public String getPayment_done_flags() {
		return payment_done_flags;
	}
	public void setPayment_done_flags(String payment_done_flags) {
		this.payment_done_flags = payment_done_flags;
	}
	public String getRenew_anyway() {
		return renew_anyway;
	}
	public void setRenew_anyway(String renew_anyway) {
		this.renew_anyway = renew_anyway;
	}
}