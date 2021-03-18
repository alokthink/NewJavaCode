package com.mps.think.model;

public class SubscriptModel {
	private int subscripId;
	private int ocId;
	private int orderCodeId;
	private long customerId;
	private int sourceCode;
	private String origOrderDate;
	private String cancelDate;
	private String subOut;
	private String title;
	private String lastDemogUpdateDate;
	private String lastReaderServiceDate;
	private int nReaderServiceInq;
	private String cancelReason;
	private String auditNameChange;
	private String auditTitleChange;
	private String nTimesSubRenewed;
	private String backlabels;
	private int nTotalIssuesLeft;
	private int startIssueId;
	private int stopIssueId;
	private int mruAdditionsDeletionsSeq;
	private int mruRenewalHistorySeq;
	private String rowVersion;
	private String mruSubscripNoteSeq;
	private String isPkg;
	private String orderCodeType;
	private int issueId;

	public int getSubscripId() {
		return subscripId;
	}

	public void setSubscripId(int subscripId) {
		this.subscripId = subscripId;
	}

	public int getOcId() {
		return ocId;
	}

	public void setOcId(int ocId) {
		this.ocId = ocId;
	}

	public int getOrderCodeId() {
		return orderCodeId;
	}

	public void setOrderCodeId(int orderCodeId) {
		this.orderCodeId = orderCodeId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public int getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(int sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getOrigOrderDate() {
		return origOrderDate;
	}

	public void setOrigOrderDate(String origOrderDate) {
		this.origOrderDate = origOrderDate;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getSubOut() {
		return subOut;
	}

	public void setSubOut(String subOut) {
		this.subOut = subOut;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLastDemogUpdateDate() {
		return lastDemogUpdateDate;
	}

	public void setLastDemogUpdateDate(String lastDemogUpdateDate) {
		this.lastDemogUpdateDate = lastDemogUpdateDate;
	}

	public String getLastReaderServiceDate() {
		return lastReaderServiceDate;
	}

	public void setLastReaderServiceDate(String lastReaderServiceDate) {
		this.lastReaderServiceDate = lastReaderServiceDate;
	}

	public int getnReaderServiceInq() {
		return nReaderServiceInq;
	}

	public void setnReaderServiceInq(int nReaderServiceInq) {
		this.nReaderServiceInq = nReaderServiceInq;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getAuditNameChange() {
		return auditNameChange;
	}

	public void setAuditNameChange(String auditNameChange) {
		this.auditNameChange = auditNameChange;
	}

	public String getAuditTitleChange() {
		return auditTitleChange;
	}

	public void setAuditTitleChange(String auditTitleChange) {
		this.auditTitleChange = auditTitleChange;
	}

	public String getnTimesSubRenewed() {
		return nTimesSubRenewed;
	}

	public void setnTimesSubRenewed(String nTimesSubRenewed) {
		this.nTimesSubRenewed = nTimesSubRenewed;
	}

	public String getBacklabels() {
		return backlabels;
	}

	public void setBacklabels(String backlabels) {
		this.backlabels = backlabels;
	}

	public int getnTotalIssuesLeft() {
		return nTotalIssuesLeft;
	}

	public void setnTotalIssuesLeft(int nTotalIssuesLeft) {
		this.nTotalIssuesLeft = nTotalIssuesLeft;
	}

	public int getStartIssueId() {
		return startIssueId;
	}

	public void setStartIssueId(int startIssueId) {
		this.startIssueId = startIssueId;
	}

	public int getStopIssueId() {
		return stopIssueId;
	}

	public void setStopIssueId(int stopIssueId) {
		this.stopIssueId = stopIssueId;
	}

	public int getMruAdditionsDeletionsSeq() {
		return mruAdditionsDeletionsSeq;
	}

	public void setMruAdditionsDeletionsSeq(int mruAdditionsDeletionsSeq) {
		this.mruAdditionsDeletionsSeq = mruAdditionsDeletionsSeq;
	}

	public int getMruRenewalHistorySeq() {
		return mruRenewalHistorySeq;
	}

	public void setMruRenewalHistorySeq(int mruRenewalHistorySeq) {
		this.mruRenewalHistorySeq = mruRenewalHistorySeq;
	}

	public String getRowVersion() {
		return rowVersion;
	}

	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
	}

	public String getMruSubscripNoteSeq() {
		return mruSubscripNoteSeq;
	}

	public void setMruSubscripNoteSeq(String mruSubscripNoteSeq) {
		this.mruSubscripNoteSeq = mruSubscripNoteSeq;
	}

	public String getIsPkg() {
		return isPkg;
	}

	public void setIsPkg(String isPkg) {
		this.isPkg = isPkg;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getOrderCodeType() {
		return orderCodeType;
	}

	public void setOrderCodeType(String orderCodeType) {
		this.orderCodeType = orderCodeType;
	}

	@Override
	public String toString() {
		return "SubscriptModel [subscripId=" + subscripId + ", ocId=" + ocId + ", orderCodeId=" + orderCodeId
				+ ", customerId=" + customerId + ", sourceCode=" + sourceCode + ", origOrderDate=" + origOrderDate
				+ ", cancelDate=" + cancelDate + ", subOut=" + subOut + ", title=" + title + ", lastDemogUpdateDate="
				+ lastDemogUpdateDate + ", lastReaderServiceDate=" + lastReaderServiceDate + ", nReaderServiceInq="
				+ nReaderServiceInq + ", cancelReason=" + cancelReason + ", auditNameChange=" + auditNameChange
				+ ", auditTitleChange=" + auditTitleChange + ", nTimesSubRenewed=" + nTimesSubRenewed + ", backlabels="
				+ backlabels + ", nTotalIssuesLeft=" + nTotalIssuesLeft + ", startIssueId=" + startIssueId
				+ ", stopIssueId=" + stopIssueId + ", mruAdditionsDeletionsSeq=" + mruAdditionsDeletionsSeq
				+ ", mruRenewalHistorySeq=" + mruRenewalHistorySeq + ", rowVersion=" + rowVersion
				+ ", mruSubscripNoteSeq=" + mruSubscripNoteSeq + ", isPkg=" + isPkg + ", orderCodeType=" + orderCodeType
				+ ", issueId=" + issueId + "]";
	}
	
		
}
