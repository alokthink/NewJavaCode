package com.mps.think.orderFunctionality.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagePanelDemographicsModel {
	private  List<DemographicChildModel> rootName;
	private List<DemographicChildModel> data;
	private List nodes;
	private List<Map<String,Object>> data1;
	
	
	
	public List<DemographicChildModel> getRootName() {
		return rootName;
	}
	public void setRootName(List<DemographicChildModel> rootName) {
		this.rootName = rootName;
	}
	public List<DemographicChildModel> getData() {
		return data;
	}
	public void setData(List<DemographicChildModel> data) {
		this.data = data;
	}
	public List getNodes() {
		return nodes;
	}
	public void setNodes(List nodes) {
		this.nodes = nodes;
	}
	public List<Map<String, Object>> getData1() {
		return data1;
	}
	public void setData1(List<Map<String, Object>> data1) {
		this.data1 = data1;
	}
	

}
