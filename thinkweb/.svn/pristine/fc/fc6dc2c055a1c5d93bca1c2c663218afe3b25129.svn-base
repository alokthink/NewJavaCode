package com.mps.think.setup.tablesetup.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.model.DropdownModel;
import com.mps.think.setup.tablesetup.dao.TableSetupDao;
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
import com.mps.think.setup.tablesetup.service.TableSetupService;

@Service("tableSetupService")
public class TableSetupServiceImpl implements TableSetupService {

	@Autowired 
	TableSetupDao tableSetupDao;

	@Override
	public int saveAddressStatus(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveAddressStatus(tableSetupModel);
	}

	@Override
	public int updateAddressState(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateAddressState(tableSetupModel);
	}

	@Override
	public int deleteAddressState(String addressStatus) {
		return tableSetupDao.deleteAddressState(addressStatus);
	}

	@Override
	public int saveAddressType(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveAddressType(tableSetupModel);
	}

	@Override
	public int updateAddressType(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateAddressType(tableSetupModel);
	}

	@Override
	public int saveAttachmentCatagorySave(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveAttachmentCatagorySave(tableSetupModel);
	}

	@Override
	public int updateAttachCategory(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateAttachCategory(tableSetupModel);
	}

	@Override
	public int deleteAttachCategory(String attachmentCatagory) {
		return tableSetupDao.deleteAttachCategory(attachmentCatagory);
	}

	@Override
	public int saveAuxField(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveAuxField(tableSetupModel);
	}

	@Override
	public int updateAuxField(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateAuxField(tableSetupModel);
	}

	@Override
	public int saveCreditStatus(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveCreditStatus(tableSetupModel);
	}

	@Override
	public int updateCreditStatus(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateCreditStatus(tableSetupModel);
	}


	@Override
	public int deleteAuxField(String tableName) {
		return tableSetupDao.deleteAuxField(tableName);
	}

	@Override
	public int saveCustomerCategory(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveCustomerCategory(tableSetupModel);
	}

	@Override
	public int updateCustomerCategory(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateCustomerCategory(tableSetupModel);
	}

	@Override
	public int saveCustomerRentList(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveCustomerRentList(tableSetupModel);
	}

	@Override
	public int updateCustomerRentList(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateCustomerRentList(tableSetupModel);
	}

	@Override
	public int saveCustomerLoginQuestion(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveCustomerLoginQuestion(tableSetupModel);
	}

	@Override
	public int updateCustomerLoginQuetion(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateCustomerLoginQuetion(tableSetupModel);
	}

	@Override
	public int deleteCustomerLoginQuestion(int customerLoginQuestionId) {
		return tableSetupDao.deleteCustomerLoginQuestion(customerLoginQuestionId);
	}

	@Override
	public int updateCustomerLookup(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateCustomerLookup(tableSetupModel);
	}

	@Override
	public List<Map<String, Object>> getDefalutDetails(String search) {
		return tableSetupDao.getDefalutDetails(search);
	}

	@Override
	public List<Map<String, Object>> getSerachFieldGroup(String search) {
		return tableSetupDao.getSerachFieldGroup(search);
	}

	@Override
	public List<Map<String, Object>> getSearchResultDisplay(String search) {
		return tableSetupDao.getSearchResultDisplay(search);
	}

	@Override
	public List<DropdownModel> getDispContext() {
		return tableSetupDao.getDispContext();
	}

	/*@Override
	public List<DropdownModel> getFollowOnServicePage() {
		return tableSetupDao.getFollowOnServicePage();
	}*/

	@Override
	public int saveCustomerMatchcode(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveCustomerMatchcode(tableSetupModel);
	}

	@Override
	public int updateCustomerMatchCode(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateCustomerMatchCode(tableSetupModel);
	}

	@Override
	public int deleteCustomerMatchCode(int custMatchCodeDetailSeq, int customerMatchCodeId) {
		return tableSetupDao.deleteCustomerMatchCode(custMatchCodeDetailSeq,customerMatchCodeId);
	}

	@Override
	public List<Map<String, Object>> getMatchCodeValues(int customerMatchCodeId) {
		return tableSetupDao.getMatchCodeValues(customerMatchCodeId);
	}

	@Override
	public List<Map<String, Object>> getMatchCodeDetails(int custMatchCodeDetailSeq) {
		return tableSetupDao.getMatchCodeDetails(custMatchCodeDetailSeq);
	}

	@Override
	public List<DropdownModel> getColumnName() {
		return tableSetupDao.getColumnName();
	}

	@Override
	public List<DropdownModel> getUseNextSegment() {
		return tableSetupDao.getUseNextSegment();
	}

	@Override
	public int ProspectCategory(TableSetupModel tableSetupModel) {
		return tableSetupDao.ProspectCategory(tableSetupModel);
	}

	@Override
	public int updateCustomerProspectCategory(TableSetupModel tableSetupModel) {
		return tableSetupDao.updateCustomerProspectCategory(tableSetupModel);
	}

	@Override
	public int saveSalesRepresatative(TableSetupModel tableSetupModel) {
		return tableSetupDao.saveSalesRepresatative(tableSetupModel);
	}

	@Override
	public int updatecustomerSalesRepresentative(TableSetupModel tableSetupModel) {
		return tableSetupDao.updatecustomerSalesRepresentative(tableSetupModel);
	}

	@Override
	public int deleteCustomerSaleRep(int salesRepresentativeId) {
		return tableSetupDao.deleteCustomerSaleRep(salesRepresentativeId);
	}

	@Override
	public int deleteCustomerProspectCategory(String prospectCategory) {
		return tableSetupDao.deleteCustomerProspectCategory(prospectCategory);
	}
	
	@Override
	public int saveprofitCenterOrderClass(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return tableSetupDao.saveprofitCenterOrderClass(tableSetupOrderClassModel);
	}



	@Override
	public int updateProfitCenterOrderClass(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return tableSetupDao.updateProfitCenterOrderClass(tableSetupOrderClassModel);
	}

@Override
	public int saveTopic(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return  tableSetupDao.saveTopic(tableSetupOrderClassModel);
	}



	@Override
	public int updateTopic(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return tableSetupDao.updateTopic(tableSetupOrderClassModel);
	}



	@Override
	public int saveSourceCodeFormat(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return tableSetupDao.saveSourceCodeFormat(tableSetupOrderClassModel);
	}



	@Override
	public int updateSourceFormat(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return tableSetupDao.updateSourceFormat(tableSetupOrderClassModel);
	}



	@Override
	public int saveVolumeGroup(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return tableSetupDao.saveVolumeGroup(tableSetupOrderClassModel);
	}



	@Override
	public int updateVolumeGroup(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return tableSetupDao.updateVolumeGroup(tableSetupOrderClassModel);
	}


@Override
	public int deleteRentList(String listRentalCategory) {
		return tableSetupDao.deleteRentList(listRentalCategory);
	}

	@Override
	public int deleteCategory(String customerCategory) {
		return tableSetupDao.deleteCategory(customerCategory);
	}

	@Override
	public int deleteCrditStatus(String creditStatus) {
		return tableSetupDao.deleteCrditStatus(creditStatus);
	}

	@Override
	public int deleteAddressType(String addressType) {
		return tableSetupDao.deleteAddressType(addressType);
	}
	@Override
	public int deleteTopic(String topic,int ocId) {
		return tableSetupDao.deleteTopic(topic,ocId);
	}


	@Override
	public int deleteVolumeGroup(int volumeGroupId) {
		return tableSetupDao.deleteVolumeGroup(volumeGroupId);
	}

	@Override
	public int deleteProfitCenter(String profitCenter) {
		return  tableSetupDao.deleteProfitCenter(profitCenter);
	}

	@Override
	public int savePayments(PaymentsModel paymetsModel) {
		return tableSetupDao.savePayments(paymetsModel);
	}

	@Override
	public int updatePayments(PaymentsModel paymetsModel) {
		return tableSetupDao.updatePayments(paymetsModel);
	}

	@Override
	public int deletePaymentThreshold(String paymentThreshold) {
		return tableSetupDao.deletePaymentThreshold(paymentThreshold);
	}

	@Override
	public int savePaymentType(PaymentsModel paymetsModel) {
		return tableSetupDao.savePaymentType(paymetsModel);
	}

	@Override
	public int updatePaymentType(PaymentsModel paymetsModel) {
		return tableSetupDao.updatePaymentType(paymetsModel);
	}

	@Override
	public int deletePaymentType(String paymentType) {
		return tableSetupDao.deletePaymentType(paymentType);
	}

	@Override
	public int saveTransactionReason(PaymentsModel paymetsModel) {
		return tableSetupDao.saveTransactionReason(paymetsModel);
	}

	@Override
	public int updateTransactionReason(PaymentsModel paymetsModel) {
		return tableSetupDao.updateTransactionReason(paymetsModel);
	}

