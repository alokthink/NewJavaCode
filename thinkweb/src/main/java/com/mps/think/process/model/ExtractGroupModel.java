package com.mps.think.process.model;

import java.util.ArrayList;
import java.util.List;

public class ExtractGroupModel {
	
	private String description;
	
	private List<ExtractGroupBreakModel> extractGroupBreakModel=new ArrayList<ExtractGroupBreakModel>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ExtractGroupBreakModel> getExtractGroupBreakModel() {
		return extractGroupBreakModel;
	}

	public void setExtractGroupBreakModel(List<ExtractGroupBreakModel> extractGroupBreakModel) {
		this.extractGroupBreakModel = extractGroupBreakModel;
	}




}
