package com.mps.think.model;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"issue","add","add_copies","add_reason","kill","kill_copies","kill_reason","additions_deletions_seq","bundle_qty","sub_start_reason","subscriber_id","order_item_seq","sub_on_reason","new_audit_qual_category","sub_off","creation_date","sub_off_reason","orderhdr_id","sub_start","add_kill_status","old_audit_qual_category","sub_stop_reason","job_id","sub_stop","sub_on"})
public class ReviewAddsKillsModel 
{
	private int issue;
	private int add;
	private int add_copies;
	private String add_reason;
	private int kill;
	private int kill_copies;
	private String kill_reason;
	private int additions_deletions_seq;
	private int bundle_qty;
	private String sub_start_reason;
	private int subscriber_id;
	private int order_item_seq;
	private String sub_on_reason;
	private String new_audit_qual_category;
	private String sub_off;
	private String creation_date;
	private String sub_off_reason;
	private int orderhdr_id;
	private String sub_start;
	private String add_kill_status;
	private String old_audit_qual_category;
	private String sub_stop_reason;
	private String job_id;
	private String sub_stop;
	private String sub_on;
	
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
	}
	public int getAdd() {
		return add;
	}
	public void setAdd(int add) {
		this.add = add;
	}
	public int getAdd_copies() {
		return add_copies;
	}
	public void setAdd_copies(int add_copies) {
		this.add_copies = add_copies;
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
	public int getKill_copies() {
		return kill_copies;
	}
	public void setKill_copies(int kill_copies) {
		this.kill_copies = kill_copies;
	}
	public String getKill_reason() {
		return kill_reason;
	}
	public void setKill_reason(String kill_reason) {
		this.kill_reason = kill_reason;
	}
	public int getAdditions_deletions_seq() {
		return additions_deletions_seq;
	}
	public void setAdditions_deletions_seq(int additions_deletions_seq) {
		this.additions_deletions_seq = additions_deletions_seq;
	}
	public int getBundle_qty() {
		return bundle_qty;
	}
	public void setBundle_qty(int bundle_qty) {
		this.bundle_qty = bundle_qty;
	}
	public String getSub_start_reason() {
		return sub_start_reason;
	}
	public void setSub_start_reason(String sub_start_reason) {
		this.sub_start_reason = sub_start_reason;
	}
	public int getSubscriber_id() {
		return subscriber_id;
	}
	public void setSubscriber_id(int subscriber_id) {
		this.subscriber_id = subscriber_id;
	}
	public int getOrder_item_seq() {
		return order_item_seq;
	}
	public void setOrder_item_seq(int order_item_seq) {
		this.order_item_seq = order_item_seq;
	}
	public String getSub_on_reason() {
		return sub_on_reason;
	}
	public void setSub_on_reason(String sub_on_reason) {
		this.sub_on_reason = sub_on_reason;
	}
	public String getNew_audit_qual_category() {
		return new_audit_qual_category;
	}
	public void setNew_audit_qual_category(String new_audit_qual_category) {
		this.new_audit_qual_category = new_audit_qual_category;
	}
	public String getSub_off() {
		return sub_off;
	}
	public void setSub_off(String sub_off) {
		this.sub_off = sub_off;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getSub_off_reason() {
		return sub_off_reason;
	}
	public void setSub_off_reason(String sub_off_reason) {
		this.sub_off_reason = sub_off_reason;
	}
	public int getOrderhdr_id() {
		return orderhdr_id;
	}
	public void setOrderhdr_id(int orderhdr_id) {
		this.orderhdr_id = orderhdr_id;
	}
	public String getSub_start() {
		return sub_start;
	}
	public void setSub_start(String sub_start) {
		this.sub_start = sub_start;
	}
	public String getAdd_kill_status() {
		return add_kill_status;
	}
	public void setAdd_kill_status(String add_kill_status) {
		this.add_kill_status = add_kill_status;
	}
	public String getOld_audit_qual_category() {
		return old_audit_qual_category;
	}
	public void setOld_audit_qual_category(String old_audit_qual_category) {
		this.old_audit_qual_category = old_audit_qual_category;
	}
	public String getSub_stop_reason() {
		return sub_stop_reason;
	}
	public void setSub_stop_reason(String sub_stop_reason) {
		this.sub_stop_reason = sub_stop_reason;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
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
}
