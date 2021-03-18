package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mps.think.model.ComplaintServiceModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.OrderCode;
import com.mps.think.model.SourceCode;
import com.mps.think.orderFunctionality.service.OrderFunctionalityService;
import com.mps.think.service.CustomerOrderService;
import com.mps.think.serviceImpl.OrderSourceOfferServicesImpl;

@RestController
@RequestMapping("order")
public class OrderSourceOfferCodeController {
	private static Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSourceOfferCodeController.class);
	
	@Autowired
	OrderSourceOfferServicesImpl orderSourceOfferService;
	
	@Autowired
	CustomerOrderService customerOrderService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(path="/orderCode", method = RequestMethod.POST)
	public  Map<String, Object> getOrderCode(@RequestParam("orderCodeType") String orderCodeType){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
		try{			
			List<OrderCode> orderCodeList =orderSourceOfferService.getOrderCode(orderCodeType);	
			responseObject.put("orderCodeList", orderCodeList);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e){
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
		
	}
	
	@RequestMapping(path="/sourceCode", method = RequestMethod.POST)
	public  Map<String, Object> getSourceCode(@RequestParam("ocId") String ocId){
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
		 List<SourceCode> sourceCodeList = null;
		try{
			if(ocId != null) {
			sourceCodeList=orderSourceOfferService.getSourceCode(ocId);
			responseObject.put("sourceCodeList", sourceCodeList);
			String audited =jdbcTemplate.queryForObject("select audited from pub where oc_id="+ocId, String.class);
			responseObject.put("audited", audited);
			}
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e){
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		}
		
	    
	}	
	
	@RequestMapping(path="/orderCodesget")
	public String getOrder(@RequestParam("orderCodeType") String orderCodeType, Model model){
		List<OrderCode> orderCodeList=new ArrayList<>();
		try{			
			orderCodeList=orderSourceOfferService.getOrderCode(orderCodeType);
			model.addAttribute("orderCodeList",gson.toJson(orderCodeList));			
		}catch(Exception e){
			LOGGER.error(ERROR +e);
		}
		return "";
	}
	
	
	
	@RequestMapping(value="/orderCodeFilter", method = RequestMethod.GET)
	public @ResponseBody String orderCodeFilter(@RequestParam("orderCodeType") String orderCodeType)
	{
		List<OrderCode> orderCodeList=new ArrayList<>();
		try {
			
			orderCodeList = orderSourceOfferService.getOrderCode(orderCodeType);
			
		} catch (Exception e) {
			LOGGER.error(ERROR +e);
		}
		return  gson.toJson(orderCodeList);

	}
	
	
	@RequestMapping(path="/orderComplaintData", method = RequestMethod.POST)
	public Map<String, Object> orderComplaint(int orderId, int customerId,int subscripId, String complaintCode,int orderItemSeq,int orderItemType,int serviceFilter){
	Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
	{
		List <DropdownModel> causeCodeData=new ArrayList<>();
		List <DropdownModel> complaintCodeData=new ArrayList<>();
		List <DropdownModel> serviceCodeData=new ArrayList<>();
		List <DropdownModel> getServiceCodeTemplateData=new ArrayList<>();
		List<DropdownModel> selectRecord=new ArrayList<>();
		List<Map<String, Object>> addServiceData= new ArrayList <Map<String, Object>>();
		List<Map<String, Object>> getSelectedData= new ArrayList <Map<String, Object>>();
		try {
			Map<String, Object> serviceSeq = orderSourceOfferService.getServiceSeq(customerId);
			causeCodeData = orderSourceOfferService.getCauseCode();
			complaintCodeData = orderSourceOfferService.getComplaintCode();
			serviceCodeData = orderSourceOfferService.getServiceCode();
			getServiceCodeTemplateData= orderSourceOfferService.getServiceCodeTemplate();
			getSelectedData = orderSourceOfferService.getSelectedData(complaintCode);
			addServiceData = orderSourceOfferService.getDataAddService(customerId, orderId, orderItemSeq, orderItemType, subscripId);
			selectRecord= orderSourceOfferService.getselectRecord(customerId, serviceFilter);
			responseObject.put("CauseCode", causeCodeData);
			responseObject.put("ComplaintCode", complaintCodeData);
			responseObject.put("ServiceCode", serviceCodeData);
			responseObject.put("ServiceCodeTemplate", getServiceCodeTemplateData);
			responseObject.put("defServiceData", addServiceData);
			responseObject.put("ServiceSeq", serviceSeq);
			responseObject.put("selectedData", getSelectedData);
			responseObject.put("SelectRecord", selectRecord);
			responseObject.put("senEmailButton", orderSourceOfferService.getEmail(customerId));
			
			
		} catch (Exception e) {
			LOGGER.error(ERROR +e);
		}
		return responseObject;

	}
	}
	
	
	@RequestMapping(path= "/serviceSave", method =RequestMethod.POST )
	public Map<String, Object> serviceSave(ComplaintServiceModel complaintServiceModel,int serviceFilter,int orderItemType){
		boolean status  = false;
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			status = orderSourceOfferService.saveService(complaintServiceModel, serviceFilter, orderItemType);
			
				 responseObject.put(STATUS,status);
				 return responseObject;
		}
		 catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
	}
	
	
	@RequestMapping(path= "/updateService", method =RequestMethod.POST )
	public Map<String, Object> updateService(ComplaintServiceModel complaintServiceModel){
		boolean status  = false;
		 Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{
			status = orderSourceOfferService.updateService(complaintServiceModel);
			
				 responseObject.put(STATUS,status);
				 return responseObject;
		}
		 catch(Exception e){
			 LOGGER.error(ERROR + e);
			 responseObject.put(STATUS,ERROR+e);
			 return responseObject;
		 }
	}
	
	
	
	@RequestMapping(path = "/serviceDetails", method = RequestMethod.POST)
	public Map<String, Object> ServiceDetails(@RequestParam("customerId")int customerId)
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
		List<DropdownModel> serviceFilterList = new ArrayList<DropdownModel>();
		serviceFilterList = orderSourceOfferService.getCondetionCheckServiceFilter(customerId); 
		responseObject.put("ServiceFilter", serviceFilterList);
		responseObject.put(STATUS, SUCCESS);
		return responseObject;
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
		
	}
	
	
	
	@RequestMapping(path = "/serviceData", method = RequestMethod.POST)
	public Map<String, Object> ServiceFilterData(@RequestParam("customerId")int customerId,
			@RequestParam("serviceFilter") int serviceFilter, @RequestParam("orderItemType") int orderItemType){
		
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			
			List<Object> serviceFilterDetail = orderSourceOfferService.getServiceFilterData(customerId,serviceFilter,orderItemType );
			responseObject.put("ServiceFilterData", serviceFilterDetail);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
			
		}
		catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
			
		}
	}
	
	
	@RequestMapping(path = "/rowCountValue", method = RequestMethod.POST)
	public Map<String, Object> RowCountValue(@RequestParam("customer_id")int customer_id) {
		String rowCount="";
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			rowCount = orderSourceOfferService.getRowCountValue(customer_id);
			responseObject.put("rowCount", rowCount);
			responseObject.put(STATUS, SUCCESS);
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			
		}
		return responseObject;
		
		
	}
	
	@RequestMapping(path = "/showDisplayForUpdate", method = RequestMethod.POST)
	public Map<String, Object> ShowDataForUpdate(@RequestParam("customerId")int customerId, @RequestParam("serviceSeq")int serviceSeq,@RequestParam("serviceFilter")int serviceFilter) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		
		try {
			List <DropdownModel> causeCodeData=new ArrayList<>();
			List <DropdownModel> complaintCodeData=new ArrayList<>();
			List <DropdownModel> serviceCodeData=new ArrayList<>();
			List<DropdownModel> selectRecord=new ArrayList<>();
			List <DropdownModel> getServiceCodeTemplateData=new ArrayList<>();
			List<ComplaintServiceModel> showDataForUpdate = orderSourceOfferService.getShowDataForUpdate(customerId,serviceSeq,serviceFilter);
			causeCodeData = orderSourceOfferService.getCauseCode();
			getServiceCodeTemplateData= orderSourceOfferService.getServiceCodeTemplate();
			complaintCodeData = orderSourceOfferService.getComplaintCode();
			serviceCodeData = orderSourceOfferService.getServiceCode();
			selectRecord= orderSourceOfferService.getselectRecord(customerId, serviceFilter);
			responseObject.put("ShowDataForUpdate", showDataForUpdate);
			responseObject.put("CauseCode", causeCodeData);
			responseObject.put("ComplaintCode", complaintCodeData);
			responseObject.put("ServiceCode", serviceCodeData);
			responseObject.put("ServiceCodeTemplate", getServiceCodeTemplateData);
			responseObject.put("selectRecord", selectRecord);
			responseObject.put(STATUS, SUCCESS);
			
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			
		}
		return responseObject;	
	}
	
	@RequestMapping(value="/serviceHistory", method = RequestMethod.POST)
	public  Map<String, Object> serviceHistory(@RequestParam("customerId") Long customerId,@RequestParam("serviceSeq") int serviceSeq)
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
				List<Object> serviceHistoryList = orderSourceOfferService.getServiceHistory(customerId,serviceSeq);
				responseObject.put("serviceHistoryList",serviceHistoryList);
				responseObject.put(STATUS,SUCCESS);
				return responseObject;
			} catch (Exception e) {
				LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR);
				return responseObject;
		}
	}
	
	@PostMapping("/serviceComplaintButton")
	public Map<String, Object> serviceComplaintButton(String complaintCode,String serviceCode,String causeCode, String action){
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			 switch(action.toLowerCase()) {
			 case "complaint":
				 if((complaintCode != null | !"".equals(complaintCode)) && action.equalsIgnoreCase("complaint")) {
						List <DropdownModel> selectedComplaintCode = orderSourceOfferService.getSelectedServiceComplaintCode(complaintCode);
						responseObject.put("selectedComplaintCode", selectedComplaintCode);
					}else{
						responseObject.put("selectedComplaintCode", "You must enter acomplaint code.");
					}
				 break;
			 case "service":
				 if( (serviceCode !=null | !"".equals(serviceCode)) && action.equalsIgnoreCase("service") ) {
						List<DropdownModel>selectedServiceCode = orderSourceOfferService.getSelectedServiceServiceCode(serviceCode);
						responseObject.put("selectedServiceCode", selectedServiceCode);
					}else {
						List<DropdownModel>selectedServiceCode = orderSourceOfferService.getSelectedServiceServiceCode(serviceCode);
						responseObject.put("selectedServiceCode", selectedServiceCode);
					}
				 break;
			 case "cause":
				 if( (causeCode !=null | !"".equals(causeCode)) && action.equalsIgnoreCase("cause") ){
					    List<DropdownModel>selectedCauseCode = orderSourceOfferService.getSelectedServiceCauseCode(causeCode);
						responseObject.put("selectedCauseCode", selectedCauseCode);
					}else {
						List<DropdownModel>selectedCauseCode = orderSourceOfferService.getSelectedServiceCauseCode(causeCode);
						responseObject.put("selectedCauseCode", selectedCauseCode);
					}
				 break;
			 }
			List<DropdownModel>templateData = orderSourceOfferService.getServiceCodeTemplate();
			responseObject.put("templateData", templateData);
			
			return responseObject;
		}catch (Exception e) {     
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/catalogSource", method = RequestMethod.POST)
	public  Map<String, Object> getCatalogSource(String sourceCode ,String orderClass, String generated){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		String msg = null;
		try{			
			List<SourceCode> catalogCodeList = orderSourceOfferService.getCatalogSource(sourceCode ,orderClass, generated);	
			msg="A general system error has occurred, Use Copy to Clipboard to copy the detail to the clipboard and forward the results to Support for assistance";
			List<DropdownModel> orderClass1 = customerOrderService.getorderClass();
			List<DropdownModel> generate = orderSourceOfferService.getGenerated();
			if(!catalogCodeList.isEmpty()) {
				responseObject.put("catalogCodeList", catalogCodeList);
			}else {
				catalogCodeList.clear();
				responseObject.put("catalogCodeList", catalogCodeList);
				responseObject.put("msg", msg);
			}
			responseObject.put("orderClass", orderClass1);
			responseObject.put("generated", generate);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e){
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
	
	@RequestMapping(path="/catalogOrder", method = RequestMethod.POST)
	public  Map<String, Object> getCatalogOrder(String sourceCodeId, String orderCode ,String orderClass,String orderCodeType,String term){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try{			
			List<OrderCode> catalogOrderList = orderSourceOfferService.getCatalogOrder(sourceCodeId, orderCode , orderClass, orderCodeType, term);	
			List<DropdownModel> orderClass1 = customerOrderService.getorderClass();
			List<DropdownModel> orderCodetype=customerOrderService.getOrderCode();	
			List<DropdownModel> orderTerm=customerOrderService.getOrderTerm();
			String msg = "A general system error has occurred, Use Copy to Clipboard to copy the detail to the clipboard and forward the results to Support for assistance";
			if(!catalogOrderList.isEmpty()) {
				responseObject.put("catalogOrderList", catalogOrderList);
			}else {
				catalogOrderList.clear();
				responseObject.put("catalogOrderList", catalogOrderList);
				responseObject.put("msg", msg);
			}
			responseObject.put("orderCodetype",orderCodetype);
			responseObject.put("orderTerm",orderTerm);			 
			responseObject.put("orderClass", orderClass1);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e){
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS,ERROR+e);
			return responseObject;
		}
	}
}
