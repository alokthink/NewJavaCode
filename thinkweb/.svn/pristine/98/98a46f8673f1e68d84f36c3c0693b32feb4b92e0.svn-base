package com.mps.think.service;

import java.util.List;
import java.util.Map;

import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.ServiceFilterModel;
import com.mps.think.model.SourceCode;
import com.mps.think.model.ComplaintServiceModel;

public interface OrderSourceOfferService {
	public List<OrderCode> getOrderCode(String orderCodeType);
	public List<SourceCode> getSourceCode(String ocID);
	public List<DropdownModel> getCauseCode();
	public List<DropdownModel> getComplaintCode();
	public List<DropdownModel> getServiceCode();
	public List<DropdownModel> getServiceCodeTemplate();
	public List<Map<String, Object>> getOrderDetails(int orderId);
	public boolean saveService(ComplaintServiceModel complaintServiceModel, int ServiceFilter,int orderItemType);
	public boolean updateService(ComplaintServiceModel complaintServiceModel);
	public List<Map<String, Object>> getSelectedData(String compalintCode);
	public List<Object> getServiceFilterData(int customer_id, int serviceFilter,int orderItemType);
	public List<DropdownModel> getselectRecord(int customerId,int serviceFilter) ;
	public List<DropdownModel> getSelectedServiceComplaintCode(String complaintCode);
	public List<DropdownModel> getSelectedServiceCauseCode(String causeCode);
	public List<DropdownModel> getSelectedServiceServiceCode(String serviceCode);
	public String getEmail(Integer customerId);
	public List<SourceCode> getCatalogSource(String sourceCode ,String orderClass, String generated);
	public List<DropdownModel> getGenerated();
	public List<OrderCode> getCatalogOrder(String sourceCodeId, String orderCode ,String orderClass,String orderCodeType,String term);
}
