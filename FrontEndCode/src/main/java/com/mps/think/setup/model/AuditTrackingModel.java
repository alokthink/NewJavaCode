package com.mps.think.setup.model;

public class AuditTrackingModel {
	private int ocId;
	private String issn;
	private String inheritedFrom;
	private String convertedTo;
	private int startType;
	private int audited;
	private int qpSubTypeRequired;
	private int qpQulSourceRequired;
	private int qpNameTitleRequired;
	private int qpSalesChannelRequired;
	private int qpMaxBackStartsOnNew;
	private int qpMaxBackIssuesOnReinstant;
	private int qpBackIssuesOnReinstant;
	private int qfSubTypeRequired;
	private int qfQualSourceRequired;
	private int qfNameTitleRequired;
	private int qfSalesChannelRequired;
	private int qfMaxBackStartsOnNew;
	private int qfMaxBackIssuesOnReinstant;
	private int qfBackIssuesOnReinstant;
	private int nqpSubTypeRequired;
	private int nqpQulSourceRequired;
	private int nqpNameTitleRequired;
	private int nqpSalesChannelRequired;
	private int nqpMaxBackStartsOnNew;
	private int nqpMaxBackIssuesOnReinstant;
	private int nqpBackIssuesOnReinstant;
	private int nqfSubTypeRequired;
	private int nqfQulSourceRequired;
	private int nqfNameTitleRequired;
	private int nqfSalesChannelRequired;
	private int nqfMaxBackStartsOnNew;
	private int nqfMaxBackIssuesOnReinstant;
	private int nqfBackIssuesOnReinstant;
	private int NumOfIssues;
	private int NumCalenderUnits;
	private int calenderUnits;
	private String onString;
	private int onCalenderUnit;
	private int onDay;
	private String volumeCaption;
	private int volumeFormat;
	private String volumeChangeDate;
	private String issueCaption;
	private int issueFormat;
	private int issueContinuous;
	private int NIssuesPerVolume;
	private int startDateTypeAnytime;
	private int backStartNIssuesAnytime;
	private int startDateTypeVolumeGroup;
	private int unitAudits;
	private Double annualRate;
	private String regionList;
	private String salesChannelPubGroup;
	private String nameTitlePubGroup;
	private String qualSourcePubGroup;
	private String subTypePubGroup;
	private int addKillReport;
	private boolean qp;
	private boolean qf;
	private boolean nqp;
	private boolean nqf;
	private String durationPubGroup;
	private String pricePubGroup;
	private String demoPubGroup;
	private int qpPromptForBackIssues;
	private int qfPromptForBackIssues;
	private int nqpPromptForBackIssues;
	private int nqfPromptForBackIssues;
	private int NoSpacesInEnumeration;
	private int accuralTimeUnit;
	private int accuralTime;
	private int revenueMethod;
	private int startDateTypeDateBased;
	private int startNDaysDateBased;
	private int suppressEnumeration;
	private int maxQualDateAge;
	private String auditPubGroup;
	private String description;
	//private List<DropdownModel> addAllPubGroup = new ArrayList<>();
	public int getOcId() {
		return ocId;
	}
	public void setOcId(int ocId) {
		this.ocId = ocId;
	}
	public String getIssn() {
		return issn;
	}
	public void setIssn(String issn) {
		this.issn = issn;
	}
	public String getInheritedFrom() {
		return inheritedFrom;
	}
	public void setInheritedFrom(String inheritedFrom) {
		this.inheritedFrom = inheritedFrom;
	}
	public String getConvertedTo() {
		return convertedTo;
	}
	public void setConvertedTo(String convertedTo) {
		this.convertedTo = convertedTo;
	}
	public int getStartType() {
		return startType;
	}
	public void setStartType(int startType) {
		this.startType = startType;
	}
	public int getAudited() {
		return audited;
	}
	public void setAudited(int audited) {
		this.audited = audited;
	}
	public int getQpSubTypeRequired() {
		return qpSubTypeRequired;
	}
	public void setQpSubTypeRequired(int qpSubTypeRequired) {
		this.qpSubTypeRequired = qpSubTypeRequired;
	}
	public int getQpQulSourceRequired() {
		return qpQulSourceRequired;
	}
	public void setQpQulSourceRequired(int qpQulSourceRequired) {
		this.qpQulSourceRequired = qpQulSourceRequired;
	}
	public int getQpNameTitleRequired() {
		return qpNameTitleRequired;
	}
	public void setQpNameTitleRequired(int qpNameTitleRequired) {
		this.qpNameTitleRequired = qpNameTitleRequired;
	}
	public int getQpSalesChannelRequired() {
		return qpSalesChannelRequired;
	}
	public void setQpSalesChannelRequired(int qpSalesChannelRequired) {
		this.qpSalesChannelRequired = qpSalesChannelRequired;
	}
	public int getQpMaxBackStartsOnNew() {
		return qpMaxBackStartsOnNew;
	}
	public void setQpMaxBackStartsOnNew(int qpMaxBackStartsOnNew) {
		this.qpMaxBackStartsOnNew = qpMaxBackStartsOnNew;
	}
	public int getQpMaxBackIssuesOnReinstant() {
		return qpMaxBackIssuesOnReinstant;
	}
	public void setQpMaxBackIssuesOnReinstant(int qpMaxBackIssuesOnReinstant) {
		this.qpMaxBackIssuesOnReinstant = qpMaxBackIssuesOnReinstant;
	}
	public int getQpBackIssuesOnReinstant() {
		return qpBackIssuesOnReinstant;
	}
	public void setQpBackIssuesOnReinstant(int qpBackIssuesOnReinstant) {
		this.qpBackIssuesOnReinstant = qpBackIssuesOnReinstant;
	}
	public int getQfSubTypeRequired() {
		return qfSubTypeRequired;
	}
	public void setQfSubTypeRequired(int qfSubTypeRequired) {
		this.qfSubTypeRequired = qfSubTypeRequired;
	}
	public int getQfQualSourceRequired() {
		return qfQualSourceRequired;
	}
	public void setQfQualSourceRequired(int qfQualSourceRequired) {
		this.qfQualSourceRequired = qfQualSourceRequired;
	}
	public int getQfNameTitleRequired() {
		return qfNameTitleRequired;
	}
	public void setQfNameTitleRequired(int qfNameTitleRequired) {
		this.qfNameTitleRequired = qfNameTitleRequired;
	}
	public int getQfSalesChannelRequired() {
		return qfSalesChannelRequired;
	}
	public void setQfSalesChannelRequired(int qfSalesChannelRequired) {
		this.qfSalesChannelRequired = qfSalesChannelRequired;
	}
	public int getQfMaxBackStartsOnNew() {
		return qfMaxBackStartsOnNew;
	}
	public void setQfMaxBackStartsOnNew(int qfMaxBackStartsOnNew) {
		this.qfMaxBackStartsOnNew = qfMaxBackStartsOnNew;
	}
	public int getQfMaxBackIssuesOnReinstant() {
		return qfMaxBackIssuesOnReinstant;
	}
	public void setQfMaxBackIssuesOnReinstant(int qfMaxBackIssuesOnReinstant) {
		this.qfMaxBackIssuesOnReinstant = qfMaxBackIssuesOnReinstant;
	}
	public int getQfBackIssuesOnReinstant() {
		return qfBackIssuesOnReinstant;
	}
	public void setQfBackIssuesOnReinstant(int qfBackIssuesOnReinstant) {
		this.qfBackIssuesOnReinstant = qfBackIssuesOnReinstant;
	}
	public int getNqpSubTypeRequired() {
		return nqpSubTypeRequired;
	}
	public void setNqpSubTypeRequired(int nqpSubTypeRequired) {
		this.nqpSubTypeRequired = nqpSubTypeRequired;
	}
	public int getNqpQulSourceRequired() {
		return nqpQulSourceRequired;
	}
	public void setNqpQulSourceRequired(int nqpQulSourceRequired) {
		this.nqpQulSourceRequired = nqpQulSourceRequired;
	}
	public int getNqpNameTitleRequired() {
		return nqpNameTitleRequired;
	}
	public void setNqpNameTitleRequired(int nqpNameTitleRequired) {
		this.nqpNameTitleRequired = nqpNameTitleRequired;
	}
	public int getNqpSalesChannelRequired() {
		return nqpSalesChannelRequired;
	}
	public void setNqpSalesChannelRequired(int nqpSalesChannelRequired) {
		this.nqpSalesChannelRequired = nqpSalesChannelRequired;
	}
	public int getNqpMaxBackStartsOnNew() {
		return nqpMaxBackStartsOnNew;
	}
	public void setNqpMaxBackStartsOnNew(int nqpMaxBackStartsOnNew) {
		this.nqpMaxBackStartsOnNew = nqpMaxBackStartsOnNew;
	}
	public int getNqpMaxBackIssuesOnReinstant() {
		return nqpMaxBackIssuesOnReinstant;
	}
	public void setNqpMaxBackIssuesOnReinstant(int nqpMaxBackIssuesOnReinstant) {
		this.nqpMaxBackIssuesOnReinstant = nqpMaxBackIssuesOnReinstant;
	}
	public int getNqpBackIssuesOnReinstant() {
		return nqpBackIssuesOnReinstant;
	}
	public void setNqpBackIssuesOnReinstant(int nqpBackIssuesOnReinstant) {
		this.nqpBackIssuesOnReinstant = nqpBackIssuesOnReinstant;
	}
	public int getNqfSubTypeRequired() {
		return nqfSubTypeRequired;
	}
	public void setNqfSubTypeRequired(int nqfSubTypeRequired) {
		this.nqfSubTypeRequired = nqfSubTypeRequired;
	}
	public int getNqfQulSourceRequired() {
		return nqfQulSourceRequired;
	}
	public void setNqfQulSourceRequired(int nqfQulSourceRequired) {
		this.nqfQulSourceRequired = nqfQulSourceRequired;
	}
	public int getNqfNameTitleRequired() {
		return nqfNameTitleRequired;
	}
	public void setNqfNameTitleRequired(int nqfNameTitleRequired) {
		this.nqfNameTitleRequired = nqfNameTitleRequired;
	}
	public int getNqfSalesChannelRequired() {
		return nqfSalesChannelRequired;
	}
	public void setNqfSalesChannelRequired(int nqfSalesChannelRequired) {
		this.nqfSalesChannelRequired = nqfSalesChannelRequired;
	}
	public int getNqfMaxBackStartsOnNew() {
		return nqfMaxBackStartsOnNew;
	}
	public void setNqfMaxBackStartsOnNew(int nqfMaxBackStartsOnNew) {
		this.nqfMaxBackStartsOnNew = nqfMaxBackStartsOnNew;
	}
	public int getNqfMaxBackIssuesOnReinstant() {
		return nqfMaxBackIssuesOnReinstant;
	}
	public void setNqfMaxBackIssuesOnReinstant(int nqfMaxBackIssuesOnReinstant) {
		this.nqfMaxBackIssuesOnReinstant = nqfMaxBackIssuesOnReinstant;
	}
	public int getNqfBackIssuesOnReinstant() {
		return nqfBackIssuesOnReinstant;
	}
	public void setNqfBackIssuesOnReinstant(int nqfBackIssuesOnReinstant) {
		this.nqfBackIssuesOnReinstant = nqfBackIssuesOnReinstant;
	}
	public int getNumOfIssues() {
		return NumOfIssues;
	}
	public void setNumOfIssues(int numOfIssues) {
		NumOfIssues = numOfIssues;
	}
	public int getNumCalenderUnits() {
		return NumCalenderUnits;
	}
	public void setNumCalenderUnits(int numCalenderUnits) {
		NumCalenderUnits = numCalenderUnits;
	}
	public int getCalenderUnits() {
		return calenderUnits;
	}
	public void setCalenderUnits(int calenderUnits) {
		this.calenderUnits = calenderUnits;
	}
	public String getOnString() {
		return onString;
	}
	public void setOnString(String onString) {
		this.onString = onString;
	}
	public int getOnCalenderUnit() {
		return onCalenderUnit;
	}
	public void setOnCalenderUnit(int onCalenderUnit) {
		this.onCalenderUnit = onCalenderUnit;
	}
	public int getOnDay() {
		return onDay;
	}
	public void setOnDay(int onDay) {
		this.onDay = onDay;
	}
	public String getVolumeCaption() {
		return volumeCaption;
	}
	public void setVolumeCaption(String volumeCaption) {
		this.volumeCaption = volumeCaption;
	}
	public int getVolumeFormat() {
		return volumeFormat;
	}
	public void setVolumeFormat(int volumeFormat) {
		this.volumeFormat = volumeFormat;
	}
	public String getVolumeChangeDate() {
		return volumeChangeDate;
	}
	public void setVolumeChangeDate(String volumeChangeDate) {
		this.volumeChangeDate = volumeChangeDate;
	}
	public String getIssueCaption() {
		return issueCaption;
	}
	public void setIssueCaption(String issueCaption) {
		this.issueCaption = issueCaption;
	}
	public int getIssueFormat() {
		return issueFormat;
	}
	public void setIssueFormat(int issueFormat) {
		this.issueFormat = issueFormat;
	}
	public int getIssueContinuous() {
		return issueContinuous;
	}
	public void setIssueContinuous(int issueContinuous) {
		this.issueContinuous = issueContinuous;
	}
	public int getNIssuesPerVolume() {
		return NIssuesPerVolume;
	}
	public void setNIssuesPerVolume(int nIssuesPerVolume) {
		NIssuesPerVolume = nIssuesPerVolume;
	}
	public int getStartDateTypeAnytime() {
		return startDateTypeAnytime;
	}
	public void setStartDateTypeAnytime(int startDateTypeAnytime) {
		this.startDateTypeAnytime = startDateTypeAnytime;
	}
	public int getBackStartNIssuesAnytime() {
		return backStartNIssuesAnytime;
	}
	public void setBackStartNIssuesAnytime(int backStartNIssuesAnytime) {
		this.backStartNIssuesAnytime = backStartNIssuesAnytime;
	}
	public int getStartDateTypeVolumeGroup() {
		return startDateTypeVolumeGroup;
	}
	public void setStartDateTypeVolumeGroup(int startDateTypeVolumeGroup) {
		this.startDateTypeVolumeGroup = startDateTypeVolumeGroup;
	}
	public int getUnitAudits() {
		return unitAudits;
	}
	public void setUnitAudits(int unitAudits) {
		this.unitAudits = unitAudits;
	}
	public Double getAnnualRate() {
		return annualRate;
	}
	public void setAnnualRate(Double annualRate) {
		this.annualRate = annualRate;
	}
	public String getRegionList() {
		return regionList;
	}
	public void setRegionList(String regionList) {
		this.regionList = regionList;
	}
	public String getSalesChannelPubGroup() {
		return salesChannelPubGroup;
	}
	public void setSalesChannelPubGroup(String salesChannelPubGroup) {
		this.salesChannelPubGroup = salesChannelPubGroup;
	}
	public String getNameTitlePubGroup() {
		return nameTitlePubGroup;
	}
	public void setNameTitlePubGroup(String nameTitlePubGroup) {
		this.nameTitlePubGroup = nameTitlePubGroup;
	}
	public String getQualSourcePubGroup() {
		return qualSourcePubGroup;
	}
	public void setQualSourcePubGroup(String qualSourcePubGroup) {
		this.qualSourcePubGroup = qualSourcePubGroup;
	}
	public String getSubTypePubGroup() {
		return subTypePubGroup;
	}
	public void setSubTypePubGroup(String subTypePubGroup) {
		this.subTypePubGroup = subTypePubGroup;
	}
	public int getAddKillReport() {
		return addKillReport;
	}
	public void setAddKillReport(int addKillReport) {
		this.addKillReport = addKillReport;
	}
	public boolean isQp() {
		return qp;
	}
	public void setQp(boolean qp) {
		this.qp = qp;
	}
	public boolean isQf() {
		return qf;
	}
	public void setQf(boolean qf) {
		this.qf = qf;
	}
	public boolean isNqp() {
		return nqp;
	}
	public void setNqp(boolean nqp) {
		this.nqp = nqp;
	}
	public boolean isNqf() {
		return nqf;
	}
	public void setNqf(boolean nqf) {
		this.nqf = nqf;
	}
	public String getDurationPubGroup() {
		return durationPubGroup;
	}
	public void setDurationPubGroup(String durationPubGroup) {
		this.durationPubGroup = durationPubGroup;
	}
	public String getPricePubGroup() {
		return pricePubGroup;
	}
	public void setPricePubGroup(String pricePubGroup) {
		this.pricePubGroup = pricePubGroup;
	}
	public String getDemoPubGroup() {
		return demoPubGroup;
	}
	public void setDemoPubGroup(String demoPubGroup) {
		this.demoPubGroup = demoPubGroup;
	}
	public int getQpPromptForBackIssues() {
		return qpPromptForBackIssues;
	}
	public void setQpPromptForBackIssues(int qpPromptForBackIssues) {
		this.qpPromptForBackIssues = qpPromptForBackIssues;
	}
	public int getQfPromptForBackIssues() {
		return qfPromptForBackIssues;
	}
	public void setQfPromptForBackIssues(int qfPromptForBackIssues) {
		this.qfPromptForBackIssues = qfPromptForBackIssues;
	}
	public int getNqpPromptForBackIssues() {
		return nqpPromptForBackIssues;
	}
	public void setNqpPromptForBackIssues(int nqpPromptForBackIssues) {
		this.nqpPromptForBackIssues = nqpPromptForBackIssues;
	}
	public int getNqfPromptForBackIssues() {
		return nqfPromptForBackIssues;
	}
	public void setNqfPromptForBackIssues(int nqfPromptForBackIssues) {
		this.nqfPromptForBackIssues = nqfPromptForBackIssues;
	}
	public int getNoSpacesInEnumeration() {
		return NoSpacesInEnumeration;
	}
	public void setNoSpacesInEnumeration(int noSpacesInEnumeration) {
		NoSpacesInEnumeration = noSpacesInEnumeration;
	}
	public int getAccuralTimeUnit() {
		return accuralTimeUnit;
	}
	public void setAccuralTimeUnit(int accuralTimeUnit) {
		this.accuralTimeUnit = accuralTimeUnit;
	}
	public int getAccuralTime() {
		return accuralTime;
	}
	public void setAccuralTime(int accuralTime) {
		this.accuralTime = accuralTime;
	}
	public int getRevenueMethod() {
		return revenueMethod;
	}
	public void setRevenueMethod(int revenueMethod) {
		this.revenueMethod = revenueMethod;
	}
	public int getStartDateTypeDateBased() {
		return startDateTypeDateBased;
	}
	public void setStartDateTypeDateBased(int startDateTypeDateBased) {
		this.startDateTypeDateBased = startDateTypeDateBased;
	}
	public int getStartNDaysDateBased() {
		return startNDaysDateBased;
	}
	public void setStartNDaysDateBased(int startNDaysDateBased) {
		this.startNDaysDateBased = startNDaysDateBased;
	}
	public int getSuppressEnumeration() {
		return suppressEnumeration;
	}
	public void setSuppressEnumeration(int suppressEnumeration) {
		this.suppressEnumeration = suppressEnumeration;
	}
	public int getMaxQualDateAge() {
		return maxQualDateAge;
	}
	public void setMaxQualDateAge(int maxQualDateAge) {
		this.maxQualDateAge = maxQualDateAge;
	}
	public String getAuditPubGroup() {
		return auditPubGroup;
	}
	public void setAuditPubGroup(String auditPubGroup) {
		this.auditPubGroup = auditPubGroup;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
