package com.mps.think.service;

import java.sql.SQLException;
import java.util.List;

import com.mps.think.model.DocumentReferenceAttributeModel;
import com.mps.think.model.DropdownModel;

public interface DocumentReferenceService {
	
	public List<Object> getDocumentReferenceList(String type,String limit)
			throws SQLException;
	public List<DropdownModel> getOperatorList()
			throws SQLException;
	public List<DropdownModel> getAssignedToList()
			throws SQLException;
	public List<DropdownModel> getBatchTemplateList()
			throws SQLException;
	public List<Object> getSearchDocumentReferenceList(DocumentReferenceAttributeModel documentReferenceAttributeModel)
			throws SQLException;
	public String editDocument(DocumentReferenceAttributeModel documentReferenceAttributeModel)
			throws SQLException;
	public String addDocument(DocumentReferenceAttributeModel documentReferenceAttributeModel)
			throws SQLException;
	public int getDescriptionCount(String description)
			throws SQLException;

}
