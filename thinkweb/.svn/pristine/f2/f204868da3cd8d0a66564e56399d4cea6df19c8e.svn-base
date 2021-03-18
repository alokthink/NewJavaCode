package com.mps.think.process.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.RenewalModel;
import com.mps.think.process.service.RenewalService;
import com.mps.think.process.serviceImpl.RenewalServiceImpl;
import com.mps.think.util.CustomerUtility;

@RestController
public class RenewalController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RenewalServiceImpl.class);
	@Autowired  RenewalService renewalService;
	
	@RequestMapping(path="/renewalDetails", method = RequestMethod.POST)
	public Map<String, Object> RenewalDetails(){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			List<RenewalModel> renewalList = renewalService.getRenewalDetails();
			responseObject.put("RenewalDetails", renewalList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/selectedRenewalDetails", method = RequestMethod.POST)
	public Map<String, Object> SelectedRenewal(@RequestParam("renewal_def") String renewal_def){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			List<RenewalModel> selectedRenewalList = renewalService.getSelectedRenewals(renewal_def);
			List<Map<String, Object>> showSelected = renewalService.getselectedValue(renewal_def);
			List<RenewalEffortModel> renewalEffortList= renewalService.getEffortDetails(renewal_def);
			responseObject.put("DefaultDetails", selectedRenewalList);
			responseObject.put("ShowSelected", showSelected);
			responseObject.put("EffortDetails", renewalEffortList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}


}
