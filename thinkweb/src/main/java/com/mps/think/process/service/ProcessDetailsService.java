package com.mps.think.process.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mps.think.model.DropdownModel;
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

public interface ProcessDetailsService {

	public List<ProcessModel> getProcessDetails(String active, String inactive);

	public List<DropdownModel> getbankDefDetails();

	public List<ProcessModel> getPaymentDetails(int processId);

	public Object getAuditOrderDetails(int processId);

	public List<Map<String, Object>> getselectedValue(int processId);

	public Object getOrderDetails(int processId, int processOcType);

	public List<DropdownModel> getQueueDetails();

	public ProcessModel getDefaultProcessDetails(int processId);

	public List<DropdownModel> getGroupDetails();

	public List<DropdownModel> getKeylineDetails();

	public List<DropdownModel> getOutputSortDetails();

	public List<Map<String, Object>> getselectedPCValue(int processId);

	public Object getPCDetails(int processId);

	public Object getbacsSelectionCurrency();

	public List<Map<String, Object>> getselectedCurrency(int processId);

	public Object getCleanupDefinitionDetails();

	public List<Map<String, Object>> getselectedCleanupValue(int processId);

	public List<Map<String, Object>> getLabelFormateList();

	public List<Map<String, Object>> getselectedReports(int processId);

	public Object getauditReports();

	public List<DropdownModel> getOrderClass();

	public String deleteProcessDetails(int processId);

	public Object getDefaultDropdown(int processId) throws SQLException;

	public String addNewProcess(int processType);

	public List<DropdownModel> getExtractDetails();

	public List<DropdownModel> getrenewalCardDetails(String ocId, String renewalDef);

	public List<DropdownModel> getVolumeGroupDetails();

	public Object getRenewalDefByDefault();

	public Object getRenewalDefDetails(int processId, int requal);

	public Object getRenewalEffortDetails(int processId);

	public Object getOrderDetailsTypeAll();

	public List<Map<String, Object>> getBillDefinintion(int processId);

	public List<EffortModel> getBillingEffort(int processId);

	public List<Map<String, Object>> getBillOrderClass();

	public List<Map<String, Object>> getInstallmentDetails(int processId);

	public List<DropdownModel> getOutputType();

	public List<DropdownModel> getOutput();

	public List<DropdownModel> getOutputFileFormat();

	public List<DropdownModel> getOc();

	public List<NthModel> getNthDef();

	public List<Map<String, Object>> getRenewalTesting(String renewalDef);

	public List<Map<String, Object>> getDefaultRenewalDetails(int processId);

	public List<DropdownModel> getAuditReport();

	public List<Map<String, Object>> getrenewalDisplay(int processId);

	public List<Map<String, Object>> getBillDisplayData(int processId);

	public List<DropdownModel> getInstallmentDropDown();

	public ProcessModel getsubmitjobData(int processId);

	public Object getPaymentType(int processId);

	public Object getAllCurrency(int processId);

	public List<Map<String, Object>> displayOutput();

	public List<OutputModel> getOutputData(int processId);

	public List<Map<String, Object>> billDefinitionTab(String billingDef);

	public List<EffortModel> getEfforts(String billingDef);

	public List<Map<String, Object>> getbillingDef();

	public List<Map<String, Object>> queueDisplay();

	public List<DropdownModel> getJobQueue();

	public List<Map<String, Object>> renewalDefinitionTab(String renewalDef);

	public List<EffortModel> getRenewalEfforts(String renewalDef);

	public List<JobModel> getJobQueueDisp(String queue, String onHold, String ready, String running, String dayEnd);

	public List<Map<String, Object>> getJobQueueList();

	List<NthModel> getNthDefDetails();

	List<Map<String, Object>> getSelectMethod(int selectMethod);

	public List<JobModel> getDefaultJobQueueDisp();

	public List<Object> getReviewJobHistory(long processId, int status);

	List<Object> getViewJobLog(long jobId);

	public boolean deleteJobQueue(long jobId);

	public Object getResetDate(long jobId);

	public boolean getHoldClear(long jobId);

	public List<DropdownModel> getProcessList();

	public List<Map<String, Object>> getSplit(Integer processId);

	public List<DropdownModel> getExtract();

	public int saveSplit(SplitDetailModel splitDetailModel);

	public int updateSplit(SplitDetailModel splitDetailModel);

	public int deleteSplit(Integer processId);

	public List<Map<String, Object>> getInsertsDetail(int processId);

	public int saveInsertsDetail(InsertsModel insertsModel);

	public int updateInsertsDetail(InsertsModel insertsModel);

	public int deteteInsertsDetail(int processId, int bitPosition);

	public Map<String, Object> getDescritionList(int processId);

	public int saveSort(SortModel sortModel);

	public int saveSortDetails(SortModel sortModel);

	public int updateSort(SortModel sortModel);

	public int deleteSort(int processSortFieldSeq, String processSort);

	public int deleteSortDetails(String processSort);

