package com.mps.think.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.dao.DocumentReferenceDao;
import com.mps.think.model.DocumentReferenceAttributeModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.service.DocumentReferenceService;

@Service("DocumentReferenceService")
public class DocumentReferenceServiceImpl implements DocumentReferenceService {
	
	@Autowired
	DocumentReferenceDao documentReferenceDao;

	@Override
	public List<Object> getDocumentReferenceList(String type,String limit) throws SQLException {
		return documentReferenceDao.getDocumentReferenceList(type,limit);
	}

	@Override
	public List<DropdownModel> getOperatorList() throws SQLException {
		return documentReferenceDao.getOperatorList();
	}

	@Override
	public List<DropdownModel> getAssignedToList() throws SQLException {
		return documentReferenceDao.getAssignedToList();
	}

	@Override
	public List<DropdownModel> getBatchTemplateList() throws SQLException {
		return documentReferenceDao.getBatchTemplateList();
	}

	@Override
	public List<Object> getSearchDocumentReferenceList(DocumentReferenceAttributeModel documentReferenceAttributeModel)
			throws SQLException {
		return documentReferenceDao.getSearchDocumentReferenceList(documentReferenceAttributeModel);
	}

	@Override
	public String editDocument(DocumentReferenceAttributeModel documentReferenceAttributeModel) throws SQLException {
		return documentReferenceDao.editDocument(documentReferenceAttributeModel);
	}

	@Override
	public String addDocument(DocumentReferenceAttributeModel documentReferenceAttributeModel) throws SQLException {
		return documentReferenceDao.addDocument(documentReferenceAttributeModel);
	}

	@Override
	public int getDescriptionCount(String description) throws SQLException {
		return documentReferenceDao.getDescriptionCount(description);
	}

}
