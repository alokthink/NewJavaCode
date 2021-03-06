package com.mps.think.process.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.process.daoImpl.ProcessDetailsDaoImp;
import com.mps.think.process.model.EffortModel;
import com.mps.think.process.model.ExtractModel;
import com.mps.think.process.model.JobModel;
import com.mps.think.process.model.NthModel;
import com.mps.think.process.model.OutputModel;
import com.mps.think.process.model.ProcessModel;
import com.mps.think.process.model.RenewalEffortModel;
import com.mps.think.process.model.RenewalModel;
import com.mps.think.process.service.ProcessDetailsService;
import com.mps.think.process.service.ProcessSaveService;
import com.mps.think.util.CustomerUtility;

@RestController
public class ProcessSaveController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessDetailsDaoImp.class);
	
	@Autowired
	ProcessSaveService processSaveService;
	
	@Autowired
	ProcessDetailsService processDetailService;
	
	@RequestMapping(path="/billingDefinitionSave", method = RequestMethod.POST)
	public Map<String, Object>billingDefinitionSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			boolean billingDefinitionSave = processSaveService.billingDefinitionSave(processModel);
			responseObject.put("billingDefinitionSave",billingDefinitionSave);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/paymentSave", method = RequestMethod.POST)
	public Map<String, Object>paymentSaveDetails(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try{
			String processList = processSaveService.savePaymentDetails(processModel);
			responseObject.put("ProcessInfo",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/selectAllOC", method = RequestMethod.POST)
	public Map<String, Object> selectAllSave(@RequestParam("ocId") String ocId, @RequestParam("processId") int processId,
			@RequestParam("processOcType") String processOcType){
		Map<String, Object> responseObject = new LinkedHashMap<>();
	try{
		boolean selectAllSave = processSaveService.selectAllOCSave(ocId,processId);
		responseObject.put("data",selectAllSave);
		responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId,Integer.parseInt(processOcType)));
	    responseObject.put(STATUS,SUCCESS);
	    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/clearAllOC", method = RequestMethod.POST)
	public Map<String, Object> clearAll(@RequestParam("ocId") String ocId, @RequestParam("processId") int processId,
			@RequestParam("processOcType") String processOcType){
		Map<String, Object> responseObject = new LinkedHashMap<>();
	try{
		boolean clearAll = processSaveService.clearAllOC(ocId,processId);
		responseObject.put("data",clearAll);
		responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId,Integer.parseInt(processOcType)));
	    responseObject.put(STATUS,SUCCESS);
	    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	
}
	
	@RequestMapping(path="/labelSave", method = RequestMethod.POST)
	public Map<String, Object> labelSaveDetails(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.saveLabelDetails(processModel);
			responseObject.put("ProcessInfo",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/refundSave", method = RequestMethod.POST)
	public Map<String, Object> refundSaveDetails(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.saveRefundDetails(processModel);
			responseObject.put("ProcessInfo",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/addSelectedOrAllPC", method = RequestMethod.POST)
	public Map<String, Object> addSelectedOrAllPC(@RequestParam("profitCenter") String profitCenter, @RequestParam("processId") int processId){
		Map<String, Object> responseObject = new LinkedHashMap<>();
	try{
		boolean selectAllSave = processSaveService.addSelectedOrAllPC(profitCenter,processId);
		responseObject.put("data",selectAllSave);
	    responseObject.put(STATUS,SUCCESS);
	    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/clearSelectedOrAllPC", method = RequestMethod.POST)
	public Map<String, Object> clearSelectedAllPC(@RequestParam("profitCenter") String profitCenter, @RequestParam("processId") int processId){
		Map<String, Object> responseObject = new LinkedHashMap<>();
	try{
		boolean clearAll = processSaveService.clearSelectedAllPC(profitCenter,processId);
		responseObject.put("data",clearAll);
	    responseObject.put(STATUS,SUCCESS);
	    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	
}

@RequestMapping(path="/auditGallerySave", method = RequestMethod.POST)
	public Map<String, Object> auditGallerysaveDetails(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.auditGallerysaveDetails(processModel);
			responseObject.put("ProcessInfo",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	

	@RequestMapping(path="/creditCardExpirySave", method = RequestMethod.POST)
	public Map<String, Object> creditCardExpiryDetails(ProcessModel pm){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.creditCardExpiryDetails(pm);
			responseObject.put("ProcessInfo",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/cleanUpSave", method = RequestMethod.POST)
	public Map<String, Object> cleanUpSaveDetails(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.cleanUpsaveDetails(processModel);
			responseObject.put("ProcessInfo",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	@RequestMapping(path="/massKillDefSave", method = RequestMethod.POST)
	public Map<String, Object> massKillSaveDetails(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.massKillDefSave(processModel);
			responseObject.put("ProcessInfo",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/billRepeatingSave", method = RequestMethod.POST)
	public Map<String, Object> billRepeatingSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String billRepeatingSave = processSaveService.billRepeatingSave(processModel);
			responseObject.put("BillRepeatingSave",billRepeatingSave);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			} 
	}
	
	@RequestMapping(path="/billInstallmentSave", method = RequestMethod.POST)
	public Map<String, Object> billInstallmentSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String billInstallmentSave = processSaveService.billInstallmentSave(processModel);
			responseObject.put("BillInstallmentSave",billInstallmentSave);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/autoRenewalDefSave", method = RequestMethod.POST)
	public Map<String, Object> AutoRenewalDefSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String autoRenewalSave = processSaveService.autoRenewalDefSave(processModel);
			responseObject.put("data",autoRenewalSave);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/renewalDefSave", method = RequestMethod.POST)
	public Map<String, Object> RenewalDefSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String renewalDefSave = processSaveService.renewalDefSave(processModel);
			responseObject.put("data",renewalDefSave);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/massKillsave", method = RequestMethod.POST)
	public Map<String, Object> massKillsave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.massKillSaveDetails(processModel);
			responseObject.put("data",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/renewalSave", method = RequestMethod.POST)
	public Map<String, Object> renewalSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.renewalSaveDetails(processModel);
			responseObject.put("data",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/addOCRenewaldef", method = RequestMethod.POST)
	public Map<String,Object> addOCRenewalDef(@RequestParam("renewalDef") String renewalDef,@RequestParam("ocId") int ocId,
			@RequestParam("processId") int processId,@RequestParam("requal") int requal) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String ocList = processSaveService.addOCRenewalDef(renewalDef,ocId);
			responseObject.put("data",ocList);
		    responseObject.put("OrderDetails", processDetailService.getOrderDetailsTypeAll());
		    responseObject.put("RenewalEffort", processDetailService.getRenewalEffortDetails(processId));
		    responseObject.put("RenewalDef",processDetailService.getRenewalDefDetails(processId,requal));
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/deleteOCRenewaldef", method = RequestMethod.POST)
	public Map<String,Object> deleteOCRenewaldef(@RequestParam("renewalDef") String renewalDef,@RequestParam("ocId") int ocId,
			@RequestParam("processId") int processId,@RequestParam("requal") int requal) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String delOCList = processSaveService.deleteOCRenewaldef(renewalDef,ocId);
			responseObject.put("data",delOCList);
		    responseObject.put("OrderDetails", processDetailService.getOrderDetailsTypeAll());
		    responseObject.put("RenewalEffort", processDetailService.getRenewalEffortDetails(processId));
		    responseObject.put("RenewalDef",processDetailService.getRenewalDefDetails(processId,requal));
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/addRenewalEffort", method = RequestMethod.POST)
	public Map<String,Object> addRenewalEffort(@RequestParam("processId") int processId,
			@RequestParam("effortNum") int effortNum,@RequestParam("renewalDef") String renewalDef,
			@RequestParam("requal") int requal,@RequestParam("renewalDefTestSeq") int renewalDefTestSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String addRenEffortList = processSaveService.addRenewalEffort(processId,effortNum,renewalDef,renewalDefTestSeq);
			responseObject.put("data",addRenEffortList);
		    responseObject.put("OrderDetails", processDetailService.getOrderDetailsTypeAll());
		    responseObject.put("RenewalEffort", processDetailService.getRenewalEffortDetails(processId));
		    responseObject.put("RenewalDef",processDetailService.getRenewalDefDetails(processId,requal));
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/deleteRenewalEffort", method = RequestMethod.POST)
	public Map<String,Object> deleteRenewalEffort(@RequestParam("processId") int processId,
			@RequestParam("effortNum") int effortNum,@RequestParam("renewalDef") String renewalDef,
			@RequestParam("requal") int requal,@RequestParam("renewalDefTestSeq") int renewalDefTestSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String delRenEffortList = processSaveService.deleteRenewalEffort(processId,effortNum,renewalDef,renewalDefTestSeq);
			responseObject.put("data",delRenEffortList);
		    responseObject.put("OrderDetails", processDetailService.getOrderDetailsTypeAll());
		    responseObject.put("RenewalEffort", processDetailService.getRenewalEffortDetails(processId));
		    responseObject.put("RenewalDef",processDetailService.getRenewalDefDetails(processId,requal));
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}

	@RequestMapping(path="/billingSave", method = RequestMethod.POST)
	public Map<String, Object>billingSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			boolean billingSave = processSaveService.billingSave(processModel);
			responseObject.put("billingSave",billingSave);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/addBillingEffort", method = RequestMethod.POST)
	public Map<String, Object>addBillingEffort(@RequestParam("effortNum") int effortNum, @RequestParam("processId") int processId,
			@RequestParam("billingDef") String billingDef,@RequestParam("billingDefTestSeq") int billingDefTestSeq){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			boolean addBillingEffort = processSaveService.addBillingEffort(effortNum,processId,billingDef,billingDefTestSeq);
			responseObject.put("addBillingEffort",addBillingEffort);
			responseObject.put("BillingDefinition",processDetailService.getBillDefinintion(processId));
			responseObject.put("BillingEffort", processDetailService.getBillingEffort(processId));
			responseObject.put("BillOrderClass",processDetailService.getBillOrderClass());
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/deleteBillingEffort", method = RequestMethod.POST)
	public Map<String, Object>deleteBillingEffort(@RequestParam("effortNum") int effortNum, @RequestParam("processId") int processId,
			@RequestParam("billingDef") String billingDef){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			boolean deleteBillingEffort = processSaveService.deleteBillingEffort(effortNum,processId,billingDef);
			responseObject.put("deleteBillingEffort",deleteBillingEffort);
			responseObject.put("BillingDefinition",processDetailService.getBillDefinintion(processId));
			responseObject.put("BillingEffort", processDetailService.getBillingEffort(processId));
			responseObject.put("BillOrderClass",processDetailService.getBillOrderClass());
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path = "/addBillingOc", method = RequestMethod.POST)
	public Map<String, Object> addBillingOc(@RequestParam("ocId") int ocId,
			@RequestParam("billingDef") String billingDef, @RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean addBillingOc = processSaveService.addBillingOc(ocId, billingDef);
			responseObject.put("addBillingOc", addBillingOc);
			responseObject.put("BillingDefinition",processDetailService.getBillDefinintion(processId));
			responseObject.put("BillingEffort", processDetailService.getBillingEffort(processId));
			responseObject.put("BillOrderClass",processDetailService.getBillOrderClass());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteBillingOc", method = RequestMethod.POST)
	public Map<String, Object> deleteBillingOC(@RequestParam("ocId") int ocId,
			@RequestParam("billingDef") String billingDef, @RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean deleteBillingOC = processSaveService.deleteBillingOC(ocId, billingDef);
			responseObject.put("deleteBillingOc", deleteBillingOC);
			responseObject.put("BillingDefinition",processDetailService.getBillDefinintion(processId));
			responseObject.put("BillingEffort", processDetailService.getBillingEffort(processId));
			responseObject.put("BillOrderClass",processDetailService.getBillOrderClass());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/backLabelSave", method = RequestMethod.POST)
	public Map<String, Object> backLabelSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.saveBackLabelDetails(processModel);
			responseObject.put("data",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/emailNotificationSave", method = RequestMethod.POST)
	public Map<String, Object> emailNotificationSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String emailList = processSaveService.saveEmailNotification(processModel);
			responseObject.put("data",emailList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/generateDefaultOutput", method = RequestMethod.POST)
	public Map<String, Object>billingOutput(int processId,String processType){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		boolean defaultOutput = false;
		try{
			switch(processType) {
			case "Billing":			
				defaultOutput = processSaveService.generateDefaultOutput(processId);
			break;
			case "Renewal":
				defaultOutput = processSaveService.generateRenewalOutput(processId);				
			break;
			}			
			List<OutputModel> displayBillingOutput = processSaveService.displayBillingOutput(processId);
			responseObject.put("defaultOutput",defaultOutput);
			responseObject.put("displayBillingOutput",displayBillingOutput);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/saveBillingOutput", method = RequestMethod.POST)
	public Map<String, Object>saveBillingOutput(OutputModel outputModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			boolean saveBillingOutput = processSaveService.saveBillingOutput(outputModel);
			List<OutputModel> displayBillingOutput = processSaveService.displayBillingOutput(outputModel.getProcessId());
			responseObject.put("saveBillingOutput",saveBillingOutput);
			responseObject.put("displayBillingOutput",displayBillingOutput);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
		
	@RequestMapping(path = "/submitSaveJob", method = RequestMethod.POST)
	public Map<String, Object> submitSaveJob(JobModel jobModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean saveSaveSubmitJob = processSaveService.getSubmitJobSave(jobModel);	
			responseObject.put("saveSubmitJob", saveSaveSubmitJob);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/selectPaymentType", method = RequestMethod.POST)
	public Map<String, Object> addPaymentType(int processId,String paymentType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean addPayment = processSaveService.addPaymentType(processId,paymentType);	
			responseObject.put("addPayment", addPayment);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/selectCurrency", method = RequestMethod.POST)
	public Map<String, Object> addCurrency(int processId,String currency) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean addCurrency = processSaveService.addCurrency(processId,currency);	
			responseObject.put("addCurrency", addCurrency);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/clearPaymentType", method = RequestMethod.POST)
	public Map<String, Object> clearPaymentType(int processId,String paymentType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean clearPayment = processSaveService.clearPaymentType(processId,paymentType);	
			responseObject.put("clearPayment", clearPayment);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/clearCurrency", method = RequestMethod.POST)
	public Map<String, Object> clearCurrency(int processId,String currency) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean clearCurrency = processSaveService.clearCurrency(processId,currency);	
			responseObject.put("clearCurrency", clearCurrency);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/generateRenewalSourceCode", method = RequestMethod.POST)
	public Map<String, Object> generateRenewalSourceCode(int ocId,String renewalDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean generateSource = processSaveService.generateRenewalSourceCode(ocId,renewalDef);	
			responseObject.put("generateSource", generateSource);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/editBillingOutput", method = RequestMethod.POST)
	public Map<String, Object>editBillingOutput(OutputModel outputModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			boolean editBillingOutput = processSaveService.editBillingOutput(outputModel);
			List<OutputModel> displayBillingOutput = processSaveService.displayBillingOutput(outputModel.getProcessId());
			responseObject.put("editBillingOutput",editBillingOutput);
			responseObject.put("displayBillingOutput",displayBillingOutput);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	@RequestMapping(path="/saveOutput", method = RequestMethod.POST)
	public Map<String, Object>saveOutput(OutputModel outputModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			boolean saveOutput = processSaveService.saveOutput(outputModel);
			List<Map<String, Object>> displayOutput = processDetailService.displayOutput();			
			responseObject.put("saveOutput",saveOutput);
			responseObject.put("displayOutput",displayOutput);
			responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	@RequestMapping(path="/editOutput", method = RequestMethod.POST)
	public Map<String, Object>editOutput(OutputModel outputModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			boolean editOutput = processSaveService.editOutput(outputModel);
			List<Map<String, Object>> displayOutput = processDetailService.displayOutput();
			responseObject.put("editOutput",editOutput);
			responseObject.put("displayOutput",displayOutput);
			responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path = "/saveQueue", method = RequestMethod.POST)
	public Map<String,Object> saveQueue(@RequestParam("queue")String queue,@RequestParam("description")String description){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String saveQueue = processSaveService.saveQueue(queue,description);
			List<Map<String, Object>> queueDisplay = processDetailService.queueDisplay();
			responseObject.put("queueDisplay",queueDisplay);
			responseObject.put("saveQueue", saveQueue);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/addNewRenewalDef", method = RequestMethod.POST)
	public Map<String, Object>addNewRenewalDef(RenewalModel renewalModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String addRenewalDef = processSaveService.addNewRenewalDef(renewalModel);
			responseObject.put("addrenewalDef",addRenewalDef);
			responseObject.put("RenewalDef",processDetailService.getRenewalDefDetails(renewalModel.getProcessId(),renewalModel.getRequal()));
			responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/addNewRenewalEffort", method = RequestMethod.POST)
	public Map<String, Object>addNewRenewalEffort(RenewalEffortModel renewalEffortModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String addRenewalDef = processSaveService.addNewRenewalEffort(renewalEffortModel);
			  responseObject.put("addrenewalDef",addRenewalDef);
			  responseObject.put("RenewalEffort", processDetailService.getRenewalEffortDetails(renewalEffortModel.getProcessId()));
			  responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path = "/genearteBillingCode", method = RequestMethod.POST)
	public Map<String, Object> genearteBillingCode(int ocId,String billingDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean genearteBillingCode = processSaveService.genearteBillingCode(ocId,billingDef);	
			responseObject.put("genearteBillingCode", genearteBillingCode);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/addTesting", method = RequestMethod.POST)
	public Map<String, Object> addTesting(String billingDef,String description,String nthDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean addTesting = processSaveService.addTesting(billingDef,description,nthDef);	
			List<Map<String, Object>> billTesting = processDetailService.getBilltesting(billingDef);		
			responseObject.put("addTesting", addTesting);
			responseObject.put("billTesting", billTesting);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/addBillDefinition", method = RequestMethod.POST)
	public Map<String, Object> addBillDefinition(String billingDef,String description,String extract,int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String checkDuplicateBillDefinition= processSaveService.checkDuplicateBillDefinition(billingDef);
			if(checkDuplicateBillDefinition.equals("1")) {
				responseObject.put("Duplicate Record","Found");
				return responseObject;
				
			}else {
			boolean addBillDefinition = processSaveService.addBillDefinition(billingDef,description,extract);			
			List<Map<String, Object>> billingDefinition = processDetailService.getBillDefinintion(processId);			 
			responseObject.put("addBillDefinition", addBillDefinition);
			responseObject.put("BillingDefinition", billingDefinition);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/addBillTesting", method = RequestMethod.POST)
	public Map<String, Object> addbillTes(String billingDef,String description,String nthDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean addTesting = processSaveService.addBillTesting(billingDef,description,nthDef);	
			List<Map<String, Object>> billTesting = processDetailService.getBillTesting(billingDef);		
			responseObject.put("addTesting", addTesting);
			responseObject.put("billTesting", billTesting);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/addBillingEfforts", method = RequestMethod.POST)
	public Map<String, Object> addBillingEfforts(EffortModel effortModel,int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String checkDuplicateEffort= processSaveService.checkDuplicateEffort(effortModel);
			if(checkDuplicateEffort.equals("1")) {
				responseObject.put("Duplicate Record","Found");
				return responseObject;
				
			}else {
			boolean addBillingEfforts = processSaveService.addBillingEfforts(effortModel);
			responseObject.put("addBillingEfforts", addBillingEfforts);
			//responseObject.put("BillingEfforts", processDetailService.getBillingEffort(processId));
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/accountingReconciliationSave", method = RequestMethod.POST)
	public Map<String, Object> accountingReconciliationSave(ProcessModel processModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String processList = processSaveService.saveAccountingReconciliation(processModel);
			responseObject.put("ProcessInfo",processList);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/selectAllPC", method = RequestMethod.POST)
	public Map<String, Object> selectAllPC(@RequestParam("profitCenter") String profitCenter, @RequestParam("processId") int processId){
		Map<String, Object> responseObject = new LinkedHashMap<>();
	try{
		boolean selectAllSave = processSaveService.selectAllPCSave(profitCenter,processId);
		responseObject.put("data",selectAllSave);
		responseObject.put("PCDetails", processDetailService.getPCDetails(processId));
	    responseObject.put(STATUS,SUCCESS);
	    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/clearAllPC", method = RequestMethod.POST)
	public Map<String, Object> clearAllPC(@RequestParam("profitCenter") String profitCenter, @RequestParam("processId") int processId){
		Map<String, Object> responseObject = new LinkedHashMap<>();
	try{
		boolean clearAll = processSaveService.clearAllPC(profitCenter,processId);
		responseObject.put("data",clearAll);
		responseObject.put("PCDetails", processDetailService.getPCDetails(processId));
	    responseObject.put(STATUS,SUCCESS);
	    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	
    }
	
	@RequestMapping(path = "/updateQueue", method = RequestMethod.POST)
	public Map<String,Object> updateQueue(@RequestParam("queue")String queue,@RequestParam("description")String description){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean updateQueue = processSaveService.updateQueue(queue,description);
			List<Map<String, Object>> queueDisplay = processDetailService.queueDisplay();
			responseObject.put("queueDisplay",queueDisplay);
			responseObject.put("updateQueue", updateQueue);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/editRenewalDef", method = RequestMethod.POST)
	public Map<String, Object>editRenewalDef(RenewalModel renewalModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String editRenDef = processSaveService.editRenewalDef(renewalModel);
			responseObject.put("editRenewalDef",editRenDef);
			responseObject.put("RenewalDef",processDetailService.getRenewalDefDetails(renewalModel.getProcessId(),renewalModel.getRequal()));
			responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path = "/editBillingDef", method = RequestMethod.POST)
	public Map<String, Object>editBillingDef(String billingDef,String description,String extract,int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {			
			boolean editBillingDef = processSaveService.editBillingDef(billingDef,description,extract);
			responseObject.put("editBillingDef",editBillingDef);
			responseObject.put("BillingDef",processDetailService.getBillDefinintion(processId));
			responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path = "/editBillingEffort", method = RequestMethod.POST)
	public Map<String, Object>editBillingEffort(EffortModel effortModel ) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {			
			String editBillingEffort = processSaveService.editBillingEffort(effortModel);
			responseObject.put("editBillingEffort",editBillingEffort);
			responseObject.put("efforts", processDetailService.getBillingDefEffort(effortModel.getProcessId()));
			responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path="/editRenewalEffort", method = RequestMethod.POST)
	public Map<String, Object>editRenewalEffort(RenewalEffortModel renewalEffortModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try{
			String editRenEffort = processSaveService.editRenewalEffort(renewalEffortModel);
			  responseObject.put("editRenEffort",editRenEffort);
			  responseObject.put("RenewalEffort", processDetailService.getRenewalEffortDetails(renewalEffortModel.getProcessId()));
			  responseObject.put(STATUS,SUCCESS);
		    return responseObject;
			}
			catch(Exception e) {
				LOGGER.error(ERROR + e);
				  responseObject.put(STATUS,ERROR+e);
				    return responseObject;
			}
	}
	
	@RequestMapping(path = "/addRenTesting", method = RequestMethod.POST)
	public Map<String, Object> addRenTesting(String renewalDef,String description,String nthDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean addTesting = processSaveService.addRenTesting(renewalDef,description,nthDef);	
			List<Map<String, Object>> renTest = processDetailService.getRenewalTesting(renewalDef);		
			responseObject.put("addTesting", addTesting);
			responseObject.put("renTesting", renTest);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/deleteQueue", method = RequestMethod.POST)
	public Map<String, Object> queueDelete(@RequestParam("queue")String queue){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean deleteQueue = processSaveService.deleteQueue(queue);
			List<Map<String, Object>> queueDisplay = processDetailService.queueDisplay();
			responseObject.put("queueDisplay",queueDisplay);
			responseObject.put("deleteQueue", deleteQueue);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		}catch(Exception e) {
		 LOGGER.error(ERROR + e);
		 responseObject.put(STATUS,ERROR+e);
		    return responseObject;
		}
	}
	
	@RequestMapping(path = "/saveNthDef", method = RequestMethod.POST)
	public Map<String, Object> saveNthDef(NthModel nthModel){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean saventh = processSaveService.saveNthDef(nthModel);
			List<NthModel> nthDef = processDetailService.getNthDef();
			responseObject.put("saveNthDef", saventh);
			responseObject.put("NthDef", nthDef);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
					
		}
	}
	
	@RequestMapping(path = "/deleteNthDef", method = RequestMethod.POST)
	public Map<String, Object> deleteNthDef(@RequestParam("nthDef")String nthDef){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean deletNthRec = processSaveService.deleteNthDef(nthDef);
			List<NthModel> nthDefDisp = processDetailService.getNthDef();
			responseObject.put("deletNthRec", deletNthRec);
			responseObject.put("nthDefDisplay", nthDefDisp);
			return responseObject;
		}catch(Exception e) {
			LOGGER.error(STATUS + e);
			responseObject.put(STATUS, ERROR +e);
			return responseObject;
		}	
	}
	
	@RequestMapping(path="/addOCRenTab", method = RequestMethod.POST)
	public Map<String,Object> addOCRenTab(@RequestParam("renewalDef") String renewalDef,@RequestParam("ocId") int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> renewalTesting = processDetailService.getRenewalTesting(renewalDef);		
			List<EffortModel> efforts = processDetailService.getRenewalEfforts(renewalDef);
			String ocList = processSaveService.addOCRenewalDef(renewalDef,ocId);
			responseObject.put("data",ocList);
//			responseObject.put("renTesting", renewalTesting);
//			responseObject.put("OrderClass", processDetailService.getOrderDetailsTypeAll());
//			responseObject.put("efforts", efforts);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/deleteOCRenTab", method = RequestMethod.POST)
	public Map<String,Object> deleteOCRenTab(@RequestParam("renewalDef") String renewalDef,@RequestParam("ocId") int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> renewalTesting = processDetailService.getRenewalTesting(renewalDef);		
			List<EffortModel> efforts = processDetailService.getRenewalEfforts(renewalDef);
			String delOCList = processSaveService.deleteOCRenewaldef(renewalDef,ocId);
			responseObject.put("data",delOCList);
//			responseObject.put("renTesting", renewalTesting);
//			responseObject.put("OrderClass", processDetailService.getOrderDetailsTypeAll());
//			responseObject.put("efforts", efforts);
		    responseObject.put(STATUS,SUCCESS);
		    return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/billingDefDelete",method=RequestMethod.POST)
	public Map<String,Object> deleteBillingDef(String billingDef,int billingDefTestSeq,int effortNum,int processId,int ocId) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			int status1=processSaveService.deleteBillingDefEffort(effortNum,processId, billingDef);
			int status=processSaveService.deleteBillingDef(billingDef,billingDefTestSeq,ocId);
			if(status!=0 || status1!=0) {
				responseObject.put(STATUS, true);
			}else {
				responseObject.put(STATUS,false);
			}return responseObject;
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
			  responseObject.put(STATUS,ERROR+e);
			    return responseObject;
		}
	}
	
	@RequestMapping(path="/bilingDefTestUpdate",method=RequestMethod.POST)
	public Map<String,Object> billingDefTestEdit(String billingDef,int billingDefTestSeq,String description, String nthDef ){
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			int status=processSaveService.editBillingDefTest(billingDef,billingDefTestSeq, description, nthDef);
			if(status!=0) {
				responseObject.put(STATUS, true);
			}else {
				responseObject.put(STATUS, false);
			}return responseObject;
		}catch (Exception e) {
			LOGGER.error("error in billingDefTestUpdate");
			responseObject.put(STATUS+ERROR, e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/generateBillingCode", method = RequestMethod.POST)
	public Map<String, Object> generateBillingcode(int ocId,String billingDef,int billingCode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean generateSource = processSaveService.billingCodeGeration(ocId,billingDef,billingCode);	
			responseObject.put("generateSource", generateSource);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	
	@RequestMapping(path = "/extractFilterTemplate", method = RequestMethod.POST)
	public Map<String, Object> getExtractFilter() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			Map<String, Object> extractFilter = processDetailService.getExtractFilterTemplateData();
			responseObject.put("template", extractFilter);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/extractFilter", method = RequestMethod.POST)
	public Map<String, Object> createExtractFilter(ExtractModel extractFilterModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean extractFilterSave = processDetailService.createExtractFilter(extractFilterModel);
			responseObject.put("extractFilterSave", extractFilterSave);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/extractFilterUpdate", method = RequestMethod.POST)
	public Map<String, Object> upDateExtractFilter(ExtractModel extractFilterModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			boolean extractFilterUpdate = processDetailService.updateExtractFilter(extractFilterModel);
			responseObject.put("extractFilterUpdate", extractFilterUpdate);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/extractFilterdelete", method = RequestMethod.POST)
	public Map<String, Object> deleteExtractFilter(ExtractModel extractFilterModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();

		try {
			boolean extractFilterDelete = processDetailService.deleteExtractFilter(extractFilterModel);
			responseObject.put("extractFilterDelete", extractFilterDelete);
			responseObject.put(STATUS, SUCCESS);

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
}



