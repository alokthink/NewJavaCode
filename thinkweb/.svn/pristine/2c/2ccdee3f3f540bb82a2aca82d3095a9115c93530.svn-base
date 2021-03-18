package com.mps.think.serviceImpl;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mps.think.dao.CustomerSearchDao;
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
import com.mps.think.service.CustomerSearchService;

@Service("CustomerSearchService")
public class CustomerSearchServiceImpl implements CustomerSearchService {

	@Autowired
	CustomerSearchDao customerSearchDao;
	@Override
	public List<CustomerAddressModel> getCustomerSearch(CustomerSearchAttributeModel customerSearchAttributeModel)
			throws SQLException {
		return customerSearchDao.getCustomerSearch(customerSearchAttributeModel);
	}
	
	@Override
	public List<Map<String, Object>>  getCustomerSearchByAddress(CustomerSearchAttributeModel customerSearchAttributeModel)
			throws SQLException {
		return customerSearchDao.getCustomerSearchByAddress(customerSearchAttributeModel);
	}

	@Override
	public List<DropdownModel> getStateList() throws SQLException {
		return customerSearchDao.getStateList();
	}
	
	@Override
	public List<DropdownModel> getaddressType() throws SQLException {
		return customerSearchDao.getaddressType();
	}
	
	@Override
	public List<DropdownModel> getlistRental() throws SQLException {
		return customerSearchDao.getlistRental();
	}
	
	@Override
	public List<DropdownModel> getcustomerCategory() throws SQLException {
		return customerSearchDao.getcustomerCategory();
	}
	
	@Override
	public List<DropdownModel> getsalesRepresentative() throws SQLException {
		return customerSearchDao.getsalesRepresentative();
	}
	
	@Override
	public List<DropdownModel> getaddressStatus() throws SQLException {
		return customerSearchDao.getaddressStatus();
	}
	
	@Override
	public List<DropdownModel> getcreditStatus() throws SQLException {
		return customerSearchDao.getcreditStatus();
	}
	
	@Override
	public List<DropdownModel> gettaxFilter() throws SQLException {
		return customerSearchDao.gettaxFilter();
	}
	
