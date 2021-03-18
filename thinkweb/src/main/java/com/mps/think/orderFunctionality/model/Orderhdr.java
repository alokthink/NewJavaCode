package com.mps.think.orderFunctionality.model;

public class Orderhdr {
	private Integer orderhdrId; 
	private Integer mruOrderItemSeq;       
	private String orderDate;
	private String poNumber;
	public Integer getOrderhdrId() {
		return orderhdrId;
	}
	public void setOrderhdrId(Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}
	public Integer getMruOrderItemSeq() {
		return mruOrderItemSeq;
	}
	public void setMruOrderItemSeq(Integer mruOrderItemSeq) {
		this.mruOrderItemSeq = mruOrderItemSeq;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	 

}
