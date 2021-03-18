package com.mps.think.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mps.think.model.ComplaintServiceModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.ServiceFilterModel;
import com.mps.think.model.SourceCode;


public interface OrderSourceOfferDao {
	public List<OrderCode> getOrderCode(String orderCodeType);
	public List<SourceCode> getSourceCode(String ocID);
	public List<Object> getServiceFilterData(int customerId, int serviceFilter,int orderItemType);	
	public List<DropdownModel> getCauseCode();
	public List<DropdownModel> getComplaintCode();
	public List<DropdownModel> getServiceCode();
	public List<DropdownModel> getServiceCodeTemplate();
	public List<Map<String, Object>> getOrderDetails(int orderId);
	public boolean saveService(ComplaintServiceModel complaintServiceModel, int serviceFilter, int orderItemTYpe);
	public boolean updateService(ComplaintServiceModel complaintServiceModel);
	public String getRowCountValue(int customer_id);
	public Map<String, Object> getServiceSeq(int customerId);
	public List<Map<String, Object>> getSelectedData(String compalintCode);
	public List<DropdownModel> getselectRecord(int customerId,int orderItemType);
	public List<ComplaintServiceModel> getShowDataForUpdate(int customerId, int serviceSeq, int serviceFilter);
	public List<DropdownModel> getCondetionCheckServiceFilter(int customerId);
	public List<Map<String, Object>> getDataAddService(int customerId, Integer orderId, int orderItemSeq,
			int orderItemType, int subscripId);
	public List<Object> getServiceHistory(Long customerId, int serviceSeq) throws SQLException;
	public List<DropdownModel> getSelectedServiceComplaintCode(String complaintCode);
	public List<DropdownModel> getSelectedServiceCauseCode(String causeCode);
	public List<DropdownModel> getSelectedServiceServiceCode(String serviceCode);
	public String getEmail(Integer customerId);
	public List<SourceCode> getCatalogSource(String sourceCode ,String orderClass, String generated);
	public List<DropdownModel> getGenerated();
	public List<OrderCode> getCatalogOrder(String sourceCodeId, String orderCode ,String orderClass,String orderCodeType,String term);
}
