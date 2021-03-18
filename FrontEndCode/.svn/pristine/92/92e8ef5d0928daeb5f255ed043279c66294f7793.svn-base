package com.mps.think.dao;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.mps.think.model.AttachmentAddAttributeModel;
import com.mps.think.model.CustomerAddAttributeModel;
import com.mps.think.model.CustomerAddressModel;
import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.CustomerHistoryModel;
import com.mps.think.model.CustomerSearchAttributeModel;
import com.mps.think.model.DistributorAccountsModel;
import com.mps.think.model.DistributorAttributeSetUpModel;
import com.mps.think.model.DistributorChildModel;
import com.mps.think.model.DistributorReportModel;
import com.mps.think.model.DistributorReportOutputOptionsModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.NoteAddAttributeModel;
import com.mps.think.orderFunctionality.model.ProspectModel;

public interface CustomerSearchDao {

	public List<CustomerAddressModel> getCustomerSearch(CustomerSearchAttributeModel customerSearchAttributeModel)
			throws SQLException;
	public List<Map<String, Object>> getCustomerSearchByAddress(CustomerSearchAttributeModel customerSearchAttributeModel) throws SQLException;
	public List<Map<String, Object>> getCustomerSearchByOrder(CustomerSearchAttributeModel customerSearchAttributeModel) throws SQLException;
	public List<Map<String, Object>> getCustomerSearchByPayment(CustomerSearchAttributeModel customerSearchAttributeModel) throws SQLException;
	public List<DropdownModel> getStateList()
			throws SQLException;
	public List<DropdownModel> getaddressType()
			throws SQLException;
	public List<DropdownModel> getlistRental()
			throws SQLException;
	public List<DropdownModel> getcustomerCategory()
			throws SQLException;
	public List<DropdownModel> getsalesRepresentative()
			throws SQLException;
	public List<DropdownModel> getaddressStatus()
			throws SQLException;
	public List<DropdownModel> getcreditStatus()
			throws SQLException;
	public List<DropdownModel> gettaxFilter()
			throws SQLException;
	public List<DropdownModel>  getpaymentThresholdList()
			throws SQLException;
	public String addCustomer(CustomerAddAttributeModel customerAddAttributeModel)
			throws SQLException;
	public void getCustomerDetail(CustomerAddAttributeModel customerAddAttributeModel,Long customerId)
			throws SQLException;
	public String editCustomer(CustomerAddAttributeModel customerAddAttributeModel)
			throws SQLException;
	public List<CustomerAddressModel> getaddressDetail(Long customerId,String type)
			throws SQLException;
	public List<String> getCountry(String stateCode)
			throws SQLException;
	public List<Object> getSearchCustomerBillTo(String billTo)
			throws SQLException;
	public List<DropdownModel> getDefaultAddressList(Long customerId)
			throws SQLException;
	public List<Object> getAddressHistory(Long customerId,int addrSeq)
			throws SQLException;
	public String addAddress(CustomerAddAttributeModel customerAddAttributeModel)
			throws SQLException;
	public void getCustomerAddressDetailBySeqID(CustomerAddAttributeModel customerAddAttributeModel,Long customerId,int addressSeq)
			throws SQLException;
	public List<Object> getAttachment(Long customerId,int attachmentFilter)
			throws SQLException;
	public List<CustomerHistoryModel> getCustomerHistory(Long customerId,int historyFilter)
			throws SQLException;
	public List<DropdownModel> getAttachmentFilterList(Long customerId)
			throws SQLException;
	public  List<DropdownModel> getNoteFilterList(Long customerId)
			throws SQLException;
	public List<Object> getNote(Long customerId,int noteFilter, Optional<Integer> paymentSeq, Optional<Long> orderhdrId, Optional<Integer> orderItemSeq)
			throws SQLException;
	public String updateAddress(CustomerAddAttributeModel customerAddAttributeModel)
			throws SQLException;
	public List<DropdownModel> getNoteRecordList(Long customerId,String noteFilter)
			throws SQLException;
	public String addNote(NoteAddAttributeModel noteAddAttributeModel)
			throws SQLException;
	public String editNote(NoteAddAttributeModel noteAddAttributeModel)
			throws SQLException;
	public String deleteNote(NoteAddAttributeModel noteAddAttributeModel)
			throws SQLException;
	public List<DropdownModel> getAttachmentCategoryList()
			throws SQLException;
	public String addAttachment(AttachmentAddAttributeModel attachmentAddAttributeModel)
			throws SQLException;
	public LinkedHashMap<String, byte[] > getAttachmentFile(String attachmentId)
			throws SQLException;
	public String deleteAttachment(String attachmentId)
			throws SQLException;
	public String editAttachment(AttachmentAddAttributeModel attachmentAddAttributeModel)
			throws SQLException;
	public List<CustomerAuxiliaryModel> getCustomerAuxiliaryFormField()
			throws SQLException;
	public LinkedHashMap<String, String> setCustomerAuxiliaryDetailByID(Long customerId)
			throws SQLException;
	public String saveCustomerAuxiliary(HttpServletRequest request)
			throws SQLException;
	public List<String> getEffevtiveReverseDate(Long customerId)
			throws SQLException;
	public String deleteAddress(Long customerId , String customerAddressSeq)
			throws SQLException;
	public List<String> getEditEffevtiveReverseDate(Long customerId,int addressSeq)
			throws SQLException;
	public String getdefaultAddressType()
			throws SQLException;
	public String getdefaultListRental()
			throws SQLException;
	public String getdefaultAddressStatus()
			throws SQLException;
	public String getdefaultCreditStatus()
			throws SQLException;
	public List<Object> getDuplicateRecord(CustomerAddAttributeModel customerAddAttributeModel);
	public List<Map<String, Object>> getDocumentReferenceDetailList(Long documentReferenceId) throws SQLException;
	public List<Map<String, Object>> getEditTrialList(Long editTrialId) throws SQLException;
	public Map<String, String> getTableHeaders(String tableName)
			throws SQLException;
	public String clearAddInfo(Long customerId) throws SQLException;
	public List<ProspectModel> getIsProspect();
	public List<DropdownModel> getProspectCategory();
	public List<DropdownModel> getsetAsGroupMbr();
	public String updateEmailAuthorizationIntoDataSource(Long customerId,String business_processes);
	public String retrieveEmailAuthorizationFromDataSource(Long customerId);
	public String retrieveDefaultEmailAuthorizationFromDataSource();
	public List<DistributorAccountsModel> retrieveDistributorAccountsListFromDataSource();
	public String updateDistributorInfoIntoDataSource(CustomerAddAttributeModel customerAddAttributeModel);
	public String addDistributorReportIntoDataSource(CustomerAddAttributeModel customerAddAttributeModel);
	public String deleteDistributorReportFromDataSource(CustomerAddAttributeModel customerAddAttributeModel);
	public List<DistributorReportModel> retrieveDistributorReportsListFromDataSource(Long customer_id);
	public String updateDistributorReportInDataSource(CustomerAddAttributeModel customerAddAttributeModel);
	public List<DistributorAttributeSetUpModel> retrieveDistributorAttributeSetUpDataFromDataSource();
	public List<DistributorAttributeSetUpModel> retrieveDistributorAttributeFromDataSource(Long customerId);
	public String deleteDistributorAttributeFromDataSource(CustomerAddAttributeModel customerAddAttributeModel);
	public String addDistributorAttributeIntoDataSource(CustomerAddAttributeModel customerAddAttributeModel);
	public String updateDistributorAttributeInDataSource(CustomerAddAttributeModel customerAddAttributeModel);
	public List<DistributorChildModel> getDistributorAccount(String customerId);
	public List<DistributorChildModel>  getDistributorAccChildList() ;
	public List<Map<String, Object>> getDistAccountDetails(String customerId);
	public List<DistributorReportOutputOptionsModel> retrieveDistributorReportGridOutputOptionsDataFromDataSource();
	public List<Map<String, Object>> getMatchCodes(int customerId, int customerAddressSeq);
	public List<Map<String, Object>> getfuterTempAddress(Long customerId);
}
