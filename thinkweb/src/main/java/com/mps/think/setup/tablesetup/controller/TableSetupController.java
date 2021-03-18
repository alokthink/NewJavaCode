package com.mps.think.setup.tablesetup.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mps.think.model.DropdownModel;
import com.mps.think.setup.model.DashboardLeftPanelModel;
import com.mps.think.setup.tablesetup.model.AuditLeftPanelModel;
import com.mps.think.setup.tablesetup.model.AuditModel;
import com.mps.think.setup.tablesetup.model.CustomerServiceLeftPanelModel;
import com.mps.think.setup.tablesetup.model.DealModel;
import com.mps.think.setup.tablesetup.model.DealsLeftPanelModel;
import com.mps.think.setup.tablesetup.model.DefaultSettings;
import com.mps.think.setup.tablesetup.model.DefaultSettingsLeftPanelModel;
import com.mps.think.setup.tablesetup.model.DemographicModel;
import com.mps.think.setup.tablesetup.model.DemographicsLeftPanelModel;
import com.mps.think.setup.tablesetup.model.DiaplayContextRedirectionLeftPanelModel;
import com.mps.think.setup.tablesetup.model.InternationalModel;
import com.mps.think.setup.tablesetup.model.InternationalandRegionalLeftPanelModel;
import com.mps.think.setup.tablesetup.model.LabelModel;
import com.mps.think.setup.tablesetup.model.LeftPanelTableSetupModel;
import com.mps.think.setup.tablesetup.model.PaymentsModel;
import com.mps.think.setup.tablesetup.model.ServiceModel;
import com.mps.think.setup.tablesetup.model.ShippingDeliveryDistributionLeftPanelModel;
import com.mps.think.setup.tablesetup.model.ShippingDeliveryandDistributionModel;
import com.mps.think.setup.tablesetup.model.TableSetupModel;
import com.mps.think.setup.tablesetup.model.TableSetupOrderClassModel;
import com.mps.think.setup.tablesetup.model.TableSetupOrdersModel;
import com.mps.think.setup.tablesetup.model.TaxesLeftPanelModel;
import com.mps.think.setup.tablesetup.model.TaxesModel;
import com.mps.think.setup.tablesetup.model.labesLeftPanelModel;
import com.mps.think.setup.tablesetup.service.TableSetupService;

@RestController
public class TableSetupController {
	private static Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger LOGGER = LoggerFactory.getLogger(TableSetupController.class);

	@Autowired
	TableSetupService tableSetupService;

