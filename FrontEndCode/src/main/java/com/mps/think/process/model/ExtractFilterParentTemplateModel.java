package com.mps.think.process.model;

import java.util.ArrayList;
import java.util.List;

public class ExtractFilterParentTemplateModel {
	
	private String title;
	
	private List<ExtractFilterChildTemplateModel> nodes=new ArrayList<ExtractFilterChildTemplateModel>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ExtractFilterChildTemplateModel> getNodes() {
		return nodes;
	}

	public void setNodes(List<ExtractFilterChildTemplateModel> nodes) {
		this.nodes = nodes;
	}

	
	
	

}
