package com.mps.think.process.model;

public class SubmitJobModel {
	private int suppressOutput;
	private int suppressEmail;
	private String renewalDef;
	private int renewalDefTestSeq;
	private int effortNumber;
	private int jobId;
	private int renewalType;
	private int effortType;
	private int numberOfUnits;
	private String volumeGroupMonthDay;
	private int processId;
	private String billingDef;
	private int billingDefTestSeq;
	private int action;
	private int interval;
	private int sendBill;
	
	
	public int getSuppressOutput() {
		return suppressOutput;
	}
	public void setSuppressOutput(int suppressOutput) {
		this.suppressOutput = suppressOutput;
	}
	public int getSuppressEmail() {
		return suppressEmail;
	}
	public void setSuppressEmail(int suppressEmail) {
		this.suppressEmail = suppressEmail;
	}
	public String getRenewalDef() {
		return renewalDef;
	}
	public void setRenewalDef(String renewalDef) {
		this.renewalDef = renewalDef;
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
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getRenewalType() {
		return renewalType;
	}
	public void setRenewalType(int renewalType) {
		this.renewalType = renewalType;
	}
	public int getEffortType() {
		return effortType;
	}
	public void setEffortType(int effortType) {
		this.effortType = effortType;
	}
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
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
	
	public String getBillingDef() {
		return billingDef;
	}
	public void setBillingDef(String billingDef) {
		this.billingDef = billingDef;
	}
	public int getBillingDefTestSeq() {
		return billingDefTestSeq;
	}
	public void setBillingDefTestSeq(int billingDefTestSeq) {
		this.billingDefTestSeq = billingDefTestSeq;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getSendBill() {
		return sendBill;
	}
	public void setSendBill(int sendBill) {
		this.sendBill = sendBill;
	}
	@Override
	public String toString() {
		return "SubmitJobModel [suppressOutput=" + suppressOutput + ", suppressEmail=" + suppressEmail + ", renewalDef="
				+ renewalDef + ", renewalDefTestSeq=" + renewalDefTestSeq + ", effortNumber=" + effortNumber
				+ ", jobId=" + jobId + ", renewalType=" + renewalType + ", effortType=" + effortType
				+ ", numberOfUnits=" + numberOfUnits + ", volumeGroupMonthDay=" + volumeGroupMonthDay + ", processId="
				+ processId + ", billingDef=" + billingDef + ", billingDefTestSeq=" + billingDefTestSeq + ", action="
				+ action + ", interval=" + interval + ", sendBill=" + sendBill + "]";
	}
}
