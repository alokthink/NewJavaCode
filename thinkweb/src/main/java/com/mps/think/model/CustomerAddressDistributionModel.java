package com.mps.think.model;

public class CustomerAddressDistributionModel 
{
	private String distributionMethod;
	private String attribute;
	private String value;
	private int customer_address_seq;
	private long customer_id;
	
	
	public int getCustomer_address_seq() {
		return customer_address_seq;
	}
	public void setCustomer_address_seq(int customer_address_seq) {
		this.customer_address_seq = customer_address_seq;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getDistributionMethod() {
		return distributionMethod;
	}
	public void setDistributionMethod(String distributionMethod) {
		this.distributionMethod = distributionMethod;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
