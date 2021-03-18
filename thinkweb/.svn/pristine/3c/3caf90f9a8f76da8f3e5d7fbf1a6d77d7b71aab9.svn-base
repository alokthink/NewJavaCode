package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.model.DropdownModel;
import com.mps.think.process.model.JobModel;

import com.mps.think.setup.dao.OrderClassDetailsDao;
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
import com.mps.think.setup.service.OrderClassService;

@Service("OrderClassDetailsService")
//@CacheConfig(cacheNames= {"dashboardLeftPanel"})//tells Spring where to store cache for this class
public class OrderClassServiceImpl implements OrderClassService {
	
	@Autowired 
	OrderClassDetailsDao orderClassDetailsDao;
    
    @Override
    public List<DropdownModel> getDefaultSourceCode(String  OrderClassID){
    	return orderClassDetailsDao.getDefaultSourceCode(OrderClassID);
    }

	@Override
	public List<Map<String, Object>> getOrderClassID1(String ocId) {
		return orderClassDetailsDao.getOrderClassID1(ocId);
	}

	@Override
	public List<DropdownModel> getSourceCodeFormat() {
		return orderClassDetailsDao.getSourceCodeFormat();
	}

	@Override
	public List<DropdownModel> getPaymentThresholdData() {
		return orderClassDetailsDao.getPaymentThresholdData();
	}
	@Override
	public List<DropdownModel> getProfitCenter() {
		return orderClassDetailsDao.getProfitCenter();
	}
	@Override
	public List<DropdownModel> getLabelOutputData() {
		return orderClassDetailsDao.getLabelOutputData();
	}
	@Override
	public List<Map<String, Object>> getTopicTableData(Long showId) {
		return orderClassDetailsDao.getTopicTableData(showId);
	}
	@Override
	public List<Map<String, Object>> getDiscountRates(int discClassId) {
		return orderClassDetailsDao.getDiscountRates(discClassId);
	}
	@Override
	public List<ParentOrderClassModel> getSourceCodeDetails(Long ocId, int active, int sourceCodeType, int isDdp) {
		return orderClassDetailsDao.getSourceCodeDetails(ocId,active,sourceCodeType, isDdp);
	}
	@Override
	public List<ParentOrderClassModel> getSourceCodeDetails(Long ocId){
		return orderClassDetailsDao.getSourceCodeDetails(ocId);
	}
	@Override
	public List<Map<String, Object>> getRateClassTableDetails(Long ocId) {
		return orderClassDetailsDao.getRateClassTableDetails(ocId);
	}
	@Override
	public List<Map<String, Object>> getRateClassDetails(int rateClassId) {
		return orderClassDetailsDao.getRateClassDetails(rateClassId);
	}
	@Override
	public List<DropdownModel> getRegionList() {
		return orderClassDetailsDao.getRegionList();
	}
	
	@Override
	public List<DropdownModel> getRegion(String regionList) {
		return orderClassDetailsDao.getRegion(regionList);
	}
	
	@Override
	public List<DropdownModel> lookupCurrency() {
		return orderClassDetailsDao.lookupCurrency();
	}

	@Override
	public List<DropdownModel> getDiscountCardUnitType() {
		return orderClassDetailsDao.getDiscountCardUnitType();
	}
	
	@Override
	public List<Map<String, Object>> getEffectiveDatesTableData(int rateClassId) {
		return orderClassDetailsDao.getEffectiveDatesTableData(rateClassId);
	}
	
	@Override
	public List<Map<String, Object>> getRateCardTableData(int rateClassId) {
		return orderClassDetailsDao.getRateCardTableData(rateClassId);
	}

	@Override
	public List<Map<String, Object>> getRateCardTableData(int rateClassId, int rateClassEffectiveSeq){
		return orderClassDetailsDao.getRateCardTableData(rateClassId, rateClassEffectiveSeq);
	}
	@Override
	public List<DropdownModel> getRenewalDropDownData(Long ocId) {
		return orderClassDetailsDao.getRenewalDropDownData(ocId);
	}

	//@Cacheable // caches the result of dashboardLeftPanel method
	@Override
	public List<DashboardLeftPanelModel> getleftPanelDashboardData() {
		return orderClassDetailsDao.getleftPanelDashboardData();
	}
	
	@Override
	public List<Map<String, Object>> getEffectiveDiscountData(int discountClassId) {
		return orderClassDetailsDao.getEffectiveDiscountData(discountClassId);
	}
	
	@Override
	public List<Map<String, Object>> getDropDownDefaultData(String ocId) {
		return orderClassDetailsDao.getDropDownDefaultData(ocId);
	}
	@Override
	public List<DropdownModel> getNewGroupMemberActionList(){
		return orderClassDetailsDao.getNewGroupMemberActionList();
	}
	@Override
	public  List<DropdownModel> getInventoryList(String ocId){
		return orderClassDetailsDao.getInventoryList(ocId);
	}
	
	@Override
	public  List<Map<String, Object>> getVGTargetSalesLevels(Long ocId){
		return orderClassDetailsDao.getVGTargetSalesLevels(ocId);
	}
	
	@Override
	public  List<Map<String, Object>> getTargetSalesLevels(Long ocId,Long volumeGroupId){
		return orderClassDetailsDao.getTargetSalesLevels(ocId, volumeGroupId);
	}
	
