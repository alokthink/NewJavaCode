package com.mps.think.process.serviceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.model.DropdownModel;
import com.mps.think.process.dao.ProcessDetailsDao;
import com.mps.think.process.model.AccountingPeriod;
import com.mps.think.process.model.EffortModel;
import com.mps.think.process.model.ExtractModel;
import com.mps.think.process.model.InsertsModel;
import com.mps.think.process.model.JobModel;
import com.mps.think.process.model.JobOutputModel;
import com.mps.think.process.model.NthModel;
import com.mps.think.process.model.OutputModel;
import com.mps.think.process.model.ProcessModel;
import com.mps.think.process.model.ProfitCenter;
import com.mps.think.process.model.PromotionModel;
import com.mps.think.process.model.SortModel;
import com.mps.think.process.model.SplitDetailModel;
import com.mps.think.process.model.SubmitJobModel;
import com.mps.think.process.service.ProcessDetailsService;

@Service("ProcessDetailsService")
public class ProcessDetailsServiceImp implements ProcessDetailsService {
	@Autowired
	ProcessDetailsDao processInfoDao;

	@Override
	public List<ProcessModel> getProcessDetails(String active, String inactive) {
		return processInfoDao.getProcessDetails(active, inactive);
	}

	@Override
	public List<DropdownModel> getbankDefDetails() {
		return processInfoDao.getbankDefDetails();
	}

	@Override
	public List<Map<String, Object>> getselectedValue(int processId) {
		return processInfoDao.getselectedValue(processId);
	}

	@Override
	public Object getOrderDetails(int processId, int processOcType) {
		return processInfoDao.getOrderDetails(processId, processOcType);
	}

	@Override
	public ProcessModel getDefaultProcessDetails(int processId) {
		return processInfoDao.getDefaultProcessDetails(processId);
	}

	@Override
	public List<DropdownModel> getQueueDetails() {
		return processInfoDao.getQueueDetails();
	}

	@Override
	public List<DropdownModel> getGroupDetails() {
		return processInfoDao.getGroupDetails();
	}

	@Override
	public List<DropdownModel> getKeylineDetails() {
		return processInfoDao.getKeylineDetails();
	}

	@Override
	public List<DropdownModel> getOutputSortDetails() {
		return processInfoDao.getOutputSortDetails();
	}

	@Override
	public List<Map<String, Object>> getselectedPCValue(int processId) {
		return processInfoDao.getselectedPCValue(processId);
	}

	@Override
	public Object getPCDetails(int processId) {
		return processInfoDao.getPCDetails(processId);
	}

	@Override
	public Object getbacsSelectionCurrency() {
		return processInfoDao.getbacsSelectionCurrency();
	}

	@Override
	public List<Map<String, Object>> getselectedCurrency(int processId) {
		// TODO Auto-generated method stub
		return processInfoDao.getselectedCurrency(processId);
	}

	@Override
	public Object getCleanupDefinitionDetails() {
		return processInfoDao.getCleanupDefinitionDetails();
	}

	@Override
	public List<Map<String, Object>> getselectedCleanupValue(int processId) {
		return processInfoDao.getselectedCleanupValue(processId);
	}

	@Override
	public List<Map<String, Object>> getLabelFormateList() {
		return processInfoDao.getLabelFormateList();
	}

	@Override
	public List<Map<String, Object>> getselectedReports(int processId) {
		return processInfoDao.getselectedReports(processId);
	}

	@Override
	public Object getauditReports() {
		return processInfoDao.getauditReports();
	}

	@Override
	public List<DropdownModel> getOrderClass() {
		return processInfoDao.getOrderClass();
	}

	@Override
	public String deleteProcessDetails(int processId) {
		return processInfoDao.deleteProcessDetails(processId);
	}

	@Override
	public Object getDefaultDropdown(int processId) throws SQLException {
		return processInfoDao.getDefaultDropdown(processId);
	}

	@Override
	public String addNewProcess(int processType) {
		return processInfoDao.addNewProcess(processType);
	}

