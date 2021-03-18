package com.mps.think.model;

import java.math.BigDecimal;

public class CancelOrderDetailsModel {
	
	private int orderHdrId;
	private String orderCode;
	private int orderItemSeq;
	private String userCode;
	private String currency;
	private int sourceCodeId;
	private String orderCategory;
	private int orderItemType;
	private String orderDate;
	private int orderQty;
	private double grossBaseAmount;
	private double grossLocalAmount;
	private double netBaseAmount;
	private float netLocalAmount;
	private int subscripId;
	private int orderCodeId;
	private double paidAmt;
	private BigDecimal refAmt;
	private String refCurr;
	private String orderStatus;
	
	public int getOrderHdrId() {
		return orderHdrId;
	}
	public void setOrderHdrId(int orderHdrId) {
		this.orderHdrId = orderHdrId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(int orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getSourceCodeId() {
		return sourceCodeId;
	}
	public void setSourceCodeId(int sourceCodeId) {
		this.sourceCodeId = sourceCodeId;
	}
	public String getOrderCategory() {
		return orderCategory;
	}
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	public int getOrderItemType() {
		return orderItemType;
	}
	public void setOrderItemType(int orderItemType) {
		this.orderItemType = orderItemType;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public double getGrossBaseAmount() {
		return grossBaseAmount;
	}
	public void setGrossBaseAmount(double grossBaseAmount) {
		this.grossBaseAmount = grossBaseAmount;
	}
	public double getGrossLocalAmount() {
		return grossLocalAmount;
	}
	public void setGrossLocalAmount(double grossLocalAmount) {
		this.grossLocalAmount = grossLocalAmount;
	}
	public double getNetBaseAmount() {
		return netBaseAmount;
	}
	public void setNetBaseAmount(double netBaseAmount) {
		this.netBaseAmount = netBaseAmount;
	}
	public float getNetLocalAmount() {
		return netLocalAmount;
	}
	public void setNetLocalAmount(float netLocalAmount) {
		this.netLocalAmount = netLocalAmount;
	}
	public int getSubscripId() {
		return subscripId;
	}
	public void setSubscripId(int subscripId) {
		this.subscripId = subscripId;
	}
	public int getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(int orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
	public double getPaidAmt() {
		return paidAmt;
	}
	public void setPaidAmt(double payAmt) {
		this.paidAmt = payAmt;
	}
	public BigDecimal getRefAmt() {
		return refAmt;
	}
	public void setRefAmt(BigDecimal bigDecimal) {
		this.refAmt = bigDecimal;
	}
	public String getRefCurr() {
		return refCurr;
	}
	public void setRefCurr(String refCurr) {
		this.refCurr = refCurr;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	

}
