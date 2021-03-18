package com.mps.think.process.model;

public class RenewalEffortModel {
	private String renewal_def;
	private int renewalDefTestSeq;
	private int effortNumber;
	private int previousEffNumber;
	private int effortType;
	private int numberOfUnits;
	private String volumeGroupMonthDay;
	private String sendTo;
	private String attachmentCode;
	private String messageString;
	private String processMethod;
	private String report;
	private int pricingDate;
	private int suppressEmail;
	private int processId;
	

	public String getRenewal_def() {
		return renewal_def;
	}
	public void setRenewal_def(String renewal_def) {
		this.renewal_def = renewal_def;
	}
	public int getPreviousEffNumber() {
		return previousEffNumber;
	}
	public void setPreviousEffNumber(int previousEffNumber) {
		this.previousEffNumber = previousEffNumber;
	}
	public int getRenewalDefTestSeq() {
		return renewalDefTestSeq;
	}
	public void setRenewalDefTestSeq(int renewalDefTestSeq) {
		this.renewalDefTestSeq = renewalDefTestSeq;
	}
	public int getEffortNumber() {
		return effortNumber;
	}
	public void setEffortNumber(int effortNumber) {
		this.effortNumber = effortNumber;
	}
	public int getEffortType() {
		return effortType;
	}
	public void setEffortType(int i) {
		this.effortType = i;
	}
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	public String getVolumeGroupMonthDay() {
		return volumeGroupMonthDay;
	}
	public void setVolumeGroupMonthDay(String volumeGroupMonthDay) {
		this.volumeGroupMonthDay = volumeGroupMonthDay;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getAttachmentCode() {
		return attachmentCode;
	}
	public void setAttachmentCode(String attachmentCode) {
		this.attachmentCode = attachmentCode;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	public String getProcessMethod() {
		return processMethod;
	}
	public void setProcessMethod(String processMethod) {
		this.processMethod = processMethod;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public int getPricingDate() {
		return pricingDate;
	}
	public void setPricingDate(int pricingDate) {
		this.pricingDate = pricingDate;
	}
	public int getSuppressEmail() {
		return suppressEmail;
	}
	public void setSuppressEmail(int suppressEmail) {
		this.suppressEmail = suppressEmail;
	}
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
}