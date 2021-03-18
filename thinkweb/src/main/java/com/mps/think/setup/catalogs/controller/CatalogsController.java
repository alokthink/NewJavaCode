package com.mps.think.setup.catalogs.controller;

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
import com.mps.think.model.OrderCode;
import com.mps.think.model.SourceCode;
import com.mps.think.model.SubscriptionDefinition;
import com.mps.think.service.OrderSourceOfferService;
import com.mps.think.setup.controller.OrderClassDetailsController;
import com.mps.think.setup.catalogs.model.*;

import com.mps.think.setup.model.ParentOrderClassModel;
import com.mps.think.setup.catalogs.service.CatalogsService;
import com.mps.think.setup.service.OrderClassService;

@RestController
public class CatalogsController {
	
	private static Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogsController.class);
	
	
	
	
	@Autowired
	CatalogsService catalogsService;
	@Autowired
	OrderClassService orderClassService;
	@Autowired
	OrderClassDetailsController controller;
	
	@RequestMapping(path = "/searchCatalogCodeDetails", method = RequestMethod.POST)
	public Map<String, Object> searchCatalogCodeDetails(@RequestParam(value = "action") String action,
			@RequestParam(value = "sourceCodeId", required = false) Integer sourceCodeId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		String actionvalue = action.toLowerCase();
		System.out.println(actionvalue);
		try {
			
			switch (actionvalue) {
			case "all":
				
				List<DropdownModel> allCatalogCodeDetails = catalogsService.getCatalogCodeDetails(sourceCodeId, action);
				responseObject.put("catalogCodeDetails", allCatalogCodeDetails);
				break;
			case "active":
				List<DropdownModel> activeCatalogCodeDetails = catalogsService.getCatalogCodeDetails(sourceCodeId, action);
				responseObject.put("catalogCodeDetails", activeCatalogCodeDetails);
				break;
			case "inactive":
				List<DropdownModel> inactiveCatalogCodeDetails = catalogsService.getCatalogCodeDetails(sourceCodeId, action);
				responseObject.put("catalogCodeDetails", inactiveCatalogCodeDetails);
				break;
								
			}
		}
			catch (Exception e) {
				LOGGER.info("Error in searchCatalogcodeDetails() : " + e);
				responseObject.put(STATUS, ERROR + e);
				return responseObject;
			}
		return responseObject;

	}
	
	@RequestMapping(path = "/addnewCatalogCode", method = RequestMethod.POST)
	public Map<String, Object> addCatalogCode(ParentCatalogsModel catalogModel) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {
			status = catalogsService.addCatalogCode(catalogModel);
			responseObject.put("source_code", status);
			
			int status1 = catalogsService.savePremium(catalogModel);
			responseObject.put("product_table", status1);
			
			int status2=catalogsService.saveAgency(catalogModel);
			responseObject.put("agency_table", status2);
			
			int status3=catalogsService.saveSorceCodeState(catalogModel);
			responseObject.put("source_code_state", status3);
			
			if (status != 0 && status1!=0 && status2!=0 && status3!=0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.info("Error in addCatalogCode() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	
	
	@RequestMapping(path = "/getCatalogDataDetails", method = RequestMethod.POST)
	public Map<String, Object> getCatalogData(int sourceCodeId,@RequestParam(value = "orderCode", required = false) String orderCode,@RequestParam(value = "orderClass", required = false) String orderClass,@RequestParam(value = "orderCodeType", required = false) String orderCodeType,@RequestParam(value = "term", required = false) String term) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> catalogDetails = new ArrayList<>();
		
		List<DropdownModel> attributeValueDetails = new ArrayList<>();
		try {
			
			catalogDetails=catalogsService.getCatalogdetailsfromSourceCode(sourceCodeId);
			responseObject.put("SourceCodeDetails", catalogDetails);
			
			List<DropdownModel> SourceCodeFormatList = orderClassService.getSourceCodeFormat();
			responseObject.put("SourceCodeFormatList", SourceCodeFormatList);
			
			List<DropdownModel> sourceCodeAttributeValue =orderClassService.getSourceCodeAttributeValue();
			responseObject.put("entryCode", sourceCodeAttributeValue);
			
			//Find premium order code look up
			
			List<OrderCode> productPremiumDetails =catalogsService.getOrderCodeData(orderCode,orderClass,orderCodeType,term);
			responseObject.put("productPremiumDetails", catalogDetails);
			
			List<DropdownModel> agencyListDetails =orderClassService.getAgencyDetails();
			responseObject.put("agencyListDetails", agencyListDetails);
			
			List<DropdownModel> stateDetails =catalogsService.getState();
			responseObject.put("stateDetails", stateDetails);
			
			List<DropdownModel> SourceCodeStateDetails =orderClassService.getSourceCodeStateDetails(sourceCodeId);
			responseObject.put("SourceCodeStateDetails", SourceCodeStateDetails);
			
			List<DropdownModel> shippingDetails =catalogsService.getShippingMethod();
			responseObject.put("shippingDetails", shippingDetails);
			
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getCatalogData() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}
	
	@RequestMapping(path = "/saveCatalogContent", method = RequestMethod.POST)
	public Map<String, Object> saveCatalogContent(CatalogContentModel catalogModel) {
		int status = 0;
		Map<String, Object> responseObject = new HashMap<>();
		try {
	
			status=catalogsService.saveCatalogCode(catalogModel);
			if (status !=0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.info("Error in saveCatalogContent() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	
	}	
	
	
	
	@RequestMapping(path = "/getCatalogContentDetails", method = RequestMethod.POST)
	public Map<String, Object> getCatalogContent(int sourceCodeId,CatalogcontentLookUpModel lookupModel) {
		
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		List<Map<String, Object>> catalogcontentDetails = new ArrayList<>();
		List<Map<String, Object>> packageDefIdDetails=new ArrayList<>();
		List<OrderCode> orderCodeIdDetails=new ArrayList<>();
		List<DropdownModel> currencyDetails=new ArrayList<>();
		
		List<DropdownModel> attributeValueDetails = new ArrayList<>();
		
		String orderCode=lookupModel.getOrderClass();
		String orderClass=lookupModel.getOrderClass();
		String orerCodeType=lookupModel.getOrderCodeType();
		String term=lookupModel.getTerm();
		Long ocId1=lookupModel.getOcId1();
		String discountClass=lookupModel.getDiscountClass();
		String discountDescription=lookupModel.getDiscountDescription();
		Long discountClassId=lookupModel.getDiscountClassId();
		String rateClass=lookupModel.getRateClass();
		String rateDescription=lookupModel.getRateDescription();
		Long rateClassId=lookupModel.getRateClassId();
		Integer ocId=lookupModel.getOcId();
		Integer pkgDefId=lookupModel.getPkgDefId();
		
		try {
			catalogcontentDetails=catalogsService.getCatalogContentDetails(sourceCodeId);
			responseObject.put("catalogContentDetails", catalogcontentDetails);
			
			currencyDetails=catalogsService.getCurrencyDetails();
			
			responseObject.put("currencyDetails",currencyDetails);
			//for order code look up
			responseObject.put("OrderCodeId",orderCodeIdDetails=catalogsService.getOrderCodeData(orderCode, orderClass, orerCodeType, term));
			//for discount look up
			//responseObject.put("DiscountClassID",controller.searchDiscountClass(ocId1, discountClass, discountDescription, discountClassId));
			//for rate class look up
			//responseObject.put("RateClassID",controller.searchRateClass(ocId1, rateClass, rateDescription, rateClassId));
			////for issue detaila look up
			responseObject.put("IssueId",controller.getIssueDetails(ocId));
			//for subscription def look up
			responseObject.put("SubscriptionId",controller.getSubscriptionDef(ocId1));
			//for package definition look up
			responseObject.put("PackageDefinitionID",packageDefIdDetails=catalogsService.getpackageDefinationDetails( pkgDefId,  ocId));
			
			
			
			responseObject.put("ProductID",controller.productDetails(ocId));
			
		}
			catch (Exception e) {
		LOGGER.info("Error in getCatalogContent() : " + e);
		responseObject.put(STATUS, ERROR + e);
		return responseObject;
	}
		return responseObject;	
	
	
	
	
	}
	
	
	
	
}	
	
	


