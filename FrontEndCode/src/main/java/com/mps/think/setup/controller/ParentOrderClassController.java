package com.mps.think.setup.controller;

import static com.mps.think.constants.SecurityConstants.STATUS;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.model.DiscountClassModel;
import com.mps.think.setup.model.OrderClassModel;
import com.mps.think.setup.model.ParentOrderClassModel;
import com.mps.think.setup.model.ProfitCenterModel;
import com.mps.think.setup.model.RateCardModel;
import com.mps.think.setup.model.RateClassModel;
import com.mps.think.setup.service.ParentOrderService;

@RestController
public class ParentOrderClassController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ParentOrderClassController.class);
	private static final String ERROR = "Error"; 
	@Autowired
	ParentOrderService parentOrderService;
	
	@RequestMapping(path= "/addSourceCode", method =RequestMethod.POST )
	public Map<String, Object> addSourceCode(ParentOrderClassModel parentOrderClassModel){
		int status = 0;
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			status = parentOrderService.addSourceCode(parentOrderClassModel);
			int sourceCodeId = parentOrderService.getSourceCodeId();
			if(status != 0) {
				 responseObject.put(STATUS,true);
				 responseObject.put("sourceCodeId",sourceCodeId);
			}else {
				responseObject.put(STATUS,false);
			}
			return responseObject;
		}catch(Exception e){
			LOGGER.info("Error in saveSourceCode() : " + e);
			 responseObject.put(STATUS, ERROR + e);
			 return responseObject;
		 }
	}
	
	@RequestMapping(path= "/updateSourceCode", method =RequestMethod.POST )
	public Map<String, Object> updateSourceCode(ParentOrderClassModel parentOrderClassModel){
		int status = 0;
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			status = parentOrderService.updateSourceCode(parentOrderClassModel);
			int sourceCodeId = parentOrderService.getSourceCodeId();
			if(status != 0) {
				 responseObject.put(STATUS,true);
				 responseObject.put("sourceCodeId",sourceCodeId);
			}else {
				responseObject.put(STATUS,false);
			}
			return responseObject;
		}catch(Exception e){
			LOGGER.info("Error in updateSourceCode() : " + e);
			 responseObject.put(STATUS, ERROR + e);
			 return responseObject;
		 }
	}
	
