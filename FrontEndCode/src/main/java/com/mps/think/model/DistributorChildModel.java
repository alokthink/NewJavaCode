package com.mps.think.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistributorChildModel {
	private int id;
	private String title;
	private Long customerId;
	private DistributorAccountsModel data;
	private boolean hasChild;
	private List<DistributorChildModel> nodes;
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<DistributorChildModel> getNodes() {
		return nodes;
	}
	public void setNodes(List<DistributorChildModel> nodes) {
		this.nodes = nodes;
	}
	public DistributorAccountsModel getData() {
		return data;
	}
	public void setData(DistributorAccountsModel distributorAccountsModel) {
		this.data = distributorAccountsModel;
	}
	
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
