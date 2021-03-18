package com.mps.think.setup.tablesetup.model;

import java.util.List;



public class LeftPanelTableSetupModel {
	private int id;
	private String title;
	private List nodes;
	private List Labels;
	
	public List getLabels() {
		return Labels;
	}
	public void setLabels(List labels) {
		Labels = labels;
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
	
	

	


