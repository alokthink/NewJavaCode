package com.mps.think.model;

public class OrderItemAccountModel {
	private String accntBreaktype;
	private String accntBreakTypeDisp;
	private double ar;
	private double cash;
	private double liability;
	private double revenue;
	private int orderhdrId;
	private int orderItemSeq;
	
	public String getAccntBreaktype() {
		return accntBreaktype;
	}
	public void setAccntBreaktype(String accntBreaktype) {
		this.accntBreaktype = accntBreaktype;
	}
	public String getAccntBreakTypeDisp() {
		return accntBreakTypeDisp;
	}
	public void setAccntBreakTypeDisp(String accntBreakTypeDisp) {
		this.accntBreakTypeDisp = accntBreakTypeDisp;
	}
	public double getAr() {
		return ar;
	}
	public void setAr(double ar) {
		this.ar = ar;
	}
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public double getLiability() {
		return liability;
	}
	public void setLiability(double liability) {
		this.liability = liability;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public int getOrderhdrId() {
		return orderhdrId;
	}
	public void setOrderhdrId(int orderhdrId) {
		this.orderhdrId = orderhdrId;
	}
	public int getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(int orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "OrderItemAccountModel [accntBreaktype=" + accntBreaktype + ", accntBreakTypeDisp=" + accntBreakTypeDisp
				+ ", ar=" + ar + ", cash=" + cash + ", liability=" + liability + ", revenue=" + revenue
				+ ", orderhdrId=" + orderhdrId + ", orderItemSeq=" + orderItemSeq + "]";
	}

}