	@Override
	public List<DropdownModel>  getpaymentThresholdList() throws SQLException {
		return customerSearchDao.getpaymentThresholdList();
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addCustomer(CustomerAddAttributeModel customerAddAttributeModel) throws SQLException {
		return customerSearchDao.addCustomer(customerAddAttributeModel);
	}
	
	@Override
	public void getCustomerDetail(CustomerAddAttributeModel customerAddAttributeModel,Long customerId) throws SQLException {
		customerSearchDao.getCustomerDetail(customerAddAttributeModel,customerId);
	}
	
	@Override
	public String editCustomer(CustomerAddAttributeModel customerAddAttributeModel) throws SQLException {
		return customerSearchDao.editCustomer(customerAddAttributeModel);
	}
	
	@Override
	public List<CustomerAddressModel> getaddressDetail(Long customerId,String type) throws SQLException {
		return customerSearchDao.getaddressDetail(customerId,type);
	}
	
	@Override
	public List<String> getCountry(String stateCode) throws SQLException {
		return customerSearchDao.getCountry(stateCode);
	}
	
	@Override
	public List<Object> getSearchCustomerBillTo(String billTo) throws SQLException {
		return customerSearchDao.getSearchCustomerBillTo(billTo);
	}
	
	@Override
	public List<DropdownModel> getDefaultAddressList(Long customerId) throws SQLException {
		return customerSearchDao.getDefaultAddressList(customerId);
	}
	
	@Override
	public List<Object> getAddressHistory(Long customerId,int addrSeq) throws SQLException {
		return customerSearchDao.getAddressHistory(customerId,addrSeq);
	}
	
	@Override
	public String addAddress(CustomerAddAttributeModel customerAddAttributeModel) throws SQLException {
		return customerSearchDao.addAddress(customerAddAttributeModel);
	}

	@Override
	public void getCustomerAddressDetailBySeqID(CustomerAddAttributeModel customerAddAttributeModel, Long customerId,
			int addressSeq) throws SQLException {
		customerSearchDao.getCustomerAddressDetailBySeqID(customerAddAttributeModel,customerId,addressSeq);
		
	}
	
	@Override
	public List<Object> getAttachment(Long customerId,int attachmentFilter) throws SQLException {
		return customerSearchDao.getAttachment(customerId,attachmentFilter);
	}
	
	@Override
	public List<CustomerHistoryModel> getCustomerHistory(Long customerId,int historyFilter) throws SQLException {
		return customerSearchDao.getCustomerHistory(customerId,historyFilter);
	}
	
	@Override
	public List<DropdownModel> getAttachmentFilterList(Long customerId) throws SQLException {
		return customerSearchDao.getAttachmentFilterList(customerId);
	}
	
	@Override
	public  List<DropdownModel> getNoteFilterList(Long customerId) throws SQLException {
		return customerSearchDao.getNoteFilterList(customerId);
	}
	
	@Override
	public List<Object> getNote(Long customerId,int noteFilter,Optional<Integer> paymentSeq, Optional<Long> orderhdrId, Optional<Integer> orderItemSeq) throws SQLException {
		return customerSearchDao.getNote(customerId,noteFilter,paymentSeq,orderhdrId,orderItemSeq);
	}
	
	@Override
	public String updateAddress(CustomerAddAttributeModel customerAddAttributeModel) throws SQLException {
		return customerSearchDao.updateAddress(customerAddAttributeModel);
	}
	
	@Override
	public List<DropdownModel> getNoteRecordList(Long customerId,String noteFilter) throws SQLException {
		return customerSearchDao.getNoteRecordList(customerId,noteFilter);
	}
	
	@Override
	public String addNote(NoteAddAttributeModel noteAddAttributeModel) throws SQLException {
		return customerSearchDao.addNote(noteAddAttributeModel);
	}
	
	@Override
	public String editNote(NoteAddAttributeModel noteAddAttributeModel) throws SQLException {
		return customerSearchDao.editNote(noteAddAttributeModel);
	}
	
	@Override
	public String deleteNote(NoteAddAttributeModel noteAddAttributeModel) throws SQLException {
		return customerSearchDao.deleteNote(noteAddAttributeModel);
	}
	
	@Override
	public List<DropdownModel> getAttachmentCategoryList() throws SQLException {
		return customerSearchDao.getAttachmentCategoryList();
	}
	
	@Override
	public String addAttachment(AttachmentAddAttributeModel attachmentAddAttributeModel) throws SQLException {
		return customerSearchDao.addAttachment(attachmentAddAttributeModel);
	}
	
	@Override
	public LinkedHashMap<String, byte[] > getAttachmentFile(String attachmentId) throws SQLException {
		return customerSearchDao.getAttachmentFile(attachmentId);
	}
	
	@Override
	public String deleteAttachment(String attachmentId) throws SQLException {
		return customerSearchDao.deleteAttachment(attachmentId);
	}
	
	@Override
	public String editAttachment(AttachmentAddAttributeModel attachmentAddAttributeModel) throws SQLException {
		return customerSearchDao.editAttachment(attachmentAddAttributeModel);
	}

	@Override
	public List<CustomerAuxiliaryModel> getCustomerAuxiliaryFormField() throws SQLException {
		return customerSearchDao.getCustomerAuxiliaryFormField();
	}

	@Override
	public LinkedHashMap<String, String> setCustomerAuxiliaryDetailByID(Long customerId)
			throws SQLException {
		return customerSearchDao.setCustomerAuxiliaryDetailByID(customerId);	
	}

	@Override
	public String saveCustomerAuxiliary(HttpServletRequest request) throws SQLException {
		return customerSearchDao.saveCustomerAuxiliary(request);
	}

	@Override
	public List<String> getEffevtiveReverseDate(Long customerId) throws SQLException {
		return customerSearchDao.getEffevtiveReverseDate(customerId);
	}

	@Override
	public String deleteAddress(Long customerId , String customerAddressSeq) throws SQLException {
		return customerSearchDao.deleteAddress(customerId, customerAddressSeq);
	}
	
	@Override
	public List<String> getEditEffevtiveReverseDate(Long customerId,int addressSeq) throws SQLException {
		return customerSearchDao.getEditEffevtiveReverseDate(customerId,addressSeq);
	}

	@Override
	public String getdefaultAddressType() throws SQLException {
		return customerSearchDao.getdefaultAddressType();
	}
	
	@Override
	public String getdefaultListRental() throws SQLException {
		return customerSearchDao.getdefaultListRental();
	}
	
	@Override
	public String getdefaultAddressStatus() throws SQLException {
		return customerSearchDao.getdefaultAddressStatus();
	}
	
	@Override
	public String getdefaultCreditStatus() throws SQLException {
		return customerSearchDao.getdefaultCreditStatus();
	}
	
	@Override
	 public List<Object> getDuplicateRecord(CustomerAddAttributeModel customerAddAttributeModel)  {  
	  return customerSearchDao.getDuplicateRecord(customerAddAttributeModel);
	 }

	@Override
	public List<Map<String, Object>> getDocumentReferenceDetailList(Long documentReferenceId) throws SQLException {
		return customerSearchDao.getDocumentReferenceDetailList(documentReferenceId);
	}

	@Override
	public List<Map<String, Object>> getEditTrialList(Long editTrialId) throws SQLException {
		return customerSearchDao.getEditTrialList(editTrialId);
	}

	@Override
	public List<Map<String, Object>> getCustomerSearchByOrder(CustomerSearchAttributeModel customerSearchAttributeModel)
			throws SQLException {
		 return customerSearchDao.getCustomerSearchByOrder(customerSearchAttributeModel);
	}

	@Override
	public List<Map<String, Object>> getCustomerSearchByPayment(
			CustomerSearchAttributeModel customerSearchAttributeModel) throws SQLException {
		return customerSearchDao.getCustomerSearchByPayment(customerSearchAttributeModel);
	}

	@Override
	public Map<String, String> getTableHeaders(String tableName) throws SQLException {
		return customerSearchDao.getTableHeaders(tableName);
	}

	
	@Override
	public String clearAddInfo(Long customerId) throws SQLException {
		return customerSearchDao.clearAddInfo(customerId);
	}

	@Override
	public List<ProspectModel> getIsProspect() {
		return customerSearchDao.getIsProspect();
	}

	@Override
	public List<DropdownModel> getProspectCategory() {
		return customerSearchDao.getProspectCategory();
	}

	@Override
	public List<DropdownModel> getsetAsGroupMbr() {
		return customerSearchDao.getsetAsGroupMbr();
	}

	@Override
	public String updateEmailAuthorization(Long customerId, String business_processes) 
	{
		return customerSearchDao.updateEmailAuthorizationIntoDataSource(customerId,business_processes);
	}
	
	@Override
	public String retrieveEmailAuthorization(Long customerId) 
	{
		return customerSearchDao.retrieveEmailAuthorizationFromDataSource(customerId);
	}
	@Override
	public String retrieveDefaultEmailAuthorization() 
	{
		return customerSearchDao.retrieveDefaultEmailAuthorizationFromDataSource();
	}
	
	@Override
	public List<DistributorAccountsModel> retrieveDistributorAccountsList() 
	{
		//List <DistributorAccountsModel>  distList=customerSearchDao.retrieveDistributorAccountsListFromDataSource();
		
		
	    return  customerSearchDao.retrieveDistributorAccountsListFromDataSource();
	}
	
	@Override
	public String updateDistributorInfo(CustomerAddAttributeModel customerAddAttributeModel) 
	{
		return customerSearchDao.updateDistributorInfoIntoDataSource(customerAddAttributeModel);
	}
	
	@Override
	public String addDistributorReport(CustomerAddAttributeModel customerAddAttributeModel) 
	{
		return customerSearchDao.addDistributorReportIntoDataSource(customerAddAttributeModel);
	}
	
	@Override
	public String deleteDistributorReport(CustomerAddAttributeModel customerAddAttributeModel) 
	{
		return customerSearchDao.deleteDistributorReportFromDataSource(customerAddAttributeModel);
	}
	
	@Override
	public List<DistributorReportModel> retrieveDistributorReportsList(Long customer_id) 
	{
		return customerSearchDao.retrieveDistributorReportsListFromDataSource(customer_id);
	}
	@Override
	public String updateDistributorReport(CustomerAddAttributeModel customerAddAttributeModel) 
	{
		return customerSearchDao.updateDistributorReportInDataSource(customerAddAttributeModel);
	}
	@Override
	public List<DistributorAttributeSetUpModel> retrieveDistributorAttributeSetUpData() 
	{
		return customerSearchDao.retrieveDistributorAttributeSetUpDataFromDataSource();
	}
	@Override
	public List<DistributorAttributeSetUpModel> retrieveDistributorAttribute(Long customer_id) 
	{
		return customerSearchDao.retrieveDistributorAttributeFromDataSource(customer_id);
	}
	@Override
	public String deleteDistributorAttribute(CustomerAddAttributeModel customerAddAttributeModel) 
	{
		return customerSearchDao.deleteDistributorAttributeFromDataSource(customerAddAttributeModel);
	}
	@Override
	public String addDistributorAttribute(CustomerAddAttributeModel customerAddAttributeModel) 
	{
		return customerSearchDao.addDistributorAttributeIntoDataSource(customerAddAttributeModel);
	}
	@Override
	public String updateDistributorAttribute(CustomerAddAttributeModel customerAddAttributeModel) 
	{
		return customerSearchDao.updateDistributorAttributeInDataSource(customerAddAttributeModel);
	}

	@Override
	public List<DistributorChildModel> getDistributorAccount(String customerId) {
		return customerSearchDao.getDistributorAccount(customerId);
	}

	@Override
	public List<DistributorChildModel> getDistributorAccChildList() {
		return customerSearchDao.getDistributorAccChildList();
	}

	@Override
	public List<Map<String, Object>> getDistAccountDetails(String customerId) {
		return customerSearchDao.getDistAccountDetails(customerId);
	}
	@Override
	public List<DistributorReportOutputOptionsModel> retrieveDistributorReportGridOutputOptionsData() 
	{
		return customerSearchDao.retrieveDistributorReportGridOutputOptionsDataFromDataSource();
	}

	@Override
	public List<Map<String, Object>> getMatchCodes(int customerId, int customerAddressSeq) {
		return customerSearchDao.getMatchCodes(customerId, customerAddressSeq);
	}

	@Override
	public List<Map<String, Object>> getfuterTempAddress(Long customerId) {
		return customerSearchDao.getfuterTempAddress(customerId);
	}

	@Override
	public List<DropdownModel> getCustomerCategoryList() {
		return customerSearchDao.getCustomerCategoryList();
	}
}
