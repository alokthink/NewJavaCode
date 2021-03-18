package com.mps.think.model;

import java.util.List;

public class DistributorAttributeSetUpModel 
{
	private int key;
	private String method;
	private String attribute;
	private List<DistributorValue>distributorValue;
	
	
	public List<DistributorValue> getDistributorValue() {
		return distributorValue;
	}
	public void setDistributorValue(List<DistributorValue> distributorValue) {
		this.distributorValue = distributorValue;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}
