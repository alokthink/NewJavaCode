package com.mps.think.setup.tablesetup.model;

public class TableSetupOrdersModel {

	
	private String cancelReason;
	private String cancelReasonDescription;
	private int cancelType;
	private boolean appliesToAnyOc;
	private boolean active;

	private int cancelPolicyId;
	private String cancelPolicyDescription;
	private int rangeType;
	private double penality;
	private int mruCancelPolicyDetailsSeq;
	
	private String orderCode;
	private int orderCodeId;
	private String description;
	private int orderCodeType;
	private int premium;
	//private int active;
	private int allowOnInternet;
	private int controlled;
	private int autoRenew;
	private int autoReplace;
	private int ocId;
	private String userCode;
	
	private String search;
	private int searchFieldGroupSeq;
	private String displayContext;
	private String exampleText;
	private int  searchResultDisplaySeq;
	private int applicationResultAction;
    private String orderCategory;
    //private String des
    private int subscriptionCategoryId;
    private String taxonomy;
    private int termId;
    private String term;
    private int calenderUnit;
    private int nCalenderUnits;
    private int nIssues;
    private int numVolumeSets;
    private int disallowInstallBilling;
    private int nCalenderUnitsPerSegmnt;
    private int nItemsPerSegment;
    private int maxCheckAmount;
    private int startType;
    private int unitTypeId;
    private String label;
    private int upsellSuggestionId;
    private int calenderCampaignId;
    private int beginDay;
    private int beginmonth;
    private String campaign;
    private int endDay;
    private int endMonth;
    
   public int getUpsellSuggestionId() {
		return upsellSuggestionId;
	}

	public void setUpsellSuggestionId(int upsellSuggestionId) {
		this.upsellSuggestionId = upsellSuggestionId;
	}

	public int getUnitTypeId() {
		return unitTypeId;
	}

