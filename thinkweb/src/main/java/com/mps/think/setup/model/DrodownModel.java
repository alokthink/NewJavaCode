package com.mps.think.setup.model;

public class DrodownModel {
	private Long oc_id;
	private String from_date;
	private String issue_id;
	private String to_date;
	private Long volume_group_id;
	private String start_date;
	private Integer previousIsues;
	public Long getOc_id() {
		return oc_id;
	}
	public void setOc_id(Long oc_id) {
		this.oc_id = oc_id;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getIssue_id() {
		return issue_id;
	}
	public void setIssue_id(String issue_id) {
		this.issue_id = issue_id;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public Long getVolume_group_id() {
		return volume_group_id;
	}
	public void setVolume_group_id(Long volume_group_id) {
		this.volume_group_id = volume_group_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public Integer getPreviousIsues() {
		return previousIsues;
	}
	public void setPreviousIsues(Integer previousIsues) {
		this.previousIsues = previousIsues;
	}
	public Integer getCurrentIssues() {
		return currentIssues;
	}
	public void setCurrentIssues(Integer currentIssues) {
		this.currentIssues = currentIssues;
	}
	private Integer currentIssues;

}
