package com.mps.think.controller;

import static com.mps.think.constants.SecurityConstants.ERROR;
import static com.mps.think.constants.SecurityConstants.STATUS;
import static com.mps.think.constants.SecurityConstants.SUCCESS;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.model.CancelOrderAttributeModel;
import com.mps.think.model.CancelOrderDetailsModel;
import com.mps.think.model.ExistingUnpaidOrdersModel;
import com.mps.think.model.RenewableItemsModel;
import com.mps.think.service.CancelOrderService;
import com.mps.think.util.CustomerUtility;

@RestController
public class CancelOrderController 
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderController.class);
	
	@Autowired
	CancelOrderService cancelOrderService; 
	@Autowired
	JdbcTemplate jdbcTemplate;
	@PostConstruct
	public void init() 
	{
		 try 
		 {
			 CustomerUtility customerUtility = new CustomerUtility();
			 customerUtility.runTruncate(jdbcTemplate);
		 } catch (Exception e) 
		 {
			e.printStackTrace();
		 }
	}


	
	@RequestMapping(path = "/cancelOrderDetail", method = RequestMethod.POST)
	public Map<String, Object> cancelOrderDetail(@RequestParam("orderHdrId") Long orderHdrId,@RequestParam("orderItemSeq") int orderItemSeq,@RequestParam("customerId") Long customerId,
			@RequestParam("subscripId") int subscripId) 
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try 
		{
			CancelOrderAttributeModel cancelOrderAttributeModel = new CancelOrderAttributeModel();
			cancelOrderAttributeModel.setCategoryList(cancelOrderService.getcategory());
			cancelOrderAttributeModel.setReasonList(cancelOrderService.getReasonList());
			cancelOrderAttributeModel.setCurrencyTypeList(cancelOrderService.getCurrencyTypeList());
			cancelOrderAttributeModel.setPaymentTypeList(cancelOrderService.getPaymentTypeList());
			cancelOrderAttributeModel.setCancellationRenewalStatusList(cancelOrderService.getCancellationRenewalStatusList());
			//Modified for 610,611,615,1119,1129
			List<CancelOrderDetailsModel> cancelOrderDetailsList=cancelOrderService.getOrderDetail(orderHdrId,orderItemSeq);
			cancelOrderAttributeModel.setOrderDetail(cancelOrderDetailsList);
			cancelOrderAttributeModel.setNoOfSubscripId(cancelOrderService.getNoOfSubscripIdInOrder(subscripId));
			cancelOrderAttributeModel.setPaymentStatus(cancelOrderDetailsList.get(0).isPaymentStatus());
			cancelOrderAttributeModel.setPaymentType(cancelOrderService.getPaymentType(orderHdrId,orderItemSeq));
			cancelOrderAttributeModel.setCategory("REFCANCEL");
			cancelOrderAttributeModel.setCancellationRenewalStatus("notry");
			cancelOrderAttributeModel.setCustomerName(cancelOrderService.getCustomerName(customerId));
			cancelOrderAttributeModel.setCustomerId(customerId+"");
			cancelOrderAttributeModel.setSelectedOrder(cancelOrderService.getSelectedOrder(orderHdrId,orderItemSeq));
			boolean paymentAccountFlag = cancelOrderService.getPaymentAccountFlag(customerId);
			responseObject.put("paymentAccountFlag", paymentAccountFlag);
			if(paymentAccountFlag)
			{	
				cancelOrderAttributeModel.setPaymentAccountList(cancelOrderService.getPaymentAccountList(customerId));
			}
			//Done For THINKDEV-611
			cancelOrderAttributeModel.setPaymentTypeToCancelOrder(cancelOrderService.retrievePaymentTypeToCancelOrder());
			responseObject.put("cancelOrderAttributeModel", cancelOrderAttributeModel);
			responseObject.put(STATUS,SUCCESS);
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			e.printStackTrace();
			responseObject.put(STATUS,ERROR);
		}
		return responseObject;
	}
	
	
	@RequestMapping(path = "/cancelOrder", method = RequestMethod.POST)
	public Map<String, Object> cancelOrderDetailSubmit(CancelOrderAttributeModel cancelOrderAttributeModel) 
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try 
		{
			String cancelStatus = null;
			if(cancelOrderAttributeModel.getCancel_orders_in_entire_sub()!=null && cancelOrderAttributeModel.getCancel_orders_in_entire_sub().equals("1"))
			{
				if(cancelOrderAttributeModel.getPayment_done_flags()!=null && cancelOrderAttributeModel.getPayment_done_flags().contains("1") && cancelOrderAttributeModel.getPayment_done_flags().contains("0"))
				{
					cancelStatus="Businee logic exception detected: The system determined that an amount had been paid against the order item, but found no non-reversed payments for the order item. The integrity of the payments against the order item is suspicious.";
				}else
				{
					cancelStatus = cancelOrderService.cancelOrder(cancelOrderAttributeModel);
				}
			}else
			{
				cancelStatus = cancelOrderService.cancelOrder(cancelOrderAttributeModel);
			}
			if(ERROR.equals(cancelStatus))
			{
				if(cancelOrderAttributeModel.isPaymentStatus())
				{
					if(null!=cancelOrderAttributeModel.getReason()&&!"".equals(cancelOrderAttributeModel.getReason()))
					{
						if(cancelOrderAttributeModel.getReason().equals("NonPmt"))
						{
							responseObject.put("Message","Orders with a payment status of 'Paid' cannot be cancelled for Non-payment.");
						}
					}
				}
				responseObject.put(STATUS, cancelStatus);
			}else if(cancelStatus.contains("Businee logic exception detected"))
			{
				responseObject.put("Message",cancelStatus);
				responseObject.put(STATUS, ERROR);
			}
			else 
			{
				responseObject.put("Message","Order(s) cancelled successfully.");
				responseObject.put(STATUS,SUCCESS);
			}
			return responseObject;
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			e.printStackTrace();
			return responseObject;
		}
	}

	
	@RequestMapping(path = "/getPaymentAccountInfo", method = RequestMethod.POST)
	public Map<String, Object> getPaymentAccountInfo(@RequestParam("paymentAccountSeq") int orderItemSeq,@RequestParam("customerId") Long customerId) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	
	@RequestMapping(path = "/cancelOrderDetailInEntireSub", method = RequestMethod.POST)
	public Map<String, Object> cancelOrderDetailInEntireSub(@RequestParam("subscripId") int subscripId) {

		Map<String, Object> responseObject = new LinkedHashMap<>();
		try {
			CancelOrderAttributeModel cancelOrderAttributeModel = new CancelOrderAttributeModel();

			cancelOrderAttributeModel.setOrderDetail(cancelOrderService.getEntireSubOrderDetail(subscripId));
			
			responseObject.put("cancelOrderAttributeModel", cancelOrderAttributeModel);
			responseObject.put(STATUS,SUCCESS);
			return responseObject;
			
		} catch (Exception e) {
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			return responseObject;
		}
	}
	
	
	/**Added By Sohrab for canceling Order And Items To Be Paid on 10-Oct-2019*/
	@RequestMapping(path = "/cancelingOrderAndItemsToBePaid", method = RequestMethod.POST)
	public Map<String, Object> cancelOrderAndGetItemsToBePaid(CancelOrderAttributeModel cancelOrderAttributeModel) 
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try 
		{
			Map<String, Object> cancelResponseObject =cancelOrderDetailSubmit(cancelOrderAttributeModel);
			Object cancelResponse=cancelResponseObject.get("Message");
			if(null!=cancelResponse)
			{
				if(cancelResponse.equals("Order(s) cancelled successfully."))
				{
					if(cancelOrderAttributeModel.getPayment_done_flags()!=null && !cancelOrderAttributeModel.getPayment_done_flags().contains("1"))
					{
						responseObject.put("Message", "The order has been cancelled, but there is no refund. No payment can be made as part of this Cancel / Pay... transaction.");
						responseObject.put(STATUS, SUCCESS);
					}else
					{
						int customer_Id=0;
						if(cancelOrderAttributeModel.getCustomerId()!=null && cancelOrderAttributeModel.getCustomerId()!="")
						{
							customer_Id=Integer.parseInt(cancelOrderAttributeModel.getCustomerId());
						}
						/*
						 int orderHdr_Id=0;
						 String deposit_amount=null;if(cancelOrderAttributeModel.getOrderHdrId()!=null && cancelOrderAttributeModel.getOrderHdrId()!="")
						{
							String orderHdrId[]=cancelOrderAttributeModel.getOrderHdrId().split(",");
							orderHdr_Id=Integer.parseInt(orderHdrId[0]);
							deposit_amount=cancelOrderService.getDepositAmount(orderHdr_Id);
						}*/
						String balance_due=cancelOrderService.getBalanceDue(customer_Id);
			 			List<ExistingUnpaidOrdersModel> listOfExistingUnpaidOrders=cancelOrderService.getListOfExistingUnpaidOrders(customer_Id,cancelOrderAttributeModel);
			 			if(null!=listOfExistingUnpaidOrders && listOfExistingUnpaidOrders.size()>0)	
			 			{
			 				responseObject.put("Balance due (USD)", balance_due);
							responseObject.put("Deposit amount to apply (USD)", cancelOrderAttributeModel.getRefundAmount());
							responseObject.put("Payable items:", listOfExistingUnpaidOrders);
			 				responseObject.put(STATUS, SUCCESS);
			 			}else
			 			{
							responseObject.put("Message", "The payment part of this compound transaction has not completed successfully. The selected order(s) have been cancelled. If there was a refund, that amount has been added to the deposit account for this customer.");
							responseObject.put(STATUS, SUCCESS);
			 			}
			 		}
				}else if(cancelResponse.equals("Orders with a payment status of 'Paid' cannot be cancelled for Non-payment."))
				{
					responseObject.put("Message", "Orders with a payment status of 'Paid' cannot be cancelled for Non-payment.");
					responseObject.put(STATUS, ERROR);
				}
				else
				{
					responseObject.put(STATUS, cancelResponse);
				}
			}else
			{
				responseObject.put(STATUS, cancelResponse);
			}
			return responseObject;
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			e.printStackTrace();
			return responseObject;
		}
	}
	
	
	/**Added By Sohrab for canceling Order And Renewable Items on 14-Oct-2019*/
	@RequestMapping(path = "/cancelingOrderAndRenewableItems", method = RequestMethod.POST)
	public Map<String, Object> cancelOrderAndGetRenewableItems(CancelOrderAttributeModel cancelOrderAttributeModel) 
	{
		Map<String, Object> responseObject = new LinkedHashMap<>();
		try 
		{
			Map<String, Object> cancelResponseObject =null;
			Object cancelResponse=null;
			if(cancelOrderAttributeModel.getRenew_anyway()!=null && "y".equalsIgnoreCase(cancelOrderAttributeModel.getRenew_anyway()))
			{
					List<RenewableItemsModel> listOfRenewableItems=cancelOrderService.getListOfRenewableItems(cancelOrderAttributeModel);
					if(listOfRenewableItems!=null && listOfRenewableItems.size()>0)
					{
		 				responseObject.put("Renewable items:", listOfRenewableItems);
		 				responseObject.put(STATUS, SUCCESS);
					}else
					{
						responseObject.put("Message 1", "There are no renewable items.");
						responseObject.put("Message 2", "The order renew part of this compound transaction has not completed successfully. The selected order(s) have been cancelled. If there was a refund, that amount has been added to the deposit account for this customer.");
						responseObject.put(STATUS, SUCCESS);
					}
			}else if(cancelOrderAttributeModel.getRenew_anyway()!=null && "n".equalsIgnoreCase(cancelOrderAttributeModel.getRenew_anyway()))
			{
				responseObject.put(STATUS, SUCCESS);
			}	
			else
			{
				cancelResponseObject =cancelOrderDetailSubmit(cancelOrderAttributeModel);
				cancelResponse=cancelResponseObject.get("Message");
				if(cancelResponse.equals("Order(s) cancelled successfully."))
				{
					if(cancelOrderAttributeModel.isPaymentStatus()==false)
					{
						responseObject.put("Message", "The order has been cancelled, but there is no refund. No refund amount can be applied to the Renew part of this transaction. Do you still want to renew an order?");
						responseObject.put(STATUS, SUCCESS);
					}else
					{
						List<RenewableItemsModel> listOfRenewableItems=cancelOrderService.getListOfRenewableItems(cancelOrderAttributeModel);
			 			if(listOfRenewableItems!=null && listOfRenewableItems.size()>0)
						{
			 				responseObject.put("Renewable items:", listOfRenewableItems);
			 				responseObject.put(STATUS, SUCCESS);
						}else
						{
							responseObject.put("Message 1", "There are no renewable items.");
							responseObject.put("Message 2", "The order renew part of this compound transaction has not completed successfully. The selected order(s) have been cancelled. If there was a refund, that amount has been added to the deposit account for this customer.");
							responseObject.put(STATUS, SUCCESS);
						}
					}
				}else if(cancelResponse.equals("Orders with a payment status of 'Paid' cannot be cancelled for Non-payment."))
				{
					responseObject.put("Message", "Orders with a payment status of 'Paid' cannot be cancelled for Non-payment.");
					responseObject.put(STATUS, ERROR);
				}else
				{
					responseObject.put(STATUS, cancelResponse);
				}
			}
			return responseObject;
		} catch (Exception e) 
		{
			LOGGER.error(ERROR + e);
			responseObject.put(STATUS,ERROR);
			e.printStackTrace();
			return responseObject;
		}
	}
	

		/**Added By Sohrab for returns Of Order on 03-Oct-2019*/
		@RequestMapping(path="/returnsOfOrder", method=RequestMethod.POST)
		public  Map<String, Object> returnOrder(CancelOrderAttributeModel cancelOrderAttributeModel) 
		{	
			 LOGGER.info("Inside returnOrder");
			Map<String, Object> responseObject = new LinkedHashMap<String, Object>(); 
			try 
			{
				String returnStatus =null;
				if(cancelOrderAttributeModel.getReturnQty()<=cancelOrderAttributeModel.getShipQty())
				{
					if(cancelOrderAttributeModel.getType_of_return()==0 || cancelOrderAttributeModel.getType_of_return()==2)
					{
						 returnStatus = cancelOrderService.returnProduct(cancelOrderAttributeModel);
						 if(returnStatus=="success")
						 {
							 responseObject.put(STATUS, SUCCESS);
						 }
					}else if(cancelOrderAttributeModel.getType_of_return()==1 || cancelOrderAttributeModel.getType_of_return()==3)
					{
						returnStatus = cancelOrderService.returnProduct(cancelOrderAttributeModel);
						 if(returnStatus=="success")
						 {
							 responseObject.put("Message","Please call cancelOrderDetail API and choose further to cancel or not.");
							 responseObject.put(STATUS, SUCCESS);
						 }
					}
	 			}else
	 			{
	 				responseObject.put("Message","You cannot return more than has been shipped. Please select a number of quantity returned less than or equal to quantity shipped.");
	 				responseObject.put(STATUS, SUCCESS);
	 			}
	 			return responseObject;
			}catch(Exception e)
			{
	 			LOGGER.error(ERROR +e);
	 			responseObject.put(STATUS,ERROR+e);
	 			e.printStackTrace();
	 			return responseObject;
			}
		}
}