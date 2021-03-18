package com.mps.think.setup.model;

public class RateCardModel {
	private int rateClassId;
	private int rateClassEffectiveSeq;
	private int ratecardSeq;
	private int fromQty;
	private String regionList;
	private String region;
	private String currency;
	private int toQty;
	private float price;
	private float chargeNew;
	private float remitNew;
	private float percentNew;
	private float basic;
	private float chargeRen;
	private float remitRen;
	private float percentRen;
	private String  lookupCurrency;
	private String qtyDiscountSchedule;
	private int  baselineQty;
	private int unitType;
	
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
	public int getFromQty() {
		return fromQty;
	}
	public void setFromQty(int fromQty) {
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
	public int getToQty() {
		return toQty;
	}
	public void setToQty(int toQty) {
		this.toQty = toQty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getChargeNew() {
		return chargeNew;
	}
	public void setChargeNew(float chargeNew) {
		this.chargeNew = chargeNew;
	}
	public float getRemitNew() {
		return remitNew;
	}
	public void setRemitNew(float remitNew) {
		this.remitNew = remitNew;
	}
	public float getPercentNew() {
		return percentNew;
	}
	public void setPercentNew(float percentNew) {
		this.percentNew = percentNew;
	}
	public float getBasic() {
		return basic;
	}
	public void setBasic(float basic) {
		this.basic = basic;
	}
	public float getChargeRen() {
		return chargeRen;
	}
	public void setChargeRen(float chargeRen) {
		this.chargeRen = chargeRen;
	}
	public float getRemitRen() {
		return remitRen;
	}
	public void setRemitRen(float remitRen) {
		this.remitRen = remitRen;
	}
	public float getPercentRen() {
		return percentRen;
	}
	public void setPercentRen(float percentRen) {
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
	public int getBaselineQty() {
		return baselineQty;
	}
	public void setBaselineQty(int baselineQty) {
		this.baselineQty = baselineQty;
	}
	public int getUnitType() {
		return unitType;
	}
	public void setUnitType(int unitType) {
		this.unitType = unitType;
	}
	@Override
	public String toString() {
		return "RateCardClass [rateClassId=" + rateClassId + ", rateClassEffectiveSeq=" + rateClassEffectiveSeq
				+ ", ratecardSeq=" + ratecardSeq + ", fromQty=" + fromQty + ", regionList=" + regionList + ", region="
				+ region + ", currency=" + currency + ", toQty=" + toQty + ", price=" + price + ", chargeNew="
				+ chargeNew + ", remitNew=" + remitNew + ", percentNew=" + percentNew + ", basic=" + basic
				+ ", chargeRen=" + chargeRen + ", remitRen=" + remitRen + ", percentRen=" + percentRen
				+ ", lookupCurrency=" + lookupCurrency + ", qtyDiscountSchedule=" + qtyDiscountSchedule
				+ ", baselineQty=" + baselineQty + ", unitType=" + unitType + "]";
	}
    
	
	
}
