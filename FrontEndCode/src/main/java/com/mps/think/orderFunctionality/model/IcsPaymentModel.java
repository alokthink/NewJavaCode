package com.mps.think.orderFunctionality.model;

public class IcsPaymentModel {
	private String icsRefNum;
	private String transDate;  
	private long amount;
	private String authCode;      
	private String authReconcilistionID;     
	private int creditCardAddressSeq;      
	private int creditCardCustomerId;  
	private String creditReconcilistionID;   
	private String currency;  
	private int customerId; 
	private String fullRequest;  
	private String fullResponse;      
	private int icsBankDefId;     
	private String paymentReconcilistionID;      
	private int paymentSeq;   
	private String returnCodes;   
	private String transMessage;
	private String transName;
	private String transStatus;
	public String getIcsRefNum() {
		return icsRefNum;
	}
	public void setIcsRefNum(String icsRefNum) {
		this.icsRefNum = icsRefNum;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getAuthReconcilistionID() {
		return authReconcilistionID;
	}
	public void setAuthReconcilistionID(String authReconcilistionID) {
		this.authReconcilistionID = authReconcilistionID;
	}
	public int getCreditCardAddressSeq() {
		return creditCardAddressSeq;
	}
	public void setCreditCardAddressSeq(int creditCardAddressSeq) {
		this.creditCardAddressSeq = creditCardAddressSeq;
	}
	public int getCreditCardCustomerId() {
		return creditCardCustomerId;
	}
	public void setCreditCardCustomerId(int creditCardCustomerId) {
		this.creditCardCustomerId = creditCardCustomerId;
	}
	public String getCreditReconcilistionID() {
		return creditReconcilistionID;
	}
	public void setCreditReconcilistionID(String creditReconcilistionID) {
		this.creditReconcilistionID = creditReconcilistionID;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFullRequest() {
		return fullRequest;
	}
	public void setFullRequest(String fullRequest) {
		this.fullRequest = fullRequest;
	}
	public String getFullResponse() {
		return fullResponse;
	}
	public void setFullResponse(String fullResponse) {
		this.fullResponse = fullResponse;
	}
	public int getIcsBankDefId() {
		return icsBankDefId;
	}
	public void setIcsBankDefId(int icsBankDefId) {
		this.icsBankDefId = icsBankDefId;
	}
	public String getPaymentReconcilistionID() {
		return paymentReconcilistionID;
	}
	public void setPaymentReconcilistionID(String paymentReconcilistionID) {
		this.paymentReconcilistionID = paymentReconcilistionID;
	}
	public int getPaymentSeq() {
		return paymentSeq;
	}
	public void setPaymentSeq(int paymentSeq) {
		this.paymentSeq = paymentSeq;
	}
	public String getReturnCodes() {
		return returnCodes;
	}
	public void setReturnCodes(String returnCodes) {
		this.returnCodes = returnCodes;
	}
	public String getTransMessage() {
		return transMessage;
	}
	public void setTransMessage(String transMessage) {
		this.transMessage = transMessage;
	}
	public String getTransName() {
		return transName;
	}
	public void setTransName(String transName) {
		this.transName = transName;
	}
	public String getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
}