	@Override
	public  List<DropdownModel> getVolumeGroupList(){
		return orderClassDetailsDao.getVolumeGroupList();
	}
	
	@Override
	public  List<DropdownModel> getSubscriptionCategory(){
		return orderClassDetailsDao.getSubscriptionCategory();
	}
	
	@Override
	public  List<Map<String, Object>> getSubscriptionCategory(Long ocId, Long volumeGroupId){
		return orderClassDetailsDao.getSubscriptionCategory(ocId, volumeGroupId);
	}
	@Override
	public String saveTargetSalesLevels(VolumeGroup volumeGroup) {
		return orderClassDetailsDao.saveTargetSalesLevels(volumeGroup);
	}
	@Override
	public String updateTargetSalesLevels(VolumeGroup volumeGroup) {
		return orderClassDetailsDao.updateTargetSalesLevels(volumeGroup);
	}
	@Override
	public List<Map<String,Object>> getDemographicsTableData(int ocId){
		return orderClassDetailsDao.getDemographicsTableData(ocId);
	}
	@Override
	public int topicActiveSave(Long ocId, String topic) {
		return orderClassDetailsDao.topicActiveSave(ocId, topic);
	}

	@Override
	public int topicInActiveSave(Long ocId, String topic) {
		return orderClassDetailsDao.topicInActiveSave(ocId, topic);
	}

	@Override
	public List<UpSellModel> getUpSellTableData(){
		return orderClassDetailsDao.getUpSellTableData();
	}
	@Override
	public int addUpSell(UpSellModel upSellClassModel) {
		return orderClassDetailsDao.addUpSell(upSellClassModel);
	}

	@Override
	public List<UpSellModel> getUpSellTableDetails(Integer ocId,Integer upsellId) {
		return orderClassDetailsDao.getUpSellTableDetails(ocId, upsellId);
	}
	
	@Override
	public List<Map<String, Object>> getUpSellDetails(Integer ocId,Integer upsellId){
		return orderClassDetailsDao.getUpSellDetails(ocId, upsellId);
	}
	
	@Override
	public List<DropdownModel> getSuggestionList(){
		return orderClassDetailsDao.getSuggestionList();
	}
	
	@Override
	public List<CalendarCampaignModel> getCompaignList(){
		return orderClassDetailsDao.getCompaignList();
	}
	
	@Override
	public int deleteUpSellRecords(int upsellId) {
		return orderClassDetailsDao.deleteUpSellRecords(upsellId);
	}

	@Override
	public int updateUpSellRecords(UpSellModel upSellClassModel) {
		return orderClassDetailsDao.updateUpSellRecords(upSellClassModel);
	}
	
	@Override
	public int deleteRateClassRecords(int rateClassId) {
		return orderClassDetailsDao.deleteRateClassRecords(rateClassId);
	}
	
	@Override
	public List<DropdownModel> getSourceCodeTypeDetails(){
		return orderClassDetailsDao.getSourceCodeTypeDetails();
	}
	
	@Override
	public int updateDiscountClassRecords(DiscountClassModel discountClass){
		return orderClassDetailsDao.updateDiscountClassRecords(discountClass);
	}

	@Override
	public int deleteDiscountRecords(int ocId, int discountClassId){
		return orderClassDetailsDao.deleteDiscountRecords(ocId, discountClassId);
	}
	@Override
	public int updateRateDiscountRecords(DiscountClassModel discountClassModel){
		return orderClassDetailsDao.updateRateDiscountRecords(discountClassModel);
	}

	@Override
	public List<OrderCodeModel> getOrderCodeTableData(int ocId) {
		return orderClassDetailsDao.getOrderCodeTableData(ocId);
	}

	@Override
	public List<Map<String, Object>> getOrderCodeDetails(Long ocId, Long orderCodeId) {
		
		return orderClassDetailsDao.getOrderCodeDetails(ocId, orderCodeId);
	}

	@Override
	public int saveOrderCodeDetails(OrderCodeModel orderCodeModel) {
		return orderClassDetailsDao.saveOrderCodeDetails(orderCodeModel);
	}

	@Override
	public int updateOrderCodeDetails(OrderCodeModel orderCodeModel) {
		return orderClassDetailsDao.updateOrderCodeDetails(orderCodeModel);
	}

	@Override
	public String deleteOrderCodeDetails(int orderCodeId) {
		return orderClassDetailsDao.deleteOrderCodeDetails(orderCodeId);
	}
	
	@Override
	public List<DropdownModel> getTaxonomyList() {
		return orderClassDetailsDao.getTaxonomyList();
	}

	@Override
	public List<Map<String, Object>> getSingleIssueList(Long ocId) {
		return orderClassDetailsDao.getSingleIssueList(ocId);
	}

	@Override
	public List<DropdownModel> getPremiumList() {
		return orderClassDetailsDao.getPremiumList();
	}

	@Override
	public List<DropdownModel> getInstallmentPlans() {
		return orderClassDetailsDao.getInstallmentPlans();
	}

	@Override
	public List<DropdownModel> getAuditDefaults() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Map<String, Object>> getRateClassDetails(Long ocId){
		return orderClassDetailsDao.getRateClassDetails(ocId);
	}
	
