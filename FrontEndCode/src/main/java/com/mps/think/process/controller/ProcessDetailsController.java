package com.mps.think.process.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.mps.think.model.DropdownModel;
import com.mps.think.process.daoImpl.ProcessDetailsDaoImp;
import com.mps.think.process.model.AccountingPeriod;
import com.mps.think.process.model.EffortModel;
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
import com.mps.think.process.service.ProcessSaveService;
import com.mps.think.process.util.PropertyUtility;
import com.mps.think.setup.tablesetup.service.TableSetupService;

@RestController
public class ProcessDetailsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessDetailsDaoImp.class);

	@Autowired
	ProcessDetailsService processDetailService;
	@Autowired
	ProcessSaveService processSaveService;
	@Autowired
	TableSetupService tableSetupService;

	@RequestMapping(path = "/ProcessDetails", method = RequestMethod.POST)
	public Map<String, Object> ProcessDetail(@RequestParam("active") String active,
			@RequestParam("inactive") String inactive) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<ProcessModel> processList = processDetailService.getProcessDetails(active, inactive);
			responseObject.put("processInfo", processList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteProcessDetails", method = RequestMethod.POST)
	public Map<String, Object> DeleteProcessDetails(@RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			String status = processDetailService.deleteProcessDetails(processId);
			if (ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put("selectedProcess", status);
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/addNewProcess", method = RequestMethod.POST)
	public Map<String, Object> AddNewProcess(@RequestParam("processType") int processType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String processList = processDetailService.addNewProcess(processType);
			String resData[] = processList.split("-");
			ProcessModel newProcess = processDetailService.getDefaultProcessDetails(Integer.parseInt(resData[1]));
			responseObject.put("addProcess", resData[0]);
			responseObject.put("newProcessDtls", newProcess);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/refundDetails", method = RequestMethod.POST)
	public Map<String, Object> refundDetails(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel refundList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> driverList = new ArrayList<DropdownModel>();
			for (int i = 0; i <= 5; i++) {
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtility().getConstantValue("driver_type_" + i));
				driverList.add(model);
			}
			List<DropdownModel> bankDefList = processDetailService.getbankDefDetails();
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			responseObject.put("DefaultDetails", refundList);
			responseObject.put("DriverType", driverList);
			responseObject.put("BankDefDetails", bankDefList);
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("CurrencyDetails", processDetailService.getAllCurrency(processId));
			responseObject.put("PaymentType", processDetailService.getPaymentType(processId));
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/autoRenewalsNotify", method = RequestMethod.POST)
	public Map<String, Object> AutoRenewals(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel autoRenewalList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			responseObject.put("DefaultDetails", autoRenewalList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/onOrOff", method = RequestMethod.POST)
	public Map<String, Object> OnOff(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel onOffList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			responseObject.put("DefaultDetails", onOffList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/installmentNotices", method = RequestMethod.POST)
	public Map<String, Object> InstallmentNotices(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel installmentNoticeList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			responseObject.put("DefaultDetails", installmentNoticeList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/renewals", method = RequestMethod.POST)
	public Map<String, Object> Renewals(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel renewalsList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			Map<String, Object> descriptionList = processDetailService.getDescritionList(processId);
			responseObject.put("DefaultDetails", renewalsList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put("descriptionList", descriptionList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/label", method = RequestMethod.POST)
	public Map<String, Object> Label(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel labelList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			Map<String, Object> descriptionList = processDetailService.getDescritionList(processId);
			responseObject.put("DefaultDetails", labelList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put("DescriptionList", descriptionList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/accountingReconciliation", method = RequestMethod.POST)
	public Map<String, Object> Reconciliation(@RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel reconciliationList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			// Map<String,Object> descriptionList =
			// processDetailService.getDescritionList(processId);
			responseObject.put("DefaultDetails", reconciliationList);
			responseObject.put("PCDetails", processDetailService.getPCDetails(processId));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/labelEstimate", method = RequestMethod.POST)
	public Map<String, Object> LabelEstimate(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel labelEstimateList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			responseObject.put("DefaultDetails", labelEstimateList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/bacsAuddis", method = RequestMethod.POST)
	public Map<String, Object> BACSAuddis(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel bacsAuddisList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			responseObject.put("DefaultDetails", bacsAuddisList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/bacsBilling", method = RequestMethod.POST)
	public Map<String, Object> BACSBilling(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel bacsBillingList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<Map<String, Object>> selectedCurrency = processDetailService.getselectedCurrency(processId);
			responseObject.put("DefaultDetails", bacsBillingList);
			responseObject.put("QueueDetail", jobQueueList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("selectedCurrency", selectedCurrency);
			responseObject.put("BACSSelectionCurrency", processDetailService.getbacsSelectionCurrency());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/bacsDD", method = RequestMethod.POST)
	public Map<String, Object> BacsDD(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel bacsBillingDDList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<Map<String, Object>> selectedCurrency = processDetailService.getselectedCurrency(processId);
			responseObject.put("bacsBillingDDList", bacsBillingDDList);
			responseObject.put("jobQueueList", jobQueueList);
			responseObject.put("selectedCurrency", selectedCurrency);
			responseObject.put("BacsDDselectionCurrency", processDetailService.getbacsSelectionCurrency());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put("STATUS", ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/creditCardTokenRefresh", method = RequestMethod.POST)
	public Map<String, Object> CreditCardToken(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel creditCardTokenList = processDetailService.getDefaultProcessDetails(processId);
			responseObject.put("creditCardTokenRefreshDetail", creditCardTokenList);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/customerDepositReconciltaion", method = RequestMethod.POST)
	public Map<String, Object> CustDepReconcilation(@RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel custDepReconcilation = processDetailService.getDefaultProcessDetails(processId);
			responseObject.put("customerDepReconcilation", custDepReconcilation);
			responseObject.put("PCDetails", processDetailService.getPCDetails(processId));
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/icsPaymentBatchLitener", method = RequestMethod.POST)
	public Map<String, Object> ICSPymentBatchLitener(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel icsPymentBetchLitener = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> bankDefList = processDetailService.getbankDefDetails();
			responseObject.put("ICSPymentBetchLitenerDetail", icsPymentBetchLitener);
			responseObject.put("BankDefDetails", bankDefList);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/cleanup", method = RequestMethod.POST)
	public Map<String, Object> Cleanup(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel cleanupList = processDetailService.getDefaultProcessDetails(processId);
			List<Map<String, Object>> showSelected = processDetailService.getselectedCleanupValue(processId);
			responseObject.put("Cleanup", cleanupList);
			responseObject.put("CleanupDefinition", processDetailService.getCleanupDefinitionDetails());
			responseObject.put("showCleanupSelected", showSelected);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/productFulfillment", method = RequestMethod.POST)
	public Map<String, Object> ProdeuctFullfillment(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel fulfillmenetDetail = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			responseObject.put("ProcessFullfillmenetDetail", fulfillmenetDetail);
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/massKill", method = RequestMethod.POST)
	public Map<String, Object> MassKill(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel massKillList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			responseObject.put("DefaultDetails", massKillList);
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/listExtract", method = RequestMethod.POST)
	public Map<String, Object> ListExtract(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel listExtract = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			responseObject.put("DefaultDetails", listExtract);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/promotion", method = RequestMethod.POST)
	public Map<String, Object> Promotion(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel promotionList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			responseObject.put("DefaultDetails", promotionList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/auditParagraphReport", method = RequestMethod.POST)
	public Map<String, Object> AuditParagraphReport(@RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel auditParagraphList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> orderList = processDetailService.getOrderClass();
			responseObject.put("DefaultDetails", auditParagraphList);
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("orderDropdown", orderList);
			responseObject.put("auditReports", processDetailService.getauditReports());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/startOrStop", method = RequestMethod.POST)
	public Map<String, Object> StartOrStop(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel startOrStopList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			responseObject.put("DefaultDetails", startOrStopList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/PaymentDetails", method = RequestMethod.POST)
	public Map<String, Object> paymentDetails(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<ProcessModel> paymentList = processDetailService.getPaymentDetails(processId);
			List<DropdownModel> driverList = new ArrayList<DropdownModel>();
			for (int i = 0; i <= 5; i++) {
				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtility().getConstantValue("driver_type_" + i));
				driverList.add(model);
			}
			List<DropdownModel> bankDefList = processDetailService.getbankDefDetails();
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			responseObject.put("DefaultDetails", paymentList);
			responseObject.put("DriverType", driverList);
			responseObject.put("BankDefDetails", bankDefList);
			responseObject.put("CurrencyDetails", processDetailService.getAllCurrency(processId));
			responseObject.put("PaymentType", processDetailService.getPaymentType(processId));
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/emailNotificationSetup", method = RequestMethod.POST)
	public Map<String, Object> emailNotificationSetup(@RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel emailSetupList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> processTypeList = new ArrayList<DropdownModel>();
			for (int i = 0; i <= 41; i++) {
				DropdownModel model = new DropdownModel();
				if (i == 35 || i == 36) {
					continue;
				}
				model.setKey("" + i);
				model.setDisplay(new PropertyUtility().getConstantValue("process_type_" + i));
				processTypeList.add(model);
			}
			responseObject.put("EmailSetupDetails", emailSetupList);
			responseObject.put("process_type", processDetailService.getDefaultDropdown(processId));
			responseObject.put("ProcessDropdown", processTypeList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/processType", method = RequestMethod.POST)
	public Map<String, Object> processType() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<DropdownModel> processTypeList = new ArrayList<DropdownModel>();
			for (int i = 0; i <= 41; i++) {
				if (i == 35 || i == 36) {
					continue;
				}

				DropdownModel model = new DropdownModel();
				model.setKey("" + i);
				model.setDisplay(new PropertyUtility().getConstantValue("process_type_" + i) != null
						? new PropertyUtility().getConstantValue("process_type_" + i)
						: "");
				processTypeList.add(model);
			}
			responseObject.put("ProcessDropdown", processTypeList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/billing", method = RequestMethod.POST)
	public Map<String, Object> billing(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel billingList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			responseObject.put("DefaultDetails", billingList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/backLabel", method = RequestMethod.POST)
	public Map<String, Object> backLabel(@RequestParam("processId") int processId,
			@RequestParam("processOcType") int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel backLabelList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			responseObject.put("DefaultDetails", backLabelList);
			responseObject.put("OrderDetails", processDetailService.getOrderDetails(processId, processOcType));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/auditGallery", method = RequestMethod.POST)
	public Map<String, Object> auditGallery(@RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel auditGalleryList = processDetailService.getDefaultProcessDetails(processId);
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			responseObject.put("DefaultDetails", auditGalleryList);
			responseObject.put("OrderDetails", processDetailService.getAuditOrderDetails(processId));
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	/* credit-card-expiry-notify details page information */

	@RequestMapping(path = "/creditCardExpiryNotify", method = RequestMethod.POST)
	public Map<String, Object> creditCardExpiry(@RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			ProcessModel creditCardExpiryList = processDetailService.getDefaultProcessDetails(processId);

			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			responseObject.put("creditCardTokenRefreshDetail", creditCardExpiryList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("QueueDetails", jobQueueList);

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/renewalDef", method = RequestMethod.POST)
	public Map<String, Object> renewalDefinition() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			responseObject.put("RenewalDef", processDetailService.getRenewalDefByDefault());
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/renewalDefDetails", method = RequestMethod.POST)
	public Map<String, Object> renewalDefinitionDetails(@RequestParam("processId") int processId,
			@RequestParam("requal") int requal) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> renewalDisplay = processDetailService.getDefaultRenewalDetails(processId);
			List<DropdownModel> volumeList = processDetailService.getVolumeGroupDetails();
			List<NthModel> nthDefList = processDetailService.getNthDef();
			responseObject.put("OrderDetails", processDetailService.getOrderDetailsTypeAll());
			responseObject.put("RenewalEffort", processDetailService.getRenewalEffortDetails(processId));
			responseObject.put("RenewalDef", processDetailService.getRenewalDefDetails(processId, requal));
			responseObject.put("VolumeList", volumeList);
			responseObject.put("RenewalDisplay", renewalDisplay);
			responseObject.put("NthDef", nthDefList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	/* billing definition */
	@RequestMapping(path = "/billDefinition", method = RequestMethod.POST)
	public Map<String, Object> BillingDefinintion(@RequestParam("processId") int processId) {
		Map<String, Object> responceObject = new LinkedHashMap<String, Object>();

		try {
			List<Map<String, Object>> billingDefinition = processDetailService.getBillDefinintion(processId);
			List<EffortModel> billingEffort = processDetailService.getBillingEffort(processId);
			List<Map<String, Object>> billOrderClass = processDetailService.getBillOrderClass();
			List<Map<String, Object>> billingDisplay = processDetailService.getBillDisplayData(processId);
			List<NthModel> nthDef = processDetailService.getNthDef();
			responceObject.put("BillingDefinition", billingDefinition);
			responceObject.put("BillingEffort", billingEffort);
			responceObject.put("BillOrderClass", billOrderClass);
			responceObject.put("NthDefDropDown", nthDef);
			responceObject.put("BillingDisplay", billingDisplay);
			responceObject.put(SUCCESS, SUCCESS);
			return responceObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responceObject.put(STATUS, ERROR);
			return responceObject;
		}
	}

	@RequestMapping(path = "/billTesting", method = RequestMethod.POST)
	public Map<String, Object> billingTesting(@RequestParam("billingDef") String billingDef) {
		Map<String, Object> responceObject = new LinkedHashMap<String, Object>();

		try {
			List<Map<String, Object>> billTesting = processDetailService.getBilltesting(billingDef);
			responceObject.put("BillTesting", billTesting);
			responceObject.put(SUCCESS, SUCCESS);
			return responceObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responceObject.put(STATUS, ERROR);
			return responceObject;
		}
	}

	@RequestMapping(path = "/displayInstallment", method = RequestMethod.POST)
	public Map<String, Object> displayInstallment(int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> displayAlldata = processDetailService.getInstallmentDetails(processId);
			responseObject.put("allData", displayAlldata);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/submitJob", method = RequestMethod.POST)
	public Map<String, Object> submitJob(@RequestParam("processId") int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			ProcessModel submitJobData = processDetailService.getsubmitjobData(processId);
			List<Map<String, Object>> renewalDisplay = processDetailService.getrenewalDisplay(processId);
			List<Map<String, Object>> billDisplay = processDetailService.getBillDisplayData(processId);
			List<DropdownModel> installmentPlanDropdown = processDetailService.getInstallmentDropDown();
			List<OutputModel> outputData = processDetailService.getOutputData(processId);
			List<DropdownModel> outputTypeDropDown = processDetailService.getOutput();
			List<DropdownModel> ocDropdown = processDetailService.getOc();
			List<DropdownModel> defaultJobQueue = processDetailService.getJobQueue();
			responseObject.put("submitJobData", submitJobData);
			responseObject.put("renewalDisplayData", renewalDisplay);
			responseObject.put("billDisplayData", billDisplay);
			responseObject.put("installmentPlanDropdown", installmentPlanDropdown);
			responseObject.put("outputData", outputData);
			responseObject.put("outputTypeDropDown", outputTypeDropDown);
			responseObject.put("ocDropdown", ocDropdown);
			responseObject.put("DefaultJobQueue", defaultJobQueue);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/renewalTesting", method = RequestMethod.POST)
	public Map<String, Object> renewalTesting(@RequestParam("renewalDef") String renewalDef) {
		Map<String, Object> responceObject = new LinkedHashMap<>();

		try {
			List<Map<String, Object>> renewalTesting = processDetailService.getRenewalTesting(renewalDef);
			responceObject.put("renewalTesting", renewalTesting);
			responceObject.put(SUCCESS, SUCCESS);
			return responceObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responceObject.put(STATUS, ERROR);
			return responceObject;
		}
	}

	@RequestMapping(path = "/renewalCard", method = RequestMethod.POST)
	public Map<String, Object> renewalCard(@RequestParam("ocId") String ocId,
			@RequestParam("renewalDef") String renewalDef) {
		Map<String, Object> responceObject = new LinkedHashMap<String, Object>();

		try {
			List<DropdownModel> renewalCardList = processDetailService.getrenewalCardDetails(ocId, renewalDef);
			responceObject.put("RenewalCard", renewalCardList);
			responceObject.put(SUCCESS, SUCCESS);
			return responceObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responceObject.put(STATUS, ERROR);
			return responceObject;
		}
	}

	@RequestMapping(path = "/displayBillingOutput", method = RequestMethod.POST)
	public Map<String, Object> displayBillingOutput(int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<OutputModel> displayBillingOutput = processSaveService.displayBillingOutput(processId);
			responseObject.put("displayBillingOutput", displayBillingOutput);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/outputGrids", method = RequestMethod.POST)
	public Map<String, Object> outputGrids() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> outputType = processDetailService.getOutputType();
			List<DropdownModel> output = processDetailService.getOutput();
			List<DropdownModel> outputFileFormat = processDetailService.getOutputFileFormat();
			List<DropdownModel> oc = processDetailService.getOc();
			List<DropdownModel> auditReport = processDetailService.getAuditReport();
			responseObject.put("outputType", outputType);
			responseObject.put("output", output);
			responseObject.put("outputFileFormat", outputFileFormat);
			responseObject.put("oc", oc);
			responseObject.put("auditReport", auditReport);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/displayOutput", method = RequestMethod.POST)
	public Map<String, Object> displayOutput() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> displayOutput = processDetailService.displayOutput();
			responseObject.put("displayOutput", displayOutput);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/renewalDropdown", method = RequestMethod.POST)
	public Map<String, Object> renewalDropdown(@RequestParam("renConst") String renConst) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			if (renConst.equals("Def")) {
				List<DropdownModel> extractList = processDetailService.getExtractDetails();
				List<DropdownModel> renTypeList = new ArrayList<DropdownModel>();
				for (int i = 0; i <= 2; i++) {
					DropdownModel model = new DropdownModel();
					model.setKey("" + i);
					model.setDisplay(new PropertyUtility().getConstantValue("renewal_type_" + i));
					renTypeList.add(model);
				}
				responseObject.put("extract", extractList);
				responseObject.put("renType", renTypeList);
			} else {
				List<DropdownModel> output = processDetailService.getOutput();
				List<DropdownModel> effortTypeList = new ArrayList<DropdownModel>();
				for (int i = 0; i <= 8; i++) {
					DropdownModel model = new DropdownModel();
					model.setKey("" + i);
					model.setDisplay(new PropertyUtility().getConstantValue("effort_type_" + i));
					effortTypeList.add(model);
				}
				responseObject.put("effortType", effortTypeList);
				responseObject.put("output", output);
			}
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/billingDef", method = RequestMethod.POST)
	public Map<String, Object> billingDef() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> getBillingDef = processDetailService.getbillingDef();
			responseObject.put("billingDef", getBillingDef);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/queueDisplay", method = RequestMethod.POST)
	public Map<String, Object> queueDisplay() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> queueDisplay = processDetailService.queueDisplay();
			responseObject.put("queueDisplay", queueDisplay);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/extractdetail", method = RequestMethod.POST)
	public Map<String, Object> extractdetail() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			responseObject.put("extractList", extractList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/billDefinitionTab", method = RequestMethod.POST)
	public Map<String, Object> billDefinitionTab(String billingDef) {
		Map<String, Object> responceObject = new LinkedHashMap<String, Object>();

		try {
			List<Map<String, Object>> billDefinitionTab = processDetailService.billDefinitionTab(billingDef);
			List<Map<String, Object>> billTesting = processDetailService.getBilltesting(billingDef);
			List<Map<String, Object>> billOrderClass = processDetailService.getBillOrderClass();
			List<EffortModel> efforts = processDetailService.getEfforts(billingDef);
			responceObject.put("billDefinitionTab", billDefinitionTab);
			responceObject.put("billTesting", billTesting);
			responceObject.put("BillOrderClass", billOrderClass);
			responceObject.put("efforts", efforts);
			responceObject.put(STATUS, SUCCESS);
			return responceObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responceObject.put(STATUS, ERROR);
			return responceObject;
		}
	}

	@RequestMapping(path = "/renewalDefinitionTab", method = RequestMethod.POST)
	public Map<String, Object> renewalDefinitionTab(String renewalDef) {
		Map<String, Object> responceObject = new LinkedHashMap<String, Object>();

		try {
			List<Map<String, Object>> renewalDefDetails = processDetailService.renewalDefinitionTab(renewalDef);
			List<Map<String, Object>> renewalTesting = processDetailService.getRenewalTesting(renewalDef);
			List<EffortModel> efforts = processDetailService.getRenewalEfforts(renewalDef);
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			List<NthModel> nthDefList = processDetailService.getNthDef();
			responceObject.put("extractList", extractList);
			responceObject.put("renewalDefDetails", renewalDefDetails);
			responceObject.put("renTesting", renewalTesting);
			responceObject.put("OrderClass", processDetailService.getOrderDetailsTypeAll());
			responceObject.put("efforts", efforts);
			responceObject.put("nthDef", nthDefList);
			responceObject.put(STATUS, SUCCESS);
			return responceObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responceObject.put(STATUS, ERROR);
			return responceObject;
		}
	}

	@RequestMapping(path = "/jobQueueDisplay", method = RequestMethod.POST)
	public Map<String, Object> jobQueueDisp(@RequestParam("queue") String queue, @RequestParam("onHold") String onHold,
			@RequestParam("ready") String ready, @RequestParam("running") String running,
			@RequestParam("dayEnd") String dayEnd) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<JobModel> jobQueueDisplay = processDetailService.getJobQueueDisp(queue, onHold, ready, running,
					dayEnd);
			responseObject.put("jobQueueDisplay", jobQueueDisplay);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/jobQueueList", method = RequestMethod.POST)
	public Map<String, Object> jobQueueDisp() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> jobQueueList = processDetailService.getJobQueueList();
			responseObject.put("jobQueueList", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/nthDefDisplay", method = RequestMethod.POST)
	public Map<String, Object> NthDef() {
		Map<String, Object> responceObject = new LinkedHashMap<String, Object>();

		try {
			List<NthModel> nthDef = processDetailService.getNthDef();
			responceObject.put("NthDef", nthDef);
			responceObject.put(SUCCESS, SUCCESS);
			return responceObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responceObject.put(STATUS, ERROR);
			return responceObject;
		}
	}

	@RequestMapping(path = "/nthDetails", method = RequestMethod.POST)
	public Map<String, Object> NthDetails() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<NthModel> nthDefDetails = processDetailService.getNthDefDetails();
			responseObject.put("nthDefDetails", nthDefDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectMethodNth", method = RequestMethod.POST)
	public Map<String, Object> nthSelectMethod(@RequestParam("selectMethod") int selectMethod) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> selectedmethod = processDetailService.getSelectMethod(selectMethod);
			responseObject.put("Selectedmethod", selectedmethod);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/defaultJobQueueDisplay", method = RequestMethod.POST)
	public Map<String, Object> defaultJobQueueDisp() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<JobModel> defaultJobQueueDisplay = processDetailService.getDefaultJobQueueDisp();
			List<Map<String, Object>> jobQueueList = processDetailService.getJobQueueList();
			responseObject.put("defaultJobQueueDisplay", defaultJobQueueDisplay);
			responseObject.put("jobQueueList", jobQueueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/reviewJobHistory", method = RequestMethod.POST)
	public Map<String, Object> reviewJobHistory(long processId, int status) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Object> dispReviewJobHistory = processDetailService.getReviewJobHistory(processId, status);
			List<DropdownModel> processList = processDetailService.getProcessList();
			responseObject.put("dispReviewJobHistory", dispReviewJobHistory);
			responseObject.put("processList", processList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/viewJobLog", method = RequestMethod.POST)
	public Map<String, Object> viewJobLogDetails(long jobId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Object> viewJobLog = processDetailService.getViewJobLog(jobId);
			responseObject.put("viewJobLog", viewJobLog);
			responseObject.put(SUCCESS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteJobQueue", method = RequestMethod.POST)
	public Map<String, Object> deleteJobQueueMethod(long jobId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean deleteJobQueue = processDetailService.deleteJobQueue(jobId);
			responseObject.put("deleteJobQueueStatus", deleteJobQueue);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/resetDate", method = RequestMethod.POST)
	public Map<String, Object> resetStartDateTime(long jobId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			Object resetDate = processDetailService.getResetDate(jobId);
			responseObject.put("resetDate", resetDate);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/holdClear", method = RequestMethod.POST)
	public Map<String, Object> holdClear(long jobId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean holdClear = processDetailService.getHoldClear(jobId);
			responseObject.put("holdClear", holdClear);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;

		} catch (Exception e) {
			LOGGER.info(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectSplit", method = RequestMethod.POST)
	public Map<String, Object> getSplit(Integer processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> splits = new ArrayList<>();
		try {
			splits = processDetailService.getSplit(processId);
			responseObject.put("splits", splits);
			List<DropdownModel> extract = processDetailService.getExtract();
			responseObject.put("extract", extract);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getSplits : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveSplit", method = RequestMethod.POST)
	public Map<String, Object> saveSplit(SplitDetailModel splitDetailModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.saveSplit(splitDetailModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveSplit() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateSplit", method = RequestMethod.POST)
	public Map<String, Object> updateSplit(SplitDetailModel splitDetailModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.updateSplit(splitDetailModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateSplit() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteSplit", method = RequestMethod.POST)
	public Map<String, Object> deleteSplit(Integer processId) {
		Map<String, Object> responseObject = new HashMap<>();
		int status = 0;
		try {
			status = processDetailService.deleteSplit(processId);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in deleteSplit : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/selectInsertsDetail", method = RequestMethod.POST)
	public Map<String, Object> getInsertsDetail(int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> insertsDetail = new ArrayList<>();
		try {
			insertsDetail = processDetailService.getInsertsDetail(processId);
			responseObject.put("insertsDetail", insertsDetail);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getInsertsDetail : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/saveInsertsDetail", method = RequestMethod.POST)
	public Map<String, Object> addInsertsDetail(InsertsModel insertsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.saveInsertsDetail(insertsModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in addInsertsDetail() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateInsertsDetail", method = RequestMethod.POST)
	public Map<String, Object> updateInsertsDetail(InsertsModel insertsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.updateInsertsDetail(insertsModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateInsertsDetail() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteInsertsDetail", method = RequestMethod.POST)
	public Map<String, Object> deleteInsertsDetail(int processId, int bitPosition) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.deteteInsertsDetail(processId, bitPosition);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in deleteInsertsDetail() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/sortSave", method = RequestMethod.POST)
	public Map<String, Object> addSortDetails(SortModel sortModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		int status1 = 0;
		try {
			status = processDetailService.saveSort(sortModel);
			status1 = processDetailService.saveSortDetails(sortModel);
			if (status != 0 || status1 != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in saveSort");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/sortUpdate", method = RequestMethod.POST)
	public Map<String, Object> editSort(SortModel sortModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.updateSort(sortModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in sortUpdate");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/sortDelete", method = RequestMethod.POST)
	public Map<String, Object> sortRowDelete(int processSortFieldSeq, String processSort) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		int status1 = 0;
		try {
			status = processDetailService.deleteSort(processSortFieldSeq, processSort);
			status1 = processDetailService.deleteSortDetails(processSort);
			if (status != 0 || status1 != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in sortDelete");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/sortDetails", method = RequestMethod.POST)
	public Map<String, Object> sortInfo(int processSortFieldSeq, String processSort) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> tablenameInfo = processDetailService.getTablenameInfo();
			responseObject.put("tablenameInfo", tablenameInfo);

			List<DropdownModel> columeName = tableSetupService.getColumnnameInfo();
			responseObject.put("columeName", columeName);
			List<SortModel> processFieldDetails = processDetailService.getProcessSortFieldDetails(processSortFieldSeq,
					processSort);
			responseObject.put("ProcessSortDetails", processFieldDetails);
		} catch (Exception e) {
			LOGGER.info("error in sort Details");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/promotionSave", method = RequestMethod.POST)
	public Map<String, Object> promotionAdd(PromotionModel promotionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		int status1 = 0;
		int status2 = 0;
		String value = null;
		value = promotionModel.getPromotionDef();
		try {
			status = processDetailService.savePromotion(promotionModel);
			if (status != 0) {
				responseObject.put(STATUS, true);
			}
			if (!promotionModel.getPromotionDef().equals("null")) {
				status1 = processDetailService.savePromotionDefTest(promotionModel);
				status2 = processDetailService.savePromtionDefEffort(promotionModel);
			}
			if (status1 != 0 || status2 != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);

			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in promotionSave");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/promotionDetails", method = RequestMethod.POST)
	public Map<String, Object> promotionInfo(String promotionDef, @RequestParam("allOc") String allOc, int ocId,
			int effortNumber, int promotionDefTestSeq, int promotionCradId, int processOcType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {

			List<Map<String, Object>> promotionDefEffortDetails = processDetailService
					.getPromotionDefEffortDetails(effortNumber, promotionDef);
			responseObject.put("promotionDefEffortDetails", promotionDefEffortDetails);

			List<Map<String, Object>> promotionDefTestDetails = processDetailService.getPromotionDefTest(promotionDef,
					promotionDefTestSeq);
			responseObject.put("promotionDefTestDetails", promotionDefTestDetails);

			List<DropdownModel> output = tableSetupService.getOutput();
			responseObject.put("output", output);

			List<DropdownModel> nthDef = processDetailService.getNthDefDetail();
			responseObject.put("nthDef", nthDef);

			List<DropdownModel> processMethod = processDetailService.getProcessMethod();
			responseObject.put("processMethod", processMethod);

			List<DropdownModel> promCardDetails = processDetailService.getPromCardDetails(promotionCradId);
			responseObject.put("promCardDetails", promCardDetails);

			List<Map<String, Object>> processDetails = processDetailService.getProcessInfo(processOcType);
			responseObject.put("processDetails", processDetails);

			if (allOc.equals("1")) {
				List<Map<String, Object>> allOrderDetails = processDetailService.getAllOrderDetails(ocId);
				responseObject.put("allOrderDetails", allOrderDetails);
			} else {
				List<Map<String, Object>> orderDetails = processDetailService.getOrderDetailsList(promotionDef, ocId);
				responseObject.put("orderDetails", orderDetails);
			}

		} catch (Exception e) {
			LOGGER.info("error in promotionDetials");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/promotionDefDetails", method = RequestMethod.POST)
	public Map<String, Object> promotionDefDetails(String promotionDef) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> promotionDefDetails = processDetailService.getPromotionDefDetail(promotionDef);
			responseObject.put("promotionDefDetails", promotionDefDetails);

		} catch (Exception e) {
			LOGGER.info("error in promotionDetials");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/promotionDefUpdate", method = RequestMethod.POST)
	public Map<String, Object> promotionDefEdit(PromotionModel promotionModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.updatePromotionDef(promotionModel);
			// int status1=processDetailService.updatePromotionDefTest(promotionModel);
			int status2 = processDetailService.updatePromotiondefEffort(promotionModel);
			if (status != 0 || status2 != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in promotionDefUpdate");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/promotionDefDelete", method = RequestMethod.POST)
	public Map<String, Object> deletePromotionDef(String promotionDef, int promotionDefTestSeq, int effortNumber) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.deletePromotionDefEffort(effortNumber, promotionDef);
			int status1 = processDetailService.deletePromotionDefTest(promotionDef, promotionDefTestSeq);
			int status2 = processDetailService.deletePromotionDef(promotionDef);
			if (status != 0 || status1 != 0 || status2 != 0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("error in promotionDefDelete");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/processTypePromotionSave", method = RequestMethod.POST)
	public Map<String, Object> saveProcessTypePromotion(ProcessModel processModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = processDetailService.addProcesstypePromotion(processModel);
			responseObject.put("status", status);
		} catch (Exception e) {
			LOGGER.info("error in processTypePromotionSave");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;

		}
		return responseObject;
	}

	@RequestMapping(path = "/processTypePromotionUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateProcessTypePromotion(ProcessModel processModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> jobQueueList = processDetailService.getQueueDetails();
			List<DropdownModel> labelGroupList = processDetailService.getGroupDetails();
			List<DropdownModel> labelKeylineList = processDetailService.getKeylineDetails();
			List<DropdownModel> outputSortList = processDetailService.getOutputSortDetails();
			List<DropdownModel> extractList = processDetailService.getExtractDetails();
			responseObject.put("QueueDetails", jobQueueList);
			responseObject.put("ExtractDetails", extractList);
			responseObject.put("GroupDetails", labelGroupList);
			responseObject.put("KeyLineDetails", labelKeylineList);
			responseObject.put("OutputDetails", outputSortList);
			int status = processDetailService.editProcessTypePromotion(processModel);
			if (status != 0) {
				responseObject.put(STATUS, "Updated is successfully");
			} else {
				responseObject.put(STATUS, "Updated is  Unsuccessfully");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in processTypePromotionUpdate");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/repeatTypeUpdate", method = RequestMethod.POST)
	public Map<String, Object> updateRepeatType(ProcessModel processModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			if (processModel.getRepeatingType() == 1 || processModel.getRepeatingType() == 2) {
				status = processDetailService.editRepeatingType(processModel);
			}
			if (status != 0) {
				responseObject.put(STATUS, "Update SuccessFull");
			} else {
				responseObject.put(STATUS, "Update UnSuccessfull");
			}

		} catch (Exception e) {
			LOGGER.info("error in repeatTypeUpdate");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/processPromotionDelete", method = RequestMethod.POST)
	public Map<String, Object> deleteprocesstypePromotion(int processId) {
		int status = 0;
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = processDetailService.deleteProcessPromotion(processId);
			if (status != 0) {
				responseObject.put(STATUS, "Deleted");
			} else {
				responseObject.put(STATUS, "Not Deleted");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in processTypePromotionDelete");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/promotionOutputSave", method = RequestMethod.POST)
	public Map<String, Object> savePromotionOutput(OutputModel outputModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean savePromotionOutput = processSaveService.saveBillingOutput(outputModel);
			responseObject.put("savePromotionOutput", savePromotionOutput);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/promotionOutputUpdate", method = RequestMethod.POST)
	public Map<String, Object> updatePromotionOutput(OutputModel outputModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean editPromotionOutput = processSaveService.editBillingOutput(outputModel);
			responseObject.put("EditPromotionOutput", editPromotionOutput);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/promotionOutputDelete", method = RequestMethod.POST)
	public Map<String, Object> deletePromotionOutput(int processOutputSeq, int procesId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			int status = processDetailService.deleteOutputPromotion(processOutputSeq, procesId);
			if (status != 0) {
				responseObject.put(STATUS, "Delete is SuccessFull");
			} else {
				responseObject.put(STATUS, "Delete is UnSuccessFull");
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in promotionOutputDelete");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/promotionOutputDetails", method = RequestMethod.POST)
	public Map<String, Object> promotionOutputInfo(int processId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<OutputModel> displayPromotionOutput = processSaveService.displayBillingOutput(processId);
			responseObject.put("displayPromotionOutput", displayPromotionOutput);
			List<DropdownModel> oc = tableSetupService.getOrderClass();
			responseObject.put("ocDetails", oc);

			List<DropdownModel> output = tableSetupService.getOutput();
			responseObject.put("output", output);

			List<Map<String, Object>> auditReport = processDetailService.getAudReport();
			responseObject.put("auditReport", auditReport);

		} catch (Exception e) {
			LOGGER.info("error in promotionOutputDetails");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;

	}

	  @RequestMapping(path = "/billingDefinitionFromTab", method = RequestMethod.POST)
      public Map<String, Object>billDefinition(String billingDef,int effortNumber) {
	       Map<String, Object> responceObject = new LinkedHashMap<String, Object>();

	       try {
		   List<Map<String, Object>> billDefinitionTab = processDetailService.billDefinitionTab(billingDef);
		   List<Map<String, Object>> billTesting = processDetailService.getBillTesting(billingDef);			
		   List<Map<String, Object>> billOrderClass = processDetailService.getBillOrderClass();
		   //List<Map<String,Object>> billProcesses=processDetailService.process(effortNumber,billingDef);
		   List<EffortModel> efforts = processDetailService.getEfforts(billingDef);	
		   List<DropdownModel> extract=processDetailService.getExtract();
		   //List<Map<String,Object>> Orders=processDetailService.allOrder(billingDef);
		   List<Map<String,Object>> allProcess=processDetailService.allProcess(effortNumber);

		   responceObject.put("billDefinitionTab", billDefinitionTab);
		   responceObject.put("billTesting", billTesting);
		   responceObject.put("BillOrderClass", billOrderClass);
		   responceObject.put("efforts", efforts);
		   //responceObject.put("billProcess", billProcesses);
		   responceObject.put("extract", extract);
		  // responceObject.put("Orders", Orders);
		   //responceObject.put("Orders", Orders);


		   responceObject.put("allProcess", allProcess);
		   responceObject.put(STATUS, SUCCESS);
		      return responceObject;
	       } 
	       catch (Exception e) {
		    LOGGER.error(ERROR + e);
		      responceObject.put(STATUS, ERROR);
		         return responceObject;
	       }
       }
	  @RequestMapping(path="/outputDropdown",method=RequestMethod.POST)
	  public Map<String,Object> output(){
		  Map<String,Object> responseObject=new LinkedHashMap<>();
		  try {
			   List<DropdownModel> output=processDetailService.getOutputDetails();
			   responseObject.put("output", output);
			   return responseObject;
		  }catch (Exception e) {
			    LOGGER.error(ERROR + e);
			    responseObject.put(STATUS, ERROR);
			         return responseObject;
		       }
	  }

	  @RequestMapping(path="/nthDef",method=RequestMethod.POST)
	  public Map<String,Object> nth(){
		  Map<String,Object> responseObject=new LinkedHashMap<>();
		  try {
			   List<DropdownModel> nthDef=processDetailService.getNthDefDetail();
			   responseObject.put("nthDef", nthDef);
			   return responseObject;
		  }catch (Exception e) {
			    LOGGER.error(ERROR + e);
			    responseObject.put(STATUS, ERROR);
			         return responseObject;
		       }
	  }



	@RequestMapping(path = "/generateDefaultPromotionOutput", method = RequestMethod.POST)
	public Map<String, Object> generateDefaultPromotionOut(int processId, String processType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		boolean defaultOutput = false;
		try {
			switch (processType) {
			case "Promotion":
				defaultOutput = processDetailService.generateDefaultOutput(processId);
				break;
			}
			List<OutputModel> displayPromotionOutput = processSaveService.displayBillingOutput(processId);
			responseObject.put("defaultOutput", defaultOutput);
			responseObject.put("displayPromotionOutput", displayPromotionOutput);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/generateDefaultProductOutput", method = RequestMethod.POST)
	public Map<String, Object> generateDefaultOutput(int processId, String processType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		boolean defaultOutput = false;
		try {
			switch (processType) {
			case "Product Fullfillment":
				defaultOutput = processDetailService.generateDefaultProductOutput(processId);
				break;
			}
			responseObject.put("defaultOutput", defaultOutput);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in generateDefaultProductOutput");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/generateDefaultLabelOutput", method = RequestMethod.POST)
	public Map<String, Object> defaultOutputgeneration(int processId, String processType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		boolean defaultOutput = false;
		try {
			switch (processType) {
			case "Label":
				defaultOutput = processDetailService.generateDefaultLabelOutput(processId);
				break;
			}
			responseObject.put("defaultOutput", defaultOutput);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in generateDefaultLabelOutput");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/DefaultOutputStartStop", method = RequestMethod.POST)
	public Map<String, Object> defaultOutputGenerationInfo(int processId, String processType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		boolean defaultOutput = false;
		try {
			switch (processType) {
			case "Start/Stop":
				defaultOutput = processDetailService.generateStartrStopDefaultOutput(processId);
				break;
			}
			responseObject.put("defaultOutput", defaultOutput);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error("error in DefaultOutputStartStop");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/generateDefaultOutputOfAuditGalley", method = RequestMethod.POST)
	public Map<String, Object> defaultOutputFefund(String processType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> defaultOutput = null;
		try {
			switch (processType) {
			case "Audit Galley":
				defaultOutput = processDetailService.generateAuditGalleyDefaultOutput();
				break;
			}
			responseObject.put("processtype", processType);
			responseObject.put("defaultOutputGeneration", "No default defined for this process type");
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in generateDefaultOutputOfRefund");
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/reprint", method = RequestMethod.POST)
	public Map<String, Object> reprint(JobModel jobModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = processDetailService.reprint(jobModel);

			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, "you cannot resubmit this job for reprint ");
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}

	@RequestMapping(path = "/viewLabelDetail", method = RequestMethod.POST)
	public Map<String, Object> getviewLabelDetail(int jobId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Map<String, Object>> viewLabelDetail = processDetailService.getviewLabelDetail(jobId);
			responseObject.put("viewLabelDetail", viewLabelDetail);

		} catch (Exception e) {
			LOGGER.info("error in viewLabelDetail");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(path = "/viewEffortDetail", method = RequestMethod.POST)
	public Map<String, Object> getviewEffortDetail(int jobId, @RequestParam(value = "action") String action) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		Map<String, Object> response = new LinkedHashMap<>();
		try {
			String actionValue = action.toLowerCase();
			System.out.println("Contoller actionValue---->" + actionValue);

			switch (actionValue) {

			case "billinghistory":

				responseObject = processDetailService.getviewEffortDetail(jobId, action);
				responseObject.put("viewBillingEffortDetail", responseObject);
				break;

			case "efforthistory":

				response = processDetailService.getviewEffortDetail(jobId, action);
				responseObject.put("viewRenewalEffortDetail", response);
				System.out.println(responseObject);
				break;

			default:
				responseObject.put("invalid selection", STATUS + ERROR);
			}
			return responseObject;

		} catch (Exception e) {
			LOGGER.info("error in promotionDetials");
			responseObject.put(STATUS + ERROR, e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/restartUpdate", method = RequestMethod.POST)
	public Map<String, Object> restartUpdate(JobModel jobModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			String status = processDetailService.restartUpdate(jobModel);

			if (status == "row updated") {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS,
						"restart update should be disabled,this type of job has not been set up to restart the update step");
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/jobLogDetails", method = RequestMethod.POST)
	public Map<String, Object> getJobLogDetails(int jobId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> jobLogDetails = new ArrayList<>();
		try {

			jobLogDetails = processDetailService.getJobLogDetails(jobId);
			responseObject.put("jobLogDetails", jobLogDetails);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in  jobLogDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteJobLog", method = RequestMethod.POST)
	public Map<String, Object> deleteJobLogDetails(int jobId, int jobLogSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.deleteJobLogDetails(jobId, jobLogSeq);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteJobLogDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/clearHoldDetails", method = RequestMethod.POST)
	public Map<String, Object> getClearHoldDetails(int jobId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			responseObject.put("clearHoldDetails", processDetailService.getResetDate(jobId));
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in  clearHoldDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateClearHold", method = RequestMethod.POST)
	public Map<String, Object> updateClearHold(JobModel jobModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = processDetailService.updateResetStartDateTime(jobModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}

	@RequestMapping(path = "/workTableErrorDetails", method = RequestMethod.POST)
	public Map<String, Object> getWorkTableErrorDetails() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> workTableErrorDetails = new ArrayList<>();
		try {

			workTableErrorDetails = processDetailService.getWorkTableErrorDetails();
			responseObject.put("workTableErrorDetails", workTableErrorDetails);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in  workTableErrorDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/deleteWorkTableError", method = RequestMethod.POST)
	public Map<String, Object> deleteWorkTableError(int jobId, int workTableSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status = processDetailService.deleteWorkTableError(jobId, workTableSeq);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in  deleteWorkTableError(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateResetDate", method = RequestMethod.POST)
	public Map<String, Object> updateResetStartDateTime(JobModel jobModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = processDetailService.updateResetStartDateTime(jobModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}

	@RequestMapping(path = "/manualSelectionDetails", method = RequestMethod.POST)
	public Map<String, Object> getManualSelectionDetails(int jobid, int customerId, int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> manualSelectionDetails = new ArrayList<>();
		try {

			manualSelectionDetails = processDetailService.getManualSelectionDetails(jobid, customerId, ocId);
			responseObject.put("manualSelectionDetails", manualSelectionDetails);

			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in  getManualSelectionDetails(): " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(path = "/updateManualSelection", method = RequestMethod.POST)
	public Map<String, Object> updateManualSelection(JobModel jobModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = processDetailService.updateManualSelection(jobModel);
			if (status == 1) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}

			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}
	}

	@RequestMapping(path = "/getAccountingReconciliation", method = RequestMethod.POST)
	public Map<String, Object> getAccountingReconciliation() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> accountingReconciliationResponse = new ArrayList<>();
		List<Map<String, Object>> getReportFileResponse = new ArrayList<>();
		List<Map<String, Object>> getOrderClassResponse = new ArrayList<>();
		try {
			accountingReconciliationResponse = processDetailService.getAccountingReconciliation();

			Map<String, Object> profitCenterFromDB = accountingReconciliationResponse.get(0);
			String profitCenter = processDetailService.getFirstProfitCenterForAccounting(profitCenterFromDB);
			List<Map<String, Object>> profitCenterAccountingPeriod = new ArrayList<>();

			List<Map<String, Object>> orderClassAccountingPeriod = new ArrayList<>();
			AccountingPeriod accountPeriodForProfitCenter = new AccountingPeriod();
			accountPeriodForProfitCenter.setProfit_center(profitCenter);
			profitCenterAccountingPeriod = processDetailService.profitCenterAccountingPeriod(accountPeriodForProfitCenter);
			getOrderClassResponse = processDetailService.getOrderClass(accountPeriodForProfitCenter);
			Map<String, Object> orderClassOCAsProfitCenter = getOrderClassResponse.get(0);

			String orderClassOC = processDetailService.getFirstProfitCenterForAccounting(orderClassOCAsProfitCenter);
			AccountingPeriod accountPeriodForOrederClass = new AccountingPeriod();
			accountPeriodForOrederClass.setProfit_center(orderClassOC);

			orderClassAccountingPeriod = processDetailService.getOrderClassAccountingPeriod(accountPeriodForOrederClass);

			getReportFileResponse = processDetailService.getReportFile();
			responseObject.put("profitCenter", accountingReconciliationResponse);
			responseObject.put("profitCenterAccountingPeriod", profitCenterAccountingPeriod);
			responseObject.put("OrderClass", getOrderClassResponse);
			responseObject.put("orderClassAccountingPeriod", orderClassAccountingPeriod);
			responseObject.put("reportFile", getReportFileResponse);
			responseObject.put(STATUS, SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Something went wrong in Accounting Reconciliation: " + e);
			responseObject.put(STATUS, ERROR + e);

		}
		return responseObject;
	}

	@RequestMapping(path = "/selectProfitCenter", method = RequestMethod.POST)
	public Map<String, Object> selectProfitCenter(AccountingPeriod accountPeriod) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> getProfitCenter = new ArrayList<>();
		List<Map<String, Object>> getOrderClass = new ArrayList<>();
		List<Map<String, Object>> profitCenterAccountingPeriod = new ArrayList<>();
		List<Map<String, Object>> getOrderClassResponse = new ArrayList<>();
		List<Map<String, Object>> orderClassAccountingPeriod = new ArrayList<>();
		try {
			getProfitCenter = processDetailService.getProfitCenter(accountPeriod);
			getOrderClass = processDetailService.getOrderClassForAccounting(accountPeriod);
			profitCenterAccountingPeriod = processDetailService.profitCenterAccountingPeriod(accountPeriod);
			getOrderClassResponse = processDetailService.getOrderClass(accountPeriod);
			Map<String, Object> orderClassOCAsProfitCenter = getOrderClassResponse.get(0);
			String orderClassOC = processDetailService.getFirstProfitCenterForAccounting(orderClassOCAsProfitCenter);
			AccountingPeriod accountPeriodForOrederClass = new AccountingPeriod();
			accountPeriodForOrederClass.setProfit_center(orderClassOC);
			orderClassAccountingPeriod = processDetailService.getOrderClassAccountingPeriod(accountPeriodForOrederClass);
			responseObject.put("profitCenter", getProfitCenter);
			responseObject.put("orderClass", getOrderClass);
			responseObject.put("profitSummeryAccountingPeriod", profitCenterAccountingPeriod);
			responseObject.put("orderClassAccountingPeriod", orderClassAccountingPeriod);
			responseObject.put(STATUS, SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Something went wrong in select Profit Center: " + e);
			responseObject.put(STATUS, ERROR + e);

		}
		return responseObject;
	}

	@RequestMapping(path = "/selectOrderClass", method = RequestMethod.POST)
	public Map<String, Object> getOrderClass(AccountingPeriod accountPeriod) {
		Map<String, Object> responseObject = new LinkedHashMap<>();

		List<Map<String, Object>> orderClassAccountingPeriod = new ArrayList<>();

		try {

			orderClassAccountingPeriod = processDetailService.getOrderClassAccountingPeriod(accountPeriod);

			responseObject.put("orderClassAccountingPeriod", orderClassAccountingPeriod);
			responseObject.put(STATUS, SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Something went wrong in Order Class Accounting Period : " + e);
			responseObject.put(STATUS, ERROR + e);

		}
		return responseObject;
	}

	@RequestMapping(path = "/profitCenterAccountingPeriod", method = RequestMethod.POST)
	public Map<String, Object> profitCenterForAccountingPeriod(AccountingPeriod accountPeriod) {
		Map<String, Object> responseObject = new LinkedHashMap<>();

		List<Map<String, Object>> profitCenterAccountingPeriod = new ArrayList<>();

		try {

			profitCenterAccountingPeriod = processDetailService.profitCenterAccountingPeriod(accountPeriod);

			responseObject.put("profitSummeryAccountingPeriod", profitCenterAccountingPeriod);

			responseObject.put(STATUS, SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Something went wrong in get Profit Center For Accounting Period: " + e);
			responseObject.put(STATUS, ERROR + e);

		}
		return responseObject;
	}
	@RequestMapping(path = "/getProfitCenterAccountingPeriod", method = RequestMethod.POST)
	public Map<String, Object> getProfitCenterForAccountingPeriod(AccountingPeriod accountPeriod) {
		Map<String, Object> responseObject = new LinkedHashMap<>();

		List<Map<String, Object>> getProfitCenterForAccountingPeriod = new ArrayList<>();

		try {

			getProfitCenterForAccountingPeriod = processDetailService.getProfitCenterForAccountingPeriod(accountPeriod);

			responseObject.put("profitSummeryAccountingPeriod", getProfitCenterForAccountingPeriod);

			responseObject.put(STATUS, SUCCESS);

		} catch (Exception e) {
			LOGGER.error("Something went wrong in get Profit Center For Accounting Period: " + e);
			responseObject.put(STATUS, ERROR + e);

		}
		return responseObject;
	}

	@RequestMapping(path = "/getCloseAccountPeriod", method = RequestMethod.POST)
	public Map<String, Object> getCloseAccountPeriod() {

		Map<String, Object> closeAccountPeriodResponse = new LinkedHashMap<>();
		List<Map<String, Object>> getCloseAccountPeriod = new ArrayList<>();
		
		try {

			getCloseAccountPeriod = processDetailService.getCloseAccountPeriod();
			
			closeAccountPeriodResponse.put("getCloseAccountPeriod", getCloseAccountPeriod);
				closeAccountPeriodResponse.put(STATUS, SUCCESS);
			
			return closeAccountPeriodResponse;
		} catch (Exception e) {
			LOGGER.error("Something went wrong in close Account Period : " + e);
			closeAccountPeriodResponse.put(STATUS, ERROR + e);
			return closeAccountPeriodResponse;
		}
	}

	@RequestMapping(path = "/closeAccountPeriod", method = RequestMethod.POST)
	public Map<String, Object> closeAccountPeriod(String... profit_center) {

		Map<String, Object> closeAccountPeriodResponse = new LinkedHashMap<>();
		int closeStatus = 0;
		try {
			if (profit_center != null) {

				closeStatus = processDetailService.closeAccountPeriod(profit_center);

				if (closeStatus == 1) {
					closeAccountPeriodResponse.put(STATUS, true);
				} else {
					closeAccountPeriodResponse.put(STATUS, false);
				}
			} else {
				LOGGER.error("Description or Profit center Should not be null");
				closeAccountPeriodResponse.put(STATUS, false);
			}
			return closeAccountPeriodResponse;

		} catch (Exception e) {
			LOGGER.error("Something went wrong in editing account period : " + e);
			closeAccountPeriodResponse.put(STATUS, ERROR + e);
			return closeAccountPeriodResponse;
		}
	}
	
	@RequestMapping(path = "/updateAccountPeriod", method = RequestMethod.POST)
	public Map<String, Object> updateAccountPeriod(AccountingPeriod accountPeriod) {

		Map<String, Object> updateAccountPeriodResponse = new LinkedHashMap<>();
		int updateStatus = 0;
		try {
			if (accountPeriod.getProfit_center() != null && accountPeriod.getDescription() != null
					&& (!accountPeriod.getDescription().isEmpty()) && (!accountPeriod.getProfit_center().isEmpty())
					&& accountPeriod.getProfit_center_calendar_seq() != null) {

				updateStatus = processDetailService.updateAccountPeriod(accountPeriod);

				if (updateStatus == 1) {
					updateAccountPeriodResponse.put(STATUS, true);
				} else {
					updateAccountPeriodResponse.put(STATUS, false);
				}
			} else {
				LOGGER.error("Description or Profit center Should not be null");
				updateAccountPeriodResponse.put(STATUS, false);
			}
			return updateAccountPeriodResponse;

		} catch (Exception e) {
			LOGGER.error("Something went wrong in editing account period : " + e);
			updateAccountPeriodResponse.put(STATUS, ERROR + e);
			return updateAccountPeriodResponse;
		}
	}

	@RequestMapping(path = "/deleteAccountPeriod", method = RequestMethod.POST)
	public Map<String, Object> deleteAccountPeriod(AccountingPeriod accountPeriod,Integer... profitCenterCalendarSeq) {
		Map<String, Object> updateAccountPeriodResponse = new LinkedHashMap<>();
		int updateStatus = 0;
		try {
			if (profitCenterCalendarSeq != null && accountPeriod.getProfit_center() != null
					&& (!accountPeriod.getProfit_center().isEmpty())) {
				updateStatus = processDetailService.deleteAccountPeriod(accountPeriod,profitCenterCalendarSeq);

				if (updateStatus == 1) {
					updateAccountPeriodResponse.put(STATUS, true);
				} else {
					updateAccountPeriodResponse.put(STATUS, false);
				}
			} else {
				LOGGER.error("profit Center Calendar Seq or Profit center Should not be null");
				updateAccountPeriodResponse.put(STATUS, false);
			}
			return updateAccountPeriodResponse;

		} catch (Exception e) {
			LOGGER.error("Something went wrong in editing account period : " + e);
			updateAccountPeriodResponse.put(STATUS, ERROR + e);
			return updateAccountPeriodResponse;
		}
	}

	@RequestMapping(path = "/createAccountPeriod", method = RequestMethod.POST)
	public Map<String, Object> createAccountPeriod(AccountingPeriod accountingPeriod,String[] end_date,String... profit_center) {
		
		int createStatus = 0;

		Map<String, Object> createAccountPeriodResponse = new LinkedHashMap<>();
		try {

			createStatus = processDetailService.createAccountPeriod(accountingPeriod, profit_center,end_date);

			if (createStatus == 1) {
				createAccountPeriodResponse.put(STATUS, SUCCESS);
			} else {
				createAccountPeriodResponse.put(STATUS, false);
			}
			return createAccountPeriodResponse;
		} catch (Exception e) {
			LOGGER.error("Something went wrong in close Account Period : " + e);
			createAccountPeriodResponse.put(STATUS, ERROR + e);
			return createAccountPeriodResponse;
		}
	}

	@RequestMapping(path = "/createProfitCenter", method = RequestMethod.POST)
	public Map<String, Object> createProfitCenter(ProfitCenter profitCenter) {

		int createProfitCenterStatus = 0;

		Map<String, Object> profitCenterResponse = new LinkedHashMap<>();
		try {

			createProfitCenterStatus = processDetailService.createProfitCenter(profitCenter);

			if (createProfitCenterStatus == 1) {
				profitCenterResponse.put(STATUS, SUCCESS);
			} else {
				profitCenterResponse.put(STATUS, false);
			}
			return profitCenterResponse;
		} catch (Exception e) {
			LOGGER.error("Something went wrong in creating ProfitCenter : " + e);
			profitCenterResponse.put(STATUS, ERROR + e);
			return profitCenterResponse;
		}
	}

	@RequestMapping(path = "/printAccountPeriod", method = RequestMethod.POST)
	public Map<String, Object> printAccountPeriod(AccountingPeriod accountPeriod) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> getAccountSummaryBreak = new ArrayList<>();
		List<Map<String, Object>> getProfitCenterCalender = new ArrayList<>();
		List<Map<String, Object>> getProfitCenterDetails = new ArrayList<>();
		List<Map<String, Object>> getAccountSummaryWithCalenderSeq = new ArrayList<>();

		try {
			if (accountPeriod.getProfit_center() != null && (!accountPeriod.getProfit_center().isEmpty())) {

				getAccountSummaryBreak = processDetailService.getAccountSummaryBreak(accountPeriod);
				responseObject.put("getAccountSummaryBreak", getAccountSummaryBreak);

				getProfitCenterCalender = processDetailService.getProfitCenterCalender(accountPeriod);
				responseObject.put("getProfitCenterCalender", getProfitCenterCalender);

				getProfitCenterDetails = processDetailService.getProfitCenterDetails(accountPeriod);
				responseObject.put("getProfitCenterDetails", getProfitCenterDetails);

				getAccountSummaryWithCalenderSeq = processDetailService.getAccountSummaryWithCalenderSeq(accountPeriod);
				responseObject.put("getAccountSummaryWithCalenderSeq", getAccountSummaryWithCalenderSeq);

				responseObject.put(STATUS, SUCCESS);
				return responseObject;
			} else {
				LOGGER.error("Profit Center SHOULD NOT BE NULL");
				responseObject.put(STATUS, ERROR);
				return responseObject;
			}
		} catch (Exception e) {
			LOGGER.error("Something went wrong While printing Details : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/createSchedular", method = RequestMethod.POST)
	public Map<String, Object> createSchedular(JobModel job) {

		int createStatus = 0;

		Map<String, Object> closeAccountPeriodResponse = new LinkedHashMap<>();
		try {

			createStatus = processDetailService.createSchedular(job);

			if (createStatus == 1) {
				closeAccountPeriodResponse.put(STATUS, SUCCESS);
			} else {
				closeAccountPeriodResponse.put(STATUS, false);
			}
			return closeAccountPeriodResponse;
		} catch (Exception e) {
			LOGGER.error("Something went wrong in close Account Period : " + e);
			closeAccountPeriodResponse.put(STATUS, ERROR + e);
			return closeAccountPeriodResponse;
		}
	}

	/// get - Initailzing Day End Jobs.

	@RequestMapping(path = "/selectInsertDayEndJobs", method = RequestMethod.POST)
	public Map<String, Object> getInsertDayEndJobs() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> driverList = new ArrayList<DropdownModel>();
		List<Map<String, Object>> insertsDetail = new ArrayList<>();
		try {
			insertsDetail = processDetailService.getInsertDayEndJobs();
			driverList = processDetailService.getQueueDetails();
			responseObject.put("insertsDetail", insertsDetail);
			responseObject.put("driverList", driverList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getInsertsDetail : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	// Update - Initailzing Day End Jobs.
	@RequestMapping(path = "/updateInsertDayEndJobs", method = RequestMethod.POST)
	public Map<String, Object> updateInsertDayEndJobs(JobModel jobModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		boolean status = false;
		try {
			status = processDetailService.updateInsertDayEndJobs(jobModel);
			responseObject.put("status", status);

			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in updateInsertDayEndJobs() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path="/auditGalleySubmitJob",method=RequestMethod.POST)
    public Map<String,Object> updateAuditGalley(JobModel jobModel) {
  	  Map<String,Object> responseObject=new LinkedHashMap<>();
  	  List<Map<String,Object>> orderclassIssueDetails=new ArrayList<>();
  	  int processId=jobModel.getProcessId();
  	  int jobId=jobModel.getJobId();
  	  
  	  try {
  		  boolean status=processDetailService.insertSubmitAuditGalley(jobModel);
  		  orderclassIssueDetails=processDetailService.getOrderIssueDetails(processId);
  		  
  		  List<Map<String,Object>> auditData=processDetailService.getAuditData(processId);
  		 
  		  responseObject.put("auditdata", auditData);
  		  responseObject.put("status", status);
  		  responseObject.put("orderclassIssueDetails", orderclassIssueDetails);
  		  return responseObject;
  	  }catch(Exception e) {
  		  LOGGER.info("error in auditGalleySubmitJob");
  		  responseObject.put(STATUS, ERROR+e);
  		  return responseObject;
  	  }
    }
    
    @RequestMapping(path="auditGalleyJobOutput",method=RequestMethod.POST)
    public Map<String,Object> jobOutput(JobOutputModel jobOutputModel) {
  	  Map<String,Object> responseObject=new LinkedHashMap<>();
  	  boolean addjobOutput=false;
  	  int processId=jobOutputModel.getProcessId();
  	  int jobOutputSeq=jobOutputModel.getJobOutputSeq();
  	  
  	  try {
  		 addjobOutput=processDetailService.insertJobOutput(jobOutputModel);
  		 responseObject.put("addJobOutput", addjobOutput);
  		  List<Map<String,Object>> jobOutputDetails=processDetailService.getJobOutputDetail(processId);
  		  responseObject.put("jobOutputdetails", jobOutputDetails);

  		 return responseObject;
  	  }catch (Exception e) {
			LOGGER.info("error in auditGalleyJobOutput ");
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
    }
    
    @RequestMapping(path="backLabelSubmitJob",method=RequestMethod.POST) 
    public Map<String,Object> backLabelJob(JobModel jobModel) {
  	  Map<String,Object> responseObject=new LinkedHashMap<>();
  	  boolean addBackLabelJob=false;
  	  int logOption=jobModel.getLogOption();
  	  try {
  		  addBackLabelJob=processDetailService.insertBackLabelJob(jobModel);
  		  responseObject.put("addBackLabelJob", addBackLabelJob);
  			  responseObject.put("0", "None");
  			  responseObject.put("1","Normal");
  			  responseObject.put("2", "Detailed");
  		
  		  return responseObject;
  		  
  	  }catch (Exception e) {
		LOGGER.info("error in the backLabelsubmitJob");
		responseObject.put(STATUS,ERROR+e);
		return responseObject;
		}
    }
    
    @RequestMapping(path="backLabelSubmitJobUpdate",method=RequestMethod.POST)
    public Map<String,Object> updateBackLabelSubmitJob(JobOutputModel jobOutputModel) {
  	  Map<String,Object> responseObject=new LinkedHashMap<>();
  	  boolean addjobOutput=false;
  	  int processId=jobOutputModel.getProcessId();
  	  int jobOutputSeq=jobOutputModel.getJobOutputSeq();
  	  
  	  try {
  		 addjobOutput=processDetailService.insertJobOutput(jobOutputModel);
  		 responseObject.put("addJobOutput", addjobOutput);
  		  List<Map<String,Object>> jobOutputDetails=processDetailService.getJobOutputDetail(processId);
  		  responseObject.put("jobOutputdetails", jobOutputDetails);

  		 return responseObject;
  	  }catch (Exception e) {
			LOGGER.info("error in backLabelSubmitJob ");
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
  	  
    }
    @RequestMapping(path="/labelSubmitJob",method=RequestMethod.POST)
    public Map<String,Object> labelSubmitJob(JobModel jobModel) {
  	  Map<String,Object> responseObject=new LinkedHashMap<>();
  	  boolean addLabelJob=false;
  	  try {
  		  addLabelJob=processDetailService.insertLabelJob(jobModel);
  		  responseObject.put("addLabelJob", addLabelJob);
  		  
	    	  int jobId=processDetailService.getJobId();
  		  responseObject.put("jobId", jobId);
  		  int processId=jobModel.getProcessId();
  		  responseObject.put("processId", processId);

  		  List<Map<String,Object>> labelDetails=processDetailService. getLabelDetails(processId);
  		  responseObject.put("labelDetails", labelDetails);
  		  return responseObject;
  	  }catch (Exception e) {
			LOGGER.info("error in labelSubmitJob");
			responseObject.put(STATUS, ERROR+e);
			return responseObject;
		}
    }
    
    @RequestMapping(path="labelSubmitJobDetails",method=RequestMethod.POST)
  	  public Map<String,Object> SubmitJobDetails(int jobId,int processId) {
  		  Map<String,Object> responseObject=new LinkedHashMap<>();
  		  try {
  			  int ocId=processDetailService.getOcId();
  			  System.out.println(ocId);
  			  List<Map<String,Object>> labelSubmitJobDetails=processDetailService.getLabelJobPubOcDetail(ocId);
  			  responseObject.put("labelSubmitJobDetails", labelSubmitJobDetails);
  			  
  			  List<Map<String,Object>> labelJobRenewalEffort=processDetailService.getJobRenewalEffort(jobId);
  			  responseObject.put("labelJobRenewalEffort",labelJobRenewalEffort);
  			  List<Map<String,Object>> jobBillingDetails=processDetailService.getJobBillingDetails(jobId);
  			  responseObject.put("jobBillingDetails", jobBillingDetails);
  			  List<Map<String,Object>> jobOutPutDetail=processDetailService.getJobOutputDetail(processId);
  			  responseObject.put("jobOutPutDetail", jobOutPutDetail);
  			  return responseObject;

  		  }catch (Exception e) {
				LOGGER.error("error in labelSubmitJobDetails");
				responseObject.put(STATUS,ERROR+e);
				return responseObject;
			}
  	  }
    
    @RequestMapping(path="renewalSubmitJob",method=RequestMethod.POST)
    public Map<String,Object> submitJobOfRenewal(JobModel jobModel) {
  	  Map<String,Object> responseObject=new LinkedHashMap<>();
  	  boolean addLabelJob=false;
  	  try {
  		  addLabelJob=processDetailService.insertLabelJob(jobModel);
  		  responseObject.put("addLabelJob", addLabelJob);
  		  int processId=jobModel.getProcessId();
  		  responseObject.put("processId", processId);

  		  List<Map<String,Object>> labelDetails=processDetailService. getLabelDetails(processId);
  		  responseObject.put("labelDetails", labelDetails);
  		  
  		  return responseObject;
  	  }catch (Exception e) {
			LOGGER.info("error in renewalSubmitJob");
			responseObject.put(STATUS, ERROR+e);
			return responseObject;
		}
  		   
    }
  
    @RequestMapping(path="jobRenewalEffortsave",method=RequestMethod.POST)
    public Map<String,Object> jobRenewalEffort(SubmitJobModel submitJobModel) { 
  	  Map<String,Object> responseObject=new LinkedHashMap<>();
  	  String addJobRenewalEffort=null;
  	  try {
  		 addJobRenewalEffort=processDetailService.insertJobRenewalEffort(submitJobModel);
  		 responseObject.put("addJobRenewalEffort",addJobRenewalEffort);
  		  
	    	 
  		  List<Map<String,Object>> jobRenewalEffortDetails=processDetailService.getJobRenewalEffortDetails();
  		  responseObject.put("jobRenewalEffortDetails", jobRenewalEffortDetails);
  		  

  		  return responseObject;
  	  }catch (Exception e) {
		LOGGER.info("error in jobRenewalEffortSave");
		responseObject.put(STATUS, ERROR+e);
		return responseObject;
		}
    }
 
   @RequestMapping(path="issueLookUp",method=RequestMethod.POST)
   public Map<String,Object> issue(String issueId,String issueDate,String enumeration,String volumeGroupId,String description){
  	  Map<String,Object> responseObject=new LinkedHashMap<>();
  	  List<Map<String,Object>> issueDetails=new ArrayList<>();
  	  List<Map<String,Object>> addressDetails=new ArrayList<>();
  	 try {

  		 if("*".equals(issueId) ) {
  			 responseObject.put(STATUS, "The value '*' is not valid for field issueId");
  			 
  		 }
  		 if("*".equals(issueDate)) {
  			 responseObject.put(STATUS, "The value '*' is not valid for field issueDate");

  		 }else if("*".equals(volumeGroupId)) {
  			 responseObject.put(STATUS, "The value '*' is not valid for field volumeGroupId");

  		 } if("*".equals(description)) {
  			 responseObject.put(STATUS, "error");

  		 }
  		 else  {
  			issueDetails= processDetailService.getIssueDetails(issueId,issueDate,enumeration,volumeGroupId,description);
	    		 responseObject.put("issueDetails", issueDetails);
		
  		 }
  		 addressDetails=processDetailService.getAddressDetails();
  		 responseObject.put("addressDetails", addressDetails);
  			return responseObject;

  	 }catch(Exception e) {
  		 LOGGER.error(ERROR+e);
  		 responseObject.put(STATUS,ERROR+e);
  		 return responseObject;
  	 }
   }
  @RequestMapping(path="/billingSubmitJob",method=RequestMethod.POST)
  public Map<String,Object> billing(JobModel jobModel){
  	Map<String,Object> responseObject=new LinkedHashMap<>();
  	 boolean addLabelJob=false;
  	  try {
  		  addLabelJob=processDetailService.insertLabelJob(jobModel);
  		  responseObject.put("addLabelJob", addLabelJob);
  		  int processId=jobModel.getProcessId();
  		  responseObject.put("processId", processId);

  		  List<Map<String,Object>> labelDetails=processDetailService. getLabelDetails(processId);
  		  responseObject.put("labelDetails", labelDetails);
  		  
  		  return responseObject;
  	  }catch (Exception e) {
			LOGGER.info("error in renewalSubmitJob");
			responseObject.put(STATUS, ERROR+e);
			return responseObject;
		}
  }
  @RequestMapping(path="billingJobEffortSave",method=RequestMethod.POST)
  public Map<String,Object> billingJobEffort(SubmitJobModel submitJobModel) {
  	Map<String,Object> responseObject=new LinkedHashMap<>();
  	String addJobRenewalEffort=null;
  	String addBillingJobEffort=null;
  	  try {
  		  addJobRenewalEffort=processDetailService.insertJobRenewalEffort(submitJobModel);
  		 responseObject.put("addJobRenewalEffort",addJobRenewalEffort);
  		  
	    	  int jobId=processDetailService.getJobId();
  		  responseObject.put("jobId", jobId);
  		  addBillingJobEffort=processDetailService.insertBillingJobEffort(submitJobModel,jobId);
  		  responseObject.put("addBillingJobEffort",addBillingJobEffort);
  		  List<Map<String,Object>> jobBillingEffort=processDetailService.getJobBillingDetails(jobId);
  		  List<Map<String,Object>> jobRenewalEffort=processDetailService.getJobRenewalEffort(jobId);
  		  responseObject.put("jobBillingEffort", jobBillingEffort);
  		  responseObject.put("jobRenewalEffort", jobRenewalEffort);
	    	return responseObject;

  		  
  }catch (Exception e) {

  	LOGGER.error(ERROR+e);
  	responseObject.put(STATUS, ERROR+e);
  	return responseObject;
	}
}
  
  @RequestMapping(path="/jobRenewalBillingDetails",method=RequestMethod.POST)
  public Map<String,Object> renewalBillingDetails(String billingDef){
  	Map<String,Object> responseObject=new LinkedHashMap<>();
  	try {
  		int jobId=processDetailService.getJobId();
  		  List<Map<String,Object>> jobRenewalEffort=processDetailService.getJobRenewalEffort(jobId);
  		  responseObject.put("jobRenewalEffort", jobRenewalEffort);

  		  List<Map<String,Object>> jobBillingEffortDetails=processDetailService.billingDetails(billingDef);
  		  responseObject.put("jobBillingEffortDetails", jobBillingEffortDetails);
  		  return responseObject;
  		  
  	}catch (Exception e) {

	    	LOGGER.error(ERROR+e);
	    	responseObject.put(STATUS, ERROR+e);
	    	return responseObject;
		}
  }
  @RequestMapping(path="/productSubmitJobSave",method=RequestMethod.POST)
	public Map<String,Object> productJob(JobModel jobModel){
		 Map<String,Object> responseObject=new LinkedHashMap<>();
		 String productSubmitJob=null;
		 try {
			 productSubmitJob=processDetailService.insertProductSubmitJob(jobModel);
  		 responseObject.put("addJobRenewalEffort",productSubmitJob);
  		  
	    	 int jobId=processDetailService.getJobId();
  		  responseObject.put("jobId", jobId);
  		  List<Map<String,Object>> productSubmitJobDetails=processDetailService.getProductSubmitJob(jobId);
  		  responseObject.put("productSubmitJobDetails", productSubmitJobDetails);
  		  return responseObject;
		 }catch (Exception e) {

		    	LOGGER.error(ERROR,e);
		    	responseObject.put(STATUS, ERROR+e);
		    	return responseObject;
			}
	}
@RequestMapping(path="productJobOutputSave",method=RequestMethod.POST)
public Map<String,Object> jobOutputSave(JobModel jobModel,String paramValues,String ouputFilename) {
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 String addJobOutput=null;
	 String productSubmitJob=null;
	
	 try {
		 productSubmitJob=processDetailService.insertProductSubmitJob(jobModel);
		 responseObject.put("addJobRenewalEffort",productSubmitJob);
		 addJobOutput=processDetailService.addJobOutput(paramValues,ouputFilename);
		 responseObject.put("addJobOutput", addJobOutput);
			 return responseObject;
}catch (Exception e) {

  	LOGGER.error(ERROR,e);
  	responseObject.put(STATUS, ERROR+e);
  	return responseObject;
	}

}	      
	@RequestMapping(path="/productJobOutputDetails",method=RequestMethod.POST)
	public Map<String,Object> productJobOutputInfo(int ocId){
		Map<String,Object> responseObject=new HashMap<>();
		List<Map<String,Object>> productJobOutput=new ArrayList<Map<String,Object>>();
		try {
			productJobOutput=processDetailService.getProductJobOutput(ocId);
			responseObject.put("productJobOutput",productJobOutput);
			return responseObject;
			
		}catch (Exception e) {

	    	LOGGER.error(ERROR,e);
	    	responseObject.put(STATUS, ERROR+e);
	    	return responseObject;
		}
	}
@RequestMapping(path="/installmentNoticeSbmitJob",method=RequestMethod.POST)
public Map<String,Object> installment(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	 try {
		 
		 status=processDetailService.insertInstallmentNotices(jobModel);
		 if(status!=0) {
			 responseObject.put(STATUS, true);
		 }else {
			 responseObject.put(STATUS, false);
		 }if(status!=0) {
			 
		 }
		 return responseObject;
	 }catch (Exception e) {

	    	LOGGER.error(ERROR,e);
	    	responseObject.put(STATUS, ERROR+e);
	    	return responseObject;
		}
}
@RequestMapping(path="/installNoticeSubmitJobDetail",method=RequestMethod.POST)
public Map<String,Object> submitJobDetails(int processId){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 try {
		 List<Map<String,Object>> installNoticeSubmitJob=processDetailService.installNoticeSubmitJobDetails(processId);
		 responseObject.put("installNoticeSubmitJob",installNoticeSubmitJob);
		 return responseObject;
	 }catch (Exception e) {

	    	LOGGER.error(ERROR,e);
	    	responseObject.put(STATUS, ERROR+e);
	    	return responseObject;
		}
}
@RequestMapping(path="/cleanupSubmitJob",method=RequestMethod.POST)
public Map<String,Object> cleanUp(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	 try {
		 
		 status=processDetailService.insertCleanupSubmitJob(jobModel);
		 if(status!=0) {
			 responseObject.put(STATUS, true);
		 }else {
			 responseObject.put(STATUS, false);
		 }if(status!=0) {
			 
		 }
		 return responseObject;
	 }catch (Exception e) {

	    	LOGGER.error(ERROR,e);
	    	responseObject.put(STATUS, ERROR+e);
	    	return responseObject;
		}
}
@RequestMapping(path="cleanUpSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> cleanUpDetails(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> cleanupSubmitJob=processDetailService.getCleanupSubmitJobDetails(processId);
		responseObject.put("cleanupSubmitJob", cleanupSubmitJob);
		List<Map<String,Object>> cleanupDef=(List<Map<String, Object>>) processDetailService.getCleanupDefinitionDetails();
		responseObject.put("cleanupDef", cleanupDef);
		return responseObject;
	}catch (Exception e) {

  	LOGGER.error(ERROR,e);
  	responseObject.put(STATUS, ERROR+e);
  	return responseObject;
	}
}

@RequestMapping(path="/refundSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> refundSubmitJob(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> refundSubmitJob=processDetailService.getRefundSubmitJob(processId);
		responseObject.put("refundSubmitJob", refundSubmitJob);
		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/refundSubmitJobSave",method=RequestMethod.POST)
public Map<String,Object> refundSubmit(JobModel jobModel){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	int status=0;
	try {
		status=processDetailService.insertRefundSubmitJob(jobModel);
		if(status!=0) {
			responseObject.put(STATUS,true);
		}else {
			responseObject.put(STATUS,false);

		}
		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/start/stopSubmitJobSave",method=RequestMethod.POST)
public Map<String,Object> startStopSubmit(JobModel jobModel){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	int status=0;
	try {
		
		status=processDetailService.insertStartStopSubmitJob(jobModel);
		if(status!=0) {
			responseObject.put(STATUS,true);
		}else {
			responseObject.put(STATUS,false);

		}
		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/jobPubOcStartStopSubmitJobSave",method=RequestMethod.POST)
public Map<String,Object> jobPubOc(JobModel jobModel,int ocId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	int status=0;
	int status1=0;
	try {
		
		status=processDetailService.insertStartStopSubmitJob(jobModel);
		status1=processDetailService.insertJobPubOc(ocId);
		if(status!=0 && status1!=0) {
			responseObject.put(STATUS,true);
		}else {
			responseObject.put(STATUS,false);

		}
		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/startStopSubmitJobDetail",method=RequestMethod.POST)
public Map<String,Object> submitJobInfo(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> startStopSubmitJobSubmitJob=processDetailService.getStartStopSubmitJob(processId);
		responseObject.put("startStopSubmitJobSubmitJob", startStopSubmitJobSubmitJob);
		List<Map<String,Object>> jobPubOcDetail=processDetailService.getjobPubOcDetail();
		responseObject.put("jobPubOcDetail", jobPubOcDetail);
		 List<Map<String,Object>> jobOutputDetails=processDetailService.getJobOutputDetail(processId);
 		  responseObject.put("jobOutputdetails", jobOutputDetails);

		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/promotionSubmitJobSave",method=RequestMethod.POST)
public Map<String,Object>promotionSubmit(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
 	  boolean addLabelJob=false;
 	  try {
 		  addLabelJob=processDetailService.insertLabelJob(jobModel);
 		  responseObject.put("addLabelJob", addLabelJob);
		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/jobPromotionSubmitJobSave",method=RequestMethod.POST)
public Map<String,Object>jobPromotionSubmitJob(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
 	  boolean addLabelJob=true;
 	  boolean JobPromotion=false;
 	  try {
 		  addLabelJob=processDetailService.insertLabelJob(jobModel);
 		 JobPromotion=processDetailService.insertJobPromotionEffort();
 		if(addLabelJob==true && JobPromotion==true) {
 	 		  responseObject.put(STATUS, true);

 		}else {
 	 		  responseObject.put(STATUS, false);
 		}
		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/jobPromotionSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> jobPromotionDetails(int processId,int jobId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		 List<Map<String,Object>> labelDetails=processDetailService. getLabelDetails(processId);
 		  responseObject.put("labelDetails", labelDetails);
 		List<Map<String,Object>> issueDetails= processDetailService.getjobPubOcDetail();
 		responseObject.put("issueDetails", issueDetails);
 		List<Map<String,Object>> jobPromotionDetail=processDetailService.getJobPromotionDetails(jobId);
 		responseObject.put("jobPromotionDetail", jobPromotionDetail);
 		List<Map<String,Object>> jobBillingEffort=processDetailService.getJobBillingDetails(jobId);
 		responseObject.put("jobBillingEffort",jobBillingEffort);
 		return responseObject;
 		

	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/onOffSubmitJob",method=RequestMethod.POST)
public Map<String,Object>onOff(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
 	  boolean addLabelJob=false;
 	  try {
 		  addLabelJob=processDetailService.insertOnoff(jobModel);
 		if(addLabelJob==true) {
 	 		  responseObject.put(STATUS, true);

 		}else {
 	 		  responseObject.put(STATUS, false);
 		}
		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/onOffSubmitJobPubOc",method=RequestMethod.POST)
public Map<String,Object> onOffJobPubOc(JobModel jobModel,int issueId) {
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	  boolean addLabelJob=false;
	  boolean addJobPubOc=false;
	  try {
		  addLabelJob=processDetailService.insertOnoff(jobModel);
		  addJobPubOc=processDetailService.insertOnOffJobPubOc(issueId);
		if(addLabelJob==true && addJobPubOc==true) {
	 		  responseObject.put(STATUS, true);

		}else {
	 		  responseObject.put(STATUS, false);
		}
		return responseObject;
	}catch (Exception e) {

	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/onOffSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> onOffSubmitDetails(int processId,int jobId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		 List<Map<String,Object>> labelDetails=processDetailService. getLabelDetails(processId);
 		  responseObject.put("labelDetails", labelDetails);
 		List<Map<String,Object>> issueDetails= processDetailService.getOnOffjobPubOcDetail();
 		responseObject.put("issueDetails", issueDetails);
 		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/maskillSubmitJObSave",method=RequestMethod.POST)
public Map<String,Object> massKill(JobModel jobModel) {
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	  try {
		  status=processDetailService.insertMassKillJob(jobModel);
		if(status!=0) {
	 		  responseObject.put(STATUS, true);

		}else {
	 		  responseObject.put(STATUS, false);
		}
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/massKillSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> massKillDetails(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> masskillDetails=processDetailService.getMassKill(processId);
		List<Map<String,Object>> jobOutputDetails=processDetailService.getJobOutputDetail(processId);
		responseObject.put("masskillDetails", masskillDetails);
		responseObject.put("jobOutputDetails", jobOutputDetails);
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/listExtractSubmitJObSave",method=RequestMethod.POST)
public Map<String,Object> listExtract(JobModel jobModel) {
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	  try {
		  status=processDetailService.insertListExtract(jobModel);
		if(status!=0) {
	 		  responseObject.put(STATUS, true);

		}else {
	 		  responseObject.put(STATUS, false);
		}
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/listExtractSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> listExtractDetails(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> listExtractDetails=processDetailService.getListExtract(processId);
		List<Map<String,Object>> jobOutputDetails=processDetailService.getJobOutputDetail(processId);
		responseObject.put("listExtractDetails", listExtractDetails);
		responseObject.put("jobOutputDetails", jobOutputDetails);
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/icsBatchListenerSubmitJObSave",method=RequestMethod.POST)
public Map<String,Object> icsBatchListener(JobModel jobModel) {
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	  try {
		  status=processDetailService.insertIcsBatchListe(jobModel);
		if(status!=0) {
	 		  responseObject.put(STATUS, true);

		}else {
	 		  responseObject.put(STATUS, false);
		}
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/icsBatchListeSubmitJObDetail",method=RequestMethod.POST)
public Map<String,Object> icsBatchListenerDetail(int processId) {
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 try {
		 List<Map<String,Object>> icsBatchListenerDetail=processDetailService.getIcsBatchListener(processId);
		 responseObject.put("icsBatchListenerDetail", icsBatchListenerDetail);
		 return responseObject;
	 }catch (Exception e) {
		  	LOGGER.error(ERROR,e);
		  	responseObject.put(STATUS, ERROR+e);
		  	return responseObject;
			}
}
@RequestMapping(path="/creditCardTokenRfreshSubmitJob",method=RequestMethod.POST)
public Map<String,Object> creditCardTokenExpire(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	  try {
		  status=processDetailService.insertIcsBatchListe(jobModel);
		if(status!=0) {
	 		  responseObject.put(STATUS, true);

		}else {
	 		  responseObject.put(STATUS, false);
		}
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/creditRefreshSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> creditCardTokenRefresh(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> crediCardTokenRefresh=processDetailService.getCreditTokenRefresh(processId);
		responseObject.put("crediCardTokenRefresh", crediCardTokenRefresh);
		
		List<Map<String,Object>> jobOutput=processDetailService.getJobOutputDetail(processId);
		responseObject.put("jobOutput",jobOutput);

		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/creditCardExpireSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> creditCardExpire(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> crediCardTokenRefresh=processDetailService.getCreditTokenRefresh(processId);
		List<Map<String,Object>> jobOutput=processDetailService.getJobOutputDetail(processId);
		responseObject.put("crediCardTokenRefresh", crediCardTokenRefresh);
		responseObject.put("jobOutput",jobOutput);
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/creditCardExpireSubmitJob",method=RequestMethod.POST)
public Map<String,Object> creditCardExpire(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	  try {
		  status=processDetailService.insertIcsBatchListe(jobModel);
		if(status!=0) {
	 		  responseObject.put(STATUS, true);

		}else {
	 		  responseObject.put(STATUS, false);
		}
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/bacsAuddisSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> bacsAuddis(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> bacsAuddis=processDetailService.getCreditTokenRefresh(processId);
		responseObject.put("bacsAuddis", bacsAuddis);
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/bacsAuddisSubmitJobSave",method=RequestMethod.POST)
public Map<String,Object> bacsAuddis(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	  try {
		  status=processDetailService.insertIcsBatchListe(jobModel);
		if(status!=0) {
	 		  responseObject.put(STATUS, true);

		}else {
	 		  responseObject.put(STATUS, false);
		}
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}

@RequestMapping(path="/bacsBillingSubmitJobSave",method=RequestMethod.POST)
public Map<String,Object> bacsBilling(JobModel jobModel) {
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		int status=processDetailService.insertBacsBilling(jobModel);
		if(status!=0) {
			responseObject.put(STATUS, true);
		}else {
			responseObject.put(STATUS, false);

		}
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/bacsBillingSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> bacsBilling(int processId) {
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> bacsBilling=processDetailService.getBacsBilling(processId);
			responseObject.put("bacsBilling", bacsBilling);
			List<Map<String,Object>> jobPubOc=processDetailService.getjobPubOcDetail();
			responseObject.put("jobPubOc", jobPubOc);

		
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/autoRenewalNotifySubmitJob",method=RequestMethod.POST)
public Map<String,Object> autoRenewalNotify(JobModel jobModel){
	 Map<String,Object> responseObject=new LinkedHashMap<>();
	 int status=0;
	  try {
		  status=processDetailService.insertIcsBatchListe(jobModel);
		if(status!=0) {
	 		  responseObject.put(STATUS, true);

		}else {
	 		  responseObject.put(STATUS, false);
		}
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/autoRenewalSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> autoRenewalNotify(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> crediCardTokenRefresh=processDetailService.getCreditTokenRefresh(processId);
		List<Map<String,Object>> jobOutput=processDetailService.getJobOutputDetail(processId);
		responseObject.put("crediCardTokenRefresh", crediCardTokenRefresh);
		responseObject.put("jobOutput",jobOutput);
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/bacsDDSubmitJobSave",method=RequestMethod.POST)
public Map<String,Object> bacsDD(JobModel jobModel){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		int status=processDetailService.insertBacsDD(jobModel);
		if(status!=0) {
			responseObject.put(STATUS, true);
		}else {
			responseObject.put(STATUS, false);

		}return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
@RequestMapping(path="/bacsDDSubmitJobDetails",method=RequestMethod.POST)
public Map<String,Object> bacsDD(int processId){
	Map<String,Object> responseObject=new LinkedHashMap<>();
	try {
		List<Map<String,Object>> bacsDD=processDetailService.getBascDD(processId);
		responseObject.put("bacsDD", bacsDD);
		return responseObject;
	}catch (Exception e) {
	  	LOGGER.error(ERROR,e);
	  	responseObject.put(STATUS, ERROR+e);
	  	return responseObject;
		}
}
}



