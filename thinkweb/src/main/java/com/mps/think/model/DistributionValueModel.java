package com.mps.think.model;

public class DistributionValueModel 
{
	private String value;
	private String region;
	private String country_or_state;
	private String city;
	private String low_range;
	private String high_range;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry_or_state() {
		return country_or_state;
	}
	public void setCountry_or_state(String country_or_state) {
		this.country_or_state = country_or_state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLow_range() {
		return low_range;
	}
	public void setLow_range(String low_range) {
		this.low_range = low_range;
	}
	public String getHigh_range() {
		return high_range;
	}
	public void setHigh_range(String high_range) {
		this.high_range = high_range;
	}
}