	@Override
	public List<DropdownModel> getDiscountClassDetails(Long ocId){
		return orderClassDetailsDao.getDiscountClassDetails(ocId);
	}
	
	@Override
	public List<DropdownModel> getCreditCardProcess() {
		return orderClassDetailsDao.getCreditCardProcess();
	}
	@Override
	public List<DropdownModel> getSettleRetryDef(){
		return orderClassDetailsDao.getSettleRetryDef();
	}
	@Override
	public List<DropdownModel> getCommodityList() {
		return orderClassDetailsDao.getCommodityList();
	}

	@Override
	public List<DropdownModel> getUnitExcess() {
		return orderClassDetailsDao.getUnitExcess();
	}

	@Override
	public List<DropdownModel> getUnitTypeList() {
		return orderClassDetailsDao.getUnitTypeList();
	}

	@Override
	public List<DropdownModel> getTimeUnits() {
		return orderClassDetailsDao.getTimeUnits();
	}
	@Override
	public List<DropdownModel> getTrialTypeList() {
		return orderClassDetailsDao.getTrialTypeList();
	}
	
	@Override
	public List<DropdownModel> getDefaultTerm() {
		return orderClassDetailsDao.getDefaultTerm();
	}

	@Override
	public List<DropdownModel> getIssue(Long ocId) {
		return orderClassDetailsDao.getIssue(ocId);
	}
	
	@Override
	public List<DropdownModel> getConditionList() {
		return orderClassDetailsDao.getConditionList();
	}

	@Override
	public List<DropdownModel> getUpsellType() {
		return orderClassDetailsDao.getUpsellType();
	}

	@Override
	public List<Map<String, Object>> getDiscountClass(Long ocId){
		return orderClassDetailsDao.getDiscountClass(ocId);
	}

	@Override
	public int savePromotionCardDetails(PromotionCard promotionCard) {
		return orderClassDetailsDao.savePromotionCardDetails(promotionCard);
	}
	@Override
	public int getPromotionCardId() {
		return orderClassDetailsDao.getPromotionCardId();
	}

	@Override
	public List<Map<String, Object>> getPromotionCardDetails(Long ocId) {
		return orderClassDetailsDao.getPromotionCardDetails(ocId);
	}
	@Override
	public List<Map<String, Object>> getPromotionCardEffortDetails(Long promoCardId){
		return orderClassDetailsDao.getPromotionCardEffortDetails(promoCardId);
	}
	@Override
	public List<Map<String, Object>> getPromotionCardOfferDetails(Long promoCardId, Long promoCardEffortId){
		return orderClassDetailsDao.getPromotionCardOfferDetails(promoCardId, promoCardEffortId);
	}

	@Override
	public int updatePromotionCardDetails(PromotionCard promotionCard) {
		return orderClassDetailsDao.updatePromotionCardDetails(promotionCard);
	}

	@Override
	public List<Map<String, Object>> getDiscountRatesDetails() {
		return orderClassDetailsDao.getDiscountRatesDetails();
	}

	@Override
	public int savePromotionCardEffortDetails(PromotionCardEffort promotionCardEffort) {
		return orderClassDetailsDao.savePromotionCardEffortDetails(promotionCardEffort);
	}

	@Override
	public int getPromotionCardFromEffortId() {
		return orderClassDetailsDao.getPromotionCardFromEffortId();
	}
	@Override
	public int getPromotionCardOfferSeq() {
		return orderClassDetailsDao.getPromotionCardOfferSeq();
	}
	@Override
	public int updatePromotionCardEffortDetails(PromotionCardEffort promotionCardEffort) {
		return orderClassDetailsDao.updatePromotionCardEffortDetails(promotionCardEffort);
	}

	@Override
	public int savePromotionCardOfferDetails(PromotionCardOffer promotionCardOffer) {
		return orderClassDetailsDao.savePromotionCardOfferDetails(promotionCardOffer);
	}

	@Override
	public int updatePromotionCardOfferDetails(PromotionCardOffer promotionCardOffer) {
		return orderClassDetailsDao.updatePromotionCardOfferDetails(promotionCardOffer);
	}

	@Override
	public int saveEffectiveDateDiscountRecords(DiscClassEffective discClassEffective) {
		return orderClassDetailsDao.saveEffectiveDateDiscountRecords(discClassEffective);
	}
	@Override
	public List<Map<String, Object>> getDiscountClassEffectiveDateDetails(int discClassId){
		return orderClassDetailsDao.getDiscountClassEffectiveDateDetails(discClassId);
	}
	@Override
	public int updateEffectiveDateDiscountRecords(DiscClassEffective discClassEffective) {
		return orderClassDetailsDao.updateEffectiveDateDiscountRecords(discClassEffective);
	}
	
	@Override
	public int saveRateCardRecords(RateClassModel rateClassModel) {
		return orderClassDetailsDao.saveRateCardRecords(rateClassModel);
	}

	@Override
	public int updateRateCardRecords(RateClassModel rateClassModel) {
		return orderClassDetailsDao.updateRateCardRecords(rateClassModel);
	}

	@Override
	public int saveDiscountCardRecords(DiscountCard discountCard) {
		return orderClassDetailsDao.saveDiscountCardRecords(discountCard);
	}

