package com.mps.think.setup.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.model.DropdownModel;
import com.mps.think.setup.service.OrderClassService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class SearchController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	OrderClassService orderClassService;	
	
	/**
	 * To search Rate Class
	 * @author Chaman.Bharti
	 */
	@RequestMapping(path = "/searchRateClass", method = RequestMethod.POST)
	public Map<String, Object> searchRateClass(Long ocId, String rateClass, String rateDescription, Long rateClassId, String searchBy) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> searchedList = new ArrayList<>();
		try {
				switch (searchBy.trim()) {
				// search by oc id
				case "ocId":
					searchedList = orderClassService.searchRateClass(ocId);
					responseObject.put("searchByOcId", searchedList);
					break;
				// search by rate class or * wild card, in this case ocId is mandatory
				case "rateClass":
					searchedList = orderClassService.searchRateClass(ocId, rateClass);
					responseObject.put("searchByRateClass", searchedList);
					break;
				//search by rate description or * wild card, in this case ocId is mandatory
				case "rateDescription":
					searchedList = orderClassService.searchRateClass((long)ocId,rateDescription);
					responseObject.put("searchByRateDescripton", searchedList);
					break;
				//search by rateClass and description or * wild card, in this case ocId is mandatory
				case "rateClassAndDescription":
					searchedList = orderClassService.searchRateClass(ocId, rateClass, rateDescription);
					responseObject.put("searchByRateClassAndDescripton", searchedList);
					break;
				// search by rate class id, in this case oc is mandatory
				case "rateClassId":
					searchedList = orderClassService.searchRateClass(ocId, rateClassId);
					responseObject.put("searchByRateClassId", searchedList);
					break;
				default:
					responseObject.put("WrongSearch", "You have entered Invalid Search Key:"+searchBy);
					break;
				}
				responseObject.put(STATUS, true);
				return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in searchRateClass() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}
	
	/**
	 * To search Discount Class
	 * @author Chaman.Bharti
	 */
	@RequestMapping(path = "/searchDiscountClass", method = RequestMethod.POST)
	@ApiOperation(value = "searchDiscountClass", notes = "REST APIs related to Search Discount Class using flag 'ocId,discountClass,discountDescription!!!!")
	public Map<String, Object> searchDiscountClass(Long ocId, String discountClass, String discountDescription,Long discountClassId,String searchBy) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> searchedList = new ArrayList<>();
		try {
				switch (searchBy.trim()) {
				// search by oc id
				case "ocId":
					searchedList = orderClassService.searchDiscountClass(ocId);
					responseObject.put("searchByOcId", searchedList);
					break;
				// search by discount class or * wild card, in this case ocId is mandatory
				case "discountClass":
					searchedList = orderClassService.searchDiscountClass(ocId, discountClass);
					responseObject.put("searchByDiscountClass", searchedList);
					break;
				//search by discount description or * wild card, in this case ocId is mandatory
				case "discountDescription":
					searchedList = orderClassService.searchDiscountClass((long)ocId,discountDescription);
					responseObject.put("searchByDiscountDescripton", searchedList);
					break;
				//search by discountClass and description or * wild card, in this case ocId is mandatory
				case "discountClassAndDescription":
					searchedList = orderClassService.searchDiscountClass(ocId, discountClass, discountDescription);
					responseObject.put("searchByDiscountClassAndDescripton", searchedList);
					break;
				// search by discount class id, in this case oc is mandatory
				case "discountClassId":
					searchedList = orderClassService.searchDiscountClass(ocId, discountClassId);
					responseObject.put("searchByDiscountClassId", searchedList);
					break;
				default:
					responseObject.put("WrongSearch", "You have entered Invalid Search Key:"+searchBy);
					break;
				}
				responseObject.put(STATUS, true);
				return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in searchDiscountClass() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}
	
	/**
	 * To search Source Code
	 * @author Chaman.Bharti
	 */
	@RequestMapping(path = "/searchSourceCode", method = RequestMethod.POST)
	@ApiOperation(value = "To search source code", 
	notes = "searchBy in which you have to enter search criteria, you have to choose from one of these(default,sourceCode,orderClass,systemGenerated,offer,list), e.g searchBy='default'.ocId & searchBy are mandatory for every request", 
	response = Iterable.class)
	public Map<String, Object> searchSourceCode(
			Long ocId, 
			String searchBy,
			String sourceCode,
			Long ocId2,
			Integer flag,
			String offer,
			String list,
			Integer addressId,
			String description
			) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> searchedList = new ArrayList<>();
		try {
				int active=1;
				int sourceCodeType=2;
				switch (searchBy.trim()) {
				// at first time on clicking grid of promotion, in this case ocId is mandatory
				case "default":
					searchedList = orderClassService.searchSourceCode(ocId, active, sourceCodeType);
					responseObject.put("searchByDefault", searchedList);
					responseObject.put("orderClass", orderClassService.getOcDetails());
					responseObject.put("addressLookUp", orderClassService.addressLookUp());
					break;
				// search by sourceCode or * wild card, in this case sourceCode & ocId is mandatory
				case "sourceCode":
					searchedList = orderClassService.searchSourceCode(ocId, active, sourceCodeType,sourceCode);
					responseObject.put("searchBySourceCode", searchedList);
					break;
				//search by orderClass, in this case ocId & ocId2 are mandatory
				case "orderClass":
					searchedList = orderClassService.searchSourceCode(ocId, active, sourceCodeType,sourceCode,ocId2);
					responseObject.put("searchByOrderClass", searchedList);
					break;
				//search by systemGenerated,in this case ocId & flag are mandatory
				case "systemGenerated":
					searchedList = orderClassService.searchSourceCode(ocId, active, sourceCodeType, flag);
					responseObject.put("searchBySystemGenerated", searchedList);
					break;
				//search by source code & orderClass, in this case source code, ocId & ocId2 are mandatory
				case "sourceCode&OrderClass":
					searchedList = orderClassService.searchSourceCode(ocId, active, sourceCodeType,sourceCode,ocId2);
					responseObject.put("searchBySourceCode&OrderClass", searchedList);
					break;
				//search by source code & systemGenerated, in this case ocId,sourceCode,ocId2 & flag are mandatory
				case "sourceCode&SystemGenerated":
					searchedList = orderClassService.searchSourceCode(ocId, active, sourceCodeType,sourceCode,ocId2,flag);
					responseObject.put("searchBySourceCode&SystemGenerated", searchedList);
					break;
				//search by order class & systemGenerated, in this case ocId,ocId2 & flag are mandatory
				case "orderClass&SystemGenerated":
					searchedList = orderClassService.searchSourceCode(ocId, active, sourceCodeType,sourceCode,ocId2,flag);
					responseObject.put("searchBySourceCode&SystemGenerated", searchedList);
					break;
				//search by order class & systemGenerated, in this case ocId,sourceCode,ocId2 & flag are mandatory
				case "sourceCodeOrderClass&SystemGenerated":
					searchedList = orderClassService.searchSourceCode(ocId, active, sourceCodeType,sourceCode,ocId2,flag);
					responseObject.put("searchBySourceCode&SystemGenerated", searchedList);
					break;
				// search by offer, in this case offer & ocId is mandatory
				case "offer":
					searchedList = orderClassService.searchSourceCodeFromOfferList(ocId, active, sourceCodeType,offer);
					responseObject.put("searchByOffer", searchedList);
					break;
				//search by list
				case "list":
					searchedList = orderClassService.searchSourceCodeFromOfferList((long)ocId, active, sourceCodeType,list);
					responseObject.put("searchByList", searchedList);
					break;
				// search by order class, in this case ocId & ocId2 is mandatory
				case "orderClass_FromOfferList":
					searchedList = orderClassService.searchSourceCodeFromOfferList(ocId, active, sourceCodeType, ocId2);
					responseObject.put("searchByOrderClass", searchedList);
					break;
				//search by offer,list & order class, in this case ocId,offer,list & ocId2 are mandatory
				case "offerListOrderClass":
					searchedList = orderClassService.searchSourceCodeFromOfferList(ocId, active, sourceCodeType,offer, list, ocId2);
					responseObject.put("searchByOfferListOrderClass", searchedList);
					break;
				//search by offer & list, in this case ocId,offer & list are mandatory
				case "offerList":
					searchedList = orderClassService.searchSourceCodeFromOfferList(ocId, active, sourceCodeType,offer, list, ocId2);
					responseObject.put("searchByOfferListOrderClass", searchedList);
					break;
				//search by offer & order class, in this case ocId,offer & ocId2 are mandatory
				case "offerOrderClass":
					searchedList = orderClassService.searchSourceCodeFromOfferList(ocId, active, sourceCodeType,offer, list, ocId2);
					responseObject.put("searchByOfferOrderClass", searchedList);
					break;
				//search by list & order class, in this case ocId,list & ocId2 are mandatory
				case "listOrderClass":
					searchedList = orderClassService.searchSourceCodeFromOfferList(ocId, active, sourceCodeType,offer, list, ocId2);
					responseObject.put("searchByOfferOrderClass", searchedList);
					break;
				//search by address id & description, in this case ocId,id & description are mandatory
				case "addressIdDescription":
					searchedList = orderClassService.searchSourceCodeFromOfferList(ocId, active, sourceCodeType,offer, list, ocId2);
					responseObject.put("searchByAddressId&Description", searchedList);
					break;
				//search by address id, in this case ocId,id are mandatory
				case "addressId":
					searchedList = orderClassService.searchSourceCodeFromOfferList(ocId, active, sourceCodeType,offer, list, ocId2);
					responseObject.put("searchByAddressId", searchedList);
					break;
				//search by address id, in this case ocId,id are mandatory
				case "addressDescription":
					searchedList = orderClassService.addressLookUp(ocId, active, sourceCodeType,addressId, description);
					responseObject.put("searchByAddressDescription", searchedList);
					break;
				default:
					responseObject.put("WrongSearch", "You have entered Invalid Search Key:"+searchBy);
					break;
				}
				responseObject.put(STATUS, true);
				return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in searchSourceCode() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	/**
	 * To search search subscription definition
	 * @author Chaman.Bharti
	 */
	@RequestMapping(path = "/searchSubscriptionDef", method = RequestMethod.POST)
	public Map<String, Object> searchSubcriptionDef(int orderCodeId,Integer inactive,String description,Integer termId,String media,Integer categoryId,String searchBy) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> searchedList = new ArrayList<>();
		try {
				switch (searchBy.trim()) {
				// at first time on clicking grid of promotion offer, in this case orderCodeId is mandatory
				case "default":
					//searchBy is being used as action to call searchSubscriptionDef method
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByDefault", searchedList);
					responseObject.put("term", orderClassService.getDefaultTerm());
					responseObject.put("category", orderClassService.getSubscriptionCategory());
					break;
				// search by all 3 fields, in this case orderCodeId,description,termId,media & categoryId
				case "all":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByAll", searchedList);
					break;
				//search by descriptionTermMedia, in this case orderCodeId,description,termId,media are mandatory
				case "descriptionTermMedia":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByDescriptionTermMedia", searchedList);
					break;
				//search by descriptionTermMedia, in this case orderCodeId,description,termId are mandatory
				case "descriptionTerm":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByDescriptionTerm", searchedList);
					break;
				//search by descriptionMedia, in this case orderCodeId,description,media are mandatory
				case "descriptionMedia":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByDescriptionTerm", searchedList);
					break;
				//search by descriptionCategory, in this case orderCodeId,description,categoryId are mandatory
				case "descriptionCategory":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByDescriptionCategoryId", searchedList);
					break;
				//search by description, in this case orderCodeId,description are mandatory
				case "description":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByDescription", searchedList);
					break;
				//search by termMediaCategory, in this case orderCodeId,termId, media, categoryId are mandatory
				case "termMediaCategory":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByTermMediaCategory", searchedList);
					break;
				//search by termMedia, in this case orderCodeId,termId, media are mandatory
				case "termMedia":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByTermMedia", searchedList);
					break;
				//search by termCategory, in this case orderCodeId,termId & categoryId are mandatory
				case "termCategory":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByTermCategory", searchedList);
					break;
				//search by term, in this case orderCodeId,termId are mandatory
				case "term":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByTerm", searchedList);
					break;
				//search by mediaCategory, in this case orderCodeId,media,category id  are mandatory
				case "mediaCategory":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByMediaCategory", searchedList);
					break;
				//search by media, in this case orderCodeId & media are mandatory
				case "media":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByMedia", searchedList);
					break;
				//search by categoryMediaDescription, in this case orderCodeId,categoryId,media,description  are mandatory
				case "categoryMediaDescription":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByCategoryMediaDescription", searchedList);
					break;
				//search by term, in this case orderCodeId & categoryId are mandatory	
				case "category":
					searchedList = orderClassService.searchSubscriptionDef(orderCodeId, inactive, description, termId, media, categoryId,searchBy);
					responseObject.put("searchByCategory", searchedList);
					break;

				default:
					responseObject.put("WrongSearch", "You have entered Invalid Search Key:"+searchBy);
					break;
				}
				responseObject.put(STATUS, true);
				return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in searchSubcriptionDef() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	/**
	 * To search product
	 * @author Chaman.Bharti
	 */
	@RequestMapping(path = "/searchProduct", method = RequestMethod.POST)
	public Map<String, Object> searchProduct(String searchBy,int orderCodeId, String description,String style, String size,String color,String action) {

		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> searchedList = new ArrayList<>();
		try {
				switch (searchBy.trim()) {
				// at first time on clicking grid of promotion offer, in this case orderCodeId is mandatory
				case "default":
					//searchBy is being used as action to call searchProduct method
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByDefault", searchedList);
					break;
				//search by description,style,size & color
				case "all":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByAll", searchedList);
					break;
				//search by description, in this case orderCodeId,description are mandatory
				case "description":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByDescription", searchedList);
					break;
				//search by descriptionStyleSize, in this case orderCodeId,description,style,size are mandatory
				case "descriptionStyleSize":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByDescriptionStyleSize", searchedList);
					break;
				//search by descriptionSizeColor, in this case orderCodeId,description,size & color are mandatory
				case "descriptionSizeColor":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByDescriptionSizeColor", searchedList);
					break;
				//search by descriptionStyle, in this case case orderCodeId,description, style are mandatory
				case "descriptionStyle":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByDescriptionStyle", searchedList);
					break;
				//search by descriptionSize, in this case case orderCodeId,description, size are mandatory
				case "descriptionSize":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByDscriptionSize", searchedList);
					break;
				//search by termCategory, in this case orderCodeId,description & color are mandatory
				case "descriptionColor":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByDdescriptionColor", searchedList);
					break;
				case "styleSizeColor":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByStyleSizeColor", searchedList);
					break;
				case "styleSize":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByStyleSize", searchedList);
					break;
				case "style":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByStyle", searchedList);
					break;
				case "styleColor":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByStyleColor", searchedList);
					break;
				case "sizeColor":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchBySizeColor", searchedList);
					break;
				case "size":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchBySize", searchedList);
					break;
				case "color":
					searchedList = orderClassService.searchProduct(orderCodeId, description, style, size, color, searchBy);
					responseObject.put("searchByColor", searchedList);
					break;
				default:
					responseObject.put("WrongSearch", "You have entered Invalid Search Key:"+searchBy);
					break;
				}
				responseObject.put(STATUS, true);
				return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in searchProduct() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	/**
	 * To search package definition
	 * @author Chaman.Bharti
	 */
	@RequestMapping(path = "/searchPkgDef", method = RequestMethod.POST)
	public Map<String, Object> searchPkgDef(String searchBy,int orderCodeId, Integer active, Integer pkgDefId,String pkgDef, String description,String action) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> searchedList = new ArrayList<>();
		try {
				switch (searchBy.trim()) {
				// at first time on clicking grid of promotion offer, in this case orderCodeId is mandatory
				case "default":
					//searchBy is being used as action to call searchPkgDef method
					searchedList = orderClassService.searchPkgDef(orderCodeId, active, pkgDefId, pkgDef, description, searchBy);
					responseObject.put("searchByDefault", searchedList);
					break;
				//search by pkgDef & description, in this case orderCodeId,pkgDef,description are mandatory
				case "pkgDefDescription":
					searchedList = orderClassService.searchPkgDef(orderCodeId, active, pkgDefId, pkgDef, description, searchBy);
					responseObject.put("searchByPkgDefDescription", searchedList);
					break;
				//search by pkgDef, in this case orderCodeId & pkgDef are mandatory
				case "pkgDef":
					searchedList = orderClassService.searchPkgDef(orderCodeId, active, pkgDefId, pkgDef, description, searchBy);
					responseObject.put("searchByPkgDef", searchedList);
					break;
				//search by descriptionTermMedia, in this case orderCodeId,description,termId are mandatory
				case "description":
					searchedList = orderClassService.searchPkgDef(orderCodeId, active, pkgDefId, pkgDef, description, searchBy);
					responseObject.put("searchByDescription", searchedList);
					break;
				//search by descriptionMedia, in this case orderCodeId,description,media are mandatory
				case "pkgDefId":
					searchedList = orderClassService.searchPkgDef(orderCodeId, active, pkgDefId, pkgDef, description, searchBy);
					responseObject.put("searchByPkdDefId", searchedList);
					break;
				default:
					responseObject.put("WrongSearch", "You have entered Invalid Search Key:"+searchBy);
					break;
				}
				responseObject.put(STATUS, true);
				return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in searchSubcriptionDef() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	/**
	 * To Search Demographic
	 * @author Chaman.Bharti
	 */
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

}
