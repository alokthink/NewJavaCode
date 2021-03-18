package com.mps.think.setup.model;

public class PackageContentModel {
	private  Integer orderCodeId;
	private Integer pkgContentSeq;
	private Integer itemOrderCodeId;
	private String description;
	private Integer qty;
	private String prepaymentOpt;
	private String required;
	public Integer getOrderCodeId() {
		return orderCodeId;
	}
	public void setOrderCodeId(Integer orderCodeId) {
		this.orderCodeId = orderCodeId;
	}
	public Integer getPkgContentSeq() {
		return pkgContentSeq;
	}
	public void setPkgContentSeq(Integer pkgContentSeq) {
		this.pkgContentSeq = pkgContentSeq;
	}
	public Integer getItemOrderCodeId() {
		return itemOrderCodeId;
	}
	public void setItemOrderCodeId(Integer itemOrderCodeId) {
		this.itemOrderCodeId = itemOrderCodeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getPrepaymentOpt() {
		return prepaymentOpt;
	}
	public void setPrepaymentOpt(String prepaymentOpt) {
		this.prepaymentOpt = prepaymentOpt;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}

}