	@Override
	public int updateDiscountCardRecords(DiscountCard discountCard) {
		return orderClassDetailsDao.updateDiscountCardRecords(discountCard);
	}
	@Override
	public int updateEffectiveRateDiscountRecords(DiscountClassModel discountClassModel) {
		return 0;
	}

	@Override
	public List<Map<String, Object>> getDiscountClassEffectiveDateTableData() {
		return orderClassDetailsDao.getDiscountClassEffectiveDateTableData();
	}

	@Override
	public List<Map<String, Object>> getDiscountCardRecords(int discClassId) {
		return orderClassDetailsDao.getDiscountCardRecords(discClassId);
	}
	
	@Override
	public List<Map<String, Object>> getDiscountCardRecords(int discountId, int disc_class_effective_Seq) {
		return orderClassDetailsDao.getDiscountCardRecords(discountId, disc_class_effective_Seq);
	}

	@Override
	public int getDiscountId() {
		return orderClassDetailsDao.getDiscountId();
	}

	@Override
	public List<Map<String, Object>> getAgencyRate(Integer rateClassId,Integer rateCardSeq) {
		return orderClassDetailsDao.getAgencyRate(rateClassId, rateCardSeq);
	}

	@Override
	public List<DropdownModel> getQtyDiscount() {
		return orderClassDetailsDao.getQtyDiscount();
	}

	@Override
	public int saveRateClassEffective(RateClassModel rateClassModel) {
		return orderClassDetailsDao.saveRateClassEffective(rateClassModel);
	}

	@Override
	public int updateRateClassEffective(RateClassModel rateClassModel) {
		return orderClassDetailsDao.updateRateClassEffective(rateClassModel);
	}

	@Override
	public Integer getDisc_class_effective_Seq(Integer discountId) {
		return orderClassDetailsDao.getDisc_class_effective_Seq(discountId);
	}
	@Override
	public Integer getRateClassEffectiveSeq(Integer rateClassId) {
		return orderClassDetailsDao.getRateClassEffectiveSeq(rateClassId);
	}

	@Override
	public List<Map<String, Object>> getRateCardCopyDetails(Integer rateClassId) {
		return orderClassDetailsDao.getRateCardCopyDetails(rateClassId);
	}
	
	@Override
	public List<Map<String, Object>> getRateCardCopyList(Integer rateClassId,Integer rateClassEffectiveSeq) {
		return orderClassDetailsDao.getRateCardCopyList(rateClassId,rateClassEffectiveSeq);
	}

	@Override
	public void insertBatchRateCard(List<RateClassModel> model) {
		orderClassDetailsDao.insertBatchRateCard(model);
		
	}

	@Override
	public List<DropdownModel> searchRateClass(Long ocId) {
		return orderClassDetailsDao.searchRateClass(ocId);
	}

	@Override
	public List<DropdownModel> searchRateClass(Long ocId, String rateClass) {
		return orderClassDetailsDao.searchRateClass(ocId, rateClass);
	}

	@Override
	public List<DropdownModel> searchRateClass(Long ocId, String rateClass, String rateDescription) {
		return orderClassDetailsDao.searchRateClass(ocId, rateClass, rateDescription);
	}

	@Override
	public List<DropdownModel> searchRateClass(Long ocId, Long rateClassId) {
		return orderClassDetailsDao.searchRateClass(ocId, rateClassId);
	}

	@Override
	public List<DropdownModel> searchDiscountClass(Long ocId) {
		return orderClassDetailsDao.searchDiscountClass(ocId);
	}

	@Override
	public List<DropdownModel> searchDiscountClass(Long ocId, String discountClass) {
		return orderClassDetailsDao.searchDiscountClass(ocId, discountClass);
	}

	@Override
	public List<DropdownModel> searchDiscountClass(Long ocId, String discountClass, String discountDescription) {
		return orderClassDetailsDao.searchDiscountClass(ocId, discountClass, discountDescription);
	}

	@Override
	public List<DropdownModel> searchDiscountClass(Long ocId, Long discountClassId) {
		return orderClassDetailsDao.searchDiscountClass(ocId, discountClassId);
	}

	@Override
	public List<Map<String, Object>> getRenewalCardDetails(Long ocId) {
		return orderClassDetailsDao.getRenewalCardDetails(ocId);
	}

	@Override
	public List<Map<String, Object>> getRenewalCardEffortDetails(Long renewalCardId) {
		return orderClassDetailsDao.getRenewalCardEffortDetails(renewalCardId);
	}

	@Override
	public List<Map<String, Object>> getRenewalCardOfferDetails(Long renewalCardId, Long renewalCardEffortId) {
		return orderClassDetailsDao.getRenewalCardOfferDetails(renewalCardId, renewalCardEffortId);
	}

	@Override
	public int getRenewalCardId() {
		return orderClassDetailsDao.getRenewalCardId();
	}

	@Override
	public int getRenewalCardEffortId(Integer renewalCardId) {
		return orderClassDetailsDao.getRenewalCardEffortId(renewalCardId);
	}

	@Override
	public int getRenewalCardOfferSeq(Integer renewalCardId,Integer renewalCardEffortId) {
		return orderClassDetailsDao.getRenewalCardOfferSeq(renewalCardId, renewalCardEffortId);
	}

