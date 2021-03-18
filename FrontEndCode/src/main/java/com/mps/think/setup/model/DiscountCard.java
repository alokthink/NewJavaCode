package com.mps.think.setup.model;

import java.math.BigDecimal;

public class DiscountCard {

	private int discountId;
	private int discClassEffectiveSeq;
	private int discountCardSeq;
	private String regionList;
	private String region;
	private String currency;
	private int fromQty;
	private int toQty;
	private BigDecimal discountPercent;
	private String customerCategory;
	private short unitType;
	private BigDecimal discountAmount;
	private String lookupCurrency;
	private BigDecimal fromAmount;
	private BigDecimal toAmount;
	
	public int getDiscountClassId() {
		return discountId;
	}
	public void setDiscountClassId(int discountId) {
		this.discountId = discountId;
	}
	public int getDiscClassEffectiveSeq() {
		return discClassEffectiveSeq;
	}
	public void setDiscClassEffectiveSeq(int discClassEffectiveSeq) {
		this.discClassEffectiveSeq = discClassEffectiveSeq;
	}
	public int getDiscountCardSeq() {
		return discountCardSeq;
	}
	public void setDiscountCardSeq(int discountCardSeq) {
		this.discountCardSeq = discountCardSeq;
	}
	public String getRegionList() {
		return regionList;
	}
	public void setRegionList(String regionList) {
		this.regionList = regionList;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getFromQty() {
		return fromQty;
	}
	public void setFromQty(int fromQty) {
		this.fromQty = fromQty;
	}
	public int getToQty() {
		return toQty;
	}
	public void setToQty(int toQty) {
		this.toQty = toQty;
	}
	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	public short getUnitType() {
		return unitType;
	}
	public void setUnitType(short unitType) {
		this.unitType = unitType;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getLookupCurrency() {
		return lookupCurrency;
	}
	public void setLookupCurrency(String lookupCurrency) {
		this.lookupCurrency = lookupCurrency;
	}
	public BigDecimal getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(BigDecimal fromAmount) {
		this.fromAmount = fromAmount;
	}
	public BigDecimal getToAmount() {
		return toAmount;
	}
	public void setToAmount(BigDecimal toAmount) {
		this.toAmount = toAmount;
	}
}
