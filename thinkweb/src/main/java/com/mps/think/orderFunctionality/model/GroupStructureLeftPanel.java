package com.mps.think.orderFunctionality.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupStructureLeftPanel {
	private int id;
	private String title;
	private List<GroupStructureLeftPanel> node;
	private List<Map<String, Object>> nodes;

	public List<GroupStructureLeftPanel> getNode() {
		return node;
	}

	public void setNode(List<GroupStructureLeftPanel> subChildSubGroupList) {
		this.node = subChildSubGroupList;
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

	public List<Map<String, Object>> getNodes() {
		return nodes;
	}

	public void setNodes(List<Map<String, Object>> nodes) {
		this.nodes = nodes;
	}

}
	
