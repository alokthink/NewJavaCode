package com.mps.think.setup.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.mps.think.setup.service.OrderClassService;
import com.mps.think.setup.util.PropertyUtils;

@RestController
public class OrderClassDetailsController {
	private static Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderClassDetailsController.class);

	@Autowired
	OrderClassService orderClassService;

	@RequestMapping(path = "/descriptionDetails", method = RequestMethod.POST)
	public Map<String, Object> getDescriptionDetails(String ocId, Long showId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> OrderClassID1 = new ArrayList<>();
		List<Map<String, Object>> TopicsData = new ArrayList<>();
		List<Map<String, Object>> dropDownSetValues = new ArrayList<>();
		try {
			OrderClassID1 = orderClassService.getOrderClassID1(ocId);
			List<DropdownModel> defaultSourceCodeList = orderClassService.getDefaultSourceCode(ocId);
			List<DropdownModel> SourceCodeFormatList = orderClassService.getSourceCodeFormat();
			List<DropdownModel> LabelOutputData = orderClassService.getLabelOutputData();
			List<DropdownModel> PaymentThresholdData = orderClassService.getPaymentThresholdData();
			List<DropdownModel> ProfitCenter = orderClassService.getProfitCenter();
			TopicsData = orderClassService.getTopicTableData(showId);
			dropDownSetValues = orderClassService.getDropDownDefaultData(ocId);
			responseObject.put("OrderClassDetails", OrderClassID1);
			responseObject.put("DefaultSourceCode", defaultSourceCodeList);
			responseObject.put("SourceCodeFormat", SourceCodeFormatList);
			responseObject.put("RSourceCodeFormat", SourceCodeFormatList);
			responseObject.put("PSourceCodeFormat", SourceCodeFormatList);
			responseObject.put("ProfitCenter", ProfitCenter);
			responseObject.put("PaymentThreshold", PaymentThresholdData);
			responseObject.put("LabelOutput", LabelOutputData);
			responseObject.put("TopicsData", TopicsData); 
			responseObject.put("dropDownValues", dropDownSetValues);
			List<DropdownModel> newGroupMemberActionList = orderClassService.getNewGroupMemberActionList();
			responseObject.put("groupMember", newGroupMemberActionList);
			List<DropdownModel> inventoryList = orderClassService.getInventoryList(ocId);
			responseObject.put("inventory", inventoryList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getOrderClassDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This API is for Volume Group Target Levels button of Description API
	@RequestMapping(path = "/targetLevels", method = RequestMethod.POST)
	public Map<String, Object> getVolumeGroupTargetLevels(Long ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> volumeGroupTargetLevels = new ArrayList<>();
		List<DropdownModel> volumeGroups = new ArrayList<>();
		List<DropdownModel> regionDataList = new ArrayList<>();
		try {

			volumeGroupTargetLevels = orderClassService.getVGTargetSalesLevels(ocId);
			responseObject.put("targetSalesLevels", volumeGroupTargetLevels);
			volumeGroups = orderClassService.getVolumeGroupList();
			responseObject.put("volumeGroups", volumeGroups);
			regionDataList = orderClassService.getRegionList();
			responseObject.put("regionList", regionDataList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getVolumeGroupTargetLevels : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveVGTargetSales", method = RequestMethod.POST)
	public Map<String, Object> saveVGTargetSalesDetails(VolumeGroup volumeGroup) {
		String saveVGTargetSales = "";
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			if (volumeGroup.getRegionList() != null && volumeGroup.getRegion() == null) {
				saveVGTargetSales = orderClassService.saveTargetSalesLevels(volumeGroup);
				if (saveVGTargetSales != null && !saveVGTargetSales.contains("duplicate")) {
					responseObject.put(STATUS, true);
					responseObject.put("saveVGTargetSales", saveVGTargetSales);
				} else {
					responseObject.put(STATUS, false);
					responseObject.put("duplicateRecord", saveVGTargetSales);
				}
			} else if (volumeGroup.getRegionList() != null
					&& (volumeGroup.getRegion() != null && volumeGroup.getSubscriptionCategoryId() == null)) {
				saveVGTargetSales = orderClassService.saveTargetSalesLevels(volumeGroup);
				if (saveVGTargetSales != null && !saveVGTargetSales.contains("duplicate")) {
					responseObject.put(STATUS, true);
					responseObject.put("saveVGTargetSales", saveVGTargetSales);
				} else {
					responseObject.put(STATUS, false);
					responseObject.put("duplicateRecord", saveVGTargetSales);
				}
			} else {
				saveVGTargetSales = orderClassService.saveTargetSalesLevels(volumeGroup);
				if (saveVGTargetSales != null && !saveVGTargetSales.contains("is not")) {
					responseObject.put(STATUS, true);
					responseObject.put("saveVGTargetSales", saveVGTargetSales);
				} else {
					saveVGTargetSales = orderClassService.saveTargetSalesLevels(volumeGroup);
					responseObject.put(STATUS, false);
					responseObject.put("missMatchedRecord", saveVGTargetSales);
				}
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveVGTargetSalesDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateVGTargetSales", method = RequestMethod.POST)
	public Map<String, Object> updateVGTargetSalesDetails(VolumeGroup volumeGroup) {
		String updateVGTargetSales = "";
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			if (volumeGroup.getRegionList() != null && volumeGroup.getRegion() == null) {
				updateVGTargetSales = orderClassService.updateTargetSalesLevels(volumeGroup);
				if (updateVGTargetSales != null && !updateVGTargetSales.contains("duplicate")) {
					responseObject.put(STATUS, true);
					responseObject.put("saveVGTargetSales", updateVGTargetSales);
				} else {
					responseObject.put(STATUS, false);
					responseObject.put("duplicateRecord", updateVGTargetSales);
				}
			} else if (volumeGroup.getRegionList() != null
					&& (volumeGroup.getRegion() != null && volumeGroup.getSubscriptionCategoryId() == null)) {
				updateVGTargetSales = orderClassService.updateTargetSalesLevels(volumeGroup);
				if (updateVGTargetSales != null && !updateVGTargetSales.contains("duplicate")) {
					responseObject.put(STATUS, true);
					responseObject.put("saveVGTargetSales", updateVGTargetSales);
				} else {
					responseObject.put(STATUS, false);
					responseObject.put("duplicateRecord", updateVGTargetSales);
				}
			} else {
				updateVGTargetSales = orderClassService.updateTargetSalesLevels(volumeGroup);
				if (updateVGTargetSales != null && !updateVGTargetSales.contains("duplicate")) {
					responseObject.put(STATUS, true);
					responseObject.put("saveVGTargetSales", updateVGTargetSales);
				} else {
					updateVGTargetSales = orderClassService.updateTargetSalesLevels(volumeGroup);
					responseObject.put(STATUS, false);
					responseObject.put("missMatchedRecord", updateVGTargetSales);
				}
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateVGTargetSalesDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	// This API is for Target Sales Levels button of Description API
	// First case parameter : Long ocId, Long volumeGroupId,String regionList for
	// Region and Sales Target
	// Second case parameter : Long ocId, Long volumeGroupId for
	// SubscriptionCategory and Sales Target
	@RequestMapping(path = "/targetSalesDetails", method = RequestMethod.POST)
	public Map<String, Object> getTargetSalesDetails(Long ocId, Long volumeGroupId, String regionList) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> targetSalesDetails = new ArrayList<>();
		List<Map<String, Object>> subsCategoryDetails = new ArrayList<>();
		List<DropdownModel> region = new ArrayList<>();
		List<DropdownModel> subscriptionCategory = new ArrayList<>();
		try {
			targetSalesDetails = orderClassService.getTargetSalesLevels(ocId, volumeGroupId);
			responseObject.put("targetSalesDetails", targetSalesDetails);
			subsCategoryDetails = orderClassService.getSubscriptionCategory(ocId, volumeGroupId);
			responseObject.put("subsCategoryDetails", subsCategoryDetails);
			region = orderClassService.getRegion(regionList);
			responseObject.put("region", region);
			subscriptionCategory = orderClassService.getSubscriptionCategory();
			responseObject.put("subscriptionCategory", subscriptionCategory);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getTargetLevels : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/topicActive", method = RequestMethod.POST)
	public Map<String, Object> topicActiveSave(Long ocId, String topic) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		int rateClassTableData;
		try {
			rateClassTableData = orderClassService.topicActiveSave(ocId, topic);
			if (rateClassTableData == 1) {
				responseObject.put(STATUS, SUCCESS);
			} else {
				responseObject.put(STATUS, ERROR);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in topicActiveSave : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/topicInActive", method = RequestMethod.POST)
	public Map<String, Object> topicInActiveSave(Long ocId, String topic) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		int inActiveTableData;
		try {
			inActiveTableData = orderClassService.topicInActiveSave(ocId, topic);
			if (inActiveTableData == 1) {
				responseObject.put(STATUS, SUCCESS);
			} else {
				responseObject.put(STATUS, ERROR);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in topicInActiveSave : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// Rate Class Grid API
	@RequestMapping(path = "/rateClassTableData", method = RequestMethod.POST)
	public Map<String, Object> getRateClassTableDetails(Long ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> rateClassTableData = new ArrayList<>();
		try {
			rateClassTableData = orderClassService.getRateClassTableDetails(ocId);
			responseObject.put("rateClassTableData", rateClassTableData);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getRateClassTableDataDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This api is to add new record
	@RequestMapping(path = "/populateRateClass", method = RequestMethod.POST)
	public Map<String, Object> populateRateClass(int rateClassId, Long ocId) {
		Map<String, Object> responseObject = null;
		List<Map<String, Object>> effectiveDatesTableData = new ArrayList<>();
		List<Map<String, Object>> rateCardDetailsForEffectiveDates = new ArrayList<>();
		try {

			responseObject = new LinkedHashMap<>();
			List<DropdownModel> regionList = orderClassService.getRegionList();
			responseObject.put("regionList", regionList);
			List<DropdownModel> renewalCardList = orderClassService.getRenewalDropDownData(ocId);
			responseObject.put("renewalCardList", renewalCardList);
			effectiveDatesTableData = orderClassService.getEffectiveDatesTableData(rateClassId);
			rateCardDetailsForEffectiveDates = orderClassService.getRateCardTableData(rateClassId);
			responseObject.put("effectiveDatesTableData", effectiveDatesTableData);
			responseObject.put("rateCardDetailsForEffectiveDates", rateCardDetailsForEffectiveDates);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in populateRateClass() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/rateClassEditDetails", method = RequestMethod.POST)
	public Map<String, Object> getRateClassDetails(int rateClassId, Long ocId, String regionList) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> rateClassData = new ArrayList<>();
		List<Map<String, Object>> effectiveDatesTableData = new ArrayList<>();
		List<Map<String, Object>> rateCardDetailsForEffectiveDates = new ArrayList<>();
		List<DropdownModel> qtyDiscountList = new ArrayList<>();
		try {
			rateClassData = orderClassService.getRateClassDetails(rateClassId);
			// List<DropdownModel> regionList= orderClassService.getRegionList();
			effectiveDatesTableData = orderClassService.getEffectiveDatesTableData(rateClassId);

			rateCardDetailsForEffectiveDates = orderClassService.getRateCardTableData(rateClassId);
			qtyDiscountList = orderClassService.getQtyDiscount();
			responseObject.put("rateClassData", rateClassData);
			responseObject.put("effectiveDatesTableData", effectiveDatesTableData);
			responseObject.put("rateCardDetailsForEffectiveDates", rateCardDetailsForEffectiveDates);

			List<DropdownModel> renewalDropDownData = orderClassService.getRenewalDropDownData(ocId);
			responseObject.put("renewalDropDownData", renewalDropDownData);

			List<DropdownModel> region = orderClassService.getRegion(regionList);
			responseObject.put("region", region);

			List<DropdownModel> lookupCurrency = orderClassService.lookupCurrency();
			responseObject.put("lookupCurrency", lookupCurrency);

			List<DropdownModel> currency = orderClassService.lookupCurrency();
			responseObject.put("currency", currency);

			List<DropdownModel> unitType = orderClassService.getDiscountCardUnitType();
			responseObject.put("unitType", unitType);

			// agencyRateDetails = orderClassService.getAgencyRate();
			// responseObject.put("agencyRateDetails", agencyRateDetails);

			responseObject.put("qtyDiscountList", qtyDiscountList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getRateClassTableDataDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// Rate Class Save and Update API
	// "/addRateClassSave" & "updateRateClassRecords" ParentOrderClassController

	// This api is to add new record into rate_class_effective table
	@RequestMapping(path = "/saveRateClassEffective", method = RequestMethod.POST)
	public Map<String, Object> saveRateClassEffectiveData(RateClassModel rateClassModel) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {

			status = orderClassService.saveRateClassEffective(rateClassModel);
			int rateClassId = rateClassModel.getRateClassId();
			int rateClassEffectiveSeq = orderClassService.getRateClassEffectiveSeq(rateClassId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("rateClassId", rateClassId);
				responseObject.put("rateClassEffectiveSeq", rateClassEffectiveSeq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveRateClassEffectiveData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This api is to update existing record into rate_class_effective table
	@RequestMapping(path = "/updateRateClassEffective", method = RequestMethod.POST)
	public Map<String, Object> updateRateClassEffectiveData(RateClassModel rateClassModel) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {

			status = orderClassService.updateRateClassEffective(rateClassModel);
			int rateClassId = rateClassModel.getRateClassId();
			int rateClassEffectiveSeq = rateClassModel.getRateClassEffectiveSeq();
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("rateClassId", rateClassId);
				responseObject.put("rateClassEffectiveSeq", rateClassEffectiveSeq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateDiscountRecords : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/rateCardDetails", method = RequestMethod.POST)
	public Map<String, Object> getRateCardDetails(String regionList, int rateClassId, int rateClassEffectiveSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> rateCardDetails = new ArrayList<>();
		// List<DropdownModel> agencyRateDetails=new ArrayList<>();
		// List<Map<String, Object>> agencyRateDetails=new ArrayList<>();
		List<DropdownModel> qtyDiscountList = new ArrayList<>();
		try {

			rateCardDetails = orderClassService.getRateCardTableData(rateClassId, rateClassEffectiveSeq);
			responseObject.put("rateCardDetails", rateCardDetails);
			List<DropdownModel> region = orderClassService.getRegion(regionList);
			responseObject.put("region", region);
			List<DropdownModel> lookupCurrency = orderClassService.lookupCurrency();
			responseObject.put("lookupCurrency", lookupCurrency);
			List<DropdownModel> currency = orderClassService.lookupCurrency();
			responseObject.put("currency", currency);
			List<DropdownModel> unitType = orderClassService.getDiscountCardUnitType();
			responseObject.put("unitType", unitType);
			// agencyRateDetails = orderClassService.getAgencyRate();
			// responseObject.put("agencyRateDetails", agencyRateDetails);
			qtyDiscountList = orderClassService.getQtyDiscount();
			responseObject.put("qtyDiscountList", qtyDiscountList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDiscountCardDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/agencyRateDetails", method = RequestMethod.POST)
	public Map<String, Object> getAgencyRateDetails(Integer rateClassId, Integer rateCardSeq) {
		Map<String, Object> responseObject = new HashMap<String, Object>();
		List<Map<String, Object>> agencyRateDetails = new ArrayList<>();
		int status = 0;
		try {
			agencyRateDetails = orderClassService.getAgencyRate(rateClassId, rateCardSeq);
			status++;
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("agencyRateDetails", agencyRateDetails);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in getAgencyRateDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/deleteRateClassRecords", method = RequestMethod.POST)
	public Map<String, Object> deleteRateClassRecords(int rateClassId) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = orderClassService.deleteRateClassRecords(rateClassId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteUpSellDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/rateCopyDetails", method = RequestMethod.POST)
	public Map<String, Object> rateCardCopyDetails(Integer rateClassId) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> rateClassEffectiveList = new ArrayList<>();
		int status = 0;
		try {
			rateClassEffectiveList = orderClassService.getRateCardCopyDetails(rateClassId);
			status++;
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("rateClassEffectiveList", rateClassEffectiveList);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in rateCardCopyDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveRateCardCopy", method = RequestMethod.POST)
	public Map<String, Object> rateCardCopyList(Integer rateClassId, Integer rateClassEffectiveSeq,
			RateClassModel model) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> rateCardList = new ArrayList<>();
		// List<RateClassModel> rateCardModelList = new ArrayList<RateClassModel>();
		int status = 0;
		try {
			rateCardList = orderClassService.getRateCardCopyList(rateClassId, rateClassEffectiveSeq);
			status++;
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				for (Map<String, Object> list : rateCardList) {
					Integer id = Integer.parseInt(list.get("rate_class_id").toString());
					model.setRateClassId(id);
					Integer rate_class_effective_seq = Integer
							.parseInt(list.get("rate_class_effective_seq").toString());
					model.setRateClassEffectiveSeq(rate_class_effective_seq);
					Integer rateCardSeq = Integer.parseInt(list.get("ratecard_seq").toString());
					model.setRateCardSeq(rateCardSeq);
					Integer fromQty = Integer.parseInt(list.get("from_qty").toString());
					model.setFromQty(fromQty);
					String regionList = list.get("region_list") != null ? (String) list.get("region_list") : null;
					model.setRegionList(regionList);
					String region = list.get("region") != null ? (String) list.get("region") : null;
					model.setRegion(region);

					String currency = list.get("currency") != null ? (String) list.get("currency") : null;
					model.setCurrency(currency);

					Integer toQty = Integer.parseInt(list.get("to_qty").toString());
					model.setToQty(toQty);
					String price = String.valueOf(list.get("price"));
					Float p = Float.parseFloat(price);
					model.setPrice(p);
					String chargeNew = String.valueOf(list.get("charge_new")) != null
							? String.valueOf(list.get("charge_new"))
							: null;
					if (chargeNew == null | chargeNew.equals("null")) {
						model.setChargeNew(0);
					} else {
						model.setChargeNew(Float.parseFloat(chargeNew));
					}

					String remitNew = String.valueOf(list.get("remit_new")) != null
							? String.valueOf(list.get("remit_new"))
							: null;
					if (remitNew == null | remitNew.equals("null")) {
						model.setRemitNew(0);
					} else {
						model.setRemitNew(Float.parseFloat(remitNew));
					}

					String percentNew = String.valueOf(list.get("percent_new")) != null
							? String.valueOf(list.get("percent_new"))
							: null;
					if (percentNew == null | percentNew.equals("null")) {
						model.setChargeNew(0);
					} else {
						model.setPercentNew(Float.parseFloat(percentNew));
					}
					String basic = String.valueOf(list.get("basic"));
					Float o = Float.valueOf(basic);
					model.setBasic(o);
					String chargeRen = String.valueOf(list.get("percent_new"));
					if (chargeRen == null | chargeRen.equals("null")) {
						model.setChargeRen(0);
					} else {
						model.setChargeRen(Float.parseFloat(chargeRen));
					}
					String remitRen = String.valueOf(list.get("percent_new")) != null
							? String.valueOf(list.get("percent_new"))
							: null;
					if (remitRen == null | remitRen.equals("null")) {
						model.setRemitRen(0);
					} else {
						model.setRemitRen(Float.parseFloat(remitRen));
					}

					String percentRen = String.valueOf(list.get("percent_new")) != null
							? String.valueOf(list.get("percent_new"))
							: null;
					if (percentRen == null | percentRen.equals("null")) {
						model.setPercentRen(0);
					} else {
						model.setPercentRen(Float.parseFloat(percentRen));
					}
					String lookupCurrency = list.get("lookup_currency") != null ? (String) list.get("lookup_currency")
							: null;
					model.setLookupCurrency(lookupCurrency);

					Integer baselineQty = Integer.parseInt(list.get("baseline_qty").toString());
					if (baselineQty == 0) {
						model.setBaselineQty(1);
					} else {
						model.setBaselineQty(baselineQty);
					}

					Short unitType = Short.parseShort(list.get("unit_type").toString());
					if (unitType == 0) {
						model.setUnitType(unitType);
					} else {
						model.setUnitType(unitType);
					}
					// rateCardModelList.add(model);//add model to list
					orderClassService.saveRateCardRecords(model);
				}
				// orderClassService.insertBatchRateCard(rateCardModelList);//call batch to
				// insert record
				rateCardList = orderClassService.getRateCardCopyList(rateClassId, rateClassEffectiveSeq);
				responseObject.put(STATUS, true);
				responseObject.put("rateClassId", rateClassId);
				responseObject.put("rateClassEffectiveSeq", rateClassEffectiveSeq);
				responseObject.put("rateCardList", rateCardList);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveRateCardCopy : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// Rate Card API
	@RequestMapping(path = "/saveRateCardRecords", method = RequestMethod.POST)
	public Map<String, Object> saveRateCardRecords(RateClassModel model) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.saveRateCardRecords(model);
			int rateClassId = model.getRateClassId();
			int rateClassEffectiveSeq = model.getRateClassEffectiveSeq();
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("rateClassId", rateClassId);
				responseObject.put("rateClassEffectiveSeq", rateClassEffectiveSeq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveRateCardRecords(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updateRateCardRecords", method = RequestMethod.POST)
	public Map<String, Object> updateRateCardRecords(RateClassModel model) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.updateRateCardRecords(model);
			int rateClassId = model.getRateClassId();
			int rateClassEffectiveSeq = model.getRateClassEffectiveSeq();
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("rateClassId", rateClassId);
				responseObject.put("rateClassEffectiveSeq", rateClassEffectiveSeq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateRateCardRecords(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This is for main grid
	@RequestMapping(path = "/discountDetails", method = RequestMethod.POST)
	public Map<String, Object> getDiscountClassByOcId(Long ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> discountDetails = new ArrayList<>();
		try {
			discountDetails = orderClassService.getDiscountClass(ocId);
			responseObject.put("discountDetails", discountDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDiscountClassByOcId() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/discountRateEditDetailsData", method = RequestMethod.POST)
	public Map<String, Object> getEffectiveDateDiscountTableDetails(int discountId, String regionList) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> DiscountRates = new ArrayList<>();
		List<Map<String, Object>> effectiveDatesRateCardData = new ArrayList<>();
		List<Map<String, Object>> discountRateCardData = new ArrayList<>();
		try {

			DiscountRates = orderClassService.getDiscountRates(discountId);
			responseObject.put("DiscountRateDetails", DiscountRates);
			effectiveDatesRateCardData = orderClassService.getEffectiveDiscountData(discountId);
			responseObject.put("effectiveDatesDiscountData", effectiveDatesRateCardData);
			discountRateCardData = orderClassService.getDiscountCardRecords(discountId);
			responseObject.put("discountRateCardData", discountRateCardData);
			List<DropdownModel> regionlist = orderClassService.getRegionList();
			responseObject.put("regionList", regionlist);
			List<DropdownModel> region = orderClassService.getRegion(regionList);
			responseObject.put("region", region);
			List<DropdownModel> lookupCurrency = orderClassService.lookupCurrency();
			responseObject.put("lookupCurrency", lookupCurrency);
			List<DropdownModel> currency = orderClassService.lookupCurrency();
			responseObject.put("currency", currency);
			List<DropdownModel> unitType = orderClassService.getDiscountCardUnitType();
			responseObject.put("unitType", unitType);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getEffectiveDateDiscountTableDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This api is to add new record
	@RequestMapping(path = "/populateDiscountClass", method = RequestMethod.POST)
	public Map<String, Object> populateDiscountClass(Long ocId, int discountId) {
		Map<String, Object> responseObject = null;
		// List<Map<String, Object>> DiscountRates=new ArrayList<>();
		try {

			responseObject = new LinkedHashMap<>();
			List<DropdownModel> regionList = orderClassService.getRegionList();
			responseObject.put("regionList", regionList);
			// =( List<Map<String,Object>>) orderClassService.getDiscountRates(discountId);
			// responseObject.put("discountClassDetails", DiscountRates);
			List<Map<String, Object>> effectiveDateDetails = orderClassService.getEffectiveDiscountData(discountId);
			responseObject.put("effectiveDateDetails", effectiveDateDetails);
			List<Map<String, Object>> discountCardDetails = orderClassService.getDiscountCardRecords(discountId);
			responseObject.put("discountCardDetails", discountCardDetails);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in populateDiscountClass() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// this is for look up details
	@RequestMapping(path = "/discountClassDetails", method = RequestMethod.POST)
	public Map<String, Object> getDiscountDetails(int discountId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> DiscountRates = new ArrayList<>();
		List<Map<String, Object>> effectiveDatesRateCardData = new ArrayList<>();
		List<Map<String, Object>> discountRateCardData = new ArrayList<>();
		try {
			DiscountRates = orderClassService.getDiscountRates(discountId);
			responseObject.put("discountClassDetails", DiscountRates);
			effectiveDatesRateCardData = orderClassService.getEffectiveDiscountData(discountId);
			responseObject.put("effectiveDatesDiscountData", effectiveDatesRateCardData);
			discountRateCardData = orderClassService.getDiscountCardRecords(discountId);
			responseObject.put("discountRateCardData", discountRateCardData);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDiscountDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// to save records of discount class, "/addDiscountClassSave" API is available
	// in ParentOrderClassController
	@RequestMapping(path = "/updateDiscountClassRecords", method = RequestMethod.POST)
	public Map<String, Object> updateDiscountRecords(DiscountClassModel discountClassModel) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {
			Integer discountId = discountClassModel.getDiscountClassId();
			String regionList = discountClassModel.getRegionList();
			status = orderClassService.updateDiscountClassRecords(discountClassModel);

			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("discountId", discountId);
				responseObject.put("regionList", regionList);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateDiscountRecords : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/deleteDiscountRecords", method = RequestMethod.POST)
	public Map<String, Object> deleteDiscountRecords(int ocId, int discountId) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = orderClassService.deleteDiscountRecords(ocId, discountId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteDiscountDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/discClassEffectiveDateDetails", method = RequestMethod.POST)
	public Map<String, Object> geDiscClassEffective(int discountId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> discClassEffectiveDateDetails = new ArrayList<>();
		try {
			discClassEffectiveDateDetails = orderClassService.getDiscountClassEffectiveDateDetails(discountId);
			responseObject.put("discClassEffectiveDateDetails", discClassEffectiveDateDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in geDiscClassEffective() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This api is to add new record into disc_class_effective table
	@RequestMapping(path = "/saveDiscClassEffective", method = RequestMethod.POST)
	public Map<String, Object> saveDiscClassEffectiveData(DiscClassEffective discClassEffective) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.saveEffectiveDateDiscountRecords(discClassEffective);
			int discountId = discClassEffective.getDiscountClassId();
			int disc_class_effective_Seq = orderClassService.getDisc_class_effective_Seq(discountId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("discountId", discountId);
				responseObject.put("disc_class_effective_Seq", disc_class_effective_Seq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveDiscClassEffectiveData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This api is to update existing record into disc_class_effective table
	@RequestMapping(path = "/updateDiscClassEffective", method = RequestMethod.POST)
	public Map<String, Object> updateEffectiveRateDiscountRecords(DiscClassEffective discClassEffective) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.updateEffectiveDateDiscountRecords(discClassEffective);
			int discountId = discClassEffective.getDiscountClassId();
			int disc_class_effective_Seq = discClassEffective.getDiscClassEffectiveSeq();
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("discountId", discountId);
				responseObject.put("disc_class_effective_Seq", disc_class_effective_Seq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateDiscountRecords : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This api is to show drop down to select region, lookup currency,currency and
	// unit type to save record into discount_card table
	@RequestMapping(path = "/populateDiscountCard", method = RequestMethod.POST)
	public Map<String, Object> populateDiscountCard(String regionList) {
		Map<String, Object> responseObject = null;
		try {
			responseObject = new LinkedHashMap<>();
			List<DropdownModel> region = orderClassService.getRegion(regionList);
			responseObject.put("region", region);
			List<DropdownModel> lookupCurrency = orderClassService.lookupCurrency();
			responseObject.put("lookupCurrency", lookupCurrency);
			List<DropdownModel> currency = orderClassService.lookupCurrency();
			responseObject.put("currency", currency);
			List<DropdownModel> unitType = orderClassService.getDiscountCardUnitType();
			responseObject.put("unitType", unitType);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in populateDiscountCard() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/discountCardDetails", method = RequestMethod.POST)
	public Map<String, Object> getDiscountCardDetails(String regionList, int discountId, int disc_class_effective_Seq) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();

		List<Map<String, Object>> discountCardDetails = new ArrayList<>();
		try {

			discountCardDetails = orderClassService.getDiscountCardRecords(discountId, disc_class_effective_Seq);
			responseObject.put("discountCardDetails", discountCardDetails);
			List<DropdownModel> region = orderClassService.getRegion(regionList);
			responseObject.put("region", region);
			List<DropdownModel> lookupCurrency = orderClassService.lookupCurrency();
			responseObject.put("lookupCurrency", lookupCurrency);
			List<DropdownModel> currency = orderClassService.lookupCurrency();
			responseObject.put("currency", currency);
			List<DropdownModel> unitType = orderClassService.getDiscountCardUnitType();
			responseObject.put("unitType", unitType);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDiscountCardDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// Discount Card API
	@RequestMapping(path = "/saveDiscountCardRecords", method = RequestMethod.POST)
	public Map<String, Object> saveDiscountCardRecords(DiscountCard discountCard) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.saveDiscountCardRecords(discountCard);
			int discountId = discountCard.getDiscountClassId();
			int disc_class_effective_Seq = discountCard.getDiscClassEffectiveSeq();
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("discountId", discountId);
				responseObject.put("disc_class_effective_Seq", disc_class_effective_Seq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveDiscountCardRecords(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updateDiscountCardRecords", method = RequestMethod.POST)
	public Map<String, Object> updateDiscountCardRecords(DiscountCard discountCard) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.updateDiscountCardRecords(discountCard);
			int discountId = discountCard.getDiscountClassId();
			int disc_class_effective_Seq = discountCard.getDiscClassEffectiveSeq();
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
				responseObject.put("discountId", discountId);
				responseObject.put("disc_class_effective_Seq", disc_class_effective_Seq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateDiscountCardRecords(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/sourceCodeDetails", method = RequestMethod.POST)
	public Map<String, Object> getSourceCodeDetails(Long ocId, int active, int sourceCodeType, int isDDp) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<ParentOrderClassModel> SourceCodeTableData = new ArrayList<>();
		try {
			SourceCodeTableData = orderClassService.getSourceCodeDetails(ocId, active, sourceCodeType, isDDp);
			responseObject.put("sourceCodeTableData", SourceCodeTableData);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getSourceCodeDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/sourceCodeTypeDetails", method = RequestMethod.POST)
	public Map<String, Object> getSourceCodeTypeDetails() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<DropdownModel> activeDataList = new ArrayList<>();
		try {
			List<DropdownModel> sourceTypeList = orderClassService.getSourceCodeTypeDetails();

			for (int i = 0; i <= 1; i++) {
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtils().getConstantValue("active_" + i));
				activeDataList.add(model);
			}
			// List<DropdownModel> statusList= orderClassService.getSourceCodeTypeDetails();
			responseObject.put("sourceTypeList", sourceTypeList);
			responseObject.put("activeDataList", activeDataList);

		} catch (Exception e) {
			LOGGER.info("Error in sourceCodeType : " + e);
			responseObject.put(STATUS, ERROR + e);
		}
		return responseObject;
	}

	@RequestMapping(path = "/demographicsTableData", method = RequestMethod.POST)
	public Map<String, Object> getDemographicsTableData(int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> demographicsTableData = new ArrayList<>();
		try {
			demographicsTableData = orderClassService.getDemographicsTableData(ocId);
			responseObject.put("demograficsTableData", demographicsTableData);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDemographicsTableData : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

//	@RequestMapping(path = "/dashboardLeftPanel", method = RequestMethod.POST)
//	public Map<String, Object> getleftpanelData() {
//		Map<String, Object> responseObject = new HashMap<>();
//		List<DashboardLeftPanelModel> leftPanelMenuData = new ArrayList<>();
//		try {
//			leftPanelMenuData = orderClassService.getleftPanelDashboardData();
//			responseObject.put("leftPanelMenuData", leftPanelMenuData);
//			responseObject.put(STATUS, SUCCESS);
//			return responseObject;
//		} catch (Exception e) {
//			LOGGER.info("Error in getleftpanelData : " + e);
//			responseObject.put(STATUS, ERROR + e);
//			return responseObject;
//		}
//
//	
	// }
	@RequestMapping(path = "/dashboardLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> getleftpanelData2() {
		Map<String, Object> responseObject = new HashMap<>();
		List<DashboardLeftPanelModel> ParentRootMenu = new ArrayList<>();
		List<DashboardLeftPanelModel> childRootMenu = new ArrayList<>();
		try {
			DashboardLeftPanelModel model = new DashboardLeftPanelModel();
			model.setId("0");
			;
			model.setTitle("Order Classes");
			model.setOcType("0");
			model.setIsActive("false");
			childRootMenu = orderClassService.getleftPanelDashboardData();
			model.setNodes(childRootMenu);
			ParentRootMenu.add(model);
			responseObject.put("leftPanelMenuData", ParentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getleftpanelData2() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This API for Grid in which all table's data will show
	@RequestMapping(path = "/upSellTableData", method = RequestMethod.POST)
	public Map<String, Object> getUpSellTableData() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<UpSellModel> upSellTableData = orderClassService.getUpSellTableData();
			responseObject.put("upSellTableData", upSellTableData);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getUpSellTableData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	/**
	 * This API populate the new create upsell data
	 */
	@RequestMapping(path = "/populateUpsellData", method = RequestMethod.POST)
	public Map<String, Object> populateUpsellData() {
		Map<String, Object> responseObject = null;
		try {

			responseObject = new LinkedHashMap<>();

			List<DropdownModel> suggestionList = orderClassService.getSuggestionList();
			responseObject.put("suggestionList", suggestionList);
			List<DropdownModel> upsellType = orderClassService.getUpsellType();
			responseObject.put("upsellType", upsellType);
			List<DropdownModel> conditionList = orderClassService.getConditionList();
			responseObject.put("conditionList", conditionList);
			List<CalendarCampaignModel> compaignList = orderClassService.getCompaignList();
			responseObject.put("compaignList", compaignList);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in populateUpsellData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/upsellDetailsSave", method = RequestMethod.POST)
	public Map<String, Object> addUpSell(UpSellModel upSellClassModel) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.addUpSell(upSellClassModel);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveUpSell : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This API for Look up in which all table's data will show
	@RequestMapping(path = "/upSellDetails", method = RequestMethod.POST)
	public Map<String, Object> getUpSellDetails(int ocId, int upsellId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> upSellDetails = new ArrayList<>();
		try {

			upSellDetails = orderClassService.getUpSellDetails(ocId, upsellId);
			responseObject.put("UpSellDetails", upSellDetails);
			List<DropdownModel> suggestionList = orderClassService.getSuggestionList();
			responseObject.put("suggestionList", suggestionList);
			List<DropdownModel> upsellType = orderClassService.getUpsellType();
			responseObject.put("upsellType", upsellType);
			List<DropdownModel> conditionList = orderClassService.getConditionList();
			responseObject.put("conditionList", conditionList);
			List<CalendarCampaignModel> compaignList = orderClassService.getCompaignList();
			responseObject.put("compaignList", compaignList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getUpSellDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateUpSellRecords", method = RequestMethod.POST)
	public Map<String, Object> updateUpSellRecords(UpSellModel upSellClassModel) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {
			status = orderClassService.updateUpSellRecords(upSellClassModel);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateUpSellRecords : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/deleteUpSellDetails", method = RequestMethod.POST)
	public Map<String, Object> deleteUpSellDetails(int upsellId) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = orderClassService.deleteUpSellRecords(upsellId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteUpSellDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/orderCodeTableData", method = RequestMethod.POST)
	public Map<String, Object> getOrderCodeTableData(int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<OrderCodeModel> orderCodeTableData = orderClassService.getOrderCodeTableData(ocId);
			responseObject.put("orderCodeTableData", orderCodeTableData);
			System.out.println(orderCodeTableData);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getOrderCodeTableData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/populateOrderCode", method = RequestMethod.POST)
	public Map<String, Object> populateOrderCodeData(Long ocId, Integer ocType, String userCode) {
		Map<String, Object> responseObject = null;
		try {
			responseObject = new LinkedHashMap<>();
			Integer orderCodeType = orderClassService.getOrderCodeType(ocType);
			responseObject.put("orderCodeType", orderCodeType);
			List<DropdownModel> installmentPlans = orderClassService.getInstallmentPlans();
			responseObject.put("installmentPlans", installmentPlans);

			/*
			 * List<DropdownModel> auditDefaults = orderClassService.getAuditDefaults();
			 * responseObject.put("auditDefaults", auditDefaults);
			 */

			List<DropdownModel> creditCardProcess = orderClassService.getCreditCardProcess();
			responseObject.put("creditCardProcess", creditCardProcess);

			List<DropdownModel> settleRetryDef = orderClassService.getSettleRetryDef();
			responseObject.put("settleRetryDef", settleRetryDef);

			List<DropdownModel> commodityList = orderClassService.getCommodityList();
			responseObject.put("commodityList", commodityList);

			List<DropdownModel> rateList = orderClassService.searchRateClass(ocId);
			responseObject.put("rateList", rateList);

			List<DropdownModel> discountList = orderClassService.searchDiscountClass(ocId);
			responseObject.put("discountList", discountList);

			List<DropdownModel> taxonomyList = orderClassService.getTaxonomyList();
			responseObject.put("taxonomyList", taxonomyList);

			List<DropdownModel> issueList = orderClassService.getIssue(ocId);
			responseObject.put("issueList", issueList);

			List<DropdownModel> premiumList = orderClassService.getPremiumList();
			responseObject.put("premiumList", premiumList);

			List<DropdownModel> unitExcess = orderClassService.getUnitExcess();
			responseObject.put("unitExcess", unitExcess);

			List<DropdownModel> unitType = orderClassService.getUnitTypeList();
			responseObject.put("unitType", unitType);

			List<DropdownModel> trilType = orderClassService.getTrialTypeList();
			responseObject.put("trilType", trilType);

			List<DropdownModel> timeUnits = orderClassService.getTimeUnits();
			responseObject.put("timeUnits", timeUnits);

			List<DropdownModel> renewalCard = orderClassService.getRenewalDropDownData(ocId);
			responseObject.put("renewalCard", renewalCard);
			List<DropdownModel> defaultTerm = orderClassService.getDefaultTerm();
			responseObject.put("defaultTerm", defaultTerm);

			List<DropdownModel> subscriptionCategory = orderClassService.getSubscriptionCategory();
			responseObject.put("subsCategory", subscriptionCategory);

			List<DropdownModel> pubRotation = orderClassService.getPubRotationList(ocId);
			responseObject.put("pubRotation", pubRotation);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in populateOrderCodeData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/translationDetails", method = RequestMethod.POST)
	public Map<String, Object> webDetails(Long ocId, Long orderCodeId, String description, String shortDescription,
			String longDescription) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			// when ocId is not null and orderCodeId,shortDescription and longDescription is
			// null
			if (orderCodeId != null && !"".equals(description)) {
				List<DropdownModel> descriptionDetails = orderClassService.getTranslationDetails(ocId, orderCodeId,
						description);
				responseObject.put("description", descriptionDetails);
			}
			// when ocId is not null and orderCodeId,shortDescription and longDescription is
			// null
			else if (ocId != null
					&& (orderCodeId == null && ("".equals(shortDescription) && "".equals(longDescription)))) {
				List<DropdownModel> webDetails = orderClassService.getWebDetails(ocId, orderCodeId, shortDescription,
						longDescription);
				responseObject.put("webDetails", webDetails);
			} else if (ocId != null
					&& (orderCodeId == null && (!"".equals(shortDescription) && "".equals(longDescription)))) {
				List<DropdownModel> webDetails = orderClassService.getWebDetails(ocId, orderCodeId, shortDescription,
						longDescription);
				responseObject.put("webDetails", webDetails);
			} else if (ocId != null
					&& (orderCodeId == null && ("".equals(shortDescription) && !"".equals(longDescription)))) {
				List<DropdownModel> webDetails = orderClassService.getWebDetails(ocId, orderCodeId, shortDescription,
						longDescription);
				responseObject.put("webDetails", webDetails);
			} else if (ocId != null && orderCodeId != null) {
				List<DropdownModel> webDetails = orderClassService.getWebDetails(ocId, orderCodeId, shortDescription,
						longDescription);
				responseObject.put("webDetails", webDetails);
			} else if (orderCodeId != null && !("".equals(shortDescription) | shortDescription == null)) {
				List<DropdownModel> sDescription = orderClassService.getWebDetails(ocId, orderCodeId, shortDescription,
						longDescription);
				responseObject.put("shortDescription", sDescription);
			} else if (orderCodeId != null && !("".equals(longDescription) | longDescription == null)) {
				List<DropdownModel> lDescription = orderClassService.getWebDetails(ocId, orderCodeId, shortDescription,
						longDescription);
				responseObject.put("longDescription", lDescription);
			}
			List<DropdownModel> languageList = orderClassService.getLanguageList();
			responseObject.put("languageList", languageList);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in webDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@PostMapping("/webDetails")
	public Map<String, Object> translationDetails(Long ocId, Long orderCodeId, String action, String shortDescription,
			String longDescription) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		String action2 = action.toLowerCase();
		try {
			if (ocId != null && orderCodeId != null) {
				List<DropdownModel> shortAndLongDetails = orderClassService.getTranslationDetails(ocId, orderCodeId,
						action);
				responseObject.put("shortLongDetails", shortAndLongDetails);
			}
			switch (action2) {
			case "description":
				List<DropdownModel> descriptionDetails = orderClassService.getTranslationDetails(ocId, orderCodeId,
						action);
				responseObject.put("description", descriptionDetails);
				break;
			case "item":
				List<DropdownModel> itemDetails = orderClassService.getTranslationDetails(ocId, orderCodeId, action);
				responseObject.put("item", itemDetails);
				break;
			case "image":
				List<DropdownModel> imageDetails = orderClassService.getTranslationDetails(ocId, orderCodeId, action);
				responseObject.put("image", imageDetails);
				break;
			case "media":
				List<DropdownModel> mediaDetails = orderClassService.getTranslationDetails(ocId, orderCodeId, action);
				responseObject.put("media", mediaDetails);
				break;
			case "edition":
				List<DropdownModel> editionDetails = orderClassService.getTranslationDetails(ocId, orderCodeId, action);
				responseObject.put("edition", editionDetails);
				break;
			case "short":
				List<DropdownModel> sDescription = orderClassService.getTranslationDetails(ocId, orderCodeId, action);
				responseObject.put("shortDescription", sDescription);
				break;
			case "long":
				List<DropdownModel> lDescription = orderClassService.getTranslationDetails(ocId, orderCodeId, action);
				responseObject.put("longDescription", lDescription);
				break;
			}
			List<DropdownModel> languageList = orderClassService.getLanguageList();
			responseObject.put("languageList", languageList);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in webDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveWebDetails", method = RequestMethod.POST)
	public Map<String, Object> saveWebDetails(AlternateContent alternateContent) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {

			status = orderClassService.saveWebDetails(alternateContent);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveWebDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateWebDetails", method = RequestMethod.POST)
	public Map<String, Object> updateWebDetails(AlternateContent alternateContent) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {

			status = orderClassService.updateWebDetails(alternateContent);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateWebDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/orderCodeDetails", method = RequestMethod.POST)
	public Map<String, Object> getOrderCodeDetails(Long ocId, Long orderCodeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> orderCodeDetails = new ArrayList<>();
		try {

			orderCodeDetails = orderClassService.getOrderCodeDetails(ocId, orderCodeId);
			responseObject.put("orderCodeDetails", orderCodeDetails);

			List<DropdownModel> installmentPlans = orderClassService.getInstallmentPlans();
			responseObject.put("installmentPlans", installmentPlans);
//			List<DropdownModel> auditDefaults = orderClassService.getAuditDefaults();
//			responseObject.put("auditDefaults", auditDefaults);
			List<DropdownModel> creditCardProcess = orderClassService.getCreditCardProcess();
			responseObject.put("creditCardProcess", creditCardProcess);
			List<DropdownModel> settleRetryDef = orderClassService.getSettleRetryDef();
			responseObject.put("settleRetryDef", settleRetryDef);

			List<DropdownModel> commodityList = orderClassService.getCommodityList();
			responseObject.put("commodityList", commodityList);

			List<DropdownModel> rateList = orderClassService.getRateList(ocId);
			responseObject.put("rateList", rateList);

			List<DropdownModel> discountList = orderClassService.getDiscountClassDetails(ocId);
			responseObject.put("discountList", discountList);

			List<DropdownModel> taxonomyList = orderClassService.getTaxonomyList();
			responseObject.put("taxonomyList", taxonomyList);

			List<DropdownModel> singleIssue = orderClassService.getIssue(ocId);
			responseObject.put("singleIssue", singleIssue);

			List<DropdownModel> trilType = orderClassService.getTrialTypeList();
			responseObject.put("trilType", trilType);

			List<DropdownModel> unitExcess = orderClassService.getUnitExcess();
			responseObject.put("unitExcess", unitExcess);

			List<DropdownModel> unitType = orderClassService.getUnitTypeList();
			responseObject.put("unitType", unitType);

			List<DropdownModel> renewalCard = orderClassService.getRenewalDropDownData(ocId);
			responseObject.put("renewalCard", renewalCard);

			List<DropdownModel> premiumList = orderClassService.getPremiumList();
			responseObject.put("premiumList", premiumList);

			List<DropdownModel> defaultTerm = orderClassService.getDefaultTerm();
			responseObject.put("defaultTerm", defaultTerm);

			List<DropdownModel> subscriptionCategory = orderClassService.getSubscriptionCategory();
			responseObject.put("subsCategory", subscriptionCategory);

			List<DropdownModel> pubRotation = orderClassService.getPubRotationList(ocId);
			responseObject.put("pubRotation", pubRotation);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getOrderCodeDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/orderCodeSave", method = RequestMethod.POST)
	public Map<String, Object> saveOrderCodeData(OrderCodeModel orderCodeModel) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.saveOrderCodeDetails(orderCodeModel);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveOrderCodeData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/orderCodeUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateOrderCodeData(OrderCodeModel orderCodeModel) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.updateOrderCodeDetails(orderCodeModel);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateOrderCodeData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/deleteOrderCode", method = RequestMethod.POST)
	public Map<String, Object> deleteOrderCodeDetails(int orderCodeId) {
		Map<String, Object> responseObject = new HashMap<>();
		String status = "";

		try {
			status = orderClassService.deleteOrderCodeDetails(orderCodeId);
			int lastIndexOfColon = status.lastIndexOf(':');
			int lastIndexOfFullstop = status.lastIndexOf('.');
			if (status.equals("1")) {
				responseObject.put(STATUS, true);
				responseObject.put("status", "OrderCodeId(" + orderCodeId + ") deleted successfully");
			} else {
				responseObject.put(STATUS, false);
				String returnStatus2 = status.substring(lastIndexOfColon, lastIndexOfFullstop);
				returnStatus2 = returnStatus2.replaceAll("\"", "").replaceAll(":", "").trim();
				responseObject.put("status", returnStatus2);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteOrderCodeDetails : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// this api is for default case.
	@RequestMapping(path = "/promoCardDetails", method = RequestMethod.POST)
	public Map<String, Object> getPromotionCardDetails(Long ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> promotionCardDetails = new ArrayList<>();
		List<Map<String, Object>> promoCardEffort = new ArrayList<>();
		List<Map<String, Object>> promoCardOffer = new ArrayList<>();
		try {
			promotionCardDetails = orderClassService.getPromotionCardDetails(ocId);
			Long promoCardId = null;
			for (Map<String, Object> list : promotionCardDetails) {
				promoCardId = Long.parseLong(list.get("promotion_card_id").toString());
				if (promoCardId != null) {
					break;
				}
			}
			promoCardEffort = orderClassService.getPromotionCardEffortDetails(promoCardId);
			Long promoCardEffortId = null;
			for (Map<String, Object> list : promoCardEffort) {
				promoCardEffortId = Long.parseLong(list.get("promotion_card_from_effort").toString());
				if (promoCardEffortId != null) {
					break;
				}
			}
			promoCardOffer = orderClassService.getPromotionCardOfferDetails(promoCardId, promoCardEffortId);
			responseObject.put("promoCard", promotionCardDetails);
			responseObject.put("promoCardEffort", promoCardEffort);
			responseObject.put("promoCardOffer", promoCardOffer);
		} catch (Exception e) {
			LOGGER.info("Error in getPromotionCardDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/savePromoCard", method = RequestMethod.POST)
	public Map<String, Object> savePromotionCardDetails(PromotionCard promotionCard) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.savePromotionCardDetails(promotionCard);
			int promotionCardId = orderClassService.getPromotionCardId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("promotionCardId", promotionCardId);

			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in savePromotionCardDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updatePromoCard", method = RequestMethod.POST)
	public Map<String, Object> updatePromotionCardDetails(PromotionCard promotionCard) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.updatePromotionCardDetails(promotionCard);
			int promotionCardId = promotionCard.getPromotionCardId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("promotionCardId", promotionCardId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updatePromotionCardDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/promoCardEffortDetails", method = RequestMethod.POST)
	public Map<String, Object> getPromotionCardEffortDetails(Long promotionCardId) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> promotionCardDetails = new ArrayList<>();
		List<Map<String, Object>> promoCardOffer = new ArrayList<>();
		try {
			promotionCardDetails = orderClassService.getPromotionCardEffortDetails(promotionCardId);
			responseObject.put("promoEffortCard", promotionCardDetails);
			Long promoCardEffortId = null;
			for (Map<String, Object> list : promotionCardDetails) {
				promoCardEffortId = Long.parseLong(list.get("promotion_card_from_effort").toString());
				if (promoCardEffortId != null) {
					break;
				}
			}
			promoCardOffer = orderClassService.getPromotionCardOfferDetails(promotionCardId, promoCardEffortId);
			responseObject.put("promoCardOffer", promoCardOffer);
		} catch (Exception e) {
			LOGGER.info("Error in getPromotionCardDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/savePromoCardEffort", method = RequestMethod.POST)
	public Map<String, Object> savePromotionCardEffortDetails(PromotionCardEffort promotionCardEffort) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.savePromotionCardEffortDetails(promotionCardEffort);
			int promotionCardId = promotionCardEffort.getPromotionCardId();
			int promotionCardEffortId = orderClassService.getPromotionCardFromEffortId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("promotionCardId", promotionCardId);
				responseObject.put("promotionCardEffortId", promotionCardEffortId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in savePromotionCardEffortDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updatePromoCardEffort", method = RequestMethod.POST)
	public Map<String, Object> updatePromotionCardEffortDetails(PromotionCardEffort promotionCardEffort) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.updatePromotionCardEffortDetails(promotionCardEffort);
			int promotionCardId = promotionCardEffort.getPromotionCardId();
			int promotionCardEffortId = promotionCardEffort.getPromotionCardEffortId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("promotionCardId", promotionCardId);
				responseObject.put("promotionCardEffortId", promotionCardEffortId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in savePromotionCardEffortDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/promoCardOfferDetails", method = RequestMethod.POST)
	public Map<String, Object> getPromotionCardOfferDetails(Long promotionCardId, Long promotionCardEffortId) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> promotionCardDetails = new ArrayList<>();
		try {
			promotionCardDetails = orderClassService.getPromotionCardOfferDetails(promotionCardId,
					promotionCardEffortId);
			responseObject.put("promoCardOffer", promotionCardDetails);
		} catch (Exception e) {
			LOGGER.info("Error in getPromotionCardOfferDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/savePromoCardOffer", method = RequestMethod.POST)
	public Map<String, Object> savePromotionCardOfferDetails(PromotionCardOffer promotionCardOffer) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.savePromotionCardOfferDetails(promotionCardOffer);
			int promotionCardId = promotionCardOffer.getPromotionCardId();
			int promotionCardEffortId = promotionCardOffer.getPromotionCardEffortId();
			int promotionCardOfferSeq = orderClassService.getPromotionCardOfferSeq();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("promotionCardId", promotionCardId);
				responseObject.put("promotionCardEffortId", promotionCardEffortId);
				responseObject.put("promotionCardOfferSeq", promotionCardOfferSeq);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in savePromotionCardOfferDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updatePromoCardOffer", method = RequestMethod.POST)
	public Map<String, Object> updatePromotionCardOfferDetails(PromotionCardOffer promotionCardOffer) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.updatePromotionCardOfferDetails(promotionCardOffer);
			int promotionCardId = promotionCardOffer.getPromotionCardId();
			int promotionCardEffortId = promotionCardOffer.getPromotionCardEffortId();
			int promotionCardOfferSeq = promotionCardOffer.getPromotionCardOfferSeq();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("promotionCardId", promotionCardId);
				responseObject.put("promotionCardEffortId", promotionCardEffortId);
				responseObject.put("promotionCardOfferSeq", promotionCardOfferSeq);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updatePromotionCardOfferDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/searchRateClass", method = RequestMethod.POST)
	public Map<String, Object> searchRateClass(Long ocId, String rateClass, String rateDescription, Long rateClassId) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> searchByOcId = new ArrayList<>();
		List<DropdownModel> searchByClass = new ArrayList<>();
		List<DropdownModel> searchByDescription = new ArrayList<>();
		List<DropdownModel> searchByRateId = new ArrayList<>();
		try {
			Long oc_Id = ocId != null ? ocId : 0;
			String rate_Class = ("null".equals(rateClass)) | ("".equals(rateClass)) ? null : rateClass;
			String description = ("null".equals(rateDescription)) | ("".equals(rateDescription)) ? null
					: rateDescription;
			Long rateId = rateClassId != null ? rateClassId : 0;
			// search by oc id
			if ((oc_Id != 0 && rateId == 0) && (rate_Class == null && description == null)) {
				searchByOcId = orderClassService.searchRateClass(ocId);
			}
			// search by oc id and rate class
			if (rate_Class != null && description == null) {
				searchByClass = orderClassService.searchRateClass(oc_Id, rate_Class);
			}
			// search by oc id,rate class and rate description
			if (description != null && rate_Class != null) {
				searchByDescription = orderClassService.searchRateClass(oc_Id, rate_Class, description);
			}
			// search by oc id and rate class id
			if (rateId != 0 && oc_Id != 0) {
				searchByRateId = orderClassService.searchRateClass(oc_Id, rateId);
			}
			status++;
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("searchByOcId", searchByOcId);
				responseObject.put("searchByRateClass", searchByClass);
				responseObject.put("searchByDescription", searchByDescription);
				responseObject.put("searchByRateId", searchByRateId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in searchRateClass() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/searchDiscountClass", method = RequestMethod.POST)
	public Map<String, Object> searchDiscountClass(Long ocId, String discountClass, String discountDescription,
			Long discountClassId) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> searchByOcId = new ArrayList<>();
		List<DropdownModel> searchByClass = new ArrayList<>();
		List<DropdownModel> searchByDescription = new ArrayList<>();
		List<DropdownModel> searchByRateId = new ArrayList<>();
		try {
			Long oc_Id = ocId != null ? ocId : 0;
			String discount_Class = ("null".equals(discountClass)) | ("".equals(discountClass)) ? null : discountClass;
			String description = ("null".equals(discountDescription)) | ("".equals(discountDescription)) ? null
					: discountDescription;
			Long discountId = discountClassId != null ? discountClassId : 0;
			// search by oc id
			if ((oc_Id != 0 && discountId == 0) && (discount_Class == null && description == null)) {
				searchByOcId = orderClassService.searchDiscountClass(ocId);
			}
			// search by oc id and discount class
			if (discount_Class != null && description == null) {
				searchByClass = orderClassService.searchDiscountClass(oc_Id, discount_Class);
			}
			// search by oc id,discount class and discount description
			if (description != null && discount_Class != null) {
				searchByDescription = orderClassService.searchDiscountClass(oc_Id, discount_Class, description);
			}
			// search by oc id and discount class id
			if (discountId != 0 && oc_Id != 0) {
				searchByRateId = orderClassService.searchDiscountClass(oc_Id, discountId);
			}
			status++;
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("searchByOcId", searchByOcId);
				responseObject.put("searchByDiscountClass", searchByClass);
				responseObject.put("searchByDescription", searchByDescription);
				responseObject.put("searchByDiscountId", searchByRateId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in searchDiscountClass() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

//	//this api is for default case.
//	@RequestMapping(path = "/renCardDetails", method = RequestMethod.POST)
//	public Map<String, Object> getRenewalCardDetails(Long ocId) {
//		Map<String, Object> responseObject = new LinkedHashMap<>();
//		List<Map<String, Object>> renewalCardDetails = new ArrayList<>();
//		List<Map<String, Object>> renewalCardEffort = new ArrayList<>();
//		List<Map<String, Object>> renewalCardOffer = new ArrayList<>();
//		try {
//			renewalCardDetails = orderClassService.getRenewalCardDetails(ocId);
//			Long renewalCardId = null; 
//			for(Map<String,Object>list:renewalCardDetails) {
//				renewalCardId = Long.parseLong(list.get("renewal_card_id").toString());
//				if(renewalCardId!=null) {
//					break;
//				}
//			}
//			renewalCardEffort = orderClassService.getRenewalCardEffortDetails(renewalCardId);
//			Long renewalCardEffortId = null;
//			for(Map<String,Object>list:renewalCardEffort) {
//				renewalCardEffortId = Long.parseLong(list.get("renewal_card_from_effort").toString());
//				if(renewalCardEffortId!=null) {
//					break;
//				}
//			}
//			renewalCardOffer = orderClassService.getRenewalCardOfferDetails(renewalCardId, renewalCardEffortId);
//			responseObject.put("renewalCard", renewalCardDetails);
//			responseObject.put("renewalCardEffort", renewalCardEffort);
//			responseObject.put("renewalCardOffer", renewalCardOffer);
//		} catch (Exception e) {
//			LOGGER.info("Error in getRenewalCardDetails(): " + e);
//			responseObject.put(STATUS, ERROR + e);
//			return responseObject;
//		}
//		return responseObject;
//	}
//	
	@RequestMapping(path = "/saveRenewalCard", method = RequestMethod.POST)
	public Map<String, Object> saveRenewalCardDetails(RenewalCard renewalCard) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.saveRenewalCardDetails(renewalCard);
			int renewalCardId = orderClassService.getRenewalCardId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("renewalCardId", renewalCardId);

			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveRenewalCardDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updateRenewalCard", method = RequestMethod.POST)
	public Map<String, Object> updateRenewalCardDetails(RenewalCard renewalCard) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.updateRenewalCardDetails(renewalCard);
			int renewalCardId = renewalCard.getRenewalCardId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("renewalCardId", renewalCardId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updatePromotionCardDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/renCardEffortDetails", method = RequestMethod.POST)
	public Map<String, Object> getRenewalCardEffortDetails(Long renewalCardId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> renewalCardEffort = new ArrayList<>();
		List<Map<String, Object>> renewalCardOffer = new ArrayList<>();
		try {
			renewalCardEffort = orderClassService.getRenewalCardEffortDetails(renewalCardId);
			Long renewalCardEffortId = null;
			for (Map<String, Object> list : renewalCardEffort) {
				renewalCardEffortId = Long.parseLong(list.get("renewal_card_from_effort").toString());
				if (renewalCardEffortId != null) {
					break;
				}
			}
			renewalCardOffer = orderClassService.getRenewalCardOfferDetails(renewalCardId, renewalCardEffortId);
			responseObject.put("renewalCardEffort", renewalCardEffort);
			responseObject.put("renewalCardOffer", renewalCardOffer);
		} catch (Exception e) {
			LOGGER.info("Error in getRenewalCardDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/saveRenewalCardEffort", method = RequestMethod.POST)
	public Map<String, Object> saveRenewalCardEffortDetails(RenewalCard renewalCard) {
		String saveRenewalCardEffort = "";
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			saveRenewalCardEffort = orderClassService.saveRenewalCardEffortDetails(renewalCard);
			Integer renewalCardId = renewalCard.getRenewalCardId();
			int renewalCardEffortId = renewalCard.getRenewalCardEffortId();
			if (saveRenewalCardEffort != null) {
				responseObject.put(STATUS, true);
				responseObject.put("saveRenewalCardEffort", saveRenewalCardEffort);
				responseObject.put("renewalCardId", renewalCardId);
				responseObject.put("renewalCardEffortId", renewalCardEffortId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveRenewalCardDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateRenewalCardEffort", method = RequestMethod.POST)
	public Map<String, Object> updateRenewalCardEffortDetails(RenewalCard renewalCard) {
		String renewalCardEffortUpdated = "";
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			renewalCardEffortUpdated = orderClassService.updateRenewalCardEffortDetails(renewalCard);
			Integer renewalCardId = renewalCard.getRenewalCardId();
			int renewalCardEffortId = renewalCard.getRenewalCardEffortId();
			if (renewalCardEffortUpdated != null) {
				responseObject.put(STATUS, true);
				responseObject.put("updateRenewalCardEffort", renewalCardEffortUpdated);
				responseObject.put("renewalCardId", renewalCardId);
				responseObject.put("renewalCardEffortId", renewalCardEffortId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveRenewalCardDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/renCardOfferDetails", method = RequestMethod.POST)
	public Map<String, Object> getRenewalCardOfferDetails(Long renewalCardId, Long renewalCardEffortId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> renewalCardOffer = new ArrayList<>();
		try {
			renewalCardOffer = orderClassService.getRenewalCardOfferDetails(renewalCardId, renewalCardEffortId);
			responseObject.put("renewalCardOffer", renewalCardOffer);
		} catch (Exception e) {
			LOGGER.info("Error in getRenewalCardOfferDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/saveRenewalCardOffer", method = RequestMethod.POST)
	public Map<String, Object> saveRenewalCardOfferDetails(RenewalCard renewalCard) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {
			status = orderClassService.saveRenewalCardOfferDetails(renewalCard);
			int renewalCardId = renewalCard.getRenewalCardId();
			int renewalCardEffortId = renewalCard.getRenewalCardEffortId();
			int renCardOrderCodeSeq = orderClassService.getRenewalCardOfferSeq(renewalCardId, renewalCardEffortId);
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("renewalCardId", renewalCardId);
				responseObject.put("renewalCardEffortId", renewalCardEffortId);
				responseObject.put("renCardOrderCodeSeq", renCardOrderCodeSeq);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveRenewalCardOfferDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateRenewalCardOffer", method = RequestMethod.POST)
	public Map<String, Object> updateRenewalCardOfferDetails(RenewalCard renewalCard) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.updateRenewalCardOfferDetails(renewalCard);
			int renewalCardId = renewalCard.getRenewalCardId();
			int renewalCardEffortId = renewalCard.getRenewalCardEffortId();
			int renCardOrderCodeSeq = renewalCard.getRenCardOrderCodeSeq();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("renewalCardId", renewalCardId);
				responseObject.put("renewalCardEffortId", renewalCardEffortId);
				responseObject.put("renCardOrderCodeSeq", renCardOrderCodeSeq);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateRenewalCardOfferDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	// This api is for grid data
	@RequestMapping(path = "/genericPromoDetails", method = RequestMethod.POST)
	public Map<String, Object> getGenericPromotionDetails(Integer ocId, Integer sourceCodeId) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> genericPromotions = new ArrayList<>();
		try {
			genericPromotions = orderClassService.getGenericPromotionDefinition(ocId, sourceCodeId);
			responseObject.put("genericPromoDetails", genericPromotions);
		} catch (Exception e) {
			LOGGER.info("Error in getGenericPromotionDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;

	}

	@RequestMapping(path = "/populateGenericPromo", method = RequestMethod.POST)
	public Map<String, Object> populateGenericPromo(Long ocId) {
		Map<String, Object> responseObject = new HashMap<>();
		try {
			List<DropdownModel> orderCode = orderClassService.getOrderCodeDetails(ocId);
			responseObject.put("orderCode", orderCode);
			List<DropdownModel> issue = orderClassService.getIssue(ocId);
			responseObject.put("issue", issue);
			List<DropdownModel> subDef = new ArrayList<>();
			List<Map<String, Object>> rateClass = orderClassService.getRateClassDetails(ocId);
			responseObject.put("rateClass", rateClass);
			List<DropdownModel> pkgDef = new ArrayList<>();
			List<Map<String, Object>> discountClass = orderClassService.getRateClassDetails(ocId);
			responseObject.put("discountClass", discountClass);
			List<DropdownModel> product = new ArrayList<>();
			List<DropdownModel> currency = orderClassService.lookupCurrency();
			responseObject.put("currency", currency);
			List<DropdownModel> format = orderClassService.getSourceCodeAttributeValue();
			responseObject.put("format", format);
			List<DropdownModel> shoppingPrice = orderClassService.getShippingPriceList();
			responseObject.put("shoppingPrice", shoppingPrice);
			List<DropdownModel> agency = orderClassService.getAgencyDetails();
			responseObject.put("agency", agency);
		} catch (Exception e) {
			LOGGER.info("Error in populateGenericPromo(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;

	}

	@RequestMapping(path = "/showGenericPromo", method = RequestMethod.POST)
	public Map<String, Object> showGenericPromo(Integer ocId, Integer sourceCodeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {

			List<Map<String, Object>> genericPromotionDetails = orderClassService.getGenericPromotionDefinition(ocId,
					sourceCodeId);
			responseObject.put("genericPromoDetails", genericPromotionDetails);
			List<Map<String, Object>> genericPromoCodeDetails = orderClassService.getGenericPromotionCode(sourceCodeId);
			responseObject.put("genericPromoCodeDetails", genericPromoCodeDetails);
		} catch (Exception e) {
			LOGGER.info("Error in showGenericPromo(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;

	}

	@RequestMapping(path = "/editGenericPromo", method = RequestMethod.POST)
	public Map<String, Object> editGenericPromo(Integer sourceCodeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> genericPromotions = new ArrayList<>();
		try {
			genericPromotions = orderClassService.getSourceCodeDetails(sourceCodeId);
			responseObject.put("promoSourceCodeDetails", genericPromotions);
			List<DropdownModel> format = orderClassService.getSourceCodeAttributeValue();
			responseObject.put("format", format);
			List<DropdownModel> shippingPrice = orderClassService.getShippingPriceList();
			responseObject.put("shippingPrice", shippingPrice);
			List<DropdownModel> agency = orderClassService.getAgencyDetails();
			responseObject.put("agency", agency);
			List<DropdownModel> sourceCodeState = orderClassService.getSourceCodeStateDetails(sourceCodeId);
			responseObject.put("sourceCodeState", sourceCodeState);
		} catch (Exception e) {
			LOGGER.info("Error in editGenericPromo(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;

	}

	@RequestMapping(path = "/deleteGenericPromo", method = RequestMethod.POST)
	public Map<String, Object> deleteGenericPromo(Integer sourceCodeId) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = orderClassService.deleteSourceCodeDetails(sourceCodeId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteGenericPromo(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveGenericPromo", method = RequestMethod.POST)
	public Map<String, Object> saveGenericPromo(ParentOrderClassModel genericPromotion) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {
			status = orderClassService.saveGenericPromoCodeDetails(genericPromotion);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveGenericPromo() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	// For Grid data "/demographicsTableData"

	// this api is for default case of Demographic Form.
	@RequestMapping(path = "/demoFormsDetails", method = RequestMethod.POST)
	public Map<String, Object> getRenewalCardDetails(Integer demFormId, Integer demQuestionId,
			Integer demFormQuestionSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> demoFormsDetails = new ArrayList<>();
		List<Map<String, Object>> demoFormsQuestionDetails = new ArrayList<>();
		List<Map<String, Object>> demFormResponseDetails = new ArrayList<>();
		List<DropdownModel> questionsList = new ArrayList<>();
		List<DropdownModel> questionsOverrideList = new ArrayList<>();
		List<DropdownModel> languageList = new ArrayList<>();
		List<DropdownModel> responsesList = new ArrayList<>();
		List<DropdownModel> responsesOverrideList = new ArrayList<>();
		try {
			Integer demoFormId = null;
			Integer demoFormQuestionSeq = null;
			Integer demoQuestionId = null;
			Integer demoFormResponseSeq = null;
			// case 1: when we will pass demFormId then we'll get data's from 3 tables.
			if (demFormId != null && (demFormQuestionSeq == null && demQuestionId == null)) {
				demoFormsDetails = orderClassService.getDemFormDetails(demFormId);

				for (Map<String, Object> list : demoFormsDetails) {
					demoFormId = Integer.parseInt(list.get("dem_form_id").toString());
					if (demoFormId != null) {
						break;
					}
				}
				demoFormsQuestionDetails = orderClassService.getDemFormQuestionDetails(demoFormId);

				for (Map<String, Object> list : demoFormsQuestionDetails) {
					demoFormQuestionSeq = Integer.parseInt(list.get("dem_form_question_seq").toString());
					demoQuestionId = Integer.parseInt(list.get("dem_question_id").toString());
					if (demoFormQuestionSeq != null) {
						break;
					}
				}
				demFormResponseDetails = orderClassService.getDemFormResponseDetails(demoFormId, demoFormQuestionSeq);

				for (Map<String, Object> list : demFormResponseDetails) {
					demoFormResponseSeq = Integer.parseInt(list.get("dem_form_response_seq").toString());
					if (demoFormResponseSeq != null) {
						break;
					}
				}
				responseObject.put("demoFormsDetails", demoFormsDetails);

				responseObject.put("questionsDetails", demoFormsQuestionDetails);
				questionsList = orderClassService.getQuestionsList();
				responseObject.put("questionsList", questionsList);
				questionsOverrideList = orderClassService.getQuestionOverrideList(demFormId, demoFormQuestionSeq);
				responseObject.put("questionsOverrideList", questionsOverrideList);
				languageList = orderClassService.getLanguageList();
				responseObject.put("languageList", languageList);

				responseObject.put("responsesDetails", demFormResponseDetails);
				responsesList = orderClassService.getResponsesList(demoQuestionId);
				responseObject.put("responsesList", responsesList);
				responsesOverrideList = orderClassService.getResponsesOverrideList(demFormId, demFormQuestionSeq,
						demoFormResponseSeq);
				responseObject.put("responsesOverrideList", responsesOverrideList);
			} else { // Case 2: when we will pass demFormId & demFormQuestionSeq then we'll get data
						// from response table only.
				demFormResponseDetails = orderClassService.getDemFormResponseDetails(demFormId, demFormQuestionSeq);
				responseObject.put("responsesDetails", demFormResponseDetails);
				for (Map<String, Object> list : demFormResponseDetails) {
					demoQuestionId = Integer.parseInt(list.get("dem_question_id").toString());
					demoFormResponseSeq = Integer.parseInt(list.get("dem_form_response_seq").toString());
					if (demoQuestionId != null) {
						break;
					}
				}
				responsesList = orderClassService.getResponsesList(demoQuestionId);
				responseObject.put("responsesList", responsesList);
				responsesOverrideList = orderClassService.getResponsesOverrideList(demFormId, demFormQuestionSeq,
						demoFormResponseSeq);
				responseObject.put("responsesOverrideList", responsesOverrideList);
				languageList = orderClassService.getLanguageList();
				responseObject.put("languageList", languageList);
			}

		} catch (Exception e) {
			LOGGER.info("Error in getRenewalCardDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/saveDemographics", method = RequestMethod.POST)
	public Map<String, Object> saveDemographicsFormDetails(DemographicForms demForm) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {

			if (demForm.getDemFormId() == null) {
				status = orderClassService.saveDemForm(demForm);
				Integer demFormId = orderClassService.getDemFormId();
				if (status != 0) {
					responseObject.put(STATUS, true);
					responseObject.put("demFormId", demFormId);
					status = 0;
				} else {
					responseObject.put(STATUS, false);
				}
			} else if ((demForm.getDemFormId() != null) && (demForm.getDemFormQuestionSeq() == null)) {
				status = orderClassService.saveDemForm(demForm);
				Integer demFormQuestionSeq = orderClassService.getDemFormQuestionSeq(demForm.getDemFormId());
				if (status != 0) {
					responseObject.put(STATUS, true);
					responseObject.put("demFormId", demForm.getDemFormId());
					responseObject.put("demFormQuestionSeq", demFormQuestionSeq);
					status = 0;
				} else {
					responseObject.put(STATUS, false);
				}
			} else {
				status = orderClassService.saveDemForm(demForm);
				Integer demFormResponseSeq = orderClassService.getDemFormResponseSeq(demForm.getDemFormId(),
						demForm.getDemFormQuestionSeq());
				if (status != 0) {
					responseObject.put(STATUS, true);
					responseObject.put("demFormId", demForm.getDemFormId());
					responseObject.put("demFormQuestionSeq", demForm.getDemFormQuestionSeq());
					responseObject.put("demFormResponseSeq", demFormResponseSeq);
				} else {
					responseObject.put(STATUS, false);
				}
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveDemographicsFormDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateDemographics", method = RequestMethod.POST)
	public Map<String, Object> updateDemographicsFormDetails(DemographicForms demForm) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {
			if (demForm.getDemFormId() != null
					&& (demForm.getDemFormQuestionSeq() == null && demForm.getDemFormResponseSeq() == null)) {
				status = orderClassService.updateDemForm(demForm);
				Integer demFormId = demForm.getDemFormId();
				if (status != 0) {
					responseObject.put(STATUS, true);
					responseObject.put("demFormId", demFormId);
				} else {
					responseObject.put(STATUS, false);
				}
			} else if (demForm.getDemFormId() != null
					&& (demForm.getDemFormQuestionSeq() != null && demForm.getDemFormResponseSeq() == null)) {
				status = orderClassService.updateDemForm(demForm);
				Integer demFormQuestionSeq = demForm.getDemFormQuestionSeq();
				if (status != 0) {
					responseObject.put(STATUS, true);
					responseObject.put("demFormId", demForm.getDemFormId());
					responseObject.put("demFormQuestionSeq", demFormQuestionSeq);
					status = 0;
				} else {
					responseObject.put(STATUS, false);
				}
			} else {
				status = orderClassService.updateDemForm(demForm);
				Integer demFormResponseSeq = demForm.getDemFormResponseSeq();
				if (status != 0) {
					responseObject.put(STATUS, true);
					responseObject.put("demFormId", demForm.getDemFormId());
					responseObject.put("demFormQuestionSeq", demForm.getDemFormQuestionSeq());
					responseObject.put("demFormResponseSeq", demFormResponseSeq);
					status = 0;
				} else {
					responseObject.put(STATUS, false);
				}
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateDemographicsFormDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/searchDemographics", method = RequestMethod.POST)
	public Map<String, Object> copyDemographics(Integer demFormId, String demForm, Integer ocId, String active) {
		Map<String, Object> responseObject = new HashMap<>();
		List<DropdownModel> filteredData = new ArrayList<>();
		int status = 0;
		try {
			filteredData = orderClassService.copyDemographics(demFormId, demForm, ocId, active);
			status++;
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("searchedData", filteredData);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in copyDemographics : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/deleteDemographics", method = RequestMethod.POST)
	public Map<String, Object> deleteDemographics(int demFormId) {
		Map<String, Object> responseObject = new HashMap<>();
		String status = "";

		try {
			status = orderClassService.deleteDemographics(demFormId);
			int lastIndexOfColon = status.lastIndexOf(':');
			int lastIndexOfFullstop = status.lastIndexOf('.');
			if (status.equals("1")) {
				responseObject.put(STATUS, true);
				responseObject.put("status", "demFormId(" + demFormId + ") deleted successfully");
			} else {
				responseObject.put(STATUS, false);
				String returnStatus2 = status.substring(lastIndexOfColon, lastIndexOfFullstop);
				returnStatus2 = returnStatus2.replaceAll("\"", "").replaceAll(":", "").trim();
				responseObject.put("status", returnStatus2);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in deleteDemographics : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@PostMapping("/productDetails")
	public Map<String, Object> productDetails(Integer ocId) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> productDetails = new ArrayList<>();
		int status = 0;
		try {
			productDetails = orderClassService.getProductDetails(ocId);
			status++;
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("productDetails", productDetails);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in productDetails():" + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	// @PostMapping("/orderCodeDependecies")
	public Map<String, Object> orderCodeDependecies(int orderCodeId) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		List<DropdownModel> orderCodeDependecies = new ArrayList<>();
		try {
			orderCodeDependecies = orderClassService.getOrderCodeDependecies(orderCodeId);
			status++;
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("orderCodeDependecies", orderCodeDependecies);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in orderCodeDependecies() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@PostMapping("/orderCodeDependecies")
	public Map<String, Object> saveVGTargetSalesDetails(OrderCodeModel model, String action, int orderCodeId) {
		String saveDependencies = "";
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> orderCodeDependecies = new ArrayList<>();
		int status = 0;
		String action2 = action.toLowerCase();
		try {
			if (action2.equals("save")) {
				saveDependencies = orderClassService.saveDependencies(model);
				if (saveDependencies != null && !saveDependencies.contains("duplicate")) {
					responseObject.put(STATUS, true);
					responseObject.put("savedDependencies", saveDependencies);
				} else {
					responseObject.put(STATUS, false);
					responseObject.put("duplicateRecord", saveDependencies);
				}
			} else if (action2.equals("update")) {
				saveDependencies = orderClassService.updateDependencies(model);
				if (saveDependencies != null && !saveDependencies.contains("duplicate")) {
					responseObject.put(STATUS, true);
					responseObject.put("updatedDependencies", saveDependencies);
				} else {
					responseObject.put(STATUS, false);
					responseObject.put("duplicateRecord", saveDependencies);
				}
			} else {
				orderCodeDependecies = orderClassService.getOrderCodeDependecies(orderCodeId);
				status++;
				if (status != 0) {
					responseObject.put(STATUS, true);
					responseObject.put("orderCodeDependecies", orderCodeDependecies);
				} else {
					responseObject.put(STATUS, false);
				}
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveOrderCodeDependecies() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	/* ================================================================ */
	/* ================================================================ */
	@RequestMapping(path = "/savePubRotation", method = RequestMethod.POST)
	public Map<String, Object> savePubRotationDetails(PubRotation pubRotation) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.savePubRotationDetails(pubRotation);
			int pubRotationId = orderClassService.getPubRotationId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("pubRotationId", pubRotationId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in savePubRotationDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updatePubRotation", method = RequestMethod.POST)
	public Map<String, Object> updatePubRotationDetails(PubRotation pubRotation) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.updatePubRotationDetails(pubRotation);
			int pubRotationId = pubRotation.getPubRotationId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("pubRotationId", pubRotationId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updatePubRotationDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}
	/*
	 * @RequestMapping(path = "/pubRotationDetails", method = RequestMethod.POST)
	 * public Map<String, Object> getPubRotationDetails(Integer pubRotationId,
	 * Integer ocId) { Map<String, Object> responseObject = new HashMap<>();
	 * List<PubRotation> pubRotationDetails = new ArrayList<>(); try {
	 * pubRotationDetails = orderClassService.getPubRotationDetails(pubRotationId,
	 * ocId); responseObject.put("pubRotation", pubRotationDetails);
	 * List<DropdownModel> onCalendarUnit = orderClassService.getOnCalendarUnit();
	 * responseObject.put("onCalendarUnit", onCalendarUnit); } catch (Exception e) {
	 * LOGGER.info("Error in getPubRotationDetails(): " + e);
	 * responseObject.put(STATUS, ERROR + e); return responseObject; } return
	 * responseObject; }
	 */

	@RequestMapping(path = "/savePub", method = RequestMethod.POST)
	public Map<String, Object> savePubDetails(Pub pub) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.savePubDetails(pub);
			int ocId = orderClassService.getOcId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("ocId", ocId);

			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in savePubDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updatePub", method = RequestMethod.POST)
	public Map<String, Object> updatePubDetails(Pub pub) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.updatePubDetails(pub);
			int ocId = pub.getOcId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("ocId", ocId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updatePubDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/issueFrequency", method = RequestMethod.POST)
	public Map<String, Object> getSelectPubDetails(Integer ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Pub> selectPubDetails = new ArrayList<>();
		List<PubRotation> pubRotationDetails = new ArrayList<>();
		try {

			selectPubDetails = orderClassService.getSelectPubDetails(ocId);
			responseObject.put("PubDetails", selectPubDetails);

			List<DropdownModel> calenderUnit = orderClassService.getCalenderUnit();
			responseObject.put("calenderUnit", calenderUnit);

			List<DropdownModel> onCalendarUnit = orderClassService.getOnCalendarUnit();
			responseObject.put("onCalendarUnit", onCalendarUnit);

			List<DropdownModel> volumeFormat = orderClassService.getVolumeFormat();
			responseObject.put("volumeFormat", volumeFormat);

			List<DropdownModel> issueFormat = orderClassService.getIssueFormat();
			responseObject.put("issueFormat", issueFormat);

			pubRotationDetails = orderClassService.getPubRotationDetails(ocId);
			responseObject.put("pubRotationDetails", pubRotationDetails);

		} catch (Exception e) {
			LOGGER.info("Error in getSelectPubDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	/*-----------------------------------------------------------------------*/

	@RequestMapping(path = "/selectIssue", method = RequestMethod.POST)
	public Map<String, Object> getIssueDetails(Integer ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> issueDetails = new ArrayList<>();

		try {

			issueDetails = orderClassService.getIssueDetails(ocId);
			responseObject.put("issueDetails", issueDetails);

			List<DropdownModel> volumeGroup = orderClassService.getVolumeGroup();
			responseObject.put("volumeGroup", volumeGroup);

			List<DropdownModel> inventory = orderClassService.getInventory();
			responseObject.put("inventory", inventory);

			List<DropdownModel> location = orderClassService.getLocation();
			responseObject.put("location", location);

			List<DropdownModel> queue = orderClassService.getQueue();
			responseObject.put("queue", queue);

			List<DropdownModel> languageList = orderClassService.getLanguageList();
			responseObject.put("languageList", languageList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getIssueDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteIssue", method = RequestMethod.POST)
	public Map<String, Object> deleteIssue(Integer issueId, Integer ocId) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = orderClassService.deleteIssue(issueId, ocId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in deleteIssue() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveIssue", method = RequestMethod.POST)
	public Map<String, Object> saveIssue(Issue issue) {

		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.saveIssue(issue);
			int issueId = orderClassService.getIssueId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("issueId", issueId);

			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveIssueDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateIssue", method = RequestMethod.POST)
	public Map<String, Object> updateIssue(Issue issue) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.updateIssue(issue);
			int issueId = orderClassService.getIssueId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("issueId", issueId);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateIssueDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateJobModel", method = RequestMethod.POST)
	public Map<String, Object> updateJobModel(JobModel jobModel) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.updateJobModel(jobModel);
			int jobId = orderClassService.getJobId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("jobId", jobId);

			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateJobModelDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

//	@RequestMapping(path = "/reOpenIssue", method = RequestMethod.POST)
//	public Map<String, Object> getReOpenIssueDetails(Integer ocId) {
//		Map<String, Object> responseObject = new LinkedHashMap<>();
//		List<Map<String, Object>> reOpenIssueDetails = new ArrayList<>();
//
//		try {
//
//			reOpenIssueDetails = orderClassService.getReOpenIssueDetails(ocId);
//			responseObject.put("reOpenIssueDetails", reOpenIssueDetails);
//
//			responseObject.put(STATUS, SUCCESS);
//			return responseObject;
//		} catch (Exception e) {
//			LOGGER.info("Error in getReOpenIssueDetails() : " + e);
//			responseObject.put(STATUS, ERROR + e);
//			return responseObject;
//		}
//	}
	
	@RequestMapping(path = "/reOpenIssue", method = RequestMethod.POST)
	public Map<String, Object> reOpenIssue(int ocId, int issueId) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.reOpenIssue(ocId, issueId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in reOpenIssue() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/markCurrentIssue", method = RequestMethod.POST)
	public Map<String, Object> markCurrentIssue(int ocId, int issueId) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.markCurrentIssue(ocId, issueId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in markCurrentIssue() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectSubscriptionDef", method = RequestMethod.POST)
	public Map<String, Object> getSubscriptionDef(Long ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<SubscriptionDef> subscriptionDefDetails = new ArrayList<>();
		try {

			subscriptionDefDetails = orderClassService.getSubscriptionDef(ocId);
			responseObject.put("subscriptionDefDetails", subscriptionDefDetails);
			System.out.println(subscriptionDefDetails);

			List<DropdownModel> defaultTerm = orderClassService.getDefaultTerm();
			responseObject.put("defaultTerm", defaultTerm);

			List<DropdownModel> orderCode = orderClassService.getOrderCodeDetails(ocId);
			responseObject.put("orderCode", orderCode);

			List<DropdownModel> rateList = orderClassService.getRateList(ocId);
			responseObject.put("rateList", rateList);

			List<DropdownModel> renewalCard = orderClassService.getRenewalDropDownData(ocId);
			responseObject.put("renewalCard", renewalCard);

			List<DropdownModel> subscriptionCategory = orderClassService.getSubscriptionCategory();
			responseObject.put("subscriptionCategory", subscriptionCategory);

			List<DropdownModel> pubRotation = orderClassService.getPubRotationList(ocId);
			responseObject.put("pubRotation", pubRotation);

			List<DropdownModel> logicalStart = orderClassService.getLogicalStart();
			responseObject.put("logicalStart", logicalStart);

			List<DropdownModel> forcedExpireMonth = orderClassService.getForcedExpireMonth();
			responseObject.put("forcedExpireMonth", forcedExpireMonth);

			List<DropdownModel> cancelPolicy = orderClassService.getCancelPolicy();
			responseObject.put("cancelPolicy", cancelPolicy);

			List<DropdownModel> premium = orderClassService.getPremiumDetails(ocId);
			responseObject.put("premium", premium);

			List<DropdownModel> languageList = orderClassService.getLanguageList();
			responseObject.put("languageList", languageList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getIssueDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}

	@RequestMapping(path = "/saveSubscriptionDef", method = RequestMethod.POST)
	public Map<String, Object> saveSubscriptionDef(SubscriptionDef subscriptionDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = orderClassService.saveSubscriptionDef(subscriptionDef);
			int subscriptionDefId = orderClassService.getSubscriptionDefId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("subscriptionDefId", subscriptionDefId);

			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in savesubscriptionDef() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateSubscriptionDef", method = RequestMethod.POST)
	public Map<String, Object> updateSubscriptionDef(SubscriptionDef subscriptionDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = orderClassService.updateSubscriptionDef(subscriptionDef);
			int subscriptionDefId = orderClassService.getSubscriptionDefId();
			if (status != 0) {
				responseObject.put(STATUS, true);
				responseObject.put("subscriptionDefId", subscriptionDefId);

			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateSubscriptionDef() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteSubscriptionDef", method = RequestMethod.POST)
	public Map<String, Object> deleteSubscriptionDef(int subscriptionDefId) {
		Map<String, Object> responseObject = new HashMap<>();
		String status = "";
		try {
			status = orderClassService.deleteSubscriptionDef(subscriptionDefId);
			int lastIndexOfColon = status.lastIndexOf(':');
			int lastIndexOfFullstop = status.lastIndexOf('.');
			if (status.equals("1")) {
				responseObject.put(STATUS, true);
				responseObject.put("status", "subscriptionDefId(" + subscriptionDefId + ") deleted successfully");
			} else {
				responseObject.put(STATUS, false);
				String returnStatus2 = status.substring(lastIndexOfColon, lastIndexOfFullstop);
				returnStatus2 = returnStatus2.replaceAll("\"", "").replaceAll(":", "").trim();
				responseObject.put("status", returnStatus2);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in deleteSubscriptionDef() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/packageDefSave", method = RequestMethod.POST)
	public Map<String, Object> addPackageDefSave(PackageDefinationModel packageDefination) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = orderClassService.addPackageDefSave(packageDefination);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveaddPackage : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}

	@RequestMapping(path = "/updatePackageDef", method = RequestMethod.POST)
	public Map<String, Object> updatePackageDef(PackageDefinationModel packageDefination, int pkgDefId) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {
			status = orderClassService.updatePackageDef(packageDefination, pkgDefId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updatePackageRecords : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path="/deletePackageDetails",method=RequestMethod.POST)
	public Map<String,Object> deletePackageDetails(int pkgDefId) {
		int status;
		Map<String,Object> responseObject=new HashMap<>();
		try {
			status=orderClassService.deletePackageDetails(pkgDefId);
			if(status==0) {
				responseObject.put(STATUS,false);
			}else {
				responseObject.put(STATUS,true);
			}
			return responseObject;
		}
		catch(Exception e) {
			LOGGER.info("Error in updatePackageRecords : " + e);
			responseObject.put(STATUS,ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/issueDetails", method = RequestMethod.POST)
	public Map<String, Object> issueDetailsController(HttpServletRequest req) {
		Integer issueId = null;
		String issueDate = null;
		String enumeration = null;
		String volume_group = null;
		String description = null;
		Map<String, Object> issueDetails = new HashMap<>();
		List<Map<String, Object>> details = new ArrayList<>();

		try {

			if (req.getParameterMap().containsKey("issueDate")) {
				issueDate = req.getParameter("issueDate");
				details = orderClassService.getByIssueDetailsByValue(issueDate, null, null, null, null);

				issueDetails.put("issueDate", details);
			}
			if (req.getParameterMap().containsKey("issueId")) {
				issueId = Integer.parseInt(req.getParameter("issueId"));
				details = orderClassService.getByIssueDetailsByValue(null, issueId, null, null, null);
				issueDetails.put("issueById", details);
			}

			if (req.getParameterMap().containsKey("enumeration")) {
				enumeration = req.getParameter("enumeration");
				details = orderClassService.getByIssueDetailsByValue(null, null, null, enumeration, null);
				issueDetails.put("enumeration", details);
			}
			if (req.getParameterMap().containsKey("volume_group")) {
				volume_group = req.getParameter(volume_group);
				details = orderClassService.getByIssueDetailsByValue(null, null, null, volume_group, null);
				issueDetails.put("volume_group", details);
			}
			if (req.getParameterMap().containsKey("issueId") && req.getParameterMap().containsKey("description")) {
				issueId = Integer.parseInt(req.getParameter("issueId"));
				description = req.getParameter("description");
				details = orderClassService.getByIssueDetailsByValue(null, issueId, null, null, description);
				issueDetails.put("issueByIdDescription", details);
			}
			details = orderClassService.getAddressDetails();

		} catch (Exception e) {
			LOGGER.info("Error in getIssueDetails() : " + e);
			issueDetails.put(STATUS, ERROR + e);

		}
		return issueDetails;
	}

	@RequestMapping(path = "/getVolumeGroupDetails", method = RequestMethod.POST)
	List<DropdownModel> getVolumeDetails() {
		List<DropdownModel> details = null;
		try {
			details = orderClassService.getVolumeDetails();

			return details;
		}

		catch (Exception e) {
			LOGGER.info("Error in getIssueDetails() : " + e);

		}

		return null;

	}
	/*-------------------for defualt values----------------------*/

	@RequestMapping(path = "/OcIssueDetails", method = RequestMethod.POST)
	public Map<String, Object> getOcIssueDetails(Integer ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> ocIdDetails = new ArrayList<>();
		List<Map<String, Object>> issueDetails = new ArrayList<>();
		// List<Map<String, Object>> promoCardOffer = new ArrayList<>();
		try {
			ocIdDetails = orderClassService.getOcIdDetails(ocId);
			Long oc_Id = null;
			for (Map<String, Object> list : ocIdDetails) {
				oc_Id = Long.parseLong(list.get("oc_id").toString());
				if (oc_Id != null) {
					break;
				}
			}
			issueDetails = orderClassService.getIssueIdDetails(ocId);
			Long issueId = null;
			for (Map<String, Object> list : issueDetails) {
				issueId = Long.parseLong(list.get("issue_id").toString());
				if (issueId != null) {
					break;
				}
			}

			responseObject.put("oc_id", ocIdDetails);
			responseObject.put("issueDetails", issueDetails);
		} catch (Exception e) {
			LOGGER.info("Error in getPromotionCardDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/chooseSubscriptionStartOption", method = RequestMethod.POST)
	public Map<String, Object> displaySubscriptionStart(Integer ocId, @RequestParam(value = "action") String action,
			@RequestParam(value = "numOfDays", required = false) Integer numOfDays,
			@RequestParam(value = "from_date", required = false) String from_date,
			@RequestParam(value = "to_date", required = false) String to_date,
			@RequestParam(value = "start_date", required = false) String start_date,
			@RequestParam(value = "numOfIssues", required = false) Integer numOfIssues,
			@RequestParam(value = "issue_id", required = false) Integer issue_id,
			@RequestParam(value = "volume", required = false) String volume,@RequestParam(value = "volume", required = false) String issue_date) {

		Map<String, Object> responseObject = new HashMap();

		try {

			
			String actionValue = action.toLowerCase();
			System.out.println("Contoller actionValue---->" + actionValue);
		
			switch (actionValue) {

			case "backstart":

				
				responseObject = orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date,
						start_date, numOfIssues, issue_id, volume, action,issue_date); 
				System.out.println(responseObject);
				responseObject.put("backstart", responseObject);
				break;

			case "current":

				
				responseObject = orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date,
						start_date, numOfIssues, issue_id, volume, action,issue_date); 
				System.out.println(responseObject);
				responseObject.put("current", responseObject);
				break;
				
			case "customstart1":

				
			
				responseObject = orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date,
						start_date, numOfIssues, issue_id, volume, action,issue_date); 
				System.out.println(responseObject);
				responseObject.put("customstart1", responseObject);

				break;

			case "volumegroup":

				responseObject=orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date, start_date, numOfIssues,
						issue_id, volume, action,issue_date);
				System.out.println(responseObject);
				responseObject.put("volumegroup", responseObject);
				break;
				
			case "currentvolume":

				responseObject=orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date, start_date, numOfIssues,
						issue_id, volume, action,issue_date);
				System.out.println(responseObject);
				responseObject.put("currentvolume", responseObject);

				break;

			case "customstart2":

				responseObject=orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date, start_date, numOfIssues,
						issue_id, volume, action,issue_date);
				System.out.println(responseObject);
				responseObject.put("customstart2", responseObject);
				break;

			case "currentdate":
				responseObject=orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date, start_date, numOfIssues,
						issue_id, volume, action,issue_date);
				
				System.out.println("currentdate malini" + responseObject);
				break;

			case "currentnumdays":

				responseObject=orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date, start_date, numOfIssues,
						issue_id, volume, action,issue_date);
				
				System.out.println(responseObject);
				responseObject.put("currentnumdays", responseObject);
				break;
				
			case "customstart3":

				responseObject=orderClassService.displaySubscriptionstart(ocId, numOfDays, from_date, to_date, start_date, numOfIssues,
						issue_id, volume, action,issue_date);
				System.out.println(responseObject);
				responseObject.put("customstart3", responseObject);
				break;

			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getIssueDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}
	
	@RequestMapping(path = "/saveSubscriptionstart", method = RequestMethod.POST)
	public Map<String, Object> saveSubscriptionStart(SubscriptionStart start) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {

			status = orderClassService.saveSubscriptionstart(start);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveWebDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/getSubscriptionStart", method = RequestMethod.POST)
	public Map<String, Object> getSubscriptionStart(Integer ocId){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {

			List<Map<String, Object>> getSubscriptionStart = orderClassService.getSubscriptionStart(ocId);
			responseObject.put("getSubscriptionStart", getSubscriptionStart);
			
		} catch (Exception e) {
			LOGGER.info("Error in showGenericPromo(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;

	}
 
	public Map<String, Object> getPublicationGroup() {
		Map<String, Object> responseObject = null;
		try {
			responseObject = new LinkedHashMap<>();

			List<DropdownModel> allPubGroup = orderClassService.getallPubGroup();
			responseObject.put("allPubGroup", allPubGroup);
			List<DropdownModel> geographicalRegionList = orderClassService.getGeographicalRegionList();
			responseObject.put("geographicalRegionList", geographicalRegionList);
			List<Map<String, Object>> qualificationSourceList = orderClassService.getQualificationSourceList();
			responseObject.put("qualificationSourceList", qualificationSourceList);
			List<Map<String, Object>> mailingAddressNameList = orderClassService.getMailingAddressNameList();
			responseObject.put("mailingAddressNameList", mailingAddressNameList);
			List<Map<String, Object>> salesChannelList = orderClassService.getSalesChannelList();
			responseObject.put("salesChannelList", salesChannelList);

			List<Map<String, Object>> subscriptionTypeList = orderClassService.getSubscriptionTypeList();
			responseObject.put("SubscriptionTypeList", subscriptionTypeList);
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("Error in publicationgroup");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	

	@RequestMapping(path = "/saveAuditTrackingPubDetails", method = RequestMethod.POST)
	public Map<String, Object> saveAuditTrackingPubDetails(AuditTrackingModel auditTrackingModel) {

		Map<String, Object> responseObject = new LinkedHashMap<>();

		int status = 0;
		try {
			status = orderClassService.saveAuditTrackingPubDetails(auditTrackingModel);

			if (status == 1) {
				responseObject.put(STATUS, true);

			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveAuditTrackingDetails: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getAuditTrackingPubDetails", method = RequestMethod.POST)

	public Map<String, Object> getAuditTrackingPubDetails(@RequestParam("ocId") int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getAuditTrackingPubDetails = orderClassService.getAuditTrackingPubDetails(ocId);
			responseObject.put("getAuditTrackingPubDetails", getAuditTrackingPubDetails);
			responseObject.put("getallPubGroup", orderClassService.getallPubGroup());
			responseObject.put("getGeographicalRegionList", orderClassService.getGeographicalRegionList());
			responseObject.put("getQualificationSourceList", orderClassService.getQualificationSourceList());
			responseObject.put("getMailingAddressNameList", orderClassService.getMailingAddressNameList());
			responseObject.put("getSalesChannelList", orderClassService.getSalesChannelList());
			responseObject.put("getSubscriptionTypeList", orderClassService.getSubscriptionTypeList());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updateAuditTrackingPubDetails", method = RequestMethod.POST)

	public Map<String, Object> updateAuditTrackingDetails(AuditTrackingModel auditTrackingModel) {
		LOGGER.info("updating audit:{}", auditTrackingModel);
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = orderClassService.updateAuditTrackingPubDetails(auditTrackingModel);

			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}

	@RequestMapping(value = "/getQuickOrderCodeDetails", method = RequestMethod.POST)

	public Map<String, Object> getQuickOrderCodeDetails(@RequestParam("ocId") Integer ocId,Integer  orderCodeId) {
		Map<String, Object> responseObject = null;
		try {
             
			responseObject = new LinkedHashMap<>();
			//List<DropdownModel> premiumList = orderClassService.getPremiumList();
			responseObject.put("premiumList",orderClassService.getPremiumList());
			List<Map<String, Object>> getQuickOrderCodeDetails = orderClassService.getQuickOrderCodeDetails(ocId, orderCodeId);
			responseObject.put("getQuickOrderCodeDetails",getQuickOrderCodeDetails);
			
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}
	
	
	@RequestMapping(path = "/updateQuickOrderCodeDetails", method = RequestMethod.POST)

	public Map<String, Object> updateQuickOrderCodeDetails(QuickOrderCodeModel quickOrderCodeModel) {
		LOGGER.info("updating ordercode:{}",quickOrderCodeModel);
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = orderClassService.updateQuickOrderCodeDetails(quickOrderCodeModel);

			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}
	
	@RequestMapping(path = "/saveQuickOrderCodeDetails", method = RequestMethod.POST)
	public Map<String, Object> saveQuickOrderCodeDetails(QuickOrderCodeModel quickOrderCodeModel) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			status = orderClassService.saveQuickOrderCodeDetails(quickOrderCodeModel);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveQuickOrderCodeDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}
	@RequestMapping(path ="/packageContentDetails",method=RequestMethod.POST)
	 public Map<String, Object> getPackageContentDetails(Integer orderCodeId,Integer itemOrderCodeId,Integer pkgContentSeq) {
		 Map<String, Object> responseObject=new LinkedHashMap<>();
		 List<Map<String, Object>> contentDetails=new ArrayList<>();
		 List<Map<String, Object>> orderDetails=new ArrayList<>();
		 List<Map<String,Object>> otherData=new ArrayList<>();
		 List<Map<String,Object>> pkgFinaldetails=new ArrayList<>();
		 List<DropdownModel> prepayOpt=new ArrayList<>();
		 try {
			 Integer ordCodeId=null;
			 Integer pkgContSeq=null;
			 Integer itemOrdCodeId=null;
			 
			 if(orderCodeId==null && (pkgContentSeq==null && itemOrderCodeId==null)) {
				 orderDetails=orderClassService.getOrderDetails(orderCodeId);
				 for(Map<String, Object> list:orderDetails) {
					 ordCodeId=Integer.parseInt(list.get("order_code_id").toString());
					 LOGGER.info("ordCodeId:{}",ordCodeId);
					 if(ordCodeId!=null) {
						 break;
					 }
				 }
				 contentDetails= orderClassService.getContentDetails(ordCodeId);
				 for(Map<String, Object> list:contentDetails) {
					 pkgContSeq= Integer.parseInt(list.get("pkg_content_seq").toString());
					 itemOrdCodeId= Integer.parseInt(list.get("item_order_code_id").toString());
					 if(pkgContSeq!=null) {
						 break;
					 }
				 }
				 responseObject.put("orderDetails",orderDetails);
				 responseObject.put("contentDetails",contentDetails);
				 prepayOpt=orderClassService.getPrepay();
				 responseObject.put("prepayOpt", prepayOpt);
			//	 otherData=orderClassService.getOtherData(orderCodeId,pkgContentSeq);
			//	 responseObject.put("otherData", otherData);
				 
			 }
			 else {
				 pkgFinaldetails=orderClassService.getPkgFinaldetails(orderCodeId,pkgContentSeq);
				 responseObject.put("pkgFinaldetails",pkgFinaldetails);
				 for (Map<String,Object> list:pkgFinaldetails) {
					 ordCodeId= Integer.parseInt(list.get("order_code_id").toString());
					 pkgContSeq=Integer.parseInt(list.get("pkg_content_seq").toString());
					 if(ordCodeId!=null) {
						 break;
					 }
				 }
				 prepayOpt=orderClassService.getPrepay();
				 responseObject.put("prepayOpt", prepayOpt);
				otherData=orderClassService.getOtherData(orderCodeId,pkgContentSeq);
				 responseObject.put("otherData", otherData);
			 }
		 }catch(Exception e) {
			 LOGGER.info("Error in getpackacontentDetails():" + e);
			 responseObject.put(STATUS, ERROR +e);
			 return responseObject;
		 } 
		 return responseObject;
	 }

	@RequestMapping(path ="/savePackageContentDetails",method=RequestMethod.POST) 
		 public Map<String, Object> savePackageContents(PackageContentModel packageContent) {
		 int status=0;
		 Map<String,Object> responseObject=new HashMap<>();
		 try {
			 if(packageContent.getOrderCodeId()==null) {
				 status=orderClassService.savePkgContents(packageContent);
				 Integer orderCodeId=orderClassService.getOrderCodeId();
				 if(status!=0) {
					 responseObject.put(STATUS,true);
					 responseObject.put("orderCodeId",orderCodeId);
					 status=0;
				 }else {
					 responseObject.put(STATUS,false);
				 }
			 }else if((packageContent.getOrderCodeId()!=null) && (packageContent.getPkgContentSeq()!=null)) {
				 status=orderClassService.savePkgContents(packageContent);
				 Integer pkgContentSeq=orderClassService.getPkgContentSeq(packageContent.getOrderCodeId());
				 if(status!=0) {
					 responseObject.put(STATUS,true);
					 responseObject.put("orderCodeId",packageContent.getOrderCodeId());
					 responseObject.put("pkgContentSeq",pkgContentSeq);
					 status=0;
				 }else {
					 responseObject.put(STATUS,false);
				 }
			 }else {
				 status=orderClassService.savePkgContents(packageContent);
				 Integer itemOrderCodeId=orderClassService.getItemOrderCodeId(packageContent.getOrderCodeId());
				 if(status !=0) {
					 responseObject.put(STATUS,true);
					 responseObject.put("orderCodeId",packageContent.getOrderCodeId());
					 responseObject.put("pkgContentSeq",packageContent.getPkgContentSeq());
					 responseObject.put("itemOrderCodeId",itemOrderCodeId);
				 }
			 }
			 return responseObject;
		 }
			 catch (Exception e) {
					LOGGER.info("Error in savePackageContentDetails() : " + e);
					responseObject.put(STATUS, ERROR + e);

		 }
			 return responseObject;
	 } 
	@RequestMapping(path ="/updatePackageContentDetails",method=RequestMethod.POST) 
	public Map<String, Object> updatePackageContent(PackageContentModel packageContent) {
		int status=0;
		Map<String, Object> responseObject=new HashMap<>();
		try {
			if(packageContent.getOrderCodeId()!=null && packageContent.getPkgContentSeq()==null) {
				status=orderClassService.updatePackageContent(packageContent);
				Integer orderCodeId=packageContent.getOrderCodeId();
				if(status!=0) {
					responseObject.put(STATUS,true);
					responseObject.put("orderCodeId",orderCodeId);
				}else {
					responseObject.put(STATUS,false);
				}
			}else if(packageContent.getOrderCodeId()!=null && packageContent.getPkgContentSeq()!=null) {
				status=orderClassService.updatePackageContent(packageContent);
				Integer pkgContentSeq=packageContent.getPkgContentSeq();
				if(status!=0) {
					responseObject.put(STATUS,true);
					responseObject.put("orderCodeId",packageContent.getOrderCodeId());
					responseObject.put("pkgContentSeq",pkgContentSeq);
					status=0;
				}else {
					responseObject.put(STATUS,false);
				} 
				} else {
					status=orderClassService.updatePackageContent(packageContent);
					Integer pkgContentSeq=packageContent.getPkgContentSeq();
					if(status!=0) {
						responseObject.put(STATUS,true);
						responseObject.put("orderCodeId",packageContent.getOrderCodeId());
						responseObject.put("pkgContentSeq",pkgContentSeq);
						status=0;
					} else {
						responseObject.put(STATUS,false);

					}
				}return responseObject;
		}catch(Exception e) {
			LOGGER.info("Error in packageContentDetails() : " + e);
			responseObject.put(STATUS,ERROR+ e);
			return responseObject;
		}
	}
	@RequestMapping(path ="/deletePackageContentDetails",method=RequestMethod.POST) 
	public Map<String,Object> deletePackagaCOntent(int orderCodeId) {
		int status;
		Map<String,Object> responseObject=new HashMap<>();
		try {
			status=orderClassService.deletePackageContent(orderCodeId);
			if(status==0) {
				responseObject.put(STATUS,false);
			}else {
				responseObject.put(STATUS,true);
			}
			return responseObject;
		}catch(Exception e) {
			LOGGER.info("Error in deletepackageContentDetails() : " + e);
			responseObject.put(STATUS,ERROR+ e);
			return responseObject;
		}
	}
	
	@RequestMapping(value="/packageDefinationDetails", method=RequestMethod.POST)
	 public Map<String,Object> getpackageDefinationDetails(int pkgDefId, int ocId) {
		 Map<String,Object> responseObject=new LinkedHashMap<>();
		 List<Map<String,Object>> packageDetails=new ArrayList<>();
		 List<Map<String,Object>> checkValues=new ArrayList<>();
		 try {
			 packageDetails=orderClassService.getpackageDefinationDetails(pkgDefId,ocId);
			 checkValues=orderClassService.getCheckValues(pkgDefId);
			 responseObject.put("checkValues",checkValues);
			 List<DropdownModel> methodList=orderClassService.getMethodList();
			 responseObject.put("methodList",methodList);
			 List<DropdownModel> calendarUnits=orderClassService.getCalendarUnits();
			 responseObject.put("calendarUnits",calendarUnits);
			 List<DropdownModel> subscriberSiteType=orderClassService.getSubscriberSiteType();
			 responseObject.put("subscriberSiteType",subscriberSiteType);
			 List<DropdownModel> revenueOption=orderClassService.getRevenueOption();
			 responseObject.put("revenueOption",revenueOption);
			 List<DropdownModel> renewalList=orderClassService.getRenewalList();
			 responseObject.put("renewalList",renewalList);
			 List<DropdownModel> discountList=orderClassService.getDiscountList();
			 responseObject.put("discountList",discountList);
			 List<DropdownModel> rateList=orderClassService.getRateList();
			 responseObject.put("rateList",rateList);
			 responseObject.put("packageDetails",packageDetails);
			 responseObject.put(STATUS, SUCCESS);
			 return responseObject;
		 }catch(Exception e) {
			 LOGGER.info("Error in getPackageDetails() : " + e);
				responseObject.put(STATUS, ERROR + e);
				return responseObject;

		 }
	 }
	 @RequestMapping(path ="/populatePackageData",method=RequestMethod.POST)
	 public Map<String, Object> populatePackageData() {
		 Map<String, Object> responseObject=null;
		 try {
			 responseObject=new LinkedHashMap<>();
			 List<DropdownModel> methodList=orderClassService.getMethodList();
			 responseObject.put("methodList",methodList);
			 List<DropdownModel> calendarUnits=orderClassService.getCalendarUnits();
			 responseObject.put("calendarUnits",calendarUnits);
			 List<DropdownModel> subscriberSiteType=orderClassService.getSubscriberSiteType();
			 responseObject.put("subscriberSiteType",subscriberSiteType);
			 List<DropdownModel> revenueOption=orderClassService.getRevenueOption();
			 responseObject.put("revenueOption",revenueOption);
			 List<DropdownModel> renewalList=orderClassService.getRenewalList();
			 responseObject.put("renewalList",renewalList);
			 List<DropdownModel> discountList=orderClassService.getDiscountList();
			 responseObject.put("discountList",discountList);
			 List<DropdownModel> rateList=orderClassService.getRateList();
			 responseObject.put("rateList",rateList);

			 return responseObject;


		 }catch(Exception e) {
			 LOGGER.info("Error in populatePackageData");
			 responseObject.put(STATUS, ERROR + e);
				return responseObject;
		 }
	 }

	
	@RequestMapping(path ="/saveProduct",method=RequestMethod.POST) 
	public Map<String,Object> saveProduct(ProductModel product) {
	Map<String,Object> responseObject=new LinkedHashMap<>();
	int status;
	try {
		status=orderClassService.saveProductDetails(product);
		int  prodectId=orderClassService.getProductId();
		if(status!=0) {
			responseObject.put(STATUS,true);
			responseObject.put("prodectId",prodectId);
		}else {
			responseObject.put(STATUS,false);
		}
		return responseObject;
	}catch(Exception e) {
		LOGGER.info("error in saveProduct(): " +e);
		responseObject.put(STATUS,ERROR +e);
		return responseObject;
	}
	}
	@RequestMapping(path ="/updateProduct",method=RequestMethod.POST) 
	public Map<String,Object> updateProductDetails(ProductModel product) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		int status=0;
		try {
			status=orderClassService.updateDetails(product);
			int productId=product.getProductId();
			if(status!=0) {
				responseObject.put(STATUS,true);
				responseObject.put("productId",productId);
			}else {
				responseObject.put(STATUS,false);
			}
			return responseObject;
		}catch(Exception e) {
			LOGGER.info("error in updateProduct(): " +e);
			responseObject.put(STATUS,ERROR +e);
			return responseObject;
		}
	}
	@RequestMapping(path ="/deleteProduct",method=RequestMethod.POST) 
	public Map<String,Object> deleteProduct(int productId) {
		Map<String,Object> responseObject=new HashMap<>();
		String status="";
		try {
			status=orderClassService.deleteProductDetails(productId);
			int lastIndexOfColon=status.lastIndexOf(':');
			int lastIndexOfFullStop=status.lastIndexOf('.');
			if(status.equals("1")) {
				responseObject.put(STATUS,true);
				responseObject.put("status","productId("+productId+") deleted successfully");
			}else {
				responseObject.put(STATUS,false);
				String returnStatus2=status.substring(lastIndexOfColon,lastIndexOfFullStop);
				returnStatus2=returnStatus2.replaceAll("\"","").replaceAll(":","").trim();
				responseObject.put("status",returnStatus2);
			}return responseObject;
		}catch(Exception e) {
			LOGGER.info("error in deleteProduct(): " +e);
			responseObject.put(STATUS,ERROR +e);
			return responseObject;
		}
	}
	
	  @RequestMapping(path ="/productInformation",method=RequestMethod.POST)
	  public Map<String,Object> productDetail(int ocId) { 
		  Map<String,Object> responseObject=new LinkedHashMap<>(); 
	  try { 
		  List<Map<String,Object>> productContents=orderClassService.getProductDetails(ocId);
		  responseObject.put("productContents", productContents); 
		  List<DropdownModel> taxonomyList = orderClassService.getTaxonomyList();
		  responseObject.put("taxonomyList", taxonomyList); 
		  List<DropdownModel> inventoryList = orderClassService.getInventoryList();
		  responseObject.put("inventory", inventoryList); 
		  List<DropdownModel> orderDetails=orderClassService.getOrderList(ocId);
		  responseObject.put("orderDetails", orderDetails); 
		  List<DropdownModel> rateList=orderClassService.getRateList(); 
		  responseObject.put("rateList",rateList); 
		  List<DropdownModel> premiunList=orderClassService.getPremiumList(ocId);
		  responseObject.put("premiunList", premiunList);
		  responseObject.put(STATUS, SUCCESS);
		  return responseObject;
	 }catch(Exception e) {
		 LOGGER.info("error in productDetails(): " +e);
			responseObject.put(STATUS,ERROR +e);
			return responseObject;
	 }
	  }

	 

}


	 