	@Override
	public List<DropdownModel> getExtractDetails() {
		return processInfoDao.getExtractDetails();
	}

	@Override
	public List<ProcessModel> getPaymentDetails(int processId) {
		return processInfoDao.getPaymentDetails(processId);
	}

	@Override
	public Object getAuditOrderDetails(int processId) {
		return processInfoDao.getAuditOrderDetails(processId);
	}

	@Override
	public List<DropdownModel> getrenewalCardDetails(String ocId, String renewalDef) {
		return processInfoDao.getrenewalCardDetails(ocId, renewalDef);
	}

	@Override
	public List<DropdownModel> getVolumeGroupDetails() {
		return processInfoDao.getVolumeGroupDetails();
	}

	@Override
	public Object getRenewalDefByDefault() {
		return processInfoDao.getRenewalDefByDefault();
	}

	@Override
	public Object getRenewalDefDetails(int processId, int requal) {
		return processInfoDao.getRenewalDefDetails(processId, requal);
	}

	@Override
	public Object getRenewalEffortDetails(int processId) {
		return processInfoDao.getRenewalEffortDetails(processId);
	}

	@Override
	public Object getOrderDetailsTypeAll() {
		return processInfoDao.getOrderDetailsTypeAll();
	}

	@Override
	public List<Map<String, Object>> getBillDefinintion(int processId) {
		return processInfoDao.getBillDefinintion(processId);
	}

	@Override
	public List<EffortModel> getBillingEffort(int processId) {
		return processInfoDao.getBillingEffort(processId);
	}

	@Override
	public List<Map<String, Object>> getBillOrderClass() {
		return processInfoDao.getBillOrderClass();
	}

	
	@Override
	public List<Map<String, Object>> getInstallmentDetails(int processId) {
		return processInfoDao.getInstallmentDetails(processId);
	}

	@Override
	public List<DropdownModel> getOutputType() {
		return processInfoDao.getOutputType();
	}

	@Override
	public List<DropdownModel> getOutput() {
		return processInfoDao.getOutput();
	}

	@Override
	public List<DropdownModel> getOutputFileFormat() {
		return processInfoDao.getOutputFileFormat();
	}

	@Override
	public List<DropdownModel> getOc() {
		return processInfoDao.getOc();
	}

	@Override
	public List<NthModel> getNthDef() {
		return processInfoDao.getNthDef();
	}

	@Override
	public List<Map<String, Object>> getRenewalTesting(String renewalDef) {
		return processInfoDao.getRenewalTesting(renewalDef);
	}

	@Override
	public List<Map<String, Object>> getDefaultRenewalDetails(int processId) {
		return processInfoDao.getDefaultRenewalDetails(processId);
	}

	@Override
	public List<DropdownModel> getAuditReport() {
		return processInfoDao.getAuditReport();
	}

	@Override
	public List<Map<String, Object>> getrenewalDisplay(int processId) {
		return processInfoDao.getrenewalDisplay(processId);
	}

	@Override
	public List<DropdownModel> getInstallmentDropDown() {
		return processInfoDao.getInstallmentDropDown();
	}

	@Override
	public ProcessModel getsubmitjobData(int processId) {
		return processInfoDao.getsubmitjobData(processId);
	}

	@Override
	public List<Map<String, Object>> displayOutput() {
		return processInfoDao.displayOutput();
	}

	@Override
	public Object getPaymentType(int processId) {
		return processInfoDao.getPaymentType(processId);
	}

	@Override
	public Object getAllCurrency(int processId) {
		return processInfoDao.getAllCurrency(processId);
	}

	@Override
	public List<Map<String, Object>> getBillDisplayData(int processId) {
		return processInfoDao.getbillingDisplay(processId);
	}

	@Override
	public List<OutputModel> getOutputData(int processId) {
		return processInfoDao.getOutputData(processId);
	}

	@Override
	public List<Map<String, Object>> billDefinitionTab(String billingDef) {
		return processInfoDao.billDefinitionTab(billingDef);
	}

