package com.mps.think.setup.reports.model;

import java.util.List;
import java.util.Map;

public class OrderClassReportsModel {

	private int id;
	private String title;
	private List<Map<String,Object>> data;
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
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	
	private List<OrderClassReportsModel> nodes;
	
	public List<OrderClassReportsModel> getNodes() {
		return nodes;
	}
	public void setNodes(List<OrderClassReportsModel> nodes) {
		this.nodes = nodes;
	}
	

}
