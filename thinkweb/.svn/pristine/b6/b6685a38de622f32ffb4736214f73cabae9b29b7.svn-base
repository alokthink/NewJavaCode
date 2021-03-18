package com.mps.think.setup.tablesetup.model;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DealsLeftPanelModel {
	private int id;
	private String title;
	private List<Map<String,Object>> data;
	
	List<CustomerServiceLeftPanelModel> nodes;
	//private List nodes1;
	
	public int getId() {
		return id;
	}

	public List<CustomerServiceLeftPanelModel> getNodes() {
		return nodes;
	}

	public void setNodes(List<CustomerServiceLeftPanelModel> nodes) {
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

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

}