	@Override
	public List<EffortModel> getEfforts(String billingDef) {
		return processInfoDao.getEfforts(billingDef);
	}

	@Override
	public List<Map<String, Object>> getbillingDef() {
		return processInfoDao.getbillingDef();
	}

	@Override
	public List<Map<String, Object>> queueDisplay() {
		return processInfoDao.queueDisplay();
	}

	@Override
	public List<DropdownModel> getJobQueue() {
		return processInfoDao.getJobQueue();
	}

	@Override
	public List<Map<String, Object>> renewalDefinitionTab(String renewalDef) {
		return processInfoDao.renewalDefinitionTab(renewalDef);
	}

	@Override
	public List<EffortModel> getRenewalEfforts(String renewalDef) {
		return processInfoDao.getRenewalEfforts(renewalDef);
	}

	@Override
	public List<JobModel> getJobQueueDisp(String queue, String onHold, String ready, String running, String dayEnd) {
		return processInfoDao.getJobQueueDisp(queue, onHold, ready, running, dayEnd);
	}

	@Override
	public List<Map<String, Object>> getJobQueueList() {
		return processInfoDao.getJobQueueList();
	}

	@Override
	public List<NthModel> getNthDefDetails() {
		return processInfoDao.getNthDefDetails();
	}

	@Override
	public List<Map<String, Object>> getSelectMethod(int selectMethod) {
		return processInfoDao.getSelectMethod(selectMethod);
	}

	@Override
	public List<JobModel> getDefaultJobQueueDisp() {
		return processInfoDao.getDefaultJobQueueDisp();
	}

	@Override
	public List<Object> getReviewJobHistory(long processId, int status) {
		return processInfoDao.getReviewJobHistory(processId, status);
	}

	@Override
	public List<Object> getViewJobLog(long jobId) {
		return processInfoDao.getViewJobLog(jobId);
	}

	@Override
	public boolean deleteJobQueue(long jobId) {
		return processInfoDao.deleteJobQueue(jobId);
	}

	@Override
	public Object getResetDate(long jobId) {
		return processInfoDao.getResetDate(jobId);
	}

	@Override
	public boolean getHoldClear(long jobId) {
		return processInfoDao.getHoldClear(jobId);
	}

	@Override
	public List<DropdownModel> getProcessList() {
		return processInfoDao.getProcess();
	}

	@Override
	public List<Map<String, Object>> getSplit(Integer processId) {
		return processInfoDao.getSplit(processId);
	}

	@Override
	public List<DropdownModel> getExtract() {
		return processInfoDao.getExtract();
	}

	@Override
	public int saveSplit(SplitDetailModel splitDetailModel) {
		return processInfoDao.saveSplit(splitDetailModel);
	}

	@Override
	public int updateSplit(SplitDetailModel splitDetailModel) {
		return processInfoDao.updateSplit(splitDetailModel);
	}

	@Override
	public int deleteSplit(Integer processId) {
		return processInfoDao.deleteSplit(processId);
	}

	@Override
	public List<Map<String, Object>> getInsertsDetail(int processId) {
		return processInfoDao.getInsertsDetail(processId);
	}

	@Override
	public int saveInsertsDetail(InsertsModel insertsModel) {
		return processInfoDao.saveInsertsDetails(insertsModel);
	}

	@Override
	public int updateInsertsDetail(InsertsModel insertsModel) {
		return processInfoDao.updateInsertsDetail(insertsModel);
	}

	@Override
	public int deteteInsertsDetail(int processId, int bitPosition) {
		return processInfoDao.deleteInsertsDetail(processId, bitPosition);
	}

	@Override
	public Map<String, Object> getDescritionList(int processId) {
		return processInfoDao.getDescritionList(processId);
	}

	@Override
	public int saveSort(SortModel sortModel) {
		return processInfoDao.saveSort(sortModel);
	}

	@Override
	public int saveSortDetails(SortModel sortModel) {
		return processInfoDao.saveSortDetails(sortModel);
	}

	@Override
	public int updateSort(SortModel sortModel) {
		return processInfoDao.updateSort(sortModel);
	}

