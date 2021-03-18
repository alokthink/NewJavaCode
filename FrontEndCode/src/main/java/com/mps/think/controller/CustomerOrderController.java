package com.mps.think.controller;
import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.model.BasicPackageItemModel;
import com.mps.think.model.CustomerAddressDistributionModel;
import com.mps.think.model.CustomerAuxiliaryModel;
import com.mps.think.model.CustomerDistributionValuesModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mps.think.daoImpl.OrderSourceOfferDaoImpl;
import com.mps.think.model.AgencyAttributeModel;
import com.mps.think.model.BackIssuesModel;
import com.mps.think.model.CustomerOrderModel;
import com.mps.think.model.DistributionAttributeModel;
import com.mps.think.model.DistributionMethodModel;
import com.mps.think.model.DistributionValueModel;
import com.mps.think.model.DropdownModel;
import com.mps.think.model.IssueModel;
import com.mps.think.model.OrderClass;
import com.mps.think.model.OrderCode;
import com.mps.think.model.OrderItem;
import com.mps.think.model.PackageDefinition;
import com.mps.think.model.PaymentThresholdHandlingDataModel;
import com.mps.think.model.Product;
import com.mps.think.model.ProposedAddsKillsModel;
import com.mps.think.model.RateClassEffectiveModel;
import com.mps.think.model.RatecardModel;
import com.mps.think.model.ReviewAddsKillsModel;
import com.mps.think.model.ReviewOnsOffsModel;
import com.mps.think.model.ShippingModel;
import com.mps.think.model.ShippingPriceListModel;
import com.mps.think.model.SingleCopyOrder;
import com.mps.think.model.SourceCode;
import com.mps.think.model.SubscriptionDefinition;
import com.mps.think.orderFunctionality.model.DemographicsModel;
import com.mps.think.orderFunctionality.service.OrderFunctionalityService;
import com.mps.think.service.AgencyService;
import com.mps.think.service.CustomerLoginService;
import com.mps.think.service.CustomerOrderService;
import com.mps.think.service.OrderPaymentService;
import com.mps.think.service.UtilityService;
import com.mps.think.util.CustomerUtility;
import com.mps.think.util.PropertyUtilityClass;
import com.mps.think.wsdl.OrderAddWsdl;
import Think.XmlWebServices.*;


@RestController
@RequestMapping("customerOrder")
public class CustomerOrderController {

	private static Gson gson = new GsonBuilder().serializeNulls().create();
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerOrderController.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	CustomerOrderService customerOrderService;

	@Autowired
	UtilityService utilityService;
	
	@Autowired
	OrderPaymentService service;

	@Autowired
	OrderFunctionalityService orderFunctionalityService;

	@Autowired
	AgencyService agencyService;
	// run truncate
	@Autowired
	CustomerUtility customerUtility;
	CustomerLoginService customerLoginService;
	
	@Autowired
	OrderSourceOfferDaoImpl orderSourceOfferDaoImpl;
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
	
	
	@RequestMapping(path = "/order", method = RequestMethod.POST)
	public Map<String, Object> getCustomerOrder(String customerId, String inActive, String paid, String controlled,
			String complimentary, String orderType, String billToCustNotOwner, String limitToOc) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<CustomerOrderModel> customerOrderList = customerOrderService.getCustomerOrder(
					Long.parseLong(customerId), inActive, paid, controlled, complimentary, orderType,
					billToCustNotOwner, null, limitToOc);
			List<CustomerOrderModel> pkgOrderList = customerOrderService.getCustomerOrder(Long.parseLong(customerId),
					inActive, paid, controlled, complimentary, orderType, billToCustNotOwner, "pkgItem", limitToOc);
			String creditStatus = customerOrderService.getCreditStatus(Long.parseLong(customerId));
			responseObject.put("customerOrderList", customerOrderList);
			responseObject.put("creditStatus", creditStatus);
			responseObject.put("pkgOrderList", pkgOrderList);
			responseObject.put("customerOrderListHeader",
					utilityService.getDispContextHeaders("view_order_tab_list_all"));
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/customerOrdersEdit", method = RequestMethod.POST)
	public Map<String, Object> customerOrderEdit(@RequestParam("orderhdrId") long orderhdrId,
			@RequestParam("orderCodeId") int orderCodeId, @RequestParam("customerId") long customerId,
			@RequestParam("orderItemType") int orderItemType, @RequestParam("orderItemSeq") int orderItemSeq,
			@RequestParam("isrenewd") int isrenewd) 
	{
		Map<String, Object> customerOrderEdit = new LinkedHashMap<String, Object>();
		try 
		{
			OrderItem orderItems = customerOrderService.customerOrderEdit(orderhdrId, orderItemType, orderCodeId,
					customerId, orderItemSeq, isrenewd);
			List<Map<String, Object>> deliveryMethodList = customerOrderService.getDeliveryMethodList();
			List<OrderItem> orderList = customerOrderService.getOrderinProgressData(orderItems.getOrderItemType(),
					String.valueOf(orderItems.getOrderCodeID()), String.valueOf(orderItems.getSourceCodeID()));
			List<RateClassEffectiveModel> rateClassEffectiveList = customerOrderService.getRateClassEffectiveList(
					orderItems.getAgencyCustomerId(), orderItems.getRateClassId(), orderItems.getOrderCodeID(),
					customerId, orderhdrId, orderItems.getOrderItemSeq(),
					Integer.parseInt(orderItems.getSubscriptionDefId()));
			List<DropdownModel> orderCategory = customerOrderService.getOrderCategory();
			List<DropdownModel> orderStatus = customerOrderService.getOrderStatus();
			List<DropdownModel> paymentStatus = customerOrderService.getpaymentStatus();
			String categoryDefaultValue = customerOrderService.getCetDefDetails(orderhdrId, orderItemSeq);
			List<OrderItem> packageItems = customerOrderService.customerOrderPackageEdit(orderhdrId, orderItemType,
					orderCodeId, customerId, orderItemSeq);
			List<CustomerAuxiliaryModel> auxiliaryFormField = customerOrderService.getCustomerAuxiliaryFormField();
			List<DropdownModel> shippingPriceList = customerOrderService.getShippingMethod();
			customerOrderEdit.put("auxiliaryformfeild", auxiliaryFormField);
			customerOrderEdit.put("OrderItem", orderItems);
			customerOrderEdit.put("packageItems", packageItems);
			customerOrderEdit.put("DeliveryMethodsMetadataList", deliveryMethodList);
			customerOrderEdit.put("OrderList", orderList);
			customerOrderEdit.put("RateClassEffective", rateClassEffectiveList);
			customerOrderEdit.put("orderCategory", orderCategory);
			customerOrderEdit.put("orderStatus", orderStatus);
			customerOrderEdit.put("paymentStatus", paymentStatus);
			customerOrderEdit.put("categoryDefaultValue", categoryDefaultValue);
			customerOrderEdit.put("shippingPriceList", shippingPriceList);
			if (orderItemType == 4) 
			{
				List<PackageDefinition> packageDefinitionList = customerOrderService.getPackageDefinitionList(orderCodeId);		
				customerOrderEdit.put("packageDefinitionList", packageDefinitionList);
			}
			if ((orderItemType == 0) || (orderItemType == 1)) 
			{
				List<IssueModel> issueModelsList = customerOrderService.getSubscriptionStartDate(orderItems.getOcId());
				customerOrderEdit.put("issueModelsList", issueModelsList);
			}
			/**Added By Sohrab to get customer Distribution Values for Subscription type order*/
			if (orderItemType == 0)
			{
				List<DistributionMethodModel> distributionMethodsList=customerOrderService.retrieveDistributionMethods();
				customerOrderEdit.put("distributionMethodsMetadataList", distributionMethodsList);
				List<DistributionAttributeModel> distributionAttributesList=customerOrderService.retrieveDistributionAttributes();
				customerOrderEdit.put("distributionAttributesMetadataList", distributionAttributesList);
				List<DistributionValueModel> distributionValuesList=customerOrderService.retrieveDistributionValues();
				customerOrderEdit.put("distributionValuesMetadataList", distributionValuesList);
			}
			customerOrderEdit.put(STATUS, SUCCESS);
			return customerOrderEdit;
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			customerOrderEdit.put(STATUS, ERROR + e);
			e.printStackTrace();
			return customerOrderEdit;
		}
	}
	
	
	
	@RequestMapping(path = "/customerAddressList", method = RequestMethod.POST)
	public Map<String, Object> retrieveCustomerAddressList(@RequestParam("customerId") long customerId) {
		Map<String, Object> customerAddressDetails = new LinkedHashMap<String, Object>();
		try {
			CustomerDistributionValuesModel customerDistributionValuesModelObject=customerOrderService.retrieveCustomerInformation(customerId);
			customerAddressDetails.put("customerAddressList", customerDistributionValuesModelObject);
			customerAddressDetails.put(STATUS, SUCCESS);
			return customerAddressDetails;
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			return customerAddressDetails;
		}
	}
	
	
	
	@RequestMapping(path = "/customerAddressDistributionList", method = RequestMethod.POST)
	public Map<String, Object> retrieveCustomerAddressDistributionList(@RequestParam("customerId") long customerId) {
		Map<String, Object> customerAddressDistributionListDetails = new LinkedHashMap<String, Object>();
		try 
		{
			List<CustomerAddressDistributionModel> customerAddressDistributionList=customerOrderService.retrieveCustomerAddressDistribution(customerId);
			customerAddressDistributionListDetails.put("DistributionForCustomerAddress", customerAddressDistributionList);
			customerAddressDistributionListDetails.put(STATUS, SUCCESS);
			return customerAddressDistributionListDetails;
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			return customerAddressDistributionListDetails;
		}
	}
	
	
	
