package com.mps.think.process.model;

public class NthModel {
	
	private String code;
	private int active;
	private String description;
	private String nthCount;
    private String nthPercentage;
	private int startingRecord;
	private int everyNthRecord;
	private String processSort;
	
	
	public String getProcessSort() {
		return processSort;
	}
	public void setProcessSort(String processSort) {
		this.processSort = processSort;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNthCount() {
		return nthCount;
	}
	public void setNthCount(String nthCount) {
		this.nthCount = nthCount;
	}
	public String getNthPercentage() {
		return nthPercentage;
	}
	public void setNthPercentage(String nthPercentage) {
		this.nthPercentage = nthPercentage;
	}
	public int getStartingRecord() {
		return startingRecord;
	}
	public void setStartingRecord(int startingRecord) {
		this.startingRecord = startingRecord;
	}
	public int getEveryNthRecord() {
		return everyNthRecord;
	}
	public void setEveryNthRecord(int everyNthRecord) {
		this.everyNthRecord = everyNthRecord;
	}
	 
	
}