package com.mps.think.setup.model;

public class RateClassModel {
	
	//select rate_class_id,rate_class,oc_id,description,region_list,renewal_card_id,mru_rate_class_effective_seq,is_package from rate_class
	private int rateClassId;
	private String rateClass;
	private int ocId;
	private String description;
	private String regionList;
	private int renewalCardId;
	private int mruRateClassEffectiveSeq;
	private int isPackage;
	
	//rate_class_id,rate_class_effective_seq,description,effective_date,renewal_expire_effective_date,
	//default_price_per_issue,mru_ratecard_seq,cost_per_day,default_pkg_price from rate_class_effective
	private int rateClassEffectiveSeq;
	private String effectiveDate;
	private String  renewalExpireEffectiveDate;
	private float defaultPricePerIssue;
	private int mruRateCardSeq;
	private float costPerDay;
	private float defaultPkgPrice;
	
	//select rate_class_id,rate_class_effective_seq,ratecard_seq,from_qty,region_list,region,currency,to_qty,price,
	//charge_new,remit_new,percent_new,basic,charge_ren,remit_ren,percent_ren,
	//lookup_currency,qty_discount_schedule,baseline_qty,unit_type from ratecard
	private int rateCardSeq;
	private String region;
	private String currency;
	private int fromQty;
	private int toQty;
	private float price;
	private float chargeNew;
	private float remitNew;
	private float percentNew;
	private float basic;
	private float chargeRen;
	private float remitRen;
	private float percentRen;
	private String lookupCurrency;
	private String qtyDiscounSchedule;
	private int baselineQty;
	private short unitType;
	
	public int getRateClassId() {
		return rateClassId;
	}
	public void setRateClassId(int rateClassId) {
		this.rateClassId = rateClassId;
	}
	public String getRateClass() {
		return rateClass;
	}
	public void setRateClass(String rateClass) {
		this.rateClass = rateClass;
	}
	public int getOcId() {
		return ocId;
	}
	public void setOcId(int ocId) {
		this.ocId = ocId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegionList() {
		return regionList;
	}
	public void setRegionList(String regionList) {
		this.regionList = regionList;
	}
	public int getRenewalCardId() {
		return renewalCardId;
	}
	public void setRenewalCardId(int renewalCardId) {
		this.renewalCardId = renewalCardId;
	}
	public int getMruRateClassEffectiveSeq() {
		return mruRateClassEffectiveSeq;
	}
	public void setMruRateClassEffectiveSeq(int mruRateClassEffectiveSeq) {
		this.mruRateClassEffectiveSeq = mruRateClassEffectiveSeq;
	}
	public int getIsPackage() {
		return isPackage;
	}
	public void setIsPackage(int isPackage) {
		this.isPackage = isPackage;
	}
	public int getRateClassEffectiveSeq() {
		return rateClassEffectiveSeq;
	}
	public void setRateClassEffectiveSeq(int rateClassEffectiveSeq) {
		this.rateClassEffectiveSeq = rateClassEffectiveSeq;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getRenewalExpireEffectiveDate() {
		return renewalExpireEffectiveDate;
	}
	public void setRenewalExpireEffectiveDate(String renewalExpireEffectiveDate) {
		this.renewalExpireEffectiveDate = renewalExpireEffectiveDate;
	}
	public float getDefaultPricePerIssue() {
		return defaultPricePerIssue;
	}
	public void setDefaultPricePerIssue(float defaultPricePerIssue) {
		this.defaultPricePerIssue = defaultPricePerIssue;
	}
	public int getMruRateCardSeq() {
		return mruRateCardSeq;
	}
	public void setMruRateCardSeq(int mruRateCardSeq) {
		this.mruRateCardSeq = mruRateCardSeq;
	}
	public float getCostPerDay() {
		return costPerDay;
	}
	public void setCostPerDay(float costPerDay) {
		this.costPerDay = costPerDay;
	}
	public float getDefaultPkgPrice() {
		return defaultPkgPrice;
	}
	public void setDefaultPkgPrice(float defaultPkgPrice) {
		this.defaultPkgPrice = defaultPkgPrice;
	}
	public int getRateCardSeq() {
		return rateCardSeq;
	}
	public void setRateCardSeq(int rateCardSeq) {
		this.rateCardSeq = rateCardSeq;
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
	public String getQtyDiscounSchedule() {
		return qtyDiscounSchedule;
	}
	public void setQtyDiscounSchedule(String qtyDiscounSchedule) {
		this.qtyDiscounSchedule = qtyDiscounSchedule;
	}
	public int getBaselineQty() {
		return baselineQty;
	}
	public void setBaselineQty(int baselineQty) {
		this.baselineQty = baselineQty;
	}
	public short getUnitType() {
		return unitType;
	}
	public void setUnitType(short unitType) {
		this.unitType = unitType;
	}
	@Override
	public String toString() {
		return "RateClassModel [rateClassId=" + rateClassId + ", rateClass=" + rateClass + ", ocId=" + ocId
				+ ", description=" + description + ", regionList=" + regionList + ", renewalCardId=" + renewalCardId
				+ ", mruRateClassEffectiveSeq=" + mruRateClassEffectiveSeq + ", isPackage=" + isPackage
				+ ", rateClassEffectiveSeq=" + rateClassEffectiveSeq + ", effectiveDate=" + effectiveDate
				+ ", renewalExpireEffectiveDate=" + renewalExpireEffectiveDate + ", defaultPricePerIssue="
				+ defaultPricePerIssue + ", mruRateCardSeq=" + mruRateCardSeq + ", costPerDay=" + costPerDay
				+ ", defaultPkgPrice=" + defaultPkgPrice + ", rateCardSeq=" + rateCardSeq + ", region=" + region
				+ ", currency=" + currency + ", fromQty=" + fromQty + ", toQty=" + toQty + ", price=" + price
				+ ", chargeNew=" + chargeNew + ", remitNew=" + remitNew + ", percentNew=" + percentNew + ", basic="
				+ basic + ", chargeRen=" + chargeRen + ", remitRen=" + remitRen + ", percentRen=" + percentRen
				+ ", lookupCurrency=" + lookupCurrency + ", qtyDiscounSchedule=" + qtyDiscounSchedule + ", baselineQty="
				+ baselineQty + ", unitType=" + unitType + "]";
	}
	
}
