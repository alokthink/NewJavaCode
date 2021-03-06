package com.mps.think.process.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mps.think.process.dao.ProcessSaveDao;
import com.mps.think.process.model.EffortModel;
import com.mps.think.process.model.JobModel;
import com.mps.think.process.model.NthModel;
import com.mps.think.process.model.OutputModel;
import com.mps.think.process.model.ProcessModel;
import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.RenewalModel;
import com.mps.think.process.service.ProcessSaveService;


@Service("ProcessSaveService")
public class ProcessSaveServiceImpl implements ProcessSaveService{
	@Autowired
	ProcessSaveDao processSaveDao;

	@Override
	public boolean billingDefinitionSave(ProcessModel processModel) {
		 return processSaveDao.billingDefinitionSave(processModel);
	}

	@Override
	public String saveLabelDetails(ProcessModel processModel) {
		return processSaveDao.saveLabelDetails(processModel);
	}

	@Override
	public String savePaymentDetails(ProcessModel processModel) {
		return processSaveDao.savePaymentDetails(processModel);
	}

	@Override
	public String saveRefundDetails(ProcessModel processModel) {
		return processSaveDao.saveRefundDetails(processModel);

	}

	@Override
	public boolean selectAllOCSave(String ocId, int processId) {
		return processSaveDao.selectAllOCSave(ocId,processId);
	}

	@Override
	public boolean clearAllOC(String ocId, int processId) {
		return processSaveDao.clearAllOC(ocId,processId);
	}

	@Override
	public boolean addSelectedOrAllPC(String profitCenter, int processId) {
		return processSaveDao.addSelectedOrAllPC(profitCenter,processId);
	}

	@Override
	public boolean clearSelectedAllPC(String profitCenter, int processId) {
		return processSaveDao.clearSelectedAllPC(profitCenter,processId);
	}

	@Override
	public String cleanUpsaveDetails(ProcessModel processModel) {
		return processSaveDao.cleanUpsaveDetails(processModel);
	}
	
	@Override
	public String auditGallerysaveDetails(ProcessModel processModel) {
		return processSaveDao.auditGallerysaveDetails(processModel);
	}
	
	@Override
	public String creditCardExpiryDetails(ProcessModel processModel) {
		return processSaveDao.creditCardExpiryDetails(processModel);
	}

	
	@Override
	public String massKillSaveDetails(ProcessModel processModel){
		return processSaveDao.saveMasskillDetails(processModel);
	}
	
	@Override
	public String renewalSaveDetails(ProcessModel processModel){
		return processSaveDao.saveRenewalsDetails(processModel);
	}
	
	@Override
	public String billRepeatingSave(ProcessModel processModel) {
		return processSaveDao.billRepeatingSave(processModel);
	}

	@Override
	public String billInstallmentSave(ProcessModel processModel) {
		return processSaveDao.billInstallmentSave(processModel);
	}

	@Override
	public String massKillDefSave(ProcessModel processModel) {
		return processSaveDao.massKillDefSave(processModel);
	}
	@Override
	public String autoRenewalDefSave(ProcessModel processModel) {
		return processSaveDao.autoRenewalDefSave(processModel);
	}

	@Override
	public String renewalDefSave(ProcessModel processModel) {
		return processSaveDao.renewalDefSave(processModel);
	}

	@Override
	public String addOCRenewalDef(String renewalDef, int ocId) {
		return processSaveDao.addOCRenewalDef(renewalDef,ocId);
	}

	@Override
	public String addRenewalEffort(int processId, int effortNum, String renewalDef,int renewalDefTestSeq) {
		return processSaveDao.addRenewalEffort(processId,effortNum,renewalDef,renewalDefTestSeq);
	}

	@Override
	public String deleteOCRenewaldef(String renewalDef, int ocId) {
		return processSaveDao.deleteOCRenewaldef(renewalDef,ocId);
	}

	@Override
	public String deleteRenewalEffort(int processId, int effortNum, String renewalDef,int renewalDefTestSeq) {
		return processSaveDao.deleteRenewalEffort(processId,effortNum,renewalDef,renewalDefTestSeq);
	}

	@Override
	public boolean billingSave(ProcessModel processModel) {
		return processSaveDao.billingSave(processModel);
	}

	@Override
	public boolean addBillingEffort(int effortNum,int processId,String billingDef,int billingDefTestSeq) {
		return processSaveDao.addBillingEffort(effortNum,processId,billingDef,billingDefTestSeq);
	}
	
	@Override
	public boolean deleteBillingEffort(int effortNum,int processId,String billingDef) {
		return processSaveDao.deleteBillingEffort(effortNum,processId,billingDef);
	}

	@Override
	public boolean addBillingOc(int ocId, String billingDef) {
		return processSaveDao.addBillingOc(ocId,billingDef);
	}

	@Override
	public boolean deleteBillingOC(int ocId, String billingDef) {
		return processSaveDao.deleteBillingOC(ocId,billingDef);
	}

	@Override
	public boolean generateDefaultOutput(int processId) {
		return processSaveDao.generateDefaultOutput(processId);
	}

	@Override
	public List<OutputModel> displayBillingOutput(int processId) {
		return processSaveDao.displayBillingOutput(processId);
	}

	@Override
	public boolean saveBillingOutput(OutputModel outputModel) {
		return processSaveDao.saveBillingOutput(outputModel);
	}

	@Override
	public String saveBackLabelDetails(ProcessModel processModel) {
		return processSaveDao.saveBackLabelDetails(processModel);
	}

	@Override
	public String saveEmailNotification(ProcessModel processModel) {
		return processSaveDao.saveEmailNotification(processModel);
	}
	
