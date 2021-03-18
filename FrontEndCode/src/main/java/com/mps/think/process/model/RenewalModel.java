package com.mps.think.process.model;

public class RenewalModel {
	private String renewalDef;
	private String extract;
	private String renewalType;
	private String description;
	private int activeTesting;
	private int renewalDefSeq;
	private int processId;
	private int requal;
	
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	public String getRenewalDef() {
		return renewalDef;
	}
	public void setRenewalDef(String renewalDef) {
		this.renewalDef = renewalDef;
	}
	public String getExtract() {
		return extract;
	}
	public void setExtract(String extract) {
		this.extract = extract;
	}
	public String getRenewalType() {
		return renewalType;
	}
	public void setRenewalType(String renewalType) {
		this.renewalType = renewalType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getActiveTesting() {
		return activeTesting;
	}
	public void setActiveTesting(int activeTesting) {
		this.activeTesting = activeTesting;
	}
	public int getRenewalDefSeq() {
		return renewalDefSeq;
	}
	public void setRenewalDefSeq(int renewalDefSeq) {
		this.renewalDefSeq = renewalDefSeq;
	}
	public int getRequal() {
		return requal;
	}
	public void setRequal(int requal) {
		this.requal = requal;
	}

	
}