	@Override
	public int saveRenewalCardDetails(RenewalCard renewalCard) {
		return orderClassDetailsDao.saveRenewalCardDetails(renewalCard);
	}

	@Override
	public int updateRenewalCardDetails(RenewalCard renewalCard) {
		return orderClassDetailsDao.updateRenewalCardDetails(renewalCard);
	}

	@Override
	public String saveRenewalCardEffortDetails(RenewalCard renewalCard) {
		return orderClassDetailsDao.saveRenewalCardEffortDetails(renewalCard);
	}

	@Override
	public String updateRenewalCardEffortDetails(RenewalCard renewalCard) {
		return orderClassDetailsDao.updateRenewalCardEffortDetails(renewalCard);
	}

	@Override
	public int saveRenewalCardOfferDetails(RenewalCard renewalCard) {
		return orderClassDetailsDao.saveRenewalCardOfferDetails(renewalCard);
	}

	@Override
	public int updateRenewalCardOfferDetails(RenewalCard renewalCard) {
		return orderClassDetailsDao.updateRenewalCardOfferDetails(renewalCard);
	}

	@Override
	public List<DropdownModel> getPubRotationList(Long ocId) {
		return orderClassDetailsDao.getPubRotationList(ocId);
	}

	@Override
	public List<DropdownModel> getWebDetails(Long ocId,Long orderCodeId,String shortDescription, String longDescription) {
		return orderClassDetailsDao.getWebDetails(ocId, orderCodeId,shortDescription, longDescription);
	}
	@Override
	public List<DropdownModel> getLanguageList(){
		return orderClassDetailsDao.getLanguageList();
	}

	@Override
	public int saveWebDetails(AlternateContent alternateContent) {
		return orderClassDetailsDao.saveWebDetails(alternateContent);
	}

	@Override
	public int updateWebDetails(AlternateContent alternateContent) {
		return orderClassDetailsDao.updateWebDetails(alternateContent);
	}
	
	@Override
	public List<DropdownModel> getTranslationDetails(Long ocId, Long orderCodeId, String description) {
		return orderClassDetailsDao.getTranslationDetails(ocId, orderCodeId, description);
	}
	
	@Override
	public List<Map<String, Object>> getGenericPromotionDefinition(Integer ocId,Integer sourceCodeId) {
		return orderClassDetailsDao.getGenericPromotionDefinition(ocId, sourceCodeId);
	}
	@Override
	public List<Map<String, Object>> getGenericPromotionCode(Integer sourceCodeId) {
		return orderClassDetailsDao.getGenericPromotionCode(sourceCodeId);
	}

	@Override
	public List<DropdownModel> getOrderCodeDetails(Long ocId) {
		return orderClassDetailsDao.getOrderCodeDetails(ocId);
	}

	@Override
	public List<DropdownModel> getAgencyDetails() {
		return orderClassDetailsDao.getAgencyDetails();
	}

	@Override
	public List<DropdownModel> getShippingPriceList() {
		return orderClassDetailsDao.getShippingPriceList();
	}

	@Override
	public List<DropdownModel> getSourceCodeAttributeValue() {
		return orderClassDetailsDao.getSourceCodeAttributeValue();
	}

	@Override
	public List<Map<String, Object>> getSourceCodeDetails(Integer sourceCodeId) {
		return orderClassDetailsDao.getSourceCodeDetails(sourceCodeId);
	}

	@Override
	public int deleteSourceCodeDetails(Integer sourceCodeId) {
		return orderClassDetailsDao.deleteSourceCodeDetails(sourceCodeId);
	}

	@Override
	public int saveGenericPromoCodeDetails(ParentOrderClassModel genericPromotion) {
		return orderClassDetailsDao.saveGenericPromoCodeDetails(genericPromotion);
	}

	@Override
	public List<DropdownModel> getSourceCodeStateDetails(Integer sourceCodeId) {
		return orderClassDetailsDao.getSourceCodeStateDetails(sourceCodeId);
	}

	@Override
	public List<DropdownModel> getRateList(Long ocId) {
		
		return orderClassDetailsDao.getRateList(ocId);
	}
	
	@Override
	public int getOrderCodeType(Integer orderCodeType) {
		return orderClassDetailsDao.getOrderCodeType(orderCodeType);
	}

	@Override
	public int getOrderCodeId() {
		return orderClassDetailsDao.getOrderCodeId();
	}

	@Override
	public void insertBatchOrderCodeDependency(List<OrderCodeModel> model) {
		orderClassDetailsDao.insertBatchOrderCodeDependency(model);		
	}

	@Override
	public String updateDependencies(OrderCodeModel model) {
		return orderClassDetailsDao.updateDependencies(model);
	}

	@Override
	public List<DropdownModel> getOrderCodeDependecies(Integer orderCodeId) {
		return orderClassDetailsDao.getOrderCodeDependecies(orderCodeId);
	}

	@Override
	public String saveDependencies(OrderCodeModel model) {
		return orderClassDetailsDao.saveDependencies(model);
	}

	@Override
	public List<DropdownModel> getQuestionsList() {
		return orderClassDetailsDao.getQuestionsList();
	}

	@Override
	public List<DropdownModel> getQuestionOverrideList(Integer demFormId, Integer demFormQuestionSeq) {
		return orderClassDetailsDao.getQuestionOverrideList(demFormId, demFormQuestionSeq);
	}