	public List<SortModel> getProcessSortFieldDetails(int processSortFieldSeq, String processSort);

	public List<DropdownModel> getTablenameInfo();

	public int savePromotion(PromotionModel promotionModel);

	public int savePromotionDefTest(PromotionModel promotionModel);

	public int savePromtionDefEffort(PromotionModel promotionModel);

	public List<Map<String, Object>> getOrderDetailsList(String promotionDef, int ocId);

	public List<Map<String, Object>> getProcessInfo(int processOcType);

	public List<Map<String, Object>> getAllOrderDetails(int ocId);

	public List<Map<String, Object>> getPromotionDefDetail(String promotionDef);

	public List<Map<String, Object>> getPromotionDefTest(String promotionDef, int promotionDefTestSeq);

	public List<Map<String, Object>> getPromotionDefEffortDetails(int effortNumber, String promotionDef);

	public List<DropdownModel> getNthDefDetail();

	public List<DropdownModel> getProcessMethod();

	public List<DropdownModel> getPromCardDetails(int promotionCradId);

	public int updatePromotionDef(PromotionModel promotionModel);

	public int updatePromotionDefTest(PromotionModel promotionModel);

	public int updatePromotiondefEffort(PromotionModel promotionModel);

	public int deletePromotionDefEffort(int effortNumber, String promotionDef);

	public int deletePromotionDefTest(String promotionDef, int promotionDefTestSeq);

	public int deletePromotionDef(String promotionDef);

	public String addProcesstypePromotion(ProcessModel processModel);

	public int editProcessTypePromotion(ProcessModel processModel);

	public int editRepeatingType(ProcessModel processModel);

	public int deleteProcessPromotion(int processId);

	public List<Map<String, Object>> getAudReport();

	public int deleteOutputPromotion(int processOutputSeq, int procesId);

	public boolean generateDefaultOutput(int processId);

	public boolean generateDefaultProductOutput(int processId);

	public boolean generateDefaultLabelOutput(int processId);

	public boolean generateStartrStopDefaultOutput(int processId);

	public int reprint(JobModel jobModel);

	public List<Map<String, Object>> getviewLabelDetail(int jobId);

	public Map<String, Object> getviewEffortDetail(int jobId, String action);

	public String restartUpdate(JobModel jobModel);

	public List<Map<String, Object>> generateAuditGalleyDefaultOutput();

	public List<Map<String, Object>> getJobLogDetails(int jobId);

	public int deleteJobLogDetails(int jobId, int jobLogSeq);

	public List<Map<String, Object>> getWorkTableErrorDetails();

	public int deleteWorkTableError(int jobId, int workTableSeq);

	public int updateResetStartDateTime(JobModel jobModel);

	public List<Map<String, Object>> getManualSelectionDetails(int jobid, int customerId, int ocId);

	public int updateManualSelection(JobModel jobModel);

	public Map<String, Object> getExtractFilterTemplateData();

	public boolean createExtractFilter(ExtractModel extractFilterModel);

	public boolean updateExtractFilter(ExtractModel extractFilterModel);

	public boolean deleteExtractFilter(ExtractModel extractFilterModel);

	public List<Map<String, Object>> getAccountingReconciliation();

	public List<Map<String, Object>> getReportFile();

	public List<Map<String, Object>> getCloseAccountPeriod();

	public int updateAccountPeriod(AccountingPeriod accountPeriod);

	public int deleteAccountPeriod(AccountingPeriod accountingPeriod,Integer... profitCenterCalendarSeq);

	public int createAccountPeriod(AccountingPeriod accountingPeriod, String[] endDate,String... profit_center);

	public int createProfitCenter(ProfitCenter profitCenter);

	public int createSchedular(JobModel job);

	public List<Map<String, Object>> getProfitCenter(AccountingPeriod accountPeriod);

	public List<Map<String, Object>> getOrderClassForAccounting(AccountingPeriod accountPeriod);

	public List<Map<String, Object>> profitCenterAccountingPeriod(AccountingPeriod accountPeriod);

	public List<Map<String, Object>> getOrderClassAccountingPeriod(AccountingPeriod accountPeriod);

	public List<Map<String, Object>> getAccountSummaryBreak(AccountingPeriod accountPeriod);

	public List<Map<String, Object>> getProfitCenterCalender(AccountingPeriod accountPeriod);

	public List<Map<String, Object>> getProfitCenterDetails(AccountingPeriod accountPeriod);

	public List<Map<String, Object>> getAccountSummaryWithCalenderSeq(AccountingPeriod accountPeriod);
	public List<Map<String, Object>> getOrderClass(AccountingPeriod accountPeriod);
	
	public String getFirstProfitCenterForAccounting(Map<String, Object> rawProfitCenterFromDB);
	
	public List<Map<String, Object>> getInsertDayEndJobs();

	
	public boolean updateInsertDayEndJobs(JobModel jobModel);

	public List<Map<String, Object>> getBillDeftesting(String billingDef);

	public List<Map<String, Object>> process(int effortNumber, String billingDef);