@RequestMapping(path = "/deleteSourceCode", method = RequestMethod.POST)
	public Map<String, Object> deleteSourceCode(Integer sourceCodeId) {
		Map<String, Object> responseObject = new HashMap<>();
		String status = "";
		try {
			 status = parentOrderService.deleteSourceCodeDetails(sourceCodeId);
			 int lastIndexOfColon = status.lastIndexOf(':');
			 int lastIndexOfFullstop = status.lastIndexOf('.');
			 if(status.equals("1")) {
				 responseObject.put(STATUS, true); 
				 responseObject.put("status","SourceCodeId("+sourceCodeId+") deleted successfully");
			 }else {
				 responseObject.put(STATUS, false); 
				 String returnStatus2 = status.substring(lastIndexOfColon, lastIndexOfFullstop);
				 returnStatus2 = returnStatus2.replaceAll("\"", "").replaceAll(":", "").trim();
				 responseObject.put("status", returnStatus2);
			 }
		     return responseObject;
		     
		    } catch (Exception e) {
		    	LOGGER.info("Error in deleteSourceCode(): " + e);
		    	responseObject.put(STATUS, ERROR + e);
		    	return responseObject;
		    }
	}

	@RequestMapping(path= "/orderClassSave", method =RequestMethod.POST )
	public Map<String, Object> addOrderClass(OrderClassModel orderClassModel){
		int status = 0;
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			status = parentOrderService.addOrderClass(orderClassModel);
			Integer ocId = parentOrderService.getOcId();
			if(status == 1){
				responseObject.put(STATUS,true);
				responseObject.put("ocId",ocId);
			}else {
				responseObject.put(STATUS,false);
			}
				 return responseObject;
		}
		 catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
	}
	
	@RequestMapping(path= "/profitCanterSave", method =RequestMethod.POST )
	public Map<String, Object> addProfitCenter(ProfitCenterModel profitCenterModel){
		boolean status = false;
		 Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			int i = parentOrderService.addProfitCenter(profitCenterModel);
				 responseObject.put(STATUS,status);
				 return responseObject;
		}
		 catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
	}
	
	@RequestMapping(path= "/addRateClassSave", method =RequestMethod.POST )
	public Map<String, Object> addRateClass(RateClassModel rateClassModel){
		int status = 0;
		 Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
				status = parentOrderService.addRateClass(rateClassModel);
				String regionList = rateClassModel.getRegionList();
				int rateClassId  = parentOrderService.getRateClassId();
				if(status == 0){
					responseObject.put(STATUS, false);
				}else{
					responseObject.put(STATUS, true);
					responseObject.put("rateClassId", rateClassId);
					responseObject.put("regionList", regionList);
				}
				return responseObject;
		}
		 catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
	}
	
	@RequestMapping(path= "/updateRateClassRecords", method =RequestMethod.POST )
	public Map<String, Object> updateRateClassRecords(RateClassModel rateClassModel){
	int status = 0; 
	Map<String, Object> responseObject = new HashMap<>();
	try{
		status = parentOrderService.updateRateClassRecords(rateClassModel);
		String regionList = rateClassModel.getRegionList();
		int rateClassId  = rateClassModel.getRateClassId();
		if(status == 0){
			responseObject.put(STATUS, false);
		}else{
			responseObject.put(STATUS, true);
			responseObject.put("rateClassId", rateClassId);
			responseObject.put("regionList", regionList);
		}
		return responseObject;
	}
	 catch(Exception e){
		 LOGGER.info("Error in updateRateClassRecords() : "+e);
		 responseObject.put(STATUS,ERROR+e);
		 return responseObject;
	 }
	
  }
	@RequestMapping(path= "/addRateCardSave", method =RequestMethod.POST )
	public Map<String, Object> addRateCard(RateCardModel rateCardModel){
		int status = 0;
		 Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			status = parentOrderService.addRateCard(rateCardModel);
			int rateClassId = rateCardModel.getRateClassId();
			int rateClassEffectiveSeq = rateCardModel.getRateClassEffectiveSeq();
			
			if(status == 0) {
				responseObject.put(STATUS,status);
			}else {
				responseObject.put(STATUS,status);
				responseObject.put("rateClassId", rateClassId);
				responseObject.put("rateClassEffectiveSeq", rateClassEffectiveSeq);
			}
		  return responseObject;
		}
		 catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
	}
	
	@RequestMapping(path= "/addDiscountClassSave", method =RequestMethod.POST )
	public Map<String, Object> discountClassSave(DiscountClassModel discountClassModel){
		int status = 0; 
		Map<String, Object> responseObject = new HashMap<>();
		try{
			String regionList = discountClassModel.getRegionList();
			status = parentOrderService.discountClassSave(discountClassModel);
			int discountId  = parentOrderService.getDiscountId();
			
			if(status == 0){
				responseObject.put(STATUS, false);
			}else{
				responseObject.put(STATUS, true);
				responseObject.put("discountId", discountId);
				responseObject.put("regionList", regionList);
			}
			return responseObject;
		}
		 catch(Exception e){
			 LOGGER.info("Error in discountClassSave(): "+e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
	}
	
	@RequestMapping(path= "/addOrderCodeSave", method =RequestMethod.POST )
	public Map<String, Object> addOrderCode(DiscountClassModel discountClassModel){
		boolean status = false;
		 Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			int i = parentOrderService.discountClassSave(discountClassModel);
				 responseObject.put(STATUS,status);
				 return responseObject;
		}
		 catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
	}
	
	@RequestMapping(path= "/updateOrderClass", method =RequestMethod.POST )
	public Map<String, Object> updateOrderClass(OrderClassModel orderClassModel){
		int status = 0;
		 Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			status = parentOrderService.addOrderClassSave(orderClassModel);
			if(status == 0){
				responseObject.put(STATUS,false);
			}else {
				responseObject.put(STATUS,true);
			}
				 return responseObject;
		}
		 catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
		
	}
	
}
