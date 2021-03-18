package com.mps.think.process.model;

import java.util.ArrayList;
import java.util.List;

public class ExtractModel {
	
	
	private String extract;
	private String description; 
	private String template; 
	private int mru_extract_group_seq;
	
	//private String extractNew;
	//private String extractOld;
	
	private List<ExtractGroupModel> extractGroup=new ArrayList<ExtractGroupModel>();

	public String getExtract() {
		return extract;
	}

	public void setExtract(String extract) {
		this.extract = extract;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public int getMru_extract_group_seq() {
		return mru_extract_group_seq;
	}

	public void setMru_extract_group_seq(int mru_extract_group_seq) {
		this.mru_extract_group_seq = mru_extract_group_seq;
	}

	public List<ExtractGroupModel> getExtractGroup() {
		return extractGroup;
	}

	public void setExtractGroup(List<ExtractGroupModel> extractGroup) {
		this.extractGroup = extractGroup;
	}
	
	
	
}
