package com.mps.think.setup.catalogs.dao;

import java.util.List;
import java.util.Map;

import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.SourceCode;
import com.mps.think.model.SubscriptionDefinition;
import com.mps.think.setup.catalogs.model.CatalogContentModel;
import com.mps.think.setup.catalogs.model.ParentCatalogsModel;

public interface CatalogsDao {

	public List<DropdownModel> getCatalogCodeDetails(Integer sourceCodeId, String action) ;

	public int addCatalogCode(ParentCatalogsModel catalogModel);

	public int savePremium(ParentCatalogsModel catalogModel);

	public int saveAgency(ParentCatalogsModel catalogModel);

	public int saveSorceCodeState(ParentCatalogsModel catalogModel);

	public List<OrderCode> getOrderCodeData(String orderCode, String orderClass, String orderCodeType, String term);

	public List<Map<String, Object>> getCatalogdetailsfromSourceCode(int sourceCodeId);

	List<DropdownModel> getShippingMethod();

	public int saveCatalogCode(CatalogContentModel catalogModel);

	public List<DropdownModel> getstate();

	public List<Map<String, Object>> getCatalogContentDetails(int sourceCodeId);

	public List<DropdownModel> getCurrencytDetails();

	
	public List<Map<String, Object>> getpackageDefinationDetails(int pkgDefId, int ocId);
	
		

}
