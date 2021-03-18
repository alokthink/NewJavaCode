package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mps.think.model.CustomerSearchAttributeModel;
import com.mps.think.model.DocumentReferenceAttributeModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.service.CustomerSearchService;
import com.mps.think.service.DocumentReferenceService;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.GeneralUtility;

import io.swagger.annotations.ApiOperation;

@RestController
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	CustomerSearchService customerSearchService;
	
	@Autowired
	DocumentReferenceService documentReferenceService;
	
	@Autowired
	CustomerUtility customerUtility;
	
	@Autowired
	GeneralUtility generalUtility;
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public Map<String, Object>  login(@RequestParam(value="username") String username,@RequestParam(value="password") String password)
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
		try {			
			 String url = "http://thinklogin.mps-think.com/loginJWT";
			 HttpPost post = new HttpPost(url);
			 
			
			 
			 List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			   urlParameters.add(new BasicNameValuePair("username", username));
			   urlParameters.add(new BasicNameValuePair("password", password));
			   
			   
			   post.setEntity(new UrlEncodedFormEntity(urlParameters));
			   
			   HttpClient client = HttpClientBuilder.create().build();
			   HttpResponse response = client.execute(post);
			   HttpEntity entity = response.getEntity();
			   if(entity!=null) {
				    String responseString = EntityUtils.toString(entity, "UTF-8");
				    Gson gson = new Gson();
				    JsonElement element = gson.fromJson (responseString, JsonElement.class);
				    JsonObject jsonObj = element.getAsJsonObject();
				    if("OK".equals(jsonObj.get("Status").getAsString())) {
					    responseObject.put("userCode",jsonObj.get("userCode").getAsString());
					    responseObject.put("publisher",jsonObj.get("publisher").getAsString());
					    responseObject.put("Token",jsonObj.get("Token").getAsString());
					    responseObject.put(STATUS,SUCCESS);
				    }
				    else {
				    	responseObject.put(STATUS,ERROR);
				    }
				}else {
					responseObject.put(STATUS,ERROR);
				}
			   
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}

	@RequestMapping(path="/dashboardcsr", method = RequestMethod.POST)
	public Map<String, Object>  dashboard(@RequestParam(value="documentReferenceId", required = false) Long documentReferenceId,@RequestParam(value="documentReferenceDialogue", required = false) String documentReferenceDialogue
			,@RequestParam(value="limit") String limit) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
		try {
				if(documentReferenceDialogue==null || "".equals(documentReferenceDialogue)) {
					documentReferenceDialogue=customerUtility.getdocumentReferenceDialogue(); 
					responseObject.put("documentReferenceDialogue",documentReferenceDialogue);
				}
				if("0".equals(documentReferenceDialogue)) {
					List<Object> documentReferenceList = documentReferenceService.getDocumentReferenceList("default",limit);
					responseObject.put("documentReferenceList",documentReferenceList);
					DocumentReferenceAttributeModel documentReferenceAttributeModel = new DocumentReferenceAttributeModel(); 
					documentReferenceAttributeModel.setOperatorList(documentReferenceService.getOperatorList());
					documentReferenceAttributeModel.setAssignedToList(documentReferenceService.getAssignedToList());
					documentReferenceAttributeModel.setBatchTemplateList(documentReferenceService.getBatchTemplateList());
					documentReferenceAttributeModel.setActive("true");
					documentReferenceAttributeModel.setCustomerService("true");
					documentReferenceAttributeModel.setBatch("true");
					responseObject.put("documentReferenceAttributeModel",documentReferenceAttributeModel);
					responseObject.put(STATUS,SUCCESS);
					return responseObject;
				}
				if("1".equals(documentReferenceDialogue) && documentReferenceId==null ) {
					documentReferenceId = customerUtility.getDocumentReferenceId();
					responseObject.put("documentReferenceId",documentReferenceId);
				}
				CustomerSearchAttributeModel customerSearchAttributeModel = new CustomerSearchAttributeModel();
				customerSearchAttributeModel.setSearchBy("Name");
				responseObject.put("customerSearchAttributeModel",customerSearchAttributeModel);
				List<DropdownModel> stateList = customerSearchService.getStateList();
				responseObject.put("stateList",stateList);	
				responseObject.put(STATUS,SUCCESS);
				return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@SuppressWarnings("static-access")
	 @ApiOperation(value = "Find Country by country code", notes="Find Country by country code")
	@RequestMapping(path="/sendMail", method = RequestMethod.POST)
	public Map<String, Object>  sendMail(@RequestParam(value="subject") String subject, @RequestParam(value="message") String message) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
		try {
			generalUtility.sendMail(subject, message);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}

}