	@Override
	public int deleteSort(int processSortFieldSeq, String processSort) {
		return processInfoDao.deleteSort(processSortFieldSeq, processSort);
	}

	@Override
	public int deleteSortDetails(String processSort) {
		return processInfoDao.deleteSortDetails(processSort);
	}

	@Override
	public List<SortModel> getProcessSortFieldDetails(int processSortFieldSeq, String processSort) {
		return processInfoDao.getProcessSortFieldDetails(processSortFieldSeq, processSort);
	}

	@Override
	public List<DropdownModel> getTablenameInfo() {
		return processInfoDao.getTablenameInfo();
	}

	@Override
	public int savePromotion(PromotionModel promotionModel) {
		return processInfoDao.savePromotion(promotionModel);
	}

	@Override
	public int savePromotionDefTest(PromotionModel promotionModel) {
		return processInfoDao.savePromotionDefTest(promotionModel);
	}

	@Override
	public int savePromtionDefEffort(PromotionModel promotionModel) {
		return processInfoDao.savePromtionDefEffort(promotionModel);
	}

	@Override
	public List<Map<String, Object>> getOrderDetailsList(String promotionDef, int processId) {
		return processInfoDao.getOrderDetailsList(promotionDef, processId);
	}

	@Override
	public List<Map<String, Object>> getProcessInfo(int processOcType) {
		return processInfoDao.getProcessInfo(processOcType);
	}

	@Override
	public List<Map<String, Object>> getAllOrderDetails(int ocId) {
		return processInfoDao.getAllOrderDetails(ocId);
	}

	@Override
	public List<Map<String, Object>> getPromotionDefDetail(String promotionDef) {
		return processInfoDao.getPromotionDefDetail(promotionDef);
	}

	@Override
	public List<Map<String, Object>> getPromotionDefTest(String promotionDef, int promotionDefTestSeq) {
		return processInfoDao.getPromotionDefTest(promotionDef, promotionDefTestSeq);
	}

	@Override
	public List<Map<String, Object>> getPromotionDefEffortDetails(int effortNumber, String promotionDef) {
		return processInfoDao.getPromotionDefEffortDetails(effortNumber, promotionDef);
	}

	@Override
	public List<DropdownModel> getNthDefDetail() {
		return processInfoDao.getNthDefDetail();
	}

	@Override
	public List<DropdownModel> getProcessMethod() {
		return processInfoDao.getProcessMethod();
	}

	@Override
	public List<DropdownModel> getPromCardDetails(int promotionCradId) {
		return processInfoDao.getPromCardDetails(promotionCradId);
	}

	@Override
	public int updatePromotionDef(PromotionModel promotionModel) {
		return processInfoDao.updatePromotionDef(promotionModel);
	}

	@Override
	public int updatePromotionDefTest(PromotionModel promotionModel) {
		return processInfoDao.updatePromotionDefTest(promotionModel);
	}

	@Override
	public int updatePromotiondefEffort(PromotionModel promotionModel) {
		return processInfoDao.updatePromotiondefEffort(promotionModel);
	}

	@Override
	public int deletePromotionDefEffort(int effortNumber, String promotionDef) {
		return processInfoDao.deletePromotionDefEffort(effortNumber, promotionDef);
	}

	@Override
	public int deletePromotionDefTest(String promotionDef, int promotionDefTestSeq) {
		return processInfoDao.deletePromotionDefTest(promotionDef, promotionDefTestSeq);
	}

	@Override
	public int deletePromotionDef(String promotionDef) {
		return processInfoDao.deletePromotionDef(promotionDef);
	}

	@Override
	public String addProcesstypePromotion(ProcessModel processModel) {
		return processInfoDao.addProcesstypePromotion(processModel);
	}

	@Override
	public int editProcessTypePromotion(ProcessModel processModel) {
		return processInfoDao.editProcessTypePromotion(processModel);
	}

	@Override
	public int editRepeatingType(ProcessModel processModel) {
		return processInfoDao.editRepeatingType(processModel);
	}

