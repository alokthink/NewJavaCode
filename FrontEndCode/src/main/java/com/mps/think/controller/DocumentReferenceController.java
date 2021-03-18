package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.model.DocumentReferenceAttributeModel;
import com.mps.think.service.CustomerSearchService;
import com.mps.think.service.DocumentReferenceService;
@RestController
public class DocumentReferenceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentReferenceController.class);
	
	@Autowired
	DocumentReferenceService documentReferenceService;
	
	@Autowired
	CustomerSearchService customerSearchService;
	
	@RequestMapping(value="/showAllDocumentReferenceList", method = RequestMethod.POST)
	public Map<String, Object> showAllDocumentReferenceList(@RequestParam(value="documentReferenceId", required = false) Long documentReferenceId,@RequestParam(value="documentReferenceDialogue", required = false) String documentReferenceDialogue
			,@RequestParam(value="limit") String limit)

	{
		Map<String, Object> responseObject = new LinkedHashMap<>(); 
		try {
			responseObject.put("documentReferenceList",documentReferenceService.getDocumentReferenceList("all",limit));	
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR+e);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/searchDocumentReference", method = RequestMethod.POST)
	public Map<String, Object> searchDocumentReference(@RequestParam(value="documentReferenceId", required = false) Long documentReferenceId,@RequestParam(value="documentReferenceDialogue", required = false) String documentReferenceDialogue
			,@RequestParam(value="limit") String limit)
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			responseObject.put("documentReferenceList",documentReferenceService.getDocumentReferenceList("default",limit));
			DocumentReferenceAttributeModel documentReferenceAttributeModel = new DocumentReferenceAttributeModel(); 
			documentReferenceAttributeModel.setOperatorList(documentReferenceService.getOperatorList());
			documentReferenceAttributeModel.setAssignedToList(documentReferenceService.getAssignedToList());
			documentReferenceAttributeModel.setBatchTemplateList(documentReferenceService.getBatchTemplateList());
			responseObject.put("documentReferenceAttributeModel",documentReferenceAttributeModel);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR+e);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/searchDocumentReferenceList", method = RequestMethod.POST)
	public Map<String, Object> searchDocumentReferenceList(DocumentReferenceAttributeModel documentReferenceAttributeModel)

	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			responseObject.put("documentReferenceList",documentReferenceService.getSearchDocumentReferenceList(documentReferenceAttributeModel));
			documentReferenceAttributeModel.setOperatorList(documentReferenceService.getOperatorList());
			documentReferenceAttributeModel.setAssignedToList(documentReferenceService.getAssignedToList());
			documentReferenceAttributeModel.setBatchTemplateList(documentReferenceService.getBatchTemplateList());
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR+e);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/editDocumentReference", method = RequestMethod.POST)
	public  Map<String, Object> editDocumentReference(DocumentReferenceAttributeModel documentReferenceAttributeModel)

	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = documentReferenceService.editDocument(documentReferenceAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS, SUCCESS);
			}
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
		}
		return responseObject;
	}
	
	@RequestMapping(value="/addDocumentReference", method = RequestMethod.POST)
	public Map<String, Object> addDocumentReference(DocumentReferenceAttributeModel documentReferenceAttributeModel)

	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = documentReferenceService.addDocument(documentReferenceAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS, SUCCESS);
			}
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
		}
		return responseObject;
	}

	@RequestMapping(path = "/getDescriptionCount", method = RequestMethod.POST)
	public Map<String, Object> getDescriptionCount(
			@RequestParam("description") String description) {

		Map<String, Object> responseObject = new LinkedHashMap<>(); 
		try {
			responseObject.put("descriptionCount", documentReferenceService.getDescriptionCount(description));
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
		
	}
}
