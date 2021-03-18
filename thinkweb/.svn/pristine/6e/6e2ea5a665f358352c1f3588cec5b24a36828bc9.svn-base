package com.mps.think.setup.catalogs.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.SourceCode;
import com.mps.think.model.SubscriptionDefinition;
import com.mps.think.setup.catalogs.dao.CatalogsDao;
import com.mps.think.setup.catalogs.model.CatalogContentModel;
import com.mps.think.setup.catalogs.model.ParentCatalogsModel;
import com.mps.think.setup.catalogs.service.CatalogsService;

@Service("CatalogsService")
public class CatalogsServiceImpl implements CatalogsService{
	@Autowired 
	CatalogsDao catalogsDao;

	@Override
	public List<DropdownModel> getCatalogCodeDetails(Integer sourceCodeId, String action) {
	return catalogsDao.getCatalogCodeDetails(sourceCodeId,action);
	}

	@Override
	public int addCatalogCode(ParentCatalogsModel catalogModel) {
		return catalogsDao.addCatalogCode(catalogModel);
	}

	@Override
	public int savePremium(ParentCatalogsModel catalogModel) {
		return catalogsDao.savePremium(catalogModel);
	}

	@Override
	public int saveAgency(ParentCatalogsModel catalogModel) {
		return catalogsDao.saveAgency(catalogModel);
	}

	@Override
	public int saveSorceCodeState(ParentCatalogsModel catalogModel) {
		return catalogsDao.saveSorceCodeState(catalogModel);
	}
	@Override
	public List<OrderCode> getOrderCodeData(String orderCode,String orderClass, String orderCodeType,String term) {
		return catalogsDao.getOrderCodeData(orderCode,orderClass,orderCodeType,term);
	}

	
	@Override
	public List<Map<String, Object>> getCatalogdetailsfromSourceCode(int sourceCodeId) {
		return catalogsDao.getCatalogdetailsfromSourceCode(sourceCodeId);
	}

	@Override
	public List<DropdownModel> getShippingMethod() {
		return catalogsDao. getShippingMethod();
	}

	@Override
	public int saveCatalogCode(CatalogContentModel catalogModel) {
		return catalogsDao.saveCatalogCode(catalogModel);		
	}

	@Override
	public List<DropdownModel> getState() {
		
		return catalogsDao.getstate();
	}

	@Override
	public List<Map<String, Object>> getCatalogContentDetails(int sourceCodeId) {
		return catalogsDao.getCatalogContentDetails( sourceCodeId);	}

	@Override
	public List<DropdownModel> getCurrencyDetails() {
		return catalogsDao.getCurrencytDetails( );
	}

	public List<Map<String, Object>> getpackageDefinationDetails(int pkgDefId, int ocId){
		return catalogsDao.getpackageDefinationDetails( pkgDefId, ocId);
	}
	}



