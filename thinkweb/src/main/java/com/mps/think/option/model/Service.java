package com.mps.think.option.model;

public class Service {
	//service table
	private Integer customerId;
	private Integer customerId2;
	private Integer serviceSeq;
	private Integer serviceSeq2;
	private String userCode;
	private String complaintCode;
	private String causeCode;
	private String serviceCode;
	private Integer orderhdrId;
	private Integer orderItemSeq;
	private String complaintDate;
	private String serviceDate;
	private String folloupDate;
	private String serviceStatus;
	private Integer subscripId;
	private String claimRefNbr;
	private Integer mruServiceNoteSeq;
	
	//service_note table
	private Integer serviceNoteSeq;
	private String creationDate;
	private String noteField;
	
	public Integer getCustomerId2() {
		return customerId2;
	}
	public void setCustomerId2(Integer customerId2) {
		this.customerId2 = customerId2;
	}
	public Integer getServiceSeq2() {
		return serviceSeq2;
	}
	public void setServiceSeq2(Integer serviceSeq2) {
		this.serviceSeq2 = serviceSeq2;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getServiceSeq() {
		return serviceSeq;
	}
	public void setServiceSeq(Integer serviceSeq) {
		this.serviceSeq = serviceSeq;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getComplaintCode() {
		return complaintCode;
	}
	public void setComplaintCode(String complaintCode) {
		this.complaintCode = complaintCode;
	}
	public String getCauseCode() {
		return causeCode;
	}
	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public Integer getOrderhdrId() {
		return orderhdrId;
	}
	public void setOrderhdrId(Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}
	public Integer getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(Integer orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	public String getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}
	public String getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getFolloupDate() {
		return folloupDate;
	}
	public void setFolloupDate(String folloupDate) {
		this.folloupDate = folloupDate;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public Integer getSubscripId() {
		return subscripId;
	}
	public void setSubscripId(Integer subscripId) {
		this.subscripId = subscripId;
	}
	public String getClaimRefNbr() {
		return claimRefNbr;
	}
	public void setClaimRefNbr(String claimRefNbr) {
		this.claimRefNbr = claimRefNbr;
	}
	public Integer getMruServiceNoteSeq() {
		return mruServiceNoteSeq;
	}
	public void setMruServiceNoteSeq(Integer mruServiceNoteSeq) {
		this.mruServiceNoteSeq = mruServiceNoteSeq;
	}
	public Integer getServiceNoteSeq() {
		return serviceNoteSeq;
	}
	public void setServiceNoteSeq(Integer serviceNoteSeq) {
		this.serviceNoteSeq = serviceNoteSeq;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getNoteField() {
		return noteField;
	}
	public void setNoteField(String noteField) {
		this.noteField = noteField;
	}
	@Override
	public String toString() {
		return "Service [customerId=" + customerId + ", serviceSeq=" + serviceSeq + ", userCode=" + userCode
				+ ", complaintCode=" + complaintCode + ", causeCode=" + causeCode + ", serviceCode=" + serviceCode
				+ ", orderhdrId=" + orderhdrId + ", orderItemSeq=" + orderItemSeq + ", complaintDate=" + complaintDate
				+ ", serviceDate=" + serviceDate + ", folloupDate=" + folloupDate + ", serviceStatus=" + serviceStatus
				+ ", subscripId=" + subscripId + ", claimRefNbr=" + claimRefNbr + ", mruServiceNoteSeq="
				+ mruServiceNoteSeq + ", serviceNoteSeq=" + serviceNoteSeq + ", creationDate=" + creationDate
				+ ", noteField=" + noteField + "]";
	}
	
}
