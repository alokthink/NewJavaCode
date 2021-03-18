package com.mps.think.process.model;

public class JobModel {
	private int jobId;
	private String  labelKeyline;
	private String labelGroup;
	private int processId;
	private String  cutOffDate;
	private String dropDate;
	private String note;
	private String startDateTime; 
	private String description;
	private String creationDate; 
	private int defaultPriority;
	private String queue;
	private int logOption;
	private int generateRenewOffers;
	private int backIssuesOnReinstated;
	private String selectStartDate;
	private String selectEndDate;
	private int holdJob ;
	private int holdOutput;
	private int holdUpdate;
	private String autoRenewals;
	private String status;
	private String stepName;
	private String nextStartDate;
	private int candidates;
	private int selected;
	private int updated;
	private int hasError;
	private int graceNew;
	private String purpose;
	private String nthDef;
	private int graceCurrent;
	private String listCompany;
	private int jobPriority;
	private int invServeLabel;
	private int writeReconDtl;
	private int updReconTables;
	private int manualReviewFulfillment;
	private int stepNumber;
	private int inclPkgMembers;
	
	private int workTableSeq;
	private String issueDate;
	private int customerId;
	private int orderhdrId;
	private int orderItemSeq;
	private String label1;
	private int productId;
	private String productSize;
	private String productStyle;
	private String productColor;
	private int nIntervalUnits;
	private int includeProforma;
	private int forceRepeat;
	private String schedulePaymentDate;
	private int volumeGroupId;
	private int nDaysToNextRun;
	private int runPaymentAfter;
	