	@Override
	public int deleteProcessPromotion(int processId) {
		return processInfoDao.deleteProcessPromotion(processId);
	}

	@Override
	public List<Map<String, Object>> getAudReport() {
		return processInfoDao.getAudReport();
	}

	@Override
	public int deleteOutputPromotion(int processOutputSeq, int procesId) {
		return processInfoDao.deleteOutputPromotion(processOutputSeq, procesId);
	}

	

	@Override
	public boolean generateDefaultOutput(int processId) {
		return processInfoDao.generateDefaultOutput(processId);
	}

	@Override
	public boolean generateDefaultProductOutput(int processId) {
		return processInfoDao.generateDefaultProductOutput(processId);
	}

	@Override
	public boolean generateDefaultLabelOutput(int processId) {
		return processInfoDao.generateDefaultLabelOutput(processId);
	}

	@Override
	public boolean generateStartrStopDefaultOutput(int processId) {
		return processInfoDao.generateStartrStopDefaultOutput(processId);
	}

	@Override
	public int reprint(JobModel jobModel) {
		return processInfoDao.reprint(jobModel);
	}

	@Override
	public List<Map<String, Object>> getviewLabelDetail(int jobId) {

		return processInfoDao.getviewLabelDetail(jobId);
	}

	@Override
	public Map<String, Object> getviewEffortDetail(int jobId, String action) {
		return processInfoDao.getviewEffortDetail(jobId, action);
	}

	@Override
	public String restartUpdate(JobModel jobModel) {
		return processInfoDao.restartUpdate(jobModel);
	}

	@Override
	public List<Map<String, Object>> generateAuditGalleyDefaultOutput() {
		return processInfoDao.generateAuditGalleyDefaultOutput();
	}

	@Override
	public List<Map<String, Object>> getJobLogDetails(int jobId) {
		return processInfoDao.getJobLogDetails(jobId);
	}

	@Override
	public int deleteJobLogDetails(int jobId, int jobLogSeq) {
		return processInfoDao.deleteJobLogDetails(jobId, jobLogSeq);
	}

	@Override
	public List<Map<String, Object>> getWorkTableErrorDetails() {
		return processInfoDao.getWorkTableErrorDetails();
	}

	@Override
	public int deleteWorkTableError(int jobId, int workTableSeq) {
		return processInfoDao.deleteWorkTableError(jobId, workTableSeq);
	}

	@Override
	public int updateResetStartDateTime(JobModel jobModel) {
		return processInfoDao.updateResetStartDateTime(jobModel);
	}

	@Override
	public List<Map<String, Object>> getManualSelectionDetails(int jobid, int customerId, int ocId) {
		return processInfoDao.getManualSelectionDetails(jobid, customerId, ocId);
	}

	@Override
	public int updateManualSelection(JobModel jobModel) {
		return processInfoDao.updateManualSelection(jobModel);

	}

	@Override
	public Map<String, Object> getExtractFilterTemplateData() {
		return processInfoDao.getExtractFilterTemplateData();
	}

	@Override
	public boolean createExtractFilter(ExtractModel extractFilterModel) {
		return processInfoDao.createExtractFilter(extractFilterModel);
	}

	@Override
	public boolean updateExtractFilter(ExtractModel extractFilterModel) {
		return processInfoDao.updateExtractFilter(extractFilterModel);
	}

	@Override
	public boolean deleteExtractFilter(ExtractModel extractFilterModel) {
		// TODO Auto-generated method stub
		return processInfoDao.deleteExtractFilter(extractFilterModel);
	}

	@Override
	public List<Map<String, Object>> getAccountingReconciliation() {

		return processInfoDao.getAccountingReconciliation();
	}

	@Override
	public List<Map<String, Object>> getReportFile() {

		return processInfoDao.getReportFile();
	}

	@Override
	public List<Map<String, Object>> getCloseAccountPeriod() {

		return processInfoDao.getCloseAccountPeriod();
	}