	public List<Map<String, Object>> getBilltesting(String billingDef);
	
	public boolean insertSubmitAuditGalley(JobModel jobModel);

	public List<Map<String, Object>> getOrderIssueDetails(int processId);


	public List<Map<String, Object>> getAuditData(int processId);

	public List<Map<String, Object>> getJobOutputDetail(int processId);

	public boolean insertJobOutput(JobOutputModel jobOutputModel);

	public boolean insertBackLabelJob(JobModel jobModel);

	public boolean insertLabelJob(JobModel jobModel);

	public int getJobId();

	public List<Map<String, Object>> getLabelDetails(int processId);

	public List<Map<String, Object>> getLabelJobPubOcDetail(int ocId);

	public List<Map<String, Object>> getJobRenewalEffort(int jobId);

	public List<Map<String, Object>> getJobBillingDetails(int jobId);

	public int getOcId();

	public String insertJobRenewalEffort(SubmitJobModel submitJobModel);

	public List<Map<String, Object>> getIssueDetails(String issueId, String issueDate, String enumeration,
			String volumeGroupId, String description);

	public List<Map<String, Object>> getAddressDetails();

	public String insertBillingJobEffort(SubmitJobModel submitJobModel, int jobId);

	public List<Map<String, Object>> getJobRenewalEffortDetails();

	public List<Map<String, Object>> billingDetails(String billingDef);

	public String insertProductSubmitJob(JobModel jobModel);

	public List<Map<String, Object>> getProductSubmitJob(int jobId);

	public String addJobOutput(String paramValues, String ouputFilename);


	public List<Map<String, Object>> getProductJobOutput(int ocId);

	public int insertInstallmentNotices(JobModel jobModel);

	public List<Map<String, Object>> installNoticeSubmitJobDetails(int processId);

	public List<Map<String, Object>> getCleanupSubmitJobDetails(int processId);

	public int insertCleanupSubmitJob(JobModel jobModel);

	public List<Map<String, Object>> getProfitCenterForAccountingPeriod(AccountingPeriod accountPeriod);

	public int closeAccountPeriod(String... profit_center);

	public List<Map<String, Object>> getRefundSubmitJob(int processId);

	public int insertRefundSubmitJob(JobModel jobModel);

	public int insertStartStopSubmitJob(JobModel jobModel);

	public int insertJobPubOc(int ocId);

	public List<Map<String, Object>> allProcess();

	public List<Map<String, Object>> allOrder(String billingDef);

	public List<DropdownModel> getOutputDetails();

	public List<Map<String, Object>> getStartStopSubmitJob(int processId);

	public List<Map<String, Object>> getjobPubOcDetail();

	public boolean insertJobPromotionEffort();

	public List<Map<String, Object>> getJobPromotionDetails(int jobId);

	public boolean insertOnoff(JobModel jobModel);

	public boolean insertOnOffJobPubOc(int issueId);

	public List<Map<String, Object>> getOnOffjobPubOcDetail();

	public int insertMassKillJob(JobModel jobModel);

	public List<Map<String, Object>> getMassKill(int processId);

	public List<Map<String, Object>> getBillTesting(String billingDef);

	public Object getBillingDefEffort(int processId);

	public int insertListExtract(JobModel jobModel);

	public List<Map<String, Object>> getListExtract(int processId);

	public int insertIcsBatchListe(JobModel jobModel);

	public List<Map<String, Object>> getIcsBatchListener(int processId);

	public List<Map<String, Object>> getCreditTokenRefresh(int processId);

	public int insertBacsBilling(JobModel jobModel);

	public List<Map<String, Object>> getBacsBilling(int processId);

	public int insertBacsDD(JobModel jobModel);

	public List<Map<String, Object>> getBascDD(int processId);

	public List<Map<String, Object>> getProcess(String billingDef);

	public List<Map<String, Object>> getOrders(String billingDef);

	public boolean getGeneratedBillCode(String billingDef);

	public List<Map<String, Object>> getBillOrderClassDetails(String billingDef, String showAllOc);

	public List<Map<String, Object>> getBillOrderClassInfo(String billingDef);

	public List<Map<String, Object>> getBillOrd(String billingDef);

	public Object getOrderDetailsTypeForSelected(String renewalDef);

	public List<Map<String, Object>> getEffortsDetails(String billingDef, String showAllPC);

	public List<Map<String, Object>> getEffortBasedProcess(String billingDef, int effortNumber);
	
	public List<Map<String, Object>> getshowProcessAll(String renewalDef);

	public Object getOrderDetailsTypeForSelectedForAdd();


	public List<DropdownModel> getProcessType();
	public  List<Map<String, Object>> getReconciliationProcessDetails(int processId);
	public List<DropdownModel> getDefaultJobQueue();
	public List<Map<String, Object>> getProfitCenterDetails();
	public List<Map<String, Object>> jobDetails(int jobId);

	public List<Map<String, Object>> getEditRenTestingData(String renewalDef);

	


}
