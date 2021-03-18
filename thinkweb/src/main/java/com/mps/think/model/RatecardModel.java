package com.mps.think.model;

public class RatecardModel {
	
	private int rateClassId;
	private int rateClassEffectiveSeq;
	private int ratecardSeq;
	private String fromQty;
	private String regionList;
	private String region;
	private String currency;
	private String toQty;
	private String price;
	private String chargeNew;
	private String remitNew;
	private String percentNew;
	private String basic;
	private String chargeRen;
	private String remitRen;
	private String percentRen;
	private String lookupCurrency;
	private String qtyDiscountSchedule;
	private String baselineQty;
	private String unitType;
	private String rowVersion;
	private String exchangeRate;
	
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	private String taxRate;
	
	public int getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(int rateClassId) {
		this.rateClassId = rateClassId;
	}
	public int getRateClassEffectiveSeq() {
		return rateClassEffectiveSeq;
	}
	public void setRateClassEffectiveSeq(int rateClassEffectiveSeq) {
		this.rateClassEffectiveSeq = rateClassEffectiveSeq;
	}
	public int getRatecardSeq() {
		return ratecardSeq;
	}
	public void setRatecardSeq(int ratecardSeq) {
		this.ratecardSeq = ratecardSeq;
	}
	public String getFromQty() {
		return fromQty;
	}
	public void setFromQty(String fromQty) {
		this.fromQty = fromQty;
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
	public String getToQty() {
		return toQty;
	}
	public void setToQty(String toQty) {
		this.toQty = toQty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getChargeNew() {
		return chargeNew;
	}
	public void setChargeNew(String chargeNew) {
		this.chargeNew = chargeNew;
	}
	public String getRemitNew() {
		return remitNew;
	}
	public void setRemitNew(String remitNew) {
		this.remitNew = remitNew;
	}
	public String getPercentNew() {
		return percentNew;
	}
	public void setPercentNew(String percentNew) {
		this.percentNew = percentNew;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getChargeRen() {
		return chargeRen;
	}
	public void setChargeRen(String chargeRen) {
		this.chargeRen = chargeRen;
	}
	public String getRemitRen() {
		return remitRen;
	}
	public void setRemitRen(String remitRen) {
		this.remitRen = remitRen;
	}
	public String getPercentRen() {
		return percentRen;
	}
	public void setPercentRen(String percentRen) {
		this.percentRen = percentRen;
	}
	public String getLookupCurrency() {
		return lookupCurrency;
	}
	public void setLookupCurrency(String lookupCurrency) {
		this.lookupCurrency = lookupCurrency;
	}
	public String getQtyDiscountSchedule() {
		return qtyDiscountSchedule;
	}
	public void setQtyDiscountSchedule(String qtyDiscountSchedule) {
		this.qtyDiscountSchedule = qtyDiscountSchedule;
	}
	public String getBaselineQty() {
		return baselineQty;
	}
	public void setBaselineQty(String baselineQty) {
		this.baselineQty = baselineQty;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getRowVersion() {
		return rowVersion;
	}
	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
	}	
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}
	@Override
	public String toString() {
		return "RatecardModel [rateClassId=" + rateClassId + ", rateClassEffectiveSeq=" + rateClassEffectiveSeq
				+ ", ratecardSeq=" + ratecardSeq + ", fromQty=" + fromQty + ", regionList=" + regionList + ", region="
				+ region + ", currency=" + currency + ", toQty=" + toQty + ", price=" + price + ", chargeNew="
				+ chargeNew + ", remitNew=" + remitNew + ", percentNew=" + percentNew + ", basic=" + basic
				+ ", chargeRen=" + chargeRen + ", remitRen=" + remitRen + ", percentRen=" + percentRen
				+ ", lookupCurrency=" + lookupCurrency + ", qtyDiscountSchedule=" + qtyDiscountSchedule
				+ ", baselineQty=" + baselineQty + ", unitType=" + unitType + ", rowVersion=" + rowVersion
				+ ", taxRate=" + taxRate + ", exchangeRate=" + exchangeRate + "]";
	}
 
	
}