	@Override
	public List<DropdownModel> getResponsesList(Integer demQuestionId) {
		return orderClassDetailsDao.getResponsesList(demQuestionId);
	}

	@Override
	public List<Map<String, Object>> getDemFormResponseDetails(Integer demFormId, Integer demFormQuestionSeq) {
		return orderClassDetailsDao.getDemFormResponseDetails(demFormId, demFormQuestionSeq);
	}

	@Override
	public List<DropdownModel> getResponsesOverrideList(Integer demFormId, Integer demFormQuestionSeq,Integer demFormResponseSeq) {
		return orderClassDetailsDao.getResponsesOverrideList(demFormId, demFormQuestionSeq, demFormResponseSeq);
	}

	@Override
	public List<Map<String, Object>> getDemFormDetails(Integer demFormId) {
		return orderClassDetailsDao.getDemFormDetails(demFormId);
	}

	@Override
	public List<Map<String, Object>> getDemFormDetails(Integer demFormId, Integer demFormQuestionSeq) {
		return orderClassDetailsDao.getDemFormDetails(demFormId, demFormQuestionSeq);
	}

	@Override
	public List<Map<String, Object>> getDemFormQuestionDetails(Integer demFormId) {
		return orderClassDetailsDao.getDemFormQuestionDetails(demFormId);
	}

	@Override
	public int saveDemForm(DemographicForms DemForm) {
		return orderClassDetailsDao.saveDemForm(DemForm);
	}

	@Override
	public int updateDemForm(DemographicForms DemForm) {
		return orderClassDetailsDao.updateDemForm(DemForm);
	}

	@Override
	public int getDemFormId() {
		return orderClassDetailsDao.getDemFormId();
	}

	@Override
	public int getDemFormQuestionSeq(Integer demFormId) {
		return orderClassDetailsDao.getDemFormQuestionSeq(demFormId);
	}

	@Override
	public int getDemFormResponseSeq(Integer demFormId, Integer demFormQuestionSeq) {
		return orderClassDetailsDao.getDemFormResponseSeq(demFormId, demFormQuestionSeq);
	}

	@Override
	public String deleteDemographics(int demFormId) {
		return orderClassDetailsDao.deleteDemographics(demFormId);
	}

	@Override
	public List<DropdownModel> copyDemographics(Integer demFormId, String demForm, Integer ocId, String active) {
		return orderClassDetailsDao.copyDemographics(demFormId, demForm, ocId, active);
	}

	@Override
	public List<Map<String, Object>> getProductDetails(Integer ocId) {
		return orderClassDetailsDao.getProductDetails(ocId);
	}


	/*===============================================================*/
	
	@Override
	public int savePubRotationDetails(PubRotation pubRotation) {
		return orderClassDetailsDao.savePubRotationDetails(pubRotation);
	}

	@Override
	public int getPubRotationId() {
		return orderClassDetailsDao.getPubRotationId();
	}

	@Override
	public int updatePubRotationDetails(PubRotation pubRotation) {
		return orderClassDetailsDao.updatePubRotationDetails(pubRotation);
	}

	@Override
	public int savePubDetails(Pub pub) {
		return orderClassDetailsDao.savePubDetails(pub);
	}

	@Override
	public int getOcId() {
		return orderClassDetailsDao.getOcId();
	}

	@Override
	public int updatePubDetails(Pub pub) {
		return orderClassDetailsDao.updatePubDetails(pub);
	}

	@Override
	public List<Pub> getSelectPubDetails(Integer ocId) {
		return orderClassDetailsDao.getSelectPubDetails(ocId);
	}

	@Override
	public List<DropdownModel> getCalenderUnit() {
		return orderClassDetailsDao.getCalenderUnit();
	}

	@Override
	public List<DropdownModel> getOnCalendarUnit() {
		return orderClassDetailsDao.getOnCalendarUnit();
	}

	@Override
	public List<DropdownModel> getVolumeFormat() {
		return orderClassDetailsDao.getVolumeFormat();
	}

	@Override
	public List<DropdownModel> getIssueFormat() {
		return orderClassDetailsDao.getIssueFormat();
	}

	@Override
	public List<PubRotation> getPubRotationDetails(Integer ocId) {
		return orderClassDetailsDao.getPubRotationDetails(ocId);
	}

	/*---------------------------------------------------------*/
	
	@Override
	public List<Map<String, Object>> getIssueDetails(Integer ocId) {
		return orderClassDetailsDao.getIssueDetails(ocId);
	}
	
	@Override
	public int deleteIssue(Integer issueId, Integer ocId) {
		return orderClassDetailsDao.deleteIssue(issueId, ocId);
	}
	
	@Override
	public int saveIssue(Issue issue) {
		return orderClassDetailsDao.saveIssue(issue);
	}

	@Override
	public int getIssueId() {
		return orderClassDetailsDao.getIssueId();
	}

	@Override
	public List<DropdownModel> getLocation() {
		return orderClassDetailsDao.getLocation();
	}
	
	@Override
	public List<DropdownModel> getVolumeGroup() {
		return orderClassDetailsDao.getVolumeGroup();
	}

	@Override
	public List<DropdownModel> getInventory() {
		return orderClassDetailsDao.getInventory();
	}

