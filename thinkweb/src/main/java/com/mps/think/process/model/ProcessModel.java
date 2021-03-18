package com.mps.think.process.model;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ProcessModel {
	private int processId;
	private String description;
	private String processType;
	private int status;
	private Integer defaultPriority;
	private String extract;
	private int driverType;
	private int bankDefId;
	private String defaultQueue;
	private int allOc;
	private String labelGroup;
	private String labelKeyline;
	private Integer labelLength;
	private int resendNotice;
	private int noticeType;
	private int daysBeforeEnd;
	private String outputSort;
	private String sqlScript;
	private Integer pickList;
	private Integer bundleThreshold;
	private String daysPassedForPulls;
	private Integer graceNew;
	private Integer graceCurrent;
	private String workDir;
	private String auddisType;
	private String skipManualPayResponse;
	private String leaveDdAccountNumberPlainText;
	private int unpaidResubmit;
	private Integer repeatingType;
	private String ccardExpireDays;
	private String auditType;
    private int validateAdds;
	private int manualReview;
	private Integer processOcType;
	private int bills;
	private Integer splits;
	private Integer inserts;
	private int renewals;
	private String autoRenewals;
	private Integer installmentBills;
	private String prioritySort;
	private int runIcVerify;
	private int processDepositPayment;	
	private int intervalUnit;
	private int nIntervalUnits;
	private int includeAll;
	private String installmentPlanId;
	private int doMassKill;
	private int doMassSuspend;
	private int massKillInterval;
	private int massSuspendInterval;
	private String cancelReason;
	private String schedulePaymentDays;
	private int includesProformas;
	private int billGrpBillTo;
	private int billGrpCurrency;
	private int billGrpDef;
	private int billGrpOclass;
	private int billGrpOrder;
	private String nthDef;
	private int renGrpRenTo;
	private int renGrpOrder;
	private int renGrpOclass;
	private int renGroupCurrency;
	private int renGrpDef;
	private int requal;
	private String generateRenewOffers;
	private String volumeGroupId;
	private String inclPkgMembers;
	private int promotions;
	private int allInstallmentPlans;
	private int allCreditCards;
	private int customerType;
	private int allProspectCategories;
	private int multiplePerCustomer;
	private String ocId;
	private int inclAuditParagraphReports;
	private String batchTemplate;
	private String coMail;
	private String allListRentalCategories;
	private int invServeLabel;
	private int writeReconDtl;
	private int icsBankDefId;
	private int updReconTables;
	private String itemsPerRequest;
	private String jobCompletionEmailAddress;
	private String auditParagraphIgnoreBackIs;
	private String fromEmailAddress;
	private Integer manualReviewFulfillment;
	private String autoRenewExpireDays;
	private String onHoldEmail;
	private String outputReadyEmail;
	private String reviewReadyEmail;
	private String jobDoneEmail; 
	private String warningEmail;
	private String fatal_email;
	private String noConnectEmail;
	private String notification;
	private int cleanupEvents;
	private String startDateTime;
	private int processOutputSeq;
	private String renewalDef;
	private String generateSourceCode;
	private Integer active;
	private String renewalCardId;
	private String fromTab;
	private String renewalDefTestDesc;
	private int activeTesting;
	private int renewalDefTestSeq;

	
	
	public int getActiveTesting() {
		return activeTesting;
	}
	public void setActiveTesting(int activeTesting) {
		this.activeTesting = activeTesting;
	}
	
	public int getRenewalDefTestSeq() {
		return renewalDefTestSeq;
	}
	
	public void setRenewalDefTestSeq(int renewalDefTestSeq) {
		this.renewalDefTestSeq = renewalDefTestSeq;
	}
	public String getRenewalCardId() {
		return renewalCardId;
	}
	public void setRenewalCardId(String renewalCardId) {
		this.renewalCardId = renewalCardId;
	}
	public void setRepeatingType(Integer repeatingType) {
		this.repeatingType = repeatingType;
	}
	public void setManualReview(int manualReview) {
		this.manualReview = manualReview;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	
	
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public int getProcessId() {
		return processId;
	}
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProcessType() {
		return processType;
	}
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer getDefaultPriority() {
		return defaultPriority;
	}
	
	public void setDefaultPriority(Integer defaultPriority) {
		this.defaultPriority = defaultPriority;
	}
	public String getExtract() {
		return extract;
	}
	public void setExtract(String extract) {
		this.extract = extract;
	}
	public int getDriverType() {
		return driverType;
	}
	public void setDriverType(int driverType) {
		this.driverType = driverType;
	}
	public int getBankDefId() {
		return bankDefId;
	}
	public void setBankDefId(int bankDefId) {
		this.bankDefId = bankDefId;
	}
	public String getDefaultQueue() {
		return defaultQueue;
	}
	public void setDefaultQueue(String defaultQueue) {
		this.defaultQueue = defaultQueue;
	}
	public int getAllOc() {
		return allOc;
	}
	public void setAllOc(int allOc) {
		this.allOc = allOc;
	}
	public String getLabelGroup() {
		return labelGroup;
	}
	public void setLabelGroup(String labelGroup) {
		this.labelGroup = labelGroup;
	}
	public String getLabelKeyline() {
		return labelKeyline;
	}
	public void setLabelKeyline(String labelKeyline) {
		this.labelKeyline = labelKeyline;
	}
	public Integer getLabelLength() {
		return labelLength;
	}
	public void setLabelLength(Integer labelLength) {
		this.labelLength = labelLength;
	}
	public int getResendNotice() {
		return resendNotice;
	}
	public void setResendNotice(int resendNotice) {
		this.resendNotice = resendNotice;
	}
	public int getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(int noticeType) {
		this.noticeType = noticeType;
	}
	public int getDaysBeforeEnd() {
		return daysBeforeEnd;
	}
	public void setDaysBeforeEnd(int daysBeforeEnd) {
		this.daysBeforeEnd = daysBeforeEnd;
	}
	public String getOutputSort() {
		return outputSort;
	}
	public void setOutputSort(String outputSort) {
		this.outputSort = outputSort;
	}
	public String getSqlScript() {
		return sqlScript;
	}
	public void setSqlScript(String sqlScript) {
		this.sqlScript = sqlScript;
	}
	public Integer getPickList() {
		return pickList;
	}
	public void setPickList(Integer pickList) {
		this.pickList = pickList;
	}
	public Integer getBundleThreshold() {
		return bundleThreshold;
	}
	public void setBundleThreshold(Integer bundleThreshold) {
		this.bundleThreshold = bundleThreshold;
	}
	public String getDaysPassedForPulls() {
		return daysPassedForPulls;
	}
	public void setDaysPassedForPulls(String daysPassedForPulls) {
		this.daysPassedForPulls = daysPassedForPulls;
	}
	public Integer getGraceNew() {
		return graceNew;
	}
	public void setGraceNew(Integer graceNew) {
		this.graceNew = graceNew;
	}
	public Integer getGraceCurrent() {
		return graceCurrent;
	}
	public void setGraceCurrent(Integer graceCurrent) {
		this.graceCurrent = graceCurrent;
	}
	public String getWorkDir() {
		return workDir;
	}
	public void setWorkDir(String workDir) {
		this.workDir = workDir;
	}
	public String getAuddisType() {
		return auddisType;
	}
	public void setAuddisType(String auddisType) {
		this.auddisType = auddisType;
	}
	public String getSkipManualPayResponse() {
		return skipManualPayResponse;
	}
	public void setSkipManualPayResponse(String skipManualPayResponse) {
		this.skipManualPayResponse = skipManualPayResponse;
	}
	public String getLeaveDdAccountNumberPlainText() {
		return leaveDdAccountNumberPlainText;
	}
	public void setLeaveDdAccountNumberPlainText(String leaveDdAccountNumberPlainText) {
		this.leaveDdAccountNumberPlainText = leaveDdAccountNumberPlainText;
	}
	public int getUnpaidResubmit() {
		return unpaidResubmit;
	}
	public void setUnpaidResubmit(int unpaidResubmit) {
		this.unpaidResubmit = unpaidResubmit;
	}
	public Integer getRepeatingType() {
		return repeatingType;
	}
	public void setRepeatingType(int repeatingType) {
		this.repeatingType = repeatingType;
	}
	public String getCcardExpireDays() {
		return ccardExpireDays;
	}
	public void setCcardExpireDays(String  ccardExpireDays) {
		this.ccardExpireDays = ccardExpireDays;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public int getValidateAdds() {
		return validateAdds;
	}
	public void setValidateAdds(int validateAdds) {
		this.validateAdds = validateAdds;
	}
	
	public Integer getManualReview() {
		return manualReview;
	}
	public void setManualReview(Integer manualReview) {
		this.manualReview = manualReview;
	}
	public Integer getProcessOcType() {
		return processOcType;
	}
	public void setProcessOcType(Integer processOcType) {
		this.processOcType = processOcType;
	}
	public int getBills() {
		return bills;
	}
	public void setBills(int bills) {
		this.bills = bills;
	}
	public Integer getSplits() {
		return splits;
	}
	public void setSplits(Integer splits) {
		this.splits = splits;
	}
	public Integer getInserts() {
		return inserts;
	}
	public void setInserts(Integer inserts) {
		this.inserts = inserts;
	}
	public int getRenewals() {
		return renewals;
	}
	public void setRenewals(int renewals) {
		this.renewals = renewals;
	}
	public String getAutoRenewals() {
		return autoRenewals;
	}
	public void setAutoRenewals(String autoRenewals) {
		this.autoRenewals = autoRenewals;
	}
	public Integer getInstallmentBills() {
		return installmentBills;
	}
	public void setInstallmentBills(Integer installmentBills) {
		this.installmentBills = installmentBills;
	}
	public String getPrioritySort() {
		return prioritySort;
	}
	public void setPrioritySort(String prioritySort) {
		this.prioritySort = prioritySort;
	}
	public int getRunIcVerify() {
		return runIcVerify;
	}
	public void setRunIcVerify(int runIcVerify) {
		this.runIcVerify = runIcVerify;
	}
	public int getProcessDepositPayment() {
		return processDepositPayment;
	}
	public void setProcessDepositPayment(int processDepositPayment) {
		this.processDepositPayment = processDepositPayment;
	}
	public int getIntervalUnit() {
		return intervalUnit;
	}
	public void setIntervalUnit(int intervalUnit) {
		this.intervalUnit = intervalUnit;
	}
	public int getnIntervalUnits() {
		return nIntervalUnits;
	}
	public void setnIntervalUnits(int nIntervalUnits) {
		this.nIntervalUnits = nIntervalUnits;
	}
	public int getIncludeAll() {
		return includeAll;
	}
	public void setIncludeAll(int includeAll) {
		this.includeAll = includeAll;
	}
	public String getInstallmentPlanId() {
		return installmentPlanId;
	}
	public void setInstallmentPlanId(String installmentPlanId) {
		this.installmentPlanId = installmentPlanId;
	}
	public int getDoMassKill() {
		return doMassKill;
	}
	public void setDoMassKill(int doMassKill) {
		this.doMassKill = doMassKill;
	}
	public int getDoMassSuspend() {
		return doMassSuspend;
	}
	public void setDoMassSuspend(int doMassSuspend) {
		this.doMassSuspend = doMassSuspend;
	}
	public int getMassKillInterval() {
		return massKillInterval;
	}
	public void setMassKillInterval(int massKillInterval) {
		this.massKillInterval = massKillInterval;
	}
	public int getMassSuspendInterval() {
		return massSuspendInterval;
	}
	public void setMassSuspendInterval(int massSuspendInterval) {
		this.massSuspendInterval = massSuspendInterval;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getSchedulePaymentDays() {
		return schedulePaymentDays;
	}
	public void setSchedulePaymentDays(String schedulePaymentDays) {
		this.schedulePaymentDays = schedulePaymentDays;
	}
	public int getIncludesProformas() {
		return includesProformas;
	}
	public void setIncludesProformas(int includesProformas) {
		this.includesProformas = includesProformas;
	}
	public int getBillGrpBillTo() {
		return billGrpBillTo;
	}
	public void setBillGrpBillTo(int billGrpBillTo) {
		this.billGrpBillTo = billGrpBillTo;
	}
	public int getBillGrpCurrency() {
		return billGrpCurrency;
	}
	public void setBillGrpCurrency(int billGrpCurrency) {
		this.billGrpCurrency = billGrpCurrency;
	}
	public int getBillGrpDef() {
		return billGrpDef;
	}
	public void setBillGrpDef(int billGrpDef) {
		this.billGrpDef = billGrpDef;
	}
	public int getBillGrpOclass() {
		return billGrpOclass;
	}
	public void setBillGrpOclass(int billGrpOclass) {
		this.billGrpOclass = billGrpOclass;
	}
	public int getBillGrpOrder() {
		return billGrpOrder;
	}
	public void setBillGrpOrder(int billGrpOrder) {
		this.billGrpOrder = billGrpOrder;
	}
	public String getNthDef() {
		return nthDef;
	}
	public void setNthDef(String nthDef) {
		this.nthDef = nthDef;
	}
	public int getRenGrpRenTo() {
		return renGrpRenTo;
	}
	public void setRenGrpRenTo(int renGrpRenTo) {
		this.renGrpRenTo = renGrpRenTo;
	}
	public int getRenGrpOrder() {
		return renGrpOrder;
	}
	public void setRenGrpOrder(int renGrpOrder) {
		this.renGrpOrder = renGrpOrder;
	}
	public int getRenGrpOclass() {
		return renGrpOclass;
	}
	public void setRenGrpOclass(int renGrpOclass) {
		this.renGrpOclass = renGrpOclass;
	}
	public int getRenGroupCurrency() {
		return renGroupCurrency;
	}
	public void setRenGroupCurrency(int renGroupCurrency) {
		this.renGroupCurrency = renGroupCurrency;
	}
	public int getRenGrpDef() {
		return renGrpDef;
	}
	public void setRenGrpDef(int renGrpDef) {
		this.renGrpDef = renGrpDef;
	}
	public int getRequal() {
		return requal;
	}
	public void setRequal(int requal) {
		this.requal = requal;
	}
	public String getGenerateRenewOffers() {
		return generateRenewOffers;
	}
	public void setGenerateRenewOffers(String generateRenewOffers) {
		this.generateRenewOffers = generateRenewOffers;
	}
	public String getVolumeGroupId() {
		return volumeGroupId;
	}
	public void setVolumeGroupId(String volumeGroupId) {
		this.volumeGroupId = volumeGroupId;
	}
	public String getInclPkgMembers() {
		return inclPkgMembers;
	}
	public void setInclPkgMembers(String inclPkgMembers) {
		this.inclPkgMembers = inclPkgMembers;
	}
	public int getPromotions() {
		return promotions;
	}
	public void setPromotions(int promotions) {
		this.promotions = promotions;
	}
	public int getAllInstallmentPlans() {
		return allInstallmentPlans;
	}
	public void setAllInstallmentPlans(int allInstallmentPlans) {
		this.allInstallmentPlans = allInstallmentPlans;
	}
	public int getAllCreditCards() {
		return allCreditCards;
	}
	public void setAllCreditCards(int allCreditCards) {
		this.allCreditCards = allCreditCards;
	}
	public int getCustomerType() {
		return customerType;
	}
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	public int getAllProspectCategories() {
		return allProspectCategories;
	}
	public void setAllProspectCategories(int allProspectCategories) {
		this.allProspectCategories = allProspectCategories;
	}
	public int getMultiplePerCustomer() {
		return multiplePerCustomer;
	}
	public void setMultiplePerCustomer(int multiplePerCustomer) {
		this.multiplePerCustomer = multiplePerCustomer;
	}
	public String getOcId() {
		return ocId;
	}
	public void setOcId(String ocId) {
		this.ocId = ocId;
	}
	public int getInclAuditParagraphReports() {
		return inclAuditParagraphReports;
	}
	public void setInclAuditParagraphReports(int inclAuditParagraphReports) {
		this.inclAuditParagraphReports = inclAuditParagraphReports;
	}
	public String getBatchTemplate() {
		return batchTemplate;
	}
	public void setBatchTemplate(String batchTemplate) {
		this.batchTemplate = batchTemplate;
	}
	public String getCoMail() {
		return coMail;
	}
	public void setCoMail(String coMail) {
		this.coMail = coMail;
	}
	public String getAllListRentalCategories() {
		return allListRentalCategories;
	}
	public void setAllListRentalCategories(String allListRentalCategories) {
		this.allListRentalCategories = allListRentalCategories;
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
	public int getIcsBankDefId() {
		return icsBankDefId;
	}
	public void setIcsBankDefId(int icsBankDefId) {
		this.icsBankDefId = icsBankDefId;
	}
	public int getUpdReconTables() {
		return updReconTables;
	}
	public void setUpdReconTables(int updReconTables) {
		this.updReconTables = updReconTables;
	}
	public String getItemsPerRequest() {
		return itemsPerRequest;
	}
	public void setItemsPerRequest(String itemsPerRequest) {
		this.itemsPerRequest = itemsPerRequest;
	}
	public String getJobCompletionEmailAddress() {
		return jobCompletionEmailAddress;
	}
	public void setJobCompletionEmailAddress(String jobCompletionEmailAddress) {
		this.jobCompletionEmailAddress = jobCompletionEmailAddress;
	}
	public String getAuditParagraphIgnoreBackIs() {
		return auditParagraphIgnoreBackIs;
	}
	public void setAuditParagraphIgnoreBackIs(String auditParagraphIgnoreBackIs) {
		this.auditParagraphIgnoreBackIs = auditParagraphIgnoreBackIs;
	}
	public String getFromEmailAddress() {
		return fromEmailAddress;
	}
	public void setFromEmailAddress(String fromEmailAddress) {
		this.fromEmailAddress = fromEmailAddress;
	}
	public Integer getManualReviewFulfillment() {
		return manualReviewFulfillment;
	}
	public void setManualReviewFulfillment(Integer manualReviewFulfillment) {
		this.manualReviewFulfillment = manualReviewFulfillment;
	}
	public String getAutoRenewExpireDays() {
		return autoRenewExpireDays;
	}
	public void setAutoRenewExpireDays(String autoRenewExpireDays) {
		this.autoRenewExpireDays = autoRenewExpireDays;
	}
	public String getOnHoldEmail() {
		return onHoldEmail;
	}
	public void setOnHoldEmail(String onHoldEmail) {
		this.onHoldEmail = onHoldEmail;
	}
	public String getOutputReadyEmail() {
		return outputReadyEmail;
	}
	public void setOutputReadyEmail(String outputReadyEmail) {
		this.outputReadyEmail = outputReadyEmail;
	}
	public String getReviewReadyEmail() {
		return reviewReadyEmail;
	}
	public void setReviewReadyEmail(String reviewReadyEmail) {
		this.reviewReadyEmail = reviewReadyEmail;
	}
	public String getJobDoneEmail() {
		return jobDoneEmail;
	}
	public void setJobDoneEmail(String jobDoneEmail) {
		this.jobDoneEmail = jobDoneEmail;
	}
	public String getWarningEmail() {
		return warningEmail;
	}
	public void setWarningEmail(String warningEmail) {
		this.warningEmail = warningEmail;
	}
	public String getFatal_email() {
		return fatal_email;
	}
	public void setFatal_email(String fatal_email) {
		this.fatal_email = fatal_email;
	}
	public String getNoConnectEmail() {
		return noConnectEmail;
	}
	public void setNoConnectEmail(String noConnectEmail) {
		this.noConnectEmail = noConnectEmail;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public int getCleanupEvents() {
		return cleanupEvents;
	}
	public void setCleanupEvents(int cleanupEvents) {
		this.cleanupEvents = cleanupEvents;
	}
	public String getRenewalDef() {
		return renewalDef;
	}
	public void setRenewalDef(String renewalDef) {
		this.renewalDef = renewalDef;
	}
	public String getGenerateSourceCode() {
		return generateSourceCode;
	}
	public void setGenerateSourceCode(String generateSourceCode) {
		this.generateSourceCode = generateSourceCode;
	}
	public int getProcessOutputSeq() {
		return processOutputSeq;
	}
	public void setProcessOutputSeq(int processOutputSeq) {
		this.processOutputSeq = processOutputSeq;
	}
	
	public String getFromTab() {
		return fromTab;
	}
	public void setFromTab(String fromTab) {
		this.fromTab = fromTab;
	}
	
	
	public String getRenewalDefTestDesc() {
		return renewalDefTestDesc;
	}
	public void setRenewalDefTestDesc(String renewalDefTestDesc) {
		this.renewalDefTestDesc = renewalDefTestDesc;
	}
	@Override
	public String toString() {
		return "ProcessModel [processId=" + processId + ", description=" + description + ", processType=" + processType
				+ ", status=" + status + ", defaultPriority=" + defaultPriority + ", extract=" + extract
				+ ", driverType=" + driverType + ", bankDefId=" + bankDefId + ", defaultQueue=" + defaultQueue
				+ ", allOc=" + allOc + ", labelGroup=" + labelGroup + ", labelKeyline=" + labelKeyline
				+ ", labelLength=" + labelLength + ", resendNotice=" + resendNotice + ", noticeType=" + noticeType
				+ ", daysBeforeEnd=" + daysBeforeEnd + ", outputSort=" + outputSort + ", sqlScript=" + sqlScript
				+ ", pickList=" + pickList + ", bundleThreshold=" + bundleThreshold + ", daysPassedForPulls="
				+ daysPassedForPulls + ", graceNew=" + graceNew + ", graceCurrent=" + graceCurrent + ", workDir="
				+ workDir + ", auddisType=" + auddisType + ", skipManualPayResponse=" + skipManualPayResponse
				+ ", leaveDdAccountNumberPlainText=" + leaveDdAccountNumberPlainText + ", unpaidResubmit="
				+ unpaidResubmit + ", repeatingType=" + repeatingType + ", ccardExpireDays=" + ccardExpireDays
				+ ", auditType=" + auditType + ", validateAdds=" + validateAdds + ", manualReview=" + manualReview
				+ ", processOcType=" + processOcType + ", bills=" + bills + ", splits=" + splits + ", inserts="
				+ inserts + ", renewals=" + renewals + ", autoRenewals=" + autoRenewals + ", installmentBills="
				+ installmentBills + ", prioritySort=" + prioritySort + ", runIcVerify=" + runIcVerify
				+ ", processDepositPayment=" + processDepositPayment + ", intervalUnit=" + intervalUnit
				+ ", nIntervalUnits=" + nIntervalUnits + ", includeAll=" + includeAll + ", installmentPlanId="
				+ installmentPlanId + ", doMassKill=" + doMassKill + ", doMassSuspend=" + doMassSuspend
				+ ", massKillInterval=" + massKillInterval + ", massSuspendInterval=" + massSuspendInterval
				+ ", cancelReason=" + cancelReason + ", schedulePaymentDays=" + schedulePaymentDays
				+ ", includesProformas=" + includesProformas + ", billGrpBillTo=" + billGrpBillTo + ", billGrpCurrency="
				+ billGrpCurrency + ", billGrpDef=" + billGrpDef + ", billGrpOclass=" + billGrpOclass
				+ ", billGrpOrder=" + billGrpOrder + ", nthDef=" + nthDef + ", renGrpRenTo=" + renGrpRenTo
				+ ", renGrpOrder=" + renGrpOrder + ", renGrpOclass=" + renGrpOclass + ", renGroupCurrency="
				+ renGroupCurrency + ", renGrpDef=" + renGrpDef + ", requal=" + requal + ", generateRenewOffers="
				+ generateRenewOffers + ", volumeGroupId=" + volumeGroupId + ", inclPkgMembers=" + inclPkgMembers
				+ ", promotions=" + promotions + ", allInstallmentPlans=" + allInstallmentPlans + ", allCreditCards="
				+ allCreditCards + ", customerType=" + customerType + ", allProspectCategories=" + allProspectCategories
				+ ", multiplePerCustomer=" + multiplePerCustomer + ", ocId=" + ocId + ", inclAuditParagraphReports="
				+ inclAuditParagraphReports + ", batchTemplate=" + batchTemplate + ", coMail=" + coMail
				+ ", allListRentalCategories=" + allListRentalCategories + ", invServeLabel=" + invServeLabel
				+ ", writeReconDtl=" + writeReconDtl + ", icsBankDefId=" + icsBankDefId + ", updReconTables="
				+ updReconTables + ", itemsPerRequest=" + itemsPerRequest + ", jobCompletionEmailAddress="
				+ jobCompletionEmailAddress + ", auditParagraphIgnoreBackIs=" + auditParagraphIgnoreBackIs
				+ ", fromEmailAddress=" + fromEmailAddress + ", manualReviewFulfillment=" + manualReviewFulfillment
				+ ", autoRenewExpireDays=" + autoRenewExpireDays + ", onHoldEmail=" + onHoldEmail
				+ ", outputReadyEmail=" + outputReadyEmail + ", reviewReadyEmail=" + reviewReadyEmail
				+ ", jobDoneEmail=" + jobDoneEmail + ", warningEmail=" + warningEmail + ", fatal_email=" + fatal_email
				+ ", noConnectEmail=" + noConnectEmail + ", notification=" + notification + ", cleanupEvents="
				+ cleanupEvents + ", startDateTime=" + startDateTime + ", renewalDef=" + renewalDef
				+ ", generateSourceCode=" + generateSourceCode + ", renewalCardId=" +renewalCardId+ ",renewalDefTestDesc="+renewalDefTestDesc+"]";
	}
	
}
	