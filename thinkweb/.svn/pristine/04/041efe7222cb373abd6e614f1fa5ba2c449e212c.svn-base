package com.mps.think.setup.reports.controller;

import java.util.ArrayList;
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mps.think.setup.reports.model.LeftPanelReportsModel;
import com.mps.think.setup.reports.model.OrderClassReportsModel;
import com.mps.think.setup.reports.service.ReportsService;

@RestController

public class ReportsController {
	private static Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportsController.class);

	@Autowired
	ReportsService reportsService;
	
	@RequestMapping(path = "/subscriptionOcsDetails", method = RequestMethod.POST)
	public Map<String,Object> subscriptionOcs() {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		List<Map<String,Object>> subsriptionOcsDetail=new ArrayList<>();
		try {
			subsriptionOcsDetail=reportsService.getSubscriptionOcs();
			responseObject.put("subsriptionOcsDetail",subsriptionOcsDetail);
		}catch(Exception e) {
			LOGGER.info("error in subscriptionOcsDetails");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
			
	
	@RequestMapping(path="/subscriptionOcDelete",method=RequestMethod.POST)
		public Map<String,Object> deleteSubscriptionOcs(int ocId) {
			int status;
			Map<String,Object> responseObject=new LinkedHashMap<>();
			try {
				status=reportsService.deleteSubscriptionOc(ocId);
				if(status!=0) {
					responseObject.put(STATUS,true);
				}else {
					responseObject.put(STATUS,false);
				}
			}catch(Exception e) {
				LOGGER.info("error in subscriptionOcsDetails");
				responseObject.put(STATUS+ERROR,e);
			}return responseObject;
		}
	
	@RequestMapping(path="/productOcsDetails",method=RequestMethod.POST)
	public Map<String,Object> productOcs(){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			List<Map<String,Object>> productOcsDetails=reportsService.getProductOcsInfo();
			responseObject.put("productOcsDetails",productOcsDetails);
		}catch(Exception e) {
			LOGGER.info("error in the productOcsDetails");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	
	@RequestMapping(path="/productOcsDelete",method=RequestMethod.POST)
	public Map<String,Object> deleteProductOcs(int ocId){
		int status;
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			status=reportsService.deleteProductOc(ocId);
			if(status!=0) {
				responseObject.put(STATUS,true);
			}else {
			responseObject.put(STATUS,false);
		}
	}catch(Exception e) {
		LOGGER.info("error in productOcsDelete");
		responseObject.put(STATUS+ERROR,e);
	}return responseObject;
}
	
	@RequestMapping(path="/ratesDetails",method=RequestMethod.POST)
	public Map<String,Object> rates() {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			List<Map<String,Object>> rateRowDetails=reportsService.getRateDetails();
			responseObject.put("rateRowDetails",rateRowDetails);
		}catch(Exception e) {
			LOGGER.info("error in ratesDetails");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	
	@RequestMapping(path="/deleteRate",method=RequestMethod.POST)
	public Map<String,Object> rateDelete(int rateClassId) {
		int status;
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			status=reportsService.deleteRate(rateClassId);
			if(status!=0) {
				responseObject.put(STATUS,true);
			}else {
				responseObject.put(STATUS,false);

			}
		}catch(Exception e){
			LOGGER.info("error in deleteRate");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	
	@RequestMapping(path="/reportDiscountDetails",method=RequestMethod.POST) 
	public Map<String,Object> discount(){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			List<Map<String,Object>> discountRowDetails=reportsService.getDiscountInfo();
			responseObject.put("discountRowDetails",discountRowDetails);
		}catch(Exception e) {
			LOGGER.info("error in discountDetails");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	@RequestMapping(path="/deleteDiscount",method=RequestMethod.POST)
	public Map<String,Object> discountDelete(int discountClassId){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		int status=0;
		try {
			status=reportsService.deleteDiscountRow(discountClassId);
			if(status!=0) {
				responseObject.put(STATUS,true);
			}else {
				responseObject.put(STATUS,false);

			}
		}catch(Exception e) {
			LOGGER.info("error in deleteDiscount");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
		
	}
	
	@RequestMapping(path="/sourcesDetails",method=RequestMethod.POST) 
	public Map<String,Object> source(){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			List<Map<String,Object>> sourceRowsDetails=reportsService.getSource();
			responseObject.put("sourceRowsDetails",sourceRowsDetails);
		}catch(Exception e) {
			LOGGER.info("eeropr in sourcesDetails");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	@RequestMapping(path="/sourceDelete",method=RequestMethod.POST)
	public Map<String,Object> deleteSource(int sourceCodeId) {
		int status;
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			status=reportsService.deleteSourceRow(sourceCodeId);
			if(status!=0) {
				responseObject.put(STATUS,true);
			}else {
				responseObject.put(STATUS,false);

			}
		}catch(Exception e) {
			LOGGER.info("error in sourceDelete");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	@RequestMapping(path="/reportOrderCodeDetails",method=RequestMethod.POST)
	public Map<String,Object> orderCode() {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			List<Map<String,Object>> orderCodeRowDetail=reportsService.getOrderCode();
			responseObject.put("orderCodeRowDetail",orderCodeRowDetail);
		}catch(Exception e) {
			LOGGER.info("error in orderCodeDetails ");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	@RequestMapping(path="/reportorderCodeDelete",method=RequestMethod.POST) 
	public Map<String,Object> orderCodedelete(int orderCodeId) {
		int status;
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			status=reportsService.deleteOrderCode(orderCodeId);
			if(status!=0) {
				responseObject.put(STATUS,true);
			}else {
				responseObject.put(STATUS,false);

			}
		}catch(Exception e) {
			LOGGER.info("error in the reportorderCodeDelete" );
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	
	@RequestMapping(path="/translationsDetail",method=RequestMethod.POST)
	public Map<String,Object> translations(){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			List<Map<String,Object>> translationRowdetails=reportsService.getTranslations();
			responseObject.put("translationRowdetails",translationRowdetails);
		}catch(Exception e) {
			LOGGER.info("error in translationsDetail");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	
	@RequestMapping(path="/translationsDelete",method=RequestMethod.POST) 
	public Map<String,Object> translationsdelete(int keyPart1) {
		int status;
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			status=reportsService.deleteTranslations(keyPart1);
			if(status!=0) {
				responseObject.put(STATUS,true);
			}else {
				responseObject.put(STATUS,false);

			}
		}catch(Exception e) {
			LOGGER.info("error in the translationsDelete" );
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
	
	@RequestMapping(path="/reportsLeftPanel",method=RequestMethod.POST)
	public Map<String,Object> getReportsLeftPanel(){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		List<LeftPanelReportsModel> parentRootMenu=new ArrayList<>();
		List<OrderClassReportsModel> childMenu=new ArrayList<>();
		try {
			LeftPanelReportsModel model=new LeftPanelReportsModel();
			model.setId(0);
			model.setTitle("Order Class Reports");
			
			List<Map<String,Object>> subscriptionOcsList=new ArrayList<>();
			Map<String,Object> subscriptionOcsMap=new LinkedHashMap<>();
			subscriptionOcsList.add(subscriptionOcsMap);
			OrderClassReportsModel model1=new OrderClassReportsModel();
			model1.setId(1);
			model1.setTitle("Subscription OCs");
			subscriptionOcsMap.put("Subscription OCs",reportsService.getSubscriptionOcs());
			model1.setData(subscriptionOcsList);
			childMenu.add(model1);
			
			List<Map<String,Object>> ProductOCsList=new ArrayList<>();
			Map<String,Object> ProductOcsMap=new LinkedHashMap<>();
			ProductOCsList.add(ProductOcsMap);
			OrderClassReportsModel model2=new OrderClassReportsModel();
			model2.setId(2);
			model2.setTitle("Product OCs");
			ProductOcsMap.put("Product OCs",reportsService.getProductOcsInfo());
			model2.setData(ProductOCsList);
			childMenu.add(model2);
			
			List<Map<String,Object>> rateList=new ArrayList<>();
			Map<String,Object> rateMap=new LinkedHashMap<>();
			rateList.add(rateMap);
			OrderClassReportsModel model3=new OrderClassReportsModel();
			model3.setId(3);
			model3.setTitle("Rates");
			rateMap.put("Rates",reportsService.getRateDetails());
			model3.setData(rateList);
			childMenu.add(model3);
			
			List<Map<String,Object>> discountsList=new ArrayList<>();
			Map<String,Object> discountsMap=new LinkedHashMap<>();
			discountsList.add(discountsMap);
			OrderClassReportsModel model4=new OrderClassReportsModel();
			model4.setId(4);
			model4.setTitle("Discounts");
			discountsMap.put("Discounts",reportsService.getDiscountInfo());
			model4.setData(discountsList);
			childMenu.add(model4);
			
			List<Map<String,Object>> sourcesList=new ArrayList<>();
			Map<String,Object> sourcesMap=new LinkedHashMap<>();
			sourcesList.add(sourcesMap);
			OrderClassReportsModel model5=new OrderClassReportsModel();
			model5.setId(5);
			model5.setTitle("Sources");
			sourcesMap.put("Sources",reportsService.getSource());
			model5.setData(sourcesList);
			childMenu.add(model5);
			
			List<Map<String,Object>> orderCodesList=new ArrayList<>();
			Map<String,Object> orderCodeMap=new LinkedHashMap<>(); 
			orderCodesList.add(orderCodeMap);
			OrderClassReportsModel model6=new OrderClassReportsModel();
			model6.setId(6);
			model6.setTitle("Order Codes");
			orderCodeMap.put("Order Codes",reportsService.getOrderCode());
			model6.setData(orderCodesList);
			childMenu.add(model6);
			
			List<Map<String,Object>> translationsList=new ArrayList<>();
			Map<String,Object> translationsMap=new LinkedHashMap<>();
			translationsList.add(translationsMap);
			OrderClassReportsModel model7=new OrderClassReportsModel();
			model7.setId(7);
			model7.setTitle("Translations");
			translationsMap.put("Translations",reportsService.getTranslations());
			model7.setData(translationsList);
			childMenu.add(model7); 
			
			
			parentRootMenu.add(model);
			model.setNodes(childMenu);
			
			responseObject.put("leftPanelMenuData",parentRootMenu);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
			
		}catch(Exception e) {
			LOGGER.info("error in reportsLeftPanel");
			responseObject.put(STATUS+ERROR,e);
		}return responseObject;
	}
}