	@RequestMapping(path = "/customerAddrsState", method = RequestMethod.POST)
	public Map<String, Object> saveAddress(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveAddressStatus(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveAddressStatus : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAddrsStateUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateAddressState(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateAddressState(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in updateAddressStatus : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAddrsStateDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteAddressState(String addressStatus) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteAddressState(addressStatus);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteAddressStatus : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAddrsTypeSave", method = RequestMethod.POST)
	public Map<String, Object> saveAddressType(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveAddressType(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveAddressType : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAddrsTypeUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateAddressType(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateAddressType(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveAddressType : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAttachmentCatagorySave", method = RequestMethod.POST)
	public Map<String, Object> saveAttachmentCatagorySave(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveAttachmentCatagorySave(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveAttachmentCatagorySave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAttachCategoryUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateAttachCategory(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateAttachCategory(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveAddressType : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAttachCategoryDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteAttachCategory(String attachmentCatagory) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteAttachCategory(attachmentCatagory);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteAddressType : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAuxFieldSave", method = RequestMethod.POST)
	public Map<String, Object> saveAuxField(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveAuxField(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveAttachmentCatagorySave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAuxFieldUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateAuxField(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateAuxField(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in updateAuxField : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerAuxFieldDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteAuxField(String tableName) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteAuxField(tableName);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerAuxFieldDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerCredtStatusdSave", method = RequestMethod.POST)
	public Map<String, Object> saveCreditStatus(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCreditStatus(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveCreditStatus : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerCreditStatusUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateCreditStatus(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateCreditStatus(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in updateCreditStatus : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerCategorydSave", method = RequestMethod.POST)
	public Map<String, Object> saveCustomerCategory(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCustomerCategory(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerCategorydSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerCategoryUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateCustomerCategory(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateCustomerCategory(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerCategoryUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerRentalListSave", method = RequestMethod.POST)
	public Map<String, Object> saveCustomerRentList(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCustomerRentList(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerRentalListSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerRentalListUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateCustomerRentList(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateCustomerRentList(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerRentalListUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerLoginQuestionSave", method = RequestMethod.POST)
	public Map<String, Object> saveCustomerLoginQuestion(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCustomerLoginQuestion(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerLoginQuestionSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerLoginQuestionUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateCustomerLoginQuetion(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateCustomerLoginQuetion(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerLoginQuestionUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerLoginQuestionDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteCustomerLoginQuestion(int customerLoginQuestionId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCustomerLoginQuestion(customerLoginQuestionId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerLoginQuestionDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerLookUpUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateCustomerLookup(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateCustomerLookup(tableSetupModel);
			responseObject.put("search_field_group", status);
			// int status1=tableSetupService.updateCustomerLookup1(tableSetupModel);
			// responseObject.put("search_result_display",status1);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerLookUpSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerLookUpDetails", method = RequestMethod.POST)
	public Map<String, Object> getCustomerLookupDetails(String search) {
		List<Map<String, Object>> defalutDetails = new ArrayList<>();
		List<Map<String, Object>> searchFieldGroup = new ArrayList<>();
		List<Map<String, Object>> searchFieldResultDisplay = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			defalutDetails = tableSetupService.getDefalutDetails(search);
			searchFieldGroup = tableSetupService.getSerachFieldGroup(search);
			searchFieldResultDisplay = tableSetupService.getSearchResultDisplay(search);

			responseObject.put("defalutDetails", defalutDetails);
			responseObject.put("searchFieldGroup", searchFieldGroup);
			responseObject.put("searchFieldresultDisplay", searchFieldResultDisplay);
			responseObject.put(STATUS, SUCCESS);
		} catch (Exception e) {
			LOGGER.info("error in customerLookUpDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/populateCustomerLookupData", method = RequestMethod.POST)
	public Map<String, Object> getCustomerLookupData(String search) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> dispContext = new ArrayList<>();
		// List<DropdownModel> followOnServicePage=new ArrayList<>();

		try {
			dispContext = tableSetupService.getDispContext();
			responseObject.put("dispContext", dispContext);
			// followOnServicePage=tableSetupService.getFollowOnServicePage();
			// responseObject.put("followOnServicePage",followOnServicePage);
			responseObject.put(STATUS, SUCCESS);
		} catch (Exception e) {
			LOGGER.info("error in populateCustomerLookupData : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/customerMatchSave", method = RequestMethod.POST)
	public Map<String, Object> saveCustomerMatchcode(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCustomerMatchcode(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerMatchSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerMatchCodeUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateCustomerMatchCode(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateCustomerMatchCode(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerMatchCodeUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerMatchCodeDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteCustomerMatchCode(int custMatchCodeDetailSeq, int customerMatchCodeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCustomerMatchCode(custMatchCodeDetailSeq, customerMatchCodeId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerMatchCodeDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerMatchCodeDetails", method = RequestMethod.POST)
	public Map<String, Object> getCustomerMatchCodeDetails(int custMatchCodeDetailSeq, int customerMatchCodeId) {
		List<Map<String, Object>> matchCodeValues = new ArrayList<>();
		List<Map<String, Object>> MatchCodeDetails = new ArrayList<>();
		List<DropdownModel> columnName = new ArrayList<>();
		List<DropdownModel> useNextSegment = new ArrayList<>();

		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			matchCodeValues = tableSetupService.getMatchCodeValues(customerMatchCodeId);
			MatchCodeDetails = tableSetupService.getMatchCodeDetails(custMatchCodeDetailSeq);
			columnName = tableSetupService.getColumnName();
			useNextSegment = tableSetupService.getUseNextSegment();
			responseObject.put("matchCodeValues", matchCodeValues);
			responseObject.put("MatchCodeDetails", MatchCodeDetails);
			responseObject.put("columnName", columnName);
			responseObject.put("useNextSegment", useNextSegment);

			responseObject.put(STATUS, SUCCESS);
		} catch (Exception e) {
			LOGGER.info("error in customerMatchCodeDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/customerProspectCategorySave", method = RequestMethod.POST)
	public Map<String, Object> saveProspectCategory(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.ProspectCategory(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerProspectCategorySave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerProspectCategoryUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateCustomerProspectCategory(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateCustomerProspectCategory(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in updateCustomerProspectCategory : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerProspectCategoryDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteCustomerProspectCategory(String prospectCategory) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCustomerProspectCategory(prospectCategory);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerProspectCategoryDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerSalesRepresentationSave", method = RequestMethod.POST)
	public Map<String, Object> saveSalesRepresatative(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveSalesRepresatative(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveSalesRepresatative : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerSalesRepresentativeUpdate", method = RequestMethod.POST)
	public Map<String, Object> updatecustomerSalesRepresentative(TableSetupModel tableSetupModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updatecustomerSalesRepresentative(tableSetupModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerSalesRepresentativeUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerSaleRepresentativeDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteCustomerSaleRep(int salesRepresentativeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCustomerSaleRep(salesRepresentativeId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteCustomerSaleRep : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveProfitCenterOrderClass", method = RequestMethod.POST)
	public Map<String, Object> saveprofitCenterOrderClass(TableSetupOrderClassModel tableSetupOrderClassModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveprofitCenterOrderClass(tableSetupOrderClassModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveprofitCenterOrderClass : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateProfitCenterOrderClass", method = RequestMethod.POST)

	public Map<String, Object> updateProfitCenterOrderClass(TableSetupOrderClassModel tableSetupOrderClassModel) {
		LOGGER.info("updating ordercode:{}", tableSetupOrderClassModel);
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateProfitCenterOrderClass(tableSetupOrderClassModel);

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

	@RequestMapping(path = "/saveTopic", method = RequestMethod.POST)
	public Map<String, Object> saveTopics(TableSetupOrderClassModel tableSetupOrderClassModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTopic(tableSetupOrderClassModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveTopic: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateTopic", method = RequestMethod.POST)

	public Map<String, Object> updateTopic(TableSetupOrderClassModel tableSetupOrderClassModel) {
		LOGGER.info("updating topic:{}", tableSetupOrderClassModel);
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateTopic(tableSetupOrderClassModel);

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

	@RequestMapping(path = "/saveSourceCodeFormat", method = RequestMethod.POST)
	public Map<String, Object> saveSourceCodeFormat(TableSetupOrderClassModel tableSetupOrderClassModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveSourceCodeFormat(tableSetupOrderClassModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveSourceCodeFormat: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateSourceFormat", method = RequestMethod.POST)

	public Map<String, Object> updateSourceFormat(TableSetupOrderClassModel tableSetupOrderClassModel) {
		LOGGER.info("updating sourceFormat:{}", tableSetupOrderClassModel);
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateSourceFormat(tableSetupOrderClassModel);

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

	@RequestMapping(path = "/saveVolumeGroup", method = RequestMethod.POST)
	public Map<String, Object> saveVolumeGroup(TableSetupOrderClassModel tableSetupOrderClassModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveVolumeGroup(tableSetupOrderClassModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in volumegroup: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateVolumeGroup", method = RequestMethod.POST)

	public Map<String, Object> updateVolumeGroup(TableSetupOrderClassModel tableSetupOrderClassModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateVolumeGroup(tableSetupOrderClassModel);

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

	@RequestMapping(path = "/customerAddrsTypeDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteAddressType(String addressType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteAddressType(addressType);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteAddressType : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerCreditStatusDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteCrditStatus(String creditStatus) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCrditStatus(creditStatus);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerCreditStatusDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerCategoryDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteCategory(String customerCategory) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCategory(customerCategory);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerCategoryDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/customerRentalListDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteRentList(String listRentalCategory) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteRentList(listRentalCategory);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in customerRentalListDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteTopic", method = RequestMethod.POST)
	public Map<String, Object> deleteTopic(String topic, int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTopic(topic, ocId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deletetopic : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteVolumeGroup", method = RequestMethod.POST)
	public Map<String, Object> deleteVolumeGroup(int volumeGroupId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteVolumeGroup(volumeGroupId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deletevolume group : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteProfitCenter", method = RequestMethod.POST)
	public Map<String, Object> deleteProfitCenter(String profitCenter) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteProfitCenter(profitCenter);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteProfitCenter : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/paymentsSave", method = RequestMethod.POST)
	public Map<String, Object> savePayments(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.savePayments(paymetsModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in paymentsSave: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/pamentsUpdate", method = RequestMethod.POST)
	public Map<String, Object> updatePayments(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updatePayments(paymetsModel);
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

	@RequestMapping(path = "/paymentsThresholdDelete", method = RequestMethod.POST)
	public Map<String, Object> deletePaymentThreshold(String paymentThreshold) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deletePaymentThreshold(paymentThreshold);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in paymentsThresholdDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/paymentTypeSave", method = RequestMethod.POST)
	public Map<String, Object> savePaymentType(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.savePaymentType(paymetsModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in paymentsSave: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/pamentTypeUpdate", method = RequestMethod.POST)
	public Map<String, Object> updatePaymentType(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updatePaymentType(paymetsModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in pamentTypeUpdate: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/paymentsTypeDelete", method = RequestMethod.POST)
	public Map<String, Object> deletePaymentType(String paymentType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deletePaymentType(paymentType);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in paymentsTypeDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/transactionReasonSave", method = RequestMethod.POST)
	public Map<String, Object> saveTransactionReason(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTransactionReason(paymetsModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in TransactionReasonSave: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/transactionReasonUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateTransactionReason(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateTransactionReason(paymetsModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in updateTransactionReason: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/transactionResonDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteTransactionReason(String transactionReason) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTransactionReason(transactionReason);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteTransactionReason : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/installmentPlanSave", method = RequestMethod.POST)
	public Map<String, Object> saveInstallementplan(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			if (paymetsModel.getAllowDefaultUsage().equals("1")) {
				status = tableSetupService.saveInstallementplanDetails(paymetsModel);
			} else if (paymetsModel.getAutoSetup().equals("1")) {
				status = tableSetupService.saveInstallementplan(paymetsModel);
			}
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in installmentPlanSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/installmentPlanDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteIntallmentPlan(int installmentPlanId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteIntallmentPlan(installmentPlanId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in installmentPlanDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/installmentPlanUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateInstallmentPlan(PaymentsModel paymetsModel) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			if (paymetsModel.getAutoSetup().equals("1")) {
				status = tableSetupService.updateInstallmentPlan(paymetsModel);
			}
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in installmentPlanUpdate: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/settleRetryDefSave", method = RequestMethod.POST)
	public Map<String, Object> saveSettleRetryDef(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveSettleRetryDef(paymetsModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in settleRetryDefSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/settleRetryDefUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateSettleRetryDef(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateSettleRetryDef(paymetsModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in settleRetryDefUpdate: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/settleRetryDefDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteSettleRetrydef(String settleRetryDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteSettleRetrydef(settleRetryDef);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteSettleRetrydef : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/qtyDiscountScheduleSave", method = RequestMethod.POST)
	public Map<String, Object> saveQtyDiscountSchedule(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveQtyDiscountSchedule(paymetsModel);
			status = tableSetupService.saveQtyDiscountScheduleDtl(paymetsModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in qtyDiscountScheduleSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/qtyDiscountScheduleUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateQtyDiscountSchedule(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateQtyDiscountSchedule(paymetsModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in updateQtyDiscountSchedule: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/qtyDiscountScheduleDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteQtyDiscountSchedule(String qtyDiscountSchedule, int qtyDiscountSchedDtlSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteQtyDiscountSchedule(qtyDiscountSchedule, qtyDiscountSchedDtlSeq);
			status = tableSetupService.deleteQtyDiscountScheduleDtl(qtyDiscountSchedule);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in qtyDiscountScheduleDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/multilineDiscountScheduleSave", method = RequestMethod.POST)
	public Map<String, Object> saveMultilineDiscountSchedule(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveMultilinDiscountSchedule(paymetsModel);
			int status1 = tableSetupService.saveMultilineDiscEff(paymetsModel);
			int status2 = tableSetupService.saveMultilineDiscSchedDtl(paymetsModel);

			if (status != 0 || status1 != 0 || status2 != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in multilineDiscountScheduleSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/multilineDiscountScheduleUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateMultilineDiscountSchedule(PaymentsModel paymetsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateMultilineDiscountSchedule(paymetsModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in updateMultilineDiscountSchedule: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/multilineDiscountScheduleDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteMultilineDiscountSchedule(String multilineDiscountSchedule,
			Integer multilineDiscEffSeq, Integer multiDiscScheddtlSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteMultilineDiscountScheduleDetails(multilineDiscountSchedule,
					multilineDiscEffSeq, multiDiscScheddtlSeq);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in multilineDiscountScheduleDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveCancelReason", method = RequestMethod.POST)
	public Map<String, Object> saveCancelReason(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCancelReason(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save cancelreason: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateCancelReason", method = RequestMethod.POST)

	public Map<String, Object> updateCancelReason(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateCancelReason(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteCancelReason", method = RequestMethod.POST)
	public Map<String, Object> deleteCancelReason(String cancelReason) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCancelReason(cancelReason);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteCancelReason : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveCancelPolicy", method = RequestMethod.POST)
	public Map<String, Object> saveCancelPolicy(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCancelPolicy(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save cancelreason: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateCancelPolicy", method = RequestMethod.POST)

	public Map<String, Object> updateCancelPolicy(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateCancelPolicy(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteCancePolicy", method = RequestMethod.POST)
	public Map<String, Object> deleteCancelPolicy(int cancelPolicyId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCancelPolicy(cancelPolicyId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteCancelPolicy : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveListPremiumUsed", method = RequestMethod.POST)
	public Map<String, Object> saveListPremiumUsed(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveListPremiumUsed(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save cancelreason: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateListPremiumUsed", method = RequestMethod.POST)

	public Map<String, Object> updateListPremiumUsed(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateListPremiumUsed(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteListPremiumUsed", method = RequestMethod.POST)
	public Map<String, Object> deleteListPremiumUsed(String orderCode, int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteListPremiumUsed(orderCode, ocId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deletelistPremiumused : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveOrders", method = RequestMethod.POST)
	public Map<String, Object> saveOrders(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveOrders(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saver OrderClass: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateOrders", method = RequestMethod.POST)

	public Map<String, Object> updateOrders(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateOrders(tableSetupOrdersModel);

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

	@RequestMapping(value = "/getOrderDetails", method = RequestMethod.POST)

	public Map<String, Object> getOrderDetails(String search, int searchFieldGroupSeq, int searchResultDisplaySeq) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getOrderDetails = tableSetupService.getOrderDetails(search, searchFieldGroupSeq,
					searchResultDisplaySeq);
			responseObject.put("getOrderDetails", getOrderDetails);
			responseObject.put(" getDispContext", tableSetupService.getDispContext());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/deleteOrders", method = RequestMethod.POST)
	public Map<String, Object> deleteOrders(String search, int searchFieldGroupSeq, int searchResultDisplaySeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteOrders(search, searchFieldGroupSeq, searchResultDisplaySeq);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deletelistPremiumused : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveOrderCategory", method = RequestMethod.POST)
	public Map<String, Object> saveOrderCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveOrderCategory(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save ordercategory: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateOrderCategory", method = RequestMethod.POST)

	public Map<String, Object> updateOrderCategory(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateOrderCategory(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteOrderCategory", method = RequestMethod.POST)
	public Map<String, Object> deleteOrderCategory(String orderCategory) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteOrderCategory(orderCategory);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete order category : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveSubscriptionCategory", method = RequestMethod.POST)
	public Map<String, Object> saveSubscriptionCategory(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveSubscriptionCategory(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save subscriptioncategory: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateSubscriptionCategory", method = RequestMethod.POST)

	public Map<String, Object> updateSubscriptionCategory(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateSubscriptionCategory(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteSubscriptionCategory", method = RequestMethod.POST)
	public Map<String, Object> deleteSubscriptionCategory(int subscriptionCategoryId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteSubscriptionCategory(subscriptionCategoryId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete subscription category : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveTaxonomy", method = RequestMethod.POST)
	public Map<String, Object> saveTaxonomy(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTaxonomy(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save Taxonomy: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateTaxonomy", method = RequestMethod.POST)

	public Map<String, Object> updateTaxonomy(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateTaxonomy(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteTaxonomy", method = RequestMethod.POST)
	public Map<String, Object> deleteTaxonomy(String taxonomy) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTaxonomy(taxonomy);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete deleteTaxonomy : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveTerm", method = RequestMethod.POST)
	public Map<String, Object> saveTerm(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTerm(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save Taxonomy: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateTerm", method = RequestMethod.POST)

	public Map<String, Object> updateTerm(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateTerm(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteTerm", method = RequestMethod.POST)
	public Map<String, Object> deleteTerm(int termId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTerm(termId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete Term : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveUnitTypes", method = RequestMethod.POST)
	public Map<String, Object> saveUnitTypes(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveUnitTypes(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save UnitTypes: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateUnitTypes", method = RequestMethod.POST)

	public Map<String, Object> updateUnitTypes(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateUnitTypes(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteUnitTypes", method = RequestMethod.POST)
	public Map<String, Object> deleteUnitTypes(int unitTypeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteUnitTypes(unitTypeId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete deleteUnitTypes : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveUpsellSuggestion", method = RequestMethod.POST)
	public Map<String, Object> saveUpsellSuggestion(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveUpsellSuggestion(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save UpsellSuggestion: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateUpsellSuggestion", method = RequestMethod.POST)

	public Map<String, Object> updateUpsellSuggestion(TableSetupOrdersModel tableSetupOrdersModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateUpsellSuggestion(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteUpsellSuggestion", method = RequestMethod.POST)
	public Map<String, Object> deleteUpsellSuggestion(int upsellSuggestionId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteUpsellSuggestion(upsellSuggestionId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete delete upsell suggestion : " + e);
			responseObject.put(STATUS, ERROR + e);

			return responseObject;
		}

	}

	@RequestMapping(path = "/saveCalenderCampaign", method = RequestMethod.POST)
	public Map<String, Object> saveCalenderCampaign(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCalenderCampaign(tableSetupOrdersModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save saveCalenderCampaign: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateCalenderCampaign", method = RequestMethod.POST)
	public Map<String, Object> updateCalenderCampaign(TableSetupOrdersModel tableSetupOrdersModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateCalenderCampaign(tableSetupOrdersModel);

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

	@RequestMapping(path = "/deleteCalenderCampaign", method = RequestMethod.POST)
	public Map<String, Object> deleteCalenderCampaign(int calenderCampaignId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCalenderCampaign(calenderCampaignId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete delete upsell suggestion : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/serviceCauseSave", method = RequestMethod.POST)
	public Map<String, Object> saveServiceCause(ServiceModel serviceModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveServiceCause(serviceModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in serviceCauseSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/serviceCauseUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateServiceCause(ServiceModel serviceModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateServiceCause(serviceModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in serviceCauseUpadate: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/serviceCauseDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteServiceCause(String causeCode, int reportItemId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteServiceCause(causeCode, reportItemId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in serviceCauseDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/serviceComplaintSave", method = RequestMethod.POST)
	public Map<String, Object> saveServiceComplaint(ServiceModel serviceModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveServiceComplaint(serviceModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveServiceComplaint : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/serviceComplaintUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateServiceComplaint(ServiceModel serviceModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateServiceComplaint(serviceModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in updateServiceComplaint: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/serviceComplaintDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteServiceComplaint(String complaintCode, String serviceCode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteServiceComplaint(complaintCode, serviceCode);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in serviceComplaintDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/serviceResolutionSave", method = RequestMethod.POST)
	public Map<String, Object> saveServiceResolution(ServiceModel serviceModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveServiceResolution(serviceModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveServiceResolution : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/serviceResolutionUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateServiceResolution(ServiceModel serviceModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateServiceResolution(serviceModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in serviceResolutionUpdate: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/serviceResolutionDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteServiceResolution(String complaintCode, String serviceCode, int reportItemId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteServiceResolution(complaintCode, serviceCode, reportItemId);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteServiceResolution : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getProfitCenter", method = RequestMethod.POST)
	public Map<String, Object> getProfitCenter(String profitCenter) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getProfitCenter = tableSetupService.getProfitCenter(profitCenter);
			responseObject.put("getprofitCenter", getProfitCenter);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getSourceCodeFormats", method = RequestMethod.POST)
	public Map<String, Object> getSourceCodeFormats(TableSetupOrderClassModel tableSetupOrderClassModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getSourceCodeFormats = tableSetupService
					.getSourceCodeFormats(tableSetupOrderClassModel);
			responseObject.put("getSourceCodeFormats", getSourceCodeFormats);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getTopic", method = RequestMethod.POST)
	public Map<String, Object> getTopic(String topic) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getTopic = tableSetupService.getTopic(topic);
			responseObject.put("get topic", getTopic);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getVolumeGroup", method = RequestMethod.POST)
	public Map<String, Object> getVolumeGroup(int volumeGroupId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getVolumeGroup = tableSetupService.getVolumeGroup(volumeGroupId);
			responseObject.put("get volume group", getVolumeGroup);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getCancelReason", method = RequestMethod.POST)
	public Map<String, Object> getCancelReason(String cancelReason) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getCancelReason = tableSetupService.getCancelReason(cancelReason);
			responseObject.put("getcancel reason", getCancelReason);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getCancelPolicy", method = RequestMethod.POST)
	public Map<String, Object> getCancelPolicy() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getCancelPolicy = tableSetupService.getCancelPolicy();
			responseObject.put("getcancel policy", getCancelPolicy);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getPremiumUsed", method = RequestMethod.POST)
	public Map<String, Object> getPremiumUsed() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getPremiumUsed = tableSetupService.getPremiumUsed();
			responseObject.put("get premium used", getPremiumUsed);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getOrderCategory", method = RequestMethod.POST)
	public Map<String, Object> getOrderCategory(String orderCategory) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getOrderCategory = tableSetupService.getOrderCategory(orderCategory);
			responseObject.put("get ordercategory", getOrderCategory);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getSubscriptionCategory", method = RequestMethod.POST)
	public Map<String, Object> getSubscriptionCategory(int subscriptionCategoryId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getSubscriptionCategory = tableSetupService
					.getSubscriptionCategory(subscriptionCategoryId);
			responseObject.put("get SubscriptionCategory", getSubscriptionCategory);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getTaxonomy", method = RequestMethod.POST)
	public Map<String, Object> getTaxonomy(String taxonomy) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getTaxonomy = tableSetupService.getTaxonomy(taxonomy);
			responseObject.put("get SubscriptionCategory", getTaxonomy);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getTerm", method = RequestMethod.POST)
	public Map<String, Object> getTerm(int termId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getTerm = tableSetupService.getTerm(termId);
			responseObject.put("get SubscriptionCategory", getTerm);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getUnitType", method = RequestMethod.POST)
	public Map<String, Object> getUnitType(int unitTypeId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getUnitType = tableSetupService.getUnitType(unitTypeId);
			responseObject.put("get unit types", getUnitType);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getUpsellSuggestion", method = RequestMethod.POST)
	public Map<String, Object> getUpsellSuggestion(int upsellSuggestionId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getUpsellSuggestion = tableSetupService.getUpsellSuggestion(upsellSuggestionId);
			responseObject.put("get getUpsellSuggestion ", getUpsellSuggestion);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getCalenderCampaign", method = RequestMethod.POST)
	public Map<String, Object> getCalenderCampaign(int calenderCampaignId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getCalenderCampaign = tableSetupService.getCalenderCampaign(calenderCampaignId);
			responseObject.put("get CalenderCampaign ", getCalenderCampaign);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveCommodityCode", method = RequestMethod.POST)
	public Map<String, Object> saveCommodityCode(TaxesModel taxesModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCommodityCode(taxesModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save commodity code: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateCommodityCode", method = RequestMethod.POST)

	public Map<String, Object> updateCommodityCode(TaxesModel taxesModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateCommodityCode(taxesModel);

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

	@RequestMapping(path = "/deleteCommodityCode", method = RequestMethod.POST)
	public Map<String, Object> deleteCommodityCode(int commodityCode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCommodityCode(commodityCode);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete commoditycode : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getCommodityCode", method = RequestMethod.POST)
	public Map<String, Object> getCommodityCode(int commodityCode) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getCommodityCode = tableSetupService.getCommodityCode(commodityCode);
			responseObject.put("commodityCodeDetails", getCommodityCode);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveJurisdiction", method = RequestMethod.POST)
	public Map<String, Object> saveJurisdiction(TaxesModel taxesModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveJurisdiction(taxesModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save  Jurisdiction: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateJurisdiction", method = RequestMethod.POST)

	public Map<String, Object> updateJurisdiction(TaxesModel taxesModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateJurisdiction(taxesModel);

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

	@RequestMapping(path = "/deleteJurisdiction", method = RequestMethod.POST)
	public Map<String, Object> deleteJurisdiction(String state, int jurisdictionSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteJurisdiction(state, jurisdictionSeq);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete Jurisdiction : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getJurisdiction", method = RequestMethod.POST)
	public Map<String, Object> getJurisdiction(String state) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getJurisdiction = tableSetupService.getJurisdiction(state);
			responseObject.put("getJurisdiction details ", getJurisdiction);
			List<DropdownModel> stateCodeList = tableSetupService.getStateCodeList(state);
			responseObject.put("stateCodeList", stateCodeList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/saveSpecialTax", method = RequestMethod.POST)
	public Map<String, Object> saveSpecialTax(TaxesModel taxesModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveSpecialTax(taxesModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save  special tax" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateSpecialTax", method = RequestMethod.POST)

	public Map<String, Object> updateSpecialTax(TaxesModel taxesModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateSpecialTax(taxesModel);

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

	@RequestMapping(path = "/deleteSpecialTax", method = RequestMethod.POST)
	public Map<String, Object> deleteSpecialTax(String specialTaxId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteSpecialTax(specialTaxId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete specialTx : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getSpecialTaxIds", method = RequestMethod.POST)
	public Map<String, Object> getSpecialTax(String specialTaxId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getSpecialTax = tableSetupService.getSpecialTax(specialTaxId);
			responseObject.put("SpecialTaxDetails", getSpecialTax);
			// List<DropdownModel> exemptStatus =
			// tableSetupService.getExemptStatus(specialTaxId);
			List<DropdownModel> exemptStatus = new ArrayList<>();
			exemptStatus.add(new DropdownModel("0", "NotTaxExempt", null, null, null, null));
			exemptStatus.add(new DropdownModel("1", "YesTaxExempt", null, null, null, null));
			exemptStatus.add(new DropdownModel("2", "AlwaysTaxExempt", null, null, null, null));
			responseObject.put("exemptList", exemptStatus);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveTaxHandling", method = RequestMethod.POST)
	public Map<String, Object> saveTaxHandling(TaxesModel taxesModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTaxHandling(taxesModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save TaxHandling: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateTaxHandling", method = RequestMethod.POST)

	public Map<String, Object> updateTaxHandling(TaxesModel taxesModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateTaxHandling(taxesModel);

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

	@RequestMapping(path = "/deleteTaxHandling", method = RequestMethod.POST)
	public Map<String, Object> deleteTaxHandling(String taxHandling) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTaxHandling(taxHandling);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete tax Handling");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getTaxHandling", method = RequestMethod.POST)
	public Map<String, Object> getTaxHandling(String taxHandling) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getTaxHandling = tableSetupService.getTaxHandling(taxHandling);
			responseObject.put("TaxHandlingDetails", getTaxHandling);
			// List<DropdownModel>
			// taxHandlingList=tableSetupService.getTaxHandlingList(taxHandling);

			List<DropdownModel> taxBasedList = new ArrayList<>();
			taxBasedList.add(new DropdownModel("0", "Bill to", null, null, null, null));
			taxBasedList.add(new DropdownModel("1", "recipient", null, null, null, null));
			responseObject.put("taxBasedList", taxBasedList);
			List<DropdownModel> taxPointList = new ArrayList<>();
			taxPointList.add(new DropdownModel("0", "On Order", null, null, null, null));
			taxPointList.add(new DropdownModel("1", "On Payment", null, null, null, null));
			taxPointList.add(new DropdownModel("2", "On Firm Invoice", null, null, null, null));
			responseObject.put("taxPointList", taxPointList);
			List<DropdownModel> taxDeliveryList = new ArrayList<>();
			taxDeliveryList.add(new DropdownModel("0", "NO", null, null, null, null));
			taxDeliveryList.add(new DropdownModel("1", "Yes", null, null, null, null));
			taxDeliveryList.add(new DropdownModel("2", "Dependent on underlyng Trans", null, null, null, null));
			responseObject.put("taxDeliveryList", taxDeliveryList);
			List<DropdownModel> conflictingTaxHandlerList = new ArrayList<>();
			conflictingTaxHandlerList.add(new DropdownModel("0", "do not charge tax", null, null, null, null));
			conflictingTaxHandlerList
					.add(new DropdownModel("1", "tax based on recipients stat", null, null, null, null));
			conflictingTaxHandlerList
					.add(new DropdownModel("2", "tax based on bills to state", null, null, null, null));
			responseObject.put("conflictingTaxHandlerList", conflictingTaxHandlerList);
			List<DropdownModel> printLocationHandlingList = new ArrayList<>();
			printLocationHandlingList
					.add(new DropdownModel("0", "Tax Based on bills to state", null, null, null, null));
			printLocationHandlingList
					.add(new DropdownModel("1", "Tax Based On Recipients if No", null, null, null, null));
			printLocationHandlingList
					.add(new DropdownModel("2", "Tax based On Recipient Regard", null, null, null, null));
			responseObject.put("printLocationHandlingList", printLocationHandlingList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveTaxRatesbyCountryandState", method = RequestMethod.POST)
	public Map<String, Object> saveTaxRatesbyCountryandState(TaxesModel taxesModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTaxRatesbyCountryandState(taxesModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveTaxRatesbyCountryandState: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateTaxRatesbyCountryandState", method = RequestMethod.POST)

	public Map<String, Object> updateTaxRatesbyCountryandState(TaxesModel taxesModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateTaxRatesbyCountryandState(taxesModel);

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

	@RequestMapping(path = "/deleteTaxRatesbyCountryandState", method = RequestMethod.POST)
	public Map<String, Object> deleteTaxRatesbyCountryandState(String state) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTaxRatesbyCountryandState(state);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete taxRatesby country and state");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getTaxRatesbyCountryandState", method = RequestMethod.POST)
	public Map<String, Object> getTaxRatesbyCountryandState(String state) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> taxRatesbyCountryandState = tableSetupService.getTaxRatesbyCountryandState(state);
			responseObject.put("TaxRatesbyCountryandStateDetails", taxRatesbyCountryandState);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveTaxRateCategories", method = RequestMethod.POST)
	public Map<String, Object> saveTaxRateCategories(TaxesModel taxesModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTaxRateCategories(taxesModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save TaxRateCategories: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateTaxRateCategories", method = RequestMethod.POST)

	public Map<String, Object> updateTaxRateCategories(TaxesModel taxesModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateTaxRateCategories(taxesModel);

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

	@RequestMapping(path = "/deleteTaxRateCategories", method = RequestMethod.POST)
	public Map<String, Object> deleteTaxRateCategories(String taxRateCategory) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTaxRateCategories(taxRateCategory);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete TaxRateCategories");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getTaxRateCategories", method = RequestMethod.POST)
	public Map<String, Object> getTaxRateCategories(String taxRateCategory) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getTaxRateCategories = tableSetupService.getTaxRateCategories(taxRateCategory);
			responseObject.put("taxRateCategories", getTaxRateCategories);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveTaxTypes", method = RequestMethod.POST)
	public Map<String, Object> saveTaxTypes(TaxesModel taxesModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTaxTypes(taxesModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save tax types: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateTaxTypes", method = RequestMethod.POST)

	public Map<String, Object> updateTaxTypes(TaxesModel taxesModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateTaxTypes(taxesModel);

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

	@RequestMapping(path = "/deleteTaxTypes", method = RequestMethod.POST)
	public Map<String, Object> deleteTaxTypes(String taxType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTaxTypes(taxType);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteTaxTypes");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getTaxTypes", method = RequestMethod.POST)
	public Map<String, Object> getTaxTypes(String taxType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getTaxTypes = tableSetupService.getTaxTypes(taxType);
			responseObject.put("taxTypes", getTaxTypes);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveAddresses", method = RequestMethod.POST)
	public Map<String, Object> saveAddresses(InternationalModel internationalModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveAddresses(internationalModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save address: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateAddresses", method = RequestMethod.POST)

	public Map<String, Object> updateAddresses(InternationalModel internationalModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateAddresses(internationalModel);

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

	@RequestMapping(path = "/deleteAddresses", method = RequestMethod.POST)
	public Map<String, Object> deleteAddresses(int addressId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteAddresses(addressId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete address");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getAddresses", method = RequestMethod.POST)
	public Map<String, Object> getAddress(int addressId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getAddressDetails = tableSetupService.getAddress(addressId);
			responseObject.put("addressDetails", getAddressDetails);
			List<DropdownModel> stateList = tableSetupService.getStateList();
			responseObject.put("stateList", stateList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveAddressCleaning", method = RequestMethod.POST)
	public Map<String, Object> saveAddressCleaning(InternationalModel internationalModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveAddressCleaning(internationalModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save address cleaning: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateAddressCleaning", method = RequestMethod.POST)

	public Map<String, Object> updateAddressCleaning(InternationalModel internationalModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateAddressCleaning(internationalModel);

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

	@RequestMapping(path = "/deleteAddressCleaning", method = RequestMethod.POST)
	public Map<String, Object> deleteAddressCleaning(int iapDatasetDefId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteAddressCleaning(iapDatasetDefId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete address cleaning");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getAddressCleaning", method = RequestMethod.POST)
	public Map<String, Object> getAddressCleaning(int iapDatasetDefId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getAddressCleaningDetails = tableSetupService.getAddressCleaning(iapDatasetDefId);
			responseObject.put("addressCleaningDetails", getAddressCleaningDetails);

			List<DropdownModel> progIdList = tableSetupService.getProgIdList();
			responseObject.put("progIdList", progIdList);

			List<Map<String, Object>> getIapNameValueDetails = tableSetupService.getIapNameValue(iapDatasetDefId);
			responseObject.put("IapNameValueDetails", getIapNameValueDetails);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveCountryCode", method = RequestMethod.POST)
	public Map<String, Object> saveCountryCode(InternationalModel internationalModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCountryCode(internationalModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save country code: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateCountryCode", method = RequestMethod.POST)

	public Map<String, Object> updateCountryCode(InternationalModel internationalModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateCountryCode(internationalModel);

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

	@RequestMapping(path = "/deleteCountryCode", method = RequestMethod.POST)
	public Map<String, Object> deleteCountryCode(String countryCode2) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCountryCode(countryCode2);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete country");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getCountryCode", method = RequestMethod.POST)
	public Map<String, Object> getCountryCode() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> getCountryCodeDetails = tableSetupService.getCountryCode();
			responseObject.put("getCountryCode", getCountryCodeDetails);

			List<DropdownModel> fileCurrencyList = tableSetupService.getFileCurrencyList();
			responseObject.put("fileCurrencyList", fileCurrencyList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveCountriesandStates", method = RequestMethod.POST)
	public Map<String, Object> saveCountriesandStates(InternationalModel internationalModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCountriesandStates(internationalModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save countries and states: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateCountriesandStates", method = RequestMethod.POST)

	public Map<String, Object> updateCountriesandStates(InternationalModel internationalModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateCountriesandStates(internationalModel);

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

	@RequestMapping(path = "/deleteCountriesandStates", method = RequestMethod.POST)
	public Map<String, Object> deleteCountriesandStates(String state) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCountriesandStates(state);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete countries and states");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getCountriesandStates", method = RequestMethod.POST)
	public Map<String, Object> getCountriesandStates(String state) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> CountriesandStatesDetails = tableSetupService.getCountriesandStates(state);
			responseObject.put("CountriesandStatesDetails", CountriesandStatesDetails);
			List<DropdownModel> currencyList = tableSetupService.getCurrencyList();
			responseObject.put("currencyList", currencyList);
			List<DropdownModel> countryCodeList = tableSetupService.getCountryCodeList();
			responseObject.put("countryCodeList", countryCodeList);
			List<DropdownModel> labelFormatList = tableSetupService.getLabelFormatList();
			responseObject.put("labelFormatList", labelFormatList);
			List<DropdownModel> addressCheckingList = tableSetupService.getaddressCheckingList();
			responseObject.put("addressCheckingList", addressCheckingList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveCurrencies", method = RequestMethod.POST)
	public Map<String, Object> saveCurrencies(InternationalModel internationalModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveCurrencies(internationalModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save Currencies: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateCurrencies", method = RequestMethod.POST)

	public Map<String, Object> updateCurrencies(InternationalModel internationalModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateCurrencies(internationalModel);

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

	@RequestMapping(path = "/deleteCurrencies", method = RequestMethod.POST)
	public Map<String, Object> deleteCurrencies(String currency) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteCurrencies(currency);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete Currencies");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getCurrencies", method = RequestMethod.POST)
	public Map<String, Object> getCurrencies(String currency) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> currenciesDetails = tableSetupService.getCurrencies(currency);
			responseObject.put("currenciesDetails", currenciesDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveLanguageCodes", method = RequestMethod.POST)
	public Map<String, Object> saveLanguageCodes(InternationalModel internationalModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveLanguageCodes(internationalModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save Language Codes: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateLanguageCodes", method = RequestMethod.POST)
	public Map<String, Object> updateLanguageCodes(InternationalModel internationalModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateLanguageCodes(internationalModel);

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

	@RequestMapping(path = "/deleteLanguageCodes", method = RequestMethod.POST)
	public Map<String, Object> deleteLanguageCodes(String languageCode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteLanguageCodes(languageCode);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete LanguageCodes");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getLanguageCodes", method = RequestMethod.POST)
	public Map<String, Object> getLanguageCodes(String languageCode) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> LanguageCodesDetails = tableSetupService.getLanguageCodes(languageCode);
			responseObject.put("LanguageCodesDetails", LanguageCodesDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveRegions", method = RequestMethod.POST)
	public Map<String, Object> saveRegions(InternationalModel internationalModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveRegions(internationalModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save regions: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateRegions", method = RequestMethod.POST)
	public Map<String, Object> updateRegions(InternationalModel internationalModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateRegions(internationalModel);

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

	@RequestMapping(path = "/deleteRegions", method = RequestMethod.POST)
	public Map<String, Object> deleteRegions(String regionList) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteRegions(regionList);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete regions");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getRegions", method = RequestMethod.POST)
	public Map<String, Object> getRegions(String regionList) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> regionsDetails = tableSetupService.getRegions(regionList);
			responseObject.put("regionsDetails ", regionsDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/addressStatusDetails", method = RequestMethod.POST)
	public Map<String, Object> getAddressStatusDetails(String addressStatus) {
		List<Map<String, Object>> addressDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			addressDetails = tableSetupService.getAddressStatusDetails(addressStatus);
			responseObject.put("addressDetails", addressDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addressStatusDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/addressTypeDetails", method = RequestMethod.POST)
	public Map<String, Object> getAddressTypeDetails(String addressType) {
		List<Map<String, Object>> addressTypeDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			addressTypeDetails = tableSetupService.getAddressTypeDetails(addressType);
			responseObject.put("addressTypeDetails", addressTypeDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addressTypeDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/attachmentCatagoryDetails", method = RequestMethod.POST)
	public Map<String, Object> getAttachmentCatagoryDetails(String attachmentCatagory) {
		List<Map<String, Object>> attachmentCatagoryDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			attachmentCatagoryDetails = tableSetupService.getAttachmentCatagoryDetails(attachmentCatagory);
			responseObject.put("attachmentCatagoryDetails", attachmentCatagoryDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in attachmentCatagoryDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/auxFieldDetails", method = RequestMethod.POST)
	public Map<String, Object> getAuxFieldDetails(String tableName) {
		List<Map<String, Object>> auxFieldDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			auxFieldDetails = tableSetupService.getAuxFieldDetails(tableName);
			responseObject.put("auxFieldDetails", auxFieldDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in auxFieldDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/creditStatusDetails", method = RequestMethod.POST)
	public Map<String, Object> getCreditStatusDetails(String creditStatus) {
		List<Map<String, Object>> creditStatusDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			creditStatusDetails = tableSetupService.getCreditStatusDetails(creditStatus);
			responseObject.put("creditStatusDetails", creditStatusDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in creditStatusDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/retalCategoryDetails", method = RequestMethod.POST)
	public Map<String, Object> getRentalCategoryDetails(String listRentalCategory) {
		List<Map<String, Object>> rentalCategoryDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			rentalCategoryDetails = tableSetupService.getRentalCategoryDetails(listRentalCategory);
			responseObject.put("rentalCategoryDetails", rentalCategoryDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in retalCategoryDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/customerCategoryDetails", method = RequestMethod.POST)
	public Map<String, Object> getCustomerCategoryDetails(String customerCategory) {
		List<Map<String, Object>> customerCategoryDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			customerCategoryDetails = tableSetupService.getCustomerCategoryDetails(customerCategory);
			responseObject.put("customerCategoryDetails", customerCategoryDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in customerCategoryDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/loginQuestionDetails", method = RequestMethod.POST)
	public Map<String, Object> getLoginQuestionDetails(int customerLoginQuestionId) {
		List<Map<String, Object>> loginQuestionDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			loginQuestionDetails = tableSetupService.getLoginQuestionDetails(customerLoginQuestionId);
			responseObject.put("loginQuestionDetails", loginQuestionDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in loginQuestionDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/addDispContext", method = RequestMethod.POST)
	public Map<String, Object> dispcontext() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> dispContext = new ArrayList<>();
		// List<DropdownModel> followOnServicePage=new ArrayList<>();

		try {
			dispContext = tableSetupService.getDispContext();
			responseObject.put("dispContext", dispContext);
			// followOnServicePage=tableSetupService.getFollowOnServicePage();
			// responseObject.put("followOnServicePage",followOnServicePage);
			responseObject.put(STATUS, SUCCESS);
		} catch (Exception e) {
			LOGGER.info("error in addDispContext : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/addColumnValue", method = RequestMethod.POST)
	public Map<String, Object> columnValue() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> columnValue = new ArrayList<>();

		try {
			columnValue = tableSetupService.getColumnName();
			responseObject.put("columnValue", columnValue);
			responseObject.put(STATUS, SUCCESS);
		} catch (Exception e) {
			LOGGER.info("error in addColumnValue : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/addUseNextSegment", method = RequestMethod.POST)
	public Map<String, Object> useNextSegment() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> useNextSegment = new ArrayList<>();

		try {
			useNextSegment = tableSetupService.getUseNextSegment();
			responseObject.put("useNextSegment", useNextSegment);
			responseObject.put(STATUS, SUCCESS);
		} catch (Exception e) {
			LOGGER.info("error in addUseNextSegment : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/prospectCategoryDetails", method = RequestMethod.POST)
	public Map<String, Object> getProspectCategoryDetails(String prospectCategory) {
		List<Map<String, Object>> prospectCategoryDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			prospectCategoryDetails = tableSetupService.getProspectCategoryDetails(prospectCategory);
			responseObject.put("prospectCategoryDetails", prospectCategoryDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in prospectCategoryDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/saleRepresentativeDetails", method = RequestMethod.POST)
	public Map<String, Object> getsalesRepresentativeDetails(int salesRepresentativeId) {
		List<Map<String, Object>> salesRepresentativeDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			salesRepresentativeDetails = tableSetupService.getsalesRepresentativeDetails(salesRepresentativeId);
			responseObject.put("salesRepresentativeDetails", salesRepresentativeDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in getsalesRepresentativeDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

		return responseObject;
	}

	@RequestMapping(path = "/paymentsThresholdDetails", method = RequestMethod.POST)
	public Map<String, Object> paymentThresholdDetails(String paymentThreshold) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> paymentThresholdDetails = new ArrayList<>();
		try {
			paymentThresholdDetails = tableSetupService.getPaymentThresholdDetails(paymentThreshold);
			responseObject.put("paymentThresholdDetails", paymentThresholdDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in paymentsThresholdDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/paymentsTypeDetails", method = RequestMethod.POST)
	public Map<String, Object> paymentTypeDetails(String paymentType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> paymentTypeDetails = new ArrayList<>();
		try {
			paymentTypeDetails = tableSetupService.getPaymentTypeDetails(paymentType);
			responseObject.put("paymentTypeDetails", paymentTypeDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in paymentsTypeDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/addPaymentForm", method = RequestMethod.POST)
	public Map<String, Object> paymentForm() {
		List<DropdownModel> paymentForm = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			paymentForm = tableSetupService.getPaymentForm();
			responseObject.put("paymentForm", paymentForm);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addPaymentForm : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/addRealizeCashWhen", method = RequestMethod.POST)
	public Map<String, Object> realizeCashWhen() {
		List<DropdownModel> realizeCashwhen = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			realizeCashwhen = tableSetupService.getRealizeCashwhen();
			responseObject.put("realizeCashwhen", realizeCashwhen);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addRealizeCashWhen : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/addCreditCardType", method = RequestMethod.POST)
	public Map<String, Object> creditCardtype() {
		List<DropdownModel> creditCardType = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			creditCardType = tableSetupService.getCreditCardType();
			responseObject.put("creditCardType", creditCardType);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addCreditCardType : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/addCardVerificationUsage", method = RequestMethod.POST)
	public Map<String, Object> cardVerificationUsage() {
		List<DropdownModel> cardVerificationusage = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			cardVerificationusage = tableSetupService.getCardVerificationusage();
			responseObject.put("cardVerificationusage", cardVerificationusage);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addCardVerificationUsage : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/transactionReasonDetails", method = RequestMethod.POST)
	public Map<String, Object> transReasonDetails(String transactionReason) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> transReasonDetails = new ArrayList<>();
		try {
			transReasonDetails = tableSetupService.getTransreasonDetails(transactionReason);
			responseObject.put("transReasonDetails", transReasonDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in transactionReasonDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/addTransactionReasonType", method = RequestMethod.POST)
	public Map<String, Object> transReasonType() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> transReasonDetails = new ArrayList<>();
		try {
			transReasonDetails = tableSetupService.getTransreasonReasonType();
			responseObject.put("transReasonDetails", transReasonDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addTransactionReasonType : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	// for defaultSettings

	@RequestMapping(path = "/defaultCustomersdetails", method = RequestMethod.POST)
	public Map<String, Object> getcustomerDetails(String currency) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> delivaryMethod = new ArrayList<>();
		List<DropdownModel> regionList = new ArrayList<>();
		List<DropdownModel> shippingPriceList = new ArrayList<>();
		List<DropdownModel> cancellationRenewal = new ArrayList<>();
		List<DropdownModel> addressType = new ArrayList<>();
		List<DropdownModel> addressStatus = new ArrayList<>();
		List<DropdownModel> rentalCategory = new ArrayList<>();
		List<Map<String, Object>> customerDetails = new ArrayList<>();

		try {
			delivaryMethod = tableSetupService.getDelivaryMethod();
			responseObject.put("delivaryMethod", delivaryMethod);
			regionList = tableSetupService.getRegionList();
			responseObject.put("regionList", regionList);
			shippingPriceList = tableSetupService.getShippingPriceList();
			responseObject.put("shippingPriceList", shippingPriceList);
			cancellationRenewal = tableSetupService.getCancellationRenewal();
			responseObject.put("cancellationRenewal", cancellationRenewal);
			addressType = tableSetupService.getAddressType();
			responseObject.put("addressType", addressType);
			addressStatus = tableSetupService.getAddressStatus();
			responseObject.put("addressStatus", addressStatus);
			rentalCategory = tableSetupService.getRentalCategory();
			responseObject.put("rentalCategory", rentalCategory);

			customerDetails = tableSetupService.getCustomersDetails(currency);
			responseObject.put("customerDetails", customerDetails);

			responseObject.put(STATUS, SUCCESS);
		} catch (Exception e) {
			LOGGER.info("error in defaultCustomersdetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/defaultCustomerUpadate", method = RequestMethod.POST)
	public Map<String, Object> updateDefaultCustomerUpdate(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateDefaultCustomerUpdate(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in defaultCustomerUpadate : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/documentReferenceDetails", method = RequestMethod.POST)
	public Map<String, Object> getDocumentReference(String bypassDocRefdlg) {
		List<Map<String, Object>> documentRefDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> operator = new ArrayList<>();
		List<DropdownModel> assignedto = new ArrayList<>();
		List<DropdownModel> batchTemplate = new ArrayList<>();
		try {
			if (bypassDocRefdlg.equals("1")) {
				operator = tableSetupService.getOperatorDetails();
				responseObject.put("operator", operator);
				assignedto = tableSetupService.getOperatorDetails();
				responseObject.put("assignedto", assignedto);
				batchTemplate = tableSetupService.getbacthTemplateDetails();
				responseObject.put("batchTemplate", batchTemplate);
				documentRefDetails = tableSetupService.getDocumentReferenceDetails();
				responseObject.put("documentRefDetails", documentRefDetails);
			}

			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in documentReferenceDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;

	}

	@RequestMapping(path = "/addType", method = RequestMethod.POST)
	public Map<String, Object> type() {
		List<DropdownModel> type = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			type = tableSetupService.getType();
			responseObject.put("type", type);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addType : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/documentReferenceSave", method = RequestMethod.POST)
	public Map<String, Object> saveDocumentReference(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> operator = new ArrayList<>();
		int status = 0;
		try {
			operator = tableSetupService.getOperatorDetails();
			responseObject.put("operator", operator);

			status = tableSetupService.saveDocumentReference(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in documentReferenceSave : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/documentReferenceEdit", method = RequestMethod.POST)
	public Map<String, Object> updateDocumentReference(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateDocumentReference(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in documentReferenceEdit : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/editTrailSave", method = RequestMethod.POST)
	public Map<String, Object> saveEditTrail(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveEditTrail(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveEditTrail : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/batchDetails", method = RequestMethod.POST)
	public Map<String, Object> getbatchDetails(int documentReferenceId) {
		List<Map<String, Object>> batchDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			batchDetails = tableSetupService.getEditTrailDetails(documentReferenceId);
			responseObject.put("batchDetails", batchDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in batchDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/editTrailDetails", method = RequestMethod.POST)
	public Map<String, Object> getEdDetails(int documentReferenceId) {
		List<Map<String, Object>> editTrailDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			editTrailDetails = tableSetupService.getEditTrail(documentReferenceId);
			responseObject.put("editTrailDetails", editTrailDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in editTrailDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/payBreakDetails", method = RequestMethod.POST)
	public Map<String, Object> getPaymentBreakdownDetails(int paymentSeq, int customerId) {
		List<Map<String, Object>> paytBreakDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			paytBreakDetails = tableSetupService.getPaymentBreakdown(paymentSeq, customerId);
			responseObject.put("paytBreakDetails", paytBreakDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in payBreakDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/addGroups", method = RequestMethod.POST)
	public Map<String, Object> shipType() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> shipType = new ArrayList<>();
		List<DropdownModel> backIssueShipType = new ArrayList<>();
		List<DropdownModel> newMemberOptions = new ArrayList<>();
		try {
			shipType = tableSetupService.getShipType();
			responseObject.put("shipType", shipType);
			backIssueShipType = tableSetupService.getBackIssueShipType();
			responseObject.put("backIssueShipType", backIssueShipType);
			newMemberOptions = tableSetupService.getNewmemberOptions();
			responseObject.put("newMemberOptions", newMemberOptions);

			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addGroups : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/accountingDetails", method = RequestMethod.POST)
	public Map<String, Object> getAccountingDetails(String currency) {
		List<Map<String, Object>> accountingDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			accountingDetails = tableSetupService.getAccountingDetails(currency);
			responseObject.put("accountingDetails", accountingDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in accountingDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/accountingUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateAccounting(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateAccounting(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in accountingUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/paymentsDetails", method = RequestMethod.POST)
	public Map<String, Object> getpaymentsDetails(String paymentType, String purposeCode, String currency) {
		List<DropdownModel> paymentThreshold = new ArrayList<>();
		List<DropdownModel> defaultPayType = new ArrayList<>();
		List<DropdownModel> refundPaytype = new ArrayList<>();
		List<DropdownModel> holdForPayment = new ArrayList<>();
		List<DropdownModel> regionList = new ArrayList<>();
		List<DropdownModel> encryptorCOM = new ArrayList<>();
		List<Map<String, Object>> paymentDetails = new ArrayList<>();

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			paymentDetails = tableSetupService.getPaymentDetails(currency);
			responseObject.put("paymentDetails", paymentDetails);

			paymentThreshold = tableSetupService.getPaymentThreshold();
			responseObject.put("paymentThreshold", paymentThreshold);
			defaultPayType = tableSetupService.getDefaultPayType();
			responseObject.put("defaultPayType", defaultPayType);
			refundPaytype = tableSetupService.getRefundPaytype(paymentType);
			responseObject.put("refundPaytype", refundPaytype);
			holdForPayment = tableSetupService.getHoldForPayment();
			responseObject.put("holdForPayment", holdForPayment);
			regionList = tableSetupService.getRegionList();
			responseObject.put("regionList", regionList);
			encryptorCOM = tableSetupService.getEncryptorCOM(purposeCode);
			responseObject.put("encryptorCOM", encryptorCOM);

			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in paymentsDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;
	}

	@RequestMapping(path = "/defaultPaymentUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateDefaultPayment(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateDefaultPayment(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in defaultPaymentUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/taxDetails", method = RequestMethod.POST)
	public Map<String, Object> getTaxInformation(@RequestParam(value = "active") String active,
			DefaultSettings defaultSettings) {
		List<Map<String, Object>> legalEntityDetails = new ArrayList<>();
		List<Map<String, Object>> checkDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> regionList = new ArrayList<>();
		List<DropdownModel> shiptoRegion = new ArrayList<>();
		List<DropdownModel> billtoRegion = new ArrayList<>();
		try {
			if (active.equals("1")) {
				regionList = tableSetupService.getRegionList();
				responseObject.put("regionList", regionList);

				legalEntityDetails = tableSetupService.getLegalEntityDetails();
				responseObject.put("legalEntityDetails", legalEntityDetails);

				shiptoRegion = tableSetupService.getShiptoRegion();
				responseObject.put("shiptoRegion", shiptoRegion);

				billtoRegion = tableSetupService.getShiptoRegion();
				responseObject.put("billtoRegion", billtoRegion);

				checkDetails = tableSetupService.getCheckValues();
				responseObject.put("checkDetails", checkDetails);

			}
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in taxDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;
	}

	@RequestMapping(path = "/taxLegalEntitysave", method = RequestMethod.POST)
	public Map<String, Object> saveTaxLegalEntity(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			status = tableSetupService.legalEntitySave(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in taxLegalEntitysave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/taxEntityDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteTaxLegalEntity(String region) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			status = tableSetupService.deleteTaxLegalEntity(region);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in taxEntityDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/taxLegalEntityUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateTaxLegalEntity(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			if (defaultSettings.getEnableVrtxTax().equals("1")) {
				status = tableSetupService.updateTax(defaultSettings);
				status = tableSetupService.updateTaxDef(defaultSettings);
				if (status != 0) {
					responseObject.put(STATUS, true);
				} else {
					responseObject.put(STATUS, false);

				}
			} else {
				status = tableSetupService.updateTaxDef(defaultSettings);
				if (status != 0) {
					responseObject.put(STATUS, true);
				} else {
					responseObject.put(STATUS, false);
				}
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in taxLegalEntitysave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/legalEntitysave", method = RequestMethod.POST)
	public Map<String, Object> saveLegalEntity(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			status = tableSetupService.saveLegalEntity(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in legalEntitysave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/legalEntityUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateLegalEntity(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			status = tableSetupService.updateLegalEntity(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in legalEntityUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/legalEntityDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteLegalEntity(int vrtxLegalEntityId, String shiptoRegion) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			status = tableSetupService.deleteLegalEntity(vrtxLegalEntityId, shiptoRegion);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in legalEntityDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/EntityDetails", method = RequestMethod.POST)
	public Map<String, Object> getEntityDetails(int vrtxLegalEntityId) {
		List<Map<String, Object>> legalEntityDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> administrativeAddress = new ArrayList<>();
		List<DropdownModel> shiptoAddress = new ArrayList<>();
		try {
			legalEntityDetails = tableSetupService.getEntityDetails(vrtxLegalEntityId);
			responseObject.put("legalEntityDetails", legalEntityDetails);

			administrativeAddress = tableSetupService.getAdministrativeAddress();
			responseObject.put("administrativeAddress", administrativeAddress);

			shiptoAddress = tableSetupService.getAdministrativeAddress();
			responseObject.put("shiptoAddress", shiptoAddress);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in legalEntityDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/defaultInventoryDetails", method = RequestMethod.POST)
	public Map<String, Object> inventoryDetails(String currency) {
		List<Map<String, Object>> inventoryDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			inventoryDetails = tableSetupService.getInventoryDetails(currency);
			responseObject.put("inventoryDetails", inventoryDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in defaultInventoryDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultInventoryUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateInventory(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			status = tableSetupService.updateInventory(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in defaultInventoryUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultInternateDetails", method = RequestMethod.POST)
	public Map<String, Object> internateDetails(String currency) {
		List<Map<String, Object>> internateDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> MatchCode = new ArrayList<>();
		List<DropdownModel> prospectCategory = new ArrayList<>();
		try {
			MatchCode = tableSetupService.getMatchCode();
			responseObject.put("MatchCode", MatchCode);

			prospectCategory = tableSetupService.getProspectCategory();
			responseObject.put("prospectCategory", prospectCategory);

			internateDetails = tableSetupService.getInternetDetails(currency);
			responseObject.put("internateDetails", internateDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in defaultInternateDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultInternetSave", method = RequestMethod.POST)
	public Map<String, Object> saveInternet(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			if (defaultSettings.getType().equals("4"))
				status = tableSetupService.saveInternet(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in defaultInternetUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/internetUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateInternet(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> operator = new ArrayList<>();
		int status;
		try {
			operator = tableSetupService.getOperatorDetails();
			responseObject.put("operator", operator);
			status = tableSetupService.updateInternet(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in internetUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultInternetUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateDefaultInternet(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {

			status = tableSetupService.updateDefaultInternet(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in defaultInternetUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultLicenseCodeDetails", method = RequestMethod.POST)
	public Map<String, Object> licenseCodeDetails(String lincenseCode) {
		List<Map<String, Object>> licenseCodeDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			licenseCodeDetails = tableSetupService.getLicenseCodeDetails(lincenseCode);
			responseObject.put("licenseCodeDetails", licenseCodeDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in defaultLicenseCodeDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultCustomFieldDetails", method = RequestMethod.POST)
	public Map<String, Object> customField(String currency) {
		List<Map<String, Object>> customFieldDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			customFieldDetails = tableSetupService.getCustomFieldDetails(currency);
			responseObject.put("customFieldDetails", customFieldDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in defaultInventoryDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultCustomFieldUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateCustomFields(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			status = tableSetupService.updateCustomFields(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in defaultCustomFieldUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultProcessingDetails", method = RequestMethod.POST)
	public Map<String, Object> processingDetails(String currency) {
		List<Map<String, Object>> processingDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> lableGroup = new ArrayList<>();
		List<DropdownModel> lableFormate = new ArrayList<>();
		try {
			lableGroup = tableSetupService.getLableGroup();
			responseObject.put("lableGroup", lableGroup);

			lableFormate = tableSetupService.getLableFormate();
			responseObject.put("lableFormate", lableFormate);

			processingDetails = tableSetupService.getProcessingDetails(currency);
			responseObject.put("processingDetails", processingDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in defaultProcessingDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultProcessingUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateProcessing(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status;
		try {
			status = tableSetupService.updateProcessing(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in defaultProcessingUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/saveDeliveryMethods", method = RequestMethod.POST)
	public Map<String, Object> saveDeliveryMethods(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveDeliveryMethods(shippingDeliveryandDistributionModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save delivery methods: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateDeliveryMethods", method = RequestMethod.POST)
	public Map<String, Object> updateDeliveryMethods(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = tableSetupService.updateDeliveryMethods(shippingDeliveryandDistributionModel);

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

	@RequestMapping(path = "/deleteDeliveryMethods", method = RequestMethod.POST)
	public Map<String, Object> deleteDeliveryMethods(String deliveryMethod) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteDeliveryMethods(deliveryMethod);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete Delivery methods");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getDeliveryMethods", method = RequestMethod.POST)
	public Map<String, Object> getDeliveryMethods(String deliveryMethod) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> deliveryMethodDetails = tableSetupService.getDeliveryMethods(deliveryMethod);
			responseObject.put("deliveryMethodDetails", deliveryMethodDetails);
			responseObject.put("regionList", tableSetupService.getRegionList());
			responseObject.put("currencyList", tableSetupService.getCurrencyList());
			List<DropdownModel> orderClassList = tableSetupService.getOrderClassList();
			responseObject.put("orderClassList", orderClassList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getSetupDefaltDeliveryMethods", method = RequestMethod.POST)
	public Map<String, Object> getSetupDefaltDeliveryMethods() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			// List<Map<String, Object>> setupDefaltDeliveryMethodsDetails =
			// tableSetupService.setupDefaltDeliveryMethodsDetails();
			// responseObject.put("setupDefaltDeliveryMethodsDetails",setupDefaltDeliveryMethodsDetails);
			List<DropdownModel> deliveryMethodList = tableSetupService.getDeliveryMethodList();
			responseObject.put("deliveryMethodList", deliveryMethodList);
			responseObject.put("regionList", tableSetupService.getRegionList());
			responseObject.put("countryandStateList", tableSetupService.getStateList());
			responseObject.put("orderClassList", tableSetupService.getOrderClassList());

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveDistributionMethods", method = RequestMethod.POST)
	public Map<String, Object> saveDistributionMethods(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveDistributionMethods(shippingDeliveryandDistributionModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save distribution methods: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateDistributionMethods", method = RequestMethod.POST)
	public Map<String, Object> updateDistributionMethods(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateDistributionMethods(shippingDeliveryandDistributionModel);

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

	@RequestMapping(path = "/deleteDistributionMethods", method = RequestMethod.POST)
	public Map<String, Object> deleteDistributionMethods(String distributionMethod, String distributionAttribute) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteDistributionMethods(distributionMethod, distributionAttribute);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete distribution methods");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getDistributionMethods", method = RequestMethod.POST)
	public Map<String, Object> getDistributionMethods(String distributionMethod, String distributionAttribute) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> distributionMethoDetails = tableSetupService
					.getDistributionMethods(distributionMethod, distributionAttribute);
			responseObject.put("distributionMethoDetails", distributionMethoDetails);
			List<DropdownModel> regionList = tableSetupService.getDistRegionList();
			responseObject.put("regionList", regionList);
			List<DropdownModel> distAttributeList = tableSetupService.getDistAttributeList();
			responseObject.put("distAttributeList", distAttributeList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveAssignDistributionCriteria", method = RequestMethod.POST)
	public Map<String, Object> saveAssignDistributionCriteria(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveAssignDistributionCriteria(shippingDeliveryandDistributionModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save assign distribution criteria: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateAssignDistributionCriteria", method = RequestMethod.POST)
	public Map<String, Object> updateAssignDistributionCriteria(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateAssignDistributionCriteria(shippingDeliveryandDistributionModel);

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

	@RequestMapping(path = "/deleteAssignDistributionCriteria", method = RequestMethod.POST)
	public Map<String, Object> deleteAssignDistributionCriteria(String distributionMethod, int distMethodDefaultSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteAssignDistributionCriteria(distributionMethod, distMethodDefaultSeq);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete Assign Distribution Criteria");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getAssignDistributionCriteria", method = RequestMethod.POST)
	public Map<String, Object> getAssignDistributionCriteria(String distributionMethod, int distMethodDefaultSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> distributionMethoDetails = tableSetupService
					.getAssignDistributionCriteria(distributionMethod, distMethodDefaultSeq);
			responseObject.put("distributionMethoDetails", distributionMethoDetails);
			List<DropdownModel> region = tableSetupService.regionList();
			responseObject.put("regionList", region);
			responseObject.put("stateList", tableSetupService.getStateList());
			List<DropdownModel> attributeList = tableSetupService.attributeList();
			responseObject.put("attributeList", attributeList);
			List<DropdownModel> attributeValue = tableSetupService.attributeValue();
			responseObject.put("attributeValue", attributeValue);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveSetUpDistributionAttributes", method = RequestMethod.POST)
	public Map<String, Object> saveSetUpDistributionAttributes(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveSetUpDistributionAttributes(shippingDeliveryandDistributionModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save SetUp Distribution Attributes: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateSetUpDistributionAttributes", method = RequestMethod.POST)
	public Map<String, Object> updateSetUpDistributionAttributes(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateSetUpDistributionAttributes(shippingDeliveryandDistributionModel);

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

	@RequestMapping(path = "/deleteSetUpDistributionAttributes", method = RequestMethod.POST)
	public Map<String, Object> deleteSetUpDistributionAttributes(String distributionAttribute,
			String distAttributeValue) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteSetUpDistributionAttributes(distributionAttribute, distAttributeValue);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete setUp distribution attributes");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getSetUpDistributionAttributes", method = RequestMethod.POST)
	public Map<String, Object> getSetUpDistributionAttributes(String distributionAttribute, String distAttributeValue) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> setUpDistributionAttributesDetails = tableSetupService
					.getSetUpDistributionAttributes(distributionAttribute, distAttributeValue);
			responseObject.put("setUpDistributionAttributesDetails", setUpDistributionAttributesDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveShippingandHandlingMethods", method = RequestMethod.POST)
	public Map<String, Object> saveShippingandHandlingMethods(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveShippingandHandlingMethods(shippingDeliveryandDistributionModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save shipping and handling methods: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateShippingandHandlingMethods", method = RequestMethod.POST)
	public Map<String, Object> updateShippingandHandlingMethods(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateShippingandHandlingMethods(shippingDeliveryandDistributionModel);

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

	@RequestMapping(path = "/deleteShippingandHandlingMethods", method = RequestMethod.POST)
	public Map<String, Object> deleteShippingandHandlingMethods(String shippingMethod) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteShippingandHandlingMethods(shippingMethod);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete shipping and handling  methods");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getShippingandHandlingMethods", method = RequestMethod.POST)
	public Map<String, Object> getShippingandHandlingMethods(String shippingMethod) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> shippingandHandlingDetails = tableSetupService
					.getShippingandHandlingMethods(shippingMethod);
			responseObject.put("shippingandHandlingDetails", shippingandHandlingDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveShippingPriceList", method = RequestMethod.POST)
	public Map<String, Object> saveShippingPriceList(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveShippingPriceList(shippingDeliveryandDistributionModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save shipping pricelist: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateShippingPriceList", method = RequestMethod.POST)
	public Map<String, Object> updateShippingPriceList(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateShippingPriceList(shippingDeliveryandDistributionModel);

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

	@RequestMapping(path = "/deleteShippingPriceList", method = RequestMethod.POST)
	public Map<String, Object> deleteShippingPriceList(String shippingPriceList) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteShippingPriceList(shippingPriceList);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete shippping price list");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getShippingPriceList", method = RequestMethod.POST)
	public Map<String, Object> getShippingPriceList(String shippingPriceList) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> shippingPriceListDetails = tableSetupService
					.getShippingPriceList(shippingPriceList);
			responseObject.put("shippingPriceListDetails", shippingPriceListDetails);
			List<DropdownModel> shippingMethodList = tableSetupService.getShippingMethodList();
			responseObject.put("shippingMethodList", shippingMethodList);
			responseObject.put("regionList", tableSetupService.getDistRegionList());
			List<DropdownModel> regionList = tableSetupService.getRegion();
			responseObject.put("regionList", regionList);
			responseObject.put("currencyList", tableSetupService.getCurrencyList());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveMailingEntryPoint", method = RequestMethod.POST)
	public Map<String, Object> saveMailingEntryPoint(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveMailingEntryPoint(shippingDeliveryandDistributionModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save mailing entrypoint: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateMailingEntryPoint", method = RequestMethod.POST)
	public Map<String, Object> updateMailingEntryPoint(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateMailingEntryPoint(shippingDeliveryandDistributionModel);

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

	@RequestMapping(path = "/deleteMailingEntryPoint", method = RequestMethod.POST)
	public Map<String, Object> deleteMailingEntryPoint(String mailingEntryPoint) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteMailingEntryPoint(mailingEntryPoint);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete mailing entrypoint");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getMailingEntryPoint", method = RequestMethod.POST)
	public Map<String, Object> getMailingEntryPoint(String mailingEntryPoint) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> mailingEntryPointDetails = tableSetupService
					.getMailingEntryPoint(mailingEntryPoint);
			responseObject.put("mailingEntryPointDetails", mailingEntryPointDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveTransportMode", method = RequestMethod.POST)
	public Map<String, Object> saveTransportMode(
			ShippingDeliveryandDistributionModel shippingDeliveryandDistributionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveTransportMode(shippingDeliveryandDistributionModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save transportmode: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteTransportMode", method = RequestMethod.POST)
	public Map<String, Object> deleteTransportMode(String transportMode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteTransportMode(transportMode);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete transport mode");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getTransportMode", method = RequestMethod.POST)
	public Map<String, Object> getTransportMode(String transportMode) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> transportModeDetails = tableSetupService.getTransportMode(transportMode);
			responseObject.put("transportModeDetails", transportModeDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/EmailFormatterSave", method = RequestMethod.POST)
	public Map<String, Object> saveEmailFormater(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveEmailFormater(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in EmailFormatorSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/EmailFormatterUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateEmailFormater(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateEmailFormater(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in EmailFormatorUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/EmailFormatterDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteEmailFormater(int transactionEvent) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteEmailFormater(transactionEvent);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in EmailFormatorDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/addTransactionEvent", method = RequestMethod.POST)
	public Map<String, Object> transactionEvent() {
		List<DropdownModel> TrasactionEvent = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			TrasactionEvent = tableSetupService.getTransactionEvent();
			responseObject.put("TrasactionEvent", TrasactionEvent);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addTransactionEvent : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/emailFormaterDetails", method = RequestMethod.POST)
	public Map<String, Object> emailFormaterDetails(int transactionEvent) {
		List<Map<String, Object>> emailFormaterDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> orderClass = new ArrayList<>();

		try {
			emailFormaterDetails = tableSetupService.getEmailFormatorDetails(transactionEvent);
			responseObject.put("emailFormaterDetails", emailFormaterDetails);
			orderClass = tableSetupService.getOrderClass();
			responseObject.put("orderClass", orderClass);

			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addProvider : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/providerDetails", method = RequestMethod.POST)
	public Map<String, Object> providerDetails(int tpProviderId) {
		List<Map<String, Object>> providerDetails = new ArrayList<>();
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> provider = new ArrayList<>();

		try {
			provider = tableSetupService.getrovider();
			responseObject.put("provider", provider);
			providerDetails = tableSetupService.getrProviderDetails(tpProviderId);
			responseObject.put("providerDetails", providerDetails);
			responseObject.put(STATUS, true);
		} catch (Exception e) {
			LOGGER.info("error in addProvider : " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/tpProviderUpdate", method = RequestMethod.POST)
	public Map<String, Object> tpProviderUpdate(DefaultSettings defaultSettings) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {

			status = tableSetupService.tpProviderUpdate(defaultSettings);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in tpProviderUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/defaultEmailAuthorizationDetails", method = RequestMethod.POST)
	public Map<String, Object> defaultEmailAuthorizationInfo(@RequestParam("currency") String Currency) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> checkDetails = tableSetupService.getCheckdetails(Currency);
			responseObject.put("checkDetails", checkDetails);

			String email_authorization = tableSetupService.defaultEmailAuthorizationInfo(Currency);
			if (ERROR.equals(email_authorization)) {
				responseObject.put(STATUS, ERROR);
			} else if (email_authorization.equals("Currency does not exist in database.")) {
				responseObject.put(STATUS, "currency does not exist in database.");
			} else {
				responseObject.put("Business Process(es) selected in Email Authorization", email_authorization);
				responseObject.put("Restore Defaults",
						"1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37");
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/defaultEmailAuthorizationSave", method = RequestMethod.POST)
	public Map<String, Object> updateDefaultEmailAuthorization(@RequestParam("currency") String currency,
			@RequestParam("business_processes") String business_processes) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String suppressEmailNotification = null;
			String notifyOldAndNew = null;
			int status1 = tableSetupService.updateCheckDetails(currency, suppressEmailNotification, notifyOldAndNew);
			responseObject.put("status1", status1);
			String status = tableSetupService.updateDefaultEmailAuthorization(currency, business_processes);
			if (ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			} else {
				responseObject.put(STATUS, status);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/defaultEmailNotificationDetails", method = RequestMethod.POST)
	public Map<String, Object> defaultEmailNotificationInfo(@RequestParam("currency") String Currency) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {

			String event_notification_bits = tableSetupService.defaultEmailNotificationInfo(Currency);
			if (ERROR.equals(event_notification_bits)) {
				responseObject.put(STATUS, ERROR);
			} else if (event_notification_bits.equals("Currency does not exist in database.")) {
				responseObject.put(STATUS, "currency does not exist in database.");
			} else {
				responseObject.put("Business Process(es) selected in event_notification_bits", event_notification_bits);
				responseObject.put("Restore Defaults",
						"1,2,3,4,5,6,7,8,9,10,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38");
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/defaultEmailNotificationSwitches", method = RequestMethod.POST)
	public Map<String, Object> updateDefaultEmailNotificationSwitches(@RequestParam("currency") String currency,
			@RequestParam("business_processes") String business_processes) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = tableSetupService.updateDefaultEmailNotificationSwitches(currency, business_processes);
			if (ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			} else {
				responseObject.put(STATUS, status);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/dealTypeSave", method = RequestMethod.POST)
	public Map<String, Object> saveDealType(DealModel dealModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveDealType(dealModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in dealTypeSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/dealTypeUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateDealType(DealModel dealModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateDealType(dealModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in dealTypeUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/dealTypeDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteDealType(String dealType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteDealType(dealType);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in dealTypeDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/dealTypeDetails", method = RequestMethod.POST)
	public Map<String, Object> dealTypeDetails(String dealType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> dealTypeInfo = tableSetupService.getDealTypeDetails(dealType);
			responseObject.put("dealTypeInfo", dealTypeInfo);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in dealTypeDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/dealStatusSave", method = RequestMethod.POST)
	public Map<String, Object> saveDealStatus(DealModel dealModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveDealStatus(dealModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in dealStatusSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/dealStatusUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateDealStatus(DealModel dealModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateDealStatus(dealModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in dealStatusUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/dealStatusDetails", method = RequestMethod.POST)
	public Map<String, Object> dealStatusDetails(String dealStatus) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> dealTypeInfo = tableSetupService.getDealStatusDetails(dealStatus);
			responseObject.put("dealTypeInfo", dealTypeInfo);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in dealStatusDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/dealStatusDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteDealStatus(String dealStatus) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteDealStatus(dealStatus);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in dealStatusDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/demographicSave", method = RequestMethod.POST)
	public Map<String, Object> saveDemograpic(DemographicModel demographicModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveDemograpic(demographicModel);
			status = tableSetupService.saveDemResponse(demographicModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in demographicSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/demographicUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateDemographic(DemographicModel demographicModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateDemQuestion(demographicModel);
			status = tableSetupService.updateDemresponse(demographicModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in demographicUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/demographicDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteDemographic(int demQuestionId, int demresponseSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			int status1 = tableSetupService.deleteDemresponse(demresponseSeq, demQuestionId);
			status = tableSetupService.deleteDemQuestion(demQuestionId);

			if (status1 != 0 || status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in demographicDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/demographicDetails", method = RequestMethod.POST)
	public Map<String, Object> demographicInfo(int demQuestionId, int demresponseSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> demographicDetails = tableSetupService.getDemographicInfo(demQuestionId,
					demresponseSeq);
			List<Map<String, Object>> demQuestionDetails = tableSetupService.getDemQuestionDetails(demQuestionId);
			responseObject.put("demQuestionDetails", demQuestionDetails);

			responseObject.put("demographicDetails", demographicDetails);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in demographicDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/addQualified", method = RequestMethod.POST)
	public Map<String, Object> quilified() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> qualifiedDetails = tableSetupService.getQualified();
			List<DropdownModel> freeFormInputDetails = tableSetupService.getFreeFormInput();
			responseObject.put("freeFormInputDetails", freeFormInputDetails);

			responseObject.put("qualifiedDetails", qualifiedDetails);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in addQualified : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/displaContextRedirectionSave", method = RequestMethod.POST)
	public Map<String, Object> saveDisplayctxRedirection(DemographicModel demographicModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveDisplayctxRedirection(demographicModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in displaContextRedirectionSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/displaContextRedirectionUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateDisplayctxRedirection(DemographicModel demographicModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateDisplayctxRedirection(demographicModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in displaContextRedirectionUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/displaContextRedirectionDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteDisplayctxRedirection(String dispContext) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteDisplayctxRedirection(dispContext);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in displaContextRedirectionDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/displaContextRedirectionDetails", method = RequestMethod.POST)
	public Map<String, Object> displayctxRedirectionDetails(String dispContext) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> displayctxRedirectionInfo = tableSetupService
					.getDisplayctxRedirection(dispContext);
			responseObject.put("displayctxRedirectionInfo", displayctxRedirectionInfo);

			responseObject.put(STATUS, true);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in displaContextRedirectionDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/addDisplayCntxRedirection", method = RequestMethod.POST)
	public Map<String, Object> dispContextAdd() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> dispContext = tableSetupService.getDispCntx();
			responseObject.put("dispContext", dispContext);

			List<DropdownModel> dispContexttoLead = tableSetupService.getDispContexttoLead();
			responseObject.put("dispContexttoLead", dispContexttoLead);

			responseObject.put(STATUS, true);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in addDispContext : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelFormatSave", method = RequestMethod.POST)
	public Map<String, Object> savelabelFormat(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.savelabelFormat(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelFormatSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelFormatUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateLabelFormat(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateLabelFormat(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelFormatUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelFormatDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteLabelFormat(String labeFormat, String labelGroup) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteLabelFormat(labeFormat, labelGroup);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelFormatDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelFormateDetails", method = RequestMethod.POST)
	public Map<String, Object> labelFormateDetails(String labeFormat) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> labelFormat = tableSetupService.getLabelFormateDetails(labeFormat);
			responseObject.put("labelFormat", labelFormat);

			responseObject.put(STATUS, true);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelFormateDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;
	}

	@RequestMapping(path = "/labelGroupDetails", method = RequestMethod.POST)
	public Map<String, Object> labelGroupDetails(String labelGroup) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> labelgroup = tableSetupService.getlabelGroupDetails(labelGroup);
			responseObject.put("labelgroup", labelgroup);

			responseObject.put(STATUS, true);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelGroupDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;
	}

	@RequestMapping(path = "/labelGroupSave", method = RequestMethod.POST)
	public Map<String, Object> savelabelGroup(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.savelabelGroup(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelGroupSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelGroupUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateLabelGroup(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateLabelGroup(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelGroupUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelGroupDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteLabelGroup(String labelGroup) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteLabelGroup(labelGroup);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelGroupDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelKeyLineSave", method = RequestMethod.POST)
	public Map<String, Object> savelabelKeyline(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.savelabelKeyline(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelKeyLineSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelKeyLineDetailSave", method = RequestMethod.POST)
	public Map<String, Object> savelabelKeylineDetail(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> tablename = new ArrayList<>();
		List<DropdownModel> columeName = new ArrayList<>();
		int status = 0;
		try {
			if (labelModel.getLabelSegmentType() == 0) {
				tablename = tableSetupService.getTablename();
				responseObject.put("tablename", tablename);

				columeName = tableSetupService.getColumnnameInfo();
				responseObject.put("columeName", columeName);

			} else if (labelModel.getLabelSegmentType() == 3) {

				List<DropdownModel> demQuestion = tableSetupService.getDemQuestion();
				responseObject.put("demQuestion", demQuestion);

			} else if (labelModel.getLabelSegmentType() == 2) {
				if (labelModel.getLabelSpecialType() == 2)
					columeName = tableSetupService.getColumnname();
				responseObject.put("columeName", columeName);

			}
			status = tableSetupService.saveLbelKeylineDetails(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelKeyLineSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelKeyLineUpdate", method = RequestMethod.POST)
	public Map<String, Object> updatelabelKeyline(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updatelabelKeyline(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelKeyLineUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelKeyLineDetailUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateLabelKeylineDetail(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> tablename = new ArrayList<>();
		List<DropdownModel> columeName = new ArrayList<>();
		int status = 0;
		try {
			if (labelModel.getLabelSegmentType() == 0) {
				tablename = tableSetupService.getTablename();
				responseObject.put("tablename", tablename);

				columeName = tableSetupService.getColumnnameInfo();
				responseObject.put("columeName", columeName);

			} else if (labelModel.getLabelSegmentType() == 3) {

				List<DropdownModel> demQuestion = tableSetupService.getDemQuestion();
				responseObject.put("demQuestion", demQuestion);

			} else if (labelModel.getLabelSegmentType() == 2) {
				if (labelModel.getLabelSpecialType() == 2)
					columeName = tableSetupService.getColumnname();
				responseObject.put("columeName", columeName);

			}
			status = tableSetupService.updateLabelKeylineDetail(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelKeyLineDetailUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelKeyLineDetails", method = RequestMethod.POST)
	public Map<String, Object> labelKeylineDetails(String labelKeyline, int labelLinenbr) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> labelkeylineDetail = tableSetupService.labelKeylineDetails(labelKeyline);
			responseObject.put("labelkeylineDetail", labelkeylineDetail);

			List<Map<String, Object>> labelkeylineDetailsInfo = tableSetupService.labelKeylineInfo(labelKeyline,
					labelLinenbr);
			responseObject.put("labelkeylineDetailsInfo", labelkeylineDetailsInfo);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelKeyLineDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelKeyLineDetailsDelete", method = RequestMethod.POST)
	public Map<String, Object> deletelabelKeylineDetail(String labelKeyline, int labelLinenbr) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deletelabelKeylineDetail(labelKeyline, labelLinenbr);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelKeyLineDetailsDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelKeyLineDelete", method = RequestMethod.POST)
	public Map<String, Object> deletelabelKeyline(String labelKeyline) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status1 = 0;
		try {

			status1 = tableSetupService.deleteLabelkeyline(labelKeyline);
			if (status1 != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelKeyLineDetailsDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelGroupFormatDetails", method = RequestMethod.POST)
	public Map<String, Object> labelGroupFormatDetails(String labelGroup, int labelLinenbr) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> labelGroupFormatDetail = tableSetupService.getLabelgroupFormatDetails(labelGroup);
			responseObject.put("labelGroupFormatDetail", labelGroupFormatDetail);

			List<Map<String, Object>> finalLabel = tableSetupService.getFinalLabel(labelGroup, labelLinenbr);
			responseObject.put("finalLabel", finalLabel);

			List<DropdownModel> labelGroupInfo = tableSetupService.getlabelGroupInfo();
			responseObject.put("labelGroupInfo", labelGroupInfo);
			List<DropdownModel> labelFormat = tableSetupService.getLabelFormat();
			responseObject.put("labelFormat", labelFormat);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelKeyLineDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelsadd", method = RequestMethod.POST)
	public Map<String, Object> saveLabel(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveLabel(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateLabel(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.updateLabel(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelFormatDetailSave", method = RequestMethod.POST)
	public Map<String, Object> saveLabelFormatDetail(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> tablename = new ArrayList<>();
		List<DropdownModel> columeName = new ArrayList<>();
		int status = 0;
		try {
			if (labelModel.getLabelSegmentType() == 0) {
				tablename = tableSetupService.getTablename();
				responseObject.put("tablename", tablename);

				columeName = tableSetupService.getColumnnameInfo();
				responseObject.put("columeName", columeName);

			} else if (labelModel.getLabelSegmentType() == 2) {
				if (labelModel.getLabelSpecialType() == 2)
					columeName = tableSetupService.getColumnnameInfo();
				responseObject.put("columeName", columeName);

			}
			status = tableSetupService.saveLabelFormatDetail(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelFormatDetailSave : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelFormatDetailUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateLabelFormatDetail(LabelModel labelModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> tablename = new ArrayList<>();
		List<DropdownModel> columeName = new ArrayList<>();
		int status = 0;
		try {
			if (labelModel.getLabelSegmentType() == 0) {
				tablename = tableSetupService.getTablename();
				responseObject.put("tablename", tablename);

				columeName = tableSetupService.getColumnnameInfo();
				responseObject.put("columeName", columeName);

			} else if (labelModel.getLabelSegmentType() == 2) {
				if (labelModel.getLabelSpecialType() == 2)
					columeName = tableSetupService.getColumnnameInfo();
				responseObject.put("columeName", columeName);

			}
			status = tableSetupService.updateLabelFormatDetail(labelModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelFormatDetailUpdate : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/labelDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteLabel(String labelFormat, int labelLinenbr) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status1 = 0;

		try {
			status1 = tableSetupService.deleteLabelDetails(labelFormat, labelLinenbr);
			if (status1 != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in labelDelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/formatLabeldelete", method = RequestMethod.POST)
	public Map<String, Object> deleteFormatLabel(String labelFormat) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;

		try {
			status = tableSetupService.deleteLabel(labelFormat);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in formatLabeldelete : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}
// Earlier Display API

	@RequestMapping(path = "/installemtPlanDetails", method = RequestMethod.POST)
	public Map<String, Object> installmentPlanDetails(int installmentPlanId, int installPlanDetailSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> output = tableSetupService.getOutput();
			responseObject.put("output", output);

			List<Map<String, Object>> installmentDetail = tableSetupService.installmentPlanDetails(installmentPlanId);
			responseObject.put("installmentDetail", installmentDetail);

			List<Map<String, Object>> installPlanDetails = tableSetupService.installPlanInfo(installmentPlanId,
					installPlanDetailSeq);
			responseObject.put("installPlanDetails", installPlanDetails);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in installemtPlanDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/settleRetryDefDetails", method = RequestMethod.POST)
	public Map<String, Object> settleretryDef(String settleRetryDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {

			List<Map<String, Object>> settleRetrydeDetail = tableSetupService.settleRetryDefInfo(settleRetryDef);
			responseObject.put("settleRetrydeDetail", settleRetrydeDetail);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in settleRetryDefDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/qtyDiscountScheduleDetails", method = RequestMethod.POST)
	public Map<String, Object> qtyDiscountSchedule(String qtyDiscountSchedule) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> discountAmtCalcType = tableSetupService.getDiscountamtCalcType();
			responseObject.put("discountAmtCalcType", discountAmtCalcType);

			List<Map<String, Object>> qtyDiscountScheduleDetails = tableSetupService
					.getQtyDiscountSchedule(qtyDiscountSchedule);
			responseObject.put("qtyDiscountScheduleDetails", qtyDiscountScheduleDetails);

			List<Map<String, Object>> qtyDiscountSchedDetails = tableSetupService
					.getQtyDiscountSchedDtl(qtyDiscountSchedule);
			responseObject.put("qtyDiscountSchedDetails", qtyDiscountSchedDetails);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in qtyDiscountScheduleDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/multilineDiscountScheduleDetails", method = RequestMethod.POST)
	public Map<String, Object> multilinrDiscountSchedule(String multilineDiscountSchedule, int multilineDiscEffSeq,
			int multiDiscScheddtlSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> discountAmtCalcType = tableSetupService.getDiscountamtCalcType();
			responseObject.put("discountAmtCalcType", discountAmtCalcType);

			List<DropdownModel> currency = tableSetupService.getCurrencyList();
			responseObject.put("currency", currency);

			List<Map<String, Object>> multilineDiscountSchedDetails = tableSetupService
					.getMultilineDiscountSchedule(multilineDiscountSchedule);
			responseObject.put("multilineDiscountSchedDetails", multilineDiscountSchedDetails);

			List<Map<String, Object>> multilineDiscEffective = tableSetupService
					.getMultilineDiscEffective(multilineDiscountSchedule, multilineDiscEffSeq);
			responseObject.put("multilineDiscEffective", multilineDiscEffective);

			List<Map<String, Object>> multiDiscSchedDtl = tableSetupService
					.getMultiDiscSchedDtl(multilineDiscountSchedule, multiDiscScheddtlSeq);
			responseObject.put("multiDiscSchedDtl", multiDiscSchedDtl);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in multilineDiscountScheduleDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;
	}

	@RequestMapping(path = "/serviceCauseDetails", method = RequestMethod.POST)
	public Map<String, Object> servicecause(String causeCode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> reportItemId = tableSetupService.getReportitemId();
			responseObject.put("reportItemId", reportItemId);

			List<Map<String, Object>> seviceCaueseDetails = tableSetupService.getServiceCause(causeCode);
			responseObject.put("seviceCaueseDetails", seviceCaueseDetails);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in serviceCauseDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/serviceComplaintsDetails", method = RequestMethod.POST)
	public Map<String, Object> servicecomplaints(String complaintCode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> causeCode = tableSetupService.getCauseCode();
			responseObject.put("causeCode", causeCode);

			List<DropdownModel> servicetoPerform = tableSetupService.getServicetoPerform();
			responseObject.put("servicetoPerform", servicetoPerform);

			List<DropdownModel> reportItemId = tableSetupService.getReportitemId();
			responseObject.put("reportItemId", reportItemId);

			List<Map<String, Object>> seviceComplaintsDetails = tableSetupService.getServiceComplaints(complaintCode);
			responseObject.put("seviceComplaintsDetails", seviceComplaintsDetails);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in serviceComplaintsDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;
	}

	@RequestMapping(path = "/serviceresolutionDetails", method = RequestMethod.POST)
	public Map<String, Object> serviceResolutions(String serviceCode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> reportItemId = tableSetupService.getReportitemId();
			responseObject.put("reportItemId", reportItemId);

			List<Map<String, Object>> seviceResolutionDetails = tableSetupService.getServiceResolution(serviceCode);
			responseObject.put("seviceResolutionDetails", seviceResolutionDetails);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in serviceresolutionDetails : " + e);
			responseObject.put(STATUS + ERROR, e);
		}
		return responseObject;

	}

	@RequestMapping(path = "/saveAuditBasicPrice", method = RequestMethod.POST)
	public Map<String, Object> saveBasicPrice(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveBasicPrice(auditModel);

			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save basic price: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateAuditBasicPrice", method = RequestMethod.POST)
	public Map<String, Object> updateBasicPrice(AuditModel auditModel) {

		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateBasicPrice(auditModel);

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

	@RequestMapping(path = "/deleteAuditBasicPrice", method = RequestMethod.POST)
	public Map<String, Object> deleteBasicPrice(int auditBasicPriceId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteBasicPrice(auditBasicPriceId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete audit basic price");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getAuditBasicPrice", method = RequestMethod.POST)
	public Map<String, Object> getBasicPrice(int auditBasicPriceId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			List<Map<String, Object>> basicPriceDetails = tableSetupService.getBasicPrice(auditBasicPriceId);
			responseObject.put("basicPriceDetails", basicPriceDetails);
			List<DropdownModel> pubGroupList = tableSetupService.getPubGroupList();
			responseObject.put("pubGroupList", pubGroupList);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveAuditDuration", method = RequestMethod.POST)
	public Map<String, Object> saveAuditDuration(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveAuditDuration(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save audit duration: " + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateAuditDuration", method = RequestMethod.POST)
	public Map<String, Object> updateAuditDuration(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateAuditDuration(auditModel);

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

	@RequestMapping(path = "/deleteAuditDuration", method = RequestMethod.POST)
	public Map<String, Object> deleteAuditDuration(int auditDurationId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteAuditDuration(auditDurationId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete audit duration");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getAuditDuration", method = RequestMethod.POST)
	public Map<String, Object> getAuditDuration(int auditDurationId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> auditDurationDetails = tableSetupService.getAuditDuration(auditDurationId);
			responseObject.put(" auditDurationDetails", auditDurationDetails);
			responseObject.put("pubGroupList", tableSetupService.getPubGroupList());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveMailingAddressName", method = RequestMethod.POST)
	public Map<String, Object> saveMailingAddressName(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveMailingAddressName(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save mailing addressname and title:" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateMailingAddressName", method = RequestMethod.POST)
	public Map<String, Object> updateMailingAddressName(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateMailingAddressName(auditModel);

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

	@RequestMapping(path = "/deleteMailingAddressName", method = RequestMethod.POST)
	public Map<String, Object> deleteMailingAddressName(int auditNameTitleId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteMailingAddressName(auditNameTitleId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete audit duration");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getMailingAddressName", method = RequestMethod.POST)
	public Map<String, Object> getMailingAddressName(int auditNameTitleId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> mailingAddressNameDetails = tableSetupService
					.getMailingAddressName(auditNameTitleId);
			responseObject.put("mailingAddressNameDetails", mailingAddressNameDetails);
			responseObject.put("pubGroupList", tableSetupService.getPubGroupList());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/savePublicationGroup", method = RequestMethod.POST)
	public Map<String, Object> savePublicationGroup(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.savePublicationGroup(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save PublicationGroup:" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updatePublicationGroup", method = RequestMethod.POST)
	public Map<String, Object> updatePublicationGroup(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updatePublicationGroup(auditModel);

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

	@RequestMapping(path = "/deletePublicationGroup", method = RequestMethod.POST)
	public Map<String, Object> deletePublicationGroup(String auditPubGroup) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deletePublicationGroup(auditPubGroup);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete publication group");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/getPublicationGroup", method = RequestMethod.POST)
	public Map<String, Object> getPublicationGroup(String auditPubGroup) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> pubGroupDetails = tableSetupService.getPublicationGroup(auditPubGroup);
			responseObject.put("pubGroupDetails", pubGroupDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveQualificationSource", method = RequestMethod.POST)
	public Map<String, Object> saveQualificationSource(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveQualificationSource(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save QualificationSource:" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateQualificationSource", method = RequestMethod.POST)
	public Map<String, Object> updateQualificationSource(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateQualificationSource(auditModel);

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

	@RequestMapping(path = "/deleteQualificationSource", method = RequestMethod.POST)
	public Map<String, Object> deleteQualificationSource(int auditQualSourceId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteQualificationSource(auditQualSourceId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete Qualificationsource");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getQualificationSource", method = RequestMethod.POST)
	public Map<String, Object> getQualificationSource(int auditQualSourceId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> auditQualSourceDetails = tableSetupService
					.getQualificationSource(auditQualSourceId);
			responseObject.put("auditQualSourceDetails", auditQualSourceDetails);
			responseObject.put("pubGroupList", tableSetupService.getPubGroupList());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveDemographicCrossTab", method = RequestMethod.POST)
	public Map<String, Object> saveDemoGraphicCrossTab(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveDemoGraphicCrossTab(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save demographic cross tab:" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateDemographicCrossTab", method = RequestMethod.POST)
	public Map<String, Object> updateDemographicCrossTab(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateDemographicCrossTab(auditModel);

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

	@RequestMapping(path = "/deleteDemographicCrossTab", method = RequestMethod.POST)
	public Map<String, Object> deleteDemographicCrossTab(int auditReportId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteDemographicCrossTab(auditReportId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete Demographic crosstab");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getDemographicCrossTab", method = RequestMethod.POST)
	public Map<String, Object> getDemographicCrossTab(int auditReportId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> auditReportDetails = tableSetupService.getDemographicCrossTab(auditReportId);
			responseObject.put("auditReportDetails", auditReportDetails);

			List<DropdownModel> questionList = tableSetupService.getQuestionList();
			responseObject.put("questionList", questionList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveSalesChannel", method = RequestMethod.POST)
	public Map<String, Object> saveSalesChannel(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveSalesChannel(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save sales channel:" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateSalesChannel", method = RequestMethod.POST)
	public Map<String, Object> updateSalesChannel(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateSalesChannel(auditModel);

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

	@RequestMapping(path = "/deleteSalesChannel", method = RequestMethod.POST)
	public Map<String, Object> deleteSalesChannel(int auditSalesChannelId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteSalesChannel(auditSalesChannelId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete Audit Sales Channel");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getSalesChannel", method = RequestMethod.POST)
	public Map<String, Object> getSalesChannel(int auditSalesChannelId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> salesChannelDetails = tableSetupService.getSalesChannel(auditSalesChannelId);
			responseObject.put("salesChannelDetails", salesChannelDetails);
			responseObject.put("pubGroupList", tableSetupService.getPubGroupList());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveSubscriptionType", method = RequestMethod.POST)
	public Map<String, Object> saveSubscriptionType(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveSubscriptionType(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save subscriptionType:" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateSubscriptionType", method = RequestMethod.POST)
	public Map<String, Object> updateSubscriptionType(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateSubscriptionType(auditModel);

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

	@RequestMapping(value = "/getSubscriptionType", method = RequestMethod.POST)
	public Map<String, Object> getSubscriptionType(int auditSubscriptTypeId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> auditSubscriptTypeDetails = tableSetupService
					.getSubscriptionType(auditSubscriptTypeId);
			responseObject.put("auditSubscriptTypeDetails", auditSubscriptTypeDetails);
			responseObject.put("pubGroupList", tableSetupService.getPubGroupList());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveLookupForAuditGalleyIssue", method = RequestMethod.POST)
	public Map<String, Object> saveLookupForAuditGalleyIssue(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveLookupForAuditGalleyIssue(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save lookup for AuditGalley Issue:" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updateLookupForAuditGalleyIssue", method = RequestMethod.POST)
	public Map<String, Object> updateLookupForAuditGalleyIssue(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateLookupForAuditGalleyIssue(auditModel);

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

	@RequestMapping(path = "/deleteLookupForAuditGalleyIssue", method = RequestMethod.POST)
	public Map<String, Object> deleteLookupForAuditGalleyIssue(String search, int searchFieldGroupSeq,
			int searchResultDisplaySeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteLookupForAuditGalleyIssue(search, searchFieldGroupSeq,
					searchResultDisplaySeq);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete look up for auditgalley issue");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getLookupForAuditGalleyIssue", method = RequestMethod.POST)
	public Map<String, Object> getLookupForAuditGalleyIssue(String search, int searchFieldGroupSeq,
			int searchResultDisplaySeq) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> lookupAuditGalleyIssuelDetails = tableSetupService
					.getLookupForAuditGalleyIssue(search, searchFieldGroupSeq, searchResultDisplaySeq);
			responseObject.put("lookupAuditGalleyIssuelDetails", lookupAuditGalleyIssuelDetails);
			responseObject.put("dispContextList", tableSetupService.getDispContext());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveParagraphReports", method = RequestMethod.POST)
	public Map<String, Object> saveParagraphReports(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.saveParagraphReports(auditModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in save paragraphReport:" + e);
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/updateParagraphReports", method = RequestMethod.POST)
	public Map<String, Object> updateParagraphReports(AuditModel auditModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			int status = tableSetupService.updateParagraphReports(auditModel);

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

	@RequestMapping(path = "/deleteParagraphReports", method = RequestMethod.POST)
	public Map<String, Object> deleteParagraphReports(int auditReportId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = tableSetupService.deleteParagraphReports(auditReportId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in delete paragraph report");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/getParagraphReports", method = RequestMethod.POST)
	public Map<String, Object> getParagraphReports() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> paragraphReportDetails = tableSetupService.getParagraphReports();
			responseObject.put("paragraphReportDetails", paragraphReportDetails);
			List<DropdownModel> paragraphSelectionList = tableSetupService.getParagraphSelectionList();
			responseObject.put("paragraphSelectionList", paragraphSelectionList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/auditLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> getAuditLeftPanel() {
		Map<String, Object> responseObject = new HashMap<>();
		List<LeftPanelTableSetupModel> ParentRootMenu = new ArrayList<>();
		List<AuditLeftPanelModel> childRootMenu = new ArrayList<>();
		try {
			LeftPanelTableSetupModel model = new LeftPanelTableSetupModel();
			model.setId(0);
			model.setTitle("Audit");

			List<Map<String, Object>> basicPriceList = new ArrayList<>();
			Map<String, Object> basicMap = new HashMap<>();
			basicPriceList.add(basicMap);
			AuditLeftPanelModel model1 = new AuditLeftPanelModel();
			model1.setId(1);
			model1.setTitle("basicPrice");
			basicMap.put("basicPrice", tableSetupService.getBasicPrice(0));
			model1.setData(basicPriceList);
			childRootMenu.add(model1);

			List<Map<String, Object>> demographicList = new ArrayList<>();
			Map<String, Object> demographicMap = new HashMap<>();
			demographicList.add(demographicMap);
			AuditLeftPanelModel model2 = new AuditLeftPanelModel();
			model2.setId(2);
			model2.setTitle("demoGraphicCrossTab");
			demographicMap.put("demoGraphicCrossTab", tableSetupService.getDemographicCrossTab(0));
			demographicList.add(demographicMap);
			model2.setData(demographicList);
			childRootMenu.add(model2);

			List<Map<String, Object>> durationList = new ArrayList<>();
			Map<String, Object> durationMap = new HashMap<>();

			AuditLeftPanelModel model3 = new AuditLeftPanelModel();
			model3.setId(3);
			model3.setTitle("duration");
			durationMap.put("duration", tableSetupService.getAuditDuration(0));
			durationList.add(durationMap);
			model3.setData(durationList);
			childRootMenu.add(model3);

			List<Map<String, Object>> mailingAddressList = new ArrayList<>();
			Map<String, Object> mailingAddressMap = new HashMap<>();

			AuditLeftPanelModel model4 = new AuditLeftPanelModel();
			model4.setId(4);
			model4.setTitle("mailingAddressName");
			mailingAddressMap.put("mailingAddressName", tableSetupService.getMailingAddressName(0));
			mailingAddressList.add(mailingAddressMap);
			model4.setData(mailingAddressList);
			childRootMenu.add(model4);

			List<Map<String, Object>> paragraphReportList = new ArrayList<>();
			Map<String, Object> paragraphReportMap = new HashMap<>();
			AuditLeftPanelModel model5 = new AuditLeftPanelModel();
			model5.setId(5);
			model5.setTitle("paragraphReports");
			paragraphReportMap.put("paragraphReports",tableSetupService.getParagraphReports());
			paragraphReportList.add(paragraphReportMap);
			model5.setData(paragraphReportList);
			childRootMenu.add(model5);

			List<Map<String, Object>> pubGroupList = new ArrayList<>();
			Map<String, Object> pubGroupMap = new HashMap<>();
			pubGroupMap.put("pubGroupMap",tableSetupService.getPublicationGroup(null));
			pubGroupList.add(pubGroupMap);
			AuditLeftPanelModel model6 = new AuditLeftPanelModel();
			model6.setId(6);
			model6.setTitle("publicationGroup");
			model6.setData(pubGroupList);
			childRootMenu.add(model6);

			List<Map<String, Object>> qualSourceList = new ArrayList<>();
			Map<String, Object> qualSourceMap = new HashMap<>();
			qualSourceList.add(qualSourceMap);
			AuditLeftPanelModel model7 = new AuditLeftPanelModel();
			model7.setId(7);
			model7.setTitle("QualificationSource");
			qualSourceMap.put("QualificationSource",tableSetupService.getQualificationSource(0));
			model7.setData(qualSourceList);
			childRootMenu.add(model7);

			List<Map<String, Object>> salesChannelList = new ArrayList<>();
			Map<String, Object> salesChannelMap = new HashMap<>();
			AuditLeftPanelModel model8 = new AuditLeftPanelModel();
			model8.setId(8);
			model8.setTitle("salesChannel");
			salesChannelMap.put("salesChannel",tableSetupService.getSalesChannel(0));
			salesChannelList.add(salesChannelMap);
			model8.setData(salesChannelList);
			childRootMenu.add(model8);

			List<Map<String, Object>> subscriptTypeList = new ArrayList<>();
			Map<String, Object> subscriptTypeMap = new HashMap<>();
			AuditLeftPanelModel model9 = new AuditLeftPanelModel();
			model9.setId(9);
			model9.setTitle("subscriptionType");
			subscriptTypeMap.put("subscriptionType",tableSetupService.getSubscriptionType(0));
			subscriptTypeList.add(subscriptTypeMap);
			model9.setData(subscriptTypeList);
			childRootMenu.add(model9);

			List<Map<String, Object>> auditGalleyIssueList = new ArrayList<>();
			Map<String, Object> auditGalleyIssueMap = new HashMap<>();
			AuditLeftPanelModel model10 = new AuditLeftPanelModel();
			model10.setId(10);
			model10.setTitle("LookupforAuditGalleyIssue");
			auditGalleyIssueMap.put("LookupforAuditGalleyIssue",tableSetupService.getLookupForAuditGalleyIssue(null,0,0));
			auditGalleyIssueList.add(auditGalleyIssueMap);
			model10.setData(auditGalleyIssueList);
			childRootMenu.add(model10);

			AuditLeftPanelModel model11 = new AuditLeftPanelModel();
			model11.setId(11);
			model11.setTitle("SubsetLookupforGalleyIssue");
			auditGalleyIssueMap.put("SubsetLookupforGalleyIssue",tableSetupService.getLookupForAuditGalleyIssue(null,0,0));
			auditGalleyIssueList.add(auditGalleyIssueMap);
			model11.setData(auditGalleyIssueList);
			childRootMenu.add(model11);
			
			ParentRootMenu.add(model);
		    model.setNodes(childRootMenu);

			responseObject.put("leftPanelMenuData", ParentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getAuditLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}
	
	
	@RequestMapping(path="/psRenewal",method=RequestMethod.POST) 
	public Map<String,Object> psRenewal(@RequestParam ("currency") String currency){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String psRenewal=tableSetupService.getPsRenewalLabel(currency);
			if(ERROR.equals(psRenewal)) {
				responseObject.put(STATUS,false);
			}else if(psRenewal.equals("Currency deosnot Exist in database")) {
				responseObject.put(STATUS, "currency does not exist in database.");
			}
			else 
			{
				responseObject.put("Business Process(es) selected in  psRenewal", psRenewal);
				responseObject.put("Restore Defaults", "2,3,4,5");
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
			}catch(Exception e) {
				LOGGER.info("error in psRenewal");
				responseObject.put(STATUS+ERROR,e);
				
		}return responseObject;
	}
	
	@RequestMapping(path="/psBilling",method=RequestMethod.POST)
	public Map<String,Object> psBilling(@RequestParam("currency") String currency){
		Map<String,Object> responseObject=new LinkedHashMap<>();
			try {
				String psBilling=tableSetupService.getPsBilling(currency);
				if(ERROR.equals(psBilling)) {
					responseObject.put(STATUS,false);
				}else if(psBilling.equals("Currency deosnot Exist in database") ) {
					responseObject.put(STATUS,"currency does not exist in database.");
				}else {
					responseObject.put("Business Process(es) selected in  psBilling", psBilling);
					responseObject.put("Restore Defaults", "1,5");
					responseObject.put(STATUS, SUCCESS);
				}
			}catch(Exception e) {
				LOGGER.info("error in psBilling");
				responseObject.put(STATUS+ERROR,e);

			}return responseObject;
	}

	
	@RequestMapping(path="/osLabel",method=RequestMethod.POST)
	public Map<String,Object> defaultOsLabel(@RequestParam("currency") String currency){
		Map<String,Object> responseObject=new LinkedHashMap<>();
			try {
				String osLabel=tableSetupService.getOsLabel(currency);
				if(ERROR.equals(osLabel)) {
					responseObject.put(STATUS,false);
				}else if(osLabel.equals("Currency deosnot Exist in database") ) {
					responseObject.put(STATUS,"currency does not exist in database.");
				}else {
					responseObject.put("Business Process(es) selected in  osLabel", osLabel);
					responseObject.put("Restore Defaults", "0,5,7");
					responseObject.put(STATUS, SUCCESS);
				}
			}catch(Exception e) {
				LOGGER.info("error in osLabel");
				responseObject.put(STATUS+ERROR,e);

			}return responseObject;
	}

	@RequestMapping(path="/osBackLabel",method=RequestMethod.POST)
	public Map<String,Object> defaultOsBackLabel(@RequestParam("currency") String currency){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String osBackLabel=tableSetupService.getOsBackLabel(currency);
			if(ERROR.equals(osBackLabel)) {
				responseObject.put(STATUS,false);
			}else if(osBackLabel.equals("Currency deosnot Exist in database") ) {
				responseObject.put(STATUS,"currency does not exist in database.");
			}else {
				responseObject.put("Business Process(es) selected in  osBackLabel", osBackLabel);
				responseObject.put("Restore Defaults", "0,5,7");
				responseObject.put(STATUS, SUCCESS);
			}
		}catch(Exception e) {
			LOGGER.info("error in osBackLabel");
			responseObject.put(STATUS+ERROR,e);

		}return responseObject;
	}

	@RequestMapping(path="/osRenewal",method=RequestMethod.POST)
	public Map<String,Object> defaultOsRenewal(@RequestParam("currency") String currency){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String osRenewal=tableSetupService.getOsRenewal(currency);
			if(ERROR.equals(osRenewal)) {
				responseObject.put(STATUS,false);
			}else if(osRenewal.equals("Currency deosnot Exist in database")) {
				responseObject.put(STATUS,"Currency Deos Not Exist in database ");
			}else {
				responseObject.put("Business Process(es) Select In osRenwal",osRenewal);
				responseObject.put("Restore defaults","0,5,7,9,12");
			}
		}catch(Exception e) {
			LOGGER.info("error in osRenwal");
			responseObject.put(STATUS+ERROR,e);

		}return responseObject;
	}
	
	@RequestMapping(path="/osBilling",method=RequestMethod.POST) 
	public Map<String,Object> defaultOsBilling(@RequestParam("currency") String currency) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String osBilling=tableSetupService.getOsBilling(currency);
			if(ERROR.equals(osBilling)) {
				responseObject.put(STATUS,false);
			}else if(osBilling.equals("Currency deosnot Exist in database")) {
				responseObject.put(STATUS,"Currency Deos Not Exist in database ");
			}else {
				responseObject.put("Business Process(es) Select In osBilling",osBilling);
				responseObject.put("Restore defaults","0,1,2,3,4,5,6,7,8,9,10,11,12,16");
			}
		}catch(Exception e) {
			LOGGER.info("error in osBilling");
			responseObject.put(STATUS+ERROR,e);

		}return responseObject;
	}
	
	@RequestMapping(path="/osCancellation",method=RequestMethod.POST) 
	public Map<String,Object> defaultOsCancellation(@RequestParam("currency") String currency) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String osCancel=tableSetupService.getOsCancellation(currency);
			if(ERROR.equals(osCancel)) {
				responseObject.put(STATUS,false);
			}else if(osCancel.equals("Currency deosnot Exist in database")) {
				responseObject.put(STATUS,"Currency Deos Not Exist in database ");
			}else {
				responseObject.put("Business Process(es) Select In osCancel",osCancel);
				responseObject.put("Restore defaults","1,2,3,4");
			}
		}catch(Exception e) {
			LOGGER.info("error in osCancellation");
			responseObject.put(STATUS+ERROR,e);

		}return responseObject;
	}
	
	@RequestMapping(path="/osSuspention",method=RequestMethod.POST) 
	public Map<String,Object> defaultOsSuspention(@RequestParam("currency") String currency) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String osSusupension=tableSetupService.getOsSuspension(currency);
			if(ERROR.equals(osSusupension)) {
				responseObject.put(STATUS,false);
			}else if(osSusupension.equals("Currency deosnot Exist in database")) {
				responseObject.put(STATUS,"Currency Deos Not Exist in database ");
			}else {
				responseObject.put("Business Process(es) Select In osSusupension",osSusupension);
				responseObject.put("Restore defaults","8,9,10,11,12,13,16");
			}
		}catch(Exception e) {
			LOGGER.info("error in osSuspention");
			responseObject.put(STATUS+ERROR,e);

		}return responseObject;
	}
	
	@RequestMapping(path="/defaultGroupsDetails",method=RequestMethod.POST) 
	public Map<String,Object> groupsDetails(int customerId) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			List<Map<String,Object>> groupInfo=tableSetupService.getGroupDetails(customerId);
			responseObject.put("GroupDetails",groupInfo);
			return responseObject;
		}catch(Exception e) {
			LOGGER.info("error in defaultGroupsDetails");
			responseObject.put(STATUS+ERROR,e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/customerServiceLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> getCustomerServiceLeftPanel() {
		Map<String, Object> responseObject = new HashMap<>();

		//List<LeftPanelTableSetupModel> customerService = new ArrayList<>();
		List<CustomerServiceLeftPanelModel> childList = new ArrayList<>();
		
		try {
			LeftPanelTableSetupModel Model = new LeftPanelTableSetupModel();
			Model.setId(0);
			Model.setTitle("customerservice");

			CustomerServiceLeftPanelModel cusomerServiceModel = new CustomerServiceLeftPanelModel();
			cusomerServiceModel.setId(1);
			cusomerServiceModel.setTitle("customer");
			
			List<CustomerServiceLeftPanelModel> customerSubList = new ArrayList<>();
			
			CustomerServiceLeftPanelModel addressStatusModel = new CustomerServiceLeftPanelModel();
			addressStatusModel.setId(1);
			addressStatusModel.setTitle("addressstatus");
			addressStatusModel.setData(tableSetupService.getAddressStatusDetails(null));
			customerSubList.add(addressStatusModel);
		
			CustomerServiceLeftPanelModel addressTypesModel = new CustomerServiceLeftPanelModel();
			addressTypesModel.setId(2);
			addressTypesModel.setTitle("addressTypes");
			addressTypesModel.setData(tableSetupService.getAddressTypeDetails(null));
			customerSubList.add(addressTypesModel);
			
			CustomerServiceLeftPanelModel attachmentCategoriesModel = new CustomerServiceLeftPanelModel();
			attachmentCategoriesModel.setId(3);
			attachmentCategoriesModel.setTitle("attachmentCategories");
			attachmentCategoriesModel.setData(tableSetupService.getAttachmentCatagoryDetails(null));
			customerSubList.add(attachmentCategoriesModel);
			
			
			CustomerServiceLeftPanelModel  auxiliaryFieldsModel = new CustomerServiceLeftPanelModel();
			auxiliaryFieldsModel.setId(4);
			auxiliaryFieldsModel.setTitle("auxiliaryFields");
			auxiliaryFieldsModel.setData(tableSetupService.getAuxFieldDetails(null));
			customerSubList.add(auxiliaryFieldsModel);
			
			
			CustomerServiceLeftPanelModel  creditStatusModel = new CustomerServiceLeftPanelModel();
			creditStatusModel.setId(5);
			creditStatusModel.setTitle("creditStatus");
			creditStatusModel.setData( tableSetupService.getCreditStatusDetails(null));
			customerSubList.add(creditStatusModel);
			
			
			CustomerServiceLeftPanelModel  customerCategoryModel = new CustomerServiceLeftPanelModel();
			customerCategoryModel.setId(6);
			customerCategoryModel.setTitle("customerCategory");
			customerCategoryModel.setData( tableSetupService.getCustomerCategoryDetails(null));
			customerSubList.add(customerCategoryModel);
			
			CustomerServiceLeftPanelModel   rentalCategoryModel = new CustomerServiceLeftPanelModel();
			rentalCategoryModel.setId(7);
			rentalCategoryModel.setTitle("rentalCategory");
			rentalCategoryModel.setData(tableSetupService.getRentalCategoryDetails(null));
			customerSubList.add(rentalCategoryModel);
			
			CustomerServiceLeftPanelModel   loginQuestionModel = new CustomerServiceLeftPanelModel();
			loginQuestionModel.setId(8);
			loginQuestionModel.setTitle("loginQuestion");
			loginQuestionModel.setData(tableSetupService.getLoginQuestionDetails(0));
			customerSubList.add(loginQuestionModel);
			
			
			List<Map<String, Object>>  lookUpForCustomerList = new ArrayList<>();
			Map<String,Object>   lookUpForCustomerMap = new HashMap<>();
			lookUpForCustomerList.add(lookUpForCustomerMap);
			CustomerServiceLeftPanelModel   lookUpForCustomerModel = new CustomerServiceLeftPanelModel();
			lookUpForCustomerModel.setId(9);
			lookUpForCustomerModel.setTitle("lookUpForCustomer");
			lookUpForCustomerMap.put("lookUpForCustomerDefaultDetails",tableSetupService.getDefalutDetails(null));
			lookUpForCustomerMap.put("lookUpForCustomerSearchFieldGroup",tableSetupService.getSerachFieldGroup(null));
			lookUpForCustomerMap.put("lookUpForCustomerSearchResultDisplay",tableSetupService.getSearchResultDisplay(null));
			lookUpForCustomerModel.setData(lookUpForCustomerList);
			customerSubList.add(lookUpForCustomerModel);
			

			  List<Map<String, Object>> lookUpCustomerforTransferList = new ArrayList<>();
			  Map<String,Object>   lookUpCustomerforTransferMap = new HashMap<>();
			  lookUpCustomerforTransferList.add(lookUpCustomerforTransferMap);
			  CustomerServiceLeftPanelModel   lookUpCustomerforTransferModel = new CustomerServiceLeftPanelModel();
			  lookUpCustomerforTransferModel.setId(10);
			  lookUpCustomerforTransferModel.setTitle("lookUpCustomerforTransfer");
			  lookUpCustomerforTransferMap.put("lookUpForCustomerTranferDefaultDetails",tableSetupService.getDefalutDetails(null));
			  lookUpCustomerforTransferMap.put("lookUpForCustomerTransferSearchFieldGroup",tableSetupService.getSerachFieldGroup(null));
			  lookUpCustomerforTransferMap.put("lookUpForCustomerTransferSearchResultDisplay",tableSetupService.getSearchResultDisplay(null));
			  lookUpCustomerforTransferModel.setData(lookUpCustomerforTransferList);
			  customerSubList.add(lookUpCustomerforTransferModel);
			 
			 
			 List<Map<String, Object>> lookUpforGroupsList = new ArrayList<>();
			 Map<String,Object>  lookUpforGroupsMap = new HashMap<>();
			 lookUpforGroupsList.add(lookUpforGroupsMap);
			 CustomerServiceLeftPanelModel   lookUpforGroupsModel = new CustomerServiceLeftPanelModel();
			 lookUpforGroupsModel.setId(11);
			 lookUpforGroupsModel.setTitle("lookUpforGroups");
			 lookUpforGroupsMap.put("lookUpForGroupsDefaultDetails",tableSetupService.getDefalutDetails(null));
			 lookUpforGroupsMap.put("lookUpForGroupsSearchFieldGroup",tableSetupService.getSerachFieldGroup(null));
			 lookUpforGroupsMap.put("lookUpForGroupsSearchResultDisplay",tableSetupService.getSearchResultDisplay(null));
			 lookUpforGroupsModel.setData(lookUpforGroupsList);
			 customerSubList.add(lookUpforGroupsModel);
			
			 List<Map<String, Object>>  matchCodeList = new ArrayList<>();
			 Map<String,Object>    matchCodeMap = new HashMap<>();
			 matchCodeList.add(matchCodeMap);
			 CustomerServiceLeftPanelModel  matchCodeModel = new CustomerServiceLeftPanelModel();
			 matchCodeModel.setId(12);
			 matchCodeModel.setTitle("matchCode");
			 matchCodeMap.put("matchcode details",tableSetupService.getMatchCodeDetails(0));
			 matchCodeMap.put("matchCodeValues",tableSetupService.getMatchCodeValues(0));
			 matchCodeModel.setData(matchCodeList);
			 customerSubList.add(matchCodeModel);
			 
			 

			 CustomerServiceLeftPanelModel  prospectCategoriesModel = new CustomerServiceLeftPanelModel();
			 prospectCategoriesModel.setId(13);
			 prospectCategoriesModel.setTitle(" prospectCategories");
			 prospectCategoriesModel.setData(tableSetupService.getProspectCategoryDetails(null));
			 customerSubList.add( prospectCategoriesModel);
			 
			 CustomerServiceLeftPanelModel   salesRepresentativesModel = new CustomerServiceLeftPanelModel();
			 salesRepresentativesModel.setId(14);
			 salesRepresentativesModel.setTitle("salesRepresentatives");
			 salesRepresentativesModel.setData(tableSetupService.getsalesRepresentativeDetails(0));
			 customerSubList.add(salesRepresentativesModel);
			 
			 cusomerServiceModel.setNodes(customerSubList);
			
			
		    CustomerServiceLeftPanelModel orderClassModel = new CustomerServiceLeftPanelModel();
			orderClassModel.setId(2);
			orderClassModel.setTitle("orderclasses");
			
			List<CustomerServiceLeftPanelModel> orderClassSubList = new ArrayList<>();
			
			CustomerServiceLeftPanelModel profitCenterModel = new CustomerServiceLeftPanelModel();
			profitCenterModel.setId(1);
			profitCenterModel.setTitle("profitCenter");
			profitCenterModel.setData(tableSetupService.getProfitCenter(null));
			orderClassSubList.add(profitCenterModel);
			
			
			CustomerServiceLeftPanelModel sourceCodeFormatsModel = new CustomerServiceLeftPanelModel();
			sourceCodeFormatsModel.setId(2);
			sourceCodeFormatsModel.setTitle("sourceCodeFormats");
			sourceCodeFormatsModel.setData(tableSetupService.getSourceCodeFormats(null));
			orderClassSubList.add(sourceCodeFormatsModel);
			
			
			
			CustomerServiceLeftPanelModel topicsModel = new CustomerServiceLeftPanelModel();
			topicsModel.setId(3);
			topicsModel.setTitle("topics");
			topicsModel.setData(tableSetupService.getTopic(null));
			orderClassSubList.add(topicsModel);
			
			CustomerServiceLeftPanelModel  volumeGroupsModel = new CustomerServiceLeftPanelModel();
			volumeGroupsModel.setId(4);
			volumeGroupsModel.setTitle("volumeGroups");
			volumeGroupsModel.setData(tableSetupService.getVolumeGroup(0));
			orderClassSubList.add(volumeGroupsModel);
			
			orderClassModel.setNodes(orderClassSubList);
			
			
			CustomerServiceLeftPanelModel ordersModel = new CustomerServiceLeftPanelModel();
			ordersModel.setId(3);
			ordersModel.setTitle("orders");
			
			List<CustomerServiceLeftPanelModel> ordersSubList = new ArrayList<>();
			
			CustomerServiceLeftPanelModel  cancelReasonModel = new CustomerServiceLeftPanelModel();
			cancelReasonModel.setId(1);
			cancelReasonModel.setTitle("cancelReasons");
			cancelReasonModel.setData(tableSetupService.getCancelReason(null));
			ordersSubList.add(cancelReasonModel);

			CustomerServiceLeftPanelModel  cancellationPolicyModel = new CustomerServiceLeftPanelModel();
			cancellationPolicyModel.setId(2);
			cancellationPolicyModel.setTitle("cancellationPolicy");
			cancellationPolicyModel.setData(tableSetupService.getCancelPolicy());
			ordersSubList.add(cancellationPolicyModel);

			CustomerServiceLeftPanelModel  listPremiumsUsedModel = new CustomerServiceLeftPanelModel();
			 listPremiumsUsedModel.setId(3);
			 listPremiumsUsedModel.setTitle("listPremiumsUsed");
			 listPremiumsUsedModel.setData(tableSetupService.getPremiumUsed());
			ordersSubList.add(listPremiumsUsedModel);
			
			
			List<Map<String,Object>> orderClassLookupList= tableSetupService.getOrderDetails(null, 0, 0);
			CustomerServiceLeftPanelModel  lookUpforOrderClassModel = new CustomerServiceLeftPanelModel();
			lookUpforOrderClassModel.setId(4);
			lookUpforOrderClassModel.setTitle("lookUpforOrderClass");
			lookUpforOrderClassModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforOrderClassModel);


			CustomerServiceLeftPanelModel  lookUpforOrderCodeModel = new CustomerServiceLeftPanelModel();
			lookUpforOrderCodeModel.setId(5);
			lookUpforOrderCodeModel.setTitle("lookUpforOrderCode");
			lookUpforOrderCodeModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforOrderCodeModel);

            
			CustomerServiceLeftPanelModel  lookUpforOrderItemModel = new CustomerServiceLeftPanelModel();
			lookUpforOrderItemModel.setId(6);
			lookUpforOrderItemModel.setTitle("lookUpforOrderItem");
			lookUpforOrderItemModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforOrderItemModel);
			
			CustomerServiceLeftPanelModel  lookUpforSourceCodeModel = new CustomerServiceLeftPanelModel();
			lookUpforSourceCodeModel.setId(7);
			lookUpforSourceCodeModel.setTitle("lookUpforSourceCode");
			lookUpforSourceCodeModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforSourceCodeModel);
			
			CustomerServiceLeftPanelModel  lookUpforSubscriptionDefModel = new CustomerServiceLeftPanelModel();
			lookUpforSubscriptionDefModel.setId(8);
			lookUpforSubscriptionDefModel.setTitle("lookUpforSubscriptionDef");
			lookUpforSubscriptionDefModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforSourceCodeModel);
			
			CustomerServiceLeftPanelModel  lookUpforPackageDefModel = new CustomerServiceLeftPanelModel();
			lookUpforPackageDefModel.setId(9);
			lookUpforPackageDefModel.setTitle("lookUpforPackageDef");
			lookUpforPackageDefModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforPackageDefModel);
			
			CustomerServiceLeftPanelModel  lookUpforProductModel = new CustomerServiceLeftPanelModel();
			lookUpforProductModel.setId(10);
			lookUpforProductModel.setTitle("lookUpforProduct");
			lookUpforProductModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforProductModel);
			
			
			CustomerServiceLeftPanelModel  lookUpforIssueModel = new CustomerServiceLeftPanelModel();
			lookUpforIssueModel.setId(11);
			lookUpforIssueModel.setTitle("lookUpforIssue");
			lookUpforIssueModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforIssueModel);
			
			
			CustomerServiceLeftPanelModel  lookUpforAgencyModel = new CustomerServiceLeftPanelModel();
			lookUpforAgencyModel.setId(12);
			lookUpforAgencyModel.setTitle("lookUpforAgency");
			lookUpforAgencyModel.setData(orderClassLookupList);
			ordersSubList.add(lookUpforAgencyModel);
			
			CustomerServiceLeftPanelModel  orderCategoriesModel = new CustomerServiceLeftPanelModel();
			orderCategoriesModel.setId(13);
			orderCategoriesModel.setTitle("orderCategories");
			orderCategoriesModel.setData(tableSetupService.getOrderCategory(null));
			ordersSubList.add(orderCategoriesModel);
			
			CustomerServiceLeftPanelModel  subscriptionCategoriesModel = new CustomerServiceLeftPanelModel();
			subscriptionCategoriesModel.setId(14);
			subscriptionCategoriesModel.setTitle("subscriptionCategories");
			subscriptionCategoriesModel.setData(tableSetupService.getSubscriptionCategory(0));
			ordersSubList.add(subscriptionCategoriesModel);
			
			
			CustomerServiceLeftPanelModel  taxonomyModel = new CustomerServiceLeftPanelModel();
			taxonomyModel.setId(15);
			taxonomyModel.setTitle("taxonomy");
			taxonomyModel.setData(tableSetupService.getTaxonomy(null));
			ordersSubList.add(taxonomyModel);
			
			
			CustomerServiceLeftPanelModel  unitTypesModel = new CustomerServiceLeftPanelModel();
			 unitTypesModel.setId(16);
			 unitTypesModel.setTitle("unitTypes");
			 unitTypesModel.setData(tableSetupService.getUnitType(0));
			 ordersSubList.add(unitTypesModel);
			
			CustomerServiceLeftPanelModel  termModel = new CustomerServiceLeftPanelModel();
			termModel.setId(16);
			termModel.setTitle("term");
			termModel.setData(tableSetupService.getTerm(0));
			ordersSubList.add(termModel);
			

			CustomerServiceLeftPanelModel  upsellSuggestionModel = new CustomerServiceLeftPanelModel();
			upsellSuggestionModel.setId(17);
			upsellSuggestionModel.setTitle("upsellSuggestion");
			upsellSuggestionModel.setData(tableSetupService.getUpsellSuggestion(0));
			ordersSubList.add(upsellSuggestionModel);
			
			CustomerServiceLeftPanelModel   calenderCampaignModel = new CustomerServiceLeftPanelModel();
			calenderCampaignModel.setId(18);
			calenderCampaignModel.setTitle("calenderCampaign");
			calenderCampaignModel.setData(tableSetupService.getCalenderCampaign(0));
			ordersSubList.add(calenderCampaignModel);
			
			ordersModel.setNodes(ordersSubList);
			
			
			CustomerServiceLeftPanelModel paymentsModel = new CustomerServiceLeftPanelModel();
			paymentsModel.setId(4);
			paymentsModel.setTitle("payments");

			List<CustomerServiceLeftPanelModel> paymentsSubList = new ArrayList<>();
			
			CustomerServiceLeftPanelModel  paymentThresholdModel = new CustomerServiceLeftPanelModel();
			paymentThresholdModel.setId(1);
			paymentThresholdModel.setTitle("paymentThreshold");
			paymentThresholdModel.setData(tableSetupService.getPaymentThresholdDetails(null));
			paymentsSubList.add(paymentThresholdModel);
			
			
			CustomerServiceLeftPanelModel  paymentTypesModel = new CustomerServiceLeftPanelModel();
			paymentTypesModel.setId(2);
			paymentTypesModel.setTitle("paymentTypes");
			paymentTypesModel.setData(tableSetupService.getPaymentTypeDetails(null));
			paymentsSubList.add(paymentTypesModel);
			paymentsModel.setNodes(paymentsSubList);
			
			
			CustomerServiceLeftPanelModel quntityDiscountModel = new CustomerServiceLeftPanelModel();
			quntityDiscountModel.setId(5);
			quntityDiscountModel.setTitle("quntityDiscount");
			quntityDiscountModel.setData( tableSetupService.getQtyDiscountSchedule(null));
			

			CustomerServiceLeftPanelModel multiLineDiscountModel = new CustomerServiceLeftPanelModel();
			multiLineDiscountModel.setId(6);
			multiLineDiscountModel.setTitle("multiLineDiscount");
			multiLineDiscountModel.setData(tableSetupService.getMultilineDiscountSchedule(null));
			
			CustomerServiceLeftPanelModel serviceModel = new CustomerServiceLeftPanelModel();
			serviceModel.setId(7);
			serviceModel.setTitle("service");
			
			List<CustomerServiceLeftPanelModel>  serviceSubList = new ArrayList<>();
			
			CustomerServiceLeftPanelModel  causesModel = new CustomerServiceLeftPanelModel();
			causesModel.setId(1);
			causesModel.setTitle("causes");
			causesModel.setData(tableSetupService.getServiceCause(null));
			serviceSubList.add(causesModel);
			
			CustomerServiceLeftPanelModel  complaintsModel = new CustomerServiceLeftPanelModel();
			complaintsModel.setId(2);
			complaintsModel.setTitle("complaints");
			complaintsModel.setData(tableSetupService.getServiceComplaints(null));
			serviceSubList.add(complaintsModel);
			
			CustomerServiceLeftPanelModel  resolutionModel = new CustomerServiceLeftPanelModel();
			resolutionModel.setId(3);
			resolutionModel.setTitle("resolution");
		    resolutionModel.setData(tableSetupService.getServiceResolution(null));
			serviceSubList.add(resolutionModel);
			
			serviceModel.setNodes(serviceSubList);
			
			childList.add(cusomerServiceModel);
			childList.add(orderClassModel);
			childList.add(ordersModel);
			childList.add(paymentsModel);
			childList.add(quntityDiscountModel);
			childList.add(multiLineDiscountModel);
            childList.add(serviceModel);
			Model.setNodes(childList);

			responseObject.put("leftPanelMenuData", Model);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getCustomerService(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	

	
	@RequestMapping(path = "/dealsLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> getDealsLeftPanel() {
		
		Map<String, Object> responseObject = new HashMap<>();
		List<LeftPanelTableSetupModel> ParentRootMenu = new ArrayList<>();
		List<DealsLeftPanelModel> childRootMenu = new ArrayList<>();
		try {
			LeftPanelTableSetupModel model = new LeftPanelTableSetupModel();
			model.setId(0);
			model.setTitle("Deals");

			List<Map<String, Object>> dealTypesList = new ArrayList<>();
			Map<String, Object>  dealTypesMap = new HashMap<>();
			dealTypesList.add(dealTypesMap);
			DealsLeftPanelModel dealTypesmodel = new DealsLeftPanelModel();
			dealTypesmodel.setId(1);
			dealTypesmodel.setTitle(" dealTypes");
			dealTypesMap.put("dealTypes", tableSetupService.getDealTypeDetails(null));
			dealTypesmodel.setData(dealTypesList);
			childRootMenu.add(dealTypesmodel);
			
			List<Map<String, Object>> dealStatusesList = new ArrayList<>();
			Map<String, Object>  dealStatusesMap = new HashMap<>();
			dealStatusesList.add(dealStatusesMap);
			DealsLeftPanelModel dealStatusesmodel = new DealsLeftPanelModel();
			dealStatusesmodel.setId(2);
			dealStatusesmodel.setTitle("dealStatuses");
			dealStatusesMap.put("dealStatuses", tableSetupService.getDealStatusDetails(null));
			dealStatusesmodel.setData(dealStatusesList);
			childRootMenu.add(dealStatusesmodel);
		    ParentRootMenu.add(model);
			model.setNodes(childRootMenu);

			responseObject.put("leftPanelMenuData", ParentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealsLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/defaultSettingsLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> getDefaultSettingsLeftPanel() {
		
		Map<String, Object> responseObject = new HashMap<>();
		List<LeftPanelTableSetupModel> ParentRootMenu = new ArrayList<>();
		List<DefaultSettingsLeftPanelModel> childRootMenu = new ArrayList<>();
		try {
			LeftPanelTableSetupModel model = new LeftPanelTableSetupModel();
			model.setId(0);
			model.setTitle("DefaultSettings");

			List<Map<String, Object>> customersList = new ArrayList<>();
			Map<String, Object>   customersMap = new HashMap<>();
			customersList.add(customersMap);
			DefaultSettingsLeftPanelModel  customersModel = new  DefaultSettingsLeftPanelModel();
			customersModel.setId(1);
			customersModel.setTitle("customers");
			customersMap.put("customers", tableSetupService.getCustomersDetails(null));
			customersModel.setData(customersList);
			childRootMenu.add(customersModel);
			
			List<Map<String, Object>> groupsList = new ArrayList<>();
			Map<String, Object>   groupsMap = new HashMap<>();
			groupsList.add(groupsMap);
			DefaultSettingsLeftPanelModel  groupsModel = new  DefaultSettingsLeftPanelModel();
			groupsModel.setId(2);
			groupsModel.setTitle("groups");
	        groupsMap.put("groups",tableSetupService.getGroupDetails(0));
			groupsModel.setData(groupsList);
			childRootMenu.add(groupsModel);
			
			List<Map<String, Object>> accountingList = new ArrayList<>();
			Map<String, Object>   accountingMap = new HashMap<>();
			accountingList.add(accountingMap);
			DefaultSettingsLeftPanelModel  accountingModel = new  DefaultSettingsLeftPanelModel();
			accountingModel.setId(3);
			accountingModel.setTitle("accounting");
			accountingMap.put("accounting",tableSetupService.getAccountingDetails(null));
			accountingModel.setData(accountingList);
			childRootMenu.add(accountingModel);
			 
			List<Map<String, Object>>  paymentList = new ArrayList<>();
			Map<String, Object>   paymentMap = new HashMap<>();
			paymentList.add(paymentMap);
			DefaultSettingsLeftPanelModel  paymentModel = new  DefaultSettingsLeftPanelModel();
			paymentModel.setId(4);
			paymentModel.setTitle("payment");
			paymentMap.put("payment",tableSetupService.getPaymentDetails(null));
			paymentModel.setData(paymentList);
			childRootMenu.add(paymentModel);
			
			
			List<Map<String, Object>>  taxList = new ArrayList<>();
			Map<String, Object>   taxMap = new HashMap<>();
			taxList.add(taxMap);
			DefaultSettingsLeftPanelModel  taxModel = new  DefaultSettingsLeftPanelModel();
			taxModel.setId(5);
			taxModel.setTitle("tax");
			taxMap.put("tax",tableSetupService.getTaxTypes(null));
			taxModel.setData(taxList);
			childRootMenu.add(taxModel);
			
			List<Map<String, Object>>  inventoryList = new ArrayList<>();
			Map<String, Object>   inventoryMap = new HashMap<>();
			inventoryList.add(inventoryMap);
			DefaultSettingsLeftPanelModel  inventoryModel = new  DefaultSettingsLeftPanelModel();
			inventoryModel.setId(6);
			inventoryModel.setTitle("inventory");
			inventoryMap.put("inventory",tableSetupService.getInventoryDetails(null));
			inventoryModel.setData(inventoryList);
			childRootMenu.add(inventoryModel);
			
			 List<Map<String, Object>>  processingList = new ArrayList<>();
			 Map<String, Object>    processingMap = new HashMap<>();
			 processingList.add( processingMap);
			 DefaultSettingsLeftPanelModel   processingModel = new  DefaultSettingsLeftPanelModel();
			 processingModel.setId(7);
			 processingModel.setTitle("processing");
			 processingMap.put("processing",tableSetupService.getProcessingDetails(null));
			 processingModel.setData(processingList);
			 childRootMenu.add(processingModel);
			
			 List<Map<String, Object>>  internetList = new ArrayList<>();
			 Map<String, Object>   internetMap = new HashMap<>();
			 internetList.add(internetMap);
			 DefaultSettingsLeftPanelModel  internetModel = new  DefaultSettingsLeftPanelModel();
			 internetModel.setId(8);
			 internetModel.setTitle("internet");
			 internetMap.put("internet",tableSetupService.getInternetDetails(null));
			 internetModel.setData(internetList);
			 childRootMenu.add(internetModel);
			 
			 List<Map<String, Object>>  licenseList = new ArrayList<>();
			 Map<String, Object>    licenseMap = new HashMap<>();
			 licenseList.add( licenseMap);
			 DefaultSettingsLeftPanelModel  licenseModel = new  DefaultSettingsLeftPanelModel();
			 licenseModel.setId(9);
			 licenseModel.setTitle("license");
			 licenseMap.put("license",tableSetupService.getLicenseCodeDetails(null));
			 licenseModel.setData( licenseList);
			 childRootMenu.add( licenseModel);
			 
			 List<Map<String, Object>>  customFieldsList = new ArrayList<>();
			 Map<String, Object>    customFieldsMap = new HashMap<>();
			 customFieldsList.add(customFieldsMap);
			 DefaultSettingsLeftPanelModel  customFieldsModel = new  DefaultSettingsLeftPanelModel();
			 customFieldsModel.setId(10);
			 customFieldsModel.setTitle("customFields");
			 customFieldsMap.put("customFields",tableSetupService.getCustomFieldDetails(null));
			 customFieldsModel.setData(customFieldsList);
			 childRootMenu.add(customFieldsModel);
			 
			 ParentRootMenu.add(model);
			 model.setLabels(childRootMenu);
			 responseObject.put("leftPanelMenuData",ParentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealsLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/shippingDeliveryandDistributionLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> shippingDeliveryandDistribution() {
		
		Map<String, Object> responseObject = new HashMap<>();
		List<LeftPanelTableSetupModel> ParentRootMenu = new ArrayList<>();
		List<ShippingDeliveryDistributionLeftPanelModel> childRootMenu = new ArrayList<>();
		try {
			LeftPanelTableSetupModel model = new LeftPanelTableSetupModel();
			model.setId(0);
			model.setTitle("shipping,DeliveryandDistribution");

			List<Map<String, Object>> deliveryMethodsList = new ArrayList<>();
			Map<String, Object>  deliveryMethodsMap = new HashMap<>();
			deliveryMethodsList.add(deliveryMethodsMap);
			ShippingDeliveryDistributionLeftPanelModel deliveryMethodsModel = new ShippingDeliveryDistributionLeftPanelModel();
			deliveryMethodsModel.setId(1);
			deliveryMethodsModel.setTitle("deliveryMethods");
			deliveryMethodsMap.put("deliveryMethods",tableSetupService.getDeliveryMethods(null));
			deliveryMethodsModel.setData(deliveryMethodsList);
			childRootMenu.add(deliveryMethodsModel);
			
			List<Map<String, Object>> distributionMethodsList = new ArrayList<>();
			Map<String, Object> distributionMethodsMap = new HashMap<>();
			distributionMethodsList.add(distributionMethodsMap);
			ShippingDeliveryDistributionLeftPanelModel distributionMethodsModel = new ShippingDeliveryDistributionLeftPanelModel();
			distributionMethodsModel.setId(2);
			distributionMethodsModel.setTitle("distributionMethods");
			distributionMethodsMap.put("distributionMethods",tableSetupService.getDistributionMethods(null, null));
			distributionMethodsModel.setData(distributionMethodsList);
			childRootMenu.add(distributionMethodsModel);
			
			List<Map<String, Object>>  shippingandHandlingList = new ArrayList<>();
			Map<String, Object> shippingandHandlingMap = new HashMap<>();
			shippingandHandlingList.add(shippingandHandlingMap);
			ShippingDeliveryDistributionLeftPanelModel shippingandHandlingModel = new ShippingDeliveryDistributionLeftPanelModel();
			shippingandHandlingModel.setId(3);
			shippingandHandlingModel.setTitle("shipping and Handling Methods");
			shippingandHandlingMap.put("shippingandHandling",tableSetupService.getShippingandHandlingMethods(null));
			shippingandHandlingModel.setData(shippingandHandlingList);
			childRootMenu.add(shippingandHandlingModel);
			
			 List<Map<String, Object>>  shippingPriceLists = new ArrayList<>();
			 Map<String, Object> shippingPriceListsMap = new HashMap<>();
			 shippingPriceLists.add(shippingPriceListsMap);
			 ShippingDeliveryDistributionLeftPanelModel  shippingPriceListsModel = new  ShippingDeliveryDistributionLeftPanelModel();
			 shippingPriceListsModel.setId(4);
			 shippingPriceListsModel.setTitle("shippingPriceLists");
			 shippingPriceListsMap.put("shippingPriceLists",tableSetupService.getShippingPriceList(null));
			 shippingPriceListsModel.setData(shippingPriceLists);
			 childRootMenu.add(shippingPriceListsModel);
			
			 List<Map<String, Object>>  mailingEntryPoints = new ArrayList<>();
			 Map<String, Object> mailingEntryPointsMap = new HashMap<>();
			 mailingEntryPoints.add(mailingEntryPointsMap);
			 ShippingDeliveryDistributionLeftPanelModel mailingEntryPointsModel = new ShippingDeliveryDistributionLeftPanelModel();
			 mailingEntryPointsModel.setId(5);
			 mailingEntryPointsModel.setTitle("mailingEntryPoints");
			 mailingEntryPointsMap.put("mailingEntryPoints",tableSetupService.getMailingEntryPoint(null));
			 mailingEntryPointsModel.setData(mailingEntryPoints);
			 childRootMenu.add(mailingEntryPointsModel);
			 
			 List<Map<String, Object>>  transportModesList = new ArrayList<>();
			 Map<String, Object>  transportModesMap = new HashMap<>();
			 transportModesList.add(transportModesMap);
			 ShippingDeliveryDistributionLeftPanelModel transportModesModel = new ShippingDeliveryDistributionLeftPanelModel();
			 transportModesModel.setId(6);
			 transportModesModel.setTitle("transportModes");
			 transportModesMap.put("transportMode",tableSetupService.getTransportMode(null));
			 transportModesModel.setData(transportModesList);
			 childRootMenu.add(transportModesModel);
			 
			 ParentRootMenu.add(model);
			 model.setNodes(childRootMenu);
			responseObject.put("leftPanelMenuData", ParentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealsLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/demographicsLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> getDemographicsLeftPanel() {
		Map<String, Object> responseObject = new HashMap<>();
		List<DemographicsLeftPanelModel> demoGraphicMenu = new ArrayList<>();
		try {
			 List<Map<String, Object>> demoGraphicsList = new ArrayList<>();
			 Map<String, Object>  demoGraphicsMap = new HashMap<>();
			 demoGraphicsList.add(demoGraphicsMap);
			 DemographicsLeftPanelModel  demoGraphicsModel = new   DemographicsLeftPanelModel();
			 demoGraphicsModel.setId(1);
			 demoGraphicsModel.setTitle("demoGraphics");
			 demoGraphicsMap.put("demoGraphicInfo", tableSetupService.getDemographicInfo(0,0));
			 demoGraphicsMap.put("DemQuestionDetails", tableSetupService.getDemQuestionDetails(0));
			 demoGraphicsModel.setData(demoGraphicsList);
			 demoGraphicMenu.add(demoGraphicsModel);
			 
           responseObject.put("leftPanelMenuData",demoGraphicMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in  getDemographicsLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/diaplayContextRedirectionLeftPanel", method = RequestMethod.POST)
	public Map<String, Object>  diaplayContextRedirectionLeftPanel() {
		Map<String, Object> responseObject = new HashMap<>();
		List<DiaplayContextRedirectionLeftPanelModel>  diaplayContextRedirectionMenu = new ArrayList<>();
		try {
			 List<Map<String, Object>>  diaplayContextRedirectionList = new ArrayList<>();
			 Map<String, Object>   diaplayContextRedirectionMap = new HashMap<>();
			 diaplayContextRedirectionList.add(diaplayContextRedirectionMap);
			 DiaplayContextRedirectionLeftPanelModel  diaplayContextRedirectionModel = new  DiaplayContextRedirectionLeftPanelModel();
			 diaplayContextRedirectionModel.setId(1);
			 diaplayContextRedirectionModel.setTitle("diaplayContextRedirection");
			 diaplayContextRedirectionMap.put("diaplayContextRedirection", tableSetupService.getDisplayctxRedirection(null));
			 diaplayContextRedirectionModel.setData(diaplayContextRedirectionList);
			 diaplayContextRedirectionMenu.add(diaplayContextRedirectionModel);
			 
			 responseObject.put("leftPanelMenuData",diaplayContextRedirectionMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in  getDemographicsLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/internationalandRegionalLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> internationalandRegionalLeftPanel() {
		
		Map<String, Object> responseObject = new HashMap<>();
		List<LeftPanelTableSetupModel> ParentRootMenu = new ArrayList<>();
		List<InternationalandRegionalLeftPanelModel> childRootMenu = new ArrayList<>();
		try {
			 LeftPanelTableSetupModel model = new LeftPanelTableSetupModel();
			 model.setId(0);
			 model.setTitle("internationalandRegional");

			 List<Map<String, Object>>  addressesList = new ArrayList<>();
			 Map<String, Object>  addressesMap = new HashMap<>();
			 addressesList.add( addressesMap);
			 InternationalandRegionalLeftPanelModel  addressesModel = new InternationalandRegionalLeftPanelModel();
			 addressesModel.setId(1);
			 addressesModel.setTitle("addresses");
			 addressesMap.put("addresses",tableSetupService.getAddress(0));
			 addressesModel.setData( addressesList);
			 childRootMenu.add(addressesModel);
		    
			
			 List<Map<String, Object>>  addressCleaningList = new ArrayList<>();
			 Map<String, Object> addressCleaningMap = new HashMap<>();
			 addressCleaningList.add(addressCleaningMap);
			 InternationalandRegionalLeftPanelModel   addressCleaningModel = new  InternationalandRegionalLeftPanelModel();
			 addressCleaningModel.setId(2);
			 addressCleaningModel.setTitle("addressCleaning");
			 addressCleaningMap.put("addressCleaning",tableSetupService.getAddressCleaning(0));
			 addressCleaningModel.setData(addressCleaningList);
			 childRootMenu.add(addressCleaningModel);
			 
			
			 List<Map<String, Object>>  countryCodesList = new ArrayList<>();
			 Map<String, Object> countryCodesMap = new HashMap<>();
			 countryCodesList.add(countryCodesMap);
			 InternationalandRegionalLeftPanelModel  countryCodesModel = new  InternationalandRegionalLeftPanelModel();
			 countryCodesModel.setId(3);
			 countryCodesModel.setTitle("countryCodes");
			 countryCodesMap.put("countryCodes",tableSetupService.getCountryCode());
			 countryCodesModel.setData(countryCodesList);
			 childRootMenu.add(countryCodesModel);
			 
			 List<Map<String, Object>>  countriesStatesList = new ArrayList<>();
			 Map<String, Object> countriesStatesMap = new HashMap<>();
			 countriesStatesList.add(countriesStatesMap);
			 InternationalandRegionalLeftPanelModel  countriesStatesModel = new  InternationalandRegionalLeftPanelModel();
			 countriesStatesModel.setId(4);
			 countriesStatesModel.setTitle("countriesStates");
			 countriesStatesMap.put("countriesStates",tableSetupService.getCountriesandStates(null));
			 countriesStatesModel.setData(countriesStatesList);
			 childRootMenu.add(countriesStatesModel );
			 
			 List<Map<String, Object>>  currenciesList = new ArrayList<>();
			 Map<String, Object>  currenciesMap = new HashMap<>();
			 currenciesList.add(currenciesMap);
			 InternationalandRegionalLeftPanelModel  currenciesModel = new  InternationalandRegionalLeftPanelModel();
			 currenciesModel.setId(5);
			 currenciesModel.setTitle("currencies");
			 currenciesMap.put("currencies",tableSetupService.getCurrencies(null));
			 currenciesModel.setData(currenciesList);
			 childRootMenu.add(currenciesModel);
			 
			 List<Map<String, Object>>  languageCodesList = new ArrayList<>();
			 Map<String, Object>  languageCodesMap = new HashMap<>();
			 languageCodesList.add(languageCodesMap);
			 InternationalandRegionalLeftPanelModel   languageCodesModel = new  InternationalandRegionalLeftPanelModel();
			 languageCodesModel.setId(6);
			 languageCodesModel.setTitle("languageCodes");
			 languageCodesMap.put("languageCodes",tableSetupService.getLanguageCodes(null));
			 languageCodesModel.setData(languageCodesList);
			 childRootMenu.add(languageCodesModel);
			 
		     ParentRootMenu.add(model);
			 model.setNodes(childRootMenu);
			responseObject.put("leftPanelMenuData", ParentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealsLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/labesLeftPanel", method = RequestMethod.POST)
	public Map<String, Object> labesLeftPanel() {
		
		Map<String, Object> responseObject = new HashMap<>();
		List<LeftPanelTableSetupModel> ParentRootMenu = new ArrayList<>();
		List<labesLeftPanelModel> childRootMenu = new ArrayList<>();
		try {
			 LeftPanelTableSetupModel model = new LeftPanelTableSetupModel();
			 model.setId(0);
			 model.setTitle("Labels");

			 List<Map<String, Object>>  labelFormatsList = new ArrayList<>();
			 Map<String, Object>  labelFormatsMap = new HashMap<>();
			 labelFormatsList.add(labelFormatsMap);
			 labesLeftPanelModel  labelFormatsModel = new  labesLeftPanelModel();
			 labelFormatsModel.setId(1);
			 labelFormatsModel.setTitle("labelFormats");
			 labelFormatsMap.put("labelFormats",tableSetupService.getLabelFormateDetails(null));
			 labelFormatsModel.setData(labelFormatsList);
			 childRootMenu.add(labelFormatsModel);
		    
			 List<Map<String, Object>>  labelGroupsList = new ArrayList<>();
			 Map<String, Object>  labelGroupsMap = new HashMap<>();
			 labelGroupsList.add(labelGroupsMap);
			 labesLeftPanelModel  labelGroupsModel = new  labesLeftPanelModel();
			 labelGroupsModel.setId(2);
			 labelGroupsModel.setTitle("labelGroups");
			 labelGroupsMap.put("labelGroups",tableSetupService.getlabelGroupDetails(null));
			 labelGroupsModel.setData(labelGroupsList);
			 childRootMenu.add(labelGroupsModel);
			 
			 List<Map<String, Object>>  labelKeylinesList = new ArrayList<>();
			 Map<String, Object>  labelKeylinesMap = new HashMap<>();
			 labelKeylinesList.add(labelKeylinesMap);
			 labesLeftPanelModel  labelKeylinesModel = new  labesLeftPanelModel();
			 labelKeylinesModel.setId(3);
			 labelKeylinesModel.setTitle("labelKeylines");
			 labelKeylinesMap.put("labelKeylines",tableSetupService.labelKeylineDetails(null));
			 labelKeylinesModel.setData(labelKeylinesList);
			 childRootMenu.add(labelKeylinesModel);
			 
			 ParentRootMenu.add(model);
			 model.setNodes(childRootMenu);
			responseObject.put("leftPanelMenuData", ParentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealsLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/taxesLeftPanel", method = RequestMethod.POST)
	public Map<String, Object>  taxesLeftPanel() {
		
		Map<String, Object> responseObject = new HashMap<>();
		List<LeftPanelTableSetupModel> ParentRootMenu = new ArrayList<>();
		List<TaxesLeftPanelModel> childRootMenu = new ArrayList<>();
		try {
			 LeftPanelTableSetupModel model = new LeftPanelTableSetupModel();
			 model.setId(0);
			 model.setTitle("Taxes");

			 List<Map<String, Object>>  commodityCodesList = new ArrayList<>();
			 Map<String, Object>  commodityCodesMap = new HashMap<>();
			 commodityCodesList.add(commodityCodesMap);
			 TaxesLeftPanelModel    commodityCodesModel = new  TaxesLeftPanelModel();
			 commodityCodesModel.setId(1);
			 commodityCodesModel.setTitle("commodityCodes");
			 commodityCodesMap.put("commodityCodes",tableSetupService.getCommodityCode(0));
			 commodityCodesModel.setData(commodityCodesList);
			 childRootMenu.add(commodityCodesModel);
		    
			 List<Map<String, Object>>  jurisdictionsList = new ArrayList<>();
			 Map<String, Object> jurisdictionsMap = new HashMap<>();
			 jurisdictionsList.add(jurisdictionsMap);
			 TaxesLeftPanelModel jurisdictionsModel = new TaxesLeftPanelModel();
			 jurisdictionsModel.setId(2);
			 jurisdictionsModel.setTitle("jurisdictions");
			 jurisdictionsMap.put("jurisdictions",tableSetupService.getJurisdiction(null));
			 jurisdictionsModel.setData(jurisdictionsList);
			 childRootMenu.add(jurisdictionsModel);
			 
			 List<Map<String, Object>>  specialTaxIdsList = new ArrayList<>();
			 Map<String, Object> specialTaxIdsMap = new HashMap<>();
			 specialTaxIdsList.add(specialTaxIdsMap);
			 TaxesLeftPanelModel  specialTaxIdsModel = new  TaxesLeftPanelModel();
			 specialTaxIdsModel.setId(3);
			 specialTaxIdsModel.setTitle("specialTaxIds");
			 specialTaxIdsMap.put("specialTaxIdsList",tableSetupService.getSpecialTax(null));
			 specialTaxIdsModel.setData(specialTaxIdsList);
			 childRootMenu.add(specialTaxIdsModel);
			 
			 List<Map<String, Object>>  taxHandlingList = new ArrayList<>();
			 Map<String, Object> taxHandlingMap = new HashMap<>();
			 taxHandlingList.add(taxHandlingMap);
			 TaxesLeftPanelModel  taxHandlingModel = new  TaxesLeftPanelModel();
			 taxHandlingModel.setId(4);
			 taxHandlingModel.setTitle("taxHandling");
			 taxHandlingMap.put("taxHandling",tableSetupService.getSpecialTax(null));
			 taxHandlingModel.setData(taxHandlingList);
			 childRootMenu.add(taxHandlingModel);
			 
			
			 List<Map<String, Object>>  taxRatesbyCountryandStatesList = new ArrayList<>();
			 Map<String, Object> taxRatesbyCountryandStatesMap = new HashMap<>();
			 taxRatesbyCountryandStatesList.add(taxRatesbyCountryandStatesMap);
			 TaxesLeftPanelModel  taxRatesbyCountryandStatesModel = new  TaxesLeftPanelModel();
			 taxRatesbyCountryandStatesModel.setId(5);
			 taxRatesbyCountryandStatesModel.setTitle("taxRatesbyCountryandStates");
			 taxRatesbyCountryandStatesMap.put("taxRatesbyCountryandStates",tableSetupService.getTaxRatesbyCountryandState(null));
			 taxRatesbyCountryandStatesModel.setData(taxRatesbyCountryandStatesList);
			 childRootMenu.add(taxRatesbyCountryandStatesModel);
			 
			 List<Map<String, Object>>  taxRateCategoriesList = new ArrayList<>();
			 Map<String, Object>  taxRateCategoriesMap = new HashMap<>();
			 taxRateCategoriesList.add(taxRateCategoriesMap);
			 TaxesLeftPanelModel taxRateCategoriesModel = new  TaxesLeftPanelModel();
			 taxRateCategoriesModel.setId(6);
			 taxRateCategoriesModel.setTitle("taxRateCategories");
			 taxRateCategoriesMap.put("taxRateCategories",tableSetupService.getTaxRateCategories(null));
			 taxRateCategoriesModel.setData(taxRateCategoriesList);
			 childRootMenu.add(taxRateCategoriesModel);
			 
			 List<Map<String, Object>>  taxTypesList = new ArrayList<>();
			 Map<String, Object> taxTypesMap = new HashMap<>();
			 taxTypesList.add(taxTypesMap);
			 TaxesLeftPanelModel  taxTypesModel = new TaxesLeftPanelModel();
			 taxTypesModel.setId(7);
			 taxTypesModel.setTitle("taxTypes");
			 taxTypesMap.put("taxTypes",tableSetupService.getTaxTypes(null));
			 taxTypesModel.setData(taxTypesList);
			 childRootMenu.add(taxTypesModel);
			 
			 ParentRootMenu.add(model);
			 model.setNodes(childRootMenu);
			responseObject.put("leftPanelMenuData", ParentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getDealsLeftPanel(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	

	@RequestMapping(path = "/defaultPsRenewalSave", method = RequestMethod.POST)
	public Map<String, Object> updatePsRenewal(@RequestParam("currency") String currency,
			@RequestParam("business_processes") int... business_processes) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = tableSetupService.Renewal(currency, business_processes);
			if (ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			} else {
				responseObject.put(STATUS, status);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/defaultPsBillingSave",method=RequestMethod.POST)
	public Map<String,Object> updatePsBilling(@RequestParam("currency") String currency,int... business_processes) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String status=tableSetupService.PsBillingUpdate(currency,business_processes);
			if(ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			}else {
				responseObject.put(STATUS, status);
			}return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/defaultOsLabelSave",method=RequestMethod.POST)
	public Map<String,Object> updateOsLabel(@RequestParam("currency") String currency,int... business_processes) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String status=tableSetupService.osLabelUpdate(currency,business_processes);
			if(ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			}else {
				responseObject.put(STATUS,status);
			}return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR +e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	@RequestMapping(path="/defaultOsBackLabelSave",method=RequestMethod.POST)
	public Map<String,Object> updateOsBackLabel(@RequestParam("currency") String currency,int... business_processes) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String status=tableSetupService.osBackLabelUpdate(currency,business_processes);
			if(ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			}else {
				responseObject.put(STATUS,status);
			}return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR +e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	@RequestMapping(path="/defaultOsRenewalSave",method=RequestMethod.POST)
	public Map<String,Object> updateOsRenewal(@RequestParam("currency") String currency,int...business_processes) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String status=tableSetupService.osRenewalUpdate(currency,business_processes);
			if(ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			}else {
				responseObject.put(STATUS,status);
			}return responseObject;
		}catch(Exception e) {
			LOGGER.info(ERROR +e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	@RequestMapping(path="/defaultOsBillingSave",method=RequestMethod.POST)
	public Map<String,Object> updateOsBilling(@RequestParam("currency") String currency,int...business_processes) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String status=tableSetupService.osBillingUpdate(currency,business_processes);
			if(ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			}else {
				responseObject.put(STATUS,status);
			}return responseObject;
		}catch(Exception e) {
			LOGGER.info(ERROR +e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/defaultOsCancellationSave",method=RequestMethod.POST)
	public Map<String,Object> updateOsCancellation(@RequestParam("currency") String currency,int...business_processes) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String status=tableSetupService.osCancellationUpdate(currency,business_processes);
			if(ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			}else {
				responseObject.put(STATUS,status);
			}return responseObject;
		}catch(Exception e) {
			LOGGER.info(ERROR +e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/defaultOsSuspensionSave",method=RequestMethod.POST)
	public Map<String,Object> updateOsSuspension(@RequestParam("currency") String currency,int...business_processes) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			String status=tableSetupService.osSuspensionUpdate(currency,business_processes);
			if(ERROR.equals(status)) {
				responseObject.put(STATUS, ERROR);
			}else {
				responseObject.put(STATUS,status);
			}return responseObject;
		}catch(Exception e) {
			LOGGER.info(ERROR +e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}


}