package com.mps.think.model;

import java.util.List;

public class CurrencyType {
	
	private String currencyType;
	private  List<String> currencyTypeList;
	private String userCode;
	private String description;
	private float exchangeRate;
	private String defaultcurrency;
	private int nDecimalPlaces;
	private String changeDate;
	private String currencySymbol;
	private String htmlSymbol;
	private String rowVersion;
	private String iso4217NumCode;
	private int dateStamp;
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public List<String> getCurrencyTypeList() {
		return currencyTypeList;
	}
	public void setCurrencyTypeList(List<String> currencyTypeList) {
		this.currencyTypeList = currencyTypeList;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getDefaultcurrency() {
		return defaultcurrency;
	}
	public void setDefaultcurrency(String defaultcurrency) {
		this.defaultcurrency = defaultcurrency;
	}
	public int getnDecimalPlaces() {
		return nDecimalPlaces;
	}
	public void setnDecimalPlaces(int nDecimalPlaces) {
		this.nDecimalPlaces = nDecimalPlaces;
	}
	public String getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public String getHtmlSymbol() {
		return htmlSymbol;
	}
	public void setHtmlSymbol(String htmlSymbol) {
		this.htmlSymbol = htmlSymbol;
	}
	public String getRowVersion() {
		return rowVersion;
	}
	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
	}
	public String getIso4217NumCode() {
		return iso4217NumCode;
	}
	public void setIso4217NumCode(String iso4217NumCode) {
		this.iso4217NumCode = iso4217NumCode;
	}
	public int getDateStamp() {
		return dateStamp;
	}
	public void setDateStamp(int dateStamp) {
		this.dateStamp = dateStamp;
	}
	@Override
	public String toString() {
		return "CurrencyType [currencyType=" + currencyType + ", currencyTypeList=" + currencyTypeList + ", userCode="
				+ userCode + ", description=" + description + ", exchangeRate=" + exchangeRate + ", defaultcurrency="
				+ defaultcurrency + ", nDecimalPlaces=" + nDecimalPlaces + ", changeDate=" + changeDate
				+ ", currencySymbol=" + currencySymbol + ", htmlSymbol=" + htmlSymbol + ", rowVersion=" + rowVersion
				+ ", iso4217NumCode=" + iso4217NumCode + ", dateStamp=" + dateStamp + "]";
	}
	
	
	

}