	@RequestMapping(path = "/customerDetail", method = RequestMethod.POST)
	public Map<String, Object> customerDetail() {
		Map<String, Object> customerDetailList = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> customerDetails = customerOrderService.getCustomerDetails("All");
			customerDetailList.put("CustomerDetails", customerDetails);
			customerDetailList.put(STATUS, SUCCESS);
			return customerDetailList;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			customerDetailList.put(STATUS, ERROR + e);
			return customerDetailList;
		}
	}
	/*
	 *  This function calculates amount and related information of order code according to applied source and definition.
	 *  Here subscriptionId is used for definition for all types like subscription_def_id,package_de_id,product_id etc else 0. 
	 */
	//Added new parameter by Sohrab for THINKDEV-610,611,615
	@RequestMapping(path="/orderProgress", method = RequestMethod.POST)
	public Map<String, Object> orderProgress(String orderCodeId,String sourceCodeId,int orderCodeType,int customerId,Integer subscriptionId,String subscriptionIdList,String grossLocalAmt,String grossBaseAmt,String agencyID, Double cancelledOrderAmount,Optional<Integer> orderhdrId,Optional<String> shippingPrice,Optional<Integer> cancelledOrderCodeType,Optional<Integer> cancelledOrderhdrId){		
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
		try
		{
			if(Integer.valueOf(orderCodeId)!=0) 
			{
				if(cancelledOrderAmount==null)
				{
					cancelledOrderAmount=0d;
				}
				String query="SELECT ocode.oc_id,oc.oc_type,ocode.start_type,ocode.revenue_method,ocode.no_charge,ocode.controlled"+ 
						" FROM order_code ocode INNER JOIN oc oc ON oc.oc_id=ocode.oc_id WHERE order_code_id=?;";
				Map<String,Object> resultMap = jdbcTemplate.queryForMap(query, orderCodeId);
				int oc_id=Integer.parseInt(resultMap.get("oc_id").toString());
				int oc_type=Integer.parseInt(resultMap.get("oc_type").toString());
				int start_type=Integer.parseInt(resultMap.get("start_type").toString());
				int revenue_method=Integer.parseInt(resultMap.get("revenue_method").toString());
				int no_charge=Integer.parseInt(resultMap.get("no_charge").toString());
				int controlled=Integer.parseInt(resultMap.get("controlled").toString());
				double amount_of_order_in_progress=0d;
				boolean isPaymentThresholdHandlingRequired=false;
				if(Objects.isNull(subscriptionId))
				{
					subscriptionId = 0;
				}
				if(Integer.parseInt(sourceCodeId)==0) 
				{
					List<SourceCode> sc = orderSourceOfferDaoImpl.getSourceCode(String.valueOf(oc_id));
					sourceCodeId = String.valueOf(sc.get(0).getSourceCodeId());	
				}		
				List<BasicPackageItemModel> basicPackageItemModelList = new ArrayList<>();
				long taxRateAmount = 0L;
				if(orderCodeType!=7)
				{
					taxRateAmount = customerOrderService.getTaxRate(customerId, Integer.parseInt(orderCodeId));
				}
				if(orderCodeType==0)
				{
					if(subscriptionId!=0) 
					{
						List<SubscriptionDefinition> subscriptionDefinitionsList= customerOrderService.getSubscriptionPackageDefList(customerId, Integer.parseInt(orderCodeId),Integer.parseInt(sourceCodeId), subscriptionId,orderCodeType,agencyID);
						responseObject.put("subscriptionDefinitionsList", subscriptionDefinitionsList);
						responseObject.put("taxRateAmount", taxRateAmount);
						String audited =jdbcTemplate.queryForObject("select audited from pub where oc_id=(select oc_id from order_code where order_code_id="+orderCodeId+")", String.class);
						responseObject.put("audited", audited);
						//fOR THINKDEV-610,611
						if(null!=subscriptionDefinitionsList && subscriptionDefinitionsList.size()>0)
						{
							amount_of_order_in_progress=subscriptionDefinitionsList.get(0).getBaseAmount();
						}
					}
				}else if(orderCodeType==1) 
				{
					List<SingleCopyOrder> SingleCopyOrder= customerOrderService.getSingleCopyOrder(customerId, Integer.parseInt(orderCodeId),sourceCodeId, subscriptionId,orderCodeType);
					responseObject.put("subscriptionDefinitionsList", SingleCopyOrder);
					responseObject.put("taxRateAmount", taxRateAmount);
					responseObject.put(STATUS,SUCCESS);
					//fOR THINKDEV-610,611
					if(null!=SingleCopyOrder && SingleCopyOrder.size()>0)
					{
						amount_of_order_in_progress=SingleCopyOrder.get(0).getBaseAmount();
					}
				}
				else if(orderCodeType == 2)
				{
					List<Product> productOrder= customerOrderService.getProductRate(customerId, Integer.parseInt(orderCodeId),Integer.parseInt(sourceCodeId), subscriptionId,orderCodeType);
					responseObject.put("subscriptionDefinitionsList", productOrder);
					responseObject.put("taxRateAmount", taxRateAmount);
					//fOR THINKDEV-610,611
					if(null!=productOrder && productOrder.size()>0)
					{
						amount_of_order_in_progress=productOrder.get(0).getBaseAmount();
					}
				}
				else if(orderCodeType == 8)
				{
					List<ShippingModel> shippingList = new ArrayList<>();
					Map<String, Object> shippingDataList =null;
					List<ShippingModel> shipOrder= customerOrderService.getShipOrderDetail(customerId, Integer.parseInt(orderCodeId),Integer.parseInt(sourceCodeId),orderCodeType);
					boolean order = orderhdrId.isPresent(); boolean ship = shippingPrice.isPresent();
					Integer orderID = orderhdrId.get();String shipPrice = shippingPrice.get();
					if((order && !orderID.equals(null)) && (ship && !shipPrice.equals(null))) {
						shippingDataList = getShippingOrderPercentage(orderID,(Integer)orderCodeType,shipPrice,Integer.parseInt(orderCodeId),customerId);
					}
					for(ShippingModel model: shipOrder) {
						model.setLocalAmount(Double.parseDouble(shippingDataList.get("chargeAmount").toString()));
						model.setBaseAmount(Double.parseDouble(shippingDataList.get("chargeAmount").toString()) * (Double.parseDouble(model.getExchangeRate())));
					shippingList.add(model);
					}
					responseObject.put("shipOrderList", shippingList);
					responseObject.put("taxRateAmount", taxRateAmount);
				}
				else if(orderCodeType == 4 || orderCodeType == 6 )
				{
						basicPackageItemModelList = customerOrderService.getBasicPackageDefList(customerId, Integer.parseInt(orderCodeId),Integer.parseInt(sourceCodeId), subscriptionId,orderCodeType,subscriptionIdList);
						long taxAmount = customerOrderService.getPackageTax(customerId, Integer.parseInt(orderCodeId));
						responseObject.put("subscriptionDefinitionsList", basicPackageItemModelList);
						responseObject.put("taxRateAmount", taxAmount);
						//fOR THINKDEV-610,611
						if(null!=basicPackageItemModelList && basicPackageItemModelList.size()>0)
						{
							amount_of_order_in_progress=basicPackageItemModelList.get(0).getBaseAmount();
						}
				}
				else if(orderCodeType == 5)
				{
						basicPackageItemModelList = customerOrderService.getAdhocPackageData(customerId, Integer.parseInt(orderCodeId),Integer.parseInt(sourceCodeId), subscriptionId,orderCodeType,subscriptionIdList,grossLocalAmt,grossBaseAmt);
						long taxAmount = customerOrderService.getPackageTax(customerId, Integer.parseInt(orderCodeId));
						responseObject.put("subscriptionDefinitionsList", basicPackageItemModelList);
						responseObject.put("taxRateAmount", taxAmount);
				}
				else if(orderCodeType == 7)
				{
					//List<QuickOrderInProgressModel> quickOrderInProgressList=customerOrderService.getQuickOrdersInProgress(customerId, Integer.parseInt(orderCodeId),Integer.parseInt(sourceCodeId),orderCodeType);
					//responseObject.put("quickOrderInProgressList", quickOrderInProgressList);
					
					List<Map<String, Object>>responseObject1 = customerOrderService.getQuickOrderData(orderCodeId, sourceCodeId, orderCodeType, customerId, subscriptionIdList, agencyID, orderhdrId, shippingPrice);
				    responseObject.put("quickOrderList", responseObject1);
				}
	//			if((orderCodeType != 7 || orderCodeType != 8) && !orderCodeId.equals("0")) {
	//				int upsellOn = jdbcTemplate.queryForObject("select upsell_on from oc where oc_id = (select parent_oc_id from oc where oc_id = (select oc_id from order_code where order_code_id = "+orderCodeId+"))", Integer.class);
	//				responseObject.put("upsellOn", upsellOn);
	//			}
				/*//UNDER DEVELOPMENT TO-DO: PLS DON'T REMOVE BELOW COMMENTED CODE:Added new method by Sohrab for THINKDEV-610,611,615
				if(cancelledOrderAmount<amount_of_order_in_progress)
				{
					isPaymentThresholdHandlingRequired=true;
				}
				if(isPaymentThresholdHandlingRequired)
				{
					if(no_charge==1||controlled==1)
					{
						responseObject.put("message","Business logic exception detected cfff0056: A payment cannot be applied to a free/complimentary order.");
					}else
					{
						PaymentThresholdHandlingDataModel paymentThresholdHandlingDataModelObj=customerOrderService.retrievePaymentThresholdHandlingData(orderCodeId,orderCodeType,sourceCodeId,subscriptionId,subscriptionIdList,cancelledOrderAmount,customerId,oc_type,start_type,revenue_method,amount_of_order_in_progress);
						if(null!=paymentThresholdHandlingDataModelObj)
						{
							double total_paid=cancelledOrderAmount;
							Map<String, Object> underOverPaymentOptions=getUnderOverPaymentOptions((float)paymentThresholdHandlingDataModelObj.getOrder_amount(),(float)total_paid);
							paymentThresholdHandlingDataModelObj.setUnderOverPaymentOptions(underOverPaymentOptions);
							responseObject.put("paymentThresholdHandlingData",paymentThresholdHandlingDataModelObj);
						}else
						{
							responseObject.put("paymentThresholdHandlingData","Payment Threshold Handling is not applicable in this case.");
						}
					}
				}
				responseObject.put("cancelledOrderAmount",cancelledOrderAmount);
				*/
			}
			if(cancelledOrderCodeType.isPresent()==true && cancelledOrderhdrId.isPresent()==true)
			{
				Integer cancelled_order_code_type = cancelledOrderCodeType.get();
				Integer cancelled_order_id = cancelledOrderhdrId.get();
				if(cancelled_order_code_type==0)//Subscription Type Order
				{
					Map<String,Object> agencyDataMap=customerOrderService.retrieveAgencyData(cancelled_order_code_type,cancelled_order_id,customerId);
					if(null!=agencyDataMap)
					{
						responseObject.put("agency_customer_id",agencyDataMap.get("agency_customer_id"));
						responseObject.put("bill_to_customer_id",agencyDataMap.get("bill_to_customer_id"));
						responseObject.put("renew_to_customer_id",agencyDataMap.get("renew_to_customer_id"));
					}
				}
			}
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
		}catch(Exception e)
		{
			LOGGER.error(ERROR +e);
			responseObject.put(STATUS,ERROR+e);
			e.printStackTrace();
			return responseObject;	
		}
	}
	
	
	@RequestMapping(path="/getUnderOverPaymentOptions",method = RequestMethod.POST)	
	public Map<String, Object> getUnderOverPaymentOptions(float item_amount,float amount_to_apply)
	{
		     Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		     String payment_threshold_status = null;
		     boolean allButtonEnable = false;
		     boolean underPaymentFieldActive = false;
		     boolean overPaymentFieldActive = false;
		     String payment_threshold_message = null;
		     try 
		     {
		    	 float  dividedAmount = amount_to_apply/item_amount;
		 		 float percentage = dividedAmount*100;
		 		 List<Map<String,Object>> paymentThresholdList = jdbcTemplate.queryForList("select * from payment_threshold");
		 		 int percent_partial = Integer.parseInt(paymentThresholdList.get(0).get("percent_partial").toString());
		 		 int percent_under = Integer.parseInt(paymentThresholdList.get(0).get("percent_under").toString());
		 		 int percent_over = Integer.parseInt(paymentThresholdList.get(0).get("percent_over").toString());
		 		 int percent_refund =Integer.parseInt(paymentThresholdList.get(0).get("percent_refund").toString());
		 		 int finalPercent = (int) percentage;
		    	 if(finalPercent == 100) 
		    	 {
		    		 payment_threshold_message = "Payment has been made successfully.";
	    			 responseObject.put("payment_threshold_message", payment_threshold_message);
	    	     }
		    	 if (finalPercent < percent_over) 
		    	 {
					underPaymentFieldActive = true;
					if(finalPercent < percent_partial) 
					{
						payment_threshold_status = "Partial Payment";
		    			 responseObject.put("payment_threshold_status", payment_threshold_status);
		    			 allButtonEnable = false;
		    			 responseObject.put("allButtonEnable", allButtonEnable);
		    			 responseObject.put("underPaymentFieldActive", underPaymentFieldActive);
					 	 responseObject.put("overPaymentFieldActive", overPaymentFieldActive);
					}
					if(finalPercent >= percent_partial && finalPercent < percent_under) 
					{
						payment_threshold_status = "Partial Payment";
		    		  	 responseObject.put("status", payment_threshold_status);
		    			 allButtonEnable = true;
		    			 responseObject.put("allButtonsEnable", allButtonEnable);
		    			 responseObject.put("underPaymentFieldActive", underPaymentFieldActive);
					 	 responseObject.put("overPaymentFieldActive", overPaymentFieldActive);
		    	    }
					if(amount_to_apply < item_amount && payment_threshold_status == null) 
					{
						payment_threshold_message = "The underpayment is within threshold values. It will be treated as full payment.";
		    			 responseObject.put("payment_threshold_message", payment_threshold_message);
					}else if(amount_to_apply > item_amount && payment_threshold_status == null) 
					{
						payment_threshold_message = "The overpayment is within threshold values. It will be treated as full payment.";
			    			 responseObject.put("payment_threshold_message", payment_threshold_message);
					}
		    	 }
		    	 else 
		    	 {
					overPaymentFieldActive = true;
					if(finalPercent >= percent_refund) 
					{
						payment_threshold_status = "Refund Overage";
			    		 responseObject.put("payment_threshold_status", payment_threshold_status);
		    			 allButtonEnable = false;
		    			 responseObject.put("allButtonsEnable", allButtonEnable);
		    			 responseObject.put("underPaymentFieldActive", underPaymentFieldActive);
					 	 responseObject.put("overPaymentFieldActive", overPaymentFieldActive);
			    	}
					if(finalPercent >= percent_over && finalPercent < percent_refund) 
					{ 
						payment_threshold_status = "Refund Overage";
		    		  	 responseObject.put("payment_threshold_status", payment_threshold_status);
		    			 allButtonEnable = true;
		    			 responseObject.put("allButtonsEnable", allButtonEnable);
		    			 responseObject.put("underPaymentFieldActive", underPaymentFieldActive);
					 	 responseObject.put("overPaymentFieldActive", overPaymentFieldActive);
		    	     }
		    	 }	
		     }catch (Exception e) 
		     {
		    	LOGGER.error(ERROR + e);
				responseObject.put(STATUS,ERROR+e);
				e.printStackTrace();
		     }
		     return responseObject;
		} 
	
	
	
	@RequestMapping(path = "/checkDuplicateOrder", method = RequestMethod.POST)
	public Map<String, Object> checkDuplicateOrder(OrderItem orderItem) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Object> duplicateOrder = customerOrderService.getDuplicateOrder(orderItem);
			responseObject.put("duplicateOrder", duplicateOrder);
			if (duplicateOrder.isEmpty()) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/getRenewalOrder", method = RequestMethod.POST)
	public Map<String, Object> getRenewalOrder(@RequestParam("subscripId") int subscripId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Object> renewalOrder = customerOrderService.getRenewalOrder(subscripId);
			responseObject.put("renewalOrder", renewalOrder);
			if (renewalOrder.isEmpty()) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}
   /*
    *   We are keeping key "packageList" for order code type (4,6,7) same for the ease of frontEnd integration
    */
	@RequestMapping(path = "/subscriptionDefDetails", method = RequestMethod.POST)
	public Map<String, Object> subscriptionDefDetails(@RequestParam("orderCodeId") int orderCodeId,
			@RequestParam("ocId") int ocId, @RequestParam("orderCodeType") int orderCodeType,@RequestParam("customerId") int customerId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		
		try {
			switch (orderCodeType) {
			case 0:
				List<SubscriptionDefinition> subscriptionDefinitionList = customerOrderService.getSubscription(orderCodeId);
				responseObject.put("subscriptionDefinitionList", subscriptionDefinitionList);
				break;
			case 1:
				List<IssueModel> issueModelsList = customerOrderService.getSubscriptionStartDate(ocId);
				responseObject.put("issueModelsList", issueModelsList);
				break;
			case 2:
				List<Product> productModelsList = customerOrderService.getProductDefinitionList(orderCodeId);
				responseObject.put("productModelsList", productModelsList);
				break;
			case 4:
				responseObject.put("packageList",customerOrderService.getOrderDropdownData(orderCodeId, ocId, orderCodeType,customerId));
				break;
			case 5:
				List<PackageDefinition> adhocPackageList = customerOrderService.getAdhocPackageList(orderCodeId);
				responseObject.put("adhocPackageList", adhocPackageList);
				break;
			case 6:
				responseObject.put("packageList", customerOrderService.getOrderDropdownData(orderCodeId, ocId, orderCodeType,customerId));
				break;
			case 7:
				responseObject.put("packageList", customerOrderService.getOrderDropdownData(orderCodeId, ocId, orderCodeType,customerId));
				break;
			}
		 responseObject.put(STATUS, SUCCESS);
		 return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;

		}

	}
	

	@RequestMapping(path = "/addOrder", method = RequestMethod.POST)
	public Map<String, Object> orderSave(OrderItem orderItem, @RequestParam("itemCount") int itemCount, String subscriptionIdList) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		String orderstatus = "false";
		try {
			/*
			 * if(orderItem.getOrderCodeType() == 4){
			 * orderstatus=customerOrderService.saveOrder(orderItem);
			 * responseObject.put(STATUS,orderstatus); return responseObject; }else{
			 */
			orderstatus = customerOrderService.getOrderAdd(orderItem, itemCount,subscriptionIdList);
			responseObject.put(STATUS, orderstatus);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	
	/**This API is used to place the order with payment at the same time.*/
	@RequestMapping(path = "/addOrderWithPayment", method = RequestMethod.POST)
	public Map<String, Object> saveOrderWithPayment(OrderItem orderItem, @RequestParam("itemCount") int itemCount, String subscriptionIdList) 
	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		String orderstatus = "false";
		try 
		{
			orderstatus = customerOrderService.saveOrderWithPayment(orderItem, itemCount,subscriptionIdList);
			responseObject.put(STATUS, orderstatus);
			return responseObject;
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	
	
	
	@RequestMapping(path = "/expireDateCalculate", method = RequestMethod.POST)
	public Map<String, Object> expireDateCalculate(@RequestParam("orderhdrId") int orderhdrId,
			@RequestParam("orderItemSeq") int orderItemSeq, @RequestParam("expireDate") String expireDate,
			@RequestParam("defaultPricing") String defaultPricing) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();

		try {
			Optional<String> isNullExpireDate = Optional.ofNullable(expireDate);
			boolean p = isNullExpireDate.isPresent();
			String pp = isNullExpireDate.get();
			if(p && !pp.equals("null")) {
				 List<Order_date_option_calculate_response> Order_date_option_calculate_response = new OrderAddWsdl()
							.getExpireDateCalculate(orderhdrId, orderItemSeq, expireDate, defaultPricing);
					responseObject.put(STATUS, Order_date_option_calculate_response);
			 }
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/noOfCopiesforDateOption", method = RequestMethod.POST)
	public Map<String, Object> noOfCopiesforDateOption(@RequestParam("orderhdrId") int orderhdrId,
			@RequestParam("orderItemSeq") int orderItemSeq, @RequestParam("quantity") int quantity) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();

		try {
			List<Bundle_quantity_date_option_calculate_response> Bundle_quantity_date_option_calculate_response = new OrderAddWsdl()
					.getnoOfCopiesforDateOption(orderhdrId, orderItemSeq, quantity);
			responseObject.put(STATUS, Bundle_quantity_date_option_calculate_response);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/noOfCopiesforIssueOption", method = RequestMethod.POST)
	public Map<String, Object> noOfCopiesforIssueOption(@RequestParam("orderhdrId") int orderhdrId,
			@RequestParam("orderItemSeq") int orderItemSeq, @RequestParam("quantity") int quantity) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();

		try {
			List<Bundle_quantity_option_calculate_response> Bundle_quantity_option_calculate_response = new OrderAddWsdl()
					.getnoOfCopiesforIssueOption(orderhdrId, orderItemSeq, quantity);
			responseObject.put(STATUS, Bundle_quantity_option_calculate_response);
			return responseObject;

		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/noOfIssueChange", method = RequestMethod.POST)
	public Map<String, Object> noOfIssueChange(int orderhdrId, int orderItemSeq, int quantity, String defaultPricing,
			long customerId, int rateClassId, int rateClassEffectiveSeq, int priceMethodOption, float localAmount,
			float baseAmount, int preQuantity, int customerAddressSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			Map<String, Object> ammountChangeByNoOfissue = customerOrderService.getAmountForNoOfIssue(orderhdrId,
					orderItemSeq, quantity, defaultPricing, customerId, rateClassId, rateClassEffectiveSeq,
					priceMethodOption, localAmount, baseAmount, preQuantity, customerAddressSeq);
			responseObject.put("AmountChangByNoOfIssue", ammountChangeByNoOfissue);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/orderUpdate", method = RequestMethod.POST)
	public Map<String, Object> orderUpdate(OrderItem orderItem) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try 
		{
				 if(orderItem.getInstallAutoPayment()!=null) 
				 {
					 if(orderItem.getBillingType().equals("Balance Due") && orderItem.getInstallAutoPayment().equals("0")) 
					 {
						  customerOrderService.deleteBillingOptions(orderItem.getOrderhdrId(), orderItem.getOrderItemSeq());
					  }else 
					  {
						  customerOrderService.saveBillingOptions(orderItem);
					  }
				  }
				  if(orderItem.getRenewalStatus()==0 || orderItem.getRenewalStatus()==1 || orderItem.getRenewalStatus()==2) 
				  {
					 orderFunctionalityService.updateRenewalOption(orderItem);
				  }
				  int pub_count = jdbcTemplate.queryForObject("Select COUNT(*) from pub where oc_id="+orderItem.getOcId(),Integer.class);
				  if(pub_count>0)
				  {
					  int qp = jdbcTemplate.queryForObject("select qp from pub where oc_id="+orderItem.getOcId(), Integer.class);
					  int qf = jdbcTemplate.queryForObject("select qf from pub where oc_id="+orderItem.getOcId(), Integer.class);
					  int nqp = jdbcTemplate.queryForObject("select nqp from pub where oc_id="+orderItem.getOcId(), Integer.class);
					  int nqf = jdbcTemplate.queryForObject("select nqf from pub where oc_id="+orderItem.getOcId(), Integer.class);
					  if(qp == 1 || qf == 1 || nqp == 1 || nqf == 1 ) 
					  {
						  String qual = orderItem.getQualDate();
							String squal = orderItem.getSqualDate();
							String date = jdbcTemplate.queryForObject("select convert(nvarchar, getdate(), 101) as date", String.class);
							if((qual !=null || Objects.nonNull(qual)) && (squal != null && Objects.nonNull(squal))) {
							//squal>qual or squal=qual
							if(qual.compareTo(squal)<0  || qual.equals(squal)) {
								// squal = date or squal<date
								if(squal.equals(date) || squal.compareTo(date)<0) {
									int status = orderFunctionalityService.updateEditAuditInfo(orderItem);
									if (status != 0) {
										responseObject.put(STATUS, "Successfully Updated");
									} else {
										responseObject.put(STATUS, "Unsuccessful");
									}
								}else {
									responseObject.put("msg1", " Business logic exception detected: cfff0186: Invalid Qualification dates.  The long and short qualification dates cannot be after today's date.");
								}
							}else {
								responseObject.put("msg", " The short qualification date must be the same as the long qualification date or a date later than the long qualification date.");
							}
					     }
					  }
							
				  }
			String action = customerOrderService.orderUpdate(orderItem);
			responseObject.put("Message", action);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	

	@RequestMapping(path = "/shippingUpdate", method = RequestMethod.POST)
	public Map<String, Object> shippingUpdate(ShippingPriceListModel shippingPriceListModel) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			customerOrderService.shippingPriceUpdate(shippingPriceListModel);
			// String action = customerOrderService.orderUpdate(shippingPriceListModel);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/customerAddress", method = RequestMethod.POST)
	public Map<String, Object> getCustomerAddress(@RequestParam("customerId") String customerId,
			@RequestParam("orderCodeId") int orderCodeId, @RequestParam("orderItemType") int orderItemType) {
		Map<String, Object> customerAddressObj = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> customerAddress = customerOrderService.getAddressDetails(customerId, orderCodeId,
					orderItemType);
			customerAddressObj.put("customerAddress", customerAddress);
			customerAddressObj.put(STATUS, SUCCESS);
			return customerAddressObj;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			customerAddressObj.put(STATUS, ERROR + e);
			return customerAddressObj;
		}

	}

	@RequestMapping(path = "/agency", method = RequestMethod.POST)
	public Map<String, Object> getAgencyList() {
		Map<String, Object> agencyListObj = new LinkedHashMap<String, Object>();
		try {
			List<AgencyAttributeModel> agencyList = agencyService.getAgencyList();
			agencyListObj.put("agencyList", agencyList);
			agencyListObj.put(STATUS, SUCCESS);
			return agencyListObj;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			agencyListObj.put(STATUS, ERROR + e);
			return agencyListObj;
		}

	}

	@RequestMapping(path = "/searchByOrderClass", method = RequestMethod.POST)
	public Map<String, Object> searchByOrderClass() {
		Map<String, Object> orderClassList = new LinkedHashMap<String, Object>();
		try {
			List<DropdownModel> orderClass = customerOrderService.getorderClass();
			List<DropdownModel> orderCodetype = customerOrderService.getOrderCode();
			List<DropdownModel> orderTerm = customerOrderService.getOrderTerm();
			orderClassList.put("orderCodetype", orderCodetype);
			orderClassList.put("orderTerm", orderTerm);
			orderClassList.put("orderClass", orderClass);
			orderClassList.put(STATUS, SUCCESS);
			return orderClassList;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			orderClassList.put(STATUS, ERROR + e);
			return orderClassList;
		}

	}

	@RequestMapping(path = "/orderCode", method = RequestMethod.POST)
	public Map<String, Object> getOrderCodeData(String orderCode, String orderClass, String orderCodeType,
			String term) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<OrderCode> orderCodeList = customerOrderService.getOrderCodeData(orderCode, orderClass, orderCodeType,
					term);
			responseObject.put("orderCodeList", orderCodeList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/onAgencyChange", method = RequestMethod.POST)
	public Map<String, Object> onAgencyChange(long customerId, int rateClassId, String orderCodeId, long orderhdrId,
			String agencyID, int orderItemSeq, int subscription_def_id) {
		Map<String, Object> changeListObj = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> AgencyData = customerOrderService.getAgencyChangeData(customerId, agencyID);
			List<RateClassEffectiveModel> rateClassEffectiveList = customerOrderService.getRateClassEffectiveList(
					agencyID, rateClassId, orderCodeId, customerId, orderhdrId, orderItemSeq, subscription_def_id);
			changeListObj.put("AgencyData", AgencyData);
			changeListObj.put("RateCardData", rateClassEffectiveList);
			changeListObj.put(STATUS, SUCCESS);
			return changeListObj;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			changeListObj.put(STATUS, ERROR + e);
			return changeListObj;
		}

	}

	@RequestMapping(path = "/onSubscriptionChange", method = RequestMethod.POST)
	public Map<String, Object> onSubscriptionChange(int rateClassId, int rateClassEffectiveSeq, long customerId,
			String orderCodeId, long orderhdrId, int orderItemSeq, int subscription_def_id, Integer issueId,
			String agencyID) {
		LOGGER.info("Inside onSubscriptionChange");
		Map<String, Object> onSubscriptionChange = new LinkedHashMap<String, Object>();
		try {
			List<RateClassEffectiveModel> rateClassEffectiveList = customerOrderService.getRateClassEffectiveList(
					agencyID, rateClassId, orderCodeId, customerId, orderhdrId, orderItemSeq, subscription_def_id);
			List<Map<String, Object>> onSubscriptionData = customerOrderService
					.getOnSubscriptionChange(subscription_def_id, issueId);
			onSubscriptionChange.put("onSubscriptionData", onSubscriptionData);
			onSubscriptionChange.put("rateClassEffectiveList", rateClassEffectiveList);
			onSubscriptionChange.put("rateClassEffectiveSeq", rateClassEffectiveSeq);
			onSubscriptionChange.put(STATUS, SUCCESS);
			return onSubscriptionChange;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			onSubscriptionChange.put(STATUS, ERROR + e);
			return onSubscriptionChange;
		}

	}

	@RequestMapping(path = "/onPkgDefChange", method = RequestMethod.POST)
	public Map<String, Object> onPkgDefChange(@RequestParam("orderCodeId") String orderCodeId,
			@RequestParam("orderCodeType") int orderCodeType, @RequestParam("customerId") int customerId,
			@RequestParam("subscriptionId") int subscriptionId) {
		LOGGER.info("Inside onPkgDefChange");
		Map<String, Object> onPkgDefChange = new LinkedHashMap<String, Object>();
		try {
			List<BasicPackageItemModel> basicPackageItemModelList = new ArrayList<>();
			basicPackageItemModelList = customerOrderService.onPkgDefChange(customerId, Integer.parseInt(orderCodeId),
					subscriptionId, orderCodeType);
			long taxAmount = customerOrderService.getPackageTax(customerId, Integer.parseInt(orderCodeId));
			onPkgDefChange.put("onPkgDefChange", basicPackageItemModelList);
			onPkgDefChange.put("taxRateAmount", taxAmount);
			onPkgDefChange.put(STATUS, SUCCESS);
			return onPkgDefChange;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			onPkgDefChange.put(STATUS, ERROR + e);
			return onPkgDefChange;
		}

	}

	@RequestMapping(path = "/viewOrderType", method = RequestMethod.POST)
	public Map<String, Object> getViewOrderType() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<DropdownModel> viewOrderType = customerOrderService.getviewOrderTypeList();
			responseObject.put("viewOrderType", viewOrderType);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}

	@RequestMapping(value = "/orderAuxiliaryAdd", method = RequestMethod.POST)
	public Map<String, Object> customerAuxiliaryAdd(@RequestParam("orderhdrId") long orderhdrId,
			@RequestParam("orderItemSeq") int orderItemSeq)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, String> map = null;
		List<Map<String, String>> finalMap = new ArrayList<Map<String,String>>(); 
		try {
			List<CustomerAuxiliaryModel> auxiliaryFormField = customerOrderService.getCustomerAuxiliaryFormField();
			new PropertyUtilityClass().appendDefaultDateInAuxiliaryFields(auxiliaryFormField);
			responseObject.put("auxiliaryformfeild", auxiliaryFormField);
			LinkedHashMap<String, String> orderAuxiliaryDetail = customerOrderService.setOrderAuxiliaryDetailByID(orderhdrId, orderItemSeq);
			// Getting the Set of entries
			Set<Entry<String, String>> entrySet = orderAuxiliaryDetail.entrySet();
			// Creating an ArrayList Of Entry objects
			List<Entry<String, String>> auxiliaryFieldDetails = new ArrayList<Entry<String, String>>(entrySet);
		        for(int i=0;i<auxiliaryFieldDetails.size();i++) {
		        	map = new LinkedHashMap<String, String>();
		        		if(auxiliaryFormField.get(i).getColumnName().equals(auxiliaryFieldDetails.get(i).getKey())) {
		        			if(auxiliaryFieldDetails.get(i).getValue() == null) {// to set default date value for date column
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
		        if(finalMap.size() == 0) {
		        	for(int i=0;i<auxiliaryFormField.size();i++) {
		        		map = new LinkedHashMap<String, String>(auxiliaryFormField.size());
						if(auxiliaryFormField.get(i).getColumnDatatype().equalsIgnoreCase("Date") ) {
							map.put(auxiliaryFormField.get(i).getColumnName(),auxiliaryFormField.get(i).getDefaultValue());
							map.put("columnDatatype", auxiliaryFormField.get(i).getColumnDatatype());
		        			finalMap.add(map);
						}
					}
		        }
			responseObject.put("orderAuxiliaryDetail", finalMap);
			responseObject.put("orderhdrId", orderhdrId);
			responseObject.put("orderItemSeq", orderItemSeq);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(value = "/orderAuxiliaryAddSubmit", method = RequestMethod.POST)
	public Map<String, Object> orderAuxiliaryAddSubmit(HttpServletRequest request)

	{
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			String status = customerOrderService.saveOrderAuxiliary(request);
			if (ERROR.equals(status))
				responseObject.put(STATUS, ERROR);
			else {
				responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	@RequestMapping(path = "/customerOrderCancel")
	public String customerOrderCancel() {
		return "order/customerOrderCancel";
	}

	@RequestMapping(path = "/customerOrderPriceTax")
	public @ResponseBody String customerOrderPriceTax(@RequestParam("rateClassId") int rateClassId,
			@RequestParam("rateClassEffectiveSeq") int rateClassEffectiveSeq,
			@RequestParam("ratecardSeq") String ratecardSeq, @RequestParam("state") String state,
			@RequestParam("commodityCode") String commodityCode) {
		List<RatecardModel> orderPriceTaxList = customerOrderService.getCustomerOrderPriceTax(rateClassId,
				rateClassEffectiveSeq, ratecardSeq, state, commodityCode);
		return gson.toJson(orderPriceTaxList);
	}

	@RequestMapping(path = "/saveOrderQuantityChangeOption", method = RequestMethod.POST)
	public Map<String, Object> saveAmountPerNoOfCopies(long issueId, int numberOfIssue, float toOrderItemPrice) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			Map<String, Object> saveAmmountChangeByNoOfissue = customerOrderService.getSaveAmountForNoOfIssue(issueId,
					numberOfIssue, toOrderItemPrice);
			responseObject.put("saveAmmountChangeByNoOfissue", saveAmmountChangeByNoOfissue);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/bundleQuantityChangeOption", method = RequestMethod.POST)
	public Map<String, Object> bundleQuantityChangeOption(String orderClass, String orderCode, int orderNumber,
			int orderLineNumber, float localAmount, int numberOfIssue, int copyPerIssue, int preCopyPerIssue,
			long orderId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			Map<String, Object> bundleQuantityChangeOption = customerOrderService.getBundleQuantityChangeOption(
					orderClass, orderCode, orderNumber, orderLineNumber, localAmount, numberOfIssue, copyPerIssue,
					preCopyPerIssue, orderId);
			responseObject.put("bundleQuantityChangeOption", bundleQuantityChangeOption);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/optionBundleQuantityChange", method = RequestMethod.POST)
	public Map<String, Object> optionBundleQuantityChange(String orderClass, String orderCode, int orderNumber,
			int orderLineNumber, float localAmount, int numberOfIssue, int copyPerIssue, int preCopyPerIssue,
			float baseAmount, long orderId, int option, long startIssueId, float baseNetAmount, float baseGrossAmount, float localNetAmount, float localGrossAmount,
			  float localCommission,float baseCommission,float totalTaxLocalAmount,float totalTaxBaseAmount,float toCastPerIssue) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			Map<String, Object> clickOnbundleQuantityChangeOption = customerOrderService
					.clickOnBundleQuantityChangeOption(orderClass, orderCode, orderNumber, orderLineNumber, localAmount,
							numberOfIssue, copyPerIssue, preCopyPerIssue, orderId, baseAmount, option, startIssueId,baseNetAmount,baseGrossAmount,localNetAmount,localGrossAmount,
							localCommission, baseCommission, totalTaxLocalAmount,totalTaxBaseAmount,toCastPerIssue);
			responseObject.put("clickOnbundleQuantityChangeOption", clickOnbundleQuantityChangeOption);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(path = "/onDateChange", method = RequestMethod.POST)
	public Map<String, Object> onDateChange(int issueId, int numIssue, int currIssueId, String subscripId, int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			Map<String, Object> date = customerOrderService.getExpirationDate(currIssueId, numIssue, ocId, subscripId);
			List<BackIssuesModel> backIssueList = customerOrderService.getBackIssueList(issueId, currIssueId,
					subscripId);
			if (date != null) {
				responseObject.put("onStartDateChange", date);
			} else {
				responseObject.put("onStartDateChange",
						"Error: Attempt to order a subscription that goes beyond the end of issues defined");
			}
			responseObject.put("backIssueList", backIssueList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/backIssues", method = RequestMethod.POST)
	public Map<String, Object> backIssues(int subscripId) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<Back_issue_full_list_select_responseBack_issue[]> backIssueList = new OrderAddWsdl()
					.getBackIssueList(subscripId);
			responseObject.put("backIssueList", backIssueList.get(0));
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(value = "/changeAmountByRateCard", method = RequestMethod.POST)
	public Map<String, Object> changeAmount(long numberOfIssue, long customerId, int rateClassId,
			int rateClassEffectiveSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			Object changeAmountByRateCard = customerOrderService.getChangeAmountByRateCard(numberOfIssue, customerId,
					rateClassId, rateClassEffectiveSeq);
			responseObject.put("changeAmountByRateCard", changeAmountByRateCard);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(value = "/onSourceCodeChange", method = RequestMethod.POST)
	public Map<String, Object> onSourceCodeChange(long customerId, int rateClassId, String orderCodeId, long orderhdrId,
			String agencyID, int orderItemSeq, int subscription_def_id, int sourceCodeId) {
		Map<String, Object> changeListObj = new LinkedHashMap<String, Object>();
		try {
			List<Map<String, Object>> sourceCodeChange = customerOrderService.getsourceCodeChange(sourceCodeId,
					agencyID);
			List<Map<String, Object>> AgencyData = customerOrderService.getAgencyChangeData(customerId,
					sourceCodeChange.get(0).get("agency_customer_id") != null
							? sourceCodeChange.get(0).get("agency_customer_id").toString()
							: agencyID);
			List<RateClassEffectiveModel> rateClassEffectiveList = customerOrderService.getRateClassEffectiveList(
					agencyID, rateClassId, orderCodeId, customerId, orderhdrId, orderItemSeq, subscription_def_id);
			changeListObj.put("sourceCodeData", sourceCodeChange);
			changeListObj.put("AgencyData", AgencyData);
			changeListObj.put("RateCardData", rateClassEffectiveList);
			changeListObj.put(STATUS, SUCCESS);
			return changeListObj;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			changeListObj.put(STATUS, ERROR + e);
			return changeListObj;
		}

	}

	@RequestMapping(value = "/AdjustQty", method = RequestMethod.POST)
	public Map<String, Object> adjustQuantityChange(long preQty, long adjQty, long additionalQty, double localAmount,
			double baseAmount) {
		Map<String, Object> returnObj = new LinkedHashMap<String, Object>();
		try {
			Map<String, Object> adjustQuatity = customerOrderService.getAdjustQuatity(preQty, adjQty, additionalQty,
					localAmount, baseAmount);
			returnObj.put("adjustQuatity", adjustQuatity);
			returnObj.put(STATUS, SUCCESS);
			return returnObj;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnObj.put(STATUS, ERROR + e);
			return returnObj;
		}
	}

	@RequestMapping(value = "/AdjustAdditionalQty", method = RequestMethod.POST)
	public Map<String, Object> adjustAdditionalQty(long preAdditional, long adjustAdditional, long total) {
		Map<String, Object> returnObject = new LinkedHashMap<String, Object>();
		try {
			Map<String, Object> adjustAdditionalQty = customerOrderService.getadjustAdditionalQty(preAdditional,
					adjustAdditional, total);
			returnObject.put("adjustAdditionalQty", adjustAdditionalQty);
			returnObject.put(STATUS, SUCCESS);
			return returnObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			returnObject.put(STATUS, ERROR + e);
			return returnObject;
		}
	}

	@RequestMapping(value = "/orderHistory", method = RequestMethod.POST)
	public Map<String, Object> orderHistory(@RequestParam("orderHdrId") Long orderHdrId,
			@RequestParam("ordItemSeq") int ordItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			List<Object> orderHistoryList = customerOrderService.getOrderHistory(orderHdrId, ordItemSeq);
			responseObject.put("orderHistoryList", orderHistoryList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	@RequestMapping(path = "/orderClassLookUp", method = RequestMethod.POST)
	public Map<String, Object> getorderClassLookUp(String orderCode, String ocID, String profitCenter,
			String description) {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			if("*".equals(ocID)) {
				responseObject.put(STATUS, "The value '*' is not valid for field Oc Id");
			}else {
			List<OrderClass> orderCodeList = customerOrderService.getorderClassLookUp(orderCode, ocID, profitCenter,
					description);
			responseObject.put("orderCodeList", orderCodeList);
			responseObject.put(STATUS, SUCCESS);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@PostMapping("/billingOptions")
	public Map<String, Object> billingOptionsDetails(Long orderhdrId, Integer orderItemSeq, Integer customerId,
			Integer isActive, String paymentType, String orderCodeId, Integer installmentId, Integer installmentIdNew,
			Integer nbrInstallments, Integer accountPaymentSeq, Integer idNbrLastFour, Integer type, Integer pullDay,
			Integer autoPayment, String action, Integer subscriptionId, String sourceCodeId,String state,String currency,String orderCodeType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<Map<String, Object>> billingDetailsList = new ArrayList<>();
		List<Map<String, Object>> installmentPlanList = new ArrayList<>();
		List<Map<String, Object>> cardData = new ArrayList<>();
		List<DropdownModel> paymentDropdown = new ArrayList<>();
		List<Map<String, Object>> creditCardDetails = new ArrayList<>();
		List<Map<String, Object>> configTableDetails = null;
		int install_auto_payment = 0;
		int accountPaymentSeq2 = 0;  
		int idNbrLastFour2 = 0;
		String msg = "Business logic exception detected: cfff0157: Cannot create an credit card or direct debit installment plan. Ensure that the 'Pull Payment Days' and 'Payment Start Interval' values have been entered in Setups.";
		try {
			configTableDetails = customerOrderService.getConfigTableDetails();
			Integer pull_pay_start_for_cc = Integer.parseInt(configTableDetails.get(0).get("pull_pay_start_for_cc").toString());
			Integer pullPaymentDay = configTableDetails.get(0).get("pull_payment_days")!=null?Integer.parseInt(configTableDetails.get(0).get("pull_payment_days").toString()):null;
			
			switch (action) {
			case "default": // it requires orderHdrId,ordItemSeq,orderCodeId,installmentId,customerId, isActive
				if (orderItemSeq != null && orderhdrId != null) {

					billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
					//clearPullRelatedKey(billingDetailsList);
					//billingDetailsList.get(0).replace("type",0);
					responseObject.put("billingDetails", billingDetailsList);
					installmentPlanList = customerOrderService.getOrderItemInstallmentDetails(orderhdrId, orderItemSeq);
					responseObject.put("installmentGridData", installmentPlanList);

					responseObject.putAll(appendDropdown(customerId, isActive, paymentType));
				}else {
					billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
					if(Objects.isNull(orderhdrId) && Objects.isNull(orderItemSeq)) {
						billingDetailsList.get(0).replace("notice_date", null);
						billingDetailsList.get(0).replace("send_notice", null);
						billingDetailsList.get(0).replace("pull_day", null);
						billingDetailsList.get(0).replace("pull_pay_start_for_cc", null);
						billingDetailsList.get(0).replace("core_reference", null);
						billingDetailsList.get(0).replace("mandate_date", null);
				}
					billingDetailsList.get(0).replace("type",0);
					responseObject.put("billingDetails", billingDetailsList);
					responseObject.putAll(appendDropdown(customerId, isActive, paymentType));
				}
				break;
			case "type":
				// it requires orderCodeId,orderHdrId, ordItemSeq,installmentIdNew
				int disallowInstallment = customerOrderService.getDisallowInstallment(Integer.valueOf(orderCodeId));
				int installmentOnly = customerOrderService.getInstallmentOnly(Integer.valueOf(orderCodeId));
				IntPredicate p = i -> type == 0 && (disallowInstallment == 0 && installmentOnly == 0);
				int count = 0;
				if (p.test(type)) {
					responseObject.putAll(appendResponse(responseObject,installmentPlanList));
					count++;
				}
				IntPredicate p1 = i -> type == 0 && disallowInstallment == 1;
				if (p1.test(type) && count == 0) {
					responseObject.putAll(appendResponse(responseObject,installmentPlanList));
					count++;
				}
				IntPredicate p2 = i -> type == 0 && installmentOnly == 1;
				if (p2.test(type) && count == 0) {
					responseObject.put("msg","The order code for this order is set to 'Installment Billing Only'. Cannot change the billing type from 'Installment Billing'.");
					responseObject.putAll(appendResponse(responseObject,installmentPlanList));
					count++;
				}
				IntPredicate p3 = i -> type == 1 && (disallowInstallment == 0 && installmentOnly == 0);
				if (p3.test(type) && count == 0) {
					// String msg = "Installment billing has been disallowed by the order code,
					// order class or term.";
					responseObject.putAll(appendResponse(responseObject,installmentPlanList));
					count++;
				}
				IntPredicate p4 = i -> type == 1 && (disallowInstallment == 1 && installmentOnly == 0);
				if (p4.test(type) && count == 0) {
					msg = "Installment billing has been disallowed by the order code, order class or term.";
					if (responseObject.isEmpty())
						responseObject.put("msg", msg);
					responseObject.putAll(appendResponse(responseObject,installmentPlanList));
					count++;
				}
				IntPredicate p5 = i -> type == 0 && (disallowInstallment == 0 && installmentOnly == 1);
				if (p5.test(type) && count == 0) {
					msg = "The order code for this order is set to 'Installment Billing Only'. Cannot change the billing tyep from 'Installment Billing'.";
					if (responseObject.isEmpty())
						responseObject.put("msg", msg);
					responseObject.putAll(appendResponse(responseObject,installmentPlanList));
					count++;
				}
				IntPredicate p6 = i -> type == 1 && (disallowInstallment == 0 && installmentOnly == 1);
				if (p6.test(type) && count == 0) {
					responseObject.putAll(appendResponse(responseObject,installmentPlanList));
					count++;
				}
				responseObject.put(STATUS, SUCCESS);
				break;
			case "selectPlan":
				if (orderItemSeq != null && orderhdrId != null) {
					if(installmentIdNew != null) {
					// installmentIdNew is from installmentGridData
					responseObject.put("installmentPlan",customerOrderService.getInstallmentPlanType(installmentIdNew));
					}
					billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
					if(installmentIdNew != null) {
					billingDetailsList.get(0).replace("installment_plan", responseObject.get("installmentPlan"));
					}
					billingDetailsList.get(0).replace("bank_sort_code", null);
					billingDetailsList.get(0).replace("auddis_transaction_code", null);
					billingDetailsList.get(0).replace("bacs_transaction_code", null);
					clearPullRelatedKey(billingDetailsList);
					setBillingType(billingDetailsList);
					responseObject.put("billingDetails", billingDetailsList);
					if(installmentIdNew != null) {
					installmentPlanList = customerOrderService.getCalculatedOrderItemInstallmentAmount(orderhdrId, orderItemSeq, installmentIdNew, customerId, subscriptionId, sourceCodeId, state, currency, orderCodeId, orderCodeType);
					responseObject.put("installmentGridData", installmentPlanList);
					}else {
						responseObject.put("installmentGridData", installmentPlanList);
					}
					
					responseObject.putAll(appendDropdown(customerId, isActive, paymentType));
				}else {
					if(installmentIdNew != null) {
						// installmentIdNew is from installmentGridData
						responseObject.put("installmentPlan",customerOrderService.getInstallmentPlanType(installmentIdNew));
						}
						billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
						if(installmentIdNew != null) {
						billingDetailsList.get(0).replace("installment_plan", responseObject.get("installmentPlan"));
						setBillingType(billingDetailsList);//1 means installment billing and 0 means balance due
						}
						billingDetailsList.get(0).replace("bank_sort_code", null);
						billingDetailsList.get(0).replace("auddis_transaction_code", null);
						billingDetailsList.get(0).replace("bacs_transaction_code", null);
						clearPullRelatedKey(billingDetailsList);
						setBillingType(billingDetailsList);
						responseObject.put("billingDetails", billingDetailsList);
						if(installmentIdNew != null) {
						installmentPlanList = customerOrderService.getCalculatedOrderItemInstallmentAmount(orderhdrId, orderItemSeq, installmentIdNew, customerId, subscriptionId, sourceCodeId, state, currency, orderCodeId, orderCodeType);
						responseObject.put("installmentGridData", installmentPlanList);
						}else {
							responseObject.put("installmentGridData", installmentPlanList);
						}
						
						responseObject.putAll(appendDropdown(customerId, isActive, paymentType));
				}

				break;
			case "credit":
				install_auto_payment = 1;
				isActive = 1;
				paymentType = "CC";
				if (accountPaymentSeq != null && idNbrLastFour != null) {
					//Integer pullPaymentDay = configTableDetails.get(0).get("pull_payment_days")!=null?Integer.parseInt(configTableDetails.get(0).get("pull_payment_days").toString()):null;
					List<Map<String, Object>> pullPaymentDetails = customerOrderService.getPullDayData(pullPaymentDay,install_auto_payment);
					billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
					replaceCreditPullKey(billingDetailsList,pullPaymentDetails,pull_pay_start_for_cc);
					
					setBillingType(billingDetailsList);
					billingDetailsList.get(0).replace("install_auto_payment", install_auto_payment);
					responseObject.put("billingDetails", billingDetailsList);
					cardData = customerOrderService.getCreditCardDetails(accountPaymentSeq, idNbrLastFour);
					responseObject.put("creditCardDetails", cardData);

					if((pull_pay_start_for_cc !=0 || pull_pay_start_for_cc ==0) && pullPaymentDay ==null) {
						responseObject.put("ApplicationError", msg);
					}
					responseObject.putAll(appendDropdown(customerId, isActive, paymentType));
					responseObject.remove("debitCard");
				}else {
					List<Map<String, Object>> pullPaymentDetails = customerOrderService.getPullDayData(pullPaymentDay,install_auto_payment);

					paymentDropdown = customerOrderService.getPaymentDropdwonList(customerId, isActive, paymentType);
					accountPaymentSeq2 = 0;
					idNbrLastFour2 = 0;
					billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
					if (paymentDropdown.size() != 0) {
						accountPaymentSeq2 = Integer.valueOf(paymentDropdown.get(0).getKey());
						idNbrLastFour2 = Integer.valueOf(paymentDropdown.get(0).getExtra());
						creditCardDetails = customerOrderService.getCreditCardDetails(accountPaymentSeq2,idNbrLastFour2);
						responseObject.put("creditCardDetails", creditCardDetails);
						//if((pull_pay_start_for_cc !=0 || pull_pay_start_for_cc ==0) && pullPaymentDay ==null) {
						if(pull_pay_start_for_cc !=0 && pullPaymentDay == null) {
							responseObject.put("ApplicationError", msg);
						}
					} else {
						msg = "This Customer doesn't have a Credit Card account on Record. Do you wish to create one?";
						responseObject.put("creditCardDetails", msg);
					}
					
					replaceCreditPullKey(billingDetailsList,pullPaymentDetails,pull_pay_start_for_cc);
					setBillingType(billingDetailsList);
					billingDetailsList.get(0).replace("install_auto_payment", install_auto_payment);
					responseObject.put("billingDetails", billingDetailsList);

					responseObject.put("billingType", customerOrderService.getBillingTypeList());
					responseObject.put("selectPlan", customerOrderService.getInstallmentPlan());
					paymentDropdown = customerOrderService.getPaymentDropdwonList(customerId, isActive, paymentType);
					responseObject.put("creditCard", paymentDropdown);
					
				}
				break;
			case "debit":
				install_auto_payment = 2;
				isActive = 1;
				paymentType = "DD";
				if (accountPaymentSeq != null) {
					List<Map<String, Object>> pullPaymentDetails = customerOrderService.getPullDayData(pullPaymentDay,install_auto_payment);
					billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
					cardData = customerOrderService.getDebitCardDetails(orderhdrId, customerId, accountPaymentSeq);
					responseObject.put("debitCardDetails", cardData);
					replaceDebitPullKey(billingDetailsList,pullPaymentDetails);
					setBillingType(billingDetailsList);
					responseObject.put("billingDetails", billingDetailsList);
					responseObject.putAll(appendDropdown(customerId, isActive, paymentType));
					responseObject.remove("creditCard");
				} else {
					paymentDropdown = customerOrderService.getPaymentDropdwonList(customerId, isActive, paymentType);
					//List<Map<String, Object>> pullPaymentDetails = customerOrderService.getPullDayData(pullPaymentDay,install_auto_payment);
					billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
					accountPaymentSeq = 0;
					if (paymentDropdown.size() != 0) {
						cardData = customerOrderService.getDebitCardDetails(orderhdrId, customerId, accountPaymentSeq);
						responseObject.put("debitCardDetails", cardData);
						//check pullDay is null or not
						if((pull_pay_start_for_cc !=0 || pull_pay_start_for_cc ==0) && pullPaymentDay ==null) {
							responseObject.put("ApplicationError", msg);
						}
					} else {
						msg = "This Customer doesn't have a Direct Debit account on Record. Do you wish to create one?";
						responseObject.put("debitCardDetails", msg);
					}
					if(cardData.size() != 0) {
						replaceDebitPullKey(billingDetailsList,cardData);
					}
					setBillingType(billingDetailsList);
					responseObject.put("billingDetails", billingDetailsList);
					responseObject.put("billingType", customerOrderService.getBillingTypeList());
					responseObject.put("selectPlan", customerOrderService.getInstallmentPlan());

					responseObject.put("debitCard", paymentDropdown);
					responseObject.put(STATUS, SUCCESS);
				}
				break;
			case "pull":// custom pull day, autoPayment 1 is credit card and 2 is debit card
				if (pullDay != null && autoPayment != null) {

					cardData = customerOrderService.getPullDayData(pullDay, autoPayment);
					// responseObject.put("pullDayData", cardData);

					billingDetailsList = customerOrderService.getDefaultOrderItemInstallmentDetails(orderhdrId,orderItemSeq);
					// replace previous pullDay, paymentStartDate, paymentTerminateDate,
					// paymentMostRecentDate, paymentNextDate from cardData List
					billingDetailsList.get(0).replace("pull_day", cardData.get(0).get("pull_payment_days"));
					billingDetailsList.get(0).replace("payment_start_date",
							cardData.get(0).get("payment_start_interval"));
					billingDetailsList.get(0).replace("payment_end_date", cardData.get(0).get("payment_end_date"));
					billingDetailsList.get(0).replace("most_recent_payment_date",
							cardData.get(0).get("most_recent_payment_date"));
					billingDetailsList.get(0).replace("next_payment_date",
							cardData.get(0).get("next_payment_interval"));
					setBillingType(billingDetailsList);
					responseObject.put("billingDetails", billingDetailsList);

					responseObject.putAll(appendDropdown(customerId, isActive, paymentType));
				}
				break;
			}
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	private Map<? extends String, ? extends Object> appendResponse(Map<String, Object> responseObject,List<Map<String, Object>> installmentPlanList) {
		responseObject.put("billingDetails", installmentPlanList);
		responseObject.put("installmentGridData", installmentPlanList);
		responseObject.put("billingType", customerOrderService.getBillingTypeList());
		responseObject.put("selectPlan", customerOrderService.getInstallmentPlan());
		return responseObject;
	}
	private void replaceCreditPullKey(List<Map<String, Object>> billingDetailsList,List<Map<String, Object>> pullPaymentDetails, Integer pull_pay_start_for_cc) {
		billingDetailsList.get(0).replace("bank_sort_code", null);
		billingDetailsList.get(0).replace("auddis_transaction_code", null);
		billingDetailsList.get(0).replace("bacs_transaction_code", null);
		billingDetailsList.get(0).replace("pull_day", pull_pay_start_for_cc!=0?pullPaymentDetails.get(0).get("pull_payment_days"):null);
		billingDetailsList.get(0).replace("payment_start_date", pull_pay_start_for_cc!=0?pullPaymentDetails.get(0).get("payment_start_date"):null);
		billingDetailsList.get(0).replace("payment_end_date", pull_pay_start_for_cc!=0?pullPaymentDetails.get(0).get("payment_end_date"):null);
		billingDetailsList.get(0).replace("most_recent_payment_date", pull_pay_start_for_cc!=0?pullPaymentDetails.get(0).get("most_recent_payment_date"):null);
		billingDetailsList.get(0).replace("next_payment_date", pull_pay_start_for_cc!=0?pullPaymentDetails.get(0).get("next_payment_date"):null);
		
		
	}
	private void replaceDebitPullKey(List<Map<String, Object>> billingDetailsList,List<Map<String, Object>> pullPaymentDetails) {
		billingDetailsList.get(0).replace("pull_day", pullPaymentDetails.get(0).get("pull_payment_days"));
		billingDetailsList.get(0).replace("payment_start_date", pullPaymentDetails.get(0).get("payment_start_date"));
		billingDetailsList.get(0).replace("payment_end_date", pullPaymentDetails.get(0).get("payment_end_date"));
		billingDetailsList.get(0).replace("most_recent_payment_date", pullPaymentDetails.get(0).get("most_recent_payment_date"));
		billingDetailsList.get(0).replace("next_payment_date", pullPaymentDetails.get(0).get("next_payment_date"));
		
	}
	private void setBillingType(List<Map<String, Object>> billingDetailsList) {
		billingDetailsList.get(0).replace("type",1);
		
	}
	private void clearPullRelatedKey(List<Map<String, Object>> billingDetailsList) {
		billingDetailsList.get(0).replace("pull_day",null);
		billingDetailsList.get(0).replace("pull_pay_start_for_cc",null);
		billingDetailsList.get(0).replace("payment_start_date",null);
		billingDetailsList.get(0).replace("payment_end_date",null);
		billingDetailsList.get(0).replace("most_recent_payment_date",null);
		billingDetailsList.get(0).replace("next_payment_date",null);
	}
	private Map<? extends String, ? extends Object> appendDropdown(Integer customerId, Integer isActive, String paymentType) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		List<DropdownModel> paymentDropdown = new ArrayList<>();
		try {
			responseObject.put("billingType", customerOrderService.getBillingTypeList());
			responseObject.put("selectPlan", customerOrderService.getInstallmentPlan());
			responseObject.put("autoPayment", customerOrderService.getAutoPaymentList());
			isActive = 1;
			paymentType = "CC";
			paymentDropdown = customerOrderService.getPaymentDropdwonList(customerId, isActive, paymentType);
			responseObject.put("creditCard", paymentDropdown);
			paymentType = "DD";
			paymentDropdown = customerOrderService.getPaymentDropdwonList(customerId, isActive, paymentType);
			responseObject.put("debitCard", paymentDropdown);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
		return responseObject;
	}
	@PostMapping("/saveBillingOption")
	public Map<String, Object> saveBillingOption(OrderItem billingOption) {
		Map<String, Object> responseObject = new HashMap<String, Object>();
		try {
			// Integer installmentPlanId = billingOption.getInstallmentPlanId();
			customerOrderService.saveBillingOptions(billingOption);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}

	@RequestMapping(value = "/useUnit", method = RequestMethod.POST)
	public Map<String, Object> useUnitDisp(long orderHdrId, int orderItemSeq) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			String useUnitData = customerOrderService.getUseUnitValue(orderHdrId, orderItemSeq);
			responseObject.put("useUnitData", useUnitData);
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
		return responseObject;
	}

	@RequestMapping(value = "/unitChangeSave", method = RequestMethod.POST)
	public Map<String, Object> unitChangeSave(OrderItem orderItem) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			boolean unitSaveStatus = customerOrderService.getUnitSave(orderItem);
			responseObject.put("unitSaveStatus", unitSaveStatus);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}

	}

	// Date based Subscription (time period with issue)
	@RequestMapping(value = "/noOfCopyChangeDateBased", method = RequestMethod.POST)
	public Map<String, Object> noOfCopyChangeTimeWithPeriod(int oldNoOfCopy, int newNoOfCopy, long orderhdrId,
			int orderItemSeq, String orderClass, String orderCode, int orderLineNumber, float orderPrice,
			float fromNoOfDays) {
		Map<String, Object> responseObject = null;
		responseObject = new LinkedHashMap<>();
		try {
			Map<String, Object> getOptionData = customerOrderService.getOptionData(oldNoOfCopy, newNoOfCopy, orderhdrId,
					orderItemSeq, orderClass, orderCode, orderLineNumber, orderPrice, fromNoOfDays);
			responseObject.put("OptionData", getOptionData);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	// save Date based Subscription (time period with issue)
	@RequestMapping(value = "/SaveNoOfCopyChangeDateBased", method = RequestMethod.POST)
	public Map<String, Object> saveNoOfCopyChangeOption(float price, int numberOfCopy, int option) {
		Map<String, Object> responseObject = null;
		responseObject = new LinkedHashMap<>();
		try {
			Map<String, Object> statusOptionclick = customerOrderService.saveNoOfCopyChange(price, numberOfCopy,
					option);
			responseObject.put("statusOptionclick", statusOptionclick);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(e + ERROR);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

	/*
	 * For this api we need generic promotion code from setup module's Generic
	 * Promotion Details window
	 */
	@PostMapping(value = "/addGenericPromoOrder")
	public Map<String, Object> addGenericPromoCodeOrderItem(String promoCode) {
		Map<String, Object> responseObject = new HashMap<>();
		List<Map<String, Object>> genericPromoDetails = new ArrayList<>();
		try {
			String message = promoCode.isEmpty() ? "'' is not a valid promotion code."
					: "'" + promoCode + "' is not a valid promotion code.";
			genericPromoDetails = customerOrderService.getGenericPromoCodeDetails(promoCode);
			Predicate<String> checkNullOrBlanck = i -> !(promoCode.equals("") | promoCode.equalsIgnoreCase("null"));
			if (checkNullOrBlanck.test(promoCode) && genericPromoDetails.size()!=0) {
				Date futureDate=customerOrderService.getPromoFutureDate(promoCode);
				Date todate = new Date();
				 if( futureDate!=null)
				 {			
				   if( futureDate.before(todate)) {
				      Integer sourceCodeId=customerOrderService.getSourceCodeId(promoCode);
					     Integer promoStatus=customerOrderService.getPromoStatus(promoCode);
					        if  (promoStatus != 0) {
							responseObject.put("this promo source code id is active", promoStatus);
							
							if  (genericPromoDetails.size() != 0) {
								responseObject.put("genericPromoDetails", genericPromoDetails);
							} else {
								responseObject.put("msg",message);
							}
						} 
					        else {
							responseObject.put("msg","invalid:order_item.source_code_id:"+sourceCodeId+" is inactive source code");
						}
				   }
				      else {
				        	responseObject.put("msg","Attempt to use generic promotion's source code before its start date");
				      }
				   }
				 else
				        {
					 Integer sourceCodeId=customerOrderService.getSourceCodeId(promoCode);
				     Integer promoStatus=customerOrderService.getPromoStatus(promoCode);
				        if  (promoStatus != 0) {
						responseObject.put("this promo source code id is active", promoStatus);
						
						if  (genericPromoDetails.size() != 0) {
							responseObject.put("genericPromoDetails", genericPromoDetails);
						} else {
							responseObject.put("msg",message);
						}
					} 
				        else {
				        responseObject.put("msg",message);
						responseObject.put("invalid:order_item.source_code_id:"+sourceCodeId+" is inactive source code",promoStatus);
					}
				} 
			 }
			
			else {
				responseObject.put("msg", message);
				
			}
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(e + ERROR);
			responseObject.put(STATUS, ERROR);
			return responseObject;
		}
	}

 	 		/**Added By Sohrab for Review Adds and Kills on 17-sep-2019*/
 	 		@RequestMapping(path="/listsOfReviewAddsKills", method=RequestMethod.POST)
 	 		public  Map<String, Object> getReviewAddsKillsForOrder(int customer_id,int subscrip_id) 
 	 		{	
 	 			Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
 	 			try 
 	 			{
 		 			List<ReviewAddsKillsModel> verifiedAddsKillsList=customerOrderService.getVerifiedAddsKills(customer_id,subscrip_id);
 	 				List<ReviewAddsKillsModel> nonVerifiedAddsKillsList=customerOrderService.getNonVerifiedAddsKills(customer_id,subscrip_id);
 	 				List<ProposedAddsKillsModel> proposedAddsKillsList=customerOrderService.getProposedAddsKills(subscrip_id);
 	 				responseObject.put("verifiedAddsKillsList", verifiedAddsKillsList);
 	 				responseObject.put("nonVerifiedAddsKillsList", nonVerifiedAddsKillsList);
 	 				responseObject.put("proposedAddsKillsList", proposedAddsKillsList);
 		 			responseObject.put(STATUS,SUCCESS);
 		 			return responseObject;
 	 			}catch(Exception e)
 	 			{
 		 			LOGGER.error(ERROR +e);
 		 			responseObject.put(STATUS,ERROR+e);
 		 			e.printStackTrace();
 		 			return responseObject;
 	 			}
 	 		}
 	 		
 	 		
 	 		/**Added By Sohrab for Review Ons and Offs on 18-sep-2019*/
 	 		@RequestMapping(path="/listsOfReviewOnsOffs", method=RequestMethod.POST)
 	 		public  Map<String, Object> getReviewOnsOffsForOrder(int customer_id,int subscrip_id) 
 	 		{	
 	 			Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
 	 			try 
 	 			{
 		 			List<ReviewOnsOffsModel> onsOffsList=customerOrderService.getReviewOnsOffs(customer_id,subscrip_id);
 	 				responseObject.put("onsOffsList", onsOffsList);
 		 			responseObject.put(STATUS,SUCCESS);
 		 			return responseObject;
 	 			}catch(Exception e)
 	 			{
 		 			LOGGER.error(ERROR +e);
 		 			responseObject.put(STATUS,ERROR+e);
 		 			e.printStackTrace();
 		 			return responseObject;
 	 			}
 	 		}

 	 		@PostMapping("/addShipOrder")
 	 		public Map<String, Object> getShippingOrderPercentage(Integer orderhdrId, Integer orderItemType,String shippingPrice, Integer orderCodeId, Integer customerId) {
 	 			Map<String, Object> responseObject = new HashMap<String, Object>();
 	 			List<Map<String, Object>> shippingPercentList = null;
 	 			List<Map<String, Object>> shippingOrderList = null;
 	 			String message = null;
 	 			Set<String> addressList = new HashSet<>();
 	 			Set<String> shipping_PriceList = new HashSet<>();
 	 			boolean businessLogicExceptionDetected = false;
 	 			Float netBaseAmount = null;
 	 			Float finalNetBaseAmount = null;
 	 			Integer orderSeqQty = null;
 	 			int count = 0;
 	 			Short chargeShipping = null;
 	 			try {
 	 				if (orderhdrId != null && !shippingPrice.isEmpty()) {
 	 					if (orderItemType == null)
 	 						orderItemType = 0;
 	 					shippingPercentList = customerOrderService.shippingOrderPercentList();
 	 					shippingOrderList = customerOrderService.getShippingOrderList(orderhdrId);
 	 					orderSeqQty = customerOrderService.getOrderItemSeq(orderhdrId);
 	 					chargeShipping = (Short) shippingOrderList.get(0).get("charge_shipping");
 	 					// to store duplicate address and shipping price into a list
 	 					for (Map<String, Object> row : shippingOrderList) {

 	 						BigDecimal netBaseAmout_ = (BigDecimal) row.get("net_base_amount");
 	 						netBaseAmount = netBaseAmout_.floatValue();
 	 						// get orderItemSequence then apply orderItemSequence * net base amount formula
 	 						// to calculate shipping charge
 	 						if (netBaseAmount > 0 && count == 0) {
 	 							finalNetBaseAmount = netBaseAmount * orderSeqQty;
 	 							count++;// to skip if block
 	 						}

 	 						if (row.get("shipping_price_list") != null) {
 	 							shipping_PriceList.add(row.get("shipping_price_list").toString());
 	 						} else if (row.get("address1") != null) {
 	 							addressList.add(row.get("address1").toString());
 	 						}
 	 					}

 	 					// to compare similar address and price list that is already applied for this
 	 					// if address duplicate but order has already been applied shipping order
 	 					if ((shipping_PriceList.size() != 0 && addressList.size() == 1) && orderItemType != 8) { 
 	 						// if order is already applied for shipping order then it will show this message
 	 						message = "Business Logic Exception Detected:cfff01bc: This order already has shipping order item. You cannot add a second shipping order item.";
 	 						businessLogicExceptionDetected = true;
 	 						responseObject.put("message", message);
 	 					} else if (addressList.size() > 1 && orderItemType != 8) {// if duplicate address is available for this order
 	 						message = "Business logic exception detected: cfff01bf: This order has shipping.  All items in the order need the same shipping address.";
 	 						businessLogicExceptionDetected = true;
 	 						responseObject.put("message", message);
 	 					}

 	 					if ((shippingPercentList.size() > 0 && shippingOrderList.size() > 0)
 	 							&& (!businessLogicExceptionDetected)) {
 	 						long taxRateAmount = customerOrderService.getTaxRate(customerId, orderCodeId);
 	 						for (Map<String, Object> row : shippingPercentList) {
 	 							String shippingPrice_ = row.get("shipping_price_list").toString();

 	 							Integer toQty = (Integer) row.get("to_qty");
 	 							BigDecimal toAmount_ = (BigDecimal) row.get("to_amt");
 	 							BigDecimal shippingCharge = (BigDecimal) row.get("shipping_charge");
 	 							BigDecimal finalPercent = (BigDecimal) row.get("shipping_percent");
 	 							// to calculate amount according to shipping percentage
 	 							if ((finalPercent != null && shippingPrice_.equals(shippingPrice))
 	 									&& (finalNetBaseAmount <= toAmount_.floatValue())) {
 	 								if (chargeShipping != 0) {
 	 									Float multipliedAmount = finalNetBaseAmount.floatValue() * finalPercent.floatValue();
 	 									Float chargeAmount = multipliedAmount / 100;
 	 									responseObject.put("chargeAmount", chargeAmount);
 	 									responseObject.put("taxRateAmount", taxRateAmount);
 	 								} else {
 	 									responseObject.put("chargeAmount", 0);
 	 									responseObject.put("taxRateAmount", taxRateAmount);
 	 								}
 	 								responseObject.put("message", false);
 	 								break;
 	 								// to calculate amount according to shipping charge
 	 							}
 	 							if ((shippingCharge != null && shippingPrice_.equals(shippingPrice))
 	 									&& (orderSeqQty <= toQty)) {
 	 								if (chargeShipping != 0) {
 	 									responseObject.put("chargeAmount", shippingCharge);
 	 									responseObject.put("taxRateAmount", taxRateAmount);
 	 								} else {
 	 									responseObject.put("chargeAmount", 0);
 	 									responseObject.put("taxRateAmount", taxRateAmount);
 	 								}
 	 								responseObject.put("message", false);
 	 								break;
 	 							}
 	 						}
 	 					}

 	 				}
 	 				responseObject.put(STATUS, SUCCESS);
 	 				return responseObject;
 	 			} catch (Exception e) {
 	 				LOGGER.error(ERROR + e);
 	 				responseObject.put(STATUS, ERROR + e);
 	 				e.printStackTrace();
 	 				return responseObject;
 	 			}
 	 		}

	@PostMapping("/inactivateDD")
	public Map<String, Object> inactiveDirectDebitAccount(Integer orderhdrId, Integer orderItemSeq) {
		Map<String, Object> responseObject = new HashMap<String, Object>();
		try {
			Predicate<Integer> p1 = p -> orderhdrId != null;
			Predicate<Integer> p2 = p -> orderItemSeq != null;
			if (p1.test(orderhdrId) & p2.test(orderItemSeq)) {
				customerOrderService.cancelDirectDebit(orderhdrId, orderItemSeq);
				responseObject.put(STATUS, SUCCESS);
			} else {
				throw new NullPointerException("orderhdrId:" + orderhdrId + ", orderItemSeq:" + orderItemSeq);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			e.printStackTrace();
			return responseObject;
		}
	}
	

	@RequestMapping(path = "/shipOrderPriceList", method = RequestMethod.POST)
	public Map<String, Object> getshipOrderPriceList() {
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {
			List<DropdownModel> shippingPriceList = customerOrderService.getShippingMethod();
			responseObject.put("shippingPriceList", shippingPriceList);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}

	}
	
	@PostMapping("/pkgEditOrderAddTime")
	public Map<String, Object> customerOdrPkgEdit(String orderCodeId, String sourceCodeId, int orderCodeType,String productId,
		     int customerId, String subscriptionIdList, String agencyID, Optional<Integer> orderhdrId,Optional<String> shippingPrice,Integer pkgDefId){
		Map<String, Object> customerOrderEdit = new HashMap<String, Object>();
		try {
			OrderItem orderItems = customerOrderService.customerOrderPkgEdit(customerId,orderCodeId,sourceCodeId,orderCodeType,productId,agencyID);
			List<DropdownModel> orderCategory = customerOrderService.getOrderCategory();
			List<DropdownModel> orderStatus = customerOrderService.getOrderStatus();
			List<DropdownModel> paymentStatus = customerOrderService.getpaymentStatus();
			List<DropdownModel> currencyDropDown = customerOrderService.getCurrencyDropdown();
			List<DropdownModel> pkgDef = customerOrderService.getPkgDef(orderCodeId);
			List<Map<String,Object>> pkgMember = customerOrderService.getPkgMember(orderCodeId,sourceCodeId,orderCodeType,
			customerId,subscriptionIdList,agencyID,orderhdrId,shippingPrice,pkgDefId);
			List<CustomerAuxiliaryModel> auxiliaryFormField = customerOrderService.getCustomerAuxiliaryFormField();
			customerOrderEdit.put("auxiliaryformfeild", auxiliaryFormField);
			customerOrderEdit.put("orderCategory", orderCategory);
			customerOrderEdit.put("orderStatus", orderStatus);
			customerOrderEdit.put("paymentStatus", paymentStatus);
			customerOrderEdit.put("OrderItem", orderItems);
			customerOrderEdit.put("currencyDropDown", currencyDropDown);
			customerOrderEdit.put("pkgMember", pkgMember);
			customerOrderEdit.put("pkgDef", pkgDef);
			customerOrderEdit.put(STATUS, SUCCESS);	
			return customerOrderEdit;	
		}catch(Exception e) {
			LOGGER.error(ERROR + e);
			customerOrderEdit.put(STATUS, ERROR + e);
			e.printStackTrace();
			return customerOrderEdit;
		}
	}	
	@RequestMapping(path="/getPoolMember",method=RequestMethod.POST)
	public Map<String,Object> selectPoolMember(int orderCodeId) {
		Map<String,Object> responseObject=new LinkedHashMap<>();
		try {
			List<Map<String,Object>> poolMemberDetails=customerOrderService.getPoolMemeberDetails(orderCodeId);
			responseObject.put("poolMemberDetails",poolMemberDetails);
			responseObject.put(STATUS, SUCCESS);
			return responseObject;
		}catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	@RequestMapping(path = "/orderDemographicDetails", method = RequestMethod.POST)
	public Map<String, Object> getDemoDetails(int customerId,int ocId) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		System.out.println("order demo");
		try {
		     responseObject.put("DemographicFormDetails",orderFunctionalityService.getDemographicForm1(ocId));
			 responseObject.put("orderDemoDetails", orderFunctionalityService.getDemoDetails(customerId));
		   
            
		    responseObject.put(STATUS, SUCCESS);
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in getorderDemographicDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/saveOrderDemographicDetails", method = RequestMethod.POST)
	public Map<String, Object> saveOrderDemographicDetails(DemographicsModel  demographicsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status= 0;
		try {

			status = orderFunctionalityService.saveDemoDetails(demographicsModel);
			if (status!=0) {
				responseObject.put(STATUS, true);
			} else {
				responseObject.put(STATUS, false);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("Error in saveOrderDemoDetails() : " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
	@RequestMapping(path = "/updateOrderDemographicDetails", method = RequestMethod.POST)
    public Map<String, Object> updateOrderDemographicDetails(DemographicsModel  demographicsModel) {
		
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		try {

			int status = orderFunctionalityService.updateDemoDetails(demographicsModel);

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
	
	
	@RequestMapping(path = "/deleteOrderDemographicDetails", method = RequestMethod.POST)
	public Map<String, Object>   deleteOrderDemographicDetails(DemographicsModel demographicsModel) {
		Map<String, Object> responseObject = new LinkedHashMap<>();
		int status = 0;
		try {
			status =  orderFunctionalityService.deleteDemoDetails(demographicsModel);
			if (status == 0) {
				responseObject.put(STATUS, false);
			} else {
				responseObject.put(STATUS, true);
			}
			return responseObject;
		} catch (Exception e) {
			LOGGER.info("error in deleteDemoDetails: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
		}
	}
	
   @PostMapping("/packageCurrencyConversion")
   public Map<String,Object> currencyChange(String currency,float amount) {
	   Map<String,Object> responseObject = new LinkedHashMap<>();
	   float baseAmount = 0;
	   try {
		   baseAmount = customerOrderService.covertedAmountByCurrency(amount,currency);   
		   responseObject.put("baseAmount", baseAmount);
			return responseObject;
	   }catch(Exception e) {
		   LOGGER.info("error in currencyChange: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
	   }
		   
	}
   
   @RequestMapping(path = "/renewalCardOffer", method = RequestMethod.POST)
   public Map<String,Object> getRenew(int subscripId) {
	   Map<String,Object> responseObject = new LinkedHashMap<>();
	   int renewOrder = 0;
	   try {
		   renewOrder = customerOrderService.getRenew(subscripId);
		   responseObject.put("renewOrder", renewOrder);
			return responseObject;
	   }catch(Exception e) {
		   LOGGER.info("error in getRenew: " + e);
			responseObject.put(STATUS, ERROR + e);
			return responseObject;
	   }
		   
	}
}