package com.mps.think.model;

public class IssueModel {
	private long issueId;
	private int analyzed;
	private String auditBeginDate;
	private String auditEndDate;
	private int auditGalleyCreate;
	private int auditGalleyNthDone;
	private int auditGalleySorted;
	private String dropDate;
	private int enumIssueNbr;
	private int enumVolumeNbr;
	private String enumeration;
	private int frozen;
	private int generateRevenue;
	private int inventoryId;
	private String issueCloseDate;
	private String issueDate;
	private String issueUrl;
	private int ocId;
	private String rowVersion;
	private int subOutBitPos;
	private int updateOrders;
	private String userCode;
	private String volumeGroupId;
	private String volume;
	public long getIssueId() {
		return issueId;
	}
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}
	public int getAnalyzed() {
		return analyzed;
	}
	public void setAnalyzed(int analyzed) {
		this.analyzed = analyzed;
	}
	public String getAuditBeginDate() {
		return auditBeginDate;
	}
	public void setAuditBeginDate(String auditBeginDate) {
		this.auditBeginDate = auditBeginDate;
	}
	public String getAuditEndDate() {
		return auditEndDate;
	}
	public void setAuditEndDate(String auditEndDate) {
		this.auditEndDate = auditEndDate;
	}
	public int getAuditGalleyCreate() {
		return auditGalleyCreate;
	}
	public void setAuditGalleyCreate(int auditGalleyCreate) {
		this.auditGalleyCreate = auditGalleyCreate;
	}
	public int getAuditGalleyNthDone() {
		return auditGalleyNthDone;
	}
	public void setAuditGalleyNthDone(int auditGalleyNthDone) {
		this.auditGalleyNthDone = auditGalleyNthDone;
	}
	public int getAuditGalleySorted() {
		return auditGalleySorted;
	}
	public void setAuditGalleySorted(int auditGalleySorted) {
		this.auditGalleySorted = auditGalleySorted;
	}
	public String getDropDate() {
		return dropDate;
	}
	public void setDropDate(String dropDate) {
		this.dropDate = dropDate;
	}
	public int getEnumIssueNbr() {
		return enumIssueNbr;
	}
	public void setEnumIssueNbr(int enumIssueNbr) {
		this.enumIssueNbr = enumIssueNbr;
	}
	public int getEnumVolumeNbr() {
		return enumVolumeNbr;
	}
	public void setEnumVolumeNbr(int enumVolumeNbr) {
		this.enumVolumeNbr = enumVolumeNbr;
	}
	public String getEnumeration() {
		return enumeration;
	}
	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}
	public int getFrozen() {
		return frozen;
	}
	public void setFrozen(int frozen) {
		this.frozen = frozen;
	}
	public int getGenerateRevenue() {
		return generateRevenue;
	}
	public void setGenerateRevenue(int generateRevenue) {
		this.generateRevenue = generateRevenue;
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getIssueCloseDate() {
		return issueCloseDate;
	}
	public void setIssueCloseDate(String issueCloseDate) {
		this.issueCloseDate = issueCloseDate;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getIssueUrl() {
		return issueUrl;
	}
	public void setIssueUrl(String issueUrl) {
		this.issueUrl = issueUrl;
	}
	public int getOcId() {
		return ocId;
	}
	public void setOcId(int ocId) {
		this.ocId = ocId;
	}
	public String getRowVersion() {
		return rowVersion;
	}
	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
	}
	public int getSubOutBitPos() {
		return subOutBitPos;
	}
	public void setSubOutBitPos(int subOutBitPos) {
		this.subOutBitPos = subOutBitPos;
	}
	public int getUpdateOrders() {
		return updateOrders;
	}
	public void setUpdateOrders(int updateOrders) {
		this.updateOrders = updateOrders;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getVolumeGroupId() {
		return volumeGroupId;
	}
	public void setVolumeGroupId(String volumeGroupId) {
		this.volumeGroupId = volumeGroupId;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}	
	@Override
	public String toString() {
		return "IssueModel [issueId=" + issueId + ", analyzed=" + analyzed + ", auditBeginDate=" + auditBeginDate
				+ ", auditEndDate=" + auditEndDate + ", auditGalleyCreate=" + auditGalleyCreate
				+ ", auditGalleyNthDone=" + auditGalleyNthDone + ", auditGalleySorted=" + auditGalleySorted
				+ ", dropDate=" + dropDate + ", enumIssueNbr=" + enumIssueNbr + ", enumVolumeNbr=" + enumVolumeNbr
				+ ", enumeration=" + enumeration + ", frozen=" + frozen + ", generateRevenue=" + generateRevenue
				+ ", inventoryId=" + inventoryId + ", issueCloseDate=" + issueCloseDate + ", issueDate=" + issueDate
				+ ", issueUrl=" + issueUrl + ", ocId=" + ocId + ", rowVersion=" + rowVersion + ", subOutBitPos="
				+ subOutBitPos + ", updateOrders=" + updateOrders + ", userCode=" + userCode + ", volumeGroupId="
				+ volumeGroupId + ", volume ="+volume+"]";
	}
	
	
}
