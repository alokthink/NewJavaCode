package com.mps.think.process.service;

import com.mps.think.process.model.EffortModel;
import com.mps.think.process.model.JobModel;
import com.mps.think.process.model.NthModel;

import java.util.List;

import com.mps.think.process.model.OutputModel;
import com.mps.think.process.model.ProcessModel;
import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.RenewalModel;


public interface ProcessSaveService {
	
	public boolean billingDefinitionSave(ProcessModel processModel);

	public String savePaymentDetails(ProcessModel processModel);

	public String saveLabelDetails(ProcessModel processModel);

	public String saveRefundDetails(ProcessModel processModel);

	public boolean selectAllOCSave(String ocId, int processId);

	public boolean clearAllOC(String ocId, int processId);

	public boolean addSelectedOrAllPC(String profitCenter, int processId);

	public boolean clearSelectedAllPC(String profitCenter, int processId);

	public String cleanUpsaveDetails(ProcessModel processModel);

	public String auditGallerysaveDetails(ProcessModel processModel);

	public String creditCardExpiryDetails(ProcessModel processModel);

	public String billRepeatingSave(ProcessModel processModel);

	public String billInstallmentSave(ProcessModel processModel);

	public String massKillDefSave(ProcessModel processModel);
	
	public String massKillSaveDetails(ProcessModel processModel);

	public String renewalSaveDetails(ProcessModel processModel);

	public String autoRenewalDefSave(ProcessModel processModel);

	public String renewalDefSave(ProcessModel processModel);

	public String addOCRenewalDef(String renewalDef, int ocId);

	public String addRenewalEffort(int processId, int effortNum, String renewalDef, int renewalDefTestSeq);

	public String deleteOCRenewaldef(String renewalDef, int ocId);

	public String deleteRenewalEffort(int processId, int effortNum, String renewalDef,int renewalDefTestSeq);

	public boolean billingSave(ProcessModel processModel);

	public boolean addBillingEffort(int effortNum,int processId,String billingDef, int billingDefTestSeq);
	
	public boolean deleteBillingEffort(int effortNum,int processId,String billingDef);

	public boolean addBillingOc(int ocId, String billingDef);

	public boolean deleteBillingOC(int ocId, String billingDef);

	public boolean generateDefaultOutput(int processId);

	public List<OutputModel> displayBillingOutput(int processId);

	public boolean saveBillingOutput(OutputModel outputModel);

	public String saveBackLabelDetails(ProcessModel processModel);

	public String saveEmailNotification(ProcessModel processModel);

	public boolean getSubmitJobSave(JobModel jobModel);

	public boolean editBillingOutput(OutputModel outputModel);

	public boolean saveOutput(OutputModel outputModel);

	public boolean editOutput(OutputModel outputModel);

	public boolean addPaymentType(int processId, String paymentType);

	public boolean addCurrency(int processId, String currency);

	public boolean clearPaymentType(int processId, String paymentType);

	public boolean clearCurrency(int processId, String currency);

	public boolean generateRenewalSourceCode(int ocId, String renewalDef);

	public String addNewRenewalDef(RenewalModel renewalModel);

	public String addNewRenewalEffort(RenewalEffortModel renewalEffortModel);

	public boolean genearteBillingCode(int ocId, String billingDef);

	public boolean addTesting(String billingDef, String description, String nthDef);

	public boolean addBillDefinition(String billingDef, String description, String extract);

	public boolean addBillingEfforts(EffortModel effortModel);

	public String checkDuplicateEffort(EffortModel effortModel);

	public boolean generateRenewalOutput(int processId);

	public String saveAccountingReconciliation(ProcessModel processModel);

	public boolean selectAllPCSave(String profitCenter, int processId);

	public boolean clearAllPC(String profitCenter, int processId);

	public String checkDuplicateBillDefinition(String billingDef);
	
	public String saveQueue(String queue, String description);

	public boolean addRenewalSourceCode(int ocId, String renewalDef);

	public boolean updateQueue(String queue, String description);

	public String editRenewalDef(RenewalModel renewalModel);

	public boolean editBillingDef(String billingDef, String description, String extract);

	public String editBillingEffort(EffortModel effortModel);

	public String editRenewalEffort(RenewalEffortModel renewalEffortModel);

	public boolean addRenTesting(String renewalDef, String description, String nthDef);

	public boolean deleteQueue(String queue);

	public boolean saveNthDef(NthModel nthModel);

	public boolean deleteNthDef(String string);

	public String deleteBillingDef(String billingDef);

	public String deleteBillingDefEffort(int effortNum,int processId, String billingDef);

	public int editBillingDefTest(String billingDef, int billingDefTestSeq, String description, String nthDef);

	public boolean billingCodeGeration(int ocId, String billingDef, int billingCode);

	public boolean addBillTesting(String billingDef, String description, String nthDef);

	public String deleteBillingDefTet(String billingDef, int billingDefTestSeq);

	public int addBillOrderClass(int ocId, String billingDef);

	public int removeOrderClass(int ocId, String billingDef);

	public int removeInstallmentSave(int processId);

	public int addBillProcess(int processId, String billingDef, int effortNumber);

	public int removeBillProcess(int processId, String billingDef);

	public String getRenTestingProgressSave(String nthDef, String description, String renewalDef,
			Integer renewalDefTestSeq);


}
