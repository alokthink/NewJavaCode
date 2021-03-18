package com.mps.think.model;

public class OrderItemAmtBreak {
	
	private long orderhdrId;	
	private String orderItemSeq;	
	private String orderItemAmtBreakSeq;	
	private String orderItemBreakType;	
	private String localAmount;	
	private String baseAmount;	
	private String jurisdictionSeq;	
	private String state;	
	private String taxType;	
	private String taxRateCategory;	
	private String rowVersion;	
	private String effectiveDate;	
	private String origBaseAmount;	
	private String taxRate;	
	private String taxDelivery;
	private String taxActive;	
	private String vrtxJurisdiction;	
	private String vrtxJurisdictionLevel;	
	private String vrtxTaxType;	
	private String txIncl;
	private String netLocalAmount;
	private String grossLocalAmount;
	private String netBaseAmount;
	private String grossBaseAmount;
	
	public String getNetLocalAmount() {
		return netLocalAmount;
	}
	public void setNetLocalAmount(String netLocalAmount) {
		this.netLocalAmount = netLocalAmount;
	}
	public String getGrossLocalAmount() {
		return grossLocalAmount;
	}
	public void setGrossLocalAmount(String grossLocalAmount) {
		this.grossLocalAmount = grossLocalAmount;
	}
	public String getNetBaseAmount() {
		return netBaseAmount;
	}
	public void setNetBaseAmount(String netBaseAmount) {
		this.netBaseAmount = netBaseAmount;
	}
	public String getGrossBaseAmount() {
		return grossBaseAmount;
	}
	public void setGrossBaseAmount(String grossBaseAmount) {
		this.grossBaseAmount = grossBaseAmount;
	}
	public long getOrderhdrId() {
		return orderhdrId;
	}
	public void setOrderhdrId(long orderhdrId) {
		this.orderhdrId = orderhdrId;
	}
	public String getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(String orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	public String getOrderItemAmtBreakSeq() {
		return orderItemAmtBreakSeq;
	}
	public void setOrderItemAmtBreakSeq(String orderItemAmtBreakSeq) {
		this.orderItemAmtBreakSeq = orderItemAmtBreakSeq;
	}
	public String getOrderItemBreakType() {
		return orderItemBreakType;
	}
	public void setOrderItemBreakType(String orderItemBreakType) {
		this.orderItemBreakType = orderItemBreakType;
	}
	public String getLocalAmount() {
		return localAmount;
	}
	public void setLocalAmount(String localAmount) {
		this.localAmount = localAmount;
	}
	public String getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(String baseAmount) {
		this.baseAmount = baseAmount;
	}
	public String getJurisdictionSeq() {
		return jurisdictionSeq;
	}
	public void setJurisdictionSeq(String jurisdictionSeq) {
		this.jurisdictionSeq = jurisdictionSeq;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTaxType() {
		return taxType;
	}
	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}
	public String getTaxRateCategory() {
		return taxRateCategory;
	}
	public void setTaxRateCategory(String taxRateCategory) {
		this.taxRateCategory = taxRateCategory;
	}
	public String getRowVersion() {
		return rowVersion;
	}
	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getOrigBaseAmount() {
		return origBaseAmount;
	}
	public void setOrigBaseAmount(String origBaseAmount) {
		this.origBaseAmount = origBaseAmount;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	public String getTaxDelivery() {
		return taxDelivery;
	}
	public void setTaxDelivery(String taxDelivery) {
		this.taxDelivery = taxDelivery;
	}
	public String getTaxActive() {
		return taxActive;
	}
	public void setTaxActive(String taxActive) {
		this.taxActive = taxActive;
	}
	public String getVrtxJurisdiction() {
		return vrtxJurisdiction;
	}
	public void setVrtxJurisdiction(String vrtxJurisdiction) {
		this.vrtxJurisdiction = vrtxJurisdiction;
	}
	public String getVrtxJurisdictionLevel() {
		return vrtxJurisdictionLevel;
	}
	public void setVrtxJurisdictionLevel(String vrtxJurisdictionLevel) {
		this.vrtxJurisdictionLevel = vrtxJurisdictionLevel;
	}
	public String getVrtxTaxType() {
		return vrtxTaxType;
	}
	public void setVrtxTaxType(String vrtxTaxType) {
		this.vrtxTaxType = vrtxTaxType;
	}
	public String getTxIncl() {
		return txIncl;
	}
	public void setTxIncl(String txIncl) {
		this.txIncl = txIncl;
	}
	@Override
	public String toString() {
		return "OrderItemAmtBreak [orderhdrId=" + orderhdrId + ", orderItemSeq=" + orderItemSeq
				+ ", orderItemAmtBreakSeq=" + orderItemAmtBreakSeq + ", orderItemBreakType=" + orderItemBreakType
				+ ", localAmount=" + localAmount + ", baseAmount=" + baseAmount + ", jurisdictionSeq=" + jurisdictionSeq
				+ ", state=" + state + ", taxType=" + taxType + ", taxRateCategory=" + taxRateCategory + ", rowVersion="
				+ rowVersion + ", effectiveDate=" + effectiveDate + ", origBaseAmount=" + origBaseAmount + ", taxRate="
				+ taxRate + ", taxDelivery=" + taxDelivery + ", taxActive=" + taxActive + ", vrtxJurisdiction="
				+ vrtxJurisdiction + ", vrtxJurisdictionLevel=" + vrtxJurisdictionLevel + ", vrtxTaxType=" + vrtxTaxType
				+ ", txIncl=" + txIncl + "]";
	}
	
	
	
	
}