	@Override
	public int updateAccountPeriod(AccountingPeriod accountPeriod) {

		return processInfoDao.updateAccountPeriod(accountPeriod);
	}

	@Override
	public int deleteAccountPeriod(AccountingPeriod accountingPeriod,Integer... profitCenterCalendarSeq) {

		return processInfoDao.deleteAccountPeriod(accountingPeriod,profitCenterCalendarSeq);
	}

	@Override
	public int createAccountPeriod(AccountingPeriod accountingPeriod, String[] endDate,String... profit_center) {

		return processInfoDao.createAccountPeriod(accountingPeriod, profit_center,endDate);
	}

	@Override
	public int createProfitCenter(ProfitCenter profitCenter) {

		return processInfoDao.createProfitCenter(profitCenter);
	}

	@Override
	public int createSchedular(JobModel job) {

		return processInfoDao.createSchedular(job);
	}

	@Override
	public List<Map<String, Object>> getProfitCenter(AccountingPeriod accountPeriod) {

		return processInfoDao.getProfitCenter(accountPeriod);
	}

	@Override
	public List<Map<String, Object>> getOrderClassForAccounting(AccountingPeriod accountPeriod) {

		return processInfoDao.getOrderClassForAccounting(accountPeriod);
	}

	@Override
	public List<Map<String, Object>> profitCenterAccountingPeriod(AccountingPeriod accountPeriod) {

		return processInfoDao.profitCenterAccountingPeriod(accountPeriod);
	}

	@Override
	public List<Map<String, Object>> getOrderClassAccountingPeriod(AccountingPeriod accountPeriod) {

		return processInfoDao.getOrderClassAccountingPeriod(accountPeriod);
	}

	@Override
	public List<Map<String, Object>> getAccountSummaryBreak(AccountingPeriod accountPeriod) {

		return processInfoDao.getAccountSummaryBreak(accountPeriod);
	}

	@Override
	public List<Map<String, Object>> getProfitCenterCalender(AccountingPeriod accountPeriod) {

		return processInfoDao.getProfitCenterCalender(accountPeriod);
	}

	@Override
	public List<Map<String, Object>> getProfitCenterDetails(AccountingPeriod accountPeriod) {
		return processInfoDao.getProfitCenterDetails(accountPeriod);
	}

	@Override
	public List<Map<String, Object>> getAccountSummaryWithCalenderSeq(AccountingPeriod accountPeriod) {

		return processInfoDao.getAccountSummaryWithCalenderSeq(accountPeriod);
	}
	@Override
	public List<Map<String, Object>> getProfitCenterForAccountingPeriod(AccountingPeriod accountPeriod) {
	
		return processInfoDao.getProfitCenterForAccountingPeriod(accountPeriod);
	}
	
	@Override
	public int closeAccountPeriod(String... profit_center) {
		
		return processInfoDao.closeAccountPeriod(profit_center);
	}
	
	
	@Override
	public List<Map<String, Object>> getInsertDayEndJobs() {
		// TODO Auto-generated method stub
		return processInfoDao.getInsertDayEndJobs();
	}

	@Override
	public boolean updateInsertDayEndJobs(JobModel jobModel) {
		// TODO Auto-generated method stub
		return processInfoDao.updateInsertDayEndJobs(jobModel);
	}

	@Override
	public List<Map<String, Object>> getOrderClass(AccountingPeriod accountPeriod) {
		return processInfoDao.getOderClass(accountPeriod);
	}

	@Override
	public String getFirstProfitCenterForAccounting(Map<String, Object> rawProfitCenterFromDB) {
		
		return processInfoDao.getFirstProfitCenterForAccounting(rawProfitCenterFromDB);
	}

	@Override
	public List<Map<String, Object>> getBillDeftesting(String billingDef) {
		return processInfoDao.getBillDeftesting(billingDef);
	}

	@Override
	public List<Map<String, Object>> process(int effortNumber, String billingDef) {
		return processInfoDao.process(effortNumber,billingDef);
	}

	@Override
	public List<Map<String, Object>> getBilltesting(String billingDef) {
		return processInfoDao.getBilltesting(billingDef);
	}

