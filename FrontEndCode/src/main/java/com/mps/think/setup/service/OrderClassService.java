package com.mps.think.setup.service;

import java.util.List;
import java.util.Map;
import com.mps.think.model.DropdownModel;
import com.mps.think.process.model.JobModel;

import com.mps.think.setup.model.AlternateContent;
import com.mps.think.setup.model.AuditTrackingModel;
import com.mps.think.setup.model.CalendarCampaignModel;
import com.mps.think.setup.model.DashboardLeftPanelModel;
import com.mps.think.setup.model.DemographicForms;
import com.mps.think.setup.model.DiscClassEffective;
import com.mps.think.setup.model.DiscountCard;
import com.mps.think.setup.model.DiscountClassModel;
import com.mps.think.setup.model.Issue;
import com.mps.think.setup.model.OrderCodeModel;
import com.mps.think.setup.model.PackageContentModel;
import com.mps.think.setup.model.PackageDefinationModel;
import com.mps.think.setup.model.ParentOrderClassModel;
import com.mps.think.setup.model.ProductModel;
import com.mps.think.setup.model.PromotionCard;
import com.mps.think.setup.model.PromotionCardEffort;
import com.mps.think.setup.model.PromotionCardOffer;
import com.mps.think.setup.model.Pub;
import com.mps.think.setup.model.PubRotation;
import com.mps.think.setup.model.QuickOrderCodeModel;
import com.mps.think.setup.model.RateClassModel;
import com.mps.think.setup.model.RenewalCard;
import com.mps.think.setup.model.SubscriptionDef;
import com.mps.think.setup.model.SubscriptionStart;
import com.mps.think.setup.model.UpSellModel;
import com.mps.think.setup.model.VolumeGroup;