	@Override
	public boolean getSubmitJobSave(JobModel jobModel) {
		return processSaveDao.getSubmitJobSave(jobModel);
	}

	@Override
	public boolean editBillingOutput(OutputModel outputModel) {
		return processSaveDao.editBillingOutput(outputModel);
	}

	@Override
	public boolean saveOutput(OutputModel outputModel) {
		return processSaveDao.saveOutput(outputModel);
	}

	@Override
	public boolean editOutput(OutputModel outputModel) {
		return processSaveDao.editOutput(outputModel);
	}

	

	@Override
	public boolean addPaymentType(int processId, String paymentType) {
		return processSaveDao.addPaymentType(processId,paymentType);
	}

	@Override
	public boolean addCurrency(int processId, String currency) {
		return processSaveDao.addCurrency(processId,currency);
	}

	@Override
	public boolean clearPaymentType(int processId, String paymentType) {
		return processSaveDao.clearPaymentType(processId,paymentType);
	}

	@Override
	public boolean clearCurrency(int processId, String currency) {
		return processSaveDao.clearCurrency(processId,currency);
	}

	@Override
	public String saveQueue(String queue, String description) {
		return processSaveDao.saveQueue(queue, description);
	}

	@Override
	public boolean addRenewalSourceCode(int ocId, String renewalDef) {
		return processSaveDao.addRenewalSourceCode(ocId, renewalDef);
	}

	@Override
	public boolean genearteBillingCode(int ocId, String billingDef) {
		return processSaveDao.genearteBillingCode(ocId, billingDef);
	}

	@Override
	public boolean updateQueue(String queue, String description) {
		return processSaveDao.updateQueue(queue,description);
	}

	@Override
	public boolean generateRenewalSourceCode(int ocId, String renewalDef) {
	return processSaveDao.generateRenewalSourceCode(ocId,renewalDef);
	}

	@Override
	public String addNewRenewalDef(RenewalModel renewalModel) {
		return processSaveDao.addNewRenewalDef(renewalModel);
	}

	@Override
	public String addNewRenewalEffort(RenewalEffortModel renewalEffortModel) {
		return processSaveDao.addNewRenewalEffort(renewalEffortModel);
	}

	@Override
	public boolean addTesting(String billingDef, String description, String nthDef) {
		return processSaveDao.addTesting(billingDef,description,nthDef);
	}

	@Override
	public boolean addBillDefinition(String billingDef, String description, String extract) {
		return processSaveDao.addBillDefinition(billingDef,description,extract);
	}

	@Override
	public boolean addBillingEfforts(EffortModel effortModel) {
		return processSaveDao.addBillingEfforts(effortModel);
	}

	@Override
	public String checkDuplicateEffort(EffortModel effortModel) {
		return processSaveDao.checkDuplicateEffort(effortModel);
	}

	@Override
	public boolean generateRenewalOutput(int processId) {
		return processSaveDao.generateRenewalOutput(processId);
	}

	@Override
	public String saveAccountingReconciliation(ProcessModel processModel) {
		return processSaveDao.saveAccountingReconciliation(processModel);
	}

	@Override
	public boolean selectAllPCSave(String profitCenter, int processId) {
		return processSaveDao.selectAllPCSave(profitCenter,processId);
	}

	@Override
	public boolean clearAllPC(String profitCenter, int processId) {
		return processSaveDao.clearAllPC(profitCenter,processId);
	}

	@Override
	public String checkDuplicateBillDefinition(String billingDef) {
		return processSaveDao.checkDuplicateBillDefinition(billingDef);
	}

	@Override
	public String editRenewalDef(RenewalModel renewalModel) {
		return processSaveDao.editRenewalDef(renewalModel);
	}

	@Override
	public boolean editBillingDef(String billingDef, String description, String extract) {
		return processSaveDao.editBillingDef(billingDef,description,extract);
	}

	@Override
	public String editBillingEffort(EffortModel effortModel) {
		return processSaveDao.editBillingEffort(effortModel);
	}

	@Override
	public String editRenewalEffort(RenewalEffortModel renewalEffortModel) {
		return processSaveDao.editRenewalEffort(renewalEffortModel);
	}

	@Override
	public boolean addRenTesting(String renewalDef, String description, String nthDef) {
		return processSaveDao.addRenTesting(renewalDef,description,nthDef);
	}

	@Override
	public boolean deleteQueue(String queue) {
		return processSaveDao.deleteQueue(queue);
	}

	@Override
	public boolean saveNthDef(NthModel nthModel) {
		return processSaveDao.saveNthDef(nthModel);
	}

	@Override
	public boolean deleteNthDef(String nthDef) {
		return processSaveDao.deleteNthDef(nthDef);
	}

	@Override
	public int deleteBillingDef(String billingDef, int billingDefTestSeq,int ocId) {
		return processSaveDao.deleteBillingDef(billingDef,billingDefTestSeq,ocId);
	}

	@Override
	public int deleteBillingDefEffort(int effortNum,int processId, String billingDef) {
		return processSaveDao.deleteBillingDefEffort(effortNum,processId,billingDef);
	}

	@Override
	public int editBillingDefTest(String billingDef, int billingDefTestSeq, String description, String nthDef) {
		return processSaveDao.editBillingDefTest(billingDef,billingDefTestSeq,description,nthDef);
	}

	@Override
	public boolean billingCodeGeration(int ocId, String billingDef,int billingCode) {
		return processSaveDao.billingCodeGeration(ocId,billingDef,billingCode);
	}

	@Override
	public boolean addBillTesting(String billingDef, String description, String nthDef) {
		return processSaveDao.addBillTesting(billingDef,description,nthDef);
	}

	

}