	@Override
	public boolean insertSubmitAuditGalley(JobModel jobModel) {
		return processInfoDao.insertSubmitAuditGalley(jobModel);
	}

	@Override
	public List<Map<String, Object>> getOrderIssueDetails(int processId) {
		return processInfoDao.getOrderIssueDetails(processId);
	}

	@Override
	public List<Map<String, Object>> getAuditData(int processId) {
		return processInfoDao.getAuditData(processId);
	}

	@Override
	public List<Map<String, Object>> getJobOutputDetail(int processId) {
		return processInfoDao.getJobOutputDetail(processId);
	}

	@Override
	public boolean insertJobOutput(JobOutputModel jobOutputModel) {
		return processInfoDao.insertJobOutput(jobOutputModel);
	}

	@Override
	public boolean insertBackLabelJob(JobModel jobModel) {
		return processInfoDao.insertBackLabelJob(jobModel);
	}

	@Override
	public boolean insertLabelJob(JobModel jobModel) {
		return processInfoDao.insertLabelJob(jobModel);
	}

	@Override
	public int getJobId() {
		return processInfoDao.getJobId();
	}

	@Override
	public List<Map<String, Object>> getLabelDetails(int processId) {
		return processInfoDao.getLabelDetails(processId);
	}

	@Override
	public List<Map<String, Object>> getLabelJobPubOcDetail(int ocId) {
		return processInfoDao.getLabelJobPubOcDetail(ocId);
	}

	@Override
	public List<Map<String, Object>> getJobRenewalEffort(int jobId) {
		return processInfoDao.getJobRenewalEffort(jobId);
	}

	@Override
	public List<Map<String, Object>> getJobBillingDetails(int jobId) {
		return processInfoDao.getJobBillingDetails(jobId);
	}

	@Override
	public int getOcId() {
		return processInfoDao.getOcId();
	}

	@Override
	public String insertJobRenewalEffort(SubmitJobModel submitJobModel) {
		return processInfoDao.insertJobRenewalEffort(submitJobModel);
	}

	@Override
	public List<Map<String, Object>> getIssueDetails(String issueId, String issueDate, String enumeration,
			String volumeGroupId, String description) {
		return processInfoDao.getIssueDetails(issueId,issueDate,enumeration,volumeGroupId,description);
	}

	@Override
	public List<Map<String, Object>> getAddressDetails() {
		return processInfoDao.getAddressDetails();
	}

	@Override
	public String insertBillingJobEffort(SubmitJobModel submitJobModel, int jobId) {
		return processInfoDao.insertBillingJobEffort(submitJobModel,jobId);
	}

	@Override
	public List<Map<String, Object>> getJobRenewalEffortDetails() {
		return processInfoDao.getJobRenewalEffortDetails();
	}

	@Override
	public List<Map<String, Object>> billingDetails(String billingDef) {
		return processInfoDao.billingDetails(billingDef);
	}

	@Override
	public String insertProductSubmitJob(JobModel jobModel) {
		return processInfoDao.insertProductSubmitJob(jobModel);
	}

	@Override
	public List<Map<String, Object>> getProductSubmitJob(int jobId) {
		return processInfoDao.getProductSubmitJob(jobId);
	}

	

	@Override
	public String addJobOutput(String paramValues, String ouputFilename) {
		return processInfoDao.addJobOutput(paramValues,ouputFilename);
	}


	@Override
	public List<Map<String, Object>> getProductJobOutput(int ocId) {
		return processInfoDao.getProductJobOutput(ocId);
	}

	@Override
	public int insertInstallmentNotices(JobModel jobModel) {
		return processInfoDao.insertInstallmentNotices(jobModel);
	}

	@Override
	public List<Map<String, Object>> installNoticeSubmitJobDetails(int processId) {
		return processInfoDao.installNoticeSubmitJobDetails(processId);
	}

	@Override
	public List<Map<String, Object>> getCleanupSubmitJobDetails(int processId) {
		return processInfoDao.getCleanupSubmitJobDetails(processId);
	}

