package com.mps.think.model;

public class TransactionStatus {
	
	private String statusKey;
	private String statusValue;
	public String getStatusKey() {
		return statusKey;
	}
	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}
	public String getStatusValue() {
		return statusValue;
	}
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}
	@Override
	public String toString() {
		return "TransactionStatus [statusKey=" + statusKey + ", statusValue=" + statusValue + "]";
	}
	
	
	
	

}
