package com.mps.think.model;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class AttachmentAddAttributeModel {
	private Long customerId;
	private Long attachmentId;
	private String attachmentType;
	private String userCode;
	private String record;
	private MultipartFile attachment;
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	private String attachmentnote;
	private String createDate;
	private String attachmentCategory;
	private String URL;
	List<DropdownModel> recordList;
	List<DropdownModel> attachmentCategoryList;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public MultipartFile getAttachment() {
		return attachment;
	}
	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}
	public String getAttachmentnote() {
		return attachmentnote;
	}
	public void setAttachmentnote(String attachmentnote) {
		this.attachmentnote = attachmentnote;
	}
	public List<DropdownModel> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<DropdownModel> list) {
		this.recordList = list;
	}
	public String getAttachmentCategory() {
		return attachmentCategory;
	}
	public void setAttachmentCategory(String attachmentCategory) {
		this.attachmentCategory = attachmentCategory;
	}
	public List<DropdownModel> getAttachmentCategoryList() {
		return attachmentCategoryList;
	}
	public void setAttachmentCategoryList(List<DropdownModel> attachmentCategoryList) {
		this.attachmentCategoryList = attachmentCategoryList;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
}
