package com.mps.think.model;

import java.util.List;

public class CustomerAddAttributeModel {
	
	private String salutation;
	private String fName;
	private String initial;
	private String lName;
	private String suffix;
	private String title;
	private String company;
	private String department;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String county;
	private String phone1;
	private String phone2;
	private String fax;
	private String email;
	private String oldEmail;
	private String addressType;
	private String taxID;
	private String specialTaxId;
	private String listRental;
	private String customerCategory;
	private String sales;
	private String addressStatus;
	private String creditStatus;
	private String institutionalIdentifier;
	private String parentInstitutionalIdentifier;
	private String isAgency;
	private String isGroup;
	private String isDistributor;
	private String isProspect;
	private String agencyCode;
	private Long customerId;
	private Long documentReferenceId;
	private String agencyName;
	private String paymentThershold;
	private String bundleDiscount;
	private String isRenewTo;
	private String isBillTo;
	private String agencyPayTax;
	private int remits;
	private int taxPayedOnGross;
	private Integer newOrderCommission;
	private Integer renewalCommission;
	private String distributor;
	private Long parent;
	private String distributorURL;
	private Integer prospectSequence;
	private String creationDate;
	private int activeProspect;
	private String qualDate;
	private int orderClass;
	private String prospectCategory;
	private String sourceCode;
	private String referredBY;
	private String reportPrefix;
	private String sequenceAddress;
	private String oldCustomerId;
	private String billTo;
	private String defaultAddress;
	private String renewTo;
	private List<DropdownModel> stateList;
	private List<DropdownModel> addressTypeList;
	private List<DropdownModel> listRentalList ;
	private List<DropdownModel> customerCategoryList;
	private List<DropdownModel> salesRepresentativeList;
	private List<DropdownModel> addressStatusList;
	private List<DropdownModel> creditStatusList;
	private List<DropdownModel> taxFilterList;
	private List<DropdownModel> defaultAddressList;
	List<DropdownModel> paymentThersholdList;
	private int customerAddressSeq;
	private String fullName;
	private Long changeAddress;
	private String to;
	private String from;
	private String futureOrTemp;
	private String userCode;
	private String setGroupMember;
	private String customerGroupCustomerId;
	private String authorized;
	private String nCopies;
	private String auditQualCategory;
	private String ocId;
	private String active;
	private String customerGroup;
	private String auditNameTitleId;   
	private String auditSourceId;    
	private String auditSalesChannelId;     
	private String auditSubscriptionTypeId; 
	private String group;
	//Added By Sohrab for Adding Distributor Report & Attribute 
	private int reportType;
	private int format;
	private String output;
	private int fileType;
	private String filePrefix;
	private String fileName;
	private int transmitBy;
	private int reportTypeOld;
	private String method;
	private String attribute;
	private String old_method;
	private String old_attribute;
	private int audited;
	private int prospectOnly;
	private int customerNote;
	//Added By Sohrab for Email_Authorization button on Add Customer Page
	private String business_processes;
	
	
	public String getBusiness_processes() {
		return business_processes;
	}
	public void setBusiness_processes(String business_processes) {
		this.business_processes = business_processes;
	}
	public List<DropdownModel> getPaymentThersholdList() {
		return paymentThersholdList;
	}
	public void setPaymentThersholdList(List<DropdownModel> paymentThersholdList) {
		this.paymentThersholdList = paymentThersholdList;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getState() {
		return state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOldEmail() {
		return oldEmail;
	}
	public void setOldEmail(String oldEmail) {
		this.oldEmail = oldEmail;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public String getSpecialTaxId() {
		return specialTaxId;
	}
	public void setSpecialTaxId(String specialTaxId) {
		this.specialTaxId = specialTaxId;
	}
	public String getListRental() {
		return listRental;
	}
	public void setListRental(String listRental) {
		this.listRental = listRental;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getAddressStatus() {
		return addressStatus;
	}
	public void setAddressStatus(String addressStatus) {
		this.addressStatus = addressStatus;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getInstitutionalIdentifier() {
		return institutionalIdentifier;
	}
	public void setInstitutionalIdentifier(String institutionalIdentifier) {
		this.institutionalIdentifier = institutionalIdentifier;
	}
	public String getParentInstitutionalIdentifier() {
		return parentInstitutionalIdentifier;
	}
	public void setParentInstitutionalIdentifier(String parentInstitutionalIdentifier) {
		this.parentInstitutionalIdentifier = parentInstitutionalIdentifier;
	}
	public String getIsAgency() {
		return isAgency;
	}
	public void setIsAgency(String isAgency) {
		this.isAgency = isAgency;
	}
	public String getIsGroup() {
		return isGroup;
	}
	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}
	public String getIsDistributor() {
		return isDistributor;
	}
	public void setIsDistributor(String isDistributor) {
		this.isDistributor = isDistributor;
	}
	public String getIsProspect() {
		return isProspect;
	}
	public void setIsProspect(String isProspect) {
		this.isProspect = isProspect;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getPaymentThershold() {
		return paymentThershold;
	}
	public void setPaymentThershold(String paymentThershold) {
		this.paymentThershold = paymentThershold;
	}
	public String getBundleDiscount() {
		return bundleDiscount;
	}
	public void setBundleDiscount(String bundleDiscount) {
		this.bundleDiscount = bundleDiscount;
	}
	public String getIsRenewTo() {
		return isRenewTo;
	}
	public void setIsRenewTo(String isRenewTo) {
		this.isRenewTo = isRenewTo;
	}
	public String getIsBillTo() {
		return isBillTo;
	}
	public void setIsBillTo(String isBillTo) {
		this.isBillTo = isBillTo;
	}
	public String getAgencyPayTax() {
		return agencyPayTax;
	}
	public void setAgencyPayTax(String agencyPayTax) {
		this.agencyPayTax = agencyPayTax;
	}
	public int getRemits() {
		return remits;
	}
	public void setRemits(int remits) {
		this.remits = remits;
	}
	public int getTaxPayedOnGross() {
		return taxPayedOnGross;
	}
	public void setTaxPayedOnGross(int taxPayedOnGross) {
		this.taxPayedOnGross = taxPayedOnGross;
	}
	public Integer getNewOrderCommission() {
		return newOrderCommission;
	}
	public void setNewOrderCommission(Integer newOrderCommission) {
		this.newOrderCommission = newOrderCommission;
	}
	public Integer getRenewalCommission() {
		return renewalCommission;
	}
	public void setRenewalCommission(Integer renewalCommission) {
		this.renewalCommission = renewalCommission;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	
	public Long getParent() {
		return parent;
	}
	public void setParent(Long parent) {
		this.parent = parent;
	}
	public String getDistributorURL() {
		return distributorURL;
	}
	public void setDistributorURL(String distributorURL) {
		this.distributorURL = distributorURL;
	}
	public Integer getProspectSequence() {
		return prospectSequence;
	}
	public void setProspectSequence(Integer prospectSequence) {
		this.prospectSequence = prospectSequence;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public int getActiveProspect() {
		return activeProspect;
	}
	public void setActiveProspect(int activeProspect) {
		this.activeProspect = activeProspect;
	}
	public String getQualDate() {
		return qualDate;
	}
	public void setQualDate(String qualDate) {
		this.qualDate = qualDate;
	}
	public int getOrderClass() {
		return orderClass;
	}
	public void setOrderClass(int orderClass) {
		this.orderClass = orderClass;
	}
	public String getProspectCategory() {
		return prospectCategory;
	}
	public void setProspectCategory(String prospectCategory) {
		this.prospectCategory = prospectCategory;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	public String getReferredBY() {
		return referredBY;
	}
	public void setReferredBY(String referredBY) {
		this.referredBY = referredBY;
	}
	public String getReportPrefix() {
		return reportPrefix;
	}
	public void setReportPrefix(String reportPrefix) {
		this.reportPrefix = reportPrefix;
	}
	public String getSequenceAddress() {
		return sequenceAddress;
	}
	public void setSequenceAddress(String sequenceAddress) {
		this.sequenceAddress = sequenceAddress;
	}
	public String getOldCustomerId() {
		return oldCustomerId;
	}
	public void setOldCustomerId(String oldCustomerId) {
		this.oldCustomerId = oldCustomerId;
	}
	public String getBillTo() {
		return billTo;
	}
	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}
	public String getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(String defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	public String getRenewTo() {
		return renewTo;
	}
	public void setRenewTo(String renewTo) {
		this.renewTo = renewTo;
	}
	public List<DropdownModel> getStateList() {
		return stateList;
	}
	public void setStateList(List<DropdownModel> stateList) {
		this.stateList = stateList;
	}
	public List<DropdownModel> getAddressTypeList() {
		return addressTypeList;
	}
	public void setAddressTypeList(List<DropdownModel> addressTypeList) {
		this.addressTypeList = addressTypeList;
	}
	public List<DropdownModel> getListRentalList() {
		return listRentalList;
	}
	public void setListRentalList(List<DropdownModel> listRentalList) {
		this.listRentalList = listRentalList;
	}
	public List<DropdownModel> getCustomerCategoryList() {
		return customerCategoryList;
	}
	public void setCustomerCategoryList(List<DropdownModel> customerCategoryList) {
		this.customerCategoryList = customerCategoryList;
	}
	public List<DropdownModel> getSalesRepresentativeList() {
		return salesRepresentativeList;
	}
	public void setSalesRepresentativeList(List<DropdownModel> salesRepresentativeList) {
		this.salesRepresentativeList = salesRepresentativeList;
	}
	public List<DropdownModel> getAddressStatusList() {
		return addressStatusList;
	}
	public void setAddressStatusList(List<DropdownModel> addressStatusList) {
		this.addressStatusList = addressStatusList;
	}
	public List<DropdownModel> getCreditStatusList() {
		return creditStatusList;
	}
	public void setCreditStatusList(List<DropdownModel> creditStatusList) {
		this.creditStatusList = creditStatusList;
	}
	public List<DropdownModel> getTaxFilterList() {
		return taxFilterList;
	}
	public void setTaxFilterList(List<DropdownModel> taxFilterList) {
		this.taxFilterList = taxFilterList;
	}
	public List<DropdownModel> getDefaultAddressList() {
		return defaultAddressList;
	}
	public void setDefaultAddressList(List<DropdownModel> defaultAddressList) {
		this.defaultAddressList = defaultAddressList;
	}
	public int getCustomerAddressSeq() {
		return customerAddressSeq;
	}
	public void setCustomerAddressSeq(int customerAddressSeq) {
		this.customerAddressSeq = customerAddressSeq;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}	
	public Long getChangeAddress() {
		return changeAddress;
	}
	public void setChangeAddress(Long changeAddress) {
		this.changeAddress = changeAddress;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getFutureOrTemp() {
		return futureOrTemp;
	}
	public void setFutureOrTemp(String futureOrTemp) {
		this.futureOrTemp = futureOrTemp;
	}
	public Long getDocumentReferenceId() {
		return documentReferenceId;
	}
	public void setDocumentReferenceId(Long documentReferenceId) {
		this.documentReferenceId = documentReferenceId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getSetGroupMember() {
		return setGroupMember;
	}
	public void setSetGroupMember(String setGroupMember) {
		this.setGroupMember = setGroupMember;
	}
	public String getCustomerGroupCustomerId() {
		return customerGroupCustomerId;
	}
	public void setCustomerGroupCustomerId(String customerGroupCustomerId) {
		this.customerGroupCustomerId = customerGroupCustomerId;
	}
	public String getAuthorized() {
		return authorized;
	}
	public void setAuthorized(String authorized) {
		this.authorized = authorized;
	}
	public String getnCopies() {
		return nCopies;
	}
	public void setnCopies(String nCopies) {
		this.nCopies = nCopies;
	}
	public String getAuditQualCategory() {
		return auditQualCategory;
	}
	public void setAuditQualCategory(String auditQualCategory) {
		this.auditQualCategory = auditQualCategory;
	}
	
	public String getOcId() {
		return ocId;
	}
	public void setOcId(String ocId) {
		this.ocId = ocId;
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	public String getCustomerGroup() {
		return customerGroup;
	}
	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}
	
	public String getAuditNameTitleId() {
		return auditNameTitleId;
	}
	public void setAuditNameTitleId(String auditNameTitleId) {
		this.auditNameTitleId = auditNameTitleId;
	}
	public String getAuditSourceId() {
		return auditSourceId;
	}
	public void setAuditSourceId(String auditSourceId) {
		this.auditSourceId = auditSourceId;
	}
	public String getAuditSalesChannelId() {
		return auditSalesChannelId;
	}
	public void setAuditSalesChannelId(String auditSalesChannelId) {
		this.auditSalesChannelId = auditSalesChannelId;
	}
	public String getAuditSubscriptionTypeId() {
		return auditSubscriptionTypeId;
	}
	public void setAuditSubscriptionTypeId(String auditSubscriptionTypeId) {
		this.auditSubscriptionTypeId = auditSubscriptionTypeId;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	public int getReportType() {
		return reportType;
	}
	public void setReportType(int reportType) {
		this.reportType = reportType;
	}
	public int getFormat() {
		return format;
	}
	public void setFormat(int format) {
		this.format = format;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public int getFileType() {
		return fileType;
	}
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	public String getFilePrefix() {
		return filePrefix;
	}
	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getTransmitBy() {
		return transmitBy;
	}
	public void setTransmitBy(int transmitBy) {
		this.transmitBy = transmitBy;
	}
	
	public int getReportTypeOld() {
		return reportTypeOld;
	}
	public void setReportTypeOld(int reportTypeOld) {
		this.reportTypeOld = reportTypeOld;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getOld_method() {
		return old_method;
	}
	public void setOld_method(String old_method) {
		this.old_method = old_method;
	}
	public String getOld_attribute() {
		return old_attribute;
	}
	public void setOld_attribute(String old_attribute) {
		this.old_attribute = old_attribute;
	}
	public int getAudited() {
		return audited;
	}
	public void setAudited(int audited) {
		this.audited = audited;
	}
	
	public int getCustomerNote() {
		return customerNote;
	}
	public void setCustomerNote(int customerNote) {
		this.customerNote = customerNote;
	}
	public int getProspectOnly() {
		return prospectOnly;
	}
	public void setProspectOnly(int prospectOnly) {
		this.prospectOnly = prospectOnly;
	}
	
	@Override
	public String toString() {
		return "CustomerAddAttributeModel [salutation=" + salutation + ", fName=" + fName + ", initial=" + initial
				+ ", lName=" + lName + ", suffix=" + suffix + ", title=" + title + ", company=" + company
				+ ", department=" + department + ", address1=" + address1 + ", address2=" + address2 + ", address3="
				+ address3 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country
				+ ", county=" + county + ", phone1=" + phone1 + ", phone2=" + phone2 + ", fax=" + fax + ", email="
				+ email + ", oldEmail=" + oldEmail + ", addressType=" + addressType + ", taxID=" + taxID
				+ ", specialTaxId=" + specialTaxId + ", listRental=" + listRental + ", customerCategory="
				+ customerCategory + ", sales=" + sales + ", addressStatus=" + addressStatus + ", creditStatus="
				+ creditStatus + ", institutionalIdentifier=" + institutionalIdentifier
				+ ", parentInstitutionalIdentifier=" + parentInstitutionalIdentifier + ", isAgency=" + isAgency
				+ ", isGroup=" + isGroup + ", isDistributor=" + isDistributor + ", isProspect=" + isProspect
				+ ", agencyCode=" + agencyCode + ", customerId=" + customerId + ", documentReferenceId="
				+ documentReferenceId + ", agencyName=" + agencyName + ", paymentThershold=" + paymentThershold
				+ ", bundleDiscount=" + bundleDiscount + ", isRenewTo=" + isRenewTo + ", isBillTo=" + isBillTo
				+ ", agencyPayTax=" + agencyPayTax + ", remits=" + remits + ", taxPayedOnGross=" + taxPayedOnGross
				+ ", newOrderCommission=" + newOrderCommission + ", renewalCommission=" + renewalCommission
				+ ", distributor=" + distributor + ", parent=" + parent + ", distributorURL=" + distributorURL
				+ ", prospectSequence=" + prospectSequence + ", creationDate=" + creationDate + ", activeProspect="
				+ activeProspect + ", qualDate=" + qualDate + ", orderClass=" + orderClass + ", prospectCategory="
				+ prospectCategory + ", sourceCode=" + sourceCode + ", referredBY=" + referredBY + ", reportPrefix="
				+ reportPrefix + ", sequenceAddress=" + sequenceAddress + ", oldCustomerId=" + oldCustomerId
				+ ", billTo=" + billTo + ", defaultAddress=" + defaultAddress + ", renewTo=" + renewTo + ", stateList="
				+ stateList + ", addressTypeList=" + addressTypeList + ", listRentalList=" + listRentalList
				+ ", customerCategoryList=" + customerCategoryList + ", salesRepresentativeList="
				+ salesRepresentativeList + ", addressStatusList=" + addressStatusList + ", creditStatusList="
				+ creditStatusList + ", taxFilterList=" + taxFilterList + ", defaultAddressList=" + defaultAddressList
				+ ", paymentThersholdList=" + paymentThersholdList + ", customerAddressSeq=" + customerAddressSeq
				+ ", fullName=" + fullName + ", changeAddress=" + changeAddress + ", to=" + to + ", from=" + from
				+ ", futureOrTemp=" + futureOrTemp + ", userCode=" + userCode + ", setGroupMember=" + setGroupMember
				+ ", customerGroupCustomerId=" + customerGroupCustomerId + ", authorized=" + authorized + ", nCopies="
				+ nCopies + ", auditQualCategory=" + auditQualCategory + ", ocId=" + ocId + ", active=" + active
				+ ", customerGroup=" + customerGroup + ", auditNameTitleId=" + auditNameTitleId + ", auditSourceId="
				+ auditSourceId + ", auditSalesChannelId=" + auditSalesChannelId + ", auditSubscriptionTypeId="
				+ auditSubscriptionTypeId + ", group=" + group + ", reportType=" + reportType + ", format=" + format
				+ ", output=" + output + ", fileType=" + fileType + ", filePrefix=" + filePrefix + ", fileName="
				+ fileName + ", transmitBy=" + transmitBy + ", reportTypeOld=" + reportTypeOld + ", method=" + method
				+ ", attribute=" + attribute + ", old_method=" + old_method + ", old_attribute=" + old_attribute
				+ ", audited=" + audited + ", getPaymentThersholdList()=" + getPaymentThersholdList()
				+ ", getSalutation()=" + getSalutation() + ", getfName()=" + getfName() + ", getInitial()="
				+ getInitial() + ", getlName()=" + getlName() + ", getSuffix()=" + getSuffix() + ", getTitle()="
				+ getTitle() + ", getCompany()=" + getCompany() + ", getDepartment()=" + getDepartment()
				+ ", getAddress1()=" + getAddress1() + ", getAddress2()=" + getAddress2() + ", getAddress3()="
				+ getAddress3() + ", getState()=" + getState() + ", getCity()=" + getCity() + ", getZip()=" + getZip()
				+ ", getCountry()=" + getCountry() + ", getCounty()=" + getCounty() + ", getPhone1()=" + getPhone1()
				+ ", getPhone2()=" + getPhone2() + ", getFax()=" + getFax() + ", getEmail()=" + getEmail()
				+ ", getOldEmail()=" + getOldEmail() + ", getAddressType()=" + getAddressType() + ", getTaxID()="
				+ getTaxID() + ", getSpecialTaxId()=" + getSpecialTaxId() + ", getListRental()=" + getListRental()
				+ ", getCustomerCategory()=" + getCustomerCategory() + ", getSales()=" + getSales()
				+ ", getAddressStatus()=" + getAddressStatus() + ", getCreditStatus()=" + getCreditStatus()
				+ ", getInstitutionalIdentifier()=" + getInstitutionalIdentifier()
				+ ", getParentInstitutionalIdentifier()=" + getParentInstitutionalIdentifier() + ", getIsAgency()="
				+ getIsAgency() + ", getIsGroup()=" + getIsGroup() + ", getIsdistributor()=" + getIsDistributor()
				+ ", getIsprospect()=" + getIsProspect() + ", getAgencyCode()=" + getAgencyCode() + ", getCustomerId()="
				+ getCustomerId() + ", getAgencyName()=" + getAgencyName() + ", getPaymentThershold()="
				+ getPaymentThershold() + ", getBundleDiscount()=" + getBundleDiscount() + ", getIsRenewTo()="
				+ getIsRenewTo() + ", getIsBillTo()=" + getIsBillTo() + ", getAgencyPayTax()=" + getAgencyPayTax()
				+ ", getRemits()=" + getRemits() + ", getTaxPayedOnGross()=" + getTaxPayedOnGross()
				+ ", getNewOrderCommission()=" + getNewOrderCommission() + ", getRenewalCommission()="
				+ getRenewalCommission() + ", getDistributor()=" + getDistributor() + ", getParent()=" + getParent()
				+ ", getDistributorURL()=" + getDistributorURL() + ", getProspectSequence()=" + getProspectSequence()
				+ ", getCreationDate()=" + getCreationDate() + ", getActiveProspect()=" + getActiveProspect()
				+ ", getQualDate()=" + getQualDate() + ", getOrderClass()=" + getOrderClass()
				+ ", getProspectCategory()=" + getProspectCategory() + ", getSourceCode()=" + getSourceCode()
				+ ", getReferredBY()=" + getReferredBY() + ", getReportPrefix()=" + getReportPrefix()
				+ ", getSequenceAddress()=" + getSequenceAddress() + ", getOldCustomerId()=" + getOldCustomerId()
				+ ", getBillTo()=" + getBillTo() + ", getDefaultAddress()=" + getDefaultAddress() + ", getRenewTo()="
				+ getRenewTo() + ", getStateList()=" + getStateList() + ", getAddressTypeList()=" + getAddressTypeList()
				+ ", getListRentalList()=" + getListRentalList() + ", getCustomerCategoryList()="
				+ getCustomerCategoryList() + ", getSalesRepresentativeList()=" + getSalesRepresentativeList()
				+ ", getAddressStatusList()=" + getAddressStatusList() + ", getCreditStatusList()="
				+ getCreditStatusList() + ", getTaxFilterList()=" + getTaxFilterList() + ", getDefaultAddressList()="
				+ getDefaultAddressList() + ", getCustomerAddressSeq()=" + getCustomerAddressSeq() + ", getFullName()="
				+ getFullName() + ", getChangeAddress()=" + getChangeAddress() + ", getTo()=" + getTo() + ", getFrom()="
				+ getFrom() + ", getFutureOrTemp()=" + getFutureOrTemp() + ", getDocumentReferenceId()="
				+ getDocumentReferenceId() + ", getUserCode()=" + getUserCode() + ", getSetGroupMember()="
				+ getSetGroupMember() + ", getCustomerGroupCustomerId()=" + getCustomerGroupCustomerId()
				+ ", getAuthorized()=" + getAuthorized() + ", getnCopies()=" + getnCopies()
				+ ", getAuditQualCategory()=" + getAuditQualCategory() + ", getOcId()=" + getOcId() + ", getActive()="
				+ getActive() + ", getCustomerGroup()=" + getCustomerGroup() + ", getAuditNameTitleId()="
				+ getAuditNameTitleId() + ", getAuditQualSourceId()=" + getAuditSourceId()
				+ ", getAuditSalesChannelId()=" + getAuditSalesChannelId() + ", getAuditSubscriptionTypeId()="
				+ getAuditSubscriptionTypeId() + ", getGroup()=" + getGroup() + ", getReportType()=" + getReportType()
				+ ", getFormat()=" + getFormat() + ", getOutput()=" + getOutput() + ", getFileType()=" + getFileType()
				+ ", getFilePrefix()=" + getFilePrefix() + ", getFileName()=" + getFileName() + ", getTransmitBy()="
				+ getTransmitBy() + ", getReportTypeOld()=" + getReportTypeOld() + ", getMethod()=" + getMethod()
				+ ", getAttribute()=" + getAttribute() + ", getOld_method()=" + getOld_method()
				+ ", getOld_attribute()=" + getOld_attribute() + ", getAudited()=" + getAudited() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + ",business_processes="+business_processes+", getProspectOnly()= " + getProspectOnly() + ",getProspectOnly()=" + getProspectOnly() + "]";
	}
	
}
