package com.mps.think.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"add","add_reason","kill","kill_reason","subscriber_id","sub_on_reason","sub_off","sub_off_reason","additions_deletions_seq","sub_start","sub_start_reason","sub_stop_reason","sub_stop","sub_on","job_id"})
public class ProposedAddsKillsModel 
{
	private int add;
	private String add_reason;
	private int kill;
	private String kill_reason;
	private int subscriber_id;
	private String sub_on_reason;
	private String sub_off;
	private String sub_off_reason;
	private int additions_deletions_seq;
	private String sub_start;
	private String sub_start_reason;
	private String sub_stop_reason;
	private String sub_stop;
	private String sub_on;
	private String job_id;
	
	public int getAdd() {
		return add;
	}
	public void setAdd(int add) {
		this.add = add;
	}
	public String getAdd_reason() {
		return add_reason;
	}
	public void setAdd_reason(String add_reason) {
		this.add_reason = add_reason;
	}
	public int getKill() {
		return kill;
	}
	public void setKill(int kill) {
		this.kill = kill;
	}
	public String getKill_reason() {
		return kill_reason;
	}
	public void setKill_reason(String kill_reason) {
		this.kill_reason = kill_reason;
	}
	public int getSubscriber_id() {
		return subscriber_id;
	}
	public void setSubscriber_id(int subscriber_id) {
		this.subscriber_id = subscriber_id;
	}
	public String getSub_on_reason() {
		return sub_on_reason;
	}
	public void setSub_on_reason(String sub_on_reason) {
		this.sub_on_reason = sub_on_reason;
	}
	public String getSub_off() {
		return sub_off;
	}
	public void setSub_off(String sub_off) {
		this.sub_off = sub_off;
	}
	public String getSub_off_reason() {
		return sub_off_reason;
	}
	public void setSub_off_reason(String sub_off_reason) {
		this.sub_off_reason = sub_off_reason;
	}
	public int getAdditions_deletions_seq() {
		return additions_deletions_seq;
	}
	public void setAdditions_deletions_seq(int additions_deletions_seq) {
		this.additions_deletions_seq = additions_deletions_seq;
	}
	public String getSub_start() {
		return sub_start;
	}
	public void setSub_start(String sub_start) {
		this.sub_start = sub_start;
	}
	public String getSub_start_reason() {
		return sub_start_reason;
	}
	public void setSub_start_reason(String sub_start_reason) {
		this.sub_start_reason = sub_start_reason;
	}
	public String getSub_stop_reason() {
		return sub_stop_reason;
	}
	public void setSub_stop_reason(String sub_stop_reason) {
		this.sub_stop_reason = sub_stop_reason;
	}
	public String getSub_stop() {
		return sub_stop;
	}
	public void setSub_stop(String sub_stop) {
		this.sub_stop = sub_stop;
	}
	public String getSub_on() {
		return sub_on;
	}
	public void setSub_on(String sub_on) {
		this.sub_on = sub_on;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
}
