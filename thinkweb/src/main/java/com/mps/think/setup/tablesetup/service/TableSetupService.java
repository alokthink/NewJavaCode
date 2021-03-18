package com.mps.think.setup.tablesetup.service;

import java.util.List;
import java.util.Map;

import com.mps.think.model.DropdownModel;
import com.mps.think.setup.tablesetup.model.AuditModel;
import com.mps.think.setup.tablesetup.model.DealModel;
import com.mps.think.setup.tablesetup.model.DefaultSettings;
import com.mps.think.setup.tablesetup.model.DemographicModel;
import com.mps.think.setup.tablesetup.model.InternationalModel;
import com.mps.think.setup.tablesetup.model.LabelModel;
import com.mps.think.setup.tablesetup.model.PaymentsModel;
import com.mps.think.setup.tablesetup.model.ServiceModel;
import com.mps.think.setup.tablesetup.model.ShippingDeliveryandDistributionModel;
import com.mps.think.setup.tablesetup.model.TableSetupModel;
import com.mps.think.setup.tablesetup.model.TableSetupOrderClassModel;
import com.mps.think.setup.tablesetup.model.TableSetupOrdersModel;
import com.mps.think.setup.tablesetup.model.TaxesModel;

public interface TableSetupService {

public	int saveAddressStatus(TableSetupModel tableSetupModel);

public int updateAddressState(TableSetupModel tableSetupModel);

public int deleteAddressState(String addressStatus);

public int saveAddressType(TableSetupModel tableSetupModel);

public int updateAddressType(TableSetupModel tableSetupModel);

public int saveAttachmentCatagorySave(TableSetupModel tableSetupModel);

public int updateAttachCategory(TableSetupModel tableSetupModel);

public int deleteAttachCategory(String attachmentCatagory);

public int saveAuxField(TableSetupModel tableSetupModel);

public int updateAuxField(TableSetupModel tableSetupModel);

public int updateCreditStatus(TableSetupModel tableSetupModel);

public int saveCreditStatus(TableSetupModel tableSetupModel);

public int deleteAuxField(String tableName);

public int saveCustomerCategory(TableSetupModel tableSetupModel);

public int updateCustomerCategory(TableSetupModel tableSetupModel);

public int saveCustomerRentList(TableSetupModel tableSetupModel);

public int updateCustomerRentList(TableSetupModel tableSetupModel);

public int saveCustomerLoginQuestion(TableSetupModel tableSetupModel);

public int updateCustomerLoginQuetion(TableSetupModel tableSetupModel);

public int deleteCustomerLoginQuestion(int customerLoginQuestionId);

public int updateCustomerLookup(TableSetupModel tableSetupModel);

public List<Map<String, Object>> getDefalutDetails(String search);

public List<Map<String, Object>> getSerachFieldGroup(String search);

public List<Map<String, Object>> getSearchResultDisplay(String search);

public List<DropdownModel> getDispContext();

//public List<DropdownModel> getFollowOnServicePage();

public int saveCustomerMatchcode(TableSetupModel tableSetupModel);

public int updateCustomerMatchCode(TableSetupModel tableSetupModel);

public int deleteCustomerMatchCode(int custMatchCodeDetailSeq, int customerMatchCodeId);

public List<Map<String, Object>> getMatchCodeValues(int customerMatchCodeId);

public List<Map<String, Object>> getMatchCodeDetails(int custMatchCodeDetailSeq);

public List<DropdownModel> getColumnName();

public List<DropdownModel> getUseNextSegment();

public int ProspectCategory(TableSetupModel tableSetupModel);

public int updateCustomerProspectCategory(TableSetupModel tableSetupModel);

public int saveSalesRepresatative(TableSetupModel tableSetupModel);

public int updatecustomerSalesRepresentative(TableSetupModel tableSetupModel);

public int deleteCustomerSaleRep(int salesRepresentativeId);

public int deleteCustomerProspectCategory(String prospectCategory);


public	int saveprofitCenterOrderClass(TableSetupOrderClassModel tableSetupOrderClassModel);
public	int updateProfitCenterOrderClass(TableSetupOrderClassModel tableSetupOrderClassModel);


public	int saveTopic(TableSetupOrderClassModel tableSetupOrderClassModel);
public	int updateTopic(TableSetupOrderClassModel tableSetupOrderClassModel);
public	int saveSourceCodeFormat(TableSetupOrderClassModel tableSetupOrderClassModel);
public	int updateSourceFormat(TableSetupOrderClassModel tableSetupOrderClassModel);

public	int saveVolumeGroup(TableSetupOrderClassModel tableSetupOrderClassModel);
public	int updateVolumeGroup(TableSetupOrderClassModel tableSetupOrderClassModel);

public int deleteAddressType(String addressType);
public int deleteCrditStatus(String creditStatus);
public int deleteCategory(String customerCategory);
public int deleteRentList(String listRentalCategory);


public int deleteTopic(String topic,int ocId);
public int deleteVolumeGroup(int volumeGroupId);
public int deleteProfitCenter(String profitCenter);

public int savePayments(PaymentsModel paymetsModel);

public int updatePayments(PaymentsModel paymetsModel);

public int deletePaymentThreshold(String paymentThreshold);

public int savePaymentType(PaymentsModel paymetsModel);

public int updatePaymentType(PaymentsModel paymetsModel);

public int deletePaymentType(String paymentType);

public int saveTransactionReason(PaymentsModel paymetsModel);

public int updateTransactionReason(PaymentsModel paymetsModel);

public int deleteTransactionReason(String transactionReason);

public int saveInstallementplanDetails(PaymentsModel paymetsModel);

public int saveInstallementplan(PaymentsModel paymetsModel);

public int deleteIntallmentPlan(int installmentPlanId);

public int updateInstallmentPlan(PaymentsModel paymetsModel);

public int saveSettleRetryDef(PaymentsModel paymetsModel);

public int updateSettleRetryDef(PaymentsModel paymetsModel);

public int deleteSettleRetrydef(String settleRetryDef);

public int saveQtyDiscountScheduleDtl(PaymentsModel paymetsModel);

public int saveQtyDiscountSchedule(PaymentsModel paymetsModel);

public int updateQtyDiscountSchedule(PaymentsModel paymetsModel);

public int deleteQtyDiscountSchedule(String qtyDiscountSchedule, int qtyDiscountSchedDtlSeq);

public int deleteQtyDiscountScheduleDtl(String qtyDiscountSchedule);

public int saveMultilinDiscountSchedule(PaymentsModel paymetsModel);

public int saveMultilineDiscEff(PaymentsModel paymetsModel);

public int saveMultilineDiscSchedDtl(PaymentsModel paymetsModel);

public int updateMultilineDiscountSchedule(PaymentsModel paymetsModel);

public int deleteMultilineDiscountScheduleDetails(String multilineDiscountSchedule, Integer multilineDiscEffSeq,Integer multiDiscScheddtlSeq);



public	int saveCancelReason(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateCancelReason(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteCancelReason(String  cancelReason);

public	int saveCancelPolicy(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateCancelPolicy(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteCancelPolicy(int cancelPolicyId); 

public	int saveListPremiumUsed(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateListPremiumUsed(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteListPremiumUsed(String orderCode,int ocId); 

public int saveOrders(TableSetupOrdersModel tableSetupOrdersModel);
public	int updateOrders(TableSetupOrdersModel tableSetupOrdersModel);
public List<Map<String, Object>> getOrderDetails(String search, int searchFieldGroupSeq, int searchResultDisplaySeq);

public int deleteOrders(String search,int searchFieldGroupSeq,int searchResultDisplaySeq);
public	int saveOrderCategory(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateOrderCategory(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteOrderCategory(String orderCategory); 
public	int saveSubscriptionCategory(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateSubscriptionCategory(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteSubscriptionCategory(int subscriptionCategoryId); 
public	int saveTaxonomy(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateTaxonomy(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteTaxonomy(String taxonomy); 
public	int saveTerm(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateTerm(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteTerm(int termId); 
public	int saveUnitTypes(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateUnitTypes(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteUnitTypes(int unitTypeId); 
public	int saveUpsellSuggestion(TableSetupOrdersModel tableSetupOrdersModel);
public	int  updateUpsellSuggestion(TableSetupOrdersModel tableSetupOrdersModel);
public int deleteUpsellSuggestion(int upsellSuggestionId); 
public	int saveCalenderCampaign(TableSetupOrdersModel tableSetupOrdersModel);
public int updateCalenderCampaign(TableSetupOrdersModel tableSetupOrdersModel); 
public int deleteCalenderCampaign(int calenderCampaignId); 

public int saveServiceCause(ServiceModel serviceModel);

public int updateServiceCause(ServiceModel serviceModel);

public int deleteServiceCause(String causeCode, int reportItemId);

public int saveServiceComplaint(ServiceModel serviceModel);

public int updateServiceComplaint(ServiceModel serviceModel);

public int deleteServiceComplaint(String complaintCode, String serviceCode);

public int saveServiceResolution(ServiceModel serviceModel);

public int updateServiceResolution(ServiceModel serviceModel);

public int deleteServiceResolution(String complaintCode, String serviceCode, int reportItemId);

public List<Map<String, Object>> getProfitCenter(String profitCenter);
public List<Map<String, Object>> getSourceCodeFormats(TableSetupOrderClassModel tableSetupOrderClassModel);
public List<Map<String, Object>> getTopic(String topic);
public List<Map<String, Object>> getVolumeGroup(int volumeGroupId);
public List<Map<String, Object>> getCancelReason(String cancelReason);
public List<Map<String, Object>> getCancelPolicy();
public List<Map<String, Object>> getPremiumUsed();
public List<Map<String, Object>> getOrderCategory(String orderCategory);
public List<Map<String, Object>> getSubscriptionCategory(int subscriptionCategoryId);
public List<Map<String, Object>> getTaxonomy(String taxonomy);
public List<Map<String, Object>> getTerm(int termId);
public List<Map<String, Object>> getUnitType(int unitTypeId);
public List<Map<String, Object>> getUpsellSuggestion(int upsellSuggestionId);
public List<Map<String, Object>> getCalenderCampaign(int calenderCampaignId);

public int saveCommodityCode(TaxesModel taxesModel);
public int updateCommodityCode(TaxesModel taxesModel); 
public int deleteCommodityCode(int commodityCode);
public List<Map<String, Object>> getCommodityCode(int commodityCode);

public int saveJurisdiction(TaxesModel taxesModel);
public int updateJurisdiction(TaxesModel taxesModel); 
public int deleteJurisdiction(String state,int jurisdictionSeq);
public List<Map<String, Object>> getJurisdiction(String state);
public List<DropdownModel> getStateCodeList(String state);

public int saveSpecialTax(TaxesModel taxesModel);
public int updateSpecialTax(TaxesModel taxesModel); 
public int deleteSpecialTax(String specialTaxId);
public List<Map<String, Object>> getSpecialTax(String specialTaxId);
public List<DropdownModel> getExemptStatus(String specialTaxId);
public int saveTaxHandling(TaxesModel taxesModel);
public int updateTaxHandling(TaxesModel taxesModel); 

public int deleteTaxHandling(String  taxHandling);
public List<Map<String, Object>> getTaxHandling(String taxHandling);
public  List<DropdownModel> getTaxHandlingList(String taxHandling);
public int saveTaxRatesbyCountryandState(TaxesModel taxesModel);
public int updateTaxRatesbyCountryandState(TaxesModel taxesModel); 
public int deleteTaxRatesbyCountryandState(String state);
public List<Map<String, Object>> getTaxRatesbyCountryandState(String state);
public int saveTaxRateCategories(TaxesModel taxesModel);
public int updateTaxRateCategories(TaxesModel taxesModel); 
public int deleteTaxRateCategories(String taxRateCategory);

public List<Map<String, Object>> getTaxRateCategories(String taxRateCategory);
public int saveTaxTypes(TaxesModel taxesModel);

public int updateTaxTypes(TaxesModel taxesModel); 
public int deleteTaxTypes(String taxType);
public List<Map<String, Object>> getTaxTypes(String taxType);

public int saveAddresses(InternationalModel internationalModel);
public int updateAddresses(InternationalModel internationalModel); 
public int deleteAddresses(int addressId);
public List<Map<String, Object>> getAddress(int addressId);
public List<DropdownModel> getStateList();
public int saveAddressCleaning(InternationalModel internationalModel);
public int updateAddressCleaning(InternationalModel internationalModel); 
public int deleteAddressCleaning(int iapDatasetDefId);
public List<Map<String, Object>> getAddressCleaning(int iapDatasetDefId);
public List<DropdownModel> getProgIdList();
public List<Map<String, Object>> getIapNameValue(int iapDatasetDefId);
public int saveCountryCode(InternationalModel internationalModel);
public int updateCountryCode(InternationalModel internationalModel); 
public int deleteCountryCode(String countryCode2);
public List<Map<String, Object>> getCountryCode();
public List<DropdownModel> getFileCurrencyList();
public int saveCountriesandStates(InternationalModel internationalModel);
public int updateCountriesandStates(InternationalModel internationalModel); 
public int deleteCountriesandStates(String state);
public List<Map<String, Object>> getCountriesandStates(String state);
public List<DropdownModel> getCurrencyList();
public List<DropdownModel> getCountryCodeList();
public List<DropdownModel> getLabelFormatList();
public List<DropdownModel> getaddressCheckingList();
public int saveCurrencies(InternationalModel internationalModel);
public int updateCurrencies(InternationalModel internationalModel); 
public int deleteCurrencies(String currency);
public List<Map<String, Object>> getCurrencies(String currency);
public int saveLanguageCodes(InternationalModel internationalModel);
public int updateLanguageCodes(InternationalModel internationalModel); 
public int deleteLanguageCodes(String langugaeCode);
public List<Map<String, Object>> getLanguageCodes(String languageCode);
public int saveRegions(InternationalModel internationalModel);
public int updateRegions(InternationalModel internationalModel); 
public int deleteRegions(String regionList);
public List<Map<String, Object>> getRegions(String regionList);


public List<Map<String, Object>> getAddressStatusDetails(String addressStatus);

public List<Map<String, Object>> getAddressTypeDetails(String addressType);

public List<Map<String, Object>> getAttachmentCatagoryDetails(String attachmentCatagory);

public List<Map<String, Object>> getAuxFieldDetails(String tableName);

public List<Map<String, Object>> getCreditStatusDetails(String creditStatus);

public List<Map<String, Object>> getRentalCategoryDetails(String listRentalCategory);

public List<Map<String, Object>> getCustomerCategoryDetails(String customerCategory);

public List<Map<String, Object>> getLoginQuestionDetails(int customerLoginQuestionId);
//public List<DropdownModel> getFollowOnServicePage();

public List<Map<String, Object>> getProspectCategoryDetails(String prospectCategory);

public List<Map<String, Object>> getsalesRepresentativeDetails(int salesRepresentativeId);

public List<DropdownModel> getDelivaryMethod();

public List<DropdownModel> getRegionList();

public List<DropdownModel> getShippingPriceList();

public List<DropdownModel> getCancellationRenewal();

public List<DropdownModel> getAddressType();

public List<DropdownModel> getAddressStatus();

public List<DropdownModel> getCreditStatus();

public List<DropdownModel> getRentalCategory();

public List<DropdownModel> getOperatorDetails();

public List<DropdownModel> getbacthTemplateDetails();

public List<Map<String, Object>> getDocumentReferenceDetails();

public List<DropdownModel> getType();

public int saveDocumentReference(DefaultSettings defaultSettings);

public int updateDocumentReference(DefaultSettings defaultSettings);

public int saveEditTrail(DefaultSettings defaultSettings);

public List<Map<String, Object>> getEditTrailDetails(int documentReferenceId);

public List<Map<String, Object>> getEditTrail(int documentReferenceId);

public List<Map<String, Object>> getPaymentBreakdown(int paymentSeq, int customerId);

public List<DropdownModel> getShipType();

public List<DropdownModel> getBackIssueShipType();

public List<DropdownModel> getNewmemberOptions();

public List<Map<String, Object>> getAccountingDetails(String currency);

public List<DropdownModel> getPaymentThreshold();

public List<DropdownModel> getDefaultPayType();

public List<DropdownModel> getRefundPaytype(String paymentType);

public List<DropdownModel> getHoldForPayment();

public List<DropdownModel> getEncryptorCOM(String purposeCode);

public List<Map<String, Object>> getVertexDetails();

public int legalEntitySave(DefaultSettings defaultSettings);

public List<Map<String, Object>> getLegalEntityDetails();

public List<DropdownModel> getShiptoRegion();

public int saveLegalEntity(DefaultSettings defaultSettings);

public List<Map<String, Object>> getPaymentThresholdDetails(String paymentThreshold);

public List<Map<String, Object>> getPaymentTypeDetails(String paymentType);

public List<DropdownModel> getPaymentForm();

public List<DropdownModel> getRealizeCashwhen();

public List<DropdownModel> getCreditCardType();

public List<DropdownModel> getCardVerificationusage();

public List<Map<String, Object>> getTransreasonDetails(String transactionReason);

public List<DropdownModel> getTransreasonReasonType();

public int updateLegalEntity(DefaultSettings defaultSettings);

public int deleteLegalEntity(int vrtxLegalEntityId, String shiptoRegion);

public List<Map<String, Object>> getEntityDetails(int vrtxLegalEntityId);

public List<DropdownModel> getAdministrativeAddress();

public int updateTax(DefaultSettings defaultSettings);

public int updateTaxDef(DefaultSettings defaultSettings);

public List<Map<String, Object>> getCheckValues();

public int deleteTaxLegalEntity(String region);

public List<Map<String, Object>> getCustomersDetails(String currency);

public int updateDefaultCustomerUpdate(DefaultSettings defaultSettings);

public int updateAccounting(DefaultSettings defaultSettings);

public List<Map<String, Object>> getPaymentDetails(String currency);

public int updateDefaultPayment(DefaultSettings defaultSettings);

public List<Map<String, Object>> getInventoryDetails(String currency);

public int updateInventory(DefaultSettings defaultSettings);

public List<Map<String, Object>> getCustomFieldDetails(String currency);

public int updateCustomFields(DefaultSettings defaultSettings);

public List<Map<String, Object>> getLicenseCodeDetails(String lincenseCode);

public List<Map<String, Object>> getInternetDetails(String currency);

public int saveInternet(DefaultSettings defaultSettings);

public int updateInternet(DefaultSettings defaultSettings);

public List<DropdownModel> getMatchCode();

public List<DropdownModel> getProspectCategory();

public int updateDefaultInternet(DefaultSettings defaultSettings);

public List<DropdownModel> getLableGroup();

public List<DropdownModel> getLableFormate();

public List<Map<String, Object>> getProcessingDetails(String currency);

public int updateProcessing(DefaultSettings defaultSettings);


public int saveDeliveryMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int updateDeliveryMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int deleteDeliveryMethods(String deliveryMethod);
public List<Map<String, Object>> getDeliveryMethods(String deliveryMethod);
public List<DropdownModel> getOrderClassList();
public int saveDistributionMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int updateDistributionMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int deleteDistributionMethods(String distributionMethod,String distributionAttribute);
public List<Map<String, Object>>  getDistributionMethods(String distributionMethod,String distributionAttribute);
public List<DropdownModel> getDistAttributeList();
public List<DropdownModel> getDistRegionList();
public List<DropdownModel> getDeliveryMethodList();
//public List<Map<String, Object>> setupDefaltDeliveryMethodsDetails();
public int saveShippingandHandlingMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int updateShippingandHandlingMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int deleteShippingandHandlingMethods(String shippingMethod);
public List<Map<String, Object>> getShippingandHandlingMethods(String shippingMethod);
public int saveAssignDistributionCriteria(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int updateAssignDistributionCriteria(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int deleteAssignDistributionCriteria(String distributionMethod,int distMethodDefaultSeq);
public List<Map<String, Object>>  getAssignDistributionCriteria(String distributionMethod,int distMethodDefaultSeq);
public List<DropdownModel> regionList();
public List<DropdownModel> attributeList();
public List<DropdownModel> attributeValue();
public int saveSetUpDistributionAttributes(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int updateSetUpDistributionAttributes(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int  deleteSetUpDistributionAttributes(String distributionAttribute,String distAttributeValue);
public List<Map<String, Object>> getSetUpDistributionAttributes(String distributionAttribute,String distAttributeValue);
public int saveShippingPriceList(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int updateShippingPriceList(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int deleteShippingPriceList(String shippingPriceList);
public List<Map<String, Object>> getShippingPriceList(String shippingPriceList);
public List<DropdownModel> getShippingMethodList();
public List<DropdownModel>  getRegion();
public int saveMailingEntryPoint(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int updateMailingEntryPoint(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int  deleteMailingEntryPoint(String mailingEntryPoint);
public List<Map<String, Object>> getMailingEntryPoint(String mailingEntryPoint);
public int saveTransportMode(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel);
public int deleteTransportMode(String transportMode);
public List<Map<String, Object>> getTransportMode(String transportMode);

public int saveEmailFormater(DefaultSettings defaultSettings);

public int updateEmailFormater(DefaultSettings defaultSettings);

public int deleteEmailFormater(int transactionEvent);

public List<DropdownModel> getTransactionEvent();

public List<DropdownModel> getOrderClass();

public List<DropdownModel> getrovider();

public int tpProviderUpdate(DefaultSettings defaultSettings);

public List<Map<String, Object>> getrProviderDetails(int tpProviderId);

public List<Map<String, Object>> getEmailFormatorDetails(int transactionEvent);

public String defaultEmailAuthorizationInfo(String Currency);

public List<Map<String, Object>> getCheckdetails(String currency);

public String updateDefaultEmailAuthorization(String currency, String business_processes);

public String defaultEmailNotificationInfo(String currency);

public int updateCheckDetails(String currency, String suppressEmailNotification, String notifyOldAndNew);

public String updateDefaultEmailNotificationSwitches(String currency, String business_processes);

public int saveDealType(DealModel dealModel);

public int updateDealType(DealModel dealModel);

public int deleteDealType(String dealType);

public List<Map<String, Object>> getDealTypeDetails(String dealType);

public int saveDealStatus(DealModel dealModel);

public int updateDealStatus(DealModel dealModel);

public List<Map<String, Object>> getDealStatusDetails(String dealStatus);

public int deleteDealStatus(String dealStatus);

public int saveDemograpic(DemographicModel demographicModel);

public int saveDemResponse(DemographicModel demographicModel);

public int updateDemQuestion(DemographicModel demographicModel);

public int updateDemresponse(DemographicModel demographicModel);

public int deleteDemQuestion(int demQuestionId);

public int deleteDemresponse(int demresponseSeq, int demQuestionId);

public List<Map<String, Object>> getDemographicInfo(int demQuestionId, int demresponseSeq);

public List<Map<String, Object>> getDemQuestionDetails(int demQuestionId);

public List<DropdownModel> getQualified();

public List<DropdownModel> getFreeFormInput();

public int saveDisplayctxRedirection(DemographicModel demographicModel);

public int updateDisplayctxRedirection(DemographicModel demographicModel);

public int deleteDisplayctxRedirection(String dispContext);

public List<Map<String, Object>> getDisplayctxRedirection(String dispContext);

public List<DropdownModel> getDispCntx();

public List<DropdownModel> getDispContexttoLead();

public int savelabelFormat(LabelModel labelModel);

public int updateLabelFormat(LabelModel labelModel);

public int deleteLabelFormat(String labeFormat, String labelGroup);

public List<Map<String, Object>> getLabelFormateDetails(String labeFormat);

public List<Map<String, Object>> getlabelGroupDetails(String labelGroup);

public int savelabelGroup(LabelModel labelModel);

public int updateLabelGroup(LabelModel labelModel);

public int deleteLabelGroup(String labeFormat);

public int savelabelKeyline(LabelModel labelModel);

public int saveLbelKeylineDetails(LabelModel labelModel);

public List<DropdownModel> getTablename();

public List<DropdownModel> getColumnname();

public List<DropdownModel> getDemQuestion();

public int updatelabelKeyline(LabelModel labelModel);

public int updateLabelKeylineDetail(LabelModel labelModel);

public List<DropdownModel> getColumnnameInfo();

public List<Map<String, Object>> labelKeylineDetails(String labelKeyline);

public List<Map<String, Object>> labelKeylineInfo(String labelKeyline, int labelLinenbr);

public int deletelabelKeylineDetail(String labelKeyline, int labelLinenbr);

public int deleteLabelkeyline(String labelKeyline);

public List<Map<String, Object>> getLabelgroupFormatDetails(String labelGroup);

public List<DropdownModel> getlabelGroupInfo();

public List<DropdownModel> getLabelFormat();

public List<Map<String, Object>> getFinalLabel(String labelGroup, int labelLinenbr);

public int saveLabel(LabelModel labelModel);

public int updateLabel(LabelModel labelModel);

public int saveLabelFormatDetail(LabelModel labelModel);

public int updateLabelFormatDetail(LabelModel labelModel);

public int deleteLabelDetails(String labelFormat, int labelLinenbr);

public int deleteLabel(String labelFormat);

public List<Map<String, Object>> installmentPlanDetails(int installmentPlanId);

public List<Map<String, Object>> installPlanInfo(int installmentPlanId, int installPlanDetailSeq);

public List<DropdownModel> getOutput();

public List<Map<String, Object>> settleRetryDefInfo(String settleRetryDef);

public List<Map<String, Object>> getQtyDiscountSchedule(String qtyDiscountSchedule);

public List<Map<String, Object>> getQtyDiscountSchedDtl(String qtyDiscountSchedule);

public List<DropdownModel> getDiscountamtCalcType();

public List<Map<String, Object>> getMultilineDiscountSchedule(String multilineDiscountSchedule);

public List<Map<String, Object>> getMultilineDiscEffective(String multilineDiscountSchedule, int multilineDiscEffSeq);

public List<Map<String, Object>> getMultiDiscSchedDtl(String multilineDiscountSchedule, int multiDiscScheddtlSeq);

public List<DropdownModel> getReportitemId();

public List<Map<String, Object>> getServiceCause(String causeCode);

public List<DropdownModel> getCauseCode();

public List<DropdownModel> getServicetoPerform();

public List<Map<String, Object>> getServiceComplaints(String complaintCode);

public List<Map<String, Object>> getServiceResolution(String serviceCode);

public int saveBasicPrice(AuditModel auditModel);
public int updateBasicPrice(AuditModel auditModel);
public int  deleteBasicPrice(int auditBasicPriceId);
public List<Map<String, Object>> getBasicPrice(int auditBasicPriceId);
public List<DropdownModel>  getPubGroupList();
public int saveAuditDuration(AuditModel auditModel);
public int updateAuditDuration(AuditModel auditModel);
public int  deleteAuditDuration(int auditDurationId);
public List<Map<String, Object>>  getAuditDuration(int auditDurationId);
public int   saveMailingAddressName(AuditModel auditModel);
public int updateMailingAddressName(AuditModel auditModel);
public int deleteMailingAddressName(int auditNameTitleId);
public List<Map<String, Object>> getMailingAddressName(int auditNameTitleId);
public int   savePublicationGroup(AuditModel auditModel);
public int updatePublicationGroup(AuditModel auditModel);
public int deletePublicationGroup(String auditPubGroup);
public List<Map<String, Object>>  getPublicationGroup(String auditPubGroup);
public int saveQualificationSource(AuditModel auditModel);
public int  updateQualificationSource(AuditModel auditModel);
public int deleteQualificationSource(int auditQualSourceId);
public List<Map<String, Object>> getQualificationSource(int auditQualSourceId) ;
public int saveDemoGraphicCrossTab(AuditModel auditModel);
public int updateDemographicCrossTab(AuditModel auditModel);
public int deleteDemographicCrossTab(int auditReportId);
public List<Map<String, Object>>  getDemographicCrossTab(int auditReportId);
public List<DropdownModel> getQuestionList();
public int  saveSalesChannel(AuditModel auditModel);
public int  updateSalesChannel(AuditModel auditModel);
public int deleteSalesChannel(int auditSalesChannelId);
public List<Map<String, Object>>  getSalesChannel(int auditSalesChannelId);
public int  saveSubscriptionType(AuditModel auditModel);
public int  updateSubscriptionType(AuditModel auditModel);
public List<Map<String, Object>> getSubscriptionType(int auditSubscriptTypeId);
public int  saveLookupForAuditGalleyIssue(AuditModel auditModel);
public int  updateLookupForAuditGalleyIssue(AuditModel auditModel);
public int deleteLookupForAuditGalleyIssue(String search, int searchFieldGroupSeq, int searchResultDisplaySeq);
public List<Map<String, Object>> getLookupForAuditGalleyIssue(String search, int searchFieldGroupSeq, int searchResultDisplaySeq);
public int  saveParagraphReports(AuditModel auditModel);
public int  updateParagraphReports(AuditModel auditModel);
public int  deleteParagraphReports(int auditReportId);
public List<Map<String, Object>> getParagraphReports();
public List<DropdownModel>  getParagraphSelectionList();

public String getPsRenewalLabel(String currency);

public String getPsBilling(String currency);

public String getOsLabel(String currency);

public String getOsBackLabel(String currency);

public String getOsRenewal(String currency);

public String getOsBilling(String currency);

public String getOsCancellation(String currency);

public String getOsSuspension(String currency);

public List<Map<String, Object>> getGroupDetails(int customerId);


public String Renewal(String currency, int... business_processes);

public String PsBillingUpdate(String currency, int... business_processes);

public String osLabelUpdate(String currency, int... business_processes);

public String osBackLabelUpdate(String currency, int... business_processes);

public String osRenewalUpdate(String currency, int... business_processes);

public String osBillingUpdate(String currency, int... business_processes);

public String osCancellationUpdate(String currency, int... business_processes);

public String osSuspensionUpdate(String currency, int... business_processes);






}



