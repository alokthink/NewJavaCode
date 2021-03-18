package com.mps.think.orderFunctionality.model;

public class BehavioralSuspension {
	private long customerId;
	private String fname;
	private String description;
	private String suspendedOrderStatus;
	private String orderStatus;
	private String suspensionStatus;
	private String userCode;
	private String startDate;
	private String expireDate;
	private String creationDate;
	private int active;
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuspendedOrderStatus() {
		return suspendedOrderStatus;
	}
	public void setSuspendedOrderStatus(String suspendedOrderStatus) {
		this.suspendedOrderStatus = suspendedOrderStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getSuspensionStatus() {
		return suspensionStatus;
	}
	public void setSuspensionStatus(String suspensionStatus) {
		this.suspensionStatus = suspensionStatus;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
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
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
}
