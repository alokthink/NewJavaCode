package com.mps.think.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeftPanelCustomerServiceModel {
	private int id;
	private String title;
	private  DistributorAccountsModel  data;
	private List nodes;
	private List labels;
	private List<Map<String,Object>> data1;

	
	

	
	public List<Map<String, Object>> getData1() {
		return data1;
	}
	public void setData1(List<Map<String, Object>> data1) {
		this.data1 = data1;
	}
	public DistributorAccountsModel getData() {
		return data;
	}
	public void setData(DistributorAccountsModel data) {
		this.data = data;
	}
	public List getLabels() {
		return labels;
	}
	public void setLabels(List labels) {
		this.labels = labels;
	}
	public int getId() {
		return id;
	}
	public List getNodes() {
		return nodes;
	}
	public void setNodes(List nodes) {
		this.nodes = nodes;
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
	
	