	@Override
	public int updateIssue(Issue issue) {
		return orderClassDetailsDao.updateIssue(issue);
	}

	@Override
	public int updateJobModel(JobModel jobModel) {
		return orderClassDetailsDao.updateJobModel(jobModel);
	}

	@Override
	public int getJobId() {
		return orderClassDetailsDao.getJobId();
	}

	@Override
	public List<DropdownModel> getQueue() {
		return orderClassDetailsDao.getQueue();
	}

	@Override
	public int reOpenIssue(int ocId, int issueId) {
		return orderClassDetailsDao.reOpenIssue(ocId, issueId);
	}

	@Override
	public int markCurrentIssue(int ocId, int issueId) {
		return orderClassDetailsDao.markCurrentIssue(ocId, issueId);
	}

	@Override
	public List<SubscriptionDef> getSubscriptionDef(Long ocId) {
		return orderClassDetailsDao.getSubscriptionDef(ocId);
	}

	@Override
	public List<DropdownModel> getLogicalStart() {
		return orderClassDetailsDao.getLogicalStart();
	}

	@Override
	public List<DropdownModel> getForcedExpireMonth() {
		return orderClassDetailsDao.getForcedExpireMonth();
	}

	@Override
	public List<DropdownModel> getCancelPolicy() {
		return orderClassDetailsDao.getCancelPolicy();
	}

	@Override
	public int saveSubscriptionDef(SubscriptionDef subscriptionDef) {
		return orderClassDetailsDao.saveSubscriptionDef(subscriptionDef);
	}

	@Override
	public int getSubscriptionDefId() {
		return orderClassDetailsDao.getSubscriptionDefId();
	}

	@Override
	public List<DropdownModel> getSourceCodeStatusDetails() {
		return orderClassDetailsDao.getSourceCodeStatusDetails();
	}

	@Override
	public List<DropdownModel> getState() {
		return orderClassDetailsDao.getState();
	}

	@Override
	public List<DropdownModel> getPremiumDetails(Long ocId) {
		return orderClassDetailsDao.getPremiumDetails(ocId);
	}

	@Override
	public int updateSubscriptionDef(SubscriptionDef subscriptionDef) {
		return orderClassDetailsDao.updateSubscriptionDef(subscriptionDef);
	}

	@Override
	public String deleteSubscriptionDef(int subscriptionDefId) {
		return orderClassDetailsDao.deleteSubscriptionDef(subscriptionDefId);
	}
	@Override
	public int  addPackageDefSave(PackageDefinationModel packageDefination){
		return orderClassDetailsDao.addPackageDefSave(packageDefination);
	}

	@Override
	public int updatePackageDef(PackageDefinationModel packageDefination,int pkgDefId) {
		return orderClassDetailsDao.updatePackageDef(packageDefination, pkgDefId) ;
	}

	@Override
	public int deletePackageDetails(int pkgDefId) {
		return orderClassDetailsDao.deletePackageDetails(pkgDefId) ;
	}

	@Override
	public List<Map<String, Object>> getpackageDefinationDetails(int pkgDefId, int ocId) {
		return orderClassDetailsDao.getpackageDefinationDetails(pkgDefId,ocId);
	}

	@Override
	public List<DropdownModel> getMethodList() {
		return orderClassDetailsDao.getMethodList() ;
	}

	@Override
	public List<DropdownModel> getCalendarUnits() {
		return orderClassDetailsDao.getCalendarUnits();
	}

	@Override
	public List<DropdownModel> getSubscriberSiteType() {
		return orderClassDetailsDao.getSubscriberSiteType();
	}

	@Override
	public List<DropdownModel> getRevenueOption() {
		return orderClassDetailsDao.getRevenueOption();
	}

	@Override
	public List<DropdownModel> getRenewalList() {
		return orderClassDetailsDao.getRenewalList();
	}

	@Override
	public List<DropdownModel> getDiscountList() {
		return orderClassDetailsDao.getDiscountList();
	}

	@Override
	public List<DropdownModel> getRateList() {
		return orderClassDetailsDao.getRateList();
	}

	@Override
	public List<Map<String, Object>> getCheckValues(int pkgDefId) {
		return orderClassDetailsDao.getCheckValues(pkgDefId);
	}

	@Override
	public int saveSubscriptionstart(SubscriptionStart start) {
		return orderClassDetailsDao.saveSubscriptionstart(start);
	}

	@Override
	public Map<String, Object> displaySubscriptionstart(Integer ocId, Integer numOfDays, String from_date,
			String to_date, String start_date, Integer numOfIssues, Integer issue_id, String volume, String action,
			String issue_date) {
		return orderClassDetailsDao.displaySubscriptionstart(ocId, numOfDays, from_date, to_date, start_date, numOfIssues, issue_id, volume, action, issue_date);
	}

	@Override
	public List<Map<String, Object>> getIssueIdDetails(Integer ocId) {
		return orderClassDetailsDao.getIssueIdDetails(ocId);
	}

	@Override
	public List<Map<String, Object>> getOcIdDetails(Integer ocId) {
		return orderClassDetailsDao.getOcIdDetails(ocId);
	}

	@Override
	public List<DropdownModel> getVolumeDetails() {
		return orderClassDetailsDao.getVolumeDetails();
	}

