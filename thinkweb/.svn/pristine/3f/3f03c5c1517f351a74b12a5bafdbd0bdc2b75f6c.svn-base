package com.mps.think.setup.catalogs.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.SourceCode;
import com.mps.think.model.SubscriptionDefinition;
import com.mps.think.setup.catalogs.model.*;


public interface CatalogsService {

	public List<DropdownModel> getCatalogCodeDetails(Integer sourceCodeId, String action) ;

	public int addCatalogCode(ParentCatalogsModel catalogModel);

	public int savePremium(ParentCatalogsModel catalogModel);

	public int saveAgency(ParentCatalogsModel catalogModel);

	public int saveSorceCodeState(ParentCatalogsModel catalogModel);
		
	public List<Map<String, Object>> getCatalogdetailsfromSourceCode(int sourceCodeId);

	public List<OrderCode> getOrderCodeData(String orderCode, String orderClass, String orderCodeType, String term);
	public List<DropdownModel> getShippingMethod();

	public int saveCatalogCode(CatalogContentModel catalogModel);

	public List<DropdownModel> getState();

	public List<Map<String, Object>> getCatalogContentDetails(int sourceCodeId);

	public List<DropdownModel> getCurrencyDetails();	

	public List<Map<String, Object>> getpackageDefinationDetails(int pkgDefId, int ocId);
}