	@Override
	public int deleteTransactionReason(String transactionReason) {
		return tableSetupDao.deleteTransactionReason(transactionReason);
	}

	@Override
	public int saveInstallementplanDetails(PaymentsModel paymetsModel) {
		return tableSetupDao.saveInstallementplanDetails(paymetsModel);
	}

	@Override
	public int saveInstallementplan(PaymentsModel paymetsModel) {
		return tableSetupDao.saveInstallementplan(paymetsModel);
	}

	@Override
	public int deleteIntallmentPlan(int installmentPlanId) {
		return tableSetupDao.deleteIntallmentPlan(installmentPlanId);
	}

	@Override
	public int updateInstallmentPlan(PaymentsModel paymetsModel) {
		return tableSetupDao.updateInstallmentPlan(paymetsModel);
	}

	@Override
	public int saveSettleRetryDef(PaymentsModel paymetsModel) {
		return tableSetupDao.saveSettleRetryDef(paymetsModel);
	}

	@Override
	public int updateSettleRetryDef(PaymentsModel paymetsModel) {
		return tableSetupDao.updateSettleRetryDef(paymetsModel);
	}

	@Override
	public int deleteSettleRetrydef(String settleRetryDef) {
		return tableSetupDao.deleteSettleRetrydef(settleRetryDef);
	}

	@Override
	public int saveQtyDiscountScheduleDtl(PaymentsModel paymetsModel) {
		return tableSetupDao.saveQtyDiscountScheduleDtl(paymetsModel);
	}

	@Override
	public int saveQtyDiscountSchedule(PaymentsModel paymetsModel) {
		return tableSetupDao.saveQtyDiscountSchedule(paymetsModel);
	}

	@Override
	public int updateQtyDiscountSchedule(PaymentsModel paymetsModel) {
		return tableSetupDao.updateQtyDiscountSchedule(paymetsModel);
	}

	@Override
	public int deleteQtyDiscountSchedule(String qtyDiscountSchedule, int qtyDiscountSchedDtlSeq) {
		return tableSetupDao.deleteQtyDiscountSchedule(qtyDiscountSchedule,qtyDiscountSchedDtlSeq);
	}

	@Override
	public int deleteQtyDiscountScheduleDtl(String qtyDiscountSchedule) {
		return tableSetupDao.deleteQtyDiscountScheduleDtl(qtyDiscountSchedule);
	}

	@Override
	public int saveMultilinDiscountSchedule(PaymentsModel paymetsModel) {
		return tableSetupDao.saveMultilinDiscountSchedule(paymetsModel);
	}

	@Override
	public int saveMultilineDiscEff(PaymentsModel paymetsModel) {
		return tableSetupDao.saveMultilineDiscEff(paymetsModel);
	}

	@Override
	public int saveMultilineDiscSchedDtl(PaymentsModel paymetsModel) {
		return tableSetupDao.saveMultilineDiscSchedDtl(paymetsModel);
	}

	@Override
	public int updateMultilineDiscountSchedule(PaymentsModel paymetsModel) {
		return tableSetupDao.updateMultilineDiscountSchedule(paymetsModel);
	}

	@Override
	public int deleteMultilineDiscountScheduleDetails(String multilineDiscountSchedule, Integer multilineDiscEffSeq,Integer multiDiscScheddtlSeq) {
		return tableSetupDao.deleteMultilineDiscountScheduleDetails(multilineDiscountSchedule,multilineDiscEffSeq,multiDiscScheddtlSeq);
	}
	@Override
	public int saveCancelReason(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveCancelReason(tableSetupOrdersModel);
	}

	@Override
	public int updateCancelReason(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateCancelReason(tableSetupOrdersModel);
	}

	@Override
	public int deleteCancelReason(String cancelReason) {
		return tableSetupDao.deleteCancelReason(cancelReason);
	}

	@Override
	public int saveCancelPolicy(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveCancelPolicy(tableSetupOrdersModel);
	}

	@Override
	public int updateCancelPolicy(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateCancelPolicy(tableSetupOrdersModel);
	}

	@Override
	public int deleteCancelPolicy(int cancelPolicyId) {
		return tableSetupDao.deleteCancelPolicy(cancelPolicyId);
	}

	@Override
	public int saveListPremiumUsed(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveListPremiumUsed(tableSetupOrdersModel);
	}

	@Override
	public int updateListPremiumUsed(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateListPremiumUsed(tableSetupOrdersModel);
	}

	@Override
	public int deleteListPremiumUsed(String orderCode, int ocId) {
		return tableSetupDao.deleteListPremiumUsed(orderCode, ocId);
	}

	
	@Override
	public int saveOrders(TableSetupOrdersModel tableSetupOrdersModel) {
	return tableSetupDao.saveOrders(tableSetupOrdersModel);
}

	@Override
	public int updateOrders(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateOrders(tableSetupOrdersModel);
	}

	@Override
	public int deleteOrders(String search, int searchFieldGroupSeq, int searchResultDisplaySeq) {
		return tableSetupDao.deleteOrders(search, searchFieldGroupSeq, searchResultDisplaySeq);
	}

	@Override
	public int saveOrderCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		
		return tableSetupDao.saveOrderCategory(tableSetupOrdersModel);
	}

	@Override
	public int updateOrderCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		return  tableSetupDao.updateOrderCategory(tableSetupOrdersModel);
	}

	@Override
	public int deleteOrderCategory(String orderCategory) {
		return tableSetupDao.deleteOrderCategory(orderCategory);
	}

	@Override
	public int saveSubscriptionCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveSubscriptionCategory(tableSetupOrdersModel);
	}

	@Override
	public int updateSubscriptionCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateSubscriptionCategory(tableSetupOrdersModel);
	}

	@Override
	public int deleteSubscriptionCategory(int subscriptionCategoryId) {
		return tableSetupDao.deleteSubscriptionCategory(subscriptionCategoryId);
	}

	@Override
	public int saveTaxonomy(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveTaxonomy(tableSetupOrdersModel);
	}

	@Override
	public int updateTaxonomy(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateTaxonomy(tableSetupOrdersModel);
	}

	@Override
	public int deleteTaxonomy(String taxonomy) {
		return tableSetupDao.deleteTaxonomy(taxonomy);
	}

	@Override
	public int saveTerm(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveTerm(tableSetupOrdersModel);
	}

	@Override
	public int updateTerm(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateTerm(tableSetupOrdersModel);
	}

	@Override
	public int deleteTerm(int termId) {
		return  tableSetupDao.deleteTerm(termId);
	}

	@Override
	public int saveUnitTypes(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveUnitTypes(tableSetupOrdersModel);
	}

	@Override
	public int updateUnitTypes(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateUnitTypes(tableSetupOrdersModel);
	}

	@Override
	public int deleteUnitTypes(int unitTypeId) {
		return tableSetupDao.deleteUnitTypes(unitTypeId);
	}

	@Override
	public int saveUpsellSuggestion(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveUpsellSuggestion(tableSetupOrdersModel);
	}

	@Override
	public int updateUpsellSuggestion(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateUpsellSuggestion(tableSetupOrdersModel);
	}

	@Override
	public int deleteUpsellSuggestion(int upsellSuggestionId) {
		return tableSetupDao.deleteUpsellSuggestion(upsellSuggestionId);
	}

	@Override
	public int saveCalenderCampaign(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.saveCalenderCampaign(tableSetupOrdersModel);
	}

	@Override
	public int updateCalenderCampaign(TableSetupOrdersModel tableSetupOrdersModel) {
		return tableSetupDao.updateCalenderCampaign(tableSetupOrdersModel);
	}

	@Override
	public int deleteCalenderCampaign(int calenderCampaignId) {
		return tableSetupDao.deleteCalenderCampaign(calenderCampaignId);
	}

	@Override
	public List<Map<String, Object>> getOrderDetails(String search, int searchFieldGroupSeq, int searchResultDisplaySeq) {
		return tableSetupDao.getOrderDetails(search,searchFieldGroupSeq,searchResultDisplaySeq);
	}

	@Override
	public int saveServiceCause(ServiceModel serviceModel) {
		return tableSetupDao.saveServiceCause(serviceModel);
	}

	@Override
	public int updateServiceCause(ServiceModel serviceModel) {
		return tableSetupDao.updateServiceCause(serviceModel);
	}

	@Override
	public int deleteServiceCause(String causeCode, int reportItemId) {
		return tableSetupDao.deleteServiceCause(causeCode,reportItemId);
	}

	@Override
	public int saveServiceComplaint(ServiceModel serviceModel) {
		return tableSetupDao.saveServiceComplaint(serviceModel);
	}

	@Override
	public int updateServiceComplaint(ServiceModel serviceModel) {
		return tableSetupDao.updateServiceComplaint(serviceModel);
	}

	@Override
	public int deleteServiceComplaint(String complaintCode, String serviceCode) {
		return tableSetupDao.deleteServiceComplaint(complaintCode,serviceCode);
	}

	@Override
	public int saveServiceResolution(ServiceModel serviceModel) {
		return tableSetupDao.saveServiceResolution(serviceModel);
	}

	@Override
	public int updateServiceResolution(ServiceModel serviceModel) {
		return tableSetupDao.updateServiceResolution(serviceModel);
	}

	@Override
	public int deleteServiceResolution(String complaintCode, String serviceCode,int reportItemId) {
		return tableSetupDao.deleteServiceResolution(complaintCode,serviceCode,reportItemId);
	}
	@Override
	public List<Map<String, Object>> getProfitCenter(String profitCenter) {
		return tableSetupDao.getProfitCenter(profitCenter);
	}

	@Override
	public List<Map<String, Object>> getSourceCodeFormats(TableSetupOrderClassModel tableSetupOrderClassModel) {
		return tableSetupDao.getSourceCodeFormats(tableSetupOrderClassModel);
	}
	

	@Override
	public List<Map<String, Object>> getTopic(String topic) {
		return tableSetupDao.getTopic(topic);
	}
	@Override
	public List<Map<String, Object>> getVolumeGroup(int volumeGroupId) {
		return  tableSetupDao.getVolumeGroup(volumeGroupId);
	}