	@Override
	public List<Map<String, Object>> getAddressDetails() {
		return orderClassDetailsDao.getAddressDetails();
	}

	@Override
	public List<Map<String, Object>> getByIssueDetailsByValue(String issueDate,Integer issueId, String enumeration,
			String volume_group, String description) {
		return orderClassDetailsDao.getIssueByValue(issueDate, issueId, enumeration, volume_group, description);
	}

	@Override
	public List<DropdownModel> getallPubGroup() {
		return orderClassDetailsDao.getallPubGroup();
	}

	

	@Override
	public List<Map<String, Object>> getQualificationSourceList() {
		return orderClassDetailsDao.getQualificationSourceList();
	}

	@Override
	public List<Map<String, Object>> getMailingAddressNameList() {
		return orderClassDetailsDao.getMailingAddressNameList();
	}

	@Override
	public List<Map<String, Object>> getSalesChannelList() {
		return orderClassDetailsDao.getSalesChannelList();
	}

	@Override
	public List<Map<String, Object>> getSubscriptionTypeList() {
	return orderClassDetailsDao.getSubscriptionTypeList();
	}

	@Override
	public List<DropdownModel> getGeographicalRegionList() {
		return orderClassDetailsDao.getGeographicalRegionList();
	}

		 
	@Override
	public int saveAuditTrackingPubDetails(AuditTrackingModel auditTrackingModel) {
		return orderClassDetailsDao.saveAuditTrackingPubDetails(auditTrackingModel);
	}

	@Override
	public int updateAuditTrackingPubDetails(AuditTrackingModel auditTrackingModel) {
		return orderClassDetailsDao.updateAuditTrackingPubDetails(auditTrackingModel);
	}

	@Override
	public List<Map<String, Object>> getAuditTrackingPubDetails(int ocId) {
	return orderClassDetailsDao.getAuditTrackingPubDetails(ocId);
	}

	@Override
	public List<Map<String, Object>> getQuickOrderCodeDetails(Integer ocId,Integer  orderCodeId) {
		return  orderClassDetailsDao.getQuickOrderCodeDetails(ocId, orderCodeId);
	}

	@Override
	public int updateQuickOrderCodeDetails(QuickOrderCodeModel quickOrderCodeModel) {
		return  orderClassDetailsDao.updateQuickOrderCodeDetails(quickOrderCodeModel);
	}

	@Override
	public int saveQuickOrderCodeDetails(QuickOrderCodeModel quickOrderCodeModel) {
		return  orderClassDetailsDao.saveQuickOrderCodeDetails(quickOrderCodeModel);
			
	}


	@Override
	public List<Map<String, Object>> getOrderDetails(Integer orderCodeId) {
		return orderClassDetailsDao.getOrderDetails(orderCodeId);
	}

	@Override
	public List<Map<String, Object>> getContentDetails(Integer ordCodeId) {
		return orderClassDetailsDao.getContentDetails(ordCodeId);
	}

	@Override
	public List<DropdownModel> getPrepay() {
		return orderClassDetailsDao.getPrepay();
	}

	@Override
	public List<Map<String, Object>> getPkgFinaldetails(Integer orderCodeId, Integer pkgContentSeq) {
		return orderClassDetailsDao.getPkgFinaldetails(orderCodeId,pkgContentSeq);
	}

	@Override
	public List<Map<String, Object>> getOtherData(Integer orderCodeId, Integer pkgContentSeq) {
		return orderClassDetailsDao.getOtherData(orderCodeId,pkgContentSeq);
	}

	@Override
	public int savePkgContents(PackageContentModel packageContent) {
		return orderClassDetailsDao.savePkgContents(packageContent);
	}

	@Override
	public int getPkgContentSeq(Integer orderCodeId) {
		return orderClassDetailsDao.getPkgContentSeq(orderCodeId);
	}

	@Override
	public int getItemOrderCodeId(Integer orderCodeId) {
		return orderClassDetailsDao.getItemOrderCodeId(orderCodeId);
	}

	@Override
	public int updatePackageContent(PackageContentModel packageContent) {
		return orderClassDetailsDao.updatePackageContent(packageContent);
	}

	@Override
	public int deletePackageContent(int orderCodeId) {
		return orderClassDetailsDao.deletePackageContent(orderCodeId);
	}

	@Override
	public int saveProductDetails(ProductModel product) {
		return orderClassDetailsDao.saveProductDetails(product);
	}

	@Override
	public int getProductId() {
		return orderClassDetailsDao.getProductId();
	}

	@Override
	public int updateDetails(ProductModel product) {
		return orderClassDetailsDao.updateDetails(product);
	}

	@Override
	public String deleteProductDetails(int productId) {
		return orderClassDetailsDao.deleteProductDetails(productId);
	}

	@Override
	public List<DropdownModel> getInventoryList() {
		return orderClassDetailsDao.getInventoryList();
	}

	@Override
	public List<DropdownModel> getOrderList(int ocId) {
		return orderClassDetailsDao.getOrderList(ocId);
	}

	@Override
	public List<DropdownModel> getPremiumList(int ocId) {
		return orderClassDetailsDao.getPremiumList(ocId);
	}

	@Override
	public List<Map<String, Object>> getSubscriptionStart(Integer ocId) {
		return orderClassDetailsDao.getSubscriptionStart(ocId);
	}

}



