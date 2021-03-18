package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.mps.think.model.LeftPanelCustomerServiceModel;
import com.mps.think.model.NoteAddAttributeModel;
import com.mps.think.orderFunctionality.model.ProspectModel;
import com.mps.think.service.CustomerLoginService;
import com.mps.think.service.CustomerOrderService;
import com.mps.think.service.CustomerSearchService;
import com.mps.think.service.OrderPaymentService;
import com.mps.think.service.UtilityService;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;

@RestController
@Scope("request")
public class CustomerSearchController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerSearchController.class);
	//private static Gson gson = new GsonBuilder().serializeNulls().create();
	private static final String CUSTOMERADD = "customerAddAttributeModel";
	private static final String CUSTOMERID = "customerId";
	private static final String ATTACHMENTFILTER = "attachmentFilter";
	private static final String ATTACHMENTADD = "attachmentAdd";
	
	@Autowired
	CustomerSearchService customerSearchService;
	
	@Autowired
	UtilityService utilityService;

	@Autowired
	OrderPaymentService  orderPaymentService;
	
	@Autowired
	CustomerOrderService customerOrderService;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	CustomerLoginService customerLoginService;
	@Autowired
	CustomerUtility customerUtility;
	//*******************************************************
	@PostConstruct
	public void init() {
		 try {
			 CustomerUtility customerUtility = new CustomerUtility();
			 customerUtility.runTruncate(jdbcTemplate);
		 } catch (Exception e) {
			e.printStackTrace();
		}
	}
   //*******************************************************
	

	@RequestMapping(path = "/customerSearch", method = RequestMethod.POST)
	public Map<String, Object> customerSearch(CustomerSearchAttributeModel customerSearchAttributeModel) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		
		try {
			if ("CustomerID".equals(customerSearchAttributeModel.getSearchBy())) {
				//if (customerSearchAttributeModel.getCustomerId().contains(".")) {
					//Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
					Pattern pattern = Pattern.compile("[a-zA-Z0-9-]*");

					System.out.println(customerSearchAttributeModel.getCustomerId());

					String str = customerSearchAttributeModel.getCustomerId();
					
					Matcher matcher = pattern.matcher(str);
					if (!matcher.matches()) {
						responseObject.put(STATUS,false);
						responseObject.put("msg"," The value '"+str+"' is not valid for field 'Customer Number'. ");
					}else {
						responseObject.put("searchresultByAddress",customerSearchService.getCustomerSearchByAddress(customerSearchAttributeModel));
						responseObject.put("searchresultByAddressTableHeaders",utilityService.getDispContextHeaders("custaddr_srchresult_address"));
						responseObject.put("searchResultByOrder",customerSearchService.getCustomerSearchByOrder(customerSearchAttributeModel));
						responseObject.put("searchResultByOrderTableHeaders",utilityService.getDispContextHeaders("cust_srchresult_orderitem"));
						
						responseObject.put("searchResultByPayment",customerSearchService.getCustomerSearchByPayment(customerSearchAttributeModel));
						responseObject.put("searchResultByPaymentTableHeaders",utilityService.getDispContextHeaders("cust_srchresult_payment"));
						responseObject.put(STATUS,SUCCESS);
					}
			}else {
				responseObject.put("searchresultByAddress",customerSearchService.getCustomerSearchByAddress(customerSearchAttributeModel));
				responseObject.put("searchresultByAddressTableHeaders",utilityService.getDispContextHeaders("custaddr_srchresult_address"));
				responseObject.put("searchResultByOrder",customerSearchService.getCustomerSearchByOrder(customerSearchAttributeModel));
				responseObject.put("searchResultByOrderTableHeaders",utilityService.getDispContextHeaders("cust_srchresult_orderitem"));
				
				responseObject.put("searchResultByPayment",customerSearchService.getCustomerSearchByPayment(customerSearchAttributeModel));
				responseObject.put("searchResultByPaymentTableHeaders",utilityService.getDispContextHeaders("cust_srchresult_payment"));
				responseObject.put(STATUS,SUCCESS);
			}
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/customerAdd", method = RequestMethod.POST)
	public Map<String, Object> customerAdd() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			CustomerAddAttributeModel customerAddAttributeModel = new CustomerAddAttributeModel();
			customerAddAttributeModel.setStateList(customerSearchService.getStateList());
			customerAddAttributeModel.setAddressTypeList(customerSearchService.getaddressType());
			customerAddAttributeModel.setListRentalList(customerSearchService.getlistRental());
			customerAddAttributeModel.setCustomerCategoryList(customerSearchService.getcustomerCategory());
			customerAddAttributeModel.setSalesRepresentativeList(customerSearchService.getsalesRepresentative());
			customerAddAttributeModel.setAddressStatusList(customerSearchService.getaddressStatus());
			customerAddAttributeModel.setCreditStatusList(customerSearchService.getcreditStatus());
			customerAddAttributeModel.setTaxFilterList(customerSearchService.gettaxFilter());
			customerAddAttributeModel.setPaymentThersholdList(customerSearchService.getpaymentThresholdList());
			customerAddAttributeModel.setAddressType(customerSearchService.getdefaultAddressType());
			customerAddAttributeModel.setListRental(customerSearchService.getdefaultListRental());
			customerAddAttributeModel.setAddressStatus(customerSearchService.getdefaultAddressStatus());
			customerAddAttributeModel.setCreditStatus(customerSearchService.getdefaultCreditStatus());
			responseObject.put(CUSTOMERADD, customerAddAttributeModel);
			String action = "customer";
			List<CustomerAuxiliaryModel> auxiliaryFormField = orderPaymentService.getAuxiliaryFields(action);
			responseObject.put("auxiliaryformfeild", auxiliaryFormField);
			List<DropdownModel> setAsGroupMember = customerSearchService.getsetAsGroupMbr();
			responseObject.put("setAsGroupMember", setAsGroupMember);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	/**
	 * Return Country by providing the state or country code
	 * @param statecode
	 * @return country
	 */
	@RequestMapping(path = "/getCountry", method = RequestMethod.POST, name ="Get Country Details by providing country code")
	public Map<String, Object> getCountry(
			@RequestParam("statecode") String statecode) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<String> country = customerSearchService.getCountry(statecode);
			responseObject.put("country",country);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/getStateList", method = RequestMethod.POST)
	public Map<String, Object> getStateList() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> stateList = customerSearchService.getStateList();
			responseObject.put("StateList",stateList);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	@RequestMapping(path = "/getCustomerCatagoryList", method = RequestMethod.POST)
	public Map<String, Object> customerCategoryList() {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<DropdownModel> customerCategoryList = customerSearchService.getCustomerCategoryList();
			responseObject.put("customerCategoryList",customerCategoryList);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	@RequestMapping(path = "/checkDuplicateCustomer", method = RequestMethod.POST)
	public Map<String, Object> checkDuplicateCustomer(CustomerAddAttributeModel customerAddAttributeModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Object> duplicateRecord = customerSearchService.getDuplicateRecord(customerAddAttributeModel);
			responseObject.put("duplicateCustomer", duplicateRecord);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
		
	}
	
	@RequestMapping(path = "/customerAddSubmit", method = RequestMethod.POST)
	public Map<String, Object> customerAddSubmit(CustomerAddAttributeModel customerAddAttributeModel) {

		String status="";
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			status = customerSearchService.addCustomer(customerAddAttributeModel);						
		if(ERROR.equals(status)) {
			if ("true".equals(customerAddAttributeModel.getSetGroupMember())) {
				if(customerAddAttributeModel.getCustomerGroupCustomerId().equals("") || customerAddAttributeModel.getCustomerGroupCustomerId().isEmpty()) {
					responseObject.put("msg", "Group name is a required field.");
				}
			}
			if ("true".equals(customerAddAttributeModel.getIsProspect())) {
				if(customerAddAttributeModel.getProspectCategory().equals(null) || customerAddAttributeModel.getProspectCategory().equals("") || customerAddAttributeModel.getProspectCategory().isEmpty()) {
					responseObject.put("message", "You must choose a prospect category.");
					responseObject.put(STATUS, false);
				}
			}
			responseObject.put(STATUS, ERROR);
			return responseObject;
					
			}else {
				responseObject.put(STATUS, SUCCESS);
				responseObject.put("CustomerId", status);
				return responseObject;
			}
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
		
	}
	
	@RequestMapping(path = "/customerEdit", method = RequestMethod.POST)
	public Map<String, Object> customerEdit(@RequestParam(CUSTOMERID) Long customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			CustomerAddAttributeModel customerAddAttributeModel = new CustomerAddAttributeModel();
			customerSearchService.getCustomerDetail(customerAddAttributeModel,customerId);
			List<CustomerAddressModel> addressDetail = customerSearchService.getaddressDetail(customerId,"default");
			List<CustomerAddressModel> futureTempaddressDetail = customerSearchService.getaddressDetail(customerId,"future");
			responseObject.put("addressDetail", addressDetail);
			responseObject.put("futureTempaddressDetail", futureTempaddressDetail);
			responseObject.put(CUSTOMERADD, customerAddAttributeModel);
			List<String> group = jdbcTemplate.queryForList("select customer_id from customer_group where customer_id ="+ customerId, String.class); 
			if(group.isEmpty() || group.equals(null)) {
				customerAddAttributeModel.setGroup("Promote to Group");
			}else {
				customerAddAttributeModel.setGroup("Demote to non-Group");
			}
			String action = "customer";
			List<CustomerAuxiliaryModel> auxiliaryFormField = orderPaymentService.getAuxiliaryFields(action);
			List<DropdownModel> addressType=customerSearchService.getaddressType();
			List<Map<String,Object>> addressStatus=customerSearchService.getfuterTempAddress(customerId);
			
			
			responseObject.put("auxiliaryformfeild", auxiliaryFormField);
			responseObject.put("addressType", addressType);
			responseObject.put("addressStatus", addressStatus);

			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/customerEditSubmit", method = RequestMethod.POST,headers = "Content-Type=application/x-www-form-urlencoded")
	public Map<String, Object> customerEditSubmit( CustomerAddAttributeModel customerAddAttributeModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerSearchService.editCustomer(customerAddAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;	
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(value="/searchCustomerBillToAddress", method = RequestMethod.POST)
	public  Map<String, Object> getSearchCustomerBillToAddress(@RequestParam("billTo") String billTo)
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Object> customerDetail = customerSearchService.getSearchCustomerBillTo(billTo);
			responseObject.put("customerDetail",customerDetail);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/addressHistory", method = RequestMethod.POST)
	public  Map<String, Object> addressHistory(@RequestParam(CUSTOMERID) Long customerId,@RequestParam("addrSeq") int addrSeq)
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
				List<Object> addressHistoryList = customerSearchService.getAddressHistory(customerId,addrSeq);
				responseObject.put("addressHistoryList",addressHistoryList);
				responseObject.put(STATUS,SUCCESS);
				return responseObject;
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/customerAddressAdd", method = RequestMethod.POST)
	public Map<String, Object> customerAddressAdd(@RequestParam(CUSTOMERID) Long customerId,@RequestParam("type") String type)
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			CustomerAddAttributeModel customerAddAttributeModel = new CustomerAddAttributeModel();
			customerAddAttributeModel.setCustomerId(customerId);
			customerAddAttributeModel.setStateList(customerSearchService.getStateList());
			customerAddAttributeModel.setAddressTypeList(customerSearchService.getaddressType());
			customerAddAttributeModel.setAddressStatusList(customerSearchService.getaddressStatus());
			customerAddAttributeModel.setTaxFilterList(customerSearchService.gettaxFilter());
			customerAddAttributeModel.setAddressType(customerSearchService.getdefaultAddressType());
			customerAddAttributeModel.setAddressStatus(customerSearchService.getdefaultAddressStatus());
			customerAddAttributeModel.setFutureOrTemp("0");
			responseObject.put(CUSTOMERADD, customerAddAttributeModel);
			String action = "customer_address";
			List<CustomerAuxiliaryModel> auxiliaryFormField = orderPaymentService.getAuxiliaryFields(action);
			responseObject.put("auxiliaryformfeild", auxiliaryFormField);
			responseObject.put("type", type);
			if("temp".equals(type)) {
				responseObject.put("EffectiveReverseDate", customerSearchService.getEffevtiveReverseDate(customerId));
			}
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(path = "/customerAddressAddSubmit", method = RequestMethod.POST)
	public  Map<String, Object> customerAddressAddSubmit(CustomerAddAttributeModel customerAddAttributeModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerSearchService.addAddress(customerAddAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/customerAddressEdit", method = RequestMethod.POST)
	public Map<String, Object> customerAddressEdit(@RequestParam(CUSTOMERID) Long customerId,@RequestParam("addressSeq") int addressSeq,@RequestParam("type") String type) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			CustomerAddAttributeModel customerAddAttributeModel = new CustomerAddAttributeModel();
			customerSearchService.getCustomerAddressDetailBySeqID(customerAddAttributeModel,customerId,addressSeq);
			customerAddAttributeModel.setStateList(customerSearchService.getStateList());
			customerAddAttributeModel.setAddressTypeList(customerSearchService.getaddressType());
			customerAddAttributeModel.setAddressStatusList(customerSearchService.getaddressStatus());
			customerAddAttributeModel.setTaxFilterList(customerSearchService.gettaxFilter());
			responseObject.put(CUSTOMERADD, customerAddAttributeModel);
			String action = "customer_address";
			List<CustomerAuxiliaryModel> auxiliaryFormField = orderPaymentService.getAuxiliaryFields(action);
			responseObject.put("auxiliaryformfeild", auxiliaryFormField);
			responseObject.put("type", type);
			if("temp".equals(type)) {
				responseObject.put("EffectiveReverseDate", customerSearchService.getEditEffevtiveReverseDate(customerId,addressSeq));
			}
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/customerAddressEditSubmit", method = RequestMethod.POST)
	public Map<String, Object> customerAddressEditSubmit(CustomerAddAttributeModel customerAddAttributeModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerSearchService.updateAddress(customerAddAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(value="/customerAttachmentFilter", method = RequestMethod.POST)
	public Map<String, Object> customerAttachmentFilter(@RequestParam(CUSTOMERID) Long customerId,@RequestParam(ATTACHMENTFILTER) int attachmentFilter)
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			
			List<Object> attachmentList = customerSearchService.getAttachment(customerId,attachmentFilter);
			responseObject.put("attachmentList", attachmentList);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/customerAttachment", method = RequestMethod.POST)
	public Map<String, Object> customerAttachment(@RequestParam(CUSTOMERID) Long customerId,@RequestParam(ATTACHMENTFILTER) int attachmentFilter)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<DropdownModel> attachmentFilterList = customerSearchService.getAttachmentFilterList(customerId);
			responseObject.put("attachmentFilterList", attachmentFilterList);
			List<Object> attachmentList = customerSearchService.getAttachment(customerId,attachmentFilter);
			responseObject.put("attachmentList", attachmentList);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/customerHistory", method = RequestMethod.POST)
	public Map<String, Object> customerHistory(@RequestParam(CUSTOMERID) Long customerId,@RequestParam("historyFilter") int historyFilter)

	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<CustomerHistoryModel> custHistoryList = customerSearchService.getCustomerHistory(customerId,historyFilter);
			responseObject.put("customerHistoryList",custHistoryList);
			responseObject.put(CUSTOMERID, customerId);
			responseObject.put("historyFilter", historyFilter);
			List<DropdownModel> historyFilterType = new ArrayList<>();
			historyFilterType.add(new DropdownModel("100","All",null,null,null,null));
			// See the sequences of theses fields in edit_trail table in THINK Data Model Document
			historyFilterType.add(new DropdownModel("0","Customer",null,null,null,null));
			historyFilterType.add(new DropdownModel("1","Address",null,null,null,null));
			historyFilterType.add(new DropdownModel("2","Prospect",null,null,null,null));//2 Customer Prospect 
			historyFilterType.add(new DropdownModel("3","Order",null,null,null,null));
			historyFilterType.add(new DropdownModel("4","Payment",null,null,null,null));
			historyFilterType.add(new DropdownModel("5","Demographics",null,null,null,null));
			historyFilterType.add(new DropdownModel("6","Order Amount Break",null,null,null,null));//6 Order Item Amount Break
			historyFilterType.add(new DropdownModel("7","Distribution",null,null,null,null)); //7 Cust. Addr. Distr
			historyFilterType.add(new DropdownModel("8","Subscrip",null,null,null,null)); 
			historyFilterType.add(new DropdownModel("9","Billing Options",null,null,null,null));//9 Order Item Install
			historyFilterType.add(new DropdownModel("10","Payment Account",null,null,null,null));
			historyFilterType.add(new DropdownModel("11","Service",null,null,null,null));
			
			historyFilterType.add(new DropdownModel("12","Subscription",null,null,null,null));
			historyFilterType.add(new DropdownModel("13","Single Issues",null,null,null,null));
			historyFilterType.add(new DropdownModel("14","Product",null,null,null,null));
			historyFilterType.add(new DropdownModel("15","Renewal Efforts",null,null,null,null));
			historyFilterType.add(new DropdownModel("16","Billing Efforts",null,null,null,null));
			historyFilterType.add(new DropdownModel("17","Promotion Efforts",null,null,null,null));
			historyFilterType.add(new DropdownModel("18","Units",null,null,null,null));
			responseObject.put("historyFilterType", historyFilterType);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;	
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/customerHistoryFilter", method = RequestMethod.POST)
	public Map<String, Object> customerHistoryFilter(@RequestParam(CUSTOMERID) Long customerId,@RequestParam("historyFilter") int historyFilter)

	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			responseObject.put("customerHistoryList", customerSearchService.getCustomerHistory(customerId,historyFilter));
			responseObject.put(STATUS,SUCCESS);
			return responseObject;	
			
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/customerNote", method = RequestMethod.POST)
	public Map<String, Object> customerNote(@RequestParam(CUSTOMERID) Long customerId)
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			 List<DropdownModel> noteFilterList = customerSearchService.getNoteFilterList(customerId);
			responseObject.put("noteFilterList", noteFilterList);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;	
			
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/customerNoteFilter", method = RequestMethod.POST)
	public Map<String, Object> customerNoteFilter(@RequestParam(CUSTOMERID) Long customerId,@RequestParam("noteFilter") int noteFilter,
			@RequestParam("paymentSeq") Optional<Integer> paymentSeq,Optional<Long> orderhdrId,Optional<Integer> orderItemSeq)

	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			responseObject.put("noteList",customerSearchService.getNote(customerId,noteFilter,paymentSeq,orderhdrId,orderItemSeq));
			Map<String,String> tableHeaders = new LinkedHashMap<>();
			tableHeaders.put("Creation Date","creation_date"); 
			tableHeaders.put("User Code","user_code"); 
            tableHeaders.put("Note Field","note_field"); 
			 switch (noteFilter) 
		        {
		            case 0: tableHeaders.put("Note Type","note_type"); 
				            tableHeaders.put("Customer Id","customer_id"); 
				            tableHeaders.put("Payment Seq","payment_seq"); 
				            tableHeaders.put("Service Seq","service_seq"); 
				            tableHeaders.put("Orderhdr Id","orderhdr_id"); 
				            tableHeaders.put("Order Item Seq","order_item_seq"); 
				            tableHeaders.put("Suspension Seq","suspension_seq"); 
				            tableHeaders.put("Subscrip Id","subscrip_id"); 
		                    break;
		            case 1: break;
		            case 2: tableHeaders.put("Subscrip Id","subscrip_id"); 
		                    break;
		            case 3: tableHeaders.put("Orderhdr Id","orderhdr_id"); 
				            tableHeaders.put("Order Item Seq","order_item_seq"); 
				            break;
		            case 4: tableHeaders.put("Payment Seq","payment_seq"); 
				            break;
		            case 5: tableHeaders.put("Suspension Seq","suspension_seq"); 
				            break;
		            case 6: tableHeaders.put("Service Seq","service_seq"); 
				            break;
		            default: break;
		        }
			responseObject.put("tableHeaders",tableHeaders);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;	
			
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/addNote", method = RequestMethod.POST)
	public Map<String, Object> noteAdd(@RequestParam(CUSTOMERID) Long customerId,@RequestParam("noteFilter") String noteFilter)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			NoteAddAttributeModel noteAddAttributeModel = new NoteAddAttributeModel();
			noteAddAttributeModel.setCustomerId(customerId);
			noteAddAttributeModel.setRecordList(customerSearchService.getNoteRecordList(customerId,noteFilter));
			responseObject.put("noteAdd", noteAddAttributeModel);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;	
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}

	}
	
	@RequestMapping(value="/addNoteSubmit", method = RequestMethod.POST)
	public Map<String, Object> noteAddSave(NoteAddAttributeModel noteAddAttributeModel)
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerSearchService.addNote(noteAddAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else 
				responseObject.put(STATUS, SUCCESS);	
			return responseObject;	
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/editNote", method = RequestMethod.POST)
	public Map<String, Object> noteEditSave(NoteAddAttributeModel noteAddAttributeModel)
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerSearchService.editNote(noteAddAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else 
				responseObject.put(STATUS, SUCCESS);	
			return responseObject;
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/deleteNote", method = RequestMethod.POST)
	public Map<String, Object> noteDelete(NoteAddAttributeModel noteAddAttributeModel)
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerSearchService.deleteNote(noteAddAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else 
				responseObject.put(STATUS, SUCCESS);
			return responseObject;
					
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/addAttachment", method = RequestMethod.POST)
	public Map<String, Object> attachmentAdd(@RequestParam(CUSTOMERID) Long customerId,@RequestParam(ATTACHMENTFILTER) String attachmentFilter,@RequestParam("userCode") String userCode)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			AttachmentAddAttributeModel attachmentAddAttributeModel = new AttachmentAddAttributeModel();
			attachmentAddAttributeModel.setAttachmentType(attachmentFilter);
			attachmentAddAttributeModel.setCustomerId(customerId);
			attachmentAddAttributeModel.setUserCode(userCode);
			attachmentAddAttributeModel.setRecordList(customerSearchService.getNoteRecordList(customerId,attachmentFilter));
			attachmentAddAttributeModel.setAttachmentCategoryList(customerSearchService.getAttachmentCategoryList());
			responseObject.put(ATTACHMENTADD, attachmentAddAttributeModel);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;	
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/addAttachmentSubmit", method = RequestMethod.POST)
	public Map<String, Object> attachmentAddSave(AttachmentAddAttributeModel attachmentAddAttributeModel)
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerSearchService.addAttachment(attachmentAddAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS,ERROR);
			else 
				responseObject.put(STATUS,SUCCESS);	
			return responseObject;	
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}

	@RequestMapping(value="/viewAttachment", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @RequestParam("attachmentId") String attachmentId) throws IOException {
		try {
			LinkedHashMap<String, byte[] > attachmentfile  = customerSearchService.getAttachmentFile(attachmentId);
			byte[] content=null;
			String fileName=null;
			for(Entry<String, byte[]> entry: attachmentfile.entrySet()) {
		         content = attachmentfile.get(entry.getKey());
		         fileName=entry.getKey();
		    }
			String mimeType= URLConnection.guessContentTypeFromName(fileName);
	        if(mimeType==null){
	            mimeType = "application/octet-stream";
	        }
	        response.setContentType(mimeType);
	        response.setHeader("Content-Disposition", String.format("inline; filename=\"%s\"",fileName));
			
	        if(content==null)
	        	content = Files.readAllBytes(new File(new PropertyUtilityClass().getConstantValue("attachmentLocation")+fileName).toPath());
				
	        response.setContentLength(content.length);
	        response.setHeader("Content-Disposition", String.format("inline; filename=\"%s\"",fileName));			 
	        FileCopyUtils.copy(content, response.getOutputStream());
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
		}
	}
     
	@RequestMapping(value="/deleteAttachment", method = RequestMethod.POST)
	public Map<String, Object> attachmentDelete(@RequestParam(CUSTOMERID) Long customerId,@RequestParam("attachmentId") String attachmentId)
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerSearchService.deleteAttachment(attachmentId);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else 
				responseObject.put(STATUS, SUCCESS);	
			return responseObject;	
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@RequestMapping(value="/editAttachment", method = RequestMethod.POST)
	public Map<String, Object> attachmentEditSave(@ModelAttribute(ATTACHMENTADD) AttachmentAddAttributeModel attachmentAddAttributeModel)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerSearchService.editAttachment(attachmentAddAttributeModel);
			if(ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else 
				responseObject.put(STATUS, SUCCESS);		
			return responseObject;	
		} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	

	@RequestMapping(value="/customerAuxiliaryAdd", method = RequestMethod.POST)
	public Map<String, Object> customerAuxiliaryAdd(@RequestParam(CUSTOMERID) Long customerId)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, String> map = null;
		List<Map<String, String>> finalMap = new ArrayList<Map<String,String>>(); 
		try {
			
			List<CustomerAuxiliaryModel> auxiliaryFormField = customerSearchService.getCustomerAuxiliaryFormField();
			new PropertyUtilityClass().appendDefaultDateInAuxiliaryFields(auxiliaryFormField);
			responseObject.put("auxiliaryformfeild", auxiliaryFormField);
			if(customerId==null) {
				Long maxCustomerId = jdbcTemplate.queryForObject("select max(customer_id) from customer", Long.class);
				customerId = maxCustomerId;
			}
			LinkedHashMap<String, String> customerAuxiliaryDetail = customerSearchService.setCustomerAuxiliaryDetailByID(customerId);
			//Getting the Set of entries 
	        Set<Entry<String, String>> entrySet = customerAuxiliaryDetail.entrySet(); 
	        //Creating an ArrayList Of Entry objects 
	        List<Entry<String, String>> auxiliaryFieldDetails = new ArrayList<Entry<String,String>>(entrySet); 
	        int length = auxiliaryFieldDetails.size();
	        for(int i=0;i<length;i++) {
	        	map = new LinkedHashMap<String, String>();
	        		if(auxiliaryFormField.get(i).getColumnName().equals(auxiliaryFieldDetails.get(i).getKey())) {
	        			if(auxiliaryFieldDetails.get(i).getValue() == null) {// to set default value for date column
	        				map.put(auxiliaryFieldDetails.get(i).getKey(), auxiliaryFormField.get(i).getDefaultValue());
	        		   }else {
	        			   map.put(auxiliaryFieldDetails.get(i).getKey(), auxiliaryFieldDetails.get(i).getValue());
	        		   }
	        			if(auxiliaryFormField.get(i).getColumnDatatype().equalsIgnoreCase("Numeric") ) {
	        				if(auxiliaryFieldDetails.get(i).getValue()!=null) {
	        					String value = auxiliaryFieldDetails.get(i).getValue();
	        					String finalValue = new PropertyUtilityClass().removeZeroFromAuxiliary(value);
	            				map.put(auxiliaryFieldDetails.get(i).getKey(), finalValue);
	        				}
	        			}
	        			map.put("columnDatatype", auxiliaryFormField.get(i).getColumnDatatype());
	        			map.put("columnLength", auxiliaryFormField.get(i).getColumnLength());
	        			map.put("columnPrecision", auxiliaryFormField.get(i).getColumnPrecision());
	        			finalMap.add(map);
	        		}
	        }
			responseObject.put("customerAuxiliaryDetail", finalMap);
			responseObject.put(CUSTOMERID, customerId);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}

	@RequestMapping(value="/customerAuxiliaryAddSubmit", method = RequestMethod.POST)
	public Map<String, Object> customerAuxiliaryAddSubmit(HttpServletRequest request)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerSearchService.saveCustomerAuxiliary(request);
			if(status.contains(ERROR))
				responseObject.put(STATUS, status);
			else {
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(value="/customerDeleteAddress", method = RequestMethod.POST)
	public Map<String, Object> customerDeleteAddress(Long customerId , String customerAddressSeq){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		String status = null;
		try {
				if(Objects.nonNull(customerAddressSeq) && !customerAddressSeq.equals("")) {
					status = customerSearchService.deleteAddress(customerId,customerAddressSeq);
				}
				if(status.equals("Deleted"))
					responseObject.put(STATUS, SUCCESS);
				else {
					responseObject.put(STATUS, ERROR);
				}
			    return responseObject;		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(value="/getDocumentReferenceDetail", method = RequestMethod.POST)
	public Map<String, Object> getDocumentReferenceDetail(@RequestParam("documentReferenceId") Long documentReferenceId)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			responseObject.put("documentReferenceDetailList", customerSearchService.getDocumentReferenceDetailList(documentReferenceId));
			responseObject.put(STATUS, SUCCESS);
			return responseObject;		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(value="/getEditTrialOnDocumentReference", method = RequestMethod.POST)
	public Map<String, Object> getEditTrialOnDocumentReference(@RequestParam("editTrialId") Long editTrialId)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			responseObject.put("editTrialList", customerSearchService.getEditTrialList(editTrialId));
			responseObject.put(STATUS, SUCCESS);
			return responseObject;		
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(value="/clearAddressInfo", method = RequestMethod.POST)
	public Map<String, Object> clearAddressInfo(@RequestParam(CUSTOMERID) Long customerId)

	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String status = customerSearchService.clearAddInfo(customerId);
			if(ERROR.equals(status)) {
				responseObject.put(STATUS,ERROR);
				responseObject.put("AddClearInfo","Error in trigger tu_customer_address 50003:"+"state"+" does not exist. Cannot modify child in "+"customer_address");
			}
			else {
				responseObject.put("AddClearInfo", status);
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/isProspect", method = RequestMethod.POST)
	public Map<String, Object> getIsProspect() {
		Map<String, Object> responseObject = new LinkedHashMap<>();		
		try {
			List<ProspectModel> isProspect = customerSearchService.getIsProspect();
			responseObject.put("isProspect", isProspect);
			List<DropdownModel> orderClass = customerOrderService.getorderClass();
			responseObject.put("orderClass", orderClass);
			List<DropdownModel> prospectCategory = customerSearchService.getProspectCategory();
			responseObject.put("prospectCategory", prospectCategory);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}
	
		
		//Added by Sohrab for fetching business process(es) of Email Authorization
		@RequestMapping(path = "/emailAuthorizationRetrieve", method = RequestMethod.POST)
		public Map<String, Object> retrieveEmailAuthorization(@RequestParam("customer_id") Long customerId) 
		{
			Map<String, Object> responseObject = new LinkedHashMap<>();
			try 
			{
				Map<Integer,String>business_processes_mapping=new HashMap<Integer,String>();
				business_processes_mapping.put(1, "Label");
				business_processes_mapping.put(2, "Renewal Effort");
				business_processes_mapping.put(3, "Billing Effort");
				business_processes_mapping.put(4, "Promotion Effort");
				business_processes_mapping.put(5, "Form Letter");
				business_processes_mapping.put(6, "Order Item Added");
				business_processes_mapping.put(7, "Payment Added");
				business_processes_mapping.put(8, "Order Canceled");
				business_processes_mapping.put(9, "Order Renewed");
				business_processes_mapping.put(10, "Password Send");
				business_processes_mapping.put(12, "Credit Card Failed");
				business_processes_mapping.put(13, "Email Changed");
				business_processes_mapping.put(14, "Package Order Added");
				business_processes_mapping.put(15, "Whole Order Added");
				business_processes_mapping.put(16, "Package Renewed");
				business_processes_mapping.put(17, "Password Changed");
				business_processes_mapping.put(18, "Credit Card Expiry Imminent");
				business_processes_mapping.put(19, "Login Locked Out");
				business_processes_mapping.put(20, "Auto-Renewal Imminent");
				business_processes_mapping.put(21, "Auto-Renewal Failure");
				business_processes_mapping.put(22, "Suspension Activated");
				business_processes_mapping.put(23, "Suspension Completed");
				business_processes_mapping.put(24, "Renewal Status Changed");
				business_processes_mapping.put(25, "Subscr. ExpireDate Changed");
				business_processes_mapping.put(26, "Subscr. IssuesLeft Changed");
				business_processes_mapping.put(27, "Payment Account Changed");
				business_processes_mapping.put(28, "Subscr. Bundle Quantity Changed");
				business_processes_mapping.put(29, "Customer Added");
				business_processes_mapping.put(30, "Customer Changed");
				business_processes_mapping.put(31, "Customer Login Added");
				business_processes_mapping.put(32, "Registration Email Send");
				business_processes_mapping.put(33, "Login Email Send");
				business_processes_mapping.put(34, "Product Shipped");
				business_processes_mapping.put(35, "IP Address Changed");
				business_processes_mapping.put(36, "Deposit Used");
				business_processes_mapping.put(37, "Group Member Added");
				business_processes_mapping.put(38, "Group Member Removed");
				/*THINKDEV-1045, 1010: Done to retrieve Default email_authorization*/
				String default_email_authorization = customerSearchService.retrieveDefaultEmailAuthorization();
				if(customerId==null)
				{
					if(ERROR.equals(default_email_authorization))
					{
						responseObject.put(STATUS, ERROR);
					}else
					{
						responseObject.put("Restore Defaults", default_email_authorization);
						responseObject.put("businessProcessesMappingWithIds", business_processes_mapping);
						responseObject.put(STATUS, SUCCESS);
					}
				}else 
				{
					String email_authorization = customerSearchService.retrieveEmailAuthorization(customerId);
					if(ERROR.equals(email_authorization))
					{
						responseObject.put(STATUS, ERROR);
					}
					else if(email_authorization.equals("Customer Id does not exist in database."))
					{
						responseObject.put(STATUS, "Customer Id does not exist in database.");
					}
					else 
					{
						responseObject.put("Business Process(es) selected in Email Authorization", email_authorization);
						if(ERROR.equals(default_email_authorization))
						{
							responseObject.put("Restore Defaults", "Some error occurred in Restore Defaults.");
						}else
						{
							responseObject.put("Restore Defaults", default_email_authorization);
						}
						responseObject.put("businessProcessesMappingWithIds", business_processes_mapping);
						responseObject.put(STATUS, SUCCESS);
					}
				}
				return responseObject;
			} catch (Exception e) 
			{
				LOGGER.error(ERROR + e);
				e.printStackTrace();
				responseObject.put(STATUS,ERROR);
				return responseObject;
			}
		}
		
		
		
		//Added by Sohrab for saving business process(es) of Email Authorization
		@RequestMapping(path = "/emailAuthorizationSave", method = RequestMethod.POST)
		public Map<String, Object> updateEmailAuthorization(@RequestParam("customer_id") Long customerId,@RequestParam("business_processes") String business_processes) 
		{
			Map<String, Object> responseObject = new LinkedHashMap<>();
			try 
			{
				String status=customerSearchService.updateEmailAuthorization(customerId,business_processes);
				if(ERROR.equals(status))
				{
					responseObject.put(STATUS, ERROR);
				}
				else 
				{
					responseObject.put(STATUS, status);
				}
				return responseObject;
			} catch (Exception e) 
			{
				LOGGER.error(ERROR + e);
				e.printStackTrace();
				responseObject.put(STATUS,ERROR);
				return responseObject;
			}
		}
		
		
		//Added by Sohrab for Distributor Accounts List
		@RequestMapping(path = "/ListOfDistributorAccounts", method = RequestMethod.POST)
		public Map<String, Object> retrieveDistributorAccountsList() 
		{
			Map<String, Object> responseObject = new LinkedHashMap<>();
			try 
			{
				List<DistributorAccountsModel> distributorAccountsList = customerSearchService.retrieveDistributorAccountsList();
				responseObject.put("distributorAccountsList",distributorAccountsList);
				responseObject.put(STATUS,SUCCESS);
				return responseObject;
			}catch (Exception e) 
			{
				LOGGER.error(ERROR + e);
				e.printStackTrace();
				responseObject.put(STATUS,ERROR);
				return responseObject;
			}
		}
		
		
		
		//Added by Sohrab for EDITING Distributor INFO
		@RequestMapping(path = "/DistributorInfoUpdate", method = RequestMethod.POST)
		public Map<String, Object> updateDistributorInfo(CustomerAddAttributeModel customerAddAttributeModel) 
		{
			Map<String, Object> responseObject = new LinkedHashMap<>();
			try 
			{
				if(customerAddAttributeModel.getCustomerId()>0)
				{
					String response = customerSearchService.updateDistributorInfo(customerAddAttributeModel);
					responseObject.put(STATUS,response);
				}else
				{
					responseObject.put(STATUS,"Customer Id (for a distributor) is not valid.");
				}
				return responseObject;
			}catch (Exception e) 
			{
				LOGGER.error(ERROR + e);
				e.printStackTrace();
				responseObject.put(STATUS,ERROR);
				return responseObject;
			}
		}
		
		
		//Added by Sohrab TO CREATE Distributor Report
		@RequestMapping(path = "/DistributorReportAdd", method = RequestMethod.POST)
		public Map<String, Object> addDistributorReport(CustomerAddAttributeModel customerAddAttributeModel) 
		{
			Map<String, Object> responseObject = new LinkedHashMap<>();
			try 
			{
				if(customerAddAttributeModel.getCustomerId()>0)
				{
					String response = customerSearchService.addDistributorReport(customerAddAttributeModel);
					responseObject.put(STATUS,response);
				}else
				{
					responseObject.put(STATUS,"Customer Id (for a Distributor Report) is not valid.");
				}
				return responseObject;
			}catch (Exception e) 
			{
				LOGGER.error(ERROR + e);
				e.printStackTrace();
				responseObject.put(STATUS,ERROR);
				return responseObject;
			}
		}
		
		
				//Added by Sohrab to READ Distributor Report List
				@RequestMapping(path = "/ListOfDistributorReport", method = RequestMethod.POST)
				public Map<String, Object> retrieveDistributorReportsList(Long customer_id) 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						List<DistributorReportModel> distributorReportsList = customerSearchService.retrieveDistributorReportsList(customer_id);
						responseObject.put("distributorReportsList",distributorReportsList);
						responseObject.put(STATUS,SUCCESS);
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				 }
				
				
				
				//Added by Sohrab TO UPDATE Distributor Report
				@RequestMapping(path = "/DistributorReportUpdate", method = RequestMethod.POST)
				public Map<String, Object> updateDistributorReport(CustomerAddAttributeModel customerAddAttributeModel) 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						if(customerAddAttributeModel.getCustomerId()>0)
						{
							String response = customerSearchService.updateDistributorReport(customerAddAttributeModel);
							responseObject.put(STATUS,response);
						}else
						{
							responseObject.put(STATUS,"Customer Id (for a Distributor Report) is not valid.");
						}
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				}
				
				
				
				//Added by Sohrab TO DELETE Distributor Report
				@RequestMapping(path = "/DistributorReportDelete", method = RequestMethod.POST)
				public Map<String, Object> deleteDistributorReport(CustomerAddAttributeModel customerAddAttributeModel) 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						if(customerAddAttributeModel.getCustomerId()>0)
						{
							String response = customerSearchService.deleteDistributorReport(customerAddAttributeModel);
							responseObject.put(STATUS,response);
						}else
						{
							responseObject.put(STATUS,"Customer Id (for a Distributor Report) is not valid.");
						}
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				}
				
				
				//Added by Sohrab for Distributor Attribute Set Up Data List
				@RequestMapping(path = "/ListOfDistributorAttributeSetUpData", method = RequestMethod.POST)
				public Map<String, Object> retrieveDistributorAttributeSetUpData() 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						List<DistributorAttributeSetUpModel> distributorAttributeSetUpDataList = customerSearchService.retrieveDistributorAttributeSetUpData();
						responseObject.put("distributorAttributeSetUpDataList",distributorAttributeSetUpDataList);
						responseObject.put(STATUS,SUCCESS);
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				 }
				
				
				
				//Added by Sohrab to CREATE Distributor Attribute
				@RequestMapping(path = "/DistributorAttributeAdd", method = RequestMethod.POST)
				public Map<String, Object> addDistributorAttribute(CustomerAddAttributeModel customerAddAttributeModel) 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						if(customerAddAttributeModel.getCustomerId()>0)
						{
							String response = customerSearchService.addDistributorAttribute(customerAddAttributeModel);
							responseObject.put(STATUS,response);
						}else
						{
							responseObject.put(STATUS,"Customer Id (for a Distributor Report) is not valid.");
						}
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				}
				
				
				
				//Added by Sohrab to READ Distributor Attribute 
				@RequestMapping(path = "/ListOfDistributorAttribute", method = RequestMethod.POST)
				public Map<String, Object> retrieveDistributorAttribute(Long customer_id) 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						List<DistributorAttributeSetUpModel> distributorAttributesList = customerSearchService.retrieveDistributorAttribute(customer_id);
						responseObject.put("distributorAttributesList",distributorAttributesList);
						responseObject.put(STATUS,SUCCESS);
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				 }
				
				
				
				//Added by Sohrab to UPDATE Distributor Attribute
				@RequestMapping(path = "/DistributorAttributeUpdate", method = RequestMethod.POST)
				public Map<String, Object> updateDistributorAttribute(CustomerAddAttributeModel customerAddAttributeModel) 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						if(customerAddAttributeModel.getCustomerId()>0)
						{
							String response = customerSearchService.updateDistributorAttribute(customerAddAttributeModel);
							responseObject.put(STATUS,response);
						}else
						{
							responseObject.put(STATUS,"Customer Id (for a Distributor Report) is not valid.");
						}
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				}

				
				//Added by Sohrab TO DELETE Distributor Attribute
				@RequestMapping(path = "/DistributorAttributeDelete", method = RequestMethod.POST)
				public Map<String, Object> deleteDistributorAttribute(CustomerAddAttributeModel customerAddAttributeModel) 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						if(customerAddAttributeModel.getCustomerId()>0)
						{
							String response = customerSearchService.deleteDistributorAttribute(customerAddAttributeModel);
							responseObject.put(STATUS,response);
						}else
						{
							responseObject.put(STATUS,"Customer Id (for a Distributor Report) is not valid.");
						}
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				}
				
				
				@RequestMapping(value = "/getDistributorAccountLeftPanel", method = RequestMethod.POST)
				public Map<String, Object> getDistributorAccount(String customerId) {
					Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
					try {

						List<DistributorChildModel> getDistributorAccount = customerSearchService.getDistributorAccount(customerId);
						responseObject.put("getDistributorAccount", getDistributorAccount);

						List<DistributorChildModel> getDistributorAccChildList =customerSearchService.getDistributorAccChildList(); 
						responseObject.put("getDistributorAccChildList ",getDistributorAccChildList );
						
						
						responseObject.put(STATUS, SUCCESS);
						return responseObject;

					} catch (Exception e) {
						LOGGER.error(ERROR + e);
						responseObject.put(STATUS, ERROR);
						return responseObject;
					}

				}
				

				@RequestMapping(path = "/distributorAccountSetupLeftPanel", method = RequestMethod.POST)
				public Map<String, Object> getdistributorAccountSetup() {
					Map<String, Object> responseObject = new HashMap<>();
                 
					try {
						 LeftPanelCustomerServiceModel Model = new  LeftPanelCustomerServiceModel();
						 Model.setId(0);
						 Model.setTitle("distributor Accounts");
						 
					    DistributorAccountsModel distModel=new  DistributorAccountsModel();
			        
						 distModel.setParent_distributor_id("Root distributor");
						 distModel.setUrl("");
						 distModel.setDistributor_report_prefix("");
						 Model.setData(distModel);
						
						 Model.setNodes(customerSearchService.getDistributorAccChildList());
						 List<LeftPanelCustomerServiceModel> leftPanel=new ArrayList<>();
                         leftPanel.add(Model);
						
                         responseObject.put("leftPanelMenuData",leftPanel);
						 responseObject.put(STATUS, SUCCESS);
						return responseObject;
					} catch (Exception e) {
						LOGGER.info("Error in getCustomerService(): " + e);
						responseObject.put(STATUS, ERROR + e);
						return responseObject;
					}
				}	
				
				@RequestMapping(value = "/getDistAccountDetails", method = RequestMethod.POST)
				public Map<String, Object> getDistAccountDetails(String customerId) {
					Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
					try {

						List<Map<String, Object>> getDistAccountDetails =customerSearchService.getDistAccountDetails(customerId);
						responseObject.put("getDistAccountDetails",getDistAccountDetails);

						responseObject.put(STATUS, SUCCESS);
						return responseObject;

					} catch (Exception e) {
						LOGGER.error(ERROR + e);
						responseObject.put(STATUS, ERROR);
						return responseObject;
					}

				}
				
				
				
				//Added by Sohrab for Distributor Report Grid Output Options Data
				@RequestMapping(path = "/ListOfDistributorReportGridOutputOptionsData", method = RequestMethod.POST)
				public Map<String, Object> retrieveDistributorReportGridOutputOptionsData() 
				{
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try 
					{
						List<DistributorReportOutputOptionsModel> distributorReportGridOutputOptionsDataList = customerSearchService.retrieveDistributorReportGridOutputOptionsData();
						responseObject.put("distributorReportOutputOptionsList",distributorReportGridOutputOptionsDataList);
						responseObject.put(STATUS,SUCCESS);
						return responseObject;
					}catch (Exception e) 
					{
						LOGGER.error(ERROR + e);
						e.printStackTrace();
						responseObject.put(STATUS,ERROR);
						return responseObject;
					}
				 }
				
				@RequestMapping(path = "/matchCodes", method = RequestMethod.POST)
				public Map<String, Object> getMatchCodes(int customerId, int customerAddressSeq) {
					Map<String, Object> responseObject = new LinkedHashMap<>();
					try {
						List<Map<String, Object>> matchCodesDetail = customerSearchService.getMatchCodes(customerId, customerAddressSeq);
						responseObject.put("matchCodesDetail", matchCodesDetail);
						responseObject.put(STATUS, SUCCESS);
						return responseObject;
					} catch (Exception e) {
						LOGGER.error(ERROR + e);
						responseObject.put(STATUS, ERROR);
						return responseObject;
					}
				}
				
}