public interface OrderClassService {

public List<DropdownModel> getDefaultSourceCode(String ocId);

public List<Map<String, Object>> getOrderClassID1(String ocId);

public List<DropdownModel> getSourceCodeFormat();

public List<DropdownModel> getPaymentThresholdData();

public List<DropdownModel> getProfitCenter(); 

public List<DropdownModel> getLabelOutputData();

public List<Map<String, Object>> getTopicTableData(Long showId);

public List<Map<String, Object>> getDiscountRates(int discClassId);

public List<ParentOrderClassModel> getSourceCodeDetails(Long ocId, int active, int sourceCodeType, int isDDp);

public List<ParentOrderClassModel> getSourceCodeDetails(Long ocId);

public List<Map<String, Object>> getRateClassTableDetails(Long ocId);

public List<Map<String, Object>> getRateClassDetails(int rateClassId);

public List<DropdownModel> getRegionList();

public List<DropdownModel> getRegion(String regionList);

public List<DropdownModel> lookupCurrency();

public List<DropdownModel> getDiscountCardUnitType();

public List<Map<String, Object>> getEffectiveDatesTableData(int rateClassId);

public List<DropdownModel> getRenewalDropDownData(Long ocId);

public List<DashboardLeftPanelModel> getleftPanelDashboardData();

public List<Map<String, Object>> getEffectiveDiscountData(int discountClassId);

//discount & rate card

public int saveRateCardRecords(RateClassModel rateClassModel);

public int updateRateCardRecords(RateClassModel rateClassModel);

public int saveDiscountCardRecords(DiscountCard discountCard);

public Integer getDisc_class_effective_Seq(Integer discountId);

public Integer getRateClassEffectiveSeq(Integer rateClassId);

public int updateDiscountCardRecords(DiscountCard discountCard);

public List<Map<String, Object>> getDropDownDefaultData(String ocId);

public List<DropdownModel> getNewGroupMemberActionList();

public List<DropdownModel> getInventoryList(String ocId);

public List<DropdownModel> getVolumeGroupList();

public List<DropdownModel> getSubscriptionCategory();

public List<Map<String, Object>> getSubscriptionCategory(Long ocId, Long volumeGroupId);

public List<Map<String, Object>> getVGTargetSalesLevels(Long ocId);

public List<Map<String, Object>> getTargetSalesLevels(Long ocId,Long volumeGroupId);

public String saveTargetSalesLevels(VolumeGroup volumeGroup);

public String updateTargetSalesLevels(VolumeGroup volumeGroup);

public List<Map<String, Object>> getDemographicsTableData(int ocId);

public int topicActiveSave(Long ocId, String topic);

public int topicInActiveSave(Long ocId, String topic);

public int addUpSell(UpSellModel upSellClassModel);

public List<UpSellModel> getUpSellTableData();

public List<UpSellModel> getUpSellTableDetails(Integer ocId,Integer upsellId);

public List<Map<String, Object>> getUpSellDetails(Integer ocId,Integer upsellId);

public List<DropdownModel> getSuggestionList();

public List<CalendarCampaignModel> getCompaignList();

public List<DropdownModel> getConditionList();

public List<DropdownModel> getUpsellType();

public int deleteUpSellRecords(int upsellId);

public int updateUpSellRecords(UpSellModel upSellClassModel);

public int deleteRateClassRecords(int rateClassId);

public List<DropdownModel> getSourceCodeTypeDetails();

//discount class
public int updateDiscountClassRecords(DiscountClassModel discountClass);

//public List<DropdownModel> getAgencyRate();
public List<Map<String, Object>> getAgencyRate(Integer rateClassId,Integer rateCardSeq);

public List<DropdownModel> getQtyDiscount();
public void insertBatchRateCard(final List<RateClassModel> model);
public List<Map<String, Object>> getRateCardCopyDetails(Integer rateClassId);
public List<Map<String,Object>> getRateCardCopyList(Integer rateClassId, Integer rateClassEffectiveSeq);
public int getDiscountId();

public List<Map<String, Object>> getDiscountCardRecords(int discClassId);

public List<Map<String, Object>> getDiscountCardRecords(int discountId, int disc_class_effective_Seq);

public List<Map<String, Object>> getRateCardTableData(int rateClassId); 

public List<Map<String, Object>> getRateCardTableData(int rateClassId, int rateClassEffectiveSeq); 

public List<Map<String, Object>> getDiscountClassEffectiveDateTableData();

public List<Map<String, Object>> getDiscountClassEffectiveDateDetails(int discClassId);

public int deleteDiscountRecords(int ocId, int discountClassId);

public int saveEffectiveDateDiscountRecords(DiscClassEffective discClassEffective);

public int updateEffectiveDateDiscountRecords(DiscClassEffective discClassEffective);

public int updateRateDiscountRecords(DiscountClassModel discountClassModel);

public int updateEffectiveRateDiscountRecords(DiscountClassModel discountClassModel);

public List<OrderCodeModel> getOrderCodeTableData(int ocId);

public List<DropdownModel> getInstallmentPlans();

public List<DropdownModel> getAuditDefaults();

public List<DropdownModel> getCreditCardProcess();

public List<DropdownModel> getSettleRetryDef();

public List<Map<String, Object>> getDiscountClass(Long ocId);

public List<DropdownModel> getCommodityList();

public List<DropdownModel> getTaxonomyList();

public List<Map<String,Object>> getSingleIssueList(Long ocId);

public List<DropdownModel> getPremiumList();

public List<DropdownModel> getUnitExcess();

public List<DropdownModel> getUnitTypeList();

public List<DropdownModel> getTimeUnits();

public List<DropdownModel> getTrialTypeList();

public List<DropdownModel> getDefaultTerm();

public List<DropdownModel> getIssue(Long ocId);

public List<Map<String, Object>> getOrderCodeDetails(Long ocId, Long orderCodeId);

public List<Map<String, Object>> getRateClassDetails(Long ocId);

public List<DropdownModel> searchRateClass(Long ocId);

public List<DropdownModel> searchRateClass(Long ocId,String rateClass);

public List<DropdownModel> searchRateClass(Long ocId,String rateClass,String rateDescription);

public List<DropdownModel> searchRateClass(Long ocId, Long rateClassId);

public List<DropdownModel> searchDiscountClass(Long ocId);

public List<DropdownModel> searchDiscountClass(Long ocId,String discountClass);

public List<DropdownModel> searchDiscountClass(Long ocId,String discountClass,String discountDescription);

public List<DropdownModel> searchDiscountClass(Long ocId, Long discountClassId);

public List<DropdownModel> getDiscountClassDetails(Long ocId);

public int saveOrderCodeDetails(OrderCodeModel orderCodeModel);

public int updateOrderCodeDetails(OrderCodeModel orderCodeModel);

public String deleteOrderCodeDetails(int orderCodeId);

public List<Map<String, Object>> getDiscountRatesDetails();

List<Map<String, Object>> getPromotionCardDetails(Long ocId);

List<Map<String, Object>> getPromotionCardEffortDetails(Long promoCardId);

List<Map<String, Object>> getPromotionCardOfferDetails(Long promoCardId, Long promoCardEffortId);

public int savePromotionCardDetails(PromotionCard promotionCard);

public int getPromotionCardId(); 

public int updatePromotionCardDetails(PromotionCard promotionCard);

public int savePromotionCardEffortDetails(PromotionCardEffort promotionCardEffort);

public int getPromotionCardFromEffortId();

public int updatePromotionCardEffortDetails(PromotionCardEffort promotionCardEffort);

public int savePromotionCardOfferDetails(PromotionCardOffer promotionCardOffer);

public int getPromotionCardOfferSeq();

public int updatePromotionCardOfferDetails(PromotionCardOffer promotionCardOffer);

public int saveRateClassEffective(RateClassModel rateClassModel);

public int updateRateClassEffective(RateClassModel rateClassModel);

List<Map<String, Object>> getRenewalCardDetails(Long ocId);

List<Map<String, Object>> getRenewalCardEffortDetails(Long renewalCardId);

List<Map<String, Object>> getRenewalCardOfferDetails(Long renewalCardId, Long renewalCardEffortId);

public int getRenewalCardId();

public int getRenewalCardEffortId(Integer renewalCardId);

public int getRenewalCardOfferSeq(Integer renewalCardId,Integer renewalCardEffortId);

public int saveRenewalCardDetails(RenewalCard renewalCard);

public int updateRenewalCardDetails(RenewalCard renewalCard);

public String saveRenewalCardEffortDetails(RenewalCard renewalCard);

public String updateRenewalCardEffortDetails(RenewalCard renewalCard);

public int saveRenewalCardOfferDetails(RenewalCard renewalCard);

public int updateRenewalCardOfferDetails(RenewalCard renewalCard);

public List<DropdownModel> getPubRotationList(Long ocId);

public List<DropdownModel> getLanguageList();

public List<DropdownModel> getWebDetails(Long ocId, Long orderCodeId, String shortDescription, String longDescription);

public int saveWebDetails(AlternateContent alternateContent);

public int updateWebDetails(AlternateContent alternateContent);

public List<DropdownModel> getTranslationDetails(Long ocId, Long orderCodeId, String description);

public List<Map<String, Object>> getGenericPromotionDefinition(Integer ocId,Integer sourceCodeId);

public List<Map<String, Object>> getGenericPromotionCode(Integer sourceCodeId);

public List<DropdownModel> getOrderCodeDetails(Long ocId);

public List<DropdownModel> getAgencyDetails();

public List<DropdownModel> getShippingPriceList();

public List<DropdownModel> getSourceCodeAttributeValue();

public List<Map<String, Object>> getSourceCodeDetails(Integer sourceCodeId);

public int deleteSourceCodeDetails(Integer sourceCodeId);

public int saveGenericPromoCodeDetails(ParentOrderClassModel genericPromo);

public List<DropdownModel> getSourceCodeStateDetails(Integer sourceCodeId);

public List<DropdownModel> getRateList(Long ocId);

public int getOrderCodeType(Integer orderCodeType); 

public int getOrderCodeId();	
public void insertBatchOrderCodeDependency(final List<OrderCodeModel> model);
public String updateDependencies(OrderCodeModel model);
public List<DropdownModel> getOrderCodeDependecies(Integer orderCodeId);
public String saveDependencies(OrderCodeModel model);
public List<DropdownModel> getQuestionsList();
public List<DropdownModel> getQuestionOverrideList(Integer demFormId, Integer demFormQuestionSeq);
public List<DropdownModel> getResponsesList(Integer demQuestionId);
public List<Map<String, Object>> getDemFormResponseDetails(Integer demFormId,Integer demFormQuestionSeq);
public List<DropdownModel> getResponsesOverrideList(Integer demFormId, Integer demFormQuestionSeq, Integer demFormResponseSeq);
public List<Map<String, Object>> getDemFormDetails(Integer demFormId);
public List<Map<String, Object>> getDemFormDetails(Integer demFormId, Integer demFormQuestionSeq);
public List<Map<String, Object>> getDemFormQuestionDetails(Integer demFormId);
public int saveDemForm(DemographicForms DemForm);
public int updateDemForm(DemographicForms DemForm);
public int getDemFormId();
public int getDemFormQuestionSeq(Integer demFormId);
public int getDemFormResponseSeq(Integer demFormId,Integer demFormQuestionSeq);
public String deleteDemographics(int demFormId);
public List<DropdownModel> copyDemographics(Integer demFormId, String demForm,Integer ocId,String active);
public List<Map<String, Object>> getProductDetails(Integer ocId);
// public List<Map<String, Object>> getjobDetails(int jobId);

/*==================================================*/

public int savePubRotationDetails(PubRotation pubRotation);

public int getPubRotationId();

public int updatePubRotationDetails(PubRotation pubRotation);

public int savePubDetails(Pub pub);

public int getOcId();

public int updatePubDetails(Pub pub);

public List<Pub> getSelectPubDetails(Integer ocId);

public List<DropdownModel> getCalenderUnit();

public List<DropdownModel> getOnCalendarUnit();

public List<DropdownModel> getVolumeFormat();

public List<DropdownModel> getIssueFormat();

public List<PubRotation> getPubRotationDetails(Integer ocId);

/*---------------------------------------------------------*/

public int saveIssue(Issue issue);

public int getIssueId();

public int updateIssue(Issue issue);

public List<Map<String, Object>> getIssueDetails(Integer ocId);

public List<DropdownModel> getVolumeGroup();

public List<DropdownModel> getInventory();

int deleteIssue(Integer issueId, Integer ocId);

public int updateJobModel(JobModel jobModel);

public int getJobId();

public List<DropdownModel> getLocation();

public List<DropdownModel> getQueue();

public int reOpenIssue(int ocId, int issueId);

public int markCurrentIssue(int ocId, int issueId);

List<DropdownModel> getSourceCodeStatusDetails();

public List<SubscriptionDef> getSubscriptionDef(Long ocId);

public List<DropdownModel> getLogicalStart();

public List<DropdownModel> getForcedExpireMonth();

public List<DropdownModel> getCancelPolicy();

public int saveSubscriptionDef(SubscriptionDef subscriptionDef);

public int getSubscriptionDefId();

public List<DropdownModel> getState();

public List<DropdownModel> getPremiumDetails(Long ocId);

public int updateSubscriptionDef(SubscriptionDef subscriptionDef);

public String deleteSubscriptionDef(int subscriptionDefId);
public int addPackageDefSave(PackageDefinationModel packageDefination);

public int updatePackageDef(PackageDefinationModel packageDefination,int pkgDefId);

public int deletePackageDetails(int pkgDefId);

public List<Map<String, Object>> getpackageDefinationDetails(int pkgDefId, int ocId);

public List<DropdownModel> getMethodList();

public List<DropdownModel> getCalendarUnits();

public List<DropdownModel> getSubscriberSiteType();

public List<DropdownModel> getRevenueOption();

public List<DropdownModel> getRenewalList();

public List<DropdownModel> getDiscountList();

public List<DropdownModel> getRateList();

public List<Map<String, Object>> getCheckValues(int pkgDefId);

public int saveSubscriptionstart(SubscriptionStart start);

public Map<String, Object> displaySubscriptionstart(Integer ocId, Integer numOfDays, String from_date, String to_date,
		String start_date, Integer numOfIssues, Integer issue_id, String volume, String action, String issue_date);

public List<Map<String, Object>> getIssueIdDetails(Integer ocId);

public List<Map<String, Object>> getOcIdDetails(Integer ocId);

public List<DropdownModel> getVolumeDetails();

public List<Map<String, Object>> getAddressDetails();

public List<Map<String, Object>> getByIssueDetailsByValue(String issueDate, Integer issueId, String enumeration,
		String volume_group, String description);


public List<DropdownModel> getallPubGroup( );
public List<DropdownModel> getGeographicalRegionList();
public List<Map<String, Object>> getQualificationSourceList();
public List<Map<String, Object>> getMailingAddressNameList();
public List<Map<String, Object>> getSalesChannelList();
public List<Map<String, Object>> getSubscriptionTypeList();
public int saveAuditTrackingPubDetails(AuditTrackingModel auditTrackingModel);
public int updateAuditTrackingPubDetails(AuditTrackingModel auditTrackingModel); 
public List<Map<String, Object>> getAuditTrackingPubDetails(int ocId);

public List<Map<String, Object>> getOrderDetails(Integer orderCodeId);


public List<Map<String, Object>> getQuickOrderCodeDetails(Integer ocId,Integer  orderCodeId);

public int updateQuickOrderCodeDetails(QuickOrderCodeModel  quickOrderCodeModel); 
public int saveQuickOrderCodeDetails(QuickOrderCodeModel  quickOrderCodeModel);




public List<Map<String, Object>> getContentDetails(Integer ordCodeId);

public List<DropdownModel> getPrepay();

public List<Map<String, Object>> getPkgFinaldetails(Integer orderCodeId, Integer pkgContentSeq);

public List<Map<String, Object>> getOtherData(Integer orderCodeId, Integer pkgContentSeq);

public int savePkgContents(PackageContentModel packageContent);

public int getPkgContentSeq(Integer orderCodeId);

public int getItemOrderCodeId(Integer orderCodeId);

public int updatePackageContent(PackageContentModel packageContent);

public int deletePackageContent(int orderCodeId);

public int saveProductDetails(ProductModel product);

public int getProductId();

public int updateDetails(ProductModel product);

public String deleteProductDetails(int productId);

public List<DropdownModel> getInventoryList();

public List<DropdownModel> getOrderList(int ocId);

public List<DropdownModel> getPremiumList(int ocId);

public List<Map<String, Object>> getSubscriptionStart(Integer ocId);



}