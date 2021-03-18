package com.mps.think.setup.tablesetup.model;

public class TaxesModel {
	private int commodityCode;
	private String description;
	private String state;
	private int jurisdictionSeq;
	private String city;
	private String country;
	private int postalCode;
	private String jurisdiction;
	private String specialTaxId;
	private int exemptStatus;
	private String taxHandling;
	private int taxBasedOn;
	private int taxPoint;
	private int taxDelivery;
	private int conflictingTaxHandling;
	private int reciptPrintLocation;
	private String stateCode;
	private String taxIdPrefix;
	private String taxIdFormat;
	private String taxRateCategory;
	private String taxType;
	
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
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getTaxIdPrefix() {
		return taxIdPrefix;
	}
	public void setTaxIdPrefix(String taxIdPrefix) {
		this.taxIdPrefix = taxIdPrefix;
	}
	public String getTaxIdFormat() {
		return taxIdFormat;
	}
	public void setTaxIdFormat(String taxIdFormat) {
		this.taxIdFormat = taxIdFormat;
	}
	public String getTaxHandling() {
		return taxHandling;
	}
	public void setTaxHandling(String taxHandling) {
		this.taxHandling = taxHandling;
	}
	public int getTaxBasedOn() {
		return taxBasedOn;
	}
	public void setTaxBasedOn(int taxBasedOn) {
		this.taxBasedOn = taxBasedOn;
	}
	public int getTaxPoint() {
		return taxPoint;
	}
	public void setTaxPoint(int taxPoint) {
		this.taxPoint = taxPoint;
	}
	public int getTaxDelivery() {
		return taxDelivery;
	}
	public void setTaxDelivery(int taxDelivery) {
		this.taxDelivery = taxDelivery;
	}
	public int getConflictingTaxHandling() {
		return conflictingTaxHandling;
	}
	public void setConflictingTaxHandling(int conflictingTaxHandling) {
		this.conflictingTaxHandling = conflictingTaxHandling;
	}
	public int getReciptPrintLocation() {
		return reciptPrintLocation;
	}
	public void setReciptPrintLocation(int reciptPrintLocation) {
		this.reciptPrintLocation = reciptPrintLocation;
	}
	public String getSpecialTaxId() {
		return specialTaxId;
	}
	public void setSpecialTaxId(String specialTaxId) {
		this.specialTaxId = specialTaxId;
	}
	public int getExemptStatus() {
		return exemptStatus;
	}
	public void setExemptStatus(int exemptStatus) {
		this.exemptStatus = exemptStatus;
	}
	public int getCommodityCode() {
		return commodityCode;
	}
	public void setCommodityCode(int commodityCode) {
		this.commodityCode = commodityCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getJurisdictionSeq() {
		return jurisdictionSeq;
	}
	public void setJurisdictionSeq(int jurisdictionSeq) {
		this.jurisdictionSeq = jurisdictionSeq;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
}
