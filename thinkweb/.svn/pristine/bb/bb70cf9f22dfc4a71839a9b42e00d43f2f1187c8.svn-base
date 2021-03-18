package com.mps.think.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.model.ComplaintServiceModel;
import com.mps.think.dao.OrderSourceOfferDao;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.ServiceFilterModel;
import com.mps.think.model.SourceCode;
import com.mps.think.service.OrderSourceOfferService;

@Service("orderSourceOfferService")
public class OrderSourceOfferServicesImpl implements OrderSourceOfferService {

	public static final Logger LOGGER = LoggerFactory.getLogger(OrderSourceOfferServicesImpl.class);

	@Autowired
	OrderSourceOfferDao orderSourceOfferDao;

	@Override
	public List<OrderCode> getOrderCode(String orderCodeType) {
		List<OrderCode> orderCodeList = new ArrayList<>();
		try {
			orderCodeList = orderSourceOfferDao.getOrderCode(orderCodeType);
		} catch (Exception e) {
			LOGGER.info("getOrderCode" + e);
		}
		return orderCodeList;
	}

	@Override
	public List<SourceCode> getSourceCode(String ocID) {
		List<SourceCode> sourceCodeList = new ArrayList<>();
		try {
			sourceCodeList = orderSourceOfferDao.getSourceCode(ocID);
		} catch (Exception e) {
			LOGGER.info("getSourceCode" + e);
		}
		return sourceCodeList;
	}
                                                                       
	@Override
	public List<DropdownModel> getCauseCode() {
		return orderSourceOfferDao.getCauseCode();
	}
	@Override
	public List<DropdownModel> getComplaintCode() {
		return orderSourceOfferDao.getComplaintCode();
	}
	@Override
	public List<DropdownModel> getServiceCode() {
		return orderSourceOfferDao.getServiceCode();
	}

	@Override
	public List<DropdownModel> getServiceCodeTemplate() {
		return orderSourceOfferDao.getServiceCodeTemplate();
	}
	@Override
	public List<Map<String, Object>> getOrderDetails(int orderId) {
		return orderSourceOfferDao.getOrderDetails( orderId);
	}
	
	@Override
	public boolean saveService(ComplaintServiceModel complaintServiceModel, int serviceFilter ,int orderItemType) {
		return orderSourceOfferDao.saveService( complaintServiceModel, serviceFilter, orderItemType);
	}
	@Override
	public boolean updateService(ComplaintServiceModel complaintServiceModel) {
		return orderSourceOfferDao.updateService( complaintServiceModel);
	}
	
	public List<Object> getServiceFilterData(int customer_id,int  serviceFilter ,int orderItemType) {
	  return orderSourceOfferDao.getServiceFilterData(customer_id, serviceFilter ,orderItemType);
	}

	public String getRowCountValue(int customer_id) {
		
		return orderSourceOfferDao.getRowCountValue(customer_id);
	}

	public Map<String, Object> getServiceSeq(int customerId) {
		return orderSourceOfferDao.getServiceSeq(customerId);
	}

	public List<Map<String, Object>> getSelectedData(String compalintCode) {
	
		return orderSourceOfferDao.getSelectedData(compalintCode);
	}

	public List<DropdownModel> getselectRecord(int customerId, int serviceFilter) {
		
		return  orderSourceOfferDao.getselectRecord(customerId,serviceFilter);
	}

	public List<ComplaintServiceModel> getShowDataForUpdate(int customerId, int serviceSeq, int serviceFilter) {
		return orderSourceOfferDao.getShowDataForUpdate(customerId,serviceSeq,serviceFilter);
	}

	public List<DropdownModel> getCondetionCheckServiceFilter(int customerId) {
		return orderSourceOfferDao.getCondetionCheckServiceFilter(customerId);
	}
	
	public List<Map<String, Object>> getDataAddService(int customerId, Integer orderId, int orderItemSeq, int orderItemType,
			int subscripId) {
		return orderSourceOfferDao.getDataAddService(customerId,orderId,orderItemSeq,orderItemType,
				subscripId);

   }

	public List<Object> getServiceHistory(Long customerId, int serviceSeq) throws SQLException {
		return orderSourceOfferDao.getServiceHistory(customerId,serviceSeq);
	}

	@Override
	public String getEmail(Integer customerId) {
		return orderSourceOfferDao.getEmail(customerId);
	}

	@Override
	public List<DropdownModel> getSelectedServiceComplaintCode(String complaintCode) {
		return orderSourceOfferDao.getSelectedServiceComplaintCode(complaintCode);
	}

	@Override
	public List<DropdownModel> getSelectedServiceCauseCode(String causeCode) {
		return orderSourceOfferDao.getSelectedServiceCauseCode(causeCode);
	}

	@Override
	public List<DropdownModel> getSelectedServiceServiceCode(String serviceCode) {
		return orderSourceOfferDao.getSelectedServiceServiceCode(serviceCode);
	}

	public List<SourceCode> getCatalogSource(String sourceCode ,String orderClass, String generated) {
		return orderSourceOfferDao.getCatalogSource(sourceCode ,orderClass, generated);
	}

	public List<DropdownModel> getGenerated() {
		return orderSourceOfferDao.getGenerated();
	}

	public List<OrderCode> getCatalogOrder(String sourceCodeId, String orderCode ,String orderClass,String orderCodeType,String term) {
			return orderSourceOfferDao.getCatalogOrder(sourceCodeId, orderCode , orderClass, orderCodeType, term);
	}
}