	public void setUnitTypeId(int unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getTermId() {
		return termId;
	}

	public void setTermId(int termId) {
		this.termId = termId;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getCalenderUnit() {
		return calenderUnit;
	}

	public void setCalenderUnit(int calenderUnit) {
		this.calenderUnit = calenderUnit;
	}

	public int getnCalenderUnits() {
		return nCalenderUnits;
	}

	public void setnCalenderUnits(int nCalenderUnits) {
		this.nCalenderUnits = nCalenderUnits;
	}

	public int getnIssues() {
		return nIssues;
	}

	public void setnIssues(int nIssues) {
		this.nIssues = nIssues;
	}

	public int getNumVolumeSets() {
		return numVolumeSets;
	}

	public void setNumVolumeSets(int numVolumeSets) {
		this.numVolumeSets = numVolumeSets;
	}

	public int getDisallowInstallBilling() {
		return disallowInstallBilling;
	}

	public void setDisallowInstallBilling(int disallowInstallBilling) {
		this.disallowInstallBilling = disallowInstallBilling;
	}

	public int getnCalenderUnitsPerSegmnt() {
		return nCalenderUnitsPerSegmnt;
	}

	public void setnCalenderUnitsPerSegmnt(int nCalenderUnitsPerSegmnt) {
		this.nCalenderUnitsPerSegmnt = nCalenderUnitsPerSegmnt;
	}

	public int getnItemsPerSegment() {
		return nItemsPerSegment;
	}

	public void setnItemsPerSegment(int nItemsPerSegment) {
		this.nItemsPerSegment = nItemsPerSegment;
	}

	public int getMaxCheckAmount() {
		return maxCheckAmount;
	}

	public void setMaxCheckAmount(int maxCheckAmount) {
		this.maxCheckAmount = maxCheckAmount;
	}

	public int getStartType() {
		return startType;
	}

	public void setStartType(int startType) {
		this.startType = startType;
	}

	
  
  
    
	public String getTaxonomy() {
		return taxonomy;
	}

	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}

	public int getSubscriptionCategoryId() {
		return subscriptionCategoryId;
	}

	public void setSubscriptionCategoryId(int subscriptionCategoryId) {
		this.subscriptionCategoryId = subscriptionCategoryId;
	}

	public String getSearch() {
		return search;
	}

	public String getOrderCategory() {
		return orderCategory;
	}

	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getSearchFieldGroupSeq() {
		return searchFieldGroupSeq;
	}

	public void setSearchFieldGroupSeq(int searchFieldGroupSeq) {
		this.searchFieldGroupSeq = searchFieldGroupSeq;
	}

	public String getDisplayContext() {
		return displayContext;
	}

	public void setDisplayContext(String displayContext) {
		this.displayContext = displayContext;
	}

	public String getExampleText() {
		return exampleText;
	}

	public void setExampleText(String exampleText) {
		this.exampleText = exampleText;
	}

	public int getSearchResultDisplaySeq() {
		return searchResultDisplaySeq;
	}

	public void setSearchResultDisplaySeq(int searchResultDisplaySeq) {
		this.searchResultDisplaySeq = searchResultDisplaySeq;
	}

	public int getApplicationResultAction() {
		return applicationResultAction;
	}

	public void setApplicationResultAction(int applicationResultAction) {
		this.applicationResultAction = applicationResultAction;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelReasonDescription() {
		return cancelReasonDescription;
	}

	public void setCancelReasonDescription(String cancelReasonDescription) {
		this.cancelReasonDescription = cancelReasonDescription;
	}

	public int getCancelType() {
		return cancelType;
	}

	public void setCancelType(int cancelType) {
		this.cancelType = cancelType;
	}

	public boolean isAppliesToAnyOc() {
		return appliesToAnyOc;
	}

	public void setAppliesToAnyOc(boolean appliesToAnyOc) {
		this.appliesToAnyOc = appliesToAnyOc;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;

	}

	public int getCancelPolicyId() {
		return cancelPolicyId;
	}

	public void setCancelPolicyId(int cancelPolicyId) {
		this.cancelPolicyId = cancelPolicyId;
	}

	public String getCancelPolicyDescription() {
		return cancelPolicyDescription;
	}

	public void setCancelPolicyDescription(String cancelPolicyDescription) {
		this.cancelPolicyDescription = cancelPolicyDescription;
	}

	public int getRangeType() {
		return rangeType;
	}

	public void setRangeType(int rangeType) {
		this.rangeType = rangeType;
	}

	public double getPenality() {
		return penality;
	}

	public void setPenality(double penality) {
		this.penality = penality;
	}

	public int getMruCancelPolicyDetailsSeq() {
		return mruCancelPolicyDetailsSeq;
	}

	public void setMruCancelPolicyDetailsSeq(int mruCancelPolicyDetailsSeq) {
		this.mruCancelPolicyDetailsSeq = mruCancelPolicyDetailsSeq;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrderCodeType() {
		return orderCodeType;
	}

	public void setOrderCodeType(int orderCodeType) {
		this.orderCodeType = orderCodeType;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public int getAllowOnInternet() {
		return allowOnInternet;
	}

	public void setAllowOnInternet(int allowOnInternet) {
		this.allowOnInternet = allowOnInternet;
	}

	public int getControlled() {
		return controlled;
	}

	public void setControlled(int controlled) {
		this.controlled = controlled;
	}

	public int getAutoRenew() {
		return autoRenew;
	}

	public void setAutoRenew(int autoRenew) {
		this.autoRenew = autoRenew;
	}

	public int getAutoReplace() {
		return autoReplace;
	}

	public void setAutoReplace(int autoReplace) {
		this.autoReplace = autoReplace;
	}

	public int getOrderCodeId() {
		return orderCodeId;
	}

	public void setOrderCodeId(int orderCodeId) {
		this.orderCodeId = orderCodeId;
	}

	public int getOcId() {
		return ocId;
	}

	public void setOcId(int ocId) {
		this.ocId = ocId;
	}

	public int getCalenderCampaignId() {
		return calenderCampaignId;
	}

	public void setCalenderCampaignId(int calenderCampaignId) {
		this.calenderCampaignId = calenderCampaignId;
	}

	public int getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(int beginDay) {
		this.beginDay = beginDay;
	}

	public int getBeginmonth() {
		return beginmonth;
	}

	public void setBeginmonth(int beginmonth) {
		this.beginmonth = beginmonth;
	}

	public String getCampaign() {
		return campaign;
	}

	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
	
	
}
