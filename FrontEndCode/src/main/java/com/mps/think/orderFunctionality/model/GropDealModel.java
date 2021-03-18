package com.mps.think.orderFunctionality.model;

public class GropDealModel {
	private int dealId;
	private String deal;
	private String description;
	private String dealType;
	private String dealStatus;
	private int customerId;
	private String startDate;
	private String endDate;
	private boolean dealOrdCustRequired;
	private String startEndDate;
	private int orderCodeId;
	private int sourceCodeId;
	private int dealOrderCodeType;
	private int gCustomerId;
	
	public int getgCustomerId() {
		return gCustomerId;
	}

	public void setgCustomerId(int gCustomerId) {
		this.gCustomerId = gCustomerId;
	}

	public GropDealModel() {
   System.out.println("inside group Model ");
	}
	
	public int getDealOrderCodeType() {
		return dealOrderCodeType;
	}
	public void setDealOrderCodeType(int dealOrderCodeType) {
		this.dealOrderCodeType = dealOrderCodeType;
	}
	public int getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(int orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
	public int getSourceCodeId() {
		return sourceCodeId;
	}
	public void setSourceCodeId(int sourceCodeId) {
		this.sourceCodeId = sourceCodeId;
	}
	public boolean isDealOrderCodeTypeId() {
		return dealOrderCodeTypeId;
	}
	public void setDealOrderCodeTypeId(boolean dealOrderCodeTypeId) {
		this.dealOrderCodeTypeId = dealOrderCodeTypeId;
	}
	private boolean dealOrderCodeTypeId;
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public String getDeal() {
		return deal;
	}
	public void setDeal(String deal) {
		this.deal = deal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public String getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public boolean isDealOrdCustRequired() {
		return dealOrdCustRequired;
	}

	public void setDealOrdCustRequired(boolean dealOrdCustRequired) {
		this.dealOrdCustRequired = dealOrdCustRequired;
	}

	public String getStartEndDate() {
		return startEndDate;
	}
	public String setStartEndDate(String startEndDate) {
		return this.startEndDate = startEndDate;
	}
	@Override
	public String toString() {
		return "GropDealModel [dealId=" + dealId + ", deal=" + deal + ", description=" + description + ", dealType="
				+ dealType + ", dealStatus=" + dealStatus + ", customerId=" + customerId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", dealOrdCustRequired=" + dealOrdCustRequired + ", startEndDate="
				+ startEndDate + "]";
	}


}
