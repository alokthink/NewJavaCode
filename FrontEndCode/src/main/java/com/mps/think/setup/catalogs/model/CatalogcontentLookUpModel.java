package com.mps.think.setup.catalogs.model;

import org.springframework.web.bind.annotation.RequestParam;

public class CatalogcontentLookUpModel {

 private String orderCode;
 private String orderClass;
 private String orderCodeType;
 private String term;

 private Long ocId1;
 private	Integer ocId;
 private String discountClass;
 private String discountDescription;
 private	Long discountClassId;
 private String rateClass;
 private String rateDescription;
 private 	Long rateClassId;
 private	Integer pkgDefId;
public String getOrderCode() {
	return orderCode;
}
public void setOrderCode(String orderCode) {
	this.orderCode = orderCode;
}
public String getOrderClass() {
	return orderClass;
}
public void setOrderClass(String orderClass) {
	this.orderClass = orderClass;
}
public String getOrderCodeType() {
	return orderCodeType;
}
public void setOrderCodeType(String orderCodeType) {
	this.orderCodeType = orderCodeType;
}
public String getTerm() {
	return term;
}
public void setTerm(String term) {
	this.term = term;
}
public Long getOcId1() {
	return ocId1;
}
public void setOcId1(Long ocId1) {
	this.ocId1 = ocId1;
}
public Integer getOcId() {
	return ocId;
}
public void setOcId(Integer ocId) {
	this.ocId = ocId;
}
public String getDiscountClass() {
	return discountClass;
}
public void setDiscountClass(String discountClass) {
	this.discountClass = discountClass;
}
public String getDiscountDescription() {
	return discountDescription;
}
public void setDiscountDescription(String discountDescription) {
	this.discountDescription = discountDescription;
}
public Long getDiscountClassId() {
	return discountClassId;
}
public void setDiscountClassId(Long discountClassId) {
	this.discountClassId = discountClassId;
}
public String getRateClass() {
	return rateClass;
}
public void setRateClass(String rateClass) {
	this.rateClass = rateClass;
}
public String getRateDescription() {
	return rateDescription;
}
public void setRateDescription(String rateDescription) {
	this.rateDescription = rateDescription;
}
public Long getRateClassId() {
	return rateClassId;
}
public void setRateClassId(Long rateClassId) {
	this.rateClassId = rateClassId;
}
public Integer getPkgDefId() {
	return pkgDefId;
}
public void setPkgDefId(Integer pkgDefId) {
	this.pkgDefId = pkgDefId;
}

}