@Override
	public List<Map<String, Object>> getCancelReason(String cancelReason) {
		return tableSetupDao.getCancelReason(cancelReason);
	}

	@Override
	public List<Map<String, Object>> getCancelPolicy() {
		return tableSetupDao.getCancelPolicy();
	}

	@Override
	public List<Map<String, Object>> getPremiumUsed() {
		return tableSetupDao.getPremiumUsed();
	}

	@Override
	public List<Map<String, Object>> getOrderCategory(String orderCategory) {
		return tableSetupDao.getOrderCategory(orderCategory);
	}

	@Override
	public List<Map<String, Object>> getSubscriptionCategory(int subscriptionCategoryId) {
		
		return tableSetupDao.getSubscriptionCategory(subscriptionCategoryId);
	
	}

	@Override
	public List<Map<String, Object>> getTaxonomy(String taxonomy) {
		return tableSetupDao.getTaxonomy(taxonomy);
	}

	@Override
	public List<Map<String, Object>> getTerm(int termId) {
		return tableSetupDao.getTerm(termId);
	}

	@Override
	public List<Map<String, Object>> getUnitType(int unitTypeId) {
		return tableSetupDao.getUnitType(unitTypeId);
	}

	@Override
	public List<Map<String, Object>> getUpsellSuggestion(int upsellSuggestionId) {
		return tableSetupDao.getUpsellSuggestion(upsellSuggestionId);
	}

	@Override
	public List<Map<String, Object>> getCalenderCampaign(int calenderCampaignId) {
		return tableSetupDao.getCalenderCampaign(calenderCampaignId);
	}
	
	@Override
	public int saveCommodityCode(TaxesModel taxesModel) {
		return tableSetupDao.saveCommodityCode(taxesModel);
	}

	@Override
	public int updateCommodityCode(TaxesModel taxesModel) {
		return tableSetupDao.updateCommodityCode(taxesModel);
	}

	@Override
	public int deleteCommodityCode(int commodityCode) {
		return tableSetupDao.deleteCommodityCode(commodityCode);
	}

	@Override
	public List<Map<String, Object>> getCommodityCode(int commodityCode) {
		return tableSetupDao.getCommodityCode(commodityCode);
	}

	@Override
	public int saveJurisdiction(TaxesModel taxesModel) {
		return tableSetupDao.saveJurisdiction(taxesModel);
	}

	@Override
	public int updateJurisdiction(TaxesModel taxesModel) {
		return tableSetupDao.updateJurisdiction(taxesModel);
	}

	@Override
	public int deleteJurisdiction(String state,int jurisdictionSeq) {
		return tableSetupDao.deleteJurisdiction(state,jurisdictionSeq);
	}

	@Override
	public List<Map<String, Object>> getJurisdiction(String state) {
		return tableSetupDao.getJurisdiction(state);
	}

	@Override
	public List<DropdownModel> getStateCodeList(String state) {
		return tableSetupDao.getStateCodeList(state);
	}

	@Override
	public int saveSpecialTax(TaxesModel taxesModel) {
		return tableSetupDao.saveSpecialTax(taxesModel);
	}

	@Override
	public int updateSpecialTax(TaxesModel taxesModel) {
		return tableSetupDao.updateSpecialTax(taxesModel);
	}

	@Override
	public int deleteSpecialTax(String specialTaxId) {
		return tableSetupDao.deleteSpecialTax(specialTaxId);
	}

	@Override
	public List<Map<String, Object>> getSpecialTax(String specialTaxId) {
		return tableSetupDao.getSpecialTax(specialTaxId);
	}

	@Override
	public List<DropdownModel> getExemptStatus(String specialTaxId) {
		return tableSetupDao.getExemptStatus(specialTaxId);
	}

	@Override
	public int saveTaxHandling(TaxesModel taxesModel) {
		return tableSetupDao.saveTaxHandling(taxesModel);
	}

	@Override
	public int updateTaxHandling(TaxesModel taxesModel) {
		return tableSetupDao.updateTaxHandling(taxesModel);
	}

	@Override
	public int deleteTaxHandling(String  taxHandling) {
		return tableSetupDao.deleteTaxHandling( taxHandling);
	}

	@Override
	public List<Map<String, Object>> getTaxHandling(String taxHandling) {
		return tableSetupDao.getTaxHandling(taxHandling);
	}

	@Override
	public List<DropdownModel> getTaxHandlingList(String taxHandling) {
		return tableSetupDao.getTaxHandlingList(taxHandling);
	}

	@Override
	public int saveTaxRatesbyCountryandState(TaxesModel taxesModel) {
		return tableSetupDao.saveTaxRatesbyCountryandState(taxesModel);
	}

	@Override
	public int updateTaxRatesbyCountryandState(TaxesModel taxesModel) {
		return tableSetupDao.updateTaxRatesbyCountryandState(taxesModel);
	}

	@Override
	public int deleteTaxRatesbyCountryandState(String state) {
		return tableSetupDao.deleteTaxRatesbyCountryandState(state);
	}

	@Override
	public List<Map<String, Object>> getTaxRatesbyCountryandState(String state) {
		return  tableSetupDao.getTaxRatesbyCountryandState(state);
	}

	@Override
	public int saveTaxRateCategories(TaxesModel taxesModel) {
		return tableSetupDao.saveTaxRateCategories(taxesModel);
	}

	@Override
	public int updateTaxRateCategories(TaxesModel taxesModel) {
		return tableSetupDao.updateTaxRateCategories(taxesModel);
	}

	@Override
	public int deleteTaxRateCategories(String taxRateCategory) {
		return tableSetupDao.deleteTaxRateCategories(taxRateCategory);
	}

	@Override
	public List<Map<String, Object>> getTaxRateCategories(String taxRateCategory) {
		return tableSetupDao.getTaxRateCategories(taxRateCategory);
	}

	@Override
	public int saveTaxTypes(TaxesModel taxesModel) {
		return tableSetupDao.saveTaxTypes(taxesModel);
	}

	@Override
	public int updateTaxTypes(TaxesModel taxesModel) {
		return tableSetupDao.updateTaxTypes(taxesModel);
	}

	@Override
	public int deleteTaxTypes(String taxType) {
		return tableSetupDao.deleteTaxTypes(taxType);
	}

	@Override
	public List<Map<String, Object>> getTaxTypes(String taxType) {
		return tableSetupDao.getTaxTypes(taxType);
	}
	@Override
	public int saveAddresses(InternationalModel internationalModel) {
		return tableSetupDao.saveAddresses(internationalModel);
	}

	@Override
	public int updateAddresses(InternationalModel internationalModel) {
		return tableSetupDao.updateAddresses(internationalModel);
	}

	@Override
	public int deleteAddresses(int addressId) {
		return tableSetupDao.deleteAddresses(addressId);
	}

	@Override
	public List<Map<String, Object>> getAddress(int addressId) {
		return tableSetupDao.getAddress(addressId);
	}

	@Override
	public List<DropdownModel> getStateList() {
		return tableSetupDao.getStateList();
	}

	@Override
	public int saveAddressCleaning(InternationalModel internationalModel) {
		return tableSetupDao.saveAddressCleaning(internationalModel);
	}

	@Override
	public int updateAddressCleaning(InternationalModel internationalModel) {
		return tableSetupDao.updateAddressCleaning(internationalModel);
	}

	@Override
	public int deleteAddressCleaning(int iapDatasetDefId) {
		return tableSetupDao.deleteAddressCleaning(iapDatasetDefId);
	}

	@Override
	public List<Map<String, Object>> getAddressCleaning(int iapDatasetDefId) {
		return tableSetupDao.getAddressCleaning(iapDatasetDefId);
	}

	@Override
	public List<DropdownModel> getProgIdList() {
		return tableSetupDao.getProgIdList();
	}
	@Override
	public List<Map<String, Object>> getIapNameValue(int iapDatasetDefId) {
		return tableSetupDao.getIapNameValue(iapDatasetDefId);
	}
	@Override
	public int saveCountryCode(InternationalModel internationalModel) {
		return tableSetupDao.saveCountryCode(internationalModel);
	}

	@Override
	public int updateCountryCode(InternationalModel internationalModel) {
		return tableSetupDao.updateCountryCode(internationalModel);
	}

	@Override
	public int deleteCountryCode(String countryCode2) {
		return tableSetupDao.deleteCountryCode(countryCode2);
	}

	@Override
	public List<Map<String, Object>> getCountryCode() {
		return tableSetupDao.getCountryCode();
	}

	@Override
	public List<DropdownModel> getFileCurrencyList() {
		return tableSetupDao.getFileCurrencyList();
	}

	@Override
	public int saveCountriesandStates(InternationalModel internationalModel) {
		return tableSetupDao.saveCountriesandStates(internationalModel);
	}

	@Override
	public int updateCountriesandStates(InternationalModel internationalModel) {
		return tableSetupDao.updateCountriesandStates(internationalModel);
	}

	@Override
	public int deleteCountriesandStates(String state) {
		return tableSetupDao.deleteCountriesandStates(state);
	}

	@Override
	public List<Map<String, Object>> getCountriesandStates(String state) {
		return tableSetupDao.getCountriesandStates(state);
	}

	@Override
	public List<DropdownModel> getCurrencyList() {
		return tableSetupDao.getCurrencyList();
	}
	@Override
	public List<DropdownModel> getCountryCodeList() {
		return tableSetupDao.getCountryCodeList();
	}
	@Override
	public List<DropdownModel> getLabelFormatList() {
		return tableSetupDao.getLabelFormatList();
	}
	@Override
	public List<DropdownModel> getaddressCheckingList() {
		return tableSetupDao.getaddressCheckingList();
	}

	@Override
	public int saveCurrencies(InternationalModel internationalModel) {
		return tableSetupDao.saveCurrencies(internationalModel);
	}

	@Override
	public int updateCurrencies(InternationalModel internationalModel) {
		return tableSetupDao.updateCurrencies(internationalModel);
	}

	@Override
	public int deleteCurrencies(String currency) {
		return tableSetupDao.deleteCurrencies(currency);
	}

	@Override
	public List<Map<String, Object>> getCurrencies(String currency) {
		return tableSetupDao.getCurrencies(currency);
	}

	@Override
	public int saveLanguageCodes(InternationalModel internationalModel) {
		return tableSetupDao.saveLanguageCodes(internationalModel);
	}

	@Override
	public int updateLanguageCodes(InternationalModel internationalModel) {
		return tableSetupDao.updateLanguageCodes(internationalModel);
	}

	@Override
	public int deleteLanguageCodes(String langugaeCode) {
		return tableSetupDao.deleteLanguageCodes(langugaeCode);
	}

	@Override
	public List<Map<String, Object>> getLanguageCodes(String languageCode) {
		return tableSetupDao.getLanguageCodes(languageCode);
	}

	@Override
	public int saveRegions(InternationalModel internationalModel) {
		return tableSetupDao.saveRegions(internationalModel);
	}

	@Override
	public int updateRegions(InternationalModel internationalModel) {
		return tableSetupDao.updateRegions(internationalModel);
	}

	@Override
	public int deleteRegions(String regionList) {
		return tableSetupDao.deleteRegions(regionList);
	}

	@Override
	public List<Map<String, Object>> getRegions(String regionList) {
		return tableSetupDao.getRegions(regionList);
	}
	@Override
	public List<Map<String, Object>> getAddressStatusDetails(String addressStatus) {
		return tableSetupDao.getAddressStatusDetails(addressStatus);
	}

	@Override
	public List<Map<String, Object>> getAddressTypeDetails(String addressType) {
		return tableSetupDao.getAddressTypeDetails(addressType);
	}

	@Override
	public List<Map<String, Object>> getAttachmentCatagoryDetails(String attachmentCatagory) {
		return tableSetupDao.getAttachmentCatagoryDetails(attachmentCatagory);
	}

	@Override
	public List<Map<String, Object>> getAuxFieldDetails(String tableName) {
		return tableSetupDao.getAuxFieldDetails(tableName);
	}

	@Override
	public List<Map<String, Object>> getCreditStatusDetails(String creditStatus) {
		return tableSetupDao.getCreditStatusDetails(creditStatus);
	}

	@Override
	public List<Map<String, Object>> getRentalCategoryDetails(String listRentalCategory) {
		return tableSetupDao.getRentalCategoryDetails(listRentalCategory);
	}

	@Override
	public List<Map<String, Object>> getCustomerCategoryDetails(String customerCategory) {
		return tableSetupDao.getCustomerCategoryDetails(customerCategory);
	}

	@Override
	public List<Map<String, Object>> getLoginQuestionDetails(int customerLoginQuestionId) {
		return tableSetupDao.getLoginQuestionDetails(customerLoginQuestionId);
	}
	/*@Override
	public List<DropdownModel> getFollowOnServicePage() {
		return tableSetupDao.getFollowOnServicePage();
	}*/

	@Override
	public List<Map<String, Object>> getProspectCategoryDetails(String prospectCategory) {
		return tableSetupDao.getProspectCategoryDetails(prospectCategory);
	}

	@Override
	public List<Map<String, Object>> getsalesRepresentativeDetails(int salesRepresentativeId) {
		return tableSetupDao.getsalesRepresentativeDetails(salesRepresentativeId);
	}

	@Override
	public List<DropdownModel> getDelivaryMethod() {
		return tableSetupDao.getDelivaryMethod();
	}

	@Override
	public List<DropdownModel> getRegionList() {
		return tableSetupDao.getRegionList();
	}

	@Override
	public List<DropdownModel> getShippingPriceList() {
		return tableSetupDao.getShippingPriceList();
	}

	@Override
	public List<DropdownModel> getCancellationRenewal() {
		return tableSetupDao.getCancellationRenewal();
	}

	@Override
	public List<DropdownModel> getAddressType() {
		return tableSetupDao.getAddressType();
	}

	@Override
	public List<DropdownModel> getAddressStatus() {
		return tableSetupDao.getAddressStatus();
	}

	@Override
	public List<DropdownModel> getCreditStatus() {
		return tableSetupDao.getCreditStatus();
	}

	@Override
	public List<DropdownModel> getRentalCategory() {
		return tableSetupDao.getRentalCategory();
	}

	@Override
	public List<DropdownModel> getOperatorDetails() {
		return tableSetupDao.getOperatorDetails();
	}

	@Override
	public List<DropdownModel> getbacthTemplateDetails() {
		return tableSetupDao.getbacthTemplateDetails();
	}

	@Override
	public List<Map<String, Object>> getDocumentReferenceDetails() {
		return tableSetupDao.getDocumentReferenceDetails();
	}

	@Override
	public List<DropdownModel> getType() {
		return tableSetupDao.getType();
	}

	@Override
	public int saveDocumentReference(DefaultSettings defaultSettings) {
		return tableSetupDao.saveDocumentReference(defaultSettings);
	}

	@Override
	public int updateDocumentReference(DefaultSettings defaultSettings) {
		return tableSetupDao.updateDocumentReference(defaultSettings);
	}

	@Override
	public int saveEditTrail(DefaultSettings defaultSettings) {
		return tableSetupDao.saveEditTrail(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getEditTrailDetails(int documentReferenceId) {
		return tableSetupDao.getEditTrailDetails(documentReferenceId);
	}

	@Override
	public List<Map<String, Object>> getEditTrail(int documentReferenceId) {
		return tableSetupDao.getEditTrail(documentReferenceId);
	}

	@Override
	public List<Map<String, Object>> getPaymentBreakdown(int paymentSeq,int customerId) {
		return tableSetupDao.getPaymentBreakdown(paymentSeq,customerId);
	}

	@Override
	public List<DropdownModel> getShipType() {
		return tableSetupDao.getShipType();
	}

	@Override
	public List<DropdownModel> getBackIssueShipType() {
		return tableSetupDao.getBackIssueShipType();
	}

	@Override
	public List<DropdownModel> getNewmemberOptions() {
		return tableSetupDao.getNewmemberOptions();
		
	}

	@Override
	public List<Map<String, Object>> getAccountingDetails(String currency) {
		return tableSetupDao.getAccountingDetails(currency);
	}

	@Override
	public List<DropdownModel> getPaymentThreshold() {
		return tableSetupDao.getPaymentThreshold();
	}

	@Override
	public List<DropdownModel> getDefaultPayType() {
		return tableSetupDao.getDefaultPayType();
	}

	@Override
	public List<DropdownModel> getRefundPaytype(String paymentType) {
		return tableSetupDao.getRefundPaytype(paymentType);
	}

	@Override
	public List<DropdownModel> getHoldForPayment() {
		return tableSetupDao.getHoldForPayment();
	}

	@Override
	public List<DropdownModel> getEncryptorCOM(String purposeCode) {
		return tableSetupDao.getEncryptorCOM(purposeCode);
	}

	@Override
	public List<Map<String, Object>> getVertexDetails() {
		return tableSetupDao.getVertexDetails();
	}

	@Override
	public int legalEntitySave(DefaultSettings defaultSettings) {
		return tableSetupDao.legalEntitySave(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getLegalEntityDetails() {
		return tableSetupDao.getLegalEntityDetails();
	}

	@Override
	public List<DropdownModel> getShiptoRegion() {
		return tableSetupDao.getShiptoRegion();
	}

	@Override
	public int saveLegalEntity(DefaultSettings defaultSettings) {
		return tableSetupDao.saveLegalEntity(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getPaymentThresholdDetails(String paymentThreshold) {
		return tableSetupDao.getPaymentThresholdDetails(paymentThreshold);
	}

	@Override
	public List<Map<String, Object>> getPaymentTypeDetails(String paymentType) {
		return tableSetupDao.getPaymentTypeDetails(paymentType);
	}

	@Override
	public List<DropdownModel> getPaymentForm() {
		return tableSetupDao.getPaymentForm();
	}

	@Override
	public List<DropdownModel> getRealizeCashwhen() {
		return tableSetupDao.getRealizeCashwhen();
	}

	@Override
	public List<DropdownModel> getCreditCardType() {
		return tableSetupDao.getCreditCardType();
	}

	@Override
	public List<DropdownModel> getCardVerificationusage() {
		return tableSetupDao.getCardVerificationusage();
	}

	@Override
	public List<Map<String, Object>> getTransreasonDetails(String transactionReason) {
		return tableSetupDao.getTransreasonDetails(transactionReason);
	}

	@Override
	public List<DropdownModel> getTransreasonReasonType() {
		return tableSetupDao.getTransreasonReasonType();
	}

	@Override
	public int updateLegalEntity(DefaultSettings defaultSettings) {
		return tableSetupDao.updateLegalEntity(defaultSettings);
	}

	@Override
	public int deleteLegalEntity(int vrtxLegalEntityId,String shiptoRegion) {
		return tableSetupDao.deleteLegalEntity(vrtxLegalEntityId,shiptoRegion);
	}

	@Override
	public List<Map<String, Object>> getEntityDetails(int vrtxLegalEntityId) {
		return tableSetupDao.getEntityDetails(vrtxLegalEntityId);
	}

	@Override
	public List<DropdownModel> getAdministrativeAddress() {
		return tableSetupDao.getAdministrativeAddress();
	}

	@Override
	public int updateTax(DefaultSettings defaultSettings) {
		return tableSetupDao.updateTax(defaultSettings);
	}

	@Override
	public int updateTaxDef(DefaultSettings defaultSettings) {
		return tableSetupDao.updateTaxDef(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getCheckValues() {
		return tableSetupDao.getCheckValues();
	}

	@Override
	public int deleteTaxLegalEntity(String region) {
		return tableSetupDao.deleteTaxLegalEntity(region);
	}

	@Override
	public List<Map<String, Object>> getCustomersDetails(String currency) {
		return tableSetupDao.getCustomersDetails(currency);
	}

	@Override
	public int updateDefaultCustomerUpdate(DefaultSettings defaultSettings) {
		return tableSetupDao.updateDefaultCustomerUpdate(defaultSettings);
	}

	@Override
	public int updateAccounting(DefaultSettings defaultSettings) {
		return tableSetupDao.updateAccounting(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getPaymentDetails(String currency) {
		return tableSetupDao.getPaymentDetails(currency);
	}

	@Override
	public int updateDefaultPayment(DefaultSettings defaultSettings) {
		return tableSetupDao.updateDefaultPayment(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getInventoryDetails(String currency) {
		return tableSetupDao.getInventoryDetails(currency);
	}

	@Override
	public int updateInventory(DefaultSettings defaultSettings) {
		return tableSetupDao.updateInventory(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getCustomFieldDetails(String currency) {
		return tableSetupDao.getCustomFieldDetails(currency);
	}

	@Override
	public int updateCustomFields(DefaultSettings defaultSettings) {
		return tableSetupDao.updateCustomFields(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getLicenseCodeDetails(String lincenseCode) {
		return tableSetupDao.getLicenseCodeDetails(lincenseCode);
	}

	@Override
	public List<Map<String, Object>> getInternetDetails(String currency) {
		return tableSetupDao.getInternetDetails(currency);
	}

	@Override
	public int saveInternet(DefaultSettings defaultSettings) {
		return tableSetupDao.saveInternet(defaultSettings);
	}

	@Override
	public int updateInternet(DefaultSettings defaultSettings) {
		return tableSetupDao.updateInternet(defaultSettings);
	}

	@Override
	public List<DropdownModel> getMatchCode() {
		return tableSetupDao.getMatchCode();
	}

	@Override
	public List<DropdownModel> getProspectCategory() {
		return tableSetupDao.getProspectCategory();
	}

	@Override
	public int updateDefaultInternet(DefaultSettings defaultSettings) {
		return tableSetupDao.updateDefaultInternet(defaultSettings);
	}

	@Override
	public List<DropdownModel> getLableGroup() {
		return tableSetupDao.getLableGroup();
	}

	@Override
	public List<DropdownModel> getLableFormate() {
		return tableSetupDao.getLableFormate();
	}

	@Override
	public List<Map<String, Object>> getProcessingDetails(String currency) {
		return tableSetupDao.getProcessingDetails(currency);
	}

	@Override
	public int updateProcessing(DefaultSettings defaultSettings) {
		return tableSetupDao.updateProcessing(defaultSettings);
	}

	@Override
	public int saveDeliveryMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return tableSetupDao.saveDeliveryMethods(shippingDeliveryandDistributionModel);
	}

	@Override
	public int updateDeliveryMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return tableSetupDao.updateDeliveryMethods(shippingDeliveryandDistributionModel);
	}

	@Override
	public int deleteDeliveryMethods(String deliveryMethod) {
		return tableSetupDao.deleteDeliveryMethods(deliveryMethod);
	}

	@Override
	public List<Map<String, Object>> getDeliveryMethods(String deliveryMethod) {
		return tableSetupDao.getDeliveryMethods(deliveryMethod);
	}

	
	@Override
	public List<DropdownModel> getOrderClassList() {
		return tableSetupDao.getOrderClassList();
	}

	@Override
	public int saveDistributionMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return tableSetupDao.saveDistributionMethods(shippingDeliveryandDistributionModel);
	}

	@Override
	public int updateDistributionMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return tableSetupDao.updateDistributionMethods(shippingDeliveryandDistributionModel);
	}

	@Override
	public int deleteDistributionMethods(String distributionMethod, String distributionAttribute) {
		return tableSetupDao.deleteDistributionMethods(distributionMethod, distributionAttribute);
	}

	@Override
	public List<Map<String, Object>> getDistributionMethods(String distributionMethod, String distributionAttribute) {
		return tableSetupDao.getDistributionMethods(distributionMethod, distributionAttribute);
	}

	@Override
	public List<DropdownModel> getDistAttributeList() {
		return tableSetupDao.getDistAttributeList();
	}

	@Override
	public List<DropdownModel> getDistRegionList() {
		return tableSetupDao.getDistRegionList();
	}

	//@Override
	//public List<Map<String, Object>> setupDefaltDeliveryMethodsDetails() {
	//	return tableSetupDao.setupDefaltDeliveryMethodsDetails() ;
	//}

	@Override
	public List<DropdownModel> getDeliveryMethodList() {
		return tableSetupDao.getDeliveryMethodList();
	}

	@Override
	public int saveAssignDistributionCriteria(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return  tableSetupDao.saveAssignDistributionCriteria(shippingDeliveryandDistributionModel);
	}

	@Override
	public int updateAssignDistributionCriteria(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return  tableSetupDao.updateAssignDistributionCriteria(shippingDeliveryandDistributionModel);
	}

	@Override
	public int deleteAssignDistributionCriteria(String distributionMethod, int distMethodDefaultSeq) {
		return tableSetupDao.deleteAssignDistributionCriteria(distributionMethod, distMethodDefaultSeq);
	}

	@Override
	public List<Map<String, Object>> getAssignDistributionCriteria(String distributionMethod,
			int distMethodDefaultSeq) {
		return  tableSetupDao.getAssignDistributionCriteria(distributionMethod, distMethodDefaultSeq);
	}

	@Override
	public List<DropdownModel> regionList() {
		return tableSetupDao.regionList();
	}

	@Override
	public List<DropdownModel> attributeList() {
		return tableSetupDao.attributeList();
	}

	@Override
	public List<DropdownModel> attributeValue() {
		return tableSetupDao.attributeValue();
	}
	@Override
	public int saveSetUpDistributionAttributes(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return  tableSetupDao.saveSetUpDistributionAttributes(shippingDeliveryandDistributionModel);
	}

	@Override
	public int updateSetUpDistributionAttributes(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return  tableSetupDao.updateSetUpDistributionAttributes(shippingDeliveryandDistributionModel);
	}

	@Override
	public int deleteSetUpDistributionAttributes(String distributionAttribute, String distAttributeValue) {
		return tableSetupDao.deleteSetUpDistributionAttributes(distributionAttribute, distAttributeValue);
	}

	@Override
	public List<Map<String, Object>> getSetUpDistributionAttributes(String distributionAttribute,String distAttributeValue) {
		return tableSetupDao.getSetUpDistributionAttributes(distributionAttribute, distAttributeValue);
	}
	@Override
	public int saveShippingandHandlingMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return tableSetupDao.saveShippingandHandlingMethods(shippingDeliveryandDistributionModel);
	}

	@Override
	public int updateShippingandHandlingMethods(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return  tableSetupDao.updateShippingandHandlingMethods(shippingDeliveryandDistributionModel);
	}

	@Override
	public int deleteShippingandHandlingMethods(String shippingMethod) {
		return tableSetupDao.deleteShippingandHandlingMethods(shippingMethod);
	}

	@Override
	public List<Map<String, Object>> getShippingandHandlingMethods(String shippingMethod) {
		return tableSetupDao.getShippingandHandlingMethods(shippingMethod);
	}

	@Override
	public int saveShippingPriceList(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return tableSetupDao.saveShippingPriceList(shippingDeliveryandDistributionModel);
	}

	@Override
	public int updateShippingPriceList(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return tableSetupDao.updateShippingPriceList(shippingDeliveryandDistributionModel);
	}

	@Override
	public int deleteShippingPriceList(String shippingPriceList) {
		return tableSetupDao.deleteShippingPriceList(shippingPriceList);
	}

	@Override
	public List<Map<String, Object>> getShippingPriceList(String shippingPriceList) {
		return tableSetupDao.getShippingPriceList(shippingPriceList);
	}

	@Override
	public List<DropdownModel> getShippingMethodList() {
		return tableSetupDao.getShippingMethodList();
	}

	@Override
	public List<DropdownModel> getRegion() {
		return tableSetupDao.getRegion();
	}

	@Override
	public int saveMailingEntryPoint(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return  tableSetupDao.saveMailingEntryPoint(shippingDeliveryandDistributionModel);
	}

	@Override
	public int updateMailingEntryPoint(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return  tableSetupDao.updateMailingEntryPoint(shippingDeliveryandDistributionModel);
	}

	@Override
	public int deleteMailingEntryPoint(String mailingEntryPoint) {
		return tableSetupDao.deleteMailingEntryPoint(mailingEntryPoint);
	}

	@Override
	public List<Map<String, Object>> getMailingEntryPoint(String mailingEntryPoint) {
		return  tableSetupDao.getMailingEntryPoint(mailingEntryPoint);
	}

	@Override
	public int saveTransportMode(ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		return  tableSetupDao.saveTransportMode(shippingDeliveryandDistributionModel);
	}

	@Override
	public int deleteTransportMode(String transportMode) {
		return tableSetupDao.deleteTransportMode(transportMode);
	}

	@Override
	public List<Map<String, Object>> getTransportMode(String transportMode) {
		return  tableSetupDao.getTransportMode(transportMode);
	}

	
	@Override
	public int saveEmailFormater(DefaultSettings defaultSettings) {
		return tableSetupDao.saveEmailFormater(defaultSettings);
	}

	@Override
	public int updateEmailFormater(DefaultSettings defaultSettings) {
		return tableSetupDao.updateEmailFormater(defaultSettings);
	}

	@Override
	public int deleteEmailFormater(int transactionEvent) {
		return tableSetupDao.deleteEmailFormater(transactionEvent);
	}

	@Override
	public List<DropdownModel> getTransactionEvent() {
		return tableSetupDao.getTransactionEvent();
	}

	@Override
	public List<DropdownModel> getOrderClass() {
		return tableSetupDao.getOrderClass();
	}

	@Override
	public List<DropdownModel> getrovider() {
		return tableSetupDao.getrovider();
	}

	@Override
	public int tpProviderUpdate(DefaultSettings defaultSettings) {
		return tableSetupDao.tpProviderUpdate(defaultSettings);
	}

	@Override
	public List<Map<String, Object>> getrProviderDetails(int tpProviderId) {
		return tableSetupDao.getrProviderDetails(tpProviderId);
	}

	@Override
	public List<Map<String, Object>> getEmailFormatorDetails(int transactionEvent) {
		return tableSetupDao.getEmailFormatorDetails(transactionEvent);
	}

	@Override
	public String defaultEmailAuthorizationInfo(String Currency) {
		return tableSetupDao.defaultEmailAuthorizationInfo(Currency);
	}

	@Override
	public List<Map<String, Object>> getCheckdetails(String Currency) {
		return tableSetupDao.getCheckdetails(Currency);
	}

	@Override
	public String updateDefaultEmailAuthorization(String currency, String business_processes) {
		return tableSetupDao.updateDefaultEmailAuthorization(currency,business_processes);
	}

	@Override
	public String defaultEmailNotificationInfo(String currency) {
		return tableSetupDao.defaultEmailNotificationInfo(currency);
	}

	@Override
	public int updateCheckDetails(String currency,String suppressEmailNotification,String notifyOldAndNew) {
		return tableSetupDao.updateCheckDetails(currency,suppressEmailNotification,notifyOldAndNew);
	}

	@Override
	public String updateDefaultEmailNotificationSwitches(String currency, String business_processes) {
		return tableSetupDao.updateDefaultEmailNotificationSwitches(currency,business_processes);
	}

	@Override
	public int saveDealType(DealModel dealModel) {
		return tableSetupDao.saveDealType(dealModel);
	}

	@Override
	public int updateDealType(DealModel dealModel) {
		return tableSetupDao.updateDealType(dealModel);
	}

	@Override
	public int deleteDealType(String dealType) {
		return tableSetupDao.deleteDealType(dealType);
	}

	@Override
	public List<Map<String, Object>> getDealTypeDetails(String dealType) {
		return tableSetupDao.getDealTypeDetails(dealType);
	}

	@Override
	public int saveDealStatus(DealModel dealModel) {
		return tableSetupDao.saveDealStatus(dealModel);
	}

	@Override
	public int updateDealStatus(DealModel dealModel) {
		return tableSetupDao.updateDealStatus(dealModel);
	}

	@Override
	public List<Map<String, Object>> getDealStatusDetails(String dealStatus) {
		return tableSetupDao.getDealStatusDetails(dealStatus);
	}

	@Override
	public int deleteDealStatus(String dealStatus) {
		return tableSetupDao.deleteDealStatus(dealStatus);
	}

	@Override
	public int saveDemograpic(DemographicModel demographicModel) {
		return tableSetupDao.saveDemograpic(demographicModel);
	}

	@Override
	public int saveDemResponse(DemographicModel demographicModel) {
		return tableSetupDao.saveDemResponse(demographicModel);
	}

	@Override
	public int updateDemQuestion(DemographicModel demographicModel) {
		return tableSetupDao.updateDemQuestion(demographicModel);
	}

	@Override
	public int updateDemresponse(DemographicModel demographicModel) {
		return tableSetupDao.updateDemresponse(demographicModel);
	}

	@Override
	public int deleteDemQuestion(int demQuestionId) {
		return tableSetupDao.deleteDemQuestion(demQuestionId);
	}

	@Override
	public int deleteDemresponse(int demresponseSeq,int demQuestionId) {
		return tableSetupDao.deleteDemresponse(demresponseSeq,demQuestionId);
	}

	@Override
	public List<Map<String, Object>> getDemographicInfo(int demQuestionId, int demresponseSeq) {
		return tableSetupDao.getDemographicInfo(demQuestionId,demresponseSeq);
	}

	@Override
	public List<Map<String, Object>> getDemQuestionDetails(int demQuestionId) {
		return tableSetupDao.getDemQuestionDetails(demQuestionId);
	}

	@Override
	public List<DropdownModel> getQualified() {
		return tableSetupDao.getQualified();
	}

	@Override
	public List<DropdownModel> getFreeFormInput() {
		return tableSetupDao.getFreeFormInput();
	}

	@Override
	public int saveDisplayctxRedirection(DemographicModel demographicModel) {
		return tableSetupDao.saveDisplayctxRedirection(demographicModel);
	}

	@Override
	public int updateDisplayctxRedirection(DemographicModel demographicModel) {
		return tableSetupDao.updateDisplayctxRedirection(demographicModel);
	}

	@Override
	public int deleteDisplayctxRedirection(String dispContext) {
		return tableSetupDao.deleteDisplayctxRedirection(dispContext);
	}

	@Override
	public List<Map<String, Object>> getDisplayctxRedirection(String dispContext) {
		return tableSetupDao.getDisplayctxRedirection(dispContext);
	}

	@Override
	public List<DropdownModel> getDispCntx() {
		return tableSetupDao.getDispCntx();
	}

	@Override
	public List<DropdownModel> getDispContexttoLead() {
		return tableSetupDao.getDispContexttoLead();
	}

	@Override
	public int savelabelFormat(LabelModel labelModel) {
		return tableSetupDao.savelabelFormat(labelModel);
	}

	@Override
	public int updateLabelFormat(LabelModel labelModel) {
		return tableSetupDao.updateLabelFormat(labelModel);
	}

	@Override
	public int deleteLabelFormat(String labeFormat,String labelGroup) {
		return tableSetupDao.deleteLabelFormat(labeFormat,labelGroup);
	}

	@Override
	public List<Map<String, Object>> getLabelFormateDetails(String labeFormat) {
		return tableSetupDao.getLabelFormateDetails(labeFormat);
	}

	@Override
	public List<Map<String, Object>> getlabelGroupDetails(String labelGroup) {
		return tableSetupDao.getlabelGroupDetails(labelGroup);
	}

	@Override
	public int savelabelGroup(LabelModel labelModel) {
		return tableSetupDao.savelabelGroup(labelModel);
	}

	@Override
	public int updateLabelGroup(LabelModel labelModel) {
		return tableSetupDao.updateLabelGroup(labelModel);
	}

	@Override
	public int deleteLabelGroup(String labelGroup) {
		return tableSetupDao.deleteLabelGroup(labelGroup);
	}

	@Override
	public int savelabelKeyline(LabelModel labelModel) {
		return tableSetupDao.savelabelKeyline(labelModel);
	}

	@Override
	public int saveLbelKeylineDetails(LabelModel labelModel) {
		return tableSetupDao.saveLbelKeylineDetails(labelModel);
	}

	@Override
	public List<DropdownModel> getTablename() {
		return tableSetupDao.getTablename();
	}

	@Override
	public List<DropdownModel> getColumnname() {
		return tableSetupDao.getColumnname();
	}

	@Override
	public List<DropdownModel> getDemQuestion() {
		return tableSetupDao.getDemQuestion();
	}

	@Override
	public int updatelabelKeyline(LabelModel labelModel) {
		return tableSetupDao.updatelabelKeyline(labelModel);
	}

	@Override
	public int updateLabelKeylineDetail(LabelModel labelModel) {
		return tableSetupDao.updateLabelKeylineDetail(labelModel);
	}

	@Override
	public List<DropdownModel> getColumnnameInfo() {
		return tableSetupDao.getColumnnameInfo();
	}

	@Override
	public List<Map<String, Object>> labelKeylineDetails(String labelKeyline) {
		return tableSetupDao.labelKeylineDetails(labelKeyline);
	}

	@Override
	public List<Map<String, Object>> labelKeylineInfo(String labelKeyline, int labelLinenbr) {
		return tableSetupDao.labelKeylineInfo(labelKeyline,labelLinenbr);
	}

	@Override
	public int deletelabelKeylineDetail(String labelKeyline, int labelLinenbr) {
		return tableSetupDao.deletelabelKeylineDetail(labelKeyline,labelLinenbr);
	}

	@Override
	public int deleteLabelkeyline(String labelKeyline) {
		return tableSetupDao.deleteLabelkeyline(labelKeyline);
	}

	@Override
	public List<Map<String, Object>> getLabelgroupFormatDetails(String labelGroup) {
		return tableSetupDao.getLabelgroupFormatDetails(labelGroup);
	}

	@Override
	public List<DropdownModel> getlabelGroupInfo() {
		return tableSetupDao.getlabelGroupInfo();
	}

	@Override
	public List<DropdownModel> getLabelFormat() {
		return tableSetupDao.getLabelFormat();
	}

	@Override
	public List<Map<String, Object>> getFinalLabel(String labelGroup, int labelLinenbr) {
		return tableSetupDao.getFinalLabel(labelGroup,labelLinenbr);
	}

	@Override
	public int saveLabel(LabelModel labelModel) {
		return tableSetupDao.saveLabel(labelModel);
	}

	@Override
	public int updateLabel(LabelModel labelModel) {
		return tableSetupDao.updateLabel(labelModel);
	}

	@Override
	public int saveLabelFormatDetail(LabelModel labelModel) {
		return tableSetupDao.saveLabelFormatDetail(labelModel);
	}

	@Override
	public int updateLabelFormatDetail(LabelModel labelModel) {
		return tableSetupDao.updateLabelFormatDetail(labelModel);
	}

	@Override
	public int deleteLabelDetails(String labelFormat, int labelLinenbr) {
		return tableSetupDao.deleteLabelDetails(labelFormat,labelLinenbr);
	}

	@Override
	public int deleteLabel(String labelFormat) {
		return tableSetupDao.deleteLabel(labelFormat);
	}

	@Override
	public List<Map<String, Object>> installmentPlanDetails(int installmentPlanId) {
		return tableSetupDao.installmentPlanDetails(installmentPlanId);
	}

	@Override
	public List<Map<String, Object>> installPlanInfo(int installmentPlanId, int installPlanDetailSeq) {
		return tableSetupDao.installPlanInfo(installmentPlanId,installPlanDetailSeq);
	}

	@Override
	public List<DropdownModel> getOutput() {
		return tableSetupDao.getOutput();
	}

	@Override
	public List<Map<String, Object>> settleRetryDefInfo(String settleRetryDef) {
		return tableSetupDao.settleRetryDefInfo(settleRetryDef);
	}

	@Override
	public List<Map<String, Object>> getQtyDiscountSchedule(String qtyDiscountSchedule) {
		return tableSetupDao.getQtyDiscountSchedule(qtyDiscountSchedule);
	}

	@Override
	public List<Map<String, Object>> getQtyDiscountSchedDtl(String qtyDiscountSchedule) {
		return tableSetupDao.getQtyDiscountSchedDtl(qtyDiscountSchedule);
	}

	@Override
	public List<DropdownModel> getDiscountamtCalcType() {
		return tableSetupDao.getDiscountamtCalcType();
	}

	@Override
	public List<Map<String, Object>> getMultilineDiscountSchedule(String multilineDiscountSchedule) {
		return tableSetupDao.getMultilineDiscountSchedule(multilineDiscountSchedule);
	}

	@Override
	public List<Map<String, Object>> getMultilineDiscEffective(String multilineDiscountSchedule,int multilineDiscEffSeq) {
		return tableSetupDao.getMultilineDiscEffective(multilineDiscountSchedule,multilineDiscEffSeq);
	}

	@Override
	public List<Map<String, Object>> getMultiDiscSchedDtl(String multilineDiscountSchedule,int multiDiscScheddtlSeq) {
		return tableSetupDao.getMultiDiscSchedDtl(multilineDiscountSchedule,multiDiscScheddtlSeq);
	}

	@Override
	public List<DropdownModel> getReportitemId() {
		return tableSetupDao.getReportitemId();
	}

	@Override
	public List<Map<String, Object>> getServiceCause(String causeCode) {
		return tableSetupDao.getServiceCause(causeCode);
	}

	@Override
	public List<DropdownModel> getCauseCode() {
		return tableSetupDao.getCauseCode();
	}

	@Override
	public List<DropdownModel> getServicetoPerform() {
		return tableSetupDao.getServicetoPerform();
	}

	@Override
	public List<Map<String, Object>> getServiceComplaints(String complaintCode) {
		return tableSetupDao.getServiceComplaints(complaintCode);
	}

	@Override
	public List<Map<String, Object>> getServiceResolution(String serviceCode) {
		return tableSetupDao.getServiceResolution(serviceCode);
	}

	  @Override                                                                                                                          
	  public int saveBasicPrice(AuditModel auditModel) {                                                                                 
	     return tableSetupDao.saveBasicPrice(auditModel);                                                                                
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateBasicPrice(AuditModel auditModel) {                                                                               
	  	return tableSetupDao.updateBasicPrice(auditModel);                                                                             
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deleteBasicPrice(int auditBasicPriceId) {                                                                               
	  	return  tableSetupDao.deleteBasicPrice(auditBasicPriceId);                                                                     
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getBasicPrice(int auditBasicPriceId) {                                                            
	  	return  tableSetupDao.getBasicPrice(auditBasicPriceId);                                                                        
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<DropdownModel> getPubGroupList() {                                                                                     
	  	return tableSetupDao.getPubGroupList();                                                                                        
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int saveAuditDuration(AuditModel auditModel) {                                                                              
	  	return tableSetupDao.saveAuditDuration(auditModel);                                                                            
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateAuditDuration(AuditModel auditModel) {                                                                            
	  	return  tableSetupDao.updateAuditDuration(auditModel);                                                                         
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deleteAuditDuration(int auditDurationId) {                                                                              
	  	return tableSetupDao.deleteAuditDuration(auditDurationId);                                                                     
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getAuditDuration(int auditDurationId) {                                                           
	  	return tableSetupDao.getAuditDuration(auditDurationId);                                                                        
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int saveMailingAddressName(AuditModel auditModel) {                                                                         
	  	return  tableSetupDao.saveMailingAddressName(auditModel);                                                                      
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateMailingAddressName(AuditModel auditModel) {                                                                       
	  	return tableSetupDao.updateMailingAddressName(auditModel);                                                                     
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deleteMailingAddressName(int auditNameTitleId) {                                                                        
	  	return  tableSetupDao.deleteMailingAddressName(auditNameTitleId);                                                              
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getMailingAddressName(int auditNameTitleId) {                                                     
	  	return  tableSetupDao.getMailingAddressName(auditNameTitleId);                                                                 
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int savePublicationGroup(AuditModel auditModel) {                                                                           
	  	return   tableSetupDao.savePublicationGroup(auditModel);                                                                       
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updatePublicationGroup(AuditModel auditModel) {                                                                         
	  	return  tableSetupDao.updatePublicationGroup(auditModel);                                                                      
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deletePublicationGroup(String auditPubGroup) {                                                                          
	  	return   tableSetupDao.deletePublicationGroup(auditPubGroup);                                                                  
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getPublicationGroup(String auditPubGroup) {                                                       
	  	return  tableSetupDao.getPublicationGroup(auditPubGroup);                                                                      
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int saveQualificationSource(AuditModel auditModel) {                                                                        
	  	return  tableSetupDao.saveQualificationSource(auditModel);                                                                     
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateQualificationSource(AuditModel auditModel) {                                                                      
	  	return  tableSetupDao.updateQualificationSource(auditModel);                                                                   
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deleteQualificationSource(int auditQualSourceId) {                                                                      
	  	return  tableSetupDao.deleteQualificationSource(auditQualSourceId);                                                            
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getQualificationSource(int auditQualSourceId) {                                                   
	  	return  tableSetupDao.getQualificationSource(auditQualSourceId);                                                               
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int saveDemoGraphicCrossTab(AuditModel auditModel) {                                                                        
	  	return  tableSetupDao.saveDemoGraphicCrossTab(auditModel);                                                                     
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateDemographicCrossTab(AuditModel auditModel) {                                                                      
	  	return  tableSetupDao.updateDemographicCrossTab(auditModel);                                                                   
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deleteDemographicCrossTab(int auditReportId) {                                                                          
	  	return  tableSetupDao.deleteDemographicCrossTab(auditReportId);                                                                
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getDemographicCrossTab(int auditReportId) {                                                       
	  	return tableSetupDao.getDemographicCrossTab(auditReportId);                                                                    
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<DropdownModel> getQuestionList() {                                                                                     
	  	return  tableSetupDao.getQuestionList();                                                                                       
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int saveSalesChannel(AuditModel auditModel) {                                                                               
	  	return   tableSetupDao.saveSalesChannel(auditModel);                                                                           
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateSalesChannel(AuditModel auditModel) {                                                                             
	  	return  tableSetupDao.updateSalesChannel(auditModel);                                                                          
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deleteSalesChannel(int auditSalesChannelId) {                                                                           
	  	return tableSetupDao.deleteSalesChannel(auditSalesChannelId);                                                                  
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getSalesChannel(int auditSalesChannelId) {                                                        
	  	return  tableSetupDao.getSalesChannel(auditSalesChannelId);                                                                    
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int saveSubscriptionType(AuditModel auditModel) {                                                                           
	  	return  tableSetupDao.saveSubscriptionType(auditModel);                                                                        
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateSubscriptionType(AuditModel auditModel) {                                                                         
	  	return   tableSetupDao.updateSubscriptionType(auditModel);                                                                     
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getSubscriptionType(int auditSubscriptTypeId) {                                                   
	  	return  tableSetupDao.getSubscriptionType(auditSubscriptTypeId);                                                               
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int saveLookupForAuditGalleyIssue(AuditModel auditModel) {                                                                  
	  	return  tableSetupDao.saveLookupForAuditGalleyIssue(auditModel);                                                               
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateLookupForAuditGalleyIssue(AuditModel auditModel) {                                                                
	  	return  tableSetupDao.updateLookupForAuditGalleyIssue(auditModel);                                                             
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deleteLookupForAuditGalleyIssue(String search, int searchFieldGroupSeq, int searchResultDisplaySeq) {                   
	  	return  tableSetupDao.deleteLookupForAuditGalleyIssue(search, searchFieldGroupSeq, searchResultDisplaySeq);                    
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getLookupForAuditGalleyIssue(String search, int searchFieldGroupSeq,                              
	  		int searchResultDisplaySeq) {                                                                                              
	  	return tableSetupDao.getLookupForAuditGalleyIssue(search, searchFieldGroupSeq, searchResultDisplaySeq);                        
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int saveParagraphReports(AuditModel auditModel) {                                                                           
	  	return  tableSetupDao.saveParagraphReports(auditModel);                                                                        
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int updateParagraphReports(AuditModel auditModel) {                                                                         
	  	return  tableSetupDao.updateParagraphReports(auditModel);                                                                      
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public int deleteParagraphReports(int auditReportId) {                                                                             
	  	return tableSetupDao.deleteParagraphReports(auditReportId);                                                                    
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<Map<String, Object>> getParagraphReports() {                                                                           
	  	return tableSetupDao.getParagraphReports();                                                                                    
	  }                                                                                                                                  
	                                                                                                                                     
	  @Override                                                                                                                          
	  public List<DropdownModel> getParagraphSelectionList() {                                                                           
	  	return tableSetupDao.getParagraphSelectionList();                                                                              
	  }

	@Override
	public String getPsRenewalLabel(String currency) {
		return tableSetupDao.getPsRenewalLabel(currency);
	}

	@Override
	public String getPsBilling(String currency) {
		return tableSetupDao.getPsBilling(currency);
	}

	@Override
	public String getOsLabel(String currency) {
		return tableSetupDao.getOsLabel(currency);
	}

	@Override
	public String getOsBackLabel(String currency) {
		return tableSetupDao.getOsBackLabel(currency);
	}

	@Override
	public String getOsRenewal(String currency) {
		return tableSetupDao.getOsRenewal(currency);
	}

	@Override
	public String getOsBilling(String currency) {
		return tableSetupDao.getOsBilling(currency);
	}

	@Override
	public String getOsCancellation(String currency) {
		return tableSetupDao.getOsCancellation(currency);
	}

	@Override
	public String getOsSuspension(String currency) {
		return tableSetupDao.getOsSuspension(currency);
	}

	@Override
	public List<Map<String, Object>> getGroupDetails(int customerId) {
		return tableSetupDao.getGroupDetails(customerId);
	}                                                          

	@Override
	public String Renewal(String currency, int... business_processes) {
		return tableSetupDao.Renewal(currency,business_processes);
	}

	@Override
	public String PsBillingUpdate(String currency, int... business_processes) {
		return tableSetupDao.PsBillingUpdate(currency,business_processes);
	}

	@Override
	public String osLabelUpdate(String currency, int... business_processes) {
		return tableSetupDao.osLabelUpdate(currency,business_processes);
	}

	@Override
	public String osBackLabelUpdate(String currency, int... business_processes) {
		return tableSetupDao.osBackLabelUpdate(currency,business_processes);
	}

	@Override
	public String osRenewalUpdate(String currency, int... business_processes) {
		return tableSetupDao.osRenewalUpdate(currency,business_processes);
	}

	@Override
	public String osBillingUpdate(String currency, int... business_processes) {
		return tableSetupDao.osBillingUpdate(currency,business_processes);
	}

	@Override
	public String osCancellationUpdate(String currency, int... business_processes) {
		return tableSetupDao.osCancellationUpdate(currency,business_processes);
	}

	@Override
	public String osSuspensionUpdate(String currency, int... business_processes) {
		return tableSetupDao.osSuspensionUpdate(currency,business_processes);
	}                                                          


}


	

	