	@Override
	public int insertCleanupSubmitJob(JobModel jobModel) {
		return processInfoDao.insertCleanupSubmitJob(jobModel);
	}

	@Override
	public List<Map<String, Object>> getRefundSubmitJob(int processId) {
		return processInfoDao.getRefundSubmitJob(processId);
	}

	@Override
	public int insertRefundSubmitJob(JobModel jobModel) {
		return processInfoDao.insertRefundSubmitJob(jobModel);
	}

	@Override
	public int insertStartStopSubmitJob(JobModel jobModel) {
		return processInfoDao.insertStartStopSubmitJob(jobModel);
	}

	@Override
	public int insertJobPubOc(int ocId) {
		return processInfoDao.insertJobPubOc(ocId);
	}

	@Override
	public List<Map<String, Object>> allProcess(int effortNumber) {
		return processInfoDao.allProcess(effortNumber);
	}

	@Override
	public List<Map<String, Object>> allOrder(String billingDef) {
		return processInfoDao.allOrder(billingDef);
	}

	@Override
	public List<DropdownModel> getOutputDetails() {
		return processInfoDao.getOutputDetails();
	}

	@Override
	public List<Map<String, Object>> getStartStopSubmitJob(int processId) {
		return processInfoDao.getStartStopSubmitJob(processId);
	}

	@Override
	public List<Map<String, Object>> getjobPubOcDetail() {
		return processInfoDao.getjobPubOcDetail();
	}

	@Override
	public boolean insertJobPromotionEffort() {
		return processInfoDao.insertJobPromotionEffort();
	}

	@Override
	public List<Map<String, Object>> getJobPromotionDetails(int jobId) {
		return processInfoDao.getJobPromotionDetails(jobId);
	}

	@Override
	public boolean insertOnoff(JobModel jobModel) {
		return processInfoDao.insertOnoff(jobModel);
	}

	@Override
	public boolean insertOnOffJobPubOc(int issueId) {
		return processInfoDao.insertOnOffJobPubOc(issueId);
	}

	@Override
	public List<Map<String, Object>> getOnOffjobPubOcDetail() {
		return processInfoDao.getOnOffjobPubOcDetail();
	}

	@Override
	public int insertMassKillJob(JobModel jobModel) {
		return processInfoDao.insertMassKillJob(jobModel);
	}

	@Override
	public List<Map<String, Object>> getMassKill(int processId) {
		return processInfoDao.getMassKill(processId);
	}

	@Override
	public List<Map<String, Object>> getBillTesting(String billingDef) {
		return processInfoDao.getBillTesting(billingDef);
	}

	@Override
	public Object getBillingDefEffort(int processId) {
		return processInfoDao.getBillingDefEffort(processId);
	}

	@Override
	public int insertListExtract(JobModel jobModel) {
		return processInfoDao.insertListExtract(jobModel);
	}

	@Override
	public List<Map<String, Object>> getListExtract(int processId) {
		return processInfoDao.getListExtract(processId);
	}

	@Override
	public int insertIcsBatchListe(JobModel jobModel) {
		return processInfoDao.insertIcsBatchListe(jobModel);
	}

	@Override
	public List<Map<String, Object>> getIcsBatchListener(int processId) {
		return processInfoDao.getIcsBatchListener(processId);
	}

	@Override
	public List<Map<String, Object>> getCreditTokenRefresh(int processId) {
		return processInfoDao.getCreditTokenRefresh(processId);
	}

	@Override
	public int insertBacsBilling(JobModel jobModel) {
		return processInfoDao.insertBacsBilling(jobModel);
	}

	@Override
	public List<Map<String, Object>> getBacsBilling(int processId) {
		return processInfoDao.getBacsBilling(processId);
	}

	@Override
	public int insertBacsDD(JobModel jobModel) {
		return processInfoDao.insertBacsDD(jobModel);
	}

	@Override
	public List<Map<String, Object>> getBascDD(int processId) {
		return processInfoDao.getBascDD(processId);
	}


	
}
