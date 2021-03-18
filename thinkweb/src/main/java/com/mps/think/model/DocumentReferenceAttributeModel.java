package com.mps.think.model;

import java.util.List;

public class DocumentReferenceAttributeModel {

	private String operator;
	private String assignedTo;
	private String batchTemplate;
	private String description;
	private String active;
	private String closed;
	private String customerService;
	private String batch;
	private String Import;
	private String Internet;
	private String type;
	private String referenceId;
	private int limit;
	List<DropdownModel> operatorList;
	List<DropdownModel> assignedToList;
	List<DropdownModel> batchTemplateList;
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getBatchTemplate() {
		return batchTemplate;
	}
	public void setBatchTemplate(String batchTemplate) {
		this.batchTemplate = batchTemplate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getClosed() {
		return closed;
	}
	public void setClosed(String closed) {
		this.closed = closed;
	}
	public String getCustomerService() {
		return customerService;
	}
	public void setCustomerService(String customerService) {
		this.customerService = customerService;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getImport() {
		return Import;
	}
	public void setImport(String import1) {
		Import = import1;
	}
	public String getInternet() {
		return Internet;
	}
	public void setInternet(String internet) {
		Internet = internet;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<DropdownModel> getOperatorList() {
		return operatorList;
	}
	public void setOperatorList(List<DropdownModel> operatorList) {
		this.operatorList = operatorList;
	}
	public List<DropdownModel> getAssignedToList() {
		return assignedToList;
	}
	public void setAssignedToList(List<DropdownModel> assignedToList) {
		this.assignedToList = assignedToList;
	}
	public List<DropdownModel> getBatchTemplateList() {
		return batchTemplateList;
	}
	public void setBatchTemplateList(List<DropdownModel> batchTemplateList) {
		this.batchTemplateList = batchTemplateList;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
		
}