	public int getWorkTableSeq() {
		return workTableSeq;
	}
	public void setWorkTableSeq(int workTableSeq) {
		this.workTableSeq = workTableSeq;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getOrderhdrId() {
		return orderhdrId;
	}
	public void setOrderhdrId(int orderhdrId) {
		this.orderhdrId = orderhdrId;
	}
	public int getOrderItemSeq() {
		return orderItemSeq;
	}
	public void setOrderItemSeq(int orderItemSeq) {
		this.orderItemSeq = orderItemSeq;
	}
	public String getLabel1() {
		return label1;
	}
	public void setLabel1(String label1) {
		this.label1 = label1;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductStyle() {
		return productStyle;
	}
	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getListCompany() {
		return listCompany;
	}
	public void setListCompany(String listCompany) {
		this.listCompany = listCompany;
	}
	public int getGraceCurrent() {
		return graceCurrent;
	}
	public void setGraceCurrent(int graceCurrent) {
		this.graceCurrent = graceCurrent;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getNthDef() {
		return nthDef;
	}
	public void setNthDef(String nthDef) {
		this.nthDef = nthDef;
	}
	public int getGraceNew() {
		return graceNew;
	}
	public void setGraceNew(int graceNew) {
		this.graceNew = graceNew;
	}
	public int getDefaultPriority() {
		return defaultPriority;
	}
	public void setDefaultPriority(int defaultPriority) {
		this.defaultPriority = defaultPriority;
	}
	public String getNextStartDate() {
		return nextStartDate;
	}
	public void setNextStartDate(String nextStartDate) {
		this.nextStartDate = nextStartDate;
	}
	
	public int getCandidates() {
		return candidates;
	}
	public void setCandidates(int candidates) {
		this.candidates = candidates;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	public int getUpdated() {
		return updated;
	}
	public void setUpdated(int updated) {
		this.updated = updated;
	}
	public int getHasError() {
		return hasError;
	}
	public void setHasError(int hasError) {
		this.hasError = hasError;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getAutoRenewals() {
		return autoRenewals;
	}
	public void setAutoRenewals(String autoRenewals) {
		this.autoRenewals = autoRenewals;
	}
	public int getHoldJob() {
		return holdJob;
	}
	public void setHoldJob(int holdJob) {
		this.holdJob = holdJob;
	}
	public int getHoldOutput() {
		return holdOutput;
	}
	public void setHoldOutput(int holdOutput) {
		this.holdOutput = holdOutput;
	}
	public int getHoldUpdate() {
		return holdUpdate;
	}
	public void setHoldUpdate(int holdUpdate) {
		this.holdUpdate = holdUpdate;
	}
	public String getSelectStartDate() {
		return selectStartDate;
	}
	public void setSelectStartDate(String selectStartDate) {
		this.selectStartDate = selectStartDate;
	}
	public String getSelectEndDate() {
		return selectEndDate;
	}
	public void setSelectEndDate(String selectEndDate) {
		this.selectEndDate = selectEndDate;
	}
	public int getBackIssuesOnReinstated() {
		return backIssuesOnReinstated;
	}
	public void setBackIssuesOnReinstated(int backIssuesOnReinstated) {
		this.backIssuesOnReinstated = backIssuesOnReinstated;
	}
	public String getLabelKeyline() {
		return labelKeyline;
	}
	public void setLabelKeyline(String labelKeyline) {
		this.labelKeyline = labelKeyline;
	}
	public String getLabelGroup() {
		return labelGroup;
	}
	public void setLabelGroup(String labelGroup) {
		this.labelGroup = labelGroup;
	}
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	public String getCutOffDate() {
		return cutOffDate;
	}
	public void setCutOffDate(String cutOffDate) {
		this.cutOffDate = cutOffDate;
	}
	public String getDropDate() {
		return dropDate;
	}
	public void setDropDate(String dropDate) {
		this.dropDate = dropDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
	public int getLogOption() {
		return logOption;
	}
	public void setLogOption(int logOption) {
		this.logOption = logOption;
	}
	public int getGenerateRenewOffers() {
		return generateRenewOffers;
	}
	public void setGenerateRenewOffers(int generateRenewOffers) {
		this.generateRenewOffers = generateRenewOffers;
	}
	public int getJobPriority() {
		return jobPriority;
	}
	public void setJobPriority(int jobPriority) {
		this.jobPriority = jobPriority;
	}
	public int getInvServeLabel() {
		return invServeLabel;
	}
	public void setInvServeLabel(int invServeLabel) {
		this.invServeLabel = invServeLabel;
	}
	public int getWriteReconDtl() {
		return writeReconDtl;
	}
	public void setWriteReconDtl(int writeReconDtl) {
		this.writeReconDtl = writeReconDtl;
	}
	public int getUpdReconTables() {
		return updReconTables;
	}
	public void setUpdReconTables(int updReconTables) {
		this.updReconTables = updReconTables;
	}
	public int getManualReviewFulfillment() {
		return manualReviewFulfillment;
	}
	public void setManualReviewFulfillment(int manualReviewFulfillment) {
		this.manualReviewFulfillment = manualReviewFulfillment;
	}
	public int getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
	public int getInclPkgMembers() {
		return inclPkgMembers;
	}
	public void setInclPkgMembers(int inclPkgMembers) {
		this.inclPkgMembers = inclPkgMembers;
	}
	public int getIncludeProforma() {
		return includeProforma;
	}
	public void setIncludeProforma(int includeProforma) {
		this.includeProforma = includeProforma;
	}
	public int getForceRepeat() {
		return forceRepeat;
	}
	public void setForceRepeat(int forceRepeat) {
		this.forceRepeat = forceRepeat;
	}
	public String getSchedulePaymentDate() {
		return schedulePaymentDate;
	}
	public void setSchedulePaymentDate(String schedulePaymentDate) {
		this.schedulePaymentDate = schedulePaymentDate;
	}
	public int getVolumeGroupId() {
		return volumeGroupId;
	}
	public void setVolumeGroupId(int volumeGroupId) {
		this.volumeGroupId = volumeGroupId;
	}
	public int getnDaysToNextRun() {
		return nDaysToNextRun;
	}
	public void setnDaysToNextRun(int nDaysToNextRun) {
		this.nDaysToNextRun = nDaysToNextRun;
	}
	public int getnIntervalUnits() {
		return nIntervalUnits;
	}
	public void setnIntervalUnits(int nIntervalUnits) {
		this.nIntervalUnits = nIntervalUnits;
	}
	public int getRunPaymentAfter() {
		return runPaymentAfter;
	}
	public void setRunPaymentAfter(int runPaymentAfter) {
		this.runPaymentAfter = runPaymentAfter;
	}
	
	
}
